function buttonLoginClick() {
	email = $("#email").val();
	password = $("#password").val();

	
	/*
	var data = {
		"email": email,
		"password": password
	}
	$.post("http://localhost:8080/authenticate/login", data)
	.done(function() {
		alert('alert');
		$(location).attr('href', 'admin.html');
	})
	.finally(function() {
		alert('alert');
		$(location).attr('href', 'admin.html');
	});
	alert('alert');
	*/
	$.ajax({
		url: "http://localhost:8080/authenticate/login",
		contentType: "application/json",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        headers: {  'Access-Control-Allow-Origin': '*' },
        type: "POST",
        async: false,
        data: JSON.stringify({
    		"email": email,
    		"password": password
    	}),
        success: function () {
        	$(location).attr('href', 'admin.html');
        },
        error: function (data) {
        	alert("User not found!");
        }
        
    });

	
}