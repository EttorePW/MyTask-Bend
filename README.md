# ✅ MyTask Backend - Sistema de Gestión de Tareas

API REST robusta para gestión de tareas desarrollada con Spring Boot 3.5.3. Utiliza MongoDB para persistencia de datos y está optimizada para deployment en Railway.

## 🌟 Características

- ✅ **API REST completa** - CRUD de tareas con MongoDB
- ✅ **Sistema de categorías** - Organización y clasificación de tareas
- ✅ **Estados de tareas** - Pendientes y completadas
- ✅ **Documentación automática** - Swagger/OpenAPI 3 integrado
- ✅ **Health checks** - Monitoreo con Spring Boot Actuator
- ✅ **CORS configurado** - Listo para frontend web
- ✅ **Deploy en Railway** - Configuración optimizada para producción
- ✅ **Base de datos MongoDB** - Conexión a MongoDB Atlas

## 🚀 Tecnologías

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.5.3** - Framework principal
- **Spring Data MongoDB** - ORM para MongoDB
- **Spring Session MongoDB** - Gestión de sesiones
- **Spring Boot Actuator** - Health checks y monitoreo
- **Swagger/OpenAPI 3** - Documentación automática de API
- **MongoDB Atlas** - Base de datos en la nube
- **Maven** - Gestión de dependencias y build
- **Railway** - Plataforma de deployment

## 📁 Estructura del Proyecto

```
MyTask-Bend/
├── .mvn/                          # Maven wrapper config
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── MyTaskApp/MyTaskList/
│   │   │       ├── MyTaskListApplication.java    # Clase principal
│   │   │       ├── config/                       # Configuraciones
│   │   │       ├── controller/                   # REST Controllers
│   │   │       ├── model/                        # Entidades MongoDB
│   │   │       ├── repository/                   # Repositorios
│   │   │       ├── service/                      # Lógica de negocio
│   │   │       └── dto/                          # Data Transfer Objects
│   │   └── resources/
│   │       ├── application.properties            # Configuración principal
│   │       └── application-railway.properties    # Configuración Railway
│   └── test/                                     # Tests unitarios
├── target/                                       # Build artifacts
├── nixpacks.toml                                # Configuración Railway
├── Procfile                                     # Comando de inicio (backup)
├── pom.xml                                      # Dependencias Maven
├── RAILWAY_DEPLOY.md                            # Guía de deployment
├── TROUBLESHOOTING_502.md                       # Guía de troubleshooting
└── README.md                                    # Documentación principal
```

## 🛠️ Instalación y Desarrollo Local

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+ (o usar el wrapper incluido)
- MongoDB local o acceso a MongoDB Atlas
- IDE recomendado: IntelliJ IDEA o VS Code

### Configuración
1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/EttorePW/MyTask-Bend.git
   cd MyTask-Bend
   ```

2. **Configura MongoDB** (opcional para desarrollo):
   ```properties
   # En application.properties
   spring.data.mongodb.uri=mongodb://localhost:27017/mytaskdb
   ```

3. **Ejecuta la aplicación**:
   ```bash
   # Usando Maven wrapper
   ./mvnw spring-boot:run
   
   # O usando Maven instalado
   mvn spring-boot:run
   
   # O compilar y ejecutar JAR
   ./mvnw clean package -DskipTests=true
   java -jar target/MyTaskList-0.0.1-SNAPSHOT.jar
   ```

4. **Verifica que funciona**:
   - API: http://localhost:8082
   - Swagger UI: http://localhost:8082/swagger-ui/index.html
   - Health Check: http://localhost:8082/actuator/health

## 📖 API Endpoints

### 🔍 Documentación Automática
- **Swagger UI**: `https://mytask-bend-production.up.railway.app/swagger-ui/index.html`
- **OpenAPI JSON**: `https://mytask-bend-production.up.railway.app/v3/api-docs`

### 📋 Endpoints Principales

