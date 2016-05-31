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
        self.cadastrarCliente = cadastrarCliente;
        self.excluirCliente = excluirCliente;
        self.initcadastroCliente = initcadastroCliente;
        self.listaCliente;
        self.resetFormCliente = resetFormCliente;
        self.Cliente = limparFormCliente();
        self.success = "0";

        function resetFormCliente(){
            self.success = "0";
            self.Cliente = limparFormCliente();
        }

        function initcadastroCliente() {
            self.success = "0";
            cadastroService.listarCliente()
                .success(function (data) {
                    if(data.success){
                        self.success = "1";
                        self.listaCliente = data;
                    }
                    toastApp.newmessage(data.mensagem);
                });
        };

        function cadastrarCliente(Cliente){
            self.success = "0";
            cadastroService.cadastrarCliente(Cliente)
                .success(function (data) {
                    if (data.success) {
                        self.success = "1";
                        self.listaCliente.push(Cliente);
                    }
                    toastApp.newmessage(data.mensagem);
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
                        }
                    });

                self.isShow = false;
                toastApp.newmessage(data.message);
                self.Cliente = limparFormCliente();
            });
        }

        function limparFormCliente(){
            return   {
                id:"",
                type:"",
                name:"",
                phoneNumber:"",
                cellNumber:"",
                cnpj:"",
                cpf:"",
                ie:"",
                rg:"",
                address:"",
                number:"",
                neighborhood:"",
                cep:"",
                city:"",
                state:"",
                email:"",
                obs:""
            };

        }

    }





})();