/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.logging;

import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.Tuple;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.MetricInfo;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.SinkInfo;
import com.google.cloud.logging.SinkInfo.Destination;
import com.google.cloud.logging.SinkInfo.Destination.BucketDestination;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.cloud.logging.SinkInfo.Destination.TopicDestination;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of using Stackdriver Logging.
 *
 * <p>This example demonstrates a simple/typical Logging usage.
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/LoggingExample
 *  -Dexec.args="[<project_id>]
 *  create metric <metric> <filter>
 *  create sink <sink> bucket|dataset|topic <destination> <filter>?
 *  list metrics
 *  list sinks
 *  list resource-descriptors
 *  list entries <filter>?
 *  delete metric <metric>
 *  delete sink <sink>
 *  delete log <logName>
 *  into metric <metric>
 *  info sink <sink>
 *  write <logName> <severity> <message> (<key> <value>)*"}</pre>
 *
 * <p>The first parameter is an optional {@code project_id} (logged-in project will be used if not
 * supplied). Second parameter is a Logging operation and can be used to demonstrate its usage. For
 * operations that apply to more than one entity (`list`, `create`, `info` and `delete`) the third
 * parameter specifies the entity.
 */
public class LoggingExample {

  private static final Map<String, LoggingAction> CREATE_ACTIONS = new HashMap<>();
  private static final Map<String, LoggingAction> INFO_ACTIONS = new HashMap<>();
  private static final Map<String, LoggingAction> LIST_ACTIONS = new HashMap<>();
  private static final Map<String, LoggingAction> DELETE_ACTIONS = new HashMap<>();
  private static final Map<String, LoggingAction> ACTIONS = new HashMap<>();

  private abstract static class LoggingAction<T> {

    abstract void run(Logging logging, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  private static class ParentAction extends LoggingAction<Tuple<LoggingAction, Object>> {

    private final Map<String, LoggingAction> subActions;

    ParentAction(Map<String, LoggingAction> subActions) {
      this.subActions = ImmutableMap.copyOf(subActions);
    }

    @Override
    @SuppressWarnings("unchecked")
    void run(Logging logging, Tuple<LoggingAction, Object> subaction) throws Exception {
      subaction.x().run(logging, subaction.y());
    }

    @Override
    Tuple<LoggingAction, Object> parse(String... args) throws Exception {
      if (args.length >= 1) {
        LoggingAction action = subActions.get(args[0]);
        if (action != null) {
          Object actionArguments = action.parse(Arrays.copyOfRange(args, 1, args.length));
          return Tuple.of(action, actionArguments);
        } else {
          throw new IllegalArgumentException("Unrecognized entity '" + args[0] + "'.");
        }
      }
      throw new IllegalArgumentException("Missing required entity.");
    }

    @Override
    public String params() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<String, LoggingAction> entry : subActions.entrySet()) {
        builder.append('\n').append(entry.getKey());
        String param = entry.getValue().params();
        if (param != null && !param.isEmpty()) {
          builder.append(' ').append(param);
        }
      }
      return builder.toString();
    }
  }

