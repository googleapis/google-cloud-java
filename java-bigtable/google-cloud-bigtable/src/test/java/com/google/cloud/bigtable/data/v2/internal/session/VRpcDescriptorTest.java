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

import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
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
}
