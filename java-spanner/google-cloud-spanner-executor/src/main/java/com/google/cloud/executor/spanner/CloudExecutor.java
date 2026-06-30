/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.executor.spanner.CloudClientExecutor.ExecutionFlowContext;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Preconditions;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.google.spanner.executor.v1.ChangeStreamRecord;
import com.google.spanner.executor.v1.ChildPartitionsRecord;
import com.google.spanner.executor.v1.ColumnMetadata;
import com.google.spanner.executor.v1.QueryResult;
import com.google.spanner.executor.v1.ReadResult;
import com.google.spanner.executor.v1.SpannerActionOutcome;
import com.google.spanner.executor.v1.SpannerAsyncActionResponse;
import com.google.spanner.executor.v1.TableMetadata;
import com.google.spanner.v1.StructType;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/** Superclass of cloud Java Client implementations for cloud requests. */
public abstract class CloudExecutor {

  private static final Logger LOGGER = Logger.getLogger(CloudExecutor.class.getName());

  // Pattern for a database name: projects/<project>/instances/<instance>/databases/<database>
  protected static final Pattern DB_NAME =
      Pattern.compile(
          "projects/([A-Za-z0-9-_]+)/instances/([A-Za-z0-9-_]+)/databases/([A-Za-z0-9-_]+)");

  // Project id.
  protected static final String PROJECT_ID = "spanner-cloud-systest";

  // Transport factory.
  protected static final HttpTransportFactory HTTP_TRANSPORT_FACTORY = NetHttpTransport::new;

  // Indicate whether grpc fault injector should be enabled.
  protected boolean enableGrpcFaultInjector;

  /**
   * Metadata is used to hold and retrieve metadata of tables and columns involved in a transaction.
   */
  public static class Metadata {

    private final Map<String, List<ColumnMetadata>> tableKeyColumnsInOrder;
    private final Map<String, Map<String, ColumnMetadata>> tableColumnsByName;

    /** Init metadata from list of tableMetadata in startTransaction action. */
    public Metadata(List<TableMetadata> metadata) {
      tableKeyColumnsInOrder = new HashMap<>();
      tableColumnsByName = new HashMap<>();
      for (TableMetadata table : metadata) {
        String tableName = table.getName();
        tableKeyColumnsInOrder.put(tableName, table.getKeyColumnList());
        tableColumnsByName.put(tableName, new HashMap<>());
        for (int j = 0; j < table.getColumnCount(); ++j) {
          ColumnMetadata column = table.getColumn(j);
          tableColumnsByName.get(tableName).put(column.getName(), column);
        }
      }
    }

