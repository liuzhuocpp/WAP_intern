<%@ include file="/jsp/base/taglib.jsp" %>



<layout:override name="menu_list">

	<div class="menu-list">
<!-- 	    <a href="/admin/classroom/" class="menu-button-middle"><span class="glyphicon glyphicon-blackboard">&nbsp;教室管理</span></a> -->
	    <a href="/admin/repertory" class="menu-button-middle"><span class="glyphicon glyphicon-th-large">&nbsp;Commodity Management</span></a>
	    <a href="/admin/repairRecord" class="menu-button-middle"><span class="glyphicon glyphicon-th">&nbsp;Commodity Position Set</span></a>
	    
<!-- 	    <a href="/admin/checkinManage" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;</span></a> -->
	    
	    <a href="/admin/modifypassword" class="menu-button-middle"><span class="glyphicon glyphicon-lock">&nbsp;Modify password</span></a>
	    <a href="/admin/user_information" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;Personal Information</span></a>
	    <a href="/logout" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;logout</span></a>

	    
	    <div class="menu-blank"></div>
	</div>
	
	
	
	 
 </layout:override>








<%@ include file="/jsp/base/user_base.jsp" %>