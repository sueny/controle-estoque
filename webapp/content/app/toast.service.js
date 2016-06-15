/**
 * Created by JOSEVALDERLEI on 27/06/2015.
 */
(function(){

    'use strict';

    angular.module('toastService',[])
        .controller('toastController', function($mdToast,toastApp) {
            var self = this;
            self.message =  toastApp.message;
            self.closeToast = function() {
                $mdToast.hide();
            };
        })
        .factory( 'toastApp', toastApp );

    toastApp.$inject = [ '$mdToast' ];

    function toastApp ($mdToast) {
        var service = {
            message: '',
            newmessage: newmessage,
            errorMessageBottom: errorMessageBottom
        };
        return service;

        /*function errorMessage(errorMessage) {
            $mdToast.show(
                $mdToast.simple()
                .textContent(errorMessage)
                .position('top right')
                .hideDelay(800)
            );
        }*/

        function newmessage(errorMessage) {
            this.message = errorMessage;
            $mdToast.show(
                {
                    controller: 'toastController',
                    controllerAs: 'vm',
                    templateUrl: '/views/forms/toast.html',
                    action: "OK",
                    highlightAction: true,
                    position: "bottom left",
                    hideDelay: 50000
                }
            );
        }

        function errorMessageBottom(errorMessage) {
            this.message = errorMessage;
            $mdToast.show(
                {
                    controller: 'toastController',
                    controllerAs: 'vm',
                    templateUrl: '/views/forms/toast.html',
                    action: "OK",
                    highlightAction: true,
                    position: "bottom left",
                    hideDelay: 100000
                }
            );
        }
    }

})();
