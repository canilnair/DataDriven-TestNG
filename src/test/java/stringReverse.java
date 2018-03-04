import org.testng.annotations.Test;
import java.io.*;

public class stringReverse {
	
	@Test
	public void StringReverse() {
		
		String str = "Anil Nair";
		String rev = "";
		
		char[] array = str.toCharArray();
		
		for(int i=(array.length-1); i>=0; i--) {
			rev=rev + array[i];
		}
		System.out.println(rev);
		
	}

}
