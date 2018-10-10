jQuery.validator.setDefaults({
	debug : true,
	success : "valid"
});
$('form').validate({
	rules : {
		business : {
			require_from_group : [ 1, ".ticket-group" ]
		},
		firstClass : {
			require_from_group : [ 1, ".ticket-group" ]
		},
		economy : {
			require_from_group : [ 1, ".ticket-group" ]
		}
	},
	messages : {
		business : {
			require_from_group : 'Please enter ticket number.'
		},
		firstClass : {
			require_from_group : ''
		},
		economy : {
			require_from_group : ''
		}
	}
});