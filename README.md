# Backend do projeto JoinFut

![](https://badgen.net/badge/Java/11/orange) 
![](https://badgen.net/badge/maven/3.6.3/green) 
![](https://badgen.net/badge/spring/2.7.3/black)
![](https://badgen.net/badge/portgresql/12/blue)


* Tipo de Backend

![](https://img.shields.io/badge/api%20rest-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

* Tipo de Banco de dados

![](https://img.shields.io/badge/SQL%20relacional-316192?style=for-the-badge&logo=postgresql&logoColor=white)


---

## Glossário

| Ordem | Informação                               |
|-------|------------------------------------------|
| 1     | [Git Workflow](#workflow)                |
| 2     | [Como rodar o projeto no Intellij](#run) |
| 3     | [Entendendo o projeto](#projeto)         |
| 4     | [Configurações iniciais](#inicial)       |

---

<a name="workflow"></a>

## Git Workflow

* Todas as informações se encontram na [**Página Oficial do Processo**](https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/processo#git-workflow)
* Resumo:

#### Branches

Como padrão para nomes de branches, foi decidido o seguinte:

```
<nomeColega>/<tipoDemanda>/<codigoDemanda>
```

Exemplo de branchs:

```
fanto/feature/#1
fanto/bugFix/#346
fanto/architecture/#1230
```

#### Padrão de Commits

Todos os commits devem começar com o **código da Issue** e uma mensagem direta do que foi feito naquele commit:

Esse código marcado é o que deve vir antes da mensagem em português do que foi feito:

```
git commit -m "#1 Atualizando os nomes dos colegas"
```

Com isso, vai vincular automaticamente a Issue ao commit, facilitando o trabalho dos revisores e colegas para saber de onde veio as alterações e o que foi feito

**ATENÇÃO** se o commit não estiver nessa estrutura, o commit vai ser invalidado e deverá ser feito um SQUASH de commits com a estrutura correta.

Não hesite em realizar vários commits, assim podemos ter documentado e salvo vários estados do desenvolvimento

#### Nomenclaturas de Métodos e Funções

* Não tenha medo de colocar nomes grandes, mas devem fazer sentido com a funcionalidade que está sendo feito:

```java
public int decodeDtoInformationIntoModel(){...}
```

#### Comentários

* Utilize comentários somente se for necessário, os nomes das variáveis e métodos devem dizer por si só o que ele faz, comentários somente são permitidos no **Template** de exemplo.

---

<a name="run"></a>

## Como rodar o projeto no Intellij

1. Abra o repositório pelo Intellij
2. Deixe ele configurar tudo sozinho (ele vai configurar o maven, os arquivos e o POM.xml sozinho)
3. Bem acima a direita terá um botão de um martelo verde e do lado deve estar escrito **JoinfutApplication**
4. Clique no símbolo ▶ em verde ao lado do texto **JoinfutApplication**
5. Rode o script inicial com os Schemas que o programa precisa, caso não tenha feito, eles se encontram no repositório [**Joinfut Database**](https://tools.ages.pucrs.br/Joinfut/joinfut-database)
6. Para testar se o projeto está funcionando, rode as requisições template guardados [AQUI](https://tools.ages.pucrs.br/Joinfut/joinfut-database/-/tree/main/Requisições/Template), para saber como leia esse [DOC](https://tools.ages.pucrs.br/Joinfut/joinfut-database/-/blob/main/README.md)

---

<a name="inicial"></a>

## Configurações iniciais

### Configurando o JDK/SDK

* Após instalado os programas necessários, devemos configurar o JDK na nossa IDE.
* Vá em **File** > **Project Structure** > **Project**
* Selecione o JDK do Java, sendo o da versão 11 que foi instalada no [Tutorial](https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/backend/java_instalacao)

### Build do projeto

* Após configurado o JDK, deixe o intellij terminar a configuração e clique no martelo verde bem acima no canto direito do intellij
* Deixe buildar, depois vá ao arquivo **pom.xml** e clique com o botão do mouse direito dentro desse arquivo
* vá até a opção **Maven** e depois clique em **Reload project**
* Assim que terminar de buildar, verifique se apareceu no canto acima direito ao lado do martelo verde o texto **JoinfutApplication**
* Se estiver aparecendo, o projeto está pronto para rodar.

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

  ---

<a name="projeto"></a>

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

