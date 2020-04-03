# Google Compute Engine Client for Java

Java idiomatic client for [Compute Engine][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>4.3.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-compute</artifactId>
  </dependency>
</dependencies>
```

[//]: # ({x-version-update-start:google-cloud-compute:released})

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-compute</artifactId>
  <version>0.117.0-alpha</version>
</dependency>
```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-compute:0.117.0-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-compute" % "0.117.0-alpha"
```
[//]: # ({x-version-update-end})

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Compute Engine [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Compute Engine.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-compute` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-compute` as a dependency in your code.

## About Compute Engine


[Compute Engine][product-docs] delivers virtual machines running in Google's innovative data centers and worldwide fiber network. Compute Engine's tooling and workflow support enable scaling from single instances to global, load-balanced cloud computing. Compute Engine's VMs boot quickly, come with persistent disk storage, deliver consistent performance and are available in many configurations.

See the [Compute Engine client library docs][javadocs] to learn how to
use this Compute Engine Client Library.


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
[ComputeExample.java](https://github.com/googleapis/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/compute/v1/ComputeExample.java)
we put together all the code shown above into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.




## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Compute Engine uses HTTP/JSON for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).


It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.


## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[product-docs]: https://cloud.google.com/compute
[javadocs]: https://googleapis.dev/java/google-cloud-compute/latest/index.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-compute/java11.html
[stability-image]: https://img.shields.io/badge/stability-alpha-orange
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-compute&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-compute/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-compute/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-compute/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=compute.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
