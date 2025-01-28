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

package com.google.cloud.redis.cluster.v1.samples;

// [START redis_v1_generated_CloudRedisCluster_RescheduleClusterMaintenance_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.redis.cluster.v1.CloudRedisClusterClient;
import com.google.cloud.redis.cluster.v1.Cluster;
import com.google.cloud.redis.cluster.v1.ClusterName;
import com.google.cloud.redis.cluster.v1.RescheduleClusterMaintenanceRequest;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;

public class AsyncRescheduleClusterMaintenanceLRO {

  public static void main(String[] args) throws Exception {
    asyncRescheduleClusterMaintenanceLRO();
  }

  public static void asyncRescheduleClusterMaintenanceLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
      RescheduleClusterMaintenanceRequest request =
          RescheduleClusterMaintenanceRequest.newBuilder()
              .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setScheduleTime(Timestamp.newBuilder().build())
              .build();
      OperationFuture<Cluster, Any> future =
          cloudRedisClusterClient
              .rescheduleClusterMaintenanceOperationCallable()
              .futureCall(request);
      // Do something.
      Cluster response = future.get();
    }
  }
}
// [END redis_v1_generated_CloudRedisCluster_RescheduleClusterMaintenance_LRO_async]
