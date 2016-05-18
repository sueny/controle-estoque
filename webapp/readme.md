# Como rodar o frontend no seu computador

Para executar o frontend, siga o passo a passo executando os comando:

- `npm install`
- `bower install`
- `start gulp` (windows) ou `gulp &` (linux)
- `start node staticFileServer.js` (windows) ou `node staticFileServer.js &` (linux)

Pronto! Você pode mudar a porta em que o servidor sobe no arquivo `staticFileServer.js` (padrão: 3000)

Você pode ajustar o caminho da api do backend em `app/app-config.js` (nas primeiras linhas do arquivo)
(padrão: 'localhost:8080/controle-estoque-web/api/')

Nesse arquivo também é possível ajustar o caminho da aplicação caso você esteja usando outro servidor
para as páginas (Apache por exemplo)
