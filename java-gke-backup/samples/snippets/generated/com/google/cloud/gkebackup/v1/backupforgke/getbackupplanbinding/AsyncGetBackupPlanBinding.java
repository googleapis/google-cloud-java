/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.gkebackup.v1.samples;

// [START gkebackup_v1_generated_BackupForGKE_GetBackupPlanBinding_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gkebackup.v1.BackupForGKEClient;
import com.google.cloud.gkebackup.v1.BackupPlanBinding;
import com.google.cloud.gkebackup.v1.BackupPlanBindingName;
import com.google.cloud.gkebackup.v1.GetBackupPlanBindingRequest;

public class AsyncGetBackupPlanBinding {

  public static void main(String[] args) throws Exception {
    asyncGetBackupPlanBinding();
  }

  public static void asyncGetBackupPlanBinding() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
      GetBackupPlanBindingRequest request =
          GetBackupPlanBindingRequest.newBuilder()
              .setName(
                  BackupPlanBindingName.of(
                          "[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]", "[BACKUP_PLAN_BINDING]")
                      .toString())
              .build();
      ApiFuture<BackupPlanBinding> future =
          backupForGKEClient.getBackupPlanBindingCallable().futureCall(request);
      // Do something.
      BackupPlanBinding response = future.get();
    }
  }
}
// [END gkebackup_v1_generated_BackupForGKE_GetBackupPlanBinding_async]
