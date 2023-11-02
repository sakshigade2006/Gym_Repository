  //fetch the data Today Special
    function fetchthedataTodaySpecial() {
	 	
    	$.ajax({
    		type: "post",
    		contentType: "application/json",
    		url: "retrieveAllTodaysSpecialVideos",
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
                                <td>${value.videos}</td>
                                <td> <button type="button" class="btn btn-primary rounded-pill m-2" onclick="deleteRowTodaySpecila(${value.id})">Delete</button></td>
                              
                            </tr>`
					);
				}).join('');
				const tabelBodyShare = document.querySelector("#tableBodyTodaySpecial");
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
				
				  if ($("#videos").val() == "") {
             alert("Fill videos.!!!!!!");
             return;
                    }
             
				var form = $('#fileUploadForm')[0];
				var data = new FormData(form);
				$.ajax({
					url: 'uploadTodaysSpecialVideo',
					type: 'POST',
					enctype: 'multipart/form-data',
					data: data,
					processData: false,
					contentType: false,
					cache: false,
					success: function(response) {
						alert(response.message);
						window.location.href = "todaySpecialVideoEdit";
					},
					error: function(xhr, status, error) {
						console.log(xhr.responseText);
					}
				});
			});
		});
		
		
		
						// JavaScript function to delete row
    function deleteRowTodaySpecila(rowId) {
	
	//alert(rowId);
	
		var input = {
		"id":rowId
	}
	const myJson = JSON.stringify(input);	

      $.ajax({
        url: 'deleteTodaysSpecialVideoByid',
        contentType: "application/json", 
        type: 'POST',
        data:myJson ,
        success: function(response) {
          
          alert(response);
          window.location.href = "todaySpecialVideoEdit";
        },
        error: function(xhr, status, error) {
          console.error('Error deleting row:', error);
        }
      });
    }