# Google Compute Engine Client for Java

Java idiomatic client for [Compute Engine][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart


If you are using Maven, add this to your pom.xml file:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-compute</artifactId>
  <version>1.12.1</version>
</dependency>

```

If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-compute:1.12.1'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-compute" % "1.12.1"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Compute Engine APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Compute Engine API calls.

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


### Compute alpha to beta migration

Java compute library is GA from version 1.7.0 and backwards incompatible with 0.x.x. Also it is incompatible with 1.5.x-alpha and prior in a following way: 
- Everything except polling methods which used to return `Operation` now returns `OperationFuture`. 
- Library automatically polls Operation status.
- `Operation op = client.myMethod(args)` should be replaced with `OperationFuture<Operation, Operation> opFuture = client.myMethodAsync(args);` 
- Polling is now done automatically, manual polling is no longer required. Calling `opFuture.get()` will wait for automatic polling to complete. It will return the result of the long running operation once the operation is completed on the server side or throw an exception if an error occurs during polling. 
- To check for intermediate status on the future use either `opFuture.peekMetadata()` (non-blocking) or `opFuture.getMetadata()` (blocking) 
- If you wish to stop automatic polling call `opFuture.cancel()` - it will cancel the future on the client side but it will not affect the execution of the operation on the server side in any way (server will keep working on the operation). 
- The calls still may be done without relying on automatic polling and/or OperationFuture. To do so, use `client.myMethodCallable(MyMethodRequest).call()` semantics instead. Note this semantics does not have flattened method declarations and the request message must be instantiated explicitly by the users code.

### Example
The following example creates a GCE address, then lists all the available addresses in the region and in the whole project and eventually deletes the newly created address.

```java
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressesClient;
import com.google.cloud.compute.v1.AddressesScopedList;
import com.google.cloud.compute.v1.Operation;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.Map;

public class ComputeExample {

  public static void main(String[] args) throws IOException, InterruptedException {
    final String project = "PROJECT_NAME";
    final String region = "REGION";
    final String address = "test-address-21";

    AddressesClient addressesClient = AddressesClient.create();

    // AddressClient#insert()
    System.out.println("\n===============\nAddressClient#insert()\n===============");
    OperationFuture<Operation,Operation> insertResponse =
        addressesClient.insertAsync(project, region, Address.newBuilder().setName(address).build());
    Operation insertResponseOperation = insertResponse.get();
    System.out.println(JsonFormat.printer().print(insertResponse) + "\n");

    // AddressClient#list()
    System.out.println("\n===============\nAddressClient#list()\n===============");
    for (Address addr : addressesClient.list(project, region).iterateAll()) {
      System.out.println(JsonFormat.printer().print(addr));
    }

    // AddressClient#aggregatedList()
    System.out.println("\n===============\nAddressClient#aggregatedList()\n===============");
    for (Map.Entry<String, AddressesScopedList> addr :
        addressesClient.aggregatedList(project).iterateAll()) {
      System.out.println("KEY: " + addr.getKey());
      System.out.println(JsonFormat.printer().print(addr.getValue()));
    }

    // AddressClient#delete()
    System.out.println("\n===============\nAddressClient#delete()\n===============");
    OperationFuture<Operation,Operation> deleteResponse = addressesClient.deleteAsync(project, region, address);
    Operation deleteResponseOperation = deleteResponse.get();
    System.out.println(JsonFormat.printer().print(deleteResponse) + "\n");
  }
}

```





## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Compute Engine uses HTTP/JSON for the transport layer.

## Supported Java Versions

Java 8 or above is required for using this client.

Google's Java client libraries,
[Google Cloud Client Libraries][cloudlibs]
and
[Google Cloud API Libraries][apilibs],
follow the
[Oracle Java SE support roadmap][oracle]
(see the Oracle Java SE Product Releases section).

### For new development

In general, new feature development occurs with support for the lowest Java
LTS version covered by  Oracle's Premier Support (which typically lasts 5 years
from initial General Availability). If the minimum required JVM for a given
library is changed, it is accompanied by a [semver][semver] major release.

Java 11 and (in September 2021) Java 17 are the best choices for new
development.

### Keeping production systems current

Google tests its client libraries with all current LTS versions covered by
Oracle's Extended Support (which typically lasts 8 years from initial
General Availability).

#### Legacy support

Google's client libraries support legacy versions of Java runtimes with long
term stable libraries that don't receive feature updates on a best efforts basis
as it may not be possible to backport all patches.

Google provides updates on a best efforts basis to apps that continue to use
Java 7, though apps might need to upgrade to current versions of the library
that supports their JVM.

#### Where to find specific information

The latest versions and the supported Java versions are identified on
the individual GitHub repository `github.com/GoogleAPIs/java-SERVICENAME`
and on [google-cloud-java][g-c-j].

## Versioning


This library follows [Semantic Versioning](http://semver.org/).



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
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/compute/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-compute/latest/history
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
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-compute&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-compute/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-compute/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-compute/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=compute.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
