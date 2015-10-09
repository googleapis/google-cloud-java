Google Cloud Java Client for Storage
====================================

Java idiomatic client for [Google Cloud Storage] (https://cloud.google.com/storage/). 

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/storage/package-summary.html)
-  [Examples] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/examples/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
Add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-storage</artifactId>
  <version>0.0.9</version>
</dependency>
```

Google Cloud Storage
----------------------

[Google Cloud Storage][cloud-storage] is a durable and highly available
object storage service. Google Cloud Storage is almost infinitely scalable
and guarantees consistency: when a write succeeds, the latest copy of the
object will be returned to any GET, globally.

See the [Google Cloud Storage docs][cloud-storage-activation] for more details on how to activate
Cloud Storage for your project.

See the ``gcloud-java`` API [storage documentation][storage-api] to learn how to interact
with the Cloud Storage using this Client Library.

```java
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.gcloud.storage.Blob;
import com.google.gcloud.storage.Storage;
import com.google.gcloud.storage.StorageFactory;
import com.google.gcloud.storage.StorageOptions;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

StorageOptions options = StorageOptions.builder().projectId(PROJECT_ID).build();
Storage storage = StorageFactory.instance().get(options);
Blob blob = new Blob(storage, "bucket", "blob_name");
if (!blob.exists()) {
  storage2.create(blob.info(), "Hello, Cloud Storage!".getBytes(UTF_8));
} else {
  System.out.println("Updating content for " + blob.info().name());
  byte[] prevContent = blob.content();
  System.out.println(new String(prevContent, UTF_8));
  WritableByteChannel channel = blob.writer();
  channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
  channel.close();
}
```

Testing
-------

This library has tools to help make tests for code using Cloud Storage.

See [TESTING] to read more about testing.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started.

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning] (http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything
may change at any time and the public API should not be considered
stable.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-storage
[cloud-platform]: https://cloud.google.com/

[cloud-storage]: https://cloud.google.com/storage/
[cloud-storage-docs]: https://cloud.google.com/storage/docs/overview
[cloud-storage-create-bucket]: https://cloud.google.com/storage/docs/cloud-console#_creatingbuckets
[storage-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/storage/package-summary.html
