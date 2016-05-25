/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroClienteCliente', cadastroClienteCliente);


    function cadastroClienteCliente(cadastroService,toastApp,$mdDialog){
        var self = this;
        self.isShow = true;
        self.cadastrarCliente = cadastrarCliente;
        self.excluirCliente = excluirCliente;
        self.initcadastroCliente = initcadastroCliente;
        self.listaCliente;
        self.resetFormCliente = resetFormCliente;
        self.Cliente = limparFormCliente();

        function resetFormCliente(){
            self.Cliente = limparFormCliente();
        }

        function initcadastroCliente() {
            cadastroService.listarCliente()
                .success(function (data) {
                    if(data){
                        //Ajustar o número e Endereço
                        self.listarCliente = data;
                    }
                    toastApp.newmessage(data.mensagem);
                });
        };

        function cadastrarCliente(Cliente){
            cadastroService.cadastrarCliente(Cliente)
                .success(function (data) {
                    if (data) {
                        self.listaCliente.push(Cliente);
                    }
                    toastApp.newmessage(data.mensagem);
                });

        }

        function excluirCliente(ev, Cliente) {
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
                        if (data) {
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