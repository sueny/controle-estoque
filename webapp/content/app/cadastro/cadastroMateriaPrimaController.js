/**
 * Created by jesus on 10/05/2016.
 */

(function () {

    'use strict';

    angular.module('app')
            .controller('cadastroMateriaPrimaController', cadastroMateriaPrimaController);

    function cadastroMateriaPrimaController(toastApp, cadastroService, $mdDialog) {

        var self = this;
        self.initcadastroMateriaPrima = initcadastroMateriaPrima;
        self.cadastrarMateriaPrima = cadastrarMateriaPrima;
        self.buscaUnidadesMateriaPrima = buscaUnidadesMateriaPrima;
        self.excluirMateriaPrima = excluirMateriaPrima;
        self.listaUnidades;
        self.isBtnRemoveMateriaPrima = false;
        self.materiaprima = {};
        self.listaMateriaPrima = [];
        self.selecionarMateriaPrima = selecionarMateriaPrima;
        self.campoOrdencao = 'nome';
        self.reverse = true;
        self.ordenaMateriaPrima = ordenaMateriaPrima;
        self.materialCategories = [];
        self.showGradeMateriaPrima = showGradeMateriaPrima;
        self.textBtnMostrarGrade = "";
        self.isVisibleGradeMateriaPrima = false;
        self.resetFormMateriaPrima = resetFormMateriaPrima;



        function resetFormMateriaPrima(){
            self.materiaprima = {id: null, name: "", skuCode: "", measuringUnit: "", description: ""};
        }




        function showGradeMateriaPrima(){
            if(self.listaMateriaPrima.length > 0) {
                self.isVisibleGradeMateriaPrima = !self.isVisibleGradeMateriaPrima;
                if (self.isVisibleGradeMateriaPrima) {
                    self.textBtnMostrarGrade = "Ocultar Grade de Materia Prima";
                } else {
                    self.textBtnMostrarGrade = "Mostrar Grade de Materia Prima";
                }
            }else {
                toastApp.newmessage('Não existe materia prima cadastrada.');
            }

        }




        function buscaUnidadesMateriaPrima() {
            self.listaUnidades = ['Kg', 'm']
        }

        function selecionarMateriaPrima(materiaPrima) {
            self.materiaprima = materiaPrima;
            self.isBtnRemoveMateriaPrima = true;

        }

        function initcadastroMateriaPrima() {
            cadastroService.listarMateriaPrima()
                    .success(function (data) {
                        console.log(data)
                        /*if(data){
                            self.listaMateriaPrima = data;
                         if(self.listaMateriaPrima.length > 0) {
                            self.textBtnMostrarGrade = "Mostrar Grade de Materia Prima";
                         }
                        }
                        toastApp.newmessage(data.mensagem);*/
                    });
        };


        function excluirMateriaPrima(ev, materiaPrima) {
            var confirm = $mdDialog.confirm()
                    .parent(angular.element(document.body))
                    .title('Excluir Matéria prima com Sku' + materiaPrima.skuCode)
                    .content('Materia Prima: ' + materiaPrima.name)
                    .ariaLabel('Excluir Materia Prima')
                    .ok('Sim')
                    .cancel('Não')
                    .targetEvent(ev);
            $mdDialog.show(confirm).then(function () {
                cadastroService.excluirMateriaPrima(materiaPrima)
                        .success(function (data) {
                            if (data) {
                                for (var i = 0; i < self.listaMateriaPrima.length; i++) {
                                    self.listaMateriaPrima[i].id === materiaPrima.id;
                                    self.listaMateriaPrima.splice(i, 1);
                                }
                            }
                            toastApp.newmessage(data.mensagem);
            });

                for (var i = 0; i < self.listaMateriaPrima.length; i++) {
                    console.log(self.listaMateriaPrima[i].id + ' === ' + materiaPrima.id)
                    if (self.listaMateriaPrima[i].id === materiaPrima.id) {
                        self.listaMateriaPrima.splice(i, 1);
                        break;
                    }
                }
                self.isBtnRemoveMateriaPrima = false;
                toastApp.newmessage('Removido a Materia Prima com o SKU.' + materiaPrima.sku);

                resetForm();
            });

        }
        function cadastrarMateriaPrima(materiaPrima) {

            cadastroService.cadastrarMateriaPrima(materiaPrima)
                    .success(function (data) {
                        if (data) {
                            self.listaMateriaPrima.push(materiaPrima);
                        }
                            toastApp.newmessage(data.mensagem);
                    });

            /*  var materiaprima = {id: self.listaMateriaPrima.length+1, nome: materiaPrima.nome, sku: materiaPrima.sku, unidade: materiaPrima.unidade, observacao: materiaPrima.observacao};
             self.listaMateriaPrima.push(materiaprima);
             self.materiaprima = {id: null,nome: "", sku: "", unidade: "", observacao: ""};
             toastApp.newmessage('Cadastro realizado com sucesso para o SKU.' + materiaPrima.sku);
             */
        }

        function ordenaMateriaPrima(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }



    }

})();
