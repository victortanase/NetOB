package testcases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.ibm.Core.TestCase;
import com.ibm.netob.lib.*;
import org.junit.Assert;

public class TestCaseNo2 extends TestCase{

	
	
	  @Test(groups = { "validation", "checkintest" })
	  public void method1() throws IOException{
			ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
			test.setOutputFile("/home/victor/Downloads/scenario_1.xls");
			test.setDefaultExcelDataForDedicatedLine();

			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "3.3.3.0");
			test.setNextHopAddress("1.1.1.1");
			test.setHowManyRoutes(ExcelTest.ConnType.DedLine, 1);
			test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8");
			test.closeWorkbook();
	  }
	  
	  
	  @Test(groups = { "validation", "checkintest" })
	  public void method2() throws IOException{
			ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
			test.setOutputFile("/home/victor/Downloads/scenario_3_wrong_conn_type.xls");
			test.setDefaultExcelDataForDedicatedLine();

			test.setHowTheCUstWillConnect(ExcelTest.ConnType.VPN, ExcelTest.Choice.Yes);

			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "3.3.3.0");
			test.setNextHopAddress("1.1.1.1");
			test.setHowManyRoutes(ExcelTest.ConnType.DedLine, 1);
			test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8,170.225.181.240/28,170.225.180.240/28,170.225.180.200/29");

			test.setOutputFile("/home/victor/Downloads/scenario_3_wrong_conn_type_ssc_2.xls");
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "3.3.3.255");
			
			test.setOutputFile("/home/victor/Downloads/scenario_3_wrong_conn_type_ssc_3.xls");
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "3.3.3.");
			
			test.setOutputFile("/home/victor/Downloads/scenario_3_wrong_conn_type_ssc_4.xls");
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "3.3.3.3.4");
			test.closeWorkbook();
	  }

	  
	  @Test(groups = { "validation", "checkintest" })
	  public void method4() throws IOException{
			ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
			test.setOutputFile("/home/victor/Downloads/scenario_4_wrong_conn_type.xls");
			test.setDefaultExcelDataForDedicatedLine();
			
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.DedLine, "");
			test.setNextHopAddress("");
			test.setHowManyRoutes(ExcelTest.ConnType.DedLine, 1);
			test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8,170.225.181.240/28,170.225.180.240/28,170.225.180.200/29");
			test.closeWorkbook();
	  }
	  
	  
	  
	  @Test(groups = { "functest",})
	  public void method31() throws IOException{
		  System.out.println("gaga cel viteaz si marul otravit");
		  Assert.assertTrue("test", true);
		  Assert.assertEquals(true, true);
	  }

	  @Test(groups = { "functest2",})
	  public void method41() throws IOException{
		  Assert.assertTrue("test", true);
		  Assert.assertEquals(true, true);
		  System.out.println("ileana cosanzeana si marul muscat");
	  }
}
