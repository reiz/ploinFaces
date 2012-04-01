package org.ploin.web.faces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.FacesMessage;
import java.util.ResourceBundle;

/**
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 113 $<br>
 * $Date: 2010-03-18 12:53:04 +0100 (Thu, 18 Mar 2010) $<br>
 * <p/>
 * Created by: robert
 * Created date: Nov 11, 2009 - 10:37:34 PM
 * <p/>
 * Description:
 */
public class BaseMessages extends Base {

	private static Log log = LogFactory.getLog(BaseMessages.class);
	private static String SHALE = "???";
	private String detailSuffix = "Detail";
	private String summarySuffix = "Suffix";

	/**
	 * This method returns a value from the default resource bundle.
	 * If there is no value for the given key, returning "???key???".
	 * <br/><br/>
	 * <code>
	 * String firstName = getStringFromResourceBundle("firstName");
	 * </cide>
	 * <br/>
	 * @param key - the messageKey
	 * @return value - value for key
	 */
	public String getStringFromResourceBundle(String key) {
		return getStringFromResourceBundle(key, null);
	}


	/**
	 * With this method you can parametrize your message-values. If you have a messageBundle
	 * like this:
	 * <br/><br/>
	 * <code>
	 * user.info=Hallo {0}, yo are {1}<br/>
	 * </code>
	 * <br/><br/>
	 * you can call this code to parametrize you message.
	 * <br/><br/>
	 * <code>
	 * String[] params = {"Wilbur Ton", "welcome"} ; <br/>
	 * STring value = getStringFromResourceBundle("user.info", params)
	 * </code>
	 * <br/><br/>
	 *
	 *
	 * @param key - the messageKey
	 * @param params - a String array for the message-values
	 * @return value
	 */
	public String getStringFromResourceBundle(String key, String[] params) {
		StringBuffer result = new StringBuffer();
		try {
			ResourceBundle resourceBundle = getResourceBundle();
			String value = resourceBundle.getString(key);
			value = replaceParamsInText(params, value);
			result.append(value);
		} catch (Exception e) {
			log.error("ERROR in getStringFromResourceBundle(String key, String[] params), key="+key+", params=" + params, e);
			result.append(SHALE);
			result.append(key);
			result.append(SHALE);
		}
		return result.toString();
	}


	/**
	 * This methode cocatinate the given key with "Detail". If you call the
	 * methode with "user", it will look in the resourceBundle for a key "userDetail". <br/>
	 * <br/>
	 * <code>String userDetail = getStringFromResourceBundleDetail("user");</code> <br/>
	 * <br/>
	 * @param key - the messageKey
	 * @return value - value for key
	 */
	public String getStringFromResourceBundleDetail(String key) {
		return getStringFromResourceBundleDetail(key, null);
	}


	/**
	 * With this method you can parametrize your message-values. If you have a messageBundle
	 * like this:
	 * <br/><br/>
	 * <code>
	 * user.infoDetail=Hallo {0}, yo are {1}<br/>
	 * </code>
	 * <br/><br/>
	 * you can call this code to parametrize you message.
	 * <br/><br/>
	 * <code>
	 * String[] params = {"Wilbur Ton", "welcome"} ; <br/>
	 * STring value = getStringFromResourceBundleDetail("user.info", params)
	 * </code>
	 * <br/><br/>
	 *
	 * @param key - the message key
	 * @param params - a String array for the message-values
	 * @return value
	 */
	public String getStringFromResourceBundleDetail(String key, final String[] params) {
		key = getDetailKey(key);
		return getStringFromResourceBundle(key, params);
	}


	/**
	 * This methode cocatinate the given key with "Summary". If you call the
	 * methode with "user", it will look in the resourceBundle for a key "userSummary".
	 * <br/><br/>
	 * <code>String userSummary = getStringFromResourceBundleDetail("user")</code>;
	 * <br/><br/>
	 * @param key - the messageKey
	 * @return value - value fro key
	 */
	public String getStringFromResourceBundleSummary(String key) {
		return getStringFromResourceBundleSummary(key, null);
	}

	/**
	 * This methode cocatinate the given key with "Summary". If you call the
	 * methode with "user", it will look in the resourceBundle for a key "userSummary".
	 * <br/><br/>
	 * <code>String userSummary = getStringFromResourceBundleDetail("user")</code>;
	 * <br/><br/>
	 * @param key the messageKey
	 * @param params to replace in key
	 * @return value value fro key
	 */
	public String getStringFromResourceBundleSummary(String key, String[] params) {
		key = getSummaryKey(key);
		return getStringFromResourceBundle(key, params);
	}


	/**
	 * This method adds a message to the application context. The key will be concatinated
	 * onetimes with "Summary" and onetimes with "Detail". If you call this method with
	 * the key "user", you should have following entries in your resourceBundle:
	 * <br/><br/>
	 * <code>
	 * userDetail=something<br/>
	 * userSummary=something
	 * <code>
	 * <br/><br/>
	 * <code>addHTMLMessageFromBundle(FacesMessage.SEVERITY_INFO, "user");</code>
	 * <br/><br/>
	 * @param severity - the severity of the message defined in FacesMessage.Severity
	 * @param key - The messageKey
	 */
	public void addHTMLMessageFromBundle(FacesMessage.Severity severity, String key) {
		addHTMLMessageFromBundle(null, severity, key);
	}


