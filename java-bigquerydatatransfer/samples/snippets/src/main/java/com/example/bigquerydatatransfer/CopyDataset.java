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

// [START bigquerydatatransfer_copy_dataset]
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

// Sample to copy dataset from another gcp project
public class CopyDataset {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String destinationProjectId = "MY_DESTINATION_PROJECT_ID";
    final String destinationDatasetId = "MY_DESTINATION_DATASET_ID";
    final String sourceProjectId = "MY_SOURCE_PROJECT_ID";
    final String sourceDatasetId = "MY_SOURCE_DATASET_ID";
    Map<String, Value> params = new HashMap<>();
    params.put("source_project_id", Value.newBuilder().setStringValue(sourceProjectId).build());
    params.put("source_dataset_id", Value.newBuilder().setStringValue(sourceDatasetId).build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(destinationDatasetId)
            .setDisplayName("Your Dataset Copy Name")
            .setDataSourceId("cross_region_copy")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .build();
    copyDataset(destinationProjectId, transferConfig);
  }

  public static void copyDataset(String projectId, TransferConfig transferConfig)
      throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      CreateTransferConfigRequest request =
          CreateTransferConfigRequest.newBuilder()
              .setParent(parent.toString())
              .setTransferConfig(transferConfig)
              .build();
      TransferConfig config = dataTransferServiceClient.createTransferConfig(request);
      System.out.println("Copy dataset created successfully :" + config.getName());
    } catch (ApiException ex) {
      System.out.print("Copy dataset was not created." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_copy_dataset]
