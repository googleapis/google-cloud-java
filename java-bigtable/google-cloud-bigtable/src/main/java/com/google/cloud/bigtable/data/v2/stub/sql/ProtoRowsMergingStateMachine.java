/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.PartialResultSet;
import com.google.bigtable.v2.ProtoRows;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.ColumnMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Used to transform a stream of {@link com.google.bigtable.v2.ProtoRowsBatch} bytes chunks into
 * {@link ProtoSqlRow}s for the given schema. Each SqlRow represents a logical row for a sql
 * response.
 *
 * <p>The intended usage of this class is:
 *
 * <ul>
 *   <li>Add results with {@link #addPartialResultSet(PartialResultSet)} until {@link
 *       #hasCompleteBatches()} is true
 *   <li>Call {@link #populateQueue(Queue)} to materialize results from the complete batch.
 *   <li>Repeat until all {@link PartialResultSet}s have been processed
 *   <li>Ensure that there is no incomplete data using {@link #isBatchInProgress()}
 * </ul>
 *
 * <p>Package-private for internal use. This class is not thread safe.
 */
@InternalApi
final class ProtoRowsMergingStateMachine {
  enum State {
    /** Waiting for data to be added to the state machine */
    AWAITING_NEW_DATA,
    /** Buffering a complete set of rows, waiting for populateQueue to be called */
    AWAITING_BATCH_CONSUME,
  }

  private static final HashFunction CRC32C = Hashing.crc32c();

  private final Supplier<ResultSetMetadata> metadataSupplier;
  private @Nullable ResultSetMetadata metadata;
  private State state;
  private ByteString batchBuffer;
  private List<List<Value>> parsedBatches;
  private boolean hasReceivedFirstResumeToken;

  ProtoRowsMergingStateMachine(Supplier<ResultSetMetadata> metadataSupplier) {
    this.metadataSupplier = metadataSupplier;
    state = State.AWAITING_NEW_DATA;
    batchBuffer = ByteString.empty();
    parsedBatches = new ArrayList<>();
    hasReceivedFirstResumeToken = false;
  }

  /**
   * Adds the bytes from the given PartialResultSet to the current buffer. If a resume token is
   * present, attempts to parse the bytes to the underlying protobuf row format
   *
   * <p>See the comments on {@link PartialResultSet} protobuf message definition for explanation of
   * the protocol implemented below.
   *
   * <pre>Translated to use local variable names the expected logic is as follows:
   * if results.reset {
   *   reset batchBuffer
   *   reset parsedBatches
   * }
   * if results.proto_rows_batch is set {
   *   append result.proto_rows_batch.batch_data to batchBuffer
   * }
   * if results.batch_checksum is set {
   *   validate the checksum matches the crc32c hash of batchBuffer
   *   parse batchBuffer as a ProtoRows message, clearing batchBuffer
   *   add the parsed data to parsedBatches
   * }
   * if results.resume_token is set {
   *   yield the results in parsedBatches to the row merger.
   *   this is controlled by the AWAITING_BATCH_CONSUME state.
   * }
   * </pre>
   */
  void addPartialResultSet(PartialResultSet results) {
    Preconditions.checkState(
        state != State.AWAITING_BATCH_CONSUME,
        "Attempting to add partial result set to state machine in state AWAITING_BATCH_CONSUME");
    // If the API indicates we should reset we need to clear buffered data
    if (results.getReset()) {
      batchBuffer = ByteString.EMPTY;
      parsedBatches.clear();
    }
    // ByteString has an efficient concat which generally involves no copying
    batchBuffer = batchBuffer.concat(results.getProtoRowsBatch().getBatchData());
    if (results.hasBatchChecksum()) {
      HashCode hash = CRC32C.hashBytes(batchBuffer.toByteArray());
      Preconditions.checkState(
          hash.hashCode() == results.getBatchChecksum(), "Unexpected checksum mismatch");
      try {
        ProtoRows completeBatch = ProtoRows.parseFrom(batchBuffer);
        batchBuffer = ByteString.EMPTY;
        parsedBatches.add(completeBatch.getValuesList());
      } catch (InvalidProtocolBufferException e) {
        throw new InternalError("Unexpected exception parsing response protobuf", e);
      }
    }
    boolean hasResumeToken = !results.getResumeToken().isEmpty();
    if (hasResumeToken) {
      if (!hasReceivedFirstResumeToken) {
        // Don't resolve the metadata until we receive the first resume token.
        // This is safe because we only use the metadata in populateQueue, which can't be called
        // until we receive a resume token. For details on why this is necessary, see
        // MetadataResolvingCallable
        metadata = metadataSupplier.get();
        hasReceivedFirstResumeToken = true;
      }
      Preconditions.checkState(
          batchBuffer.isEmpty(), "Received resumeToken with buffered data and no checksum");
      state = State.AWAITING_BATCH_CONSUME;
    }
  }

  /** Returns true if there are complete batches, ready to yield. False otherwise */
  boolean hasCompleteBatches() {
    return state == State.AWAITING_BATCH_CONSUME;
  }

  /** Returns true if there is a partial or complete batch buffered, false otherwise */
  boolean isBatchInProgress() {
    boolean hasBufferedData = !batchBuffer.isEmpty() || !parsedBatches.isEmpty();
    return hasCompleteBatches() || hasBufferedData;
  }

  /**
   * Populates the given queue with the currently buffered rows of rows
   *
   * @throws IllegalStateException if there is no yieldable data
   */
  void populateQueue(Queue<SqlRow> queue) {
    Preconditions.checkState(
        state == State.AWAITING_BATCH_CONSUME,
        "Attempting to populate Queue from state machine without completed batch");
    Preconditions.checkState(
        batchBuffer.isEmpty(), "Unexpected buffered partial batch while consuming rows.");
    Preconditions.checkNotNull(metadata, "Unexpected empty metadata when parsing response");

    Iterator<Value> valuesIterator = Iterables.concat(parsedBatches).iterator();
    while (valuesIterator.hasNext()) {
      ImmutableList.Builder<Value> rowDataBuilder = ImmutableList.builder();
      for (ColumnMetadata c : metadata.getColumns()) {
        Preconditions.checkState(
            valuesIterator.hasNext(), "Incomplete row received with first missing column: %s", c);
        Value v = valuesIterator.next();
        validateValueAndType(c.type(), v);
        rowDataBuilder.add(v);
      }
      queue.add(ProtoSqlRow.create(metadata, rowDataBuilder.build()));
    }
    this.parsedBatches = new ArrayList<>();
    state = State.AWAITING_NEW_DATA;
  }

  @InternalApi("VisibleForTestingOnly")
  static void validateValueAndType(SqlType<?> type, Value value) {
    // Null is represented as a value with none of the kind fields set
    if (value.getKindCase() == Value.KindCase.KIND_NOT_SET) {
      return;
    }
    switch (type.getCode()) {
      // Primitive types
      case STRING:
        checkExpectedKind(value, Value.KindCase.STRING_VALUE, type);
        break;
      case BYTES:
        checkExpectedKind(value, Value.KindCase.BYTES_VALUE, type);
        break;
      case INT64:
        checkExpectedKind(value, Value.KindCase.INT_VALUE, type);
        break;
      case FLOAT64:
      case FLOAT32:
        checkExpectedKind(value, Value.KindCase.FLOAT_VALUE, type);
        break;
      case BOOL:
        checkExpectedKind(value, Value.KindCase.BOOL_VALUE, type);
        break;
      case TIMESTAMP:
        checkExpectedKind(value, Value.KindCase.TIMESTAMP_VALUE, type);
        break;
      case DATE:
        checkExpectedKind(value, Value.KindCase.DATE_VALUE, type);
        break;
      // Complex types
      case ARRAY:
        checkExpectedKind(value, Value.KindCase.ARRAY_VALUE, type);
        SqlType.Array<?> arrayType = (SqlType.Array<?>) type;
        SqlType<?> elemType = arrayType.getElementType();
        for (Value element : value.getArrayValue().getValuesList()) {
          validateValueAndType(elemType, element);
        }
        break;
      case STRUCT:
        checkExpectedKind(value, Value.KindCase.ARRAY_VALUE, type);
        List<Value> fieldValues = value.getArrayValue().getValuesList();
        SqlType.Struct structType = (SqlType.Struct) type;
        if (fieldValues.size() != structType.getFields().size()) {
          throw new IllegalStateException(
              String.format(
                  "Unexpected malformed struct data. Expected %s fields, received: %s",
                  structType.getFields().size(), fieldValues.size()));
        }
        for (int i = 0; i < fieldValues.size(); i++) {
          validateValueAndType(structType.getType(i), fieldValues.get(i));
        }
        break;
      case MAP:
        checkExpectedKind(value, Value.KindCase.ARRAY_VALUE, type);
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        for (Value mapElement : value.getArrayValue().getValuesList()) {
          Preconditions.checkState(
              mapElement.getArrayValue().getValuesCount() == 2,
              "Map elements must have exactly 2 elementss");
          validateValueAndType(
              mapType.getKeyType(), mapElement.getArrayValue().getValuesList().get(0));
          validateValueAndType(
              mapType.getValueType(), mapElement.getArrayValue().getValuesList().get(1));
        }
        break;
      case PROTO:
        checkExpectedKind(value, Value.KindCase.BYTES_VALUE, type);
      case ENUM:
        checkExpectedKind(value, Value.KindCase.INT_VALUE, type);
      default:
        // This should be caught already at ResultSetMetadata creation
        throw new IllegalStateException("Unrecognized type: " + type);
    }
  }

  private static void checkExpectedKind(Value value, Value.KindCase expectedKind, SqlType<?> type) {
    Preconditions.checkState(
        value.getKindCase() == expectedKind,
        "Value kind must be %s for columns of type: %s",
        expectedKind.name(),
        type);
  }
}
