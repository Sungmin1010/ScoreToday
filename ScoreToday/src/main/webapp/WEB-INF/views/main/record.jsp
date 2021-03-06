<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semantic/semantic.min.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/semantic/semantic.min.js"></script>

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
      <h1 class="ui header">당신의 <span id="timecategoryKOR"></span> 점수는? </h1>
      <form class="ui form" id="scoreForm" action="/main/record" method="post">
        <input type="hidden" name="tc" id="tc" value="${timecategory}">
        <div class="three fields">
          <div class="field">
            <label>Body score</label>
            <select name="bodyscore" id="bodyscore" class="ui fluid dropdown">
              <option value="">Score</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
            </select>
          </div>
          <div class="field"><label>Mind score</label>
          <select name="mindscore" id="mindscore" class="ui fluid dropdown">
            <option value="">Score</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select></div>
          <div class="field">
            <label>Mental score</label>
            <select name="mentalscore" id="mentalscore" class="ui fluid dropdown">
              <option value="">Score</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
            </select>
          </div>
        </div>
        <!-- <div class="three fields">
          <div class="field"><label>Memo</label><textarea rows="3"></textarea></div>
          <div class="field"><label>Memo</label><textarea rows="3"></textarea></div>
          <div class="field"><label>Memo</label><textarea rows="3"></textarea></div>
        </div> -->
        <button class="ui center aligned primary button" type="submit" onclick="document.getElementById('scoreForm').submin();">Save</button>
      </form>

    </div>

    <script language="javascript" charset="UTF-8">
    var tc = '${timecategory}';
    var timecategoryKOR;
    switch(tc){
    case 'AM':
    	timecategoryKOR = "오전";
    	break;
    case 'NOON':
    	timecategoryKOR = "낮";
    	break;
    case 'PM':
    	timecategoryKOR = "오후";
    	break;
    default:
    	break;
    }
    var title = document.getElementById('timecategoryKOR');
    title.innerHTML = timecategoryKOR;

  </script>


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
  </body>
</html>
