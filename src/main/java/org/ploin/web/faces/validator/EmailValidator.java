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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 */
public class EmailValidator extends PloinJsfValidator implements Serializable{

	private static final long serialVersionUID = -5788761962473298350L;
	private Log log = LogFactory.getLog(EmailValidator.class);

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9._%+-]+\\.[A-Za-z]{2,4}");
		Matcher m = p.matcher((String)value);

		if(!m.matches() || ((String)value).length() < 6){
			String message = null;
			try {
				String bundleName = context.getApplication().getMessageBundle();
				ResourceBundle bundle = ResourceBundle.getBundle(bundleName, getLocale());
				message = bundle.getString("ploin.emailValidator");
			} catch (Exception e) {
				log.error("ERROR in EmailValidator ", e);
			}
			if (message == null || message.equals("")){
				message = "Validationerror. " +
				"Please type in a valid e-mail-adress!";
			}
			throw new ValidatorException(new FacesMessage(message));
		}
	}

}