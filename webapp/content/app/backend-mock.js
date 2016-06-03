/*Mock backend*/
(function(){
  var myAppDev = angular.module('myAppDev', ['app', 'ngMockE2E']);

  myAppDev.run(function($httpBackend) {
    var categories = [
      {
        id: 1,
        name: 'Blusas e camisetas'
      },
      {
        id: 2,
        name: 'Acessórios'
      }
    ];

    var subCategories = [
      [{
        id: 1,
        name: "Blusas",
        category: {id: 1}
      },
      {
        id: 2,
        name: "Camisetas",
        category: {id: 1}
      },
      {
        id: 3,
        name: "Tops",
        category: {id: 1}
      }],
      [{
        id: 4,
        name: "Acessórios diversos",
        category: {id: 2}
      }]
    ];

    var modelos = [{id: 1, name: "Modelo exemplo"}];

    $httpBackend.whenPOST('/controle-estoque-web/api/productsupercategory/listar/').respond(categories);
    $httpBackend.whenPOST('/controle-estoque-web/api/productsubcategory/listar/1').respond(subCategories[0]);
    $httpBackend.whenPOST('/controle-estoque-web/api/productsubcategory/listar/2').respond(subCategories[1]);
    $httpBackend.whenPOST('/controle-estoque-web/api/productmodel/listar/').respond(modelos);

    $httpBackend.whenPOST('/controle-estoque-web/api/productmodel/cadastrar/').respond(function(method, url, data) {
      var m = angular.fromJson(data);
      m.id = modelos.reduce(function(a, b){return Math.max(a, b.id)}, 0) + 1;
      modelos.push(m);
      return [200, {mensagem: "Modelo cadastrado com sucesso!", object: m}, {}];
    });
    // Passthrough everything
    $httpBackend.whenGET(/[\s\S]*/).passThrough();
    //...
  });
})();
