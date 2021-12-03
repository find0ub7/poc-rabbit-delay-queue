POC para reproduzir um comportamento de delay de consumo de mensagem enviada para o rabbit.

A mensagem é enviada para uma fila sem consumer, porém, com um TTL. Quando a mensagem expira, ela é enviada para uma fila com consumer.
A app vai subir utilizando a configuração default do rabbit.

Pré-requisito para executar a POC:
- rabbit rodando localmente
- sugestão: subir o rabbit usando a seguinte imagem
docker run -d --name rabbit-local -p 15672:15672 -p 15673:15673 -p 5672:5672 -p 5673:5673 rabbitmq:3.6.0-management
