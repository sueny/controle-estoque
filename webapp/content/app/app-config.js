/**
 * Created by jesus on 06/05/2016.
 */
(function(){

    'use strict';

    var staticPath = '';
    var apiUrl = 'http://localhost:8080/controle-estoque-web/api/';

    angular
        .module('app')
        .constant('paths', {
          staticPath: staticPath,
          apiUrl: apiUrl
        })
        .config(appConfig);

    /*Mock backend*/
    var myAppDev = angular.module('myAppDev', ['app', 'ngMockE2E']);

    myAppDev.run(function($httpBackend) {
      var categories = [
        {
          id: 1,
          name: 'Blusas e camisetas'
        },
        {
          id: 2,
          name: 'Acessórios'
        }
      ];

      var subCategories = [
        [{
          id: 1,
          name: "Blusas",
          category: {id: 1}
        },
        {
          id: 2,
          name: "Camisetas",
          category: {id: 1}
        },
        {
          id: 3,
          name: "Tops",
          category: {id: 1}
        }],
        [{
          id: 4,
          name: "Acessórios diversos",
          category: {id: 2}
        }]
      ];

      var modelos = [{id: 1, name: "Modelo exemplo"}];

      $httpBackend.whenPOST('/controle-estoque-web/api/productsupercategory/listar/').respond(categories);
      $httpBackend.whenPOST('/controle-estoque-web/api/productsubcategory/listar/1').respond(subCategories[0]);
      $httpBackend.whenPOST('/controle-estoque-web/api/productsubcategory/listar/2').respond(subCategories[1]);
      $httpBackend.whenPOST('/controle-estoque-web/api/productmodel/listar/').respond(modelos);

      $httpBackend.whenPOST('/controle-estoque-web/api/productmodel/cadastrar/').respond(function(method, url, data) {
        var m = angular.fromJson(data);
        m.id = modelos.reduce(function(a, b){return Math.max(a, b.id)}, 0) + 1;
        modelos.push(m);
        return [200, {mensagem: "Modelo cadastrado com sucesso!", object: m}, {}];
      });
      // Passthrough everything
      $httpBackend.whenGET(/[\s\S]*/).passThrough();
      //...
    });

    appConfig.$inject = ['$mdThemingProvider','$locationProvider'];

    function appConfig($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple', {
                'default': '300', // by default use shade 400 from the pink palette for primary intentions
                'hue-1': '100', // use shade 100 for the <code>md-hue-1</code> class
                'hue-2': '200', // use shade 600 for the <code>md-hue-2</code> class
                'hue-3': 'A100' // use shade A100 for the <code>md-hue-3</code> class
            })
            // If you specify less than all of the keys, it will inherit from the
            // default shades
            .accentPalette('deep-purple', {
                'default': '500' // use shade 200 for default, and keep all other shades the same
            });
    }



})();
