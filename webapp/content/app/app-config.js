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

    appConfig.$inject = ['$mdThemingProvider','$locationProvider'];

    function appConfig($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple', {
                'default': '600', // by default use shade 400 from the pink palette for primary intentions
                'hue-1': '100', // use shade 100 for the <code>md-hue-1</code> class
                'hue-2': '400', // use shade 600 for the <code>md-hue-2</code> class
                'hue-3': 'A100' // use shade A100 for the <code>md-hue-3</code> class
            })
            // If you specify less than all of the keys, it will inherit from the
            // default shades
            .accentPalette('purple', {
                'default': '300' // use shade 200 for default, and keep all other shades the same
            });
    }



})();
