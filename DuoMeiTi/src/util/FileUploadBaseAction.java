package util;


import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadBaseAction extends ActionSupport{
    
    public File file; //上传的文件
    public String fileFileName; //文件名称
    public String fileContentType; //文件类型
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
}