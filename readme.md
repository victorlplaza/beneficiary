# Desenvolvimento da aplicação

Para o desenvolvimento dessa aplicação foram utilizados o Java 17 com Spring Boot 3, também foram usados o JPA e Lombok além do banco de dados H2 embarcado. A ferramenta usada para o desenvolvimento foi o Visual Studio Code.

Foi escolhido o JPA devido a sua facilidade para trabalhar com banco de dados reduzindo assim o tempo de codificação do DEV, pelo mesmo motivo também optamos pelo Lombok que nos permite muitas facilidades e economias em linhas de codigo digitadas.

Foi usado o Swagger para documentação dos endpoint, assim que o projeto estiver em execução a UI pode ser acessada. Para maiores informações por favor acesse: https://swagger.io/docs/

# Leia-me: Construindo a API Spring Boot

Este guia detalha como construir e executar a API Spring Boot desenvolvida em Java, utilizando Spring Boot 3, JPA e Lombok.

## Pré-requisitos

* JDK 17
* Maven 3.8.6 ou superior
* Git (opcional, para clonar o repositório)

## Etapas de construção

1. Clone-o localmente:
2. Navegue até o diretório do projeto atré do Command;
3. Execute o comando mvn clean package para executar um build do projeto;
4. Execute a API com o comando mvn spring-boot:run;
5. Acessar o arquivo application.properties no diretório da aplicação e colocar qualquer informação nos campos de spring.security.user.name= e spring.security.user.password=. Esses serão seus dados de usuário e senha para acesso aos endpoints com Authorization Basic Auth;
6. Pronto a API já rodando e sé esperando ser enviado informações para seus endpoints.

Exemplos de Json a serem enviados no endpoints

Post: {
            "name" : "name",
            "telephone" : "00 00 00000-0000",
            "dateBirth" : "00-00-0000",
            "document" : [
                {
                    "typeDocuments" : "typeDocuments",
                    "description" : "description"
                }
            ]
        }
    obs: Todos esses campos estão como string. Os demais campos são preenchidos automaticamente pela aplicação.

Put: {
            "name" : "name",
            "telephone" : "00 00000-0000",
            "dateBirth" : "00-00-0000"
        } 