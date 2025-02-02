# Comunicação Cliente-Servidor em Java

Exemplo do uso das classes `Socket` e `ServerSocket` para estudo 
da comunicação Cliente-Servidor em Java. Essas classes permitem
que uma aplicação funcione como cliente, enviando requisições, 
enquanto outra, como servidor, recebendo e processando 
as requisições.

## Temas abordados
* **Chat de Texto**: Troca de mensagens de texto entre Cliente e Servidor.
* **Serialização de Objetos**: Envio e recebimento de objetos serializados através da rede. 
* **Protocolo HTTP**: Criação e envio de requisições HTTP para APIs REST.


## Tecnologias Utilizadas

- Java (`Socket`, `ServerSocket`).
- Serialização de Objetos.
- Protocolo TCP/IP e HTTP (Consumo de API REST).

## Como executar

Faça uma cópia do repositório em sua máquina.

```bash
git clone https://github.com/EnricoABM/network-java.git 
```
Os tópicos a seguir demonstram como executar cada tipo de servidor e seu respectivo cliente.
### Chat de Texto

1. Compile as classes do projeto.
```bash
dir /s /B *.java > sources.txt && javac -cp "./src" -d "./bin" @sources.txt && del sources.txt
```

2. Inicie o Servidor.
```bash
java -cp "./bin" server.ChatServer
```

3. Inicie o Cliente (em outra aba do terminal).
```bash
java -cp "./bin" client.ChatClient
```

4. Altere entre os terminais e veja o envio de mensagens.

### Serialização

1. Compile as classes do projeto.
```bash
dir /s /B *.java > sources.txt && javac -cp "./src" -d "./bin" @sources.txt && del sources.txt
```

2. Inicie o Servidor.
```bash
java -cp "./bin" server.SerializationServer
```

3. Inicie o Cliente (em outra aba do terminal).
```bash
java -cp "./bin" client.SerializationClient
```

4. Observe a troca de objetos entre cliente e servidor..

### Protocolo HTTP

A API utilizada para o exemplo é o [ViaCep](https://viacep.com.br/).

1. Compile as classes do projeto.
```bash
dir /s /B *.java > sources.txt && javac -cp "./src" -d "./bin" @sources.txt && del sources.txt
```

2. Execute o Cliente HTTP.
```bash
java -cp "./bin" client.HttpClient
```

3. Informe o CEP que deseja consultar e veja o retorno da API.

## Referências

Esse conteúdo foi retirado da série `Comunicação em Redes de Computadores usando Java` do canal [Professor Miltin](https://www.youtube.com/playlist?list=PLXpJXj3bxppwwQPKOjDnd0rlVbjCOAfcW).