#### Tasks
```http
GET    /api/tasks              # Obtener todas las tareas
POST   /api/tasks              # Crear nueva tarea
GET    /api/tasks/{id}          # Obtener tarea por ID
PUT    /api/tasks/{id}          # Actualizar tarea
DELETE /api/tasks/{id}          # Eliminar tarea
```

#### Categories
```http
GET    /api/categories          # Obtener todas las categorías
POST   /api/categories          # Crear nueva categoría
GET    /api/categories/{id}     # Obtener categoría por ID
PUT    /api/categories/{id}     # Actualizar categoría
DELETE /api/categories/{id}     # Eliminar categoría
```

#### Health & Monitoring
```http
GET    /actuator/health         # Estado de la aplicación
GET    /actuator/info           # Información de la aplicación
```

### 📊 Estructura de Datos

#### Task (Tarea)
```json
{
  "taskId": "string",
  "taskTitle": "string",
  "taskNote": "string",
  "taskCategory": {
    "categoryId": "string",
    "categoryName": "string"
  },
  "taskDate": "yyyy-mm-dd",
  "hasDone": boolean,
  "createdAt": "2025-07-22T10:30:00Z",
  "updatedAt": "2025-07-22T10:30:00Z"
}
```

#### Category (Categoría)
```json
{
  "categoryId": "string",
  "categoryName": "string",
  "createdAt": "2025-07-22T10:30:00Z"
}
```

### 📝 Ejemplos de Uso

#### Crear una tarea
```bash
curl -X POST https://mytask-bend-production.up.railway.app/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "taskTitle": "Completar proyecto",
    "taskNote": "Finalizar la implementación del sistema de tareas",
    "taskCategory": "trabajo",
    "taskDate": "2025-08-01",
    "hasDone": false
  }'
```

#### Obtener todas las tareas
```bash
curl https://mytask-bend-production.up.railway.app/api/tasks
```

#### Marcar tarea como completada
```bash
curl -X PUT https://mytask-bend-production.up.railway.app/api/tasks/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "hasDone": true
  }'
```

## 🚀 Deployment en Railway

### Configuración Automática
El proyecto incluye configuración optimizada para Railway:
- **`nixpacks.toml`** - Configuración de build con Java 17
- **`Procfile`** - Comando de inicio alternativo
- **`application.properties`** - Variables de entorno con fallbacks

### Deployment
1. **Conecta tu repositorio** en Railway
2. **Variables de entorno** (opcionales, tienen fallbacks):
   ```
   MONGODB_URI=tu-connection-string-mongodb
   ```
3. **Deploy automático** - Railway detecta cambios en main branch

### URLs de Producción
- **API Base**: `https://mytask-bend-production.up.railway.app`
- **Swagger UI**: `https://mytask-bend-production.up.railway.app/swagger-ui/index.html`
- **Health Check**: `https://mytask-bend-production.up.railway.app/actuator/health`

## 🧪 Testing

### Ejecutar Tests
```bash
# Todos los tests
./mvnw test

# Tests específicos
./mvnw test -Dtest=TaskControllerTest

# Con coverage
./mvnw test jacoco:report
```

### Testing Manual
```bash
# Health check
curl https://mytask-bend-production.up.railway.app/actuator/health

# Obtener tareas
curl https://mytask-bend-production.up.railway.app/api/tasks

# Crear categoría
curl -X POST https://mytask-bend-production.up.railway.app/api/categories \
  -H "Content-Type: application/json" \
  -d '{"categoryName": "trabajo"}'
```

## ⚙️ Configuración

### Variables de Entorno
| Variable | Descripción | Default | Requerido |
|----------|-------------|---------|-----------|
| `PORT` | Puerto del servidor | 8082 | ❌ (Railway lo asigna) |
| `MONGODB_URI` | Connection string MongoDB | URI incluida | ❌ |
| `MONGODB_DATABASE` | Nombre de base de datos | MyTaskListDB | ❌ |

