package org.ploin.web.faces.validator;

import java.io.Serializable;

/**
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 91 $<br>
 * $Date: 2010-01-18 22:26:53 +0100 (Mon, 18 Jan 2010) $<br>
 * Created by: Robert Reiz
 * Created date: Mar 5, 2009 / 10:16:27 AM
 */
public abstract class NumberValidator extends PloinJsfValidator implements Serializable {


	public String getValue(Object value){
		String val = "";
		if (value instanceof String){
			val = (String)value;
		} else if (value instanceof Integer){
			Integer i = (Integer)value;
			val = String.valueOf(i);
		} else if (value instanceof Long){
			Long l = (Long)value;
			val = String.valueOf(l);
		} else if (value instanceof Double){
			Double d = (Double)value;
			val = String.valueOf(d);
		} else if (value instanceof Float){
			Float f = (Float)value;
			val = String.valueOf(f);
		}
		return val;
	}

}
