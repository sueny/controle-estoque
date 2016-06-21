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
        var API_ROUTE_CADASTRARFORNECEDOR = paths.apiUrl + 'supplier/cadastrar/';
        var API_ROUTE_EXCLUIRFORNECEDOR = paths.apiUrl + 'supplier/remover/';
        var API_ROUTE_LISTARFORNECEDOR = paths.apiUrl + 'supplier/listar/';
        var API_ROUTE_CADASTRARPRODUTO = paths.apiUrl + 'product/cadastrar/';
        var API_ROUTE_EXCLUIRPRODUTO = paths.apiUrl + 'product/remover/';
        var API_ROUTE_LISTARPRODUTO = paths.apiUrl + 'product/listar/';
        var API_ROUTE_CADASTRARCLIENTE = paths.apiUrl + 'customer/cadastrar/';
        var API_ROUTE_EXCLUIRCLIENTE = paths.apiUrl + 'customer/remover/';
        var API_ROUTE_LISTARCLIENTE = paths.apiUrl + 'customer/listar/';
        var API_ROUTE_CADASTRARMODELO = paths.apiUrl + 'productmodel/cadastrar/';
        var API_ROUTE_EXCLUIRMODELO = paths.apiUrl + 'productmodel/remover/';
        var API_ROUTE_LISTARMODELO = paths.apiUrl + 'productmodel/listar/';

        var API_ROUTE_LISTARCATEGORIA = paths.apiUrl + 'productcategory/listar';

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
            listarCliente: listarCliente,
            cadastrarModelo: cadastrarModelo,
            excluirModelo: excluirModelo,
            listarModelo: listarModelo,
            listarCategoria: listarCategoria,
            buscarClientes: buscarClientes

        };
        return service;

        function buscarClientes(data){
            return $http.post(API_ROUTE_BUSCARCLIENTES,data);
        }

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

        function cadastrarModelo(data) {
            return $http.post(API_ROUTE_CADASTRARMODELO, data);
        }

        function excluirModelo(data) {
            return $http.post(API_ROUTE_EXCLUIRMODELO, data);
        }

        function listarModelo() {
            return $http.post(API_ROUTE_LISTARMODELO);
        }

        function listarCategoria(){
            return $http.post(API_ROUTE_LISTARCATEGORIA);
        }
    }


})();
