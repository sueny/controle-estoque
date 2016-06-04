/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('estoqueController', estoqueController);


    function estoqueController(){
        var self = this;
        self.isShowFiltro = false;
        self.listaProdutos = [];
        self.initFormEstoque = initFormEstoque;
        self.operacaoEstoque = '';



        function initFormEstoque(operacao){
            switch (operacao) {
                case "consignacao":
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);

                    break;
                case "venda":
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);
                    break;
                default:
                    self.operacaoEstoque = operacao;
                    console.log(self.operacaoEstoque);
                    break;
            }
        }



    }

})();