/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('vendaController', vendaController);


    function vendaController(){
        var self = this;
        self.isShow = true;
        self.titleForm = "Nova Venda";

    }

})();