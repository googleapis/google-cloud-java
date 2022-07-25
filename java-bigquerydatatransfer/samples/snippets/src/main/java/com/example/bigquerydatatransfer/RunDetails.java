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

// [START bigquerydatatransfer_get_run_details]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import java.io.IOException;

// Sample to get run details from transfer config.
public class RunDetails {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // runId examples:
    // `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or
    // `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`
    String runId = "MY_RUN_ID";
    runDetails(runId);
  }

  public static void runDetails(String runId) throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      GetTransferRunRequest request = GetTransferRunRequest.newBuilder().setName(runId).build();
      TransferRun run = dataTransferServiceClient.getTransferRun(request);
      System.out.print("Run details retrieved successfully :" + run.getName() + "\n");
    } catch (ApiException ex) {
      System.out.print("Run details not found." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_get_run_details]
