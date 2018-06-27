var app = angular.module("app",[]);

// ws = new WebSocket('ws://localhost:8080/api');
// ws.onmessage = function(data){};

//one

app.controller('mainController',function ($scope,$http) {

    var Game =  {};



    $scope.socket = null;
    $scope.timer = null;

    $scope.connect = (function() {
        $scope.socket = new SockJS("/app");
        $scope.socket.onopen = function () {
            $scope.timer = setInterval(function() {
                $scope.socket.send('ping');
            }, 30000);
        };
        $scope.socket.onclose = function () {
            //$scope.timer.cancel();
        };
        $scope.socket.onmessage = function (message) {
            switch (message.data) {
                case 'refresh':
                     $scope.getPage();

            }
        };
    });


    $scope.guess = function (variant) {
        $http.get('app/try?variant=' + variant).then(function (response) {
            $scope.page = response.data;
            variant=' ';
        });
    };

    $scope.getPage=function(){
        $http.get('app/show').then(function (response) {
            $scope.page = response.data;
        });
    };
    
    $scope.countDown= function () {
        if($scope.page.newGameDelay > 0) {
            $scope.page.newGameDelay--;

        }
        if($scope.page.answerDelay>0){
            $scope.page.answerDelay--;
        }
        setTimeout($scope.countDown, 1000);
    };


    $scope.connect();
    $scope.getPage();
    setTimeout($scope.countDown, 1000);
});


















//
//
//
// app.controller('getEmail',function ($scope, $http) {
//
//     $scope.something1 = "wtf";
//     $scope.something2 = "da";
//     $http.get('http://localhost:8080/api/email/get').then(function (response) {
//         $scope.user = response.data;
//         $scope.email = response.data.principal.attributes.email;
//         $scope.something1 = "wtf2";
//         $scope.something2 = "da2";
//     });
// });
//
//
//
// app.controller('getRandomQuestionController', function ($scope,$http) {
//
//     $scope.RandomQuestion="";
//
//     $scope.getRandomQuestion = function () {
//         $http.get('http://localhost:8080/api/question/RandomQ').then(function (response) {
//
//             $scope.RandomQuestion = response.data;
//         });
//     };
//
//     $scope.getEmail = function () {
//         var url = 'http://localhost:8080/api/email/get';
//
//         $http.get(url).then(function (response) {
//             $scope.someEmail = response.data;
//             $scope.something1 = "wtf";
//             $scope.something2 = "da";
//         });
//     };
//
//
//
//
//
// app.controller('postUserController', function($scope, $http) {
//     $scope.submitForm = function(item) {
//
//         var url = 'http://localhost:8080/api/user/adding';
//
//         $http.post(url, item).then(function (response) {
//             $scope.item = response.data;
//         });
//
//         $scope.name = "";
//         $scope.password = "";
//         $scope.email = "";
//     }
// });
//
