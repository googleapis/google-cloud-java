Google Cloud Java Client for Compute
====================================

Java idiomatic client for [Google Cloud Compute][cloud-compute].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][compute-product-docs]
- [Client Library Documentation][compute-client-lib-docs]

Check https://cloud.google.com/compute/docs/api/libraries for the recommended Java client library to use for
accessing Compute.

Quickstart
----------

[//]: # ({x-version-update-start:google-cloud:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-compute</artifactId>
  <version>0.97.0-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-compute:0.97.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-compute" % "0.97.0-alpha"
```
[//]: # ({x-version-update-end})

Example Application
-------------------

[`ComputeExample`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/compute/ComputeExample.java)
is a simple command line interface that provides some of Google Cloud Compute Engine's
functionality. Read more about using the application on the
[`ComputeExample` docs page](https://googleapis.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/compute/ComputeExample.html).

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Compute
--------------------------

[Google Cloud Compute][cloud-compute] delivers virtual machines running in Google's innovative data
centers and worldwide fiber network. Compute Engine's tooling and workflow support enable scaling
from single instances to global, load-balanced cloud computing. Compute Engine's VMs boot quickly,
come with persistent disk storage, deliver consistent performance and are available in many
configurations.

Be sure to activate the Google Cloud Compute API on the Developer's Console to use Compute from
your project.

See the [Compute client library docs][compute-client-lib-docs] to learn how to interact
with Google Cloud Compute using this Client Library.

Getting Started
---------------

#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/)
project with the Compute Engine API enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en)
to use Google Cloud DNS. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects)
to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands
in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-compute` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-compute` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Compute Engine, you must create a service object with
credentials. You can then make API calls by calling methods on the Compute service object. The
simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.AddressClient;
import com.google.cloud.compute.v1.AddressSettings;

Credentials myCredentials = GoogleCredentials.getApplicationDefault();
    String myEndpoint = AddressSettings.getDefaultEndpoint();

    AddressSettings addressSettings =
        AddressSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .setTransportChannelProvider(
                AddressSettings.defaultHttpJsonTransportProviderBuilder()
                    .setEndpoint(myEndpoint)
                    .build())
            .build();
    return AddressClient.create(addressSettings);
```

For other authentication options, see the [Authentication](https://github.com/googleapis/google-cloud-java#authentication)
page.

#### Creating a region IP address
An external region IP address can be associated to a Google Compute Engine instance to communicate
with instances in different regions or to communicate with the instance from ouside of Compute
Engine. In this code snippet, we will create a new external region address.

Add the following imports at the top of your file:

```java
import com.google.cloud.compute.v1.InsertAddressHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionAddressName;
```

Then add the following code to create an address. Most Compute Engine calls return an `Operation`
object that can be used to wait for operation completion and to check whether operation failed or
succeeded:

```java
ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
Address address = Address.newBuilder().build();
InsertAddressHttpRequest request =
    InsertAddressHttpRequest.newBuilder()
        .setRegion(region.toString())
        .setAddressResource(address)
        .build();

Operation response = client.insertAddress(request);
if (operation.getError() == null) {
  System.out.println("Address " + addressId + " was successfully created");
} else {
  // inspect operation.getError()
  throw new RuntimeException("Address creation failed");
}
```

#### Creating a persistent disk
A persistent disk can be used as primary storage for your virtual machine instances. Persistent
disks can be created empty, from a disk image or from a disk snapshot. Compute Engine offers
[publicly-available images](https://cloud.google.com/compute/docs/operating-systems/) of certain
operating systems that you can use. In this code snippet, we will create a new persistent disk from
a publicly-available image.

Add the following imports at the top of your file:

```java
import com.google.api.core.ApiFuture;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskClient;
import com.google.cloud.compute.v1.InsertDiskHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectZoneName;
```

Then add the following code to create a disk and wait for disk creation to terminate.

```java
ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
Disk diskResource = Disk.newBuilder().build();
InsertDiskHttpRequest request = InsertDiskHttpRequest.newBuilder()
   .setZone(zone.toString())
       .setDiskResource(diskResource)
       .build();
ApiFuture<Operation> future = client.insertDiskCallable().futureCall(request);
Operation response;
try {
  response = future.get();
} catch (InterruptedException | ExecutionException e) {
  // inspect operation.getError()
  throw new RuntimeException("Disk creation failed");
}
```

#### Complete source code

In
[ComputeExample.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/compute/v1/ComputeExample.java)
we put together all the code shown above into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Compute uses HTTP for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud Compute.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

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


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-compute
[cloud-platform]: https://cloud.google.com/

[cloud-compute]: https://cloud.google.com/compute/
[compute-product-docs]: https://cloud.google.com/compute/docs/
[compute-client-lib-docs]: https://googleapis.github.io/google-cloud-java/google-cloud-clients/apidocs/index.html?com/google/cloud/compute/v1/package-summary.html
