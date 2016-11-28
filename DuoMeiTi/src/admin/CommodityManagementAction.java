package admin;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
import model.Commodity;

public class CommodityManagementAction extends util.FileUploadBaseAction{
	private static final long serialVersionUID = 1L;
	private List<Commodity> commodity_list;

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
	

	public String importFile() throws Exception 
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
