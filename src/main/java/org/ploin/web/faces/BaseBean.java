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
package org.ploin.web.faces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ploin.web.flow.Flow;
import org.ploin.web.flow.FlowControl;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * The BaseBean should extend all your ManagedBeans or your own BaseBean.
 * <p/>
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/main/java/org/ploin/web/faces/BaseBean.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 */
public class BaseBean extends BaseMessages implements Serializable {

	private static final long serialVersionUID = 1987654321L;
	private static Log log = LogFactory.getLog(BaseBean.class);
	private Lifecycle lifecycle = null;


	public BaseBean() {}

	/**
	 * This methode returns the HttpServlet Object
	 * 
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = null;
		try {
			request = (HttpServletRequest)getFacesContext().getExternalContext().getRequest();
		} catch (Exception e) {
			log.error("ERROR in getRequest, ", e);
		}
		return request;
	}


	/**
	 * This methode returns the HttpSession object
	 * 
	 * @return HttpSession
	 */
	public static HttpSession getSession(){
		HttpServletRequest request = (HttpServletRequest)getRequest();
		if (request != null){
			HttpSession session = (HttpSession)request.getSession();
			return session;
		} else return null;
	}


	/**
	 * This methode returns the HttpServlet Response
	 *
	 * @return HttpServletResponse
	 */
	public static HttpServletResponse getResponse(){
		HttpServletResponse response = null;
		try {
			response = (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
		} catch (Exception e) {
			log.error("ERROR in getResponse, ", e);
		}
		return response;
	}


	/**
	 * This method rerturns the ApplicationMap, containing some parameters.
	 *
	 * @return
	 */
	public static Map getApplicationMap(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getExternalContext().getApplicationMap();
	}


	/**
	 * This method fetch a value from the ApplicationMap with the given key.
	 *
	 * @param key - the selected key
	 * @return value
	 */
	public static Object getValueFromApplicationMap(Object key){
		return getApplicationMap().get(key);
	}


	/**
	 * Returns the Parameter-Map from the Request. 
	 *
	 * @return Map<String, String> map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getRequestMap() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getExternalContext().getRequestParameterMap();		
	}

	/**
	 * This method looks for a value in the requestMap with the given key,
	 * convert it to Long and return the Long value. If there is no value
	 * for the given key or the convertig process throws an Exception returning null.
	 *
	 * @param key - the key for the requestMap
	 * @return the value converted to Long
	 */
	protected Long getLongFromRequestMap(String key){
		if (key == null || "".equals(key.trim())) return null;
		try {
			String value = getRequestMap().get(key);

			if (value == null || "".equals(value) || "null".equals(value))
				return null;

			return Long.valueOf(value);
		} catch (NumberFormatException e) {
			log.error("ERROR in getLongFromRequestMap, key not found ", e);
			return null;
		}
	}

	/**
	 * This method looks for a value in the requestMap with the given key,
	 * convert it to Integer and return the Integer value. If there is no value
	 * for the given key or the convertig process throws an Exception returning null.
	 *
	 * @param key - the key for the requestMap
	 * @return the value converted to Long
	 */
	protected Integer getIntegerFromRequestMap(String key){
		if (key == null || "".equals(key.trim())) return null;
		try {
			String value = getRequestMap().get(key);

			if (value == null || "".equals(value) || "null".equals(value))
				return null;

			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			log.error("ERROR in getIntegerFromRequestMap, key not found ", e);
			return null;
		}
	}

	/**
	 * This method looks for a value in the requestMap with the given key,
	 * and return the String value. If there is no value
	 * for the given key returning null.
	 *
	 * @param key - the key for the requestMap
	 * @return the value converted to Long
	 */
	protected String getStringFromRequestMap(String key){
		if (key == null || "".equals(key.trim())) return null;
		try {
			String value = getRequestMap().get(key);
			return (String)value;
		} catch (NumberFormatException e) {
			log.error("ERROR in getStringFromRequestMap, key not found ", e);
			return null;
		}
	}


	/**
	 * Returns the current LifecycleInstance of the Application.
	 *
	 * @return the current LifecycleInstance
	 */
	public Lifecycle getCurrentDefaultLifecycleInstance() {
		if (lifecycle != null) {
			return lifecycle;
		} else {
			LifecycleFactory factory = (LifecycleFactory) FactoryFinder
				.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			return factory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		}
	}


	/**
	 * Returns the current PhaseId as Integer.<br/>
	 *
	 * @return 1 ... 6
	 */
	public static Integer getCurrentPhaseId(){
		HttpSession session = getSession();
		if (session != null){
			Integer i = (Integer)session.getAttribute("jsfPhase");
			if (i == null) return 0;
			else return i; 
		} else return 0;
	}


	/**
	 * Return the viewId from where the request is comming.
	 *
	 * @return the viewId from where the request is comming. 
	 */
	public static String getFromViewId(){
		HttpSession session = getSession();
		if (session != null){
			return (String)session.getAttribute("ploinFacesFromViewId");
		} else return null;
	}


	/**
	 * Return the lifecycleId, which is generated by ploinFaces.
	 *
	 * @return the lifecycleId, which is generated by ploinFaces.
	 */
	public static Long getLifecycleId(){
		Long lifecycleId = 1l;
		if (getSession() != null){
			lifecycleId = (Long)getSession().getAttribute("lifecycleId");
			if (lifecycleId == null) lifecycleId = 1l;
		}
		return lifecycleId;
	}

	/**
	 * Set the lifecycle. Just For testing!!
	 * 
	 * @param lifecycle instance
	 */
	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}


	/**
	 * removes all attributes/ManagedBeans containing to the flow
	 * from the session
	 *
	 * @param flowId - the name of a flow
	 * @return true/false
	 */
	public boolean removeFlow(String flowId){
		Object o = getApplicationMap().get("ploinFlows");
		if (o != null && o instanceof List){
			List flows = (List)o;
			FlowControl flowControl = new FlowControl();
			Flow flow = flowControl.getFlowById(flowId, flows);
			flowControl.leaveFlow(flow, getFacesContext(), getSession());
			return true;
		}
		return false;
	}

}
