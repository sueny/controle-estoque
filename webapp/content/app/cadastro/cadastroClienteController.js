/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroClienteController', cadastroClienteController);


    function cadastroClienteController(cadastroService,toastApp,$mdDialog){
        var self = this;
        self.isShow = true;
        self.isVisibleGradeCliente = false;
        self.textBtnMostrarGradeCliente = "Listar";
        self.cadastrarCliente = cadastrarCliente;
        self.excluirCliente = excluirCliente;
        self.initCadastroCliente = initCadastroCliente;
        self.listaCliente = [];
        self.resetFormCliente = resetFormCliente;
        self.Client = {};
        self.success = "0";
        self.showGradeCliente = showGradeCliente;
        self.selecionarCliente = selecionarCliente;




        function showGradeCliente(){
            self.isVisibleGradeCliente = true;
            self.textBtnMostrarGradeCliente = "Ocultar";
        }

        function resetFormCliente(){
            self.success = "0";
            limparFormCliente();
        }

        function selecionarCliente(cliente){
            console.log(cliente);
            self.Client = cliente;
            self.isShow = !self.isShow;
            self.isVisibleGradeCliente = false;
            self.textBtnMostrarGradeCliente = "Listar";
        }

        function initCadastroCliente() {
           /* for(var i = 0; i < 10; i++){
                if((i % 2) === 0){
                    var cli = {id:i, type:'F', name: "Maria Carolina " + i}
                }else{
                    var cli = {id:i, type:'J', name: "Maria Carolina " + i}
                }
                self.listaCliente.push(cli);
            }
*/
            self.success = "0";
            cadastroService.listarCliente()
                .success(function (data) {
                    if(data.success){
                        self.success = "1";
                        self.listaCliente = data.object;

                    }else{
                        toastApp.newmessage("Problema ao carregar Clientes.");
                    }

                });
        };

        function cadastrarCliente(Cliente){
            self.success = "0";
            cadastroService.cadastrarCliente(Cliente)
                .success(function (data) {
                    if (data.success) {
                        self.success = "1";
                        self.listaCliente.push(Cliente);
                        toastApp.newmessage("Operação realizada com sucesso.");
                        self.isVisibleGradeCliente = false;
                        self.textBtnMostrarGradeCliente = "Listar";
                        resetFormCliente();
                    }else{
                        toastApp.newmessage("Problema ao cadastrar Cliente.");
                    }

                });

        }

        function excluirCliente(ev, Cliente) {
            self.success = "0";
            var confirm = $mdDialog.confirm()
                .parent(angular.element(document.body))
                .title('Excluir Cliente')
                .content('Cliente: ' + Cliente.name)
                .ariaLabel('Excluir cliente')
                .ok('Sim')
                .cancel('Não')
                .targetEvent(ev);
            $mdDialog.show(confirm).then(function () {
                cadastroService.excluirCliente(Cliente)
                    .success(function (data) {
                        if (data.success) {
                            self.success = "1";
                            for (var i = 0; i < self.listaCliente.length; i++) {
                                self.listaCliente[i].id === Cliente.id;
                                self.listaCliente.splice(i, 1);
                            }
                            self.isVisibleGradeCliente = false;
                            self.textBtnMostrarGradeCliente = "Listar";
                            self.isShow = false;
                            toastApp.newmessage("Cliente Removido!");
                            limparFormCliente();
                        }else{
                            toastApp.newmessage("Problema ao remover Cliente!");
                        }
                    });


            });
        }

        function limparFormCliente(){
            self.Client  =  {}
        }

    }





})();