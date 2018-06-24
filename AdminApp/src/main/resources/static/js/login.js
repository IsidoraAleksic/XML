function buttonLoginClick() {
	email = $('#email').val();
	password = $('#password').val();

	$.ajax({
		url: "http://localhost:8080/authenticate/login",
		contentType: "application/json",
        dataType: "text",
        type: "POST",
        async: false,
        data: JSON.stringify({
        	"id": "",
        	"firstName":"",
        	"lastName": "",
        	"role": "ADMIN",
    		"email": email,
    		"password": password
    	}),
        success: function (data) {
        	$(location).attr('href', 'admin.html');
        }
        
    });
}