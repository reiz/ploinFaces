package mock;

import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.*;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/ExternalContextMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class ExternalContextMock extends ExternalContext {

	private HttpSession session = new HttpSessionMock();
	private Map<String, Object> applicationMap = new HashMap<String, Object>();



	public void dispatch(String s) throws IOException {

	}

	public String encodeActionURL(String s) {
		return null;
	}

	public String encodeNamespace(String s) {
		return null;
	}

	public String encodeResourceURL(String s) {
		return null;
	}

	public Map<String, Object> getApplicationMap() {
		return applicationMap; 
	}

	public String getAuthType() {
		return null;
	}

	public Object getContext() {
		return null;
	}

	public String getInitParameter(String s) {
		return null;
	}

	public Map getInitParameterMap() {
		return null;
	}

	public String getRemoteUser() {
		return null;
	}

	public Object getRequest() {
		return null;
	}

	public String getRequestContextPath() {
		return null;
	}

	public Map<String, Object> getRequestCookieMap() {
		return null;
	}

	public Map<String, String> getRequestHeaderMap() {
		return null;
	}

	public Map<String, String[]> getRequestHeaderValuesMap() {
		return null;
	}

	public Locale getRequestLocale() {
		return null;
	}

	public Iterator<Locale> getRequestLocales() {
		return null;
	}

	public Map<String, Object> getRequestMap() {
		return null;
	}

	public Map<String, String> getRequestParameterMap() {
		return null;
	}

	public Iterator<String> getRequestParameterNames() {
		return null;
	}

	public Map<String, String[]> getRequestParameterValuesMap() {
		return null;
	}

	public String getRequestPathInfo() {
		return null;
	}

	public String getRequestServletPath() {
		return null;
	}

	public URL getResource(String s) throws MalformedURLException {
		return null;
	}

	public InputStream getResourceAsStream(String s) {
		return null;
	}

	public Set<String> getResourcePaths(String s) {
		return null;
	}

	public Object getResponse() {
		return null;
	}

	public Object getSession(boolean b) {
		return session; 
	}

	public Map<String, Object> getSessionMap() {
		return null;
	}

	public Principal getUserPrincipal() {
		return null;
	}

	public boolean isUserInRole(String s) {
		return false;
	}

	public void log(String s) {

	}

	public void log(String s, Throwable throwable) {

	}

	public void redirect(String s) throws IOException {
		
	}
}
