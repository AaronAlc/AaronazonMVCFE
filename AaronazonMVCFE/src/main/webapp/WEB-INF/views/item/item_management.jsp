<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="/AaronazonMVCFE/app/css/item_management.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/item/itemManagement.app.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/item/itemManagement.service.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/item/itemManagement.controller.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Item Management Control</title>
</head>
<body>
	<t:headerfooter>
		<div class="container" ng-app="itemManagementApp"
			ng-controller="ItemController as ctrl">
			<h1>
				<span>Item Administration Form</span>
			</h1>
			<p ng-if="ctrl.error_message.length > 0" id="error_message" name="error_message" ng-bind="ctrl.error_message"></p>
			<form name="myForm">
				<table class="table table-bordered">
					<tr>
						<td><input type="hidden" ng-model="ctrl.item.id" /> <label
							for="itemName">Item Name</label></td>
						<td><input type="text" ng-model="ctrl.item.itemName"
							id="itemName" name="itemName" placeholder="Enter Item Name"
							required ng-minlength="3" />
							<div>
								<span ng-show="myForm.itemName.$error.required">This is
									required Field </span> <span
									ng-show="myForm.itemName.$error.minlength">Item name has
									to be at least 3 characters</span>
							</div></td>
					</tr>
					<tr>
						<td><label class="itemname-label" for="itemDesc">Item
								Description</label></td>
						<td><input type="text" ng-model="ctrl.item.description"
							id="itemDesc" placeholder="Enter your Item Description" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input id="submit_btn" type="submit" ng-click="ctrl.submit()"
								value="{{!ctrl.item.id ? 'Create' : 'Update'}}" class="btn-submit"
								ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()" class="btn-warning"
								ng-disabled="myForm.$pristine">Reset Form</button>
						</td>
					</tr>
				</table>
			</form>
			<div class="tablecontainer">
				<span>List of Items</span>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col" width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="itm in ctrl.items">
							<td ng-bind="itm.id"></td>
							<td id="table_{{itm.itemName.replace(' ', '_')}}" ng-bind="itm.itemName"></td>
							<td ng-bind="itm.description"></td>
							<td>
								<button id="{{itm.itemName.replace(' ', '_')}}_edit_btn" type="button" ng-click="ctrl.edit(itm.id)"
									class="btn btn-outline-primary">Edit</button>
								<button id="{{itm.itemName.replace(' ', '_')}}_remove_btn" type="button" ng-click="ctrl.remove(itm.id)"
									class="btn btn-outline-secondary">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</t:headerfooter>
</body>
</html>