angular.module("myApp",[])
    .controller("AppCtrl",function ($scope) {
        $scope.tempInput = "test";
        $scope.tasksArray= ["first task","second task"];
        $scope.addNew = function () {
            if ($scope.tempInput) {
                $scope.tasksArray.push($scope.tempInput);
                $scope.tempInput = "";
            } else {
                console.log('empty');
            }
        }

        $scope.deleteItem = function (item) {
            var index = $scope.tasksArray.indexOf(item);
            console.log(index);
            $scope.tasksArray.splice(index,1);
        }
    });

// app.controller("AppCtrl",function ($scope,$http) {
//     //$scope.questionTable=[];
//     //      $scope.questionTable = [{
//     //          id:'',
//     //          name:"vasya",
//     //          password:'123',  
//     //          email:'12'
//     //      }];
// });

//$scope.message = "fine";

// $http.get('http://localhost:8080/api/quesyion/viewQ').success(function (data) {
//     $scope.questionTable = data;
// });