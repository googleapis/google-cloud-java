# Google Cloud Data Loss Prevention Client for Java

Java idiomatic client for [Cloud Data Loss Prevention][product-docs].

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
      <version>16.2.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-dlp</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-dlp</artifactId>
  <version>2.2.3</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-dlp:2.2.4'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-dlp" % "2.2.4"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Data Loss Prevention [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Data Loss Prevention.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-dlp` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-dlp` as a dependency in your code.

## About Cloud Data Loss Prevention


[Cloud Data Loss Prevention][product-docs] provides programmatic access to a powerful detection engine for personally identifiable information and other privacy-sensitive data in unstructured data streams, like text blocks and images.

See the [Cloud Data Loss Prevention client library docs][javadocs] to learn how to
use this Cloud Data Loss Prevention Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-dlp/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| De Identify Table Bucketing | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableBucketing.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableBucketing.java) |
| De Identify Table Condition Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableConditionInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableConditionInfoTypes.java) |
| De Identify Table Condition Masking | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableConditionMasking.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableConditionMasking.java) |
| De Identify Table Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableInfoTypes.java) |
| De Identify Table Row Suppress | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableRowSuppress.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableRowSuppress.java) |
| De Identify Table With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTableWithFpe.java) |
| De Identify Text With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyTextWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyTextWithFpe.java) |
| De Identify With Date Shift | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithDateShift.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithDateShift.java) |
| De Identify With Exception List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithExceptionList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithExceptionList.java) |
| De Identify With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithFpe.java) |
| De Identify With Info Type | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithInfoType.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithInfoType.java) |
| De Identify With Masking | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithMasking.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithMasking.java) |
| De Identify With Redaction | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithRedaction.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithRedaction.java) |
| De Identify With Replacement | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithReplacement.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithReplacement.java) |
| De Identify With Simple Word List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithSimpleWordList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/DeIdentifyWithSimpleWordList.java) |
| Info Types List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InfoTypesList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InfoTypesList.java) |
| Inspect Big Query Table | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectBigQueryTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectBigQueryTable.java) |
| Inspect Big Query Table With Sampling | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectBigQueryTableWithSampling.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectBigQueryTableWithSampling.java) |
| Inspect Datastore Entity | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectDatastoreEntity.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectDatastoreEntity.java) |
| Inspect Gcs File | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectGcsFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectGcsFile.java) |
| Inspect Gcs File With Sampling | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectGcsFileWithSampling.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectGcsFileWithSampling.java) |
| Inspect Image File | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectImageFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectImageFile.java) |
| Inspect Image File All Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectImageFileAllInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectImageFileAllInfoTypes.java) |
| Inspect Image File Listed Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectImageFileListedInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectImageFileListedInfoTypes.java) |
| Inspect Phone Number | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectPhoneNumber.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectPhoneNumber.java) |
| Inspect String | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectString.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectString.java) |
| Inspect String Custom Excluding Substring | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringCustomExcludingSubstring.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringCustomExcludingSubstring.java) |
| Inspect String Custom Hotword | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringCustomHotword.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringCustomHotword.java) |
| Inspect String Custom Omit Overlap | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringCustomOmitOverlap.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringCustomOmitOverlap.java) |
| Inspect String Multiple Rules | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringMultipleRules.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringMultipleRules.java) |
| Inspect String Omit Overlap | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringOmitOverlap.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringOmitOverlap.java) |
| Inspect String With Exclusion Dict | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionDict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionDict.java) |
| Inspect String With Exclusion Dict Substring | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionDictSubstring.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionDictSubstring.java) |
| Inspect String With Exclusion Regex | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionRegex.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringWithExclusionRegex.java) |
| Inspect String Without Overlap | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectStringWithoutOverlap.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectStringWithoutOverlap.java) |
| Inspect Table | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectTable.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectTable.java) |
| Inspect Text File | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectTextFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectTextFile.java) |
| Inspect With Custom Regex | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectWithCustomRegex.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectWithCustomRegex.java) |
| Inspect With Hotword Rules | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/InspectWithHotwordRules.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/InspectWithHotwordRules.java) |
| Jobs Create | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/JobsCreate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/JobsCreate.java) |
| Jobs Delete | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/JobsDelete.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/JobsDelete.java) |
| Jobs Get | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/JobsGet.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/JobsGet.java) |
| Jobs List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/JobsList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/JobsList.java) |
| Quick Start | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/QuickStart.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/QuickStart.java) |
| Re Identify Table With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/ReIdentifyTableWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/ReIdentifyTableWithFpe.java) |
| Re Identify Text With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/ReIdentifyTextWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/ReIdentifyTextWithFpe.java) |
| Re Identify With Fpe | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/ReIdentifyWithFpe.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/ReIdentifyWithFpe.java) |
| Redact Image File | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RedactImageFile.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RedactImageFile.java) |
| Redact Image File All Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RedactImageFileAllInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RedactImageFileAllInfoTypes.java) |
| Redact Image File All Text | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RedactImageFileAllText.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RedactImageFileAllText.java) |
| Redact Image File Colored Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RedactImageFileColoredInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RedactImageFileColoredInfoTypes.java) |
| Redact Image File Listed Info Types | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RedactImageFileListedInfoTypes.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RedactImageFileListedInfoTypes.java) |
| Risk Analysis Categorical Stats | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RiskAnalysisCategoricalStats.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RiskAnalysisCategoricalStats.java) |
| Risk Analysis K Anonymity | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RiskAnalysisKAnonymity.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RiskAnalysisKAnonymity.java) |
| Risk Analysis K Map | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RiskAnalysisKMap.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RiskAnalysisKMap.java) |
| Risk Analysis L Diversity | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RiskAnalysisLDiversity.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RiskAnalysisLDiversity.java) |
| Risk Analysis Numerical Stats | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/RiskAnalysisNumericalStats.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/RiskAnalysisNumericalStats.java) |
| Templates Create | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TemplatesCreate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TemplatesCreate.java) |
| Templates Delete | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TemplatesDelete.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TemplatesDelete.java) |
| Templates List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TemplatesList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TemplatesList.java) |
| Triggers Create | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TriggersCreate.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TriggersCreate.java) |
| Triggers Delete | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TriggersDelete.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TriggersDelete.java) |
| Triggers List | [source code](https://github.com/googleapis/java-dlp/blob/master/samples/snippets/src/main/java/dlp/snippets/TriggersList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/src/main/java/dlp/snippets/TriggersList.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Data Loss Prevention uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/dlp/docs/
[javadocs]: https://googleapis.dev/java/google-cloud-dlp/latest/
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-dlp/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-dlp.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-dlp&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-dlp/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-dlp/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-dlp/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=dlp.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
