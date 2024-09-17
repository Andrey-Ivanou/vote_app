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

<form action="http://localhost:8080/web-app-vote-final/removeGenre" method="post">
    <fieldset>

        <h4><p>Удалить Жанр</p></h4>

        <select name="name">
                <c:forEach items="${genres}" var="item">
                    <option value="<c:out value="${item.value}"/>"><c:out value="${item.value}"/></option>
                </c:forEach>
            </select>

        <p>
            <input type="submit" value="Отправить">
        </p>
    </fieldset>
</form>

</body>

</html>