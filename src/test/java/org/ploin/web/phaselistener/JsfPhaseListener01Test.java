package org.ploin.web.phaselistener;

import mock.FacesContextMock;
import mock.LifecycleMock;
import org.ploin.web.faces.phaselistener.JsfPhaseListener01;
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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/phaselistener/JsfPhaseListener01Test.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class JsfPhaseListener01Test {

	private JsfPhaseListener01 phaseListener;

	/**
	 * Here we setup the PhaseListener. 
	 */
	@BeforeClass
	public void before(){
		phaseListener = new JsfPhaseListener01();		
	}


	/**
	 * Here we test the getter an setter of the phaseListener
	 */
	@Test
	public void getterAndSetter(){
		FacesContext fc = new FacesContextMock();
		phaseListener.setF(fc);
		assertNotNull(phaseListener.getF());
	}


	/**
	 * Here we are testing the generateId method.<br/>
	 * We expect not null.
	 */
	@Test
	public void generateId(){
		assertNotNull(phaseListener.generateID());
	}


	/**
	 * Here we are testing the getPhaseId method. <br/>
	 * We expect RESTORE_VIEW
	 */
	@Test
	public void getPhaseId(){
		assertNotNull(phaseListener.getPhaseId());
		assertEquals(phaseListener.getPhaseId(), PhaseId.RESTORE_VIEW);
	}


	/**
	 * Here we are checking the afterPhase method.<br/>
	 * we expect no exception.
	 */
	@Test
	public void afterPhase(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = new FacesContextMock();
		phaseListener.afterPhase(new PhaseEvent(fc, PhaseId.RESTORE_VIEW, life));
		assert 1==1;
	}


	/**
	 * In this testcase, we are testing the beforePhase method. <br/>
	 * We expect that the session Attribute ploinFacesFromViewId is equal to null.
	 */
	@Test(dependsOnMethods = {"getterAndSetter"})
	public void beforePhase1(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = phaseListener.getF();
		phaseListener.beforePhase(new PhaseEvent(fc, PhaseId.RESTORE_VIEW, life));
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(true);
		String pffvi = (String)session.getAttribute("ploinFacesFromViewId");
		assertEquals(pffvi, null);
	}


	/**
	 * In this testcase, we are testing the beforePhase method. <br/>
	 * We expect that the session Attribute ploinFacesFromViewId is equal to "/page/start.xhtml".
	 */
	@Test(dependsOnMethods = {"beforePhase1"})
	public void beforePhase2(){
		String viewId = "/page/start.xhtml";
		Lifecycle life = new LifecycleMock();
		FacesContext fc = phaseListener.getF();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.setAttribute("ploinFacesFromViewId", viewId);
		phaseListener.beforePhase(new PhaseEvent(fc, PhaseId.RESTORE_VIEW, life));
		session = (HttpSession)fc.getExternalContext().getSession(true);
		String pffvi = (String)session.getAttribute("ploinFacesFromViewId");
		assertEquals(pffvi, viewId);
	}


}
