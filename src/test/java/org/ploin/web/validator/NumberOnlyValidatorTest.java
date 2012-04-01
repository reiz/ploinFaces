package org.ploin.web.validator;

import mock.FacesContextMock;
import org.ploin.web.faces.validator.NumberOnlyValidator;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/org/ploin/web/validator/NumberOnlyValidatorTest.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class NumberOnlyValidatorTest {

	private NumberOnlyValidator nov;

	/**
	 * Here we set up the testscenario.
	 */
	@BeforeClass
	public void init(){
		nov = new NumberOnlyValidator();
	}


	/**
	 * Here we call the method with a valid string.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate0(){
		FacesContext fc = new FacesContextMock();
		fc.getApplication().setMessageBundle("no");
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, "4lkkl5");
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assertFalse(b);
	}

	/**
	 * Here we call the method with a valid string.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate1(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, "45");
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assert b;
	}

	/**
	 * Here we call the method with a wrong string.<br/>
	 * We expect an Exception.
	 */
	@Test(expectedExceptions = {ValidatorException.class})
	public void validate2(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		nov.validate(fc, component, "this <html> is a testcase");
	}

	/**
	 * Here we call the method with a valid number.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate3(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, 45);
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assert b;
	}

	/**
	 * Here we call the method with a valid number.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate4(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, new Double(45));
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assertFalse(b);
	}

	/**
	 * Here we call the method with a valid number.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate5(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, new Float(67));
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assertFalse(b);
	}

	/**
	 * Here we call the method with a valid number.<br/>
	 * We expect no Exception.
	 */
	@Test
	public void validate6(){
		FacesContext fc = new FacesContextMock();
		UIComponent component = new HtmlInputText();
		boolean b = true;
		try {
			nov.validate(fc, component, new Long(67));
		} catch (ValidatorException e) {
			e.printStackTrace();
			b = false;
		}
		assert b;
	}


}
