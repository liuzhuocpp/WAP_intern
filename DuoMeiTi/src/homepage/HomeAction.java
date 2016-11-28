package homepage;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import util.PageGetBaseAction;


public class HomeAction extends PageGetBaseAction
{
	public List check_list = new ArrayList();
	public List notice_list = new ArrayList();
	public List repair_list = new ArrayList();
	public List file_path_list = new ArrayList();
	public String file_path_html;
	public List deviceReplaceList = new ArrayList();
	
 
	
	List dutyStudentList = new ArrayList();
	List notCheckClassroomStudentList = new ArrayList();
	
//	ArrayList<ArrayList<StudentProfile>> allNotCheckStudentList;
	public String execute() throws Exception
	{ 
		return ActionSupport.SUCCESS;
	}

	public List getCheck_list() {
		return check_list;
	}

	public void setCheck_list(List check_list) {
		this.check_list = check_list;
	}

	public List getNotice_list() {
		return notice_list;
	}

	public void setNotice_list(List notice_list) {
		this.notice_list = notice_list;
	}

	public List getRepair_list() {
		return repair_list;
	}

	public void setRepair_list(List repair_list) {
		this.repair_list = repair_list;
	}

	public List getFile_path_list() {
		return file_path_list;
	}

	public void setFile_path_list(List file_path_list) {
		this.file_path_list = file_path_list;
	}

	public String getFile_path_html() {
		return file_path_html;
	}

	public void setFile_path_html(String file_path_html) {
		this.file_path_html = file_path_html;
	}

	public List getDeviceReplaceList() {
		return deviceReplaceList;
	}

	public void setDeviceReplaceList(List deviceReplaceList) {
		this.deviceReplaceList = deviceReplaceList;
	}

	public List getDutyStudentList() {
		return dutyStudentList;
	}

	public void setDutyStudentList(List dutyStudentList) {
		this.dutyStudentList = dutyStudentList;
	}

	public List getNotCheckClassroomStudentList() {
		return notCheckClassroomStudentList;
	}

