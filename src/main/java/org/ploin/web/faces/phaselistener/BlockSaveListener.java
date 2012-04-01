package org.ploin.web.faces.phaselistener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This is a workarround for a security leck in IceFaces 1.7.2 and IceFaces 1.8 <br/>
 * With the "block" servlet it is possible to fetch
 * files under WEB-INF. With the following request it is possible to
 * read the web.xml and other files under WEB-INF.
 * <code><pre>
 * http://localhost:8080/myProject/block/WEB-INF/web.xml
 * </pre></code>
 * <br/><br/>
 * To protect your WEB-INF directory you have to regist this PhaseListener
 * for the RESTORE_VIEW Phase in the faces-config.xml. Here is an Example<br/>
 * <br/>
 * <code><pre>
 * <lifecycle>
 * 		<phase-listener>
 *			org.ploin.web.faces.phaselistener.BlockSaveListener
 *	 	</phase-listener>
 * </lifecycle>
 * </pre></code>
 * <p/>
 * This PhaseListener is a part of ploinFaces 1.4.X (http://www.ploinfaces.org).<p/>
 *
 * @author Robert Reiz (reiz@ploin.de)
 * $Date: 2009-04-14 11:07:20 +0200 (Tue, 14 Apr 2009) $<br>
 */
public class BlockSaveListener implements PhaseListener {

	private FacesContext f = null;

	public void afterPhase(PhaseEvent event) {  }

	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		String url = request.getRequestURL().toString();
		if (url.contains("/block/WEB-INF/")){
			try {
				String[] s = url.split("block/WEB-INF/");
				facesContext.getExternalContext().redirect(s[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	public FacesContext getF() {
		return f;
	}

	public void setF(FacesContext f) {
		this.f = f;
	}
	
}
