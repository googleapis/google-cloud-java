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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthzPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListBackendAuthenticationConfigsPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListGatewaySecurityPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListGatewaySecurityPolicyRulesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListTlsInspectionPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListUrlListsPagedResponse;

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
  public void listBackendAuthenticationConfigsTest() throws Exception {
    BackendAuthenticationConfig responsesElement = BackendAuthenticationConfig.newBuilder().build();
    ListBackendAuthenticationConfigsResponse expectedResponse =
        ListBackendAuthenticationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackendAuthenticationConfigs(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackendAuthenticationConfigsPagedResponse pagedListResponse =
        client.listBackendAuthenticationConfigs(parent);

    List<BackendAuthenticationConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getBackendAuthenticationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackendAuthenticationConfigsRequest actualRequest =
        ((ListBackendAuthenticationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackendAuthenticationConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackendAuthenticationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackendAuthenticationConfigsTest2() throws Exception {
    BackendAuthenticationConfig responsesElement = BackendAuthenticationConfig.newBuilder().build();
    ListBackendAuthenticationConfigsResponse expectedResponse =
        ListBackendAuthenticationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackendAuthenticationConfigs(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackendAuthenticationConfigsPagedResponse pagedListResponse =
        client.listBackendAuthenticationConfigs(parent);

    List<BackendAuthenticationConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getBackendAuthenticationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackendAuthenticationConfigsRequest actualRequest =
        ((ListBackendAuthenticationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackendAuthenticationConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackendAuthenticationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackendAuthenticationConfigTest() throws Exception {
    BackendAuthenticationConfig expectedResponse =
        BackendAuthenticationConfig.newBuilder()
            .setName(
                BackendAuthenticationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setClientCertificate("clientCertificate592328908")
            .setTrustConfig("trustConfig515541946")
            .setEtag("etag3123477")
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    BackendAuthenticationConfigName name =
        BackendAuthenticationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");

    BackendAuthenticationConfig actualResponse = client.getBackendAuthenticationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackendAuthenticationConfigRequest actualRequest =
        ((GetBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackendAuthenticationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      BackendAuthenticationConfigName name =
          BackendAuthenticationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");
      client.getBackendAuthenticationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackendAuthenticationConfigTest2() throws Exception {
    BackendAuthenticationConfig expectedResponse =
        BackendAuthenticationConfig.newBuilder()
            .setName(
                BackendAuthenticationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setClientCertificate("clientCertificate592328908")
            .setTrustConfig("trustConfig515541946")
            .setEtag("etag3123477")
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    BackendAuthenticationConfig actualResponse = client.getBackendAuthenticationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackendAuthenticationConfigRequest actualRequest =
        ((GetBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackendAuthenticationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getBackendAuthenticationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackendAuthenticationConfigTest() throws Exception {
    BackendAuthenticationConfig expectedResponse =
        BackendAuthenticationConfig.newBuilder()
            .setName(
                BackendAuthenticationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setClientCertificate("clientCertificate592328908")
            .setTrustConfig("trustConfig515541946")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackendAuthenticationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackendAuthenticationConfig backendAuthenticationConfig =
        BackendAuthenticationConfig.newBuilder().build();
    String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";

    BackendAuthenticationConfig actualResponse =
        client
            .createBackendAuthenticationConfigAsync(
                parent, backendAuthenticationConfig, backendAuthenticationConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackendAuthenticationConfigRequest actualRequest =
        ((CreateBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        backendAuthenticationConfig, actualRequest.getBackendAuthenticationConfig());
    Assert.assertEquals(
        backendAuthenticationConfigId, actualRequest.getBackendAuthenticationConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackendAuthenticationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackendAuthenticationConfig backendAuthenticationConfig =
          BackendAuthenticationConfig.newBuilder().build();
      String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";
      client
          .createBackendAuthenticationConfigAsync(
              parent, backendAuthenticationConfig, backendAuthenticationConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackendAuthenticationConfigTest2() throws Exception {
    BackendAuthenticationConfig expectedResponse =
        BackendAuthenticationConfig.newBuilder()
            .setName(
                BackendAuthenticationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setClientCertificate("clientCertificate592328908")
            .setTrustConfig("trustConfig515541946")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackendAuthenticationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    BackendAuthenticationConfig backendAuthenticationConfig =
        BackendAuthenticationConfig.newBuilder().build();
    String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";

    BackendAuthenticationConfig actualResponse =
        client
            .createBackendAuthenticationConfigAsync(
                parent, backendAuthenticationConfig, backendAuthenticationConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackendAuthenticationConfigRequest actualRequest =
        ((CreateBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        backendAuthenticationConfig, actualRequest.getBackendAuthenticationConfig());
    Assert.assertEquals(
        backendAuthenticationConfigId, actualRequest.getBackendAuthenticationConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackendAuthenticationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      BackendAuthenticationConfig backendAuthenticationConfig =
          BackendAuthenticationConfig.newBuilder().build();
      String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";
      client
          .createBackendAuthenticationConfigAsync(
              parent, backendAuthenticationConfig, backendAuthenticationConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBackendAuthenticationConfigTest() throws Exception {
    BackendAuthenticationConfig expectedResponse =
        BackendAuthenticationConfig.newBuilder()
            .setName(
                BackendAuthenticationConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setClientCertificate("clientCertificate592328908")
            .setTrustConfig("trustConfig515541946")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackendAuthenticationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    BackendAuthenticationConfig backendAuthenticationConfig =
        BackendAuthenticationConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackendAuthenticationConfig actualResponse =
        client
            .updateBackendAuthenticationConfigAsync(backendAuthenticationConfig, updateMask)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackendAuthenticationConfigRequest actualRequest =
        ((UpdateBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        backendAuthenticationConfig, actualRequest.getBackendAuthenticationConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackendAuthenticationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      BackendAuthenticationConfig backendAuthenticationConfig =
          BackendAuthenticationConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackendAuthenticationConfigAsync(backendAuthenticationConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackendAuthenticationConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackendAuthenticationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    BackendAuthenticationConfigName name =
        BackendAuthenticationConfigName.of(
            "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");

    client.deleteBackendAuthenticationConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackendAuthenticationConfigRequest actualRequest =
        ((DeleteBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackendAuthenticationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      BackendAuthenticationConfigName name =
          BackendAuthenticationConfigName.of(
              "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");
      client.deleteBackendAuthenticationConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackendAuthenticationConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackendAuthenticationConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackendAuthenticationConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackendAuthenticationConfigRequest actualRequest =
        ((DeleteBackendAuthenticationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackendAuthenticationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackendAuthenticationConfigAsync(name).get();
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
  public void listGatewaySecurityPoliciesTest() throws Exception {
    GatewaySecurityPolicy responsesElement = GatewaySecurityPolicy.newBuilder().build();
    ListGatewaySecurityPoliciesResponse expectedResponse =
        ListGatewaySecurityPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGatewaySecurityPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGatewaySecurityPoliciesPagedResponse pagedListResponse =
        client.listGatewaySecurityPolicies(parent);

    List<GatewaySecurityPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaySecurityPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaySecurityPoliciesRequest actualRequest =
        ((ListGatewaySecurityPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaySecurityPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGatewaySecurityPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGatewaySecurityPoliciesTest2() throws Exception {
    GatewaySecurityPolicy responsesElement = GatewaySecurityPolicy.newBuilder().build();
    ListGatewaySecurityPoliciesResponse expectedResponse =
        ListGatewaySecurityPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGatewaySecurityPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGatewaySecurityPoliciesPagedResponse pagedListResponse =
        client.listGatewaySecurityPolicies(parent);

    List<GatewaySecurityPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaySecurityPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaySecurityPoliciesRequest actualRequest =
        ((ListGatewaySecurityPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaySecurityPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGatewaySecurityPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewaySecurityPolicyTest() throws Exception {
    GatewaySecurityPolicy expectedResponse =
        GatewaySecurityPolicy.newBuilder()
            .setName(
                GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    GatewaySecurityPolicyName name =
        GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");

    GatewaySecurityPolicy actualResponse = client.getGatewaySecurityPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewaySecurityPolicyRequest actualRequest =
        ((GetGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewaySecurityPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyName name =
          GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
      client.getGatewaySecurityPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewaySecurityPolicyTest2() throws Exception {
    GatewaySecurityPolicy expectedResponse =
        GatewaySecurityPolicy.newBuilder()
            .setName(
                GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    GatewaySecurityPolicy actualResponse = client.getGatewaySecurityPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewaySecurityPolicyRequest actualRequest =
        ((GetGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewaySecurityPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getGatewaySecurityPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGatewaySecurityPolicyTest() throws Exception {
    GatewaySecurityPolicy expectedResponse =
        GatewaySecurityPolicy.newBuilder()
            .setName(
                GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewaySecurityPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
    String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";

    GatewaySecurityPolicy actualResponse =
        client
            .createGatewaySecurityPolicyAsync(
                parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewaySecurityPolicyRequest actualRequest =
        ((CreateGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gatewaySecurityPolicy, actualRequest.getGatewaySecurityPolicy());
    Assert.assertEquals(gatewaySecurityPolicyId, actualRequest.getGatewaySecurityPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewaySecurityPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
      String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";
      client
          .createGatewaySecurityPolicyAsync(parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGatewaySecurityPolicyTest2() throws Exception {
    GatewaySecurityPolicy expectedResponse =
        GatewaySecurityPolicy.newBuilder()
            .setName(
                GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewaySecurityPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
    String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";

    GatewaySecurityPolicy actualResponse =
        client
            .createGatewaySecurityPolicyAsync(
                parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewaySecurityPolicyRequest actualRequest =
        ((CreateGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gatewaySecurityPolicy, actualRequest.getGatewaySecurityPolicy());
    Assert.assertEquals(gatewaySecurityPolicyId, actualRequest.getGatewaySecurityPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewaySecurityPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
      String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";
      client
          .createGatewaySecurityPolicyAsync(parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGatewaySecurityPolicyTest() throws Exception {
    GatewaySecurityPolicy expectedResponse =
        GatewaySecurityPolicy.newBuilder()
            .setName(
                GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setTlsInspectionPolicy(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGatewaySecurityPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GatewaySecurityPolicy actualResponse =
        client.updateGatewaySecurityPolicyAsync(gatewaySecurityPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGatewaySecurityPolicyRequest actualRequest =
        ((UpdateGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(gatewaySecurityPolicy, actualRequest.getGatewaySecurityPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGatewaySecurityPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGatewaySecurityPolicyAsync(gatewaySecurityPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewaySecurityPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewaySecurityPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    GatewaySecurityPolicyName name =
        GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");

    client.deleteGatewaySecurityPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewaySecurityPolicyRequest actualRequest =
        ((DeleteGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewaySecurityPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyName name =
          GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
      client.deleteGatewaySecurityPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewaySecurityPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewaySecurityPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGatewaySecurityPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewaySecurityPolicyRequest actualRequest =
        ((DeleteGatewaySecurityPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewaySecurityPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGatewaySecurityPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGatewaySecurityPolicyRulesTest() throws Exception {
    GatewaySecurityPolicyRule responsesElement = GatewaySecurityPolicyRule.newBuilder().build();
    ListGatewaySecurityPolicyRulesResponse expectedResponse =
        ListGatewaySecurityPolicyRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGatewaySecurityPolicyRules(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    GatewaySecurityPolicyName parent =
        GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");

    ListGatewaySecurityPolicyRulesPagedResponse pagedListResponse =
        client.listGatewaySecurityPolicyRules(parent);

    List<GatewaySecurityPolicyRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getGatewaySecurityPolicyRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaySecurityPolicyRulesRequest actualRequest =
        ((ListGatewaySecurityPolicyRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaySecurityPolicyRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyName parent =
          GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
      client.listGatewaySecurityPolicyRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGatewaySecurityPolicyRulesTest2() throws Exception {
    GatewaySecurityPolicyRule responsesElement = GatewaySecurityPolicyRule.newBuilder().build();
    ListGatewaySecurityPolicyRulesResponse expectedResponse =
        ListGatewaySecurityPolicyRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGatewaySecurityPolicyRules(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGatewaySecurityPolicyRulesPagedResponse pagedListResponse =
        client.listGatewaySecurityPolicyRules(parent);

    List<GatewaySecurityPolicyRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getGatewaySecurityPolicyRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGatewaySecurityPolicyRulesRequest actualRequest =
        ((ListGatewaySecurityPolicyRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGatewaySecurityPolicyRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGatewaySecurityPolicyRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewaySecurityPolicyRuleTest() throws Exception {
    GatewaySecurityPolicyRule expectedResponse =
        GatewaySecurityPolicyRule.newBuilder()
            .setName(
                GatewaySecurityPolicyRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnabled(true)
            .setPriority(-1165461084)
            .setDescription("description-1724546052")
            .setSessionMatcher("sessionMatcher-1681872452")
            .setApplicationMatcher("applicationMatcher1416724930")
            .setTlsInspectionEnabled(true)
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    GatewaySecurityPolicyRuleName name =
        GatewaySecurityPolicyRuleName.of(
            "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");

    GatewaySecurityPolicyRule actualResponse = client.getGatewaySecurityPolicyRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewaySecurityPolicyRuleRequest actualRequest =
        ((GetGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewaySecurityPolicyRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyRuleName name =
          GatewaySecurityPolicyRuleName.of(
              "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");
      client.getGatewaySecurityPolicyRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewaySecurityPolicyRuleTest2() throws Exception {
    GatewaySecurityPolicyRule expectedResponse =
        GatewaySecurityPolicyRule.newBuilder()
            .setName(
                GatewaySecurityPolicyRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnabled(true)
            .setPriority(-1165461084)
            .setDescription("description-1724546052")
            .setSessionMatcher("sessionMatcher-1681872452")
            .setApplicationMatcher("applicationMatcher1416724930")
            .setTlsInspectionEnabled(true)
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    GatewaySecurityPolicyRule actualResponse = client.getGatewaySecurityPolicyRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGatewaySecurityPolicyRuleRequest actualRequest =
        ((GetGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGatewaySecurityPolicyRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getGatewaySecurityPolicyRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGatewaySecurityPolicyRuleTest() throws Exception {
    GatewaySecurityPolicyRule expectedResponse =
        GatewaySecurityPolicyRule.newBuilder()
            .setName(
                GatewaySecurityPolicyRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnabled(true)
            .setPriority(-1165461084)
            .setDescription("description-1724546052")
            .setSessionMatcher("sessionMatcher-1681872452")
            .setApplicationMatcher("applicationMatcher1416724930")
            .setTlsInspectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewaySecurityPolicyRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    GatewaySecurityPolicyName parent =
        GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
    GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
        GatewaySecurityPolicyRule.newBuilder().build();
    String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";

    GatewaySecurityPolicyRule actualResponse =
        client
            .createGatewaySecurityPolicyRuleAsync(
                parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewaySecurityPolicyRuleRequest actualRequest =
        ((CreateGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gatewaySecurityPolicyRule, actualRequest.getGatewaySecurityPolicyRule());
    Assert.assertEquals(
        gatewaySecurityPolicyRuleId, actualRequest.getGatewaySecurityPolicyRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewaySecurityPolicyRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyName parent =
          GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
      GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
          GatewaySecurityPolicyRule.newBuilder().build();
      String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";
      client
          .createGatewaySecurityPolicyRuleAsync(
              parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGatewaySecurityPolicyRuleTest2() throws Exception {
    GatewaySecurityPolicyRule expectedResponse =
        GatewaySecurityPolicyRule.newBuilder()
            .setName(
                GatewaySecurityPolicyRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnabled(true)
            .setPriority(-1165461084)
            .setDescription("description-1724546052")
            .setSessionMatcher("sessionMatcher-1681872452")
            .setApplicationMatcher("applicationMatcher1416724930")
            .setTlsInspectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewaySecurityPolicyRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
        GatewaySecurityPolicyRule.newBuilder().build();
    String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";

    GatewaySecurityPolicyRule actualResponse =
        client
            .createGatewaySecurityPolicyRuleAsync(
                parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGatewaySecurityPolicyRuleRequest actualRequest =
        ((CreateGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gatewaySecurityPolicyRule, actualRequest.getGatewaySecurityPolicyRule());
    Assert.assertEquals(
        gatewaySecurityPolicyRuleId, actualRequest.getGatewaySecurityPolicyRuleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGatewaySecurityPolicyRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
          GatewaySecurityPolicyRule.newBuilder().build();
      String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";
      client
          .createGatewaySecurityPolicyRuleAsync(
              parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGatewaySecurityPolicyRuleTest() throws Exception {
    GatewaySecurityPolicyRule expectedResponse =
        GatewaySecurityPolicyRule.newBuilder()
            .setName(
                GatewaySecurityPolicyRuleName.of(
                        "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnabled(true)
            .setPriority(-1165461084)
            .setDescription("description-1724546052")
            .setSessionMatcher("sessionMatcher-1681872452")
            .setApplicationMatcher("applicationMatcher1416724930")
            .setTlsInspectionEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGatewaySecurityPolicyRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
        GatewaySecurityPolicyRule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GatewaySecurityPolicyRule actualResponse =
        client.updateGatewaySecurityPolicyRuleAsync(gatewaySecurityPolicyRule, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGatewaySecurityPolicyRuleRequest actualRequest =
        ((UpdateGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(gatewaySecurityPolicyRule, actualRequest.getGatewaySecurityPolicyRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGatewaySecurityPolicyRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
          GatewaySecurityPolicyRule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGatewaySecurityPolicyRuleAsync(gatewaySecurityPolicyRule, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewaySecurityPolicyRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewaySecurityPolicyRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    GatewaySecurityPolicyRuleName name =
        GatewaySecurityPolicyRuleName.of(
            "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");

    client.deleteGatewaySecurityPolicyRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewaySecurityPolicyRuleRequest actualRequest =
        ((DeleteGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewaySecurityPolicyRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      GatewaySecurityPolicyRuleName name =
          GatewaySecurityPolicyRuleName.of(
              "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");
      client.deleteGatewaySecurityPolicyRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGatewaySecurityPolicyRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewaySecurityPolicyRuleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGatewaySecurityPolicyRuleAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGatewaySecurityPolicyRuleRequest actualRequest =
        ((DeleteGatewaySecurityPolicyRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGatewaySecurityPolicyRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGatewaySecurityPolicyRuleAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listUrlListsTest() throws Exception {
    UrlList responsesElement = UrlList.newBuilder().build();
    ListUrlListsResponse expectedResponse =
        ListUrlListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUrlLists(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListUrlListsPagedResponse pagedListResponse = client.listUrlLists(parent);

    List<UrlList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUrlListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUrlListsRequest actualRequest = ((ListUrlListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUrlListsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listUrlLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUrlListsTest2() throws Exception {
    UrlList responsesElement = UrlList.newBuilder().build();
    ListUrlListsResponse expectedResponse =
        ListUrlListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUrlLists(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUrlListsPagedResponse pagedListResponse = client.listUrlLists(parent);

    List<UrlList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUrlListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUrlListsRequest actualRequest = ((ListUrlListsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUrlListsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUrlLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUrlListTest() throws Exception {
    UrlList expectedResponse =
        UrlList.newBuilder()
            .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllValues(new ArrayList<String>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");

    UrlList actualResponse = client.getUrlList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUrlListRequest actualRequest = ((GetUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUrlListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");
      client.getUrlList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUrlListTest2() throws Exception {
    UrlList expectedResponse =
        UrlList.newBuilder()
            .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllValues(new ArrayList<String>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    UrlList actualResponse = client.getUrlList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUrlListRequest actualRequest = ((GetUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUrlListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getUrlList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUrlListTest() throws Exception {
    UrlList expectedResponse =
        UrlList.newBuilder()
            .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllValues(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createUrlListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    UrlList urlList = UrlList.newBuilder().build();
    String urlListId = "urlListId-564417368";

    UrlList actualResponse = client.createUrlListAsync(parent, urlList, urlListId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUrlListRequest actualRequest = ((CreateUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(urlList, actualRequest.getUrlList());
    Assert.assertEquals(urlListId, actualRequest.getUrlListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUrlListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      UrlList urlList = UrlList.newBuilder().build();
      String urlListId = "urlListId-564417368";
      client.createUrlListAsync(parent, urlList, urlListId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createUrlListTest2() throws Exception {
    UrlList expectedResponse =
        UrlList.newBuilder()
            .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllValues(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createUrlListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    UrlList urlList = UrlList.newBuilder().build();
    String urlListId = "urlListId-564417368";

    UrlList actualResponse = client.createUrlListAsync(parent, urlList, urlListId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUrlListRequest actualRequest = ((CreateUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(urlList, actualRequest.getUrlList());
    Assert.assertEquals(urlListId, actualRequest.getUrlListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUrlListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      UrlList urlList = UrlList.newBuilder().build();
      String urlListId = "urlListId-564417368";
      client.createUrlListAsync(parent, urlList, urlListId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateUrlListTest() throws Exception {
    UrlList expectedResponse =
        UrlList.newBuilder()
            .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllValues(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateUrlListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    UrlList urlList = UrlList.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UrlList actualResponse = client.updateUrlListAsync(urlList, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUrlListRequest actualRequest = ((UpdateUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(urlList, actualRequest.getUrlList());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUrlListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      UrlList urlList = UrlList.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUrlListAsync(urlList, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteUrlListTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUrlListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");

    client.deleteUrlListAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUrlListRequest actualRequest = ((DeleteUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUrlListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");
      client.deleteUrlListAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteUrlListTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteUrlListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteUrlListAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUrlListRequest actualRequest = ((DeleteUrlListRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUrlListExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUrlListAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTlsInspectionPoliciesTest() throws Exception {
    TlsInspectionPolicy responsesElement = TlsInspectionPolicy.newBuilder().build();
    ListTlsInspectionPoliciesResponse expectedResponse =
        ListTlsInspectionPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsInspectionPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTlsInspectionPoliciesPagedResponse pagedListResponse =
        client.listTlsInspectionPolicies(parent);

    List<TlsInspectionPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsInspectionPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTlsInspectionPoliciesRequest actualRequest =
        ((ListTlsInspectionPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTlsInspectionPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTlsInspectionPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTlsInspectionPoliciesTest2() throws Exception {
    TlsInspectionPolicy responsesElement = TlsInspectionPolicy.newBuilder().build();
    ListTlsInspectionPoliciesResponse expectedResponse =
        ListTlsInspectionPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsInspectionPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTlsInspectionPoliciesPagedResponse pagedListResponse =
        client.listTlsInspectionPolicies(parent);

    List<TlsInspectionPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsInspectionPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTlsInspectionPoliciesRequest actualRequest =
        ((ListTlsInspectionPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTlsInspectionPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTlsInspectionPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsInspectionPolicyTest() throws Exception {
    TlsInspectionPolicy expectedResponse =
        TlsInspectionPolicy.newBuilder()
            .setName(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCaPool("caPool-1368606310")
            .setTrustConfig("trustConfig515541946")
            .setExcludePublicCaSet(true)
            .addAllCustomTlsFeatures(new ArrayList<String>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    TlsInspectionPolicyName name =
        TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");

    TlsInspectionPolicy actualResponse = client.getTlsInspectionPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTlsInspectionPolicyRequest actualRequest =
        ((GetTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTlsInspectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      TlsInspectionPolicyName name =
          TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");
      client.getTlsInspectionPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsInspectionPolicyTest2() throws Exception {
    TlsInspectionPolicy expectedResponse =
        TlsInspectionPolicy.newBuilder()
            .setName(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCaPool("caPool-1368606310")
            .setTrustConfig("trustConfig515541946")
            .setExcludePublicCaSet(true)
            .addAllCustomTlsFeatures(new ArrayList<String>())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    TlsInspectionPolicy actualResponse = client.getTlsInspectionPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTlsInspectionPolicyRequest actualRequest =
        ((GetTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTlsInspectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getTlsInspectionPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTlsInspectionPolicyTest() throws Exception {
    TlsInspectionPolicy expectedResponse =
        TlsInspectionPolicy.newBuilder()
            .setName(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCaPool("caPool-1368606310")
            .setTrustConfig("trustConfig515541946")
            .setExcludePublicCaSet(true)
            .addAllCustomTlsFeatures(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsInspectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
    String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";

    TlsInspectionPolicy actualResponse =
        client
            .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTlsInspectionPolicyRequest actualRequest =
        ((CreateTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tlsInspectionPolicy, actualRequest.getTlsInspectionPolicy());
    Assert.assertEquals(tlsInspectionPolicyId, actualRequest.getTlsInspectionPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTlsInspectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
      String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";
      client
          .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTlsInspectionPolicyTest2() throws Exception {
    TlsInspectionPolicy expectedResponse =
        TlsInspectionPolicy.newBuilder()
            .setName(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCaPool("caPool-1368606310")
            .setTrustConfig("trustConfig515541946")
            .setExcludePublicCaSet(true)
            .addAllCustomTlsFeatures(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsInspectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
    String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";

    TlsInspectionPolicy actualResponse =
        client
            .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTlsInspectionPolicyRequest actualRequest =
        ((CreateTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tlsInspectionPolicy, actualRequest.getTlsInspectionPolicy());
    Assert.assertEquals(tlsInspectionPolicyId, actualRequest.getTlsInspectionPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTlsInspectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
      String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";
      client
          .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTlsInspectionPolicyTest() throws Exception {
    TlsInspectionPolicy expectedResponse =
        TlsInspectionPolicy.newBuilder()
            .setName(
                TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCaPool("caPool-1368606310")
            .setTrustConfig("trustConfig515541946")
            .setExcludePublicCaSet(true)
            .addAllCustomTlsFeatures(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTlsInspectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TlsInspectionPolicy actualResponse =
        client.updateTlsInspectionPolicyAsync(tlsInspectionPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTlsInspectionPolicyRequest actualRequest =
        ((UpdateTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(tlsInspectionPolicy, actualRequest.getTlsInspectionPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTlsInspectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTlsInspectionPolicyAsync(tlsInspectionPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTlsInspectionPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsInspectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    TlsInspectionPolicyName name =
        TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");

    client.deleteTlsInspectionPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTlsInspectionPolicyRequest actualRequest =
        ((DeleteTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTlsInspectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      TlsInspectionPolicyName name =
          TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");
      client.deleteTlsInspectionPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTlsInspectionPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsInspectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTlsInspectionPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTlsInspectionPolicyRequest actualRequest =
        ((DeleteTlsInspectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTlsInspectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTlsInspectionPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAuthzPoliciesTest() throws Exception {
    AuthzPolicy responsesElement = AuthzPolicy.newBuilder().build();
    ListAuthzPoliciesResponse expectedResponse =
        ListAuthzPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthzPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuthzPoliciesPagedResponse pagedListResponse = client.listAuthzPolicies(parent);

    List<AuthzPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthzPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthzPoliciesRequest actualRequest = ((ListAuthzPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthzPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAuthzPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuthzPoliciesTest2() throws Exception {
    AuthzPolicy responsesElement = AuthzPolicy.newBuilder().build();
    ListAuthzPoliciesResponse expectedResponse =
        ListAuthzPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthzPolicies(Arrays.asList(responsesElement))
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuthzPoliciesPagedResponse pagedListResponse = client.listAuthzPolicies(parent);

    List<AuthzPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthzPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthzPoliciesRequest actualRequest = ((ListAuthzPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthzPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAuthzPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthzPolicyTest() throws Exception {
    AuthzPolicy expectedResponse =
        AuthzPolicy.newBuilder()
            .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setTarget(AuthzPolicy.Target.newBuilder().build())
            .addAllHttpRules(new ArrayList<AuthzPolicy.AuthzRule>())
            .setCustomProvider(AuthzPolicy.CustomProvider.newBuilder().build())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");

    AuthzPolicy actualResponse = client.getAuthzPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthzPolicyRequest actualRequest = ((GetAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthzPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");
      client.getAuthzPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthzPolicyTest2() throws Exception {
    AuthzPolicy expectedResponse =
        AuthzPolicy.newBuilder()
            .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setTarget(AuthzPolicy.Target.newBuilder().build())
            .addAllHttpRules(new ArrayList<AuthzPolicy.AuthzRule>())
            .setCustomProvider(AuthzPolicy.CustomProvider.newBuilder().build())
            .build();
    mockNetworkSecurity.addResponse(expectedResponse);

    String name = "name3373707";

    AuthzPolicy actualResponse = client.getAuthzPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthzPolicyRequest actualRequest = ((GetAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthzPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.getAuthzPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthzPolicyTest() throws Exception {
    AuthzPolicy expectedResponse =
        AuthzPolicy.newBuilder()
            .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setTarget(AuthzPolicy.Target.newBuilder().build())
            .addAllHttpRules(new ArrayList<AuthzPolicy.AuthzRule>())
            .setCustomProvider(AuthzPolicy.CustomProvider.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAuthzPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
    String authzPolicyId = "authzPolicyId1717400543";

    AuthzPolicy actualResponse =
        client.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthzPolicyRequest actualRequest = ((CreateAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(authzPolicy, actualRequest.getAuthzPolicy());
    Assert.assertEquals(authzPolicyId, actualRequest.getAuthzPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthzPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
      String authzPolicyId = "authzPolicyId1717400543";
      client.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAuthzPolicyTest2() throws Exception {
    AuthzPolicy expectedResponse =
        AuthzPolicy.newBuilder()
            .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setTarget(AuthzPolicy.Target.newBuilder().build())
            .addAllHttpRules(new ArrayList<AuthzPolicy.AuthzRule>())
            .setCustomProvider(AuthzPolicy.CustomProvider.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAuthzPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String parent = "parent-995424086";
    AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
    String authzPolicyId = "authzPolicyId1717400543";

    AuthzPolicy actualResponse =
        client.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthzPolicyRequest actualRequest = ((CreateAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(authzPolicy, actualRequest.getAuthzPolicy());
    Assert.assertEquals(authzPolicyId, actualRequest.getAuthzPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthzPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String parent = "parent-995424086";
      AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
      String authzPolicyId = "authzPolicyId1717400543";
      client.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAuthzPolicyTest() throws Exception {
    AuthzPolicy expectedResponse =
        AuthzPolicy.newBuilder()
            .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setTarget(AuthzPolicy.Target.newBuilder().build())
            .addAllHttpRules(new ArrayList<AuthzPolicy.AuthzRule>())
            .setCustomProvider(AuthzPolicy.CustomProvider.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAuthzPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AuthzPolicy actualResponse = client.updateAuthzPolicyAsync(authzPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAuthzPolicyRequest actualRequest = ((UpdateAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(authzPolicy, actualRequest.getAuthzPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAuthzPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAuthzPolicyAsync(authzPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthzPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthzPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");

    client.deleteAuthzPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthzPolicyRequest actualRequest = ((DeleteAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthzPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");
      client.deleteAuthzPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAuthzPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAuthzPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNetworkSecurity.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAuthzPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockNetworkSecurity.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthzPolicyRequest actualRequest = ((DeleteAuthzPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthzPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNetworkSecurity.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAuthzPolicyAsync(name).get();
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
