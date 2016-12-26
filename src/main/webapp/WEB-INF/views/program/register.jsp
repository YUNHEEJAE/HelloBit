<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Program Register <small>Blank example to the boxed layout</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Layout</a></li>
			<li class="active">Boxed</li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content">
		<hr />
		<div class="row">
			<div class="col-md-12"> 
			
				<div class="form-group">
				  <label class=" control-label" for="giftID">Gift ID</label>  
				  <input id="giftID" name="giftID" type="text" placeholder="Gift ID" class="form-control">
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" for="giftName">Gift Name</label>  
				  <input id="giftName" name="giftName" type="text" placeholder="Gift Name" class="form-control input-md" required="">
				    
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" for="giftPrice">Price</label>  
				  <input id="giftPrice" name="giftPrice" type="text" placeholder="Price" class="form-control input-md" required="">
				    
				</div>
				
				<!-- Select Basic -->
				<div class="form-group">
				  <label class=" control-label" for="store">Store</label>
				    <select id="store" name="store" class="form-control">
				      <option value="Store 1">Store 1</option>
				      <option value="Store 2">Store 2</option>
				    </select>
				</div>
				
				<!-- Select Basic -->
				<div class="form-group">
				  <label class=" control-label" for="category">Category</label>
				    <select id="category" name="category" class="form-control">
				      <option value="category1">Category 1</option>
				      <option value="category2">Category 2</option>
				    </select>
				</div>
				
				<!-- Select Basic -->
				<div class="form-group">
				  <label class=" control-label" for="giftStatus">Status</label>
				    <select id="giftStatus" name="giftStatus" class="form-control">
				      <option value="1">Available</option>
				      <option value="0">Not Available</option>
				    </select>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" for="shippingDays">Shipping Days</label>  
				  <input id="shippingDays" name="shippingDays" type="text" placeholder="Shipping Days" class="form-control input-md">
				  <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Appended checkbox -->
				<div class="form-group">
				  <label class=" control-label" for="giftPic">Gift Picture</label>
				    <div class="input-group">
				      <input id="giftPic" name="giftPic" class="form-control" type="text" placeholder="Gift Picture">
				            <span class="input-group-addon">     
				          <input type="checkbox">     
				      </span>
				    </div>
				    <p class="help-block">Please upload the picture of the gift</p>
				</div>
				<div class=""></div>
				<button type="button" class="btn btn-success">Register</button>
				<button type="button" class="btn btn-warning">Cancel</button>
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>


<script>

$(document).ready(function() {
	
	
});


</script>

</html>