### Perfiles de Spring
- **default**: Configuración para desarrollo local
- **railway**: Configuración optimizada para Railway (opcional)

### Configuración CORS
```java
// Configurado para permitir frontend
@CrossOrigin(origins = "*")
// O específicamente:
@CrossOrigin(origins = "https://tu-frontend.com")
```

## 🐛 Troubleshooting

### Errores Comunes

1. **Error 502 en Railway**:
   - Consulta: `TROUBLESHOOTING_502.md`
   - Revisa logs de Railway
   - Verifica configuración de puerto

2. **Error de conexión MongoDB**:
   ```bash
   # Verifica connection string
   # Asegúrate que IP está en whitelist (0.0.0.0/0)
   ```

3. **Error de build**:
   ```bash
   # Limpia cache Maven
   ./mvnw clean
   
   # Verifica versión Java
   java --version  # Debe ser 17+
   ```

4. **Swagger no carga**:
   ```bash
   # Verifica que la app esté iniciada
   curl /actuator/health
   
   # URL correcta:
   /swagger-ui/index.html
   ```

### Logs Útiles
```bash
# Logs de MongoDB
logging.level.org.springframework.data.mongodb=DEBUG

# Logs de web requests
logging.level.org.springframework.web=DEBUG

# Logs de la aplicación
logging.level.MyTaskApp.MyTaskList=DEBUG
```

## 📈 Mejoras Futuras

- 🔐 **Autenticación JWT** - Sistema de usuarios y roles
- 📊 **Métricas avanzadas** - Prometheus/Grafana integration
- 🔄 **Cache Redis** - Para mejorar performance
- 📋 **Paginación** - Para listas grandes de tareas
- 🔍 **Búsqueda full-text** - MongoDB text search
- 📧 **Notificaciones** - Email/SMS para recordatorios
- 🏗️ **Arquitectura hexagonal** - Mejor separación de capas
- 🧪 **Test coverage 100%** - Tests exhaustivos
- 📱 **WebSockets** - Updates en tiempo real

## 🛡️ Seguridad

### Implementado
- ✅ CORS configurado
- ✅ Spring Boot Security básico
- ✅ Validación de datos de entrada
- ✅ Health checks sin información sensible

### Por implementar
- 🔐 JWT Authentication
- 🔒 HTTPS enforcement
- 🛡️ Rate limiting
- 🔍 Input sanitization avanzada

## 🤝 Contribuciones

1. Fork el proyecto
2. Crea una rama feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Guías de Contribución
- Seguir convenciones de Spring Boot
- Añadir tests para nuevas funcionalidades
- Documentar cambios en la API
- Mantener compatibilidad con versiones anteriores

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver [LICENSE](LICENSE) para detalles.

## ✨ Agradecimientos

- **Spring Team** - Por el excelente framework
- **MongoDB** - Por la base de datos flexible
- **Railway** - Por la plataforma de deployment
- **OpenAPI** - Por la documentación automática
- **Comunidad Open Source** - Por inspiration y resources

## 👨‍💻 Autor

**EttoreJunior**
- GitHub: [@EttorePW](https://github.com/EttorePW)
- Frontend: [MyTask-fend](https://github.com/EttorePW/MyTask-fend)

---

### 📊 Estado del Proyecto

| Aspecto | Estado | Notas |
|---------|--------|-------|
| **Build** | ✅ Funcionando | Maven build exitoso |
| **Tests** | ⚠️ Básicos | Necesita más cobertura |
| **Deployment** | ✅ Railway | Auto-deploy configurado |
| **API Docs** | ✅ Swagger | Documentación completa |
| **Database** | ✅ MongoDB Atlas | Conexión estable |
| **Monitoring** | ✅ Actuator | Health checks activos |

---

**Versión**: 0.0.1-SNAPSHOT  
**Última actualización**: Julio 2025  
**Java**: 17  
**Spring Boot**: 3.5.3
