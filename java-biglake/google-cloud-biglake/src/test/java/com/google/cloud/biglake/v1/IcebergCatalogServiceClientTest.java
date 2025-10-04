/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.biglake.v1;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class IcebergCatalogServiceClientTest {
  private static MockIcebergCatalogService mockIcebergCatalogService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IcebergCatalogServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIcebergCatalogService = new MockIcebergCatalogService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIcebergCatalogService));
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
    IcebergCatalogServiceSettings settings =
        IcebergCatalogServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IcebergCatalogServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");

    IcebergCatalog actualResponse = client.getIcebergCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIcebergCatalogRequest actualRequest = ((GetIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIcebergCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
      client.getIcebergCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIcebergCatalogTest2() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    IcebergCatalog actualResponse = client.getIcebergCatalog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIcebergCatalogRequest actualRequest = ((GetIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIcebergCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.getIcebergCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIcebergCatalogsTest() throws Exception {
    IcebergCatalog responsesElement = IcebergCatalog.newBuilder().build();
    ListIcebergCatalogsResponse expectedResponse =
        ListIcebergCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIcebergCatalogs(Arrays.asList(responsesElement))
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListIcebergCatalogsPagedResponse pagedListResponse = client.listIcebergCatalogs(parent);

    List<IcebergCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIcebergCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIcebergCatalogsRequest actualRequest = ((ListIcebergCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIcebergCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listIcebergCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIcebergCatalogsTest2() throws Exception {
    IcebergCatalog responsesElement = IcebergCatalog.newBuilder().build();
    ListIcebergCatalogsResponse expectedResponse =
        ListIcebergCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIcebergCatalogs(Arrays.asList(responsesElement))
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIcebergCatalogsPagedResponse pagedListResponse = client.listIcebergCatalogs(parent);

    List<IcebergCatalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIcebergCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIcebergCatalogsRequest actualRequest = ((ListIcebergCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIcebergCatalogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIcebergCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IcebergCatalog actualResponse = client.updateIcebergCatalog(icebergCatalog, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIcebergCatalogRequest actualRequest =
        ((UpdateIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(icebergCatalog, actualRequest.getIcebergCatalog());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIcebergCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIcebergCatalog(icebergCatalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIcebergCatalogTest() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
    String icebergCatalogId = "icebergCatalogId504062865";

    IcebergCatalog actualResponse =
        client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIcebergCatalogRequest actualRequest =
        ((CreateIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(icebergCatalog, actualRequest.getIcebergCatalog());
    Assert.assertEquals(icebergCatalogId, actualRequest.getIcebergCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIcebergCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
      String icebergCatalogId = "icebergCatalogId504062865";
      client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIcebergCatalogTest2() throws Exception {
    IcebergCatalog expectedResponse =
        IcebergCatalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
            .setBiglakeServiceAccount("biglakeServiceAccount-779711961")
            .setDefaultLocation("defaultLocation-395835114")
            .addAllCatalogRegions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
    String icebergCatalogId = "icebergCatalogId504062865";

    IcebergCatalog actualResponse =
        client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIcebergCatalogRequest actualRequest =
        ((CreateIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(icebergCatalog, actualRequest.getIcebergCatalog());
    Assert.assertEquals(icebergCatalogId, actualRequest.getIcebergCatalogId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIcebergCatalogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      IcebergCatalog icebergCatalog = IcebergCatalog.newBuilder().build();
      String icebergCatalogId = "icebergCatalogId504062865";
      client.createIcebergCatalog(parent, icebergCatalog, icebergCatalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void failoverIcebergCatalogTest() throws Exception {
    FailoverIcebergCatalogResponse expectedResponse =
        FailoverIcebergCatalogResponse.newBuilder()
            .setReplicationTime(Timestamp.newBuilder().build())
            .build();
    mockIcebergCatalogService.addResponse(expectedResponse);

    String name = "name3373707";
    String primaryReplica = "primaryReplica-389090218";

    FailoverIcebergCatalogResponse actualResponse =
        client.failoverIcebergCatalog(name, primaryReplica);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIcebergCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverIcebergCatalogRequest actualRequest =
        ((FailoverIcebergCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(primaryReplica, actualRequest.getPrimaryReplica());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverIcebergCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIcebergCatalogService.addException(exception);

    try {
      String name = "name3373707";
      String primaryReplica = "primaryReplica-389090218";
      client.failoverIcebergCatalog(name, primaryReplica);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
