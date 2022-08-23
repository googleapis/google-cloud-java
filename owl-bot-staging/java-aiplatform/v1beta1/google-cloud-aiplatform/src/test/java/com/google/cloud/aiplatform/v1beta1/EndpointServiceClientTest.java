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

import static com.google.cloud.aiplatform.v1beta1.EndpointServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.EndpointServiceClient.ListLocationsPagedResponse;

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
import java.util.Map;
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
public class EndpointServiceClientTest {
  private static MockEndpointService mockEndpointService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EndpointServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEndpointService = new MockEndpointService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEndpointService, mockLocations, mockIAMPolicy));
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
    EndpointServiceSettings settings =
        EndpointServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EndpointServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Endpoint endpoint = Endpoint.newBuilder().build();

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Endpoint endpoint = Endpoint.newBuilder().build();
      client.createEndpointAsync(parent, endpoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Endpoint endpoint = Endpoint.newBuilder().build();

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String parent = "parent-995424086";
      Endpoint endpoint = Endpoint.newBuilder().build();
      client.createEndpointAsync(parent, endpoint).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEndpointTest3() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint, endpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(endpointId, actualRequest.getEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpointAsync(parent, endpoint, endpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEndpointTest4() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint, endpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(endpointId, actualRequest.getEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String parent = "parent-995424086";
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpointAsync(parent, endpoint, endpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    mockEndpointService.addResponse(expectedResponse);

    EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    mockEndpointService.addResponse(expectedResponse);

    String name = "name3373707";

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String name = "name3373707";
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockEndpointService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest2() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockEndpointService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllDeployedModels(new ArrayList<DeployedModel>())
            .putAllTrafficSplit(new HashMap<String, Integer>())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .setNetwork("network1843485230")
            .setEnablePrivateServiceConnect(true)
            .setModelDeploymentMonitoringJob(
                ModelDeploymentMonitoringJobName.of(
                        "[PROJECT]", "[LOCATION]", "[MODEL_DEPLOYMENT_MONITORING_JOB]")
                    .toString())
            .setPredictRequestResponseLoggingConfig(
                PredictRequestResponseLoggingConfig.newBuilder().build())
            .build();
    mockEndpointService.addResponse(expectedResponse);

    Endpoint endpoint = Endpoint.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Endpoint actualResponse = client.updateEndpoint(endpoint, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEndpointRequest actualRequest = ((UpdateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      Endpoint endpoint = Endpoint.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEndpoint(endpoint, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEndpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    client.deleteEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointRequest actualRequest = ((DeleteEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      client.deleteEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEndpointTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointRequest actualRequest = ((DeleteEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployModelTest() throws Exception {
    DeployModelResponse expectedResponse =
        DeployModelResponse.newBuilder()
            .setDeployedModel(DeployedModel.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
    DeployedModel deployedModel = DeployedModel.newBuilder().build();
    Map<String, Integer> trafficSplit = new HashMap<>();

    DeployModelResponse actualResponse =
        client.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployModelRequest actualRequest = ((DeployModelRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint.toString(), actualRequest.getEndpoint());
    Assert.assertEquals(deployedModel, actualRequest.getDeployedModel());
    Assert.assertEquals(trafficSplit, actualRequest.getTrafficSplitMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      DeployedModel deployedModel = DeployedModel.newBuilder().build();
      Map<String, Integer> trafficSplit = new HashMap<>();
      client.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployModelTest2() throws Exception {
    DeployModelResponse expectedResponse =
        DeployModelResponse.newBuilder()
            .setDeployedModel(DeployedModel.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    String endpoint = "endpoint1741102485";
    DeployedModel deployedModel = DeployedModel.newBuilder().build();
    Map<String, Integer> trafficSplit = new HashMap<>();

    DeployModelResponse actualResponse =
        client.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployModelRequest actualRequest = ((DeployModelRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(deployedModel, actualRequest.getDeployedModel());
    Assert.assertEquals(trafficSplit, actualRequest.getTrafficSplitMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String endpoint = "endpoint1741102485";
      DeployedModel deployedModel = DeployedModel.newBuilder().build();
      Map<String, Integer> trafficSplit = new HashMap<>();
      client.deployModelAsync(endpoint, deployedModel, trafficSplit).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployModelTest() throws Exception {
    UndeployModelResponse expectedResponse = UndeployModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
    String deployedModelId = "deployedModelId-1817547906";
    Map<String, Integer> trafficSplit = new HashMap<>();

    UndeployModelResponse actualResponse =
        client.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployModelRequest actualRequest = ((UndeployModelRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint.toString(), actualRequest.getEndpoint());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertEquals(trafficSplit, actualRequest.getTrafficSplitMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      String deployedModelId = "deployedModelId-1817547906";
      Map<String, Integer> trafficSplit = new HashMap<>();
      client.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployModelTest2() throws Exception {
    UndeployModelResponse expectedResponse = UndeployModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEndpointService.addResponse(resultOperation);

    String endpoint = "endpoint1741102485";
    String deployedModelId = "deployedModelId-1817547906";
    Map<String, Integer> trafficSplit = new HashMap<>();

    UndeployModelResponse actualResponse =
        client.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEndpointService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployModelRequest actualRequest = ((UndeployModelRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertEquals(trafficSplit, actualRequest.getTrafficSplitMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEndpointService.addException(exception);

    try {
      String endpoint = "endpoint1741102485";
      String deployedModelId = "deployedModelId-1817547906";
      Map<String, Integer> trafficSplit = new HashMap<>();
      client.undeployModelAsync(endpoint, deployedModelId, trafficSplit).get();
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
