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

// [START bigquerydatatransfer_create_play_transfer]
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

// Sample to create a play transfer config.
public class CreatePlayTransfer {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "MY_PROJECT_ID";
    String datasetId = "MY_DATASET_ID";
    String bucket = "gs://cloud-sample-data";
    String tableSuffix = "_test";
    Map<String, Value> params = new HashMap<>();
    params.put("bucket", Value.newBuilder().setStringValue(bucket).build());
    params.put("table_suffix", Value.newBuilder().setStringValue(tableSuffix).build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetId)
            .setDisplayName("Your Play Config Name")
            .setDataSourceId("play")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .build();
    createPlayTransfer(projectId, transferConfig);
  }

  public static void createPlayTransfer(String projectId, TransferConfig transferConfig)
      throws IOException {
    try (DataTransferServiceClient client = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      CreateTransferConfigRequest request =
          CreateTransferConfigRequest.newBuilder()
              .setParent(parent.toString())
              .setTransferConfig(transferConfig)
              .build();
      TransferConfig config = client.createTransferConfig(request);
      System.out.println("play transfer created successfully :" + config.getName());
    } catch (ApiException ex) {
      System.out.print("play transfer was not created." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_create_play_transfer]
