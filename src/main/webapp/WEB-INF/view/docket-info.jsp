<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Docket info</title>
    <link rel="stylesheet" type="text/css" href="resources/css/jquery.datetimepicker.min.css"/>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="resources/js/jquery.datetimepicker.full.js"></script>

<script>
    $('#datepicker').datetimepicker({
        norange: true, // use only one value
        cells: [1, 1], // show only one month

        resizeButton: false, // deny resize picker
        fullsizeButton: false,
        fullsizeOnDblClick: false,

        timepicker: true, // use timepicker
        timepickerOptions: {
            hours: true,
            minutes: true,
            seconds: false,
            ampm: true
        }
    });
</script>

</body>
</html>