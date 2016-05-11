package testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.ibm.Core.CustomLogger;
import com.ibm.Core.TestCase;
import com.ibm.netob.lib.*;
import org.junit.Assert;

public class TestCaseNo2 extends TestCase{

	  
	  @Test(groups = { "functest"}, priority = 0)
	  public void method31() throws IOException, InterruptedException{
		  System.out.println("gaga cel viteaz si marul otravit");
		  Assert.assertTrue("test", true);
		  Assert.assertEquals(true, true);
		  Thread.sleep(5000);
		  Assert.assertEquals("Test the assert message",true, false  );
	  }

	  @Test(groups = { "functest2"}, priority = 1)
	  public void method41() throws Exception{
		  CustomLogger.logTestAction("Actiunea 1");
		  Assert.assertTrue("test", true);
		  Thread.sleep(5000);
		  CustomLogger.logTestAction("Actiunea 2");
		  Assert.assertEquals(true, true);
		  CustomLogger.logInfo("Log INFO");
		  CustomLogger.logSuccess("SUCCCESS TEST");
		  throw new Exception("gaga cel viteaz");
		  
	  }

	  @Test(groups = { "functest2"}, priority = 1)
	  public void method51() throws Exception{
		  CustomLogger.logTestAction("Actiunea 1");
		  Assert.assertTrue("test", true);
		  Thread.sleep(5000);
		  CustomLogger.logTestAction("Actiunea 2");
		  Assert.assertEquals(true, true);
		  CustomLogger.logInfo("Log INFO");
		  CustomLogger.logSuccess("SUCCCESS TEST");
		  throw new Exception("gaga cel viteaz");
		  
	  }
}
