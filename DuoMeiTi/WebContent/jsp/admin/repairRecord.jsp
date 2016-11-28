<%@ include file="/jsp/base/taglib.jsp" %>


<layout:override name="main_content">
<div class="mycontent">

<s:iterator   var="i" begin="0" end="1">
	
	<table class="table table-bordered table-hover" id="repairRecordTable">
	<tr class="active">
		<s:iterator  var="region" begin="0" end="1">
			<th>日用品区</th>
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
				
<%-- 				<s:if test="commodityPosition.get(#pid).status == @model.CommodityStatus@IN_SHELF"> --%>
<%-- 					<s:property value="commodityPosition.get(#pid).name"/> --%>
<%-- 				</s:if> --%>
<%-- 				<s:else> --%>
<%-- 					<input class="form-control" value="<s:property value="commodityPosition.get(#pid).id"/>" --%>
<!-- 						style="background-color:red;" -->
<!-- 					/> -->
<%-- 				</s:else> --%>
										
				
				
				
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



<button class="btn btn-primary" id="setButton"> Set </button>
<button class="btn btn-primary" id="openResetButon"> Open Reset </button>
<button class="btn btn-primary" id="closeResetButon"> Close Reset </button>
</div>



<script>

	$(document).on("click", "#openResetButon", function() {
		allCell = $("[commodityId]");
		for(var i = 0; i < allCell.length; ++ i)
		{
			cell = allCell[i];
			$(cell).html('<input class="form-control" value='+  $(cell).attr("commodityId")  +' />');
		}
		
	})


	$(document).on("click", "#setButton", function() {


// 		alert("IIII")
		
		
		
		allCell = $("[commodityId]");
// 		alert(allCell.length)
		var commodityIdArrayString="";
		for(var i = 0; i < allCell.length; ++ i)
		{
			cell = allCell[i];
			commodityId = $(cell).attr("commodityId");
			console.log(commodityId);
			var input = $(cell).find("input")
			if($(cell).find("input"))
			{ 
				commodityId = $(cell).find("input").val();
			}
			console.log(commodityId + "--");
			if(commodityIdArrayString != "") commodityIdArrayString += ","
			commodityIdArrayString += commodityId;			
			
		}
		alert(commodityIdArrayString);
// 		alert(commodityIdArrayString);
		

		
		
		$.ajax({  
	        url:'/admin/repairRecord_set' ,  
	        type: "POST",  
	        data: {
	        	"commodityIdArrayString":commodityIdArrayString,
	        },  
	          
	        success: function(data) {
	        	
	        	alert("Set Successfully")
	        	window.location.reload();
// 	        	alert(data.repairRecordTable)
	        	

	        }

	   });  
	}) 
	
	$(document).on("click", "#exportButton",function(){
		
		$.ajax({
			url:'/admin/repairRecord_export',
			type: "POST",
			data: {
				"selectDevice":$("#selectDevice").val(),
	        	"inputRepairman":$("#inputRepairman").val(),
	        	"selectTeachBuilding":$("#selectTeachBuilding").val(),
	        	"inputClassroom":$("#inputClassroom").val(),
	        	"inputBeginDate":$("#inputBeginDate").val(),
	        	"inputEndDate":$("#inputEndDate").val(),
			},
			
			success: function(data){
				$("#repairRecordTableDiv").html(data.repairRecordTable);
				window.open(data.exportPath);
				
			}
			
		});
	})

</script>






</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>






