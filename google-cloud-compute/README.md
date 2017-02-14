Google Cloud Java Client for Compute
====================================

Java idiomatic client for [Google Cloud Compute](https://cloud.google.com/compute).

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-compute.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56bd8ee72a29ed002d2b0969)

-  [Homepage](https://googlecloudplatform.github.io/google-cloud-java/)
-  [API Documentation](https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/compute/package-summary.html)

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-compute</artifactId>
  <version>0.9.2-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-compute:0.9.2-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-compute" % "0.9.2-alpha"
```

Example Application
-------------------

[`ComputeExample`](../google-cloud-examples/src/main/java/com/google/cloud/examples/compute/ComputeExample.java)
is a simple command line interface that provides some of Google Cloud Compute Engine's
functionality. Read more about using the application on the
[`ComputeExample` docs page](https://googlecloudplatform.github.io/google-cloud-java/apidocs/?com/google/cloud/examples/compute/ComputeExample.html).

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Compute
--------------------------

[Google Cloud Compute][cloud-compute] delivers virtual machines running in Google's innovative data
centers and worldwide fiber network. Compute Engine's tooling and workflow support enable scaling
from single instances to global, load-balanced cloud computing. Compute Engine's VMs boot quickly,
come with persistent disk storage, deliver consistent performance and are available in many
configurations.

Be sure to activate the Google Cloud Compute API on the Developer's Console to use Compute from
your project.

See the ``google-cloud`` API [compute documentation][compute-api] to learn how to interact
with Google Cloud Compute using this Client Library.

Getting Started
---------------

#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/)
project with the Compute Engine API enabled. You will need to [enable billing](https://support.google.com/cloud/answer/6158867?hl=en)
to use Google Cloud DNS. [Follow these instructions](https://cloud.google.com/docs/authentication#preparation)
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
import com.google.cloud.compute.Compute;
import com.google.cloud.compute.ComputeOptions;

Compute compute = ComputeOptions.getDefaultInstance().getService();
```

For other authentication options, see the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
page.

#### Creating a region IP address
An external region IP address can be associated to a Google Compute Engine instance to communicate
with instances in different regions or to communicate with the instance from ouside of Compute
Engine. In this code snippet, we will create a new external region address.

Add the following imports at the top of your file:

```java
import com.google.cloud.compute.AddressInfo;
import com.google.cloud.compute.Operation;
import com.google.cloud.compute.RegionAddressId;
```

Then add the following code to create an address. Most Compute Engine calls return an `Operation`
object that can be used to wait for operation completion and to check whether operation failed or
succeeded:

```java
RegionAddressId addressId = RegionAddressId.of("us-central1", "test-address");
Operation operation = compute.create(AddressInfo.of(addressId));
// Wait for operation to complete
operation = operation.waitFor();
if (operation.getErrors() == null) {
  System.out.println("Address " + addressId + " was successfully created");
} else {
  // inspect operation.getErrors()
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
import com.google.cloud.compute.DiskInfo;
import com.google.cloud.compute.DiskId;
import com.google.cloud.compute.ImageDiskConfiguration;
import com.google.cloud.compute.ImageId;
```

Then add the following code to create a disk and wait for disk creation to terminate.

```java
ImageId imageId = ImageId.of("debian-cloud", "debian-8-jessie-v20160329");
DiskId diskId = DiskId.of("us-central1-a", "test-disk");
ImageDiskConfiguration diskConfiguration = ImageDiskConfiguration.of(imageId);
DiskInfo disk = DiskInfo.of(diskId, diskConfiguration);
Operation operation = compute.create(disk);
// Wait for operation to complete
operation = operation.waitFor();
if (operation.getErrors() == null) {
  System.out.println("Disk " + diskId + " was successfully created");
} else {
  // inspect operation.getErrors()
  throw new RuntimeException("Disk creation failed");
}
```

#### Creating a virtual machine instance
An Google Compute Engine instance is a virtual machine (VM) hosted on Google's infrastructure. An
instance can be created given it's identity, a machine type, one boot disk and a network interface.
In this code snippet, we will create a virtual machine instance in the default network using as a
boot disk the disk we have just created and assigning to it the just created IP address.

Add the following imports at the top of your file:

```java
import com.google.cloud.compute.AttachedDisk;
import com.google.cloud.compute.AttachedDisk.PersistentDiskConfiguration;
import com.google.cloud.compute.InstanceId;
import com.google.cloud.compute.InstanceInfo;
import com.google.cloud.compute.MachineTypeId;
import com.google.cloud.compute.NetworkConfiguration;
import com.google.cloud.compute.NetworkConfiguration.AccessConfig;
import com.google.cloud.compute.NetworkId;
import com.google.cloud.compute.NetworkInterface;
```

Then add the following code to create an instance and wait for instance creation to terminate.

```java
Address externalIp = compute.getAddress(addressId);
InstanceId instanceId = InstanceId.of("us-central1-a", "test-instance");
NetworkId networkId = NetworkId.of("default");
PersistentDiskConfiguration attachConfiguration =
    PersistentDiskConfiguration.newBuilder(diskId).setBoot(true).build();
AttachedDisk attachedDisk = AttachedDisk.of("dev0", attachConfiguration);
NetworkInterface networkInterface = NetworkInterface.newBuilder(networkId)
    .setAccessConfigurations(AccessConfig.of(externalIp.getAddress()))
    .build();
MachineTypeId machineTypeId = MachineTypeId.of("us-central1-a", "n1-standard-1");
InstanceInfo instance =
    InstanceInfo.of(instanceId, machineTypeId, attachedDisk, networkInterface);
Operation operation = compute.create(instance);
// Wait for operation to complete
operation = operation.waitFor();
if (operation.getErrors() == null) {
  System.out.println("Instance " + instanceId + " was successfully created");
} else {
  // inspect operation.getErrors()
  throw new RuntimeException("Instance creation failed");
}
```

#### Complete source code

In
[CreateAddressDiskAndInstance.java](../google-cloud-examples/src/main/java/com/google/cloud/examples/compute/snippets/CreateAddressDiskAndInstance.java)
we put together all the code shown above into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

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


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-compute
[cloud-platform]: https://cloud.google.com/

[cloud-compute]: https://cloud.google.com/compute/
[compute-api]: https://googlecloudplatform.github.io/google-cloud-java/apidocs/index.html?com/google/cloud/compute/package-summary.html
