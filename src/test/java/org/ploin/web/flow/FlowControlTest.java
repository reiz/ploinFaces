package org.ploin.web.flow;


import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.ploin.web.faces.phaselistener.JsfPhaseListener06;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mock.FacesContextMock;

/**
 * <code><pre>
 *                                    ........
 *                                 .WHHUUVOOOOU&,
 *     dMMMMMMMMMMMa,   .MMMMF   .MHW0Oz+!``````?G.   .MMMM% .MMMMMMMMMMMN,
 *    .MMMMMMMMMMMMMMr  JMMMM   JHHXwOz;:^..```  `O,  JMMM#  dMMMMMMMMMMMMN
 *    JMMM#     ,MMMMF  MMMMF  .MHVXwOz++.^.````  +n .MMMM$ .MMMMt    dMMM#
 *   .MMMMt     .MMMMt .MMMM!  JMHWWXwOz++....  `.+X JMMMM  JMMMM    .MMMM%
 *   JMMM#     .MMMM@  dMMM#   ,MHHWWXwOzz+++....?df MMMMF .MMMMF    JMMM#
 *  .MMMMNNNNNMMMMMD   MMMMMNNm 4MHHWWXXwOOzzz1+1wX'.MMMM! .MMMM`   .MMMM$
 *  .MMMMMMMMMMMM"`    .YMMMMMF  TMHHHWWWXXXwwwwXK! MMMMF  MMMMF    JMMMM
 *  MMMMF                          TMMHHHHHWWWHY^
 * .MMMM'                             `7""""^`
 * dMMM#
 * </pre></code>
 * <p/>
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/flow/FlowControlTest.java $<br>
 * $LastChangedBy: r.reiz<br>
 * $Revision: 1$<br>
 * $Date: 2009-01-15 10:45:26 +0100 (Do, 15 Jan 2009)<br>
 */
public class FlowControlTest {

	Set<String> views = new HashSet<String>();
	private JsfPhaseListener06 listener;

	/**
	 * Here we setup a Set<String> views, with the two elements
	 * "/page/registration.*" and "/page/start.xhtml"
	 */
	@BeforeClass
	public void before(){
		views.add("/page/registration.*");
		views.add("/page/start.xhtml");
		listener = new JsfPhaseListener06();
		FacesContext fc = new FacesContextMock();
		listener.setFacesContextTest(fc);
	}

	/**
	 * In the first test we create an instance of FlowControl and
	 * call the method isViewInSet(views, "/page/registrationPage1.xhtml").<br/>
	 * assurtTrue
	 */
	@Test
	public void isViewInSet1(){
		FlowControl fc = new FlowControl();
	  	assert fc.isViewInSet(views, "/page/registrationPage1.xhtml");
	}

	/**
	 * In the second test we check if "/page/start.xhtml" is in the set. <br/>
	 * assertTrue 
	 */
	@Test(dependsOnMethods = {"isViewInSet1"})
	public void isViewInSet2(){
		FlowControl fc = new FlowControl();
		assert fc.isViewInSet(views, "/page/start.xhtml");
	}

	/**
	 * In the second test we check if "/page/start.xhtmlUti" is in the set. <br/>
	 * assertFalse 
	 */
	@Test(dependsOnMethods = {"isViewInSet2"})
	public void isViewInSet3(){
		FlowControl fc = new FlowControl();
		assert !fc.isViewInSet(views, "/page/start.xhtmlUti");
	}

	/**
	 * In the third test we check if "/page/registrrrationPage1.xhtml" is in the set. <br/>
	 * assertFalse
	 */
	@Test(dependsOnMethods = {"isViewInSet3"})
	public void isViewNotInSet1(){
		FlowControl fc = new FlowControl();
		assert !fc.isViewInSet(views, "/page/registrrrationPage1.xhtml");
	}

	/**
	 * Here we check if "/page/statt.*" is in the set. <br/>
	 * assertFalse
	 */
	@Test(dependsOnMethods = {"isViewNotInSet1"})
	public void isViewNotInSet2(){
		FlowControl fc = new FlowControl();
		assert !fc.isViewInSet(views, "/page/statt.*");
	}

