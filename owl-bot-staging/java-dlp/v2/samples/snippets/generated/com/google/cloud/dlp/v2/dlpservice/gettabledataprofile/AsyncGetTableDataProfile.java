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

package com.google.cloud.dlp.v2.samples;

// [START dlp_v2_generated_DlpService_GetTableDataProfile_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.GetTableDataProfileRequest;
import com.google.privacy.dlp.v2.TableDataProfile;
import com.google.privacy.dlp.v2.TableDataProfileName;

public class AsyncGetTableDataProfile {

  public static void main(String[] args) throws Exception {
    asyncGetTableDataProfile();
  }

  public static void asyncGetTableDataProfile() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      GetTableDataProfileRequest request =
          GetTableDataProfileRequest.newBuilder()
              .setName(
                  TableDataProfileName.ofOrganizationLocationTableDataProfileName(
                          "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]")
                      .toString())
              .build();
      ApiFuture<TableDataProfile> future =
          dlpServiceClient.getTableDataProfileCallable().futureCall(request);
      // Do something.
      TableDataProfile response = future.get();
    }
  }
}
// [END dlp_v2_generated_DlpService_GetTableDataProfile_async]
