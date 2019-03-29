<div class="container">

    <div class="row">

      <div class="col-lg-3">

        <%@include file="./shared/sidebar.jsp" %>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
			<!-- breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClicksAllProducts==true}">
						<script>
							window.categoryId='';
						</script>
						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Product</li>
							</ul>
					</c:if>
					
					<c:if test="${userClicksCategoryProducts==true}">
						
						<script>
							window.categoryId='${category.id}';
						</script>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">Category</li>
						<li class="breadcrumb-item active">${category.name}</li>
					</ul>
				</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<table id="productListTable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th><!-- for image -->
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>Qty. AVAILABLE</th>
								<th></th><!-- for view product symbol -->
								<!-- for add to cart -->
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>