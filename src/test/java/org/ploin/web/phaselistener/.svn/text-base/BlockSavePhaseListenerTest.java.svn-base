package org.ploin.web.phaselistener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.lifecycle.Lifecycle;

import mock.FacesContextMock;
import mock.LifecycleMock;

import org.ploin.web.faces.phaselistener.BlockSaveListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
 * $HeadURL: svn://ploin.de/Bean.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 1 $<br>
 * $Date: 2009-01-15 10:45:26 +0100 (Do, 15 Jan 2009) $<br>
 * Created by: Robert Reiz
 * Created date: Apr 10, 2009 / 3:13:21 PM
 */
public class BlockSavePhaseListenerTest {

	private BlockSaveListener block; 

	/**
	 * Here we setup the PhaseListener.
	 */
	@BeforeClass
	public void before(){
		block = new BlockSaveListener();
	}


	/**
	 * Here we test the getter an setter of the phaseListener
	 */
	@Test
	public void getterAndSetter(){
		FacesContext fc = new FacesContextMock();
		block.setF(fc);
		assertNotNull(block.getF());
	}


	/**
	 * Here we are testing the getPhaseId method. <br/>
	 * We expect PROCESS_VALIDATIONS
	 */
	@Test
	public void getPhaseId(){
		assertNotNull(block.getPhaseId());
		assertEquals(block.getPhaseId(), PhaseId.RESTORE_VIEW);
	}


	/**
	 * Here we are checking the afterPhase method.<br/>
	 * we expect no exception.
	 */
	@Test
	public void afterPhase(){
		Lifecycle life = new LifecycleMock();
		FacesContext fc = new FacesContextMock();
		block.afterPhase(new PhaseEvent(fc, PhaseId.RESTORE_VIEW, life));
		assert 1==1;
	}
	

}
