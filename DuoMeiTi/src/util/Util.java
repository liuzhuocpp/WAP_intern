package util;

 import java.util.ArrayList;
import java.util.List;

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
 				"Daily necessities region",
 				"Wine region",
 				"Drink region", 				
 				"Food region",
 		};

 		return array[regionId];
 	}
 	
	public static final String RootPath;
	
	static 
	{	
		ServletContext application = ServletActionContext.getServletContext();
		RootPath = application.getRealPath("");
	}
	
	public static List<String> splitCSVFormatRow(String row)
	{
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
		return array;
	}	
}
