package testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.ibm.Core.TestCase;
import com.ibm.netob.lib.*;

import org.junit.Assert;

public class TestCaseNo1 extends TestCase{
	
	
	
	  @Test(groups = { "functest", "checkintest" })
	  public void method1() throws IOException{
			ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
			test.setCustomerConnectToCMS("Internet Only");
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.INTONLY, ExcelTest.Choice.Yes.toString());
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.VPN, ExcelTest.Choice.No.toString());
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.NBOND, ExcelTest.Choice.No.toString());
			test.setConnectionWithDefRoute(ExcelTest.Choice.Yes.toString());
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.VPN, "3.3.3.3");
			test.setNextHopAddress("1.1.1.1");
			test.setHowManyRoutes(ExcelTest.ConnType.VPN, 10);
			test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8,170.225.181.240/28,170.225.180.240/28,170.225.180.200/29");
			test.enableCMSFirewall(ExcelTest.Choice.Yes.toString());
			test.hasLBaS(ExcelTest.Choice.Yes.toString());
			test.setSecurityZoneNumber(4);
			HashMap<String,String> details = new HashMap<>();
				
			details.put("Subnet","1.1.1.1");
			details.put("Mask","255.255.255.0");
			details.put("isVlbAttached","Yes");
			details.put("CustSpecifiedName","Gaga");
			test.setSecurityZoneDetails(4, details);
			test.closeWorkbook();
		  
	  }
	  @Test(groups = { "incomplete", "checkintest" })
	  public void method2() throws IOException{
			ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
			test.setCustomerConnectToCMS("Internet Only");
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.INTONLY, ExcelTest.Choice.Yes.toString());
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.VPN, ExcelTest.Choice.No.toString());
			test.setHowTheCUstWillConnect(ExcelTest.ConnType.NBOND, ExcelTest.Choice.No.toString());
			test.setConnectionWithDefRoute(ExcelTest.Choice.Yes.toString());
			test.setDefaultRouteDestinationNetwork(ExcelTest.ConnType.VPN, "3.3.3.3");
			test.setNextHopAddress("1.1.1.1");
			test.setHowManyRoutes(ExcelTest.ConnType.VPN, 10);
			test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8,170.225.181.240/28,170.225.180.240/28,170.225.180.200/29");
			test.enableCMSFirewall(ExcelTest.Choice.Yes.toString());
			test.hasLBaS(ExcelTest.Choice.Yes.toString());
			test.setSecurityZoneNumber(4);
			HashMap<String,String> details = new HashMap<>();
				
			details.put("Subnet","1.1.1.1");
			details.put("Mask","255.255.255.0");
			details.put("isVlbAttached","Yes");
			details.put("CustSpecifiedName","Gaga");
			test.setSecurityZoneDetails(4, details);
			test.closeWorkbook();
		  
	  }
	  
	  @Test(groups = { "functest",})
	  public void method3() throws IOException{
		  Assert.assertTrue("test", true);
		  Assert.assertEquals(true, false);
	  }

}
