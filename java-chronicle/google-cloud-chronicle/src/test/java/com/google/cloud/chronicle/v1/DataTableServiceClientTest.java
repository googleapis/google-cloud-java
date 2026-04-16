/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DataTableServiceClientTest {
  private static MockDataTableService mockDataTableService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataTableServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataTableService = new MockDataTableService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataTableService));
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
    DataTableServiceSettings settings =
        DataTableServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTableServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataTableTest() throws Exception {
    DataTable expectedResponse =
        DataTable.newBuilder()
            .setName(
                DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllColumnInfo(new ArrayList<DataTableColumnInfo>())
            .setDataTableUuid("dataTableUuid501169183")
            .addAllRules(new ArrayList<String>())
            .setRuleAssociationsCount(-1522562875)
            .setRowTimeToLive("rowTimeToLive1780890798")
            .setApproximateRowCount(-297926913)
            .setScopeInfo(DataTableScopeInfo.newBuilder().build())
            .setUpdateSource(DataTableUpdateSource.forNumber(0))
            .setRowTimeToLiveUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataTable dataTable = DataTable.newBuilder().build();
    String dataTableId = "dataTableId1260854911";

    DataTable actualResponse = client.createDataTable(parent, dataTable, dataTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTableRequest actualRequest = ((CreateDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataTable, actualRequest.getDataTable());
    Assert.assertEquals(dataTableId, actualRequest.getDataTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      DataTable dataTable = DataTable.newBuilder().build();
      String dataTableId = "dataTableId1260854911";
      client.createDataTable(parent, dataTable, dataTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataTableTest2() throws Exception {
    DataTable expectedResponse =
        DataTable.newBuilder()
            .setName(
                DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllColumnInfo(new ArrayList<DataTableColumnInfo>())
            .setDataTableUuid("dataTableUuid501169183")
            .addAllRules(new ArrayList<String>())
            .setRuleAssociationsCount(-1522562875)
            .setRowTimeToLive("rowTimeToLive1780890798")
            .setApproximateRowCount(-297926913)
            .setScopeInfo(DataTableScopeInfo.newBuilder().build())
            .setUpdateSource(DataTableUpdateSource.forNumber(0))
            .setRowTimeToLiveUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataTable dataTable = DataTable.newBuilder().build();
    String dataTableId = "dataTableId1260854911";

    DataTable actualResponse = client.createDataTable(parent, dataTable, dataTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTableRequest actualRequest = ((CreateDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataTable, actualRequest.getDataTable());
    Assert.assertEquals(dataTableId, actualRequest.getDataTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataTable dataTable = DataTable.newBuilder().build();
      String dataTableId = "dataTableId1260854911";
      client.createDataTable(parent, dataTable, dataTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTablesTest() throws Exception {
    DataTable responsesElement = DataTable.newBuilder().build();
    ListDataTablesResponse expectedResponse =
        ListDataTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTables(Arrays.asList(responsesElement))
            .build();
    mockDataTableService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataTablesPagedResponse pagedListResponse = client.listDataTables(parent);

    List<DataTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTablesRequest actualRequest = ((ListDataTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listDataTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTablesTest2() throws Exception {
    DataTable responsesElement = DataTable.newBuilder().build();
    ListDataTablesResponse expectedResponse =
        ListDataTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTables(Arrays.asList(responsesElement))
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataTablesPagedResponse pagedListResponse = client.listDataTables(parent);

    List<DataTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTablesRequest actualRequest = ((ListDataTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTablesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableTest() throws Exception {
    DataTable expectedResponse =
        DataTable.newBuilder()
            .setName(
                DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllColumnInfo(new ArrayList<DataTableColumnInfo>())
            .setDataTableUuid("dataTableUuid501169183")
            .addAllRules(new ArrayList<String>())
            .setRuleAssociationsCount(-1522562875)
            .setRowTimeToLive("rowTimeToLive1780890798")
            .setApproximateRowCount(-297926913)
            .setScopeInfo(DataTableScopeInfo.newBuilder().build())
            .setUpdateSource(DataTableUpdateSource.forNumber(0))
            .setRowTimeToLiveUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName name = DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");

    DataTable actualResponse = client.getDataTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableRequest actualRequest = ((GetDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName name =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      client.getDataTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableTest2() throws Exception {
    DataTable expectedResponse =
        DataTable.newBuilder()
            .setName(
                DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllColumnInfo(new ArrayList<DataTableColumnInfo>())
            .setDataTableUuid("dataTableUuid501169183")
            .addAllRules(new ArrayList<String>())
            .setRuleAssociationsCount(-1522562875)
            .setRowTimeToLive("rowTimeToLive1780890798")
            .setApproximateRowCount(-297926913)
            .setScopeInfo(DataTableScopeInfo.newBuilder().build())
            .setUpdateSource(DataTableUpdateSource.forNumber(0))
            .setRowTimeToLiveUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String name = "name3373707";

    DataTable actualResponse = client.getDataTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableRequest actualRequest = ((GetDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataTableTest() throws Exception {
    DataTable expectedResponse =
        DataTable.newBuilder()
            .setName(
                DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllColumnInfo(new ArrayList<DataTableColumnInfo>())
            .setDataTableUuid("dataTableUuid501169183")
            .addAllRules(new ArrayList<String>())
            .setRuleAssociationsCount(-1522562875)
            .setRowTimeToLive("rowTimeToLive1780890798")
            .setApproximateRowCount(-297926913)
            .setScopeInfo(DataTableScopeInfo.newBuilder().build())
            .setUpdateSource(DataTableUpdateSource.forNumber(0))
            .setRowTimeToLiveUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTable dataTable = DataTable.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTable actualResponse = client.updateDataTable(dataTable, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataTableRequest actualRequest = ((UpdateDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(dataTable, actualRequest.getDataTable());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTable dataTable = DataTable.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataTable(dataTable, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataTableTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName name = DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    boolean force = true;

    client.deleteDataTable(name, force);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTableRequest actualRequest = ((DeleteDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName name =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      boolean force = true;
      client.deleteDataTable(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataTableTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTableService.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteDataTable(name, force);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTableRequest actualRequest = ((DeleteDataTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteDataTable(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataTableRowTest() throws Exception {
    DataTableRow expectedResponse =
        DataTableRow.newBuilder()
            .setName(
                DataTableRowName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRowTimeToLive("rowTimeToLive1780890798")
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    DataTableRow dataTableRow = DataTableRow.newBuilder().build();

    DataTableRow actualResponse = client.createDataTableRow(parent, dataTableRow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTableRowRequest actualRequest = ((CreateDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataTableRow, actualRequest.getDataTableRow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTableRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      DataTableRow dataTableRow = DataTableRow.newBuilder().build();
      client.createDataTableRow(parent, dataTableRow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataTableRowTest2() throws Exception {
    DataTableRow expectedResponse =
        DataTableRow.newBuilder()
            .setName(
                DataTableRowName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRowTimeToLive("rowTimeToLive1780890798")
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataTableRow dataTableRow = DataTableRow.newBuilder().build();

    DataTableRow actualResponse = client.createDataTableRow(parent, dataTableRow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTableRowRequest actualRequest = ((CreateDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataTableRow, actualRequest.getDataTableRow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTableRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataTableRow dataTableRow = DataTableRow.newBuilder().build();
      client.createDataTableRow(parent, dataTableRow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataTableRowTest() throws Exception {
    DataTableRow expectedResponse =
        DataTableRow.newBuilder()
            .setName(
                DataTableRowName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRowTimeToLive("rowTimeToLive1780890798")
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableRow dataTableRow = DataTableRow.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTableRow actualResponse = client.updateDataTableRow(dataTableRow, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataTableRowRequest actualRequest = ((UpdateDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(dataTableRow, actualRequest.getDataTableRow());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataTableRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableRow dataTableRow = DataTableRow.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataTableRow(dataTableRow, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTableRowsTest() throws Exception {
    DataTableRow responsesElement = DataTableRow.newBuilder().build();
    ListDataTableRowsResponse expectedResponse =
        ListDataTableRowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTableRows(Arrays.asList(responsesElement))
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");

    ListDataTableRowsPagedResponse pagedListResponse = client.listDataTableRows(parent);

    List<DataTableRow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTableRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTableRowsRequest actualRequest = ((ListDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTableRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      client.listDataTableRows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTableRowsTest2() throws Exception {
    DataTableRow responsesElement = DataTableRow.newBuilder().build();
    ListDataTableRowsResponse expectedResponse =
        ListDataTableRowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTableRows(Arrays.asList(responsesElement))
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataTableRowsPagedResponse pagedListResponse = client.listDataTableRows(parent);

    List<DataTableRow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTableRowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTableRowsRequest actualRequest = ((ListDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTableRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataTableRows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableRowTest() throws Exception {
    DataTableRow expectedResponse =
        DataTableRow.newBuilder()
            .setName(
                DataTableRowName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRowTimeToLive("rowTimeToLive1780890798")
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableRowName name =
        DataTableRowName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");

    DataTableRow actualResponse = client.getDataTableRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableRowRequest actualRequest = ((GetDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableRowName name =
          DataTableRowName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");
      client.getDataTableRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableRowTest2() throws Exception {
    DataTableRow expectedResponse =
        DataTableRow.newBuilder()
            .setName(
                DataTableRowName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRowTimeToLive("rowTimeToLive1780890798")
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String name = "name3373707";

    DataTableRow actualResponse = client.getDataTableRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableRowRequest actualRequest = ((GetDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataTableRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataTableRowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableRowName name =
        DataTableRowName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");

    client.deleteDataTableRow(name);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTableRowRequest actualRequest = ((DeleteDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTableRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableRowName name =
          DataTableRowName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");
      client.deleteDataTableRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataTableRowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataTableService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataTableRow(name);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTableRowRequest actualRequest = ((DeleteDataTableRowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTableRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataTableRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkCreateDataTableRowsTest() throws Exception {
    BulkCreateDataTableRowsResponse expectedResponse =
        BulkCreateDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkCreateDataTableRowsResponse actualResponse =
        client.bulkCreateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkCreateDataTableRowsRequest actualRequest =
        ((BulkCreateDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkCreateDataTableRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      List<CreateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkCreateDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkCreateDataTableRowsTest2() throws Exception {
    BulkCreateDataTableRowsResponse expectedResponse =
        BulkCreateDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkCreateDataTableRowsResponse actualResponse =
        client.bulkCreateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkCreateDataTableRowsRequest actualRequest =
        ((BulkCreateDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkCreateDataTableRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkCreateDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkGetDataTableRowsTest() throws Exception {
    BulkGetDataTableRowsResponse expectedResponse =
        BulkGetDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<GetDataTableRowRequest> requests = new ArrayList<>();

    BulkGetDataTableRowsResponse actualResponse = client.bulkGetDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkGetDataTableRowsRequest actualRequest =
        ((BulkGetDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkGetDataTableRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      List<GetDataTableRowRequest> requests = new ArrayList<>();
      client.bulkGetDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkGetDataTableRowsTest2() throws Exception {
    BulkGetDataTableRowsResponse expectedResponse =
        BulkGetDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<GetDataTableRowRequest> requests = new ArrayList<>();

    BulkGetDataTableRowsResponse actualResponse = client.bulkGetDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkGetDataTableRowsRequest actualRequest =
        ((BulkGetDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkGetDataTableRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<GetDataTableRowRequest> requests = new ArrayList<>();
      client.bulkGetDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkReplaceDataTableRowsTest() throws Exception {
    BulkReplaceDataTableRowsResponse expectedResponse =
        BulkReplaceDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkReplaceDataTableRowsResponse actualResponse =
        client.bulkReplaceDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkReplaceDataTableRowsRequest actualRequest =
        ((BulkReplaceDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkReplaceDataTableRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      List<CreateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkReplaceDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkReplaceDataTableRowsTest2() throws Exception {
    BulkReplaceDataTableRowsResponse expectedResponse =
        BulkReplaceDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkReplaceDataTableRowsResponse actualResponse =
        client.bulkReplaceDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkReplaceDataTableRowsRequest actualRequest =
        ((BulkReplaceDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkReplaceDataTableRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkReplaceDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkUpdateDataTableRowsTest() throws Exception {
    BulkUpdateDataTableRowsResponse expectedResponse =
        BulkUpdateDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<UpdateDataTableRowRequest> requests = new ArrayList<>();

    BulkUpdateDataTableRowsResponse actualResponse =
        client.bulkUpdateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkUpdateDataTableRowsRequest actualRequest =
        ((BulkUpdateDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkUpdateDataTableRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      List<UpdateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkUpdateDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkUpdateDataTableRowsTest2() throws Exception {
    BulkUpdateDataTableRowsResponse expectedResponse =
        BulkUpdateDataTableRowsResponse.newBuilder()
            .addAllDataTableRows(new ArrayList<DataTableRow>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<UpdateDataTableRowRequest> requests = new ArrayList<>();

    BulkUpdateDataTableRowsResponse actualResponse =
        client.bulkUpdateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkUpdateDataTableRowsRequest actualRequest =
        ((BulkUpdateDataTableRowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkUpdateDataTableRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<UpdateDataTableRowRequest> requests = new ArrayList<>();
      client.bulkUpdateDataTableRows(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableOperationErrorsTest() throws Exception {
    DataTableOperationErrors expectedResponse =
        DataTableOperationErrors.newBuilder()
            .setName(
                DataTableOperationErrorsName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]")
                    .toString())
            .addAllRpcErrors(new ArrayList<Status>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    DataTableOperationErrorsName name =
        DataTableOperationErrorsName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]");

    DataTableOperationErrors actualResponse = client.getDataTableOperationErrors(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableOperationErrorsRequest actualRequest =
        ((GetDataTableOperationErrorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableOperationErrorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      DataTableOperationErrorsName name =
          DataTableOperationErrorsName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]");
      client.getDataTableOperationErrors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTableOperationErrorsTest2() throws Exception {
    DataTableOperationErrors expectedResponse =
        DataTableOperationErrors.newBuilder()
            .setName(
                DataTableOperationErrorsName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]")
                    .toString())
            .addAllRpcErrors(new ArrayList<Status>())
            .build();
    mockDataTableService.addResponse(expectedResponse);

    String name = "name3373707";

    DataTableOperationErrors actualResponse = client.getDataTableOperationErrors(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTableService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTableOperationErrorsRequest actualRequest =
        ((GetDataTableOperationErrorsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTableOperationErrorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTableService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataTableOperationErrors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
