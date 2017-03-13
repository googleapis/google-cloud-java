Use Google Cloud Java Client with Google App Engine
=================================================

Quickstart
----------
This file provides extra instructions to set up Google Cloud Java Client with Google App Engine.
See [Quickstart](./README.md#quickstart) for general instructions on using Google Cloud Java.
See [Instructions](https://cloud.google.com/appengine/docs/standard/java/quickstart) for extra Google App Engine instructions.

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