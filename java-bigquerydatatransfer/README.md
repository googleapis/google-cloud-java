# Google BigQuery Data Transfer Service Client for Java

Java idiomatic client for [BigQuery Data Transfer Service][product-docs].

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
      <version>16.3.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigquerydatatransfer</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquerydatatransfer</artifactId>
  <version>1.0.27</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.3.0')

compile 'com.google.cloud:google-cloud-bigquerydatatransfer'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigquerydatatransfer:1.0.27'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigquerydatatransfer" % "1.0.27"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the BigQuery Data Transfer Service [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google BigQuery Data Transfer Service.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-bigquerydatatransfer` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-bigquerydatatransfer` as a dependency in your code.

## About BigQuery Data Transfer Service


[BigQuery Data Transfer Service][product-docs] transfers data from partner SaaS applications to Google BigQuery on a scheduled, managed basis.

See the [BigQuery Data Transfer Service client library docs][javadocs] to learn how to
use this BigQuery Data Transfer Service Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-bigquerydatatransfer/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Copy Dataset | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CopyDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CopyDataset.java) |
| Create Ad Manager Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAdManagerTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAdManagerTransfer.java) |
| Create Ads Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAdsTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAdsTransfer.java) |
| Create Amazon S3 Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAmazonS3Transfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateAmazonS3Transfer.java) |
| Create Campaignmanager Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateCampaignmanagerTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateCampaignmanagerTransfer.java) |
| Create Cloud Storage Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateCloudStorageTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateCloudStorageTransfer.java) |
| Create Play Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreatePlayTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreatePlayTransfer.java) |
| Create Redshift Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateRedshiftTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateRedshiftTransfer.java) |
| Create Scheduled Query | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateScheduledQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateScheduledQuery.java) |
| Create Scheduled Query With Service Account | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateScheduledQueryWithServiceAccount.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateScheduledQueryWithServiceAccount.java) |
| Create Teradata Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateTeradataTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateTeradataTransfer.java) |
| Create Youtube Channel Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateYoutubeChannelTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateYoutubeChannelTransfer.java) |
| Create Youtube Content Owner Transfer | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateYoutubeContentOwnerTransfer.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/CreateYoutubeContentOwnerTransfer.java) |
| Delete Scheduled Query | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/DeleteScheduledQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/DeleteScheduledQuery.java) |
| Delete Transfer Config | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/DeleteTransferConfig.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/DeleteTransferConfig.java) |
| Disable Transfer Config | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/DisableTransferConfig.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/DisableTransferConfig.java) |
| Get Transfer Config Info | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/GetTransferConfigInfo.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/GetTransferConfigInfo.java) |
| List Transfer Configs | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/ListTransferConfigs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/ListTransferConfigs.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/QuickstartSample.java) |
| Re Enable Transfer Config | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/ReEnableTransferConfig.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/ReEnableTransferConfig.java) |
| Run Details | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunDetails.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunDetails.java) |
| Run History | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunHistory.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunHistory.java) |
| Run Notification | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunNotification.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/RunNotification.java) |
| Schedule Back Fill | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/ScheduleBackFill.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/ScheduleBackFill.java) |
| Update Credentials | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/UpdateCredentials.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/UpdateCredentials.java) |
| Update Transfer Config | [source code](https://github.com/googleapis/java-bigquerydatatransfer/blob/master/samples/snippets/src/main/java/com/example/bigquerydatatransfer/UpdateTransferConfig.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-bigquerydatatransfer&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/bigquerydatatransfer/UpdateTransferConfig.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

BigQuery Data Transfer Service uses gRPC for the transport layer.

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

Java is a registered trademark of Oracle and/or its affiliates.

[product-docs]: https://cloud.google.com/bigquery/transfer/
[javadocs]: https://googleapis.dev/java/google-cloud-bigquerydatatransfer/latest
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-bigquerydatatransfer/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigquerydatatransfer.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-bigquerydatatransfer&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-bigquerydatatransfer/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-bigquerydatatransfer/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-bigquerydatatransfer/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=bigquerydatatransfer.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
