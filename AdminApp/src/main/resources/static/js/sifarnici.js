backedServer = "http://localhost:8080";
var action="create";
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
content+="<div class=\"card merch-container\"><h2>"+ "Name:" + accommodationType.typeName + "</h2>"+
    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"openModalAccommodationTypeUpdate("+accommodationType.id+")\">Update Accommodation Type</button></div><br/>" +
    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteAccommodationType("+accommodationType.id+")\">Delete Accommodation Type</button></div></div>";
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
    	updateAccommodationType();
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

            for (var type in accommodationType) {
                content+=createAccommodationCategoryDiv(accommodationCategory[type]);
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
function getUsers(){
	$('#showUsers').show=true;
	$.ajax({
        url: backedServer+"/administrator/getAllUsers",
        dataType: "json",
        type: "GET",
        success: function(data){
            var users = data;
            var content = "";

            for (var user in users) {
                content+=createUsersDiv(users[user]);
            }
            $("#users").empty().append(content);

        }
    });

}

function createUsersDiv(user){
	$("#showUsers").find('tbody')
    .append($('<tr>')
        .append($('<td>')
            .append(
				user.firstName
            )
        )
		.append($('<td>')
            .append(
				user.lastName
            )
        )
	);
}

function getReviews(){
	$.ajax({
        url: backedServer+"/administrator/getAllReviews",
        dataType: "json",
        type: "GET",
        success: function(data){
            var reviews = data;
            var content = "";

            for (var review in reviews) {
                content+=createReviewsDiv(reviews[review]);
            }
            $("#reviews").empty().append(content);

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
function updateAccommodationType(){
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
function updateAccommodationCategory(){
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

function updateAdditionalServices(){
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