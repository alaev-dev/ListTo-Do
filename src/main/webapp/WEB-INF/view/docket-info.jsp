<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Docket info</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<form:form action="saveDocket" modelAttribute="docketInput">

    <table>
        <tr>
            <th>To-do</th>
            <td><form:input path="describeCase"/></td>
        </tr>
        <tr>
            <th>Deadline</th>
            <td><form:input path="deadline" id="datepicker"/></td>
        </tr>
    </table>

    <br>

    <input type="submit" value="OK">
</form:form>

<script>
    $(function () {
        $.datepicker.setDefaults({
            dateFormat: "dd.mm.yy",
            onClose: function (date, inst) {
                $("#selectedDateVal").html(date);
            }
        });

        $("#datepicker").datepicker();
    });
</script>

</body>
</html>