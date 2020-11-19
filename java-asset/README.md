# Google Cloud Asset Inventory Client for Java

Java idiomatic client for [Cloud Asset Inventory][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>16.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-asset</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-asset</artifactId>
  <version>2.1.1</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-asset:2.1.1'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-asset" % "2.1.1"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Asset Inventory [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Asset Inventory.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-asset` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-asset` as a dependency in your code.

## About Cloud Asset Inventory


[Cloud Asset Inventory][product-docs] provides inventory services based on a time series database. This database keeps a five week history of Google Cloud asset metadata. The Cloud Asset Inventory export service allows you to export all asset metadata at a certain timestamp or export event change history during a timeframe.

See the [Cloud Asset Inventory client library docs][javadocs] to learn how to
use this Cloud Asset Inventory Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-asset/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Batch Get Assets History Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/BatchGetAssetsHistoryExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/BatchGetAssetsHistoryExample.java) |
| Create Feed Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/CreateFeedExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/CreateFeedExample.java) |
| Delete Feed Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/DeleteFeedExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/DeleteFeedExample.java) |
| Export Assets Bigquery Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/ExportAssetsBigqueryExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/ExportAssetsBigqueryExample.java) |
| Export Assets Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/ExportAssetsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/ExportAssetsExample.java) |
| Get Feed Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/GetFeedExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/GetFeedExample.java) |
| List Assets Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/ListAssetsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/ListAssetsExample.java) |
| List Feeds Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/ListFeedsExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/ListFeedsExample.java) |
| Search All Iam Policies Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/SearchAllIamPoliciesExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/SearchAllIamPoliciesExample.java) |
| Search All Resources Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/SearchAllResourcesExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/SearchAllResourcesExample.java) |
| Update Feed Example | [source code](https://github.com/googleapis/java-asset/blob/master/samples/snippets/src/main/java/com/example/asset/UpdateFeedExample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-asset&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/asset/UpdateFeedExample.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Asset Inventory uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

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
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[product-docs]: https://cloud.google.com/resource-manager/docs/cloud-asset-inventory/overview
[javadocs]: https://googleapis.dev/java/google-cloud-asset/latest/index.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-asset/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-asset.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-asset&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-asset/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-asset/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-asset/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=cloudasset.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
