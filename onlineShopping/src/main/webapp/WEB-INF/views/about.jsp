
<div class="container">

    <div class="row">

      <div class="col-lg-3">

      <h1>Shop Name</h1>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
		
	</c:forEach>
</div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
        