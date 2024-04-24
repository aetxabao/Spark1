<!DOCTYPE html>
<html>
<head>
    <title>Productos!</title>
    <meta charset="UTF-8"/>
    <#-- Referencia a un recurso estático -->
    <link rel="stylesheet" href="style/estilo.css"/>
</head>
<body>
<#-- Se puede inyectar el nombre del usuario -->
<h1>Bienvenido ${usuario}!</h1>
<p>Último producto:
    <#-- Se puede inyectar un objeto y utilizar sus atributos (getters) -->
    <a href="${ultimoProducto.url}">${ultimoProducto.nombre}</a>!
</p>

<p>Nuestros productos:
<ol>
    <#-- Iteración sobre unaa lista de objetos -->
    <#list productos as producto>
        <li>
            <a href="${producto.url}">${producto.nombre}</a>
        </li>
    </#list>
</ol>
</p>

<p>
    <#-- Estructura condicional -->
    <#if usuario == "Aitor">
        <b>Tú eres Aitor!</b>
    <#else>
        <i>Tú no eres Aitor!</i>
    </#if>
</p>

<#-- Referencia a un recurso estático -->
<div id="logo">
    <img src="imgs/mas.jpeg">
</div>

</body>
</html>