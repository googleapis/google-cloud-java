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
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-datastore</artifactId>
  <version>0.0.9</version>
</dependency>
```

Example Application
--------------------
[`DatastoreExample`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/DatastoreExample.java) is a simple command line interface for the Cloud Datastore.  Read more about using the application on the [`gcloud-java-examples` docs page](http://googlecloudplatform.github.io/gcloud-java/apidocs/?com/google/gcloud/examples/DatastoreExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section in the main repository's README.

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

Here is a code snippet showing a simple usage example from within Compute/App Engine.  Note that you must [supply credentials](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) if running this snippet elsewhere.

```java
import com.google.gcloud.datastore.Datastore;
import com.google.gcloud.datastore.DatastoreFactory;
import com.google.gcloud.datastore.DatastoreOptions;
import com.google.gcloud.datastore.DateTime;
import com.google.gcloud.datastore.Entity;
import com.google.gcloud.datastore.Key;
import com.google.gcloud.datastore.KeyFactory;

DatastoreOptions options = DatastoreOptions.builder().projectId(PROJECT_ID).build();
Datastore datastore = DatastoreFactory.instance().get(options);
KeyFactory keyFactory = datastore.newKeyFactory().kind(KIND);
Key key = keyFactory.newKey(keyName);
Entity entity = datastore.get(key);
if (entity == null) {
  entity = Entity.builder(key)
      .set("name", "John Do")
      .set("age", 30)
      .set("access_time", DateTime.now())
      .build();
  datastore.put(entity);
} else {
  System.out.println("Updating access_time for " + entity.getString("name"));
  entity = Entity.builder(entity)
      .set("access_time", DateTime.now())
      .build();
  datastore.update(entity);
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

