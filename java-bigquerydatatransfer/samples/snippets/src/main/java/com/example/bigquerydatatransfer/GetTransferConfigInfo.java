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

// [START bigquerydatatransfer_get_config_info]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import java.io.IOException;

// Sample to get config info.
public class GetTransferConfigInfo {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String configId = "MY_CONFIG_ID";
    // i.e projects/{project_id}/transferConfigs/{config_id}` or
    // `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`
    getTransferConfigInfo(configId);
  }

  public static void getTransferConfigInfo(String configId) throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      GetTransferConfigRequest request =
          GetTransferConfigRequest.newBuilder().setName(configId).build();
      TransferConfig info = dataTransferServiceClient.getTransferConfig(request);
      System.out.print("Config info retrieved successfully." + info.getName() + "\n");
    } catch (ApiException ex) {
      System.out.print("config not found." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_get_config_info]
