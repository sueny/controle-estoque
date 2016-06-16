/**
 * Created by jesus on 26/05/2016.
 */


(function(){

    "use strict";

    angular.module("app")
        .controller("graficoController", graficoController);

    function graficoController(movimentacaoService) {
        var self = this;
        self.graficoVenda = {};
        self.initGrafico = initGrafico;

        self.graficoVenda.type = "PieChart";

        self.produto = [
            {v: "Consignação"},
            {v: 10000}
        ];
        self.mes = [
            {v: "Venda"},
            {v: 7825}
        ];

       /* self.graficoVenda.data = {"cols": [
            {id: "t", label: "Topping", type: "string"},
            {id: "s", label: "Quantidade", type: "number"}
        ], "rows": [
            {c: self.produto},
            {c: self.mes}
        ]};*/
        self.graficoVenda.data = {"cols": [
            {id: "t", label: "Topping", type: "string"},
            {id: "s", label: "Quantidade", type: "number"}
        ], "rows": []};

       function initGrafico(){
           movimentacaoService.relatorioTopDez()
               .success(function(data){
                   if(data.success){
                       for(var i=0; i < data.object.length; i++){
                           var dado = {
                               c: [
                                   {v: data.object[i][1]},
                                   {v: data.object[i][2]}
                               ]
                           }
                           self.graficoVenda.data.rows.push(dado);
                           console.log(dado)
                       }
                   }else {
                       toastApp.newmessage("Problemas ao conectar com servidor.");
                   }
               })
             /*for(var i=1; i < 11; i++){
                var dado = {
                    c: [
                     {v: "Produto" + i},
                     {v: i*1000}
                 ]
                }
                 self.graficoVenda.data.rows.push(dado);
                 console.log(dado)
             }*/
        }



    }


})();

