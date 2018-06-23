backedServer = "http://localhost:8080";
var action;
var accommodationIdType;
var accommodationIdCategory;
var additionalServiceId;

$( document ).ready(function() {
	 var x = document.getElementById("accommodationType");
	 var y = document.getElementById("accommodationCategory");
	 var z = document.getElementById("additionalServices");
	 var w = document.getElementById("reviews");
	 var u = document.getElementById("showUsers");
	 var v =  document.getElementById("addAgent");
	 x.style.display = "none";
	 y.style.display = "none";
	 z.style.display = "none";
	 w.style.display = "none";
	 u.style.display = "none";
	 v.style.display = "none";
});


function showHideAccommodationType() {
    var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
	var z = document.getElementById("additionalServices");
	var w = document.getElementById("reviews");
	var u = document.getElementById("showUsers");
	var v =  document.getElementById("addAgent");
    if (x.style.display === "none") {
        x.style.display = "block";
        y.style.display = "none";
   	 	z.style.display = "none";
	   	w.style.display = "none";
	   	u.style.display = "none";
	   	v.style.display = "none";
        getAccommodationType();
    } else {
        x.style.display = "none";
    }
}

function showHideAccommodationCategory() {
	var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
	var z = document.getElementById("additionalServices");
	var w = document.getElementById("reviews");
	var u = document.getElementById("showUsers");
	var v =  document.getElementById("addAgent");
    if (y.style.display === "none") {
        y.style.display = "block";
        x.style.display = "none";
   	 	z.style.display = "none";
   	 	w.style.display = "none";
	   	u.style.display = "none";
	   	v.style.display = "none";
        getAccommodationCategory();
    } else {
        y.style.display = "none";
    }
}

function showHideAdditionalServices() {
	var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
    var z = document.getElementById("additionalServices");
    var w = document.getElementById("reviews");
	var u = document.getElementById("showUsers");
	var v =  document.getElementById("addAgent");
    if (z.style.display === "none") {
        z.style.display = "block";
        x.style.display = "none";
   	 	y.style.display = "none";
   	 	w.style.display = "none";
	   	u.style.display = "none";
	   	v.style.display = "none";
        getAdditionalServices();
    } else {
        z.style.display = "none";
    }
}

function getAccommodationType(){
	$.ajax({
        url: backedServer+"/administrator/getAllAccommodationType",
        dataType: "json",
        type: "GET",
        success: function(data){
            var accommodationType = data;
            var content = "";

            for (var type in accommodationType) {
                content+=createAccommodationTypeDiv(accommodationType[type]);
            }
            $("#accommodationType").empty().append(content);

        }
    });

}

function createAccommodationTypeDiv(accommodationType){
var content = "";
content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Accommodation type:" + accommodationType.typeName + "</h2>"+"<button type=\"button\" class=\"close\" onclick=\"card merch-container.close()\" data-dismiss=\"modal\">&times;</button></div>"+
    "<button  type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationTypeUpdate("+accommodationType.id+")\">Update</button><br/>" +
    "<button  type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAccommodationType("+accommodationType.id+")\">Delete</button></div></div></div>";
return content;
}

function createAccommodationCategoryDiv(accommodationCategory){
	var content = "";
	content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Accommodation category:" + accommodationCategory.categoryName + "</h2>"+"<button type=\"button\" class=\"close\" onclick=\"card merch-container.close()\" data-dismiss=\"modal\">&times;</button></div>"+
	    "<button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationCategoryUpdate("+accommodationCategory.id+")\">Update</button><br/>" +
	    "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAccommodationCategory("+accommodationCategory.id+")\">Delete</button></div></div></div>";
	return content;
}