    public List<com.google.spanner.v1.Type> getKeyColumnTypes(String tableName)
        throws SpannerException {
      if (!tableKeyColumnsInOrder.containsKey(tableName)) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "There is no metadata for table: " + tableName);
      }
      List<com.google.spanner.v1.Type> typeList = new ArrayList<>();
      List<ColumnMetadata> columns = tableKeyColumnsInOrder.get(tableName);
      for (ColumnMetadata column : columns) {
        typeList.add(column.getType());
      }
      return typeList;
    }

    /** Return column type of the given table and column. */
    public com.google.spanner.v1.Type getColumnType(String tableName, String columnName)
        throws SpannerException {
      if (!tableColumnsByName.containsKey(tableName)) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "There is no metadata for table: " + tableName);
      }
      Map<String, ColumnMetadata> columnList = tableColumnsByName.get(tableName);
      if (!columnList.containsKey(columnName)) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT,
            "Metadata for table " + tableName + " contains no column named " + columnName);
      }
      return columnList.get(columnName).getType();
    }
  }

  /**
   * OutcomeSender is a utility class used for sending action outcomes back to the client. For read
   * actions, it buffers rows and sends partial read results in batches.
   */
  public class OutcomeSender {

    private final int actionId;
    private final ExecutionFlowContext context;

    // All the relevant variables below should be set before first outcome is sent back, and unused
    // variables should leave null.
    private Timestamp timestamp;
    private boolean hasReadResult;
    private boolean hasQueryResult;
    private boolean hasChangeStreamRecords;
    private String table;
    private String index;
    private Integer requestIndex;
    private StructType rowType;

    // PartialOutcome accumulates rows and relevant information.
    private SpannerActionOutcome.Builder partialOutcomeBuilder;
    private ReadResult.Builder readResultBuilder;
    private QueryResult.Builder queryResultBuilder;

    // Current row count in Read/Query result.
    private int rowCount;
    // Modified row count in DML result.
    private final List<Long> rowsModified = new ArrayList<>();
    // Current ChangeStreamRecord count in Cloud result.
    private int changeStreamRecordCount;
    // Change stream records to be returned.
    private final List<ChangeStreamRecord> changeStreamRecords = new ArrayList<>();
    // Change stream related variables.
    private String partitionTokensString = "[";
    private String dataChangeRecordsString = "[";
    private String changeStreamForQuery = "";
    private String partitionTokenForQuery = "";

    // The timestamp in milliseconds of when the last ChangeStreamRecord received.
    private long changeStreamRecordReceivedTimestamp;
    // The heartbeat interval for the change stream query in milliseconds.
    private long changeStreamHeartbeatMilliseconds;
    // Whether the change stream query is a partitioned change stream query.
    private boolean isPartitionedChangeStreamQuery;

    // If row count exceed this value, we should send rows back in batch.
    private static final int MAX_ROWS_PER_BATCH = 100;
    // If change stream record count exceed this value, send change stream records back in batch.
    private static final int MAX_CHANGE_STREAM_RECORDS_PER_BATCH = 2000;

    public OutcomeSender(int actionId, ExecutionFlowContext context) {
      this.actionId = actionId;
      this.context = context;
      this.index = null;
      this.rowType = null;
      this.requestIndex = null;
      this.timestamp = Timestamp.newBuilder().setSeconds(0).setNanos(0).build();
    }

    /** Set the timestamp for commit. */
    public void setTimestamp(Timestamp timestamp) {
      this.timestamp = timestamp;
    }

    /** Set the rowType for appending row. */
    public void setRowType(StructType rowType) {
      this.rowType = rowType;
    }

    /** Init the sender for read action, then set the table and index if there exists. */
    public void initForRead(String table, String index) {
      this.hasReadResult = true;
      this.table = table;
      if (!index.isEmpty()) {
        this.index = index;
      }
    }

    /** Init the sender for query action. */
    public void initForQuery() {
      this.hasQueryResult = true;
    }

    /** Init the sender for batch read action, then set the table and index if there exists. */
    public void initForBatchRead(String table, String index) {
      initForRead(table, index);
      // Cloud API supports only simple batch reads (not multi reads), so request index
      // is always 0
      this.requestIndex = 0;
    }

    /** Init the sender for change stream query action. */
    public void initForChangeStreamQuery(
        long changeStreamHeartbeatMilliseconds, String changeStreamName, String partitionToken) {
      this.hasChangeStreamRecords = true;
      this.changeStreamRecordReceivedTimestamp = 0;
      this.changeStreamHeartbeatMilliseconds = changeStreamHeartbeatMilliseconds;
      this.changeStreamForQuery = changeStreamName;
      if (!partitionToken.isEmpty()) {
        this.isPartitionedChangeStreamQuery = true;
        this.partitionTokenForQuery = partitionToken;
      }
    }

    /** Update change stream record timestamp. */
    public void updateChangeStreamRecordReceivedTimestamp(
        long changeStreamRecordReceivedTimestamp) {
      this.changeStreamRecordReceivedTimestamp = changeStreamRecordReceivedTimestamp;
    }

    /** Add rows modified in DML to result. */
    public void appendRowsModifiedInDml(Long rowsModified) {
      this.rowsModified.add(rowsModified);
    }

    public long getChangeStreamRecordReceivedTimestamp() {
      return this.changeStreamRecordReceivedTimestamp;
    }

    public long getChangeStreamHeartbeatMilliSeconds() {
      return this.changeStreamHeartbeatMilliseconds;
    }

    public boolean getIsPartitionedChangeStreamQuery() {
      return this.isPartitionedChangeStreamQuery;
    }

    /** Send the last outcome with OK status. */
    public Status finishWithOK() {
      buildOutcome();
      partialOutcomeBuilder.setStatus(toProto(Status.OK));
      return flush();
    }

    /** Send the last outcome with aborted error, this will set the transactionRestarted to true. */
    public Status finishWithTransactionRestarted() {
      buildOutcome();
      partialOutcomeBuilder.setTransactionRestarted(true);
      partialOutcomeBuilder.setStatus(toProto(Status.OK));
      return flush();
    }

    /** Send the last outcome with given error status. */
    public Status finishWithError(Status err) {
      buildOutcome();
      partialOutcomeBuilder.setStatus(toProto(err));
      return flush();
    }

    /**
     * Add another row to buffer. If buffer hits its size limit, buffered rows will be sent back.
     */
    public Status appendRow(com.google.spanner.executor.v1.ValueList row) {
      if (!hasReadResult && !hasQueryResult) {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT,
                "Either hasReadResult or hasQueryResult should be true"));
      }
      if (rowType == null) {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "RowType should be set first"));
      }
      buildOutcome();
      if (hasReadResult) {
        readResultBuilder.addRow(row);
        ++rowCount;
      } else if (hasQueryResult) {
        queryResultBuilder.addRow(row);
        ++rowCount;
      }
      if (rowCount >= MAX_ROWS_PER_BATCH) {
        return flush();
      }
      return Status.OK;
    }

    /** Append change stream record to result. */
    public Status appendChangeStreamRecord(ChangeStreamRecord record) {
      if (!hasChangeStreamRecords) {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "hasChangeStreamRecords should be true"));
      }
      if (record.hasDataChange()) {
        String appendedString =
            String.format(
                "{%s, %s}, ",
                record.getDataChange().getTransactionId(),
                record.getDataChange().getRecordSequence());
        dataChangeRecordsString += appendedString;
      } else if (record.hasChildPartition()) {
        for (ChildPartitionsRecord.ChildPartition childPartition :
            record.getChildPartition().getChildPartitionsList()) {
          partitionTokensString = partitionTokensString.concat(childPartition.getToken() + ", ");
        }
      }
      buildOutcome();
      changeStreamRecords.add(record);
      ++changeStreamRecordCount;
      if (changeStreamRecordCount >= MAX_CHANGE_STREAM_RECORDS_PER_BATCH) {
        return flush();
      }
      return Status.OK;
    }

    /** Build the partialOutcome if not exists using relevant variables. */
    private void buildOutcome() {
      if (partialOutcomeBuilder != null) {
        return;
      }
      partialOutcomeBuilder = SpannerActionOutcome.newBuilder();
      partialOutcomeBuilder.setCommitTime(timestamp);
      if (hasReadResult) {
        readResultBuilder = ReadResult.newBuilder();
        readResultBuilder.setTable(table);
        if (index != null) {
          readResultBuilder.setIndex(index);
        }
        if (rowType != null) {
          readResultBuilder.setRowType(rowType);
        }
        if (requestIndex != null) {
          readResultBuilder.setRequestIndex(requestIndex);
        }
      } else if (hasQueryResult) {
        queryResultBuilder = QueryResult.newBuilder();
        if (rowType != null) {
          queryResultBuilder.setRowType(rowType);
        }
      }
    }

    /** Send partialOutcome to stream and clear the internal state. */
    private Status flush() {
      Preconditions.checkNotNull(partialOutcomeBuilder);
      for (Long rowCount : rowsModified) {
        partialOutcomeBuilder.addDmlRowsModified(rowCount);
      }
      if (hasReadResult) {
        partialOutcomeBuilder.setReadResult(readResultBuilder.build());
      } else if (hasQueryResult) {
        partialOutcomeBuilder.setQueryResult(queryResultBuilder.build());
      } else if (hasChangeStreamRecords) {
        partialOutcomeBuilder.addAllChangeStreamRecords(changeStreamRecords);
        partitionTokensString += "]\n";
        dataChangeRecordsString += "]\n";
        LOGGER.log(
            Level.INFO,
            String.format(
                "OutcomeSender with action ID %s for change stream %s and partition token %s is"
                    + " sending data change records with the following transaction id/record"
                    + " sequence combinations: %s and partition tokens: %s",
                this.changeStreamForQuery,
                this.partitionTokenForQuery,
                actionId,
                dataChangeRecordsString,
                partitionTokensString));
        partitionTokensString = "";
        dataChangeRecordsString = "";
      }
      Status status = sendOutcome(partialOutcomeBuilder.build());
      partialOutcomeBuilder = null;
      readResultBuilder = null;
      queryResultBuilder = null;
      rowCount = 0;
      rowsModified.clear();
      changeStreamRecordCount = 0;
      changeStreamRecords.clear();
      return status;
    }

    /** Send the given SpannerActionOutcome. */
    public Status sendOutcome(SpannerActionOutcome outcome) {
      try {
        LOGGER.log(Level.INFO, String.format("Sending result %s actionId %s", outcome, actionId));
        SpannerAsyncActionResponse result =
            SpannerAsyncActionResponse.newBuilder()
                .setActionId(actionId)
                .setOutcome(outcome)
                .build();
        context.onNext(result);
        LOGGER.log(Level.INFO, String.format("Sent result %s actionId %s", outcome, actionId));
      } catch (SpannerException e) {
        LOGGER.log(Level.SEVERE, "Failed to send outcome with error: " + e.getMessage(), e);
        return toStatus(e);
      } catch (Throwable t) {
        LOGGER.log(Level.SEVERE, "Failed to send outcome with error: " + t.getMessage(), t);
        return Status.fromThrowable(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "Unexpected error during rpc send: " + t));
      }
      return Status.OK;
    }
  }

  /** Map Cloud ErrorCode to Status. */
  protected Status toStatus(SpannerException e) {
    String errorMessage = e.getMessage();
    com.google.rpc.Status rpcStatus = io.grpc.protobuf.StatusProto.fromThrowable(e);
    if (rpcStatus != null) {
      if (rpcStatus.getDetailsCount() > 0) {
        errorMessage += "/n";
      }
      for (int i = 0; i < rpcStatus.getDetailsCount(); i++) {
        errorMessage += "\nError detail: " + rpcStatus.getDetails(i).toString();
      }
    }
    switch (e.getErrorCode()) {
      case INVALID_ARGUMENT:
        return Status.fromCode(Status.INVALID_ARGUMENT.getCode()).withDescription(errorMessage);
      case PERMISSION_DENIED:
        return Status.fromCode(Status.PERMISSION_DENIED.getCode()).withDescription(errorMessage);
      case ABORTED:
        return Status.fromCode(Status.ABORTED.getCode()).withDescription(errorMessage);
      case ALREADY_EXISTS:
        return Status.fromCode(Status.ALREADY_EXISTS.getCode()).withDescription(errorMessage);
      case CANCELLED:
        return Status.fromCode(Status.CANCELLED.getCode()).withDescription(errorMessage);
      case INTERNAL:
        return Status.fromCode(Status.INTERNAL.getCode())
            .withDescription(errorMessage + e.getReason() == null ? "" : ": " + e.getReason());
      case FAILED_PRECONDITION:
        return Status.fromCode(Status.FAILED_PRECONDITION.getCode()).withDescription(errorMessage);
      case NOT_FOUND:
        return Status.fromCode(Status.NOT_FOUND.getCode()).withDescription(errorMessage);
      case DEADLINE_EXCEEDED:
        return Status.fromCode(Status.DEADLINE_EXCEEDED.getCode()).withDescription(errorMessage);
      case RESOURCE_EXHAUSTED:
        return Status.fromCode(Status.RESOURCE_EXHAUSTED.getCode()).withDescription(errorMessage);
      case OUT_OF_RANGE:
        return Status.fromCode(Status.OUT_OF_RANGE.getCode()).withDescription(errorMessage);
      case UNAUTHENTICATED:
        return Status.fromCode(Status.UNAUTHENTICATED.getCode()).withDescription(errorMessage);
      case UNIMPLEMENTED:
        return Status.fromCode(Status.UNIMPLEMENTED.getCode()).withDescription(errorMessage);
      case UNAVAILABLE:
        return Status.fromCode(Status.UNAVAILABLE.getCode()).withDescription(errorMessage);
      case UNKNOWN:
        return Status.fromCode(Status.UNKNOWN.getCode()).withDescription(errorMessage);
      default:
        return Status.fromCode(Status.UNKNOWN.getCode())
            .withDescription("Unsupported Spanner error code: " + e.getErrorCode());
    }
  }

  /** Convert a Status to a Status Proto. */
  protected static com.google.rpc.Status toProto(Status status) {
    return com.google.rpc.Status.newBuilder()
        .setCode(status.getCode().value())
        .setMessage(status.getDescription() == null ? "" : status.getDescription())
        .build();
  }

  /**
   * Converts timestamp microseconds to query-friendly timestamp string. If useNanosPrecision is set
   * to true it pads input timestamp with 3 random digits treating it as timestamp nanoseconds.
   */
  protected static String timestampToString(boolean useNanosPrecision, long timestampInMicros) {
    Timestamp timestamp =
        useNanosPrecision
            ? Timestamps.fromNanos(timestampInMicros * 1000 + System.nanoTime() % 1000)
            : Timestamps.fromMicros(timestampInMicros);
    return String.format("\"%s\"", Timestamps.toString(timestamp));
  }
}
