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

package com.google.iam.v2;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

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
public class PoliciesClientTest {
  private static MockPolicies mockPolicies;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PoliciesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPolicies = new MockPolicies();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPolicies));
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
    PoliciesSettings settings =
        PoliciesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PoliciesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listPoliciesTest() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockPolicies.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPoliciesRequest actualRequest = ((ListPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    mockPolicies.addResponse(expectedResponse);

    String name = "name3373707";

    Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyRequest actualRequest = ((GetPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicies.addResponse(resultOperation);

    String parent = "parent-995424086";
    Policy policy = Policy.newBuilder().build();
    String policyId = "policyId546908653";

    Policy actualResponse = client.createPolicyAsync(parent, policy, policyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyRequest actualRequest = ((CreatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertEquals(policyId, actualRequest.getPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicies.addException(exception);

    try {
      String parent = "parent-995424086";
      Policy policy = Policy.newBuilder().build();
      String policyId = "policyId546908653";
      client.createPolicyAsync(parent, policy, policyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicies.addResponse(resultOperation);

    UpdatePolicyRequest request =
        UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();

    Policy actualResponse = client.updatePolicyAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyRequest actualRequest = ((UpdatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicies.addException(exception);

    try {
      UpdatePolicyRequest request =
          UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
      client.updatePolicyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPolicies.addResponse(resultOperation);

    String name = "name3373707";

    Policy actualResponse = client.deletePolicyAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPolicies.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyRequest actualRequest = ((DeletePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPolicies.addException(exception);

    try {
      String name = "name3373707";
      client.deletePolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
