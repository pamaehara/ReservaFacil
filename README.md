# ReservaFacil

Aplicação de agendamento e consulta de transferências financeiras.

Tecnologias utilizadas para a aplicação foram:
- PrimeFaces 6.0
- Spring 4.3.7.RELEASE
- Hibernate 5
- Mockito 1.9.5
- Maven
- Postgre
- Tomcat 8

Optei pelo PrimeFaces por ser simples e fácil de configurar e desenvolver, o Spring porque é o melhor ou um dos melhores frameworks para injeção de dependência, inversão de controle, controle de transação e para os serviços Restful, o Hibernate/JPA para ORM devido sua eficacia para aplicações tipo CRUD, Maven para controle de versão e de dependências do projeto, Postgre por ser um database free, Tomcat por ser um container fácil e leve.

No desenvolvimento optei por estruturar o projeto em pacotes bem definidos e utilizei o design pattern Factory Method para implementar as regras para cálculo da taxa.

Para testar a solução pode-se usar os seguintes endereços:

- lista dos agendamentos realizados:
Pagina - http://localhost:8080/ReservaFacil/listaAgendamentos.xhtml ou 
API - http://localhost:8080/ReservaFacil/api/agendamento/listaAgendamentos

- cadastrar agendamentos
Pagina - http://localhost:8080/ReservaFacil/agendamentoTransferencia.xhtml ou 
API - http://localhost:8080/ReservaFacil/api/agendamento/agendar
