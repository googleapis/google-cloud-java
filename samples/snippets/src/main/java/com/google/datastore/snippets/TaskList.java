/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple Task List application demonstrating how to connect to Cloud Datastore, create, modify,
 * delete, and query entities.
 */
public class TaskList {

  // [START build_service]
  // Create an authorized Datastore service using Application Default Credentials.
  private final Datastore datastore = DatastoreOptions.defaultInstance().service();

  // Create a Key factory to construct keys associated with this project.
  private final KeyFactory keyFactory = datastore.newKeyFactory().kind("Task");
  // [END build_service]

  // [START add_entity]
  /**
   * Adds a task entity to the Datastore.
   *
   * @param description The task description
   * @return The {@link Key} of the entity
   * @throws DatastoreException if the ID allocation or put fails
   */
  Key addTask(String description) {
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity task = Entity.builder(key)
        .set("description", StringValue.builder(description).excludeFromIndexes(true).build())
        .set("created", DateTime.now())
        .set("done", false)
        .build();
    datastore.put(task);
    return key;
  }
  // [END add_entity]

  // [START update_entity]
  /**
   * Marks a task entity as done.
   *
   * @param id The ID of the task entity as given by {@link Key#id()}
   * @return true if the task was found, false if not
   * @throws DatastoreException if the transaction fails
   */
  boolean markDone(long id) {
    Transaction transaction = datastore.newTransaction();
    try {
      Entity task = transaction.get(keyFactory.newKey(id));
      if (task != null) {
        transaction.put(Entity.builder(task).set("done", true).build());
      }
      transaction.commit();
      return task != null;
    } finally {
      if (transaction.active()) {
        transaction.rollback();
      }
    }
  }
  // [END update_entity]

  // [START retrieve_entities]
  /**
   * Returns a list of all task entities in ascending order of creation time.
   *
   * @throws DatastoreException if the query fails
   */
  Iterator<Entity> listTasks() {
    Query<Entity> query =
        Query.entityQueryBuilder().kind("Task").orderBy(OrderBy.asc("created")).build();
    return datastore.run(query);
  }
  // [END retrieve_entities]

  // [START delete_entity]
  /**
   * Deletes a task entity.
   *
   * @param id The ID of the task entity as given by {@link Key#id()}
   * @throws DatastoreException if the delete fails
   */
  void deleteTask(long id) {
    datastore.delete(keyFactory.newKey(id));
  }
  // [END delete_entity]

  // [START format_results]
  /**
   * Converts a list of task entities to a list of formatted task strings.
   *
   * @param tasks An iterator over task entities
   * @return A list of tasks strings, one per entity
   */
  static List<String> formatTasks(Iterator<Entity> tasks) {
    List<String> strings = new ArrayList<>();
    while (tasks.hasNext()) {
      Entity task = tasks.next();
      if (task.getBoolean("done")) {
        strings.add(
            String.format("%d : %s (done)", task.key().id(), task.getString("description")));
      } else {
        strings.add(String.format("%d : %s (created %s)", task.key().id(),
            task.getString("description"), task.getDateTime("created")));
      }
    }
    return strings;
  }
  // [END format_results]

  /**
   * Handles a single command.
   *
   * @param commandLine A line of input provided by the user
   */
  void handleCommandLine(String commandLine) {
    String[] args = commandLine.split("\\s+");

    if (args.length < 1) {
      throw new IllegalArgumentException("not enough args");
    }

    String command = args[0];
    switch (command) {
      case "new":
        // Everything after the first whitespace token is interpreted to be the description.
        args = commandLine.split("\\s+", 2);
        if (args.length != 2) {
          throw new IllegalArgumentException("missing description");
        }
        // Set created to now() and done to false.
        addTask(args[1]);
        System.out.println("task added");
        break;
      case "done":
        assertArgsLength(args, 2);
        long id = Long.parseLong(args[1]);
        if (markDone(id)) {
          System.out.println("task marked done");
        } else {
          System.out.printf("did not find a Task entity with ID %d%n", id);
        }
        break;
      case "list":
        assertArgsLength(args, 1);
        List<String> tasks = formatTasks(listTasks());
        System.out.printf("found %d tasks:%n", tasks.size());
        System.out.println("task ID : description");
        System.out.println("---------------------");
        for (String taskString : tasks) {
          System.out.println(taskString);
        }
        break;
      case "delete":
        assertArgsLength(args, 2);
        deleteTask(Long.parseLong(args[1]));
        System.out.println("task deleted (if it existed)");
        break;
      default:
        throw new IllegalArgumentException("unrecognized command: " + command);
    }
  }

  private void assertArgsLength(String[] args, int expectedLength) {
    if (args.length != expectedLength) {
      throw new IllegalArgumentException(
          String.format("expected exactly %d arg(s), found %d", expectedLength, args.length));
    }
  }

  /**
   * Exercises the methods defined in this class.
   *
   * <p>Assumes that you are authenticated using the Google Cloud SDK (using
   * {@code gcloud auth login}).
   */
  public static void main(String[] args) throws Exception {
    TaskList taskList = new TaskList();
    System.out.println("Cloud Datastore Task List");
    System.out.println();
    printUsage();
    while (true) {
      String commandLine = System.console().readLine("> ");
      if (commandLine.trim().isEmpty()) {
        break;
      }
      try {
        taskList.handleCommandLine(commandLine);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        printUsage();
      }
    }
    System.out.println("exiting");
    System.exit(0);
  }

  private static void printUsage() {
    System.out.println("Usage:");
    System.out.println();
    System.out.println("  new <description>  Adds a task with a description <description>");
    System.out.println("  done <task-id>     Marks a task as done");
    System.out.println("  list               Lists all tasks by creation time");
    System.out.println("  delete <task-id>   Deletes a task");
    System.out.println();
  }
}
