<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
	<head>
		<title> The Happy Car </title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

    <style type="text/css">
      body {
        padding-top: 60px;
        background-color:#353535;
        color:#fff
      }
    </style>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="resources/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png">

  	<!-- Google Fonts call. Font Used Open Sans -->
  	<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
  	
  	<!-- FullCalendar Files - JS & CSS Configuration -->
  	<link rel="stylesheet" type="text/css" href="resources/fullcalendar/fullcalendar.css">
	<link rel="stylesheet" type="text/css" href="resources/fullcalendar/fullcalendar.print.css" media="print">
	<script type="text/javascript" src="resources/fullcalendar/jquery-ui-1.8.23.custom.min.js"></script>
	<script type="text/javascript" src="resources/fullcalendar/fullcalendar.min.js"></script>

	<script type="text/javascript">

  	<!-- FullCalendar Initializaiton -->

	$(document).ready(function() {
	
	
		/* initialize the external events
		-----------------------------------------------------------------*/
	
		$('#external-events div.external-event').each(function() {
		
			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: $.trim($(this).text()) // use the element's text as the event title
			};
			
			// store the Event Object in the DOM element so we can get to it later
			$(this).data('eventObject', eventObject);
			
			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});
			
		});
	
	
		/* initialize the calendar
		-----------------------------------------------------------------*/
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar !!!
			drop: function(date, allDay) { // this function is called when something is dropped
			
				// retrieve the dropped element's stored Event Object
				var originalEventObject = $(this).data('eventObject');
				
				// we need to copy it, so that multiple events don't have a reference to the same object
				var copiedEventObject = $.extend({}, originalEventObject);
				
				// assign it the date that was reported
				copiedEventObject.start = date;
				copiedEventObject.allDay = allDay;
				
				// render the event on the calendar
				// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
				$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
				
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
				
			}
		});
	});

</script>

  	
  </head>
  <body>
  	<!-- NAVIGATION MENU -->

    <div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div> 
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="welcome"><i class="icon-home icon-white"></i> Home</a></li>
              <li><a href="login"><i class="icon-folder-open icon-white"></i> Login</a></li>
              <li class="active"><a href="viewSchedule"><i class="icon-calendar icon-white"></i> Calendar</a></li>
              <li><a href="newUser"><i class="icon-th icon-white"></i> Add New User</a></li>
              <li><a href="newCar"><i class="icon-lock icon-white"></i> Add New Car</a></li>
              <li><a href="newEngineer"><i class="icon-user icon-white"></i> Add New Engineer</a></li>
              <li><a href="newSchedule"><i class="icon-user icon-white"></i>Add new Schedule</a></li>

            </ul>
          </div><!--/.nav-collapse -->
        </div>
    </div>

	<div class="container">

      <!-- CONTENT -->
		<div class="row">
      		<!-- Event Selector -->
			<div class="col-sm-3 col-lg-3">
				<div id="external-events">
				<h4>Draggable Events</h4>
				<div class="external-event">My Event 1</div>
				<div class="external-event">My Event 2</div>
				<div class="external-event">My Event 3</div>
				<div class="external-event">My Event 4</div>
				<div class="external-event">My Event 5</div>
				<p>
				<input type="checkbox" id="drop-remove"> <label for="drop-remove">remove after drop</label>
				</p>
				</div>
        	</div><!-- /span3 -->

      		<!-- Calendar -->
        	<div class="col-sm-9 col-lg-9">
	        	<div id="calendar"></div>
				<div style="clear:both"></div>
			</div><!-- /span9 -->
	      </div><!-- /row -->
	   </div> <!-- /container -->
     <br>
    <!-- Footer -->
	<div id="footerwrap">
      	<footer class="clearfix"></footer>
      	<div class="container">
      		<div class="row">
      			<div class="col-sm-12 col-lg-12">
      			<p><img src="resources/img/logo.png" alt=""></p>
      			<p>YIGC - Java Academy</p>
      			</div>

      		</div><!-- /row -->
      	</div><!-- /container -->		
	</div><!-- /footerwrap -->


    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="resources/js/admin.js"></script>
        
	</body>
</html>