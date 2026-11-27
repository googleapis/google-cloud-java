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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.AggregateAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAgentAnomalyDetectionScopesPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedInvocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListMonitoredAgentsPagedResponse;

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
public class AgentAnomalyDetectionServiceClientTest {
  private static MockAgentAnomalyDetectionService mockAgentAnomalyDetectionService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AgentAnomalyDetectionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAgentAnomalyDetectionService = new MockAgentAnomalyDetectionService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockAgentAnomalyDetectionService, mockLocations, mockIAMPolicy));
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
    AgentAnomalyDetectionServiceSettings settings =
        AgentAnomalyDetectionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentAnomalyDetectionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAgentAnomalyDetectionScopeTest() throws Exception {
    AgentAnomalyDetectionScope expectedResponse =
        AgentAnomalyDetectionScope.newBuilder()
            .setName(
                AgentAnomalyDetectionScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllLogBuckets(new ArrayList<String>())
            .addAllObservabilityBuckets(new ArrayList<String>())
            .setAutoEnroll(true)
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    AgentAnomalyDetectionScopeName name =
        AgentAnomalyDetectionScopeName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");

    AgentAnomalyDetectionScope actualResponse = client.getAgentAnomalyDetectionScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentAnomalyDetectionScopeRequest actualRequest =
        ((GetAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentAnomalyDetectionScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      AgentAnomalyDetectionScopeName name =
          AgentAnomalyDetectionScopeName.of(
              "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");
      client.getAgentAnomalyDetectionScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentAnomalyDetectionScopeTest2() throws Exception {
    AgentAnomalyDetectionScope expectedResponse =
        AgentAnomalyDetectionScope.newBuilder()
            .setName(
                AgentAnomalyDetectionScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllLogBuckets(new ArrayList<String>())
            .addAllObservabilityBuckets(new ArrayList<String>())
            .setAutoEnroll(true)
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String name = "name3373707";

    AgentAnomalyDetectionScope actualResponse = client.getAgentAnomalyDetectionScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentAnomalyDetectionScopeRequest actualRequest =
        ((GetAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentAnomalyDetectionScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.getAgentAnomalyDetectionScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMonitoredAgentTest() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    MonitoredAgentName name = MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    MonitoredAgent actualResponse = client.getMonitoredAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredAgentRequest actualRequest = ((GetMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMonitoredAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName name =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.getMonitoredAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMonitoredAgentTest2() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String name = "name3373707";

    MonitoredAgent actualResponse = client.getMonitoredAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredAgentRequest actualRequest = ((GetMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMonitoredAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.getMonitoredAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMonitoredAgentsTest() throws Exception {
    MonitoredAgent responsesElement = MonitoredAgent.newBuilder().build();
    ListMonitoredAgentsResponse expectedResponse =
        ListMonitoredAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoredAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMonitoredAgentsPagedResponse pagedListResponse = client.listMonitoredAgents(parent);

    List<MonitoredAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoredAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredAgentsRequest actualRequest = ((ListMonitoredAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMonitoredAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMonitoredAgentsTest2() throws Exception {
    MonitoredAgent responsesElement = MonitoredAgent.newBuilder().build();
    ListMonitoredAgentsResponse expectedResponse =
        ListMonitoredAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMonitoredAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMonitoredAgentsPagedResponse pagedListResponse = client.listMonitoredAgents(parent);

    List<MonitoredAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMonitoredAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredAgentsRequest actualRequest = ((ListMonitoredAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMonitoredAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableMonitoredAgentTest() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableMonitoredAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    MonitoredAgentName name = MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    MonitoredAgent actualResponse = client.enableMonitoredAgentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableMonitoredAgentRequest actualRequest =
        ((EnableMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableMonitoredAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName name =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.enableMonitoredAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void enableMonitoredAgentTest2() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableMonitoredAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    String name = "name3373707";

    MonitoredAgent actualResponse = client.enableMonitoredAgentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableMonitoredAgentRequest actualRequest =
        ((EnableMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableMonitoredAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.enableMonitoredAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableMonitoredAgentTest() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableMonitoredAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    MonitoredAgentName name = MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    MonitoredAgent actualResponse = client.disableMonitoredAgentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableMonitoredAgentRequest actualRequest =
        ((DisableMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableMonitoredAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName name =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.disableMonitoredAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableMonitoredAgentTest2() throws Exception {
    MonitoredAgent expectedResponse =
        MonitoredAgent.newBuilder()
            .setName(
                MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAgentResource(AgentResource.newBuilder().build())
            .setStatusMessage("statusMessage-958704715")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableMonitoredAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    String name = "name3373707";

    MonitoredAgent actualResponse = client.disableMonitoredAgentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableMonitoredAgentRequest actualRequest =
        ((DisableMonitoredAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableMonitoredAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.disableMonitoredAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAgentAnomalyDetectionScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAgentAnomalyDetectionScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    AgentAnomalyDetectionScopeName name =
        AgentAnomalyDetectionScopeName.of(
            "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");

    client.deleteAgentAnomalyDetectionScopeAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentAnomalyDetectionScopeRequest actualRequest =
        ((DeleteAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentAnomalyDetectionScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      AgentAnomalyDetectionScopeName name =
          AgentAnomalyDetectionScopeName.of(
              "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");
      client.deleteAgentAnomalyDetectionScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAgentAnomalyDetectionScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAgentAnomalyDetectionScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAgentAnomalyDetectionScopeAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentAnomalyDetectionScopeRequest actualRequest =
        ((DeleteAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentAnomalyDetectionScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAgentAnomalyDetectionScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAgentAnomalyDetectionScopeTest() throws Exception {
    AgentAnomalyDetectionScope expectedResponse =
        AgentAnomalyDetectionScope.newBuilder()
            .setName(
                AgentAnomalyDetectionScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllLogBuckets(new ArrayList<String>())
            .addAllObservabilityBuckets(new ArrayList<String>())
            .setAutoEnroll(true)
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAgentAnomalyDetectionScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AgentAnomalyDetectionScope agentAnomalyDetectionScope =
        AgentAnomalyDetectionScope.newBuilder().build();
    String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";

    AgentAnomalyDetectionScope actualResponse =
        client
            .createAgentAnomalyDetectionScopeAsync(
                parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentAnomalyDetectionScopeRequest actualRequest =
        ((CreateAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(agentAnomalyDetectionScope, actualRequest.getAgentAnomalyDetectionScope());
    Assert.assertEquals(
        agentAnomalyDetectionScopeId, actualRequest.getAgentAnomalyDetectionScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentAnomalyDetectionScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AgentAnomalyDetectionScope agentAnomalyDetectionScope =
          AgentAnomalyDetectionScope.newBuilder().build();
      String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";
      client
          .createAgentAnomalyDetectionScopeAsync(
              parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAgentAnomalyDetectionScopeTest2() throws Exception {
    AgentAnomalyDetectionScope expectedResponse =
        AgentAnomalyDetectionScope.newBuilder()
            .setName(
                AgentAnomalyDetectionScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .addAllLogBuckets(new ArrayList<String>())
            .addAllObservabilityBuckets(new ArrayList<String>())
            .setAutoEnroll(true)
            .setEncryptionSpec(EncryptionSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAgentAnomalyDetectionScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    String parent = "parent-995424086";
    AgentAnomalyDetectionScope agentAnomalyDetectionScope =
        AgentAnomalyDetectionScope.newBuilder().build();
    String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";

    AgentAnomalyDetectionScope actualResponse =
        client
            .createAgentAnomalyDetectionScopeAsync(
                parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentAnomalyDetectionScopeRequest actualRequest =
        ((CreateAgentAnomalyDetectionScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(agentAnomalyDetectionScope, actualRequest.getAgentAnomalyDetectionScope());
    Assert.assertEquals(
        agentAnomalyDetectionScopeId, actualRequest.getAgentAnomalyDetectionScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentAnomalyDetectionScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      AgentAnomalyDetectionScope agentAnomalyDetectionScope =
          AgentAnomalyDetectionScope.newBuilder().build();
      String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";
      client
          .createAgentAnomalyDetectionScopeAsync(
              parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAgentAnomalyDetectionScopesTest() throws Exception {
    AgentAnomalyDetectionScope responsesElement = AgentAnomalyDetectionScope.newBuilder().build();
    ListAgentAnomalyDetectionScopesResponse expectedResponse =
        ListAgentAnomalyDetectionScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentAnomalyDetectionScopes(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAgentAnomalyDetectionScopesPagedResponse pagedListResponse =
        client.listAgentAnomalyDetectionScopes(parent);

    List<AgentAnomalyDetectionScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAgentAnomalyDetectionScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentAnomalyDetectionScopesRequest actualRequest =
        ((ListAgentAnomalyDetectionScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentAnomalyDetectionScopesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAgentAnomalyDetectionScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAgentAnomalyDetectionScopesTest2() throws Exception {
    AgentAnomalyDetectionScope responsesElement = AgentAnomalyDetectionScope.newBuilder().build();
    ListAgentAnomalyDetectionScopesResponse expectedResponse =
        ListAgentAnomalyDetectionScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentAnomalyDetectionScopes(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAgentAnomalyDetectionScopesPagedResponse pagedListResponse =
        client.listAgentAnomalyDetectionScopes(parent);

    List<AgentAnomalyDetectionScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAgentAnomalyDetectionScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentAnomalyDetectionScopesRequest actualRequest =
        ((ListAgentAnomalyDetectionScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentAnomalyDetectionScopesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAgentAnomalyDetectionScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyzedSessionsTest() throws Exception {
    AnalyzedSession responsesElement = AnalyzedSession.newBuilder().build();
    ListAnalyzedSessionsResponse expectedResponse =
        ListAnalyzedSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyzedSessions(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    MonitoredAgentName parent =
        MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    ListAnalyzedSessionsPagedResponse pagedListResponse = client.listAnalyzedSessions(parent);

    List<AnalyzedSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyzedSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyzedSessionsRequest actualRequest =
        ((ListAnalyzedSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyzedSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName parent =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.listAnalyzedSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyzedSessionsTest2() throws Exception {
    AnalyzedSession responsesElement = AnalyzedSession.newBuilder().build();
    ListAnalyzedSessionsResponse expectedResponse =
        ListAnalyzedSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyzedSessions(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalyzedSessionsPagedResponse pagedListResponse = client.listAnalyzedSessions(parent);

    List<AnalyzedSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyzedSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyzedSessionsRequest actualRequest =
        ((ListAnalyzedSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyzedSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAnalyzedSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalyzedSessionTest() throws Exception {
    AnalyzedSession expectedResponse =
        AnalyzedSession.newBuilder()
            .setName(
                AnalyzedSessionName.of(
                        "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
                    .toString())
            .setSessionId("sessionId607796817")
            .setUserId("userId-836030906")
            .setAgentResourceName(
                AnalyzedSessionName.of(
                        "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestAnalyzedTime(Timestamp.newBuilder().build())
            .setAssessment(Assessment.newBuilder().build())
            .putAllSeverities(new HashMap<String, AnalyzedSession.SeveritySummary>())
            .setAgentDisplayName("agentDisplayName2121176616")
            .setLocation("location1901043637")
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    AnalyzedSessionName name =
        AnalyzedSessionName.of(
            "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");

    AnalyzedSession actualResponse = client.getAnalyzedSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalyzedSessionRequest actualRequest = ((GetAnalyzedSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalyzedSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      AnalyzedSessionName name =
          AnalyzedSessionName.of(
              "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");
      client.getAnalyzedSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalyzedSessionTest2() throws Exception {
    AnalyzedSession expectedResponse =
        AnalyzedSession.newBuilder()
            .setName(
                AnalyzedSessionName.of(
                        "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
                    .toString())
            .setSessionId("sessionId607796817")
            .setUserId("userId-836030906")
            .setAgentResourceName(
                AnalyzedSessionName.of(
                        "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLatestAnalyzedTime(Timestamp.newBuilder().build())
            .setAssessment(Assessment.newBuilder().build())
            .putAllSeverities(new HashMap<String, AnalyzedSession.SeveritySummary>())
            .setAgentDisplayName("agentDisplayName2121176616")
            .setLocation("location1901043637")
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String name = "name3373707";

    AnalyzedSession actualResponse = client.getAnalyzedSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalyzedSessionRequest actualRequest = ((GetAnalyzedSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalyzedSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.getAnalyzedSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyzedInvocationsTest() throws Exception {
    AnalyzedInvocation responsesElement = AnalyzedInvocation.newBuilder().build();
    ListAnalyzedInvocationsResponse expectedResponse =
        ListAnalyzedInvocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyzedInvocations(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    AnalyzedSessionName parent =
        AnalyzedSessionName.of(
            "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");

    ListAnalyzedInvocationsPagedResponse pagedListResponse = client.listAnalyzedInvocations(parent);

    List<AnalyzedInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyzedInvocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyzedInvocationsRequest actualRequest =
        ((ListAnalyzedInvocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyzedInvocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      AnalyzedSessionName parent =
          AnalyzedSessionName.of(
              "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");
      client.listAnalyzedInvocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyzedInvocationsTest2() throws Exception {
    AnalyzedInvocation responsesElement = AnalyzedInvocation.newBuilder().build();
    ListAnalyzedInvocationsResponse expectedResponse =
        ListAnalyzedInvocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyzedInvocations(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalyzedInvocationsPagedResponse pagedListResponse = client.listAnalyzedInvocations(parent);

    List<AnalyzedInvocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyzedInvocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyzedInvocationsRequest actualRequest =
        ((ListAnalyzedInvocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyzedInvocationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAnalyzedInvocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalyzedInvocationTest() throws Exception {
    AnalyzedInvocation expectedResponse =
        AnalyzedInvocation.newBuilder()
            .setName(
                AnalyzedInvocationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MONITORED_AGENT]",
                        "[ANALYZED_SESSION]",
                        "[ANALYZED_INVOCATION]")
                    .toString())
            .setInvocationId("invocationId149331403")
            .setAssessment(Assessment.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    AnalyzedInvocationName name =
        AnalyzedInvocationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[MONITORED_AGENT]",
            "[ANALYZED_SESSION]",
            "[ANALYZED_INVOCATION]");

    AnalyzedInvocation actualResponse = client.getAnalyzedInvocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalyzedInvocationRequest actualRequest =
        ((GetAnalyzedInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalyzedInvocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      AnalyzedInvocationName name =
          AnalyzedInvocationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[MONITORED_AGENT]",
              "[ANALYZED_SESSION]",
              "[ANALYZED_INVOCATION]");
      client.getAnalyzedInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalyzedInvocationTest2() throws Exception {
    AnalyzedInvocation expectedResponse =
        AnalyzedInvocation.newBuilder()
            .setName(
                AnalyzedInvocationName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[MONITORED_AGENT]",
                        "[ANALYZED_SESSION]",
                        "[ANALYZED_INVOCATION]")
                    .toString())
            .setInvocationId("invocationId149331403")
            .setAssessment(Assessment.newBuilder().build())
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String name = "name3373707";

    AnalyzedInvocation actualResponse = client.getAnalyzedInvocation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalyzedInvocationRequest actualRequest =
        ((GetAnalyzedInvocationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalyzedInvocationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.getAnalyzedInvocation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateAnalyzedSessionsTest() throws Exception {
    AggregateAnalyzedSessionsResponse.AgentAggregate responsesElement =
        AggregateAnalyzedSessionsResponse.AgentAggregate.newBuilder().build();
    AggregateAnalyzedSessionsResponse expectedResponse =
        AggregateAnalyzedSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentAggregates(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    MonitoredAgentName parent =
        MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    AggregateAnalyzedSessionsPagedResponse pagedListResponse =
        client.aggregateAnalyzedSessions(parent);

    List<AggregateAnalyzedSessionsResponse.AgentAggregate> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentAggregatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateAnalyzedSessionsRequest actualRequest =
        ((AggregateAnalyzedSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateAnalyzedSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName parent =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.aggregateAnalyzedSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateAnalyzedSessionsTest2() throws Exception {
    AggregateAnalyzedSessionsResponse.AgentAggregate responsesElement =
        AggregateAnalyzedSessionsResponse.AgentAggregate.newBuilder().build();
    AggregateAnalyzedSessionsResponse expectedResponse =
        AggregateAnalyzedSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgentAggregates(Arrays.asList(responsesElement))
            .build();
    mockAgentAnomalyDetectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    AggregateAnalyzedSessionsPagedResponse pagedListResponse =
        client.aggregateAnalyzedSessions(parent);

    List<AggregateAnalyzedSessionsResponse.AgentAggregate> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentAggregatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateAnalyzedSessionsRequest actualRequest =
        ((AggregateAnalyzedSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateAnalyzedSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.aggregateAnalyzedSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void clearTrainingDataTest() throws Exception {
    ClearTrainingDataResponse expectedResponse = ClearTrainingDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("clearTrainingDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    MonitoredAgentName name = MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");

    ClearTrainingDataResponse actualResponse = client.clearTrainingDataAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClearTrainingDataRequest actualRequest = ((ClearTrainingDataRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void clearTrainingDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      MonitoredAgentName name =
          MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
      client.clearTrainingDataAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void clearTrainingDataTest2() throws Exception {
    ClearTrainingDataResponse expectedResponse = ClearTrainingDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("clearTrainingDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentAnomalyDetectionService.addResponse(resultOperation);

    String name = "name3373707";

    ClearTrainingDataResponse actualResponse = client.clearTrainingDataAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentAnomalyDetectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClearTrainingDataRequest actualRequest = ((ClearTrainingDataRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void clearTrainingDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentAnomalyDetectionService.addException(exception);

    try {
      String name = "name3373707";
      client.clearTrainingDataAsync(name).get();
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
