/**
 * Created by jesus on 11/05/2016.
 */


(function(){

    'use strict';

    angular
        .module('app')
        .factory('materialCategoryService', materialCategoryService);

    materialCategoryService.$inject = ['$http','paths','$location'];

    function materialCategoryService($http, paths) {

        var API_ROUTE_CADASTRARMATERIALPRIMA = paths.apiUrl + 'materialcategory/cadastrar/';
        var API_ROUTE_EXCLUIRMATERIAPRIMA = paths.apiUrl + 'materialcategory/remover/';
        var API_ROUTE_LISTARMATERIAPRIMA = paths.apiUrl + 'materialcategory/listar/';


        var service = {
            cadastrar: cadastrar,
            excluir: excluir,
            listar: listar

        };
        return service;

        function cadastrar(data) {
            return $http.post(API_ROUTE_CADASTRARMATERIALPRIMA, data);
        }

        function excluir(data) {
            return $http.post(API_ROUTE_EXCLUIRMATERIAPRIMA, data);
        }

        function listar() {
            return $http.post(API_ROUTE_LISTARMATERIAPRIMA);
        }


    }


})();
