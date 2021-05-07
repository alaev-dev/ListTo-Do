<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>To-do List</title>
</head>
<body>
<table>
    <tr>
        <th>Do</th>
        <th>Tags</th>
        <th>Setup time</th>
        <th>Deadline</th>
    </tr>

    <c:forEach var="docket" items="${allDocket}">
        <tr>
            <td>${docket.describeCase}</td>
            <td>
                <c:forEach var="tag" items="${docket.tags}">
                    <li>${tag.name}</li>
                </c:forEach>
            </td>
            <td>${docket.timeSetup}</td>
            <td>${docket.deadline}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>