	public void setNotCheckClassroomStudentList(List notCheckClassroomStudentList) {
		this.notCheckClassroomStudentList = notCheckClassroomStudentList;
	}
	


	
	

//	ArrayList<ArrayList<ArrayList<DutySchedule>> > dutyShowList;
//	List dutyPlaceList;
//	public String dutyShow() throws Exception
//	{	
//		Session session = model.Util.sessionFactory.openSession();
//		
//		dutyPlaceList = session.createCriteria(model.DutyPlace.class).list();
//		List dutyScheduleList = session.createCriteria(model.DutySchedule.class).list();
//		
//		int place_size = dutyPlaceList.size();
//		
//		
//		
//		dutyShowList = new ArrayList<ArrayList<ArrayList<DutySchedule>> >();
//		
//		for(int i = 0; i < place_size; ++ i) 
//		{
//			ArrayList<ArrayList<DutySchedule>> tmp = new ArrayList<ArrayList<DutySchedule>>();
//			for(int j = 0; j < 35; ++ j)
//			{
//				ArrayList<DutySchedule> tmp_ds = new ArrayList<DutySchedule>();
//				tmp.add(tmp_ds);
//			}
//			dutyShowList.add(tmp);
//		}
//		
//		
//		
//		for(int i = 0; i < dutyScheduleList.size(); ++ i)
//		{
//			DutySchedule ds = (DutySchedule)dutyScheduleList.get(i);
//		
//			dutyShowList.get(dutyPlaceList.indexOf(ds.dutyPiece.dutyPlace) )
//						.get(ds.dutyPiece.time)
//						.add(ds);
//						
//		}
//		
//		
//		session.close();
//
//
//		return ActionSupport.SUCCESS;
//	}
//
//	
//	
//	
//	
//	
//	
///*	
// * 教室负责人表：
// */
////	List<Classroom> classroomList;
//	ArrayList<ArrayList<Classroom> > classroomByPrinicpalList; 
//	
//	Map<String, ArrayList<Classroom>> classroomMap;
//	public String classroomPincipalShow() throws Exception
//	{
//		
//		Session s = model.Util.sessionFactory.openSession();
//		List<Classroom> allClassroomList = s.createCriteria(model.Classroom.class)
//											.addOrder(Order.asc("classroom_num"))
//											.list();
//		
//		classroomMap = new TreeMap<String, ArrayList<Classroom>>();
//		for(Classroom c : allClassroomList)
//		{
//			String teachBuildingName = c.teachbuilding.build_name;
//			if(!classroomMap.containsKey(teachBuildingName))
//			{
//				classroomMap.put(teachBuildingName, new ArrayList<Classroom>());
//			}
//			
//			List<Classroom> cntClassroomList = classroomMap.get(teachBuildingName);
//			
//			cntClassroomList.add(c);
//		}
//		
//		
//		
//		
//		
//		s.close();
//		return SUCCESS;
//
//	}
//	
//	
//	
//	
//	
//	
//	
//
//
//
//
//
//
//
//	public ArrayList<ArrayList<Classroom>> getClassroomByPrinicpalList() {
//		return classroomByPrinicpalList;
//	}
//
//
//
//	public void setClassroomByPrinicpalList(ArrayList<ArrayList<Classroom>> classroomByPrinicpalList) {
//		this.classroomByPrinicpalList = classroomByPrinicpalList;
//	}
//
//	
//	
//	
//	
//	
//
//
//
//	public Map<String, ArrayList<Classroom>> getClassroomMap() {
//		return classroomMap;
//	}
//
//
//
//	public void setClassroomMap(Map<String, ArrayList<Classroom>> classroomMap) {
//		this.classroomMap = classroomMap;
//	}
//
//
//
//	public List getDutyStudentList() {
//		return dutyStudentList;
//	}
//
//
//
//	public void setDutyStudentList(List dutyStudentList) {
//		this.dutyStudentList = dutyStudentList;
//	}
//
//
//
//	public ArrayList<ArrayList<ArrayList<DutySchedule>>> getDutyShowList() {
//		return dutyShowList;
//	}
//
//
//
//	public void setDutyShowList(ArrayList<ArrayList<ArrayList<DutySchedule>>> dutyShowList) {
//		this.dutyShowList = dutyShowList;
//	}
//
//
//
//	public List getDutyPlaceList() {
//		return dutyPlaceList;
//	}
//
//
//
//	public void setDutyPlaceList(List dutyPlaceList) {
//		this.dutyPlaceList = dutyPlaceList;
//	}
//
//
//
//	public List getCheck_list() {
//		return check_list;
//	}
//
//	public void setCheck_list(List check_list) {
//		this.check_list = check_list;
//	}
//
//	public List getNotice_list() {
//		return notice_list;
//	}
//
//	public void setNotice_list(List notice_list) {
//		this.notice_list = notice_list;
//	}
//
//	public List getRepair_list() {
//		return repair_list;
//	}
//
//	public void setRepair_list(List repair_list) {
//		this.repair_list = repair_list;
//	}
//
//	public List getFile_path_list() {
//		return file_path_list;
//	}
//
//	public void setFile_path_list(List file_path_list) {
//		this.file_path_list = file_path_list;
//	}
//
//	public String getFile_path_html() {
//		return file_path_html;
//	}
//
//	public void setFile_path_html(String file_path_html) {
//		this.file_path_html = file_path_html;
//	}
//
//
//
//	public List getDeviceReplaceList() {
//		return deviceReplaceList;
//	}
//
//
//
//	public void setDeviceReplaceList(List deviceReplaceList) {
//		this.deviceReplaceList = deviceReplaceList;
//	}
//
//
//
//	public List<Classroom> getNotCheckClassroomStudentList() {
//		return notCheckClassroomStudentList;
//	}
//
//
//
//	public void setNotCheckClassroomStudentList(List<Classroom> notCheckClassroomStudentList) {
//		this.notCheckClassroomStudentList = notCheckClassroomStudentList;
//	}
//
//
//
//	public ArrayList<ArrayList<StudentProfile>> getAllNotCheckStudentList() {
//		return allNotCheckStudentList;
//	}
//
//
//
//	public void setAllNotCheckStudentList(ArrayList<ArrayList<StudentProfile>> allNotCheckStudentList) {
//		this.allNotCheckStudentList = allNotCheckStudentList;
//	}
//	
//	
//	
//

	
	
	
}










