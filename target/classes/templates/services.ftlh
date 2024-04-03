<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/sign.css">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/menu.css">
</head>
<body>


<script>
    let refetch = () => {
        $.ajax({
            type: "GET",
            url: "/allservices",
            success: function(response) {
                // рисуем таблицу на основе ответа на запрос
                renderTable(response, $('#table'))
            },
            //тип данных, который мы отпралвяем
            dataType: "json",
            contentType: "application/json"
        })
    }
    // принимает пользователей в формате JSON и таблицу, которую нужно заполнить
    function renderTable(services, table) {

        let innerHtml = '<tr>\n' +
            '               <th>id</th>' +
            '               <th>Name</th>' +
            '               <th>Cost</th>' +
            '               <th>Date</th>' +
            '            </tr>';

        for (let i = 0; i < services.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + services[i]['id'] + '</td>';
            innerHtml += '  <td>' + services[i]['name'] + '</td>';
            innerHtml += '  <td>' + services[i]['cost'] + '</td>';
            innerHtml += '  <td>' + services[i]['date'] + '</td>';
            innerHtml += '</tr>';
        }

        table.html(innerHtml);
    }

    function sendUser(name, cost, date) {

        let data = {
            "name": name,
            "cost": cost,
            "date": date
        };

        $.ajax({
            type: "POST", // метод запроса
            url: "/services", //урл запроса
            data: JSON.stringify(data),  // данные для отправки из JSON-объекта превращаем в JSON-строку
            // // что происходит, если запрос прошел успешнго?
            success: refetch,
            //тип данных, который мы отпралвяем
            dataType: "json",
            contentType: "application/json"
        });
    }
</script>
<div class="container">
    <h1>Insert</h1>
    <hr>
    <label><b>Name</b></label>
    <input type="text" id="name" placeholder="Name">
    <label><b>Cost</b></label>
    <input type="text" id="cost" placeholder="Cost">
    <label><b>Time</b></label>
    <input type="text" id="date" placeholder="Time">
    <hr>
    <button class="button" onclick="sendUser($('#name').val(),
                              $('#cost').val(),
                              $('#date').val())">Добавить</button>
</div>
<div>
    <table id="table">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>cost</th>
            <th>date</th>
        </tr>
        <#list serviceList as services>
            <tr>
                <td>${services.id}</td>
                <td>${services.name}</td>
                <td>${services.cost}</td>
                <td>${services.date}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>