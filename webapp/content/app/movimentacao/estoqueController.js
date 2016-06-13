/**
 * Created by jesus on 20/05/2016.
 */

(function(){
    "use strict";


    angular.module('app')
        .controller('estoqueController', estoqueController);


    function estoqueController(toastApp, $scope, movimentacaoService,cadastroService){
        var self = this;
        self.isShowFiltro = true;
        self.isSelectCosignacao = false;
        self.listaBuscaProduto = [];
        self.initFormEstoque = initFormEstoque;
        self.initFormAcerto = initFormAcerto;
        self.initFormConsignacao = initFormConsignacao;
        self.initFormVenda = initFormVenda;
        self.operacaoEstoque = '';
        self.buscarListaCliente = buscarListaCliente;
        self.buscarListaProdutos = buscarListaProdutos;
        self.Busca = { campo:'name'};
        self.estoque = { data: new Date()}
        self.campoOrdencao = 'nome';
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
        self.Client = {};
        self.alterarRetorno = alterarRetorno;
        self.validaDevolver = validaDevolver;
        self.fecharAcerto = fecharAcerto;
        self.novoAcerto = novoAcerto;
        self.cancelarProduto = cancelarProduto;
        self.priceVendido = 0;



        function novoAcerto(){
            self.consignacaoList = [];
            self.isShowFiltro = true;
            self.isSelectCosignacao = false;
            self.priceVendido = 0;

        }

        function fecharAcerto(consignacao){
            console.log(consignacao);
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
            console.log(self.consignacao.productList[1]);
            for(var i=0; i < self.consignacao.productList.length; i++){
                console.log(self.consignacao.productList[i]);
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
            cons.Client = self.consignacao.Client;
            self.consignacao = cons;
            console.log(cons);
            self.isVisibleGradeAcerto = false;
            self.isSelectCosignacao = true;
            self.priceDevolvido = self.consignacao.priceTotal;

        }


        function selecionarClienteAcerto(cliente){
            self.consignacao.Client = cliente;
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
            console.log(consignacao.dataRetorno)
            if(consignacao.type === 0) {
                if (consignacao.dataRetorno === undefined || consignacao.dataRetorno === "") {
                    toastApp.newmessage("Data Prevista de Retorno.");
                    document.getElementById("dataRetornoCliente").focus();
                    return;
                }
            }
            console.log(consignacao);
            novoKit();

            /*movimentacaoService.cadastrarKit(consignacao)
                .success(function (data) {
                    if (data.success) {
                        toastApp.newmessage("Sucesso na Operação.");

                    }else{
                        toastApp.newmessage("Problema ao cadastrar Cliente.");
                    }

                });*/
        }

        function buscarListaCliente(name){
            if(name === undefined || name == ""){
                toastApp.newmessage("Digite algo...");
                document.getElementById("nameCliente").focus();
                return
            }
        }

        function montarKit(item){
            var adicionar = true;
            if(self.quantityEstoque < item.quantity){
                toastApp.newmessage("Valor está superior a quantidade em estoque.");
                document.getElementById("quantity").focus();
                return;
            }
            for(var i=0; i < self.consignacao.productList.length; i++){
                if(item.Product.id === self.consignacao.productList[i].Product.id){
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


        function inserirEntradaEstoque(estoque){
            console.log(estoque);
        }


        function resetFormEstoque(){
            self.Busca = { campo:'name'};
            self.estoque = { data: new Date()};
            self.isShowFiltro = !self.isShowFiltro;

        }

        function selecionarProduto(produto){
            self.estoque = { Produto: produto, data: new Date() };
            self.isShowFiltro = !self.isShowFiltro;
            return
        }

        function cancelarProduto(){
          self.isSelectCosignacao = !self.isSelectCosignacao;
        }

        function selecionarProdutoConsignacao(item){
            var quantitySelected = 0;
            for(var i =0; i < self.consignacao.productList.length; i++){
                if(self.consignacao.productList[i].Product.id === item.Product.id){
                    quantitySelected = quantitySelected + self.consignacao.productList[i].quantity;
                }
            }
            self.quantityEstoque = (item.quantity - quantitySelected);
            self.item.Product = item.Product;
            self.item.price = item.price;

            self.isSelectCosignacao = !self.isSelectCosignacao;
            return
        }

        function selecionarCliente(cliente){
            self.consignacao.Client = cliente;
            self.isShowFiltro = !self.isShowFiltro;
            initEstoque();
            console.log(self.listaBuscaProduto)
            self.isSelectCosignacao = true;
        }

        function initEstoque(){
            for(var i = 1; i < 5; i++){
                var item = {
                    Product: {id: i, name: "Produto" +i, skuProduto:"S"+i+"k"+i+"U"},
                    quantity: 1000,
                    price: 99.99,
                }
                self.listaBuscaProduto.push(item);
            }
        }

       /* function initEstoque(){
            for(var i = 1; i < 5; i++){
                var item = {
                    Product: {id: i, name: "Produto" +i, skuProduto:"S"+i+"k"+i+"U"},
                    quantity: 1000,
                    price: 99.99,
                }
                self.consignacao.productList.push(item);
            }
        }*/

        function initFormVenda(){
            for(var i = 1; i < 5; i++){
                var cliente = {id: i, name: "Maria Venda " +i}
                self.listaBuscaCliente.push(cliente)
            }
        }

        function buscarListaProdutos(busca){
            if(busca.palavraChave === undefined || busca.palavraChave === ""){
                toastApp.newmessage("Digite algo no campo Busca.");
                document.getElementById("palavraChaveBusca").focus();
                return
            }


        }


        function ordenaProduto(campoOrdencao) {
            self.reverse = (self.campoOrdencao === campoOrdencao) ? !self.reverse : false;
            self.campoOrdencao = campoOrdencao;

        }

        function initFormConsignacao(tipo){
            var now = new Date();
            var nextMonth = new Date();
            nextMonth.setDate(now.getDate() + 30);
            self.consignacao = { type:tipo, Client: undefined, dataSaida: now, dataRetorno: nextMonth, productList:[]};
            for(var i = 1; i < 5; i++){
                var cliente = {id: i, name: "Maria Consignação " +i}
                self.listaBuscaCliente.push(cliente)
            }
        }

        function initFormAcerto(){
            self.consignacao.dataRetorno = new Date();
            for(var i = 1; i < 5; i++){
                var cliente = {id: i, name: "Maria  " +i}
                self.listaBuscaCliente.push(cliente)
            }
        }
        function initFormEstoque(){
            self.listaBuscaProduto = [];
            for(var i = 1; i < 5; i++){
                var produto = {id: i, name: "Produto" +i, skuProduto:"S"+i+"k"+i+"U"}
                self.listaBuscaProduto.push(produto)
            }
        }

        function buscarListaConsignacao(cliente){
            self.isSelectClienteCosignacao = true;
            self.isVisibleGradeAcerto = true;
            var cons = { };
            for(var i= 1; i < 5;i++){
                cons = {
                    dataSaida: new Date(),
                    dataRetorno: new Date(),
                    priceTotal: 0,
                    productList:[],
                    obs: "Observação " + i,

                }
                for(var j= 1; j < 11;j++) {
                    var produto = {id: j, name: "Produto " + j, skuProduto: "00XX"+j+i};
                    var item = { Product: produto,
                        price: i + 20,
                        quantity:(i + 5) * 10,
                        quantityRetorno: (i + 5) * 10

                    }
                    cons.priceTotal = cons.priceTotal + (item.price * item.quantity);
                    cons.productList.push(item);
                }
                self.consignacaoList.push(cons);
            }
        }


    }

})();
