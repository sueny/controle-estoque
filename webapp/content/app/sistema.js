/**
 * Created by jesus on 20/05/2016.
 */

(function(){


    'use strict';

    angular.module('app')
        .filter('keyboardShortcut', function($window) {
            return function(str) {
                if (!str) return;
                var keys = str.split('-');
                var isOSX = /Mac OS X/.test($window.navigator.userAgent);
                var seperator = (!isOSX || keys.length > 2) ? '+' : '';
                var abbreviations = {
                    M: isOSX ? '⌘' : 'Ctrl',
                    A: isOSX ? 'Option' : 'Alt',
                    S: 'Shift'
                };
                return keys.map(function(key, index) {
                    var last = index == keys.length - 1;
                    return last ? key : abbreviations[key];
                }).join(seperator);
            };
        })
        .controller('sistemaController', sistemaController);


    function sistemaController($state,toastApp){

        var self = this;

        self.showFormMateriaPrima = showFormMateriaPrima;
        self.showFormProduto = showFormProduto;
        self.showFormFornecedor = showFormFornecedor;
        self.showInformacao = showInformacao;
        self.showFormCliente = showFormCliente;
        self.showFormConsignacao = showFormConsignacao;
        self.showFormVenda = showFormVenda;

        function showFormMateriaPrima(){
            $state.go('sistema.cadastroMateriaPrima');
        }
        function showFormProduto(){
            $state.go('sistema.cadastroProduto');
        }
        function showFormFornecedor(){
            $state.go('sistema.cadastroFornecedor');
        }
        function showFormCliente(){
            $state.go('sistema.cadastroCliente');
        }
        function showInformacao(){
            $state.go('sistema.informacao');
        }

        function showFormConsignacao(){
            $state.go('sistema.consignacao');
        }
        function showFormVenda(){
            $state.go('sistema.venda');
        }

    }

    })();
