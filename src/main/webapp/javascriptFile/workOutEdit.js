  //fetch the data WorkOut
    function fetchthedataWorkOut() {
	 	
    	$.ajax({
    		type: "post",
    		contentType: "application/json",
    		url: "getAllWorkOutData",
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
                                <td>${value.day}</td>
                                <td>${value.duration}</td>
                                <td>${value.level}</td>
                                <td>${value.exerciseType}</td>
                                <td>${value.video}</td>
                                <td> <button type="button" class="btn btn-primary rounded-pill m-2" onclick="deleteRow(${value.id})">Delete</button></td>
                              
                            </tr>`
					);
				}).join('');
				const tabelBodyShare = document.querySelector("#tableBodyWorkout");
				tabelBodyShare.innerHTML = tableData;
			}


    		},
    		error: function() {
    			alert("Device control failed");
    		}
    	});

    }
    

// Save operation of Workout    
    
    		$(document).ready(function() {
			$('#submitBtn').click(function() {
				
				  if ($("#day").val() == "") {
             alert("Fill Day!!!!!!");
             return;
                    }
                    
                      if ($("#duration").val() == "") {
             alert("Fill  Duration!!!");
             return;
                    }
                    
                      if ($("#level").val() == "") {
             alert("Fill  level.!!!");
             return;
                    }
                    
                      if ($("#exerciseType").val() == "") {
             alert("Fill  exerciseType!!!");
             return;
                    }
                    
                      if ($("#video").val() == "") {
             alert("Fill url.!!!");
             return;
                    }
                    
                   
                    
                    
				var form = $('#fileUploadForm')[0];
				var data = new FormData(form);
				
				 // Convert FormData to JSON
      var jsonObject = {};
      for (var [key, value] of data.entries()) {
        jsonObject[key] = value;
      }
      var jsonData = JSON.stringify(jsonObject);

      // Display JSON data
      console.log(jsonData);
				$.ajax({
					url: 'saveWorkOutData',
					type: 'POST',
					contentType: "application/json",
					data: jsonData,
					processData: false,
					cache: false,
					success: function(response) {
						alert(response.message);
						window.location.href = "workOutEdit";
					},
					error: function(xhr, status, error) {
						console.log(xhr.responseText);
					}
				});
			});
		});
		
		
				// JavaScript function to delete row
    function deleteRow(rowId) {
	
	//alert(rowId);
	
		var input = {
		"id":rowId
	}
	const myJson = JSON.stringify(input);	

      $.ajax({
        url: 'deleteWorkOutById',
        contentType: "application/json", 
        type: 'POST',
        data:myJson ,
        success: function(response) {
          
          alert(response);
          window.location.href = "workOutEdit";
        },
        error: function(xhr, status, error) {
          console.error('Error deleting row:', error);
        }
      });
    }
		
		
		
		
		
		