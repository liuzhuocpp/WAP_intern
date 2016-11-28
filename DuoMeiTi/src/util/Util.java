package util;

 import javax.servlet.ServletContext;
 
 import org.apache.struts2.ServletActionContext;
 
public class Util
{
 	public static int calculatePostionId(int regionRow, int regionColumn, int shelf, int row, int column)
	{
		
		int ans = regionRow;
		
		ans = ans * 2 + regionColumn;
		ans = ans * 2 + shelf;
		ans = ans * 2 + row;
		ans = ans * 4 + column;
		return ans;
		
	}
	
 	public static String getRegion(int regionId)
 	{
 		final String[] array = {
 				"Daily necessities area",
 				"Beverage area",
 				"Wine area",
 				"Food area", 				
 		};

 		return array[regionId];
 	}
 	
	
	
	public static final String RootPath;
	

	

	
	
	static 
	{	
		ServletContext application = ServletActionContext.getServletContext();
		RootPath = application.getRealPath("");
	}

			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