	/**
	 * Here we check if "/page/statt.*" is in the empty set. <br/>
	 * assertFalse
	 */
	@Test(dependsOnMethods = {"isViewNotInSet2"})
	public void isViewNotInSet3(){
		FlowControl fc = new FlowControl();
		assert !fc.isViewInSet(null, "/page/statt.*");
	}

	/**
	 * Here we check if null is in the set. <br/>
	 * assertFalse
	 */
	@Test(dependsOnMethods = {"isViewNotInSet3"})
	public void isViewNotInSet4(){
		FlowControl fc = new FlowControl();
		assert !fc.isViewInSet(views, null);
	}

	/**
	 * In this testcase we call the method with a null parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewNotInSet4"})
	public void isViewsInSubflows(){
		FlowControl fc = new FlowControl();
		assertFalse(fc.isViewInSubFlows(null, new Flow(), "sf"));
	}

	/**
	 * In this testcase we call the method with a null parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows"})
	public void isViewsInSubflows2(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		flows.add(new Flow());
		assertFalse(fc.isViewInSubFlows(flows, null, "af"));
	}

	/**
	 * In this testcase we call the method with a null parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows2"})
	public void isViewsInSubflows3(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		flows.add(new Flow());
		assertFalse(fc.isViewInSubFlows(flows, new Flow(), ""));
	}

	/**
	 * In this testcase we call the method with a null parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows3"})
	public void isViewsInSubflows4(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		flows.add(new Flow());
		assertFalse(fc.isViewInSubFlows(flows, new Flow(), null));
	}

	/**
	 * In this testcase we call the method with valid parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows4"})
	public void isViewsInSubflows5(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		flows.add(new Flow());
		Flow flow = new Flow();
		assertFalse(fc.isViewInSubFlows(flows, flow, "/page/flow.xhtml"));
	}

	/**
	 * In this testcase we call the method with valid parameter. <br/>
	 * we expect true.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows5"})
	public void isViewsInSubflows6(){
		FlowControl fc = new FlowControl();
		String view = "/page/flow.xhtml";
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("flowSub");
		in.addView(view);
		flows.add(in);
		Flow flow = new Flow();
		flow.addSubFlow("flowSub");
		assertTrue(fc.isViewInSubFlows(flows, flow, view));
	}

	/**
	 * In this testcase we call the method with valid parameter. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows6"})
	public void isViewsInSubflows7(){
		FlowControl fc = new FlowControl();
		String view = "/page/flow.xhtml";
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("flowSub");
		in.addView(view + "te");
		flows.add(in);
		Flow flow = new Flow();
		flow.addSubFlow("flowSub");
		assertFalse(fc.isViewInSubFlows(flows, flow, view));
	}



	/**
	 * In this testcase we call the method with wrong parameters. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewsInSubflows7"})
	public void getFlowById1(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("flowSub");
		in.addView("te");
		flows.add(in);
		assertNull(fc.getFlowById(null, flows));
	}

	/**
	 * In this testcase we call the method with wrong parameters. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"getFlowById1"})
	public void getFlowById2(){
		FlowControl fc = new FlowControl();		
		assertNull(fc.getFlowById("asf", null));
	}

	/**
	 * In this testcase we call the method with wrong parameters. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"getFlowById2"})
	public void getFlowById3(){
		FlowControl fc = new FlowControl();
		assertNull(fc.getFlowById("", null));
	}

	/**
	 * In this testcase we call the method with wrong parameters. <br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"getFlowById3"})
	public void getFlowById4(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		assertNull(fc.getFlowById("as", flows));
	}

	/**
	 * In this testcase we call the method with valid parameters. <br/>
	 * we expect the searched Flow.
	 */
	@Test(dependsOnMethods = {"getFlowById4"})
	public void getFlowById5(){
		String flowId = "flowSub";
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId(flowId);
		in.addView("te");
		flows.add(in);
		Flow f = fc.getFlowById(flowId, flows);
		assertNotNull(f);
		assertEquals(f.getFlowId(), flowId);
	}




