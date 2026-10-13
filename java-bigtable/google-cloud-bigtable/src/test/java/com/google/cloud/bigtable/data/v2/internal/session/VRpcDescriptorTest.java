/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.AuthorizedViewRequest;
import com.google.bigtable.v2.AuthorizedViewResponse;
import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.Idempotency;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.SessionCheckAndMutateRowRequest;
import com.google.bigtable.v2.SessionCheckAndMutateRowResponse;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionReadModifyWriteRowRequest;
import com.google.bigtable.v2.SessionReadModifyWriteRowResponse;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.bigtable.v2.TableRequest;
import com.google.bigtable.v2.TableResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Status;
import org.junit.jupiter.api.Test;

class VRpcDescriptorTest {

  @Test
  void testReadRow() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_ROW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.TABLE_SESSION);

    TableResponse tableResp =
        TableResponse.newBuilder()
            .setReadRow(
                SessionReadRowResponse.newBuilder()
                    .setRow(
                        Row.newBuilder()
                            .setKey(ByteString.copyFromUtf8("rowkey1"))
                            .addFamilies(
                                Family.newBuilder()
                                    .setName("f")
                                    .addColumns(
                                        Column.newBuilder()
                                            .addCells(
                                                Cell.newBuilder()
                                                    .setTimestampMicros(12345)
                                                    .setValue(ByteString.copyFromUtf8("value")))))))
            .build();
    assertThat(VRpcDescriptor.READ_ROW.decode(tableResp.toByteString()))
        .isEqualTo(tableResp.getReadRow());

    SessionReadRowRequest req =
        SessionReadRowRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8("rowkey1"))
            .setFilter(RowFilter.newBuilder().setBlockAllFilter(true))
            .build();
    assertThat(TableRequest.parseFrom(VRpcDescriptor.READ_ROW.encode(req)))
        .isEqualTo(TableRequest.newBuilder().setReadRow(req).build());
  }

  @Test
  void testToLegacyProtoReadRow() {
    SessionReadRowRequest req =
        SessionReadRowRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8("rowkey1"))
            .setFilter(RowFilter.newBuilder().setBlockAllFilter(true))
            .build();
    ReadRowsRequest legacyReq =
        (ReadRowsRequest) VRpcDescriptor.READ_ROW.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRows().getRowKeys(0)).isEqualTo(req.getKey());
    assertThat(legacyReq.getFilter()).isEqualTo(req.getFilter());
    assertThat(legacyReq.getRowsLimit()).isEqualTo(1);
  }

  @Test
  void testToLegacyProtoMutateRow() {
    SessionMutateRowRequest req =
        SessionMutateRowRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8("rowkey1"))
            .addMutations(
                Mutation.newBuilder()
                    .setSetCell(
                        Mutation.SetCell.newBuilder()
                            .setFamilyName("f")
                            .setColumnQualifier(ByteString.copyFromUtf8("c"))
                            .setValue(ByteString.copyFromUtf8("v"))))
            .build();
    MutateRowRequest legacyReq =
        (MutateRowRequest) VRpcDescriptor.MUTATE_ROW.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRowKey()).isEqualTo(req.getKey());
    assertThat(legacyReq.getMutationsList()).isEqualTo(req.getMutationsList());
  }

  @Test
  void testCheckAndMutateRow() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.CHECK_AND_MUTATE_ROW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.TABLE_SESSION);

    TableResponse tableResp =
        TableResponse.newBuilder()
            .setCheckAndMutateRow(
                SessionCheckAndMutateRowResponse.newBuilder().setPredicateMatched(true))
            .build();
    assertThat(VRpcDescriptor.CHECK_AND_MUTATE_ROW.decode(tableResp.toByteString()))
        .isEqualTo(tableResp.getCheckAndMutateRow());

    SessionCheckAndMutateRowRequest req = sampleCheckAndMutateRowRequest();
    assertThat(TableRequest.parseFrom(VRpcDescriptor.CHECK_AND_MUTATE_ROW.encode(req)))
        .isEqualTo(TableRequest.newBuilder().setCheckAndMutateRow(req).build());
  }

  @Test
  void testCheckAndMutateRowAuthView() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.CHECK_AND_MUTATE_ROW_AUTH_VIEW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.AUTHORIZED_VIEW_SESSION);

    AuthorizedViewResponse authViewResp =
        AuthorizedViewResponse.newBuilder()
            .setCheckAndMutateRow(
                SessionCheckAndMutateRowResponse.newBuilder().setPredicateMatched(false))
            .build();
    assertThat(VRpcDescriptor.CHECK_AND_MUTATE_ROW_AUTH_VIEW.decode(authViewResp.toByteString()))
        .isEqualTo(authViewResp.getCheckAndMutateRow());

    SessionCheckAndMutateRowRequest req = sampleCheckAndMutateRowRequest();
    assertThat(
            AuthorizedViewRequest.parseFrom(
                VRpcDescriptor.CHECK_AND_MUTATE_ROW_AUTH_VIEW.encode(req)))
        .isEqualTo(AuthorizedViewRequest.newBuilder().setCheckAndMutateRow(req).build());
  }

  @Test
  void testToLegacyProtoCheckAndMutateRow() {
    SessionCheckAndMutateRowRequest req = sampleCheckAndMutateRowRequest();
    CheckAndMutateRowRequest legacyReq =
        (CheckAndMutateRowRequest)
            VRpcDescriptor.CHECK_AND_MUTATE_ROW.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAuthorizedViewName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRowKey()).isEqualTo(req.getKey());
    assertThat(legacyReq.getPredicateFilter()).isEqualTo(req.getPredicateFilter());
    assertThat(legacyReq.getTrueMutationsList()).isEqualTo(req.getTrueMutationsList());
    assertThat(legacyReq.getFalseMutationsList()).isEqualTo(req.getFalseMutationsList());
  }

  @Test
  void testToLegacyProtoCheckAndMutateRowAuthView() {
    SessionCheckAndMutateRowRequest req = sampleCheckAndMutateRowRequest();
    CheckAndMutateRowRequest legacyReq =
        (CheckAndMutateRowRequest)
            VRpcDescriptor.CHECK_AND_MUTATE_ROW_AUTH_VIEW.toLegacyProto("view1", "app1", req);
    assertThat(legacyReq.getAuthorizedViewName()).isEqualTo("view1");
    assertThat(legacyReq.getTableName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRowKey()).isEqualTo(req.getKey());
    assertThat(legacyReq.getPredicateFilter()).isEqualTo(req.getPredicateFilter());
    assertThat(legacyReq.getTrueMutationsList()).isEqualTo(req.getTrueMutationsList());
    assertThat(legacyReq.getFalseMutationsList()).isEqualTo(req.getFalseMutationsList());
  }

  @Test
  void testToLegacyProtoCheckAndMutateRowWithoutPredicate() {
    // Without a predicate filter set, the legacy converter must leave predicate_filter unset.
    SessionCheckAndMutateRowRequest req =
        SessionCheckAndMutateRowRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8("rowkey1"))
            .addTrueMutations(sampleSetCell())
            .build();
    CheckAndMutateRowRequest legacyReq =
        (CheckAndMutateRowRequest)
            VRpcDescriptor.CHECK_AND_MUTATE_ROW.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.hasPredicateFilter()).isFalse();
    assertThat(legacyReq.getTrueMutationsList()).isEqualTo(req.getTrueMutationsList());
    assertThat(legacyReq.getFalseMutationsList()).isEmpty();
  }

  private static SessionCheckAndMutateRowRequest sampleCheckAndMutateRowRequest() {
    return SessionCheckAndMutateRowRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8("rowkey1"))
        .setPredicateFilter(RowFilter.newBuilder().setBlockAllFilter(true))
        .addTrueMutations(sampleSetCell())
        .addFalseMutations(
            Mutation.newBuilder().setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance()))
        .build();
  }

  private static Mutation sampleSetCell() {
    return Mutation.newBuilder()
        .setSetCell(
            Mutation.SetCell.newBuilder()
                .setFamilyName("f")
                .setColumnQualifier(ByteString.copyFromUtf8("c"))
                .setValue(ByteString.copyFromUtf8("v")))
        .build();
  }

  @Test
  void testReadModifyWriteRow() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_MODIFY_WRITE_ROW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.TABLE_SESSION);

    TableResponse tableResp =
        TableResponse.newBuilder()
            .setReadModifyWriteRow(
                SessionReadModifyWriteRowResponse.newBuilder()
                    .setRow(Row.newBuilder().setKey(ByteString.copyFromUtf8("rowkey1"))))
            .build();
    assertThat(VRpcDescriptor.READ_MODIFY_WRITE_ROW.decode(tableResp.toByteString()))
        .isEqualTo(tableResp.getReadModifyWriteRow());

    SessionReadModifyWriteRowRequest req = sampleReadModifyWriteRowRequest();
    assertThat(TableRequest.parseFrom(VRpcDescriptor.READ_MODIFY_WRITE_ROW.encode(req)))
        .isEqualTo(TableRequest.newBuilder().setReadModifyWriteRow(req).build());
  }

  @Test
  void testReadModifyWriteRowAuthView() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_MODIFY_WRITE_ROW_AUTH_VIEW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.AUTHORIZED_VIEW_SESSION);

    AuthorizedViewResponse authViewResp =
        AuthorizedViewResponse.newBuilder()
            .setReadModifyWriteRow(
                SessionReadModifyWriteRowResponse.newBuilder()
                    .setRow(Row.newBuilder().setKey(ByteString.copyFromUtf8("rowkey1"))))
            .build();
    assertThat(VRpcDescriptor.READ_MODIFY_WRITE_ROW_AUTH_VIEW.decode(authViewResp.toByteString()))
        .isEqualTo(authViewResp.getReadModifyWriteRow());

    SessionReadModifyWriteRowRequest req = sampleReadModifyWriteRowRequest();
    assertThat(
            AuthorizedViewRequest.parseFrom(
                VRpcDescriptor.READ_MODIFY_WRITE_ROW_AUTH_VIEW.encode(req)))
        .isEqualTo(AuthorizedViewRequest.newBuilder().setReadModifyWriteRow(req).build());
  }

  @Test
  void testToLegacyProtoReadModifyWriteRow() {
    SessionReadModifyWriteRowRequest req = sampleReadModifyWriteRowRequest();
    ReadModifyWriteRowRequest legacyReq =
        (ReadModifyWriteRowRequest)
            VRpcDescriptor.READ_MODIFY_WRITE_ROW.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAuthorizedViewName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRowKey()).isEqualTo(req.getKey());
    assertThat(legacyReq.getRulesList()).isEqualTo(req.getRulesList());
  }

  @Test
  void testToLegacyProtoReadModifyWriteRowAuthView() {
    SessionReadModifyWriteRowRequest req = sampleReadModifyWriteRowRequest();
    ReadModifyWriteRowRequest legacyReq =
        (ReadModifyWriteRowRequest)
            VRpcDescriptor.READ_MODIFY_WRITE_ROW_AUTH_VIEW.toLegacyProto("view1", "app1", req);
    assertThat(legacyReq.getAuthorizedViewName()).isEqualTo("view1");
    assertThat(legacyReq.getTableName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRowKey()).isEqualTo(req.getKey());
    assertThat(legacyReq.getRulesList()).isEqualTo(req.getRulesList());
  }

  private static SessionReadModifyWriteRowRequest sampleReadModifyWriteRowRequest() {
    return SessionReadModifyWriteRowRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8("rowkey1"))
        .addRules(
            ReadModifyWriteRule.newBuilder()
                .setFamilyName("f")
                .setColumnQualifier(ByteString.copyFromUtf8("c"))
                .setAppendValue(ByteString.copyFromUtf8("v")))
        .addRules(
            ReadModifyWriteRule.newBuilder()
                .setFamilyName("f")
                .setColumnQualifier(ByteString.copyFromUtf8("c2"))
                .setIncrementAmount(1))
        .build();
  }

  @Test
  void testMutateRows() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.MUTATE_ROWS.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.TABLE_SESSION);

    TableResponse tableResp =
        TableResponse.newBuilder()
            .setMutateRows(
                SessionMutateRowsResponse.newBuilder()
                    .addEntries(
                        SessionMutateRowsResponse.Entry.newBuilder()
                            .setIndex(0)
                            .setStatus(Status.newBuilder().setCode(0).build())))
            .build();
    assertThat(VRpcDescriptor.MUTATE_ROWS.decode(tableResp.toByteString()))
        .isEqualTo(tableResp.getMutateRows());

    SessionMutateRowsRequest req = sampleMutateRowsRequest();
    assertThat(TableRequest.parseFrom(VRpcDescriptor.MUTATE_ROWS.encode(req)))
        .isEqualTo(TableRequest.newBuilder().setMutateRows(req).build());
  }

  @Test
  void testMutateRowsAuthView() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.MUTATE_ROWS_AUTH_VIEW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.AUTHORIZED_VIEW_SESSION);

    AuthorizedViewResponse authViewResp =
        AuthorizedViewResponse.newBuilder()
            .setMutateRows(
                SessionMutateRowsResponse.newBuilder()
                    .addEntries(
                        SessionMutateRowsResponse.Entry.newBuilder()
                            .setIndex(0)
                            .setStatus(Status.newBuilder().setCode(0).build())))
            .build();
    assertThat(VRpcDescriptor.MUTATE_ROWS_AUTH_VIEW.decode(authViewResp.toByteString()))
        .isEqualTo(authViewResp.getMutateRows());

    SessionMutateRowsRequest req = sampleMutateRowsRequest();
    assertThat(AuthorizedViewRequest.parseFrom(VRpcDescriptor.MUTATE_ROWS_AUTH_VIEW.encode(req)))
        .isEqualTo(AuthorizedViewRequest.newBuilder().setMutateRows(req).build());
  }

  @Test
  void testToLegacyProtoMutateRows() {
    SessionMutateRowsRequest req = sampleMutateRowsRequest();
    MutateRowsRequest legacyReq =
        (MutateRowsRequest) VRpcDescriptor.MUTATE_ROWS.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAuthorizedViewName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getEntriesCount()).isEqualTo(1);
    assertThat(legacyReq.getEntries(0).getRowKey()).isEqualTo(req.getEntries(0).getKey());
    assertThat(legacyReq.getEntries(0).getMutationsList())
        .isEqualTo(req.getEntries(0).getMutationsList());
  }

  @Test
  void testToLegacyProtoMutateRowsAuthView() {
    SessionMutateRowsRequest req = sampleMutateRowsRequest();
    MutateRowsRequest legacyReq =
        (MutateRowsRequest)
            VRpcDescriptor.MUTATE_ROWS_AUTH_VIEW.toLegacyProto("view1", "app1", req);
    assertThat(legacyReq.getAuthorizedViewName()).isEqualTo("view1");
    assertThat(legacyReq.getTableName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getEntriesCount()).isEqualTo(1);
    assertThat(legacyReq.getEntries(0).getRowKey()).isEqualTo(req.getEntries(0).getKey());
    assertThat(legacyReq.getEntries(0).getMutationsList())
        .isEqualTo(req.getEntries(0).getMutationsList());
  }

  @Test
  void testToLegacyProtoMutateRowsWithIdempotency() {
    Idempotency idempotency =
        Idempotency.newBuilder().setToken(ByteString.copyFromUtf8("token123")).build();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .setKey(ByteString.copyFromUtf8("rowkey1"))
                    .addMutations(sampleSetCell())
                    .setIdempotency(idempotency))
            .build();
    MutateRowsRequest legacyReq =
        (MutateRowsRequest) VRpcDescriptor.MUTATE_ROWS.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getEntries(0).hasIdempotency()).isTrue();
    assertThat(legacyReq.getEntries(0).getIdempotency()).isEqualTo(idempotency);
  }

  private static SessionMutateRowsRequest sampleMutateRowsRequest() {
    return SessionMutateRowsRequest.newBuilder()
        .addEntries(
            SessionMutateRowsRequest.Entry.newBuilder()
                .setKey(ByteString.copyFromUtf8("rowkey1"))
                .addMutations(sampleSetCell()))
        .build();
  }
}
