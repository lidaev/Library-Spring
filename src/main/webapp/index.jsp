
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>Login</title>
  </head>
  <body>

  <div class="container">
    <div class="row">
      <div class="col-sm-4 col-sm-offset-4" id="login_block_tabs">
        <p id="welcome">Welcome to the digital library!</p>
        <!-- Nav tabs -->
        <div class="card">
          <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Login</a></li>
            <li role="presentation"><a href="#register" aria-controls="register" role="tab" data-toggle="tab">Registration</a></li>
          </ul>

          <!-- Tab panes -->
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
              <form id="login_form" method='post' action="login" class="col-sm-9 col-sm-offset-1">
                <div class="form-group">
                  Login <input class="form-control col-sm-10" type="text" name="name">
                </div>
                <div class="form-group">
                  Passwword: <input class="form-control col-sm-10" type="password" name="password">
                </div>
                <div class="form-group">
                  <button class="btn btn-default col-sm-offset-4" name='login' type="submit" id="login_btn" value="submit">Login</button>
                </div>
              </form>
            </div>
            <div role="tabpanel" class="tab-pane" id="register">
              <form id="reg_form" method="post" action="registration" class="col-sm-9 col-sm-offset-1">
                <div class="form-group">
                  Login: <input class="form-control col-sm-10" type="text" name="newusername">
                </div>
                <div class="form-group">
                  Password: <input class="form-control col-sm-10" type="password" name="password">
                </div>
                <div class="form-group">
                  <button class="btn btn-default col-sm-offset-2" name="registration" type="submit" id="reg_btn" value="submit">Register</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  </body>
</html>
