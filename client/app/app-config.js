/**
 * Created by jesus on 06/05/2016.
 */
(function(){

    'use strict';

    angular
        .module('app')
        .config(appConfig);

    appConfig.$inject = ['$mdThemingProvider','$locationProvider'];

    function appConfig($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple', {
                'default': '400', // by default use shade 400 from the pink palette for primary intentions
                'hue-1': '100', // use shade 100 for the <code>md-hue-1</code> class
                'hue-2': '600', // use shade 600 for the <code>md-hue-2</code> class
                'hue-3': 'A100' // use shade A100 for the <code>md-hue-3</code> class
            })
            // If you specify less than all of the keys, it will inherit from the
            // default shades
            .accentPalette('purple', {
                'default': '200' // use shade 200 for default, and keep all other shades the same
            });
    }



})();