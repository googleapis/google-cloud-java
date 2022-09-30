/*
 * Copyright 2019 Google LLC
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

// [START cloud_tasks_create_http_task_with_token]
import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.HttpMethod;
import com.google.cloud.tasks.v2.HttpRequest;
import com.google.cloud.tasks.v2.OidcToken;
import com.google.cloud.tasks.v2.QueueName;
import com.google.cloud.tasks.v2.Task;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.charset.Charset;

public class CreateHttpTaskWithToken {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String locationId = "us-central1";
    String queueId = "my-queue";
    String serviceAccountEmail =
        "java-docs-samples-testing@java-docs-samples-testing.iam.gserviceaccount.com";
    createTask(projectId, locationId, queueId, serviceAccountEmail);
  }

  // Create a task with a HTTP target and authorization token using the Cloud Tasks client.
  public static void createTask(
      String projectId, String locationId, String queueId, String serviceAccountEmail)
      throws IOException {

    // Instantiates a client.
    try (CloudTasksClient client = CloudTasksClient.create()) {
      String url =
          "https://example.com/taskhandler"; // The full url path that the request will be sent to
      String payload = "Hello, World!"; // The task HTTP request body

      // Construct the fully qualified queue name.
      String queuePath = QueueName.of(projectId, locationId, queueId).toString();

      // Add your service account email to construct the OIDC token.
      // in order to add an authentication header to the request.
      OidcToken.Builder oidcTokenBuilder =
          OidcToken.newBuilder().setServiceAccountEmail(serviceAccountEmail);

      // Construct the task body.
      Task.Builder taskBuilder =
          Task.newBuilder()
              .setHttpRequest(
                  HttpRequest.newBuilder()
                      .setBody(ByteString.copyFrom(payload, Charset.defaultCharset()))
                      .setHttpMethod(HttpMethod.POST)
                      .setUrl(url)
                      .setOidcToken(oidcTokenBuilder)
                      .build());

      // Send create task request.
      Task task = client.createTask(queuePath, taskBuilder.build());
      System.out.println("Task created: " + task.getName());
    }
  }
}
// [END cloud_tasks_create_http_task_with_token]
