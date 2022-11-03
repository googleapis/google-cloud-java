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

package com.google.protos.google.cloud.binaryauthorization.v1;

import static com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client.ListAttestorsPagedResponse;

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
public class BinauthzManagementServiceV1ClientTest {
  private static MockBinauthzManagementServiceV1 mockBinauthzManagementServiceV1;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BinauthzManagementServiceV1Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockBinauthzManagementServiceV1 = new MockBinauthzManagementServiceV1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBinauthzManagementServiceV1));
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
    BinauthzManagementServiceV1Settings settings =
        BinauthzManagementServiceV1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BinauthzManagementServiceV1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getPolicyTest() throws Exception {
    Resources.Policy expectedResponse =
        Resources.Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<Resources.AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .setDefaultAdmissionRule(Resources.AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofProjectName("[PROJECT]");

    Resources.Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.GetPolicyRequest actualRequest = ((Service.GetPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    Resources.Policy expectedResponse =
        Resources.Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<Resources.AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .setDefaultAdmissionRule(Resources.AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    String name = "name3373707";

    Resources.Policy actualResponse = client.getPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.GetPolicyRequest actualRequest = ((Service.GetPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    Resources.Policy expectedResponse =
        Resources.Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<Resources.AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, Resources.AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(
                new HashMap<String, Resources.AdmissionRule>())
            .setDefaultAdmissionRule(Resources.AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    Resources.Policy policy = Resources.Policy.newBuilder().build();

    Resources.Policy actualResponse = client.updatePolicy(policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.UpdatePolicyRequest actualRequest =
        ((Service.UpdatePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

    try {
      Resources.Policy policy = Resources.Policy.newBuilder().build();
      client.updatePolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest() throws Exception {
    Resources.Attestor expectedResponse =
        Resources.Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String attestorId = "attestorId2055733027";
    Resources.Attestor attestor = Resources.Attestor.newBuilder().build();

    Resources.Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.CreateAttestorRequest actualRequest =
        ((Service.CreateAttestorRequest) actualRequests.get(0));

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
    mockBinauthzManagementServiceV1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String attestorId = "attestorId2055733027";
      Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest2() throws Exception {
    Resources.Attestor expectedResponse =
        Resources.Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String attestorId = "attestorId2055733027";
    Resources.Attestor attestor = Resources.Attestor.newBuilder().build();

    Resources.Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.CreateAttestorRequest actualRequest =
        ((Service.CreateAttestorRequest) actualRequests.get(0));

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
    mockBinauthzManagementServiceV1.addException(exception);

    try {
      String parent = "parent-995424086";
      String attestorId = "attestorId2055733027";
      Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttestorTest() throws Exception {
    Resources.Attestor expectedResponse =
        Resources.Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    Resources.Attestor actualResponse = client.getAttestor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.GetAttestorRequest actualRequest = ((Service.GetAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    Resources.Attestor expectedResponse =
        Resources.Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    String name = "name3373707";

    Resources.Attestor actualResponse = client.getAttestor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.GetAttestorRequest actualRequest = ((Service.GetAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttestorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    Resources.Attestor expectedResponse =
        Resources.Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    Resources.Attestor attestor = Resources.Attestor.newBuilder().build();

    Resources.Attestor actualResponse = client.updateAttestor(attestor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.UpdateAttestorRequest actualRequest =
        ((Service.UpdateAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(attestor, actualRequest.getAttestor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

    try {
      Resources.Attestor attestor = Resources.Attestor.newBuilder().build();
      client.updateAttestor(attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttestorsTest() throws Exception {
    Resources.Attestor responsesElement = Resources.Attestor.newBuilder().build();
    Service.ListAttestorsResponse expectedResponse =
        Service.ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Resources.Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.ListAttestorsRequest actualRequest =
        ((Service.ListAttestorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttestorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    Resources.Attestor responsesElement = Resources.Attestor.newBuilder().build();
    Service.ListAttestorsResponse expectedResponse =
        Service.ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Resources.Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.ListAttestorsRequest actualRequest =
        ((Service.ListAttestorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttestorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    client.deleteAttestor(name);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.DeleteAttestorRequest actualRequest =
        ((Service.DeleteAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttestorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

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
    mockBinauthzManagementServiceV1.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAttestor(name);

    List<AbstractMessage> actualRequests = mockBinauthzManagementServiceV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.DeleteAttestorRequest actualRequest =
        ((Service.DeleteAttestorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttestorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBinauthzManagementServiceV1.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
