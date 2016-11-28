package admin;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
import model.Commodity;
//import util.Const;

public class CommodityManagementAction extends util.FileUploadBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Commodity> commodity_list;
// 	private List<T_Repertory> rtSearch_list = new ArrayList<T_Repertory>();
	
	private String repertory_table;
 	
	
	
	List deviceStatusHistoryList;
	
	String deviceStatusHistoryTable;
	
	public static java.sql.Timestamp addDays(java.util.Date d, int day)
	{
		return new java.sql.Timestamp(d.getTime() + day * 24*60 *60*1000);
	}

 
	
	
	
	private static List<Commodity> commodityData;
	// Generate fake data
	static 
	{
		commodityData = new ArrayList<Commodity>();
		commodityData.add(new Commodity(1, "Wipes", "Huggies Natural Care Plus Wipes",24.99	,"USD") );
				
	}
	
	
	
	
	public String execute() throws Exception{
		commodity_list = commodityData;
				
		return SUCCESS;
	}
	

	public String importExcel() throws Exception 
	{
		System.out.println("batch import");
		if(this.file == null)
		{
			return SUCCESS;
		}
		

		InputStream stream = new FileInputStream (this.file);
		Scanner scan = new Scanner(stream);
		scan.nextLine();
		while(scan.hasNext())
		{
			String row = scan.nextLine();

			List<String> array = util.Util.splitCSVFormatRow(row);
			System.out.println(row);

			System.out.println(array);
			Commodity r = new Commodity(Integer.parseInt(array.get(0)), array.get(1), array.get(2), 
									Double.parseDouble(array.get(3)), array.get(4));
			commodityData.add(r);
		}
		scan.close();
		
		
		return SUCCESS;
	}
	
	List<Commodity> getRepertory_list() {
		return commodity_list;
	}

	public void setRepertory_list(List<Commodity> repertory_list) {
		this.commodity_list = repertory_list;
	}


//	public List<T_Repertory> getRtSearch_list() {
//		return rtSearch_list;
//	}
//
//	public void setRtSearch_list(List<T_Repertory> rtSearch_list) {
//		this.rtSearch_list = rtSearch_list;
//	}

	public String getRepertory_table() {
		return repertory_table;
	}

	public void setRepertory_table(String repertory_table) {
		this.repertory_table = repertory_table;
	}

//	public String[] getDevice() {
//		return device;
//	}
//
//	public void setDevice(String[] device) {
//		this.device = device;
//	}
//
//	public String[] getMainDevice() {
//		return mainDevice;
//	}
//
//	public void setMainDevice(String[] mainDevice) {
//		this.mainDevice = mainDevice;
//	}
//
//	public String[] getCostDevice() {
//		return costDevice;
//	}
//
//	public void setCostDevice(String[] costDevice) {
//		this.costDevice = costDevice;
//	}
//
//	public String[] getDeviceStatus() {
//		return deviceStatus;
//	}
//
//	public void setDeviceStatus(String[] deviceStatus) {
//		this.deviceStatus = deviceStatus;
//	}

	public List getDeviceStatusHistoryList() {
		return deviceStatusHistoryList;
	}

	public void setDeviceStatusHistoryList(List deviceStatusHistoryList) {
		this.deviceStatusHistoryList = deviceStatusHistoryList;
	}

	public String getDeviceStatusHistoryTable() {
		return deviceStatusHistoryTable;
	}

	public void setDeviceStatusHistoryTable(String deviceStatusHistoryTable) {
		this.deviceStatusHistoryTable = deviceStatusHistoryTable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<Commodity> getCommodity_list() {
		return commodity_list;
	}

	public void setCommodity_list(List<Commodity> commodity_list) {
		this.commodity_list = commodity_list;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}