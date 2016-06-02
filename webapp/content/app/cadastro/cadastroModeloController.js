/**
 * Created by jesus on 10/05/2016.
 */

(function () {

    'use strict';

    angular.module('app')
            .controller('cadastroModeloController', cadastroModeloController);

    function cadastroModeloController(toastApp, cadastroService, $mdDialog) {

        var self = this;
        self.initcadastroModelo = initCadastroModelo;
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

        initCadastroModelo();
        console.log("após init");

        function resetFormModelo(){
            self.Modelo = {id: null, name: "", description: ""};
        }

        function showGradeModelo(){
            if(self.listaModelo.length > 0) {
                self.isVisibleGradeModelo = !self.isVisibleGradeModelo;
                if (self.isVisibleGradeModelo) {
                    self.textBtnMostrarGrade = "Ocultar Grande de Modelo";
                } else {
                    self.textBtnMostrarGrade = "Mostrar Grade de Modelo";
                }
            }else {
                toastApp.newmessage('Não existe Modelo cadastrada.');
            }

        }


        function selecionarModelo(Modelo) {
            self.Modelo = Modelo;
            self.isBtnRemoveModelo = true;
        }

        function initCadastroModelo() {

          cadastroService.listarModelo().success(function (data) {
                      console.log(data)
                      if(data){
                          self.listaModelo = data;
                      }
                  });

            cadastroService.listarCategoriaProduto().success(function (data) {
                        console.log(data)
                        if(data){
                            self.categories = data;
                        }
                    });
        };

        function loadSubcategories(){
          console.log("lload");
          cadastroService.listarSubcategoriaProduto(self.chosenCategory)
                  .success(function (data) {
                      console.log(data)
                      console.log("lloaded");
                      if(data){
                          self.subCategories = data;
                      }
                  });
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
                            if (data) {
                                for (var i = 0; i < self.listaModelo.length; i++) {
                                    self.listaModelo[i].id === Modelo.id;
                                    self.listaModelo.splice(i, 1);
                                }
                            }
                            toastApp.newmessage(data.mensagem);
            });

                for (var i = 0; i < self.listaModelo.length; i++) {
                    console.log(self.listaModelo[i].id + ' === ' + Modelo.id)
                    if (self.listaModelo[i].id === Modelo.id) {
                        self.listaModelo.splice(i, 1);
                        break;
                    }
                }
                self.isBtnRemoveModelo = false;
                toastApp.newmessage('Removido a Modelo.');

                resetForm();
            });

        }
        function cadastrarModelo(Modelo) {
            console.log(Modelo);
            cadastroService.cadastrarModelo(Modelo)
                    .success(function (data) {
                        console.log(data);
                        if (data) {
                            self.listaModelo.push(data.object);
                        }
                            toastApp.newmessage(data.mensagem);
                    });

        }
        function ordenaModelo(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }
    }

})();
