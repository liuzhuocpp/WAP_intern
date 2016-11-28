



$(document).on("click", "#rtExportExcel", function() {
	
	$.ajax({
		url : 'repertory_exportExcel',
		type : 'post',
		dataType : 'json',
		data :
			{
			"selectDeviceType" :$("#selectDeviceType").val(),
			"selectDeviceStatus" :$("#selectDeviceStatus").val(),
			},
		success : function(data)
		{
			window.open(data.exportExcelPath);
			
			
		}
	});
})




 


//import excel
$(document).on("click","#rtUpload",function() {
	var params = new FormData();
	params.append("file", document.getElementById("excelFile").files[0]);
	$.ajax({
		url: '/admin/repertory_importExcel',
		type: "POST",  
        data: params,  
        async: true,  
        cache: false,  
        contentType: false,  
        processData: false,  
        success: importCallback,
	});
	
})

function importCallback(data) {
	
	window.location.reload();
	
}

