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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonDataTableServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataTableServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataTableServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataTableServiceStub.getMethodDescriptors(),
            DataTableServiceSettings.getDefaultEndpoint());
    DataTableServiceSettings settings =
        DataTableServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataTableServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTableServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    DataTable dataTable = DataTable.newBuilder().build();
    String dataTableId = "dataTableId1260854911";

    DataTable actualResponse = client.createDataTable(parent, dataTable, dataTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDataTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    DataTable dataTable = DataTable.newBuilder().build();
    String dataTableId = "dataTableId1260854911";

    DataTable actualResponse = client.createDataTable(parent, dataTable, dataTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDataTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListDataTablesPagedResponse pagedListResponse = client.listDataTables(parent);

    List<DataTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTablesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataTablesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListDataTablesPagedResponse pagedListResponse = client.listDataTables(parent);

    List<DataTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTablesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataTablesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    DataTableName name = DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");

    DataTable actualResponse = client.getDataTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7157/locations/location-7157/instances/instance-7157/dataTables/dataTable-7157";

    DataTable actualResponse = client.getDataTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7157/locations/location-7157/instances/instance-7157/dataTables/dataTable-7157";
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
    mockService.addResponse(expectedResponse);

    DataTable dataTable =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTable actualResponse = client.updateDataTable(dataTable, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDataTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTable dataTable =
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
    mockService.addResponse(expectedResponse);

    DataTableName name = DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    boolean force = true;

    client.deleteDataTable(name, force);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDataTableExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7157/locations/location-7157/instances/instance-7157/dataTables/dataTable-7157";
    boolean force = true;

    client.deleteDataTable(name, force);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDataTableExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7157/locations/location-7157/instances/instance-7157/dataTables/dataTable-7157";
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    DataTableRow dataTableRow = DataTableRow.newBuilder().build();

    DataTableRow actualResponse = client.createDataTableRow(parent, dataTableRow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDataTableRowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
    DataTableRow dataTableRow = DataTableRow.newBuilder().build();

    DataTableRow actualResponse = client.createDataTableRow(parent, dataTableRow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDataTableRowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableRow dataTableRow =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTableRow actualResponse = client.updateDataTableRow(dataTableRow, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDataTableRowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataTableRow dataTableRow =
          DataTableRow.newBuilder()
              .setName(
                  DataTableRowName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[INSTANCE]",
                          "[DATA_TABLE]",
                          "[DATA_TABLE_ROW]")
                      .toString())
              .addAllValues(new ArrayList<String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setRowTimeToLive("rowTimeToLive1780890798")
              .build();
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");

    ListDataTableRowsPagedResponse pagedListResponse = client.listDataTableRows(parent);

    List<DataTableRow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTableRowsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataTableRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";

    ListDataTableRowsPagedResponse pagedListResponse = client.listDataTableRows(parent);

    List<DataTableRow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTableRowsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDataTableRowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableRowName name =
        DataTableRowName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");

    DataTableRow actualResponse = client.getDataTableRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableRowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5010/locations/location-5010/instances/instance-5010/dataTables/dataTable-5010/dataTableRows/dataTableRow-5010";

    DataTableRow actualResponse = client.getDataTableRow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableRowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5010/locations/location-5010/instances/instance-5010/dataTables/dataTable-5010/dataTableRows/dataTableRow-5010";
      client.getDataTableRow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataTableRowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataTableRowName name =
        DataTableRowName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");

    client.deleteDataTableRow(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDataTableRowExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5010/locations/location-5010/instances/instance-5010/dataTables/dataTable-5010/dataTableRows/dataTableRow-5010";

    client.deleteDataTableRow(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDataTableRowExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5010/locations/location-5010/instances/instance-5010/dataTables/dataTable-5010/dataTableRows/dataTableRow-5010";
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkCreateDataTableRowsResponse actualResponse =
        client.bulkCreateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkCreateDataTableRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkCreateDataTableRowsResponse actualResponse =
        client.bulkCreateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkCreateDataTableRowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<GetDataTableRowRequest> requests = new ArrayList<>();

    BulkGetDataTableRowsResponse actualResponse = client.bulkGetDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkGetDataTableRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
    List<GetDataTableRowRequest> requests = new ArrayList<>();

    BulkGetDataTableRowsResponse actualResponse = client.bulkGetDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkGetDataTableRowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkReplaceDataTableRowsResponse actualResponse =
        client.bulkReplaceDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkReplaceDataTableRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
    List<CreateDataTableRowRequest> requests = new ArrayList<>();

    BulkReplaceDataTableRowsResponse actualResponse =
        client.bulkReplaceDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkReplaceDataTableRowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableName parent =
        DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
    List<UpdateDataTableRowRequest> requests = new ArrayList<>();

    BulkUpdateDataTableRowsResponse actualResponse =
        client.bulkUpdateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkUpdateDataTableRowsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
    List<UpdateDataTableRowRequest> requests = new ArrayList<>();

    BulkUpdateDataTableRowsResponse actualResponse =
        client.bulkUpdateDataTableRows(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void bulkUpdateDataTableRowsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-90/locations/location-90/instances/instance-90/dataTables/dataTable-90";
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
    mockService.addResponse(expectedResponse);

    DataTableOperationErrorsName name =
        DataTableOperationErrorsName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]");

    DataTableOperationErrors actualResponse = client.getDataTableOperationErrors(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableOperationErrorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8100/locations/location-8100/instances/instance-8100/dataTableOperationErrors/dataTableOperationError-8100";

    DataTableOperationErrors actualResponse = client.getDataTableOperationErrors(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDataTableOperationErrorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8100/locations/location-8100/instances/instance-8100/dataTableOperationErrors/dataTableOperationError-8100";
      client.getDataTableOperationErrors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
