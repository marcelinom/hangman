# README #

Instruções para rodar a aplicação Hangman, desenvolvida por Marcelino Magalhães de Oliveira, em 7/jun/2021

### Implementação ###

Esta aplicação foi implementada com:

* Java 8
* Spring Boot 1.5
* Angular 1.2
* H2 Database

O projeto usa o banco temporário H2 para evitar usar HTTP Sessions, que consumiria memória no servidor. Apenas por princípio, caso se decidisse escalonar para um site online com vários jogadores em simultâneo.

O arquivo com as palavras é lido na inicialização da aplicação e gravado no banco de dados. Cada vez que o jogador reinicia o jogo uma das palavras é selecionada randomicamente. 

Como a UI do Hangman do site https://www.hangmanwords.com/play é simples, funcional e bonita, copiei o SVG e os arquivos CSS dela para este projeto. Acredito que não prejudique o desafio, pois a implementação com Angular provavelmente ficou mais simples e elegante que a original. Espero que os autores do site não se ofendam.

### Instruções para Deploy ###

Na linha de comando, digitar
* mvn clean install , para criar o jar executável
* java -jar hangman-0.0.1-SNAPSHOT.jar, para rodar o jogo
* abrir o browser no endereço http://localhost:8080/        
* jogar!

### Instruções para jogar o Hangman ###

* clique em uma das teclas com letra disponíveis na tela
* se a letra não existir na palavra, um pedaço do corpo do boneco será acrescentado na forca
* caso a palavra tenha aquela letra ela será preenchida no template, em todas as posições em que aparecer
* se você errar seis vezes o boneco será enforcado e o jogo termina
* se você acertar a palavra, o boneco sairá da forca! Uhuuu!!!
* para reiniciar o jogo basta teclar em qualquer letra disponível na tela e confirmar a opção na tela de diálogo.
* só é permitido teclar uma vez em cada letra. Após o clique a tecla é desabilitada.





