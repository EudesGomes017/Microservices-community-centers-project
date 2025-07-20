# 🏙️ Microservices Community Centers

Este projeto consiste em uma arquitetura de microsserviços baseada em Spring Boot, que simula uma plataforma de monitoramento de centros comunitários, utilizando Kafka para comunicação assíncrona entre serviços e MongoDB para persistência de dados.

## 📦 Serviços

### 1. `center-service`
Responsável por cadastrar e atualizar os centros comunitários e enviar eventos ao Kafka quando houver alteração de lotação.

### 2. `notification-service`
Escuta os eventos Kafka e envia notificações (simuladas via log ou futuramente e-mail/SMS) para os administradores.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia         | Descrição                                      |
|--------------------|-----------------------------------------------|
| Java 21            | Linguagem principal                            |
| Spring Boot 3      | Framework para construção dos microserviços    |
| Spring Web         | APIs REST                                      |
| Spring Kafka       | Integração com Apache Kafka                    |
| Spring Data Mongo  | Persistência no MongoDB                        |
| Apache Kafka       | Broker de mensagens                            |
| MongoDB            | Banco de dados NoSQL                           |
| Docker & Docker Compose | Contêineres e orquestração dos serviços  |
| Swagger/OpenAPI    | Documentação automática das APIs               |
| Kafka UI           | Interface web para gerenciamento dos tópicos Kafka |
| Postman            | Testes manuais das rotas HTTP                  |

---

## 🐳 Como executar via Docker

1. **Clone o projeto:**
```bash
git clone https://github.com/seu-usuario/Microservices-community-centers-project.git
cd Microservices-community-centers-project
Suba os serviços:

docker-compose up --build
Acesse os serviços:

Serviço	URL
Center Service	http://localhost:8081/swagger-ui/index.html
Notification Service	http://localhost:8083/swagger-ui/index.html
Kafka UI	http://localhost:8088

🧪 Testes com Postman
Exemplo de criação de centro:
http
POST http://localhost:8081/api/centers/create
Content-Type: application/json

{
  "name": "Centro Norte",
  "maxCapacity": 100,
  "currentOccupancy": 80
}
Espera-se que o serviço envie uma mensagem para o Kafka e o notification-service registre a notificação no log.

📁 Estrutura de Diretórios

Microservices-community-centers-project/
├── center-service/
│   ├── src/
│   ├── Dockerfile
│   └── ...
├── notification-service/
│   ├── src/
│   ├── Dockerfile
│   └── ...
├── docker-compose.yml
└── README.md
❗Dificuldades Enfrentadas
Durante o desenvolvimento do projeto, as seguintes dificuldades foram superadas:

❌ Conexões entre containers: Os serviços inicialmente não conseguiam resolver os nomes dos containers (mongo, kafka), o que causava falha nas dependências do Spring.

❌ Configuração do Kafka: A variável KAFKA_ADVERTISED_LISTENERS precisou ser corretamente ajustada para PLAINTEXT://kafka:9092 para funcionar dentro da rede Docker.

❌ Problemas com Maven e encoding: Erros de MalformedInputException exigiram que os arquivos fossem salvos com o encoding correto (UTF-8).

❌ Swagger não respondia: Foi necessário garantir que o server.address=0.0.0.0 estivesse configurado e que as portas estivessem corretamente expostas.

Todas essas barreiras foram superadas com ajustes de rede, perfis Spring e boas práticas com Docker.

🛠️ Próximas melhorias
 Integração com banco relacional (PostgreSQL)

 Envio real de notificações (e-mail/SMS)

 Implementação de testes automatizados (JUnit, Testcontainers)

 Deploy em cloud (AWS, Azure ou GCP)

📬 Contato
Desenvolvido por Eudes Gomes

"A melhor forma de prever o futuro é criá-lo." – Peter Drucker
