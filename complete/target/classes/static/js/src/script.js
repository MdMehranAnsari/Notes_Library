$(document).ready(function () {
	
	/* Load Grades List */
	
	$('#grade').find('option').remove();
	$('#grade').append('<option disabled>Select grade</option>');
	
	$.ajax({
	    type: "GET",
	    url: "http://localhost:8080/grades",
		data: "json",
		contentType: "application/json",
		
	    success: function (data) {
		    let obj = $.parseJSON(data);
			let str="";
		    $.each(obj, function (key, value) {
		    	str += '<option value="' + value.gradeId + '">' + value.gradeName + '</option>' + '\n'
		    });
			$('#grade').append(str);
	    },
	
	    error: function (data) {
	    	$('#grade').append('<option>Grades Unavailable</option>');
	    },
	});
	
	$('#exam').find('option').remove();
	$('#exam').append('<option disabled>Select exam</option>');
	
	/* Load Exams List */
	
	$.ajax({
	    type: "GET",
	    url: "http://localhost:8080/exams",
		data: "json",
		contentType: "application/json",
		
	    success: function (data) {
		    let obj = $.parseJSON(data);
			let str="";
		    $.each(obj, function (key, value) {
		    	str += '<option value="' + value.examId + '">' + value.examName + '</option>' + '\n'
		    });
			$('#exam').append(str);
	    },
	
	    error: function (data) {
	    	$('#exam').append('<option>Exams Unavailable</option>');
	    },
	});
	
   /** Load School Boards 
	 * Change in Grades List triggers loading of School Boards List.
     */

   $('#grade').change(function () {

      $('#schoolBoard').find('option').remove();
      

      var gradeId1 = $('#grade').val();
      /*var inputValObj = {};
      inputValObj.gradeId = gradeId1;
      var inputVal = JSON.stringify(inputValObj);
      var data = inputVal.toString();*/

      $.ajax({
         type: "GET",
         url: "http://localhost:8080/schoolBoards?gradeId=" + gradeId1,
		 data: "json",
         contentType: "application/json",
         success: function (data) {
            
			let str = "";
			console.log(data);
			
			if(!data)
			{
				str = '<option value="1">N/A</option>';
			}
			else
			{
				let obj = $.parseJSON(data);
				str = '<option selected disabled>Select school board</option>';
	            $.each(obj, function (key, value) {
	               str += '<option value="' + value.schoolBoardId + '">' + value.schoolBoardName + '</option>' + '\n'
	            });
			}
			$('#schoolBoard').append(str);
         },
		 
         error: function (data) {
            $('#schoolBoard').append('<option>School Board Unavailable</option>');
         },
      });
   });
});