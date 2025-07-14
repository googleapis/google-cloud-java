/*
 * Copyright 2025 Google LLC
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

package com.google.iam.v3;

import static com.google.iam.v3.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.iam.v3.stub.HttpJsonPrincipalAccessBoundaryPoliciesStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class PrincipalAccessBoundaryPoliciesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PrincipalAccessBoundaryPoliciesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPrincipalAccessBoundaryPoliciesStub.getMethodDescriptors(),
            PrincipalAccessBoundaryPoliciesSettings.getDefaultEndpoint());
    PrincipalAccessBoundaryPoliciesSettings settings =
        PrincipalAccessBoundaryPoliciesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PrincipalAccessBoundaryPoliciesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrincipalAccessBoundaryPoliciesClient.create(settings);
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
  public void createPrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .createPrincipalAccessBoundaryPolicyAsync(
                parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
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
  public void createPrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder().build();
      String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
      client
          .createPrincipalAccessBoundaryPolicyAsync(
              parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPrincipalAccessBoundaryPolicyTest2() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .createPrincipalAccessBoundaryPolicyAsync(
                parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
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
  public void createPrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder().build();
      String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
      client
          .createPrincipalAccessBoundaryPolicyAsync(
              parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    PrincipalAccessBoundaryPolicy actualResponse = client.getPrincipalAccessBoundaryPolicy(name);
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
  public void getPrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.getPrincipalAccessBoundaryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrincipalAccessBoundaryPolicyTest2() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";

    PrincipalAccessBoundaryPolicy actualResponse = client.getPrincipalAccessBoundaryPolicy(name);
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
  public void getPrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";
      client.getPrincipalAccessBoundaryPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrincipalAccessBoundaryPolicyTest() throws Exception {
    PrincipalAccessBoundaryPolicy expectedResponse =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
        PrincipalAccessBoundaryPolicy.newBuilder()
            .setName(
                PrincipalAccessBoundaryPolicyName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrincipalAccessBoundaryPolicy actualResponse =
        client
            .updatePrincipalAccessBoundaryPolicyAsync(principalAccessBoundaryPolicy, updateMask)
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
  public void updatePrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
          PrincipalAccessBoundaryPolicy.newBuilder()
              .setName(
                  PrincipalAccessBoundaryPolicyName.of(
                          "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
                      .toString())
              .setUid("uid115792")
              .setEtag("etag3123477")
              .setDisplayName("displayName1714148973")
              .putAllAnnotations(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDetails(PrincipalAccessBoundaryPolicyDetails.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client
          .updatePrincipalAccessBoundaryPolicyAsync(principalAccessBoundaryPolicy, updateMask)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    client.deletePrincipalAccessBoundaryPolicyAsync(name).get();

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
  public void deletePrincipalAccessBoundaryPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.deletePrincipalAccessBoundaryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePrincipalAccessBoundaryPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrincipalAccessBoundaryPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";

    client.deletePrincipalAccessBoundaryPolicyAsync(name).get();

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
  public void deletePrincipalAccessBoundaryPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";
      client.deletePrincipalAccessBoundaryPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesTest() throws Exception {
    PrincipalAccessBoundaryPolicy responsesElement =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    ListPrincipalAccessBoundaryPoliciesResponse expectedResponse =
        ListPrincipalAccessBoundaryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrincipalAccessBoundaryPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPrincipalAccessBoundaryPoliciesPagedResponse pagedListResponse =
        client.listPrincipalAccessBoundaryPolicies(parent);

    List<PrincipalAccessBoundaryPolicy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPrincipalAccessBoundaryPoliciesList().get(0), resources.get(0));

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
  public void listPrincipalAccessBoundaryPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPrincipalAccessBoundaryPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrincipalAccessBoundaryPoliciesTest2() throws Exception {
    PrincipalAccessBoundaryPolicy responsesElement =
        PrincipalAccessBoundaryPolicy.newBuilder().build();
    ListPrincipalAccessBoundaryPoliciesResponse expectedResponse =
        ListPrincipalAccessBoundaryPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrincipalAccessBoundaryPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListPrincipalAccessBoundaryPoliciesPagedResponse pagedListResponse =
        client.listPrincipalAccessBoundaryPolicies(parent);

    List<PrincipalAccessBoundaryPolicy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPrincipalAccessBoundaryPoliciesList().get(0), resources.get(0));

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
  public void listPrincipalAccessBoundaryPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listPrincipalAccessBoundaryPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchPrincipalAccessBoundaryPolicyBindingsResponse expectedResponse =
        SearchPrincipalAccessBoundaryPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PrincipalAccessBoundaryPolicyName name =
        PrincipalAccessBoundaryPolicyName.of(
            "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");

    SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse pagedListResponse =
        client.searchPrincipalAccessBoundaryPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

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
  public void searchPrincipalAccessBoundaryPolicyBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrincipalAccessBoundaryPolicyName name =
          PrincipalAccessBoundaryPolicyName.of(
              "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
      client.searchPrincipalAccessBoundaryPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPrincipalAccessBoundaryPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchPrincipalAccessBoundaryPolicyBindingsResponse expectedResponse =
        SearchPrincipalAccessBoundaryPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";

    SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse pagedListResponse =
        client.searchPrincipalAccessBoundaryPolicyBindings(name);

    List<PolicyBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyBindingsList().get(0), resources.get(0));

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
  public void searchPrincipalAccessBoundaryPolicyBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2178/locations/location-2178/principalAccessBoundaryPolicies/principalAccessBoundaryPolicie-2178";
      client.searchPrincipalAccessBoundaryPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
