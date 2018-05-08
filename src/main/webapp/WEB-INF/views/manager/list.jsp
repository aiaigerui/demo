<%--
  Created by IntelliJ IDEA.
  User: E-LINTER-002
  Date: 2018/1/1
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios@0.12.0/dist/axios.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/lodash@4.13.1/lodash.min.js"></script>

    <style>
        .active{
            height:100px;
            width:100px;
            background:aqua;
        }
        .fade-enter-active, .fade-leave-active {
            transition: opacity .5s
        }
        .fade-enter, .fade-leave-to /* .fade-leave-active in below version 2.1.8 */ {
            opacity: 0
        }
    </style>
</head>
<body>
<div id="demo">
    <button v-on:click="show = !show">
        Toggle
    </button>
    <transition name="fade">
        <p v-if="show">hello</p>
    </transition>
</div>
</body>
<script>
    new Vue({
        el: '#demo',
        data: {
            show: true
        }
    })

</script>
</html>