	/**
	 * This method adds a message to the application context. The key will be concatinated
	 * onetimes with "Summary" and onetimes with "Detail". If you call this method with
	 * the key "user", you should have following entries in your resourceBundle:
	 *  <br/><br/>
	 * <code>
	 * userDetail=something<br/>
	 * userSummary=something
	 * </code>
	 *  <br/><br/>
	 * With compId you can call the component, for example the id of a textfield.
	 * <br/>
	 * <br/>
	 * <code>addHTMLMessageFromBundle("form:testID", FacesMessage.SEVERITY_INFO, "user");</code><br/>
	 * <br/>
	 * to find out your exact ID you should use fireBug in FireFox.<br/>
	 * <br/>
	 * @param componentId - the id of the component
	 * @param severity - the severity of the message defined in FacesMessage.Severity
	 * @param key - The messageKey
	 */
	public void addHTMLMessageFromBundle(String componentId, FacesMessage.Severity severity, String key) {
		addHTMLMessageFromBundle(componentId, severity, key, null);
	}


	/**
	 * With this method you can parametrize your message-values. If you have a messageBundle
	 * like this:
	 * <br/><br/>
	 * <code>
	 * user.infoSummary=Hallo {0},<br/>
	 * user.infoDetail=welcome in {1}.
	 * </code>
	 * <br/><br/>
	 * you can call this code to parametrize you message.
	 * <br/><br/>
	 * <code>
	 * String[] params = {"Wilbur Ton", "Malibu"} ; <br/>
	 * addHTMLMessageFromBundle(FacesMessage.SEVERITY_INFO, "user.info", params)
	 * </code>
	 * <br/><br/>
	 * @param severity - the severity of the message defined in FacesMessage.Severity
	 * @param key - the messageKey
	 * @param params - a String array for the message-values
	 */
	public void addHTMLMessageFromBundle(FacesMessage.Severity severity, String key, String[] params) {
		addHTMLMessageFromBundle(null, severity, key, params);
	}


	/**
	 * With this method you can parametrize your message-values. If you have a messageBundle
	 * like this:
	 * <br/><br/>
	 * <code>
	 * user.infoSummary=Hallo {0},<br/>
	 * user.infoDetail=welcome in {1}.
	 * </code>
	 * <br/><br/>
	 * you can call this code to parametrize you message.
	 * <br/><br/>
	 * <code>
	 * String[] params = {"Wilbur Ton", "Malibu"} ;<br/>
	 * addHTMLMessageFromBundle(FacesMessage.SEVERITY_INFO, "user.info", params)
	 * </code>
	 * <br/><br/>
	 * With compId you can call the component, for example the id of a textfield. The returned
	 * Message will be refered to the componentId.
	 * <br/><br/>
	 * @param componentId - the id of the component
	 * @param severity - the severity of the message defined in FacesMessage.Severity
	 * @param key - the messageKey
	 * @param params - a String array for the message-values
	 */
	public void addHTMLMessageFromBundle(String componentId, FacesMessage.Severity severity, String key, String[] params) {
		ResourceBundle resourceBundle = getResourceBundle();
		String summary = getStringFromResourceBundleSummary(key);
		String detail = getStringFromResourceBundleDetail(key, params);
		getFacesContext().addMessage(componentId, new FacesMessage(severity, summary, detail));
	}


	public void addInfoMessage(String componentId, String key, String[] params) {
		addHTMLMessageFromBundle(componentId, FacesMessage.SEVERITY_INFO, key, params);
	}

	public void addInfoMessage(String key) {
		addHTMLMessageFromBundle(null, FacesMessage.SEVERITY_INFO, key, null);
	}

	public void addInfoMessageText(String text) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, text, text));
	}

	public void addInfoMessageText(String summary, String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}


	public void addWarnMessage(String componentId, String key, String[] params) {
		addHTMLMessageFromBundle(componentId, FacesMessage.SEVERITY_WARN, key, params);
	}

	public void addWarnMessage(String key) {
		addHTMLMessageFromBundle(null, FacesMessage.SEVERITY_WARN, key, null);
	}

	public void addWarnMessageText(String text) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, text, text));
	}

	public void addWarnMessageText(String summary, String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
	}


	public void addErrorMessage(String componentId, String key, String[] params) {
		addHTMLMessageFromBundle(componentId, FacesMessage.SEVERITY_ERROR, key, params);
	}

	public void addErrorMessage(String key) {
		addHTMLMessageFromBundle(FacesMessage.SEVERITY_ERROR, key);
	}

	public void addErrorMessageText(String text) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, text, text));
	}

	public void addErrorMessageText(String summary, String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
	}


	public void addFatalMessage(String componentId, String key, String[] params) {
		addHTMLMessageFromBundle(componentId, FacesMessage.SEVERITY_FATAL, key, params);
	}

	public void addFatalMessage(String key) {
		addHTMLMessageFromBundle(FacesMessage.SEVERITY_FATAL, key);
	}

	public void addFatalMessageText(String text) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, text, text));
	}

	public void addFatalMessageText(String summary, String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail));
	}


	/**
	 *
	 * @param severity - the severity of the message defined in FacesMessage.Severity
	 * @param summary - the messageKey for the summary
	 * @param detail - the messageKey for the detail
	 */
	public void addHTMLMessage(FacesMessage.Severity severity, String summary, String detail) {
		getFacesContext().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	private String replaceParamsInText(String[] params, String text){
		if (params != null && params.length > 0){
			for (int i = 0; i < params.length; i++){
				text = text.replaceAll("\\{"+i+"\\}", params[i]);
			}
		}
		return text;
	}

	private String getDetailKey(String key){
		return key + getDetailSuffix();
	}

	private String getSummaryKey(String key){
		return key + getSummarySuffix();
	}

	public String getDetailSuffix() {
		return detailSuffix;
	}

	public void setDetailSuffix(String detailSuffix) {
		this.detailSuffix = detailSuffix;
	}

	public String getSummarySuffix() {
		return summarySuffix;
	}

	public void setSummarySuffix(String summarySuffix) {
		this.summarySuffix = summarySuffix;
	}
}