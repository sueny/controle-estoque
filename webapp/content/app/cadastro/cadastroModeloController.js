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

        function initcadastroModelo() {
            cadastroService.listarCategoria()
                    .success(function (data) {
                        console.log(data)
                        if(data){
                            self.categories = data;
                        }
                    });
        };

        function loadSubcategories(){
          cadastroService.listarSubcategoria(self.chosenCategory)
                  .success(function (data) {
                      console.log(data)
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
                toastApp.newmessage('Removido a Modelo com o SKU.' + Modelo.sku);

                resetForm();
            });

        }
        function cadastrarModelo(Modelo) {

            cadastroService.cadastrarModelo(Modelo)
                    .success(function (data) {
                        if (data) {
                            self.listaModelo.push(Modelo);
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
