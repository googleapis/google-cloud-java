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

package com.google.cloud.agentidentity.v1beta;

import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
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
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AuthProviderServiceClientTest {
  private static MockAuthProviderService mockAuthProviderService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AuthProviderServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAuthProviderService = new MockAuthProviderService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAuthProviderService, mockLocations, mockIAMPolicy));
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
    AuthProviderServiceSettings settings =
        AuthProviderServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuthProviderServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAuthProvidersTest() throws Exception {
    AuthProvider responsesElement = AuthProvider.newBuilder().build();
    ListAuthProvidersResponse expectedResponse =
        ListAuthProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthProviders(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuthProvidersPagedResponse pagedListResponse = client.listAuthProviders(parent);

    List<AuthProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthProvidersRequest actualRequest = ((ListAuthProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthProvidersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAuthProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthProvidersTest2() throws Exception {
    AuthProvider responsesElement = AuthProvider.newBuilder().build();
    ListAuthProvidersResponse expectedResponse =
        ListAuthProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthProviders(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuthProvidersPagedResponse pagedListResponse = client.listAuthProviders(parent);

    List<AuthProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthProvidersRequest actualRequest = ((ListAuthProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthProvidersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAuthProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.getAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthProviderRequest actualRequest = ((GetAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.getAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthProviderTest2() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    AuthProvider actualResponse = client.getAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthProviderRequest actualRequest = ((GetAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AuthProvider authProvider = AuthProvider.newBuilder().build();
    String authProviderId = "authProviderId325000884";

    AuthProvider actualResponse = client.createAuthProvider(parent, authProvider, authProviderId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthProviderRequest actualRequest = ((CreateAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(authProvider, actualRequest.getAuthProvider());
    Assert.assertEquals(authProviderId, actualRequest.getAuthProviderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AuthProvider authProvider = AuthProvider.newBuilder().build();
      String authProviderId = "authProviderId325000884";
      client.createAuthProvider(parent, authProvider, authProviderId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthProviderTest2() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AuthProvider authProvider = AuthProvider.newBuilder().build();
    String authProviderId = "authProviderId325000884";

    AuthProvider actualResponse = client.createAuthProvider(parent, authProvider, authProviderId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthProviderRequest actualRequest = ((CreateAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(authProvider, actualRequest.getAuthProvider());
    Assert.assertEquals(authProviderId, actualRequest.getAuthProviderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String parent = "parent-995424086";
      AuthProvider authProvider = AuthProvider.newBuilder().build();
      String authProviderId = "authProviderId325000884";
      client.createAuthProvider(parent, authProvider, authProviderId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProvider authProvider = AuthProvider.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AuthProvider actualResponse = client.updateAuthProvider(authProvider, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAuthProviderRequest actualRequest = ((UpdateAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(authProvider, actualRequest.getAuthProvider());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProvider authProvider = AuthProvider.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAuthProvider(authProvider, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthProviderTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    client.deleteAuthProvider(name);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthProviderRequest actualRequest = ((DeleteAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.deleteAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthProviderTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAuthProvider(name);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthProviderRequest actualRequest = ((DeleteAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.undeleteAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteAuthProviderRequest actualRequest =
        ((UndeleteAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.undeleteAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteAuthProviderTest2() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    AuthProvider actualResponse = client.undeleteAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteAuthProviderRequest actualRequest =
        ((UndeleteAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.undeleteAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryAuthProvidersTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    QueryAuthProvidersResponse expectedResponse =
        QueryAuthProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthProviderNames(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String workloadId = "workloadId-186277134";

    QueryAuthProvidersPagedResponse pagedListResponse =
        client.queryAuthProviders(parent, workloadId);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProviderNamesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryAuthProvidersRequest actualRequest = ((QueryAuthProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workloadId, actualRequest.getWorkloadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryAuthProvidersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String workloadId = "workloadId-186277134";
      client.queryAuthProviders(parent, workloadId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryAuthProvidersTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    QueryAuthProvidersResponse expectedResponse =
        QueryAuthProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthProviderNames(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String workloadId = "workloadId-186277134";

    QueryAuthProvidersPagedResponse pagedListResponse =
        client.queryAuthProviders(parent, workloadId);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProviderNamesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryAuthProvidersRequest actualRequest = ((QueryAuthProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workloadId, actualRequest.getWorkloadId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryAuthProvidersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String parent = "parent-995424086";
      String workloadId = "workloadId-186277134";
      client.queryAuthProviders(parent, workloadId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryWorkloadsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    QueryWorkloadsResponse expectedResponse =
        QueryWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIds(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    QueryWorkloadsPagedResponse pagedListResponse = client.queryWorkloads(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryWorkloadsRequest actualRequest = ((QueryWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.queryWorkloads(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryWorkloadsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    QueryWorkloadsResponse expectedResponse =
        QueryWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloadIds(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    QueryWorkloadsPagedResponse pagedListResponse = client.queryWorkloads(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryWorkloadsRequest actualRequest = ((QueryWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.queryWorkloads(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthorizationsTest() throws Exception {
    Authorization responsesElement = Authorization.newBuilder().build();
    ListAuthorizationsResponse expectedResponse =
        ListAuthorizationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthorizations(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName parent = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    ListAuthorizationsPagedResponse pagedListResponse = client.listAuthorizations(parent);

    List<Authorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizationsRequest actualRequest = ((ListAuthorizationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName parent = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.listAuthorizations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthorizationsTest2() throws Exception {
    Authorization responsesElement = Authorization.newBuilder().build();
    ListAuthorizationsResponse expectedResponse =
        ListAuthorizationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthorizations(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuthorizationsPagedResponse pagedListResponse = client.listAuthorizations(parent);

    List<Authorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizationsRequest actualRequest = ((ListAuthorizationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAuthorizations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizationTest() throws Exception {
    Authorization expectedResponse =
        Authorization.newBuilder()
            .setName(
                AuthorizationName.of(
                        "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setClientUserId("clientUserId-1376663055")
            .addAllScopes(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthorizationName name =
        AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationRequest actualRequest = ((GetAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthorizationName name =
          AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");
      client.getAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizationTest2() throws Exception {
    Authorization expectedResponse =
        Authorization.newBuilder()
            .setName(
                AuthorizationName.of(
                        "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setClientUserId("clientUserId-1376663055")
            .addAllScopes(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationRequest actualRequest = ((GetAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthorizationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthorizationName name =
        AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");

    client.deleteAuthorization(name);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthorizationRequest actualRequest = ((DeleteAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthorizationName name =
          AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");
      client.deleteAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthorizationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAuthorization(name);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthorizationRequest actualRequest = ((DeleteAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessSummariesTest() throws Exception {
    AccessSummary responsesElement = AccessSummary.newBuilder().build();
    ListAccessSummariesResponse expectedResponse =
        ListAccessSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessSummaries(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccessSummariesPagedResponse pagedListResponse = client.listAccessSummaries(parent);

    List<AccessSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessSummariesRequest actualRequest = ((ListAccessSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessSummariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAccessSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessSummariesTest2() throws Exception {
    AccessSummary responsesElement = AccessSummary.newBuilder().build();
    ListAccessSummariesResponse expectedResponse =
        ListAccessSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessSummaries(Arrays.asList(responsesElement))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccessSummariesPagedResponse pagedListResponse = client.listAccessSummaries(parent);

    List<AccessSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessSummariesRequest actualRequest = ((ListAccessSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessSummariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccessSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessSummaryTest() throws Exception {
    AccessSummary expectedResponse =
        AccessSummary.newBuilder()
            .setName(AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]").toString())
            .setFirstAccessTime(Timestamp.newBuilder().build())
            .setLastAccessTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUserId("userId-836030906")
            .setWorkloadId("workloadId-186277134")
            .setTokenUrl("tokenUrl-1103813450")
            .addAllScopes(new ArrayList<String>())
            .setAuthProvider(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setAuthProviderType(AuthProviderType.forNumber(0))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AccessSummaryName name = AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]");

    AccessSummary actualResponse = client.getAccessSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessSummaryRequest actualRequest = ((GetAccessSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AccessSummaryName name = AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]");
      client.getAccessSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessSummaryTest2() throws Exception {
    AccessSummary expectedResponse =
        AccessSummary.newBuilder()
            .setName(AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]").toString())
            .setFirstAccessTime(Timestamp.newBuilder().build())
            .setLastAccessTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setUserId("userId-836030906")
            .setWorkloadId("workloadId-186277134")
            .setTokenUrl("tokenUrl-1103813450")
            .addAllScopes(new ArrayList<String>())
            .setAuthProvider(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setAuthProviderType(AuthProviderType.forNumber(0))
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    AccessSummary actualResponse = client.getAccessSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessSummaryRequest actualRequest = ((GetAccessSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessSummaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeAuthorizationTest() throws Exception {
    RevokeAuthorizationResponse expectedResponse = RevokeAuthorizationResponse.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
    String userId = "userId-836030906";

    RevokeAuthorizationResponse actualResponse = client.revokeAuthorization(name, userId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeAuthorizationRequest actualRequest = ((RevokeAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(userId, actualRequest.getUserId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      String userId = "userId-836030906";
      client.revokeAuthorization(name, userId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeAuthorizationTest2() throws Exception {
    RevokeAuthorizationResponse expectedResponse = RevokeAuthorizationResponse.newBuilder().build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";
    String userId = "userId-836030906";

    RevokeAuthorizationResponse actualResponse = client.revokeAuthorization(name, userId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeAuthorizationRequest actualRequest = ((RevokeAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(userId, actualRequest.getUserId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      String userId = "userId-836030906";
      client.revokeAuthorization(name, userId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.enableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableAuthProviderRequest actualRequest = ((EnableAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.enableAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableAuthProviderTest2() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    AuthProvider actualResponse = client.enableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableAuthProviderRequest actualRequest = ((EnableAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.enableAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableAuthProviderTest() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.disableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableAuthProviderRequest actualRequest = ((DisableAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableAuthProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
      client.disableAuthProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableAuthProviderTest2() throws Exception {
    AuthProvider expectedResponse =
        AuthProvider.newBuilder()
            .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthProviderTypeParams(AuthProvider.AuthProviderTypeParams.newBuilder().build())
            .addAllAllowedScopes(new ArrayList<String>())
            .addAllBlockedScopes(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setDeleted(true)
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllWorkloadIds(new ArrayList<String>())
            .build();
    mockAuthProviderService.addResponse(expectedResponse);

    String name = "name3373707";

    AuthProvider actualResponse = client.disableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthProviderService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableAuthProviderRequest actualRequest = ((DisableAuthProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableAuthProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthProviderService.addException(exception);

    try {
      String name = "name3373707";
      client.disableAuthProvider(name);
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
            .setResource(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
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
                  AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
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
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
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
                  AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
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
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
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
                  AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
