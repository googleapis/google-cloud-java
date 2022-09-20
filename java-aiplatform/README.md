# Google Vertex AI Client for Java

Java idiomatic client for [Vertex AI][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]


## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file:

```xml
<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-aiplatform</artifactId>
    <version>3.2.0</version>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:


```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-aiplatform</artifactId>
  <version>3.2.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies:

```Groovy
implementation platform('com.google.cloud:libraries-bom:26.1.2')

implementation 'com.google.cloud:google-cloud-aiplatform'
```
If you are using Gradle without BOM, add this to your dependencies:

```Groovy
implementation 'com.google.cloud:google-cloud-aiplatform:3.3.0'
```

If you are using SBT, add this to your dependencies:

```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-aiplatform" % "3.3.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Authorization

The client application making API calls must be granted [authorization scopes][auth-scopes] required for the desired Vertex AI APIs, and the authenticated principal must have the [IAM role(s)][predefined-iam-roles] required to access GCP resources using the Vertex AI API calls.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Vertex AI [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Vertex AI.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-aiplatform` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-aiplatform` as a dependency in your code.

## About Vertex AI


[Vertex AI][product-docs] is an integrated suite of machine learning tools and services for building and using ML models with AutoML or custom code. It offers both novices and experts the best workbench for the entire machine learning development lifecycle.

See the [Vertex AI client library docs][javadocs] to learn how to
use this Vertex AI Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-aiplatform/tree/main/samples) directory.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Batch Create Features Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/BatchCreateFeaturesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/BatchCreateFeaturesSample.java) |
| Batch Read Feature Values Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/BatchReadFeatureValuesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/BatchReadFeatureValuesSample.java) |
| Cancel Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CancelBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelBatchPredictionJobSample.java) |
| Cancel Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CancelDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelDataLabelingJobSample.java) |
| Cancel Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CancelTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelTrainingPipelineSample.java) |
| Create Batch Prediction Job Bigquery Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobBigquerySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobBigquerySample.java) |
| Create Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobSample.java) |
| Create Batch Prediction Job Text Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextClassificationSample.java) |
| Create Batch Prediction Job Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextEntityExtractionSample.java) |
| Create Batch Prediction Job Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobTextSentimentAnalysisSample.java) |
| Create Batch Prediction Job Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoActionRecognitionSample.java) |
| Create Batch Prediction Job Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoClassificationSample.java) |
| Create Batch Prediction Job Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoObjectTrackingSample.java) |
| Create Data Labeling Job Active Learning Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobActiveLearningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobActiveLearningSample.java) |
| Create Data Labeling Job Image Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobImageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobImageSample.java) |
| Create Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSample.java) |
| Create Data Labeling Job Specialist Pool Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSpecialistPoolSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSpecialistPoolSample.java) |
| Create Data Labeling Job Video Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobVideoSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobVideoSample.java) |
| Create Dataset Image Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetImageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetImageSample.java) |
| Create Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetSample.java) |
| Create Dataset Tabular Bigquery Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetTabularBigquerySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTabularBigquerySample.java) |
| Create Dataset Tabular Gcs Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetTabularGcsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTabularGcsSample.java) |
| Create Dataset Text Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetTextSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTextSample.java) |
| Create Dataset Video Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateDatasetVideoSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetVideoSample.java) |
| Create Endpoint Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateEndpointSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateEndpointSample.java) |
| Create Entity Type Monitoring Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateEntityTypeMonitoringSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateEntityTypeMonitoringSample.java) |
| Create Entity Type Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateEntityTypeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateEntityTypeSample.java) |
| Create Feature Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateFeatureSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateFeatureSample.java) |
| Create Featurestore Fixed Nodes Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateFeaturestoreFixedNodesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateFeaturestoreFixedNodesSample.java) |
| Create Featurestore Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateFeaturestoreSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateFeaturestoreSample.java) |
| Create Hyperparameter Tuning Job Python Package Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobPythonPackageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobPythonPackageSample.java) |
| Create Hyperparameter Tuning Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobSample.java) |
| Create Training Pipeline Custom Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomJobSample.java) |
| Create Training Pipeline Custom Training Managed Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomTrainingManagedDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomTrainingManagedDatasetSample.java) |
| Create Training Pipeline Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageClassificationSample.java) |
| Create Training Pipeline Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageObjectDetectionSample.java) |
| Create Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineSample.java) |
| Create Training Pipeline Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularClassificationSample.java) |
| Create Training Pipeline Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularRegressionSample.java) |
| Create Training Pipeline Text Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextClassificationSample.java) |
| Create Training Pipeline Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextEntityExtractionSample.java) |
| Create Training Pipeline Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextSentimentAnalysisSample.java) |
| Create Training Pipeline Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoActionRecognitionSample.java) |
| Create Training Pipeline Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoClassificationSample.java) |
| Create Training Pipeline Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoObjectTrackingSample.java) |
| Delete Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteBatchPredictionJobSample.java) |
| Delete Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteDataLabelingJobSample.java) |
| Delete Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteDatasetSample.java) |
| Delete Endpoint Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteEndpointSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteEndpointSample.java) |
| Delete Entity Type Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteEntityTypeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteEntityTypeSample.java) |
| Delete Export Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteExportModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteExportModelSample.java) |
| Delete Feature Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteFeatureSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteFeatureSample.java) |
| Delete Featurestore Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteFeaturestoreSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteFeaturestoreSample.java) |
| Delete Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteModelSample.java) |
| Delete Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeleteTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteTrainingPipelineSample.java) |
| Deploy Model Custom Trained Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeployModelCustomTrainedModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeployModelCustomTrainedModelSample.java) |
| Deploy Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/DeployModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeployModelSample.java) |
| Export Feature Values Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ExportFeatureValuesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportFeatureValuesSample.java) |
| Export Feature Values Snapshot Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ExportFeatureValuesSnapshotSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportFeatureValuesSnapshotSample.java) |
| Export Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ExportModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelSample.java) |
| Export Model Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ExportModelTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelTabularClassificationSample.java) |
| Export Model Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ExportModelVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelVideoActionRecognitionSample.java) |
| Get Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetBatchPredictionJobSample.java) |
| Get Entity Type Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetEntityTypeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetEntityTypeSample.java) |
| Get Feature Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetFeatureSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetFeatureSample.java) |
| Get Featurestore Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetFeaturestoreSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetFeaturestoreSample.java) |
| Get Hyperparameter Tuning Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetHyperparameterTuningJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetHyperparameterTuningJobSample.java) |
| Get Model Evaluation Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageClassificationSample.java) |
| Get Model Evaluation Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageObjectDetectionSample.java) |
| Get Model Evaluation Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationSample.java) |
| Get Model Evaluation Slice Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationSliceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationSliceSample.java) |
| Get Model Evaluation Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularClassificationSample.java) |
| Get Model Evaluation Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularRegressionSample.java) |
| Get Model Evaluation Text Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextClassificationSample.java) |
| Get Model Evaluation Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextEntityExtractionSample.java) |
| Get Model Evaluation Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextSentimentAnalysisSample.java) |
| Get Model Evaluation Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoActionRecognitionSample.java) |
| Get Model Evaluation Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoClassificationSample.java) |
| Get Model Evaluation Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoObjectTrackingSample.java) |
| Get Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelSample.java) |
| Get Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/GetTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetTrainingPipelineSample.java) |
| Import Data Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataImageClassificationSample.java) |
| Import Data Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataImageObjectDetectionSample.java) |
| Import Data Text Classification Single Label Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataTextClassificationSingleLabelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextClassificationSingleLabelSample.java) |
| Import Data Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextEntityExtractionSample.java) |
| Import Data Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextSentimentAnalysisSample.java) |
| Import Data Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoActionRecognitionSample.java) |
| Import Data Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoClassificationSample.java) |
| Import Data Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportDataVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoObjectTrackingSample.java) |
| Import Feature Values Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ImportFeatureValuesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportFeatureValuesSample.java) |
| List Entity Types Async Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListEntityTypesAsyncSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListEntityTypesAsyncSample.java) |
| List Entity Types Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListEntityTypesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListEntityTypesSample.java) |
| List Features Async Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListFeaturesAsyncSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListFeaturesAsyncSample.java) |
| List Features Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListFeaturesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListFeaturesSample.java) |
| List Featurestores Async Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListFeaturestoresAsyncSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListFeaturestoresAsyncSample.java) |
| List Featurestores Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListFeaturestoresSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListFeaturestoresSample.java) |
| List Model Evaluation Slice Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/ListModelEvaluationSliceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListModelEvaluationSliceSample.java) |
| Predict Custom Trained Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictCustomTrainedModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictCustomTrainedModelSample.java) |
| Predict Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictImageClassificationSample.java) |
| Predict Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictImageObjectDetectionSample.java) |
| Predict Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTabularClassificationSample.java) |
| Predict Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTabularRegressionSample.java) |
| Predict Text Classification Single Label Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictTextClassificationSingleLabelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextClassificationSingleLabelSample.java) |
| Predict Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextEntityExtractionSample.java) |
| Predict Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/PredictTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextSentimentAnalysisSample.java) |
| Search Features Async Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/SearchFeaturesAsyncSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/SearchFeaturesAsyncSample.java) |
| Search Features Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/SearchFeaturesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/SearchFeaturesSample.java) |
| Undeploy Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UndeployModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UndeployModelSample.java) |
| Update Entity Type Monitoring Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UpdateEntityTypeMonitoringSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UpdateEntityTypeMonitoringSample.java) |
| Update Entity Type Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UpdateEntityTypeSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UpdateEntityTypeSample.java) |
| Update Feature Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UpdateFeatureSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UpdateFeatureSample.java) |
| Update Featurestore Fixed Nodes Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UpdateFeaturestoreFixedNodesSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UpdateFeaturestoreFixedNodesSample.java) |
| Update Featurestore Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UpdateFeaturestoreSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UpdateFeaturestoreSample.java) |
| Upload Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/main/samples/snippets/src/main/java/aiplatform/UploadModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UploadModelSample.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Vertex AI uses gRPC for the transport layer.

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

[product-docs]: https://cloud.google.com/vertex-ai/docs
[javadocs]: https://cloud.google.com/java/docs/reference/google-cloud-aiplatform/latest/history
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-aiplatform/java11.html
[stability-image]: https://img.shields.io/badge/stability-stable-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-aiplatform.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-aiplatform&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[auth-scopes]: https://developers.google.com/identity/protocols/oauth2/scopes
[predefined-iam-roles]: https://cloud.google.com/iam/docs/understanding-roles#predefined_roles
[iam-policy]: https://cloud.google.com/iam/docs/overview#cloud-iam-policy
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/main/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-aiplatform/blob/main/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-aiplatform/blob/main/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-aiplatform/blob/main/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=aiplatform.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png

[semver]: https://semver.org/
[cloudlibs]: https://cloud.google.com/apis/docs/client-libraries-explained
[apilibs]: https://cloud.google.com/apis/docs/client-libraries-explained#google_api_client_libraries
[oracle]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[g-c-j]: http://github.com/googleapis/google-cloud-java
