$(function() {
	// solving the active menu problem
	switch(menu) {
	
		case 'All Peoples':
			$('#listPeoples').addClass('active');
			break;
		default:
			$('#listPeoples').addClass('active');
			$('#a_'+menu).addClass('active');
			break;	
	
	}
		
	
});

$('#addUrlForm').submit(function() {
	 alert("success");
});