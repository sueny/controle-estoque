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
                    url: '/materiaprima',
                    templateUrl: paths.staticPath + 'views/forms/cad_materiaprima.html',
                    controller: 'cadastroMateriaPrimaController as vm'
                }
            }
        }).state('sistema.informacao', {
            url: 'sobre',
            views: {
                'formulario': {
                    url: '/informacao',
                    templateUrl: paths.staticPath + 'views/forms/informacao.html'
                }
            }
        }).state('sistema.menu', {
                url: 'menu',
                views: {
                    'formulario': {
                        url: '/menu',
                        templateUrl: paths.staticPath + 'views/forms/menu.html'
                    }
                }
            }).state('sistema.cadastroFornecedor', {
            url: 'cadastrofornecedor',
            views: {
                'formulario': {
                    url: '/fornecedor',
                    templateUrl: paths.staticPath + 'views/forms/cad_fornecedor.html',
                    controller: 'cadastroFornecedorController as vm'
                }
            }
        }).state('sistema.cadastroCliente', {
                url: 'cadastrocliente',
                views: {
                    'formulario': {
                        url: '/cliente',
                        templateUrl: paths.staticPath + 'views/forms/cad_cliente.html',
                        controller: 'cadastroClienteController as vm'
                    }
                }
            }).state('sistema.cadastroProduto', {
            url: 'cadastroproduto',
            views: {
                'formulario': {
                    url: '/produto',
                    templateUrl: paths.staticPath + 'views/forms/cad_produto.html',
                    controller: 'cadastroProdutoController as vm'
                }
            }
        }).state('sistema.cadastroModelo', {
                url: 'cadastromodelo',
                views: {
                    'formulario': {
                        url: '/modelo',
                        templateUrl: paths.staticPath + 'views/forms/cad_modelo.html',
                        controller: 'cadastroModeloController as vm'
                    }
                }
            }).state('sistema.estoque_entrada', {
            url: 'entrada',
            views: {
                'formulario': {
                    url: '/consignacao',
                    templateUrl: paths.staticPath + 'views/forms/estoque_entrada.html',
                    controller: 'estoqueController as vm'
                }
            }
        }).state('sistema.venda', {
                url: 'venda',
                views: {
                    'formulario': {
                        url: '/venda',
                        templateUrl: paths.staticPath + 'views/forms/venda.html',
                        controller: 'estoqueController as vm'
                    }
                }
            }).state('sistema.consignacao', {
            url: 'consignacao',
            views: {
                'formulario': {
                    url: '/consignacao',
                    templateUrl: paths.staticPath + 'views/forms/consignacao.html',
                    controller: 'estoqueController as vm'
                }
            }
        }).state('sistema.acerto', {
            url: 'acerto',
            views: {
                'formulario': {
                    url: '/acerto',
                    templateUrl: paths.staticPath + 'views/forms/acerto_consignacao.html',
                    controller: 'estoqueController as vm'
                }
            }
        }).state('sistema.grafico', {
            url: 'grafico',
            views: {
                'formulario': {
                    url: '/grafico',
                    templateUrl: paths.staticPath + 'views/forms/grafico.html',
                    controller: 'graficoController as vm'
                }
            }
        });
        $urlRouterProvider.otherwise('/');

    }

})();
