# Lava Jato API

Este repositório contém o código-fonte de uma aplicação de gerenciamento para um lava jato, desenvolvida em **Spring Boot** com suporte ao **Java 21**. A API permite realizar o gerenciamento de clientes, veículos, serviços e agendamentos, proporcionando uma solução completa para administração do negócio.

## Funcionalidades

- **Gestão de Clientes:**
  - Cadastro, edição, consulta e remoção de clientes.
- **Gestão de Veículos:**
  - Associação de veículos a clientes, consulta e atualização de dados.
- **Gestão de Serviços:**
  - Definição de serviços oferecidos, como lavagem, polimento e revisão.
- **Agendamentos:**
  - Sistema para agendamento de serviços com registro de data e horário.
- **Relatórios:**
  - Consulta de relatórios sobre serviços realizados e histórico de clientes.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security (para autenticação e autorização)
- **Banco de Dados:** PostgreSQL
- **Documentação:** Swagger/OpenAPI
- **Ferramentas de Build:** Maven

## Requisitos

- **Java 21** instalado
- **Maven** instalado
- Banco de Dados PostgreSQL configurado

## Configuração do Projeto

1. Clone este repositório:

```bash
git clone https://github.com/AndersonSilvaJob/car-wash.git
```

2. Acesse o diretório do projeto:

```bash
cd carwash
```

3. Configure o arquivo `application.properties` em `src/main/resources`:

```properties
spring.datasource.url=${DATABASE_URL:jdbc:mysql://localhost:3306/carwash}
spring.datasource.username=${DATABASE_USERNAME:root}
spring.datasource.password=${DATABASE_PASSWORD:admin}
spring.jpa.hibernate.ddl-auto=update
```

4. Compile e execute o projeto:

```bash
mvn spring-boot:run
```

## Endpoints Principais

### Clientes
- `GET /clientes` - Lista todos os clientes
- `POST /clientes` - Cria um novo cliente
- `PUT /clientes/{id}` - Atualiza informações de um cliente
- `DELETE /clientes/{id}` - Remove um cliente

### Veículos
- `GET /veiculos` - Lista todos os veículos
- `POST /veiculos` - Adiciona um novo veículo

### Serviços
- `GET /servicos` - Lista todos os serviços
- `POST /servicos` - Cria um novo serviço

### Agendamentos
- `GET /agendamentos` - Lista todos os agendamentos
- `POST /agendamentos` - Cria um novo agendamento

## Testes

Para executar os testes:

```bash
mvn test
```

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Fork este repositório
2. Crie um branch para sua feature: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'Adiciona nova funcionalidade'`
4. Envie para o branch principal: `git push origin minha-feature`
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais informações.
