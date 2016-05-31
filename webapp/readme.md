# Como rodar o frontend no seu computador


Para executar o frontend, siga o passo a passo executando os comandos.
É necessário ter o Node.js/NPM instalados.

- `npm install -g bower` - Instala o bower (gerenciador de dependências)
- `npm install -g gulp` - Instala o gulp (build)
- `npm install` - Instala (baixa) as dependências que são pacotes npm
- `bower install` - Instala (baixa) dependências via bower
- `start gulp` (windows) ou `gulp &` (linux) - Inicia em background processo de build contínua
- `start node staticFileServer.js` (windows) ou `node staticFileServer.js &` (linux) - Inicia servidor

Pronto! Você pode mudar a porta em que o servidor sobe no arquivo `config.server.json` (padrão para o projeto é 8080)

Você pode ajustar o caminho da api do backend em `app/app-config.js` (nas primeiras linhas do arquivo)
(padrão: 'localhost:3000/)

Nesse arquivo também é possível ajustar o caminho da aplicação caso você esteja usando outro servidor
para as páginas (Apache por exemplo).

Padrão para o desenvolvimento do frontend para este projeto (By Jesus)

1. Criar um formulário (form_NomeDoForm.html).
2. Implementar o controller (nomeDoFormController.js)
3. Mapear no arquivo router.app.js (/webapp/content/app/) na árvores de navegaçao associando formuário e controller.
4. Implmentar um novo ou usar um service já existente em /webapp/content/app/service/ com as rotas do backend.
5. O resto é lógica de negócio... Mão na massa.
