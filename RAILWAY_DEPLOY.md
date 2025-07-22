# MyTask Backend - Deploy en Railway

## Pasos para hacer deploy en Railway:

### 1. Preparar el repositorio
Asegúrate de que todos los cambios estén committed y pushed a tu repositorio de Git:

```bash
git add .
git commit -m "Configure Railway deployment"
git push origin main
```

### 2. Crear proyecto en Railway
1. Ve a [railway.app](https://railway.app)
2. Conecta tu cuenta de GitHub
3. Crea un nuevo proyecto
4. Conecta tu repositorio `MyTask-Bend`

### 3. Configurar variables de entorno en Railway
En el dashboard de Railway, ve a Variables y añade:

**Variables REQUERIDAS:**
- `PORT`: Se configurará automáticamente por Railway
- `MONGODB_URI`: tu string de conexión MongoDB (recomendado usar variables de entorno por seguridad)

**Opcional (para mayor seguridad):**
Si quieres usar variables de entorno para MongoDB:
- `MONGODB_URI`: `mongodb+srv://ettorepw:Diosesfiel1%2B@bibliotecadejunior.y2xvybm.mongodb.net/MyTaskListDB?retryWrites=true&w=majority`

### 4. Deploy
Railway detectará automáticamente que es un proyecto Java y usará el archivo `nixpacks.toml` para configurar el build.

## Archivos de configuración añadidos:

- **nixpacks.toml**: Configuración de build para Railway
- **Procfile**: Comando alternativo de inicio
- **application.properties**: Actualizado para usar variables de entorno

## Verificación local:
Para probar localmente con el nuevo setup:

```bash
# Compilar
./mvnw clean package -DskipTests=true

# Ejecutar con puerto específico
java -Dserver.port=8082 -jar target/*.jar
```

## Troubleshooting:

### Error 502 (Bad Gateway):
Si ves un error 502, la aplicación no está arrancando correctamente:

1. **Verificar logs en Railway**:
   - Ve al dashboard de Railway
   - Revisa los logs del deploy y runtime

2. **Configurar variables de entorno**:
   ```
   MONGODB_URI=mongodb+srv://usuario:password@cluster.mongodb.net/database
   SPRING_PROFILES_ACTIVE=railway
   ```

3. **Problemas comunes y soluciones**:
   - **Error de build**: Verificar que Java 17 esté disponible
   - **Error de conexión MongoDB**: Verificar string de conexión y whitelist de IPs
   - **Error de puerto**: Railway asigna automáticamente el puerto vía variable $PORT
   - **JAR no encontrado**: Verificar que el nombre del JAR coincida en nixpacks.toml

4. **Verificar health endpoint**:
   Una vez desplegado: `https://tu-app.railway.app/actuator/health`

5. **Logs útiles para debug**:
   - Application startup logs
   - MongoDB connection logs
   - Port binding logs

## Endpoints después del deploy:
- **API Base**: `https://tu-app.railway.app/api/tasks`
- **Swagger UI**: `https://tu-app.railway.app/swagger-ui/index.html`
- **Health check**: `https://tu-app.railway.app/actuator/health`
- **OpenAPI docs**: `https://tu-app.railway.app/v3/api-docs`
