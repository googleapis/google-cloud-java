/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dlp.snippets;

// [START dlp_k_map]

import com.google.api.core.SettableApiFuture;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.privacy.dlp.v2.Action;
import com.google.privacy.dlp.v2.Action.PublishToPubSub;
import com.google.privacy.dlp.v2.AnalyzeDataSourceRiskDetails.KMapEstimationResult;
import com.google.privacy.dlp.v2.AnalyzeDataSourceRiskDetails.KMapEstimationResult.KMapEstimationHistogramBucket;
import com.google.privacy.dlp.v2.AnalyzeDataSourceRiskDetails.KMapEstimationResult.KMapEstimationQuasiIdValues;
import com.google.privacy.dlp.v2.BigQueryTable;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.FieldId;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.PrivacyMetric;
import com.google.privacy.dlp.v2.PrivacyMetric.KMapEstimationConfig;
import com.google.privacy.dlp.v2.PrivacyMetric.KMapEstimationConfig.TaggedField;
import com.google.privacy.dlp.v2.RiskAnalysisJobConfig;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
class RiskAnalysisKMap {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String datasetId = "your-bigquery-dataset-id";
    String tableId = "your-bigquery-table-id";
    String topicId = "pub-sub-topic";
    String subscriptionId = "pub-sub-subscription";
    calculateKMap(projectId, datasetId, tableId, topicId, subscriptionId);
  }

  public static void calculateKMap(
      String projectId, String datasetId, String tableId, String topicId, String subscriptionId)
      throws ExecutionException, InterruptedException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // Specify the BigQuery table to analyze
      BigQueryTable bigQueryTable =
          BigQueryTable.newBuilder()
              .setProjectId(projectId)
              .setDatasetId(datasetId)
              .setTableId(tableId)
              .build();

      // These values represent the column names of quasi-identifiers to analyze
      List<String> quasiIds = Arrays.asList("Age", "Gender");

      // These values represent the info types corresponding to the quasi-identifiers above
      List<String> infoTypeNames = Arrays.asList("AGE", "GENDER");

      // Tag each of the quasiId column names with its corresponding infoType
      List<InfoType> infoTypes =
          infoTypeNames.stream()
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      if (quasiIds.size() != infoTypes.size()) {
        throw new IllegalArgumentException("The numbers of quasi-IDs and infoTypes must be equal!");
      }

      List<TaggedField> taggedFields = new ArrayList<TaggedField>();
      for (int i = 0; i < quasiIds.size(); i++) {
        TaggedField taggedField =
            TaggedField.newBuilder()
                .setField(FieldId.newBuilder().setName(quasiIds.get(i)).build())
                .setInfoType(infoTypes.get(i))
                .build();
        taggedFields.add(taggedField);
      }

      // The k-map distribution region can be specified by any ISO-3166-1 region code.
      String regionCode = "US";

      // Configure the privacy metric for the job
      KMapEstimationConfig kmapConfig =
          KMapEstimationConfig.newBuilder()
              .addAllQuasiIds(taggedFields)
              .setRegionCode(regionCode)
              .build();
      PrivacyMetric privacyMetric =
          PrivacyMetric.newBuilder().setKMapEstimationConfig(kmapConfig).build();

      // Create action to publish job status notifications over Google Cloud Pub/Sub
      ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
      PublishToPubSub publishToPubSub =
          PublishToPubSub.newBuilder().setTopic(topicName.toString()).build();
      Action action = Action.newBuilder().setPubSub(publishToPubSub).build();

      // Configure the risk analysis job to perform
      RiskAnalysisJobConfig riskAnalysisJobConfig =
          RiskAnalysisJobConfig.newBuilder()
              .setSourceTable(bigQueryTable)
              .setPrivacyMetric(privacyMetric)
              .addActions(action)
              .build();

      // Build the request to be sent by the client
      CreateDlpJobRequest createDlpJobRequest =
          CreateDlpJobRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setRiskJob(riskAnalysisJobConfig)
              .build();

      // Send the request to the API using the client
      DlpJob dlpJob = dlpServiceClient.createDlpJob(createDlpJobRequest);

      // Set up a Pub/Sub subscriber to listen on the job completion status
      final SettableApiFuture<Boolean> done = SettableApiFuture.create();

      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      MessageReceiver messageHandler =
          (PubsubMessage pubsubMessage, AckReplyConsumer ackReplyConsumer) -> {
            handleMessage(dlpJob, done, pubsubMessage, ackReplyConsumer);
          };
      Subscriber subscriber = Subscriber.newBuilder(subscriptionName, messageHandler).build();
      subscriber.startAsync();

      // Wait for job completion semi-synchronously
      // For long jobs, consider using a truly asynchronous execution model such as Cloud Functions
      try {
        done.get(15, TimeUnit.MINUTES);
      } catch (TimeoutException e) {
        System.out.println("Job was not completed after 15 minutes.");
        return;
      } finally {
        subscriber.stopAsync();
        subscriber.awaitTerminated();
      }

      // Build a request to get the completed job
      GetDlpJobRequest getDlpJobRequest =
          GetDlpJobRequest.newBuilder().setName(dlpJob.getName()).build();

      // Retrieve completed job status
      DlpJob completedJob = dlpServiceClient.getDlpJob(getDlpJobRequest);
      System.out.println("Job status: " + completedJob.getState());

      // Get the result and parse through and process the information
      KMapEstimationResult kmapResult = completedJob.getRiskDetails().getKMapEstimationResult();

      for (KMapEstimationHistogramBucket result : kmapResult.getKMapEstimationHistogramList()) {
        System.out.printf(
            "\tAnonymity range: [%d, %d]\n", result.getMinAnonymity(), result.getMaxAnonymity());
        System.out.printf("\tSize: %d\n", result.getBucketSize());

        for (KMapEstimationQuasiIdValues valueBucket : result.getBucketValuesList()) {
          List<String> quasiIdValues =
              valueBucket.getQuasiIdsValuesList().stream()
                  .map(
                      value -> {
                        String s = value.toString();
                        return s.substring(s.indexOf(':') + 1).trim();
                      })
                  .collect(Collectors.toList());

          System.out.printf("\tValues: {%s}\n", String.join(", ", quasiIdValues));
          System.out.printf(
              "\tEstimated k-map anonymity: %d\n", valueBucket.getEstimatedAnonymity());
        }
      }
    }
  }

  // handleMessage injects the job and settableFuture into the message reciever interface
  private static void handleMessage(
      DlpJob job,
      SettableApiFuture<Boolean> done,
      PubsubMessage pubsubMessage,
      AckReplyConsumer ackReplyConsumer) {
    String messageAttribute = pubsubMessage.getAttributesMap().get("DlpJobName");
    if (job.getName().equals(messageAttribute)) {
      done.set(true);
      ackReplyConsumer.ack();
    } else {
      ackReplyConsumer.nack();
    }
  }
}
// [END dlp_k_map]
