Google Cloud Java Client for DNS
================================

Java idiomatic client for [Google Cloud DNS] (https://cloud.google.com/dns/).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/gcloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/gcloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/gcloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/gcloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-dns.svg)]( https://img.shields.io/maven-central/v/com.google.gcloud/gcloud-java-dns.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/gcloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage] (https://googlecloudplatform.github.io/gcloud-java/)
-  [API Documentation] (http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/dns/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.gcloud</groupId>
  <artifactId>gcloud-java-dns</artifactId>
  <version>0.1.7</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.gcloud:gcloud-java-dns:0.1.7'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.gcloud" % "gcloud-java-dns" % "0.1.7"
```

Example Application
-------------------

[`DnsExample`](../gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/DnsExample.java)
is a simple command line interface that provides some of Google Cloud DNS's functionality.  Read
more about using the application on the
[`DnsExample` docs page](http://googlecloudplatform.github.io/gcloud-java/apidocs/?com/google/gcloud/examples/dns/DnsExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) section
in the base directory's README.

About Google Cloud DNS
--------------------------

[Google Cloud DNS][cloud-dns] is a scalable, reliable and managed authoritative Domain Name System
(DNS) service running on the same infrastructure as Google. It has low latency, high availability
and is a cost-effective way to make your applications and services available to your users.

See the [Google Cloud DNS docs][dns-activate] for more details on how to activate
Cloud DNS for your project.

See the [``gcloud-java-dns`` API documentation][dns-api] to learn how to interact
with the Cloud DNS using this client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/)
project with the DNS API enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en)
to use Google Cloud DNS. [Follow these instructions](https://cloud.google.com/docs/authentication#preparation)
to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands
in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `gcloud-java-dns` library.  See the [Quickstart](#quickstart) section to
add `gcloud-java-dns` as a dependency in your code.

#### Creating an authorized service object
To make authenticated requests to Google Cloud DNS, you must create a service object with
credentials. You can then make API calls by calling methods on the DNS service object. The simplest
way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials).
These credentials are automatically inferred from your environment, so you only need the following
code to create your service object:

```java
import com.google.gcloud.dns.Dns;
import com.google.gcloud.dns.DnsOptions;

Dns dns = DnsOptions.defaultInstance().service();
```

For other authentication options, see the [Authentication](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) page.

#### Managing Zones
Record sets in `gcloud-java-dns` are managed inside containers called "zones". `ZoneInfo` is a class
which encapsulates metadata that describe a zone in Google Cloud DNS. `Zone`, a subclass of `ZoneInfo`, adds service-related
functionality over `ZoneInfo`.

*Important: Zone names must be unique to the project. If you choose a zone name that already
exists within your project, you'll get a helpful error message telling you to choose another name. In the code below,
replace "my-unique-zone" with a unique zone name. See more about naming rules [here](https://cloud.google.com/dns/api/v1/managedZones#name).*

In this code snippet, we create a new zone to manage record sets for domain `someexampledomain.com.`

*Important: The service may require that you verify ownership of the domain for which you are creating a zone.
Hence, we recommend that you do so beforehand. You can verify ownership of
a domain name [here](https://www.google.com/webmasters/verification/home). Note that Cloud DNS
requires fully qualified domain names which must end with a period.*

Add the following imports at the top of your file:

```java
import com.google.gcloud.dns.Zone;
import com.google.gcloud.dns.ZoneInfo;
```

Then add the following code to create a zone.

```java
// Create a zone metadata object
String zoneName = "my-unique-zone"; // Change this zone name which is unique within your project
String domainName = "someexampledomain.com."; // Change this to a domain which you own
String description = "This is a gcloud-java-dns sample zone.";
ZoneInfo zoneInfo = ZoneInfo.of(zoneName, domainName, description);

// Create zone in Google Cloud DNS
Zone zone = dns.create(zoneInfo);
System.out.printf("Zone was created and assigned ID %s.%n", zone.generatedId());
```

You now have an empty zone hosted in Google Cloud DNS which is ready to be populated with
record sets for domain name `someexampledomain.com.` Upon creating the zone, the cloud service
assigned a set of DNS servers to host records for this zone and
created the required SOA and NS records for the domain. The following snippet prints the list of servers
assigned to the zone created above. First, import

```java
import java.util.List;
```

and then add

```java
// Print assigned name servers
List<String> nameServers = zone.nameServers();
for(String nameServer : nameServers) {
  System.out.println(nameServer);
}
```

You can now instruct your domain registrar to [update your domain name servers] (https://cloud.google.com/dns/update-name-servers).
As soon as this happens and the change propagates through cached values in DNS resolvers,
all the DNS queries will be directed to and answered by the Google Cloud DNS service.

#### Creating Record Sets
Now that we have a zone, we can add some record sets. The record sets held within zones are
modified by "change requests". In this example, we create and apply a change request to
our zone that creates a record set of type A and points URL www.someexampledomain.com to
IP address 12.13.14.15. Start by adding

```java
import com.google.gcloud.dns.ChangeRequestInfo;
import com.google.gcloud.dns.RecordSet;

import java.util.concurrent.TimeUnit;
```

and proceed with:

```java
// Prepare a www.someexampledomain.com. type A record set with ttl of 24 hours
String ip = "12.13.14.15";
RecordSet toCreate = RecordSet.builder("www." + zone.dnsName(), RecordSet.Type.A)
    .ttl(24, TimeUnit.HOURS)
    .addRecord(ip)
    .build();

// Make a change
ChangeRequestInfo changeRequest = ChangeRequestInfo.builder().add(toCreate).build();

// Build and apply the change request to our zone
changeRequest = zone.applyChangeRequest(changeRequest);
```

The `addRecord` method of `RecordSet.Builder` accepts records in the form of
strings. The format of the strings depends on the type of the record sets to be added.
More information on the supported record set types and record formats can be found [here](https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types).

If you already have a record set, Cloud DNS will return an error upon an attempt to create a duplicate of it.
You can modify the code above to create a record set or update it if it already exists by making the
following adjustment in your imports

```java
import java.util.Iterator;
```

and in the code

```java
// Make a change
ChangeRequestInfo.Builder changeBuilder = ChangeRequestInfo.builder().add(toCreate);

// Verify the type A record does not exist yet.
// If it does exist, we will overwrite it with our prepared record.
Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
while (recordSetIterator.hasNext()) {
  RecordSet current = recordSetIterator.next();
  if (toCreate.name().equals(current.name()) && toCreate.type().equals(current.type())) {
    changeBuilder.delete(current);
  }
}

// Build and apply the change request to our zone
ChangeRequestInfo changeRequest = changeBuilder.build();
ChangeRequest pendingRequest = zone.applyChangeRequest(changeRequest);
```
You can find more information about changes in the [Cloud DNS documentation] (https://cloud.google.com/dns/what-is-cloud-dns#cloud_dns_api_concepts).

When the change request is applied, it is registered with the Cloud DNS service for processing. We
can wait for its completion as follows:

```java
while (!pendingRequest.isDone()) {
  try {
    Thread.sleep(500L);
  } catch (InterruptedException e) {
    System.err.println("The thread was interrupted while waiting...");
  }
}
System.out.println("The change request has been applied.");
```

Change requests are applied atomically to all the assigned DNS servers at once. Note that when this
happens, it may still take a while for the change to be registered by the DNS cache resolvers.
See more on this topic [here](https://cloud.google.com/dns/monitoring).

#### Listing Zones and Record Sets
Suppose that you have added more zones and record sets, and now you want to list them.
First, import the following (unless you have done so in the previous section):

```java
import java.util.Iterator;
```

Then add the following code to list all your zones and record sets.

```java
// List all your zones
Iterator<Zone> zoneIterator = dns.listZones().iterateAll();
int counter = 1;
while (zoneIterator.hasNext()) {
  System.out.printf("#%d.: %s%n%n", counter, zoneIterator.next());
  counter++;
}

// List the record sets in a particular zone
recordSetIterator = zone.listRecordSets().iterateAll();
System.out.println(String.format("Record sets inside %s:", zone.name()));
while (recordSetIterator.hasNext()) {
  System.out.println(recordSetIterator.next());
}
```

You can also list the history of change requests that were applied to a zone.
First add:

```java
import java.util.ChangeRequest;
```

and then:

```java

// List the change requests applied to a particular zone
Iterator<ChangeRequest> changeIterator = zone.listChangeRequests().iterateAll();
System.out.println(String.format("The history of changes in %s:", zone.name()));
while (changeIterator.hasNext()) {
  System.out.println(changeIterator.next());
}
```

#### Deleting Zones

If you no longer want to host a zone in Cloud DNS, you can delete it.
First, you need to empty the zone by deleting all its records except for the default SOA and NS record sets.

```java
// Make a change for deleting the record sets
changeBuilder = ChangeRequestInfo.builder();
while (recordIterator.hasNext()) {
  RecordSet current = recordIterator.next();
  // SOA and NS records cannot be deleted
  if (!RecordSet.Type.SOA.equals(current.type()) && !RecordSet.Type.NS.equals(current.type())) {
    changeBuilder.delete(current);
  }
}

// Build and apply the change request to our zone if it contains records to delete
ChangeRequestInfo changeRequest = changeBuilder.build();
if (!changeRequest.deletions().isEmpty()) {
  ChangeRequest pendingRequest = dns.applyChangeRequest(zoneName, changeRequest);

  // Wait for the change request to complete
  while (!pendingRequest.isDone()) {
    System.out.println("Waiting for change to complete. Going to sleep for 500ms...");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      System.err.println("The thread was interrupted while waiting for change request to be "
          + "processed.");
    }
  }
}

// Delete the zone
boolean result = dns.delete(zoneName);
if (result) {
  System.out.println("Zone was deleted.");
} else {
  System.out.println("Zone was not deleted because it does not exist.");
}
```

#### Complete Source Code

We composed some of the aforementioned snippets into complete executable code samples. In
[CreateZones.java](../gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/CreateZone.java)
we create a zone. In [CreateOrUpdateRecordSets.java](../gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/CreateOrUpdateRecordSets.java)
we create a type A record set for a zone, or update an existing type A record set to a new IP address. We
demonstrate how to delete a zone in [DeleteZone.java](../gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/DeleteZone.java).
Finally, in [ManipulateZonesAndRecordSets.java](../gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/ManipulateZonesAndRecordSets.java)
we assemble all the code snippets together and create zone, create or update a record set, list zones, list record sets, list changes, and
delete a zone. The applications assume that they are running on Compute Engine or from your own desktop. To run any of these examples on App
Engine, simply move the code from the main method to your application's servlet class and change the
print statements to display on your webpage.

Troubleshooting
---------------

To get help, follow the `gcloud-java` links in the `gcloud-*` [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help make tests for code using Cloud DNS.

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

See `gcloud-java`'s [CONTRIBUTING] documentation and the `gcloud-*` [shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/TESTING.md#testing-code-that-uses-storage
[cloud-platform]: https://cloud.google.com/

[cloud-dns]: https://cloud.google.com/dns/
[dns-api]: http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/dns/package-summary.html
[dns-activate]:https://cloud.google.com/dns/getting-started#prerequisites
