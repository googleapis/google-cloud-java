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

package com.google.cloud.agentidentity.v1;

import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.agentidentity.v1.stub.HttpJsonAuthProviderServiceStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AuthProviderServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AuthProviderServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAuthProviderServiceStub.getMethodDescriptors(),
            AuthProviderServiceSettings.getDefaultEndpoint());
    AuthProviderServiceSettings settings =
        AuthProviderServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AuthProviderServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuthProviderServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listAuthProvidersTest() throws Exception {
    AuthProvider responsesElement = AuthProvider.newBuilder().build();
    ListAuthProvidersResponse expectedResponse =
        ListAuthProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuthProviders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuthProvidersPagedResponse pagedListResponse = client.listAuthProviders(parent);

    List<AuthProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProvidersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAuthProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAuthProvidersPagedResponse pagedListResponse = client.listAuthProviders(parent);

    List<AuthProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProvidersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAuthProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.getAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    AuthProvider actualResponse = client.getAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AuthProvider authProvider = AuthProvider.newBuilder().build();
    String authProviderId = "authProviderId325000884";

    AuthProvider actualResponse = client.createAuthProvider(parent, authProvider, authProviderId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    AuthProvider authProvider = AuthProvider.newBuilder().build();
    String authProviderId = "authProviderId325000884";

    AuthProvider actualResponse = client.createAuthProvider(parent, authProvider, authProviderId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    AuthProvider authProvider =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    AuthProvider actualResponse = client.updateAuthProvider(authProvider, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AuthProvider authProvider =
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    client.deleteAuthProvider(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    client.deleteAuthProvider(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.undeleteAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void undeleteAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    AuthProvider actualResponse = client.undeleteAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void undeleteAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String workloadId = "workloadId-186277134";

    QueryAuthProvidersPagedResponse pagedListResponse =
        client.queryAuthProviders(parent, workloadId);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProviderNamesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void queryAuthProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String workloadId = "workloadId-186277134";

    QueryAuthProvidersPagedResponse pagedListResponse =
        client.queryAuthProviders(parent, workloadId);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthProviderNamesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void queryAuthProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    QueryWorkloadsPagedResponse pagedListResponse = client.queryWorkloads(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void queryWorkloadsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    QueryWorkloadsPagedResponse pagedListResponse = client.queryWorkloads(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadIdsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void queryWorkloadsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName parent = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    ListAuthorizationsPagedResponse pagedListResponse = client.listAuthorizations(parent);

    List<Authorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAuthorizationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1729/locations/location-1729/authProviders/authProvider-1729";

    ListAuthorizationsPagedResponse pagedListResponse = client.listAuthorizations(parent);

    List<Authorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuthorizationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAuthorizationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1729/locations/location-1729/authProviders/authProvider-1729";
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
    mockService.addResponse(expectedResponse);

    AuthorizationName name =
        AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAuthorizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4252/locations/location-4252/authProviders/authProvider-4252/authorizations/authorization-4252";

    Authorization actualResponse = client.getAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAuthorizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4252/locations/location-4252/authProviders/authProvider-4252/authorizations/authorization-4252";
      client.getAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthorizationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AuthorizationName name =
        AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");

    client.deleteAuthorization(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteAuthorizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4252/locations/location-4252/authProviders/authProvider-4252/authorizations/authorization-4252";

    client.deleteAuthorization(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteAuthorizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4252/locations/location-4252/authProviders/authProvider-4252/authorizations/authorization-4252";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccessSummariesPagedResponse pagedListResponse = client.listAccessSummaries(parent);

    List<AccessSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessSummariesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAccessSummariesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAccessSummariesPagedResponse pagedListResponse = client.listAccessSummaries(parent);

    List<AccessSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessSummariesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAccessSummariesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    AccessSummaryName name = AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]");

    AccessSummary actualResponse = client.getAccessSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAccessSummaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8922/locations/location-8922/accessSummaries/accessSummarie-8922";

    AccessSummary actualResponse = client.getAccessSummary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAccessSummaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8922/locations/location-8922/accessSummaries/accessSummarie-8922";
      client.getAccessSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeAuthorizationTest() throws Exception {
    RevokeAuthorizationResponse expectedResponse = RevokeAuthorizationResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
    String userId = "userId-836030906";

    RevokeAuthorizationResponse actualResponse = client.revokeAuthorization(name, userId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void revokeAuthorizationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
    String userId = "userId-836030906";

    RevokeAuthorizationResponse actualResponse = client.revokeAuthorization(name, userId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void revokeAuthorizationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.enableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    AuthProvider actualResponse = client.enableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");

    AuthProvider actualResponse = client.disableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableAuthProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";

    AuthProvider actualResponse = client.disableAuthProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableAuthProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4176/locations/location-4176/authProviders/authProvider-4176";
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
