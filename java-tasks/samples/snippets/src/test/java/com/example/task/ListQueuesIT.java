// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example.task;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.LocationName;
import com.google.cloud.tasks.v2.Queue;
import com.google.cloud.tasks.v2.QueueName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for listing queues. */
@RunWith(JUnit4.class)
public class ListQueuesIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = System.getenv("LOCATION_ID");
  private static final String QUEUE_ID = "test-queue-" + UUID.randomUUID();

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private Queue queue;

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

    try (CloudTasksClient client = CloudTasksClient.create()) {
      String parent = LocationName.of(PROJECT_ID, LOCATION_ID).toString();
      String queuePath = QueueName.of(PROJECT_ID, LOCATION_ID, QUEUE_ID).toString();
      queue = client.createQueue(parent, Queue.newBuilder().setName(queuePath).build());
    } catch (Exception e) {
      System.out.println("Error with queue creation.");
    }
  }

  @After
  public void tearDown() {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      client.deleteQueue(queue.getName());
    } catch (IOException e) {
      System.out.println("Error with queue deletion.");
    }
    System.setOut(null);
  }

  @Test
  public void testListQueues() throws Exception {
    ListQueues.listQueues(PROJECT_ID, LOCATION_ID);
    String got = bout.toString();
    assertThat(got).contains(queue.getName());
  }
}
