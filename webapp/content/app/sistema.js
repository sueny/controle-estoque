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

    function sistemaController($state,$scope){
        var self = this;
        self.showFormMateriaPrima = showFormMateriaPrima;
        self.showFormProduto = showFormProduto;
        self.showFormFornecedor = showFormFornecedor;
        self.showInformacao = showInformacao;
        self.showFormCliente = showFormCliente;
        self.showFormConsignacao = showFormConsignacao;
        self.showFormVenda = showFormVenda;
        self.showFormGrafico = showFormGrafico;
        self.setSubMenu = setSubMenu;
        self.initSistema = initSistema;
        self.voltar = false;

        function setSubMenu(submenu){
            if(submenu === 'Cadastro'){
                self.voltar = true;
                $scope.tabVisivel = tabCadastro;
            }else if(submenu === 'Movimentação'){
                self.voltar = true;
                $scope.tabVisivel = tabMovimentacao;
            }else if(submenu === 'Relatórios/Gráficos'){
                self.voltar = true;
                $scope.tabVisivel = tabRelatorio;
            }else if(submenu === 0){
                self.voltar = false;
                $scope.tabVisivel = tabSistema;
            }else {
                $state.go(submenu);
            }
        }

        function initSistema(){
            $state.go('sistema.informacao');
        }

        var tabSistema = [
            { titulo: 'Cadastro', acao: "Cadastro"},
            { titulo: 'Movimentação', acao: "Movimentação"},
            { titulo: 'Relatórios/Gráficos', acao: "Relatórios/Gráficos"},
            { titulo: 'Sobre', acao: "sistema.informacao"}
        ],
        tabCadastro = [
            { titulo: 'Cliente', acao: "sistema.cadastroCliente"},
            { titulo: 'Produto', acao: "sistema.cadastroProduto"},
            { titulo: 'Modelo', acao: "sistema.cadastroModelo"},
            { titulo: 'Matéria Prima', acao: "sistema.cadastroMateriaPrima"}
           /* { titulo: 'Fornecedor', acao: "sistema.cadastroFornecedor"}*/
        ],
        tabMovimentacao = [
            { titulo: 'Consignação', acao: "sistema.consignacao"},
            { titulo: 'Acerto Consigaçao', acao: "sistema.acerto"},
            { titulo: 'Venda', acao: "sistema.venda"},
            { titulo: 'Entrada', acao: "sistema.estoque_entrada"}
        ],
        tabRelatorio = [
            { titulo: 'Top 10 Vendas', acao: "sistema.grafico"}
        ],
            selected = null,
            previous = null;
        $scope.tabVisivel = tabSistema;
        $scope.selectedIndex = 4;
        $scope.$watch('selectedIndex', function(current, old){
            previous = selected;
            selected = tabSistema[current];
        });

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
        function showFormGrafico(){
            $state.go('sistema.grafico');
        }

    }

    })();
