package homepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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

import model.Classroom;
import model.DutySchedule;
import model.StudentProfile;
import model.User;
import util.PageGetBaseAction;


public class HomeAction extends PageGetBaseAction
{	
	// enter!
	public String execute() throws Exception
	{ 
		System.out.println("请输入若干个数,每输入一个数用回车确认");
		System.out.println("最后输入一个非数字结束输入操作");
		
		InputStream in = null;
		try
		{
			System.out.println(util.Util.RootPath );
			in = new FileInputStream(util.Util.RootPath + "/jsp/homepage/in.txt");
//			in = new FileInputStream("/jsp/admin/HomepageModify/ResourceFileTable.jsp");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
            
		
		
		Scanner reader=new Scanner(in);
		double sum=0;
		int m=0;
		while(reader.hasNextDouble())
		{
		    double x=reader.nextDouble();
		    m=m+1;
		    sum=sum+x;
		}
		reader.close();
		System.out.printf("%d个数的和为%f\n",m,sum);
		System.out.printf("%d个数的平均值是%f\n",m,sum/m);

		
		
		
		
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public List check_list;
	public List notice_list;
	public List repair_list;
	public List file_path_list;
	public String file_path_html;
	public List deviceReplaceList;
	
	
	
////初始化SemesterFirstWeek表，保证SemesterFirstWeek里恰好有一条记录
//	static
//	{
//		Session s = model.Util.sessionFactory.openSession();
//		
//		List L = s.createCriteria(model.SemesterFirstWeek.class)
//				 .list();
//		if(L.size() == 0)
//		{
//			s.beginTransaction();
//			model.SemesterFirstWeek ins = new model.SemesterFirstWeek();
//			
//			ins.date = new java.sql.Date(new java.util.Date().getTime());
//			s.save(ins);
//			s.getTransaction().commit();
//		}
//		s.close();
//	}
//	
//	
//	static
//	{
//		Session session = model.Util.sessionFactory.openSession();		
//
//		
//		List L = session.createCriteria(model.AdminProfile.class).list();
//		if(L.size() == 0)
//		{
//			User user = new User();
//			user.setUsername("admin");
//			user.setPassword("admin");
//			
//			user.setFullName("full_admin");
//
//			model.AdminProfile ap = new model.AdminProfile();
//			ap.setUser(user);
//			
//			session.beginTransaction();
//			session.save(user);
//			session.save(ap);
//			session.getTransaction().commit();
//		}
//		
//		session.close();
//		
//	}

	
	List dutyStudentList;
	List<Classroom> notCheckClassroomStudentList;
	
	ArrayList<ArrayList<StudentProfile>> allNotCheckStudentList;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String resourceFile() throws Exception
	{	
		Session session = model.Util.sessionFactory.openSession();
		
		Criteria q = session.createCriteria(model.ResourceFilePath.class);
		
		
		file_path_list = q.list();
		
//		System.out.println("resourceFile========");
//		System.out.println(this.getCurrentPageNum());
//		file_path_list = this.makeCurrentPageList(q, 10); // 根据代表总体的Criteria 获取当前页元素的List，这个效率高，应尽量使用这个
//		file_path_list = this.makeCurrentPageList(q.list(), 10); //根据代表总体的List 获取当前页元素的List
		
		session.close();
		System.out.println("resourceFile========22222222");
//		if(this.getIsAjaxTransmission()) // 这是ajax 传输
//		{
//			System.out.println("ENTER?");
////			file_path_html = util.Util.getJspOutput("/jsp/admin/HomepageModify/ResourceFileTable.jsp");				
//			return "getPage";
//		}
		
		return ActionSupport.SUCCESS;
	}
	
	
	

	ArrayList<ArrayList<ArrayList<DutySchedule>> > dutyShowList;
	List dutyPlaceList;
	public String dutyShow() throws Exception
	{	
		Session session = model.Util.sessionFactory.openSession();
		
		dutyPlaceList = session.createCriteria(model.DutyPlace.class).list();
		List dutyScheduleList = session.createCriteria(model.DutySchedule.class).list();
		
		int place_size = dutyPlaceList.size();
		
		
		
		dutyShowList = new ArrayList<ArrayList<ArrayList<DutySchedule>> >();
		
		for(int i = 0; i < place_size; ++ i) 
		{
			ArrayList<ArrayList<DutySchedule>> tmp = new ArrayList<ArrayList<DutySchedule>>();
			for(int j = 0; j < 35; ++ j)
			{
				ArrayList<DutySchedule> tmp_ds = new ArrayList<DutySchedule>();
				tmp.add(tmp_ds);
			}
			dutyShowList.add(tmp);
		}
		
		
		
		for(int i = 0; i < dutyScheduleList.size(); ++ i)
		{
			DutySchedule ds = (DutySchedule)dutyScheduleList.get(i);
		
			dutyShowList.get(dutyPlaceList.indexOf(ds.dutyPiece.dutyPlace) )
						.get(ds.dutyPiece.time)
						.add(ds);
						
		}
		
		
		session.close();


		return ActionSupport.SUCCESS;
	}

	
	
	
	
	
	
/*	
 * 教室负责人表：
 */
//	List<Classroom> classroomList;
	ArrayList<ArrayList<Classroom> > classroomByPrinicpalList; 
	
	Map<String, ArrayList<Classroom>> classroomMap;
	public String classroomPincipalShow() throws Exception
	{
		
		Session s = model.Util.sessionFactory.openSession();
		List<Classroom> allClassroomList = s.createCriteria(model.Classroom.class)
											.addOrder(Order.asc("classroom_num"))
											.list();
		
		classroomMap = new TreeMap<String, ArrayList<Classroom>>();
		for(Classroom c : allClassroomList)
		{
			String teachBuildingName = c.teachbuilding.build_name;
			if(!classroomMap.containsKey(teachBuildingName))
			{
				classroomMap.put(teachBuildingName, new ArrayList<Classroom>());
			}
			
			List<Classroom> cntClassroomList = classroomMap.get(teachBuildingName);
			
			cntClassroomList.add(c);
		}
		
		
		
		
		
		s.close();
		return SUCCESS;
//		Session s = model.Util.sessionFactory.openSession();
//		List<Classroom> classroomList = 
//				s.createCriteria(model.Classroom.class)
//				.addOrder(Order.desc("principal"))
//				.add(Restrictions.isNotNull("principal"))
//				.list();
//		
//		
//		classroomByPrinicpalList = new ArrayList<ArrayList<Classroom> >();
//		
//		for(int i = 0, j; i < classroomList.size(); i = j)
//		{
//			for(j = i + 1; j < classroomList.size(); ++ j)
//			{
//				StudentProfile spi = classroomList.get(i).principal;
//				StudentProfile spj = classroomList.get(j).principal;
//				
//				if( (spi == null) ^ (spj == null) == true ||
//						(spi != null && spi.id != spj.id)
//
//						
//						)
//				break;
//			}
//			
//			ArrayList<Classroom> cntList = new ArrayList<Classroom>();
//			for(int k = i; k < j; ++ k)
//			{
//				cntList.add(classroomList.get(k));
//			}
//			classroomByPrinicpalList.add(cntList);
//			
//		}
//		
//		
//		
//		
//		
//		s.close();
//		return SUCCESS;
	}
	
	
	
	
	
	
	







	public ArrayList<ArrayList<Classroom>> getClassroomByPrinicpalList() {
		return classroomByPrinicpalList;
	}



	public void setClassroomByPrinicpalList(ArrayList<ArrayList<Classroom>> classroomByPrinicpalList) {
		this.classroomByPrinicpalList = classroomByPrinicpalList;
	}

	
	
	
	
	
	

//	public List<Classroom> getClassroomList() {
//		return classroomList;
//	}
//
//
//
//	public void setClassroomList(List<Classroom> classroomList) {
//		this.classroomList = classroomList;
//	}
//


	public Map<String, ArrayList<Classroom>> getClassroomMap() {
		return classroomMap;
	}



	public void setClassroomMap(Map<String, ArrayList<Classroom>> classroomMap) {
		this.classroomMap = classroomMap;
	}



	public List getDutyStudentList() {
		return dutyStudentList;
	}



	public void setDutyStudentList(List dutyStudentList) {
		this.dutyStudentList = dutyStudentList;
	}



	public ArrayList<ArrayList<ArrayList<DutySchedule>>> getDutyShowList() {
		return dutyShowList;
	}



	public void setDutyShowList(ArrayList<ArrayList<ArrayList<DutySchedule>>> dutyShowList) {
		this.dutyShowList = dutyShowList;
	}



	public List getDutyPlaceList() {
		return dutyPlaceList;
	}



	public void setDutyPlaceList(List dutyPlaceList) {
		this.dutyPlaceList = dutyPlaceList;
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



	public List<Classroom> getNotCheckClassroomStudentList() {
		return notCheckClassroomStudentList;
	}



	public void setNotCheckClassroomStudentList(List<Classroom> notCheckClassroomStudentList) {
		this.notCheckClassroomStudentList = notCheckClassroomStudentList;
	}



	public ArrayList<ArrayList<StudentProfile>> getAllNotCheckStudentList() {
		return allNotCheckStudentList;
	}



	public void setAllNotCheckStudentList(ArrayList<ArrayList<StudentProfile>> allNotCheckStudentList) {
		this.allNotCheckStudentList = allNotCheckStudentList;
	}
	
	
	


	
	
	
}










