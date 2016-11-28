package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
//import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import dto.T_Repertory;
import model.Classroom;
import model.RepairRecord;
//import jxl.Sheet;
//import jxl.Workbook;
import model.Commodity;
import util.Const;

public class RepertoryAction extends util.FileUploadBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//insert tag's name
	private int rtId;
	private String rtType;
	private String rtNumber;
	private String rtVersion;
	private String rtFactorynum;
	private String add_repertory_html;
	private String rtDevice;
	private java.util.Date rtProdDate;
	private java.util.Date rtApprDate;
	private String rtDeviceStatus;
	private int rtReplacePeriod;
	private int rtFilterCleanPeriod;
	private String rtFreqPoint;
	
	
	String repertoryTable;
	
	private String status;
	private List<Commodity> commodity_list;
	//search tag's name
//	private String sDevice;
//	private String sMainDevice;
//	private String sCostDevice;
//	private String sDeviceStatus;
	private List<T_Repertory> rtSearch_list = new ArrayList<T_Repertory>();
	
	private String repertory_table;
	
	//tag select func
	private String device[];
	private String mainDevice[];
	private String costDevice[];
	private String deviceStatus[];

	
	
	
	List deviceStatusHistoryList;
	
	String deviceStatusHistoryTable;
	
	public static java.sql.Timestamp addDays(java.util.Date d, int day)
	{
		return new java.sql.Timestamp(d.getTime() + day * 24*60 *60*1000);
	}

	// 按照成员字段构建一个Repertory 对象
	Commodity makeRepertory()
	{
		Commodity r = new Commodity();
		r.rtId = rtId;
		r.rtType = rtType;
		r.rtNumber = rtNumber;
		r.rtVersion = rtVersion;
		r.rtFactorynum = rtFactorynum;

		
		if(rtProdDate != null)
		r.rtProdDate = new java.sql.Timestamp(rtProdDate.getTime());
		
		if(rtApprDate != null)
		r.rtApprDate = new java.sql.Timestamp(rtApprDate.getTime());
		
		
		r.rtReplacePeriod = rtReplacePeriod;		
		r.rtDeadlineDate = addDays(new java.util.Date() , rtReplacePeriod);
		
		r.rtFilterCleanPeriod = rtFilterCleanPeriod;		
		r.rtFreqPoint = rtFreqPoint;


		// 新的设备状态一定不会是 ‘教室’状态，所以设置rtClassroom字段为null
		r.rtDeviceStatus = rtDeviceStatus;
		r.rtClassroom = null;
		return r;
	}
	

	
	
	
	private static List<Commodity> repertoryData;
	// Generate fake data
	static 
	{
		repertoryData = new ArrayList<Commodity>();
		repertoryData.add(new Commodity(1, "Wipes", "Huggies Natural Care Plus Wipes",24.99	,"USD") );
				

//		repertoryData.add()
	}
	
	
	
	
	public String execute() throws Exception{
		
		device = Const.device;
		mainDevice = Const.mainDevice;
		costDevice = Const.costDevice;
		
		deviceStatus = new String[5];
		deviceStatus[0] = Const.deviceStatus[0];
		deviceStatus[1] = Const.deviceStatus[1];
		deviceStatus[2] = Const.deviceStatus[3];
		deviceStatus[3] = Const.deviceStatus[4];
		deviceStatus[4] = Const.deviceStatus[2];
		commodity_list = repertoryData;
				
		return SUCCESS;
	}
	

	public String importExcel() throws Exception 
	{
		System.out.println("import excel");
		if(this.file == null)
		{
			return this.SUCCESS;
		}
		

		InputStream stream = new FileInputStream (this.file);
		Scanner scan = new Scanner(stream);
		scan.nextLine();
		while(scan.hasNext())
		{
			String row = scan.nextLine();

			List<String> array = new ArrayList<String>();
			String cnt="";
			boolean isIn = false;
			for(int i = 0; i < row.length(); ++ i)
			{
				if(row.charAt(i) == ',')
				{
					if(!isIn)
					{
						array.add(cnt);
						cnt="";
					}
					else 
					{
						cnt += ",";
					}
					
				}
				else if(row.charAt(i) == '\"')
				{					
					if(!isIn)
					{
						cnt="";
					}
					
					isIn ^= true;
				}
				else cnt += row.charAt(i);
			}
			
			array.add(cnt);
			System.out.println(row);

			System.out.println(array);
			Commodity r = new Commodity(Integer.parseInt(array.get(0)), array.get(1), array.get(2), 
									Double.parseDouble(array.get(3)), array.get(4));
			repertoryData.add(r);
		}
//		System.out.println(scan.nextLine());
//		System.out.println(scan.nextLine());
//		System.out.println(scan.nextLine());
		
		
		return SUCCESS;
	}
	
	int selectDeviceType;
	

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	public String getRtType() {
		return rtType;
	}

	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	public String getRtNumber() {
		return rtNumber;
	}

	public void setRtNumber(String rtNumber) {
		this.rtNumber = rtNumber;
	}

	public String getRtVersion() {
		return rtVersion;
	}

	public void setRtVersion(String rtVersion) {
		this.rtVersion = rtVersion;
	}

	public String getRtFactorynum() {
		return rtFactorynum;
	}

	public void setRtFactorynum(String rtFactorynum) {
		this.rtFactorynum = rtFactorynum;
	}

	public String getAdd_repertory_html() {
		return add_repertory_html;
	}

	public void setAdd_repertory_html(String add_repertory_html) {
		this.add_repertory_html = add_repertory_html;
	}

	public String getRtDevice() {
		return rtDevice;
	}

	public void setRtDevice(String rtDevice) {
		this.rtDevice = rtDevice;
	}

	public java.util.Date getRtProdDate() {
		return rtProdDate;
	}

	public void setRtProdDate(java.util.Date rtProdDate) {
		this.rtProdDate = rtProdDate;
	}

	public java.util.Date getRtApprDate() {
		return rtApprDate;
	}

	public void setRtApprDate(java.util.Date rtApprDate) {
		this.rtApprDate = rtApprDate;
	}

	public String getRtDeviceStatus() {
		return rtDeviceStatus;
	}

	public void setRtDeviceStatus(String rtDeviceStatus) {
		this.rtDeviceStatus = rtDeviceStatus;
	}

	public int getRtReplacePeriod() {
		return rtReplacePeriod;
	}

	public void setRtReplacePeriod(int rtReplacePeriod) {
		this.rtReplacePeriod = rtReplacePeriod;
	}

	public int getRtFilterCleanPeriod() {
		return rtFilterCleanPeriod;
	}

	public void setRtFilterCleanPeriod(int rtFilterCleanPeriod) {
		this.rtFilterCleanPeriod = rtFilterCleanPeriod;
	}

	public String getRtFreqPoint() {
		return rtFreqPoint;
	}

	public void setRtFreqPoint(String rtFreqPoint) {
		this.rtFreqPoint = rtFreqPoint;
	}

	public String getRepertoryTable() {
		return repertoryTable;
	}

	public void setRepertoryTable(String repertoryTable) {
		this.repertoryTable = repertoryTable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Commodity> getRepertory_list() {
		return commodity_list;
	}

	public void setRepertory_list(List<Commodity> repertory_list) {
		this.commodity_list = repertory_list;
	}


	public List<T_Repertory> getRtSearch_list() {
		return rtSearch_list;
	}

	public void setRtSearch_list(List<T_Repertory> rtSearch_list) {
		this.rtSearch_list = rtSearch_list;
	}

	public String getRepertory_table() {
		return repertory_table;
	}

	public void setRepertory_table(String repertory_table) {
		this.repertory_table = repertory_table;
	}

	public String[] getDevice() {
		return device;
	}

	public void setDevice(String[] device) {
		this.device = device;
	}

	public String[] getMainDevice() {
		return mainDevice;
	}

	public void setMainDevice(String[] mainDevice) {
		this.mainDevice = mainDevice;
	}

	public String[] getCostDevice() {
		return costDevice;
	}

	public void setCostDevice(String[] costDevice) {
		this.costDevice = costDevice;
	}

	public String[] getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String[] deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

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

	public int getSelectDeviceType() {
		return selectDeviceType;
	}

	public void setSelectDeviceType(int selectDeviceType) {
		this.selectDeviceType = selectDeviceType;
	}

	public String getSelectDeviceStatus() {
		return selectDeviceStatus;
	}

	public void setSelectDeviceStatus(String selectDeviceStatus) {
		this.selectDeviceStatus = selectDeviceStatus;
	}

	public String getExportExcelPath() {
		return exportExcelPath;
	}

	public void setExportExcelPath(String exportExcelPath) {
		this.exportExcelPath = exportExcelPath;
	}

	public List<Commodity> getCommodity_list() {
		return commodity_list;
	}

	public void setCommodity_list(List<Commodity> commodity_list) {
		this.commodity_list = commodity_list;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
