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

package com.google.cloud.dialogflow.cx.v3beta1.samples;

// [START dialogflow_v3beta1_generated_Playbooks_ExportPlaybook_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.cx.v3beta1.ExportPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybookName;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient;
import com.google.longrunning.Operation;

public class AsyncExportPlaybook {

  public static void main(String[] args) throws Exception {
    asyncExportPlaybook();
  }

  public static void asyncExportPlaybook() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PlaybooksClient playbooksClient = PlaybooksClient.create()) {
      ExportPlaybookRequest request =
          ExportPlaybookRequest.newBuilder()
              .setName(
                  PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
              .setPlaybookUri("playbookUri2118184975")
              .build();
      ApiFuture<Operation> future = playbooksClient.exportPlaybookCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END dialogflow_v3beta1_generated_Playbooks_ExportPlaybook_async]
