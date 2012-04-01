package org.ploin.web.flow;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/flow/FlowTest.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class FlowTest {

	private Flow flow;


	/**
	 * Here we set up the testscenario.
	 */
	@BeforeClass
	public void init(){
		flow = new Flow();
	}


	//############ EQUALS AND HASHCODE #############################

	@Test
	public void checkEquals1(){
		Flow r = new Flow();
		assertNotSame(r, flow);
	}

	@Test(dependsOnMethods = {"checkEquals1"})
	public void checkEquals2(){
		assertSame(flow, flow);
	}

	@Test(dependsOnMethods = {"checkEquals2"})
	public void checkEquals3(){
		assertTrue(flow.equals(flow));
	}

	@Test(dependsOnMethods = {"checkEquals3"})
	public void checkEquals4(){
		Flow r = new Flow();
		r.setFlowId("1l");
		Flow r2 = new Flow();
		r2.setFlowId("2l");
		assertNotSame(r, r2);
		assertTrue(!r.equals(r2));
	}

	@Test(dependsOnMethods = {"checkEquals4"})
	public void checkEquals5(){
		Flow r = new Flow();
		r.setFlowId("1l");
		Flow r2 = new Flow();
		r2.setFlowId("1l");
		assertTrue(r.equals(r2));
	}

	@Test(dependsOnMethods = {"checkEquals5"})
	public void checkEquals6(){
		Flow r = new Flow();
		r.setFlowId("1l");
		assertTrue(!r.equals(null));
	}

	@Test(dependsOnMethods = {"checkEquals6"})
	public void checkEquals7(){
		Flow p = new Flow();
		p.setFlowId("");
		assertTrue(flow.equals(p));
	}

	@Test(dependsOnMethods = {"checkEquals7"})
	public void checkEquals8(){
		Flow pp = new Flow();
		pp.setFlowId("44l");
		Flow p = new Flow();
		p.setFlowId(null);
		assertFalse(pp.equals(p));
	}

	@Test(dependsOnMethods = {"checkEquals8"})
	public void checkHashCode1(){
		Flow r = new Flow();
		r.setFlowId("1l");
		System.out.println(r.hashCode());
		assertTrue(r.hashCode() == 1627);
	}

	@Test(dependsOnMethods = {"checkHashCode1"})
	public void checkHashCode2(){
		Flow r = new Flow();
		r.setFlowId("1l");
		assertTrue( ! (r.hashCode() == 4) );
	}

	@Test(dependsOnMethods = {"checkHashCode2"})
	public void checkHashCode3(){
		Flow r = new Flow();
		r.setFlowId(null);
		assertTrue( r.hashCode() == 0 );
	}


	//############# GETTER AND SETTER ###################################

	/**
	 * Here we testing the getter and setter for AccessDeniedPage. 
	 */
	@Test
	public void getterAndSetterForAccessDeniedPage(){
		assertNull(flow.getAccessDeniedPage());
		String denied = "/page/denied.xhtml"; 
		flow.setAccessDeniedPage(denied);
		assertNotNull(flow.getAccessDeniedPage());
		assertEquals(flow.getAccessDeniedPage(), denied);
	}

	/**
	 * Here we testing the getter and setter for AfterFlowAction
	 */
	@Test
	public void getterAndSetterForAfterFlowAction(){
		assertNull(flow.getAfterFlowAction());
		String af = "#{initBean.after}";
		flow.setAfterFlowAction(af);
		assertNotNull(flow.getAfterFlowAction());
		assertEquals(flow.getAfterFlowAction(), af);
	}

	/**
	 * Here we testing the getter and setter for AfterLifeCycleAction
	 */
	@Test
	public void getterAndSetterForAfterLifecycleAction(){
		assertNull(flow.getAfterLifecycleAction());
		String af = "#{initBean.after}";
		flow.setAfterLifecycleAction(af);
		assertNotNull(flow.getAfterLifecycleAction());
		assertEquals(flow.getAfterLifecycleAction(), af);
	}

	/**
	 * Here we testing the getter and setter for AppName
	 */
	@Test
	public void getterAndSetterForAppName(){
		assertNull(flow.getAppName());
		String appname = "tsm";
		flow.setAppName(appname);
		assertNotNull(flow.getAppName());
		assertEquals(flow.getAppName(), appname);
	}

	/**
	 * Here we testing the getter and setter for Attributes
	 */
	@Test
	public void getterAndSetterForAttributes(){
		assertNotNull(flow.getAttributes() );
		assertEquals(flow.getAttributes().size(), 0);
		flow.setAttributes(null);
		assertNull(flow.getAttributes());		
	}

	/**
	 * Here we testing the add-method for Attributes
	 */
	@Test(dependsOnMethods = {"getterAndSetterForAttributes"})
	public void addAttribute(){
		flow.addAttribute("test");
		assertNotNull(flow.getAttributes());
		assertEquals(flow.getAttributes().size(), 1);
	}

	/**
	 * Here we testing the contain-method for Attributes
	 */
	@Test(dependsOnMethods = {"addAttribute"})
	public void containAttribute(){
		assertTrue(flow.attributeContains("test"));
	}

	/**
	 * Here we testing the getter and setter for AuthoritySource
	 */
	@Test
	public void getterAndSetterForAuthoritySource(){
		assertNull(flow.getAuthoritySource() );
		String authSource = "tsm";
		flow.setAuthoritySource(authSource);
		assertNotNull(flow.getAuthoritySource());
		assertEquals(flow.getAuthoritySource(), authSource);
	}

	/**
	 * Here we testing the getter and setter for BeforeFlowAction
	 */
	@Test
	public void getterAndSetterForBeforeFlowAction(){
		assertNull(flow.getBeforeFlowAction() );
		String bfa = "#{initBean.init}";
		flow.setBeforeFlowAction(bfa);
		assertNotNull(flow.getBeforeFlowAction());
		assertEquals(flow.getBeforeFlowAction(), bfa);
	}

	/**
	 * Here we testing the getter and setter for BeforeLifecycleAction
	 */
	@Test
	public void getterAndSetterForBeforeLifecycleAction(){
		assertNull(flow.getBeforeLifecycleAction() );
		String bfa = "#{initBean.init}";
		flow.setBeforeLifecycleAction(bfa);
		assertNotNull(flow.getBeforeLifecycleAction());
		assertEquals(flow.getBeforeLifecycleAction(), bfa);
	}

	/**
	 * Here we testing the getter and setter for DisableUrlNavigation
	 */
	@Test
	public void getterAndSetterForDisableUrlNavigation(){		
		assertEquals(flow.getDisableUrlNavigation(), Boolean.FALSE);
		flow.setDisableUrlNavigation(Boolean.TRUE);
		assertEquals(flow.getDisableUrlNavigation(), Boolean.TRUE);
	}

	/**
	 * Here we testing the getter and setter for ExcludeAuthoritys
	 */
	@Test
	public void getterAndSetterForExcludeAuthoritys(){
		assertNotNull(flow.getExcludeAuthoritys());
		assertEquals(flow.getExcludeAuthoritys().size(), 0);
		flow.setExcludeAuthoritys(null);
		assertNull(flow.getExcludeAuthoritys());
	}

	/**
	 * Here we testing the adder for ExcludeAuthoritys
	 */
	@Test( dependsOnMethods = {"getterAndSetterForExcludeAuthoritys"})
	public void addExcludeAuthoritys(){
		flow.addExcludeAuthority("test");
		assertNotNull(flow.getExcludeAuthoritys());
		assertEquals(flow.getExcludeAuthoritys().size(), 1);		
	}

	/**
	 * Here we testing the adder for ExcludeAuthoritys
	 */
	@Test( dependsOnMethods = {"addExcludeAuthoritys"})
	public void containExcludeAuthoritys(){
		assertTrue(flow.excludeContains("test"));
	}

	/**
	 * Here we testing the getter and setter for FlowId
	 */
	@Test
	public void getterAndSetterForFlowId(){
		assertNotNull(flow.getFlowId() );
		assertEquals(flow.getFlowId(), "");
		flow.setFlowId("flow");
		assertNotNull(flow.getFlowId());
		assertEquals(flow.getFlowId(), "flow");
	}

	/**
	 * Here we testing the getter and setter for IgnoreViews
	 */
	@Test
	public void getterAndSetterForIgnoreViews(){
		assertNotNull(flow.getIgnoreViews());
		assertEquals(flow.getIgnoreViews().size(), 0);
		flow.setIgnoreViews(null);
		assertNull(flow.getIgnoreViews());
	}

	/**
	 * Here we testing the adder for IgnoreViews
	 */
	@Test(dependsOnMethods = {"getterAndSetterForIgnoreViews"})
	public void addIgnoreViews(){
		flow.addIgnoreView("test");
		assertNotNull(flow.getIgnoreViews());
		assertEquals(flow.getIgnoreViews().size(), 1);
	}

	/**
	 * Here we testing the getter and setter for IncludeAuthoritys
	 */
	@Test
	public void getterAndSetterForIncludeAuthoritys(){
		assertNotNull(flow.getIncludeAuthoritys());
		assertEquals(flow.getIncludeAuthoritys().size(), 0);
		flow.setIncludeAuthoritys(null);
		assertNull(flow.getIncludeAuthoritys());
	}

	/**
	 * Here we testing the adder for IncludeAuthoritys
	 */
	@Test(dependsOnMethods = {"getterAndSetterForIncludeAuthoritys"})
	public void addIncludeAuthoritys(){
		flow.addIncludeAuthority("test");
		assertNotNull(flow.getIncludeAuthoritys());
		assertEquals(flow.getIncludeAuthoritys().size(), 1);
	}

	/**
	 * Here we testing the contain-method for IncludeAuthoritys
	 */
	@Test(dependsOnMethods = {"addIncludeAuthoritys"})
	public void containIncludeAuthoritys(){
		assertTrue(flow.includeContains("test"));
	}

	/**
	 * Here we testing the getter and setter for SubFlows
	 */
	@Test
	public void getterAndSetterForSubFlows(){
		assertNotNull(flow.getSubFlows());
		assertEquals(flow.getSubFlows().size(), 0);
		flow.setSubFlows(null);
		assertNull(flow.getSubFlows());
	}

	/**
	 * Here we testing the add-method for SubFlows
	 */
	@Test(dependsOnMethods = {"getterAndSetterForSubFlows"})
	public void addSubFlows(){
		Set<String> set = new HashSet();
		set.add("test");
		flow.setSubFlows(set);
		assertNotNull(flow.getSubFlows());
		flow.addSubFlow("test2");
		assertEquals(flow.getSubFlows().size(), 2);
	}

	/**
	 * Here we testing the getter and setter for Views
	 */
	@Test
	public void getterAndSetterForViews(){
		assertNotNull(flow.getViews());
		assertEquals(flow.getViews().size(), 0);
		flow.setViews(null);
		assertNull(flow.getViews());
	}

	/**
	 * Here we testing the add-method for Views
	 */
	@Test(dependsOnMethods = {"getterAndSetterForViews"})
	public void addViews(){
		flow.addView("test");
		assertNotNull(flow.getViews());
		assertEquals(flow.getViews().size(), 1);
	}

	/**
	 * Here we testing the viewContains-method for Views
	 */
	@Test(dependsOnMethods = {"addViews"})
	public void viewContains(){
		assertTrue(flow.viewContains("test"));
	}

}
