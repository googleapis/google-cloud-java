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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_BreakTemplateService_GetBreakTemplate_sync]
import com.google.ads.admanager.v1.BreakTemplate;
import com.google.ads.admanager.v1.BreakTemplateName;
import com.google.ads.admanager.v1.BreakTemplateServiceClient;
import com.google.ads.admanager.v1.GetBreakTemplateRequest;

public class SyncGetBreakTemplate {

  public static void main(String[] args) throws Exception {
    syncGetBreakTemplate();
  }

  public static void syncGetBreakTemplate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BreakTemplateServiceClient breakTemplateServiceClient =
        BreakTemplateServiceClient.create()) {
      GetBreakTemplateRequest request =
          GetBreakTemplateRequest.newBuilder()
              .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
              .build();
      BreakTemplate response = breakTemplateServiceClient.getBreakTemplate(request);
    }
  }
}
// [END admanager_v1_generated_BreakTemplateService_GetBreakTemplate_sync]
