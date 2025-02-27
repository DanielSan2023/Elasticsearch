# Application with SpringBoot starter Data Elasticsearch

## Overview

The **Elasticsearch Integration with Spring Boot** project demonstrates how to integrate Elasticsearch
into a Spring Boot application. It provides a scalable and efficient way to store, query,
and manage employee data using Elasticsearch. The project leverages **Spring Data Elasticsearch**
and the **Elasticsearch Java client** for seamless integration.
---

## Features

- **Elasticsearch Integration**: Uses Spring Data Elasticsearch for CRUD operations and advanced querying.
- **RESTful API**: Supports querying employee data using custom Elasticsearch queries.
- **Pagination**: Supports paginated results for large datasets.
- **Secure Connection**: Configures HTTPS and authentication for Elasticsearch.

---

## Project Structure

### Main Components:

1. **Entity - `Employee`**
    - Represents an employee stored in the employee index in Elasticsearch.
    - Uses Spring Data Elasticsearch annotations for seamless integration.

2. **Repository - `Repository `**
    - Provides methods for querying Elasticsearch, including custom queries and pagination.

3. **Configuration - `GetESClient and HttpClientConfigImpl`**
    - Configures the Elasticsearch client with HTTPS and authentication.
    - Sets up the connection to the Elasticsearch instance.

---

## Elasticsearch Index Design

### Index Schema

| Attribute    | Type   | Notes                                           |
|--------------|--------|-------------------------------------------------|
| `id`         | String | Primary key. Unique identifier for an employee. |
| `name`       | String | Name of the employee.                           |
| `department` | String | Department the employee belongs to.             |
| `email`      | String | Email address of the employee.                  |
| `salary`     | double | Salary of the employee.                         |

### Repository Methods

### 1.Find by Salary Range

- **Find by Name**: `List<Employee> findByName(String name);`
    - Description: `Retrieves employees by their name.`
    - Example: `employeeRepository.findByName("John Doe");`

### 2.Find by Salary Range

**Find by Salary** `List<Employee> findBySalaryBetween(double min, double max);`

- **Description**: `Retrieves employees with salaries between the specified range.`.
- **Example**: `employeeRepository.findBySalaryBetween(30000, 50000);`

### 3.Find by Name and Minimum Salary

**Match by min and max Salary
** `@Query(value = "{\"bool\": {\"must\":[{ \"match\": {\"name\": \"?0\"}},{\"range\": {\"salary\": {\"gte\": ?1}}}]}}")
List<Employee> findByNameMatchQueryAndSalary(String name, double minSalary);`

- **Description**: ` Retrieves employees by name and a minimum salary.`
- **Example**: `employeeRepository.findByNameMatchQueryAndSalary("John Doe", 40000);`

### 4. Paginated Results

**Pagination ** `/Page<Employee> findAll(Pageable pageable);`

- **Description**: ` Retrieves employees with pagination support.`
- **Example**: `employeeRepository.findAll(PageRequest.of(0, 10));`

## Configuration

### Elasticsearch Client Configuration

- The **GetESClient** class configures the Elasticsearch client using the **ElasticsearchClient** from the Elasticsearch
  Java client library.
- It sets up the connection to an Elasticsearch instance running on `localhost:9200` with **HTTPS**.

---

### HTTP Client Configuration

- The **HttpClientConfigImpl** class configures the HTTP client with SSL and authentication credentials for connecting
  to Elasticsearch.

## Configuration

- **Elasticsearch:** Ensure Elasticsearch 8.7.0 is running on localhost:9200 with HTTPS enabled.
- **Java:** Java 21 or higher.
- **Maven:** For building and running the project.


## Running the Project

- **Build the Project:** `mvn clean install`
- **Run the Application:** `mvn spring-boot:run`
- **Access the Application:** The application will start on the default Spring Boot port `(8080)..`
-
## License

- This project is licensed under the MIT License. See the LICENSE file for details.