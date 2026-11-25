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

package com.google.cloud.agentregistry.v1.samples;

// [START agentregistry_v1_generated_AgentRegistry_ListSkillRevisions_Paged_async]
import com.google.cloud.agentregistry.v1.AgentRegistryClient;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsRequest;
import com.google.cloud.agentregistry.v1.ListSkillRevisionsResponse;
import com.google.cloud.agentregistry.v1.SkillName;
import com.google.cloud.agentregistry.v1.SkillRevision;
import com.google.common.base.Strings;

public class AsyncListSkillRevisionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSkillRevisionsPaged();
  }

  public static void asyncListSkillRevisionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
      ListSkillRevisionsRequest request =
          ListSkillRevisionsRequest.newBuilder()
              .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSkillRevisionsResponse response =
            agentRegistryClient.listSkillRevisionsCallable().call(request);
        for (SkillRevision element : response.getSkillRevisionsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END agentregistry_v1_generated_AgentRegistry_ListSkillRevisions_Paged_async]
