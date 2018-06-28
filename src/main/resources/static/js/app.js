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
        if($scope.page.newAnswerDelay > 0){
            $scope.page.newAnswerDelay--;
        }
        setTimeout($scope.countDown, 1000);
        $scope.$apply();
    };


    $scope.connect();
    $scope.getPage();
    setTimeout($scope.countDown, 1000);

    document.getElementById("Guess_button").onclick = function(e){
        document.getElementById("variantId").value = "";}
});

