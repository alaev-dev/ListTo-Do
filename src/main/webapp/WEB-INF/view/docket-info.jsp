<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Docket info</title>
    <link rel="stylesheet" type="text/css" href="resources/css/flatpickr.css"/>
</head>
<body>
<form:form action="saveDocket" modelAttribute="docketInput">

    <table>
        <tr>
            <th>To-do</th>
            <td><form:input path="describeCase"/></td>
            <td><form:errors path="describeCase"/></td>
        </tr>
        <tr>
            <th>Deadline</th>
            <td><form:input path="deadline" id="datepicker"/></td>
        </tr>
        <tr>
            <th>Tags</th>
            <td>
                    <form:checkboxes path="pickedTags" items="${listOfTag}"/>
        </tr>
    </table>

    <br>

    <input type="submit" value="OK">
</form:form>

<script src="resources/js/flatpickr.js"></script>

<script>

    flatpickr.l10ns.default.firstDayOfWeek = 1; // Monday

    flatpickr("#datepicker", {
        enableTime: true,
        time_24hr: true,
        altInput: true,
        altFormat: "j F Y H:i",
        dateFormat: "Y-m-d H:i",

        minDate: "today"
    });
</script>

</body>
</html>