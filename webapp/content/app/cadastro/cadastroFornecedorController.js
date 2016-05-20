/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('cadastroFornecedorController', cadastroFornecedorController);


    function cadastroFornecedorController(cadastroService,toastApp,$mdDialog){
        var self = this;
        self.isShow = false;
        self.cadastrarFornecedor = cadastrarFornecedor;
        self.excluirFornecedor = excluirFornecedor;
        self.initcadastroFornecedor = initcadastroFornecedor;
        self.listaFornecedor;
        self.fornecedor = {
            id:"",
            name:"",
            phoneNumber:"",
            cellNumber:"",
            cnpj:"",
            ie:"",
            address:"",
            number:"",
            neighborhood:"",
            cep:"",
            city:"",
            state:"",
            email:"",
            obs:""
        }

        function initcadastroFornecedor() {
            cadastroService.listarFornecedor()
                .success(function (data) {
                    if(data){
                        //Ajustar o número e Endereço
                        self.fornecedor = data;
                    }
                    toastApp.newmessage(data.mensagem);
                });
        };

        function cadastrarFornecedor(fornecedor){
            var  fornecedor = {
                id:"",
                name: fornecedor.name,
                phoneNumber: fornecedor.phoneNumber,
                cellNumber:fornecedor.cellNumber,
                cnpj:fornecedor.cnpj,
                ie:fornecedor.ie,
                address:fornecedor.address + ', ' +fornecedor.number,
                neighborhood: fornecedor.neighborhood,
                cep: fornecedor.cep,
                city:fornecedor.city,
                state:fornecedor.state,
                email:fornecedor.email,
                obs:fornecedor.obs
            }
            cadastroService.cadastrarFornecedor(fornecedor)
                .success(function (data) {
                    if (data) {
                        self.listaFornecedor.push(fornecedor);
                    }
                    toastApp.newmessage(data.mensagem);
                });

        }

        function excluirFornecedor(ev, fornecedor) {
            var confirm = $mdDialog.confirm()
                .parent(angular.element(document.body))
                .title('Excluir Forededor')
                .content('Fornecedor: ' + fornecedor.name)
                .ariaLabel('Excluir Fornecedor')
                .ok('Sim')
                .cancel('Não')
                .targetEvent(ev);
            $mdDialog.show(confirm).then(function () {
                cadastroService.excluirFornecedor(fornecedor)
                    .success(function (data) {
                        if (data) {
                            for (var i = 0; i < self.listaFornecedor.length; i++) {
                                self.listaFornecedor[i].id === fornecedor.id;
                                self.listaFornecedor.splice(i, 1);
                            }
                        }
                    });

                self.isShow = false;
                toastApp.newmessage(data.message);
                self.fornecedor = limparFormFornecedor();
            });
        }

        function limparFormFornecedor(){
            return   {
                id:"",
                name:"",
                phoneNumber:"",
                cellNumber:"",
                cnpj:"",
                ie:"",
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

        self.listaEstados = [{
            "Sigla": "AC",
            "Nome": "Acre"
        },
            {
                "Sigla": "AL",
                "Nome": "Alagoas"
            },
            {
                "Sigla": "AM",
                "Nome": "Amazonas"
            },
            {
                "Sigla": "AP",
                "Nome": "Amapá"
            },
            {
                "Sigla": "BA",
                "Nome": "Bahia"
            },
            {
                "Sigla": "CE",
                "Nome": "Ceará"
            },
            {
                "Sigla": "DF",
                "Nome": "Distrito Federal"
            },
            {
                "Sigla": "ES",
                "Nome": "Espírito Santo"
            },
            {
                "Sigla": "GO",
                "Nome": "Goiás"
            },
            {
                "Sigla": "MA",
                "Nome": "Maranhão"
            },
            {
                "Sigla": "MG",
                "Nome": "Minas Gerais"
            },
            {
                "Sigla": "MS",
                "Nome": "Mato Grosso do Sul"
            },
            {
                "Sigla": "MT",
                "Nome": "Mato Grosso"
            },
            {
                "Sigla": "PA",
                "Nome": "Pará"
            },
            {
                "Sigla": "PB",
                "Nome": "Paraíba"
            },
            {
                "Sigla": "PE",
                "Nome": "Pernambuco"
            },
            {
                "Sigla": "PI",
                "Nome": "Piauí"
            },
            {
                "Sigla": "PR",
                "Nome": "Paraná"
            },
            {
                "Sigla": "RJ",
                "Nome": "Rio de Janeiro"
            },
            {
                "Sigla": "RN",
                "Nome": "Rio Grande do Norte"
            },
            {
                "Sigla": "RO",
                "Nome": "Rondônia"
            },
            {
                "Sigla": "RR",
                "Nome": "Roraima"
            },
            {
                "Sigla": "RS",
                "Nome": "Rio Grande do Sul"
            },
            {
                "Sigla": "SC",
                "Nome": "Santa Catarina"
            },
            {
                "Sigla": "SE",
                "Nome": "Sergipe"
            },
            {
                "Sigla": "SP",
                "Nome": "São Paulo"
            },
            {
                "Sigla": "TO",
                "Nome": "Tocantins"
            }]

    }





})();