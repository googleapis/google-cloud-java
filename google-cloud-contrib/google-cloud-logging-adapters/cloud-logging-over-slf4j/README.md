## Slf4j Adapter for Google Cloud Logging

Built with [Slf4j](https://www.slf4j.org/) v1.7.21 and 
[Google cloud logging library](https://github.com/GoogleCloudPlatform/google-cloud-java/tree/master/google-cloud-logging)

Adapter library for [Google Cloud logging](https://cloud.google.com/logging/docs/view/logs_viewer_v2) over Slf4j.


## Configuration and setup
Install [Apache Maven](https://maven.apache.org/) <p>
`mvn clean install`

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.example</groupId>
  <artifactId>cloud-logging-over-slf4j</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

### Configuration file
Set system property or environment variable `CLOUD_LOGGING_CONFIG` to the absolute path of .yaml configuration file. <p>
Here is a sample configuration file : [google-cloud-logging.yaml](src/test/resources/google-cloud-logging.yaml)<p>

#### Fields
- `destination` (optional) : defaults to direct writes via API. <p>
Allowed values : <p>
 -`"stdout"` : logs to standard out <p>
 -`"fluentd"` logs to fluentd forwarding port (`localhost:24224`)
 
- `loggers` (list) : (optional)
  ##### Required fields for custom loggers : 
  - `name` : "default" or package/class name
  ##### Optional fields : 
  - `log_name` defaults to `name` if not specified <p>
  - `resource` defaults to `global`, restricted to 
  [Supported ResourceTypes](https://cloud.google.com/logging/docs/api/v2/resource-list)<p>
  - `enable`  : boolean [default : true] <p>
  - `level` : Min log level. Supported log levels [here](https://www.slf4j.org/api/org/apache/commons/logging/Log.html)<p>
  - `labels` (optional) : Adds custom labels to logs <p>
     - Format list of key, value pairs, eg `project_id: "$GOOGLE_CLOUD_PROJECT"`
     - prefix values with `$` to use system/environment variable values. 
   <p> Use `default` logger name to update default logging parameters <p>

## Usage
Initialize the service in a class with
`Logger logger = LoggerFactory.getLogger(loggerName)`

- Log using standard Slf4j formatting : <p>
  - `logger.info("Hello world {}: INFO", "app")` <p>
  - `logger.error("Hello world : {}", "exception", new Throwable("illegal argument"))` <p>
  - `logger.debug("Hello world : DEBUG")` <p>
  - `logger.trace("Hello world : TRACE")` <p>
  
 - Markers can be used to set Cloud logging log levels that are not supported via Slf4j 
    : `NOTICE`, `CRITICAL`, `ALERT`, `EMERGENCY`<p>
    Examples : <p>
    - `logger.info(MarkerFactory.getMarker("NOTICE"), Hello world : INFO_NOTICE")` <p>
    - `logger.error(MarkerFactory.getMarker("CRITICAL"), "Hello world : Error")` <p>
 
 - Markers can also be used to add custom labels <p>
 `logger.info(MarkerFactory.getMarker("label1:value1"), "Hello world : labels")` <p>


## Todo
<p> Add support for fluentd port forwarding config, currently hardcoded