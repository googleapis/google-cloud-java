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

package com.google.cloud.biglake.hive.v1beta;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class HiveMetastoreServiceClientTest {
  private static MockHiveMetastoreService mockHiveMetastoreService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HiveMetastoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHiveMetastoreService = new MockHiveMetastoreService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockHiveMetastoreService));
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
    HiveMetastoreServiceSettings settings =
        HiveMetastoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HiveMetastoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
    String hiveCatalogId = "hiveCatalogId-575314556";

    HiveCatalog actualResponse = client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveCatalogRequest actualRequest = ((CreateHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hiveCatalog, actualRequest.getHiveCatalog());
    Assert.assertEquals(hiveCatalogId, actualRequest.getHiveCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
      String hiveCatalogId = "hiveCatalogId-575314556";
      client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveCatalogTest2() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
    String hiveCatalogId = "hiveCatalogId-575314556";

    HiveCatalog actualResponse = client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveCatalogRequest actualRequest = ((CreateHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hiveCatalog, actualRequest.getHiveCatalog());
    Assert.assertEquals(hiveCatalogId, actualRequest.getHiveCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
      String hiveCatalogId = "hiveCatalogId-575314556";
      client.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    HiveCatalog actualResponse = client.getHiveCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveCatalogRequest actualRequest = ((GetHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.getHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveCatalogTest2() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    HiveCatalog actualResponse = client.getHiveCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveCatalogRequest actualRequest = ((GetHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveCatalogsTest() throws Exception {
    HiveCatalog responsesElement = HiveCatalog.newBuilder().build();
    ListHiveCatalogsResponse expectedResponse =
        ListHiveCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListHiveCatalogsPagedResponse pagedListResponse = client.listHiveCatalogs(parent);

    List<HiveCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveCatalogsRequest actualRequest = ((ListHiveCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listHiveCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveCatalogsTest2() throws Exception {
    HiveCatalog responsesElement = HiveCatalog.newBuilder().build();
    ListHiveCatalogsResponse expectedResponse =
        ListHiveCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHiveCatalogsPagedResponse pagedListResponse = client.listHiveCatalogs(parent);

    List<HiveCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveCatalogsRequest actualRequest = ((ListHiveCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveCatalogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHiveCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveCatalogTest() throws Exception {
    HiveCatalog expectedResponse =
        HiveCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .addAllReplicas(new ArrayList<HiveCatalog.Replica>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveCatalog actualResponse = client.updateHiveCatalog(hiveCatalog, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHiveCatalogRequest actualRequest = ((UpdateHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(hiveCatalog, actualRequest.getHiveCatalog());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHiveCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveCatalog(hiveCatalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveCatalogTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    client.deleteHiveCatalog(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveCatalogRequest actualRequest = ((DeleteHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.deleteHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveCatalogTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteHiveCatalog(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveCatalogRequest actualRequest = ((DeleteHiveCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHiveCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
    HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
    String hiveDatabaseId = "hiveDatabaseId-1150232698";

    HiveDatabase actualResponse = client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveDatabaseRequest actualRequest = ((CreateHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hiveDatabase, actualRequest.getHiveDatabase());
    Assert.assertEquals(hiveDatabaseId, actualRequest.getHiveDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
      HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
      String hiveDatabaseId = "hiveDatabaseId-1150232698";
      client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveDatabaseTest2() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
    String hiveDatabaseId = "hiveDatabaseId-1150232698";

    HiveDatabase actualResponse = client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveDatabaseRequest actualRequest = ((CreateHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hiveDatabase, actualRequest.getHiveDatabase());
    Assert.assertEquals(hiveDatabaseId, actualRequest.getHiveDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
      String hiveDatabaseId = "hiveDatabaseId-1150232698";
      client.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    HiveDatabase actualResponse = client.getHiveDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveDatabaseRequest actualRequest = ((GetHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.getHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveDatabaseTest2() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    HiveDatabase actualResponse = client.getHiveDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveDatabaseRequest actualRequest = ((GetHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveDatabasesTest() throws Exception {
    HiveDatabase responsesElement = HiveDatabase.newBuilder().build();
    ListHiveDatabasesResponse expectedResponse =
        ListHiveDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");

    ListHiveDatabasesPagedResponse pagedListResponse = client.listHiveDatabases(parent);

    List<HiveDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveDatabasesRequest actualRequest = ((ListHiveDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.listHiveDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveDatabasesTest2() throws Exception {
    HiveDatabase responsesElement = HiveDatabase.newBuilder().build();
    ListHiveDatabasesResponse expectedResponse =
        ListHiveDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHiveDatabasesPagedResponse pagedListResponse = client.listHiveDatabases(parent);

    List<HiveDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveDatabasesRequest actualRequest = ((ListHiveDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHiveDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveDatabaseTest() throws Exception {
    HiveDatabase expectedResponse =
        HiveDatabase.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
            .setDescription("description-1724546052")
            .setLocationUri("locationUri552310135")
            .putAllParameters(new HashMap<String, String>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveDatabase actualResponse = client.updateHiveDatabase(hiveDatabase, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHiveDatabaseRequest actualRequest = ((UpdateHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(hiveDatabase, actualRequest.getHiveDatabase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHiveDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveDatabase(hiveDatabase, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveDatabaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    client.deleteHiveDatabase(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveDatabaseRequest actualRequest = ((DeleteHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.deleteHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveDatabaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteHiveDatabase(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveDatabaseRequest actualRequest = ((DeleteHiveDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHiveDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
    HiveTable hiveTable = HiveTable.newBuilder().build();
    String hiveTableId = "hiveTableId152241145";

    HiveTable actualResponse = client.createHiveTable(parent, hiveTable, hiveTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveTableRequest actualRequest = ((CreateHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(hiveTable, actualRequest.getHiveTable());
    Assert.assertEquals(hiveTableId, actualRequest.getHiveTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      HiveTable hiveTable = HiveTable.newBuilder().build();
      String hiveTableId = "hiveTableId152241145";
      client.createHiveTable(parent, hiveTable, hiveTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHiveTableTest2() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    HiveTable hiveTable = HiveTable.newBuilder().build();
    String hiveTableId = "hiveTableId152241145";

    HiveTable actualResponse = client.createHiveTable(parent, hiveTable, hiveTableId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateHiveTableRequest actualRequest = ((CreateHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(hiveTable, actualRequest.getHiveTable());
    Assert.assertEquals(hiveTableId, actualRequest.getHiveTableId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createHiveTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      HiveTable hiveTable = HiveTable.newBuilder().build();
      String hiveTableId = "hiveTableId152241145";
      client.createHiveTable(parent, hiveTable, hiveTableId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    HiveTable actualResponse = client.getHiveTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveTableRequest actualRequest = ((GetHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.getHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHiveTableTest2() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    HiveTable actualResponse = client.getHiveTable(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHiveTableRequest actualRequest = ((GetHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHiveTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveTablesTest() throws Exception {
    HiveTable responsesElement = HiveTable.newBuilder().build();
    ListHiveTablesResponse expectedResponse =
        ListHiveTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");

    ListHiveTablesPagedResponse pagedListResponse = client.listHiveTables(parent);

    List<HiveTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveTablesRequest actualRequest = ((ListHiveTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
      client.listHiveTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHiveTablesTest2() throws Exception {
    HiveTable responsesElement = HiveTable.newBuilder().build();
    ListHiveTablesResponse expectedResponse =
        ListHiveTablesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTables(Arrays.asList(responsesElement))
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListHiveTablesPagedResponse pagedListResponse = client.listHiveTables(parent);

    List<HiveTable> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTablesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListHiveTablesRequest actualRequest = ((ListHiveTablesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listHiveTablesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listHiveTables(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHiveTableTest() throws Exception {
    HiveTable expectedResponse =
        HiveTable.newBuilder()
            .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setDescription("description-1724546052")
            .setStorageDescriptor(StorageDescriptor.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllPartitionKeys(new ArrayList<FieldSchema>())
            .putAllParameters(new HashMap<String, String>())
            .setTableType("tableType-1988515800")
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    HiveTable hiveTable = HiveTable.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HiveTable actualResponse = client.updateHiveTable(hiveTable, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHiveTableRequest actualRequest = ((UpdateHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(hiveTable, actualRequest.getHiveTable());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHiveTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      HiveTable hiveTable = HiveTable.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHiveTable(hiveTable, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveTableTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    client.deleteHiveTable(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveTableRequest actualRequest = ((DeleteHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveTableExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.deleteHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteHiveTableTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteHiveTable(name);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteHiveTableRequest actualRequest = ((DeleteHiveTableRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteHiveTableExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteHiveTable(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreatePartitionsTest() throws Exception {
    BatchCreatePartitionsResponse expectedResponse =
        BatchCreatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    BatchCreatePartitionsResponse actualResponse = client.batchCreatePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreatePartitionsRequest actualRequest =
        ((BatchCreatePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreatePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchCreatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreatePartitionsTest2() throws Exception {
    BatchCreatePartitionsResponse expectedResponse =
        BatchCreatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    BatchCreatePartitionsResponse actualResponse = client.batchCreatePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreatePartitionsRequest actualRequest =
        ((BatchCreatePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreatePartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchCreatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeletePartitionsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    client.batchDeletePartitions(parent);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeletePartitionsRequest actualRequest =
        ((BatchDeletePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeletePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchDeletePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeletePartitionsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    client.batchDeletePartitions(parent);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeletePartitionsRequest actualRequest =
        ((BatchDeletePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeletePartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchDeletePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartitionsTest() throws Exception {
    BatchUpdatePartitionsResponse expectedResponse =
        BatchUpdatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");

    BatchUpdatePartitionsResponse actualResponse = client.batchUpdatePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdatePartitionsRequest actualRequest =
        ((BatchUpdatePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdatePartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
      client.batchUpdatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdatePartitionsTest2() throws Exception {
    BatchUpdatePartitionsResponse expectedResponse =
        BatchUpdatePartitionsResponse.newBuilder()
            .addAllPartitions(new ArrayList<Partition>())
            .build();
    mockHiveMetastoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    BatchUpdatePartitionsResponse actualResponse = client.batchUpdatePartitions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHiveMetastoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdatePartitionsRequest actualRequest =
        ((BatchUpdatePartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdatePartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchUpdatePartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest() throws Exception {
    ListPartitionsResponse expectedResponse =
        ListPartitionsResponse.newBuilder().addAllPartitions(new ArrayList<Partition>()).build();
    mockHiveMetastoreService.addResponse(expectedResponse);
    ListPartitionsRequest request =
        ListPartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setFilter("filter-1274492040")
            .build();

    MockStreamObserver<ListPartitionsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse> callable =
        client.listPartitionsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ListPartitionsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void listPartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHiveMetastoreService.addException(exception);
    ListPartitionsRequest request =
        ListPartitionsRequest.newBuilder()
            .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
            .setFilter("filter-1274492040")
            .build();

    MockStreamObserver<ListPartitionsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse> callable =
        client.listPartitionsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ListPartitionsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
