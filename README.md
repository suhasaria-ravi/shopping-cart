# shopping-cart
For running on windows

1. Run Maven and build all projects.
2. Install and run Rabbit MQ.
3. To run zipkin:

set RABBIT_URI=amqp://localhost
java -jar zipkin.jar                           

4. Run each applicaiton as java app.

5. Run the BDD app for testing results.

----------------------------
Validation URLs:
----------------------------

Zipkin:
http://192.168.99.100:9411/zipkin/

Rabbit MQ:
http://192.168.99.100:15672/

Eureka:
http://192.168.99.100:8761

-----------------------
Rest APIs:
------------------------



GET: http://localhost:8001/shopping-cart/customers

GET: http://localhost:8002/shopping-cart/items

GET: http://localhost:8003/shopping-cart/orders


POST: http://localhost:8003/shopping-cart/order-for-existing-customer
With body as example:

{
    "custId": 1,
    "itemSku": 1,
    "ordQuantity": 1
}


POST: http://localhost:8003/shopping-cart/order-for-new-customer
With body as example:
{
    "fname": "FistName",
    "lname": "LastName",
    "itemSku": 2,
    "ordQuantity": 2
}

