
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;
import com.Ostermiller.util.MD5;




/**
 * 
 */

/**
 * @author Dr. Donyina
 *
 */
public class VMSTest extends TestCase {

	
	public void testCase1() throws Exception {
		boolean testvalue = false;
		PrintStream ps = new PrintStream(new FileOutputStream("output_test_case_1.txt"));
		System.setOut(ps);
		TacomaVendingMachine tvm = new TacomaVendingMachine();
		for (int i = 0; i < 6; i++) {
		TacomaVendingMachine.recipeArray[i] = new Recipe();
		}
		String todo = "1\ngrisling\n34.99\n10\n2\n5\n1\n0\n7\n";
		ByteArrayInputStream b1 = new ByteArrayInputStream(todo.getBytes());
		tvm.setSystemIn(true, b1, ps);
		TacomaVendingMachine.mainMenu();
		tvm.clearAll();
		// Testing if the two files are alike
		System.setOut(System.out);
		File outPut = new File("output_test_case_1.txt");
		File outPut_expected = new File("output_test_case_1_expected.txt");
		// Creates a md5 string from the two files
		String s1 = MD5.getHashString(outPut);
		String s2 = MD5.getHashString(outPut_expected);
		


		assertTrue(s1.equals(s2));
		
	
	
		}
	
	public VMSTest(String name) {
		super(name);
	}
	
}	

