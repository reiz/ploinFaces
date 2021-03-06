package mock;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import java.util.Iterator;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/FacesContextMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class FacesContextMock extends FacesContext {

	private Application app = new ApplicationMock();
	private ExternalContext context = new ExternalContextMock();
	private UIViewRoot viewRoot = new UIViewRoot();


	public FacesContextMock(){
		
	}

	public void addMessage(String s, FacesMessage facesMessage) {

	}

	public Application getApplication() {
		return app;
	}

	public Iterator<String> getClientIdsWithMessages() {
		return null;
	}

	public ExternalContext getExternalContext() {
		return context; 
	}

	public FacesMessage.Severity getMaximumSeverity() {
		return null;
	}

	public Iterator<FacesMessage> getMessages() {
		return null;
	}

	public Iterator<FacesMessage> getMessages(String s) {
		return null;
	}

	public RenderKit getRenderKit() {
		return null;
	}

	public boolean getRenderResponse() {
		return false;
	}

	public boolean getResponseComplete() {
		return false;
	}

	public ResponseStream getResponseStream() {
		return null;
	}

	public ResponseWriter getResponseWriter() {
		return null;
	}

	public UIViewRoot getViewRoot() {
		return viewRoot;
	}

	public void release() {

	}

	public void renderResponse() {

	}

	public void responseComplete() {

	}

	public void setResponseStream(ResponseStream responseStream) {

	}

	public void setResponseWriter(ResponseWriter responseWriter) {

	}

	public void setViewRoot(UIViewRoot uiViewRoot) {

	}
}
