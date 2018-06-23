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

function showHideReview() {
    var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
	var z = document.getElementById("additionalServices");
	var w = document.getElementById("reviews");
	var u = document.getElementById("showUsers");
	var v =  document.getElementById("addAgent");
    if (w.style.display === "none") {
        w.style.display = "block";
        y.style.display = "none";
   	 	z.style.display = "none";
		u.style.display = "none";
		v.style.display = "none";
		x.style.display = "none";
		getReviews();
    } else {
        w.style.display = "none";
    }
}



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
	content+="<div class=\"row\"><div class=\"col-md-4\"><div class=\"card merch-container\" style=\"width:400px; height:190px\"><div class=\"modal-header\"><h2>"+ "Review:" + review.review + "</h2>"+ "<h5>"+ "Approved:" + review.approved +"</h5>"+ "</div>"+
	    "<button type=\"button\" class=\"btn btn-primary\" onclick=\"postReview("+review.id+","+true+")\">Approve review</button><br/>" +
	    "<button type=\"button\" class=\"btn btn-secondary\" onclick=\"postReview("+review.id+","+false+")\">Reject review</button></div></div></div>";
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
	let status = "&nbsp; &nbsp;&nbsp\<button class=\"btn\" onclick=\"changeStatus(\'"+user.email+"\',\'ACTIVATED\')\"><i class=\"far fa-smile fa-2x\"></i>Activate</button>"+ "&nbsp; &nbsp;&nbsp"+
	"<button class=\"btn\" onclick=\"changeStatus(\'"+user.email+"\',\'BLOCKED\')\"><i class=\"far fa-frown-open fa-2x \"></i>Block</button>"+ "&nbsp; &nbsp;&nbsp" +
	"<button class=\"btn\" onclick=\"changeStatus(\'"+user.email+"\',\'DELETED\')\"><i class=\"fas fa-trash-alt fa-2x\"></i>Delete</button>";
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
    var z = document.getElementById("addAgent");
    var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
	var v = document.getElementById("additionalServices");
	var w = document.getElementById("reviews");
	var u = document.getElementById("showUsers");
    if (z.style.display === "none") {
        z.style.display = "block";
        x.style.display = "none";
   	 	y.style.display = "none";
   	 	w.style.display = "none";
   	 	u.style.display = "none";
   	 	v.style.display = "none";
    } else {
        z.style.display = "none";
    }
}
function showHideUser() {
	getUsers();
    var u = document.getElementById("showUsers");
    var z = document.getElementById("addAgent");
    var x = document.getElementById("accommodationType");
    var y = document.getElementById("accommodationCategory");
	var v = document.getElementById("additionalServices");
	var w = document.getElementById("reviews");
    if (u.style.display === "none") {
        u.style.display = "block";
        z.style.display = "none";
        x.style.display = "none";
   	 	y.style.display = "none";
   	 	w.style.display = "none";
   	 	v.style.display = "none";
    } else {
        u.style.display = "none";
    }
}
