/**
 * Created by jesus on 20/05/2016.
 */


(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroProdutoController', cadastroProdutoController);


    function cadastroProdutoController(){
        var self = this;
        self.isShow = false;
        self.listaMateriaPrima = [];
        self.cadastrarProduto = cadastrarProduto;
        self.excluirProduto = excluirProduto;
        self.adicionarMateriaPrima = adicionarMateriaPrima;



        function adicionarMateriaPrima(materiaPrima){
            var mp = {
                name: materiaPrima.name,
                qte: materiaPrima.qte
            }
            self.listaMateriaPrima.push(mp);
        }

        function cadastrarProduto(produto){

        }

        function excluirProduto(produto){

        }

    }





})();