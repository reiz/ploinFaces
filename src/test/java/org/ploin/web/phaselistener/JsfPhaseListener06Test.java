package org.ploin.web.phaselistener;

import mock.FacesContextMock;
import mock.LifecycleMock;
import org.ploin.web.faces.phaselistener.JsfPhaseListener06;
import org.ploin.web.flow.Flow;
import org.ploin.web.flow.FlowControl;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.lifecycle.Lifecycle;
import javax.servlet.http.HttpSession;
import java.util.List;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/phaselistener/JsfPhaseListener06Test.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 */
public class JsfPhaseListener06Test {


	private JsfPhaseListener06 listener;

	/**
	 * Here we setup the PhaseListener.
	 */
	@BeforeClass
	public void before(){
		listener = new JsfPhaseListener06();
	}


	/**
	 * Here we test the getter an setter of the phaseListener
	 */
	@Test
	public void getterAndSetter(){
		FacesContext fc = new FacesContextMock();
		listener.setFacesContextTest(fc);
		assertNotNull(listener.getFacesContextTest());
	}

	/**
	 * Here we are testing the getPhaseId method. <br/>
	 * We expect PROCESS_VALIDATIONS
	 */
	@Test
	public void getPhaseId(){
		assertNotNull(listener.getPhaseId());
		assertEquals(listener.getPhaseId(), PhaseId.RENDER_RESPONSE);
	}


	/**
	 * Here we are checking the afterPhase method.<br/>
	 * we expect no exception.
	 */
	@Test
	public void afterPhase(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = new FacesContextMock();
		listener.afterPhase(new PhaseEvent(fc, PhaseId.RENDER_RESPONSE, life));
		assert 1==1;
	}

	/**
	 * In this testcase, we are testing the beforePhase method. <br/>
	 * We expect that the session Attribute jsfPhase is equal to null.
	 */
	@Test(dependsOnMethods = {"getterAndSetter"})
	public void beforePhase1(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = listener.getFacesContextTest();
		fc.getViewRoot().setViewId("/page/registration/.*");
		FlowControl flowC = new FlowControl();
		fc.getExternalContext().getApplicationMap().put("ploinFlows", flowC.readFlows());
		listener.beforePhase(new PhaseEvent(fc, PhaseId.RENDER_RESPONSE, life));
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(true);
		String pffvi = (String)session.getAttribute("ploinploin");
		assertEquals(pffvi, null);
	}

	/**
	 * In this testcase, we are testing the beforePhase method. <br/>
	 * We expect that the session Attribute jsfPhase is equal to null.
	 */
	@Test(dependsOnMethods = {"getterAndSetter"})
	public void beforePhase2(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = listener.getFacesContextTest();
		fc.getViewRoot().setViewId("/page/registration/.*");
		FlowControl flowC = new FlowControl();
		List<Flow> flows = flowC.readFlows();
		flows.get(0).setDisableUrlNavigation(Boolean.TRUE);
		fc.getExternalContext().getApplicationMap().put("ploinFlows", flows);
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.setAttribute("ploinFacesFromViewId", "/page/start.xhtml");
		listener.beforePhase(new PhaseEvent(fc, PhaseId.RENDER_RESPONSE, life));
		session = (HttpSession)fc.getExternalContext().getSession(true);
		String pffvi = (String)session.getAttribute("ploinploin");
		assertEquals(pffvi, null);
	}




}
