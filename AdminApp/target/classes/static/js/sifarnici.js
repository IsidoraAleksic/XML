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
content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Accommodation type:" + accommodationType.typeName + "</h2></div>"+
    "<button  type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationTypeUpdate("+accommodationType.id+",\'"+accommodationType.typeName+"\')\">Update</button><br/>" +
    "<button  type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAccommodationType("+accommodationType.id+")\">Delete</button></div></div></div>";
return content;
}

function createAccommodationCategoryDiv(accommodationCategory){
	var content = "";
	content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Accommodation category:" + accommodationCategory.categoryName + "</h2></div>"+
	    "<button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationCategoryUpdate("+accommodationCategory.id+",\'"+ accommodationCategory.categoryName+"\')\">Update</button><br/>" +
	    "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAccommodationCategory("+accommodationCategory.id+")\">Delete</button></div></div></div>";
	return content;
}

function createAdditionalServicesDiv(additionalService){
	var content = "";
	content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Additional service:" + additionalService.name + "</h2></div>"+
	    "<button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAdditionalServiceUpdate("+additionalService.id+",\'"+ additionalService.name+"\')\">Update</button><br/>" +
	    "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"deleteAdditionalServices("+additionalService.id+")\">Delete</button></div></div></div>";
	return content;
}
function openModalAccommodationTypeCreate() {
	$("#typeName").val("");
    action="create";
    $("#accommodationTypeModal").modal();
}
function openModalAccommodationTypeUpdate(id,name) {
	accommodationIdType=id;
	$("#typeName").val(name);
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
	$("#categoryName").val("");
    action="create";
    $("#accommodationCategoryModal").modal();

}
function openModalAccommodationCategoryUpdate(id,name) {
	accommodationIdCategory=id;
	$("#categoryName").val(name);
    action="update";
    $("#accommodationCategoryModal").modal();
}
function chooseMethodAccommodationCategory(){
    if(action == "create"){
    	addAccommodationCategory();
    }else{
    	updateAccommodationCategory(accommodationIdCategory);
    }
}
function openModalAdditionalServiceCreate() {
	$("#nameService").val("");
    action="create";
    $("#additionalServiceModal").modal();

}
function openModalAdditionalServiceUpdate(id,name) {
	additionalServiceId=id;
	$("#nameService").val(name);
    action="update";
    $("#additionalServiceModal").modal();

}
function chooseMethodAdditionalService(){
    if(action == "create"){
    	addAdditionalService();
    }else{
    	updateAdditionalService(additionalServiceId);
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

function addAdditionalService(){
    $.ajax({
        url: backedServer+"/administrator/addAdditionalServices",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "name": $("#nameService").val()
        }),
        success: function(data) {
            $(location).attr('href', 'admin.html');
        }
    });

}

function updateAdditionalService(additionalServiceId){
    $.ajax({
        url: backedServer+"/administrator/updateAdditionalServices/"+additionalServiceId,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "name": $("#nameService").val()
        }),
        success: function(data) {
        	 $('#additionalServiceModal').modal('hide');
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