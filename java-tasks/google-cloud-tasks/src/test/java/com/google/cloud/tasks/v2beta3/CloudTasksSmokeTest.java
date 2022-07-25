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

import static org.junit.Assert.fail;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class CloudTasksSmokeTest {
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String LOCATION_ENV_NAME = "GOOGLE_CLOUD_LOCATION";
  private static final String DEFAULT_LOCATION_ID = "us-central1";
  private static final String QUEUE_ID = "default";
  static Queue queue;

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      createTask(getProjectId(), getLocationId(), QUEUE_ID);
      System.out.println("OK");
    } catch (IOException e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  @BeforeClass
  public static void setupQueue() {
    String queueName = QueueName.of(getProjectId(), getLocationId(), QUEUE_ID).toString();
    try (CloudTasksClient client = CloudTasksClient.create()) {
      Queue q = Queue.newBuilder().setName(queueName).build();
      try {

        queue = client.createQueue(LocationName.of(getProjectId(), getLocationId()), q);
      } catch (AlreadyExistsException e) {
        queue = client.getQueue(queueName);
      }
    } catch (IOException e) {
      fail("Failed to create queue: " + e.getMessage());
    }
  }

  @Test
  public void run() {
    main(null);
  }

  public static void createTask(String project, String location, String queue) throws IOException {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      String url = "https://example.com/taskhandler";
      String payload = "Hello, World!";

      // Construct the fully qualified queue name.
      String queuePath = QueueName.of(project, location, queue).toString();

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

  private static String getLocationId() {
    String locationId = System.getProperty(LOCATION_ENV_NAME, System.getenv(LOCATION_ENV_NAME));
    if (locationId == null) {
      return DEFAULT_LOCATION_ID;
    }
    return locationId;
  }
}
