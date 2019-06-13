<%--
  Created by IntelliJ IDEA.
  User: isd
  Date: 25.06.18
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <script type="text/javascript" src="webjars/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <title>Library</title>
</head>
<body>
<div class="container">
    <div class="row my-5">
        <h1>Частота слов в книгах</h1>
    </div>
    <div class="row my-5">
        <div class="col-6">
            <div>
                <label for="inputBook">Название книги</label>
                <input type="text" class="form-control" id="inputBook" aria="bookHelp"
                       placeholder="Книга">
                <small id="bookHelp" class="form-text text-muted">Введите название книги</small>
            </div>
            <div>
                <label for="inputWord">Искомое слово</label>
                <input type="text" class="form-control" id="inputWord" aria="wordHelp"
                       placeholder="Слово">
                <small id="wordHelp" class="form-text text-muted">Введите слово</small>
            </div>
            <button type="submit" id="btnSearch" class="btn btn-primary" onclick="search()">Поиск</button>
        </div>
    </div>
    <div class="row my-2">
            <h4 id="frequency"></h4>
    </div>
</div>
</body>
</html>
