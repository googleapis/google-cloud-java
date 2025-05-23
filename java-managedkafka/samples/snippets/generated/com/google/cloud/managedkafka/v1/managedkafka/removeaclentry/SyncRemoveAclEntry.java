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

package com.google.cloud.managedkafka.v1.samples;

// [START managedkafka_v1_generated_ManagedKafka_RemoveAclEntry_sync]
import com.google.cloud.managedkafka.v1.AclEntry;
import com.google.cloud.managedkafka.v1.AclName;
import com.google.cloud.managedkafka.v1.ManagedKafkaClient;
import com.google.cloud.managedkafka.v1.RemoveAclEntryRequest;
import com.google.cloud.managedkafka.v1.RemoveAclEntryResponse;

public class SyncRemoveAclEntry {

  public static void main(String[] args) throws Exception {
    syncRemoveAclEntry();
  }

  public static void syncRemoveAclEntry() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
      RemoveAclEntryRequest request =
          RemoveAclEntryRequest.newBuilder()
              .setAcl(AclName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ACL]").toString())
              .setAclEntry(AclEntry.newBuilder().build())
              .build();
      RemoveAclEntryResponse response = managedKafkaClient.removeAclEntry(request);
    }
  }
}
// [END managedkafka_v1_generated_ManagedKafka_RemoveAclEntry_sync]
