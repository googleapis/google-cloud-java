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

package com.google.cloud.gkehub.v1beta1;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

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
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GkeHubMembershipServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGkeHubMembershipService = new MockGkeHubMembershipService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockGkeHubMembershipService, mockLocations, mockIAMPolicy));
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembershipsRequest actualRequest = ((ListMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipsTest2() throws Exception {
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
  public void listMembershipsExceptionTest2() throws Exception {
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
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    Membership actualResponse = client.getMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMembershipRequest actualRequest = ((GetMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.getMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
  public void getMembershipExceptionTest2() throws Exception {
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
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Membership resource = Membership.newBuilder().build();
    String membershipId = "membershipId517665681";

    Membership actualResponse = client.createMembershipAsync(parent, resource, membershipId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMembershipRequest actualRequest = ((CreateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
  public void createMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
  public void createMembershipExceptionTest2() throws Exception {
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

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    client.deleteMembershipAsync(name).get();

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMembershipRequest actualRequest = ((DeleteMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.deleteMembershipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMembershipTest2() throws Exception {
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
  public void deleteMembershipExceptionTest2() throws Exception {
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
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
    Membership resource = Membership.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Membership actualResponse = client.updateMembershipAsync(name, resource, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGkeHubMembershipService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMembershipRequest actualRequest = ((UpdateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
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
  public void updateMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
  public void updateMembershipExceptionTest2() throws Exception {
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
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
              .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
              .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
              .setCrdManifest("crdManifest1401188132")
              .setCrManifest("crManifest-1971077186")
              .build();
      client.generateExclusivityManifest(request);
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
            .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
              .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
            .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
              .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
            .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
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
              .setResource(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
