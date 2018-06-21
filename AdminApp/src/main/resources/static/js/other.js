function registerAgent() {
	 $.ajax({
	        url: backedServer+"/administrator/addAgent",
	        contentType: "application/json",
	        dataType: "text",
	        type: "POST",
	        data: JSON.stringify({
	        	"name": $("#formRegister-first-name").val(), 
	    		"surname": $("formRegister-last-name").val(), 
	    		"email":  $("formRegister-email").val(), 
	    		"regNumber": $("formRegister-brn").val()
	        }),
	        success: function(data) {
	            $(location).attr('href', 'admin.html');
	        }
	    });
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

function createReviewsDiv(review){
	var content = "";
	content+="<div class=\"card merch-container\"><h2>"+ "Review:" + review.review + "</h2>"+ "Approved:" + review.approved + 
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"approveReview()\">Approve review</button></div><br/>" +
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"rejectReview()\">Reject review</button></div></div>";
	return content;
}

function approveReview(){	
	$.ajax({
        url: backedServer+"/administrator/posReview/approve",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "approved": $("#approved").val()
        }),
        success: function(data) {
        	 $(location).attr('href', 'admin.html');
        }
    });
}

function rejectReview(){	
	$.ajax({
        url: backedServer+"/administrator/posReview/reject",
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "approved": $("#approved").val()
        }),
        success: function(data) {
        	 $(location).attr('href', 'admin.html');
        }
    });
}

function changeStatus(){
	
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