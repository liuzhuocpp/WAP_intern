<%@ include file="/jsp/base/taglib.jsp"%>
<link rel="stylesheet" type="text/css" media="screen" href="/css/admin/repertory.css"/>
<layout:override name="main_content">

	<div class="mycontent">

		<div>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#rtModal" id="rtInsert" name="rtInsert">Add Commodity Information </button>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#rtModalImport" id="rtImport" name="rtImport">Import Commodity Information</button>
			<button class="btn btn-primary btn-lg"  id="rtExportExcel" name="rtExportExcel">Export Commodity Information</button>
		</div>
		
		<div class="modal fade" id="rtModalImport">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h2 class="modal-title" id="modal-title">Batch Import Commodity Information</h2>
					</div>
					<div class="modal-body">
 					<form class="form-inline well" id="import_repertory" enctype="multipart/form-data" method="post">
						<div class="row">
							<div class="form-group">
								<input type="file" name="excelFile" id="excelFile">
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-primary" id="rtUpload">
								<span class="glyphicon glyphicon-upload"></span>Upload</button>
							</div>
						</div>
					</form>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal" id="rtClose">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		
		<div id="repertoryTableDiv">
			<%@ include file="/jsp/admin/widgets/repertoryTable.jsp" %>
		</div>

		
 		<script type='text/javascript'  >

		//import excel
		$(document).on("click","#rtUpload",function() {
			var params = new FormData();
			params.append("file", document.getElementById("excelFile").files[0]);
			$.ajax({
				url: '/admin/commodity_importFile',
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

		</script>
		
	</div>
</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>