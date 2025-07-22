# 🔧 Troubleshooting Guide: Error 502 (Bad Gateway)

## 🚨 ¿Qué significa Error 502?

Un error 502 significa que Railway no puede iniciar tu aplicación correctamente. La aplicación no está respondiendo en el puerto asignado.

## 🔍 Pasos para Diagnosticar

### 1. **Revisar Logs de Railway**
```bash
# En el dashboard de Railway:
1. Ve a tu proyecto MyTask-Bend
2. Click en "View Logs" 
3. Busca errores en:
   - Build logs (durante la compilación)
   - Runtime logs (durante la ejecución)
```

### 2. **Verificar Build Exitoso**
```bash
# Logs que debes ver:
✅ "BUILD SUCCESS" en Maven
✅ "MyTaskList-0.0.1-SNAPSHOT.jar created"
✅ No errores de compilación Java
```

### 3. **Verificar Inicio de Aplicación**
```bash
# Logs que debes ver:
✅ "Started MyTaskListApplication in X seconds"
✅ "Tomcat started on port(s): XXXX"
✅ "MongoDB connected successfully"
```

## ⚙️ Configuración Necesaria en Railway

### Variables de Entorno:
```
PORT=<automático por Railway>
MONGODB_URI=mongodb+srv://ettorepw:Diosesfiel1%2B@bibliotecadejunior.y2xvybm.mongodb.net/MyTaskListDB?retryWrites=true&w=majority
```

### Archivos de Configuración:
- ✅ `nixpacks.toml` - Configuración de build
- ✅ `Procfile` - Comando de inicio (respaldo)
- ✅ `application.properties` - Configuración Spring Boot

## 🐛 Problemas Comunes y Soluciones

### 1. **Error: "Port already in use"**
```yaml
# Solución: Verificar nixpacks.toml
[phases.start]
cmd = "java -Dserver.port=$PORT -jar target/MyTaskList-0.0.1-SNAPSHOT.jar"
```

### 2. **Error: "MongoDB connection failed"**
```properties
# Solución: Verificar application.properties
spring.data.mongodb.uri=${MONGODB_URI:mongodb+srv://ettorepw:Diosesfiel1%2B@bibliotecadejunior.y2xvybm.mongodb.net/MyTaskListDB?retryWrites=true&w=majority}
```

### 3. **Error: "JAR not found"**
```bash
# Verificar que el nombre del JAR coincida:
target/MyTaskList-0.0.1-SNAPSHOT.jar
```

### 4. **Error: "Permission denied on mvnw"**
```toml
# nixpacks.toml debe incluir:
[phases.build]
cmds = [
  "chmod +x mvnw",
  "./mvnw clean package -DskipTests=true"
]
```

## 🔧 Soluciones Paso a Paso

### Solución 1: Verificar Configuración Básica
```bash
1. Revisa que application.properties tenga:
   server.port=${PORT:8082}
   
2. Revisa que nixpacks.toml tenga:
   cmd = "java -Dserver.port=$PORT -jar target/MyTaskList-0.0.1-SNAPSHOT.jar"
```

### Solución 2: Simplificar Configuración
```bash
1. Remove perfiles complejos de Spring
2. Usa configuración directa en application.properties
3. Evita variables de entorno opcionales
```

### Solución 3: Verificar MongoDB
```bash
1. Prueba la conexión MongoDB desde otra herramienta
2. Verifica que la IP esté en whitelist (0.0.0.0/0)
3. Confirma usuario y contraseña
```

### Solución 4: Health Check Manual
```bash
# Una vez desplegado, verifica:
curl https://mytask-bend-production.up.railway.app/actuator/health
```

## 📊 Logs Típicos de una App Funcionando

```log
BUILD SUCCESS
Started MyTaskListApplication in 45.123 seconds (JVM running for 48.456)
Tomcat started on port(s): 8080 (http) with context path ''
MongoDB connection established to: mongodb+srv://...
Application is ready to serve requests
```

## 🚨 Logs Típicos de Error 502

```log
Error starting ApplicationContext
Failed to configure a DataSource: 'url' attribute is not specified
Connection refused: no further information to mongodb
Port 8080 was already in use
Application startup failed
```

## 💡 Tips Adicionales

### 1. **Usa Configuración Simple**
- Evita perfiles múltiples de Spring
- Usa variables de entorno con fallbacks
- Mantén configuración mínima necesaria

### 2. **Verifica Dependencias**
```xml
<!-- Asegúrate que pom.xml incluya: -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### 3. **Test Local Primero**
```bash
# Antes de deploy, prueba local:
./mvnw spring-boot:run -Dserver.port=8082
```

## 🔄 Proceso de Debug Recomendado

1. **Local Test** ✅
   ```bash
   ./mvnw clean package -DskipTests=true
   java -jar target/MyTaskList-0.0.1-SNAPSHOT.jar
   ```

2. **Verify Build** ✅
   ```bash
   git push origin main
   # Revisar logs de build en Railway
   ```

3. **Check Runtime** ✅
   ```bash
   # Revisar logs de runtime en Railway
   # Verificar que la app inicie correctamente
   ```

4. **Test Endpoints** ✅
   ```bash
   curl https://mytask-bend-production.up.railway.app/api/tasks
   ```

## 🆘 Si Nada Funciona

1. **Crear nuevo deployment en Railway**
2. **Usar template básico de Spring Boot**
3. **Migrar configuración paso a paso**
4. **Contactar soporte de Railway**

---

**Última actualización**: Julio 2025  
**Estado actual**: Configuración simplificada aplicada
