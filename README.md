# Backend do projeto JoinFut

---

## Glossário

|Ordem| Informação                                                            |
|---|-----------------------------------------------------------------------|
|1| [Git Workflow](#Git-Workflow)                                         
|2| [Versões dos programas utilizados](#Versões-dos-programas-utilizados) |
|3| [Como rodar o projeto no Intellij](#Como-rodar-o-projeto-no-Intellij) |
|4| [Entendendo o projeto](#Entendendo-o-projeto)                         |
|5| [Configurações iniciais](#Configurações-iniciais)                     |

* Bem vindo ao projeto do Joinfut, abaixo se encontram:
  * Como rodar o projeto no Intellij e VSCODE
  * Links para explicações do códigos

## Git Workflow

|Informação|
|---|
|[Nomes](#Nomes)|

### Nomes

---

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

#### Criação de Branches

---

##### Criação pelo Gitlab

* Uma forma simples de criar uma Branch é direto no Gitlab, onde acesse a página inicial do repositório e siga as instruções do GIF abaixo:

<img src="https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/resources%5Cimages%5Cprocesso%5CCriando_Branch_Gitlab.gif">

* A branch principal se chama **Main** e ela é bloqueada para não receber commits direto nela, por ser a Branch ativa que o cliente utiliza.

* Branches ativas são Branches que precisam estar 100% funcionando e que não devem ser mexidas se não foi validado e testado as modificações, podendo quebrar o projeto e ficar fora do ar para o cliente.

##### Criação pelo Console

* A forma mais comum de criação de uma Branch é pelo console (ou terminal) quando o repositório está clonado em sua maquina (mais informações em [Git]())

* Abaixo um video completo de criação de uma branch

<img src="https://tools.ages.pucrs.br/Joinfut/joinfut-wiki/-/wikis/resources%5Cimages%5Cprocesso%5CCriando_Branch_Console.gif">

* Os comando utilizados são:

```
git pull
```
Git pull serve para trazer as atualizações que estão no repositório remoto (Gitlab)

```
git branch
```
Git branch serve para vermos qual é a Branch que estamos nesse momento, no vídeo tem uma extensão para powershell que mostra o nome da branch sempre que for um repositório GIT

```
git checkout -b fanto/architecure/#2
```
Git checkout -b serve para criar uma nova Branch e acessar ela automaticamente, onde ele espera que seja colocado o nome da branch depois do -b, essa Branch está seguindo o padrão definido no tópico nome de branches

```
git log
```
Git log serve para ver os Commits já feitos, onde mostra em qual Branch eles foram criados.

### Commits

---

#### Salvando Localmente

Para garantir que apenas o código necessário para funcionamento da tarefa lembre-se de realizar o comando `add` apenas nos arquivos **essenciais** para a tarefa:

```
git add <nomeDoArquivo>
```

Caso todos os arquivos modificados da Branch são essenciais, pode utilizar o ponto `.` para salvar todos os arquivos localmente, mas tenha muito cuidado para não salvar os arquivos que não são essenciais:

```
git add .
```

#### Padrão de Commits

Todos os commits devem começar com o **código da Issue** e uma mensagem direta do que foi feito naquele commit:

Exemplo de Issue:

<img src="resources\images\processo\Codigo_Issue.png">

Esse código marcado é o que deve vir antes da mensagem em português do que foi feito:

```
git commit -m "#1 Atualizando os nomes dos colegas"
```

Com isso, vai vincular automaticamente a Issue ao commit, facilitando o trabalho dos revisores e colegas para saber de onde veio as alterações e o que foi feito

<img src="resources\images\processo\Vinculo_Issue.png">

**ATENÇÃO** se o commit não estiver nessa estrutura, o commit vai ser invalidado e deverá ser feito um SQUASH de commits com a estrutura correta.

Não hesite em realizar vários commits, assim podemos ter documentado e salvo vários estados do desenvolvimento

---

#### Enviando modificações Remotamente

Depois de finalizar o desenvolvimento, envie todos os commits da sua máquina para o servidor remoto. Para isso depois de realizar as etapas de salvamento local, salve remotamente com o comando `push` sempre dizendo qual localização (origin) e o nome da branch, assim não terá conflitos de nomes e facilitará a verificar qual branch você está trabalhando:

```
git push origin fanto/architecture/#1
```

---

### Merge Requests

---

Depois de uma Demanda ter sido desenvolvida e estiver pronta de acordo com os critérios de aceitação, é necessário que a mesma seja enviada para a branch de desenvolvimento. Para isso é necessário abrir um Merge Request pela platafora GitLab:

#### Criando o Merge Request

A criação pode ser realizada na seção Merge Requests do repositório em que a branch foi criada. Clicando no botão `New Merge Request` siga os seguintes passos:

1. Selecionar a branch de origem (sua branch de desenvolvimento);
2. Selecionar a branch de destino (branch dev);
3. Selecione `Compare branches and continue`
4. Em `Title`, escreva um título que descreva a funcionalidade adicionada ou bug corrigido;
5. Em `Description`, escreva uma descrição com uma breve justificativa nos arquivos que foram alterados;
6. Na seção `Assignee`, selecione `Assign to me` para que fique registrado quem foi o responsável pelo desenvolvimento daquela tarefa (a pessoa selecionada será chamada caso o revisor tenha dúvidas sobre a tarefa);
7. Em `Milestone` selecione a Sprint em que a tarefa foi realizada;
8. Em `Labels`selecione qual é o tipo de tarefa que foi realizada;
9. Por último, revise se os arquivos que estão sendo enviados estão corretos e clique em `Submit Merge Request`.

#### Revisando o Merge Request

A revisão de merge request pode ser realizada por qualquer desenvolvedor, mas é preciso da aprovação de pelo menos um AGES III ou AGES IV para que a mesma seja incorporada na dev.

Na hora de revisar o Merge Request, entre na branch em sua máquina e teste a funcionalidade/bug/componente/tela de acordo com os critérios de aceitação apresentados no [Airtable](https://airtable.com/tblV0c8w2YX9PZAAC/viw4mJkZmd28WlplE?blocks=hide).

Caso haja pendências, relacionadas a documentação do código, padronização ou arquivos enviados, não exite em realizar um novo commit na branch com as mudanças necessárias antes de realizar a integração.

---

## Versões dos programas utilizados

* **Java 8** : [Como instalar o Java 8]()
* **Postman** : [Download do postman mais recente]()
* **Apache Maven 3.6.3** : [Como instalar o Maven]()
* **PostgreSQL 12**: [Como instalar o PostgreSQL 12]()

---

## Como rodar o projeto no Intellij

---

## Entendendo o projeto

---

## Configurações iniciais



