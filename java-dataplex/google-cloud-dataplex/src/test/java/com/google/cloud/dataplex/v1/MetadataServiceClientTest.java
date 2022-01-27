/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class MetadataServiceClientTest {
  private static MockMetadataService mockMetadataService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetadataServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetadataService = new MockMetadataService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetadataService));
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
    MetadataServiceSettings settings =
        MetadataServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetadataServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getEntityTest() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");

    Entity actualResponse = client.getEntity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityRequest actualRequest = ((GetEntityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      EntityName name = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      client.getEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntityTest2() throws Exception {
    Entity expectedResponse =
        Entity.newBuilder()
            .setName(
                EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setId("id3355")
            .setEtag("etag3123477")
            .setAsset("asset93121264")
            .setDataPath("dataPath1788928751")
            .setDataPathPattern("dataPathPattern1514620321")
            .setCatalogEntry("catalogEntry-1171922983")
            .setSystem(StorageSystem.forNumber(0))
            .setFormat(StorageFormat.newBuilder().build())
            .setCompatibility(Entity.CompatibilityStatus.newBuilder().build())
            .setSchema(Schema.newBuilder().build())
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    Entity actualResponse = client.getEntity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntityRequest actualRequest = ((GetEntityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getEntity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitiesTest() throws Exception {
    Entity responsesElement = Entity.newBuilder().build();
    ListEntitiesResponse expectedResponse =
        ListEntitiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntities(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListEntitiesPagedResponse pagedListResponse = client.listEntities(parent);

    List<Entity> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitiesRequest actualRequest = ((ListEntitiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.listEntities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitiesTest2() throws Exception {
    Entity responsesElement = Entity.newBuilder().build();
    ListEntitiesResponse expectedResponse =
        ListEntitiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntities(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntitiesPagedResponse pagedListResponse = client.listEntities(parent);

    List<Entity> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitiesRequest actualRequest = ((ListEntitiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartitionTest() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    PartitionName name =
        PartitionName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");

    Partition actualResponse = client.getPartition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartitionRequest actualRequest = ((GetPartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      PartitionName name =
          PartitionName.of(
              "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]");
      client.getPartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPartitionTest2() throws Exception {
    Partition expectedResponse =
        Partition.newBuilder()
            .setName(
                PartitionName.of(
                        "[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]", "[PARTITION]")
                    .toString())
            .addAllValues(new ArrayList<String>())
            .setLocation("location1901043637")
            .setEtag("etag3123477")
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String name = "name3373707";

    Partition actualResponse = client.getPartition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPartitionRequest actualRequest = ((GetPartitionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPartitionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String name = "name3373707";
      client.getPartition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest() throws Exception {
    Partition responsesElement = Partition.newBuilder().build();
    ListPartitionsResponse expectedResponse =
        ListPartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");

    ListPartitionsPagedResponse pagedListResponse = client.listPartitions(parent);

    List<Partition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPartitionsRequest actualRequest = ((ListPartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPartitionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      EntityName parent = EntityName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ENTITY]");
      client.listPartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPartitionsTest2() throws Exception {
    Partition responsesElement = Partition.newBuilder().build();
    ListPartitionsResponse expectedResponse =
        ListPartitionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartitions(Arrays.asList(responsesElement))
            .build();
    mockMetadataService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPartitionsPagedResponse pagedListResponse = client.listPartitions(parent);

    List<Partition> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartitionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetadataService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPartitionsRequest actualRequest = ((ListPartitionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPartitionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetadataService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPartitions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
