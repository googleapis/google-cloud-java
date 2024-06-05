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

package google.maps.fleetengine.delivery.v1.samples;

// [START fleetengine_v1_generated_DeliveryService_CreateTask_async]
import com.google.api.core.ApiFuture;
import google.maps.fleetengine.delivery.v1.CreateTaskRequest;
import google.maps.fleetengine.delivery.v1.DeliveryRequestHeader;
import google.maps.fleetengine.delivery.v1.DeliveryServiceClient;
import google.maps.fleetengine.delivery.v1.Task;

public class AsyncCreateTask {

  public static void main(String[] args) throws Exception {
    asyncCreateTask();
  }

  public static void asyncCreateTask() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
      CreateTaskRequest request =
          CreateTaskRequest.newBuilder()
              .setHeader(DeliveryRequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setTaskId("taskId-880873088")
              .setTask(Task.newBuilder().build())
              .build();
      ApiFuture<Task> future = deliveryServiceClient.createTaskCallable().futureCall(request);
      // Do something.
      Task response = future.get();
    }
  }
}
// [END fleetengine_v1_generated_DeliveryService_CreateTask_async]
