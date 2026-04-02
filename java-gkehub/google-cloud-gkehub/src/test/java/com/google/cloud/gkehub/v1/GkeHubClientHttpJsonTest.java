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

package com.google.cloud.gkehub.v1;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListBoundMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFleetsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListPermittedScopesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeNamespacesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkehub.v1.stub.HttpJsonGkeHubStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
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
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class GkeHubClientHttpJsonTest {
  private static MockHttpService mockService;
  private static GkeHubClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGkeHubStub.getMethodDescriptors(), GkeHubSettings.getDefaultEndpoint());
    GkeHubSettings settings =
        GkeHubSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                GkeHubSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GkeHubClient.create(settings);
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
  public void listMembershipsTest() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListMembershipsResponse expectedResponse =
        ListMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listMembershipsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listMembershipsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBoundMembershipsTest() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListBoundMembershipsResponse expectedResponse =
        ListBoundMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemberships(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName scopeName = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    ListBoundMembershipsPagedResponse pagedListResponse = client.listBoundMemberships(scopeName);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipsList().get(0), resources.get(0));

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
  public void listBoundMembershipsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName scopeName = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.listBoundMemberships(scopeName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBoundMembershipsTest2() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListBoundMembershipsResponse expectedResponse =
        ListBoundMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemberships(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String scopeName = "projects/project-6565/locations/location-6565/scopes/scope-6565";

    ListBoundMembershipsPagedResponse pagedListResponse = client.listBoundMemberships(scopeName);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipsList().get(0), resources.get(0));

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
  public void listBoundMembershipsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scopeName = "projects/project-6565/locations/location-6565/scopes/scope-6565";
      client.listBoundMemberships(scopeName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturesTest() throws Exception {
    Feature responsesElement = Feature.newBuilder().build();
    ListFeaturesResponse expectedResponse =
        ListFeaturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFeaturesPagedResponse pagedListResponse = client.listFeatures(parent);

    List<Feature> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listFeaturesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFeatures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeaturesTest2() throws Exception {
    Feature responsesElement = Feature.newBuilder().build();
    ListFeaturesResponse expectedResponse =
        ListFeaturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListFeaturesPagedResponse pagedListResponse = client.listFeatures(parent);

    List<Feature> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

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
  public void listFeaturesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listFeatures(parent);
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    Membership actualResponse = client.getMembership(name);
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
  public void getMembershipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-883/locations/location-883/memberships/membership-883";

    Membership actualResponse = client.getMembership(name);
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
  public void getMembershipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-883/locations/location-883/memberships/membership-883";
      client.getMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");

    Feature actualResponse = client.getFeature(name);
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
  public void getFeatureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
      client.getFeature(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeatureTest2() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8365/locations/location-8365/features/feature-8365";

    Feature actualResponse = client.getFeature(name);
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
  public void getFeatureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8365/locations/location-8365/features/feature-8365";
      client.getFeature(name);
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Membership resource = Membership.newBuilder().build();
    String membershipId = "membershipId517665681";

    Membership actualResponse = client.createMembershipAsync(parent, resource, membershipId).get();
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
  public void createMembershipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Membership resource = Membership.newBuilder().build();
      String membershipId = "membershipId517665681";
      client.createMembershipAsync(parent, resource, membershipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Membership resource = Membership.newBuilder().build();
    String membershipId = "membershipId517665681";

    Membership actualResponse = client.createMembershipAsync(parent, resource, membershipId).get();
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
  public void createMembershipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Membership resource = Membership.newBuilder().build();
      String membershipId = "membershipId517665681";
      client.createMembershipAsync(parent, resource, membershipId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Feature resource = Feature.newBuilder().build();
    String featureId = "featureId-420503887";

    Feature actualResponse = client.createFeatureAsync(parent, resource, featureId).get();
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
  public void createFeatureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Feature resource = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      client.createFeatureAsync(parent, resource, featureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFeatureTest2() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Feature resource = Feature.newBuilder().build();
    String featureId = "featureId-420503887";

    Feature actualResponse = client.createFeatureAsync(parent, resource, featureId).get();
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
  public void createFeatureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Feature resource = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      client.createFeatureAsync(parent, resource, featureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    client.deleteMembershipAsync(name).get();

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
  public void deleteMembershipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.deleteMembershipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-883/locations/location-883/memberships/membership-883";

    client.deleteMembershipAsync(name).get();

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
  public void deleteMembershipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-883/locations/location-883/memberships/membership-883";
      client.deleteMembershipAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFeatureTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");

    client.deleteFeatureAsync(name).get();

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
  public void deleteFeatureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
      client.deleteFeatureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFeatureTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-8365/locations/location-8365/features/feature-8365";

    client.deleteFeatureAsync(name).get();

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
  public void deleteFeatureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8365/locations/location-8365/features/feature-8365";
      client.deleteFeatureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
    Membership resource = Membership.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Membership actualResponse = client.updateMembershipAsync(name, resource, updateMask).get();
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
  public void updateMembershipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      Membership resource = Membership.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembershipAsync(name, resource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExternalId("externalId-1699764666")
            .setLastConnectionTime(Timestamp.newBuilder().build())
            .setUniqueId("uniqueId-294460212")
            .setAuthority(Authority.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMembershipTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-883/locations/location-883/memberships/membership-883";
    Membership resource = Membership.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Membership actualResponse = client.updateMembershipAsync(name, resource, updateMask).get();
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
  public void updateMembershipExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-883/locations/location-883/memberships/membership-883";
      Membership resource = Membership.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembershipAsync(name, resource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateFeatureTest() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
    Feature resource = Feature.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Feature actualResponse = client.updateFeatureAsync(name, resource, updateMask).get();
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
  public void updateFeatureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
      Feature resource = Feature.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureAsync(name, resource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateFeatureTest2() throws Exception {
    Feature expectedResponse =
        Feature.newBuilder()
            .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .setResourceState(FeatureResourceState.newBuilder().build())
            .setSpec(CommonFeatureSpec.newBuilder().build())
            .putAllMembershipSpecs(new HashMap<String, MembershipFeatureSpec>())
            .setState(CommonFeatureState.newBuilder().build())
            .putAllMembershipStates(new HashMap<String, MembershipFeatureState>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllScopeSpecs(new HashMap<String, ScopeFeatureSpec>())
            .putAllScopeStates(new HashMap<String, ScopeFeatureState>())
            .addAllUnreachable(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFeatureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-8365/locations/location-8365/features/feature-8365";
    Feature resource = Feature.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Feature actualResponse = client.updateFeatureAsync(name, resource, updateMask).get();
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
  public void updateFeatureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8365/locations/location-8365/features/feature-8365";
      Feature resource = Feature.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeatureAsync(name, resource, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateConnectManifestTest() throws Exception {
    GenerateConnectManifestResponse expectedResponse =
        GenerateConnectManifestResponse.newBuilder()
            .addAllManifest(new ArrayList<ConnectAgentResource>())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateConnectManifestRequest request =
        GenerateConnectManifestRequest.newBuilder()
            .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
            .setNamespace("namespace1252218203")
            .setProxy(ByteString.EMPTY)
            .setVersion("version351608024")
            .setIsUpgrade(true)
            .setRegistry("registry-690212803")
            .setImagePullSecretContent(ByteString.EMPTY)
            .build();

    GenerateConnectManifestResponse actualResponse = client.generateConnectManifest(request);
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
  public void generateConnectManifestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateConnectManifestRequest request =
          GenerateConnectManifestRequest.newBuilder()
              .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
              .setNamespace("namespace1252218203")
              .setProxy(ByteString.EMPTY)
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
  public void createFleetTest() throws Exception {
    Fleet expectedResponse =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFleetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Fleet fleet = Fleet.newBuilder().build();

    Fleet actualResponse = client.createFleetAsync(parent, fleet).get();
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
  public void createFleetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Fleet fleet = Fleet.newBuilder().build();
      client.createFleetAsync(parent, fleet).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFleetTest2() throws Exception {
    Fleet expectedResponse =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFleetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Fleet fleet = Fleet.newBuilder().build();

    Fleet actualResponse = client.createFleetAsync(parent, fleet).get();
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
  public void createFleetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Fleet fleet = Fleet.newBuilder().build();
      client.createFleetAsync(parent, fleet).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getFleetTest() throws Exception {
    Fleet expectedResponse =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");

    Fleet actualResponse = client.getFleet(name);
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
  public void getFleetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");
      client.getFleet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFleetTest2() throws Exception {
    Fleet expectedResponse =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6427/locations/location-6427/fleets/fleet-6427";

    Fleet actualResponse = client.getFleet(name);
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
  public void getFleetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6427/locations/location-6427/fleets/fleet-6427";
      client.getFleet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFleetTest() throws Exception {
    Fleet expectedResponse =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFleetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Fleet fleet =
        Fleet.newBuilder()
            .setName(
                FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUid("uid115792")
            .setState(FleetLifecycleState.newBuilder().build())
            .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Fleet actualResponse = client.updateFleetAsync(fleet, updateMask).get();
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
  public void updateFleetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Fleet fleet =
          Fleet.newBuilder()
              .setName(
                  FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setUid("uid115792")
              .setState(FleetLifecycleState.newBuilder().build())
              .setDefaultClusterConfig(DefaultClusterConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFleetAsync(fleet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFleetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFleetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");

    client.deleteFleetAsync(name).get();

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
  public void deleteFleetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");
      client.deleteFleetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFleetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFleetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6427/locations/location-6427/fleets/fleet-6427";

    client.deleteFleetAsync(name).get();

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
  public void deleteFleetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6427/locations/location-6427/fleets/fleet-6427";
      client.deleteFleetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listFleetsTest() throws Exception {
    Fleet responsesElement = Fleet.newBuilder().build();
    ListFleetsResponse expectedResponse =
        ListFleetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFleets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFleetsPagedResponse pagedListResponse = client.listFleets(parent);

    List<Fleet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetsList().get(0), resources.get(0));

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
  public void listFleetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFleets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFleetsTest2() throws Exception {
    Fleet responsesElement = Fleet.newBuilder().build();
    ListFleetsResponse expectedResponse =
        ListFleetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFleets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListFleetsPagedResponse pagedListResponse = client.listFleets(parent);

    List<Fleet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFleetsList().get(0), resources.get(0));

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
  public void listFleetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listFleets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");

    Namespace actualResponse = client.getScopeNamespace(name);
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
  public void getScopeNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");
      client.getScopeNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeNamespaceTest2() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7315/locations/location-7315/scopes/scope-7315/namespaces/namespace-7315";

    Namespace actualResponse = client.getScopeNamespace(name);
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
  public void getScopeNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7315/locations/location-7315/scopes/scope-7315/namespaces/namespace-7315";
      client.getScopeNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScopeNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeNamespaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
    Namespace scopeNamespace = Namespace.newBuilder().build();
    String scopeNamespaceId = "scopeNamespaceId-125738782";

    Namespace actualResponse =
        client.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
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
  public void createScopeNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      Namespace scopeNamespace = Namespace.newBuilder().build();
      String scopeNamespaceId = "scopeNamespaceId-125738782";
      client.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createScopeNamespaceTest2() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeNamespaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
    Namespace scopeNamespace = Namespace.newBuilder().build();
    String scopeNamespaceId = "scopeNamespaceId-125738782";

    Namespace actualResponse =
        client.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
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
  public void createScopeNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
      Namespace scopeNamespace = Namespace.newBuilder().build();
      String scopeNamespaceId = "scopeNamespaceId-125738782";
      client.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateScopeNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateScopeNamespaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Namespace scopeNamespace =
        Namespace.newBuilder()
            .setName(
                NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(NamespaceLifecycleState.newBuilder().build())
            .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Namespace actualResponse = client.updateScopeNamespaceAsync(scopeNamespace, updateMask).get();
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
  public void updateScopeNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Namespace scopeNamespace =
          Namespace.newBuilder()
              .setName(
                  NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setState(NamespaceLifecycleState.newBuilder().build())
              .setScope(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
              .putAllNamespaceLabels(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScopeNamespaceAsync(scopeNamespace, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeNamespaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeNamespaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");

    client.deleteScopeNamespaceAsync(name).get();

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
  public void deleteScopeNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");
      client.deleteScopeNamespaceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeNamespaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeNamespaceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7315/locations/location-7315/scopes/scope-7315/namespaces/namespace-7315";

    client.deleteScopeNamespaceAsync(name).get();

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
  public void deleteScopeNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7315/locations/location-7315/scopes/scope-7315/namespaces/namespace-7315";
      client.deleteScopeNamespaceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listScopeNamespacesTest() throws Exception {
    Namespace responsesElement = Namespace.newBuilder().build();
    ListScopeNamespacesResponse expectedResponse =
        ListScopeNamespacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopeNamespaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    ListScopeNamespacesPagedResponse pagedListResponse = client.listScopeNamespaces(parent);

    List<Namespace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopeNamespacesList().get(0), resources.get(0));

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
  public void listScopeNamespacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.listScopeNamespaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScopeNamespacesTest2() throws Exception {
    Namespace responsesElement = Namespace.newBuilder().build();
    ListScopeNamespacesResponse expectedResponse =
        ListScopeNamespacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopeNamespaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";

    ListScopeNamespacesPagedResponse pagedListResponse = client.listScopeNamespaces(parent);

    List<Namespace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopeNamespacesList().get(0), resources.get(0));

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
  public void listScopeNamespacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
      client.listScopeNamespaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    RBACRoleBindingName name =
        RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
            "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");

    RBACRoleBinding actualResponse = client.getScopeRBACRoleBinding(name);
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
  public void getScopeRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBindingName name =
          RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
              "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");
      client.getScopeRBACRoleBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeRBACRoleBindingTest2() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9375/locations/location-9375/scopes/scope-9375/rbacrolebindings/rbacrolebinding-9375";

    RBACRoleBinding actualResponse = client.getScopeRBACRoleBinding(name);
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
  public void getScopeRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9375/locations/location-9375/scopes/scope-9375/rbacrolebindings/rbacrolebinding-9375";
      client.getScopeRBACRoleBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScopeRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
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
  public void createScopeRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createScopeRBACRoleBindingTest2() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
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
  public void createScopeRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createScopeRBACRoleBindingTest3() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
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
  public void createScopeRBACRoleBindingExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateScopeRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RBACRoleBinding rbacrolebinding =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RBACRoleBinding actualResponse =
        client.updateScopeRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
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
  public void updateScopeRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBinding rbacrolebinding =
          RBACRoleBinding.newBuilder()
              .setName(
                  RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                          "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                      .toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setState(RBACRoleBindingLifecycleState.newBuilder().build())
              .setRole(RBACRoleBinding.Role.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScopeRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeRBACRoleBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RBACRoleBindingName name =
        RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
            "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");

    client.deleteScopeRBACRoleBindingAsync(name).get();

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
  public void deleteScopeRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBindingName name =
          RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
              "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");
      client.deleteScopeRBACRoleBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeRBACRoleBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9375/locations/location-9375/scopes/scope-9375/rbacrolebindings/rbacrolebinding-9375";

    client.deleteScopeRBACRoleBindingAsync(name).get();

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
  public void deleteScopeRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9375/locations/location-9375/scopes/scope-9375/rbacrolebindings/rbacrolebinding-9375";
      client.deleteScopeRBACRoleBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listScopeRBACRoleBindingsTest() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListScopeRBACRoleBindingsResponse expectedResponse =
        ListScopeRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    ListScopeRBACRoleBindingsPagedResponse pagedListResponse =
        client.listScopeRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listScopeRBACRoleBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.listScopeRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScopeRBACRoleBindingsTest2() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListScopeRBACRoleBindingsResponse expectedResponse =
        ListScopeRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    ListScopeRBACRoleBindingsPagedResponse pagedListResponse =
        client.listScopeRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listScopeRBACRoleBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.listScopeRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScopeRBACRoleBindingsTest3() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListScopeRBACRoleBindingsResponse expectedResponse =
        ListScopeRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";

    ListScopeRBACRoleBindingsPagedResponse pagedListResponse =
        client.listScopeRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listScopeRBACRoleBindingsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6912/locations/location-6912/scopes/scope-6912";
      client.listScopeRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    Scope actualResponse = client.getScope(name);
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
  public void getScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.getScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeTest2() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";

    Scope actualResponse = client.getScope(name);
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
  public void getScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";
      client.getScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Scope scope = Scope.newBuilder().build();
    String scopeId = "scopeId1923941007";

    Scope actualResponse = client.createScopeAsync(parent, scope, scopeId).get();
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
  public void createScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Scope scope = Scope.newBuilder().build();
      String scopeId = "scopeId1923941007";
      client.createScopeAsync(parent, scope, scopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createScopeTest2() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Scope scope = Scope.newBuilder().build();
    String scopeId = "scopeId1923941007";

    Scope actualResponse = client.createScopeAsync(parent, scope, scopeId).get();
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
  public void createScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Scope scope = Scope.newBuilder().build();
      String scopeId = "scopeId1923941007";
      client.createScopeAsync(parent, scope, scopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Scope scope =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(ScopeLifecycleState.newBuilder().build())
            .putAllNamespaceLabels(new HashMap<String, String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Scope actualResponse = client.updateScopeAsync(scope, updateMask).get();
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
  public void updateScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Scope scope =
          Scope.newBuilder()
              .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setState(ScopeLifecycleState.newBuilder().build())
              .putAllNamespaceLabels(new HashMap<String, String>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScopeAsync(scope, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    client.deleteScopeAsync(name).get();

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
  public void deleteScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.deleteScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";

    client.deleteScopeAsync(name).get();

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
  public void deleteScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";
      client.deleteScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listScopesTest() throws Exception {
    Scope responsesElement = Scope.newBuilder().build();
    ListScopesResponse expectedResponse =
        ListScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListScopesPagedResponse pagedListResponse = client.listScopes(parent);

    List<Scope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopesList().get(0), resources.get(0));

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
  public void listScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listScopesTest2() throws Exception {
    Scope responsesElement = Scope.newBuilder().build();
    ListScopesResponse expectedResponse =
        ListScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListScopesPagedResponse pagedListResponse = client.listScopes(parent);

    List<Scope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopesList().get(0), resources.get(0));

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
  public void listScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPermittedScopesTest() throws Exception {
    Scope responsesElement = Scope.newBuilder().build();
    ListPermittedScopesResponse expectedResponse =
        ListPermittedScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPermittedScopesPagedResponse pagedListResponse = client.listPermittedScopes(parent);

    List<Scope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopesList().get(0), resources.get(0));

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
  public void listPermittedScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPermittedScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPermittedScopesTest2() throws Exception {
    Scope responsesElement = Scope.newBuilder().build();
    ListPermittedScopesResponse expectedResponse =
        ListPermittedScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllScopes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPermittedScopesPagedResponse pagedListResponse = client.listPermittedScopes(parent);

    List<Scope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScopesList().get(0), resources.get(0));

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
  public void listPermittedScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPermittedScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipBindingTest() throws Exception {
    MembershipBinding expectedResponse =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    MembershipBindingName name =
        MembershipBindingName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");

    MembershipBinding actualResponse = client.getMembershipBinding(name);
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
  public void getMembershipBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipBindingName name =
          MembershipBindingName.of(
              "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");
      client.getMembershipBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipBindingTest2() throws Exception {
    MembershipBinding expectedResponse =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8571/locations/location-8571/memberships/membership-8571/bindings/binding-8571";

    MembershipBinding actualResponse = client.getMembershipBinding(name);
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
  public void getMembershipBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8571/locations/location-8571/memberships/membership-8571/bindings/binding-8571";
      client.getMembershipBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMembershipBindingTest() throws Exception {
    MembershipBinding expectedResponse =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
    MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
    String membershipBindingId = "membershipBindingId1360802634";

    MembershipBinding actualResponse =
        client.createMembershipBindingAsync(parent, membershipBinding, membershipBindingId).get();
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
  public void createMembershipBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
      String membershipBindingId = "membershipBindingId1360802634";
      client.createMembershipBindingAsync(parent, membershipBinding, membershipBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMembershipBindingTest2() throws Exception {
    MembershipBinding expectedResponse =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
    MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
    String membershipBindingId = "membershipBindingId1360802634";

    MembershipBinding actualResponse =
        client.createMembershipBindingAsync(parent, membershipBinding, membershipBindingId).get();
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
  public void createMembershipBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
      MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
      String membershipBindingId = "membershipBindingId1360802634";
      client.createMembershipBindingAsync(parent, membershipBinding, membershipBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateMembershipBindingTest() throws Exception {
    MembershipBinding expectedResponse =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMembershipBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipBinding membershipBinding =
        MembershipBinding.newBuilder()
            .setName(
                MembershipBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(MembershipBindingLifecycleState.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MembershipBinding actualResponse =
        client.updateMembershipBindingAsync(membershipBinding, updateMask).get();
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
  public void updateMembershipBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipBinding membershipBinding =
          MembershipBinding.newBuilder()
              .setName(
                  MembershipBindingName.of(
                          "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
                      .toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setState(MembershipBindingLifecycleState.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembershipBindingAsync(membershipBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMembershipBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMembershipBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipBindingName name =
        MembershipBindingName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");

    client.deleteMembershipBindingAsync(name).get();

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
  public void deleteMembershipBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipBindingName name =
          MembershipBindingName.of(
              "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");
      client.deleteMembershipBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMembershipBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMembershipBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8571/locations/location-8571/memberships/membership-8571/bindings/binding-8571";

    client.deleteMembershipBindingAsync(name).get();

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
  public void deleteMembershipBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8571/locations/location-8571/memberships/membership-8571/bindings/binding-8571";
      client.deleteMembershipBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listMembershipBindingsTest() throws Exception {
    MembershipBinding responsesElement = MembershipBinding.newBuilder().build();
    ListMembershipBindingsResponse expectedResponse =
        ListMembershipBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembershipBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    ListMembershipBindingsPagedResponse pagedListResponse = client.listMembershipBindings(parent);

    List<MembershipBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipBindingsList().get(0), resources.get(0));

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
  public void listMembershipBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.listMembershipBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipBindingsTest2() throws Exception {
    MembershipBinding responsesElement = MembershipBinding.newBuilder().build();
    ListMembershipBindingsResponse expectedResponse =
        ListMembershipBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembershipBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";

    ListMembershipBindingsPagedResponse pagedListResponse = client.listMembershipBindings(parent);

    List<MembershipBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipBindingsList().get(0), resources.get(0));

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
  public void listMembershipBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
      client.listMembershipBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    RBACRoleBindingName name =
        RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
            "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");

    RBACRoleBinding actualResponse = client.getMembershipRBACRoleBinding(name);
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
  public void getMembershipRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBindingName name =
          RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
              "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");
      client.getMembershipRBACRoleBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipRBACRoleBindingTest2() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8531/locations/location-8531/memberships/membership-8531/rbacrolebindings/rbacrolebinding-8531";

    RBACRoleBinding actualResponse = client.getMembershipRBACRoleBinding(name);
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
  public void getMembershipRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8531/locations/location-8531/memberships/membership-8531/rbacrolebindings/rbacrolebinding-8531";
      client.getMembershipRBACRoleBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMembershipRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client
            .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
            .get();
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
  public void createMembershipRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMembershipRBACRoleBindingTest2() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client
            .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
            .get();
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
  public void createMembershipRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMembershipRBACRoleBindingTest3() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
    RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
    String rbacrolebindingId = "rbacrolebindingId827577784";

    RBACRoleBinding actualResponse =
        client
            .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
            .get();
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
  public void createMembershipRBACRoleBindingExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
      RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
      String rbacrolebindingId = "rbacrolebindingId827577784";
      client.createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateMembershipRBACRoleBindingTest() throws Exception {
    RBACRoleBinding expectedResponse =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RBACRoleBinding rbacrolebinding =
        RBACRoleBinding.newBuilder()
            .setName(
                RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
                        "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setState(RBACRoleBindingLifecycleState.newBuilder().build())
            .setRole(RBACRoleBinding.Role.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RBACRoleBinding actualResponse =
        client.updateMembershipRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
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
  public void updateMembershipRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBinding rbacrolebinding =
          RBACRoleBinding.newBuilder()
              .setName(
                  RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
                          "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
                      .toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setState(RBACRoleBindingLifecycleState.newBuilder().build())
              .setRole(RBACRoleBinding.Role.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembershipRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMembershipRBACRoleBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RBACRoleBindingName name =
        RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
            "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");

    client.deleteMembershipRBACRoleBindingAsync(name).get();

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
  public void deleteMembershipRBACRoleBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RBACRoleBindingName name =
          RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
              "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");
      client.deleteMembershipRBACRoleBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMembershipRBACRoleBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMembershipRBACRoleBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8531/locations/location-8531/memberships/membership-8531/rbacrolebindings/rbacrolebinding-8531";

    client.deleteMembershipRBACRoleBindingAsync(name).get();

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
  public void deleteMembershipRBACRoleBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8531/locations/location-8531/memberships/membership-8531/rbacrolebindings/rbacrolebinding-8531";
      client.deleteMembershipRBACRoleBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listMembershipRBACRoleBindingsTest() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListMembershipRBACRoleBindingsResponse expectedResponse =
        ListMembershipRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");

    ListMembershipRBACRoleBindingsPagedResponse pagedListResponse =
        client.listMembershipRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listMembershipRBACRoleBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
      client.listMembershipRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipRBACRoleBindingsTest2() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListMembershipRBACRoleBindingsResponse expectedResponse =
        ListMembershipRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    ListMembershipRBACRoleBindingsPagedResponse pagedListResponse =
        client.listMembershipRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listMembershipRBACRoleBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.listMembershipRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipRBACRoleBindingsTest3() throws Exception {
    RBACRoleBinding responsesElement = RBACRoleBinding.newBuilder().build();
    ListMembershipRBACRoleBindingsResponse expectedResponse =
        ListMembershipRBACRoleBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRbacrolebindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";

    ListMembershipRBACRoleBindingsPagedResponse pagedListResponse =
        client.listMembershipRBACRoleBindings(parent);

    List<RBACRoleBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRbacrolebindingsList().get(0), resources.get(0));

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
  public void listMembershipRBACRoleBindingsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9966/locations/location-9966/memberships/membership-9966";
      client.listMembershipRBACRoleBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateMembershipRBACRoleBindingYAMLTest() throws Exception {
    GenerateMembershipRBACRoleBindingYAMLResponse expectedResponse =
        GenerateMembershipRBACRoleBindingYAMLResponse.newBuilder()
            .setRoleBindingsYaml("roleBindingsYaml-926355989")
            .build();
    mockService.addResponse(expectedResponse);

    GenerateMembershipRBACRoleBindingYAMLRequest request =
        GenerateMembershipRBACRoleBindingYAMLRequest.newBuilder()
            .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
            .setRbacrolebindingId("rbacrolebindingId827577784")
            .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
            .build();

    GenerateMembershipRBACRoleBindingYAMLResponse actualResponse =
        client.generateMembershipRBACRoleBindingYAML(request);
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
  public void generateMembershipRBACRoleBindingYAMLExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateMembershipRBACRoleBindingYAMLRequest request =
          GenerateMembershipRBACRoleBindingYAMLRequest.newBuilder()
              .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
              .setRbacrolebindingId("rbacrolebindingId827577784")
              .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
              .build();
      client.generateMembershipRBACRoleBindingYAML(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
