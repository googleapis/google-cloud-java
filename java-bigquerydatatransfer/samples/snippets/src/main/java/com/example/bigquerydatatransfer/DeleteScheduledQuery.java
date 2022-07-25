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

// [START bigquerydatatransfer_delete_scheduled_query]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest;
import java.io.IOException;

// Sample to delete a scheduled query
public class DeleteScheduledQuery {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // i.e projects/{project_id}/transferConfigs/{config_id}` or
    // `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`
    String name = "MY_CONFIG_ID";
    deleteScheduledQuery(name);
  }

  public static void deleteScheduledQuery(String name) throws IOException {
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      DeleteTransferConfigRequest request =
          DeleteTransferConfigRequest.newBuilder().setName(name).build();
      dataTransferServiceClient.deleteTransferConfig(request);
      System.out.print("Scheduled query deleted successfully.\n");
    } catch (ApiException ex) {
      System.out.print("Scheduled query was not deleted." + ex.toString());
    }
  }
}
// [END bigquerydatatransfer_delete_scheduled_query]
