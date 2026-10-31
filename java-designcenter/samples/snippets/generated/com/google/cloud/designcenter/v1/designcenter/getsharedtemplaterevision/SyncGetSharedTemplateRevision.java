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

package com.google.cloud.designcenter.v1.samples;

// [START designcenter_v1_generated_DesignCenter_GetSharedTemplateRevision_sync]
import com.google.cloud.designcenter.v1.DesignCenterClient;
import com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.SharedTemplateRevision;
import com.google.cloud.designcenter.v1.SharedTemplateRevisionName;

public class SyncGetSharedTemplateRevision {

  public static void main(String[] args) throws Exception {
    syncGetSharedTemplateRevision();
  }

  public static void syncGetSharedTemplateRevision() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
      GetSharedTemplateRevisionRequest request =
          GetSharedTemplateRevisionRequest.newBuilder()
              .setName(
                  SharedTemplateRevisionName.of(
                          "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
                      .toString())
              .build();
      SharedTemplateRevision response = designCenterClient.getSharedTemplateRevision(request);
    }
  }
}
// [END designcenter_v1_generated_DesignCenter_GetSharedTemplateRevision_sync]
