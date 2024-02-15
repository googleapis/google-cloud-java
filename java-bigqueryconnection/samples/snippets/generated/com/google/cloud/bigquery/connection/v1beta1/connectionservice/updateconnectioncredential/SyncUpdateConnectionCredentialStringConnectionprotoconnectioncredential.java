/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.connection.v1beta1.samples;

// [START bigqueryconnection_v1beta1_generated_ConnectionService_UpdateConnectionCredential_StringConnectionprotoconnectioncredential_sync]
import com.google.cloud.bigquery.connection.v1beta1.ConnectionProto;
import com.google.cloud.bigquery.connection.v1beta1.ConnectionServiceClient;
import com.google.protobuf.Empty;

public class SyncUpdateConnectionCredentialStringConnectionprotoconnectioncredential {

  public static void main(String[] args) throws Exception {
    syncUpdateConnectionCredentialStringConnectionprotoconnectioncredential();
  }

  public static void syncUpdateConnectionCredentialStringConnectionprotoconnectioncredential()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
      String name = "name3373707";
      ConnectionProto.ConnectionCredential credential =
          ConnectionProto.ConnectionCredential.newBuilder().build();
      connectionServiceClient.updateConnectionCredential(name, credential);
    }
  }
}
// [END bigqueryconnection_v1beta1_generated_ConnectionService_UpdateConnectionCredential_StringConnectionprotoconnectioncredential_sync]
