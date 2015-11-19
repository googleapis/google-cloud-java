Google Cloud Java Client for Datastore
======================================

Java idiomatic client for [Google Cloud Datastore] (https://cloud.google.com/datastore/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-datastore.svg)]( https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-datastore.svg)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/datastore/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-datastore</artifactId>
  <version>0.0.12</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.gcloud:gcloud-java-datastore:jar:0.0.12'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.gcloud" % "gcloud-java-datastore" % "0.0.12"
```

Example Application
--------------------
[`DatastoreExample`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/DatastoreExample.java) is a simple command line interface for the Cloud Datastore.  Read more about using the application on the [`gcloud-java-examples` docs page](http://googlecloudplatform.github.io/gcloud-java/apidocs/?com/google/gcloud/examples/DatastoreExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section in the base directory's README.

About Google Cloud Datastore
----------------------------

Google [Cloud Datastore][cloud-datastore] is a fully managed, schemaless database for
storing non-relational data. Cloud Datastore automatically scales with
your users and supports ACID transactions, high availability of reads and
writes, strong consistency for reads and ancestor queries, and eventual
consistency for all other queries.

See the [Google Cloud Datastore docs][cloud-datastore-activation] for more details on how to activate
Cloud Datastore for your project.

See the ``gcloud-java`` API [datastore documentation][datastore-api] to learn how to interact
with the Cloud Datastore using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/) project with the Datastore API enabled. [Follow these instructions](https://cloud.google.com/docs/authentication#preparation) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `gcloud-java-datastore` library.  See the [Quickstart](#quickstart) section to add `gcloud-java-datastore` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Datastore, you must create a service object with credentials. You can then make API calls by calling methods on the Datastore service object. The simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials). These credentials are automatically inferred from your environment, so you only need the following code to create your service object:

```java
import com.google.gcloud.datastore.Datastore;
import com.google.gcloud.datastore.DatastoreOptions;

Datastore datastore = DatastoreOptions.defaultInstance().service();
```

For other authentication options, see the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) page.

#### Storing data
Objects in Datastore are known as entities. Entities are grouped by "kind" and have keys for easy access. In this code snippet, we will create a new entity representing a person and store that data by the person's name.  First, add the following imports at the top of your file:

```java
import com.google.gcloud.datastore.Entity;
import com.google.gcloud.datastore.Key;
import com.google.gcloud.datastore.KeyFactory;
```

Then add the following code to put an entity in Datastore.

```java
KeyFactory keyFactory = datastore.newKeyFactory().kind("Person");
Key key = keyFactory.newKey("John Doe");
Entity entity = Entity.builder(key)
    .set("age", 30)
    .set("favorite_food", "pizza")
    .build();
datastore.put(entity);
```

Later, if you want to get this entity back, add the following to your code:

```java
Entity johnEntity = datastore.get("John Doe");
```

#### Running a query
In addition to retrieving entities by their keys, you can perform queries to retrieve entities by the values of their properties. A typical query includes an entity kind, filters to select entities with matching values, and sort orders to sequence the results. `gcloud-java-datastore` supports two types of queries: `StructuredQuery` (that allows you to construct query elements) and `GqlQuery` (which operates using [GQL syntax](https://cloud.google.com/datastore/docs/apis/gql/gql_reference)) in string format. In this tutorial, we will use a simple `StructuredQuery`.

Suppose that you've added more people to Datastore, and now you want to find all people whose favorite food is pizza. Import the following:

```java
import com.google.gcloud.datastore.Query;
import com.google.gcloud.datastore.QueryResults;
import com.google.gcloud.datastore.StructuredQuery;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;
```

Then add the following code to your program:

```java
Query<Entity> query = Query.entityQueryBuilder()
    .kind("Person")
    .filter(PropertyFilter.eq("favorite_food", "pizza"))
    .build();
QueryResults<Entity> results = datastore.run(query);
while (results.hasNext()) {
  Entity currentEntity = results.next();
}
```

#### Complete source code

Here we put together all the code shown above into one program.  This program assumes that you are running on Compute Engine or from your own desktop. To run this example on App Engine, simply move the code from the main method to your application's servlet class.

```java
import com.google.gcloud.datastore.Datastore;
import com.google.gcloud.datastore.DatastoreOptions;
import com.google.gcloud.datastore.Entity;
import com.google.gcloud.datastore.Key;
import com.google.gcloud.datastore.KeyFactory;
import com.google.gcloud.datastore.Query;
import com.google.gcloud.datastore.QueryResults;
import com.google.gcloud.datastore.StructuredQuery;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;

public class GcloudJavaDatastoreExample {

  public static void main(String[] args) {
    // Create datastore service object.
    // By default, credentials are inferred from the runtime environment.
    Datastore datastore = DatastoreOptions.defaultInstance().service();

    // Add an entity to Datastore
    KeyFactory keyFactory = datastore.newKeyFactory().kind("Person");
    Key key = keyFactory.newKey("John Doe");
    Entity entity = Entity.builder(key)
        .set("age", 51)
        .set("favorite_food", "pizza")
        .build();
    datastore.put(entity);

    // Get an entity from Datastore
    Entity johnEntity = datastore.get(key);

    // Add a couple more entities to make the query results more interesting
    Key janeKey = keyFactory.newKey("Jane Doe");
    Entity janeEntity = Entity.builder(janeKey)
        .set("age", 44)
        .set("favorite_food", "pizza")
        .build();
    Key joeKey = keyFactory.newKey("Joe Shmoe");
    Entity joeEntity = Entity.builder(joeKey)
        .set("age", 27)
        .set("favorite_food", "sushi")
        .build();
    datastore.put(janeEntity, joeEntity);

    // Run a query
    Query<Entity> query = Query.entityQueryBuilder()
        .kind("Person")
        .filter(PropertyFilter.eq("favorite_food", "pizza"))
        .build();
    QueryResults<Entity> results = datastore.run(query);
    while (results.hasNext()) {
      Entity currentEntity = results.next();
      // Do something using the entity.  (e.g. send an invite a pizza party)
    }
  }
}
```

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help write tests for code that uses the Datastore.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-datastore
[cloud-platform]: https://cloud.google.com/
[cloud-datastore]: https://cloud.google.com/datastore/docs
[cloud-datastore-docs]: https://cloud.google.com/datastore/docs
[cloud-datastore-activation]: https://cloud.google.com/datastore/docs/activate
[datastore-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/datastore/package-summary.html

