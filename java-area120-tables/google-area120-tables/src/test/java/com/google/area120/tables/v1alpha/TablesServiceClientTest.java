/*
 * Copyright 2020 Google LLC
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
package com.google.area120.tables.v1alpha;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.RowName;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.TableName;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class TablesServiceClientTest {
  private static MockTablesService mockTablesService;
  private static MockServiceHelper serviceHelper;
  private TablesServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTablesService = new MockTablesService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTablesService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    TablesServiceSettings settings =
        TablesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TablesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void getTableTest() {
    TableName name2 = TableName.of("[TABLE]");
    String displayName = "displayName1615086568";
    Table expectedResponse =
        Table.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTableRequest actualRequest = (GetTableRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";

      client.getTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTablesTest() {
    String nextPageToken = "";
    Table tablesElement = Table.newBuilder().build();
    List<Table> tables = Arrays.asList(tablesElement);
    ListTablesResponse expectedResponse =
        ListTablesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllTables(tables)
            .build();
    mockTablesService.addResponse(expectedResponse);

    ListTablesRequest request = ListTablesRequest.newBuilder().build();

    ListTablesPagedResponse pagedListResponse = client.listTables(request);

    List<Table> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTablesRequest actualRequest = (ListTablesRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      ListTablesRequest request = ListTablesRequest.newBuilder().build();

      client.listTables(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRowTest() {
    RowName name2 = RowName.of("[TABLE]", "[ROW]");
    Row expectedResponse = Row.newBuilder().setName(name2.toString()).build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    Row actualResponse = client.getRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRowRequest actualRequest = (GetRowRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";

      client.getRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listRowsTest() {
    String nextPageToken = "";
    Row rowsElement = Row.newBuilder().build();
    List<Row> rows = Arrays.asList(rowsElement);
    ListRowsResponse expectedResponse =
        ListRowsResponse.newBuilder().setNextPageToken(nextPageToken).addAllRows(rows).build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRowsPagedResponse pagedListResponse = client.listRows(parent);

    List<Row> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRowsRequest actualRequest = (ListRowsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";

      client.listRows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createRowTest() {
    RowName name = RowName.of("[TABLE]", "[ROW]");
    Row expectedResponse = Row.newBuilder().setName(name.toString()).build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Row row = Row.newBuilder().build();

    Row actualResponse = client.createRow(parent, row);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRowRequest actualRequest = (CreateRowRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(row, actualRequest.getRow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";
      Row row = Row.newBuilder().build();

      client.createRow(parent, row);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateRowsTest() {
    BatchCreateRowsResponse expectedResponse = BatchCreateRowsResponse.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateRowRequest> requests = new ArrayList<>();
    BatchCreateRowsRequest request =
        BatchCreateRowsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();

    BatchCreateRowsResponse actualResponse = client.batchCreateRows(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateRowsRequest actualRequest = (BatchCreateRowsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateRowRequest> requests = new ArrayList<>();
      BatchCreateRowsRequest request =
          BatchCreateRowsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();

      client.batchCreateRows(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateRowTest() {
    RowName name = RowName.of("[TABLE]", "[ROW]");
    Row expectedResponse = Row.newBuilder().setName(name.toString()).build();
    mockTablesService.addResponse(expectedResponse);

    Row row = Row.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Row actualResponse = client.updateRow(row, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRowRequest actualRequest = (UpdateRowRequest) actualRequests.get(0);

    Assert.assertEquals(row, actualRequest.getRow());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      Row row = Row.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateRow(row, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateRowsTest() {
    BatchUpdateRowsResponse expectedResponse = BatchUpdateRowsResponse.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<UpdateRowRequest> requests = new ArrayList<>();
    BatchUpdateRowsRequest request =
        BatchUpdateRowsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();

    BatchUpdateRowsResponse actualResponse = client.batchUpdateRows(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateRowsRequest actualRequest = (BatchUpdateRowsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchUpdateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<UpdateRowRequest> requests = new ArrayList<>();
      BatchUpdateRowsRequest request =
          BatchUpdateRowsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();

      client.batchUpdateRows(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteRowTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    RowName name = RowName.of("[TABLE]", "[ROW]");

    client.deleteRow(name);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRowRequest actualRequest = (DeleteRowRequest) actualRequests.get(0);

    Assert.assertEquals(name, RowName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      RowName name = RowName.of("[TABLE]", "[ROW]");

      client.deleteRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
