backedServer = "http://localhost:8080";
var action;
var accommodationIdType;
var accommodationIdCategory;
var additionalServiceId;
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
content+="<div class=\"card merch-container\"><h2>"+ "Accommodation type:" + accommodationType.typeName + "</h2>"+
    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationTypeUpdate("+accommodationType.id+")\">Update Accommodation Type</button></div><br/>" +
    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteAccommodationType("+accommodationType.id+")\">Delete Accommodation Type</button></div></div>";
return content;
}

function createAccommodationCategoryDiv(accommodationCategory){
	var content = "";
	content+="<div class=\"card merch-container\"><h2>"+ "Accommodation category:" + accommodationCategory.categoryName + "</h2>"+
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationCategoryUpdate("+accommodationCategory.id+")\">Update Accommodation Category</button></div><br/>" +
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteAccommodationCategory("+accommodationCategory.id+")\">Delete Accommodation Category</button></div></div>";
	return content;
}

function createAdditionalServicesDiv(additionalService){
	var content = "";
	content+="<div class=\"card merch-container\"><h2>"+ "Additional service:" + additionalService.name + "</h2>"+
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAdditionalServiceUpdate("+additionalService.id+")\">Update Additional Service</button></div><br/>" +
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteAdditionalServices("+additionalService.id+")\">Delete Accommodation Service</button></div></div>";
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