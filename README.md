# crud-java-esig
Um sistema de gestão de tarefas simples feito em java, jpa, jsf, maven. Nele você pode cadastrar colaboradores e para cada colaborador pode-se ter várias tarefas, as tarefas tem os seguintes campos status, titulo, descrição, data, responsavel e prioridade. Jpa foi usado para criar nossas tabelas no banco de dados com base nas classes criadas acelarando o processo de criação do banco, as telas foram feitas com a tecnologia jsf que tem várias bibliotecas que facilatam a criação dessas telas e também foi usado o mavem uma ferramenta de gerenciamento de dependencias, em um arquivo pom.xml coloca as dependencias que serão usadas no projeto e ele automatiza o download delas.

<h2> Como rodar o projeto </h2>
Baixe a pasta crud-java-esig ou clone este repositório em sua maquina, importe a pasta crud para a IDE que você utiliza, caso seja o eclipse, entre no site da mvn repository e baixe o lombok, abra o arquivo baixado deixe ele achar eclipse e clique em install/update, depois de instalado clique em quit installer. Para integrar o projeto ao seu banco, vá ao arquivo persistence.xml que está em src/main/resources e substitua os values das tags "property" pelas a do seu banco de dados, por exemplo eu usei o postgreSQL então fica value="org.postgresql.Driver", você pode achar essas configurações do site do banco que você usa, vão ser elas as do driver, url, user e senha, na property que tem "hibernate.dialect" você deve procurar as configurações de acordo com a versão do seu banco, e quando for rodar a primeira vez trocar na property hibernate.hbm2ddl.auto o seu value por create, para que ele crie as tabelas. O server usado foi o tomcat v8.5, voce deve adicionar o projeto a ele para rodar.

<h2><a href="https://maven.apache.org/index.html">Maven</a></h2>
Gerenciador de projetos que ajuda o desenvolvedor com o controle e manejamento das: -> Dependencias -> Bilds -> Documentação -> Etc

<h2><a href="https://www.postgresql.org">PostgreSQL</a></h2>
PostgreSQL é um sistema gerenciador de banco de dados objeto relacional.

<h2><a href="https://projectlombok.org">Lombok</a></h2>
Biblioteca que agiliza muitas das implementações que seriam realizadas write less code more

<h2><a href="http://tomcat.apache.org">TomCat Apache</a></h2>
O Tomcat é um servidor Java-Web, que implementa as tecnologias Java Servlet e JavaServer Pages, permitindo assim, que a aplicação esteja disponivel para coneção em Navegador.

<h2><a href="https://www.primefaces.org">PrimeFaces</a></h2>
O PrimeFaces é uma biblioteca de componentes de interface de usuário de código-fonte aberto para aplicativos baseados em JavaServer Faces

<h2>Dependencias utilizadas:</h2>

-> hibernate-core 5.5.3.Final

-> 9.1-901-1.jdbc4

-> junit 4.13.2

-> lombok 1.18.18

-> javax.faces 2.4.0

-> primefaces 8.0

-> weld-servlet-core 3.1.4.Final

-> omnifaces 3.5

-> javax.validation validation-api 2.0.1.Final

-> hibernate-validator 6.0.13.Final


<h2>Telas e funcionalidades</h2>
O Sistema possui cinco telas para que ocorra a manipulação dos dados, todas elas, disponiveis ao acesso por meio de uma barra de navegação


<h4>Cadastro de colaboradores</h4>
Nesta tela é possível fazer o cadastro de um colaborador para que ele seja responsável por uma tarefa. O usuário deve informar um nome e cargo de um colaborador para cadastra-lo no sistema. O usuário não deve preocupar-se com a digitação de uma matrícula ou identificador, pois o próprio sistema ficará responsavel para garantir que dois funcionários não possuam o mesmo identificador.

<h4>Relatorio dos Colaboradores cadastrados</h4>
Sera possivel conferir todos os funcionarios cadastrados no sistema.

<h4>Alterar e Excluir</h4>
Caso um dos Colaboradores ou alguma tarefa exibidos na tabela, seja selecionado, o usuário poderá alterar os dados nas caixas de texto ou excluir o colaborador assim que o usuário pressione um dos botões.

<h4>Tela de cadastro de uma tarefa</h4>
Nessa tela o usuário poderá cadastrar uma tarefa, assim como no Colaborador, o controle do número de identificação fica por conta do sistema, assim como o estado de uma tarefa, que por sua vez sempre é Em andamento quando criada.

<h4>Tela de gerenciar  uma tarefa</h4>
Tal qual a tabela de colaboradores, o usuário poderá alterar os dados e excluir uma tarefa assim que selecionada, porem, o usuário também poderá marcar uma tarefa como concluida.

<h4>Tela de buscar tarefas</h4>
Nessa tela o usuário poderá utilizar os campos disponíveis para filtrar tarefas específicas.
