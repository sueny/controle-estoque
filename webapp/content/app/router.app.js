/**
 * Created by JOSEVALDERLEI on 25/06/2015.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .config(routes);
    function routes($stateProvider, $urlRouterProvider, paths) {
        $stateProvider.state('cadastroMateriaPrima', {
            url: '/',
            templateUrl: paths.staticPath + 'views/forms/cad_materiaprima.html',
            controller: 'cadastroMateriaPrimaController as vm'
            });
        $urlRouterProvider.otherwise('/');

    }

})();
