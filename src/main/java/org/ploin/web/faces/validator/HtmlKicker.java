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
package org.ploin.web.faces.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.ResourceBundle;


/**
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 */
public class HtmlKicker extends PloinJsfValidator implements Serializable{
	

	private static final long serialVersionUID = -4691129792307259008L;
    private Log log = LogFactory.getLog(HtmlKicker.class);

    public void validate(FacesContext context,
						 UIComponent component,
						 Object value) throws ValidatorException {
		String val = (String)value;
		if (val.matches(".*<.*") || 
			val.matches(".*href.*") || 
			val.matches(".*>.*") || 
			val.matches(".*\\&.*")){
			String message = null;
			try {
				String bundleName = context.getApplication().getMessageBundle();
				ResourceBundle bundle = ResourceBundle.getBundle(bundleName, getLocale());
				message = bundle.getString("ploin.htmlKicker");
			} catch (Exception e) {
				log.error("ERROR in HtmlKicker ", e);
			}			
			if (message == null || message.equals("")){
				message = "Validationerror. " +
				"Please dont`t type in HTML-Tags or special signs like (&).";
			}
			throw new ValidatorException(new FacesMessage(message));
		}
	}

}
