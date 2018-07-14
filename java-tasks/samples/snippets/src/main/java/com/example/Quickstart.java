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

package com.example;

// [START tasks_quickstart]

import com.google.cloud.tasks.v2beta2.AcknowledgeTaskRequest;
import com.google.cloud.tasks.v2beta2.CloudTasksClient;
import com.google.cloud.tasks.v2beta2.CreateTaskRequest;
import com.google.cloud.tasks.v2beta2.LeaseTasksRequest;
import com.google.cloud.tasks.v2beta2.LeaseTasksResponse;
import com.google.cloud.tasks.v2beta2.PullMessage;
import com.google.cloud.tasks.v2beta2.QueueName;
import com.google.cloud.tasks.v2beta2.Task;
import com.google.common.base.Strings;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Quickstart {
  private static String GGOGLE_CLOUD_PROJECT_KEY = "GOOGLE_CLOUD_PROJECT";

  private static Option PROJECT_ID_OPTION = Option.builder("project")
      .longOpt("project-id")
      .desc("The Google Cloud Project, if not set as GOOGLE_CLOUD_PROJECT env var.")
      .hasArg()
      .argName("project-id")
      .type(String.class)
      .build();

  private static Option QUEUE_OPTION = Option.builder("queue")
      .required()
      .longOpt("queue")
      .desc("The Cloud Tasks queue.")
      .hasArg()
      .argName("queue")
      .type(String.class)
      .build();

  private static Option LOCATION_OPTION = Option.builder("location")
      .required()
      .longOpt("location")
      .desc("The region in which your queue is running.")
      .hasArg()
      .argName("location")
      .type(String.class)
      .build();

  public static void main(String... args) throws Exception {
    Options options = new Options();
    options.addOption(PROJECT_ID_OPTION);
    options.addOption(QUEUE_OPTION);
    options.addOption(LOCATION_OPTION);

    if (args.length == 0) {
      printUsage(options);
      return;
    }

    CommandLineParser parser = new DefaultParser();
    CommandLine params;
    try {
      params = parser.parse(options, args);
    } catch (ParseException e) {
      System.err.println("Invalid command line: " + e.getMessage());
      printUsage(options);
      return;
    }

    String projectId;
    if (params.hasOption("project-id")) {
      projectId = params.getOptionValue("project-id");
    } else {
      projectId = System.getenv(GGOGLE_CLOUD_PROJECT_KEY);
    }
    if (Strings.isNullOrEmpty(projectId)) {
      printUsage(options);
      return;
    }

    String queue = params.getOptionValue(QUEUE_OPTION.getOpt());
    String location = params.getOptionValue(LOCATION_OPTION.getOpt());

    switch (args[0]) {
      default:
        printUsage(options);
        break;
      case "create-task":
        createTask(projectId, queue, location);
        break;
      case "lease-and-ack-task":
        pullAndAckTask(projectId, queue, location);
        break;
    }
  }

  // [START cloud_tasks_create_task]
  private static void createTask(String projectId, String queueName, String location)
      throws IOException {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      Task.Builder taskBuilder = Task
          .newBuilder()
          .setPullMessage(PullMessage.newBuilder().setPayload(
              ByteString.copyFrom("a message for recipient", Charset.defaultCharset())));

      Task newTask = client.createTask(CreateTaskRequest
          .newBuilder()
          .setParent(QueueName.of(projectId, location, queueName).toString())
          .setTask(taskBuilder)
          .build());
      System.out.println("Task created: " + newTask.getName());
    }
  }
  // [END cloud_tasks_create_task]

  // [START cloud_tasks_lease_and_acknowledge_task]
  private static void pullAndAckTask(String projectId, String queueName, String location) {
    try (CloudTasksClient client = CloudTasksClient.create()) {
      LeaseTasksRequest leaseReq = LeaseTasksRequest.newBuilder()
          .setParent(QueueName.of(projectId, location, queueName).toString())
          .setLeaseDuration(Duration.newBuilder().setSeconds(600))
          .setMaxTasks(1)
          .setResponseView(Task.View.FULL)
          .build();
      LeaseTasksResponse response = client.leaseTasks(leaseReq);
      if (response.getTasksCount() == 0) {
        System.out.println("No tasks found in queue.");
        return;
      }
      Task task = response.getTasksList().get(0);
      System.out.println("Leased task: " + task.getName());
      AcknowledgeTaskRequest ackRequest = AcknowledgeTaskRequest
          .newBuilder()
          .setName(task.getName())
          .setScheduleTime(task.getScheduleTime())
          .build();
      client.acknowledgeTask(ackRequest);
      System.out.println("Acknowledged task: " + task.getName());
    } catch (Exception e) {
      System.out.println("Exception during PullAndAckTask: " + e.getMessage());
    }
  }
  // [END cloud_tasks_lease_and_acknowledge_task]

  private static void printUsage(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("client",
        "A simple Cloud Tasks command line client.", options, "", true);
  }
}
// [END tasks_quickstart]
