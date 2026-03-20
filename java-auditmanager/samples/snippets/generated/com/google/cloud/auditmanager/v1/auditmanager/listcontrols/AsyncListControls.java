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

package com.google.cloud.auditmanager.v1.samples;

// [START auditmanager_v1_generated_AuditManager_ListControls_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.auditmanager.v1.AuditManagerClient;
import com.google.cloud.auditmanager.v1.Control;
import com.google.cloud.auditmanager.v1.ListControlsRequest;
import com.google.cloud.auditmanager.v1.StandardName;

public class AsyncListControls {

  public static void main(String[] args) throws Exception {
    asyncListControls();
  }

  public static void asyncListControls() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
      ListControlsRequest request =
          ListControlsRequest.newBuilder()
              .setParent(
                  StandardName.ofOrganizationLocationStandardName(
                          "[ORGANIZATION]", "[LOCATION]", "[STANDARD]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Control> future =
          auditManagerClient.listControlsPagedCallable().futureCall(request);
      // Do something.
      for (Control element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END auditmanager_v1_generated_AuditManager_ListControls_async]
