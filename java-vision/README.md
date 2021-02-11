# Google Cloud Vision Client for Java

Java idiomatic client for [Cloud Vision][product-docs].

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
      <version>16.2.1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-vision</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-vision</artifactId>
  <version>1.100.10</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.4.0')

compile 'com.google.cloud:google-cloud-vision'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-vision:1.100.10'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-vision" % "1.100.10"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Vision [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Vision.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-vision` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-vision` as a dependency in your code.

## About Cloud Vision


[Cloud Vision][product-docs] allows developers to easily integrate vision detection features within applications, including image labeling, face and landmark detection, optical character recognition (OCR), and tagging of explicit content.

See the [Cloud Vision client library docs][javadocs] to learn how to
use this Cloud Vision Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-vision/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Async Batch Image Annotation | [source code](https://github.com/googleapis/java-vision/blob/master/samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionAsyncBatchAnnotateImages.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionAsyncBatchAnnotateImages.java) |
| None | [source code](https://github.com/googleapis/java-vision/blob/master/samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionBatchAnnotateFiles.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionBatchAnnotateFiles.java) |
| None | [source code](https://github.com/googleapis/java-vision/blob/master/samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionBatchAnnotateFilesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/generated/src/main/java/com/google/cloud/examples/vision/v1/VisionBatchAnnotateFilesGcs.java) |
| Async Batch Annotate Images Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/AsyncBatchAnnotateImagesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/AsyncBatchAnnotateImagesGcs.java) |
| Detect | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/Detect.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/Detect.java) |
| Detect Batch Annotate Files | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/DetectBatchAnnotateFiles.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/DetectBatchAnnotateFiles.java) |
| Detect Batch Annotate Files Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/DetectBatchAnnotateFilesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/DetectBatchAnnotateFilesGcs.java) |
| Detect Beta | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/DetectBeta.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/DetectBeta.java) |
| Import Product Sets | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ImportProductSets.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ImportProductSets.java) |
| Product In Product Set Management | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ProductInProductSetManagement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ProductInProductSetManagement.java) |
| Product Management | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ProductManagement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ProductManagement.java) |
| Product Search | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ProductSearch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ProductSearch.java) |
| Product Set Management | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ProductSetManagement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ProductSetManagement.java) |
| Reference Image Management | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/ReferenceImageManagement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/ReferenceImageManagement.java) |
| Quickstart Sample | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/quickstart/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/quickstart/QuickstartSample.java) |
| Async Batch Annotate Images | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/AsyncBatchAnnotateImages.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/AsyncBatchAnnotateImages.java) |
| Batch Annotate Files | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/BatchAnnotateFiles.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/BatchAnnotateFiles.java) |
| Batch Annotate Files Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/BatchAnnotateFilesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/BatchAnnotateFilesGcs.java) |
| Detect Crop Hints | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectCropHints.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectCropHints.java) |
| Detect Crop Hints Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectCropHintsGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectCropHintsGcs.java) |
| Detect Faces | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectFaces.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectFaces.java) |
| Detect Faces Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectFacesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectFacesGcs.java) |
| Detect Labels | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLabels.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLabels.java) |
| Detect Labels Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLabelsGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLabelsGcs.java) |
| Detect Landmarks | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarks.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarks.java) |
| Detect Landmarks Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarksGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarksGcs.java) |
| Detect Landmarks Url | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarksUrl.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLandmarksUrl.java) |
| Detect Logos | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLogos.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLogos.java) |
| Detect Logos Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectLogosGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectLogosGcs.java) |
| Detect Properties | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectProperties.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectProperties.java) |
| Detect Properties Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectPropertiesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectPropertiesGcs.java) |
| Detect Safe Search | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectSafeSearch.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectSafeSearch.java) |
| Detect Safe Search Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectSafeSearchGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectSafeSearchGcs.java) |
| Detect Text | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectText.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectText.java) |
| Detect Text Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectTextGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectTextGcs.java) |
| Detect Web Detections | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebDetections.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebDetections.java) |
| Detect Web Detections Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebDetectionsGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebDetectionsGcs.java) |
| Detect Web Entities | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntities.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntities.java) |
| Detect Web Entities Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesGcs.java) |
| Detect Web Entities Include Geo Results | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesIncludeGeoResults.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesIncludeGeoResults.java) |
| Detect Web Entities Include Geo Results Gcs | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesIncludeGeoResultsGcs.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/DetectWebEntitiesIncludeGeoResultsGcs.java) |
| Purge Products | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/PurgeProducts.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/PurgeProducts.java) |
| Purge Products In Product Set | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/PurgeProductsInProductSet.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/PurgeProductsInProductSet.java) |
| Set Endpoint | [source code](https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/SetEndpoint.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/vision/snippets/SetEndpoint.java) |
| Application | [source code](https://github.com/googleapis/java-vision/blob/master/samples/spring-framework/src/main/java/com/example/vision/Application.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/spring-framework/src/main/java/com/example/vision/Application.java) |
| Vision Controller | [source code](https://github.com/googleapis/java-vision/blob/master/samples/spring-framework/src/main/java/com/example/vision/VisionController.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-vision&page=editor&open_in_editor=samples/spring-framework/src/main/java/com/example/vision/VisionController.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Vision uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/vision/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-vision/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-vision/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-vision.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-vision&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-vision/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-vision/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-vision/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=vision.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
