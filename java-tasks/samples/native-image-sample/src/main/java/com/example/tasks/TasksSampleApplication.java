/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.tasks;

import com.google.cloud.ServiceOptions;
import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.CreateQueueRequest;
import com.google.cloud.tasks.v2.HttpMethod;
import com.google.cloud.tasks.v2.HttpRequest;
import com.google.cloud.tasks.v2.LocationName;
import com.google.cloud.tasks.v2.Queue;
import com.google.cloud.tasks.v2.QueueName;
import com.google.cloud.tasks.v2.RateLimits;
import com.google.cloud.tasks.v2.Task;
import java.io.IOException;
import java.util.UUID;

/** Sample application demonstrating Native Image compatibility with Google Cloud Tasks APIs. */
public class TasksSampleApplication {
  /**
   * Queue name randomness added to avoid FAILED_PRECONDITION: The queue cannot be created because a
   * queue with this name existed too recently.
   */
  private static final String GRAALVM_TEST_QUEUE_NAME = "graal-test-queue-";

  private static final String LOCATION_ID = System.getenv("LOCATION_ID");

  /** Runs the Cloud Tasks sample application. */
  public static void main(String[] args) throws IOException {
    String projectId = ServiceOptions.getDefaultProjectId();
    LocationName parent = LocationName.of(projectId, LOCATION_ID);
    QueueName queueName =
        QueueName.of(
            parent.getProject(),
            parent.getLocation(),
            GRAALVM_TEST_QUEUE_NAME + UUID.randomUUID().toString());

    try (CloudTasksClient client = CloudTasksClient.create()) {
      // Create queue
      Queue queue =
          Queue.newBuilder()
              .setName(queueName.toString())
              .setRateLimits(RateLimits.newBuilder().setMaxConcurrentDispatches(1).build())
              .build();

      CreateQueueRequest createQueueRequest =
          CreateQueueRequest.newBuilder().setParent(parent.toString()).setQueue(queue).build();

      Queue createdQueue = client.createQueue(createQueueRequest);
      System.out.println("Test queue ready: " + createdQueue);

      // Create task
      HttpRequest taskTarget =
          HttpRequest.newBuilder()
              .setUrl("https://google.com")
              .setHttpMethod(HttpMethod.GET)
              .build();

      Task taskRequest = Task.newBuilder().setHttpRequest(taskTarget).build();
      Task task = client.createTask(queueName, taskRequest);
      System.out.println("Created task: " + task);

      // Cleanup
      client.purgeQueue(queueName);
      System.out.println("Queue purged");

      client.deleteQueue(queueName);
      System.out.println("Queue deleted");
    }
  }
}
