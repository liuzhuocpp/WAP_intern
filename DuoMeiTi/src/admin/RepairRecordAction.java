package admin;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.RepairRecord;
import model.Commodity;
import model.CommodityStatus;
import model.User;
import model.Classroom;
import model.TeachBuilding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.text.SimpleDateFormat;


public class RepairRecordAction extends ActionSupport {
	
	private static List<Commodity> commodityData = new ArrayList<Commodity>();
	static
	{
		for(int i = 0; i < 64; ++ i)
		{
			String name = "Beer";
			if(i % 3 == 0)
			{
				name = "Water";
			}
			if(i % 11 == 0)
			{
				name = "Coca-Cola";
			}
			name +=i;
			
			
			
			Commodity c = new Commodity(i, "Wipes",name,24.99	,"USD");
			
			if(i % 7 == 0)
			{
				c.setPositionId(i);
				c.setStatus(CommodityStatus.IN_SHELF);
			}
			commodityData.add(c);
		}
		
//		Collections.shuffle(commodityData);
	}
	
	private List<Commodity> commodityPosition = new ArrayList<Commodity>();
	private static int TOTAL_POSITION = 64;
	
	public String execute() throws Exception {		
		
		for(int i = 0; i < TOTAL_POSITION; ++ i)
		commodityPosition.add(null);
		for(Commodity c : commodityData)
		{
			if(c.getStatus() == CommodityStatus.IN_SHELF)
			{
				commodityPosition.set(c.getPositionId(), c);
			}
		}
		int cpId = 0;
		for(Commodity c : commodityData)
		{
			if(c.getStatus() == CommodityStatus.IN_SHELF) continue;
			for(;cpId < TOTAL_POSITION && commodityPosition.get(cpId) != null; cpId++);

			commodityPosition.set(cpId, c);
			cpId++;
			
		}
		return ActionSupport.SUCCESS;
	}




	public List<Commodity> getCommodityPosition() {
		return commodityPosition;
	}


	public void setCommodityPosition(List<Commodity> commodityPosition) {
		this.commodityPosition = commodityPosition;
	}
	
	
	
	
	
	private String commodityIdArrayString;
//	String inputRepairman;
//	String selectTeachingBuildingName;
//	String inputClassroom;
//	
//	
//	java.util.Date inputBeginDate;
//	java.util.Date inputEndDate;
//	
//	String repairRecordTable; 
//	String exportPath;
//	List repairRecordList;
//	
	public String set() throws Exception
	{
		System.out.println("FFFssss");
		
		String[] commodityIdArray= commodityIdArrayString.split(",");
		Map<Integer, Integer> commodityIdToPositionId = new HashMap<Integer, Integer>();
		for(int i = 0;i < commodityIdArray.length; ++ i)
		{
			commodityIdToPositionId.put(Integer.parseInt(commodityIdArray[i]), i);

		}
		
		for(Commodity commodity: commodityData)
		{
//			Commodity commodity = commodityData.get(i);
			if(commodityIdToPositionId.containsKey(commodity.getId()))
			{
				commodity.setStatus(CommodityStatus.IN_SHELF);
				commodity.setPositionId(commodityIdToPositionId.get(commodity.getId()));
			}
		}
		
		
		return SUCCESS;
		
	}




	public static List<Commodity> getCommodityData() {
		return commodityData;
	}




	public static void setCommodityData(List<Commodity> commodityData) {
		RepairRecordAction.commodityData = commodityData;
	}




	public String getCommodityIdArrayString() {
		return commodityIdArrayString;
	}




