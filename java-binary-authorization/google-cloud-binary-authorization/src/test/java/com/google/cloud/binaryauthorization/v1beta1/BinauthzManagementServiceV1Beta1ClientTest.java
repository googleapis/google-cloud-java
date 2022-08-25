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

package com.google.cloud.binaryauthorization.v1beta1;

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class BinauthzManagementServiceV1Beta1ClientTest {
  private static MockBinauthzManagementServiceV1Beta1 mockBinauthzManagementServiceV1Beta1;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BinauthzManagementServiceV1Beta1Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockBinauthzManagementServiceV1Beta1 = new MockBinauthzManagementServiceV1Beta1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBinauthzManagementServiceV1Beta1));
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
    BinauthzManagementServiceV1Beta1Settings settings =
        BinauthzManagementServiceV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BinauthzManagementServiceV1Beta1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofProjectName("[PROJECT]");

    Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
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
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      PolicyName name = PolicyName.ofProjectName("[PROJECT]");
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
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    String name = "name3373707";

    Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
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
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      String name = "name3373707";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.updatePolicy(policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
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
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      Policy policy = Policy.newBuilder().build();
      client.updatePolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String attestorId = "attestorId2055733027";
    Attestor attestor = Attestor.newBuilder().build();

    Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttestorRequest actualRequest = ((CreateAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(attestorId, actualRequest.getAttestorId());
    Assert.assertEquals(attestor, actualRequest.getAttestor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String attestorId = "attestorId2055733027";
      Attestor attestor = Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest2() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String attestorId = "attestorId2055733027";
    Attestor attestor = Attestor.newBuilder().build();

    Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttestorRequest actualRequest = ((CreateAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(attestorId, actualRequest.getAttestorId());
    Assert.assertEquals(attestor, actualRequest.getAttestor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttestorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      String parent = "parent-995424086";
      String attestorId = "attestorId2055733027";
      Attestor attestor = Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    Attestor actualResponse = client.getAttestor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttestorRequest actualRequest = ((GetAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
      client.getAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttestorTest2() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    String name = "name3373707";

    Attestor actualResponse = client.getAttestor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttestorRequest actualRequest = ((GetAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttestorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      String name = "name3373707";
      client.getAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    Attestor attestor = Attestor.newBuilder().build();

    Attestor actualResponse = client.updateAttestor(attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAttestorRequest actualRequest = ((UpdateAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(attestor, actualRequest.getAttestor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      Attestor attestor = Attestor.newBuilder().build();
      client.updateAttestor(attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttestorsTest() throws Exception {
    Attestor responsesElement = Attestor.newBuilder().build();
    ListAttestorsResponse expectedResponse =
        ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttestorsRequest actualRequest = ((ListAttestorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttestorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listAttestors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttestorsTest2() throws Exception {
    Attestor responsesElement = Attestor.newBuilder().build();
    ListAttestorsResponse expectedResponse =
        ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttestorsRequest actualRequest = ((ListAttestorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttestorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAttestors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttestorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    client.deleteAttestor(name);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttestorRequest actualRequest = ((DeleteAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
      client.deleteAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttestorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBinauthzManagementServiceV1Beta1.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAttestor(name);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttestorRequest actualRequest = ((DeleteAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttestorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1Beta1.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
