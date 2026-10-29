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
package com.google.cloud.bigtable.testproxy;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.testproxy.CbtTestProxy.CbtClient;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.rpc.Code;
import io.grpc.stub.StreamObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;

@RunWith(JUnit4.class)
public class CbtTestProxyTest {

  private static final String CLIENT_ID = "test-client";
  private static final String TABLE_NAME =
      "projects/my-project/instances/my-instance/tables/my-table";
  private static final String TABLE_ID = "my-table";

  private BigtableDataClient mockDataClient;
  private CbtTestProxy proxy;

  @Before
  public void setUp() {
    mockDataClient = mock(BigtableDataClient.class);
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(8080)
            .setProjectId("my-project")
            .setInstanceId("my-instance")
            .build();
    proxy = CbtTestProxy.create();
    proxy.idClientMap.put(CLIENT_ID, CbtClient.create(settings, mockDataClient));
  }

  @Test
  public void testReadRowNotFoundEmitsEmptyRowResultWithOkStatus() {
    when(mockDataClient.readRow(eq(TABLE_ID), eq("missing-row"), any(Filter.class)))
        .thenReturn(null);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadRowRequest request =
        ReadRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setTableName(TABLE_NAME)
            .setRowKey("missing-row")
            .build();

    proxy.readRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isFalse();
  }

  @Test
  public void testReadRowFoundEmitsPopulatedRowResultWithOkStatus() {
    Row row =
        Row.create(
            ByteString.copyFromUtf8("row-1"),
            ImmutableList.of(
                RowCell.create(
                    "cf",
                    ByteString.copyFromUtf8("col"),
                    1000L,
                    ImmutableList.of(),
                    ByteString.copyFromUtf8("val"))));
    when(mockDataClient.readRow(eq(TABLE_ID), eq("row-1"), any(Filter.class))).thenReturn(row);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadRowRequest request =
        ReadRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setTableName(TABLE_NAME)
            .setRowKey("row-1")
            .build();

    proxy.readRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isTrue();
    assertThat(result.getRow().getKey()).isEqualTo(ByteString.copyFromUtf8("row-1"));
  }

  @Test
  public void testReadModifyWriteRowNullEmitsEmptyRowResultWithOkStatus() {
    when(mockDataClient.readModifyWriteRow(any(ReadModifyWriteRow.class))).thenReturn(null);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadModifyWriteRowRequest request =
        ReadModifyWriteRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.ReadModifyWriteRowRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .setRowKey(ByteString.copyFromUtf8("rmw-row"))
                    .addRules(
                        ReadModifyWriteRule.newBuilder()
                            .setFamilyName("cf")
                            .setColumnQualifier(ByteString.copyFromUtf8("col"))
                            .setAppendValue(ByteString.copyFromUtf8("v"))))
            .build();

    proxy.readModifyWriteRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isFalse();
  }
}
