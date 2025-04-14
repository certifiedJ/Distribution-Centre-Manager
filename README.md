# Distribution Centre Manager API Documentation

This guide provides an overview of the REST API endpoints for managing distribution centres and items. All endpoints require **Basic Authentication** with the credentials:

- **Username**: `admin`
- **Password**: `admin`

## Base URL
The examples assume the API is running at `http://localhost:8081`. Adjust the URL based on your deployment.

## Endpoints
### 1. Get all existing Items
**Description**: Get all existing Items from ITEMS table.  
**Method**: `GET`  
**URL**: `/api/items/all`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/items/all;
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
```
### 2. Manipulate Item in a Distribution Centre
**Description**: associate new item with distribution centre or **_addition/subtraction_** the amount of item in a centre.   
* add a new item with positive amount in a centre
* increase the amount of existing item in a centre with positive number
* delete the specific amount of existing item in a centre with negative number 

**Method**: `POST`  
**URL**: `/api/distribution-centres/{centreId}/items?itemId={itemId}&quantity={quantity}`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/distribution-centres/1/items?itemId=2&quantity=-10";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
```
### 3. Add new Item to Items table
**Description**: Adds a new item to item category with a specified name, brand, year, price. It will return 409 conflict if the brand and name combination exists.  
**Method**: `POST`  
**URL**: `/api/items/create?name=shorts&brand=YSL&year=2024&price=199.99`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/items/create?name=shorts&brand=YSL&year=2024&price=199.99";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
```
### 4. Delete Item from Distribution Centre
**Description**: Dissociate/Removes an item from a specific distribution centre completely.  
**Method**: `DELETE`  
**URL**: `/api/distribution-centres/{centreId}/items/{itemId}`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/distribution-centres/1/items/2";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
```
### 5. List All Distribution Centres
**Description**: Retrieves a list of all distribution centres.  
**Method**: `GET`  
**URL**: `/api/distribution-centres`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/distribution-centres";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
```
### 6. Request Items by Brand and Name
**Description**: Searches for items by exact brand and name substring, returning availability details.  
**Method**: `GET`  
**URL**: `/api/items/search?brand={brand}&name={name}`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/items/search?brand=Nike&name=shirt";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
```
### Notes
- **Authentication**: All endpoints require Basic Authentication with `admin:admin`.
- **Response Format**: 
  - Successful requests return JSON.
  - Errors return plain text messages.