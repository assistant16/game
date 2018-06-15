var app = angular.module("userController",[]);


app.controller('getUserController', function ($scope,$http) {
        $scope.UserTable = [];

        $http.get('http://localhost:8080/api/user/viewU').then(function (response) {
            $scope.UserTable = response.data;
        });
});

﻿

app.controller('postUserController', function($scope, $http) {
    var url = 'http://localhost:8080/api/user/addingU';

    var data = {
        name: $scope.name,
        password: $scope.password,
        email: $scope.emacr
    };

    $http.post(url, data).then(function (response) {
        $scope.postResultMessage = response.data;
    }, function error(response) {
        $scope.postResultMessage = "Error with status: " +  response.statusText;
    });

    $scope.name = "";
    $scope.password = "";
    $scope.email = "";
});
