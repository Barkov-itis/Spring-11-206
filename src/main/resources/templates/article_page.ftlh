<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form action="/users/${user.id}/articles" method="post">
        <input name="email" type="email" placeholder="EMAIL">
        <input name="password" type="password" placeholder="PASSWORD">
        <input type="submit" value="SIGN UP">
    </form>
</div>
<div>
    <table>
        <tr>
            <th>Article</th>
        </tr>
        <#list articles as article>
            <tr>
                <td>${article.text}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>