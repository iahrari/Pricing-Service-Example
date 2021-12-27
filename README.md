# Pricing Service

This project is a spring boot application that contains rest api for retrieving price for a source and destination.

## Requirements

This project needs java 11+ and will run on port 8081.

## Execute
You can simply run this project with Intelij Idea or with Spring boot extension pack in VsCode alternatively you can run project with this command.

```bash
./mvnw spring-boot:run
```

## Requests
***Get price***
----
  Get price for a source and destination.

* **URL**

  /api/v1/price

* **Method:**

  `POST`

* **Request Body**
    * **Content:** 
        ```
        { 
            "source" : "String", 
            "destination": "String"
        }
        ```

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    ```
    {  
        "source": "String", 
        "destination": "String", 
        "price": "decimal number" 
    }
    ```

* **Error Response:**

  * **Code:** 400 <br />
    **Content:** 
    ```
    { 
        "field name": "String reason",
        "field name2": "String reason",
        .
        .
        .
    }
    ```

