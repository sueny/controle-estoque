/**
 * Created by jesus on 05/06/2016.
 */

(function(){

    'use strict';

    angular
        .module('app')
        .factory('movimentacaoService', movimentacaoService);

    movimentacaoService.$inject = ['$http','paths'];

    function movimentacaoService($http,paths) {

        var API_ROUTE_CADASTRARESTOQUE = paths.apiUrl + 'estoque/cadastrar/';
        var API_ROUTE_RECUPERARVARIOSESTOQUE = paths.apiUrl + 'product/listarpornomeskucode/';
        var API_ROUTE_LISTACLIENTESPORNOME = paths.apiUrl + 'customer/listarpornome/';
        var API_ROUTE_LISTACLIENTESCONSIGNACAOABERTA = paths.apiUrl + 'customer/listarconsignacaoaberta/';
        var API_ROUTE_LISTACONSIGNACAO = paths.apiUrl + 'consignacao/listarporcliente/';
        var API_ROUTE_CADASTRARCONSIGNACAO = paths.apiUrl + 'consignacao/cadastrar/';
        var API_ROUTE_RECUPERARPRODUTOESTOQUE = paths.apiUrl + 'estoque/listarproduto/';
        var API_ROUTE_ACERTARCONSIGNACAO = paths.apiUrl + 'acertoconsignacao/cadastrar/';
        var API_ROUTE_RELATORIOTOPDEZ = paths.apiUrl + 'relatorio/produtotop10/';


        var service = {
            cadastrarEstoque: cadastrarEstoque,
            recuperarListaCliente:recuperarListaCliente,
            recuperarProdutos: recuperarProdutos,
            cadastrarConsignacao: cadastrarConsignacao,
            listarConsignacao: listarConsignacao,
            listarConsignacaoPorCliente: listarConsignacaoPorCliente,
            recuperarProdutoEstoque: recuperarProdutoEstoque,
            acertarConsignacao: acertarConsignacao,
            relatorioTopDez : relatorioTopDez,
            recuperarListaClientesAcerto: recuperarListaClientesAcerto

        };
        return service;

        function relatorioTopDez(){
            return $http.post(API_ROUTE_RELATORIOTOPDEZ);
        }

        function recuperarProdutoEstoque(data){
            return $http.post(API_ROUTE_RECUPERARPRODUTOESTOQUE, data);

        }
        function cadastrarEstoque(data) {
            return $http.post(API_ROUTE_CADASTRARESTOQUE, data);
        }
        function recuperarListaCliente(data) {
            return $http.post(API_ROUTE_LISTACLIENTESPORNOME, data);
        }

        function recuperarListaClientesAcerto(data) {
            return $http.post(API_ROUTE_LISTACLIENTESCONSIGNACAOABERTA, data);
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