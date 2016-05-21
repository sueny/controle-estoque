/**
 * Created by jesus on 20/05/2016.
 */


(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroProdutoController', cadastroProdutoController);


    function cadastroProdutoController(toastApp, cadastroService, $mdDialog){
        var self = this;
        self.isShow = false;
        self.isShowBtnCadastrar = false;
        self.listaMateriaPrima = [];
        self.cadastrarProduto = cadastrarProduto;
        self.excluirProduto = excluirProduto;
        self.adicionarMateriaPrima = adicionarMateriaPrima;
        self.alertDeleteMateriaPrima = alertDeleteMateriaPrima;
        self.removerMateriaPrima = removerMateriaPrima;
        self.listaProduto = self.listaProduto;


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
            var novaLista = [];
            for (var i = 0; i < self.listaMateriaPrima.length; i++) {
                    var mp = self.listaMateriaPrima[i];
                    mp.id = i;
                    novaLista.push(mp);
            }
            self.listaMateriaPrima = novaLista;
            if(self.listaMateriaPrima.length === 0) self.isShowBtnCadastrar = false;
        }
        function alertDeleteMateriaPrima(materiaPrima){
            materiaPrima.isShow = !materiaPrima.isShow;
        }



        function cadastrarProduto(produto){
            cadastroService.cadastrarProduto(produto)
                .success(function (data) {
                    if (data) {
                        self.listaProduto.push(produto);
                    }
                    toastApp.newmessage(data.mensagem);
                });
        }

        function excluirProduto(ev, produto) {
                var confirm = $mdDialog.confirm()
                    .parent(angular.element(document.body))
                    .title('Excluir Produto')
                    .content('Produto: ' + produto.name)
                    .ariaLabel('Excluir Produto')
                    .ok('Sim')
                    .cancel('Não')
                    .targetEvent(ev);
                $mdDialog.show(confirm).then(function () {
                    cadastroService.excluirProduto(produto)
                        .success(function (data) {
                            if (data) {

                            }
                        });

                    self.isShow = false;
                    toastApp.newmessage(data.message);
                    //Limpar campos form
                });

        }

    }





})();