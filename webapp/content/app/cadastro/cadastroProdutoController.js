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
        self.isShowBtnCadastrar = false;
        self.listaMateriaPrima = [];
        self.cadastrarProduto = cadastrarProduto;
        self.excluirProduto = excluirProduto;
        self.adicionarMateriaPrima = adicionarMateriaPrima;
        self.alertDeleteMateriaPrima = alertDeleteMateriaPrima;
        self.removerMateriaPrima = removerMateriaPrima;


        function adicionarMateriaPrima(materiaPrima){
            var mp = {
                id: self.listaMateriaPrima.length,
                name: materiaPrima.name,
                qte: materiaPrima.qte,
                isShow: false
            }
            self.listaMateriaPrima.push(mp);
            self.isShowBtnCadastrar = true;
        }
        function removerMateriaPrima(id){
            console.log(id);
            self.listaMateriaPrima.splice(id,1);
            if(self.listaMateriaPrima.length === 0) self.isShowBtnCadastrar = false;
        }
        function alertDeleteMateriaPrima(materiaPrima){
            materiaPrima.isShow = !materiaPrima.isShow;
        }



        function cadastrarProduto(produto){

        }

        function excluirProduto(produto){

        }

    }





})();