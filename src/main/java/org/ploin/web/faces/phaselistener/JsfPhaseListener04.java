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
package org.ploin.web.faces.phaselistener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import static org.ploin.web.flow.FlowControl.JSF_PHASE;

/**
 * PhaseListener for Phase 4. 
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 121 $<br>
 * $Date: 2010-04-22 12:28:07 +0200 (Thu, 22 Apr 2010) $<br>
 */
public class JsfPhaseListener04 implements PhaseListener{

	
	private static final long serialVersionUID = -4712130409740477348L;
	private Log log = LogFactory.getLog(JsfPhaseListener04.class);
	private FacesContext f;
	
	
	public void beforePhase(PhaseEvent arg0) {
		log.info("beforePhase " + getPhaseId());
		FacesContext facesContext = null;
		if (f != null){
			facesContext = f;
		} else {
			facesContext = FacesContext.getCurrentInstance();
		}
		HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
		session.setAttribute(JSF_PHASE, 4);
	}

	public void afterPhase(PhaseEvent arg0) {
		log.info("afterPhase " + getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.UPDATE_MODEL_VALUES;
	}

	public FacesContext getF() {
		return f;
	}

	public void setF(FacesContext f) {
		this.f = f;
	}

}
