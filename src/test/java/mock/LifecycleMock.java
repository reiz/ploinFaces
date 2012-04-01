package mock;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import java.util.ArrayList;
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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/LifecycleMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class LifecycleMock extends Lifecycle {

	private List<PhaseListener> ps = new ArrayList<PhaseListener>();

	public void addPhaseListener(PhaseListener phaseListener) {
		ps.add(phaseListener);	
	}

	public void execute(FacesContext facesContext) throws FacesException {

	}

	public PhaseListener[] getPhaseListeners() {
		PhaseListener[] p = new PhaseListener[ps.size()];
		int z = 0;
		if (ps != null && ps.size() > 0){
			for (PhaseListener phase: ps){
				p[z++] = phase;
			}
		}
		return p;
	}

	public void removePhaseListener(PhaseListener phaseListener) {

	}

	public void render(FacesContext facesContext) throws FacesException {

	}
}
