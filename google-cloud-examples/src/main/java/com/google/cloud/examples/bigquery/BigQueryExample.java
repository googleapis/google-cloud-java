/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.examples.bigquery;

import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.ExtractJobConfiguration;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.ViewDefinition;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.google.common.collect.ImmutableMap;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An example of using Google BigQuery.
 *
 * <p>This example demonstrates a simple/typical BigQuery usage.
 *
 * <p>See the
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 * <pre>{@code target/appassembler/bin/BigQueryExample [<project_id>]
 * list datasets |
 * list tables <dataset> |
 * list jobs |
 * list data <dataset> <table> |
 * info dataset <dataset> |
 * info table <dataset> <table> |
 * info job <job> |
 * create dataset <dataset> |
 * create table <dataset> <table> (<fieldName>:<primitiveType>)+ |
 * create view <dataset> <table> <query> |
 * create external-table <dataset> <table> <format> (<fieldName>:<primitiveType>)+ <sourceUri> |
 * delete dataset <dataset> |
 * delete table <dataset> <table> |
 * cancel <job> |
 * copy <sourceDataset> <sourceTable> <destinationDataset> <destinationTable> |
 * load <dataset> <table> <format> <sourceUri>+ |
 * extract <dataset> <table> <format> <destinationUri>+ |
 * query <query> |
 * load-file <dataset> <table> <format> <filePath>}</pre>
 *
 * <p>The first parameter is an optional {@code project_id} (logged-in project will be used if not
 * supplied). Second parameter is a BigQuery operation and can be used to demonstrate its usage. For
 * operations that apply to more than one entity (`list`, `create`, `info` and `delete`) the third
 * parameter specifies the entity. {@code <primitiveType>} indicates that only primitive types are
 * supported by the {@code create table} and {@code create external-table} operations
 * ({@code string}, {@code float}, {@code integer}, {@code timestamp}, {@code boolean},
 * {@code bytes}). {@code <sourceUri>}, {@code <sourceUris>} and {@code <destinationUris>}
 * parameters are URIs to Google Cloud Storage blobs, in the form {@code gs://bucket/path}.
 * See each action's run method for the specific BigQuery interaction.
 */
public class BigQueryExample {

  private static final int CHUNK_SIZE = 8 * 256 * 1024;
  private static final Map<String, BigQueryAction> CREATE_ACTIONS = new HashMap<>();
  private static final Map<String, BigQueryAction> INFO_ACTIONS = new HashMap<>();
  private static final Map<String, BigQueryAction> LIST_ACTIONS = new HashMap<>();
  private static final Map<String, BigQueryAction> DELETE_ACTIONS = new HashMap<>();
  private static final Map<String, BigQueryAction> ACTIONS = new HashMap<>();

  private abstract static class BigQueryAction<T> {

    abstract void run(BigQuery bigquery, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  private static class ParentAction extends BigQueryAction<Tuple<BigQueryAction, Object>> {

    private final Map<String, BigQueryAction> subActions;

    public ParentAction(Map<String, BigQueryAction> subActions) {
      this.subActions = ImmutableMap.copyOf(subActions);
    }

    @Override
    @SuppressWarnings("unchecked")
    void run(BigQuery bigquery, Tuple<BigQueryAction, Object> subaction) throws Exception {
      subaction.x().run(bigquery, subaction.y());
    }

    @Override
    Tuple<BigQueryAction, Object> parse(String... args) throws Exception {
      if (args.length >= 1) {
        BigQueryAction action = subActions.get(args[0]);
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
      for (Map.Entry<String, BigQueryAction> entry : subActions.entrySet()) {
        builder.append('\n').append(entry.getKey());
        String param = entry.getValue().params();
        if (param != null && !param.isEmpty()) {
          builder.append(' ').append(param);
        }
      }
      return builder.toString();
    }
  }

  private abstract static class NoArgsAction extends BigQueryAction<Void> {
    @Override
    Void parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      }
      throw new IllegalArgumentException("This action takes no arguments.");
    }
  }

  /**
   * This class demonstrates how to list BigQuery Datasets.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets/list">Datasets: list
   *     </a>
   */
  private static class ListDatasetsAction extends NoArgsAction {
    @Override
    public void run(BigQuery bigquery, Void arg) {
      for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
        System.out.println(dataset);
      }
    }
  }

  private abstract static class DatasetAction extends BigQueryAction<DatasetId> {
    @Override
    DatasetId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return DatasetId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required dataset id.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<dataset>";
    }
  }

  /**
   * This class demonstrates how to list BigQuery Tables in a Dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/list">Tables: list</a>
   */
  private static class ListTablesAction extends DatasetAction {
    @Override
    public void run(BigQuery bigquery, DatasetId datasetId) {
      for (Table table : bigquery.listTables(datasetId).iterateAll()) {
        System.out.println(table);
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a BigQuery Dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets/get">Datasets: get
   *     </a>
   */
  private static class DatasetInfoAction extends DatasetAction {
    @Override
    public void run(BigQuery bigquery, DatasetId datasetId) {
      System.out.println("Dataset info: " + bigquery.getDataset(datasetId));
    }
  }

  /**
   * This class demonstrates how to create a BigQuery Dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets/insert">Datasets:
   *     insert</a>
   */
  private static class CreateDatasetAction extends DatasetAction {
    @Override
    public void run(BigQuery bigquery, DatasetId datasetId) {
      bigquery.create(DatasetInfo.newBuilder(datasetId).build());
      System.out.println("Created dataset " + datasetId);
    }
  }

  /**
   * This class demonstrates how to delete a BigQuery Dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets/delete">Datasets:
   *     delete</a>
   */
  private static class DeleteDatasetAction extends DatasetAction {
    @Override
    public void run(BigQuery bigquery, DatasetId datasetId) {
      if (bigquery.delete(datasetId)) {
        System.out.println("Dataset " + datasetId + " was deleted");
      } else {
        System.out.println("Dataset " + datasetId + " not found");
      }
    }
  }

  private abstract static class TableAction extends BigQueryAction<TableId> {
    @Override
    TableId parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        return TableId.of(args[0], args[1]);
      } else if (args.length < 2) {
        message = "Missing required dataset and table id.";
      } else {
        message = "Too many arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<dataset> <table>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a BigQuery Table.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/get">Tables: get</a>
   */
  private static class TableInfoAction extends TableAction {
    @Override
    public void run(BigQuery bigquery, TableId tableId) {
      System.out.println("Table info: " + bigquery.getTable(tableId));
    }
  }

  /**
   * This class demonstrates how to delete a BigQuery Table.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/delete">Tables: delete
   *     </a>
   */
  private static class DeleteTableAction extends TableAction {
    @Override
    public void run(BigQuery bigquery, TableId tableId) {
      if (bigquery.delete(tableId)) {
        System.out.println("Table " + tableId + " was deleted");
      } else {
        System.out.println("Table " + tableId + " not found");
      }
    }
  }

  /**
   * This class demonstrates how to list the rows in a BigQuery Table.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tabledata/list">Tabledata:
   *     list</a>
   */
  private static class ListTableDataAction extends TableAction {
    @Override
    public void run(BigQuery bigquery, TableId tableId) {
      for (FieldValueList row : bigquery.listTableData(tableId).iterateAll()) {
        System.out.println(row);
      }
    }
  }

  private abstract static class JobAction extends BigQueryAction<JobId> {
    @Override
    JobId parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return JobId.of(args[0]);
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required query.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<job>";
    }
  }

  /**
   * This class demonstrates how to list BigQuery Jobs.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/list">Jobs: list</a>
   */
  private static class ListJobsAction extends NoArgsAction {
    @Override
    public void run(BigQuery bigquery, Void arg) {
      for (Job job : bigquery.listJobs().iterateAll()) {
        System.out.println(job);
      }
    }
  }

  /**
   * This class demonstrates how to retrieve information on a BigQuery Job.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/get">Jobs: get</a>
   */
  private static class JobInfoAction extends JobAction {
    @Override
    public void run(BigQuery bigquery, JobId jobId) {
      System.out.println("Job info: " + bigquery.getJob(jobId));
    }
  }

  /**
   * This class demonstrates how to cancel a BigQuery Job.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/cancel">Jobs: cancel</a>
   */
  private static class CancelJobAction extends JobAction {
    @Override
    public void run(BigQuery bigquery, JobId jobId) {
      if (bigquery.cancel(jobId)) {
        System.out.println("Requested cancel for job " + jobId);
      } else {
        System.out.println("Job " + jobId + " not found");
      }
    }
  }

  private abstract static class CreateTableAction extends BigQueryAction<TableInfo> {
    @Override
    void run(BigQuery bigquery, TableInfo table) throws Exception {
      Table createTable = bigquery.create(table);
      System.out.println("Created table:");
      System.out.println(createTable.toString());
    }

    static Schema parseSchema(String[] args, int start, int end) {
      List<Field> schemaFields = new ArrayList<>();
      for (int i = start; i < end; i++) {
        String[] fieldsArray = args[i].split(":");
        if (fieldsArray.length != 2) {
          throw new IllegalArgumentException("Unrecognized field definition '" + args[i] + "'.");
        }
        String fieldName = fieldsArray[0];
        String typeString = fieldsArray[1].toLowerCase();
        LegacySQLTypeName fieldType;
        switch (typeString) {
          case "string":
            fieldType = LegacySQLTypeName.STRING;
            break;
          case "integer":
            fieldType = LegacySQLTypeName.INTEGER;
            break;
          case "timestamp":
            fieldType = LegacySQLTypeName.TIMESTAMP;
            break;
          case "float":
            fieldType = LegacySQLTypeName.FLOAT;
            break;
          case "boolean":
            fieldType = LegacySQLTypeName.BOOLEAN;
            break;
          case "bytes":
            fieldType = LegacySQLTypeName.BYTES;
            break;
          default:
            throw new IllegalArgumentException("Unrecognized field type '" + typeString + "'.");
        }
        schemaFields.add(Field.of(fieldName, fieldType));
      }
      return Schema.of(schemaFields);
    }
  }

  /**
   * This class demonstrates how to create a simple BigQuery Table (i.e. a table created from a
   * {@link StandardTableDefinition}).
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/insert">Tables: insert
   *     </a>
   */
  private static class CreateSimpleTableAction extends CreateTableAction {
    @Override
    TableInfo parse(String... args) throws Exception {
      if (args.length >= 3) {
        String dataset = args[0];
        String table = args[1];
        TableId tableId = TableId.of(dataset, table);
        return TableInfo.of(tableId, StandardTableDefinition.of(parseSchema(args, 2, args.length)));
      }
      throw new IllegalArgumentException("Missing required arguments.");
    }

    @Override
    protected String params() {
      return "<dataset> <table> (<fieldName>:<primitiveType>)+";
    }
  }

  /**
   * This class demonstrates how to create a BigQuery External Table (i.e. a table created from a
   * {@link ExternalTableDefinition}).
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/insert">Tables: insert
   *     </a>
   */
  private static class CreateExternalTableAction extends CreateTableAction {
    @Override
    TableInfo parse(String... args) throws Exception {
      if (args.length >= 5) {
        String dataset = args[0];
        String table = args[1];
        TableId tableId = TableId.of(dataset, table);
        ExternalTableDefinition externalTableDefinition =
            ExternalTableDefinition.of(args[args.length - 1],
                parseSchema(args, 3, args.length - 1), FormatOptions.of(args[2]));
        return TableInfo.of(tableId, externalTableDefinition);
      }
      throw new IllegalArgumentException("Missing required arguments.");
    }

    @Override
    protected String params() {
      return "<dataset> <table> <format> (<fieldName>:<primitiveType>)+ <sourceUri>";
    }
  }

  /**
   * This class demonstrates how to create a BigQuery View Table (i.e. a table created from a
   * {@link ViewDefinition}).
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables/insert">Tables: insert
   *     </a>
   */
  private static class CreateViewAction extends CreateTableAction {
    @Override
    TableInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 3) {
        String dataset = args[0];
        String table = args[1];
        String query = args[2];
        TableId tableId = TableId.of(dataset, table);
        return TableInfo.of(tableId, ViewDefinition.of(query));
      } else if (args.length < 3) {
        message = "Missing required dataset id, table id or query.";
      } else {
        message = "Too many arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<dataset> <table> <query>";
    }
  }

  private abstract static class JobRunAction extends BigQueryAction<JobInfo> {
    @Override
    void run(BigQuery bigquery, JobInfo job) throws Exception {
      System.out.println("Creating job");
      Job startedJob = bigquery.create(job);
      while (!startedJob.isDone()) {
        System.out.println("Waiting for job " + startedJob.getJobId().getJob() + " to complete");
        Thread.sleep(1000L);
      }
      startedJob = startedJob.reload();
      if (startedJob.getStatus().getError() == null) {
        System.out.println("Job " + startedJob.getJobId().getJob() + " succeeded");
      } else {
        System.out.println("Job " + startedJob.getJobId().getJob() + " failed");
        System.out.println("Error: " + startedJob.getStatus().getError());
      }
    }
  }

  /**
   * This class demonstrates how to create a BigQuery Load Job and wait for it to complete.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/insert">Jobs: insert</a>
   */
  private static class LoadAction extends JobRunAction {
    @Override
    JobInfo parse(String... args) throws Exception {
      if (args.length >= 4) {
        String dataset = args[0];
        String table = args[1];
        String format = args[2];
        TableId tableId = TableId.of(dataset, table);
        LoadJobConfiguration configuration = LoadJobConfiguration.of(
            tableId, Arrays.asList(args).subList(3, args.length), FormatOptions.of(format));
        return JobInfo.of(configuration);
      }
      throw new IllegalArgumentException("Missing required arguments.");
    }

    @Override
    protected String params() {
      return "<dataset> <table> <format> <sourceUri>+";
    }
  }

  /**
   * This class demonstrates how to create a BigQuery Extract Job and wait for it to complete.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/insert">Jobs: insert</a>
   */
  private static class ExtractAction extends JobRunAction {
    @Override
    JobInfo parse(String... args) throws Exception {
      if (args.length >= 4) {
        String dataset = args[0];
        String table = args[1];
        String format = args[2];
        TableId tableId = TableId.of(dataset, table);
        ExtractJobConfiguration configuration = ExtractJobConfiguration.of(
            tableId, Arrays.asList(args).subList(3, args.length), format);
        return JobInfo.of(configuration);
      }
      throw new IllegalArgumentException("Missing required arguments.");
    }

    @Override
    protected String params() {
      return "<dataset> <table> <format> <destinationUri>+";
    }
  }

  /**
   * This class demonstrates how to create a BigQuery Copy Job and wait for it to complete.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/insert">Jobs: insert</a>
   */
  private static class CopyAction extends JobRunAction {
    @Override
    JobInfo parse(String... args) throws Exception {
      String message;
      if (args.length == 4) {
        TableId sourceTableId = TableId.of(args[0], args[1]);
        TableId destinationTableId = TableId.of(args[2], args[3]);
        return JobInfo.of(CopyJobConfiguration.of(destinationTableId, sourceTableId));
      } else if (args.length < 3) {
        message = "Missing required source or destination table.";
      } else {
        message = "Too many arguments.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<sourceDataset> <sourceTable> <destinationDataset> <destinationTable>";
    }
  }

  /**
   * This class demonstrates how to run a BigQuery SQL Query and wait for associated job to
   * complete. Results or errors are shown.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/query">Jobs: query</a>
   */
  private static class QueryAction extends BigQueryAction<QueryJobConfiguration> {
    @Override
    void run(BigQuery bigquery, QueryJobConfiguration queryConfig) throws Exception {
      System.out.println("Running query");
      QueryResponse queryResponse = bigquery.query(queryConfig).getQueryResults();
      if (!queryResponse.hasErrors()) {
        System.out.println("Query succeeded. Results:");
        for (FieldValueList row : queryResponse.getResult().iterateAll()) {
          System.out.println(row);
        }
      } else {
        System.out.println("Query completed with errors. Errors:");
        for (BigQueryError err : queryResponse.getExecutionErrors()) {
          System.out.println(err);
        }
      }
    }

    @Override
    QueryJobConfiguration parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return QueryJobConfiguration.of(args[0]);
      }  else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required query.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    protected String params() {
      return "<query>";
    }
  }

  /**
   * This class demonstrates how to load data into a BigQuery Table from a local file.
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-post-request#resumable">Resumable
   *     Upload</a>
   */
  private static class LoadFileAction
      extends BigQueryAction<Tuple<WriteChannelConfiguration, String>> {
    @Override
    void run(BigQuery bigquery, Tuple<WriteChannelConfiguration, String> configuration)
        throws Exception {
      System.out.println("Running insert");
      try (FileChannel fileChannel = FileChannel.open(Paths.get(configuration.y()))) {
        WriteChannel writeChannel = bigquery.writer(configuration.x());
        long position = 0;
        long written = fileChannel.transferTo(position, CHUNK_SIZE, writeChannel);
        while (written > 0) {
          position += written;
          written = fileChannel.transferTo(position, CHUNK_SIZE, writeChannel);
        }
        writeChannel.close();
      }
    }

    @Override
    Tuple<WriteChannelConfiguration, String> parse(String... args) throws Exception {
      if (args.length == 4) {
        String dataset = args[0];
        String table = args[1];
        String format = args[2];
        TableId tableId = TableId.of(dataset, table);
        WriteChannelConfiguration configuration =
            WriteChannelConfiguration.of(tableId, FormatOptions.of(format));
        return Tuple.of(configuration, args[3]);
      }
      throw new IllegalArgumentException("Missing required arguments.");
    }

    @Override
    protected String params() {
      return "<dataset> <table> <format> <filePath>";
    }
  }

  static {
    CREATE_ACTIONS.put("dataset", new CreateDatasetAction());
    CREATE_ACTIONS.put("table", new CreateSimpleTableAction());
    CREATE_ACTIONS.put("view", new CreateViewAction());
    CREATE_ACTIONS.put("external-table", new CreateExternalTableAction());
    INFO_ACTIONS.put("dataset", new DatasetInfoAction());
    INFO_ACTIONS.put("table", new TableInfoAction());
    INFO_ACTIONS.put("job", new JobInfoAction());
    LIST_ACTIONS.put("datasets", new ListDatasetsAction());
    LIST_ACTIONS.put("tables", new ListTablesAction());
    LIST_ACTIONS.put("jobs", new ListJobsAction());
    LIST_ACTIONS.put("data", new ListTableDataAction());
    DELETE_ACTIONS.put("dataset", new DeleteDatasetAction());
    DELETE_ACTIONS.put("table", new DeleteTableAction());
    ACTIONS.put("create", new ParentAction(CREATE_ACTIONS));
    ACTIONS.put("info", new ParentAction(INFO_ACTIONS));
    ACTIONS.put("list", new ParentAction(LIST_ACTIONS));
    ACTIONS.put("delete", new ParentAction(DELETE_ACTIONS));
    ACTIONS.put("cancel", new CancelJobAction());
    ACTIONS.put("load", new LoadAction());
    ACTIONS.put("extract", new ExtractAction());
    ACTIONS.put("copy", new CopyAction());
    ACTIONS.put("query", new QueryAction());
    ACTIONS.put("load-file", new LoadFileAction());
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, BigQueryAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param.replace("\n", "\n\t\t"));
      }
    }
    System.out.printf("Usage: %s [<project_id>] operation [entity] <args>*%s%n",
        BigQueryExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    BigQueryOptions.Builder optionsBuilder = BigQueryOptions.newBuilder();
    BigQueryAction action;
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
    BigQuery bigquery = optionsBuilder.build().getService();
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
    action.run(bigquery, arg);
  }
}
