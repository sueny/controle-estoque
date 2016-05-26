/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('consignacaoController', consignacaoController);


    function consignacaoController(){
        var self = this;
        self.isShow = true;
        self.titleForm = "Nova Consignacao";

    }

})();