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

// [START bigquerydatatransfer_get_run_history]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest;
import java.io.IOException;

// Sample to get run history from transfer config.
public class RunHistory {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String configId = "MY_CONFIG_ID";
    // i.e projects/{project_id}/transferConfigs/{config_id}` or
    // `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`
    runHistory(configId);
  }

  public static void runHistory(String configId) throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ListTransferRunsRequest request =
          ListTransferRunsRequest.newBuilder().setParent(configId).build();
      dataTransferServiceClient
          .listTransferRuns(request)
          .iterateAll()
          .forEach(run -> System.out.print("Success! Run ID :" + run.getName() + "\n"));
    } catch (ApiException ex) {
      System.out.println("Run history not found due to error." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_get_run_history]
