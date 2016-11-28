<%@ include file="/jsp/base/taglib.jsp"%>
<link rel="stylesheet" type="text/css" media="screen" href="/css/admin/repertory.css"/>
<layout:override name="main_content">

	<div class="mycontent">

		<div>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#rtModal" id="rtInsert" name="rtInsert">添加设备信息</button>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#rtModalImport" id="rtImport" name="rtImport">导入设备xls表</button>
			<button class="btn btn-primary btn-lg"  id="rtExportExcel" name="rtExportExcel">导出设备xls表</button>
			
			
		</div>
 


 		
		
		
		<div class="modal fade" id="rtModalImport">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h2 class="modal-title" id="modal-title">设备信息导入</h2>
					</div>
					<div class="modal-body">
					<div class="alert alert-danger" role="alert">导入Excel表格要求：
						<br>1.&nbsp; 从第一列开始每列设备字段分别为:
						
						<!--0-->
						<br>第0列：设备名称（必须与约定设备名称一致）、						
						<!--1-->
						<br>第1列：资产编号、						
						<!--2-->
						<br>第2列：型号、						
						<!--3-->
						<br>第3列：出厂日期（日期格式yyyy-mm-dd）、						
						<!--4-->
						<br>第4列：审批日期、
						<!--5-->
						<br>第5列：出厂号、
						<!--6-->
						<br>第6列：使用状态（备用、教室、维修、报废）、
						<!--7-->
						<br>第7列：教学楼、
						<!--8-->
						<br>第8列：教室号、
						<!--9-->
						<br>第9列：更换时间、
						<!--10-->
						<br>第10列：频点、
						<!--11-->
						<br>第11列：过滤网更换时间。
						
						<br>&nbsp;&nbsp;2.&nbsp;只读取Excel表格中第一个工作簿。第一行为字段名，第二行开始为数据内容。所有数据必须为文本格式，尤其是日期。 <br>&nbsp;&nbsp;3.&nbsp;若表中有空行，则空行之后的数据会被舍弃。</div>
					<form class="form-inline well" id="import_repertory" enctype="multipart/form-data" method="post">
						<div class="row">
							<div class="form-group">
								<input type="file" name="excelFile" id="excelFile">
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-primary" id="rtUpload"><span class="glyphicon glyphicon-upload"></span>上传</button>
							</div>
						</div>
					</form>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal" id="rtClose">关闭</button>
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

		
		<div id="noResult"></div>
		
		<script type='text/javascript' src="/js/admin/repertory.js"></script>
		
	</div>
</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>