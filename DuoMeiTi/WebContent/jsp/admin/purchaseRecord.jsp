<%@ include file="/jsp/base/taglib.jsp"%>
<layout:override name="main_content">

<div class="mycontent">

	
	<div>
		<form class="form-inline" role="form">
		  <div class="form-group">
		    <div class="input-group">
		      <div class="input-group-addon">Start Time</div>
		      <input type="date" class="form-control"/>
		    </div>
		    <div class="input-group">
		      <div class="input-group-addon">End Time</div>
		      <input type="date" class="form-control"/>
		    </div>

		  </div>
		  <button type="submit" class="btn btn-default">Show</button>
		</form>		
	</div>
	<br/>
	
	<button class="btn btn-primary"> 2014.5.4 Purchase Order： </button>
	<table class="table table-bordered">
		<tr>
			<th>Purchase commodity</th>
			<th>Purchase commodity number</th>
			<th>Purchase price</th>
			<th>Total price</th>
			<th>Supplier </th>
		</tr>
		<tr>
			<td> Coca-cola</td>
			<td>200 </td>
			<td>50 </td>
			<td>10000 </td>
			<td> Coca-cola company</td>
		</tr>
	</table>
	
	<button class="btn btn-primary"> 2014.6.3 Purchase Order： </button>
	<table class="table table-bordered">
		<tr>
			<th>Purchase commodity</th>
			<th>Purchase commodity number</th>
			<th>Purchase price</th>
			<th>Total price</th>
			<th>Supplier </th>
		</tr>
		<tr>
			<td> Coca-cola</td>
			<td>200 </td>
			<td>50 </td>
			<td>10000 </td>
			<td> Coca-cola company</td>
		</tr>
	</table>
	
	



</div>
</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>