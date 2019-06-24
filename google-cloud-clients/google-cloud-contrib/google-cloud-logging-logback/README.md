Logback Appender for Google Cloud Logging
=========================================

Logback appender `com.google.cloud.logging.logback.LoggingAppender` for
[Google Cloud Logging](https://cloud.google.com/logging/).

This library allows you to use [Logback](https://logback.qos.ch/) configuration and the [Slf4j](https://www.slf4j.org/) interface to log via Google Cloud logging.

-  [Homepage](https://googleapis.github.io/google-cloud-java/)
-  [API Documentation](https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/logging/logback/LoggingAppender.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-logging-logback:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-logging-logback</artifactId>
  <version>0.97.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-logging-logback:0.97.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-logging-logback" % "0.97.0-alpha"
```
[//]: # ({x-version-update-end})

Usage 
-----

Add the appender to your [Logback configuration](https://logback.qos.ch/manual/configuration.html) `logback.xml`.
See [Logback filters](https://logback.qos.ch/manual/filters.html#thresholdFilter) for information on filtering log output and
 [encoders](https://logback.qos.ch/manual/encoders.html) for information on formatting.


```xml
<configuration>
  <appender name="CLOUD" class="com.google.cloud.logging.logback.LoggingAppender">
    <!-- Optional : filter logs at or above a level -->
    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
      <level>INFO</level>
    </filter>
    <log>application.log</log> <!-- Optional : default java.log -->
    <!-- Optional : will use the default credentials of the environment if this property is not set -->
    <credentialsFile>/path/to/credentials.json</credentialsFile>
    <enhancer>com.example.enhancers.TestLoggingEnhancer</enhancer> <!-- Optional -->
    <enhancer>com.example.enhancers.AnotherEnhancer</enhancer> <!-- Optional -->
    <flushLevel>WARN</flushLevel> <!-- Optional : default ERROR -->
  </appender>

  <root level="info">
    <appender-ref ref="CLOUD" />
  </root>
</configuration>
```

In your code :

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class TestLogger {
    private final Logger logger = LoggerFactory.getLogger(TestLogger.class);
 
    public void log(String name) {
        logger.info("This is a test");
    }

    public static void main(String[] args) {
        TestLogger testLogger = new TestLogger();
        testLogger.log("test");
    }
}
```


Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication)
section in the base directory's README.

You can also specify custom credentials by setting the optional property credentialsFile in your configuration file.

Limitations
-----------

This library is usable, but not yet complete.
Open issues [here](https://github.com/googleapis/google-cloud-java/issues?q=is%3Aissue+is%3Aopen+label%3A%22logging-logback%22).


Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the
[shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud)
for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct.
By participating in this project you agree to abide by its terms. See
[Code of Conduct][code-of-conduct] for more information.

License
-------
Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-storage
[cloud-platform]: https://cloud.google.com/

[cloud-logging]: https://cloud.google.com/logging/
[cloud-logging-docs]: https://cloud.google.com/logging/docs/overview
