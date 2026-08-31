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

package com.google.cloud.apptopology.v1.samples;

// [START apptopology_v1_generated_AppTopology_GenerateDiscoveredResourcesTopology_DiscoveredresourcestopologynameListstring_sync]
import com.google.cloud.apptopology.v1.AppTopologyClient;
import com.google.cloud.apptopology.v1.DiscoveredResourcesTopologyName;
import com.google.cloud.apptopology.v1.GenerateDiscoveredResourcesTopologyResponse;
import java.util.ArrayList;
import java.util.List;

public class SyncGenerateDiscoveredResourcesTopologyDiscoveredresourcestopologynameListstring {

  public static void main(String[] args) throws Exception {
    syncGenerateDiscoveredResourcesTopologyDiscoveredresourcestopologynameListstring();
  }

  public static void
      syncGenerateDiscoveredResourcesTopologyDiscoveredresourcestopologynameListstring()
          throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
      DiscoveredResourcesTopologyName name =
          DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]");
      List<String> topologyDomains = new ArrayList<>();
      GenerateDiscoveredResourcesTopologyResponse response =
          appTopologyClient.generateDiscoveredResourcesTopology(name, topologyDomains);
    }
  }
}
// [END apptopology_v1_generated_AppTopology_GenerateDiscoveredResourcesTopology_DiscoveredresourcestopologynameListstring_sync]
