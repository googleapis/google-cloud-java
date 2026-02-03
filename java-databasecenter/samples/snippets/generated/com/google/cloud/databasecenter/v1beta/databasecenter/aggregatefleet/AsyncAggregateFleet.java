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

package com.google.cloud.databasecenter.v1beta.samples;

// [START databasecenter_v1beta_generated_DatabaseCenter_AggregateFleet_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.databasecenter.v1beta.AggregateFleetRequest;
import com.google.cloud.databasecenter.v1beta.AggregateFleetRow;
import com.google.cloud.databasecenter.v1beta.DatabaseCenterClient;
import com.google.type.Date;

public class AsyncAggregateFleet {

  public static void main(String[] args) throws Exception {
    asyncAggregateFleet();
  }

  public static void asyncAggregateFleet() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatabaseCenterClient databaseCenterClient = DatabaseCenterClient.create()) {
      AggregateFleetRequest request =
          AggregateFleetRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setGroupBy("groupBy293428022")
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setBaselineDate(Date.newBuilder().build())
              .build();
      ApiFuture<AggregateFleetRow> future =
          databaseCenterClient.aggregateFleetPagedCallable().futureCall(request);
      // Do something.
      for (AggregateFleetRow element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END databasecenter_v1beta_generated_DatabaseCenter_AggregateFleet_async]
