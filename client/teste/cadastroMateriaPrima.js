/**
 * Created by jesus on 11/05/2016.
 */


(function(){


    "use strict";

    var webdriver = require('selenium-webdriver');

    var browser = new webdriver.Builder().usingServer().withCapabilities({'browserName': 'chrome' }).build();

    browser.get('http://localhost:51719/ProjetoDeEngSoftw/client/views/index.html#/');

    browser.findElement(webdriver.By.name('btnCadastrarMateriaPrima')).click();
    browser.sleep(2000);
    browser.findElement(webdriver.By.name('nomeMateriaPrima')).sendKeys("Tecido de bolinha amarelinha");
    browser.findElement(webdriver.By.name('btnCadastrarMateriaPrima')).click();
    browser.sleep(3000);
    browser.findElement(webdriver.By.name('skuMateriaPrima')).sendKeys("0938098");
    browser.findElement(webdriver.By.name('btnCadastrarMateriaPrima')).click();
    browser.sleep(3000);
    browser.findElement(webdriver.By.name('unidadeMateriaPrima')).sendKeys("KG");
    browser.findElement(webdriver.By.name('btnCadastrarMateriaPrima')).click();

    browser.sleep(3000);
    browser.findElement(webdriver.By.name('btnExcluirMateriaPrima')).click();
    browser.sleep(3000);
    browser.findElement(webdriver.By.name('nomeMateriaPrima')).sendKeys("Tecido de bolinha azul");
    browser.findElement(webdriver.By.name('skuMateriaPrima')).sendKeys("0938099");
    browser.findElement(webdriver.By.name('unidadeMateriaPrima')).sendKeys("KG");
    browser.findElement(webdriver.By.name('observacaoMateriaPrima')).sendKeys("Tecido bom para fazer roupa com bolinha azul");
    browser.findElement(webdriver.By.name('btnCadastrarMateriaPrima')).click();
    browser.sleep(3000);
    browser.findElement(webdriver.By.name('btnExcluirMateriaPrima')).click();
    browser.sleep(5000);
    browser.quit();


})();