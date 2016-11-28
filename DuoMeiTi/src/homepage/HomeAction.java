package homepage;

 import java.util.ArrayList;
 import java.util.List;
 import com.opensymphony.xwork2.ActionSupport;

 

public class HomeAction extends ActionSupport
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
}
	


	
	






