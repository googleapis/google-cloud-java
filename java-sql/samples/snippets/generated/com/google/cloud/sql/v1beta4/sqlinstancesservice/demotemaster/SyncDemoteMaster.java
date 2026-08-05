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

package com.google.cloud.sql.v1beta4.samples;

// [START sqladmin_v1beta4_generated_SqlInstancesService_DemoteMaster_sync]
import com.google.cloud.sql.v1beta4.InstancesDemoteMasterRequest;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlInstancesDemoteMasterRequest;
import com.google.cloud.sql.v1beta4.SqlInstancesServiceClient;

public class SyncDemoteMaster {

  public static void main(String[] args) throws Exception {
    syncDemoteMaster();
  }

  public static void syncDemoteMaster() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
      SqlInstancesDemoteMasterRequest request =
          SqlInstancesDemoteMasterRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesDemoteMasterRequest.newBuilder().build())
              .build();
      Operation response = sqlInstancesServiceClient.demoteMaster(request);
    }
  }
}
// [END sqladmin_v1beta4_generated_SqlInstancesService_DemoteMaster_sync]
