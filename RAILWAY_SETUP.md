# 🚂 Railway Setup - Environment Variables

## ❗ WICHTIG: Environment Variables konfigurieren

Dein Projekt funktioniert lokal, aber nicht auf Railway, weil die **Environment Variables** fehlen!

## 📋 Schritt-für-Schritt Anleitung

### 1. Gehe zu deinem Railway Dashboard
1. Öffne https://railway.app
2. Logge dich ein
3. Wähle dein Projekt "MyTask-Bend"

### 2. Environment Variables setzen
1. Klicke auf dein **Service** (MyTask-Bend)
2. Gehe zum **"Variables"** Tab
3. Klicke auf **"New Variable"**

### 3. Setze diese Variables:

#### Variable 1 (ERFORDERLICH):
```
Name:  MONGODB_URI
Value: mongodb+srv://ettorepw:Diosesfiel1%2B@bibliotecadejunior.y2xvybm.mongodb.net/MyTaskListDB?retryWrites=true&w=majority&maxPoolSize=10&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&socketTimeoutMS=0
```

#### Variable 2 (Optional):
```
Name:  SPRING_PROFILES_ACTIVE  
Value: railway
```

#### Variable 3 (Falls nötig):
```
Name:  PORT
Value: 8080
```

### 4. Deploy triggern
Nach dem Setzen der Variables:
1. Gehe zum **"Deployments"** Tab
2. Klicke auf **"Redeploy"** oder
3. Mache einen neuen Git Push

## 🔍 Variables überprüfen

Nach dem Deployment kannst du überprüfen ob es funktioniert:

```bash
# Health Check
curl https://DEINE-RAILWAY-URL/actuator/health

# Test Endpoint mit Environment Info
curl https://DEINE-RAILWAY-URL/test
```

## 🚨 Häufige Fehler

### Fehler 1: Application Failed to Start
**Ursache:** MONGODB_URI fehlt
**Lösung:** Variable MONGODB_URI setzen

### Fehler 2: Port Already in Use
**Ursache:** PORT Variable nicht korrekt
**Lösung:** Sicherstellen dass PORT=${PORT:8080} in properties steht

### Fehler 3: Cannot Connect to MongoDB
**Ursache:** MongoDB Atlas IP Whitelist
**Lösung:** 0.0.0.0/0 zur Whitelist hinzufügen in MongoDB Atlas

## 📱 Railway Dashboard Zugriff

### Variables Tab finden:
```
1. Railway Dashboard öffnen
2. Dein Projekt auswählen
3. Service "MyTask-Bend" klicken  
4. "Variables" Tab → hier die Environment Variables setzen
5. "Deployments" Tab → hier Deployments verwalten
6. "Logs" Tab → hier Fehlermeldungen lesen
```

## ✅ Nach dem Setup

Deine App sollte dann erreichbar sein unter:
- **API**: https://DEINE-URL.up.railway.app
- **Health**: https://DEINE-URL.up.railway.app/actuator/health  
- **Test**: https://DEINE-URL.up.railway.app/test
- **Swagger**: https://DEINE-URL.up.railway.app/swagger-ui/index.html

## 🛠️ Troubleshooting

### Logs anschauen:
1. Railway Dashboard → dein Service
2. "Logs" Tab
3. Nach Fehlern suchen wie:
   - "Connection refused"
   - "Port already in use"  
   - "MongoDB connection failed"

### Häufige Log Meldungen:
```
✅ GOOD: "APPLICATION READY" 
✅ GOOD: "Started MyTaskListApplication"
❌ BAD: "MongoSocketOpenException"
❌ BAD: "Port 8080 was already in use"
```

## 💡 Warum diese Variables?

- **MONGODB_URI**: Ohne diese kann die App nicht mit der Datenbank verbinden
- **SPRING_PROFILES_ACTIVE=railway**: Lädt spezielle Railway-Konfiguration  
- **PORT**: Railway setzt das automatisch, aber Fallback ist gut

Nach dem Setzen der Environment Variables sollte dein Projekt auf Railway funktionieren!
