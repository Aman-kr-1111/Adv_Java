# JDBC Connection Example with Oracle Database

This guide demonstrates how to connect to an Oracle database using JDBC and retrieve data from a table named `EMP52`.

---

## 💻 Prerequisites

1. **Oracle Database:** Ensure you have Oracle Database installed.
2. **JDBC Driver:** Download and add the Oracle JDBC driver (e.g., `ojdbc11.jar`) to your project's classpath.
3. **Database Table:** Create the table `EMP52` with sample data (SQL script provided below).

```sql
CREATE TABLE EMP52 (
    ID VARCHAR2(10),
    Name VARCHAR2(50),
    Dept VARCHAR2(50),
    Salary NUMBER
);

INSERT INTO EMP52 VALUES ('101', 'John Doe', 'IT', 50000);
INSERT INTO EMP52 VALUES ('102', 'Jane Smith', 'HR', 60000);
COMMIT;
```

---

## 🔧 Steps to Connect and Execute a Query in JDBC

1. **📚 Load the Oracle JDBC Driver**
   ```java
   Class.forName("oracle.jdbc.driver.OracleDriver");
   ```
   - Loads the Oracle JDBC driver into memory.
   
2. **🔌 Create a Connection**
   ```java
   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADVJAVA", "ADVJAVA");
   ```
   - Connects to the Oracle database with:
     - `jdbc:oracle:thin:@localhost:1521:XE`: JDBC URL specifying the database server.
     - `"ADVJAVA"`: Username.
     - `"ADVJAVA"`: Password.

3. **🖋 Prepare a Statement**
   ```java
   Statement stm = con.createStatement();
   ```
   - Prepares an object for SQL execution.

4. **📋 Execute an SQL Query**
   ```java
   ResultSet rs = stm.executeQuery("SELECT * FROM EMP52");
   ```
   - Executes the `SELECT` query on the `EMP52` table and stores the result in a ResultSet.

5. **📜 Process the ResultSet**
   ```java
   while (rs.next()) {
       System.out.println(
           rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
       );
   }
   ```
   - Reads and prints data row by row.
   - Example methods used:
     - `rs.getString(1)`: Fetch first column.
     - `rs.getInt(4)`: Fetch fourth column as an integer.

6. **❌ Close the Connection**
   ```java
   con.close();
   ```
   - Closes the connection to free resources.

7. **⚠ Exception Handling**
   ```java
   catch (Exception e) {
       e.printStackTrace();
   }
   ```
   - Captures and logs exceptions during execution.


---

## 📝 Sample Output

For the table `EMP52` with the following data:

| ID   | Name       | Dept | Salary |
|------|------------|------|--------|
| 101  | John Doe   | IT   | 50000  |
| 102  | Jane Smith | HR   | 60000  |

---
The output will be:
```plaintext
101     John Doe     IT      50000
102     Jane Smith   HR      60000
```
