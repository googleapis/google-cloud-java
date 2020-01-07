/*
 * Copyright 2019 Google LLC
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

// [START dlp_inspect_bigquery]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.common.util.concurrent.SettableFuture;
import com.google.privacy.dlp.v2.Action;
import com.google.privacy.dlp.v2.BigQueryOptions;
import com.google.privacy.dlp.v2.BigQueryTable;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InfoTypeStats;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectDataSourceDetails;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InspectBigQueryTable {

  public static void inspectBigQueryTable()
      throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String bigQueryDatasetId = "your-bigquery-dataset-id";
    String bigQueryTableId = "your-bigquery-table-id";
    String pubSubTopicId = "your-pubsub-topic-id";
    String pubSubSubscriptionId = "your-pubsub-subscription-id";
    inspectBigQueryTable(
        projectId, bigQueryDatasetId, bigQueryTableId, pubSubTopicId, pubSubSubscriptionId);
  }

  // Inspects a BigQuery Table
  public static void inspectBigQueryTable(
      String projectId,
      String bigQueryDatasetId,
      String bigQueryTableId,
      String pubSubTopicId,
      String pubSubSubscriptionName)
      throws ExecutionException, InterruptedException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlp = DlpServiceClient.create()) {
      // Specify the BigQuery table to be inspected.
      BigQueryTable tableReference =
          BigQueryTable.newBuilder()
              .setProjectId(projectId)
              .setDatasetId(bigQueryDatasetId)
              .setTableId(bigQueryTableId)
              .build();

      BigQueryOptions bigQueryOptions =
          BigQueryOptions.newBuilder().setTableReference(tableReference).build();

      StorageConfig storageConfig =
          StorageConfig.newBuilder().setBigQueryOptions(bigQueryOptions).build();

      // Specify the type of info the inspection will look for.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      List<InfoType> infoTypes =
          Stream.of("PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER")
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      // Specify how the content should be inspected.
      InspectConfig inspectConfig =
          InspectConfig.newBuilder().addAllInfoTypes(infoTypes).setIncludeQuote(true).build();

      // Specify the action that is triggered when the job completes.
      String pubSubTopic = String.format("projects/%s/topics/%s", projectId, pubSubTopicId);
      Action.PublishToPubSub publishToPubSub =
          Action.PublishToPubSub.newBuilder().setTopic(pubSubTopic).build();
      Action action = Action.newBuilder().setPubSub(publishToPubSub).build();

      // Configure the long running job we want the service to perform.
      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setStorageConfig(storageConfig)
              .setInspectConfig(inspectConfig)
              .addActions(action)
              .build();

      // Create the request for the job configured above.
      CreateDlpJobRequest createDlpJobRequest =
          CreateDlpJobRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setInspectJob(inspectJobConfig)
              .build();

      // Use the client to send the request.
      final DlpJob job = dlp.createDlpJob(createDlpJobRequest);
      System.out.println("Job created: " + job.getName());

      // Set up a Pub/Sub subscriber to listen for the job completion status
      SettableFuture<Void> jobDone = SettableFuture.create();
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, pubSubSubscriptionName);
      MessageReceiver handleMessage =
          (PubsubMessage pubsubMessage, AckReplyConsumer ackReplyConsumer) -> {
            String messageAttribute = pubsubMessage.getAttributesMap().get("DlpJobName");
            if (job.getName().equals(messageAttribute)) {
              jobDone.set(null);
              ackReplyConsumer.ack();
            } else {
              ackReplyConsumer.nack();
            }
          };
      Subscriber subscriber = Subscriber.newBuilder(subscriptionName, handleMessage).build();
      subscriber.startAsync(); // Let the subscriber listen to messages

      // Wait for the original job to complete
      try {
        jobDone.get(10, TimeUnit.MINUTES);
      } catch (TimeoutException e) {
        System.out.println("Job was not completed after 10 minutes.");
        return;
      }

      // Get the latest state of the job from the service
      GetDlpJobRequest request = GetDlpJobRequest.newBuilder().setName(job.getName()).build();
      DlpJob completedJob = dlp.getDlpJob(request);

      // Parse the response and process results.
      System.out.println("Job status: " + completedJob.getState());
      InspectDataSourceDetails.Result result = completedJob.getInspectDetails().getResult();
      System.out.println("Findings: ");
      for (InfoTypeStats infoTypeStat : result.getInfoTypeStatsList()) {
        System.out.print("\tInfo type: " + infoTypeStat.getInfoType().getName());
        System.out.println("\tCount: " + infoTypeStat.getCount());
      }
    }
  }
}
// [END dlp_inspect_bigquery]
