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

// [START managedkafka_v1_generated_ManagedKafkaConnect_UpdateConnector_sync]
import com.google.cloud.managedkafka.v1.Connector;
import com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient;
import com.google.cloud.managedkafka.v1.UpdateConnectorRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateConnector {

  public static void main(String[] args) throws Exception {
    syncUpdateConnector();
  }

  public static void syncUpdateConnector() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
      UpdateConnectorRequest request =
          UpdateConnectorRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setConnector(Connector.newBuilder().build())
              .build();
      Connector response = managedKafkaConnectClient.updateConnector(request);
    }
  }
}
// [END managedkafka_v1_generated_ManagedKafkaConnect_UpdateConnector_sync]
