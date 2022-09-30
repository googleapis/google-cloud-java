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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.QueueName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for creating Tasks with HTTP targets. */
@RunWith(JUnit4.class)
public class CreateHttpTaskIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = System.getenv("LOCATION_ID");
  private static final String QUEUE_ID = "default";
  private static final String EMAIL =
      "java-docs-samples-testing@java-docs-samples-testing.iam.gserviceaccount.com";
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("LOCATION_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
    try (CloudTasksClient client = CloudTasksClient.create()) {
      String queuePath = QueueName.of(PROJECT_ID, LOCATION_ID, QUEUE_ID).toString();
      client.purgeQueue(queuePath);
    } catch (Exception e) {
      System.out.println("Error with queue purge.");
    }
  }

  @Test
  public void testCreateHttpTask() throws Exception {
    CreateHttpTask.createTask(PROJECT_ID, LOCATION_ID, QUEUE_ID);
    String got = bout.toString();
    assertThat(got).contains("Task created:");
  }

  @Test
  public void testCreateHttpTaskWithToken() throws Exception {
    CreateHttpTaskWithToken.createTask(PROJECT_ID, LOCATION_ID, QUEUE_ID, EMAIL);
    String got = bout.toString();
    assertThat(got).contains("Task created:");
  }
}
