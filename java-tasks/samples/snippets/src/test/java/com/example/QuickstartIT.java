/*
 * Copyright 2017 Google Inc.
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

package com.example;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.cloud.tasks.v2beta2.CloudTasksClient;
import com.google.cloud.tasks.v2beta2.QueueName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link Quickstart}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartIT {
  private static String queue_name = "my-pull-queue";
  private static String location = "us-east1";
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @BeforeClass
  public static void setUpClass() throws Exception {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
  }

  // Purge the task queue when tests done.
  @AfterClass
  public static void tearDownClass() throws IOException {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      client.purgeQueue(QueueName.of(System.getenv("GOOGLE_CLOUD_PROJECT"), location, queue_name));
    }
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @Test
  public void createTaskTest() throws Exception {
    Quickstart.main("create-task", "--queue", queue_name, "--location", location);
    assertThat(bout.toString()).contains("Task created: ");
  }

  @Test
  public void leaseAndAcknowledge() throws Exception {
    Quickstart.main("lease-and-ack-task", "--queue", queue_name, "--location", location);
    assertThat(bout.toString()).contains("Leased task: ");
    assertThat(bout.toString()).contains("Acknowledged task: ");
  }
}
