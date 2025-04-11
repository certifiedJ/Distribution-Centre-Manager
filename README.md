# Distribution Centre Manager API Documentation

This guide provides an overview of the REST API endpoints for managing distribution centres and items. All endpoints require **Basic Authentication** with the credentials:

- **Username**: `admin`
- **Password**: `admin`

## Base URL
The examples assume the API is running at `http://localhost:8081`. Adjust the URL based on your deployment.

## Endpoints

### 1. Add Item to Distribution Centre
**Description**: Adds an item to a distribution centre with a specified quantity or updates the quantity if the item already exists.  
**Method**: `POST`  
**URL**: `/api/distribution-centres/{centreId}/items?itemId={itemId}&quantity={quantity}`  
**Example**:
```java
RestTemplate restTemplate = new RestTemplate();
String url = "http://localhost:8081/api/distribution-centres/1/items?itemId=2&quantity=10";
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "admin");
HttpEntity<String> request = new HttpEntity<>(headers);
ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
```
### 2. Delete Item from Distribution Centre
**Description**: Removes an item from a specific distribution centre.  
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
### 3. List All Distribution Centres
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
### 4. Request Items by Brand and Name
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