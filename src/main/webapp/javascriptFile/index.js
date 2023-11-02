
    
  //fetch the data Shop
    function fetchthedataShop() {
	 	
    	$.ajax({
    		type: "post",
    		contentType: "application/json",
    		url: "retrieveAllShopData",
    		asynch: false,
    		success: function(data) {
    		
    				for (let i = 0; i < data.length; i++) {
				var j =1;
				const tableData = data.map(function(value) {
					return (
						`<tr>
								<td>${j++}</td>
                                <td>${value.id}</td>
                                <td>${value.productName}</td>
                                <td>${value.price}</td>
                                <td>${value.quantity}</td>
                                <td>${value.color}</td>
                                <td>${value.description}</td>
                                <td>${value.priceDiscount}</td>
                                <td>${value.shortDescription}</td>
                                <td> <button type="button" class="btn btn-primary rounded-pill m-2" onclick="deleteRowShop(${value.id})">Delete</button></td>
                                 </tr>`
					);
				}).join('');
				const tabelBodyShare = document.querySelector("#tableBodyShop");
				tabelBodyShare.innerHTML = tableData;
			}


    		},
    		error: function() {
    			alert("Device control failed");
    		}
    	});

    }
  
  
  
  //save operation  
  
  

		$(document).ready(function() {
			$('#submitBtn').click(function() {
				
				  if ($("#productName").val() == "") {
             alert("Fill productName.!!!!!!");
             return;
                    }
                    
                      if ($("#product_title").val() == "") {
             alert("Fill  product_title.!!!");
             return;
                    }
                    
                      if ($("#price").val() == "") {
             alert("Fill  price.!!!");
             return;
                    }
                    
                      if ($("#quantity").val() == "") {
             alert("Fill  quantity!!!");
             return;
                    }
                    
                      if ($("#color").val() == "") {
             alert("Fill color.!!!");
             return;
                    }
                    
                    
                        if ($("#priceDiscount").val() == "") {
             alert("Fill color.!!!");
             return;
                    }
                    
                    
                        if ($("#shortDescription").val() == "") {
             alert("Fill color.!!!");
             return;
                    }
                    
                      if ($("#description").val() == "") {
             alert("Fill description!!!");
             return;
                    }
                    
                      if ($("#image").val() == "") {
             alert("Fill image1!!!");
             return;
                    }
                    
                      if ($("#image2").val() == "") {
             alert("Fill image2!!!");
             return;
                    }
                    
                      if ($("#image3").val() == "") {
             alert("Fill  image3!!!");
             return;
                    }
                    
                      if ($("#image4").val() == "") {
             alert("Fill image4 !!!");
             return;
                    }
                    
                      if ($("#image5").val() == "") {
             alert("Fill  image5!!!");
             return;
                    }
                    
                    
                    
				var form = $('#fileUploadForm')[0];
				var data = new FormData(form);
				$.ajax({
					url: 'saveshopData',
					type: 'POST',
					enctype: 'multipart/form-data',
					data: data,
					processData: false,
					contentType: false,
					cache: false,
					success: function(response) {
						alert(response.message);
						window.location.href = "index";
					},
					error: function(xhr, status, error) {
						console.log(xhr.responseText);
					}
				});
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		// JavaScript function to delete row
    function deleteRowShop(rowId) {
	
	//alert(rowId);
	
		var input = {
		"id":rowId
	}
	const myJson = JSON.stringify(input);	

      $.ajax({
        url: 'deleteShopDataById',
        contentType: "application/json", 
        type: 'POST',
        data:myJson ,
        success: function(response) {
          
          alert(response);
          window.location.href = "index";
        },
        error: function(xhr, status, error) {
          console.error('Error deleting row:', error);
        }
      });
    }
