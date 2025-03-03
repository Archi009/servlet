/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
	let eventAll = []
	fetch('fullData.do')
	.then(result => result.json())
	.then(result => {
		console.log(result)
		eventAll = result
		console.log("되라 좀")
		fullCalFunc()
	})
	.catch(err=> console.log(err))
	
	function fullCalFunc(){
   var calendarEl = document.getElementById('calendar');

   var calendar = new FullCalendar.Calendar(calendarEl, {
     headerToolbar: {
       left: 'prev,next today',
       center: 'title',
       right: 'dayGridMonth,timeGridWeek,timeGridDay'
     },
     initialDate: '2025-02-12',
     navLinks: true, // can click day/week names to navigate views
     selectable: true,
     selectMirror: true,
     select: function(arg) {
       var title = prompt('Event Title:');
       console.log(arg);
       console.log("title"+title,"start"+arg.start,"end"+arg.end);
      // let data = {"title":title,"start":arg.start,"end":arg.end}
      //  fetch("fullInsert.do", {
      //   method: "POST", 
      //   mode: "cors", 
      //   cache: "no-cache", 
      //   credentials: "same-origin", 
      //   headers: {
      //     "Content-Type": "application/json", 
      //   },
      //   redirect: "follow", 
      //   referrerPolicy: "no-referrer", 
      //   body: JSON.stringify(data)
      // }).then(result => result.json())
      // .then(result =>{
      //   console.log(result);
      // })
      fetch("fullInsert.do?title="+title+"&start="+arg.start+"&end="+arg.end)
      .then(result=>result.json())
      .then(result=>{
        console.log(result);
      }

      )
       if (title) {
         calendar.addEvent({
           title: title,
           start: arg.start,
           end: arg.end,
           allDay: arg.allDay
         })
       }
       calendar.unselect()
     },
     eventClick: function(arg) {
       if (confirm('Are you sure you want to delete this event?')) {
         arg.event.remove()
       }
     },
     editable: true,
     dayMaxEvents: true, // allow "more" link when too many events
     events: eventAll
   });

   calendar.render();}
 });