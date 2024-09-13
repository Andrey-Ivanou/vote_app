<%@ page language="Java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Голосование</title>
</head>

<body bgcolor="#87ceeb">

<form action="http://localhost:8080/web-app-vote-final/form" method="post">
    <fieldset>
        <legend><h2>Форма для голосования</h2></legend>
        <p><h4>Выбирите одного из кандитатов:</h4></p>
        <p><input list="кондидаты" name="name" placeholder="Введите имя" required></p><br>

        <h4><p>Выбирите жанры (от 3 до 5 вариантов)</p></h4>

        <p>
        <c:forEach items="${genres}" var="item">
        <a><input type="checkbox" name="genre" value="<c:out value="${item.key}"/>"/>${item.value}</a>
        </c:forEach>
        </p>


        <p>
        <h4><label for="comment">Ваш коментарий</label><br></h4>
            <textarea id="comment" name="comment" aria-modal="100" placeholder="Написать комментарий не более 100 символов" cols="30" rows="7"></textarea>
        </p>

        <p>
            <input type="submit" value="Отправить">
        </p>
    </fieldset>
</form>

<datalist id="кондидаты">
<c:forEach items="${candidates}"
var="item">
<option value="<c:out value="${item.key}"/>"/>${item.value}</option>
</c:forEach>
</datalist>

</body>

</html>