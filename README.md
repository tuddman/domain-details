#Domain Details

_Know things about domains._

Domain Details is a stubbed service to capture & provide information about collected domains.

### Getting Started

run the following command in a terminal to start the service
```
cd domain-details/
./mvnw spring-boot:run
```

### Build the JAR file
```
./mvnw clean package
```

### Run the JAR 
```
java -jar target/domain-details-0.1.0-SNAPSHOT.jar
```

### Ensure the service is running

[http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)


### Available Endpoints
browse to [http://localhost:8080](http://localhost:8080) to see that the service has started.

browse to [http://localhost:8080/domains](http://localhost:8080/domains) to see the list of collected domains.

#### add a domain
```
curl -i -H "Content-Type: application/json" -X POST -d '{"url":"acbxyz123","commonName":"Bazaar","details":"..."}' http://localhost:8080/domains
```

