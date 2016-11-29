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
	private static Commodity makeRegionCommodity(int id, String region, String candidateName1, String candidateName2)
	{
		String name = candidateName1;
		if(id % 3 == 0)
		{
			name = candidateName2;
		}
		name += id;
		Commodity commodity = new Commodity(id, region, name, 24.99	,"USD");
		return commodity;
	}
	static
	{
		List<Commodity> dailyCommodityData = new ArrayList<Commodity>();
		List<Commodity> wineCommodityData = new ArrayList<Commodity>();
		List<Commodity> drinkCommodityData = new ArrayList<Commodity>();
		List<Commodity> foodCommodityData = new ArrayList<Commodity>();
		List<Commodity> otherCommodityData = new ArrayList<Commodity>();
		for(int i = 0; i < 16; ++ i)
		{
			dailyCommodityData.add(makeRegionCommodity(i, "Daily necessities", "Cup", "Gloves"));
			wineCommodityData.add(makeRegionCommodity(i + 16, "Wine", "Liquor", "Grape wine"));
			drinkCommodityData.add(makeRegionCommodity(i + 16 * 2, "Drink", "Coca Cola", "Pepsi"));
			foodCommodityData.add(makeRegionCommodity(i + 16 * 3, "Food", "Bread", "Hamburger"));
		}
		
		for(int i = 64; i < 1000; i += 4)
		{
			otherCommodityData.add(makeRegionCommodity(i, "Daily necessities", "Cup", "Gloves"));
			otherCommodityData.add(makeRegionCommodity(i + 1, "Wine", "Liquor", "Grape wine"));
			otherCommodityData.add(makeRegionCommodity(i + 2, "Drink", "Coca Cola", "Pepsi"));
			otherCommodityData.add(makeRegionCommodity(i + 3, "Food", "Bread", "Hamburger"));
		}
		
		commodityData.addAll(dailyCommodityData);
		commodityData.addAll(wineCommodityData);
		commodityData.addAll(drinkCommodityData);
		commodityData.addAll(foodCommodityData);
		commodityData.addAll(otherCommodityData);
		
		for(int i = 0; i < 64; ++ i)
		{
			if(i % 7 == 0)
			{
				commodityData.get(i).setPositionId(i);
				commodityData.get(i).setStatus(CommodityStatus.IN_SHELF);
			}
		}
		
		commodityData.get(1).setName("Leather shoes");
		commodityData.get(2).setName("Shoe polish");
		commodityData.get(4).setName("Diaper");	
		commodityData.get(19).setName("Beer");

		
//		for(int i = 0; i < 200; ++ i)
//		{
//			String name = "Ice cream";
//			if(i % 3 == 0)
//			{
//				name = "Mineral water";
//			}
//			if(i % 11 == 0)
//			{
//				name = "Coca-Cola";
//			}
//			name +=i;
//			
//			
//			
//			Commodity c = new Commodity(i, "Wipes", name,24.99	,"USD");
//			
//			if(i % 7 == 0  && i < 64)
//			{
//				c.setPositionId(i);
//				c.setStatus(CommodityStatus.IN_SHELF);
//			}
//			commodityData.add(c);
//		}
//		commodityData.get(1).setName("Leather shoes");
//		commodityData.get(2).setName("Shoe polish");
//		commodityData.get(19).setName("Beer");
//		commodityData.get(4).setName("Diaper");
		
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
			if(cpId == TOTAL_POSITION)
			{
				break;
			}
			commodityPosition.set(cpId, c);
			cpId++;
			
		}
		return ActionSupport.SUCCESS;
	}

	private String commodityIdArrayString;
	private String status;
	public String set() throws Exception
	{
		System.out.println("FFFssss");
		status = "";
		String[] commodityIdArray= commodityIdArrayString.split(",");
		Map<Integer, Integer> commodityIdToPositionId = new HashMap<Integer, Integer>();
		for(int i = 0;i < commodityIdArray.length; ++ i)
		{
			int commodityId = Integer.parseInt(commodityIdArray[i]);
			if(!(commodityId >= 0 && commodityId < commodityData.size()))
			{
				if(!status.isEmpty()) status +=",";
				status += commodityIdArray[i];
			}
			commodityIdToPositionId.put(Integer.parseInt(commodityIdArray[i]), i);
		}
		if(!status.isEmpty())
		{
			status = "The following commodities are not exist: " + status + "\nPlease check and re-enter";
			return SUCCESS;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
