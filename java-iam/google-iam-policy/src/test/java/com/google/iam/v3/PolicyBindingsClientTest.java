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

package com.google.iam.v3;

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Expr;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class PolicyBindingsClientTest {
  private static MockLocations mockLocations;
  private static MockPolicyBindings mockPolicyBindings;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PolicyBindingsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPolicyBindings = new MockPolicyBindings();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPolicyBindings, mockLocations));
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
    PolicyBindingsSettings settings =
        PolicyBindingsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyBindingsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPolicyBindingTest() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofOrganizationLocationPolicyBindingName(
                        "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
    String policyBindingId = "policyBindingId1375821166";

    PolicyBinding actualResponse =
        client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBindingRequest actualRequest = ((CreatePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policyBinding, actualRequest.getPolicyBinding());
    Assert.assertEquals(policyBindingId, actualRequest.getPolicyBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
      String policyBindingId = "policyBindingId1375821166";
      client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPolicyBindingTest2() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofOrganizationLocationPolicyBindingName(
                        "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
    String policyBindingId = "policyBindingId1375821166";

    PolicyBinding actualResponse =
        client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBindingRequest actualRequest = ((CreatePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policyBinding, actualRequest.getPolicyBinding());
    Assert.assertEquals(policyBindingId, actualRequest.getPolicyBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
      String policyBindingId = "policyBindingId1375821166";
      client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPolicyBindingTest3() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofOrganizationLocationPolicyBindingName(
                        "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
    String policyBindingId = "policyBindingId1375821166";

    PolicyBinding actualResponse =
        client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBindingRequest actualRequest = ((CreatePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policyBinding, actualRequest.getPolicyBinding());
    Assert.assertEquals(policyBindingId, actualRequest.getPolicyBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBindingExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
      String policyBindingId = "policyBindingId1375821166";
      client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPolicyBindingTest4() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofOrganizationLocationPolicyBindingName(
                        "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    String parent = "parent-995424086";
    PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
    String policyBindingId = "policyBindingId1375821166";

    PolicyBinding actualResponse =
        client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyBindingRequest actualRequest = ((CreatePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policyBinding, actualRequest.getPolicyBinding());
    Assert.assertEquals(policyBindingId, actualRequest.getPolicyBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyBindingExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      String parent = "parent-995424086";
      PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
      String policyBindingId = "policyBindingId1375821166";
      client.createPolicyBindingAsync(parent, policyBinding, policyBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPolicyBindingTest() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofProjectLocationPolicyBindingName(
                        "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    PolicyBindingName name =
        PolicyBindingName.ofProjectLocationPolicyBindingName(
            "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");

    PolicyBinding actualResponse = client.getPolicyBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyBindingRequest actualRequest = ((GetPolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      PolicyBindingName name =
          PolicyBindingName.ofProjectLocationPolicyBindingName(
              "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
      client.getPolicyBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyBindingTest2() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofProjectLocationPolicyBindingName(
                        "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    String name = "name3373707";

    PolicyBinding actualResponse = client.getPolicyBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyBindingRequest actualRequest = ((GetPolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicyBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyBindingTest() throws Exception {
    PolicyBinding expectedResponse =
        PolicyBinding.newBuilder()
            .setName(
                PolicyBindingName.ofProjectLocationPolicyBindingName(
                        "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setTarget(PolicyBinding.Target.newBuilder().build())
            .setPolicy("policy-982670030")
            .setPolicyUid("policyUid-225689154")
            .setCondition(Expr.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PolicyBinding actualResponse = client.updatePolicyBindingAsync(policyBinding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyBindingRequest actualRequest = ((UpdatePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(policyBinding, actualRequest.getPolicyBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePolicyBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePolicyBindingAsync(policyBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePolicyBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    PolicyBindingName name =
        PolicyBindingName.ofProjectLocationPolicyBindingName(
            "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");

    client.deletePolicyBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyBindingRequest actualRequest = ((DeletePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      PolicyBindingName name =
          PolicyBindingName.ofProjectLocationPolicyBindingName(
              "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
      client.deletePolicyBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePolicyBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicyBindings.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePolicyBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyBindingRequest actualRequest = ((DeletePolicyBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      String name = "name3373707";
      client.deletePolicyBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    ListPolicyBindingsResponse expectedResponse =
        ListPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListPolicyBindingsPagedResponse pagedListResponse = client.listPolicyBindings(parent);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBindingsRequest actualRequest = ((ListPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listPolicyBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    ListPolicyBindingsResponse expectedResponse =
        ListPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPolicyBindingsPagedResponse pagedListResponse = client.listPolicyBindings(parent);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBindingsRequest actualRequest = ((ListPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPolicyBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyBindingsTest3() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    ListPolicyBindingsResponse expectedResponse =
        ListPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPolicyBindingsPagedResponse pagedListResponse = client.listPolicyBindings(parent);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBindingsRequest actualRequest = ((ListPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBindingsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPolicyBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyBindingsTest4() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    ListPolicyBindingsResponse expectedResponse =
        ListPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPolicyBindingsPagedResponse pagedListResponse = client.listPolicyBindings(parent);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPolicyBindingsRequest actualRequest = ((ListPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPolicyBindingsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPolicyBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTargetPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchTargetPolicyBindingsResponse expectedResponse =
        SearchTargetPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    String target = "target-880905839";

    SearchTargetPolicyBindingsPagedResponse pagedListResponse =
        client.searchTargetPolicyBindings(parent, target);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTargetPolicyBindingsRequest actualRequest =
        ((SearchTargetPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(target, actualRequest.getTarget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTargetPolicyBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      String target = "target-880905839";
      client.searchTargetPolicyBindings(parent, target);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTargetPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchTargetPolicyBindingsResponse expectedResponse =
        SearchTargetPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String target = "target-880905839";

    SearchTargetPolicyBindingsPagedResponse pagedListResponse =
        client.searchTargetPolicyBindings(parent, target);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTargetPolicyBindingsRequest actualRequest =
        ((SearchTargetPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(target, actualRequest.getTarget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTargetPolicyBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String target = "target-880905839";
      client.searchTargetPolicyBindings(parent, target);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTargetPolicyBindingsTest3() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchTargetPolicyBindingsResponse expectedResponse =
        SearchTargetPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    String target = "target-880905839";

    SearchTargetPolicyBindingsPagedResponse pagedListResponse =
        client.searchTargetPolicyBindings(parent, target);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTargetPolicyBindingsRequest actualRequest =
        ((SearchTargetPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(target, actualRequest.getTarget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTargetPolicyBindingsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      String target = "target-880905839";
      client.searchTargetPolicyBindings(parent, target);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchTargetPolicyBindingsTest4() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchTargetPolicyBindingsResponse expectedResponse =
        SearchTargetPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockPolicyBindings.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String target = "target-880905839";

    SearchTargetPolicyBindingsPagedResponse pagedListResponse =
        client.searchTargetPolicyBindings(parent, target);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicyBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchTargetPolicyBindingsRequest actualRequest =
        ((SearchTargetPolicyBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(target, actualRequest.getTarget());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchTargetPolicyBindingsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicyBindings.addException(exception);

    try {
      String parent = "parent-995424086";
      String target = "target-880905839";
      client.searchTargetPolicyBindings(parent, target);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
