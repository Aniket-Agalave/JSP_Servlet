# JSP + Servlet + JDBC Login & User Display App

This is a basic Java EE web application that performs user **login validation** and **displays all users** stored in a MySQL database using **JSP**, **Servlets**, **JDBC**, and **JSTL**.

---

## 🧾 Features

- Login functionality with credential check against MySQL database
- Displays a list of all users from the database
- JSP-based frontend with basic form and table
- JDBC connection using a utility class

---

## 🛠️ Tech Stack

- Java EE (Servlets, JSP)
- MySQL Database
- JDBC API
- Apache Tomcat (or any Java EE compatible servlet container)
- JSTL (JavaServer Pages Standard Tag Library)

---

## 📁 Project Structure
```
aniket-agalave-jsp_servlet.git/
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── tka/
        │           ├── DBConnection.java
        │           ├── GetUsersServlet.java
        │           ├── LoginServlet.java
        │           └── User.java
        └── webapp/
            ├── home.jsp
            ├── index.jsp
            ├── users.jsp
            ├── META-INF/
            │   └── MANIFEST.MF
            └── WEB-INF/
                └── lib/
```

---

## 🧑‍💻 How It Works

### 1. `index.jsp`

- Simple login form with fields for username and password.
- Submits data to `LoginServlet`.

### 2. `LoginServlet.java`

- Reads credentials from form.
- Validates against `user` table in MySQL.
- On **success** → forwards to `home.jsp`.
- On **failure** → returns to `index.jsp` with "invalid" message.

### 3. `home.jsp`

- Displays a link: “get all users”
- Clicking it calls `/get-users` endpoint (mapped to `GetUsersServlet`).

### 4. `GetUsersServlet.java`

- Fetches all users from the `user` table in the database.
- Populates a list of `User` objects.
- Forwards data to `users.jsp`.

### 5. `users.jsp`

- Uses JSTL `<c:forEach>` to loop through the `users` list and display data in an HTML table.

---

## 🧮 Database Setup

Create a MySQL database named `jsp_servlet` and a table `user`:

```sql
CREATE DATABASE IF NOT EXISTS jsp_servlet;

USE jsp_servlet;

CREATE TABLE IF NOT EXISTS user (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    age INT,
    city VARCHAR(100)
);

## 🚀 How to Run the Project

### ✅ Prerequisites

Make sure the following are installed:

- **Java JDK 8+**
- **Apache Tomcat 9 or 10**
- **MySQL**
- **Eclipse IDE** (or any IDE that supports Dynamic Web Projects)
- **JSTL JARs** (`jstl.jar` and `standard.jar`) — Place them in `src/main/webapp/WEB-INF/lib/`

---

### 🛠️ Setup Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/aniket-agalave-jsp_servlet.git
   ```

2. **Open in Eclipse**

   - Go to `File > Import > Existing Projects into Workspace`
   - Select the root folder `aniket-agalave-jsp_servlet`
   - Make sure the project is recognized as a **Dynamic Web Project**

3. **Configure Apache Tomcat**

   - Go to `Servers` tab → Right-click → `New > Server`
   - Choose Apache Tomcat version (matching your installation)
   - Add your project to the server

4. **Setup MySQL Database**

   - Ensure MySQL is running
   - A database named `jsp_servlet` will be created automatically if it does not exist (based on the connection URL):
     ```
     jdbc:mysql://localhost:3306/jsp_servlet?createDatabaseIfNotExist=true
     ```
   - Update username and password in `DBConnection.java` if needed:
     ```java
     DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/jsp_servlet?createDatabaseIfNotExist=true",
         "root",
         "root"
     );
     ```

5. **Create Table `user` Manually (Optional)**

   ```sql
   CREATE TABLE user (
       username VARCHAR(50),
       password VARCHAR(50),
       age INT,
       city VARCHAR(100)
   );
   ```

6. **Run the Application**

   - Right-click the project → `Run As > Run on Server`
   - Access the app at: [http://localhost:8080/aniket-agalave-jsp_servlet](http://localhost:8080/aniket-agalave-jsp_servlet)

---

### 📂 Default Pages

- `index.jsp`: Login form
- `home.jsp`: Redirected page after successful login
- `users.jsp`: Displays all users from the database


INSERT INTO user (username, password, age, city) VALUES
('admin', '123', 25, 'Pune'),
('john', 'doe123', 30, 'Mumbai');



