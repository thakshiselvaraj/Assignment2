/**
 * 
 */
$(document).ready(function()
{ 
		if ($("#alertSuccess").text().trim() == "") 
		 { 
			$("#alertSuccess").hide(); 
		 } 
		 	$("#alertError").hide(); 
}); 

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
		// Clear alerts---------------------
		 $("#alertSuccess").text(""); 
		 $("#alertSuccess").hide(); 
		 $("#alertError").text(""); 
		 $("#alertError").hide(); 
		 
// Form validation-------------------
var status = validateItemForm(); 
		if (status != true) 
		 { 
			 $("#alertError").text(status); 
			 $("#alertError").show(); 
			 return; 
		 } 
		
		
// If valid------------------------
		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
		 $.ajax( 
		 { 
		 url : "InvestorsAPI", 
		 type : type, 
		 data : $("#formItem").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemSaveComplete(response.responseText, status); 
		 } 
		 });
}); 

function onItemSaveComplete(response, status)
{ 

	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		}
		

		else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		} 
	else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
		 //$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	     $("#hidItemIDSave").val($(this).data("investorID"));
		 $("#investorName").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#Mail").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#ProjectCode").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#ProjectName").val($(this).closest("tr").find('td:eq(3)').text());
		 $("#InvestAmount").val($(this).closest("tr").find('td:eq(3)').text());
		 
}); 
	// CLIENT-MODEL================================================================
	function validateItemForm() 
	{ 
	// NAME
		if ($("#investorName").val().trim() == "") 
		 { 
			return "Insert investor name."; 
		 } 
	// MAIL
		if ($("#Mail").val().trim() == "") 
		 { 
			return "Insert mail."; 
		 }
	// CODE
		if ($("#ProjectCode").val().trim() == "") 
		 { 
			return "Insert project code."; 
		 }
		
	// PROJECT NAME
		if ($("#ProjectName").val().trim() == "") 
		 { 
			return "Insert project Name."; 
		 }
		
	//Amount-------------------------------
		if ($("#InvestAmount").val().trim() == "") 
		 { 
			return "Insert Invest amount."; 
		 } 
	// is numerical value
		/*var tmpAmount = $("#InvestAmount").val().trim(); 
		if (!$.isNumeric(tmpAmount)) 
		 { 
			return "Insert a numerical value for Invest Amount."; 
		 } 
	// convert to decimal price
	$("#InvestAmount").val(parseDouble(tmpPrice).toFixed(2)); */


return true; 
}
	
	//REMOVE
	$(document).on("click", ".btnRemove", function(event)
			{ 
			 $.ajax( 
			 { 
			 url : "InvestorsAPI", 
			 type : "DELETE", 
			 data : "investorID=" + $(this).data("investorid"),
			 dataType : "text", 
			 complete : function(response, status) 
			 { 
			 onItemDeleteComplete(response.responseText, status); 
			 } 
		 }); 
});
	
	function onProductDeleteComplete(response, status) {

		if (status == "success") {
			var resultSet = JSON.parse(response);
			if (resultSet.status.trim() == "success") {
				$("#alertSuccess").text("Successfully deleted.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
			}

			else if (resultSet.status.trim() == "error") {
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}

		}

		else if (status == "error") {
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		}

		else {
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();

		}

	}

