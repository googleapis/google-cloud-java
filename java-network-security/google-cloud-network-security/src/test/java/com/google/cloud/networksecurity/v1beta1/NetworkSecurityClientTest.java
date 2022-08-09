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

package com.google.cloud.networksecurity.v1beta1;

import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

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
public class NetworkSecurityClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockNetworkSecurity mockNetworkSecurity;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NetworkSecurityClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNetworkSecurity = new MockNetworkSecurity();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNetworkSecurity, mockLocations, mockIAMPolicy));
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
    NetworkSecuritySettings settings =
        NetworkSecuritySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NetworkSecurityClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAuthorizationPoliciesTest() throws Exception {
    AuthorizationPolicy responsesElement = AuthorizationPolicy.newBuilder().build();
    ListAuthorizationPoliciesResponse expectedResponse =
        ListAuthorizationPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthorizationPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuthorizationPoliciesPagedResponse pagedListResponse =
        client.listAuthorizationPolicies(parent);

    List<AuthorizationPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizationPoliciesRequest actualRequest =
        ((ListAuthorizationPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizationPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAuthorizationPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthorizationPoliciesTest2() throws Exception {
    AuthorizationPolicy responsesElement = AuthorizationPolicy.newBuilder().build();
    ListAuthorizationPoliciesResponse expectedResponse =
        ListAuthorizationPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthorizationPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuthorizationPoliciesPagedResponse pagedListResponse =
        client.listAuthorizationPolicies(parent);

    List<AuthorizationPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizationPoliciesRequest actualRequest =
        ((ListAuthorizationPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizationPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAuthorizationPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizationPolicyTest() throws Exception {
    AuthorizationPolicy expectedResponse =
        AuthorizationPolicy.newBuilder()
            .setName(
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<AuthorizationPolicy.Rule>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    AuthorizationPolicyName name =
        AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");

    AuthorizationPolicy actualResponse = client.getAuthorizationPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationPolicyRequest actualRequest =
        ((GetAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthorizationPolicyName name =
          AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
      client.getAuthorizationPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizationPolicyTest2() throws Exception {
    AuthorizationPolicy expectedResponse =
        AuthorizationPolicy.newBuilder()
            .setName(
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<AuthorizationPolicy.Rule>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    AuthorizationPolicy actualResponse = client.getAuthorizationPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizationPolicyRequest actualRequest =
        ((GetAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizationPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthorizationPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthorizationPolicyTest() throws Exception {
    AuthorizationPolicy expectedResponse =
        AuthorizationPolicy.newBuilder()
            .setName(
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<AuthorizationPolicy.Rule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAuthorizationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
    String authorizationPolicyId = "authorizationPolicyId1314252166";

    AuthorizationPolicy actualResponse =
        client
            .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthorizationPolicyRequest actualRequest =
        ((CreateAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(authorizationPolicy, actualRequest.getAuthorizationPolicy());
    Assert.assertEquals(authorizationPolicyId, actualRequest.getAuthorizationPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthorizationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
      String authorizationPolicyId = "authorizationPolicyId1314252166";
      client
          .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAuthorizationPolicyTest2() throws Exception {
    AuthorizationPolicy expectedResponse =
        AuthorizationPolicy.newBuilder()
            .setName(
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<AuthorizationPolicy.Rule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAuthorizationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
    String authorizationPolicyId = "authorizationPolicyId1314252166";

    AuthorizationPolicy actualResponse =
        client
            .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthorizationPolicyRequest actualRequest =
        ((CreateAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(authorizationPolicy, actualRequest.getAuthorizationPolicy());
    Assert.assertEquals(authorizationPolicyId, actualRequest.getAuthorizationPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthorizationPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
      String authorizationPolicyId = "authorizationPolicyId1314252166";
      client
          .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAuthorizationPolicyTest() throws Exception {
    AuthorizationPolicy expectedResponse =
        AuthorizationPolicy.newBuilder()
            .setName(
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<AuthorizationPolicy.Rule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAuthorizationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AuthorizationPolicy actualResponse =
        client.updateAuthorizationPolicyAsync(authorizationPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAuthorizationPolicyRequest actualRequest =
        ((UpdateAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(authorizationPolicy, actualRequest.getAuthorizationPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAuthorizationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAuthorizationPolicyAsync(authorizationPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthorizationPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthorizationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    AuthorizationPolicyName name =
        AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");

    client.deleteAuthorizationPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthorizationPolicyRequest actualRequest =
        ((DeleteAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthorizationPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthorizationPolicyName name =
          AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
      client.deleteAuthorizationPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthorizationPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthorizationPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAuthorizationPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthorizationPolicyRequest actualRequest =
        ((DeleteAuthorizationPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthorizationPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAuthorizationPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServerTlsPoliciesTest() throws Exception {
    ServerTlsPolicy responsesElement = ServerTlsPolicy.newBuilder().build();
    ListServerTlsPoliciesResponse expectedResponse =
        ListServerTlsPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServerTlsPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServerTlsPoliciesPagedResponse pagedListResponse = client.listServerTlsPolicies(parent);

    List<ServerTlsPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServerTlsPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServerTlsPoliciesRequest actualRequest =
        ((ListServerTlsPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServerTlsPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServerTlsPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServerTlsPoliciesTest2() throws Exception {
    ServerTlsPolicy responsesElement = ServerTlsPolicy.newBuilder().build();
    ListServerTlsPoliciesResponse expectedResponse =
        ListServerTlsPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServerTlsPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServerTlsPoliciesPagedResponse pagedListResponse = client.listServerTlsPolicies(parent);

    List<ServerTlsPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServerTlsPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServerTlsPoliciesRequest actualRequest =
        ((ListServerTlsPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServerTlsPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServerTlsPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServerTlsPolicyTest() throws Exception {
    ServerTlsPolicy expectedResponse =
        ServerTlsPolicy.newBuilder()
            .setName(
                ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAllowOpen(true)
            .setServerCertificate(CertificateProvider.newBuilder().build())
            .setMtlsPolicy(ServerTlsPolicy.MTLSPolicy.newBuilder().build())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    ServerTlsPolicyName name =
        ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");

    ServerTlsPolicy actualResponse = client.getServerTlsPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServerTlsPolicyRequest actualRequest = ((GetServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServerTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ServerTlsPolicyName name =
          ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");
      client.getServerTlsPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServerTlsPolicyTest2() throws Exception {
    ServerTlsPolicy expectedResponse =
        ServerTlsPolicy.newBuilder()
            .setName(
                ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAllowOpen(true)
            .setServerCertificate(CertificateProvider.newBuilder().build())
            .setMtlsPolicy(ServerTlsPolicy.MTLSPolicy.newBuilder().build())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    ServerTlsPolicy actualResponse = client.getServerTlsPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServerTlsPolicyRequest actualRequest = ((GetServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServerTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getServerTlsPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServerTlsPolicyTest() throws Exception {
    ServerTlsPolicy expectedResponse =
        ServerTlsPolicy.newBuilder()
            .setName(
                ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAllowOpen(true)
            .setServerCertificate(CertificateProvider.newBuilder().build())
            .setMtlsPolicy(ServerTlsPolicy.MTLSPolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServerTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
    String serverTlsPolicyId = "serverTlsPolicyId-1966046011";

    ServerTlsPolicy actualResponse =
        client.createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServerTlsPolicyRequest actualRequest =
        ((CreateServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serverTlsPolicy, actualRequest.getServerTlsPolicy());
    Assert.assertEquals(serverTlsPolicyId, actualRequest.getServerTlsPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServerTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
      String serverTlsPolicyId = "serverTlsPolicyId-1966046011";
      client.createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServerTlsPolicyTest2() throws Exception {
    ServerTlsPolicy expectedResponse =
        ServerTlsPolicy.newBuilder()
            .setName(
                ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAllowOpen(true)
            .setServerCertificate(CertificateProvider.newBuilder().build())
            .setMtlsPolicy(ServerTlsPolicy.MTLSPolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServerTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
    String serverTlsPolicyId = "serverTlsPolicyId-1966046011";

    ServerTlsPolicy actualResponse =
        client.createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServerTlsPolicyRequest actualRequest =
        ((CreateServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serverTlsPolicy, actualRequest.getServerTlsPolicy());
    Assert.assertEquals(serverTlsPolicyId, actualRequest.getServerTlsPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServerTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
      String serverTlsPolicyId = "serverTlsPolicyId-1966046011";
      client.createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServerTlsPolicyTest() throws Exception {
    ServerTlsPolicy expectedResponse =
        ServerTlsPolicy.newBuilder()
            .setName(
                ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAllowOpen(true)
            .setServerCertificate(CertificateProvider.newBuilder().build())
            .setMtlsPolicy(ServerTlsPolicy.MTLSPolicy.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServerTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServerTlsPolicy actualResponse =
        client.updateServerTlsPolicyAsync(serverTlsPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServerTlsPolicyRequest actualRequest =
        ((UpdateServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(serverTlsPolicy, actualRequest.getServerTlsPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServerTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServerTlsPolicyAsync(serverTlsPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServerTlsPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServerTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    ServerTlsPolicyName name =
        ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");

    client.deleteServerTlsPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServerTlsPolicyRequest actualRequest =
        ((DeleteServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServerTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ServerTlsPolicyName name =
          ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");
      client.deleteServerTlsPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServerTlsPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServerTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServerTlsPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServerTlsPolicyRequest actualRequest =
        ((DeleteServerTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServerTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServerTlsPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listClientTlsPoliciesTest() throws Exception {
    ClientTlsPolicy responsesElement = ClientTlsPolicy.newBuilder().build();
    ListClientTlsPoliciesResponse expectedResponse =
        ListClientTlsPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllClientTlsPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListClientTlsPoliciesPagedResponse pagedListResponse = client.listClientTlsPolicies(parent);

    List<ClientTlsPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClientTlsPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClientTlsPoliciesRequest actualRequest =
        ((ListClientTlsPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClientTlsPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listClientTlsPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClientTlsPoliciesTest2() throws Exception {
    ClientTlsPolicy responsesElement = ClientTlsPolicy.newBuilder().build();
    ListClientTlsPoliciesResponse expectedResponse =
        ListClientTlsPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllClientTlsPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListClientTlsPoliciesPagedResponse pagedListResponse = client.listClientTlsPolicies(parent);

    List<ClientTlsPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClientTlsPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClientTlsPoliciesRequest actualRequest =
        ((ListClientTlsPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClientTlsPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listClientTlsPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClientTlsPolicyTest() throws Exception {
    ClientTlsPolicy expectedResponse =
        ClientTlsPolicy.newBuilder()
            .setName(
                ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSni("sni114030")
            .setClientCertificate(CertificateProvider.newBuilder().build())
            .addAllServerValidationCa(new ArrayList<ValidationCA>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    ClientTlsPolicyName name =
        ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");

    ClientTlsPolicy actualResponse = client.getClientTlsPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClientTlsPolicyRequest actualRequest = ((GetClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClientTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ClientTlsPolicyName name =
          ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");
      client.getClientTlsPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClientTlsPolicyTest2() throws Exception {
    ClientTlsPolicy expectedResponse =
        ClientTlsPolicy.newBuilder()
            .setName(
                ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSni("sni114030")
            .setClientCertificate(CertificateProvider.newBuilder().build())
            .addAllServerValidationCa(new ArrayList<ValidationCA>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    ClientTlsPolicy actualResponse = client.getClientTlsPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClientTlsPolicyRequest actualRequest = ((GetClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClientTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getClientTlsPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClientTlsPolicyTest() throws Exception {
    ClientTlsPolicy expectedResponse =
        ClientTlsPolicy.newBuilder()
            .setName(
                ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSni("sni114030")
            .setClientCertificate(CertificateProvider.newBuilder().build())
            .addAllServerValidationCa(new ArrayList<ValidationCA>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClientTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
    String clientTlsPolicyId = "clientTlsPolicyId-188933315";

    ClientTlsPolicy actualResponse =
        client.createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClientTlsPolicyRequest actualRequest =
        ((CreateClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(clientTlsPolicy, actualRequest.getClientTlsPolicy());
    Assert.assertEquals(clientTlsPolicyId, actualRequest.getClientTlsPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClientTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
      String clientTlsPolicyId = "clientTlsPolicyId-188933315";
      client.createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createClientTlsPolicyTest2() throws Exception {
    ClientTlsPolicy expectedResponse =
        ClientTlsPolicy.newBuilder()
            .setName(
                ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSni("sni114030")
            .setClientCertificate(CertificateProvider.newBuilder().build())
            .addAllServerValidationCa(new ArrayList<ValidationCA>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClientTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
    String clientTlsPolicyId = "clientTlsPolicyId-188933315";

    ClientTlsPolicy actualResponse =
        client.createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClientTlsPolicyRequest actualRequest =
        ((CreateClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(clientTlsPolicy, actualRequest.getClientTlsPolicy());
    Assert.assertEquals(clientTlsPolicyId, actualRequest.getClientTlsPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClientTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
      String clientTlsPolicyId = "clientTlsPolicyId-188933315";
      client.createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateClientTlsPolicyTest() throws Exception {
    ClientTlsPolicy expectedResponse =
        ClientTlsPolicy.newBuilder()
            .setName(
                ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSni("sni114030")
            .setClientCertificate(CertificateProvider.newBuilder().build())
            .addAllServerValidationCa(new ArrayList<ValidationCA>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClientTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ClientTlsPolicy actualResponse =
        client.updateClientTlsPolicyAsync(clientTlsPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClientTlsPolicyRequest actualRequest =
        ((UpdateClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(clientTlsPolicy, actualRequest.getClientTlsPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateClientTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClientTlsPolicyAsync(clientTlsPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClientTlsPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClientTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    ClientTlsPolicyName name =
        ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");

    client.deleteClientTlsPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClientTlsPolicyRequest actualRequest =
        ((DeleteClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClientTlsPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      ClientTlsPolicyName name =
          ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");
      client.deleteClientTlsPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteClientTlsPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClientTlsPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteClientTlsPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClientTlsPolicyRequest actualRequest =
        ((DeleteClientTlsPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClientTlsPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteClientTlsPolicyAsync(name).get();
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
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
                  AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
                  AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
                AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
                  AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
