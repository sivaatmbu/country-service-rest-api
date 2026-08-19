# Country Service REST API

This is a simple Spring Boot REST API project developed to understand and practice REST API development using Spring Boot.

Currently, this project uses a **HashMap as an in-memory database** to store country data. In the future, the HashMap will be replaced with a real database.

## Project Flow

The development flow I followed for this project:

**Service → Bean (when required) → Controller → Run Application → Test using Postman**

## How I Developed This Project

### 1. Created Country Bean

First, I created the `Country` bean class because the service class needs to work with Country objects.

The `Country` class contains:

- `id`
- `countryName`
- `countryCapital`
- Getters and Setters

### 2. Created CountryService

Next, I created the `CountryService` class to implement the required services.

First, I created a `HashMap<Integer, Country>` and stored 6 country details in it.

The services implemented are:

1. Get all countries
2. Get country by ID
3. Get country by name
4. Add a new country
5. Update a country
6. Delete a country

### 3. Created Message Bean

For the delete country operation, I created another bean called `Message`.

It is used to return a message along with the ID of the deleted country.

### 4. Created CountryController

After completing the services, I created the `CountryController` class to map the services to HTTP requests.

The controller uses:

- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@PathVariable`
- `@RequestParam`
- `@RequestBody`

### 5. Run and Test the Application

After completing the Controller, I ran the Spring Boot application.

I tested all the HTTP requests using **Postman**.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- REST API
- HashMap
- Maven
- Postman

## Current Data Storage

Currently, the country data is stored using:

```text
HashMap<Integer, Country>

---
© 2026 Siva Praneesh. All rights reserved.
