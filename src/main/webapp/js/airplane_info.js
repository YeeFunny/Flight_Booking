$('document').ready(function () {
	$.ajax({
		url: "airplaneinfo",
		method: "GET",
		dataType: "json",
		success: function (data) {
			let result = $.map(data, function (d) {
				return d['airplaneId'];
			});
			$.each(result, function(index, value) {
				$('#airplaneId').append($('<option>', {
					value: value,
					text: value
				}));
			});
		},
		error: function (e) {
			console.log(e);
		}
	});
	$('#airplaneId').on('change', function() {
		$.get({
	        url: "airplaneinfo",
	        success: function(data){
	        	$.each(JSON.parse(data), function(index, airplane) {
	        		if ($('#airplaneId').val() === '') {
	        			$('#businessCap').val('');
		    			$('#firstCap').val('');
		    			$('#economyCap').val('');
	        		}
	        		console.log(airplane['airplaneId']);
	        		console.log($('#airplaneId').val());
		    		if (airplane['airplaneId'] == $('#airplaneId').val()) {
		    			$('#businessCap').val(airplane['businessClassCap']);
		    			$('#firstCap').val(airplane['firstClassCap']);
		    			$('#economyCap').val(airplane['economyClassCap']);
		    		}
		    	});
	        }
	   });
	});
});