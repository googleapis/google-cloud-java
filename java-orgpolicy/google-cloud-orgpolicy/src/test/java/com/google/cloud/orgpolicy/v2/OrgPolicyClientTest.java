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

package com.google.cloud.orgpolicy.v2;

import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListPoliciesPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class OrgPolicyClientTest {
  private static MockOrgPolicy mockOrgPolicy;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OrgPolicyClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOrgPolicy = new MockOrgPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOrgPolicy));
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
    OrgPolicySettings settings =
        OrgPolicySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrgPolicyClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConstraintsTest() throws Exception {
    Constraint responsesElement = Constraint.newBuilder().build();
    ListConstraintsResponse expectedResponse =
        ListConstraintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConstraints(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListConstraintsPagedResponse pagedListResponse = client.listConstraints(parent);

    List<Constraint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConstraintsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConstraintsRequest actualRequest = ((ListConstraintsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConstraintsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listConstraints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConstraintsTest2() throws Exception {
    Constraint responsesElement = Constraint.newBuilder().build();
    ListConstraintsResponse expectedResponse =
        ListConstraintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConstraints(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListConstraintsPagedResponse pagedListResponse = client.listConstraints(parent);

    List<Constraint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConstraintsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConstraintsRequest actualRequest = ((ListConstraintsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConstraintsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listConstraints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConstraintsTest3() throws Exception {
    Constraint responsesElement = Constraint.newBuilder().build();
    ListConstraintsResponse expectedResponse =
        ListConstraintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConstraints(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListConstraintsPagedResponse pagedListResponse = client.listConstraints(parent);

    List<Constraint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConstraintsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConstraintsRequest actualRequest = ((ListConstraintsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConstraintsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listConstraints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConstraintsTest4() throws Exception {
    Constraint responsesElement = Constraint.newBuilder().build();
    ListConstraintsResponse expectedResponse =
        ListConstraintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConstraints(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConstraintsPagedResponse pagedListResponse = client.listConstraints(parent);

    List<Constraint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConstraintsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConstraintsRequest actualRequest = ((ListConstraintsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConstraintsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConstraints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPoliciesRequest actualRequest = ((ListPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest2() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPoliciesRequest actualRequest = ((ListPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest3() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPoliciesRequest actualRequest = ((ListPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPoliciesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest4() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPoliciesRequest actualRequest = ((ListPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPoliciesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

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
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");

    Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyRequest actualRequest = ((GetPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    String name = "name3373707";

    Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPolicyRequest actualRequest = ((GetPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectivePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");

    Policy actualResponse = client.getEffectivePolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectivePolicyRequest actualRequest = ((GetEffectivePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectivePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
      client.getEffectivePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEffectivePolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    String name = "name3373707";

    Policy actualResponse = client.getEffectivePolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEffectivePolicyRequest actualRequest = ((GetEffectivePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEffectivePolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      String name = "name3373707";
      client.getEffectivePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.createPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyRequest actualRequest = ((CreatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      Policy policy = Policy.newBuilder().build();
      client.createPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.createPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyRequest actualRequest = ((CreatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Policy policy = Policy.newBuilder().build();
      client.createPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest3() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.createPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyRequest actualRequest = ((CreatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Policy policy = Policy.newBuilder().build();
      client.createPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest4() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.createPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePolicyRequest actualRequest = ((CreatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPolicyExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      String parent = "parent-995424086";
      Policy policy = Policy.newBuilder().build();
      client.createPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
            .setSpec(PolicySpec.newBuilder().build())
            .setAlternate(AlternatePolicySpec.newBuilder().build())
            .build();
    mockOrgPolicy.addResponse(expectedResponse);

    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.updatePolicy(policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePolicyRequest actualRequest = ((UpdatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      Policy policy = Policy.newBuilder().build();
      client.updatePolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOrgPolicy.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");

    client.deletePolicy(name);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyRequest actualRequest = ((DeletePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
      client.deletePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOrgPolicy.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePolicy(name);

    List<AbstractMessage> actualRequests = mockOrgPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePolicyRequest actualRequest = ((DeletePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicy.addException(exception);

    try {
      String name = "name3373707";
      client.deletePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
