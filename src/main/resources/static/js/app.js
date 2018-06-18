var app = angular.module("app",[]);

ws = new WebSocket('ws://localhost:8080/api');
ws.onmessage = function(data){};


app.controller('getUserController', function ($scope,$http) {
    $http.get('http://localhost:8080/api/user/viewU').then(function (response) {
        $scope.UserTable = response.data;
    });
});﻿

app.controller('postUserController', function($scope, $http) {
    $scope.submitForm = function(item) {

        var url = 'http://localhost:8080/api/user/adding';

        $http.post(url, item).then(function (response) {
            $scope.item = response.data;
        });

        $scope.name = "";
        $scope.password = "";
        $scope.email = "";
    }
});

app.controller('getQuestionController', function ($scope,$http) {
    $http.get('http://localhost:8080/api/question/viewQ').then(function (response) {
        $scope.QuestionTable = response.data;
    });
    // }
});

app.controller('getRandomQuestionController', function ($scope,$http) {

    $scope.RandomQuestion="";

    $scope.getRandomQuestion = function () {
        $http.get('http://localhost:8080/api/question/RandomQ').then(function (response) {

            $scope.RandomQuestion = response.data;
        });
    };

    $scope.tryAnswer=function(response) {

    }
});

// $scope.tryAnswer=function(response) {
//
//         //$scope.localAnswer = response.data;
//     $scope.data;
//         if ($scope.RandomQuestion == response.data )
//         {
//             $http.get('http://localhost:8080/api/question/winQQ');
//         }
//         else {
//             $http.get('http://localhost:8080/api/question/tryQ');
//         }};


//for example

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});