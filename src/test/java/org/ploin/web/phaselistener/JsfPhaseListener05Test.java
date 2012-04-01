package org.ploin.web.phaselistener;

import mock.FacesContextMock;
import mock.LifecycleMock;
import org.ploin.web.faces.phaselistener.JsfPhaseListener05;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.lifecycle.Lifecycle;
import javax.servlet.http.HttpSession;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/phaselistener/JsfPhaseListener05Test.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class JsfPhaseListener05Test {

	private JsfPhaseListener05 listener;


	/**
	 * Here we setup the PhaseListener.
	 */
	@BeforeClass
	public void before(){
		listener = new JsfPhaseListener05();
	}


	/**
	 * Here we test the getter an setter of the phaseListener
	 */
	@Test
	public void getterAndSetter(){
		FacesContext fc = new FacesContextMock();
		listener.setF(fc);
		assertNotNull(listener.getF());
	}

	/**
	 * Here we are testing the getPhaseId method. <br/>
	 * We expect PROCESS_VALIDATIONS
	 */
	@Test
	public void getPhaseId(){
		assertNotNull(listener.getPhaseId());
		assertEquals(listener.getPhaseId(), PhaseId.INVOKE_APPLICATION);
	}


	/**
	 * Here we are checking the afterPhase method.<br/>
	 * we expect no exception.
	 */
	@Test
	public void afterPhase(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = new FacesContextMock();
		listener.afterPhase(new PhaseEvent(fc, PhaseId.INVOKE_APPLICATION, life));
		assert 1==1;
	}

	/**
	 * In this testcase, we are testing the beforePhase method. <br/>
	 * We expect that the session Attribute jsfPhase is equal to 5.
	 */
	@Test(dependsOnMethods = {"getterAndSetter"})
	public void beforePhase1(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = listener.getF();
		listener.beforePhase(new PhaseEvent(fc, PhaseId.INVOKE_APPLICATION, life));
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(true);
		Integer jp = (Integer)session.getAttribute("jsfPhase");
		assertEquals(jp, new Integer(5));
	}

}
