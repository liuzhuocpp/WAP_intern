package admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.Commodity;
import model.CommodityStatus;
import com.opensymphony.xwork2.ActionSupport;

public class CommodityPositionManagementAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private static List<Commodity> commodityData = new ArrayList<Commodity>();
	static
	{
		for(int i = 0; i < 64; ++ i)
		{
			String name = "Ice cream";
			if(i % 3 == 0)
			{
				name = "Mineral water";
			}
			if(i % 11 == 0)
			{
				name = "Coca-Cola";
			}
			name +=i;
			
			
			
			Commodity c = new Commodity(i, "Wipes", name,24.99	,"USD");
			
			if(i % 7 == 0)
			{
				c.setPositionId(i);
				c.setStatus(CommodityStatus.IN_SHELF);
			}
			commodityData.add(c);
		}
		commodityData.get(1).setName("Leather shoes");
		commodityData.get(2).setName("Shoe polish");
		commodityData.get(19).setName("Beer");
		commodityData.get(4).setName("Diaper");
		
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

	private String commodityIdArrayString;
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
		CommodityPositionManagementAction.commodityData = commodityData;
	}
	
	public String getCommodityIdArrayString() {
		return commodityIdArrayString;
	}
	
	public void setCommodityIdArrayString(String commodityIdArrayString) {
		this.commodityIdArrayString = commodityIdArrayString;
	}
	
	public List<Commodity> getCommodityPosition() {
		return commodityPosition;
	}
	
	public void setCommodityPosition(List<Commodity> commodityPosition) {
		this.commodityPosition = commodityPosition;
	}
}
