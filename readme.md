## Prometheus Monitoring of REST API
This code helps you understand how monitoring of REST APIs is done via Spring boot.


### Code Requirements
1) The example code is in Java ([version 1.8](https://java.com/en/download/) or higher will work). 
2) Prometheus for Windows

### Description
Prometheus is an open-source systems monitoring and alerting toolkit originally built at SoundCloud. Since its inception in 2012, many companies and organizations have adopted Prometheus, and the project has a very active developer and user community. It is now a standalone open source project and maintained independently of any company.

For more information, [see](https://prometheus.io/docs/introduction/overview/)

## Working Example
<img src="https://github.com/akshaybahadur21/Prometheus_Monitoring/blob/master/prom.gif">

Changes in prometheus.yml file
```java
  - job_name: 'prometheus-metrics'
    metrics_path: '/prometheus-metrics'
    static_configs:
      - targets: ['localhost:8080']
``` 
Changes in application.properties file
```java
endpoints.prometheus.path= prometheus-metrics
management.security.enabled=false
``` 

### Execution
mvn clean install
java -jar iCoin.java

```
mvn clean install
java -jar iCoin.java
```
