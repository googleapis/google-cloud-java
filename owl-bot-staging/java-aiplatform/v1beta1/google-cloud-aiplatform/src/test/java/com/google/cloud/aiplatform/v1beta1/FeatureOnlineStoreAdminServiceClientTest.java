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

import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureOnlineStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewSyncsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListLocationsPagedResponse;

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
import com.google.rpc.Status;
import com.google.type.Interval;
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
public class FeatureOnlineStoreAdminServiceClientTest {
  private static MockFeatureOnlineStoreAdminService mockFeatureOnlineStoreAdminService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FeatureOnlineStoreAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFeatureOnlineStoreAdminService = new MockFeatureOnlineStoreAdminService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockFeatureOnlineStoreAdminService, mockLocations, mockIAMPolicy));
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
    FeatureOnlineStoreAdminServiceSettings settings =
        FeatureOnlineStoreAdminServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeatureOnlineStoreAdminServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createFeatureOnlineStoreTest() throws Exception {
    FeatureOnlineStore expectedResponse =
        FeatureOnlineStore.newBuilder()
            .setName(
                FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDedicatedServingEndpoint(
                FeatureOnlineStore.DedicatedServingEndpoint.newBuilder().build())
            .setEmbeddingManagement(FeatureOnlineStore.EmbeddingManagement.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureOnlineStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
    String featureOnlineStoreId = "featureOnlineStoreId1046065331";

    FeatureOnlineStore actualResponse =
        client
            .createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureOnlineStoreRequest actualRequest =
        ((CreateFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(featureOnlineStore, actualRequest.getFeatureOnlineStore());
    Assert.assertEquals(featureOnlineStoreId, actualRequest.getFeatureOnlineStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureOnlineStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
      String featureOnlineStoreId = "featureOnlineStoreId1046065331";
      client.createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureOnlineStoreTest2() throws Exception {
    FeatureOnlineStore expectedResponse =
        FeatureOnlineStore.newBuilder()
            .setName(
                FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDedicatedServingEndpoint(
                FeatureOnlineStore.DedicatedServingEndpoint.newBuilder().build())
            .setEmbeddingManagement(FeatureOnlineStore.EmbeddingManagement.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureOnlineStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    String parent = "parent-995424086";
    FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
    String featureOnlineStoreId = "featureOnlineStoreId1046065331";

    FeatureOnlineStore actualResponse =
        client
            .createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureOnlineStoreRequest actualRequest =
        ((CreateFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(featureOnlineStore, actualRequest.getFeatureOnlineStore());
    Assert.assertEquals(featureOnlineStoreId, actualRequest.getFeatureOnlineStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureOnlineStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
      String featureOnlineStoreId = "featureOnlineStoreId1046065331";
      client.createFeatureOnlineStoreAsync(parent, featureOnlineStore, featureOnlineStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getFeatureOnlineStoreTest() throws Exception {
    FeatureOnlineStore expectedResponse =
        FeatureOnlineStore.newBuilder()
            .setName(
                FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDedicatedServingEndpoint(
                FeatureOnlineStore.DedicatedServingEndpoint.newBuilder().build())
            .setEmbeddingManagement(FeatureOnlineStore.EmbeddingManagement.newBuilder().build())
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureOnlineStoreName name =
        FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");

    FeatureOnlineStore actualResponse = client.getFeatureOnlineStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureOnlineStoreRequest actualRequest =
        ((GetFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureOnlineStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureOnlineStoreName name =
          FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
      client.getFeatureOnlineStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureOnlineStoreTest2() throws Exception {
    FeatureOnlineStore expectedResponse =
        FeatureOnlineStore.newBuilder()
            .setName(
                FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDedicatedServingEndpoint(
                FeatureOnlineStore.DedicatedServingEndpoint.newBuilder().build())
            .setEmbeddingManagement(FeatureOnlineStore.EmbeddingManagement.newBuilder().build())
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    FeatureOnlineStore actualResponse = client.getFeatureOnlineStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureOnlineStoreRequest actualRequest =
        ((GetFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureOnlineStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeatureOnlineStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureOnlineStoresTest() throws Exception {
    FeatureOnlineStore responsesElement = FeatureOnlineStore.newBuilder().build();
    ListFeatureOnlineStoresResponse expectedResponse =
        ListFeatureOnlineStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureOnlineStores(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFeatureOnlineStoresPagedResponse pagedListResponse = client.listFeatureOnlineStores(parent);

    List<FeatureOnlineStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureOnlineStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureOnlineStoresRequest actualRequest =
        ((ListFeatureOnlineStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureOnlineStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFeatureOnlineStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureOnlineStoresTest2() throws Exception {
    FeatureOnlineStore responsesElement = FeatureOnlineStore.newBuilder().build();
    ListFeatureOnlineStoresResponse expectedResponse =
        ListFeatureOnlineStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureOnlineStores(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeatureOnlineStoresPagedResponse pagedListResponse = client.listFeatureOnlineStores(parent);

    List<FeatureOnlineStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureOnlineStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureOnlineStoresRequest actualRequest =
        ((ListFeatureOnlineStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureOnlineStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeatureOnlineStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeatureOnlineStoreTest() throws Exception {
    FeatureOnlineStore expectedResponse =
        FeatureOnlineStore.newBuilder()
            .setName(
                FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDedicatedServingEndpoint(
                FeatureOnlineStore.DedicatedServingEndpoint.newBuilder().build())
            .setEmbeddingManagement(FeatureOnlineStore.EmbeddingManagement.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureOnlineStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FeatureOnlineStore actualResponse =
        client.updateFeatureOnlineStoreAsync(featureOnlineStore, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeatureOnlineStoreRequest actualRequest =
        ((UpdateFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(featureOnlineStore, actualRequest.getFeatureOnlineStore());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeatureOnlineStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureOnlineStore featureOnlineStore = FeatureOnlineStore.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureOnlineStoreAsync(featureOnlineStore, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureOnlineStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureOnlineStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    FeatureOnlineStoreName name =
        FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
    boolean force = true;

    client.deleteFeatureOnlineStoreAsync(name, force).get();

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureOnlineStoreRequest actualRequest =
        ((DeleteFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureOnlineStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureOnlineStoreName name =
          FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
      boolean force = true;
      client.deleteFeatureOnlineStoreAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureOnlineStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureOnlineStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    String name = "name3373707";
    boolean force = true;

    client.deleteFeatureOnlineStoreAsync(name, force).get();

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureOnlineStoreRequest actualRequest =
        ((DeleteFeatureOnlineStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureOnlineStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteFeatureOnlineStoreAsync(name, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureViewTest() throws Exception {
    FeatureView expectedResponse =
        FeatureView.newBuilder()
            .setName(
                FeatureViewName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setSyncConfig(FeatureView.SyncConfig.newBuilder().build())
            .setVectorSearchConfig(FeatureView.VectorSearchConfig.newBuilder().build())
            .setIndexConfig(FeatureView.IndexConfig.newBuilder().build())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    FeatureOnlineStoreName parent =
        FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
    FeatureView featureView = FeatureView.newBuilder().build();
    String featureViewId = "featureViewId-1437334218";

    FeatureView actualResponse =
        client.createFeatureViewAsync(parent, featureView, featureViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureViewRequest actualRequest = ((CreateFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(featureView, actualRequest.getFeatureView());
    Assert.assertEquals(featureViewId, actualRequest.getFeatureViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureOnlineStoreName parent =
          FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
      FeatureView featureView = FeatureView.newBuilder().build();
      String featureViewId = "featureViewId-1437334218";
      client.createFeatureViewAsync(parent, featureView, featureViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFeatureViewTest2() throws Exception {
    FeatureView expectedResponse =
        FeatureView.newBuilder()
            .setName(
                FeatureViewName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setSyncConfig(FeatureView.SyncConfig.newBuilder().build())
            .setVectorSearchConfig(FeatureView.VectorSearchConfig.newBuilder().build())
            .setIndexConfig(FeatureView.IndexConfig.newBuilder().build())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    String parent = "parent-995424086";
    FeatureView featureView = FeatureView.newBuilder().build();
    String featureViewId = "featureViewId-1437334218";

    FeatureView actualResponse =
        client.createFeatureViewAsync(parent, featureView, featureViewId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeatureViewRequest actualRequest = ((CreateFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(featureView, actualRequest.getFeatureView());
    Assert.assertEquals(featureViewId, actualRequest.getFeatureViewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeatureViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      FeatureView featureView = FeatureView.newBuilder().build();
      String featureViewId = "featureViewId-1437334218";
      client.createFeatureViewAsync(parent, featureView, featureViewId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getFeatureViewTest() throws Exception {
    FeatureView expectedResponse =
        FeatureView.newBuilder()
            .setName(
                FeatureViewName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setSyncConfig(FeatureView.SyncConfig.newBuilder().build())
            .setVectorSearchConfig(FeatureView.VectorSearchConfig.newBuilder().build())
            .setIndexConfig(FeatureView.IndexConfig.newBuilder().build())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureViewName name =
        FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");

    FeatureView actualResponse = client.getFeatureView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureViewRequest actualRequest = ((GetFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureViewName name =
          FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
      client.getFeatureView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureViewTest2() throws Exception {
    FeatureView expectedResponse =
        FeatureView.newBuilder()
            .setName(
                FeatureViewName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setSyncConfig(FeatureView.SyncConfig.newBuilder().build())
            .setVectorSearchConfig(FeatureView.VectorSearchConfig.newBuilder().build())
            .setIndexConfig(FeatureView.IndexConfig.newBuilder().build())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    FeatureView actualResponse = client.getFeatureView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureViewRequest actualRequest = ((GetFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeatureView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureViewsTest() throws Exception {
    FeatureView responsesElement = FeatureView.newBuilder().build();
    ListFeatureViewsResponse expectedResponse =
        ListFeatureViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureViews(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureOnlineStoreName parent =
        FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");

    ListFeatureViewsPagedResponse pagedListResponse = client.listFeatureViews(parent);

    List<FeatureView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureViewsRequest actualRequest = ((ListFeatureViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureOnlineStoreName parent =
          FeatureOnlineStoreName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]");
      client.listFeatureViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureViewsTest2() throws Exception {
    FeatureView responsesElement = FeatureView.newBuilder().build();
    ListFeatureViewsResponse expectedResponse =
        ListFeatureViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureViews(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeatureViewsPagedResponse pagedListResponse = client.listFeatureViews(parent);

    List<FeatureView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureViewsRequest actualRequest = ((ListFeatureViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureViewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeatureViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeatureViewTest() throws Exception {
    FeatureView expectedResponse =
        FeatureView.newBuilder()
            .setName(
                FeatureViewName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setSyncConfig(FeatureView.SyncConfig.newBuilder().build())
            .setVectorSearchConfig(FeatureView.VectorSearchConfig.newBuilder().build())
            .setIndexConfig(FeatureView.IndexConfig.newBuilder().build())
            .setServiceAccountEmail("serviceAccountEmail1825953988")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    FeatureView featureView = FeatureView.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FeatureView actualResponse = client.updateFeatureViewAsync(featureView, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeatureViewRequest actualRequest = ((UpdateFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(featureView, actualRequest.getFeatureView());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeatureViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureView featureView = FeatureView.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureViewAsync(featureView, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureViewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    FeatureViewName name =
        FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");

    client.deleteFeatureViewAsync(name).get();

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureViewRequest actualRequest = ((DeleteFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureViewName name =
          FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
      client.deleteFeatureViewAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFeatureViewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureViewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFeatureViewAsync(name).get();

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeatureViewRequest actualRequest = ((DeleteFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeatureViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFeatureViewAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void syncFeatureViewTest() throws Exception {
    SyncFeatureViewResponse expectedResponse =
        SyncFeatureViewResponse.newBuilder()
            .setFeatureViewSync("featureViewSync1701607414")
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureViewName featureView =
        FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");

    SyncFeatureViewResponse actualResponse = client.syncFeatureView(featureView);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SyncFeatureViewRequest actualRequest = ((SyncFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(featureView.toString(), actualRequest.getFeatureView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void syncFeatureViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureViewName featureView =
          FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
      client.syncFeatureView(featureView);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void syncFeatureViewTest2() throws Exception {
    SyncFeatureViewResponse expectedResponse =
        SyncFeatureViewResponse.newBuilder()
            .setFeatureViewSync("featureViewSync1701607414")
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String featureView = "featureView-376914245";

    SyncFeatureViewResponse actualResponse = client.syncFeatureView(featureView);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SyncFeatureViewRequest actualRequest = ((SyncFeatureViewRequest) actualRequests.get(0));

    Assert.assertEquals(featureView, actualRequest.getFeatureView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void syncFeatureViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String featureView = "featureView-376914245";
      client.syncFeatureView(featureView);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureViewSyncTest() throws Exception {
    FeatureViewSync expectedResponse =
        FeatureViewSync.newBuilder()
            .setName(
                FeatureViewSyncName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRunTime(Interval.newBuilder().build())
            .setFinalStatus(Status.newBuilder().build())
            .setSyncSummary(FeatureViewSync.SyncSummary.newBuilder().build())
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureViewSyncName name =
        FeatureViewSyncName.of(
            "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");

    FeatureViewSync actualResponse = client.getFeatureViewSync(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureViewSyncRequest actualRequest = ((GetFeatureViewSyncRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureViewSyncExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureViewSyncName name =
          FeatureViewSyncName.of(
              "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
      client.getFeatureViewSync(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureViewSyncTest2() throws Exception {
    FeatureViewSync expectedResponse =
        FeatureViewSync.newBuilder()
            .setName(
                FeatureViewSyncName.of(
                        "[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRunTime(Interval.newBuilder().build())
            .setFinalStatus(Status.newBuilder().build())
            .setSyncSummary(FeatureViewSync.SyncSummary.newBuilder().build())
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    FeatureViewSync actualResponse = client.getFeatureViewSync(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeatureViewSyncRequest actualRequest = ((GetFeatureViewSyncRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeatureViewSyncExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getFeatureViewSync(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureViewSyncsTest() throws Exception {
    FeatureViewSync responsesElement = FeatureViewSync.newBuilder().build();
    ListFeatureViewSyncsResponse expectedResponse =
        ListFeatureViewSyncsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureViewSyncs(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    FeatureViewName parent =
        FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");

    ListFeatureViewSyncsPagedResponse pagedListResponse = client.listFeatureViewSyncs(parent);

    List<FeatureViewSync> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureViewSyncsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureViewSyncsRequest actualRequest =
        ((ListFeatureViewSyncsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureViewSyncsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      FeatureViewName parent =
          FeatureViewName.of("[PROJECT]", "[LOCATION]", "[FEATURE_ONLINE_STORE]", "[FEATURE_VIEW]");
      client.listFeatureViewSyncs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeatureViewSyncsTest2() throws Exception {
    FeatureViewSync responsesElement = FeatureViewSync.newBuilder().build();
    ListFeatureViewSyncsResponse expectedResponse =
        ListFeatureViewSyncsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeatureViewSyncs(Arrays.asList(responsesElement))
            .build();
    mockFeatureOnlineStoreAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeatureViewSyncsPagedResponse pagedListResponse = client.listFeatureViewSyncs(parent);

    List<FeatureViewSync> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeatureViewSyncsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFeatureOnlineStoreAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeatureViewSyncsRequest actualRequest =
        ((ListFeatureViewSyncsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeatureViewSyncsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFeatureOnlineStoreAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFeatureViewSyncs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
