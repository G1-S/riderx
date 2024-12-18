# RiderX - Sistema de Caronas Compartilhadas

**RiderX** é um sistema de backend para um aplicativo de caronas compartilhadas, permitindo o gerenciamento eficiente de usuários, corridas e veículos. O sistema fornece operações de CRUD, autenticação segura e cálculo de tempo estimado para viagens.

## 📋 Funcionalidades

### Usuários
- Cadastro de usuários com informações detalhadas.
- Autenticação segura utilizando tokens JWT.
- Operações de CRUD para gerenciar os dados.

### Corridas
- Cadastro e gerenciamento de corridas.
- Consulta de corridas por destino.
- Cálculo de tempo estimado de viagem com base na distância e velocidade.

### Veículos
- Cadastro de veículos com validações.
- Gerenciamento de informações como modelo, placa e ano.

---

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **MySQL** - Persistência de dados.
- **Insomnia** - Teste de APIs.
- **Git e GitHub** - Controle de versão.

### Dependências:
- Spring Data JPA
- MySQL Driver
- Spring Web
- Spring Security (JWT)
- Validation
- Maven

---

## 🔗 Endpoints

### Usuário
- `GET /usuarios/all` - Lista todos os usuários.
- `GET /usuarios/{id}` - Retorna um usuário específico.
- `POST /usuarios` - Cria um novo usuário.
- `PUT /usuarios` - Atualiza um usuário existente.
- `DELETE /usuarios/{id}` - Remove um usuário.

### Corridas
- `GET /corridas/all` - Lista todas as corridas.
- `GET /corridas/{id}` - Retorna detalhes de uma corrida específica.
- `POST /corridas` - Cria uma nova corrida.
- `PUT /corridas` - Atualiza uma corrida.
- `DELETE /corridas/{id}` - Remove uma corrida.

### Veículos
- `GET /veiculos/all` - Lista todos os veículos.
- `GET /veiculos/id/{id}` - Retorna detalhes de um veículo.
- `POST /veiculos` - Cria um novo veículo.
- `PUT /veiculos` - Atualiza um veículo.
- `DELETE /veiculos/id/{id}` - Remove um veículo.

---

## ⚙️ Segurança com Spring Security e JWT

O sistema implementa autenticação e autorização seguras:
- **JWT**: Tokens gerados com validade de 1 hora.
- **Criptografia de Senhas**: Utiliza BCryptPasswordEncoder.
- **Filtros de Segurança**: Requisições protegidas com validação de token.

---

## 🚀 Funcionalidade Especial

### Cálculo de Tempo de Viagem
Permite calcular o tempo estimado de viagem de uma corrida com base na fórmula:

