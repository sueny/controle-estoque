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
         var api = 'http://10.1.1.103:8080/controle-estoque-web/api/';
        //var api = 'http://138.186.84.138/controle-estoque-web/api/';


        var API_ROUTE_CADASTRARESTOQUE = api + 'estoque/cadastrar/';
        var API_ROUTE_RECUPERARVARIOSESTOQUE = api + 'product/listarpornomeskucode/';
        var API_ROUTE_LISTACLIENTESPORNOME = api + 'customer/listarpornome/';
        var API_ROUTE_LISTACLIENTESCONSIGNACAOABERTA = api + 'customer/listarconsignacaoaberta/';
        var API_ROUTE_LISTACONSIGNACAO = api + 'consignacao/listarporcliente/';
        var API_ROUTE_CADASTRARCONSIGNACAO = api + 'consignacao/cadastrar/';
        var API_ROUTE_RECUPERARPRODUTOESTOQUE = api + 'estoque/listarproduto/';
        var API_ROUTE_ACERTARCONSIGNACAO = api + 'acertoconsignacao/cadastrar/';
        var API_ROUTE_RELATORIOTOPDEZ = api + 'relatorio/produtotop10/';


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