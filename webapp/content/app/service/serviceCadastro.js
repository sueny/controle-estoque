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
       // var api = 'http://192.168.137.73:8080/controle-estoque-web/api/';
         //var api = 'http://138.186.84.138/controle-estoque-web/api/';
        var api=  'http://10.1.1.103:8080/controle-estoque-web/api/';

        var API_ROUTE_CADASTRARMATERIALPRIMA = api + 'material/cadastrar/';
        var API_ROUTE_EXCLUIRMATERIAPRIMA = api + 'material/remover/';
        var API_ROUTE_LISTARMATERIAPRIMA = api + 'material/listar/';
        var API_ROUTE_CADASTRARFORNECEDOR = api + 'supplier/cadastrar/';
        var API_ROUTE_EXCLUIRFORNECEDOR = api + 'supplier/remover/';
        var API_ROUTE_LISTARFORNECEDOR = api + 'supplier/listar/';
        var API_ROUTE_CADASTRARPRODUTO = api + 'product/cadastrar/';
        var API_ROUTE_EXCLUIRPRODUTO = api + 'product/remover/';
        var API_ROUTE_LISTARPRODUTO = api + 'product/listar/';
        var API_ROUTE_CADASTRARCLIENTE = api + 'customer/cadastrar/';
        var API_ROUTE_EXCLUIRCLIENTE = api + 'customer/remover/';
        var API_ROUTE_LISTARCLIENTE = api + 'customer/listar/';
        var API_ROUTE_CADASTRARMODELO = api + 'productmodel/cadastrar/';
        var API_ROUTE_EXCLUIRMODELO = api + 'productmodel/remover/';
        var API_ROUTE_LISTARMODELO = api + 'productmodel/listar/';
        var API_ROUTE_BUSCARCLIENTES = api + 'customer/search'

        var API_ROUTE_LISTARCATEGORIA = api + 'productcategory/listar';

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
