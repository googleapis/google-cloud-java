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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.EngineServiceClient.ListEnginesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
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
public class EngineServiceClientTest {
  private static MockEngineService mockEngineService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EngineServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEngineService = new MockEngineService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEngineService, mockLocations));
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
    EngineServiceSettings settings =
        EngineServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EngineServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .setKnowledgeGraphConfig(Engine.KnowledgeGraphConfig.newBuilder().build())
            .setDisableAnalytics(true)
            .setSessionConfig(SessionConfig.newBuilder().build())
            .putAllFeatures(new HashMap<String, Engine.FeatureState>())
            .setCmekConfig(CmekConfig.newBuilder().build())
            .putAllModelConfigs(new HashMap<String, Engine.ModelState>())
            .setObservabilityConfig(ObservabilityConfig.newBuilder().build())
            .putAllConnectorTenantInfo(new HashMap<String, String>())
            .setAgentGatewaySetting(AgentGatewaySetting.newBuilder().build())
            .addAllProcurementContactEmails(new ArrayList<String>())
            .setAssociatedAgentRegistry("associatedAgentRegistry-1486670084")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEngineService.addResponse(resultOperation);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    Engine engine = Engine.newBuilder().build();
    String engineId = "engineId1820490493";

    Engine actualResponse = client.createEngineAsync(parent, engine, engineId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEngineRequest actualRequest = ((CreateEngineRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(engine, actualRequest.getEngine());
    Assert.assertEquals(engineId, actualRequest.getEngineId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEngineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      Engine engine = Engine.newBuilder().build();
      String engineId = "engineId1820490493";
      client.createEngineAsync(parent, engine, engineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .setKnowledgeGraphConfig(Engine.KnowledgeGraphConfig.newBuilder().build())
            .setDisableAnalytics(true)
            .setSessionConfig(SessionConfig.newBuilder().build())
            .putAllFeatures(new HashMap<String, Engine.FeatureState>())
            .setCmekConfig(CmekConfig.newBuilder().build())
            .putAllModelConfigs(new HashMap<String, Engine.ModelState>())
            .setObservabilityConfig(ObservabilityConfig.newBuilder().build())
            .putAllConnectorTenantInfo(new HashMap<String, String>())
            .setAgentGatewaySetting(AgentGatewaySetting.newBuilder().build())
            .addAllProcurementContactEmails(new ArrayList<String>())
            .setAssociatedAgentRegistry("associatedAgentRegistry-1486670084")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEngineService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Engine engine = Engine.newBuilder().build();
    String engineId = "engineId1820490493";

    Engine actualResponse = client.createEngineAsync(parent, engine, engineId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEngineRequest actualRequest = ((CreateEngineRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(engine, actualRequest.getEngine());
    Assert.assertEquals(engineId, actualRequest.getEngineId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEngineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String parent = "parent-995424086";
      Engine engine = Engine.newBuilder().build();
      String engineId = "engineId1820490493";
      client.createEngineAsync(parent, engine, engineId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEngineTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEngineService.addResponse(resultOperation);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    client.deleteEngineAsync(name).get();

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEngineRequest actualRequest = ((DeleteEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEngineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.deleteEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEngineTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEngineTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEngineService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEngineAsync(name).get();

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEngineRequest actualRequest = ((DeleteEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEngineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEngineAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .setKnowledgeGraphConfig(Engine.KnowledgeGraphConfig.newBuilder().build())
            .setDisableAnalytics(true)
            .setSessionConfig(SessionConfig.newBuilder().build())
            .putAllFeatures(new HashMap<String, Engine.FeatureState>())
            .setCmekConfig(CmekConfig.newBuilder().build())
            .putAllModelConfigs(new HashMap<String, Engine.ModelState>())
            .setObservabilityConfig(ObservabilityConfig.newBuilder().build())
            .putAllConnectorTenantInfo(new HashMap<String, String>())
            .setAgentGatewaySetting(AgentGatewaySetting.newBuilder().build())
            .addAllProcurementContactEmails(new ArrayList<String>())
            .setAssociatedAgentRegistry("associatedAgentRegistry-1486670084")
            .build();
    mockEngineService.addResponse(expectedResponse);

    Engine engine = Engine.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Engine actualResponse = client.updateEngine(engine, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEngineRequest actualRequest = ((UpdateEngineRequest) actualRequests.get(0));

    Assert.assertEquals(engine, actualRequest.getEngine());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEngineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      Engine engine = Engine.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEngine(engine, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineTest() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .setKnowledgeGraphConfig(Engine.KnowledgeGraphConfig.newBuilder().build())
            .setDisableAnalytics(true)
            .setSessionConfig(SessionConfig.newBuilder().build())
            .putAllFeatures(new HashMap<String, Engine.FeatureState>())
            .setCmekConfig(CmekConfig.newBuilder().build())
            .putAllModelConfigs(new HashMap<String, Engine.ModelState>())
            .setObservabilityConfig(ObservabilityConfig.newBuilder().build())
            .putAllConnectorTenantInfo(new HashMap<String, String>())
            .setAgentGatewaySetting(AgentGatewaySetting.newBuilder().build())
            .addAllProcurementContactEmails(new ArrayList<String>())
            .setAssociatedAgentRegistry("associatedAgentRegistry-1486670084")
            .build();
    mockEngineService.addResponse(expectedResponse);

    EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    Engine actualResponse = client.getEngine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineRequest actualRequest = ((GetEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.getEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEngineTest2() throws Exception {
    Engine expectedResponse =
        Engine.newBuilder()
            .setName(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDataStoreIds(new ArrayList<String>())
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setCommonConfig(Engine.CommonConfig.newBuilder().build())
            .setKnowledgeGraphConfig(Engine.KnowledgeGraphConfig.newBuilder().build())
            .setDisableAnalytics(true)
            .setSessionConfig(SessionConfig.newBuilder().build())
            .putAllFeatures(new HashMap<String, Engine.FeatureState>())
            .setCmekConfig(CmekConfig.newBuilder().build())
            .putAllModelConfigs(new HashMap<String, Engine.ModelState>())
            .setObservabilityConfig(ObservabilityConfig.newBuilder().build())
            .putAllConnectorTenantInfo(new HashMap<String, String>())
            .setAgentGatewaySetting(AgentGatewaySetting.newBuilder().build())
            .addAllProcurementContactEmails(new ArrayList<String>())
            .setAssociatedAgentRegistry("associatedAgentRegistry-1486670084")
            .build();
    mockEngineService.addResponse(expectedResponse);

    String name = "name3373707";

    Engine actualResponse = client.getEngine(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEngineRequest actualRequest = ((GetEngineRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEngineExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String name = "name3373707";
      client.getEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnginesTest() throws Exception {
    Engine responsesElement = Engine.newBuilder().build();
    ListEnginesResponse expectedResponse =
        ListEnginesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngines(Arrays.asList(responsesElement))
            .build();
    mockEngineService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    ListEnginesPagedResponse pagedListResponse = client.listEngines(parent);

    List<Engine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnginesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnginesRequest actualRequest = ((ListEnginesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnginesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      client.listEngines(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnginesTest2() throws Exception {
    Engine responsesElement = Engine.newBuilder().build();
    ListEnginesResponse expectedResponse =
        ListEnginesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEngines(Arrays.asList(responsesElement))
            .build();
    mockEngineService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnginesPagedResponse pagedListResponse = client.listEngines(parent);

    List<Engine> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnginesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnginesRequest actualRequest = ((ListEnginesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnginesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEngines(parent);
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
    mockEngineService.addResponse(expectedResponse);

    ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockEngineService.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
    mockEngineService.addResponse(expectedResponse);

    ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockEngineService.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEngineService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEngineService.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
