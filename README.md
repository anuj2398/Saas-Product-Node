# Saas-Product-Node
A simple demonstration of a SaaS product with the CRUD operations and a Java service to implement logic with MongoDB as the database
## how to run
The Node server is run of port 3000 
The API endpoints are:
- `GET /products` - Retrieve a list of all products.
- `GET /products/{product_id}` - Retrieve details of a specific product.
- `POST /products` - Add a new product.
- `PUT /products/{product_id}` - Update details of a specific product.
- `DELETE /products/{product_id}` - Remove a specific product.
- 'PUT /price-update' - Endpoint to receive price updates from the Java service
The Java service is a spring boot application running on port 8080
The MongoDB will be running on port 27017
Spring project is build using gradle.All the necessary dependencies are defined in build.gradle
## steps to run
-First download both the folders product-service and Saas product backend \
-Setup the MongoDB compass in your local machine with mongodb://localhost:27017 and table digital-products and collection name products \
-Run the product-service which is a springBoot application and run the Node.js Saas product backend \
-once both the applications are connected to the MongoDB , you can use Thunder Client extension of the VS code to run the API's


https://github.com/anuj2398/Saas-Product-Node/assets/59406385/bda8e2e9-2de3-4d91-93ad-fafd1ed3da6e



