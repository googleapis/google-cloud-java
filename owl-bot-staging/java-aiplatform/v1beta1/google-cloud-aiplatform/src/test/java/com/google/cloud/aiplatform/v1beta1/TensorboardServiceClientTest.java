/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ExportTensorboardTimeSeriesDataPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ListTensorboardExperimentsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ListTensorboardRunsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ListTensorboardTimeSeriesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.TensorboardServiceClient.ListTensorboardsPagedResponse;

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
public class TensorboardServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockTensorboardService mockTensorboardService;
  private LocalChannelProvider channelProvider;
  private TensorboardServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTensorboardService = new MockTensorboardService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTensorboardService, mockLocations, mockIAMPolicy));
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
    TensorboardServiceSettings settings =
        TensorboardServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TensorboardServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTensorboardTest() throws Exception {
    Tensorboard expectedResponse =
        Tensorboard.newBuilder()
            .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setBlobStoragePathPrefix("blobStoragePathPrefix-1184583211")
            .setRunCount(-485221797)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTensorboardTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
    Tensorboard tensorboard = Tensorboard.newBuilder().build();

    Tensorboard actualResponse = client.createTensorboardAsync(parent, tensorboard).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardRequest actualRequest = ((CreateTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tensorboard, actualRequest.getTensorboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
      Tensorboard tensorboard = Tensorboard.newBuilder().build();
      client.createTensorboardAsync(parent, tensorboard).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTensorboardTest2() throws Exception {
    Tensorboard expectedResponse =
        Tensorboard.newBuilder()
            .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setBlobStoragePathPrefix("blobStoragePathPrefix-1184583211")
            .setRunCount(-485221797)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTensorboardTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Tensorboard tensorboard = Tensorboard.newBuilder().build();

    Tensorboard actualResponse = client.createTensorboardAsync(parent, tensorboard).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardRequest actualRequest = ((CreateTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tensorboard, actualRequest.getTensorboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      Tensorboard tensorboard = Tensorboard.newBuilder().build();
      client.createTensorboardAsync(parent, tensorboard).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getTensorboardTest() throws Exception {
    Tensorboard expectedResponse =
        Tensorboard.newBuilder()
            .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setBlobStoragePathPrefix("blobStoragePathPrefix-1184583211")
            .setRunCount(-485221797)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");

    Tensorboard actualResponse = client.getTensorboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardRequest actualRequest = ((GetTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
      client.getTensorboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardTest2() throws Exception {
    Tensorboard expectedResponse =
        Tensorboard.newBuilder()
            .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setBlobStoragePathPrefix("blobStoragePathPrefix-1184583211")
            .setRunCount(-485221797)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String name = "name3373707";

    Tensorboard actualResponse = client.getTensorboard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardRequest actualRequest = ((GetTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.getTensorboard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTensorboardTest() throws Exception {
    Tensorboard expectedResponse =
        Tensorboard.newBuilder()
            .setName(TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setBlobStoragePathPrefix("blobStoragePathPrefix-1184583211")
            .setRunCount(-485221797)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTensorboardTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    Tensorboard tensorboard = Tensorboard.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tensorboard actualResponse = client.updateTensorboardAsync(tensorboard, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTensorboardRequest actualRequest = ((UpdateTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboard, actualRequest.getTensorboard());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTensorboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      Tensorboard tensorboard = Tensorboard.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTensorboardAsync(tensorboard, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTensorboardsTest() throws Exception {
    Tensorboard responsesElement = Tensorboard.newBuilder().build();
    ListTensorboardsResponse expectedResponse =
        ListTensorboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboards(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTensorboardsPagedResponse pagedListResponse = client.listTensorboards(parent);

    List<Tensorboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardsRequest actualRequest = ((ListTensorboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTensorboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardsTest2() throws Exception {
    Tensorboard responsesElement = Tensorboard.newBuilder().build();
    ListTensorboardsResponse expectedResponse =
        ListTensorboardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboards(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTensorboardsPagedResponse pagedListResponse = client.listTensorboards(parent);

    List<Tensorboard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardsRequest actualRequest = ((ListTensorboardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTensorboards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTensorboardTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");

    client.deleteTensorboardAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardRequest actualRequest = ((DeleteTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
      client.deleteTensorboardAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTensorboardTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTensorboardAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardRequest actualRequest = ((DeleteTensorboardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTensorboardAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTensorboardExperimentTest() throws Exception {
    TensorboardExperiment expectedResponse =
        TensorboardExperiment.newBuilder()
            .setName(
                TensorboardExperimentName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setSource("source-896505829")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName parent =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
    TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
    String tensorboardExperimentId = "tensorboardExperimentId1267328197";

    TensorboardExperiment actualResponse =
        client.createTensorboardExperiment(parent, tensorboardExperiment, tensorboardExperimentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardExperimentRequest actualRequest =
        ((CreateTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tensorboardExperiment, actualRequest.getTensorboardExperiment());
    Assert.assertEquals(tensorboardExperimentId, actualRequest.getTensorboardExperimentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardExperimentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName parent =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
      String tensorboardExperimentId = "tensorboardExperimentId1267328197";
      client.createTensorboardExperiment(parent, tensorboardExperiment, tensorboardExperimentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTensorboardExperimentTest2() throws Exception {
    TensorboardExperiment expectedResponse =
        TensorboardExperiment.newBuilder()
            .setName(
                TensorboardExperimentName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setSource("source-896505829")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
    String tensorboardExperimentId = "tensorboardExperimentId1267328197";

    TensorboardExperiment actualResponse =
        client.createTensorboardExperiment(parent, tensorboardExperiment, tensorboardExperimentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardExperimentRequest actualRequest =
        ((CreateTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tensorboardExperiment, actualRequest.getTensorboardExperiment());
    Assert.assertEquals(tensorboardExperimentId, actualRequest.getTensorboardExperimentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardExperimentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
      String tensorboardExperimentId = "tensorboardExperimentId1267328197";
      client.createTensorboardExperiment(parent, tensorboardExperiment, tensorboardExperimentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardExperimentTest() throws Exception {
    TensorboardExperiment expectedResponse =
        TensorboardExperiment.newBuilder()
            .setName(
                TensorboardExperimentName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setSource("source-896505829")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName name =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");

    TensorboardExperiment actualResponse = client.getTensorboardExperiment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardExperimentRequest actualRequest =
        ((GetTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardExperimentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName name =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      client.getTensorboardExperiment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardExperimentTest2() throws Exception {
    TensorboardExperiment expectedResponse =
        TensorboardExperiment.newBuilder()
            .setName(
                TensorboardExperimentName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setSource("source-896505829")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String name = "name3373707";

    TensorboardExperiment actualResponse = client.getTensorboardExperiment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardExperimentRequest actualRequest =
        ((GetTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardExperimentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.getTensorboardExperiment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTensorboardExperimentTest() throws Exception {
    TensorboardExperiment expectedResponse =
        TensorboardExperiment.newBuilder()
            .setName(
                TensorboardExperimentName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setSource("source-896505829")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TensorboardExperiment actualResponse =
        client.updateTensorboardExperiment(tensorboardExperiment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTensorboardExperimentRequest actualRequest =
        ((UpdateTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardExperiment, actualRequest.getTensorboardExperiment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTensorboardExperimentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperiment tensorboardExperiment = TensorboardExperiment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTensorboardExperiment(tensorboardExperiment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardExperimentsTest() throws Exception {
    TensorboardExperiment responsesElement = TensorboardExperiment.newBuilder().build();
    ListTensorboardExperimentsResponse expectedResponse =
        ListTensorboardExperimentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardExperiments(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");

    ListTensorboardExperimentsPagedResponse pagedListResponse =
        client.listTensorboardExperiments(parent);

    List<TensorboardExperiment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardExperimentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardExperimentsRequest actualRequest =
        ((ListTensorboardExperimentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardExperimentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardName parent = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
      client.listTensorboardExperiments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardExperimentsTest2() throws Exception {
    TensorboardExperiment responsesElement = TensorboardExperiment.newBuilder().build();
    ListTensorboardExperimentsResponse expectedResponse =
        ListTensorboardExperimentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardExperiments(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTensorboardExperimentsPagedResponse pagedListResponse =
        client.listTensorboardExperiments(parent);

    List<TensorboardExperiment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardExperimentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardExperimentsRequest actualRequest =
        ((ListTensorboardExperimentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardExperimentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTensorboardExperiments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTensorboardExperimentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardExperimentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    TensorboardExperimentName name =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");

    client.deleteTensorboardExperimentAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardExperimentRequest actualRequest =
        ((DeleteTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardExperimentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName name =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      client.deleteTensorboardExperimentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTensorboardExperimentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardExperimentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTensorboardExperimentAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardExperimentRequest actualRequest =
        ((DeleteTensorboardExperimentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardExperimentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTensorboardExperimentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTensorboardRunTest() throws Exception {
    TensorboardRun expectedResponse =
        TensorboardRun.newBuilder()
            .setName(
                TensorboardRunName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardRunName parent =
        TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
    TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
    String tensorboardRunId = "tensorboardRunId-407822631";

    TensorboardRun actualResponse =
        client.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardRunRequest actualRequest =
        ((CreateTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tensorboardRun, actualRequest.getTensorboardRun());
    Assert.assertEquals(tensorboardRunId, actualRequest.getTensorboardRunId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRunName parent =
          TensorboardRunName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
      TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
      String tensorboardRunId = "tensorboardRunId-407822631";
      client.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTensorboardRunTest2() throws Exception {
    TensorboardRun expectedResponse =
        TensorboardRun.newBuilder()
            .setName(
                TensorboardRunName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
    String tensorboardRunId = "tensorboardRunId-407822631";

    TensorboardRun actualResponse =
        client.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardRunRequest actualRequest =
        ((CreateTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tensorboardRun, actualRequest.getTensorboardRun());
    Assert.assertEquals(tensorboardRunId, actualRequest.getTensorboardRunId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
      String tensorboardRunId = "tensorboardRunId-407822631";
      client.createTensorboardRun(parent, tensorboardRun, tensorboardRunId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTensorboardRunsTest() throws Exception {
    BatchCreateTensorboardRunsResponse expectedResponse =
        BatchCreateTensorboardRunsResponse.newBuilder()
            .addAllTensorboardRuns(new ArrayList<TensorboardRun>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName parent =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
    List<CreateTensorboardRunRequest> requests = new ArrayList<>();

    BatchCreateTensorboardRunsResponse actualResponse =
        client.batchCreateTensorboardRuns(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTensorboardRunsRequest actualRequest =
        ((BatchCreateTensorboardRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTensorboardRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName parent =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      List<CreateTensorboardRunRequest> requests = new ArrayList<>();
      client.batchCreateTensorboardRuns(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTensorboardRunsTest2() throws Exception {
    BatchCreateTensorboardRunsResponse expectedResponse =
        BatchCreateTensorboardRunsResponse.newBuilder()
            .addAllTensorboardRuns(new ArrayList<TensorboardRun>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateTensorboardRunRequest> requests = new ArrayList<>();

    BatchCreateTensorboardRunsResponse actualResponse =
        client.batchCreateTensorboardRuns(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTensorboardRunsRequest actualRequest =
        ((BatchCreateTensorboardRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTensorboardRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateTensorboardRunRequest> requests = new ArrayList<>();
      client.batchCreateTensorboardRuns(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardRunTest() throws Exception {
    TensorboardRun expectedResponse =
        TensorboardRun.newBuilder()
            .setName(
                TensorboardRunName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardRunName name =
        TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");

    TensorboardRun actualResponse = client.getTensorboardRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardRunRequest actualRequest = ((GetTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRunName name =
          TensorboardRunName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
      client.getTensorboardRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardRunTest2() throws Exception {
    TensorboardRun expectedResponse =
        TensorboardRun.newBuilder()
            .setName(
                TensorboardRunName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String name = "name3373707";

    TensorboardRun actualResponse = client.getTensorboardRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardRunRequest actualRequest = ((GetTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.getTensorboardRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTensorboardRunTest() throws Exception {
    TensorboardRun expectedResponse =
        TensorboardRun.newBuilder()
            .setName(
                TensorboardRunName.of(
                        "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TensorboardRun actualResponse = client.updateTensorboardRun(tensorboardRun, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTensorboardRunRequest actualRequest =
        ((UpdateTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardRun, actualRequest.getTensorboardRun());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTensorboardRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRun tensorboardRun = TensorboardRun.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTensorboardRun(tensorboardRun, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardRunsTest() throws Exception {
    TensorboardRun responsesElement = TensorboardRun.newBuilder().build();
    ListTensorboardRunsResponse expectedResponse =
        ListTensorboardRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardRuns(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName parent =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");

    ListTensorboardRunsPagedResponse pagedListResponse = client.listTensorboardRuns(parent);

    List<TensorboardRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardRunsRequest actualRequest = ((ListTensorboardRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName parent =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      client.listTensorboardRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardRunsTest2() throws Exception {
    TensorboardRun responsesElement = TensorboardRun.newBuilder().build();
    ListTensorboardRunsResponse expectedResponse =
        ListTensorboardRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardRuns(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTensorboardRunsPagedResponse pagedListResponse = client.listTensorboardRuns(parent);

    List<TensorboardRun> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardRunsRequest actualRequest = ((ListTensorboardRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTensorboardRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTensorboardRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    TensorboardRunName name =
        TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");

    client.deleteTensorboardRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardRunRequest actualRequest =
        ((DeleteTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRunName name =
          TensorboardRunName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
      client.deleteTensorboardRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTensorboardRunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTensorboardRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardRunRequest actualRequest =
        ((DeleteTensorboardRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTensorboardRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreateTensorboardTimeSeriesTest() throws Exception {
    BatchCreateTensorboardTimeSeriesResponse expectedResponse =
        BatchCreateTensorboardTimeSeriesResponse.newBuilder()
            .addAllTensorboardTimeSeries(new ArrayList<TensorboardTimeSeries>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName parent =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
    List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();

    BatchCreateTensorboardTimeSeriesResponse actualResponse =
        client.batchCreateTensorboardTimeSeries(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTensorboardTimeSeriesRequest actualRequest =
        ((BatchCreateTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName parent =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();
      client.batchCreateTensorboardTimeSeries(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTensorboardTimeSeriesTest2() throws Exception {
    BatchCreateTensorboardTimeSeriesResponse expectedResponse =
        BatchCreateTensorboardTimeSeriesResponse.newBuilder()
            .addAllTensorboardTimeSeries(new ArrayList<TensorboardTimeSeries>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();

    BatchCreateTensorboardTimeSeriesResponse actualResponse =
        client.batchCreateTensorboardTimeSeries(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateTensorboardTimeSeriesRequest actualRequest =
        ((BatchCreateTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateTensorboardTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateTensorboardTimeSeriesRequest> requests = new ArrayList<>();
      client.batchCreateTensorboardTimeSeries(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTensorboardTimeSeriesTest() throws Exception {
    TensorboardTimeSeries expectedResponse =
        TensorboardTimeSeries.newBuilder()
            .setName(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setPluginName("pluginName-387216290")
            .setPluginData(ByteString.EMPTY)
            .setMetadata(TensorboardTimeSeries.Metadata.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardTimeSeriesName parent =
        TensorboardTimeSeriesName.of(
            "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
    TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();

    TensorboardTimeSeries actualResponse =
        client.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardTimeSeriesRequest actualRequest =
        ((CreateTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tensorboardTimeSeries, actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeriesName parent =
          TensorboardTimeSeriesName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
      TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
      client.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTensorboardTimeSeriesTest2() throws Exception {
    TensorboardTimeSeries expectedResponse =
        TensorboardTimeSeries.newBuilder()
            .setName(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setPluginName("pluginName-387216290")
            .setPluginData(ByteString.EMPTY)
            .setMetadata(TensorboardTimeSeries.Metadata.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();

    TensorboardTimeSeries actualResponse =
        client.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTensorboardTimeSeriesRequest actualRequest =
        ((CreateTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tensorboardTimeSeries, actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTensorboardTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
      client.createTensorboardTimeSeries(parent, tensorboardTimeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardTimeSeriesTest() throws Exception {
    TensorboardTimeSeries expectedResponse =
        TensorboardTimeSeries.newBuilder()
            .setName(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setPluginName("pluginName-387216290")
            .setPluginData(ByteString.EMPTY)
            .setMetadata(TensorboardTimeSeries.Metadata.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardTimeSeriesName name =
        TensorboardTimeSeriesName.of(
            "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");

    TensorboardTimeSeries actualResponse = client.getTensorboardTimeSeries(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardTimeSeriesRequest actualRequest =
        ((GetTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeriesName name =
          TensorboardTimeSeriesName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
      client.getTensorboardTimeSeries(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorboardTimeSeriesTest2() throws Exception {
    TensorboardTimeSeries expectedResponse =
        TensorboardTimeSeries.newBuilder()
            .setName(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setPluginName("pluginName-387216290")
            .setPluginData(ByteString.EMPTY)
            .setMetadata(TensorboardTimeSeries.Metadata.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String name = "name3373707";

    TensorboardTimeSeries actualResponse = client.getTensorboardTimeSeries(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorboardTimeSeriesRequest actualRequest =
        ((GetTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorboardTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.getTensorboardTimeSeries(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTensorboardTimeSeriesTest() throws Exception {
    TensorboardTimeSeries expectedResponse =
        TensorboardTimeSeries.newBuilder()
            .setName(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setPluginName("pluginName-387216290")
            .setPluginData(ByteString.EMPTY)
            .setMetadata(TensorboardTimeSeries.Metadata.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TensorboardTimeSeries actualResponse =
        client.updateTensorboardTimeSeries(tensorboardTimeSeries, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTensorboardTimeSeriesRequest actualRequest =
        ((UpdateTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardTimeSeries, actualRequest.getTensorboardTimeSeries());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeries tensorboardTimeSeries = TensorboardTimeSeries.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTensorboardTimeSeries(tensorboardTimeSeries, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardTimeSeriesTest() throws Exception {
    TensorboardTimeSeries responsesElement = TensorboardTimeSeries.newBuilder().build();
    ListTensorboardTimeSeriesResponse expectedResponse =
        ListTensorboardTimeSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardTimeSeries(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardRunName parent =
        TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");

    ListTensorboardTimeSeriesPagedResponse pagedListResponse =
        client.listTensorboardTimeSeries(parent);

    List<TensorboardTimeSeries> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardTimeSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardTimeSeriesRequest actualRequest =
        ((ListTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRunName parent =
          TensorboardRunName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
      client.listTensorboardTimeSeries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorboardTimeSeriesTest2() throws Exception {
    TensorboardTimeSeries responsesElement = TensorboardTimeSeries.newBuilder().build();
    ListTensorboardTimeSeriesResponse expectedResponse =
        ListTensorboardTimeSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorboardTimeSeries(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTensorboardTimeSeriesPagedResponse pagedListResponse =
        client.listTensorboardTimeSeries(parent);

    List<TensorboardTimeSeries> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorboardTimeSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorboardTimeSeriesRequest actualRequest =
        ((ListTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorboardTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTensorboardTimeSeries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTensorboardTimeSeriesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardTimeSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    TensorboardTimeSeriesName name =
        TensorboardTimeSeriesName.of(
            "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");

    client.deleteTensorboardTimeSeriesAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardTimeSeriesRequest actualRequest =
        ((DeleteTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeriesName name =
          TensorboardTimeSeriesName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
      client.deleteTensorboardTimeSeriesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTensorboardTimeSeriesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTensorboardTimeSeriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTensorboardService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTensorboardTimeSeriesAsync(name).get();

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTensorboardTimeSeriesRequest actualRequest =
        ((DeleteTensorboardTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTensorboardTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTensorboardTimeSeriesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchReadTensorboardTimeSeriesDataTest() throws Exception {
    BatchReadTensorboardTimeSeriesDataResponse expectedResponse =
        BatchReadTensorboardTimeSeriesDataResponse.newBuilder()
            .addAllTimeSeriesData(new ArrayList<TimeSeriesData>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardName tensorboard = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");

    BatchReadTensorboardTimeSeriesDataResponse actualResponse =
        client.batchReadTensorboardTimeSeriesData(tensorboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchReadTensorboardTimeSeriesDataRequest actualRequest =
        ((BatchReadTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboard.toString(), actualRequest.getTensorboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchReadTensorboardTimeSeriesDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardName tensorboard = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
      client.batchReadTensorboardTimeSeriesData(tensorboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReadTensorboardTimeSeriesDataTest2() throws Exception {
    BatchReadTensorboardTimeSeriesDataResponse expectedResponse =
        BatchReadTensorboardTimeSeriesDataResponse.newBuilder()
            .addAllTimeSeriesData(new ArrayList<TimeSeriesData>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String tensorboard = "tensorboard-266431955";

    BatchReadTensorboardTimeSeriesDataResponse actualResponse =
        client.batchReadTensorboardTimeSeriesData(tensorboard);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchReadTensorboardTimeSeriesDataRequest actualRequest =
        ((BatchReadTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboard, actualRequest.getTensorboard());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchReadTensorboardTimeSeriesDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String tensorboard = "tensorboard-266431955";
      client.batchReadTensorboardTimeSeriesData(tensorboard);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readTensorboardTimeSeriesDataTest() throws Exception {
    ReadTensorboardTimeSeriesDataResponse expectedResponse =
        ReadTensorboardTimeSeriesDataResponse.newBuilder()
            .setTimeSeriesData(TimeSeriesData.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardTimeSeriesName tensorboardTimeSeries =
        TensorboardTimeSeriesName.of(
            "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");

    ReadTensorboardTimeSeriesDataResponse actualResponse =
        client.readTensorboardTimeSeriesData(tensorboardTimeSeries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadTensorboardTimeSeriesDataRequest actualRequest =
        ((ReadTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardTimeSeries.toString(), actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readTensorboardTimeSeriesDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeriesName tensorboardTimeSeries =
          TensorboardTimeSeriesName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
      client.readTensorboardTimeSeriesData(tensorboardTimeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readTensorboardTimeSeriesDataTest2() throws Exception {
    ReadTensorboardTimeSeriesDataResponse expectedResponse =
        ReadTensorboardTimeSeriesDataResponse.newBuilder()
            .setTimeSeriesData(TimeSeriesData.newBuilder().build())
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String tensorboardTimeSeries = "tensorboardTimeSeries571115953";

    ReadTensorboardTimeSeriesDataResponse actualResponse =
        client.readTensorboardTimeSeriesData(tensorboardTimeSeries);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadTensorboardTimeSeriesDataRequest actualRequest =
        ((ReadTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardTimeSeries, actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readTensorboardTimeSeriesDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String tensorboardTimeSeries = "tensorboardTimeSeries571115953";
      client.readTensorboardTimeSeriesData(tensorboardTimeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readTensorboardBlobDataTest() throws Exception {
    ReadTensorboardBlobDataResponse expectedResponse =
        ReadTensorboardBlobDataResponse.newBuilder()
            .addAllBlobs(new ArrayList<TensorboardBlob>())
            .build();
    mockTensorboardService.addResponse(expectedResponse);
    ReadTensorboardBlobDataRequest request =
        ReadTensorboardBlobDataRequest.newBuilder()
            .setTimeSeries(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .addAllBlobIds(new ArrayList<String>())
            .build();

    MockStreamObserver<ReadTensorboardBlobDataResponse> responseObserver =
        new MockStreamObserver<>();

    ServerStreamingCallable<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
        callable = client.readTensorboardBlobDataCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadTensorboardBlobDataResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void readTensorboardBlobDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);
    ReadTensorboardBlobDataRequest request =
        ReadTensorboardBlobDataRequest.newBuilder()
            .setTimeSeries(
                TensorboardTimeSeriesName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[TENSORBOARD]",
                        "[EXPERIMENT]",
                        "[RUN]",
                        "[TIME_SERIES]")
                    .toString())
            .addAllBlobIds(new ArrayList<String>())
            .build();

    MockStreamObserver<ReadTensorboardBlobDataResponse> responseObserver =
        new MockStreamObserver<>();

    ServerStreamingCallable<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
        callable = client.readTensorboardBlobDataCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadTensorboardBlobDataResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void writeTensorboardExperimentDataTest() throws Exception {
    WriteTensorboardExperimentDataResponse expectedResponse =
        WriteTensorboardExperimentDataResponse.newBuilder().build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardExperimentName tensorboardExperiment =
        TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
    List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();

    WriteTensorboardExperimentDataResponse actualResponse =
        client.writeTensorboardExperimentData(tensorboardExperiment, writeRunDataRequests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteTensorboardExperimentDataRequest actualRequest =
        ((WriteTensorboardExperimentDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardExperiment.toString(), actualRequest.getTensorboardExperiment());
    Assert.assertEquals(writeRunDataRequests, actualRequest.getWriteRunDataRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeTensorboardExperimentDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardExperimentName tensorboardExperiment =
          TensorboardExperimentName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]");
      List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();
      client.writeTensorboardExperimentData(tensorboardExperiment, writeRunDataRequests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeTensorboardExperimentDataTest2() throws Exception {
    WriteTensorboardExperimentDataResponse expectedResponse =
        WriteTensorboardExperimentDataResponse.newBuilder().build();
    mockTensorboardService.addResponse(expectedResponse);

    String tensorboardExperiment = "tensorboardExperiment-293652982";
    List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();

    WriteTensorboardExperimentDataResponse actualResponse =
        client.writeTensorboardExperimentData(tensorboardExperiment, writeRunDataRequests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteTensorboardExperimentDataRequest actualRequest =
        ((WriteTensorboardExperimentDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardExperiment, actualRequest.getTensorboardExperiment());
    Assert.assertEquals(writeRunDataRequests, actualRequest.getWriteRunDataRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeTensorboardExperimentDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String tensorboardExperiment = "tensorboardExperiment-293652982";
      List<WriteTensorboardRunDataRequest> writeRunDataRequests = new ArrayList<>();
      client.writeTensorboardExperimentData(tensorboardExperiment, writeRunDataRequests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeTensorboardRunDataTest() throws Exception {
    WriteTensorboardRunDataResponse expectedResponse =
        WriteTensorboardRunDataResponse.newBuilder().build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardRunName tensorboardRun =
        TensorboardRunName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
    List<TimeSeriesData> timeSeriesData = new ArrayList<>();

    WriteTensorboardRunDataResponse actualResponse =
        client.writeTensorboardRunData(tensorboardRun, timeSeriesData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteTensorboardRunDataRequest actualRequest =
        ((WriteTensorboardRunDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardRun.toString(), actualRequest.getTensorboardRun());
    Assert.assertEquals(timeSeriesData, actualRequest.getTimeSeriesDataList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeTensorboardRunDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardRunName tensorboardRun =
          TensorboardRunName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]");
      List<TimeSeriesData> timeSeriesData = new ArrayList<>();
      client.writeTensorboardRunData(tensorboardRun, timeSeriesData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeTensorboardRunDataTest2() throws Exception {
    WriteTensorboardRunDataResponse expectedResponse =
        WriteTensorboardRunDataResponse.newBuilder().build();
    mockTensorboardService.addResponse(expectedResponse);

    String tensorboardRun = "tensorboardRun-174725858";
    List<TimeSeriesData> timeSeriesData = new ArrayList<>();

    WriteTensorboardRunDataResponse actualResponse =
        client.writeTensorboardRunData(tensorboardRun, timeSeriesData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteTensorboardRunDataRequest actualRequest =
        ((WriteTensorboardRunDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardRun, actualRequest.getTensorboardRun());
    Assert.assertEquals(timeSeriesData, actualRequest.getTimeSeriesDataList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeTensorboardRunDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String tensorboardRun = "tensorboardRun-174725858";
      List<TimeSeriesData> timeSeriesData = new ArrayList<>();
      client.writeTensorboardRunData(tensorboardRun, timeSeriesData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportTensorboardTimeSeriesDataTest() throws Exception {
    TimeSeriesDataPoint responsesElement = TimeSeriesDataPoint.newBuilder().build();
    ExportTensorboardTimeSeriesDataResponse expectedResponse =
        ExportTensorboardTimeSeriesDataResponse.newBuilder()
            .setNextPageToken("")
            .addAllTimeSeriesDataPoints(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    TensorboardTimeSeriesName tensorboardTimeSeries =
        TensorboardTimeSeriesName.of(
            "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");

    ExportTensorboardTimeSeriesDataPagedResponse pagedListResponse =
        client.exportTensorboardTimeSeriesData(tensorboardTimeSeries);

    List<TimeSeriesDataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTimeSeriesDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportTensorboardTimeSeriesDataRequest actualRequest =
        ((ExportTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardTimeSeries.toString(), actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportTensorboardTimeSeriesDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      TensorboardTimeSeriesName tensorboardTimeSeries =
          TensorboardTimeSeriesName.of(
              "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]", "[TIME_SERIES]");
      client.exportTensorboardTimeSeriesData(tensorboardTimeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportTensorboardTimeSeriesDataTest2() throws Exception {
    TimeSeriesDataPoint responsesElement = TimeSeriesDataPoint.newBuilder().build();
    ExportTensorboardTimeSeriesDataResponse expectedResponse =
        ExportTensorboardTimeSeriesDataResponse.newBuilder()
            .setNextPageToken("")
            .addAllTimeSeriesDataPoints(Arrays.asList(responsesElement))
            .build();
    mockTensorboardService.addResponse(expectedResponse);

    String tensorboardTimeSeries = "tensorboardTimeSeries571115953";

    ExportTensorboardTimeSeriesDataPagedResponse pagedListResponse =
        client.exportTensorboardTimeSeriesData(tensorboardTimeSeries);

    List<TimeSeriesDataPoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTimeSeriesDataPointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTensorboardService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportTensorboardTimeSeriesDataRequest actualRequest =
        ((ExportTensorboardTimeSeriesDataRequest) actualRequests.get(0));

    Assert.assertEquals(tensorboardTimeSeries, actualRequest.getTensorboardTimeSeries());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportTensorboardTimeSeriesDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTensorboardService.addException(exception);

    try {
      String tensorboardTimeSeries = "tensorboardTimeSeries571115953";
      client.exportTensorboardTimeSeriesData(tensorboardTimeSeries);
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
