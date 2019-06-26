/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.tasks.v2beta3;

import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloudTasksSmokeTest {
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String LOCATION_ID = "us-east1";
  private static final String QUEUE_ID = "default";

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      createTask();
      System.out.println("OK");
    } catch (IOException e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  @Test
  public void run() {
    main(null);
  }

  public static void createTask() throws IOException {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      String url = "https://example.com/taskhandler";
      String payload = "Hello, World!";

      // Construct the fully qualified queue name.
      String queuePath = QueueName.of(getProjectId(), LOCATION_ID, QUEUE_ID).toString();

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


  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
              System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    Preconditions.checkArgument(projectId != null, "A project ID is required.");
    return projectId;
  }
}
