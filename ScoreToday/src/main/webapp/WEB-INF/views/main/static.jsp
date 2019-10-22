<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.min.css">
    <!-- Load c3.css -->
    <link href="${pageContext.request.contextPath }/resources/css/c3.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>
    <!-- Load d3.js and c3.js -->
    <script src="https://d3js.org/d3.v5.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>

	<!-- Load Fomantic Calendar module-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/calendar.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/calendar.min.js"></script>

    <style type="text/css">
    body {
      background-color: #FFFFFF;
    }
    .ui.menu .item img.logo {
      margin-right: 1.5em;
    }
    .main.container {
      margin-top: 10em;
    }
    .wireframe {
      margin-top: 2em;
    }
    .ui.footer.segment {
      margin: 5em 0em 0em;
      padding: 5em 0em;
    }
  </style>

    <script>

  </script>
  
  
  
    <title></title>
  </head>
  <body>
    <div class="ui large fixed inverted menu"> <!-- fixed  stackable -->
      <div class="ui container">
        <a href="#" class="header item">
          Score Today
        </a>
        <a href="#" class="item">Static</a>
        <a href="#" class="item">Mypage</a>
      </div>
    </div>

    <div class="ui main text container">
      <h1 class="ui header">Static Page </h1>
      <form class="ui form" id="staticform">
        <div class="two fields">
          <div class="field">
            <label>Start date</label>
            <div class="ui calendar" id="rangestart">
              <div class="ui input left icon">
                <i class="calendar icon"></i>
                <input type="text" placeholder="Start" id="start" name="startDate">
              </div>
            </div>
          </div>
          <div class="field">
            <label>End date</label>
            <div class="ui calendar" id="rangeend">
              <div class="ui input left icon">
                <i class="calendar icon"></i>
                <input type="text" placeholder="End" name="endDate">
              </div>
            </div>
          </div>
        </div>
        <label>Select the score category </label>
        <div class="inline fields">

          <div class="field">
          <div class="ui checkbox">
            <input type="checkbox" name="category" value="bodyscore">
            <label>Body Score</label>
          </div>
          </div>
          <div class="field">
          <div class="ui checkbox">
            <input type="checkbox" name="category" value="mindscore">
            <label>Mind Score</label>
          </div>
          </div>
          <div class="field">
          <div class="ui checkbox">
            <input type="checkbox" name="category" value="mentalscore">
            <label>Mental Score</label>
          </div>
          </div>
        </div>
        <button class="ui button" type="submit" onclick="getScores()" >Submit</button>
      </form>  <!-- End Form -->
      <div class="ui divider"></div>
      <div id="chart"></div>
    </div>
<script type="text/javascript">
var today = new Date();
var maxDate = new Date(today.getFullYear(), today.getMonth(), today.getDate());

$('#rangestart').calendar({
  type: 'date',
  endCalendar: $('#rangeend'),
  maxDate: maxDate,
  formatter: {
    date: function (date, settings){
      if (!date) return '';
      var day = date.getDate();
      var month = date.getMonth() + 1;
      var year = date.getFullYear();
      return year+'-'+month+'-'+day;
    }
  }
});
$('#rangeend').calendar({
  type: 'date',
  startCalendar: $('#rangestart'),
  maxDate: maxDate,
  formatter: {
    date: function (date, settings){
      if (!date) return '';
      var day = date.getDate();
      var month = date.getMonth() + 1;
      var year = date.getFullYear();
      return year+'-'+month+'-'+day;
    }
  }
});


</script>
<script type="text/javascript">
function makeC3(x_data, body_data, mind_data, mental_data){
	var chart = c3.generate({
        bindto: '#chart',
        data:{
          x:'x',
          json: {
            x:x_data,
            body_score: body_data,
            mind_score: mind_data,
            mental_score: mental_data
          },
        },
        axis:{
          x: {
            type: 'timeseries',
            tick: {format: '%Y-%m-%d'},
            //padding: 500
          },
          y: {
            max: 10,
            min: 1
            //padding: 10
          }
        },
        //legend: {position: 'top'},
        size: {
          height:500

        },
        padding:{right:40, bottom:50, left:20},
        zoom: {enabled: true}
      });
}
//var data = {};
//var senddata = {};
//function getDate(){
//event.preventDefault();
/* data = $('#staticform').serializeArray();
console.log("폼");
$.each(data, function(index, o){
  console.log(o.name + " : "+o.value);
});

var s = $('#rangestart').calendar('get date'); //s object
console.log(s);
var s_date = new Date(s);
console.log(s_date);
console.log(s_date.getFullYear());
var s_y = s_date.getFullYear();
var s_m = s_date.getMonth()+1;
var s_d = s_date.getDate();
var s_date_kor = s_y+ "/" + s_m + "/" + s_d + "/";
console.log("선택한 시작 날짜는 " + s_date_kor + "입니다.");
 */

