# 🏦 EazyBank Microservices

Enterprise level microservices project built with Spring Boot and Spring Cloud.

## 📁 Project Structure

```
Microservices/
├── Accounts/          # Accounts microservice (port 8080)
├── Cards/             # Cards microservice (port 9000)
├── loans/             # Loans microservice (port 8090)
└── config-server/     # Spring Cloud Config Server (port 8071)
```

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Cloud 2024.0.1**
- **Spring Cloud Config Server** — centralized configuration management
- **H2 Database** — in-memory database for development
- **Hibernate / Spring Data JPA** — ORM
- **Lombok** — boilerplate reduction
- **SpringDoc OpenAPI** — API documentation (Swagger UI)
- **Maven** — build tool

## 🔧 Microservices Overview

### Accounts Service (port 8080)
Handles customer account creation, retrieval, update and deletion.

**Endpoints:**
| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/create` | Create a new account |
| GET | `/api/account?mobileNumber=` | Fetch account details |
| PUT | `/api/update` | Update account details |
| DELETE | `/api/delete?mobileNumber=` | Delete account |
| GET | `/api/version` | Get build version |
| GET | `/api/contact-info` | Get contact info from config |

---

### Cards Service (port 9000)
Handles card creation, retrieval, update and deletion.

**Endpoints:**
| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/create` | Create a new card |
| GET | `/api/fetch?mobileNumber=` | Fetch card details |
| PUT | `/api/update` | Update card details |
| DELETE | `/api/delete?mobileNumber=` | Delete card |
| GET | `/api/build-info` | Get build version |

---

### Loans Service (port 8090)
Handles loan creation, retrieval, update and deletion.

**Endpoints:**
| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/create` | Create a new loan |
| GET | `/api/fetch?mobileNumber=` | Fetch loan details |
| PUT | `/api/update` | Update loan details |
| DELETE | `/api/delete?mobileNumber=` | Delete loan |
| GET | `/api/build-info` | Get build version |

---

### Config Server (port 8071)
Centralized configuration server for all microservices using Spring Cloud Config.

Supports:
- **Native profile** — serves configs from `classpath:/config`
- **Git profile** — serves configs from a remote git repository

**Verify config is being served:**
```
http://localhost:8071/accounts/prod
http://localhost:8071/cards/prod
http://localhost:8071/loans/prod
```

## ⚙️ Configuration

Each microservice connects to the config server via `application.yml`:

```yaml
spring:
  application:
    name: "accounts"   # must match config file name
  profiles:
    active: "prod"
  config:
    import: "configserver:http://localhost:8071/"
```

## 🚀 How to Run

> **Important:** Always start Config Server first!

```
1. Start config-server   → http://localhost:8071
2. Start Accounts        → http://localhost:8080
3. Start Cards           → http://localhost:9000
4. Start Loans           → http://localhost:8090
```

## 📖 API Documentation (Swagger UI)

Once services are running:
```
Accounts → http://localhost:8080/swagger-ui/index.html
Cards    → http://localhost:9000/swagger-ui/index.html
Loans    → http://localhost:8090/swagger-ui/index.html
```

## 📚 Concepts Covered

- [x] REST API design with Spring Boot
- [x] Spring Data JPA + H2 in-memory database
- [x] Input validation with `@Valid` and `@Pattern`
- [x] Centralized config management with Spring Cloud Config Server
- [x] Profile-based configuration (`dev`, `prod`, `qa`)
- [x] `@ConfigurationProperties` with Java Records
- [x] `@Value` for injecting config properties
- [x] Native config (classpath) and Git-based config
- [x] OpenAPI / Swagger documentation
- [x] Spring Boot Actuator

## 🔜 Coming Up Next

- [ ] `@RefreshScope` — live config refresh without restart
- [ ] Spring Cloud Bus — broadcast refresh to all services
- [ ] Service Discovery with Eureka
- [ ] API Gateway
- [ ] Inter-service communication with OpenFeign
- [ ] Docker & Docker Compose
