<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">All Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ul>
		</div>
	</div>

	<div class="row">
		<!-- display image -->
		<div class="col-sm-4 col-xs-12">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive"></img>
			</div>

		</div>
		<!-- display product content -->
		<div class="col-sm-8 col-xs-12">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />
			<h4>
				Price: <strong>$ ${product.unitPrice}</strong>
			</h4>
			<hr />
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<span style="color: red">Out of stock</span><br/>
					<a href="javascript:void(0)"
					class="btn btn-primary disabled"><i class="fas fa-cart-plus"><strike>Add to
						Cart</strike></i></a> <a href="${contextRoot}/show/all/products"
					class="btn btn-success">Back</a>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
					<a href="${contextRoot}/cart/add/${product.id}/product"
					class="btn btn-primary"><i class="fas fa-cart-plus">Add to
						Cart</i></a> <a href="${contextRoot}/show/all/products"
					class="btn btn-success">Back</a>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
</div>