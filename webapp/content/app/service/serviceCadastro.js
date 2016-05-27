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
        //var api = paths.apiUrl;
        var api = 'http://177.91.224.214/controle-estoque-web/api/';

        var API_ROUTE_CADASTRARMATERIALPRIMA = api + 'material/cadastrar/';
        var API_ROUTE_EXCLUIRMATERIAPRIMA = api + 'material/remover/';
        var API_ROUTE_LISTARMATERIAPRIMA = api + 'material/listar/';
        var API_ROUTE_CADASTRARFORNECEDOR = api + 'fornecedor/cadastrar/';
        var API_ROUTE_EXCLUIRFORNECEDOR = api + 'fornecedor/remover/';
        var API_ROUTE_LISTARFORNECEDOR = api + 'fornecedor/listar/';
        var API_ROUTE_CADASTRARPRODUTO = api + 'produto/cadastrar/';
        var API_ROUTE_EXCLUIRPRODUTO = api + 'produto/remover/';
        var API_ROUTE_LISTARPRODUTO = api + 'produto/listar/';
        var API_ROUTE_CADASTRARCLIENTE = api + 'cliente/cadastrar/';
        var API_ROUTE_EXCLUIRCLIENTE = api + 'cliente/remover/';
        var API_ROUTE_LISTARCLIENTE = api + 'cliente/listar/';

        var service = {
            cadastrarMateriaPrima: cadastrarMateriaPrima,
            excluirMateriaPrima: excluirMateriaPrima,
            listarMateriaPrima: listarMateriaPrima,
            cadastrarFornecedor: cadastrarFornecedor,
            excluirFornecedor: excluirFornecedor,
            listarFornecedor: listarFornecedor,
            cadastrarProduto: cadastrarProduto,
            excluirProduto: excluirProduto,
            listarProduto: listarProduto,
            cadastrarCliente: cadastrarCliente,
            excluirCliente: excluirCliente,
            listarCliente: listarCliente


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

        function cadastrarProduto(data) {
            return $http.post(API_ROUTE_CADASTRARPRODUTO, data);
        }

        function excluirProduto(data) {
            return $http.post(API_ROUTE_EXCLUIRPRODUTO, data);
        }

        function listarProduto() {
            return $http.post(API_ROUTE_LISTARPRODUTO);
        }

        function cadastrarCliente(data) {
            return $http.post(API_ROUTE_CADASTRARCLIENTE, data);
        }

        function excluirCliente(data) {
            return $http.post(API_ROUTE_EXCLUIRCLIENTE, data);
        }

        function listarCliente() {
            return $http.post(API_ROUTE_LISTARCLIENTE);
        }
    }


})();
