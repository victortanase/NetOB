package com.ibm.netob.lib;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class ExcelTest {
	
	//Overall Network Connectivity
	private static final int ONC_CUST_CONNTYPE_ROW = 73;
	private static final int ONC_CUST_CONNTYPE_COL = 2;
	private static final int YES_NO_FOR_CONNECTION_TYPE_ROW = 77;
	private static final int YES_NO_FOR_CONNECTION_TYPE_COL_VPN = 2;
	private static final int YES_NO_FOR_CONNECTION_TYPE_COL_DLINE = 4;
	private static final int YES_NO_FOR_CONNECTION_TYPE_COL_NBOND = 5;
	private static final int YES_NO_FOR_CONNECTION_TYPE_COL_INTONLY = 7;
	//Routing
	private static final int HAS_DEF_ROUTE_ROW = 85;
	private static final int HAS_DEF_ROUTE_COL_VPN = 2;
	private static final int HAS_DEF_ROUTE_COL_DLINE = 4;
	private static final int HAS_DEF_ROUTE_COL_ATT = 5;
	private static final int HAS_DEF_ROUTE_COL_INTONLY = 7;

	private static final int DEST_NET_ROUTE_ROW = 86;
	private static final int DEST_NET_ROUTE_COL_VPN = 2;
	private static final int DEST_NET_ROUTE_COL_LINE = 4;
	private static final int DEST_NET_ROUTE_COL_NBOND = 5;
	private static final int DEST_NET_ROUTE_COL_INTONLY = 7;

	private static final int NEXT_HOP_ADDR_ROW = 87;
	private static final int NEXT_HOP_ADDR_COL_LINE = 4;
	private static final int HOW_MANY_ROUTES_ROW = 88;
	private static final int HOW_MANY_ROUTES_COL_VPN = 2;
	private static final int HOW_MANY_ROUTES_COL_LINE = 4;
	private static final int HOW_MANY_ROUTES_COL_NBOND = 5;
	private static final int HOW_MANY_ROUTES_COL_INTONLY = 7;
	private static final int CMS_ROUTES_TOFORWARD_ROW = 161;
	private static final int CMS_ROUTES_TOFORWARD_COL = 2;

	//CMS Secuity and Load Balancing
	private static final int CMS_REQ_FIREWALL_ROW = 164;
	private static final int CMS_REQ_FIREWALL_COL = 2;

	private static final int CMS_HAS_LBAAS_ROW = 167;
	private static final int CMS_HAS_LBAAS_COL = 2;
	
	//Internet Connectivity
	private static final int CMS_REQUIRE_INTERNET_ROW = 172;
	private static final int CMS_REQUIRE_INTERNET_COL = 2;
	private static final int HOW_MANY_IP_ADDRESS_ROW = 173;
	private static final int HOW_MANY_IP_ADDRESS_COL = 2;
	private static final int HOW_MANY_LBAAS_IP_ADDRESS_ROW = 174;
	private static final int HOW_MANY_LBAAS_IP_ADDRESS_COL = 2;
	private static final int CMS_IP_ADDRESS_ASSIGNED_ROW = 175;
	private static final int CMS_IP_ADDRESS_ASSIGNED_COL = 2;
	
	//Security Zones
	private static final int NR_OF_SEC_ZONES_ROW = 183;
	private static final int NR_OF_SEC_ZONES_COL = 2;
	
	//Security Zones Details
	private static final int SEC_ZONE_DET_ROW = 186;
	private static final int SEC_ZONE_DET_SUBNET_COL = 2;
	private static final int SEC_ZONE_DET_MASK_COL = 4;
	private static final int SEC_ZONE_DET_DEF_NAME_COL = 4;
	private static final int SEC_ZONE_DET_VLB_ATTACHED_COL = 6;
	private static final int SEC_ZONE_DET_CUST_ZONE_NAME_COL = 7;
	
	private File file_1;
	private File outFile;
	private FileInputStream file;
	private HSSFWorkbook workbook;
	private HSSFSheet genReqSheet;
	
	public enum Choice {Yes, No};
	public enum ConnType {	VPN,
		DedLine,
		NBOND,
		INTONLY;
	}

	public ExcelTest(String filename){
		workbook = this.getWorksheet(filename);
		genReqSheet = workbook.getSheet("General Requirements");
		outFile = new File("/home/victor/Downloads/fortest992.xls");
	}

	public void setOutputFile(String path){
		outFile = new File(path);
	}
	public HSSFWorkbook getWorksheet(String filename){
		file_1 = new File(filename);
		
		try {
			file = new FileInputStream(file_1);
			workbook = new HSSFWorkbook(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return workbook;
	}

	public void setCustomerConnectToCMS(String connType) throws IOException{

		HSSFRow row = genReqSheet.getRow(ONC_CUST_CONNTYPE_ROW);
		HSSFCell cell = row.getCell(ONC_CUST_CONNTYPE_COL);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue(connType);
		this.writeToFile();
	}

	public void setHowTheCUstWillConnect(ConnType connType, Choice val) throws IOException{
		HSSFRow row = genReqSheet.getRow(YES_NO_FOR_CONNECTION_TYPE_ROW);
		int colNr =0;
		switch(connType){
		case VPN:
			colNr = YES_NO_FOR_CONNECTION_TYPE_COL_VPN;
			break;
		case DedLine: 
			colNr = YES_NO_FOR_CONNECTION_TYPE_COL_DLINE;
			break;
		case NBOND: 
			colNr = YES_NO_FOR_CONNECTION_TYPE_COL_NBOND;
			break;
		case INTONLY: 
			colNr = YES_NO_FOR_CONNECTION_TYPE_COL_INTONLY;
			break;
		}
		HSSFCell cell = row.getCell(colNr);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue(val.toString());
		this.writeToFile();
	}

	public void setConnectionWithDefRoute(ConnType connType, Choice val) throws IOException{
		HSSFRow row = genReqSheet.getRow(HAS_DEF_ROUTE_ROW);
		
		int colNr =0;
		switch(connType){
		case VPN:
			colNr = HAS_DEF_ROUTE_COL_VPN;
			break;
		case DedLine: 
			colNr = HAS_DEF_ROUTE_COL_DLINE;
			break;
		case NBOND: 
			colNr = HAS_DEF_ROUTE_COL_ATT;
			break;
		case INTONLY: 
			colNr = HAS_DEF_ROUTE_COL_INTONLY;
			break;
			
		}
		HSSFCell cell = row.getCell(colNr);
		cell.setCellValue(val.toString());
		this.writeToFile();
	}

	public void setDefaultRouteDestinationNetwork(ConnType connType, String value) throws IOException{
		HSSFRow row = genReqSheet.getRow(DEST_NET_ROUTE_ROW);

		int colNr =0;
		switch(connType){
		case VPN:
			colNr = DEST_NET_ROUTE_COL_VPN;
			break;
		case DedLine: 
			colNr = DEST_NET_ROUTE_COL_LINE;
			break;
		case NBOND: 
			colNr = DEST_NET_ROUTE_COL_NBOND;
			break;
		case INTONLY: 
			colNr = DEST_NET_ROUTE_COL_INTONLY;
			break;
			
		}
		HSSFCell cell = row.getCell(colNr);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue(value);
		this.writeToFile();
	}

	public void setNextHopAddress(String value) throws IOException{
		HSSFRow row = genReqSheet.getRow(NEXT_HOP_ADDR_ROW);
		HSSFCell cell = row.getCell(NEXT_HOP_ADDR_COL_LINE);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue(value);
		this.writeToFile();
		
	}

	public void setHowManyRoutes(ConnType connType, int value) throws IOException{
		int colNr = 0;
		HSSFRow row = genReqSheet.getRow(HOW_MANY_ROUTES_ROW);
		switch(connType){
		case VPN:
			colNr = HOW_MANY_ROUTES_COL_VPN;
			break;
		case DedLine: 
			colNr = HOW_MANY_ROUTES_COL_LINE;
			break;
		case NBOND: 
			colNr = HOW_MANY_ROUTES_COL_NBOND;
			break;
		case INTONLY: 
			colNr = HOW_MANY_ROUTES_COL_INTONLY;
			break;
			
		}
		HSSFCell cell = row.getCell(colNr);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue(value);
		this.writeToFile();
	}

	public void routesCMSWillFwToFrontB(String ipList) throws IOException{
		HSSFRow row = genReqSheet.getRow(CMS_ROUTES_TOFORWARD_ROW);
		HSSFCell cell = row.getCell(CMS_ROUTES_TOFORWARD_COL);
		String [] strg = ipList.split(",");
		StringBuilder str =new StringBuilder();
		for (String i :strg){
			str.append(i+StringUtils.repeat(" ", 40));
		}
		cell.setCellValue(str.toString());
		this.writeToFile();		
	}

	public void enableCMSFirewall(String val) throws IOException{
		HSSFRow row = genReqSheet.getRow(CMS_REQ_FIREWALL_ROW);
		HSSFCell cell = row.getCell(CMS_REQ_FIREWALL_COL);
		cell.setCellValue(val);
		this.writeToFile();
	}

	public void hasLBaS(String val) throws IOException{
		HSSFRow row = genReqSheet.getRow(CMS_HAS_LBAAS_ROW);
		HSSFCell cell = row.getCell(CMS_HAS_LBAAS_COL);
		cell.setCellValue(val);
		this.writeToFile();
	}

	public void CMSRequireInternet(Choice val) throws IOException{
		HSSFRow row = genReqSheet.getRow(CMS_REQUIRE_INTERNET_ROW);
		HSSFCell cell = row.getCell(CMS_REQUIRE_INTERNET_COL);
		cell.setCellValue(val.toString());
		this.writeToFile();
	}

	public void howManyPublicIpNeeded(String val) throws IOException{
		HSSFRow row = genReqSheet.getRow(HOW_MANY_IP_ADDRESS_ROW);
		HSSFCell cell = row.getCell(HOW_MANY_IP_ADDRESS_COL);
		cell.setCellValue(val);
		this.writeToFile();
	}

	public void howManyLBaSPublicIpNeeded(String val) throws IOException{
		HSSFRow row = genReqSheet.getRow(HOW_MANY_LBAAS_IP_ADDRESS_ROW);
		HSSFCell cell = row.getCell(HOW_MANY_LBAAS_IP_ADDRESS_COL);
		cell.setCellValue(val);
		this.writeToFile();
	}
	
	public void configureIPAddressFromMND(String val) throws IOException{
		HSSFRow row = genReqSheet.getRow(CMS_IP_ADDRESS_ASSIGNED_ROW);
		HSSFCell cell = row.getCell(CMS_IP_ADDRESS_ASSIGNED_COL);
		cell.setCellValue(val);
		this.writeToFile();
	}
	
	public void setSecurityZoneNumber(int nrOfZones) throws IOException{
		HSSFRow row = genReqSheet.getRow(NR_OF_SEC_ZONES_ROW);
		HSSFCell cell = row.getCell(NR_OF_SEC_ZONES_COL);
		cell.setCellValue(nrOfZones);
		this.writeToFile();		
	}
	
	public void setSecurityZoneDetails(int nrOfZones, 
			List<HashMap<String,String>> lista) throws IOException{
		int rowNr = SEC_ZONE_DET_ROW;
		for (int i=0; i< nrOfZones; i++){
			HashMap<String,String> details = lista.remove(0);
			HSSFRow row = genReqSheet.getRow(rowNr);
			row.setZeroHeight(false);
			HSSFCell cell = row.getCell(SEC_ZONE_DET_SUBNET_COL);
			cell.setCellValue(details.get("Subnet"));
			cell = row.getCell(SEC_ZONE_DET_MASK_COL);
			cell.setCellValue(details.get("Mask"));
			cell = row.getCell(SEC_ZONE_DET_VLB_ATTACHED_COL);
			cell.setCellValue(details.get("isVlbAttached"));
			cell = row.getCell(SEC_ZONE_DET_CUST_ZONE_NAME_COL);
			cell.setCellValue(details.get("CustSpecifiedName"));
			rowNr++;
		}
		this.writeToFile();	
	}
	
	public void setDefaultExcelDataForDedicatedLine() throws IOException{
		setCustomerConnectToCMS("Dedicated Line");
		setHowTheCUstWillConnect(ExcelTest.ConnType.INTONLY, ExcelTest.Choice.No);
		setHowTheCUstWillConnect(ExcelTest.ConnType.VPN, ExcelTest.Choice.No);
		setHowTheCUstWillConnect(ExcelTest.ConnType.DedLine, ExcelTest.Choice.Yes);
		setHowTheCUstWillConnect(ExcelTest.ConnType.NBOND, ExcelTest.Choice.No);
		
		setConnectionWithDefRoute(ExcelTest.ConnType.VPN,ExcelTest.Choice.No);
		setConnectionWithDefRoute(ExcelTest.ConnType.DedLine,ExcelTest.Choice.Yes);	
		enableCMSFirewall(ExcelTest.Choice.No.toString());
		CMSRequireInternet(ExcelTest.Choice.No);
		hasLBaS(ExcelTest.Choice.No.toString());
		setConnectionWithDefRoute(ExcelTest.ConnType.VPN,ExcelTest.Choice.No);
	    setConnectionWithDefRoute(ExcelTest.ConnType.DedLine,ExcelTest.Choice.Yes);
		setSecurityZoneNumber(1);
		HashMap<String,String> details = new HashMap<>();
		List<HashMap<String,String>> lista =new ArrayList<>();
		
		details.put("Subnet","172.20.80.11");
		details.put("Mask","255.255.255.0");
		details.put("isVlbAttached","Yes");
		details.put("CustSpecifiedName","zona1");
		lista.add(details);
		setSecurityZoneDetails(1, lista);
	}
	
	public void writeToFile() throws IOException{
		FileOutputStream fileout = null;
		try{
			fileout = new FileOutputStream(outFile);
			workbook.unwriteProtectWorkbook();
			workbook.write(fileout);
		}
		finally{
			if(fileout != null){
				fileout.close();
			}
		}
	}
	
	public void closeWorkbook() throws IOException{
		workbook.close();
	}
	
	public static void main(String [] args) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		ExcelTest test = new ExcelTest("/home/victor/Downloads/fortest1.xls");
		test.setCustomerConnectToCMS("Internet Only");
		test.setHowTheCUstWillConnect(ConnType.INTONLY, Choice.Yes);
		test.setHowTheCUstWillConnect(ConnType.VPN, Choice.No);
		test.setHowTheCUstWillConnect(ConnType.NBOND, Choice.No);
		test.setConnectionWithDefRoute(ConnType.INTONLY, Choice.Yes);
		test.setDefaultRouteDestinationNetwork(ConnType.VPN, "3.3.3.3");
		test.setNextHopAddress("1.1.1.1");
		test.setHowManyRoutes(ConnType.VPN, 10);
		test.routesCMSWillFwToFrontB("19.16.0.0/16,172.16.0.0/12,10.0.0.0/8,170.225.181.240/28,170.225.180.240/28,170.225.180.200/29");
		test.enableCMSFirewall(Choice.Yes.toString());
		test.hasLBaS(Choice.Yes.toString());
		test.setSecurityZoneNumber(4);
		HashMap<String,String> details = new HashMap<>();
		List<HashMap<String,String>> lista =new ArrayList<>();
		
		details.put("Subnet","172.20.80.11");
		details.put("Mask","255.255.255.0");
		details.put("isVlbAttached","Yes");
		details.put("CustSpecifiedName","zona1");
		lista.add(details);
		details.put("Subnet","172.20.80.12");
		details.put("CustSpecifiedName","zona2");
		lista.add(details);
		test.setSecurityZoneDetails(2, lista);
		test.workbook.close();
	}
}
