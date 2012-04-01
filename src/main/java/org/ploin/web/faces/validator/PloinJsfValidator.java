package org.ploin.web.faces.validator;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import java.util.Locale;

/**
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 * Created by: Robert Reiz
 * Created date: May 27, 2009 / 5:06:13 PM
 */
public abstract class PloinJsfValidator implements Validator{


	public Locale getLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		if (viewRoot != null){
			return viewRoot.getLocale();
		} else {
			return null;
		}
	}

}
