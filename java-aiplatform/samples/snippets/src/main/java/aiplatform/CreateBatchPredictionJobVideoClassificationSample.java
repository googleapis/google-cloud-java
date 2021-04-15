/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_create_batch_prediction_job_video_classification_sample]

import com.google.cloud.aiplatform.util.ValueConverter;
import com.google.cloud.aiplatform.v1.BatchDedicatedResources;
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.InputConfig;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.OutputConfig;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.OutputInfo;
import com.google.cloud.aiplatform.v1.BigQueryDestination;
import com.google.cloud.aiplatform.v1.BigQuerySource;
import com.google.cloud.aiplatform.v1.CompletionStats;
import com.google.cloud.aiplatform.v1.GcsDestination;
import com.google.cloud.aiplatform.v1.GcsSource;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.MachineSpec;
import com.google.cloud.aiplatform.v1.ManualBatchTuningParameters;
import com.google.cloud.aiplatform.v1.ModelName;
import com.google.cloud.aiplatform.v1.ResourcesConsumed;
import com.google.cloud.aiplatform.v1.schema.predict.params.VideoClassificationPredictionParams;
import com.google.protobuf.Any;
import com.google.protobuf.Value;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.List;

public class CreateBatchPredictionJobVideoClassificationSample {

  public static void main(String[] args) throws IOException {
    String batchPredictionDisplayName = "YOUR_VIDEO_CLASSIFICATION_DISPLAY_NAME";
    String modelId = "YOUR_MODEL_ID";
    String gcsSourceUri =
        "gs://YOUR_GCS_SOURCE_BUCKET/path_to_your_video_source/[file.csv/file.jsonl]";
    String gcsDestinationOutputUriPrefix =
        "gs://YOUR_GCS_SOURCE_BUCKET/destination_output_uri_prefix/";
    String project = "YOUR_PROJECT_ID";
    createBatchPredictionJobVideoClassification(
        batchPredictionDisplayName, modelId, gcsSourceUri, gcsDestinationOutputUriPrefix, project);
  }