//checkbox 확인
/* var category = [];
$('input:checked').each(function(){
  //console.log($(this).val());
  //category.push($(this).val());
}); */
//console.log(str);

//var senddata = {};
/* $.each(data, function(index, o){
  if(o.name=='category'){
    category.push(o.value);
  }else{
    senddata[o.name] = o.value;
  }
});
senddata['category'] = category;

} */
</script>

<script>
//x:['2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04'],
//            body_score: [9, 8, 8, 5],
 //           mind_score: [2, 6, 4, 6],

function getScores(){
	//prepare data for c3.js
  var x = [];
  var body_score = [];
  var mind_score = [];
  var mental_score = [];
  
  event.preventDefault();
  //set ajax send data
  var senddata = {};
  var data = {};
  data = $('#staticform').serializeArray();
  var category = [];
  $.each(data, function(index, o){
    if(o.name=='category'){
    	console.log("카테고리");
      category.push(o.value);
    }else{
    	console.log("그냥");
      senddata[o.name] = o.value;
    }
  });
  senddata['category'] = category;
  console.log("보낼데이터");
console.log(senddata);
  //start ajax
  $.ajax({
    url: '/static/user/testid/scores',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: JSON.stringify(senddata),
    success: function(result){
      //console.log(result);
      $.each(result, function(index, staticVo){
    	  x.push(staticVo.date);
    	  body_score.push(staticVo.bodyscore);
    	  mind_score.push(staticVo.mindscore);
    	  mental_score.push(staticVo.mentalscore);
    	  
    	 
      });
      //그래프 그리기
      var chart = c3.generate({
          bindto: '#chart',
          data:{
            x:'x',
            json: {
              x:x,
              body_score: body_score,
              mind_score: mind_score,
              mental_score: mental_score
            },
          },
          axis:{
            x: {
              type: 'timeseries',
              tick: {format: '%Y-%m-%d'},
              //padding: 500
            },
            y: {
              max: 10,
              min: 1
              //padding: 10
            }
          },
          //legend: {position: 'top'},
          size: {
            height:500

          },
          padding:{right:40, bottom:50, left:20},
          zoom: {enabled: true}
        });
    }
  });

}

</script>

<!-- footer -->
    <div class="ui inverted vertical footer segment">
      <div class="ui center aligned container">
        <div class="ui stackable inverted divided grid">
          <div class="three wide column">
            <h4 class="ui inverted header">Group 1</h4>
            <div class="ui inverted link list">
              <a href="#" class="item">Link One</a>
              <a href="#" class="item">Link Two</a>
              <a href="#" class="item">Link Three</a>
              <a href="#" class="item">Link Four</a>
            </div>
          </div>
          <div class="three wide column">
            <h4 class="ui inverted header">Group 2</h4>
            <div class="ui inverted link list">
              <a href="#" class="item">Link One</a>
              <a href="#" class="item">Link Two</a>
              <a href="#" class="item">Link Three</a>
              <a href="#" class="item">Link Four</a>
            </div>
          </div>
          <div class="three wide column">
            <h4 class="ui inverted header">Group 3</h4>
            <div class="ui inverted link list">
              <a href="#" class="item">Link One</a>
              <a href="#" class="item">Link Two</a>
              <a href="#" class="item">Link Three</a>
              <a href="#" class="item">Link Four</a>
            </div>
          </div>
          <div class="seven wide column">
            <h4 class="ui inverted header">Footer Header</h4>
            <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
          </div>
        </div>
        <div class="ui inverted section divider"></div>

        <div class="ui horizontal inverted small divided link list">
          <a class="item" href="#">Site Map</a>
          <a class="item" href="#">Contact Us</a>
          <a class="item" href="#">Terms and Conditions</a>
          <a class="item" href="#">Privacy Policy</a>
        </div>
      </div>
    </div>
    
    <script type="text/javascript">
    
    
     /*  window.onload = function () {
      var chart = c3.generate({
        bindto: '#chart',
        data:{
          x:'x',
          json: {
            x:['2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04'],
            body_score: [9, 8, 8, 5],
            mind_score: [2, 6, 4, 6],
            mental_score: [6, 5, 3, 5]
          },
        },
        axis:{
          x: {
            type: 'timeseries',
            tick: {format: '%Y-%m-%d'},
            //padding: 500
          },
          y: {
            max: 10,
            min: 1
            //padding: 10
          }
        },
        //legend: {position: 'top'},
        size: {
          height:500

        },
        padding:{right:40, bottom:50, left:20},
        zoom: {enabled: true}
      });
    } */
    </script>
    
  </body>
</html>
