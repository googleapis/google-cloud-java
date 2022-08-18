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

package com.google.cloud.ids.v1.samples;

// [START ids_v1_generated_idsclient_createendpoint_stringendpointstring_sync]
import com.google.cloud.ids.v1.Endpoint;
import com.google.cloud.ids.v1.IDSClient;
import com.google.cloud.ids.v1.LocationName;

public class SyncCreateEndpointStringEndpointString {

  public static void main(String[] args) throws Exception {
    syncCreateEndpointStringEndpointString();
  }

  public static void syncCreateEndpointStringEndpointString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (IDSClient iDSClient = IDSClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      Endpoint response = iDSClient.createEndpointAsync(parent, endpoint, endpointId).get();
    }
  }
}
// [END ids_v1_generated_idsclient_createendpoint_stringendpointstring_sync]