  static void createBatchPredictionJobVideoClassification(
      String batchPredictionDisplayName,
      String modelId,
      String gcsSourceUri,
      String gcsDestinationOutputUriPrefix,
      String project)
      throws IOException {
    JobServiceSettings jobServiceSettings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings)) {
      String location = "us-central1";
      LocationName locationName = LocationName.of(project, location);

      VideoClassificationPredictionParams modelParamsObj =
          VideoClassificationPredictionParams.newBuilder()
              .setConfidenceThreshold(((float) 0.5))
              .setMaxPredictions(10000)
              .setSegmentClassification(true)
              .setShotClassification(true)
              .setOneSecIntervalClassification(true)
              .build();

      Value modelParameters = ValueConverter.toValue(modelParamsObj);

      ModelName modelName = ModelName.of(project, location, modelId);
      GcsSource.Builder gcsSource = GcsSource.newBuilder();
      gcsSource.addUris(gcsSourceUri);
      InputConfig inputConfig =
          InputConfig.newBuilder().setInstancesFormat("jsonl").setGcsSource(gcsSource).build();

      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(gcsDestinationOutputUriPrefix).build();
      OutputConfig outputConfig =
          OutputConfig.newBuilder()
              .setPredictionsFormat("jsonl")
              .setGcsDestination(gcsDestination)
              .build();

      BatchPredictionJob batchPredictionJob =
          BatchPredictionJob.newBuilder()
              .setDisplayName(batchPredictionDisplayName)
              .setModel(modelName.toString())
              .setModelParameters(modelParameters)
              .setInputConfig(inputConfig)
              .setOutputConfig(outputConfig)
              .build();
      BatchPredictionJob batchPredictionJobResponse =
          jobServiceClient.createBatchPredictionJob(locationName, batchPredictionJob);

      System.out.println("Create Batch Prediction Job Video Classification Response");
      System.out.format("\tName: %s\n", batchPredictionJobResponse.getName());
      System.out.format("\tDisplay Name: %s\n", batchPredictionJobResponse.getDisplayName());
      System.out.format("\tModel %s\n", batchPredictionJobResponse.getModel());
      System.out.format(
          "\tModel Parameters: %s\n", batchPredictionJobResponse.getModelParameters());

      System.out.format("\tState: %s\n", batchPredictionJobResponse.getState());
      System.out.format("\tCreate Time: %s\n", batchPredictionJobResponse.getCreateTime());
      System.out.format("\tStart Time: %s\n", batchPredictionJobResponse.getStartTime());
      System.out.format("\tEnd Time: %s\n", batchPredictionJobResponse.getEndTime());
      System.out.format("\tUpdate Time: %s\n", batchPredictionJobResponse.getUpdateTime());
      System.out.format("\tLabels: %s\n", batchPredictionJobResponse.getLabelsMap());

      InputConfig inputConfigResponse = batchPredictionJobResponse.getInputConfig();
      System.out.println("\tInput Config");
      System.out.format("\t\tInstances Format: %s\n", inputConfigResponse.getInstancesFormat());

      GcsSource gcsSourceResponse = inputConfigResponse.getGcsSource();
      System.out.println("\t\tGcs Source");
      System.out.format("\t\t\tUris %s\n", gcsSourceResponse.getUrisList());

      BigQuerySource bigQuerySource = inputConfigResponse.getBigquerySource();
      System.out.println("\t\tBigquery Source");
      System.out.format("\t\t\tInput_uri: %s\n", bigQuerySource.getInputUri());

      OutputConfig outputConfigResponse = batchPredictionJobResponse.getOutputConfig();
      System.out.println("\tOutput Config");
      System.out.format(
          "\t\tPredictions Format: %s\n", outputConfigResponse.getPredictionsFormat());

      GcsDestination gcsDestinationResponse = outputConfigResponse.getGcsDestination();
      System.out.println("\t\tGcs Destination");
      System.out.format(
          "\t\t\tOutput Uri Prefix: %s\n", gcsDestinationResponse.getOutputUriPrefix());

      BigQueryDestination bigQueryDestination = outputConfigResponse.getBigqueryDestination();
      System.out.println("\t\tBig Query Destination");
      System.out.format("\t\t\tOutput Uri: %s\n", bigQueryDestination.getOutputUri());

      BatchDedicatedResources batchDedicatedResources =
          batchPredictionJobResponse.getDedicatedResources();
      System.out.println("\tBatch Dedicated Resources");
      System.out.format(
          "\t\tStarting Replica Count: %s\n", batchDedicatedResources.getStartingReplicaCount());
      System.out.format(
          "\t\tMax Replica Count: %s\n", batchDedicatedResources.getMaxReplicaCount());

      MachineSpec machineSpec = batchDedicatedResources.getMachineSpec();
      System.out.println("\t\tMachine Spec");
      System.out.format("\t\t\tMachine Type: %s\n", machineSpec.getMachineType());
      System.out.format("\t\t\tAccelerator Type: %s\n", machineSpec.getAcceleratorType());
      System.out.format("\t\t\tAccelerator Count: %s\n", machineSpec.getAcceleratorCount());

      ManualBatchTuningParameters manualBatchTuningParameters =
          batchPredictionJobResponse.getManualBatchTuningParameters();
      System.out.println("\tManual Batch Tuning Parameters");
      System.out.format("\t\tBatch Size: %s\n", manualBatchTuningParameters.getBatchSize());

      OutputInfo outputInfo = batchPredictionJobResponse.getOutputInfo();
      System.out.println("\tOutput Info");
      System.out.format("\t\tGcs Output Directory: %s\n", outputInfo.getGcsOutputDirectory());
      System.out.format("\t\tBigquery Output Dataset: %s\n", outputInfo.getBigqueryOutputDataset());

      Status status = batchPredictionJobResponse.getError();
      System.out.println("\tError");
      System.out.format("\t\tCode: %s\n", status.getCode());
      System.out.format("\t\tMessage: %s\n", status.getMessage());
      List<Any> details = status.getDetailsList();

      for (Status partialFailure : batchPredictionJobResponse.getPartialFailuresList()) {
        System.out.println("\tPartial Failure");
        System.out.format("\t\tCode: %s\n", partialFailure.getCode());
        System.out.format("\t\tMessage: %s\n", partialFailure.getMessage());
        List<Any> partialFailureDetailsList = partialFailure.getDetailsList();
      }

      ResourcesConsumed resourcesConsumed = batchPredictionJobResponse.getResourcesConsumed();
      System.out.println("\tResources Consumed");
      System.out.format("\t\tReplica Hours: %s\n", resourcesConsumed.getReplicaHours());

      CompletionStats completionStats = batchPredictionJobResponse.getCompletionStats();
      System.out.println("\tCompletion Stats");
      System.out.format("\t\tSuccessful Count: %s\n", completionStats.getSuccessfulCount());
      System.out.format("\t\tFailed Count: %s\n", completionStats.getFailedCount());
      System.out.format("\t\tIncomplete Count: %s\n", completionStats.getIncompleteCount());
    }
  }
}
// [END aiplatform_create_batch_prediction_job_video_classification_sample]
