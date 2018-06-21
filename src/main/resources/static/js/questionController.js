var app = angular.module("questionController",[]);


app.controller('getQuestionController', function ($scope,$http) {
    // $scope.getAllUsers = function () {
    $http.get('http://localhost:8080/api/question/viewQ').then(function (response) {
        $scope.QuestionTable = response.data;
    });
    // }
});

app.controller('getRandomQuestionController', function ($scope,$http) {
    $scope.getRandomQuestion = function () {
        $http.get('http://localhost:8080/api/question/RandomQ').then(function (response) {
            //$scope.QuestionTable2 = [];

            $scope.RandomQuestion = response.data;
        });
    };
});