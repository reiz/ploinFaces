package mock;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.application.StateManager;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.*;
import javax.faces.event.ActionListener;
import javax.faces.validator.Validator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/ApplicationMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 87 $<br>
 * $Date: 2010-01-10 12:25:05 +0100 (Sun, 10 Jan 2010) $<br>
 */
public class ApplicationMock extends Application {

	private String messageBundle = "messages";

	public void addComponent(String s, String s1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void addConverter(String s, String s1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void addValidator(String s, String s1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public UIComponent createComponent(String s) throws FacesException {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public UIComponent createComponent(ValueBinding valueBinding, FacesContext facesContext, String s) throws FacesException {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Converter createConverter(String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public MethodBinding createMethodBinding(String s, Class[] classes) throws ReferenceSyntaxException {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Validator createValidator(String s) throws FacesException {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public ValueBinding createValueBinding(String s) throws ReferenceSyntaxException {
		return new ValueBindingMock();  
	}

	public ActionListener getActionListener() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Iterator<String> getComponentTypes() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Iterator<String> getConverterIds() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void addConverter(Class<?> aClass, String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public Converter createConverter(Class<?> aClass) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Iterator<Class<?>> getConverterTypes() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Locale getDefaultLocale() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getDefaultRenderKitId() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getMessageBundle() {
		return messageBundle;
	}

	public NavigationHandler getNavigationHandler() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public PropertyResolver getPropertyResolver() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public StateManager getStateManager() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Iterator<Locale> getSupportedLocales() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Iterator<String> getValidatorIds() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public VariableResolver getVariableResolver() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public ViewHandler getViewHandler() {
		return new ViewHandlerMock();  
	}

	public void setActionListener(ActionListener actionListener) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setDefaultLocale(Locale locale) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setDefaultRenderKitId(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setMessageBundle(String s) {
		messageBundle = s;
	}

	public void setNavigationHandler(NavigationHandler navigationHandler) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setPropertyResolver(PropertyResolver propertyResolver) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setStateManager(StateManager stateManager) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setSupportedLocales(Collection<Locale> locales) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setVariableResolver(VariableResolver variableResolver) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setViewHandler(ViewHandler viewHandler) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
