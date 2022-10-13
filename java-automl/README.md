# Google Cloud Auto ML Client for Java

Java idiomatic client for [Cloud Auto ML][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>26.1.3</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-automl</artifactId>
  </dependency>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigquery</artifactId>
  </dependency>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-storage</artifactId>
  </dependency>
</dependencies>

```

If you are using Maven without BOM, add this to your dependencies:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-automl</artifactId>
  <version>2.3.17</version>
</dependency>
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-bigquery</artifactId>
  <version>2.17.0</version>
</dependency>
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-storage</artifactId>
  <version>2.13.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies:

```Groovy
implementation platform('com.google.cloud:libraries-bom:26.1.3')

implementation 'com.google.cloud:google-cloud-automl'
```
If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-automl:2.3.17'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-automl" % "2.3.17"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Cloud Auto ML APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Cloud Auto ML API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Auto ML [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud Auto ML.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-automl` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-automl` as a dependency in your code.

## About Cloud Auto ML

🔔 **AutoML API Java Client is now available in Vertex AI. Please visit** 
[java-aiplatform](https://github.com/googleapis/java-aiplatform) **for the new Java Vertex AI client.** 
Vertex AI is our next generation AI Platform, with many new features that are unavailable in the current platform. 
[Migrate your resources to Vertex AI](https://cloud.google.com/vertex-ai/docs/start/migrating-to-vertex-ai) to get 
the latest machine learning features, simplify end-to-end journeys, and productionize models with MLOps.

[Cloud Auto ML](https://cloud.google.com/automl/docs/) makes the power 
of machine learning available to you even if you have limited knowledge 
of machine learning. You can use AutoML to build on Google's machine 
learning capabilities to create your own custom machine learning models 
that are tailored to your business needs, and then integrate those 
models into your applications and web sites.

See the [Cloud Auto ML client library docs](https://cloud.google.com/java/docs/reference/google-cloud-automl/latest/history)
to learn how to use this Cloud Auto ML Client Library.






## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-automl/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Batch Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/BatchPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/BatchPredict.java) |
| Cancel Operation | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/CancelOperation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/CancelOperation.java) |
| Delete Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/DeleteDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/DeleteDataset.java) |
| Delete Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/DeleteModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/DeleteModel.java) |
| Deploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/DeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/DeployModel.java) |
| Get Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/GetModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/GetModel.java) |
| Get Model Evaluation | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/GetModelEvaluation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/GetModelEvaluation.java) |
| Get Operation Status | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/GetOperationStatus.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/GetOperationStatus.java) |
| Import Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/ImportDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/ImportDataset.java) |
| List Datasets | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/ListDatasets.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/ListDatasets.java) |
| List Model Evaluations | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/ListModelEvaluations.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/ListModelEvaluations.java) |
| List Models | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/ListModels.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/ListModels.java) |
| Set Endpoint | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/SetEndpoint.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/SetEndpoint.java) |
| Tables Batch Predict Big Query | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesBatchPredictBigQuery.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesBatchPredictBigQuery.java) |
| Tables Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesCreateDataset.java) |
| Tables Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesCreateModel.java) |
| Tables Get Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesGetModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesGetModel.java) |
| Tables Import Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesImportDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesImportDataset.java) |
| Tables Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/TablesPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/TablesPredict.java) |
| Undeploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/UndeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/UndeployModel.java) |
| Video Classification Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/VideoClassificationCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/VideoClassificationCreateDataset.java) |
| Video Classification Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/VideoClassificationCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/VideoClassificationCreateModel.java) |
| Video Object Tracking Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/VideoObjectTrackingCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/VideoObjectTrackingCreateDataset.java) |
| Video Object Tracking Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/beta/automl/VideoObjectTrackingCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/beta/automl/VideoObjectTrackingCreateModel.java) |
| Batch Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/BatchPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/BatchPredict.java) |
| Delete Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/DeleteDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/DeleteDataset.java) |
| Delete Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/DeleteModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/DeleteModel.java) |
| Deploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/DeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/DeployModel.java) |
| Export Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ExportDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ExportDataset.java) |
| Get Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/GetDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/GetDataset.java) |
| Get Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/GetModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/GetModel.java) |
| Get Model Evaluation | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/GetModelEvaluation.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/GetModelEvaluation.java) |
| Get Operation Status | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/GetOperationStatus.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/GetOperationStatus.java) |
| Import Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ImportDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ImportDataset.java) |
| Language Entity Extraction Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionCreateDataset.java) |
| Language Entity Extraction Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionCreateModel.java) |
| Language Entity Extraction Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageEntityExtractionPredict.java) |
| Language Sentiment Analysis Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisCreateDataset.java) |
| Language Sentiment Analysis Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisCreateModel.java) |
| Language Sentiment Analysis Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageSentimentAnalysisPredict.java) |
| Language Text Classification Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationCreateDataset.java) |
| Language Text Classification Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationCreateModel.java) |
| Language Text Classification Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/LanguageTextClassificationPredict.java) |
| List Datasets | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ListDatasets.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ListDatasets.java) |
| List Model Evaluations | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ListModelEvaluations.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ListModelEvaluations.java) |
| List Models | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ListModels.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ListModels.java) |
| List Operation Status | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/ListOperationStatus.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/ListOperationStatus.java) |
| Translate Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/TranslateCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/TranslateCreateDataset.java) |
| Translate Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/TranslateCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/TranslateCreateModel.java) |
| Translate Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/TranslatePredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/TranslatePredict.java) |
| Undeploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/UndeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/UndeployModel.java) |
| Vision Classification Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionClassificationCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionClassificationCreateDataset.java) |
| Vision Classification Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionClassificationCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionClassificationCreateModel.java) |
| Vision Classification Deploy Model Node Count | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionClassificationDeployModelNodeCount.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionClassificationDeployModelNodeCount.java) |
| Vision Classification Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionClassificationPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionClassificationPredict.java) |
| Vision Object Detection Create Dataset | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionCreateDataset.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionCreateDataset.java) |
| Vision Object Detection Create Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionCreateModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionCreateModel.java) |
| Vision Object Detection Deploy Model Node Count | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionDeployModelNodeCount.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionDeployModelNodeCount.java) |
| Vision Object Detection Predict | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionPredict.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/automl/VisionObjectDetectionPredict.java) |
| Dataset Api | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/translate/automl/DatasetApi.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/translate/automl/DatasetApi.java) |
| Model Api | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/translate/automl/ModelApi.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/translate/automl/ModelApi.java) |
| Classification Undeploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/ClassificationUndeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/ClassificationUndeployModel.java) |
| Prediction Api | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/PredictionApi.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/PredictionApi.java) |
| Classification Deploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationDeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationDeployModel.java) |
| Classification Deploy Model Node Count | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationDeployModelNodeCount.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationDeployModelNodeCount.java) |
| Classification Undeploy Model | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationUndeployModel.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ClassificationUndeployModel.java) |
| Model Api | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ModelApi.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ModelApi.java) |
| Object Detection Deploy Model Node Count | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ObjectDetectionDeployModelNodeCount.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/ObjectDetectionDeployModelNodeCount.java) |
| Prediction Api | [source code](https://github.com/googleapis/java-automl/blob/main/samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/PredictionApi.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-automl&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/cloud/vision/samples/automl/PredictionApi.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud Auto ML uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/automl/docs/
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-automl/latest/history
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-automl/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-automl.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-automl&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-automl/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-automl/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-automl/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=automl.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
