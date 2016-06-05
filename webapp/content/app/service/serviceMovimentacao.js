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
        var API_ROUTE_RECUPERARUMESTOQUE = api + 'estoque/recuperarUmEstoque/';
        var API_ROUTE_RECUPERARVARIOSESTOQUE = api + 'estoque/recuperarVarios/';



        var service = {
            cadastrarEstoque: cadastrarEstoque,
            recuperarUmEstoque: recuperarUmEstoque,
            recuperarVariosEstoque: recuperarVariosEstoque


        };
        return service;

        function cadastrarEstoque(data) {
            return $http.post(API_ROUTE_CADASTRARESTOQUE, data);
        }
        function recuperarUmEstoque(data) {
            return $http.post(API_ROUTE_RECUPERARUMESTOQUE, data);
        }

        function recuperarVariosEstoque() {
            return $http.post(API_ROUTE_RECUPERARVARIOSESTOQUE);
        }

    }
})();