	public void setCommodityIdArrayString(String commodityIdArrayString) {
		this.commodityIdArrayString = commodityIdArrayString;
	}
	
	
//	
//	
//	public String export() throws Exception
//	{
//		System.out.println("abc");
//		this.search();
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet();
//		try{
//			HSSFRow row0 = sheet.createRow(0);
//			HSSFCell cell = row0.createCell(0);
//			cell.setCellValue(new HSSFRichTextString("设备"));
//			cell = row0.createCell(1);
//			cell.setCellValue(new HSSFRichTextString("维修人"));
//			cell = row0.createCell(2);
//			cell.setCellValue(new HSSFRichTextString("教学楼"));
//			cell = row0.createCell(3);
//			cell.setCellValue(new HSSFRichTextString("教室"));
//			cell = row0.createCell(4);
//			cell.setCellValue(new HSSFRichTextString("维修内容"));
//			cell = row0.createCell(5);
//			cell.setCellValue(new HSSFRichTextString("维修时间"));
//			for(int i=0; i<repairRecordList.size(); i++){
//				HSSFRow row = sheet.createRow(i+1);
//				List<RepairRecord> RestrictionsList = repairRecordList;
//				RepairRecord r = RestrictionsList.get(i); 
//				
//				cell = row.createCell(0);
//				cell.setCellValue(r.getDeviceType());
//				
//				cell = row.createCell(1);
//				cell.setCellValue(r.getRepairmanFullName());
//				
//				cell = row.createCell(2);
//				cell.setCellValue(r.getTeachingBuildingName());
//				
//				cell = row.createCell(3);
//				cell.setCellValue(r.getClassroomName());
//
//				cell = row.createCell(4);
//				cell.setCellValue(r.getRepairdetail());
//				
//				cell = row.createCell(5);				
//				cell.setCellValue(util.Util.formatTimestamp(r.repairdate));
//			}
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
////		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
////		String FileName = now.toString() + "设备维修记录.xls"; 
////		exportPath = util.Util.RecordExportPath + FileName;
////		OutputStream out = new FileOutputStream(util.Util.RootPath + util.Util.RecordExportPath + FileName);
//		
//		
//		
//		exportPath = util.Util.RecordExportPath +  "设备维修记录.xls";
//		OutputStream out = new FileOutputStream(util.Util.RootPath + exportPath);
//		
//		workbook.write(out);
//		workbook.close();
//		out.close();
//		return SUCCESS;
//	}
//	
//	public int getSelectDevice() {
//		return selectDevice;
//	}
//	public void setSelectDevice(int selectDevice) {
//		this.selectDevice = selectDevice;
//	}
//	public String getInputRepairman() {
//		return inputRepairman;
//	}
//	public void setInputRepairman(String inputRepairman) {
//		this.inputRepairman = inputRepairman;
//	}
//	
//public String getSelectTeachingBuildingName() {
//		return selectTeachingBuildingName;
//	}
//
//
//	public void setSelectTeachingBuildingName(String selectTeachingBuildingName) {
//		this.selectTeachingBuildingName = selectTeachingBuildingName;
//	}
//
//
//	//	public int getSelectTeachBuilding() {
////		return selectTeachBuilding;
////	}
////	public void setSelectTeachBuilding(int selectTeachBuilding) {
////		this.selectTeachBuilding = selectTeachBuilding;
////	}
//	public String getInputClassroom() {
//		return inputClassroom;
//	}
//	public void setInputClassroom(String inputClassroom) {
//		this.inputClassroom = inputClassroom;
//	}
//
//	
//	
//	public java.util.Date getInputBeginDate() {
//		return inputBeginDate;
//	}
//
//
//
//
//	public void setInputBeginDate(java.util.Date inputBeginDate) {
//		this.inputBeginDate = inputBeginDate;
//	}
//
//
//
//
//
//	public java.util.Date getInputEndDate() {
//		return inputEndDate;
//	}
//
//
//
//
//	public void setInputEndDate(java.util.Date inputEndDate) {
//		this.inputEndDate = inputEndDate;
//	}
//
//
//
//
//	public String getRepairRecordTable() {
//		return repairRecordTable;
//	}
//	public void setRepairRecordTable(String repairRecordTable) {
//		this.repairRecordTable = repairRecordTable;
//	}
//	public List getRepairRecordList() {
//		return repairRecordList;
//	}
//	public void setRepairRecordList(List repairRecordList) {
//		this.repairRecordList = repairRecordList;
//	}
//	
//	public String getExportPath(){
//		return exportPath;
//	}
//	
//	public void setExportPath(String exportPath){
//		this.exportPath = exportPath;
//	}
	
	
	
	


	}
