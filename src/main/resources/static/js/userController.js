var app = angular.module("userController",[]);


app.controller('getUserController', function ($scope,$http) {
    // $scope.getAllUsers = function () {
    $http.get('http://localhost:8080/api/user/viewU').then(function (response) {
        $scope.UserTable = response.data;
    });
    // }
});

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
