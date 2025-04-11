# Distribution-Centre-Manager
CPAN22-Web-Project RESTFUL API
# API Documentation
## 1. Add Item to Distribution Centre
   Description: Associates an item with a specific distribution centre and specifies the quantity. If the item is already associated, the quantity is updated.
   URL: POST /api/distribution-centres/{centreId}/items
   Parameters:
   centreId: The ID of the distribution centre (path variable).
   itemId: The ID of the item (request parameter).
   quantity: The quantity of the item (request parameter).
   Example Using Spring Boot:

RestTemplate restTemplate = new RestTemplate();

String url = "http://localhost:8081/api/distribution-centres/1/items?itemId=2&quantity=10";

HttpHeaders headers = new HttpHeaders();

headers.setBasicAuth("admin", "admin");

HttpEntity<String> request = new HttpEntity<>(headers);

ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

## 2. Delete Item from Distribution Centre
   Description: Removes the association between a distribution centre and an item.
   URL: DELETE /api/distribution-centres/{centreId}/items/{itemId}
   Parameters:
   centreId: The ID of the distribution centre (path variable).
   itemId: The ID of the item to remove (path variable).
   Example Using Spring Boot:

RestTemplate restTemplate = new RestTemplate();

String url = "http://localhost:8081/api/distribution-centres/1/items/2";

HttpHeaders headers = new HttpHeaders();

headers.setBasicAuth("admin", "admin");

HttpEntity<String> request = new HttpEntity<>(headers);

ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);


## 3. List All Distribution Centres
   Description: Retrieves a list of all distribution centres.
   URL: GET /api/distribution-centres
   Example Using Spring Boot:

RestTemplate restTemplate = new RestTemplate();

String url = "http://localhost:8081/api/distribution-centres";

HttpHeaders headers = new HttpHeaders();

headers.setBasicAuth("admin", "admin");

HttpEntity<String> request = new HttpEntity<>(headers);

ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

### Authorization: 
Use basic authentication with username admin and password admin. Set the Authorization header to Basic YWRtaW46YWRtaW4= (Base64 encoded admin:admin).
Notes
The examples assume the API is running on http://localhost:8081. Adjust the base URL as needed.