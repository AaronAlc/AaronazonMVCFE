<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/home/home_user_view.app.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/home/home_user_view.service.js"></script>
<script type="text/javascript"
	src="/AaronazonMVCFE/app/js/home/home_user_view.controller.js"></script>
<html>
<title>Home Page</title>
<body>
	<t:headerfooter>
		<h1>Items sold in store</h1>
		<div class="container" ng-app="homeApp"	ng-controller="HomeController as hctrl">

			<div class="col-lg-9">
				<div class="row" >
					<div class="col-lg-4 col-md-6 mb-4" ng-repeat="itm in hctrl.items">
						<div class="card h-80">
							<a href="http://localhost:8081/AaronazonMVCFE/app/images/{{itm.imageLoc}}"><img class="card-img-top" src="http://localhost:8081/AaronazonMVCFE/app/images/{{itm.imageLoc}}" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#" ng-bind="itm.itemName"></a>
								</h4>
								<p class="card-text" ng-bind="itm.description"></p>
							</div>
							<div class="card-footer">
								<button type="Submit">Add to Cart</button>
								<small class="text-muted"></small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</t:headerfooter>
</body>
</html>