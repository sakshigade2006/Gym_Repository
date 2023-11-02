  //fetch the data Expert
    function fetchthedataExpert() {
	 	
    	$.ajax({
    		type: "post",
    		contentType: "application/json",
    		url: "getAllExpertData",
    		asynch: false,
    		success: function(data) {
    		
    				for (let i = 0; i < data.length; i++) {
				var j =1;
				const tableData = data.map(function(value) {
					return (
						` 
                            <tr>
								<td>${j++}</td>
								<td>${value.id}</td>
                                <td>${value.name}</td>
                                <td>${value.detailDescription}</td>
                                <td>${value.mobileNo}</td>
                                <td>${value.experience}</td>
                                <td>${value.ratings}</td>
                                <td> <button type="button" class="btn btn-primary rounded-pill m-2" onclick="deleteRowExpert(${value.id})">Delete</button></td>
                              
                            </tr>`
					);
				}).join('');
				const tabelBodyShare = document.querySelector("#tableBodyExpert");
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
				
				  if ($("#name").val() == "") {
             alert("Fill Name.!!!!!!");
             return;
                    }
                    
                      if ($("#experience").val() == "") {
             alert("Fill  Experience!!!");
             return;
                    }
                    
                      if ($("#detailDescription").val() == "") {
             alert("Fill  Details Description.!!!");
             return;
                    }
                    
                      if ($("#ratings").val() == "") {
             alert("Fill  Ratings!!!");
             return;
                    }
                    
                      if ($("#mobileNo").val() == "") {
             alert("Fill mobileNo.!!!");
             return;
                    }
                    
                      if ($("#file").val() == "") {
             alert("Fill image!!!");
             return;
                    }
                    
                
                    
                    
                    
				var form = $('#fileUploadForm')[0];
				var data = new FormData(form);
				$.ajax({
					url: 'saveExpertDetails',
					type: 'POST',
					enctype: 'multipart/form-data',
					data: data,
					processData: false,
					contentType: false,
					cache: false,
					success: function(response) {
						alert(response.message);
						window.location.href = "expertEdit";
					},
					error: function(xhr, status, error) {
						console.log(xhr.responseText);
					}
				});
			});
		});
		
		
		
		
				// JavaScript function to delete row
    function deleteRowExpert(rowId) {
	
	//alert(rowId);
	
		var input = {
		"id":rowId
	}
	const myJson = JSON.stringify(input);	

      $.ajax({
        url: 'deleteExpertDataById',
        contentType: "application/json", 
        type: 'POST',
        data:myJson ,
        success: function(response) {
          
          alert(response);
          window.location.href = "expertEdit";
        },
        error: function(xhr, status, error) {
          console.error('Error deleting row:', error);
        }
      });
    }