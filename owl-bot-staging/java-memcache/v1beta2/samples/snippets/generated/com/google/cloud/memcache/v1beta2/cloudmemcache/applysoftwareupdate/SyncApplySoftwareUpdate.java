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

package com.google.cloud.memcache.v1beta2.samples;

// [START memcache_v1beta2_generated_CloudMemcache_ApplySoftwareUpdate_sync]
import com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest;
import com.google.cloud.memcache.v1beta2.CloudMemcacheClient;
import com.google.cloud.memcache.v1beta2.Instance;
import com.google.cloud.memcache.v1beta2.InstanceName;
import java.util.ArrayList;

public class SyncApplySoftwareUpdate {

  public static void main(String[] args) throws Exception {
    syncApplySoftwareUpdate();
  }

  public static void syncApplySoftwareUpdate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
      ApplySoftwareUpdateRequest request =
          ApplySoftwareUpdateRequest.newBuilder()
              .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .addAllNodeIds(new ArrayList<String>())
              .setApplyAll(true)
              .build();
      Instance response = cloudMemcacheClient.applySoftwareUpdateAsync(request).get();
    }
  }
}
// [END memcache_v1beta2_generated_CloudMemcache_ApplySoftwareUpdate_sync]
