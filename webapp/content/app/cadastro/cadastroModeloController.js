/**
 * Created by jesus on 10/05/2016.
 */

(function () {

    'use strict';

    angular.module('app')
            .controller('cadastroModeloController', cadastroModeloController);

    function cadastroModeloController(toastApp, cadastroService, $mdDialog) {

        var self = this;
        self.initcadastroModelo = initcadastroModelo;
        self.cadastrarModelo = cadastrarModelo;
        self.excluirModelo = excluirModelo;
        self.listaUnidades;
        self.isBtnRemoveModelo = false;
        self.Modelo = {};
        self.listaModelo = [];
        self.selecionarModelo = selecionarModelo;
        self.campoOrdencao = 'nome';
        self.reverse = true;
        self.ordenaModelo = ordenaModelo;
        self.materialCategories = [];
        self.showGradeModelo = showGradeModelo;
        self.textBtnMostrarGrande = "";
        self.isVisibleGrandeModelo = false;
        self.resetFormModelo = resetFormModelo;
        self.loadSubcategories = loadSubcategories;



        function resetFormModelo(){
            self.Modelo = {};
            self.idSuper = undefined;
            self.isBtnRemoveModelo = false;
        }



        function showGradeModelo(){
            if(self.listaModelo.length > 0) {
                self.isVisibleGradeModelo = !self.isVisibleGradeModelo;
                if (self.isVisibleGradeModelo) {
                    self.textBtnMostrarGrade = "Ocultar Lista";
                } else {
                    self.textBtnMostrarGrade = "Listar";
                }
            }else {
                toastApp.newmessage('Não existe Modelo cadastrada.');
            }

        }


        function selecionarModelo(Modelo) {
            self.Modelo = Modelo;
            for(var i=0; i < self.categories.length; i++){
                for(var j=0; j < self.categories[i].listSubCategory.length; j++){
                    if(self.categories[i].listSubCategory[j].id == Modelo.productSubCategory.id){
                        self.idSuper = self.categories[i].id;
                        loadSubcategories(self.idSuper);
                        break
                    }
                }

            }
            self.Modelo.productSubCategory.id = Modelo.productSubCategory.id;
            self.isVisibleGradeModelo = false;
            self.textBtnMostrarGrade = "Listar";
            self.isBtnRemoveModelo = true;

        }

        function initcadastroModelo() {
            self.textBtnMostrarGrade = "Listar";
            cadastroService.listarCategoria()
                    .success(function (data) {
                        if(data.success){
                            self.categories = data.object;
                            cadastroService.listarModelo()
                                .success(function (data) {
                                    if(data.success){
                                        self.listaModelo = data.object;
                                    }
                                });
                        }
                    });
        };

        function loadSubcategories(id){
            for(var i=0; i < self.categories.length; i++){
                if(self.categories[i].id == id){
                    self.subCategories = self.categories[i].listSubCategory;
                    break
                }
            }
        }


        function excluirModelo(ev, Modelo) {
            var confirm = $mdDialog.confirm()
                    .parent(angular.element(document.body))
                    .title('Excluir Modelo ' + Modelo.name)
                    .ariaLabel('Excluir Modelo')
                    .ok('Sim')
                    .cancel('Não')
                    .targetEvent(ev);
            $mdDialog.show(confirm).then(function () {
                cadastroService.excluirModelo(Modelo)
                        .success(function (data) {
                            console.log(data)
                            if (data.success) {
                                toastApp.newmessage("Excluído com sucesso.");
                                var lista = self.listaModelo;
                                self.listaModelo = [];
                                for (var i = 0; i < lista.length; i++) {
                                    if (lista[i].id !== Modelo.id) {
                                        self.listaModelo.push(lista[i]);
                                    }
                                }
                                self.isBtnRemoveModelo = false;
                                resetFormModelo();
                            }else{
                                toastApp.newmessage("Problemas na remoção.");
                            }

            });
            });

        }
        function cadastrarModelo(Modelo) {
            if(self.Modelo.season === undefined || self.Modelo.season === ""){
                toastApp.newmessage("Selecione um tipo estação!");
                document.getElementById("selEstacao").focus();
                return
            }
            else if(self.idSuper === undefined || self.idSuper === ""){
                toastApp.newmessage("Selecione uma Catetoria!");
                document.getElementById("selCategoria").focus();
                return
            }
            else if(self.Modelo.productSubCategory === undefined || self.Modelo.productSubCategory === ""){
                toastApp.newmessage("Selecione uma Catetoria!");
                document.getElementById("selSubcategoria").focus();
                return
            }
            cadastroService.cadastrarModelo(Modelo)
                    .success(function (data) {
                        if (data.success) {
                            toastApp.newmessage("Cadastro realizado com Sucesso!");
                            resetFormModelo();
                            self.isBtnRemoveModelo = false;
                            initcadastroModelo();
                            return
                        }
                        toastApp.newmessage("Problemas.");
                    });

        }
        function ordenaModelo(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }
    }

})();
