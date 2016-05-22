/**
 * Created by JOSEVALDERLEI on 25/06/2015.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .config(routes);
    function routes($stateProvider, $urlRouterProvider, paths) {
        $stateProvider.state('sistema', {
            url: '/',
            templateUrl: paths.staticPath + 'views/forms/sistema.html',
            controller: 'sistemaController as vm'
            }).state('sistema.cadastroMateriaPrima', {
            url: 'cadastromateriaprima',
            views: {
                'formulario': {
                    url: '/',
                    templateUrl: paths.staticPath + 'views/forms/cad_materiaprima.html',
                    controller: 'cadastroMateriaPrimaController as vm'
                }
            }
        }).state('sistema.informacao', {
            url: 'sobre',
            views: {
                'formulario': {
                    url: '/',
                    templateUrl: paths.staticPath + 'views/forms/informacao.html'
                }
            }
        }).state('sistema.cadastroFornecedor', {
            url: 'cadastrofornecedor',
            views: {
                'formulario': {
                    url: '/',
                    templateUrl: paths.staticPath + 'views/forms/cad_fornecedor.html',
                    controller: 'cadastroFornecedorController as vm'
                }
            }
        }).state('sistema.cadastroProduto', {
            url: 'cadastroproduto',
            views: {
                'formulario': {
                    url: '/',
                    templateUrl: paths.staticPath + 'views/forms/cad_produto.html',
                    controller: 'cadastroProdutoController as vm'
                }
            }
        });
        $urlRouterProvider.otherwise('/');

    }

})();
