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
import com.google.bigtable.v2.MaterializedViewRequest;
import com.google.bigtable.v2.MaterializedViewResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionCheckAndMutateRowRequest;
import com.google.bigtable.v2.SessionCheckAndMutateRowResponse;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.bigtable.v2.SessionReadRowsRequest;
import com.google.bigtable.v2.SessionReadRowsResponse;
import com.google.bigtable.v2.TableRequest;
import com.google.bigtable.v2.TableResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
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
  void testReadRows() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_ROWS.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.TABLE_SESSION);

    TableResponse tableResp =
        TableResponse.newBuilder()
            .setReadRows(
                SessionReadRowsResponse.newBuilder()
                    .addRow(Row.newBuilder().setKey(ByteString.copyFromUtf8("rowkey1"))))
            .build();
    assertThat(VRpcDescriptor.READ_ROWS.decode(tableResp.toByteString()))
        .isEqualTo(tableResp.getReadRows());

    SessionReadRowsRequest req = sampleReadRowsRequest();
    assertThat(TableRequest.parseFrom(VRpcDescriptor.READ_ROWS.encode(req)))
        .isEqualTo(TableRequest.newBuilder().setReadRows(req).build());
  }

  @Test
  void testReadRowsAuthView() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_ROWS_AUTH_VIEW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.AUTHORIZED_VIEW_SESSION);

    AuthorizedViewResponse authViewResp =
        AuthorizedViewResponse.newBuilder()
            .setReadRows(
                SessionReadRowsResponse.newBuilder()
                    .addRow(Row.newBuilder().setKey(ByteString.copyFromUtf8("rowkey1"))))
            .build();
    assertThat(VRpcDescriptor.READ_ROWS_AUTH_VIEW.decode(authViewResp.toByteString()))
        .isEqualTo(authViewResp.getReadRows());

    SessionReadRowsRequest req = sampleReadRowsRequest();
    assertThat(AuthorizedViewRequest.parseFrom(VRpcDescriptor.READ_ROWS_AUTH_VIEW.encode(req)))
        .isEqualTo(AuthorizedViewRequest.newBuilder().setReadRows(req).build());
  }

  @Test
  void testReadRowsMatView() throws InvalidProtocolBufferException {
    assertThat(VRpcDescriptor.READ_ROWS_MAT_VIEW.getSessionDescriptor())
        .isEqualTo(VRpcDescriptor.MATERIALIZED_VIEW_SESSION);

    MaterializedViewResponse matViewResp =
        MaterializedViewResponse.newBuilder()
            .setReadRows(
                SessionReadRowsResponse.newBuilder()
                    .addRow(Row.newBuilder().setKey(ByteString.copyFromUtf8("rowkey1"))))
            .build();
    assertThat(VRpcDescriptor.READ_ROWS_MAT_VIEW.decode(matViewResp.toByteString()))
        .isEqualTo(matViewResp.getReadRows());

    SessionReadRowsRequest req = sampleReadRowsRequest();
    assertThat(MaterializedViewRequest.parseFrom(VRpcDescriptor.READ_ROWS_MAT_VIEW.encode(req)))
        .isEqualTo(MaterializedViewRequest.newBuilder().setReadRows(req).build());
  }

  @Test
  void testToLegacyProtoReadRows() {
    SessionReadRowsRequest req = sampleReadRowsRequest();
    ReadRowsRequest legacyReq =
        (ReadRowsRequest) VRpcDescriptor.READ_ROWS.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.getTableName()).isEqualTo("table1");
    assertThat(legacyReq.getAuthorizedViewName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRows()).isEqualTo(req.getRows());
    assertThat(legacyReq.getFilter()).isEqualTo(req.getFilter());
    assertThat(legacyReq.getRowsLimit()).isEqualTo(req.getRowsLimit());
    assertThat(legacyReq.getReversed()).isEqualTo(req.getReversed());
  }

  @Test
  void testToLegacyProtoReadRowsAuthView() {
    SessionReadRowsRequest req = sampleReadRowsRequest();
    ReadRowsRequest legacyReq =
        (ReadRowsRequest) VRpcDescriptor.READ_ROWS_AUTH_VIEW.toLegacyProto("view1", "app1", req);
    assertThat(legacyReq.getAuthorizedViewName()).isEqualTo("view1");
    assertThat(legacyReq.getTableName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRows()).isEqualTo(req.getRows());
    assertThat(legacyReq.getFilter()).isEqualTo(req.getFilter());
    assertThat(legacyReq.getRowsLimit()).isEqualTo(req.getRowsLimit());
    assertThat(legacyReq.getReversed()).isEqualTo(req.getReversed());
  }

  @Test
  void testToLegacyProtoReadRowsMatView() {
    SessionReadRowsRequest req = sampleReadRowsRequest();
    ReadRowsRequest legacyReq =
        (ReadRowsRequest) VRpcDescriptor.READ_ROWS_MAT_VIEW.toLegacyProto("mv1", "app1", req);
    assertThat(legacyReq.getMaterializedViewName()).isEqualTo("mv1");
    assertThat(legacyReq.getTableName()).isEmpty();
    assertThat(legacyReq.getAuthorizedViewName()).isEmpty();
    assertThat(legacyReq.getAppProfileId()).isEqualTo("app1");
    assertThat(legacyReq.getRows()).isEqualTo(req.getRows());
    assertThat(legacyReq.getFilter()).isEqualTo(req.getFilter());
    assertThat(legacyReq.getRowsLimit()).isEqualTo(req.getRowsLimit());
    assertThat(legacyReq.getReversed()).isEqualTo(req.getReversed());
  }

  @Test
  void testToLegacyProtoReadRowsWithoutFilterOrLimit() {
    // Without a filter or a positive rows_limit set, the legacy converter must leave both unset.
    SessionReadRowsRequest req =
        SessionReadRowsRequest.newBuilder()
            .setRows(
                RowSet.newBuilder()
                    .addRowRanges(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("a"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("z"))))
            .build();
    ReadRowsRequest legacyReq =
        (ReadRowsRequest) VRpcDescriptor.READ_ROWS.toLegacyProto("table1", "app1", req);
    assertThat(legacyReq.hasFilter()).isFalse();
    assertThat(legacyReq.getRowsLimit()).isEqualTo(0);
    assertThat(legacyReq.getReversed()).isFalse();
    assertThat(legacyReq.getRows()).isEqualTo(req.getRows());
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

  private static SessionReadRowsRequest sampleReadRowsRequest() {
    return SessionReadRowsRequest.newBuilder()
        .setRows(
            RowSet.newBuilder()
                .addRowKeys(ByteString.copyFromUtf8("rowkey1"))
                .addRowRanges(
                    RowRange.newBuilder()
                        .setStartKeyClosed(ByteString.copyFromUtf8("a"))
                        .setEndKeyOpen(ByteString.copyFromUtf8("z"))))
        .setFilter(RowFilter.newBuilder().setBlockAllFilter(true))
        .setRowsLimit(100)
        .setReversed(true)
        .build();
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
}
