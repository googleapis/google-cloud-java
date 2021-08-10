/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.gkehub.v1beta1;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class GkeHubMembershipServiceClientTest {
  private static MockGkeHubMembershipService mockGkeHubMembershipService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GkeHubMembershipServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGkeHubMembershipService = new MockGkeHubMembershipService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGkeHubMembershipService));
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
    GkeHubMembershipServiceSettings settings =
        GkeHubMembershipServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GkeHubMembershipServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMembershipsTest() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListMembershipsResponse expectedResponse =
        ListMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockGkeHubMembershipService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembershipsRequest actualRequest = ((ListMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMembershipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName("name3373707")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(MembershipState.newBuilder().build())
            .setAuthority(Authority.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .build();
    mockGkeHubMembershipService.addResponse(expectedResponse);

    String name = "name3373707";

    Membership actualResponse = client.getMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMembershipRequest actualRequest = ((GetMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      String name = "name3373707";
      client.getMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName("name3373707")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(MembershipState.newBuilder().build())
            .setAuthority(Authority.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGkeHubMembershipService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Membership resource = Membership.newBuilder().build();
    String membershipId = "membershipId517665681";

    Membership actualResponse = client.createMembershipAsync(parent, resource, membershipId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMembershipRequest actualRequest = ((CreateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(membershipId, actualRequest.getMembershipId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      String parent = "parent-995424086";
      Membership resource = Membership.newBuilder().build();
      String membershipId = "membershipId517665681";
      client.createMembershipAsync(parent, resource, membershipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMembershipTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGkeHubMembershipService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMembershipAsync(name).get();

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMembershipRequest actualRequest = ((DeleteMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMembershipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName("name3373707")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(MembershipState.newBuilder().build())
            .setAuthority(Authority.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGkeHubMembershipService.addResponse(resultOperation);

    String name = "name3373707";
    Membership resource = Membership.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Membership actualResponse = client.updateMembershipAsync(name, resource, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMembershipRequest actualRequest = ((UpdateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      String name = "name3373707";
      Membership resource = Membership.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembershipAsync(name, resource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateConnectManifestTest() throws Exception {
    GenerateConnectManifestResponse expectedResponse =
        GenerateConnectManifestResponse.newBuilder()
            .addAllManifest(new ArrayList<ConnectAgentResource>())
            .build();
    mockGkeHubMembershipService.addResponse(expectedResponse);

    GenerateConnectManifestRequest request =
        GenerateConnectManifestRequest.newBuilder()
            .setName("name3373707")
            .setConnectAgent(ConnectAgent.newBuilder().build())
            .setVersion("version351608024")
            .setIsUpgrade(true)
            .setRegistry("registry-690212803")
            .setImagePullSecretContent(ByteString.EMPTY)
            .build();

    GenerateConnectManifestResponse actualResponse = client.generateConnectManifest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateConnectManifestRequest actualRequest =
        ((GenerateConnectManifestRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getConnectAgent(), actualRequest.getConnectAgent());
    Assert.assertEquals(request.getVersion(), actualRequest.getVersion());
    Assert.assertEquals(request.getIsUpgrade(), actualRequest.getIsUpgrade());
    Assert.assertEquals(request.getRegistry(), actualRequest.getRegistry());
    Assert.assertEquals(
        request.getImagePullSecretContent(), actualRequest.getImagePullSecretContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateConnectManifestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      GenerateConnectManifestRequest request =
          GenerateConnectManifestRequest.newBuilder()
              .setName("name3373707")
              .setConnectAgent(ConnectAgent.newBuilder().build())
              .setVersion("version351608024")
              .setIsUpgrade(true)
              .setRegistry("registry-690212803")
              .setImagePullSecretContent(ByteString.EMPTY)
              .build();
      client.generateConnectManifest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void validateExclusivityTest() throws Exception {
    ValidateExclusivityResponse expectedResponse =
        ValidateExclusivityResponse.newBuilder().setStatus(Status.newBuilder().build()).build();
    mockGkeHubMembershipService.addResponse(expectedResponse);

    ValidateExclusivityRequest request =
        ValidateExclusivityRequest.newBuilder()
            .setParent("parent-995424086")
            .setCrManifest("crManifest-1971077186")
            .setIntendedMembership("intendedMembership-2074920351")
            .build();

    ValidateExclusivityResponse actualResponse = client.validateExclusivity(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateExclusivityRequest actualRequest = ((ValidateExclusivityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCrManifest(), actualRequest.getCrManifest());
    Assert.assertEquals(request.getIntendedMembership(), actualRequest.getIntendedMembership());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateExclusivityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      ValidateExclusivityRequest request =
          ValidateExclusivityRequest.newBuilder()
              .setParent("parent-995424086")
              .setCrManifest("crManifest-1971077186")
              .setIntendedMembership("intendedMembership-2074920351")
              .build();
      client.validateExclusivity(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateExclusivityManifestTest() throws Exception {
    GenerateExclusivityManifestResponse expectedResponse =
        GenerateExclusivityManifestResponse.newBuilder()
            .setCrdManifest("crdManifest1401188132")
            .setCrManifest("crManifest-1971077186")
            .build();
    mockGkeHubMembershipService.addResponse(expectedResponse);

    GenerateExclusivityManifestRequest request =
        GenerateExclusivityManifestRequest.newBuilder()
            .setName("name3373707")
            .setCrdManifest("crdManifest1401188132")
            .setCrManifest("crManifest-1971077186")
            .build();

    GenerateExclusivityManifestResponse actualResponse =
        client.generateExclusivityManifest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateExclusivityManifestRequest actualRequest =
        ((GenerateExclusivityManifestRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCrdManifest(), actualRequest.getCrdManifest());
    Assert.assertEquals(request.getCrManifest(), actualRequest.getCrManifest());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateExclusivityManifestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGkeHubMembershipService.addException(exception);

    try {
      GenerateExclusivityManifestRequest request =
          GenerateExclusivityManifestRequest.newBuilder()
              .setName("name3373707")
              .setCrdManifest("crdManifest1401188132")
              .setCrManifest("crManifest-1971077186")
              .build();
      client.generateExclusivityManifest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
