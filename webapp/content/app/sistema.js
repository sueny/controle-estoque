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

    function sistemaController($state,$window,$scope){
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

        /*function setSubMenu(tab){
            $window.localStorage.setItem('submenu',0);
            $window.localStorage.setItem('indice',tab.indice);
            if(tab.titulo === 'Cadastro'){
                self.voltar = false;
                $scope.tabVisivel = tabCadastro;
                $window.localStorage.setItem('indiceMenu',1);
                $window.localStorage.setItem('indice',1);
            }else if(tab.titulo === 'Movimentação'){
                self.voltar = false;
                $scope.tabVisivel = tabMovimentacao;
                $window.localStorage.setItem('indice',2);
                $window.localStorage.setItem('indiceMenu',2);
            }else if(tab.titulo === 'Relatórios/Gráficos'){
                $scope.selectedIndex = undefined;
                self.voltar = false;
                $scope.tabVisivel = tabRelatorio;
                $window.localStorage.setItem('indice',3);
                $window.localStorage.setItem('indiceMenu',3);
            }else if(tab.titulo === 0){
                $window.localStorage.setItem('submenu',1);
                self.voltar = true;
                $scope.selectedIndex = undefined;
                $scope.tabVisivel = tabSistema;
                $state.go("sistema.menu");
                $window.localStorage.setItem('indice',0);
                $window.localStorage.setItem('indiceMenu',0);
            }else {
                $window.localStorage.setItem('submenu',0);
                $state.go(tab.acao);
            }
        }

        function initSistema(){
            var indice = $window.localStorage.getItem('indice');
            var submenu = $window.localStorage.getItem('submenu');
            var indiceMenu = $window.localStorage.getItem('indiceMenu');
            if(indice === null){
                $window.localStorage.setItem('indice',0);
                $window.localStorage.setItem('submenu',0);
            }else{
                if(submenu === '0') submenu = false;
                else submenu = true;
                $scope.selectedIndex = indice;
            }
            self.voltar = submenu;

            console.log(indice + '  ' + self.voltar + '  ' + indiceMenu)
            switch (indiceMenu) {
                case "0":
                    $scope.tabVisivel = tabSistema;
                    self.voltar = true;
                    break
                case "1":
                    $scope.tabVisivel = tabCadastro;
                    self.voltar = true;
                    break
                case "2":
                    $scope.tabVisivel = tabMovimentacao;
                    self.voltar = true;
                    break
                case "3":
                    $scope.tabVisivel = tabRelatorio;
                    break
                default:
                    self.voltar = false;
                    $scope.tabVisivel = tabSistema;
            }

        }*/
        function setSubMenu(tab){
            $window.localStorage.setItem('indice',tab.indice);
            if(tab.titulo === 'Cadastro'){
                self.voltar = true;
                console.log('Cadastro...')
                $scope.tabVisivel = tabCadastro;
                $window.localStorage.setItem('indiceMenu',1);
                self.selectedIndex = undefined;
            }else if(tab.titulo === 'Movimentação'){
                self.voltar = true;
                console.log('Movimentação...')
                $scope.tabVisivel = tabMovimentacao;
                $window.localStorage.setItem('indiceMenu',2);
                self.selectedIndex = undefined;
            }else if(tab.titulo === 'Relatórios/Gráficos'){
                self.voltar = true;
                self.selectedIndex = undefined;
                $scope.tabVisivel = tabRelatorio;
                $window.localStorage.setItem('indiceMenu',3);
            }else if(tab.titulo === 0){
                console.log('home...')
                $scope.selectedIndex = undefined;
                $window.localStorage.setItem('indiceMenu',0);
                self.voltar = false;
                $scope.selectedIndex = undefined;
                $scope.tabVisivel = tabSistema;
                $state.go("sistema.menu");

            }else {
                self.voltar = true;
                $state.go(tab.acao);
            }
        }

        function initSistema(){
            var indice = $window.localStorage.getItem('indice');
            var indiceMenu = $window.localStorage.getItem('indiceMenu');
            console.log(indice + '  ' + self.voltar + '  ' + indiceMenu);
            if(indice === null){
                $scope.selectedIndex = undefined;
                $window.localStorage.setItem('indiceMenu',0);
            }else{
                $scope.selectedIndex = indice;
            }
            console.log(indice + '  ' + self.voltar + '  ' + indiceMenu);

            switch (indiceMenu) {
                case "0":
                    $scope.tabVisivel = tabSistema;
                    self.voltar = false;
                    console.log('tabSistema' + '  ' + self.voltar + '  ' + indiceMenu)
                    break
                case "1":
                    $scope.tabVisivel = tabCadastro;
                    self.voltar = true;
                    console.log('tabCadastro' + '  ' + self.voltar + '  ' + indiceMenu)
                    break
                case "2":
                    $scope.tabVisivel = tabMovimentacao;
                    console.log('tabMovimentacao' + '  ' + self.voltar + '  ' + indiceMenu)
                    self.voltar = true;
                    break
                case "3":
                    $scope.tabVisivel = tabRelatorio;
                    console.log('tabRelatorio' + '  ' + self.voltar + '  ' + indiceMenu)
                    self.voltar = true;
                    break
                default:
                    self.voltar = false;
                    $scope.tabVisivel = tabSistema;
            }

        }
        var tabSistema = [
            { titulo: 'Cadastro', acao: "Cadastro", indice:0},
            { titulo: 'Movimentação', acao: "Movimentação", indice:1},
            { titulo: 'Relatórios/Gráficos', acao: "Relatórios/Gráficos", indice:2},
            { titulo: 'Sobre', acao: "sistema.informacao", indice:3}
        ],
        tabCadastro = [
            { titulo: 'Cliente', acao: "sistema.cadastroCliente", indice:0},
            { titulo: 'Produto', acao: "sistema.cadastroProduto", indice:1},
            { titulo: 'Modelo', acao: "sistema.cadastroModelo", indice:2},
            { titulo: 'Matéria Prima', acao: "sistema.cadastroMateriaPrima", indice:3}
           /* { titulo: 'Fornecedor', acao: "sistema.cadastroFornecedor"}*/
        ],
        tabMovimentacao = [
            { titulo: 'Consignação', acao: "sistema.consignacao", indice:0},
            { titulo: 'Acerto Consigaçao', acao: "sistema.acerto", indice:1},
            { titulo: 'Venda', acao: "sistema.venda", indice:2},
            { titulo: 'Entrada', acao: "sistema.estoque_entrada", indice:3}
        ],
        tabRelatorio = [
            { titulo: 'Top 10 Vendas', acao: "sistema.grafico", indice:0}
        ],
            selected = null,
            previous = null;
        $scope.tabVisivel = tabSistema;
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
