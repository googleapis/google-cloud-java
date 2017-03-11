Use Google Cloud Java Client with GoogleAppEngine
=================================================

Quickstart
----------
This file provides extra instructions to setup Google Cloud Java client with GoogleAppEngine.
See [Quickstart](./README.md#quickstart) for Google Cloud Java common instructions.
See [Quickstart](https://cloud.google.com/appengine/docs/standard/java/quickstart) for extra GAE instructions.

If you are using Maven, add this to your pom.xml file
```xml
<dependency>
    <groupId>com.google.appengine</groupId>
    <artifactId>appengine-api-1.0-sdk</artifactId>
    <version>1.9.50</version>
</dependency>
```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.appengine:appengine-api-1.0-sdk:1.9.50'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.appengine" % "appengine-api-1.0-sdk" % "1.9.50"
```

To test with local dev server, run
```
mvn appengine:devserver
```