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

package com.google.cloud.cloudsecuritycompliance.v1.samples;

// [START cloudsecuritycompliance_v1_generated_Audit_ListFrameworkAudits_Paged_async]
import com.google.cloud.cloudsecuritycompliance.v1.AuditClient;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.LocationName;
import com.google.common.base.Strings;

public class AsyncListFrameworkAuditsPaged {

  public static void main(String[] args) throws Exception {
    asyncListFrameworkAuditsPaged();
  }

  public static void asyncListFrameworkAuditsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AuditClient auditClient = AuditClient.create()) {
      ListFrameworkAuditsRequest request =
          ListFrameworkAuditsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListFrameworkAuditsResponse response =
            auditClient.listFrameworkAuditsCallable().call(request);
        for (FrameworkAudit element : response.getFrameworkAuditsList()) {
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
// [END cloudsecuritycompliance_v1_generated_Audit_ListFrameworkAudits_Paged_async]
