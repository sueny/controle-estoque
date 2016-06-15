/**
 * Created by jesus on 05/06/2016.
 */

(function(){

    'use strict';

    angular
        .module('app')
        .factory('movimentacaoService', movimentacaoService);

    movimentacaoService.$inject = ['$http'];

    function movimentacaoService($http) {
        //var api = paths.apiUrl;
        // var api = 'http://192.168.137.73:8080/controle-estoque-web/api/';
        var api = 'http://138.186.84.138/controle-estoque-web/api/';


        var API_ROUTE_CADASTRARESTOQUE = api + 'estoque/cadastrar/';
        var API_ROUTE_RECUPERARVARIOSESTOQUE = api + 'product/listarpornomeskucode/';
        var API_ROUTE_LISTACLIENTESPORNOME = api + 'customer/listarpornome/';
        var API_ROUTE_LISTACONSIGNACAO = api + 'consignacao/listarporcliente/';
        var API_ROUTE_CADASTRARCONSIGNACAO = api + 'consignacao/cadastrar/';
        var API_ROUTE_RECUPERARPRODUTOESTOQUE = api + 'estoque/listarproduto/';
        var API_ROUTE_ACERTARCONSIGNACAO = api + 'acertoconsignacao/cadastrar';

        var service = {
            cadastrarEstoque: cadastrarEstoque,
            recuperarListaCliente:recuperarListaCliente,
            recuperarProdutos: recuperarProdutos,
            cadastrarConsignacao: cadastrarConsignacao,
            listarConsignacao: listarConsignacao,
            listarConsignacaoPorCliente: listarConsignacaoPorCliente,
            recuperarProdutoEstoque: recuperarProdutoEstoque,
            acertarConsignacao: acertarConsignacao

        };
        return service;
        function recuperarProdutoEstoque(data){
            return $http.post(API_ROUTE_RECUPERARPRODUTOESTOQUE, data);

        }
        function cadastrarEstoque(data) {
            return $http.post(API_ROUTE_CADASTRARESTOQUE, data);
        }
        function recuperarListaCliente(data) {
            return $http.post(API_ROUTE_LISTACLIENTESPORNOME, data);
        }

        function recuperarProdutos(data) {
            return $http.post(API_ROUTE_RECUPERARVARIOSESTOQUE,data);
        }

        function cadastrarConsignacao(data) {
            return $http.post(API_ROUTE_CADASTRARCONSIGNACAO,data);
        }

        function listarConsignacao(data) {
            return $http.post(API_ROUTE_LISTACONSIGNACAO,data);
        }

        function listarConsignacaoPorCliente(data){
            return $http.post(API_ROUTE_LISTACONSIGNACAO,data);
        }

        function acertarConsignacao(data){
            return $http.post(API_ROUTE_ACERTARCONSIGNACAO,data);
        }

    }
})();