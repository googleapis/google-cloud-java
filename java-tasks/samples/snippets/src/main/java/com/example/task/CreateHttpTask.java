/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.task;

// [START cloud_tasks_create_http_task]
import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.HttpMethod;
import com.google.cloud.tasks.v2.HttpRequest;
import com.google.cloud.tasks.v2.QueueName;
import com.google.cloud.tasks.v2.Task;
import com.google.protobuf.ByteString;
import java.nio.charset.Charset;

public class CreateHttpTask {
  /**
   * Create a task with a HTTP target using the Cloud Tasks client.
   *
   * @param projectId the Id of the project.
   * @param queueId the name of your Queue.
   * @param locationId the GCP region of your queue.
   * @throws Exception on Cloud Tasks Client errors.
   */
  public static void createTask(String projectId, String locationId, String queueId)
      throws Exception {

    // Instantiates a client.
    try (CloudTasksClient client = CloudTasksClient.create()) {
      String url = "https://example.com/taskhandler";
      String payload = "Hello, World!";

      // Construct the fully qualified queue name.
      String queuePath = QueueName.of(projectId, locationId, queueId).toString();

      // Construct the task body.
      Task.Builder taskBuilder =
          Task.newBuilder()
              .setHttpRequest(
                  HttpRequest.newBuilder()
                      .setBody(ByteString.copyFrom(payload, Charset.defaultCharset()))
                      .setUrl(url)
                      .setHttpMethod(HttpMethod.POST)
                      .build());

      // Send create task request.
      Task task = client.createTask(queuePath, taskBuilder.build());
      System.out.println("Task created: " + task.getName());
    }
  }
}
// [END cloud_tasks_create_http_task]
