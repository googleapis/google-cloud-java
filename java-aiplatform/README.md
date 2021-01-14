# Google Cloud AI Platform Client for Java

Java idiomatic client for [Cloud AI Platform][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-aiplatform</artifactId>
    <version>0.2.0</version>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-aiplatform</artifactId>
  <version>0.2.0</version>
</dependency>

```

If you are using Gradle 5.x or later, add this to your dependencies
```Groovy
implementation platform('com.google.cloud:libraries-bom:16.2.1')

compile 'com.google.cloud:google-cloud-aiplatform'
```
If you are using Gradle without BOM, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-aiplatform:0.2.0'
```

If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-aiplatform" % "0.2.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud AI Platform [API enabled][enable-api].
You will need to [enable billing][enable-billing] to use Google Cloud AI Platform.
[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-aiplatform` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-aiplatform` as a dependency in your code.

## About Cloud AI Platform


[Cloud AI Platform][product-docs] is an integrated suite of machine learning tools and services for building and using ML models with AutoML or custom code. It offers both novices and experts the best workbench for the entire machine learning development lifecycle.

See the [Cloud AI Platform client library docs][javadocs] to learn how to
use this Cloud AI Platform Client Library.





## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-aiplatform/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Cancel Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CancelBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelBatchPredictionJobSample.java) |
| Cancel Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CancelDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelDataLabelingJobSample.java) |
| Cancel Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CancelTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CancelTrainingPipelineSample.java) |
| Create Batch Prediction Job Bigquery Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobBigquerySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobBigquerySample.java) |
| Create Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobSample.java) |
| Create Batch Prediction Job Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoActionRecognitionSample.java) |
| Create Batch Prediction Job Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoClassificationSample.java) |
| Create Batch Prediction Job Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateBatchPredictionJobVideoObjectTrackingSample.java) |
| Create Data Labeling Job Active Learning Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobActiveLearningSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobActiveLearningSample.java) |
| Create Data Labeling Job Image Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobImageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobImageSample.java) |
| Create Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSample.java) |
| Create Data Labeling Job Specialist Pool Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSpecialistPoolSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobSpecialistPoolSample.java) |
| Create Data Labeling Job Video Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobVideoSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDataLabelingJobVideoSample.java) |
| Create Dataset Image Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetImageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetImageSample.java) |
| Create Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetSample.java) |
| Create Dataset Tabular Bigquery Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetTabularBigquerySample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTabularBigquerySample.java) |
| Create Dataset Tabular Gcs Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetTabularGcsSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTabularGcsSample.java) |
| Create Dataset Text Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetTextSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetTextSample.java) |
| Create Dataset Video Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateDatasetVideoSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateDatasetVideoSample.java) |
| Create Endpoint Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateEndpointSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateEndpointSample.java) |
| Create Hyperparameter Tuning Job Python Package Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobPythonPackageSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobPythonPackageSample.java) |
| Create Hyperparameter Tuning Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateHyperparameterTuningJobSample.java) |
| Create Training Pipeline Custom Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomJobSample.java) |
| Create Training Pipeline Custom Training Managed Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomTrainingManagedDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineCustomTrainingManagedDatasetSample.java) |
| Create Training Pipeline Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageClassificationSample.java) |
| Create Training Pipeline Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineImageObjectDetectionSample.java) |
| Create Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineSample.java) |
| Create Training Pipeline Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularClassificationSample.java) |
| Create Training Pipeline Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTabularRegressionSample.java) |
| Create Training Pipeline Text Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextClassificationSample.java) |
| Create Training Pipeline Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextEntityExtractionSample.java) |
| Create Training Pipeline Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineTextSentimentAnalysisSample.java) |
| Create Training Pipeline Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoActionRecognitionSample.java) |
| Create Training Pipeline Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoClassificationSample.java) |
| Create Training Pipeline Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/CreateTrainingPipelineVideoObjectTrackingSample.java) |
| Delete Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteBatchPredictionJobSample.java) |
| Delete Data Labeling Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteDataLabelingJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteDataLabelingJobSample.java) |
| Delete Dataset Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteDatasetSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteDatasetSample.java) |
| Delete Endpoint Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteEndpointSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteEndpointSample.java) |
| Delete Export Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteExportModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteExportModelSample.java) |
| Delete Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteModelSample.java) |
| Delete Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeleteTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeleteTrainingPipelineSample.java) |
| Deploy Model Custom Trained Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeployModelCustomTrainedModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeployModelCustomTrainedModelSample.java) |
| Deploy Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/DeployModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/DeployModelSample.java) |
| Export Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ExportModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelSample.java) |
| Export Model Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ExportModelTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelTabularClassificationSample.java) |
| Export Model Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ExportModelVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ExportModelVideoActionRecognitionSample.java) |
| Get Batch Prediction Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetBatchPredictionJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetBatchPredictionJobSample.java) |
| Get Hyperparameter Tuning Job Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetHyperparameterTuningJobSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetHyperparameterTuningJobSample.java) |
| Get Model Evaluation Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageClassificationSample.java) |
| Get Model Evaluation Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationImageObjectDetectionSample.java) |
| Get Model Evaluation Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationSample.java) |
| Get Model Evaluation Slice Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationSliceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationSliceSample.java) |
| Get Model Evaluation Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularClassificationSample.java) |
| Get Model Evaluation Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTabularRegressionSample.java) |
| Get Model Evaluation Text Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextClassificationSample.java) |
| Get Model Evaluation Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextEntityExtractionSample.java) |
| Get Model Evaluation Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationTextSentimentAnalysisSample.java) |
| Get Model Evaluation Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoActionRecognitionSample.java) |
| Get Model Evaluation Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoClassificationSample.java) |
| Get Model Evaluation Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelEvaluationVideoObjectTrackingSample.java) |
| Get Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetModelSample.java) |
| Get Training Pipeline Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/GetTrainingPipelineSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/GetTrainingPipelineSample.java) |
| Import Data Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataImageClassificationSample.java) |
| Import Data Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataImageObjectDetectionSample.java) |
| Import Data Text Classification Single Label Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataTextClassificationSingleLabelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextClassificationSingleLabelSample.java) |
| Import Data Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextEntityExtractionSample.java) |
| Import Data Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataTextSentimentAnalysisSample.java) |
| Import Data Video Action Recognition Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataVideoActionRecognitionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoActionRecognitionSample.java) |
| Import Data Video Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataVideoClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoClassificationSample.java) |
| Import Data Video Object Tracking Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ImportDataVideoObjectTrackingSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ImportDataVideoObjectTrackingSample.java) |
| List Model Evaluation Slice Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/ListModelEvaluationSliceSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/ListModelEvaluationSliceSample.java) |
| Predict Custom Trained Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictCustomTrainedModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictCustomTrainedModelSample.java) |
| Predict Image Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictImageClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictImageClassificationSample.java) |
| Predict Image Object Detection Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictImageObjectDetectionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictImageObjectDetectionSample.java) |
| Predict Tabular Classification Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictTabularClassificationSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTabularClassificationSample.java) |
| Predict Tabular Regression Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictTabularRegressionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTabularRegressionSample.java) |
| Predict Text Classification Single Label Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictTextClassificationSingleLabelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextClassificationSingleLabelSample.java) |
| Predict Text Entity Extraction Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictTextEntityExtractionSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextEntityExtractionSample.java) |
| Predict Text Sentiment Analysis Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/PredictTextSentimentAnalysisSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/PredictTextSentimentAnalysisSample.java) |
| Undeploy Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/UndeployModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UndeployModelSample.java) |
| Upload Model Sample | [source code](https://github.com/googleapis/java-aiplatform/blob/master/samples/snippets/src/main/java/aiplatform/UploadModelSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-aiplatform&page=editor&open_in_editor=samples/snippets/src/main/java/aiplatform/UploadModelSample.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Transport

Cloud AI Platform uses gRPC for the transport layer.

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


It is currently in major version zero (``0.y.z``), which means that anything may change at any time
and the public API should not be considered stable.

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

[product-docs]: https://cloud.google.com/ai-platform-unified/docs
[javadocs]: https://googleapis.dev/java/google-cloud-aiplatform/latest/index.html
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
[stability-image]: https://img.shields.io/badge/stability-beta-yellow
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-aiplatform.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-aiplatform&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-aiplatform/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-aiplatform/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-aiplatform/blob/master/LICENSE
[enable-billing]: https://cloud.google.com/apis/docs/getting-started#enabling_billing
[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=aiplatform.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
