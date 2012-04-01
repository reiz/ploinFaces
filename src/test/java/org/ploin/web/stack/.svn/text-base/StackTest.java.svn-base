package org.ploin.web.stack;

import org.testng.annotations.Test;

import java.util.Stack;

/**
 * $LastChangedBy: robert $<br>
 * $Revision: 1 $<br>
 * $Date: Apr 24, 2010 $<br>
 * <p/>
 * Created by: robert
 * Created date: Apr 24, 2010 - 6:31:09 PM
 */
public class StackTest {


	@Test
	public void stackTest(){
		Stack stack = new Stack();
		stack.push(1L);
		stack.push(2L);
		stack.push(3L);
		stack.push(4L);
		stack.push(5L);
		assert stack.size() == 5;
		stack.remove(0);
		assert stack.size() == 4;
		assert (Long)stack.peek() == 5L;
		stack.remove(0);
		assert (Long)stack.peek() == 5L;
	}
}
