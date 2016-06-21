/**
 * Created by jesus on 20/06/2016.
 */

(function(){
    "use strict";
    angular.module('utilService',[])
        .factory( 'util', util );

    function util () {
        var service = {
            validaCNPJ: validaCNPJ,
            validaCPF: validaCPF
        };
        return service;


    function validaCNPJ(campo)
    {
        if (campo.value != '') {
            var CNPJ = campo.value;

            while (CNPJ.indexOf(".") != -1)
                CNPJ = CNPJ.replace(".","");
            while (CNPJ.indexOf("-") != -1)
                CNPJ = CNPJ.replace("-","");
            while (CNPJ.indexOf(" ") != -1)
                CNPJ = CNPJ.replace(" ","");
            while (CNPJ.indexOf("/") != -1)
                CNPJ = CNPJ.replace("/","");

            var cnpjCalc = CNPJ.substr(0,12);
            var cnpjSoma = 0;
            var cnpjDigit = 0;
            var digit = "";

            for (i = 0;  i < 4;  i++) {
                cnpjSoma = cnpjSoma + parseInt(cnpjCalc.charAt(i)) * (5 - i);
            }

            for (i = 0;  i < 8;  i++) {
                cnpjSoma = cnpjSoma + parseInt(cnpjCalc.charAt(i+4)) * (9 - i);
            }

            cnpjDigit = 11 - cnpjSoma%11;

            if ((cnpjDigit == 10) || (cnpjDigit == 11)){
                cnpjCalc = cnpjCalc + "0";
            }
            else {
                digit = digit + cnpjDigit;
                cnpjCalc = cnpjCalc + (digit.charAt(0));
            }

            cnpjSoma = 0;

            for (i = 0;  i < 5;  i++){
                cnpjSoma = cnpjSoma + parseInt(cnpjCalc.charAt(i)) * (6 - i);
            }

            for (i = 0;  i < 8;  i++) {
                cnpjSoma = cnpjSoma + parseInt(cnpjCalc.charAt(i+5)) * (9 - i);
            }

            cnpjDigit = 11 - cnpjSoma%11;

            if ((cnpjDigit == 10) || (cnpjDigit == 11)) {
                cnpjCalc = cnpjCalc + "0";
            }
            else {
                digit = "";
                digit = digit + cnpjDigit;
                cnpjCalc = cnpjCalc + (digit.charAt(0))
            }

            if (CNPJ != cnpjCalc) {
                return false;
            }
            return true;
        }

        function validaCPF(campo)
        {
            if (campo.value != '') {
                var CPF = campo.value;

                while (CPF.indexOf(".") != -1)
                    CPF = CPF.replace(".","");
                while (CPF.indexOf("-") != -1)
                    CPF = CPF.replace("-","");
                while (CPF.indexOf(" ") != -1)
                    CPF = CPF.replace(" ","");

                var cpfCalc = CPF.substr(0,9);
                var cpfSoma = 0;
                var cpfDigit = 0;
                var digit = "";

                for (i = 0; i < 9; i++) {
                    cpfSoma = cpfSoma + parseInt(cpfCalc.charAt(i)) * (10 - i)
                }

                cpfDigit = 11 - cpfSoma%11;

                if (cpfDigit > 9) {
                    cpfCalc = cpfCalc + "0";
                }
                else {
                    digit = digit + cpfDigit;
                    cpfCalc = cpfCalc + digit.charAt(0);
                }

                cpfSoma = 0;

                for (i = 0; i < 10; i++) {
                    cpfSoma = cpfSoma + parseInt(cpfCalc.charAt(i)) * (11 - i)
                }

                cpfDigit = 11 - cpfSoma%11;

                if (cpfDigit > 9) {
                    cpfCalc = cpfCalc + "0";
                }
                else {
                    digit = "";
                    digit = digit + cpfDigit;
                    cpfCalc = cpfCalc + digit.charAt(0);
                }

                if (CPF != cpfCalc){
                    return false;
                }

                return true;
            }
        }

    }
    }


})();