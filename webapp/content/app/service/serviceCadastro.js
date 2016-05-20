/**
 * Created by jesus on 11/05/2016.
 */


(function(){

    'use strict';

    angular
        .module('app')
        .factory('cadastroService', cadastroService);

   cadastroService.$inject = ['$http','paths', '$location'];

    function cadastroService($http, paths) {

        var API_ROUTE_CADASTRARMATERIALPRIMA = paths.apiUrl + 'material/cadastrar/';
        var API_ROUTE_EXCLUIRMATERIAPRIMA = paths.apiUrl + 'material/remover/';
        var API_ROUTE_LISTARMATERIAPRIMA = paths.apiUrl + 'material/listar/';
        var API_ROUTE_CADASTRARFORNECEDOR = paths.apiUrl + 'fornecedor/cadastrar/';
        var API_ROUTE_EXCLUIRFORNECEDOR = paths.apiUrl + 'fornecedor/remover/';
        var API_ROUTE_LISTARFORNECEDOR = paths.apiUrl + 'fornecedor/listar/';

        var service = {
            cadastrarMateriaPrima: cadastrarMateriaPrima,
            excluirMateriaPrima: excluirMateriaPrima,
            listarMateriaPrima: listarMateriaPrima,
            cadastrarFornecedor: cadastrarFornecedor,
            excluirFornecedor: excluirFornecedor,
            listarFornecedor: listarFornecedor

        };
        return service;

        function cadastrarMateriaPrima(data) {
            return $http.post(API_ROUTE_CADASTRARMATERIALPRIMA, data);
        }
        function excluirMateriaPrima(data) {
            return $http.post(API_ROUTE_EXCLUIRMATERIAPRIMA, data);
        }

        function listarMateriaPrima() {
            return $http.post(API_ROUTE_LISTARMATERIAPRIMA);
        }
        function cadastrarFornecedor(data) {
            return $http.post(API_ROUTE_CADASTRARFORNECEDOR, data);
        }

        function excluirFornecedor(data) {
            return $http.post(API_ROUTE_EXCLUIRFORNECEDOR, data);
        }

        function listarFornecedor() {
            return $http.post(API_ROUTE_LISTARFORNECEDOR);
        }


    }


})();
