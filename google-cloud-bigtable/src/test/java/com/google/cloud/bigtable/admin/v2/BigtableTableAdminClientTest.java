/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.PagedResponseWrappers.ListTablesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BigtableTableAdminClientTest {
  private static MockBigtableInstanceAdmin mockBigtableInstanceAdmin;
  private static MockBigtableTableAdmin mockBigtableTableAdmin;
  private static MockServiceHelper serviceHelper;
  private BigtableTableAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtableInstanceAdmin = new MockBigtableInstanceAdmin();
    mockBigtableTableAdmin = new MockBigtableTableAdmin();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockBigtableInstanceAdmin, mockBigtableTableAdmin));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    BigtableTableAdminSettings settings =
        BigtableTableAdminSettings.newBuilder()
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigtableTableAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createTableTest() {
    TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    Table expectedResponse = Table.newBuilder().setNameWithTableName(name).build();
    mockBigtableTableAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String tableId = "tableId-895419604";
    Table table = Table.newBuilder().build();

    Table actualResponse = client.createTable(parent, tableId, table);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTableRequest actualRequest = (CreateTableRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsInstanceName());
    Assert.assertEquals(tableId, actualRequest.getTableId());
    Assert.assertEquals(table, actualRequest.getTable());
  }

  @Test
  @SuppressWarnings("all")
  public void createTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String tableId = "tableId-895419604";
      Table table = Table.newBuilder().build();

      client.createTable(parent, tableId, table);
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
    mockBigtableTableAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListTablesPagedResponse pagedListResponse = client.listTables(parent);

    List<Table> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTablesRequest actualRequest = (ListTablesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsInstanceName());
  }

  @Test
  @SuppressWarnings("all")
  public void listTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.listTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTableTest() {
    TableName name2 = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    Table expectedResponse = Table.newBuilder().setNameWithTableName(name2).build();
    mockBigtableTableAdmin.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTableRequest actualRequest = (GetTableRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsTableName());
  }

  @Test
  @SuppressWarnings("all")
  public void getTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");

      client.getTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTableTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableTableAdmin.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");

    client.deleteTable(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTableRequest actualRequest = (DeleteTableRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsTableName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");

      client.deleteTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void modifyColumnFamiliesTest() {
    TableName name2 = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    Table expectedResponse = Table.newBuilder().setNameWithTableName(name2).build();
    mockBigtableTableAdmin.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    List<ModifyColumnFamiliesRequest.Modification> modifications = new ArrayList<>();

    Table actualResponse = client.modifyColumnFamilies(name, modifications);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyColumnFamiliesRequest actualRequest = (ModifyColumnFamiliesRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsTableName());
    Assert.assertEquals(modifications, actualRequest.getModificationsList());
  }

  @Test
  @SuppressWarnings("all")
  public void modifyColumnFamiliesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      List<ModifyColumnFamiliesRequest.Modification> modifications = new ArrayList<>();

      client.modifyColumnFamilies(name, modifications);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void dropRowRangeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableTableAdmin.addResponse(expectedResponse);

    String formattedName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString();
    ByteString rowKeyPrefix = ByteString.copyFromUtf8("-9");

    client.dropRowRange(formattedName, rowKeyPrefix);

    List<GeneratedMessageV3> actualRequests = mockBigtableTableAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DropRowRangeRequest actualRequest = (DropRowRangeRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(rowKeyPrefix, actualRequest.getRowKeyPrefix());
  }

  @Test
  @SuppressWarnings("all")
  public void dropRowRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableTableAdmin.addException(exception);

    try {
      String formattedName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString();
      ByteString rowKeyPrefix = ByteString.copyFromUtf8("-9");

      client.dropRowRange(formattedName, rowKeyPrefix);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
