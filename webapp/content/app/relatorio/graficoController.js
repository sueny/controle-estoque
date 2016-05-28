/**
 * Created by jesus on 26/05/2016.
 */


(function(){

    "use strict";

    angular.module("app")
        .controller("graficoController", graficoController);

    function graficoController() {
        var self = this;
        self.graficoVenda = {};
        self.graficoVenda.type = "BarChart";

        self.consignacao = [
            {v: "Consignação"},
            {v: 100}
        ];
        self.calca = [
            {v: "Venda"},
            {v: 30}
        ];

        self.graficoVenda.data = {"cols": [
            {id: "t", label: "Topping", type: "string"},
            {id: "s", label: "Quantidade", type: "number"}
        ], "rows": [
            {c: self.consignacao},
            {c: self.calca}
        ]};


        self.graficoVenda.options = {
            'title': 'Grafico de Vendas'
        };

    }


})();

