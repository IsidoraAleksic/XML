function registerAgent() {
	 $.ajax({
	        url: backedServer+"/administrator/addAgent",
	        contentType: "application/json",
	        dataType: "text",
	        type: "POST",
	        data: JSON.stringify({
	        	"name": $("#formRegister-first-name").val(), 
	    		"surname": $("#formRegister-last-name").val(), 
	    		"email":  $("#formRegister-email").val(), 
	    		"regNumber": $("#formRegister-brn").val()
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
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"postReview("+review.id+","+true+")\">Approve review</button></div><br/>" +
	    "<div><button type=\"button\" class=\"btn btn-primary\" onclick=\"postReview("+review.id+","+false+")\">Reject review</button></div></div>";
	return content;
}

function postReview(reviewId,status){	
	$.ajax({
        url: backedServer+"/administrator/postReview/"+reviewId+"/"+status,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "approved": $("#approved").val()
        }),
        success: function(data) {
        	if(data){
        		getReviews();
        	}else{
        		$(location).attr('href', 'admin.html');
        	}
        	 
        }
    });
}

function changeStatus(email,status){
	$.ajax({
        url: backedServer+"/administrator/changeUserStatus/"+email+"/"+status,
        contentType: "application/json",
        dataType: "text",
        type: "POST",
        data: JSON.stringify({
            "status": $("#status").val()
        }),
        success: function(data) {
        	if(data){
        		getUsers();
        	}else{
        		$(location).attr('href', 'admin.html');
        	}
        	 
        }
    });
}

function getUsers(){
	
	$.ajax({
        url: backedServer+"/administrator/getAllUsers",
        dataType: "json",
        type: "GET",
        success: function(data){
            var users = data;
            var content = "";
            $('tbody').empty();
            for (var user in users) {
                content+=createUsersDiv(users[user]);
            }
            $("#users").empty().append(content);

        }
    });

}

function createUsersDiv(user){
	let status = "<button type=\"button\" onclick=\"changeStatus(\'"+user.email+"\',\'ACTIVATED\')\" class=\"btn\">Activate User</button>"+
	"<button type=\"button\" onclick=\"changeStatus(\'"+user.email+"\',\'BLOCKED\')\" class=\"btn\">Block User</button>"+
	"<button type=\"button\" onclick=\"changeStatus(\'"+user.email+"\',\'DELETED\')\" class=\"btn\">Delete User</button>";
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
        .append($('<td>')
        	.append(
        		user.email
        	)
        
        )
        .append($('<td>')
        	.append(
        		user.role
        	)
        
        )
        .append($('<td>')
        	.append(
        		user.status
        	)
        
        )
         .append($('<td>')
        	.append(
        		status
        	)
        
        )
	);
}

function showHideAgent() {
    var x = document.getElementById("addAgent");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function showHideUser() {
	getUsers();
    var x = document.getElementById("showUsers");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
$( document ).ready(function() {
	 var x = document.getElementById("addAgent");
	 var y = document.getElementById("showUsers");
	 x.style.display = "none";
	 y.style.display = "none";
});
