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

package com.google.maps.mapmanagement.v2beta;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

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
public class MapManagementClientTest {
  private static MockMapManagement mockMapManagement;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MapManagementClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMapManagement = new MockMapManagement();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMapManagement));
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
    MapManagementSettings settings =
        MapManagementSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MapManagementClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMapConfigTest() throws Exception {
    MapConfig expectedResponse =
        MapConfig.newBuilder()
            .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMapId("mapId103663511")
            .setMapFeatures(MapFeatures.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMapType(MapRenderingType.forNumber(0))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    MapConfig mapConfig = MapConfig.newBuilder().build();

    MapConfig actualResponse = client.createMapConfig(parent, mapConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMapConfigRequest actualRequest = ((CreateMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mapConfig, actualRequest.getMapConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMapConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      MapConfig mapConfig = MapConfig.newBuilder().build();
      client.createMapConfig(parent, mapConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMapConfigTest2() throws Exception {
    MapConfig expectedResponse =
        MapConfig.newBuilder()
            .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMapId("mapId103663511")
            .setMapFeatures(MapFeatures.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMapType(MapRenderingType.forNumber(0))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MapConfig mapConfig = MapConfig.newBuilder().build();

    MapConfig actualResponse = client.createMapConfig(parent, mapConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMapConfigRequest actualRequest = ((CreateMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mapConfig, actualRequest.getMapConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMapConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      MapConfig mapConfig = MapConfig.newBuilder().build();
      client.createMapConfig(parent, mapConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMapConfigTest() throws Exception {
    MapConfig expectedResponse =
        MapConfig.newBuilder()
            .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMapId("mapId103663511")
            .setMapFeatures(MapFeatures.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMapType(MapRenderingType.forNumber(0))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");

    MapConfig actualResponse = client.getMapConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMapConfigRequest actualRequest = ((GetMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMapConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
      client.getMapConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMapConfigTest2() throws Exception {
    MapConfig expectedResponse =
        MapConfig.newBuilder()
            .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMapId("mapId103663511")
            .setMapFeatures(MapFeatures.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMapType(MapRenderingType.forNumber(0))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";

    MapConfig actualResponse = client.getMapConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMapConfigRequest actualRequest = ((GetMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMapConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getMapConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMapConfigsTest() throws Exception {
    MapConfig responsesElement = MapConfig.newBuilder().build();
    ListMapConfigsResponse expectedResponse =
        ListMapConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMapConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListMapConfigsPagedResponse pagedListResponse = client.listMapConfigs(parent);

    List<MapConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMapConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMapConfigsRequest actualRequest = ((ListMapConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMapConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listMapConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMapConfigsTest2() throws Exception {
    MapConfig responsesElement = MapConfig.newBuilder().build();
    ListMapConfigsResponse expectedResponse =
        ListMapConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMapConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMapConfigsPagedResponse pagedListResponse = client.listMapConfigs(parent);

    List<MapConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMapConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMapConfigsRequest actualRequest = ((ListMapConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMapConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMapConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMapConfigTest() throws Exception {
    MapConfig expectedResponse =
        MapConfig.newBuilder()
            .setName(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMapId("mapId103663511")
            .setMapFeatures(MapFeatures.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMapType(MapRenderingType.forNumber(0))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapConfig mapConfig = MapConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MapConfig actualResponse = client.updateMapConfig(mapConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMapConfigRequest actualRequest = ((UpdateMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(mapConfig, actualRequest.getMapConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMapConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapConfig mapConfig = MapConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMapConfig(mapConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMapConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
    boolean force = true;

    client.deleteMapConfig(name, force);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMapConfigRequest actualRequest = ((DeleteMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMapConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapConfigName name = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
      boolean force = true;
      client.deleteMapConfig(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMapConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteMapConfig(name, force);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMapConfigRequest actualRequest = ((DeleteMapConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMapConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteMapConfig(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStyleConfigTest() throws Exception {
    StyleConfig expectedResponse =
        StyleConfig.newBuilder()
            .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setStyleId("styleId-1875214676")
            .setJsonStyleSheet("jsonStyleSheet2038037814")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    StyleConfig styleConfig = StyleConfig.newBuilder().build();

    StyleConfig actualResponse = client.createStyleConfig(parent, styleConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStyleConfigRequest actualRequest = ((CreateStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(styleConfig, actualRequest.getStyleConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStyleConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      StyleConfig styleConfig = StyleConfig.newBuilder().build();
      client.createStyleConfig(parent, styleConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStyleConfigTest2() throws Exception {
    StyleConfig expectedResponse =
        StyleConfig.newBuilder()
            .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setStyleId("styleId-1875214676")
            .setJsonStyleSheet("jsonStyleSheet2038037814")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    StyleConfig styleConfig = StyleConfig.newBuilder().build();

    StyleConfig actualResponse = client.createStyleConfig(parent, styleConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStyleConfigRequest actualRequest = ((CreateStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(styleConfig, actualRequest.getStyleConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStyleConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      StyleConfig styleConfig = StyleConfig.newBuilder().build();
      client.createStyleConfig(parent, styleConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStyleConfigTest() throws Exception {
    StyleConfig expectedResponse =
        StyleConfig.newBuilder()
            .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setStyleId("styleId-1875214676")
            .setJsonStyleSheet("jsonStyleSheet2038037814")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");

    StyleConfig actualResponse = client.getStyleConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleConfigRequest actualRequest = ((GetStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");
      client.getStyleConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStyleConfigTest2() throws Exception {
    StyleConfig expectedResponse =
        StyleConfig.newBuilder()
            .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setStyleId("styleId-1875214676")
            .setJsonStyleSheet("jsonStyleSheet2038037814")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";

    StyleConfig actualResponse = client.getStyleConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStyleConfigRequest actualRequest = ((GetStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStyleConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getStyleConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStyleConfigsTest() throws Exception {
    StyleConfig responsesElement = StyleConfig.newBuilder().build();
    ListStyleConfigsResponse expectedResponse =
        ListStyleConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStyleConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListStyleConfigsPagedResponse pagedListResponse = client.listStyleConfigs(parent);

    List<StyleConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStyleConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStyleConfigsRequest actualRequest = ((ListStyleConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStyleConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listStyleConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStyleConfigsTest2() throws Exception {
    StyleConfig responsesElement = StyleConfig.newBuilder().build();
    ListStyleConfigsResponse expectedResponse =
        ListStyleConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStyleConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListStyleConfigsPagedResponse pagedListResponse = client.listStyleConfigs(parent);

    List<StyleConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStyleConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStyleConfigsRequest actualRequest = ((ListStyleConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStyleConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listStyleConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateStyleConfigTest() throws Exception {
    StyleConfig expectedResponse =
        StyleConfig.newBuilder()
            .setName(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setStyleId("styleId-1875214676")
            .setJsonStyleSheet("jsonStyleSheet2038037814")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    StyleConfig styleConfig = StyleConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    StyleConfig actualResponse = client.updateStyleConfig(styleConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStyleConfigRequest actualRequest = ((UpdateStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(styleConfig, actualRequest.getStyleConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateStyleConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      StyleConfig styleConfig = StyleConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStyleConfig(styleConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStyleConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");

    client.deleteStyleConfig(name);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStyleConfigRequest actualRequest = ((DeleteStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStyleConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      StyleConfigName name = StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]");
      client.deleteStyleConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStyleConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteStyleConfig(name);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStyleConfigRequest actualRequest = ((DeleteStyleConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStyleConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteStyleConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMapContextConfigTest() throws Exception {
    MapContextConfig expectedResponse =
        MapContextConfig.newBuilder()
            .setName(
                MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
                    .toString())
            .setMapConfig(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setStyleConfig(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .addAllDataset(new ArrayList<String>())
            .setAlias("alias92902992")
            .addAllMapVariants(new ArrayList<MapContextConfig.MapVariant>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
    MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();

    MapContextConfig actualResponse = client.createMapContextConfig(parent, mapContextConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMapContextConfigRequest actualRequest =
        ((CreateMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(mapContextConfig, actualRequest.getMapContextConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMapContextConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
      MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
      client.createMapContextConfig(parent, mapContextConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMapContextConfigTest2() throws Exception {
    MapContextConfig expectedResponse =
        MapContextConfig.newBuilder()
            .setName(
                MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
                    .toString())
            .setMapConfig(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setStyleConfig(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .addAllDataset(new ArrayList<String>())
            .setAlias("alias92902992")
            .addAllMapVariants(new ArrayList<MapContextConfig.MapVariant>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();

    MapContextConfig actualResponse = client.createMapContextConfig(parent, mapContextConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMapContextConfigRequest actualRequest =
        ((CreateMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(mapContextConfig, actualRequest.getMapContextConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMapContextConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
      client.createMapContextConfig(parent, mapContextConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMapContextConfigTest() throws Exception {
    MapContextConfig expectedResponse =
        MapContextConfig.newBuilder()
            .setName(
                MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
                    .toString())
            .setMapConfig(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setStyleConfig(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .addAllDataset(new ArrayList<String>())
            .setAlias("alias92902992")
            .addAllMapVariants(new ArrayList<MapContextConfig.MapVariant>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapContextConfigName name =
        MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");

    MapContextConfig actualResponse = client.getMapContextConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMapContextConfigRequest actualRequest = ((GetMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMapContextConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapContextConfigName name =
          MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");
      client.getMapContextConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMapContextConfigTest2() throws Exception {
    MapContextConfig expectedResponse =
        MapContextConfig.newBuilder()
            .setName(
                MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
                    .toString())
            .setMapConfig(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setStyleConfig(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .addAllDataset(new ArrayList<String>())
            .setAlias("alias92902992")
            .addAllMapVariants(new ArrayList<MapContextConfig.MapVariant>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";

    MapContextConfig actualResponse = client.getMapContextConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMapContextConfigRequest actualRequest = ((GetMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMapContextConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      client.getMapContextConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMapContextConfigsTest() throws Exception {
    MapContextConfig responsesElement = MapContextConfig.newBuilder().build();
    ListMapContextConfigsResponse expectedResponse =
        ListMapContextConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMapContextConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");

    ListMapContextConfigsPagedResponse pagedListResponse = client.listMapContextConfigs(parent);

    List<MapContextConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMapContextConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMapContextConfigsRequest actualRequest =
        ((ListMapContextConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMapContextConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapConfigName parent = MapConfigName.of("[PROJECT]", "[MAP_CONFIG]");
      client.listMapContextConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMapContextConfigsTest2() throws Exception {
    MapContextConfig responsesElement = MapContextConfig.newBuilder().build();
    ListMapContextConfigsResponse expectedResponse =
        ListMapContextConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMapContextConfigs(Arrays.asList(responsesElement))
            .build();
    mockMapManagement.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMapContextConfigsPagedResponse pagedListResponse = client.listMapContextConfigs(parent);

    List<MapContextConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMapContextConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMapContextConfigsRequest actualRequest =
        ((ListMapContextConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMapContextConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMapContextConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMapContextConfigTest() throws Exception {
    MapContextConfig expectedResponse =
        MapContextConfig.newBuilder()
            .setName(
                MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]")
                    .toString())
            .setMapConfig(MapConfigName.of("[PROJECT]", "[MAP_CONFIG]").toString())
            .setStyleConfig(StyleConfigName.of("[PROJECT]", "[STYLE_CONFIG]").toString())
            .addAllDataset(new ArrayList<String>())
            .setAlias("alias92902992")
            .addAllMapVariants(new ArrayList<MapContextConfig.MapVariant>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMapManagement.addResponse(expectedResponse);

    MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MapContextConfig actualResponse = client.updateMapContextConfig(mapContextConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMapContextConfigRequest actualRequest =
        ((UpdateMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(mapContextConfig, actualRequest.getMapContextConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMapContextConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapContextConfig mapContextConfig = MapContextConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMapContextConfig(mapContextConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMapContextConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    MapContextConfigName name =
        MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");

    client.deleteMapContextConfig(name);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMapContextConfigRequest actualRequest =
        ((DeleteMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMapContextConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      MapContextConfigName name =
          MapContextConfigName.of("[PROJECT]", "[MAP_CONFIG]", "[MAP_CONTEXT_CONFIG]");
      client.deleteMapContextConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMapContextConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMapManagement.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMapContextConfig(name);

    List<AbstractMessage> actualRequests = mockMapManagement.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMapContextConfigRequest actualRequest =
        ((DeleteMapContextConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMapContextConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMapManagement.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMapContextConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
