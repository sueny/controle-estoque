/**
 * Created by jesus on 10/05/2016.
 */

(function () {

    'use strict';

    angular.module('app')
            .controller('cadastroMateriaPrimaController', cadastroMateriaPrimaController);

    function cadastroMateriaPrimaController(toastApp, materiaPrimaService, $mdDialog) {

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




        function buscaUnidadesMateriaPrima() {
            self.listaUnidades = ['Kg', 'm']
        }

        function selecionarMateriaPrima(materiaPrima) {
            self.materiaprima = materiaPrima;
            self.isBtnRemoveMateriaPrima = true;

        }

        function initcadastroMateriaPrima() {
            materiaPrimaService.listarTodas()
                    .success(function (data) {
                        console.log(data);
                        self.listaMateriaPrima = data;

                    });


            /*  var materiaprima = {id: 1, nome: "X Tecido", sku: "00000X999", unidade: "KG", observacao: "Teste de X"};
             self.listaMateriaPrima.push(materiaprima);
             var materiaprima = {id: 2, nome: "B Tecido", sku: "00000B003", unidade: "KG", observacao: "Teste de B"};
             self.listaMateriaPrima.push(materiaprima);
             var materiaprima = {id: 3, nome: "A Tecido", sku: "00000X999", unidade: "KG", observacao: "Teste de A"};
             self.listaMateriaPrima.push(materiaprima);
             */
        }


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
                materiaPrimaService.excluir(materiaPrima)
                        .success(function (data) {
                            if (data) {
                                for (var i = 0; i < self.listaMateriaPrima.length; i++) {
                                    self.listaMateriaPrima[i].id === materiaPrima.id;
                                    self.listaMateriaPrima.splice(i, 1);
                                }
                                toastApp.newmessage('Removido com sucesso!.');
                            } else {
                                toastApp.newmessage('Problema ao Acessar o servidor');
                            }
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

                self.materiaprima = {id: null, name: "", skuCode: "", measuringUnit: "", description: ""};
            });

        }
        function cadastrarMateriaPrima(materiaPrima) {

            materiaPrimaService.cadastrar(materiaPrima)
                    .success(function (data) {
                        console.log(data);
                        if (data) {
                            self.listaMateriaPrima.push(materiaPrima);
                            toastApp.newmessage('Cadastro realizado com sucesso!');
                        } else {
                            toastApp.newmessage('Problema ao Acessar a o servidor');
                        }
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