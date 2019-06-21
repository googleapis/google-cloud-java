Google Cloud Java Client for Storage
====================================

Java idiomatic client for [Google Cloud Storage][cloud-storage].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-storage.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-storage.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][storage-product-docs]
- [Client Library Documentation][storage-client-lib-docs]

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud-storage:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-storage</artifactId>
  <version>1.79.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-storage:1.79.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-storage" % "1.79.0"
```
[//]: # ({x-version-update-end})

Example Applications
-------------------

- [`StorageExample`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/storage/StorageExample.java) is a simple command line interface that provides some of Cloud Storage's functionality.  Read more about using the application on the [`StorageExample` docs page](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md).
- [`Bookshelf`](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/bookshelf) - An App Engine application that manages a virtual bookshelf.
  - This app uses `google-cloud` to interface with Cloud Datastore and Cloud Storage. It also uses Cloud SQL, another Google Cloud Platform service.
- [`Flexible Environment/Storage example`](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/flexible/cloudstorage) - An app that uploads files to a public Cloud Storage bucket on the App Engine Flexible Environment runtime.

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Storage
--------------------------

[Google Cloud Storage][cloud-storage] is a durable and highly available
object storage service. Google Cloud Storage is almost infinitely scalable
and guarantees consistency: when a write succeeds, the latest copy of the
object will be returned to any GET, globally.

See the [Google Cloud Storage docs][cloud-storage-activation] for more details on how to activate
Cloud Storage for your project.

See the [Storage client library docs][storage-client-lib-docs] to learn how to interact
with the Cloud Storage using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/) project with "Google Cloud Storage" and "Google Cloud Storage JSON API" enabled via the console's API Manager. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en) to use Google Cloud Storage. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-storage` library.  See the [Quickstart](#quickstart) section to add `google-cloud-storage` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Storage, you must create a service object with credentials. You can then make API calls by calling methods on the Storage service object. The simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials). These credentials are automatically inferred from your environment, so you only need the following code to create your service object:

```java
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

Storage storage = StorageOptions.getDefaultInstance().getService();
```

For other authentication options, see the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) page.

#### Storing data
Stored objects are called "blobs" in `google-cloud` and are organized into containers called "buckets".  `Blob`, a subclass of `BlobInfo`, adds a layer of service-related functionality over `BlobInfo`.  Similarly, `Bucket` adds a layer of service-related functionality over `BucketInfo`.  In this code snippet, we will create a new bucket and upload a blob to that bucket.

Add the following imports at the top of your file:

```java
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
```

Then add the following code to create a bucket and upload a simple blob.

*Important: Bucket names have to be globally unique (among all users of Cloud Storage). If you choose a bucket name that already exists, you'll get a helpful error message telling you to choose another name. In the code below, replace "my_unique_bucket" with a unique bucket name. See more about naming rules [here](https://cloud.google.com/storage/docs/bucket-naming?hl=en#requirements).*

```java
// Create a bucket
String bucketName = "my_unique_bucket"; // Change this to something unique
Bucket bucket = storage.create(BucketInfo.of(bucketName));

// Upload a blob to the newly created bucket
BlobId blobId = BlobId.of(bucketName, "my_blob_name");
BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
Blob blob = storage.create(blobInfo, "a simple blob".getBytes(UTF_8));
```

A complete example for creating a blob can be found at
[CreateBlob.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/storage/snippets/CreateBlob.java).

At this point, you will be able to see your newly created bucket and blob on the Google Developers Console.

#### Retrieving data
Now that we have content uploaded to the server, we can see how to read data from the server.  Add the following line to your program to get back the blob we uploaded.

```java
BlobId blobId = BlobId.of(bucketName, "my_blob_name");
byte[] content = storage.readAllBytes(blobId);
String contentString = new String(content, UTF_8);
```

A complete example for accessing blobs can be found at
[CreateBlob.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/storage/snippets/CreateBlob.java).

#### Updating data
Another thing we may want to do is update a blob. The following snippet shows how to update a Storage blob if it exists. 

``` java
BlobId blobId = BlobId.of(bucketName, "my_blob_name");
Blob blob = storage.get(blobId);
if (blob != null) {
  byte[] prevContent = blob.getContent();
  System.out.println(new String(prevContent, UTF_8));
  WritableByteChannel channel = blob.writer();
  channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
  channel.close();
}
```

The complete source code can be found at
[UpdateBlob.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/storage/snippets/UpdateBlob.java).

#### Listing buckets and contents of buckets
Suppose that you've added more buckets and blobs, and now you want to see the names of your buckets and the contents of each one. Add the following code to list all your buckets and all the blobs inside each bucket.

```java
// List all your buckets
System.out.println("My buckets:");
for (Bucket bucket : storage.list().iterateAll()) {
  System.out.println(bucket);
  
  // List all blobs in the bucket
  System.out.println("Blobs in the bucket:");
  for (Blob blob : bucket.list().iterateAll()) {
    System.out.println(blob);
  }
}
```

#### Complete source code

In
[CreateAndListBucketsAndBlobs.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/storage/snippets/CreateAndListBucketsAndBlobs.java)
we put together examples creating and listing buckets and blobs into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Storage uses HTTP for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Storage.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version one (``1.y.z``), which means that the public API should be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-storage
[cloud-platform]: https://cloud.google.com/

[cloud-storage]: https://cloud.google.com/storage/
[cloud-storage-create-bucket]: https://cloud.google.com/storage/docs/cloud-console#_creatingbuckets
[cloud-storage-activation]:https://cloud.google.com/storage/docs/signup?hl=en
[storage-product-docs]: https://cloud.google.com/storage/docs/
[storage-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/storage/package-summary.html
