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
<!-- AM Score -->
      <h4 class="ui horizontal divider header"> AM </h4>
      <c:choose>
        <c:when test="${empty am.scoredate}">
          <button class="ui fluid button" id="AM" onclick="recordBtn(this.id)">
            <i class="plus icon"></i>add new one
      	  </button>
      	</c:when>
        <c:otherwise>
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
                <td><h1 class="ui header">${am.bodyscore}</h1></td>
                <td><h1 class="ui header">${am.mindscore}</h1></td>
                <td><h1 class="ui header">${am.mentalscore}</h1></td>
              </tr>
            </tbody>
          </table>
        </c:otherwise>
      </c:choose>
<!-- NOON Score -->
      <h4 class="ui horizontal divider header"> NOON </h4>
      <c:choose>
        <c:when test="${empty noon.scoredate}">
          <button class="ui fluid button" id="NOON" onclick="recordBtn(this.id)">
            <i class="plus icon"></i>add new one
      	  </button>
        </c:when>
        <c:otherwise>
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
                <td><h1 class="ui header">${noon.bodyscore}</h1></td>
                <td><h1 class="ui header">${noon.mindscore}</h1></td>
                <td><h1 class="ui header">${noon.mentalscore}</h1></td>
              </tr>
            </tbody>
          </table>
        </c:otherwise>
      </c:choose>
<!-- PM Score -->    
      <h4 class="ui horizontal divider header"> PM </h4>
      <c:choose>
        <c:when test="${empty pm.scoredate}">
          <button class="ui fluid button" id="PM" onclick="recordBtn(this.id)">
            <i class="plus icon"></i>add new one
      	  </button>
        </c:when>
        <c:otherwise>
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
                <td><h1 class="ui header">${pm.bodyscore}</h1></td>
                <td><h1 class="ui header">${pm.mindscore}</h1></td>
                <td><h1 class="ui header">${pm.mentalscore}</h1></td>
              </tr>
            </tbody>
          </table>
        </c:otherwise>
      </c:choose>
      
      
      
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
    <script>
    var result = '${msg}';
    if(result == 'success'){
    	alert("점수가 입력되었습니다.");
    }
    if(result == 'score-error'){
    	alert("더이상 점수를 입력할 수 없습니다.");
    }
    </script>
  </body>
</html>