	/**
	 * In this testcase we call the method with null parameters.<br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"getFlowById5"})
	public void isViewInFlowPathPeek1(){
		FlowControl fc = new FlowControl();
		boolean r = fc.isViewInFlowPathPeek(null, null, null);
		assertFalse(r);
	}

	/**
	 * In this testcase we call the method with null parameters.<br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewInFlowPathPeek1"})
	public void isViewInFlowPathPeek2(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("fl");
		in.addView("te");
		flows.add(in);
		boolean r = fc.isViewInFlowPathPeek(flows, null, null);
		assertFalse(r);
	}

	/**
	 * In this testcase we call the method with null parameters.<br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewInFlowPathPeek2"})
	public void isViewInFlowPathPeek3(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("fl");
		in.addView("te");
		flows.add(in);
		boolean r = fc.isViewInFlowPathPeek(flows, "asf", null);
		assertFalse(r);
	}

	/**
	 * In this testcase we call the method with valid parameters.<br/>
	 * we expect true.
	 */
	@Test(dependsOnMethods = {"isViewInFlowPathPeek3"})
	public void isViewInFlowPathPeek4(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("fl");
		in.addView("te");
		flows.add(in);
		boolean r = fc.isViewInFlowPathPeek(flows, "fl", "te");
		assertTrue(r);
	}

	/**
	 * In this testcase we call the method with valid parameters, but
	 * the toViewId is not in the flows.<br/>
	 * we expect false.
	 */
	@Test(dependsOnMethods = {"isViewInFlowPathPeek4"})
	public void isViewInFlowPathPeek5(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = new ArrayList<Flow>();
		Flow in = new Flow();
		in.setFlowId("fl");
		in.addView("te");
		flows.add(in);
		boolean r = fc.isViewInFlowPathPeek(flows, "fl", "tetf");
		assertFalse(r);
	}




	/**
	 * In this testcase we call the method readFlows<br/>
	 * we expect a list with two elements.
	 */
	@Test(dependsOnMethods = {"isViewInFlowPathPeek5"})
	public void readFlows1(){
		FlowControl fc = new FlowControl();
		List<Flow> flows = fc.readFlows();
		assertNotNull(flows);
		assertEquals(flows.size(), 2);
		Flow flow1 = flows.get(0);
		assertEquals(flow1.getAuthoritySource(), "#{sessionBean.getRole}");
		assertEquals(flow1.getAccessDeniedPage(), "/page/accessDenied.xhtml");
		assertEquals(flow1.getDisableUrlNavigation(), Boolean.FALSE);
		assertEquals(flow1.getDisableUrlNavigation(), Boolean.FALSE);
		Set<String> ignoreViews = flow1.getIgnoreViews();
		assertEquals(ignoreViews.size(), 1);
		assertTrue(ignoreViews.contains("/page/info/.*"));
		Set<String> views = flow1.getViews();
		assertEquals(views.size(), 5);
		assertTrue(views.contains("/page/error/.*"));
		assertTrue(views.contains("/page/registration/.*"));
		Set<String> attr = flow1.getAttributes();
		assertEquals(attr.size(), 1);
		assertTrue(attr.contains("startBean"));
		Set<String> excludes = flow1.getExcludeAuthoritys();
		assertEquals(excludes.size(), 1);
		assertTrue(excludes.contains("admin"));		
	}

	/**
	 * In this testcase, we are testing the leaveFlow method. <br/>
	 * We expect no exception.
	 */
	@Test(dependsOnMethods = {"readFlows1"})
	public void leaveFlowAction1(){
		FlowControl fcontrol = new FlowControl();		
		FacesContext fc = listener.getFacesContextTest();
		fc.getViewRoot().setViewId("/page/registration/.*");
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		FlowControl flowC = new FlowControl();
		List<Flow> flows = flowC.readFlows();
		Flow flow = flows.get(1);
		fcontrol.leaveFlow(flow, fc, session);
		assert 1==1;
	}
	
}
