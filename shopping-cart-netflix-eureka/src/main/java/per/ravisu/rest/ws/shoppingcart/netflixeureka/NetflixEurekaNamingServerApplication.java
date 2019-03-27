package per.ravisu.rest.ws.shoppingcart.netflixeureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaNamingServerApplication { 
	
	private static Logger logger = LoggerFactory.getLogger(NetflixEurekaNamingServerApplication.class);
	
    @Value("{spring.rabbitmq.host}")
    private static String rabbitMQValue;
    
    @Value("${localhost.uri.ravisu}")
    private static String localhostvalue;

	public static void main(String[] args) {
		
		logger.info("Localhost value read as : {}", localhostvalue);
		logger.info("rabbitMQValue value read as : {}", rabbitMQValue);
		
		SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE; 
		
		
	}
}
