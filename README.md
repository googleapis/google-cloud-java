Google Cloud Client Library for Java
====================================

Java idiomatic client for [Google Cloud Platform][cloud-platform] services.

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bom.svg)](https://search.maven.org/search?q=g:com.google.cloud%20a:google-cloud-bom)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Google Cloud Platform Documentation][cloud-platform-docs]
- [Client Library Documentation][client-lib-docs]

This library supports the following Google Cloud Platform services with clients at a [GA](#versioning) quality level:
-  [BigQuery](https://github.com/googleapis/java-bigquery) (GA)
-  [Cloud Bigtable](https://github.com/googleapis/java-bigtable) (GA)
-  [Cloud Datastore](https://github.com/googleapis/java-datastore/google-cloud-datastore) (GA)
-  [Cloud Firestore](https://github.com/googleapis/java-firestore/google-cloud-firestore) (GA)
-  [Cloud KMS](https://github.com/googleapis/java-kms) (GA)
-  [Cloud Natural Language](https://github.com/googleapis/java-language) (GA)
-  [Cloud Pub/Sub](https://github.com/googleapis/java-pubsub) (GA)
-  [Cloud Scheduler](https://github.com/googleapis/java-scheduler) (GA)
-  [Cloud Spanner](https://github.com/googleapis/java-spanner) (GA)
-  [Cloud Speech](https://github.com/googleapis/java-speech) (GA)
-  [Cloud Storage](https://github.com/googleapis/java-storage) (GA)
-  [Cloud Translation](https://github.com/googleapis/java-translate) (GA)
-  [Cloud Tasks](https://github.com/googleapis/java-tasks) (GA)
-  [Cloud Vision](https://github.com/googleapis/java-vision) (GA)
-  [Stackdriver Logging](https://github.com/googleapis/java-logging) (GA)
-  [Stackdriver Monitoring](https://github.com/googleapis/java-monitoring) (GA)

This library supports the following Google Cloud Platform services with clients at a [Beta](#versioning) quality level:

-  [BigQuery Data Transfer](https://github.com/googleapis/java-bigquerydatatransfer) (Beta)
-  [Cloud Asset](https://github.com/googleapis/java-asset) (Beta)
-  [Cloud AutoML](https://github.com/googleapis/java-automl) (Beta)
-  [Cloud Container Analysis](https://github.com/googleapis/java-containeranalysis) (Beta)
-  [Cloud Dataproc](https://github.com/googleapis/java-dataproc) (Beta)
-  [Cloud Data Loss Prevention](https://github.com/googleapis/java-dlp) (Beta)
-  [Cloud IoT Core](https://github.com/googleapis/java-iot) (Beta)
-  [Cloud Phishing Protection](https://github.com/googleapis/java-phishingprotection) (Beta)
-  [Cloud Security Scanner](https://github.com/googleapis/java-websecurityscanner) (Beta)
-  [Cloud Talent Solution](https://github.com/googleapis/java-talent) (Beta)
-  [Cloud Text-to-Speech](https://github.com/googleapis/java-texttospeech) (Beta)
-  [Cloud Video Intelligence](https://github.com/googleapis/java-video-intelligence) (Beta)
-  [Kubernetes Engine](https://github.com/googleapis/java-container) (Beta)
-  [reCAPTCHA Enterprise](https://github.com/googleapis/java-recaptchaenterprise) (Beta)
-  [Stackdriver Error Reporting](https://github.com/googleapis/java-errorreporting) (Beta)
-  [Stackdriver Trace](https://github.com/googleapis/java-trace) (Beta)

This library supports the following Google Cloud Platform services with clients at an [Alpha](#versioning) quality level:

-  [BigQuery Storage](https://github.com/googleapis/java-bigquerystorage) (Alpha)
-  [Cloud Compute](https://github.com/googleapis/java-compute) (Alpha)
-  [Cloud Data Catalog](https://github.com/googleapis/java-datacatalog) (Alpha)
-  [Cloud Data Labeling](https://github.com/googleapis/java-datalabeling) (Alpha)
-  [Cloud DNS](https://github.com/googleapis/java-dns) (Alpha)
-  [Cloud IAM Service Account Credentials API](https://github.com/googleapis/java-iamcredentials) (Alpha)
-  [Cloud OS Login](https://github.com/googleapis/java-os-login) (Alpha)
-  [Cloud Memorystore for Redis](https://github.com/googleapis/java-redis) (Alpha)
-  [Cloud Resource Manager](https://github.com/googleapis/java-resourcemanager) (Alpha)
-  [Cloud Web Risk](https://github.com/googleapis/java-webrisk) (Alpha)
-  [Dialogflow](https://github.com/googleapis/java-dialogflow) (Alpha)

Quickstart
----------

To call any of the supported Google Cloud Services simply add a corresponding client library 
artifact as a dependency to your project. The following instructions use `google-cloud-storage` 
as an example (specific instructions can be found in the README of each client).

If you are using Maven, add this to your pom.xml file
```xml
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>com.google.cloud</groupId>
        <artifactId>libraries-bom</artifactId>
        <version>3.0.0</version>
        <type>pom</type>
        <scope>import</scope>
       </dependency>
     </dependencies>
  </dependencyManagement>

  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-storage</artifactId>
    </dependency>
    ...
```

[//]: # ({x-version-update-start:google-cloud-storage:released})
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-storage:1.102.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-storage" % "1.102.0"
```
[//]: # ({x-version-update-end})

If you're using IntelliJ or Eclipse, you can add client libraries to your project using these IDE plugins:
* [Cloud Tools for IntelliJ](https://cloud.google.com/tools/intellij/docs/client-libraries?utm_source=github&utm_medium=google-cloud-java&utm_campaign=ToolsforIntelliJ)
* [Cloud Tools for Eclipse](https://cloud.google.com/eclipse/docs/libraries?utm_source=github&utm_medium=google-cloud-java&utm_campaign=ToolsforEclipse)

Besides adding client libraries, the plugins provide additional functionality, such as service account key management. Refer to the documentation for each plugin for more details.

These client libraries can be used on App Engine standard for Java 8 runtime and App Engine flexible (including the Compat runtime).  Most of the libraries do not work on the App Engine standard for Java 7 runtime. However, Datastore, Storage, and Bigquery should work.

Specifying a Project ID
-----------------------

Most `google-cloud` libraries require a project ID.  There are multiple ways to specify this project ID.

1. When using `google-cloud` libraries from within Compute/App Engine, there's no need to specify a project ID.  It is automatically inferred from the production environment.
2. When using `google-cloud` elsewhere, you can do one of the following:
  * Supply the project ID when building the service options.  For example, to use Datastore from a project with ID "PROJECT_ID", you can write:

  ```java
  Datastore datastore = DatastoreOptions.newBuilder().setProjectId("PROJECT_ID").build().getService();
  ```
  * Specify the environment variable `GOOGLE_CLOUD_PROJECT` to be your desired project ID.
  * Set the project ID using the [Google Cloud SDK](https://cloud.google.com/sdk/?hl=en).  To use the SDK, [download the SDK](https://cloud.google.com/sdk/?hl=en) if you haven't already, and set the project ID from the command line.  For example:

  ```
  gcloud config set project PROJECT_ID
  ```

`google-cloud` determines the project ID from the following sources in the listed order, stopping once it finds a value:

1. The project ID supplied when building the service options
2. Project ID specified by the environment variable `GOOGLE_CLOUD_PROJECT`
3. The App Engine / Compute Engine project ID
4. The project ID specified in the JSON credentials file pointed by the `GOOGLE_APPLICATION_CREDENTIALS` environment variable
5. The Google Cloud SDK project ID

In cases where the library may expect a project ID explicitly, we provide a helper that can provide the inferred project ID:
   ```java
     import com.google.cloud.ServiceOptions;
     ...
     String projectId = ServiceOptions.getDefaultProjectId();
   ```

Authentication
--------------

`google-cloud-java` uses
[https://github.com/googleapis/google-auth-library-java](https://github.com/googleapis/google-auth-library-java)
to authenticate requests. `google-auth-library-java` supports a wide range of authentication types;
see the project's [README](https://github.com/google/google-auth-library-java/blob/master/README.md)
and [javadoc](http://googleapis.dev/java/google-auth-library/latest/) for more
details.

To access Google Cloud services, you first need to ensure that the necessary Google Cloud APIs are
enabled for your project. To do this, follow the instructions on the
[authentication document](https://github.com/googleapis/google-cloud-common/blob/master/authentication/readme.md#authentication)
shared by all the Google Cloud language libraries.

Next, choose a method for authenticating API requests from within your project:

1. When using `google-cloud` libraries from within Compute/App Engine, no additional authentication
steps are necessary. For example:
```java
Storage storage = StorageOptions.getDefaultInstance().getService();
```
2. When using `google-cloud` libraries elsewhere, there are several options:
  * [Generate a JSON service account key](https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts).
  After downloading that key, you must do one of the following:
    * Define the environment variable GOOGLE_APPLICATION_CREDENTIALS to be the location of the key.
    For example:
    ```bash
    export GOOGLE_APPLICATION_CREDENTIALS=/path/to/my/key.json
    ```
    * Supply the JSON credentials file when building the service options. For example, this Storage
    object has the necessary permissions to interact with your Google Cloud Storage data:
    ```java
    Storage storage = StorageOptions.newBuilder()
        .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("/path/to/my/key.json")))
        .build()
        .getService();
    ```
  * If running locally for development/testing, you can use the
  [Google Cloud SDK](https://cloud.google.com/sdk/). Create Application Default Credentials with
  `gcloud auth application-default login`, and then `google-cloud` will automatically detect such
  credentials.
  * If you already have an OAuth2 access token, you can use it to authenticate (notice that in this
  case, the access token will not be automatically refreshed):
  ```java
  Storage storage = StorageOptions.newBuilder()
      .setCredentials(GoogleCredentials.create(new AccessToken(accessToken, expirationTime)))
      .build()
      .getService();
  ```

If no credentials are provided, `google-cloud` will attempt to detect them from the environment
using `GoogleCredentials.getApplicationDefault()` which will search for Application Default
Credentials in the following locations (in order):

1. The credentials file pointed to by the `GOOGLE_APPLICATION_CREDENTIALS` environment variable
2. Credentials provided by the Google Cloud SDK `gcloud auth application-default login` command
3. Google App Engine built-in credentials
4. Google Cloud Shell built-in credentials
5. Google Compute Engine built-in credentials

Troubleshooting
---------------

To get help, follow the instructions in the [Troubleshooting document](https://github.com/googleapis/google-cloud-java/blob/master/TROUBLESHOOTING.md).

Using a proxy
-------------
Clients in this repository use either HTTP or gRPC for the transport layer.
The README of each client documents the transport layer the client uses.

For HTTP clients, a proxy can be configured by using `http.proxyHost` and
related system properties as documented by
[Java Networking and Proxies](https://docs.oracle.com/javase/8/docs/technotes/guides/net/proxies.html).

For gRPC clients, a proxy can be configured by using the
`GRPC_PROXY_EXP` environment variable as documented by
the gRPC [release notes](https://github.com/grpc/grpc-java/releases/tag/v1.0.3).
Please note that gRPC proxy support is currently experimental.

Java Versions
-------------

Java 7 or above is required for using the clients in this repository.

Supported Platforms
-------------------

Clients in this repository use either HTTP or gRPC for the transport layer. All
HTTP-based clients should work in all environments.

For clients that use gRPC, the supported platforms are constrained by the platforms
that [Forked Tomcat Native](http://netty.io/wiki/forked-tomcat-native.html) supports,
which for architectures means only x86_64, and for operating systems means Mac OS X,
Windows, and Linux. Additionally, gRPC constrains the use of platforms with
threading restrictions.

Thus, the following are not supported:

- Android 
  - Consider [Firebase](https://firebase.google.com), which includes many of these APIs.
  - It is possible to use these libraries in many cases, although it is unsupported.
    You can find examples, such as [this one](https://github.com/GoogleCloudPlatform/android-docs-samples/tree/master/speech/SpeechRecognitionClient),
    in this [example repository](https://github.com/GoogleCloudPlatform/android-docs-samples) but consider the risks carefully before using these libraries in an application.
- Alpine Linux (due to netty-tcnative requiring glibc, which is not present on Alpine)
- Raspberry Pi (since it runs on the ARM architecture)
- Google App Engine Standard Java 7

The following environments should work (among others):

- standalone Windows on x86_64
- standalone Mac OS X on x86_64
- standalone Linux on x86_64
- Google Compute Engine (GCE)
- Google Container Engine (GKE)
- Google App Engine Standard Java 8 (GAE Std J8)
- Google App Engine Flex (GAE Flex)

Testing
-------

This library provides tools to help write tests for code that uses google-cloud services.

See [TESTING] to read more about using our testing helpers.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/), with some
additional qualifications:

1. Components marked with `@BetaApi` are considered to be "0.x" features inside
   a "1.x" library. This means they can change between minor and patch releases
   in incompatible ways. These features should not be used by any library "B"
   that itself has consumers, unless the components of library B that use
   `@BetaApi` features are also marked with `@BetaApi`. Features marked as
   `@BetaApi` are on a path to eventually become "1.x" features with the marker
   removed.

   **Special exception for google-cloud-java**: google-cloud-java is
   allowed to depend on `@BetaApi` features in gax-java without declaring the consuming
   code `@BetaApi`, because gax-java and google-cloud-java move in step
   with each other. For this reason, gax-java should not be used
   independently of google-cloud-java.

1. Components marked with `@InternalApi` are technically public, but only
   because of the limitations of Java's access
   modifiers. For the purposes of semver, they should be considered private.

Please note it is currently under active development. Any release versioned 0.x.y is
subject to backwards incompatible changes at any time.

**GA**: Libraries defined at a GA quality level are expected to be stable and all updates in the
libraries are guaranteed to be backwards-compatible. Any backwards-incompatible changes will lead
to the major version increment (1.x.y -> 2.0.0).

**Beta**: Libraries defined at a Beta quality level are expected to be mostly stable and
we're working towards their release candidate. We will address issues and requests with
a higher priority.

**Alpha**: Libraries defined at an Alpha quality level are still a work-in-progress and
are more likely to get backwards-incompatible updates. Additionally, it's possible for Alpha
libraries to get deprecated and deleted before ever being promoted to Beta or GA.

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
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md

[cloud-platform]: https://cloud.google.com/
[cloud-platform-docs]: https://cloud.google.com/docs/
[client-lib-docs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html

