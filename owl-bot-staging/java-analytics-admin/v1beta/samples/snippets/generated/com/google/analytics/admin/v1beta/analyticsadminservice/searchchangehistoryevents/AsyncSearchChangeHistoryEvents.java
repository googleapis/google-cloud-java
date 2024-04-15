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

package com.google.analytics.admin.v1beta.samples;

// [START analyticsadmin_v1beta_generated_AnalyticsAdminService_SearchChangeHistoryEvents_async]
import com.google.analytics.admin.v1beta.AccountName;
import com.google.analytics.admin.v1beta.ActionType;
import com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1beta.ChangeHistoryEvent;
import com.google.analytics.admin.v1beta.ChangeHistoryResourceType;
import com.google.analytics.admin.v1beta.PropertyName;
import com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest;
import com.google.api.core.ApiFuture;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncSearchChangeHistoryEvents {

  public static void main(String[] args) throws Exception {
    asyncSearchChangeHistoryEvents();
  }

  public static void asyncSearchChangeHistoryEvents() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      SearchChangeHistoryEventsRequest request =
          SearchChangeHistoryEventsRequest.newBuilder()
              .setAccount(AccountName.of("[ACCOUNT]").toString())
              .setProperty(PropertyName.of("[PROPERTY]").toString())
              .addAllResourceType(new ArrayList<ChangeHistoryResourceType>())
              .addAllAction(new ArrayList<ActionType>())
              .addAllActorEmail(new ArrayList<String>())
              .setEarliestChangeTime(Timestamp.newBuilder().build())
              .setLatestChangeTime(Timestamp.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<ChangeHistoryEvent> future =
          analyticsAdminServiceClient.searchChangeHistoryEventsPagedCallable().futureCall(request);
      // Do something.
      for (ChangeHistoryEvent element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END analyticsadmin_v1beta_generated_AnalyticsAdminService_SearchChangeHistoryEvents_async]
