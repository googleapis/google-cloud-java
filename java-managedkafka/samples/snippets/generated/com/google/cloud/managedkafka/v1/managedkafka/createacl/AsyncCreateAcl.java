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

// [START managedkafka_v1_generated_ManagedKafka_CreateAcl_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.managedkafka.v1.Acl;
import com.google.cloud.managedkafka.v1.ClusterName;
import com.google.cloud.managedkafka.v1.CreateAclRequest;
import com.google.cloud.managedkafka.v1.ManagedKafkaClient;

public class AsyncCreateAcl {

  public static void main(String[] args) throws Exception {
    asyncCreateAcl();
  }

  public static void asyncCreateAcl() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
      CreateAclRequest request =
          CreateAclRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setAclId("aclId92636997")
              .setAcl(Acl.newBuilder().build())
              .build();
      ApiFuture<Acl> future = managedKafkaClient.createAclCallable().futureCall(request);
      // Do something.
      Acl response = future.get();
    }
  }
}
// [END managedkafka_v1_generated_ManagedKafka_CreateAcl_async]
