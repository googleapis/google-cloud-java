/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListWorkspacesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.ColumnDescription;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.RowName;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.TableName;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
import com.google.area120.tables.v1alpha1.WorkspaceName;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TablesServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTablesService mockTablesService;
  private LocalChannelProvider channelProvider;
  private TablesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTablesService = new MockTablesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTablesService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void getTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(TableName.of("[TABLE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllColumns(new ArrayList<ColumnDescription>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    TableName name = TableName.of("[TABLE]");

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTableRequest actualRequest = ((GetTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      TableName name = TableName.of("[TABLE]");
      client.getTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTableTest2() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(TableName.of("[TABLE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllColumns(new ArrayList<ColumnDescription>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTableRequest actualRequest = ((GetTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";
      client.getTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTablesTest() throws Exception {
    Table responsesElement = Table.newBuilder().build();
    ListTablesResponse expectedResponse =
        ListTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockTablesService.addResponse(expectedResponse);

    ListTablesRequest request =
        ListTablesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListTablesPagedResponse pagedListResponse = client.listTables(request);

    List<Table> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTablesRequest actualRequest = ((ListTablesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      ListTablesRequest request =
          ListTablesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listTables(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkspaceTest() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(WorkspaceName.of("[WORKSPACE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTables(new ArrayList<Table>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    WorkspaceName name = WorkspaceName.of("[WORKSPACE]");

    Workspace actualResponse = client.getWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkspaceRequest actualRequest = ((GetWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkspaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      WorkspaceName name = WorkspaceName.of("[WORKSPACE]");
      client.getWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkspaceTest2() throws Exception {
    Workspace expectedResponse =
        Workspace.newBuilder()
            .setName(WorkspaceName.of("[WORKSPACE]").toString())
            .setDisplayName("displayName1714148973")
            .addAllTables(new ArrayList<Table>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    Workspace actualResponse = client.getWorkspace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkspaceRequest actualRequest = ((GetWorkspaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkspaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkspace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkspacesTest() throws Exception {
    Workspace responsesElement = Workspace.newBuilder().build();
    ListWorkspacesResponse expectedResponse =
        ListWorkspacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkspaces(Arrays.asList(responsesElement))
            .build();
    mockTablesService.addResponse(expectedResponse);

    ListWorkspacesRequest request =
        ListWorkspacesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListWorkspacesPagedResponse pagedListResponse = client.listWorkspaces(request);

    List<Workspace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkspacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkspacesRequest actualRequest = ((ListWorkspacesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkspacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      ListWorkspacesRequest request =
          ListWorkspacesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listWorkspaces(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRowTest() throws Exception {
    Row expectedResponse =
        Row.newBuilder()
            .setName(RowName.of("[TABLE]", "[ROW]").toString())
            .putAllValues(new HashMap<String, Value>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    RowName name = RowName.of("[TABLE]", "[ROW]");

    Row actualResponse = client.getRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRowRequest actualRequest = ((GetRowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      RowName name = RowName.of("[TABLE]", "[ROW]");
      client.getRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRowTest2() throws Exception {
    Row expectedResponse =
        Row.newBuilder()
            .setName(RowName.of("[TABLE]", "[ROW]").toString())
            .putAllValues(new HashMap<String, Value>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    Row actualResponse = client.getRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRowRequest actualRequest = ((GetRowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";
      client.getRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRowsTest() throws Exception {
    Row responsesElement = Row.newBuilder().build();
    ListRowsResponse expectedResponse =
        ListRowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRows(Arrays.asList(responsesElement))
            .build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRowsPagedResponse pagedListResponse = client.listRows(parent);

    List<Row> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRowsRequest actualRequest = ((ListRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRowTest() throws Exception {
    Row expectedResponse =
        Row.newBuilder()
            .setName(RowName.of("[TABLE]", "[ROW]").toString())
            .putAllValues(new HashMap<String, Value>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Row row = Row.newBuilder().build();

    Row actualResponse = client.createRow(parent, row);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRowRequest actualRequest = ((CreateRowRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(row, actualRequest.getRow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String parent = "parent-995424086";
      Row row = Row.newBuilder().build();
      client.createRow(parent, row);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateRowsTest() throws Exception {
    BatchCreateRowsResponse expectedResponse =
        BatchCreateRowsResponse.newBuilder().addAllRows(new ArrayList<Row>()).build();
    mockTablesService.addResponse(expectedResponse);

    BatchCreateRowsRequest request =
        BatchCreateRowsRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllRequests(new ArrayList<CreateRowRequest>())
            .build();

    BatchCreateRowsResponse actualResponse = client.batchCreateRows(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateRowsRequest actualRequest = ((BatchCreateRowsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      BatchCreateRowsRequest request =
          BatchCreateRowsRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllRequests(new ArrayList<CreateRowRequest>())
              .build();
      client.batchCreateRows(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRowTest() throws Exception {
    Row expectedResponse =
        Row.newBuilder()
            .setName(RowName.of("[TABLE]", "[ROW]").toString())
            .putAllValues(new HashMap<String, Value>())
            .build();
    mockTablesService.addResponse(expectedResponse);

    Row row = Row.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Row actualResponse = client.updateRow(row, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRowRequest actualRequest = ((UpdateRowRequest) actualRequests.get(0));

    Assert.assertEquals(row, actualRequest.getRow());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      Row row = Row.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRow(row, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateRowsTest() throws Exception {
    BatchUpdateRowsResponse expectedResponse =
        BatchUpdateRowsResponse.newBuilder().addAllRows(new ArrayList<Row>()).build();
    mockTablesService.addResponse(expectedResponse);

    BatchUpdateRowsRequest request =
        BatchUpdateRowsRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllRequests(new ArrayList<UpdateRowRequest>())
            .build();

    BatchUpdateRowsResponse actualResponse = client.batchUpdateRows(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateRowsRequest actualRequest = ((BatchUpdateRowsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      BatchUpdateRowsRequest request =
          BatchUpdateRowsRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllRequests(new ArrayList<UpdateRowRequest>())
              .build();
      client.batchUpdateRows(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    RowName name = RowName.of("[TABLE]", "[ROW]");

    client.deleteRow(name);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRowRequest actualRequest = ((DeleteRowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      RowName name = RowName.of("[TABLE]", "[ROW]");
      client.deleteRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRow(name);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRowRequest actualRequest = ((DeleteRowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteRowsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTablesService.addResponse(expectedResponse);

    BatchDeleteRowsRequest request =
        BatchDeleteRowsRequest.newBuilder()
            .setParent(TableName.of("[TABLE]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    client.batchDeleteRows(request);

    List<AbstractMessage> actualRequests = mockTablesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteRowsRequest actualRequest = ((BatchDeleteRowsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTablesService.addException(exception);

    try {
      BatchDeleteRowsRequest request =
          BatchDeleteRowsRequest.newBuilder()
              .setParent(TableName.of("[TABLE]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchDeleteRows(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
