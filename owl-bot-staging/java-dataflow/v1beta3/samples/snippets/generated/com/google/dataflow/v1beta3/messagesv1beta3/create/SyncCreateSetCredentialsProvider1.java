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

package com.google.dataflow.v1beta3.samples;

// [START dataflow_v1beta3_generated_MessagesV1Beta3_Create_SetCredentialsProvider1_sync]
import com.google.dataflow.v1beta3.MessagesV1Beta3Client;
import com.google.dataflow.v1beta3.MessagesV1Beta3Settings;

public class SyncCreateSetCredentialsProvider1 {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider1();
  }

  public static void syncCreateSetCredentialsProvider1() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    MessagesV1Beta3Settings messagesV1Beta3Settings =
        MessagesV1Beta3Settings.newHttpJsonBuilder().build();
    MessagesV1Beta3Client messagesV1Beta3Client =
        MessagesV1Beta3Client.create(messagesV1Beta3Settings);
  }
}
// [END dataflow_v1beta3_generated_MessagesV1Beta3_Create_SetCredentialsProvider1_sync]
