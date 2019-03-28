# shopping-cart

----------------------
DOCKER STEPS -- Link: https://hub.docker.com/r/ravisuhasaria/shopping-cart
-----------------------

Please put value for RABBIT_MQ_HOST and DOCKER_HOST which ever is sutiable.

1.>Create Network:

docker network create sc_net

2.>RUN Docker Zipkin:

docker run -ti -d --network sc_net   --name inst-sc-zipkin -p 9411:9411 -d sc-zipkin 

Validate URL: http://192.168.99.100:9411/zipkin/



3.>RUN Docker RabbitMQ:

docker run -d --network sc_net   --name sc-rabbit -p 5672:5672 -p 15672:15672 -e RABBIT_URI=amqp://192.168.99.100  rabbitmq:3-management

Validate URL: http://192.168.99.100:15672/

4.>RUN Netflix-Eureka:

docker run -ti -d --network sc_net  --name inst-sc-netf-eurk -p 5672 -p 15672 -p 8761:8761 -e "RABBIT_MQ_HOST=192.168.99.100"  -e "DOCKER_HOST=192.168.99.100" -e "RABBIT_URI=amqp://192.168.99.100" --link sc-rabbit  -d sc-netf-eurk

Validate URL: http://192.168.99.100:15672/

#5.>RUN Customer-MS:

docker run -ti -d --network sc_net   --name inst-sc-customer -p 5672 -p 15672 -p 8761 -p 8001:8001  -e "RABBIT_MQ_HOST=192.168.99.100"  -e "DOCKER_HOST=192.168.99.100" --link sc-netf-eurk  -d sc-customer

docker run -ti -d --network sc_net   --name inst-sc-item -p 5672 -p 15672 -p 8761 -p 8002:8002      -e "RABBIT_MQ_HOST=192.168.99.100"  -e "DOCKER_HOST=192.168.99.100" --link sc-netf-eurk  -d sc-item

docker run -ti -d --network sc_net   --name inst-sc-order -p 5672 -p 15672 -p 8761 -p 8003:8003     -e "RABBIT_MQ_HOST=192.168.99.100"  -e "DOCKER_HOST=192.168.99.100" --link sc-netf-eurk  -d sc-order




