# Automation Exercise - Proyecto Screenplay Pattern

**Autor:** Estiven Ospina González  
**Patrón de Diseño:** Screenplay Pattern  
**Framework:** SerenityBDD + Cucumber + Gradle  
**Sitio Automatizado:** https://automationexercise.com/

---

## 📋 Descripción del Proyecto

Proyecto de automatización E2E que implementa el **patrón Screenplay** para validar el flujo completo de compra en Automation Exercise, desde el registro de usuario hasta la confirmación de orden.

### ✨ Características Principales

- ✅ **Patrón Screenplay**: Tasks, Questions, UI separados
- ✅ **Principios SOLID**: Responsabilidad única, segregación de interfaces
- ✅ **Clean Code**: Métodos < 20 líneas, nombres descriptivos
- ✅ **DRY**: Sin duplicación de código
- ✅ **Design Patterns**: Builder, Factory
- ✅ **Data-Driven Testing**: Escenarios outline con múltiples datos
- ✅ **Lombok**: Reducción de código boilerplate
- ✅ **SonarQube Ready**: Código limpio sin code smells

---

## 🏗️ Estructura del Proyecto

```
src/
├── main/java/org/com/screenplay/project/
│   ├── hook/          # OpenWeb task
│   ├── questions/     # Validaciones (Questions)
│   ├── tasks/         # Acciones del usuario (Tasks)
│   ├── ui/            # Page Objects con locators
│   └── utils/         # Constantes y utilidades
└── test/
    ├── java/org/com/screenplay/project/
    │   ├── runners/           # Test runners por feature
    │   └── stepdefinition/    # Step definitions
    └── resources/
        └── features/          # Archivos .feature en Gherkin
```

---

## 🚀 Requisitos Previos

- **Java JDK:** 8 o superior
- **Gradle:** 8.4
- **Edge Driver:** Compatible con tu versión de Edge
- **Git:** Para clonar el repositorio

---

## 📦 Instalación

```bash
# Clonar el repositorio
git clone https://github.com/eospgonz10/automationExercise.git
cd automationExercise

# Dar permisos de ejecución (Linux/Mac)
chmod +x gradlew

# Verificar instalación
./gradlew --version
```

---

## ▶️ Ejecución de Pruebas

### Ejecutar todos los tests
```bash
./gradlew clean test
```

### Ejecutar feature específico
```bash
# Registro de usuarios
./gradlew test --tests "org.com.screenplay.project.runners.RunnerRegisterUser"

# Selección de productos
./gradlew test --tests "org.com.screenplay.project.runners.RunnerProducts"

# Proceso de pago
./gradlew test --tests "org.com.screenplay.project.runners.RunnerPayment"

# Confirmación de orden
./gradlew test --tests "org.com.screenplay.project.runners.RunnerOrderConfirmation"

# Flujo E2E completo
./gradlew test --tests "org.com.screenplay.project.runners.RunnerE2EFlow"
```

### Ejecutar por tags
```bash
# Solo registro
./gradlew clean test -Dcucumber.filter.tags="@registro"

# Solo flujos E2E
./gradlew clean test -Dcucumber.filter.tags="@e2e"

# Múltiples tags
./gradlew clean test -Dcucumber.filter.tags="@registro or @productos"
```

---

## 📊 Generación de Reportes

```bash
# Generar reportes Serenity después de la ejecución
./gradlew aggregate

# El reporte se genera en:
# target/site/serenity/index.html

# Abrir reporte automáticamente (Linux)
xdg-open target/site/serenity/index.html

# Abrir reporte automáticamente (Mac)
open target/site/serenity/index.html

# Abrir reporte automáticamente (Windows)
start target/site/serenity/index.html
```

---

## 🧪 Flujos de Prueba Implementados

### 1. Registro de Nuevo Usuario
- Acceso a página de registro
- Completar formulario con datos válidos
- Validación de cuenta creada

### 2. Selección de Productos
- Navegación a catálogo
- Agregar múltiples productos al carrito
- Validación de productos en carrito

### 3. Proceso de Pago
- Checkout desde carrito
- Ingreso de datos de tarjeta
- Validación de pago procesado

### 4. Confirmación de Orden
- Visualización de mensaje de confirmación
- Validación de orden exitosa

### 5. Flujo E2E Completo
- Registro → Productos → Pago → Confirmación

---

## 🔧 Configuración

### Variables de Entorno (serenity.conf)

```hocon
environments {
  default {
    webdriver.base.url = "https://automationexercise.com/"
  }
}

credentials {
  default {
    user.email = "prueba1@udea.edu.co"
    user.password = "Prueba123"
  }
}
```

### Credenciales de Prueba

**Usuario existente:**
- Email: `prueba1@udea.edu.co`
- Password: `Prueba123`

---

## 📝 Convenciones de Código

- **Tasks:** Acciones del usuario (`Login`, `SignUp`, `AddProductsToCart`)
- **Questions:** Verificaciones (`UserIsLoggedIn`, `OrderConfirmation`)
- **UI:** Locators centralizados (`LoginUI`, `ProductsUI`, `PaymentUI`)
- **Step Definitions:** Un archivo por contexto (`LoginStep`, `ProductsStep`)
- **Runners:** Un runner por feature

---

## 🎯 Principios Aplicados

### SOLID
- **S** - Responsabilidad única en cada clase
- **O** - Abierto/Cerrado (extensible sin modificación)
- **L** - Sustitución de Liskov
- **I** - Segregación de interfaces
- **D** - Inversión de dependencias

### Clean Code
- Métodos cortos (< 20 líneas)
- Nombres descriptivos
- Sin código duplicado
- Comentarios solo cuando es necesario

---

## 📈 Análisis de Calidad

### SonarQube

```bash
# Ejecutar análisis de SonarQube
./gradlew sonarqube \
  -Dsonar.projectKey=automationExercise \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=YOUR_TOKEN
```

### Métricas Esperadas
- ✅ Bugs: 0
- ✅ Code Smells: Mínimos
- ✅ Cobertura: > 80%
- ✅ Duplicación: < 3%
- ✅ Complejidad Ciclomática: < 10

---

## 🐛 Troubleshooting

### Error: Driver no encontrado
```bash
# Verificar que Edge esté instalado
edge --version

# Actualizar driver automáticamente (Serenity lo hace por defecto)
```

### Error: Puerto en uso
```bash
# Cerrar procesos de Edge
pkill -f edge
```

### Error: Timeout
```bash
# Aumentar timeouts en serenity.conf
webdriver.timeouts.implicitlywait = 20000
```

---

## 📚 Recursos

- [Documentación Serenity BDD](https://serenity-bdd.info/)
- [Screenplay Pattern](https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals)
- [Cucumber](https://cucumber.io/docs/cucumber/)
- [Automation Exercise](https://automationexercise.com/)

---

## 👤 Autor

**Estiven Ospina González**
- GitHub: [@eospgonz10](https://github.com/eospgonz10)

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea tu rama de feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

**¡Happy Testing! 🚀**
