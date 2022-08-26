# Backend do projeto JoinFut

---

## Glossário

|Ordem| Informação                                                            |
|---|-----------------------------------------------------------------------|
|1| [Git Workflow](https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/processo#git-workflow)                                         
|2| [Versões dos programas utilizados](#Versões-dos-programas-utilizados) |
|3| [Como rodar o projeto no Intellij](#Como-rodar-o-projeto-no-Intellij) |
|4| [Entendendo o projeto](#Entendendo-o-projeto)                         |
|5| [Configurações iniciais](#Configurações-iniciais)                     |

## Versões dos programas utilizados

* **Java 8** : [Como instalar o Java 8]() `Em construção`
* **Postman** : [Download do postman mais recente](https://www.postman.com/downloads/)
* **Apache Maven 3.6.3** : [Como instalar o Maven]() `Em construção`
* **PostgreSQL 12**: [Como instalar o PostgreSQL 12](https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/instalação#postgresql)
* **Intellij 2022 ou mais recente** : [Download do intellij](https://www.jetbrains.com/pt-br/idea/download/)

---

## Como rodar o projeto no Intellij

1. Abra o repositório pelo Intellij
2. Deixe ele configurar tudo sozinho (ele vai configurar o maven, os arquivos e o POM.xml sozinho)
3. Bem acima a direita terá um botão de um martelo verde e do lado deve estar escrito **JoinfutApplication**
4. Clique no símbolo ▶ em verde ao lado do texto **JoinfutApplication**
5. Rode o script inicial com os Schemas que o programa precisa, caso não tenha feito, eles se encontram no repositório [**Joinfut Database**](https://tools.ages.pucrs.br/Joinfut/joinfut-database)
6. Para testar se o projeto está funcionando, rode as requisições template guardados [AQUI](https://tools.ages.pucrs.br/Joinfut/joinfut-database/-/tree/main/Requisições/Template), para saber como leia esse [DOC](https://tools.ages.pucrs.br/Joinfut/joinfut-database/-/blob/main/README.md)

---

## Entendendo o projeto

* O projeto é uma [**API REST**](https://rockcontent.com/br/blog/rest-api/) utilizando [**Spring Data**](https://spring.io/projects/spring-data) e [**Hibernate**](https://hibernate.org)
* O Projeto possui a seguinte estrutura:
  * **src.main.java** = caminho para os diretórios do projeto.
      * **com.ages.joinfut** = caminho para os arquivos oficiais da arquitetura
          * **config** = diretório onde ficam as configurações globais
              * **generic** = diretório onde ficam os arquivos genéricos utilizados no projeto.
              * **validation** = diretório onde ficam o tratamento de erros e validações globais.
          * **controller** = diretório onde ficam os arquivos de controle das requisições a API REST.
          * **dto** = diretório onde ficam o tratamento de dados e suas validações das requisições para o banco.
          * **Enum** = diretório onde ficam os objetos enumerados (que possuem valores padrões) que podem ser utilizados.
          * **model** = diretório onde ficam as entidades (a estrutura de informações que vão ser salvos no banco).
          * **repository** = diretório onde ficam os arquivos de tratamento das camadas de persistência do JPA.
          * **service** = diretório onde ficam validações mais complexas e funções utilizadas pelas requisições.
      * **resources** = diretório onde fica o `application.properties` com as configurações do spring
      * **test** = diretório onde ficam os testes do projeto
* O projeto deve ser implementado seguindo o seguinte caminho:
  * [**Model**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/model/Template.java)
  * [**DTO**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/dto/TemplateDTO.java)
  * [**Repository**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/repository/TemplateRepository.java)
  * [**Service**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/service/TemplateService.java)
  * [**Controller**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/controller/TemplateController.java)
  * [**Enum(Opcional)**](https://tools.ages.pucrs.br/Joinfut/joinfut-backend/-/blob/main/src/main/java/com/ages/joinfut/Enum/TemplateEnum.java)

---

## Configurações iniciais

### Evitar que os imports sejam simplificados
* Após baixado o Intellij, vá na ponta esquerda da IDE e clique em **File**
* Procure por **Settings**
* Vá em **Editor > Code Style > Java**
* Acesse a aba **Imports**
* Coloque no máximo de 9 na opção **Class count to use import with '*'**
* Coloque no máximo de 9 na opção **Names count to use static import with '*'**
* Desmarque as opções abaixo:
  * import java.awt.*
  * import javax.swing.*

