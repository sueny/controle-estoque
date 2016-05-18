/**
 * Created by jesus on 11/05/2016.
 */


(function(){

    'use strict';

    angular
        .module('app')
        .factory('materialCategoryService', materialCategoryService);

    materialCategoryService.$inject = ['$http','$location'];

    function materialCategoryService($http) {

        var API_ROUTE_CADASTRARMATERIALPRIMA = '/controle-estoque-web/api/materialcategory/cadastrar/';
        var API_ROUTE_EXCLUIRMATERIAPRIMA = '/controle-estoque-web/api/materialcategory/remover/';
        var API_ROUTE_LISTARMATERIAPRIMA = '/controle-estoque-web/api/materialcategory/listar/';


        var service = {
            cadastrar: cadastrar,
            excluir: excluir,
            listarTodas: listarTodas

        };
        return service;

        function cadastrar(data) {
            return $http.post(API_ROUTE_CADASTRARMATERIALPRIMA, data);
        }

        function excluir(data) {
            return $http.post(API_ROUTE_EXCLUIRMATERIAPRIMA, data);
        }

        function listarTodas() {
            return $http.post(API_ROUTE_LISTARMATERIAPRIMA);
        }


    }


})();