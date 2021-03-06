<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    <div class="ui inverted segment">
      <div class="ui inverted secondary pointing menu">
        <a class="active item">
          Home
        </a>
        <a class="item">
          Messages
        </a>
        <a class="item">
          Friends
        </a>
        <div class="right item">
          <a class="ui inverted button">Log in</a>
          <a class="ui inverted button">Sign Up</a>
        </div>
      </div>
    </div>

  <!-- <div class="ui large fixed inverted menu">

        <a href="#" class="header item">
          Score Today
        </a>

    </div>-->

    <div class="ui main center aligned text container">
        <h1 class="ui header">SCORE TODAY ${serverTime}</h1>


      <div class="ui center aligned grid">
        <div class="eight wide column">
          <form class="ui large form" id="loginForm" action="/main" method="post">
        <div class="ui segment">
          <div class="field">
            <div class="ui left icon input">
              <i class="user icon"></i>
              <input type="text" name="id" placeholder="ID">
            </div>
          </div>
          <div class="field">
            <div class="ui left icon input">
              <i class="lock icon"></i>
              <input type="password" name="password" placeholder="Password">
            </div>
          </div>
          <div class="ui fluid large teal submit button" onclick="document.getElementById('loginForm').submit();">Login</div>
        </div>
        <div class="ui error message"></div>
      </form>
      </div>
      </div>

      </div>

<script type="text/javascript">

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
