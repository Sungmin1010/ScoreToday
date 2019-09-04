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

    <script>

  </script>
    <title></title>
  </head>
  <body>
    <div class="ui large fixed inverted menu"> <!-- fixed  stackable -->
      <div class="ui container">
        <a href="/main" class="header item">
          Score Today
        </a>
        <a href="/main/static" class="item">Static</a>
        <a href="/main/mypage" class="item">Mypage</a>
      </div>
    </div>



    <div class="ui main text container">
      <h1>Hello, ${userInfo.name} !!! </h1>
      <h1 class="ui header">Today is .... </h1>
      
      <!-- scoreList 이용한 코드 추가하기 -->
      <c:forEach var="score" items="${scoreList}">
         <c:choose>
        	<c:when test="${score.timecode eq 'a'}">
            <h4 class="ui horizontal divider header"> AM </h4>
        	</c:when>
        	<c:when test="${score.timecode eq 'n'}">
            <h4 class="ui horizontal divider header"> NOON </h4>
        	</c:when>
        	<c:when test="${score.timecode eq 'p'}">
            <h4 class="ui horizontal divider header"> PM </h4>
        	</c:when>
        	<c:otherwise></c:otherwise>   
    	</c:choose>
    	<table class="ui celled table">
        <thead class="center aligned">
          <tr>
            <th>Body</th>
            <th>Mind</th>
            <th>Mental</th>
          </tr>
        </thead>
        <tbody class="center aligned">
          <tr>
            <td><h1 class="ui header">${score.bodyscore}</h1></td> <!-- two wide column -->
            <td><h1 class="ui header">${score.mindscore}</h1></td>
            <td><h1 class="ui header">${score.mentalscore}</h1></td>
          </tr>
        </tbody>
      </table>
      </c:forEach>
      
      <!-- <h4 class="ui horizontal divider header"> AM </h4>
      <table class="ui celled table">
        <thead class="center aligned">
          <tr>
            <th>Body</th>
            <th>Mind</th>
            <th>Mental</th>
          </tr>
        </thead>
        <tbody class="center aligned">
          <tr>
            <td><h1 class="ui header">7</h1></td> two wide column
            <td><h1 class="ui header">5</h1></td>
            <td><h1 class="ui header">9</h1></td>
          </tr>
        </tbody>
      </table>
      
      <h4 class="ui horizontal divider header"> NOON </h4>
      <table class="ui celled table">
        <thead class="center aligned">
          <tr>
            <th>Body</th>
            <th>Mind</th>
            <th>Mental</th>
          </tr>
        </thead>
        <tbody class="center aligned">
          <tr>
            <td><h1 class="ui header">7</h1></td> two wide column
            <td><h1 class="ui header">5</h1></td>
            <td><h1 class="ui header">9</h1></td>
          </tr>
        </tbody>
      </table>
      
      <h4 class="ui horizontal divider header"> PM </h4>
      <button class="ui fluid button" id="PM" onclick="recordBtn(this.id)">
        <i class="plus icon"></i>
        add new one
      </button> -->
    </div>

<script>
function recordBtn(id){
	//get button's id
	var timecategory = id;
	//make uri
	var uri = "/main/record?timecategory="+timecategory;
	//go record page
	 window.location.href=uri;
}

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
