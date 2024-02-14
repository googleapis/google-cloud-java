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

package com.google.analytics.admin.v1alpha.samples;

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_BatchCreateAccessBindings_sync]
import com.google.analytics.admin.v1alpha.AccountName;
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse;
import com.google.analytics.admin.v1alpha.CreateAccessBindingRequest;
import java.util.ArrayList;

public class SyncBatchCreateAccessBindings {

  public static void main(String[] args) throws Exception {
    syncBatchCreateAccessBindings();
  }

  public static void syncBatchCreateAccessBindings() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      BatchCreateAccessBindingsRequest request =
          BatchCreateAccessBindingsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .addAllRequests(new ArrayList<CreateAccessBindingRequest>())
              .build();
      BatchCreateAccessBindingsResponse response =
          analyticsAdminServiceClient.batchCreateAccessBindings(request);
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_BatchCreateAccessBindings_sync]
