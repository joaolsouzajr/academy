package labs.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NestedClassTest {
	
	private int param = 1;
	private static int sparam = 2;
	
	@Test
	public void innerClassAcessTest() {
	
		final int intparam = 1;
		
		class CalcLocal{
			int sum(int a, int b){
				return (a + b) * (param + intparam);
			}
		}
		
		assertEquals(4, CalcStatic.sum(1,1));
		sparam = 1;
		assertEquals(2, CalcStatic.sum(1,1));
		
		var calcInst = new CalcInst();
		assertEquals(2, calcInst.sum(1,1));
		param = 2;
		assertEquals(4, calcInst.sum(1,1));

		var calcLocal = new CalcLocal();
		assertEquals(6, calcLocal.sum(1,1));
		param = 1;
		assertEquals(4, calcLocal.sum(1,1));

		
		
	}
	
	static class CalcStatic {
		static int sum(int a, int b){
			return (a + b) * sparam;
		}
	}
	
	class CalcInst{
		
		int sum(int a, int b){
			return (a + b) * param;
		}
		
	}
	

}
