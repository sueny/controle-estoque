# Como rodar o frontend no seu computador


Para executar o frontend, siga o passo a passo executando os comandos.
É necessário ter o Node.js/NPM instalados.

- `npm install -g bower` - Instala o bower (gerenciador de dependências)
- `npm install` - Instala (baixa) as dependências que são pacotes npm
- `bower install` - Instala (baixa) dependências via bower
- `start gulp` (windows) ou `gulp &` (linux) - Inicia em background processo de build contínua
- `start node staticFileServer.js` (windows) ou `node staticFileServer.js &` (linux) - Inicia servidor

Pronto! Você pode mudar a porta em que o servidor sobe no arquivo `staticFileServer.js` (padrão: 3000)

Você pode ajustar o caminho da api do backend em `app/app-config.js` (nas primeiras linhas do arquivo)
(padrão: 'localhost:8080/controle-estoque-web/api/')

Nesse arquivo também é possível ajustar o caminho da aplicação caso você esteja usando outro servidor
para as páginas (Apache por exemplo)
