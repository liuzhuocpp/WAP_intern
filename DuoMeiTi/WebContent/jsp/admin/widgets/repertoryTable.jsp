<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/base/taglib.jsp" %>
	<table class="table table-bordered table-hover" id="repertory_table">
		<tr class="active">
 			<th>index</th>
 			<th>type</th>
			<th>name</th>				
 						
  			<th>purchase price</th>
 			<th>purchase price unit</th>
 			<th>position</th>
		</tr>
		<s:iterator value="commodity_list" var="i" status="index">
			<tr class="warning" rt_id="<s:property value="#i.id"/>">
				<td  > <s:property value="#i.id"/> </td>
				<td  > <s:property value="#i.type"/> </td>
				
				<td  > <s:property value="#i.name"/> </td>
				<td  > <s:property value="#i.purchasePrice"/> </td>
							
				<td  > <s:property value="#i.purchasePriceUnit"/> </td>
				<td  > <s:property value="#i.postion"/> </td>
			</tr>
		</s:iterator>
	</table>