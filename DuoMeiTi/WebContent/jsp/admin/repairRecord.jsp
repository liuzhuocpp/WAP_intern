<%@ include file="/jsp/base/taglib.jsp" %>


<layout:override name="main_content">
<div class="mycontent">

<div class="alert alert-success" role="alert">
	<strong>
	The white cell means a commodity's real position, and the yellow cell means a commodity's recommended position.
	</strong>
</div>


<button class="btn btn-primary" id="setButton"> Set </button>
<button class="btn btn-primary" id="openResetButon"> Open Recommend </button>
<button class="btn btn-primary" id="closeResetButon"> Close Recommend </button>

<s:iterator   var="i" begin="0" end="1">
	
	<table class="table table-bordered table-hover" id="repairRecordTable">
	<tr class="active">
		<s:iterator  var="region" begin="0" end="1">
			<th>
				<s:property value="@util.Util@getRegion(#i * 2 + #region)"/>
			</th>
		</s:iterator>
	</tr>
	
	<tr class="warning"  >
		<s:iterator  var="region" begin="0" end="1">
			<td > 
					<s:iterator var="shelf" begin="0" end="1">
						<table class="table table-bordered table-hover" >
							<tr>
								Shelf<s:property value="#shelf + 1"/>
							</tr>
							
							<s:iterator var="row" begin="0" end= "1">
								<tr >
										<s:iterator var="col" begin="0" end= "3">
										
										
										
					<s:set name="pid" value="@util.Util@calculatePostionId(#i, #region, #shelf, #row, #col)" />
										
										
					<td commodityId='<s:property value="commodityPosition.get(#pid).id"/>' 
						commodityName='<s:property value="commodityPosition.get(#pid).name"/>'
						positionId='<s:property value="#pid"/>'
					>

												
					<input class="form-control" value="<s:property value="commodityPosition.get(#pid).id"/>"
						<s:if test="commodityPosition.get(#pid).status != @model.CommodityStatus@IN_SHELF">
							style="background-color:yellow;"
						</s:if>
						<s:else>
						</s:else>
					/>
				<s:property value="commodityPosition.get(#pid).name"/>
				
				
				
											</td>
										</s:iterator>
								</tr>
							</s:iterator>
							
						</table>
						
					</s:iterator>
						
		
	     </td>
		</s:iterator>
		

	</tr>
</table>
	

</s:iterator>


</div>



<script>

	$(document).on("click", "#openResetButon", function() {
		allCell = $("[commodityId]");
		for(var i = 0; i < allCell.length; ++ i)
		{
			cell = allCell[i];
			var input = $(cell).find("input");
			if(i % 7 == 0 || i % 3 == 0)
			{
				$(input).css("background-color", "yellow");
			}
		}		
	})

	$(document).on("click", "#closeResetButon", function() {
		allCell = $("[commodityId]");
		for(var i = 0; i < allCell.length; ++ i)
		{
			cell = allCell[i];
			var input = $(cell).find("input");
			$(input).css("background-color", "");

		}		
	})

	$(document).on("click", "#setButton", function() {
		allCell = $("[commodityId]");
		var commodityIdArrayString="";
		for(var i = 0; i < allCell.length; ++ i)
		{
			cell = allCell[i];
			var input = $(cell).find("input")
			commodityId = $(input).val();
			if(commodityIdArrayString != "") commodityIdArrayString += ","
			commodityIdArrayString += commodityId;			
			
		}
		$.ajax({  
	        url:'/admin/commodityPosition_set' ,  
	        type: "POST",  
	        data: {
	        	"commodityIdArrayString":commodityIdArrayString,
	        },  
	          
	        success: function(data) {
	        	
	        	alert("Set Successfully")
	        	window.location.reload();
	        }

	   });  
	}) 
	

</script>






</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>






