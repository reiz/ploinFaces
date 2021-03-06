package mock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/HttpSessionMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class HttpSessionMock implements HttpSession {

	private Map map = new HashMap<String, Object>();


	public Object getAttribute(String s) {
		return map.get(s);  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Enumeration getAttributeNames() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public long getCreationTime() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getId() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public long getLastAccessedTime() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public int getMaxInactiveInterval() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public ServletContext getServletContext() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public HttpSessionContext getSessionContext() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Object getValue(String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String[] getValueNames() {
		return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void invalidate() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public boolean isNew() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void putValue(String s, Object o) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void removeAttribute(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void removeValue(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void setAttribute(String s, Object o) {
		map.put(s, o);
	}

	public void setMaxInactiveInterval(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
