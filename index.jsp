<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
        <form action="FirstServlet" method="post">
            category:
            <select name="c">
                <option name="abc">story</option>
                 <option name="story">story</option>
                 <option name="novel">novel</option>
                  <option name="g.k">g.k</option>
            </select><br><br>
            Title:
           <input type="textfield" name="title"><br><br>
            Author:
           <input type="textfield" name="author"><br><br>
           ISBN:
           <input type="textfield" name="isbn"><br><br>
        <input type="submit" name="submit">
        </form>
  </body>
</html>
