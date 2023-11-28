/*
 * Copyright 2023 Google LLC
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

package google.cloud.edgenetwork.v1.samples;

// [START edgenetwork_v1_generated_EdgeNetwork_Create_SetCredentialsProvider1_sync]
import google.cloud.edgenetwork.v1.EdgeNetworkClient;
import google.cloud.edgenetwork.v1.EdgeNetworkSettings;

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
    EdgeNetworkSettings edgeNetworkSettings = EdgeNetworkSettings.newHttpJsonBuilder().build();
    EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create(edgeNetworkSettings);
  }
}
// [END edgenetwork_v1_generated_EdgeNetwork_Create_SetCredentialsProvider1_sync]
