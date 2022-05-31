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

package com.example.bigquerydatatransfer;

// [START bigquerydatatransfer_run_notification]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ProjectName;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Sample to get run notification
public class RunNotification {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "MY_PROJECT_ID";
    final String datasetId = "MY_DATASET_ID";
    final String pubsubTopicName = "MY_TOPIC_NAME";
    final String query =
        "SELECT CURRENT_TIMESTAMP() as current_time, @run_time as intended_run_time, "
            + "@run_date as intended_run_date, 17 as some_integer";
    Map<String, Value> params = new HashMap<>();
    params.put("query", Value.newBuilder().setStringValue(query).build());
    params.put(
        "destination_table_name_template",
        Value.newBuilder().setStringValue("my_destination_table_{run_date}").build());
    params.put("write_disposition", Value.newBuilder().setStringValue("WRITE_TRUNCATE").build());
    params.put("partitioning_field", Value.newBuilder().build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetId)
            .setDisplayName("Your Scheduled Query Name")
            .setDataSourceId("scheduled_query")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .setNotificationPubsubTopic(pubsubTopicName)
            .build();
    runNotification(projectId, transferConfig);
  }

  public static void runNotification(String projectId, TransferConfig transferConfig)
      throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      CreateTransferConfigRequest request =
          CreateTransferConfigRequest.newBuilder()
              .setParent(parent.toString())
              .setTransferConfig(transferConfig)
              .build();
      TransferConfig config = dataTransferServiceClient.createTransferConfig(request);
      System.out.println(
          "\nScheduled query with run notification created successfully :" + config.getName());
    } catch (ApiException ex) {
      System.out.print("\nScheduled query with run notification was not created." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_run_notification]
