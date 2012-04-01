/**
 * Copyright [2008] [PLOIN GmbH -> http://www.ploin.de]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.ploin.web.flow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 105 $<br>
 * $Date: 2010-03-17 15:40:49 +0100 (Wed, 17 Mar 2010) $<br>
 */
public class FlowControl implements Serializable {

	private static final long serialVersionUID = -6940069522385802482L;
	private static Log log = LogFactory.getLog(FlowControl.class);

	public static final String PLOIN_FLOWS = "ploinFlows";
	public static final String PLOIN_PLOIN = "ploinploin";
	public static final String PLOIN_FACES_TIME = "ploinFacesTime";
	public static final String PLOIN_FACES_FROM_VIEW_ID = "ploinFacesFromViewId";
	public static final String PLOIN_FACES_FLOW_PATH = "ploinFacesFlowPath";
	public static final String JSF_PHASE = "jsfPhase";
	public static final String LIFECYCLE_ID = "lifecycleId";


	/**
	 * This method read the "ploinFlows.xml" and build an object-graph.
	 * The object-graph is a List of Flow-Ojbects.
	 *
	 * @see  Flow
	 * @return List<Flow>, object-graph
	 */
	public List<Flow> readFlows(){
		List<Flow> flows = new ArrayList<Flow>();
		try {
			ClassLoader loader = Thread.currentThread ().getContextClassLoader ();
			if (loader == null) loader = ClassLoader.getSystemClassLoader();
			URL url = loader.getResource("ploinFlows.xml");

			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			Element root = document.getRootElement();

			String authSource = null;  // authoritiySource
			String appName = null;     // applicationName
			String acceddDeniedPage = null;
			Boolean disableUrlNavigation = Boolean.FALSE;

			Set<String> viewsForAllFlows = new HashSet<String>();
			Set<String> ignoreFlows = new HashSet<String>();

			for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
				Element flow = (Element) i.next();

				if ("ignoreViews".equalsIgnoreCase(flow.getName())){
					for ( Iterator<Element> e = flow.elementIterator(); e.hasNext(); ) {
					Element view = (Element) e.next();
						if ("view".equalsIgnoreCase(view.getName())){
							ignoreFlows.add(view.getStringValue());
						}
					}
				} else if ("viewsForAllFlows".equalsIgnoreCase(flow.getName())){
					for ( Iterator<Element> e = flow.elementIterator(); e.hasNext(); ) {
					Element view = (Element) e.next();
						if ("view".equalsIgnoreCase(view.getName())){
							viewsForAllFlows.add(view.getStringValue());
						}
					}
				} else if ("disableUrlNavigation".equalsIgnoreCase(flow.getName())){
					try {
						disableUrlNavigation = Boolean.parseBoolean(flow.getStringValue());
					} catch (Exception e) {
						log.error("ERROR by parsing boolean. ", e);
					}
				} else if ("accessDeniedPage".equalsIgnoreCase(flow.getName())){
					acceddDeniedPage = flow.getStringValue();
				} else if ("appName".equalsIgnoreCase(flow.getName())){
					appName = flow.getStringValue();
				} else if ("authoritySource".equalsIgnoreCase(flow.getName())){
					authSource = flow.getStringValue();
				} else if ("flow".equalsIgnoreCase(flow.getName())){
					Flow flowItem = new Flow();
					flowItem.setFlowId(flow.attribute("id").getValue());
					log.debug("read ID: " + flow.attribute("id").getValue());
					for ( Iterator<Element> e = flow.elementIterator(); e.hasNext(); ) {
						Element flowChild = (Element) e.next();
						if ("views".equalsIgnoreCase(flowChild.getName())){
							for ( Iterator<Element> t = flowChild.elementIterator(); t.hasNext(); ) {
								Element view = (Element) t.next();
								if ("view".equalsIgnoreCase(view.getName())){
									flowItem.addView(view.getStringValue());
								}
							}
						} else if ("attributes".equalsIgnoreCase(flowChild.getName())){
							for ( Iterator<Element> t = flowChild.elementIterator(); t.hasNext(); ) {
								Element attribute = (Element) t.next();
								if ("attribute".equalsIgnoreCase(attribute.getName())){
									flowItem.addAttribute(attribute.getStringValue());
								}
							}
						} else if ("includeAuthorities".equalsIgnoreCase(flowChild.getName()) ||
								"includeAuthoritys".equalsIgnoreCase(flowChild.getName())){
							for ( Iterator<Element> t = flowChild.elementIterator(); t.hasNext(); ) {
								Element auth = (Element) t.next();
								if ("authority".equalsIgnoreCase(auth.getName())){
									flowItem.addIncludeAuthority(auth.getStringValue());
								}
							}
						} else if ("excludeAuthorities".equalsIgnoreCase(flowChild.getName()) ||
								"excludeAuthoritys".equalsIgnoreCase(flowChild.getName())){
							for ( Iterator<Element> t = flowChild.elementIterator(); t.hasNext(); ) {
								Element auth = (Element) t.next();
								if ("authority".equalsIgnoreCase(auth.getName())){
									flowItem.addExcludeAuthority(auth.getStringValue());
								}
							}
						} else if ("beforeFlowAction".equalsIgnoreCase(flowChild.getName())){
							flowItem.setBeforeFlowAction(flowChild.getStringValue());
						} else if ("afterFlowAction".equalsIgnoreCase(flowChild.getName())){
						 	flowItem.setAfterFlowAction(flowChild.getStringValue());
						} else if ("beforeLifecycleAction".equalsIgnoreCase(flowChild.getName())){
							flowItem.setBeforeLifecycleAction(flowChild.getStringValue());
						} else if ("afterLifecycleAction".equalsIgnoreCase(flowChild.getName())){
							flowItem.setAfterLifecycleAction(flowChild.getStringValue());
						} else if ("subFlows".equalsIgnoreCase(flowChild.getName())){
							for ( Iterator<Element> t = flowChild.elementIterator(); t.hasNext(); ) {
								Element flowId = (Element) t.next();
								if ("flowId".equalsIgnoreCase(flowId.getName())){
									flowItem.addSubFlow(flowId.getStringValue());
								}
							}
						}
					}
					flowItem.setAuthoritySource(authSource);
					flowItem.setAppName(appName);
					flowItem.setAccessDeniedPage(acceddDeniedPage);
					if (viewsForAllFlows.size() > 0){
						for (String view: viewsForAllFlows){
							flowItem.addView(view);
						}
					}
					flowItem.setIgnoreViews(ignoreFlows);
					flowItem.setDisableUrlNavigation(disableUrlNavigation);
					flows.add(flowItem);
				}
			}
		} catch (Exception e) {
			log.error("ERROR in ploinFlow ", e);
		}
		return flows;
	}


	/**
	 * This methode check if a given "view" is in the given set of viewIds.
	 *
	 * @param set, a set with viewIds (from the ploinFlows.xml)
	 * @param view, the given view (JSF-Lifecycle)
	 * @return true/false
	 */
	public boolean isViewInSet(Set<String> set, String view){
		if (view == null){
			log.debug("isViewInSet() view is null");
			return false;
		}
		if (set == null){
			log.debug("set is null");
			return false;
		}
		if (set.contains(view)){
			return true;
		} else {
			for (String v: set){
				if (v.contains(".*")){
					Pattern pattern = Pattern.compile(v);
					Matcher matcher = pattern.matcher(view);
					if (matcher.find()){
						return true;
					}
				}
			}
		}
		return false;
	}


	public boolean isLeavingFlow(Set<String> set, String fromViewId, String toViewId){
		boolean fromViewIdInFlow = isViewInSet(set, fromViewId);
		boolean toViewIdInFlow = isViewInSet(set, toViewId);
		return fromViewIdInFlow && !toViewIdInFlow;
	}


	public boolean isStayInFlow(Set<String> set, String fromViewId, String toViewId){
		boolean fromViewIdInFlow = isViewInSet(set, fromViewId);
		boolean toViewIdInFlow = isViewInSet(set, toViewId);
		return fromViewIdInFlow && toViewIdInFlow;
	}


	/**
	 * This methode checks if the goToViewId is is a subFlow
	 *
	 * @param flows - all Flows defined in the ploinFlows.xml
	 * @param actualFlow - the actual flow where you are
	 * @param goToViewId - the viewId where to go.
	 * @return true/false
	 */
	public boolean isViewInSubFlows(List<Flow> flows, Flow actualFlow, String goToViewId){
		if (flows == null || flows.size() == 0){
			log.debug(" flows is empty in isViewInSubFlows");
			return false;
		}
		if (actualFlow == null){
			log.debug(" actualFlow is null in isViewInSubFlows");
			return false;
		}
		if (goToViewId == null || "".equals(goToViewId.trim())){
			log.debug(" goToViewId is null in isViewInSubFlows");
			return false;
		}
		if (actualFlow.getSubFlows() == null || actualFlow.getSubFlows().size() == 0){
			return false;
		} else {
			for (Flow flow: flows){
				for (String subflowId: actualFlow.getSubFlows()){
					if (flow.getFlowId().equals(subflowId) && isViewInSet(flow.getViews(), goToViewId)){
						return true;
					}
				}
			}
		}
		return false;
	}


	public boolean isViewInFlowPathPeek(List<Flow> flows, String flowId, String goToViewId){
		if (flows == null || flows.size() == 0){
			log.debug(" flows is empty in isViewInFlowPath");
			return false;
		}
		if (flowId == null){
			log.debug(" flowId is null in isViewInFlowPath");
			return false;
		}
		if (goToViewId == null){
			log.debug(" goToViewId is null in isViewInFlowPath");
			return false;
		}
		for (Flow flow: flows){
			if ( flowId.equals(flow.getFlowId() ) && isViewInSet(flow.getViews(), goToViewId)){
				return true;
			}
		}
		return false;
	}


	public String getFlowIdForViewInFlowPath(List<Flow> flows, Set<String> flowPath, String goToViewId){
		for (Flow flow: flows){
			for (String flowPathId: flowPath){
				if ( flowPathId.equals(flow.getFlowId() ) && isViewInSet(flow.getViews(), goToViewId)){
					return flow.getFlowId();
				}
			}
		}
		return null;
	}


	public boolean isViewInFlowPath(List<Flow> flows, Set<String> flowPath, String goToViewId){
		return getFlowIdForViewInFlowPath(flows, flowPath, goToViewId) != null;
	}


	public Flow getFlowById(String flowId, List<Flow> flows){
		if (flowId == null || "".equals(flowId.trim())){
			log.debug("flowId is null, in getFlowById");
			return null;
		}
		if (flows == null || flows.size() == 0){
			log.debug("flows are empty, in getFlowById");
			return null;
		}
		for (Flow flow: flows){
			if (flow.getFlowId().equals(flowId)) {
				return flow;
			}
		}
		return null;
	}


	public void leaveFlow(List<Flow> flows, String flowId, FacesContext fc, HttpSession session){
		for (Flow flow: flows){
			if (flow.getFlowId().equals(flowId)){
				leaveFlow(flow, fc, session);
				break;
			}
		}
	}


	public void leaveFlow(Flow flow, FacesContext fc, HttpSession session){
		if (flow != null && fc != null && session != null){
			String action = flow.getAfterFlowAction();
			if (action != null){
				log.debug(" execute afterFlowAction " + action);
				fc.getApplication().createValueBinding(action).getValue(fc);
			}
			for (String att: flow.getAttributes()){
				session.removeAttribute(att);
				log.debug("remove from session: " + att + ", because leaving flow with id: " + flow.getFlowId());
			}
		}
	}

}
