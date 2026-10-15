/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.memorystore.v1beta.samples;

// [START memorystore_v1beta_generated_Memorystore_CreateAclPolicy_LocationnameAclpolicyString_sync]
import com.google.cloud.memorystore.v1beta.AclPolicy;
import com.google.cloud.memorystore.v1beta.LocationName;
import com.google.cloud.memorystore.v1beta.MemorystoreClient;

public class SyncCreateAclPolicyLocationnameAclpolicyString {

  public static void main(String[] args) throws Exception {
    syncCreateAclPolicyLocationnameAclpolicyString();
  }

  public static void syncCreateAclPolicyLocationnameAclpolicyString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AclPolicy aclPolicy = AclPolicy.newBuilder().build();
      String aclPolicyId = "aclPolicyId-1805591401";
      AclPolicy response = memorystoreClient.createAclPolicy(parent, aclPolicy, aclPolicyId);
    }
  }
}
// [END memorystore_v1beta_generated_Memorystore_CreateAclPolicy_LocationnameAclpolicyString_sync]
