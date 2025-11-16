# Comandos Útiles - Automation Exercise

## 🚀 Compilación y Ejecución

### Compilar sin ejecutar tests
```bash
./gradlew clean build -x test
```

### Ejecutar todos los tests
```bash
./gradlew clean test
```

### Ejecutar tests y generar reportes
```bash
./gradlew clean test aggregate
```

---

## 📋 Ejecución por Runner

```bash
# Registro de usuarios
./gradlew test --tests "org.com.screenplay.project.runners.RunnerRegisterUser"

# Productos
./gradlew test --tests "org.com.screenplay.project.runners.RunnerProducts"

# Pago
./gradlew test --tests "org.com.screenplay.project.runners.RunnerPayment"

# Confirmación de orden
./gradlew test --tests "org.com.screenplay.project.runners.RunnerOrderConfirmation"

# Flujo E2E completo
./gradlew test --tests "org.com.screenplay.project.runners.RunnerE2EFlow"
```

---

## 🏷️ Ejecución por Tags

```bash
# Solo registro
./gradlew clean test -Dcucumber.filter.tags="@registro"

# Solo productos
./gradlew clean test -Dcucumber.filter.tags="@productos"

# Solo pago
./gradlew clean test -Dcucumber.filter.tags="@pago"

# Solo confirmación
./gradlew clean test -Dcucumber.filter.tags="@confirmacion"

# Flujo E2E
./gradlew clean test -Dcucumber.filter.tags="@e2e"

# Múltiples tags (OR)
./gradlew clean test -Dcucumber.filter.tags="@registro or @productos"

# Múltiples tags (AND)
./gradlew clean test -Dcucumber.filter.tags="@registro and @registroExitoso"

# Excluir tags
./gradlew clean test -Dcucumber.filter.tags="not @wip"
```

---

## 📊 Reportes

### Generar reportes Serenity
```bash
./gradlew aggregate
```

### Abrir reporte en el navegador

**Linux:**
```bash
xdg-open target/site/serenity/index.html
```

**Mac:**
```bash
open target/site/serenity/index.html
```

**Windows:**
```bash
start target/site/serenity/index.html
```

---

## 🧹 Limpieza

### Limpiar build y reportes
```bash
./gradlew clean
```

### Limpiar solo reportes
```bash
rm -rf target/site/serenity
```

---

## 🔍 Debug y Análisis

### Ejecutar con logs detallados
```bash
./gradlew test --info
```

### Ejecutar con debug
```bash
./gradlew test --debug
```

### Ver dependencias
```bash
./gradlew dependencies
```

### Ver tareas disponibles
```bash
./gradlew tasks
```

---

## 🐛 Troubleshooting

### Ver procesos de Gradle
```bash
./gradlew --status
```

### Detener daemon de Gradle
```bash
./gradlew --stop
```

### Limpiar cache de Gradle
```bash
rm -rf ~/.gradle/caches/
```

### Forzar descarga de dependencias
```bash
./gradlew clean build --refresh-dependencies
```

---

## 📈 SonarQube

### Ejecutar análisis local
```bash
./gradlew sonarqube \
  -Dsonar.projectKey=automationExercise \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=YOUR_TOKEN
```

---

## 🔧 Gradle Wrapper

### Actualizar Gradle Wrapper
```bash
./gradlew wrapper --gradle-version=8.10
```

### Verificar versión de Gradle
```bash
./gradlew --version
```

---

## 📦 Construcción

### Build completo con tests
```bash
./gradlew clean build
```

### Build sin tests (rápido)
```bash
./gradlew clean build -x test
```

### Build con reportes
```bash
./gradlew clean build test aggregate
```

---

## 🎯 Ejecución Rápida (Recomendada)

### Desarrollo rápido (solo compilación)
```bash
./gradlew clean compileJava compileTestJava
```

### Test + Reporte en un comando
```bash
./gradlew clean test aggregate && xdg-open target/site/serenity/index.html
```

### Pipeline completo
```bash
./gradlew clean build test aggregate
```

---

## ⚙️ Variables de Entorno

### Ejecutar con ambiente específico
```bash
./gradlew test -Denvironment=qa
```

### Ejecutar con credenciales custom
```bash
./gradlew test \
  -Dcredentials.default.user.email=custom@test.com \
  -Dcredentials.default.user.password=CustomPass123
```

### Ejecutar en modo headless
```bash
./gradlew test -Dheadless.mode=true
```

---

## 📝 Notas

- Los reportes se generan en: `target/site/serenity/index.html`
- Los logs se encuentran en: `target/site/serenity/`
- Screenshots se guardan automáticamente en cada acción
- La compilación exitosa indica que el código está libre de errores sintácticos

---

**¡Happy Testing! 🚀**
