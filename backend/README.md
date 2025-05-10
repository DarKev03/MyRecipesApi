# 🍲 MyRecipes Backend

Backend REST API para la aplicación de recetas de cocina del TFG, desarrollado con Spring Boot y PostgreSQL. Permite gestionar usuarios, recetas, ingredientes, listas de la compra y más.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL (en Supabase)
- Maven
- Swagger (OpenAPI)
- Render (para despliegue)
- Lombok

---

## 📁 Estructura del proyecto

```
src/main/java/
├── controller
├── service
├── repository
├── entity
└── config
```

---

## ⚙️ Variables de entorno

Este proyecto utiliza variables de entorno para conectarse a la base de datos y definir perfiles de Spring.

### 📄 Archivo `.env` (no lo subas a GitHub):

```dotenv
SPRING_PROFILES_ACTIVE=default
DB_HOST=db.oobjaapymbqacotvschw.supabase.co
DB_PORT=5432
DB_NAME=postgres
DB_USER=postgres
DB_PASSWORD=CYklUHr7OPWkAQDg
```

---

## 💻 Cómo ejecutar en local

1. Clona el proyecto:
   ```bash
   git clone https://github.com/tuusuario/MyRecipesApi.git
   cd backend
   ```

2. Crea un archivo `.env` en la raíz del proyecto con las variables mostradas arriba.

3. Ejecuta el backend:
   ```bash
   export $(cat .env | xargs) && mvn spring-boot:run
   ```

4. Abre Swagger para probar la API:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## ☁️ Despliegue en Render

Este backend se despliega automáticamente en:

🔗 `https://<tu-nombre-servicio>.onrender.com`

### Variables de entorno en Render:
- `DB_HOST`
- `DB_PORT`
- `DB_NAME`
- `DB_USER`
- `DB_PASSWORD`
- `SPRING_PROFILES_ACTIVE`

### Comandos en Render:
- **Build command:** `./mvnw clean install`
- **Start command:** `java -jar target/backend-0.0.1-SNAPSHOT.jar`

---

## 📚 Endpoints principales

| Método | Ruta                         | Descripción                        |
|--------|------------------------------|------------------------------------|
| GET    | `/api/recipes`               | Listar recetas                     |
| POST   | `/api/recipes`               | Crear una receta                   |
| GET    | `/api/ingredients`           | Listar ingredientes                |
| POST   | `/api/auth/register`         | Registrar usuario                  |
| POST   | `/api/auth/login`            | Iniciar sesión (simple)            |
| GET    | `/swagger-ui/index.html`     | UI para explorar y probar la API   |

---

## ✅ TODO pendiente (futuras mejoras)

- Implementar autenticación JWT
- Validación avanzada con DTOs
- Tests unitarios
- Filtros y búsqueda por ingredientes
- Documentación técnica adicional

---

## 📄 Licencia

Proyecto creado como parte del Trabajo de Fin de Grado. Uso académico y personal autorizado.
