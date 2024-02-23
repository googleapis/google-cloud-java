/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.biglake.v1alpha1;

import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListLocksPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListTablesPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class MetastoreServiceClientTest {
  private static MockMetastoreService mockMetastoreService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetastoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetastoreService = new MockMetastoreService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetastoreService));
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
    MetastoreServiceSettings settings =
        MetastoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetastoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Catalog catalog = Catalog.newBuilder().build();
    String catalogId = "catalogId1455933204";

    Catalog actualResponse = client.createCatalog(parent, catalog, catalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCatalogRequest actualRequest = ((CreateCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertEquals(catalogId, actualRequest.getCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Catalog catalog = Catalog.newBuilder().build();
      String catalogId = "catalogId1455933204";
      client.createCatalog(parent, catalog, catalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogTest2() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Catalog catalog = Catalog.newBuilder().build();
    String catalogId = "catalogId1455933204";

    Catalog actualResponse = client.createCatalog(parent, catalog, catalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCatalogRequest actualRequest = ((CreateCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertEquals(catalogId, actualRequest.getCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      Catalog catalog = Catalog.newBuilder().build();
      String catalogId = "catalogId1455933204";
      client.createCatalog(parent, catalog, catalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    Catalog actualResponse = client.deleteCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCatalogRequest actualRequest = ((DeleteCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.deleteCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogTest2() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Catalog actualResponse = client.deleteCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCatalogRequest actualRequest = ((DeleteCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    Catalog actualResponse = client.getCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCatalogRequest actualRequest = ((GetCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.getCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTest2() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Catalog actualResponse = client.getCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCatalogRequest actualRequest = ((GetCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest2() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabase(parent, database, databaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabase(parent, database, databaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Database database = Database.newBuilder().build();
    String databaseId = "databaseId1688905718";

    Database actualResponse = client.createDatabase(parent, database, databaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      Database database = Database.newBuilder().build();
      String databaseId = "databaseId1688905718";
      client.createDatabase(parent, database, databaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");

    Database actualResponse = client.deleteDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatabaseRequest actualRequest = ((DeleteDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      client.deleteDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Database actualResponse = client.deleteDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDatabaseRequest actualRequest = ((DeleteDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    Database database = Database.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Database actualResponse = client.updateDatabase(database, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatabaseRequest actualRequest = ((UpdateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      Database database = Database.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatabase(database, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(
                DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest2() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
    Table table = Table.newBuilder().build();
    String tableId = "tableId-1552905847";

    Table actualResponse = client.createTable(parent, table, tableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTableRequest actualRequest = ((CreateTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(table, actualRequest.getTable());
    Assert.assertEquals(tableId, actualRequest.getTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      Table table = Table.newBuilder().build();
      String tableId = "tableId-1552905847";
      client.createTable(parent, table, tableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTableTest2() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Table table = Table.newBuilder().build();
    String tableId = "tableId-1552905847";

    Table actualResponse = client.createTable(parent, table, tableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTableRequest actualRequest = ((CreateTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(table, actualRequest.getTable());
    Assert.assertEquals(tableId, actualRequest.getTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      Table table = Table.newBuilder().build();
      String tableId = "tableId-1552905847";
      client.createTable(parent, table, tableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    Table actualResponse = client.deleteTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTableRequest actualRequest = ((DeleteTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      TableName name =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.deleteTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTableTest2() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Table actualResponse = client.deleteTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTableRequest actualRequest = ((DeleteTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    Table table = Table.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Table actualResponse = client.updateTable(table, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTableRequest actualRequest = ((UpdateTableRequest) actualRequests.get(0));

    Assert.assertEquals(table, actualRequest.getTable());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      Table table = Table.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTable(table, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
    TableName newName =
        TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    Table actualResponse = client.renameTable(name, newName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTableRequest actualRequest = ((RenameTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(newName.toString(), actualRequest.getNewName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      TableName name =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      TableName newName =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.renameTable(name, newName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTableTest2() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
    String newName = "newName1845020747";

    Table actualResponse = client.renameTable(name, newName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTableRequest actualRequest = ((RenameTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(newName, actualRequest.getNewName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      TableName name =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      String newName = "newName1845020747";
      client.renameTable(name, newName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTableTest3() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";
    TableName newName =
        TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    Table actualResponse = client.renameTable(name, newName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTableRequest actualRequest = ((RenameTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(newName.toString(), actualRequest.getNewName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTableExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      TableName newName =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.renameTable(name, newName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameTableTest4() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";
    String newName = "newName1845020747";

    Table actualResponse = client.renameTable(name, newName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTableRequest actualRequest = ((RenameTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(newName, actualRequest.getNewName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renameTableExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      String newName = "newName1845020747";
      client.renameTable(name, newName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTableTest() throws Exception {
    Table expectedResponse =
        Table.newBuilder()
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
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
    mockMetastoreService.addException(exception);

    try {
      TableName name =
          TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
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
            .setName(
                TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Table actualResponse = client.getTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
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
    mockMetastoreService.addException(exception);

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
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");

    ListTablesPagedResponse pagedListResponse = client.listTables(parent);

    List<Table> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTablesRequest actualRequest = ((ListTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      client.listTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTablesTest2() throws Exception {
    Table responsesElement = Table.newBuilder().build();
    ListTablesResponse expectedResponse =
        ListTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTablesPagedResponse pagedListResponse = client.listTables(parent);

    List<Table> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTablesRequest actualRequest = ((ListTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTablesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLockTest() throws Exception {
    Lock expectedResponse =
        Lock.newBuilder()
            .setName(
                LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
    Lock lock = Lock.newBuilder().build();

    Lock actualResponse = client.createLock(parent, lock);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLockRequest actualRequest = ((CreateLockRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lock, actualRequest.getLock());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLockExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      Lock lock = Lock.newBuilder().build();
      client.createLock(parent, lock);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLockTest2() throws Exception {
    Lock expectedResponse =
        Lock.newBuilder()
            .setName(
                LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Lock lock = Lock.newBuilder().build();

    Lock actualResponse = client.createLock(parent, lock);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLockRequest actualRequest = ((CreateLockRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lock, actualRequest.getLock());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLockExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      Lock lock = Lock.newBuilder().build();
      client.createLock(parent, lock);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLockTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetastoreService.addResponse(expectedResponse);

    LockName name = LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]");

    client.deleteLock(name);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLockRequest actualRequest = ((DeleteLockRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLockExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      LockName name = LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]");
      client.deleteLock(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLockTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteLock(name);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLockRequest actualRequest = ((DeleteLockRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLockExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLock(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkLockTest() throws Exception {
    Lock expectedResponse =
        Lock.newBuilder()
            .setName(
                LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    LockName name = LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]");

    Lock actualResponse = client.checkLock(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckLockRequest actualRequest = ((CheckLockRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkLockExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      LockName name = LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]");
      client.checkLock(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkLockTest2() throws Exception {
    Lock expectedResponse =
        Lock.newBuilder()
            .setName(
                LockName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[LOCK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    Lock actualResponse = client.checkLock(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckLockRequest actualRequest = ((CheckLockRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkLockExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.checkLock(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocksTest() throws Exception {
    Lock responsesElement = Lock.newBuilder().build();
    ListLocksResponse expectedResponse =
        ListLocksResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocks(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");

    ListLocksPagedResponse pagedListResponse = client.listLocks(parent);

    List<Lock> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocksRequest actualRequest = ((ListLocksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
      client.listLocks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocksTest2() throws Exception {
    Lock responsesElement = Lock.newBuilder().build();
    ListLocksResponse expectedResponse =
        ListLocksResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocks(Arrays.asList(responsesElement))
            .build();
    mockMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLocksPagedResponse pagedListResponse = client.listLocks(parent);

    List<Lock> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocksRequest actualRequest = ((ListLocksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLocks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