  private abstract static class NoArgsAction extends LoggingAction<Void> {
    @Override
    Void parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      }
      throw new IllegalArgumentException("This action takes no arguments.");
    }
  }

  /**
   * This class demonstrates how to list Logging metrics.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.metrics/list">
   *     List metrics</a>
   */
  private static class ListMetricsAction extends NoArgsAction {
    @Override
    public void run(Logging logging, Void arg) {
      for (Metric metric : logging.listMetrics().iterateAll()) {
        System.out.println(metric);
      }
    }
  }

  private abstract static class MetricAction extends LoggingAction<String> {
    @Override
    String parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return args[0];
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required metric name.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<metric>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Logging metric.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.metrics/get">
   *     Get metric</a>
   */
  private static class MetricInfoAction extends MetricAction {
    @Override
    public void run(Logging logging, String metric) {
      System.out.printf("Metric info: %s%n", logging.getMetric(metric));
    }
  }

  /**
   * This class demonstrates how to delete a Logging metric.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.metrics/delete">
   *     Delete a metric</a>
   */
  private static class DeleteMetricAction extends MetricAction {
    @Override
    public void run(Logging logging, String metric) {
      logging.deleteMetric(metric);
      System.out.printf("Deleted metric %s%n", metric);
    }
  }

  /**
   * This class demonstrates how to create a Logging metric.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.metrics/create">
   *     Create a metric</a>
   */
  private static class CreateMetricAction extends LoggingAction<MetricInfo> {
    @Override
    public void run(Logging logging, MetricInfo metric) {
      System.out.printf("Created metric %s%n", logging.create(metric));
    }

    @Override
    MetricInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return MetricInfo.of(args[0], args[1]);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required metric name or filter.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<metric> <filter>";
    }
  }

  /**
   * This class demonstrates how to list Logging sinks.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.sinks/list">
   *     List sinks</a>
   */
  private static class ListSinksAction extends NoArgsAction {
    @Override
    public void run(Logging logging, Void arg) {
      for (Sink sink : logging.listSinks().iterateAll()) {
        System.out.println(sink);
      }
    }
  }

  private abstract static class SinkAction extends LoggingAction<String> {
    @Override
    String parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return args[0];
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required sink name.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<sink>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Logging sink.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.sinks/get">
   *     Get sink</a>
   */
  private static class SinkInfoAction extends SinkAction {
    @Override
    public void run(Logging logging, String sink) {
      System.out.printf("Sink info: %s%n", logging.getSink(sink));
    }
  }

  /**
   * This class demonstrates how to delete a Logging sink.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.sinks/delete">
   *     Delete a sink</a>
   */
  private static class DeleteSinkAction extends SinkAction {
    @Override
    public void run(Logging logging, String sink) {
      logging.deleteSink(sink);
      System.out.printf("Deleted sink %s%n", sink);
    }
  }

  /**
   * This class demonstrates how to create a Logging sink.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.sinks/create">
   *     Create a sink</a>
   */
  private static class CreateSinkAction extends LoggingAction<SinkInfo> {
    @Override
    public void run(Logging logging, SinkInfo sink) {
      System.out.printf("Created sink %s%n", logging.create(sink));
    }

    @Override
    SinkInfo parse(String... args) throws Exception {
      if (args.length >= 3) {
        if (args.length > 4) {
          throw new IllegalArgumentException("Too many arguments.");
        }
        String name = args[0];
        Destination destination;
        switch (args[1]) {
          case "bucket":
            destination = BucketDestination.of(args[2]);
            break;
          case "dataset":
            destination = DatasetDestination.of(args[2]);
            break;
          case "topic":
            destination = TopicDestination.of(args[2]);
            break;
          default:
            throw new IllegalArgumentException("Second argument must be bucket|dataset|topic.");
        }
        SinkInfo.Builder builder = SinkInfo.newBuilder(name, destination);
        if (args.length == 4) {
          builder.setFilter(args[3]);
        }
        return builder.build();
      }
      throw new IllegalArgumentException("Missing required sink name, destination or filter.");
    }

    @Override
    public String params() {
      return "<sink> bucket|dataset|topic <destination> <filter>?";
    }
  }

  /**
   * This class demonstrates how to list Logging monitored resource descriptors.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/monitoredResourceDescriptors/list">
   *     List monitored resource descriptor</a>
   */
  private static class ListResourceDescriptorsAction extends NoArgsAction {
    @Override
    public void run(Logging logging, Void arg) {
      for (MonitoredResourceDescriptor descriptor :
          logging.listMonitoredResourceDescriptors().iterateAll()) {
        System.out.println(descriptor);
      }
    }
  }

  /**
   * This class demonstrates how to write Logging entries.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/entries/write">
   *     Write log entries</a>
   */
  private static class WriteEntryAction extends LoggingAction<LogEntry> {

    @Override
    public void run(Logging logging, LogEntry entry) {
      MonitoredResource resource =
          MonitoredResource.newBuilder("global")
              .addLabel("project_id", logging.getOptions().getProjectId())
              .build();
      LogEntry entryWithResource = entry.toBuilder().setResource(resource).build();
      logging.write(Collections.singleton(entryWithResource));
      System.out.printf("Written entry %s%n", entryWithResource);
    }

    @Override
    LogEntry parse(String... args) throws Exception {
      if (args.length >= 3) {
        if ((args.length & 0x1) != 0x1) {
          throw new IllegalArgumentException("Labels must be a list of key-value pairs.");
        }
        String logName = args[0];
        Severity severity = Severity.valueOf(args[1].toUpperCase());
        String message = args[2];
        Map<String, String> labels = Maps.newHashMapWithExpectedSize((args.length - 3) / 2);
        for (int i = 3; i < args.length; i += 2) {
          labels.put(args[i], args[i + 1]);
        }
        return LogEntry.newBuilder(StringPayload.of(message))
            .setLogName(logName)
            .setSeverity(severity)
            .setLabels(labels)
            .build();
      } else {
        throw new IllegalArgumentException("Missing required arguments.");
      }
    }

    @Override
    public String params() {
      return "<logName> <severity> <message> (<key> <value>)*";
    }
  }

  /**
   * This class demonstrates how to list Logging entries.
   *
   * @see <a href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/entries/list">
   *     List log entries</a>
   */
  private static class ListEntriesAction extends LoggingAction<String> {
    @Override
    public void run(Logging logging, String filter) {
      Page<LogEntry> entryPage;
      if (filter == null) {
        entryPage = logging.listLogEntries();
      } else {
        entryPage = logging.listLogEntries(EntryListOption.filter(filter));
      }
      for (LogEntry entry : entryPage.iterateAll()) {
        System.out.println(entry);
      }
    }

    @Override
    String parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      } else if (args.length == 1) {
        return args[0];
      }
      throw new IllegalArgumentException("Too many arguments.");
    }

    @Override
    public String params() {
      return "<filter>?";
    }
  }

  /**
   * This class demonstrates how to delete a Logging log.
   *
   * @see <a
   *     href="https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/projects.logs/delete">
   *     Delete a log</a>
   */
  private static class DeleteLogAction extends LoggingAction<String> {
    @Override
    public void run(Logging logging, String logName) {
      logging.deleteLog(logName);
      System.out.printf("Deleted log %s%n", logName);
    }

    @Override
    String parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return args[0];
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required log name.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<logName>";
    }
  }

  static {
    CREATE_ACTIONS.put("metric", new CreateMetricAction());
    CREATE_ACTIONS.put("sink", new CreateSinkAction());
    INFO_ACTIONS.put("metric", new MetricInfoAction());
    INFO_ACTIONS.put("sink", new SinkInfoAction());
    LIST_ACTIONS.put("metrics", new ListMetricsAction());
    LIST_ACTIONS.put("sinks", new ListSinksAction());
    LIST_ACTIONS.put("entries", new ListEntriesAction());
    LIST_ACTIONS.put("resource-descriptors", new ListResourceDescriptorsAction());
    DELETE_ACTIONS.put("metric", new DeleteMetricAction());
    DELETE_ACTIONS.put("sink", new DeleteSinkAction());
    DELETE_ACTIONS.put("log", new DeleteLogAction());
    ACTIONS.put("create", new ParentAction(CREATE_ACTIONS));
    ACTIONS.put("info", new ParentAction(INFO_ACTIONS));
    ACTIONS.put("list", new ParentAction(LIST_ACTIONS));
    ACTIONS.put("delete", new ParentAction(DELETE_ACTIONS));
    ACTIONS.put("write", new WriteEntryAction());
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, LoggingAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param.replace("\n", "\n\t\t"));
      }
    }
    System.out.printf(
        "Usage: %s [<project_id>] operation [entity] <args>*%s%n",
        LoggingExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    LoggingOptions.Builder optionsBuilder = LoggingOptions.newBuilder();
    LoggingAction action;
    String actionName;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      actionName = args[1];
      optionsBuilder.setProjectId(args[0]);
      action = ACTIONS.get(args[1]);
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      action = ACTIONS.get(args[0]);
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    if (action == null) {
      System.out.println("Unrecognized action.");
      printUsage();
      return;
    }
    try (Logging logging = optionsBuilder.build().getService()) {
      Object arg;
      try {
        arg = action.parse(args);
      } catch (IllegalArgumentException ex) {
        System.out.printf("Invalid input for action '%s'. %s%n", actionName, ex.getMessage());
        System.out.printf("Expected: %s%n", action.params());
        return;
      } catch (Exception ex) {
        System.out.println("Failed to parse arguments.");
        ex.printStackTrace();
        return;
      }
      action.run(logging, arg);
    }
  }
}