function createAdditionalServicesDiv(additionalService){
	var content = "";
	content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Additional service:" + additionalService.name + "</h2>" +"<button type=\"button\" class=\"close\" onclick=\"self.close()\" data-dismiss=\"modal\">&times;</button></div>"+
	    "<button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAdditionalServiceUpdate("+additionalService.id+")\">Update</button><br/>" +
	    "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAdditionalServices("+additionalService.id+")\">Delete</button></div></div></div>";
	return content;
}
function openModalAccommodationTypeCreate() {
    action="create";
    $("#accommodationTypeModal").modal();
}
function openModalAccommodationTypeUpdate(id) {
	accommodationIdType=id;
    action="update";
    $("#accommodationTypeModal").modal();

}
function chooseMethodAccommodationType(){
    if(action == "create"){
    	addAccommodationType();
    }else{
    	updateAccommodationType(accommodationIdType);
    }
}
function openModalAccommodationCategoryCreate() {
    action="create";
    $("#accommodationCategoryModal").modal();

}
function openModalAccommodationCategoryUpdate(id) {
	accommodationIdCategory=id;
    action="update";
    $("#accommodationCategoryModal").modal();

}
function chooseMethodAccommodationCategory(){
    if(action == "create"){
    	addAccommodationCategory();
    }else{
    	updateAccommodationCategory();
    }
}
function openModalAdditionalServiceCreate() {
    action="create";
    $("#additionalServiceModal").modal();

}
function openModalAdditionalServiceUpdate(id) {
	additionalServiceId=id;
    action="update";
    $("#additionalServiceModal").modal();

}
function chooseMethodAdditionalService(){
    if(action == "create"){
    	addAdditionalService();
    }else{
    	updateAdditionalService();
    }
}
function getAccommodationCategory(){
	$.ajax({
        url: backedServer+"/administrator/getAllAccommodationCategory",
        dataType: "json",
        type: "GET",
        success: function(data){
            var accommodationCategory = data;
            var content = "";

            for (var category in accommodationCategory) {
                content+=createAccommodationCategoryDiv(accommodationCategory[category]);
            }
            $("#accommodationCategory").empty().append(content);

        }
    });

}

function getAdditionalServices(){
	$.ajax({
        url: backedServer+"/administrator/getAllAdditionalServices",
        dataType: "json",
        type: "GET",
        success: function(data){
            var additionalServices = data;
            var content = "";

            for (var service in additionalServices) {
                content+=createAdditionalServicesDiv(additionalServices[service]);
            }
            $("#additionalServices").empty().append(content);

        }
    });

}

function addAccommodationType(){
    $.ajax({
        url: backedServer+"/administrator/addAccommodationType",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "typeName": $("#typeName").val()
        }),
        success: function(data) {
            $(location).attr('href', 'admin.html');
        }
    });

}
function updateAccommodationType(accommodationIdType){
    $.ajax({
        url: backedServer+"/administrator/updateAccommodationType/"+accommodationIdType,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "typeName": $("#typeName").val()
        }),
        success: function(data) {
        	 $('#accommodationTypeModal').modal('hide');
        }
    });

}
function addAccommodationCategory(){
    $.ajax({
        url: backedServer+"/administrator/addAccommodationCategory",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "categoryName": $("#categoryName").val()
        }),
        success: function(data) {
            $(location).attr('href', 'admin.html');
        }
    });

}
function updateAccommodationCategory(accommodationIdCategory){
    $.ajax({
        url: backedServer+"/administrator/updateAccommodationCategory/"+accommodationIdCategory,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "categoryName": $("#categoryName").val()
        }),
        success: function(data) {
        	 $('#accommodationCategoryModal').modal('hide');
        }
    });

}

function addAdditionalServices(){
    $.ajax({
        url: backedServer+"/administrator/addAdditionalServices",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "name": $("#name").val()
        }),
        success: function(data) {
            $(location).attr('href', 'admin.html');
        }
    });

}

function updateAdditionalServices(additionalServiceId){
    $.ajax({
        url: backedServer+"/administrator/updateAdditionalServices/"+additionalServiceId,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "name": $("#name").val()
        }),
        success: function(data) {
        	 $('#additionalServicesModal').modal('hide');
        }
    });

}

function deleteAccommodationType(accommodationTypeId){
    $.ajax({
        url: backedServer+"/administrator/deleteAccommodationType/"+accommodationTypeId,
        contentType: "application/json",
        dataType: "text",
        type: "DELETE",
        success: function (data) {
            $(location).attr('href', 'admin.html');
        }
    });

}
function deleteAccommodationCategory(accommodationCategoryId){
    $.ajax({
        url: backedServer+"/administrator/deleteAccommodationCategory/"+accommodationCategoryId,
        contentType: "application/json",
        dataType: "text",
        type: "DELETE",
        success: function (data) {
            $(location).attr('href', 'admin.html');
        }
    });

}
function deleteAdditionalServices(additionalServicesId){
    $.ajax({
        url: backedServer+"/administrator/deleteAdditionalServices/"+additionalServicesId,
        contentType: "application/json",
        dataType: "text",
        type: "DELETE",
        success: function (data) {
            $(location).attr('href', 'admin.html');
        }
    });

}