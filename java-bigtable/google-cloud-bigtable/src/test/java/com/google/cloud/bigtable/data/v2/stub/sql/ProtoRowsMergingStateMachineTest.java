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

import static com.google.cloud.bigtable.data.v2.stub.sql.ProtoRowsMergingStateMachineSubject.assertThat;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.checksum;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapElement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSets;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.tokenOnlyResultSet;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.PartialResultSet;
import com.google.bigtable.v2.ProtoRows;
import com.google.bigtable.v2.ProtoRowsBatch;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.common.Type;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.ArrayDeque;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// Use enclosed runner so we can put parameterized and non-parameterized cases in the same test
// suite
@RunWith(Enclosed.class)
public final class ProtoRowsMergingStateMachineTest {

  public static final class IndividualTests {
    @Test
    public void stateMachine_hasCompleteBatches_falseWhenEmpty() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      assertThat(stateMachine).hasCompleteBatches(false);
    }

    @Test
    public void stateMachine_hasCompleteBatches_falseWhenAwaitingPartialBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThat(stateMachine).hasCompleteBatches(false);
    }

    @Test
    public void stateMachine_hasCompleteBatches_trueWhenAwaitingBatchConsume() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      stateMachine.addPartialResultSet(partialResultSetWithToken(stringValue("bar")).getResults());
      assertThat(stateMachine).hasCompleteBatches(true);
    }

    @Test
    public void stateMachine_isBatchInProgress_falseWhenEmpty() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      assertThat(stateMachine).isBatchInProgress(false);
    }

    @Test
    public void stateMachine_isBatchInProgress_trueWhenAwaitingPartialBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThat(stateMachine).isBatchInProgress(true);
    }

    @Test
    public void stateMachine_isBatchInProgress_trueWhenAwaitingBatchConsume() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThat(stateMachine).isBatchInProgress(true);
    }

    @Test
    public void stateMachine_consumeRow_throwsExceptionWhenColumnsArentComplete() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(columnMetadata("a", stringType()), columnMetadata("b", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      // this is a valid partial result set so we don't expect an error until we call populateQueue
      stateMachine.addPartialResultSet(partialResultSetWithToken(stringValue("foo")).getResults());
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));
    }

    @Test
    public void stateMachine_consumeRow_throwsExceptionWhenAwaitingPartialBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      // this doesn't have a token so we shouldn't allow results to be processed
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));
    }

    @Test
    public void stateMachine_mergesPartialBatches() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      List<ExecuteQueryResponse> partialBatches =
          partialResultSets(3, stringValue("foo"), stringValue("bar"), stringValue("baz"));
      for (ExecuteQueryResponse res : partialBatches) {
        stateMachine.addPartialResultSet(res.getResults());
      }

      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("foo"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("bar"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("baz"))));
    }

    @Test
    public void stateMachine_mergesPartialBatches_withRandomChunks() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(columnMetadata("map", mapType(stringType(), bytesType()))));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      Value mapVal =
          mapValue(
              mapElement(
                  stringValue(Strings.repeat("a", 10)), bytesValue(Strings.repeat("aVal", 100))),
              mapElement(stringValue("b"), bytesValue(Strings.repeat("bVal", 100))));
      ProtoRows rows = ProtoRows.newBuilder().addValues(mapVal).build();
      ByteString chunk1 = rows.toByteString().substring(0, 100);
      ByteString chunk2 = rows.toByteString().substring(100);

      stateMachine.addPartialResultSet(
          PartialResultSet.newBuilder()
              .setProtoRowsBatch(ProtoRowsBatch.newBuilder().setBatchData(chunk1).build())
              .build());
      stateMachine.addPartialResultSet(
          PartialResultSet.newBuilder()
              .setResumeToken(ByteString.copyFromUtf8("token"))
              .setProtoRowsBatch(ProtoRowsBatch.newBuilder().setBatchData(chunk2).build())
              .setBatchChecksum(checksum(rows.toByteString()))
              .build());

      assertThat(stateMachine)
          .populateQueueYields(ProtoSqlRow.create(metadata, ImmutableList.of(mapVal)));
    }

    @Test
    public void stateMachine_reconstructsRowWithMultipleColumns() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(
                  columnMetadata("a", stringType()),
                  columnMetadata("b", bytesType()),
                  columnMetadata("c", arrayType(stringType())),
                  columnMetadata("d", mapType(stringType(), bytesType()))));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      Value stringVal = stringValue("test");
      stateMachine.addPartialResultSet(partialResultSetWithoutToken(stringVal).getResults());
      Value bytesVal = bytesValue("bytes");
      stateMachine.addPartialResultSet(partialResultSetWithoutToken(bytesVal).getResults());
      Value arrayVal = arrayValue(stringValue("foo"), stringValue("bar"));
      stateMachine.addPartialResultSet(partialResultSetWithoutToken(arrayVal).getResults());
      Value mapVal =
          mapValue(
              mapElement(stringValue("a"), bytesValue("aVal")),
              mapElement(stringValue("b"), bytesValue("bVal")));
      stateMachine.addPartialResultSet(partialResultSetWithToken(mapVal).getResults());

      assertThat(stateMachine).hasCompleteBatches(true);
      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(
                  metadata, ImmutableList.of(stringVal, bytesVal, arrayVal, mapVal)));

      // Once we consume a completed row the state machine should be reset
      assertThat(stateMachine).hasCompleteBatches(false);
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));
      assertThat(stateMachine).isBatchInProgress(false);
    }

    @Test
    public void stateMachine_throwsExceptionWhenValuesDontMatchSchema() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(columnMetadata("a", stringType()), columnMetadata("b", bytesType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      // values in wrong order
      stateMachine.addPartialResultSet(
          partialResultSetWithToken(bytesValue("test"), stringValue("test")).getResults());
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));
    }

    @Test
    public void stateMachine_handlesResumeTokenWithNoValues() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      stateMachine.addPartialResultSet(partialResultSetWithToken().getResults());
      assertThat(stateMachine).populateQueueYields(new ProtoSqlRow[] {});
    }

    @Test
    public void stateMachine_handlesResumeTokenWithOpenBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("test")).getResults());
      stateMachine.addPartialResultSet(
          tokenOnlyResultSet(ByteString.copyFromUtf8("token")).getResults());
      assertThat(stateMachine)
          .populateQueueYields(ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("test"))));
    }

    @Test
    public void addPartialResultSet_throwsExceptionWhenAwaitingRowConsume() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(partialResultSetWithToken(stringValue("test")).getResults());

      assertThrows(
          IllegalStateException.class,
          () ->
              stateMachine.addPartialResultSet(
                  partialResultSetWithToken(stringValue("test2")).getResults()));
    }

    @Test
    public void stateMachine_throwsExceptionOnChecksumMismatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      List<ExecuteQueryResponse> responses =
          partialResultSets(3, stringValue("foo"), stringValue("bar"), stringValue("baz"));

      // Override the checksum of the final response
      PartialResultSet lastResultsWithBadChecksum =
          responses.get(2).getResults().toBuilder().setBatchChecksum(1234).build();

      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(responses.get(0).getResults());
      stateMachine.addPartialResultSet(responses.get(1).getResults());

      assertThrows(
          IllegalStateException.class,
          () -> stateMachine.addPartialResultSet(lastResultsWithBadChecksum));
    }

    @Test
    public void stateMachine_handlesResetOnPartialBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      // Initial response here has reset bit set
      List<ExecuteQueryResponse> responses =
          partialResultSets(3, stringValue("foo"), stringValue("bar"), stringValue("baz"));

      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      stateMachine.addPartialResultSet(responses.get(0).getResults());
      stateMachine.addPartialResultSet(responses.get(1).getResults());

      // The two results above should be discarded by reset
      for (ExecuteQueryResponse response : responses) {
        stateMachine.addPartialResultSet(response.getResults());
      }

      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("foo"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("bar"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("baz"))));
    }

    @Test
    public void stateMachine_handlesResetWithUncommittedBatches() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      // Create 2 batches split into multiple chunks. Neither containing a resume token
      List<ExecuteQueryResponse> firstBatch =
          partialResultSets(
              2,
              true,
              ByteString.EMPTY,
              stringValue("foo"),
              stringValue("bar"),
              stringValue("baz"));
      List<ExecuteQueryResponse> secondBatch =
          partialResultSets(
              3, false, ByteString.EMPTY, stringValue("a"), stringValue("b"), stringValue("c"));

      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      for (ExecuteQueryResponse res : firstBatch) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      for (ExecuteQueryResponse res : secondBatch) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      // Nothing should be yielded yet
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));

      List<ExecuteQueryResponse> resetBatch =
          partialResultSets(
              2,
              true,
              ByteString.EMPTY,
              stringValue("foo2"),
              stringValue("bar2"),
              stringValue("baz2"));
      List<ExecuteQueryResponse> batchAfterReset =
          partialResultSets(
              3,
              false,
              ByteString.copyFromUtf8("token"),
              stringValue("a2"),
              stringValue("b2"),
              stringValue("c2"));
      for (ExecuteQueryResponse res : resetBatch) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      for (ExecuteQueryResponse res : batchAfterReset) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("foo2"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("bar2"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("baz2"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("a2"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("b2"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("c2"))));
    }

    @Test
    public void stateMachine_handlesMultipleCompleteBatchesBeforeToken() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      // Create 2 batches split into multiple chunks. Neither containing a resume token
      List<ExecuteQueryResponse> firstBatch =
          partialResultSets(
              2,
              true,
              ByteString.EMPTY,
              stringValue("foo"),
              stringValue("bar"),
              stringValue("baz"));
      List<ExecuteQueryResponse> secondBatch =
          partialResultSets(
              3, false, ByteString.EMPTY, stringValue("a"), stringValue("b"), stringValue("c"));

      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);
      for (ExecuteQueryResponse res : firstBatch) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      for (ExecuteQueryResponse res : secondBatch) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      // Nothing should be yielded yet
      assertThrows(
          IllegalStateException.class, () -> stateMachine.populateQueue(new ArrayDeque<>()));
      ExecuteQueryResponse resultWithToken = partialResultSetWithToken(stringValue("final"));
      stateMachine.addPartialResultSet(resultWithToken.getResults());
      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("foo"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("bar"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("baz"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("a"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("b"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("c"))),
              ProtoSqlRow.create(metadata, ImmutableList.of(stringValue("final"))));
    }

    @Test
    public void stateMachine_throwsExceptionWithChecksumButNoData() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      PartialResultSet invalid = PartialResultSet.newBuilder().setBatchChecksum(1234).build();
      assertThrows(IllegalStateException.class, () -> stateMachine.addPartialResultSet(invalid));
    }

    @Test
    public void stateMachine_resolvesMetadataOnlyAfterFirstToken() {
      final boolean[] metadataHasBeenAccessed = {false};
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine =
          new ProtoRowsMergingStateMachine(
              () -> {
                // hacky way to check if supplier has been resolved
                // This is in an array so the variable can be final
                metadataHasBeenAccessed[0] = true;
                return metadata;
              });

      stateMachine.addPartialResultSet(partialResultSetWithoutToken(stringValue("s")).getResults());
      assertFalse(metadataHasBeenAccessed[0]);
      stateMachine.addPartialResultSet(partialResultSetWithToken(stringValue("b")).getResults());
      assertTrue(metadataHasBeenAccessed[0]);
    }

    @Test
    public void stateMachine_handlesSchemaChangeAfterResetOfInitialBatch() {
      SettableApiFuture<ResultSetMetadata> mdFuture = SettableApiFuture.create();
      ProtoRowsMergingStateMachine stateMachine =
          new ProtoRowsMergingStateMachine(
              () -> ApiExceptions.callAndTranslateApiException(mdFuture));
      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("discard")).getResults());

      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(columnMetadata("a", bytesType()), columnMetadata("b", int64Type())));
      mdFuture.set(metadata);
      List<ExecuteQueryResponse> retryResponses =
          partialResultSets(2, bytesValue("bytes"), int64Value(123));
      for (ExecuteQueryResponse res : retryResponses) {
        stateMachine.addPartialResultSet(res.getResults());
      }
      assertThat(stateMachine)
          .populateQueueYields(
              ProtoSqlRow.create(metadata, ImmutableList.of(bytesValue("bytes"), int64Value(123))));
    }

    @Test
    public void stateMachine_throwsExceptionWithTokenAndIncompleteBatch() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      List<ExecuteQueryResponse> responses =
          partialResultSets(2, stringValue("foo"), stringValue("bar"));
      stateMachine.addPartialResultSet(responses.get(0).getResults());
      // We haven't added the second response above, this should error
      assertThrows(
          IllegalStateException.class,
          () ->
              stateMachine.addPartialResultSet(
                  tokenOnlyResultSet(ByteString.copyFromUtf8("token")).getResults()));
    }

    @Test
    public void isBatchInProgress_trueWithUncommitedCompleteBatches() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThat(stateMachine).isBatchInProgress(true);
    }

    @Test
    public void hasCompleteBatches_falseWithUncommitedCompleteBatches() {
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(metadata(columnMetadata("a", stringType())));
      ProtoRowsMergingStateMachine stateMachine = new ProtoRowsMergingStateMachine(() -> metadata);

      stateMachine.addPartialResultSet(
          partialResultSetWithoutToken(stringValue("foo")).getResults());
      assertThat(stateMachine).hasCompleteBatches(false);
    }
  }

  @RunWith(Parameterized.class)
  public static final class ParameterizedTests {

    public ParameterizedTests(SqlType.Code typeCode) {
      this.typeCase = typeCode;
    }

    private final SqlType.Code typeCase;

    @Parameters
    public static SqlType.Code[] valueTypes() {
      return SqlType.Code.values();
    }

    @Test
    @SuppressWarnings("UnnecessaryDefaultInEnumSwitch")
    public void testValidateSupportsAllTypes() {
      switch (typeCase) {
        case STRING:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.string(), bytesValue("test")));
          break;
        case BYTES:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.bytes(), stringValue("test")));
          break;
        case INT64:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.int64(), stringValue("test")));
          break;
        case BOOL:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.bool(), stringValue("test")));
          break;
        case FLOAT32:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.float32(), stringValue("test")));
          break;
        case FLOAT64:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.float64(), stringValue("test")));
          break;
        case TIMESTAMP:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.timestamp(), stringValue("test")));
          break;
        case DATE:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.date(), stringValue("test")));
          break;
        case ARRAY:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.arrayOf(SqlType.string()), stringValue("test")));
          // It should check nested values match
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.arrayOf(SqlType.string()),
                      arrayValue(stringValue("test"), bytesValue("test"))));
          break;
        case STRUCT:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.fromProto(structType(stringType(), bytesType())),
                      stringValue("test")));
          // It should check nested values match
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.fromProto(structType(stringType(), bytesType())),
                      structValue(stringValue("test"), stringValue("test"))));
          break;
        case MAP:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.mapOf(SqlType.string(), SqlType.string()), stringValue("test")));
          // It should check nested values match
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.mapOf(SqlType.string(), SqlType.bytes()),
                      mapValue(
                          mapElement(stringValue("key"), bytesValue("val")),
                          mapElement(stringValue("key2"), stringValue("val2")))));
          // It should check all map elements contain only one key and one value because map
          // elements
          // are represented as structs which are represented as an array of fields.
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      SqlType.mapOf(SqlType.string(), SqlType.bytes()),
                      mapValue(
                          mapElement(stringValue("key"), bytesValue("val")),
                          structValue(
                              stringValue("key2"), bytesValue("val2"), bytesValue("val3")))));
          break;
        case PROTO:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      Type.SchemalessProto.create("test"), stringValue("test")));
          break;
        case ENUM:
          assertThrows(
              IllegalStateException.class,
              () ->
                  ProtoRowsMergingStateMachine.validateValueAndType(
                      Type.SchemalessEnum.create("test"), bytesValue("val")));
          break;
        default:
          assertWithMessage(
                  "Unknown TypeCase "
                      + typeCase.name()
                      + " seen. Check if"
                      + " SerializedProtoRowsMergingStateMachine.validateValueAndType supports all"
                      + " types.")
              .fail();
      }
    }
  }
}
