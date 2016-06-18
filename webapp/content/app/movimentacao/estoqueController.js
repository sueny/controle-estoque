/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('estoqueController', estoqueController);


    function estoqueController(toastApp, $scope, $timeout, movimentacaoService,cadastroService){
        var self = this;
        self.isShowFiltro = true;
        self.isSelectCosignacao = false;
        self.listaBuscaProduto = [];
        self.listaBuscaProdutoEstoque = [];
        self.initFormAcerto = initFormAcerto;
        self.initFormConsignacao = initFormConsignacao;
        self.operacaoEstoque = '';
        self.buscarListaCliente = buscarListaCliente;
        self.buscarListaProdutos = buscarListaProdutos;
        self.buscarListaProdutoEstoque = buscarListaProdutoEstoque;
        self.Busca = { campo:'name'};
        self.estoque = { data: new Date()}
        self.campoOrdencao = 'name';
        self.ordenaProduto = ordenaProduto;
        self.selecionarProduto = selecionarProduto;
        self.isVisibleGradeModelo = false;
        self.resetFormEstoque = resetFormEstoque;
        self.inserirEntradaEstoque = inserirEntradaEstoque;
        self.selecionarCliente = selecionarCliente;
        self.consignacao = {};
        self.listaBuscaCliente = [];
        self.montarKit = montarKit;
        self.selecionarProdutoConsignacao = selecionarProdutoConsignacao;
        self.fecharKit = fecharKit;
        self.totalGeralConsignacao = 0.00;
        self.retirarProduto = retirarProduto;
        self.item = {};
        self.novaConsignacao = novaConsignacao;
        self.quantityEstoque = 0;
        self.consignacaoList = [];
        self.isSelectClienteCosignacao = true;
        self.selecionarClienteAcerto = selecionarClienteAcerto;
        self.selecionarConsigacao = selecionarConsigacao;
        self.textBtnMostrarGradeAcerto = 'Listar';
        self.mostraGradeAcerto = mostraGradeAcerto;
        self.isVisibleGradeAcerto = false;
        self.client = {};
        self.alterarRetorno = alterarRetorno;
        self.validaDevolver = validaDevolver;
        self.fecharAcerto = fecharAcerto;
        self.novoAcerto = novoAcerto;
        self.cancelarProduto = cancelarProduto;
        self.priceVendido = 0;
        self.workSystem = false;

        function novoAcerto(){
            self.consignacaoList = [];
            self.isShowFiltro = true;
            self.isSelectCosignacao = false;
            self.priceVendido = 0;
            self.consignacaoList = [];
        }

        function fecharAcerto(consignacao){
            var lista = [];
            for(var i =0; i < self.consignacao.productList.length; i++){
                var item = {
                    stock: self.consignacao.productList[i].stock,
                    quantity :self.consignacao.productList[i].quantity,
                    quantityAcerto : self.consignacao.productList[i].quantityAcerto,
                    quantityRetorno : self.consignacao.productList[i].quantityRetorno
                }
                lista.push(item);
            }
            var obj = {
                id: "",
                dataSaida: formataData(consignacao.dataSaida),
                dataRetorno: formataData(consignacao.dataRetorno),
                consignment: { id: consignacao.id },
                client: consignacao.client,
                productList: lista,
                obs: consignacao.obs
            };
            movimentacaoService.acertarConsignacao(obj)
                .success(function(data){
                    if(data.success){
                        toastApp.newmessage('Gravado com suceso');
                        novoAcerto();
                    }else{
                        toastApp.newmessage('Problema na gravação do acerto');
                    }
                })

        }

        function alterarRetorno(item,index){
            if(item.quantityAcerto === undefined ){
                item.quantityAcerto = 0;
                ajustaTela(item);
                return
            }
            if(item.quantityAcerto > item.quantity){
                toastApp.newmessage('Valor deve ser menor que ' + item.quantity);
                item.quantityAcerto = 0;
                ajustaTela(item);
                document.getElementById("quantityAcerto"+index).focus();
                return
            }
            ajustaTela(item)
        }

        var ajustaTela = function(item){
            self.priceVendido = 0;
            self.priceDevolvido = self.consignacao.priceTotal;
            item.quantityRetorno = item.quantity - item.quantityAcerto;
            for(var i=0; i < self.consignacao.productList.length; i++){
                self.priceVendido = self.priceVendido + ((self.consignacao.productList[i].quantity - self.consignacao.productList[i].quantityRetorno) * self.consignacao.productList[i].price);
            }
            self.priceDevolvido =  self.consignacao.priceTotal - self.priceVendido;
        }
        function validaDevolver(item,index){
            if(item.quantityAcerto === undefined ){
                item.quantityAcerto = 0;
            }
            var soma = item.quantity - item.quantityAcerto;
            if(soma < item.quantityRetorno){
                toastApp.newmessage('Valor deve ser menor que ' + soma);
                document.getElementById("quantityRetorno"+index).focus();
                item.quantityAcerto = item.quantity - soma;
                item.quantityRetorno = soma;
                ajustaTela(item);
                return
            }
        }
        function mostraGradeAcerto(){
            if(self.consignacaoList.length > 0) {
                self.isVisibleGradeAcerto = !self.isVisibleGradeAcerto;
                if (self.isVisibleGradeAcerto) {
                    self.textBtnMostrarGradeAcerto = "Ocultar";
                } else {
                    self.textBtnMostrarGradeAcerto = "Listar";
                }
            }else {
                toastApp.newmessage('Não existe consignação.');
            }
        }
        function selecionarConsigacao(cons){
            cons.dataRetorno = new Date();
            cons.dataSaida = dataToDateJS(cons.dataSaida);
            cons.client = self.consignacao.client;
            self.consignacao = cons;
            self.isVisibleGradeAcerto = false;
            self.textBtnMostrarGradeAcerto = "Listar";
            self.isSelectCosignacao = true;
            self.priceDevolvido = self.consignacao.priceTotal;
        }
        function selecionarClienteAcerto(cliente){
            self.consignacao.client = cliente;
            self.isShowFiltro = false;
            self.isSelectCosignacao = true;
            buscarListaConsignacao(cliente);
        }

        function retirarProduto(index, item){
            self.totalGeralConsignacao =  (self.totalGeralConsignacao - (item.quantity * item.price))
            self.consignacao.productList.splice(index,1);
        }
        function novaConsignacao(){
            self.isShowFiltro = true;
            self.isSelectCosignacao = true;
            self.listaBuscaProduto = [];
            self.Busca = { campo:'name'};
            self.isVisibleGradeModelo = false;
             self.consignacao = {};
            self.listaBuscaCliente = [];
            self.totalGeralConsignacao = 0.00;
            self.item = {};
            initFormConsignacao();
        }
        var novoKit = function(){
            self.isSelectCosignacao = false;
            self.consignacao.productList = [];
            self.totalGeralConsignacao =  0.00;
            self.item = {};
            self.isSelectCosignacao = !self.isSelectCosignacao;
            initFormConsignacao();
        }
        function fecharKit(consignacao){
            if(consignacao.type === "C") {
                if (consignacao.dataRetorno === undefined || consignacao.dataRetorno === "") {
                    toastApp.newmessage("Data Prevista de Retorno.");
                    document.getElementById("dataRetornoCliente").focus();
                    return;
                }else{
                    consignacao.dataRetorno = consignacao.dataSaida;
                }
            }
            var lista = [];
            for(var i =0; i < self.consignacao.productList.length; i++){
                var item = {
                    stock: { id: self.consignacao.productList[i].id },
                    quantity :self.consignacao.productList[i].quantity,
                    price: self.consignacao.productList[i].price,
                }
                lista.push(item);
            }
            var obj = {
                id: "",
                type: consignacao.type,
                dataSaida: formataData(consignacao.dataSaida),
                dataRetorno: formataData(consignacao.dataRetorno),
                client: consignacao.client,
                productList: lista,
                obs: consignacao.obs
            };
            movimentacaoService.cadastrarConsignacao(obj)
                .success(function(data){
                    if(data.success){
                        self.listaBuscaProdutoEstoque = [];
                        var msg = "Consignação cadastrada."
                        if(consignacao.type === 'V') msg = "Operação de venda realizada."
                        toastApp.newmessage(msg);

                    }else{
                        toastApp.newmessage("Erro ao Cadastrar estoque");
                    }
                });
            novoKit();
        }

        var tempoEsgotado = function() {
            self.workSystem = false;
            toastApp.newmessage("Servidor não está disponível.");
        }

        function buscarListaCliente(cliente){
            if(cliente.name === undefined || cliente.name == ""){
                toastApp.newmessage("Digite inicias do nome...");
                document.getElementById("nameCliente").focus();
                return
            }
            self.workSystem = true;
            var acesso = $timeout(tempoEsgotado, 8000);

            movimentacaoService.recuperarListaCliente(cliente)
                .success(function(data){
                   if(data.success){
                       self.listaBuscaCliente = data.object;
                       if(self.listaBuscaCliente.length < 1){
                           toastApp.newmessage("Não exitem clientes para esta busca.");
                           document.getElementById("nameCliente").focus();
                       }
                   }else{
                       toastApp.newmessage("Problema com acesso ao servidor.");
                   }
                    self.workSystem = false;
                    $timeout.cancel(acesso);
                });

        }

        function montarKit(item){
            var adicionar = true;
            if(self.quantityEstoque < item.quantity){
                toastApp.newmessage("Valor está superior a quantidade em estoque.");
                document.getElementById("quantity").focus();
                return;
            }
            for(var i=0; i < self.consignacao.productList.length; i++){
                if(item.product.id === self.consignacao.productList[i].product.id){
                    if(item.price === self.consignacao.productList[i].price){
                        self.consignacao.productList[i].quantity = self.consignacao.productList[i].quantity + item.quantity;
                        adicionar = false;
                    }
                }
            }
            self.quantityEstoque = 0;
            if(adicionar) self.consignacao.productList.push(item);
            self.totalGeralConsignacao =  self.totalGeralConsignacao + (item.quantity * item.price)
            self.item = {};
            self.isSelectCosignacao = !self.isSelectCosignacao;
        }

        var formataData = function (data){
            var dia = data.getDate();
            if (dia.toString().length == 1)
                dia = "0"+dia;
            var mes = data.getMonth()+1;
            if (mes.toString().length == 1)
                mes = "0"+mes;
            var ano = data.getFullYear();
            return ano+"-"+mes+"-"+dia;
        }

        function inserirEntradaEstoque(estoque){
            var obj = {
                "id":'',
                "data": formataData(estoque.data),
                "product": estoque.product,
                "quantity": estoque.quantity,
                "price": estoque.price,
                "obs": estoque.obs
            };
            movimentacaoService.cadastrarEstoque(obj)
                .success(function(data){
                    if(data.success){
                        toastApp.newmessage("Produto Cadastrado com Sucesso.");
                        resetFormEstoque();
                    }else{
                        toastApp.newmessage("Erro ao cadastrar no estoque.");
                    }
                });
        }


        function resetFormEstoque(){
            self.Busca = { campo:'name'};
            self.estoque = { data: new Date()};
            self.isShowFiltro = !self.isShowFiltro;

        }

        function selecionarProduto(produto){
            self.estoque = { product: produto, data: new Date() };
            self.isShowFiltro = !self.isShowFiltro;
            return
        }

        function cancelarProduto(){
          self.isSelectCosignacao = !self.isSelectCosignacao;
        }

        function selecionarProdutoConsignacao(item){
            var quantitySelected = 0;
            for(var i =0; i < self.consignacao.productList.length; i++){
                if(self.consignacao.productList[i].id === item.id){
                    quantitySelected = quantitySelected + self.consignacao.productList[i].quantity;
                }
            }
            self.quantityEstoque = (item.quantity - quantitySelected);
            self.item.product = item.product;
            self.item.price = item.price;
            self.item.id = item.id;
            self.isSelectCosignacao = !self.isSelectCosignacao;
            return
        }

        function selecionarCliente(cliente){
            self.consignacao.client = cliente;
            self.isShowFiltro = !self.isShowFiltro;
            self.isSelectCosignacao = true;
        }


        function buscarListaProdutos(busca){
            if(busca.palavraChave === undefined || busca.palavraChave === ""){
                toastApp.newmessage("Digite algo no campo Busca.");
                document.getElementById("palavraChaveBusca").focus();
                return
            }
            var obj = {
                name:null,
                skuCode: null
            }
            if(busca.campo === "name"){
                obj.name = busca.palavraChave;
            }else{
                obj.skuCode = busca.palavraChave;
            }
            movimentacaoService.recuperarProdutos(obj)
                .success(function(data){
                    if(data.success){
                        self.listaBuscaProduto = data.object;
                        if(self.listaBuscaProduto.length < 1){
                            toastApp.newmessage("Não existem produtos com estas palavras.");
                            document.getElementById("palavraChaveBusca").focus();
                        }
                    }
                });
        }


        function buscarListaProdutoEstoque(busca){
            if(busca.palavraChave === undefined || busca.palavraChave === ""){
                toastApp.newmessage("Digite algo no campo Busca.");
                document.getElementById("palavraChaveBusca").focus();
                return
            }
            var obj = {
                name:null,
                skuCode: null
            }
            if(busca.campo === "name"){
                obj.name = busca.palavraChave;
            }else{
                obj.skuCode = busca.palavraChave;
            }
            movimentacaoService.recuperarProdutoEstoque(obj)
                .success(function(data){
                    if(data.success){
                        self.listaBuscaProdutoEstoque = data.object;
                        if(self.listaBuscaProdutoEstoquelength < 1){
                            toastApp.newmessage("Não existem produtos com estas palavras.");
                            document.getElementById("palavraChaveBusca").focus();
                        }

                    }
                });
        }

        function ordenaProduto(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }

        function initFormConsignacao(tipo){
            var now = new Date();
            var nextMonth = new Date();
            nextMonth.setDate(now.getDate() + 30);
            self.consignacao = { type: tipo, client: undefined, dataSaida: now, dataRetorno: nextMonth, productList:[]};
            document.getElementById("nameCliente").focus();
            buscarListaCliente({ name: 'c'})
        }

        function initFormAcerto(){
            self.consignacao.dataRetorno = new Date();
            buscarListaCliente({ name: 'c'})
        }

        var dataToDateJS = function(data){
           return new Date(data);
        }

        function buscarListaConsignacao(cliente){
            movimentacaoService.listarConsignacaoPorCliente(cliente)
                .success(function(data){
                    if(data.success){
                        self.consignacaoList = data.object;
                        if(self.consignacaoList.length > 0){
                            self.isVisibleGradeAcerto = true;
                            self.textBtnMostrarGradeAcerto = "Ocultar";
                        }
                        for(var i= 0; i < self.consignacaoList.length;i++) {
                            self.consignacaoList[i].priceTotal = 0;
                            for (var j = 0; j < self.consignacaoList[i].productList.length; j++) {
                                console.log(self.consignacaoList[i].productList[j])
                                self.consignacaoList[i].priceTotal = self.consignacaoList[i].priceTotal + (self.consignacaoList[i].productList[j].price * self.consignacaoList[i].productList[j].quantity);
                                self.consignacaoList[i].productList[j].quantityRetorno = self.consignacaoList[i].productList[j].quantity;

                            }
                        }

                    }else {
                        toastApp.newmessage("Não há consignação aberta para este Cliente.");
                    }
                })
        }


    }

})();
