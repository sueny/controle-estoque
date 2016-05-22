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
        var API_ROUTE_LISTARMATERIAPRIMA = 'https://httpbin.org/get';
        var API_ROUTE_CADASTRARFORNECEDOR = paths.apiUrl + 'fornecedor/cadastrar/';
        var API_ROUTE_EXCLUIRFORNECEDOR = paths.apiUrl + 'fornecedor/remover/';
        var API_ROUTE_LISTARFORNECEDOR = paths.apiUrl + 'fornecedor/listar/';
        var API_ROUTE_CADASTRARPRODUTO = paths.apiUrl + 'produto/cadastrar/';
        var API_ROUTE_EXCLUIRPRODUTO = paths.apiUrl + 'produto/remover/';
        var API_ROUTE_LISTARPRODUTO = paths.apiUrl + 'produto/listar/';

        var service = {
            cadastrarMateriaPrima: cadastrarMateriaPrima,
            excluirMateriaPrima: excluirMateriaPrima,
            listarMateriaPrima: listarMateriaPrima,
            cadastrarFornecedor: cadastrarFornecedor,
            excluirFornecedor: excluirFornecedor,
            listarFornecedor: listarFornecedor,
            cadastrarProduto: cadastrarProduto,
            excluirProduto: excluirProduto,
            listarProduto: listarProduto


        };
        return service;

        function cadastrarMateriaPrima(data) {
            return $http.post(API_ROUTE_CADASTRARMATERIALPRIMA, data);
        }
        function excluirMateriaPrima(data) {
            return $http.post(API_ROUTE_EXCLUIRMATERIAPRIMA, data);
        }

        function listarMateriaPrima() {
            console.log(paths.apiUrl)
            return $http.get(API_ROUTE_LISTARMATERIAPRIMA);
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

        function cadastrarProduto(data) {
            return $http.post(API_ROUTE_CADASTRARPRODUTO, data);
        }

        function excluirProduto(data) {
            return $http.post(API_ROUTE_EXCLUIRPRODUTO, data);
        }

        function listarProduto() {
            return $http.post(API_ROUTE_LISTARPRODUTO);
        }


    }


})();
