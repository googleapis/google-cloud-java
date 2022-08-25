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

// [START bigquerydatatransfer_list_configs]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ProjectName;
import java.io.IOException;

// Sample to get list of transfer config
public class ListTransferConfigs {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "MY_PROJECT_ID";
    listTransferConfigs(projectId);
  }

  public static void listTransferConfigs(String projectId) throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      ListTransferConfigsRequest request =
          ListTransferConfigsRequest.newBuilder().setParent(parent.toString()).build();
      dataTransferServiceClient
          .listTransferConfigs(request)
          .iterateAll()
          .forEach(config -> System.out.print("Success! Config ID :" + config.getName() + "\n"));
    } catch (ApiException ex) {
      System.out.println("Config list not found due to error." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_list_configs]
