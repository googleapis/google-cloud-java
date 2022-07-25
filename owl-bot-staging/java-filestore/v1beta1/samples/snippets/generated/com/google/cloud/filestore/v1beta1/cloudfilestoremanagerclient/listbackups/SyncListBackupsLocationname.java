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

package com.google.cloud.filestore.v1beta1.samples;

// [START filestore_v1beta1_generated_cloudfilestoremanagerclient_listbackups_locationname_sync]
import com.google.cloud.filestore.v1beta1.Backup;
import com.google.cloud.filestore.v1beta1.CloudFilestoreManagerClient;
import com.google.cloud.filestore.v1beta1.LocationName;

public class SyncListBackupsLocationname {

  public static void main(String[] args) throws Exception {
    syncListBackupsLocationname();
  }

  public static void syncListBackupsLocationname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CloudFilestoreManagerClient cloudFilestoreManagerClient =
        CloudFilestoreManagerClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      for (Backup element : cloudFilestoreManagerClient.listBackups(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END filestore_v1beta1_generated_cloudfilestoremanagerclient_listbackups_locationname_sync]
