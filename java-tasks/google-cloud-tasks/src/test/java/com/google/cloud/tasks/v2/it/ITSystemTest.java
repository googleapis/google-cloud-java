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
package com.google.cloud.tasks.v2.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.CreateQueueRequest;
import com.google.cloud.tasks.v2.CreateTaskRequest;
import com.google.cloud.tasks.v2.DeleteQueueRequest;
import com.google.cloud.tasks.v2.DeleteTaskRequest;
import com.google.cloud.tasks.v2.GetQueueRequest;
import com.google.cloud.tasks.v2.GetTaskRequest;
import com.google.cloud.tasks.v2.HttpMethod;
import com.google.cloud.tasks.v2.HttpRequest;
import com.google.cloud.tasks.v2.ListQueuesRequest;
import com.google.cloud.tasks.v2.ListTasksRequest;
import com.google.cloud.tasks.v2.LocationName;
import com.google.cloud.tasks.v2.PauseQueueRequest;
import com.google.cloud.tasks.v2.Queue;
import com.google.cloud.tasks.v2.QueueName;
import com.google.cloud.tasks.v2.ResumeQueueRequest;
import com.google.cloud.tasks.v2.Task;
import com.google.cloud.tasks.v2.TaskName;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String LOCATION = "us-central1";
  private static final String LOCATION_NAME = LocationName.of(PROJECT_ID, LOCATION).toString();
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String QUEUE_ID = "test-queue-" + ID;
  private static final String QUEUE_NAME = QueueName.of(PROJECT_ID, LOCATION, QUEUE_ID).toString();
  private static final String TASK_ID = "test-task-" + ID;
  private static final String TASK_NAME =
      TaskName.of(PROJECT_ID, LOCATION, QUEUE_ID, TASK_ID).toString();
  private static final String URL = "https://example.com/taskhandler";
  private static final String PAYLOAD = "Hello, World!";
  private static Queue queue;
  private static Task task;
  private static CloudTasksClient client;

  @BeforeClass
  public static void setUp() throws IOException {

    client = CloudTasksClient.create();

    /* create queue */
    Queue createQueue =
        Queue.newBuilder().setName(QUEUE_NAME).setState(Queue.State.RUNNING).build();
    CreateQueueRequest queueRequest =
        CreateQueueRequest.newBuilder().setParent(LOCATION_NAME).setQueue(createQueue).build();
    queue = client.createQueue(queueRequest);

    /* create task */
    Task createTask =
        Task.newBuilder()
            .setName(TASK_NAME)
            .setHttpRequest(
                HttpRequest.newBuilder()
                    .setBody(ByteString.copyFrom(PAYLOAD, Charset.defaultCharset()))
                    .setUrl(URL)
                    .setHttpMethod(HttpMethod.POST)
                    .build())
            .build();
    CreateTaskRequest taskRequest =
        CreateTaskRequest.newBuilder().setParent(QUEUE_NAME).setTask(createTask).build();
    task = client.createTask(taskRequest);
  }

  @AfterClass
  public static void tearDown() {

    /* delete task */
    DeleteTaskRequest taskRequest = DeleteTaskRequest.newBuilder().setName(TASK_NAME).build();
    client.deleteTask(taskRequest);

    /* delete queue */
    DeleteQueueRequest queueRequest = DeleteQueueRequest.newBuilder().setName(QUEUE_NAME).build();
    client.deleteQueue(queueRequest);
    client.close();
  }

  @Test
  public void listQueuesTest() {
    ListQueuesRequest request = ListQueuesRequest.newBuilder().setParent(LOCATION_NAME).build();
    for (Queue actual : client.listQueues(request).iterateAll()) {
      if (queue.getName().equals(actual.getName())) {
        assertQueue(queue, actual);
      }
    }
  }

  @Test
  public void getQueueTest() {
    GetQueueRequest request = GetQueueRequest.newBuilder().setName(QUEUE_NAME).build();
    assertQueue(queue, client.getQueue(request));
  }

  @Test
  public void listTasksTest() {
    ListTasksRequest request = ListTasksRequest.newBuilder().setParent(QUEUE_NAME).build();
    for (Task actual : client.listTasks(request).iterateAll()) {
      if (task.getName().equals(actual.getName())) {
        assertTask(task, actual);
      }
    }
  }

  @Test
  public void pauseQueueTest() {
    PauseQueueRequest request = PauseQueueRequest.newBuilder().setName(QUEUE_NAME).build();
    Queue actual = client.pauseQueue(request);
    assertEquals(Queue.State.PAUSED, actual.getState());
  }

  @Test
  public void resumeQueueTest() {
    ResumeQueueRequest request = ResumeQueueRequest.newBuilder().setName(QUEUE_NAME).build();
    Queue actual = client.resumeQueue(request);
    assertEquals(Queue.State.RUNNING, actual.getState());
  }

  @Test
  public void getTaskTest() {
    GetTaskRequest request = GetTaskRequest.newBuilder().setName(TASK_NAME).build();
    assertTask(task, client.getTask(request));
  }

  private void assertQueue(Queue expected, Queue actual) {
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getRateLimits(), actual.getRateLimits());
    assertEquals(expected.getRetryConfig(), actual.getRetryConfig());
    assertEquals(expected.getState(), actual.getState());
  }

  private void assertTask(Task expected, Task actual) {
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getHttpRequest(), actual.getHttpRequest());
    assertEquals(expected.getCreateTime(), actual.getCreateTime());
    assertEquals(expected.getDispatchDeadline(), actual.getDispatchDeadline());
    assertEquals(expected.getView(), actual.getView());
  }
}
