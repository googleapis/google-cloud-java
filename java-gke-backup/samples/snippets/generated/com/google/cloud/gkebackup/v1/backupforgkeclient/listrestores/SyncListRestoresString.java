/*
 * Copyright 2022 Google LLC
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

// [START gkebackup_v1_generated_backupforgkeclient_listrestores_string_sync]
import com.google.cloud.gkebackup.v1.BackupForGKEClient;
import com.google.cloud.gkebackup.v1.Restore;
import com.google.cloud.gkebackup.v1.RestorePlanName;

public class SyncListRestoresString {

  public static void main(String[] args) throws Exception {
    syncListRestoresString();
  }

  public static void syncListRestoresString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
      String parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
      for (Restore element : backupForGKEClient.listRestores(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END gkebackup_v1_generated_backupforgkeclient_listrestores_string_sync]
