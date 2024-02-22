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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureGroupsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class FeatureRegistryServiceClientTest {
  private static MockFeatureRegistryService mockFeatureRegistryService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FeatureRegistryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFeatureRegistryService = new MockFeatureRegistryService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockFeatureRegistryService, mockLocations, mockIAMPolicy));
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
    FeatureRegistryServiceSettings settings =
        FeatureRegistryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeatureRegistryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createFeatureGroupTest() throws Exception {
    FeatureGroup expectedResponse =
        FeatureGroup.newBuilder()
            .setName(FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
    String featureGroupId = "featureGroupId-1768466396";

    FeatureGroup actualResponse =
        client.createFeatureGroupAsync(parent, featureGroup, featureGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureGroupRequest actualRequest = ((CreateFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(featureGroup, actualRequest.getFeatureGroup());
    Assert.assertEquals(featureGroupId, actualRequest.getFeatureGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
      String featureGroupId = "featureGroupId-1768466396";
      client.createFeatureGroupAsync(parent, featureGroup, featureGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureGroupTest2() throws Exception {
    FeatureGroup expectedResponse =
        FeatureGroup.newBuilder()
            .setName(FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    String parent = "parent-995424086";
    FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
    String featureGroupId = "featureGroupId-1768466396";

    FeatureGroup actualResponse =
        client.createFeatureGroupAsync(parent, featureGroup, featureGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureGroupRequest actualRequest = ((CreateFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(featureGroup, actualRequest.getFeatureGroup());
    Assert.assertEquals(featureGroupId, actualRequest.getFeatureGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String parent = "parent-995424086";
      FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
      String featureGroupId = "featureGroupId-1768466396";
      client.createFeatureGroupAsync(parent, featureGroup, featureGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getFeatureGroupTest() throws Exception {
    FeatureGroup expectedResponse =
        FeatureGroup.newBuilder()
            .setName(FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    FeatureGroupName name = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");

    FeatureGroup actualResponse = client.getFeatureGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureGroupRequest actualRequest = ((GetFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureGroupName name = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
      client.getFeatureGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureGroupTest2() throws Exception {
    FeatureGroup expectedResponse =
        FeatureGroup.newBuilder()
            .setName(FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    String name = "name3373707";

    FeatureGroup actualResponse = client.getFeatureGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureGroupRequest actualRequest = ((GetFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeatureGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureGroupsTest() throws Exception {
    FeatureGroup responsesElement = FeatureGroup.newBuilder().build();
    ListFeatureGroupsResponse expectedResponse =
        ListFeatureGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureGroups(Arrays.asList(responsesElement))
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFeatureGroupsPagedResponse pagedListResponse = client.listFeatureGroups(parent);

    List<FeatureGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureGroupsRequest actualRequest = ((ListFeatureGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFeatureGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureGroupsTest2() throws Exception {
    FeatureGroup responsesElement = FeatureGroup.newBuilder().build();
    ListFeatureGroupsResponse expectedResponse =
        ListFeatureGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureGroups(Arrays.asList(responsesElement))
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeatureGroupsPagedResponse pagedListResponse = client.listFeatureGroups(parent);

    List<FeatureGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureGroupsRequest actualRequest = ((ListFeatureGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeatureGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeatureGroupTest() throws Exception {
    FeatureGroup expectedResponse =
        FeatureGroup.newBuilder()
            .setName(FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FeatureGroup actualResponse = client.updateFeatureGroupAsync(featureGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeatureGroupRequest actualRequest = ((UpdateFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(featureGroup, actualRequest.getFeatureGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeatureGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureGroup featureGroup = FeatureGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureGroupAsync(featureGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    FeatureGroupName name = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
    boolean force = true;

    client.deleteFeatureGroupAsync(name, force).get();

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureGroupRequest actualRequest = ((DeleteFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureGroupName name = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
      boolean force = true;
      client.deleteFeatureGroupAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    String name = "name3373707";
    boolean force = true;

    client.deleteFeatureGroupAsync(name, force).get();

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureGroupRequest actualRequest = ((DeleteFeatureGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteFeatureGroupAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeaturestoreEntityTypeFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    EntityTypeName parent =
        EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
    Feature feature = Feature.newBuilder().build();
    String featureId = "featureId-420503887";

    Feature actualResponse = client.createFeatureAsync(parent, feature, featureId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureRequest actualRequest = ((CreateFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertEquals(featureId, actualRequest.getFeatureId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      EntityTypeName parent =
          EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
      Feature feature = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      client.createFeatureAsync(parent, feature, featureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureTest2() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeaturestoreEntityTypeFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    FeatureGroupName parent = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
    Feature feature = Feature.newBuilder().build();
    String featureId = "featureId-420503887";

    Feature actualResponse = client.createFeatureAsync(parent, feature, featureId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureRequest actualRequest = ((CreateFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertEquals(featureId, actualRequest.getFeatureId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureGroupName parent = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
      Feature feature = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      client.createFeatureAsync(parent, feature, featureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureTest3() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeaturestoreEntityTypeFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Feature feature = Feature.newBuilder().build();
    String featureId = "featureId-420503887";

    Feature actualResponse = client.createFeatureAsync(parent, feature, featureId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureRequest actualRequest = ((CreateFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertEquals(featureId, actualRequest.getFeatureId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String parent = "parent-995424086";
      Feature feature = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      client.createFeatureAsync(parent, feature, featureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeatureGroupFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    FeatureName name =
        FeatureName.ofProjectLocationFeatureGroupFeatureName(
            "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]");

    Feature actualResponse = client.getFeature(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureRequest actualRequest = ((GetFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureName name =
          FeatureName.ofProjectLocationFeatureGroupFeatureName(
              "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]");
      client.getFeature(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureTest2() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeatureGroupFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    String name = "name3373707";

    Feature actualResponse = client.getFeature(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureRequest actualRequest = ((GetFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeature(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturesTest() throws Exception {
    Feature responsesElement = Feature.newBuilder().build();
    ListFeaturesResponse expectedResponse =
        ListFeaturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatures(Arrays.asList(responsesElement))
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    EntityTypeName parent =
        EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");

    ListFeaturesPagedResponse pagedListResponse = client.listFeatures(parent);

    List<Feature> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeaturesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeaturesRequest actualRequest = ((ListFeaturesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeaturesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      EntityTypeName parent =
          EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
      client.listFeatures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturesTest2() throws Exception {
    Feature responsesElement = Feature.newBuilder().build();
    ListFeaturesResponse expectedResponse =
        ListFeaturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatures(Arrays.asList(responsesElement))
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    FeatureGroupName parent = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");

    ListFeaturesPagedResponse pagedListResponse = client.listFeatures(parent);

    List<Feature> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeaturesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeaturesRequest actualRequest = ((ListFeaturesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeaturesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureGroupName parent = FeatureGroupName.of("[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]");
      client.listFeatures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturesTest3() throws Exception {
    Feature responsesElement = Feature.newBuilder().build();
    ListFeaturesResponse expectedResponse =
        ListFeaturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatures(Arrays.asList(responsesElement))
            .build();
    mockFeatureRegistryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeaturesPagedResponse pagedListResponse = client.listFeatures(parent);

    List<Feature> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeaturesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeaturesRequest actualRequest = ((ListFeaturesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeaturesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeatures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(
                FeatureName.ofProjectLocationFeatureGroupFeatureName(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setMonitoringConfig(FeaturestoreMonitoringConfig.newBuilder().build())
            .setDisableMonitoring(true)
            .addAllMonitoringStats(new ArrayList<FeatureStatsAnomaly>())
            .addAllMonitoringStatsAnomalies(new ArrayList<Feature.MonitoringStatsAnomaly>())
            .setVersionColumnName("versionColumnName-997658119")
            .setPointOfContact("pointOfContact-804861287")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    Feature feature = Feature.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Feature actualResponse = client.updateFeatureAsync(feature, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeatureRequest actualRequest = ((UpdateFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(feature, actualRequest.getFeature());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeatureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      Feature feature = Feature.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureAsync(feature, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    FeatureName name =
        FeatureName.ofProjectLocationFeatureGroupFeatureName(
            "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]");

    client.deleteFeatureAsync(name).get();

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureRequest actualRequest = ((DeleteFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      FeatureName name =
          FeatureName.ofProjectLocationFeatureGroupFeatureName(
              "[PROJECT]", "[LOCATION]", "[FEATURE_GROUP]", "[FEATURE]");
      client.deleteFeatureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureRegistryService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFeatureAsync(name).get();

    List<AbstractMessage> actualRequests = mockFeatureRegistryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureRequest actualRequest = ((DeleteFeatureRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureRegistryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFeatureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
