$(document).ready(function() {
	// solving active menu problem

	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	//code for Jquery datatable
	//data set for table
		
	
	var $table=$('#productListTable');
	//display only if table exists
	if($table.length){
		//console.log("INSIDE TABLE");
		
		var jsonUrl= '';
		if(window.categoryId == ''){
			jsonUrl=window.contextRoot+'/json/data/all/products';
		}else{
			jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable(
			{
				lengthMenu: [
					[3,2,-1],['3 records','2 records','all records']
					],
				pageLength: 4,
				//data: products //instead use ajax
				ajax: {
					url: jsonUrl,
					dataSrc:''
				},
				columns:[
					{
						data: 'code',
						/* mRender will modify data and return it*/
						mRender: function(data, type, row){
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
						}
					},
					
					{
						data: 'name'
					},
					{
						data: 'brand'
					},
					{
						data: 'unitPrice',
						mRender: function(data,type,row){
							return '$ '+data
						}
					},
					{
						data: 'quantity',
						mRender: function(data, type, row){
							if(data<1){
								return '<span style="color: red">Out of stock</span>';
							}else
								return data;
						}
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row){
							var str='';
							str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-light btn-sm"><i class="fas fa-eye"></i></a>&#160';
							if(row.quantity < 1){
								
								str+='<a href="javascript.void(0)" class="btn btn-light btn-sm disabled"><i class="fas fa-cart-plus"></i></a>';
							}
							
							else{
							str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-light btn-sm"><i class="fas fa-cart-plus"></i></a>';
							}
							return str;
						}
					}
				]
				
			}
		);
		
		
	}
});