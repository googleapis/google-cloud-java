/*
 * Copyright 2020 Google LLC
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

// [START aiplatform_get_batch_prediction_job_sample]

import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.InputConfig;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.OutputConfig;
import com.google.cloud.aiplatform.v1.BatchPredictionJob.OutputInfo;
import com.google.cloud.aiplatform.v1.BatchPredictionJobName;
import com.google.cloud.aiplatform.v1.BigQueryDestination;
import com.google.cloud.aiplatform.v1.BigQuerySource;
import com.google.cloud.aiplatform.v1.CompletionStats;
import com.google.cloud.aiplatform.v1.GcsDestination;
import com.google.cloud.aiplatform.v1.GcsSource;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.ResourcesConsumed;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.List;

public class GetBatchPredictionJobSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String batchPredictionJobId = "YOUR_BATCH_PREDICTION_JOB_ID";
    getBatchPredictionJobSample(project, batchPredictionJobId);
  }

  static void getBatchPredictionJobSample(String project, String batchPredictionJobId)
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
      BatchPredictionJobName batchPredictionJobName =
          BatchPredictionJobName.of(project, location, batchPredictionJobId);

      BatchPredictionJob batchPredictionJob =
          jobServiceClient.getBatchPredictionJob(batchPredictionJobName);

      System.out.println("Get Batch Prediction Job Response");
      System.out.format("\tName: %s\n", batchPredictionJob.getName());
      System.out.format("\tDisplay Name: %s\n", batchPredictionJob.getDisplayName());
      System.out.format("\tModel: %s\n", batchPredictionJob.getModel());

      System.out.format("\tModel Parameters: %s\n", batchPredictionJob.getModelParameters());
      System.out.format("\tState: %s\n", batchPredictionJob.getState());

      System.out.format("\tCreate Time: %s\n", batchPredictionJob.getCreateTime());
      System.out.format("\tStart Time: %s\n", batchPredictionJob.getStartTime());
      System.out.format("\tEnd Time: %s\n", batchPredictionJob.getEndTime());
      System.out.format("\tUpdate Time: %s\n", batchPredictionJob.getUpdateTime());
      System.out.format("\tLabels: %s\n", batchPredictionJob.getLabelsMap());

      InputConfig inputConfig = batchPredictionJob.getInputConfig();
      System.out.println("\tInput Config");
      System.out.format("\t\tInstances Format: %s\n", inputConfig.getInstancesFormat());

      GcsSource gcsSource = inputConfig.getGcsSource();
      System.out.println("\t\tGcs Source");
      System.out.format("\t\t\tUris: %s\n", gcsSource.getUrisList());

      BigQuerySource bigquerySource = inputConfig.getBigquerySource();
      System.out.println("\t\tBigquery Source");
      System.out.format("\t\t\tInput Uri: %s\n", bigquerySource.getInputUri());

      OutputConfig outputConfig = batchPredictionJob.getOutputConfig();
      System.out.println("\tOutput Config");
      System.out.format("\t\tPredictions Format: %s\n", outputConfig.getPredictionsFormat());

      GcsDestination gcsDestination = outputConfig.getGcsDestination();
      System.out.println("\t\tGcs Destination");
      System.out.format("\t\t\tOutput Uri Prefix: %s\n", gcsDestination.getOutputUriPrefix());

      BigQueryDestination bigqueryDestination = outputConfig.getBigqueryDestination();
      System.out.println("\t\tBigquery Destination");
      System.out.format("\t\t\tOutput Uri: %s\n", bigqueryDestination.getOutputUri());

      OutputInfo outputInfo = batchPredictionJob.getOutputInfo();
      System.out.println("\tOutput Info");
      System.out.format("\t\tGcs Output Directory: %s\n", outputInfo.getGcsOutputDirectory());
      System.out.format("\t\tBigquery Output Dataset: %s\n", outputInfo.getBigqueryOutputDataset());

      Status status = batchPredictionJob.getError();
      System.out.println("\tError");
      System.out.format("\t\tCode: %s\n", status.getCode());
      System.out.format("\t\tMessage: %s\n", status.getMessage());

      List<Any> detailsList = status.getDetailsList();

      for (Status partialFailure : batchPredictionJob.getPartialFailuresList()) {
        System.out.println("\tPartial Failure");
        System.out.format("\t\tCode: %s\n", partialFailure.getCode());
        System.out.format("\t\tMessage: %s\n", partialFailure.getMessage());
        List<Any> details = partialFailure.getDetailsList();
      }

      ResourcesConsumed resourcesConsumed = batchPredictionJob.getResourcesConsumed();
      System.out.println("\tResources Consumed");
      System.out.format("\t\tReplica Hours: %s\n", resourcesConsumed.getReplicaHours());

      CompletionStats completionStats = batchPredictionJob.getCompletionStats();
      System.out.println("\tCompletion Stats");
      System.out.format("\t\tSuccessful Count: %s\n", completionStats.getSuccessfulCount());
      System.out.format("\t\tFailed Count: %s\n", completionStats.getFailedCount());
      System.out.format("\t\tIncomplete Count: %s\n", completionStats.getIncompleteCount());
    }
  }
}
// [END aiplatform_get_batch_prediction_job_sample]
