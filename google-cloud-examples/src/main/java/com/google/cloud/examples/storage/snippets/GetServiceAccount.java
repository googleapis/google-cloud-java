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
package com.google.cloud.examples.storage.snippets;

// [START storage_get_service_account]
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GetServiceAccount {
  public static void getServiceAccount(String projectId) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    ServiceAccount serviceAccount = storage.getServiceAccount(projectId);
    System.out.println(
        "The GCS service account for project " + projectId + " is: " + serviceAccount.getEmail());
  }
}
// [END storage_get_service_account]
