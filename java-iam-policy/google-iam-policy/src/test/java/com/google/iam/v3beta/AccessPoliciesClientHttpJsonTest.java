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

package com.google.iam.v3beta;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

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
import com.google.iam.v3beta.stub.HttpJsonAccessPoliciesStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class AccessPoliciesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccessPoliciesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccessPoliciesStub.getMethodDescriptors(),
            AccessPoliciesSettings.getDefaultEndpoint());
    AccessPoliciesSettings settings =
        AccessPoliciesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccessPoliciesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccessPoliciesClient.create(settings);
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
  public void createAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
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
  public void createAccessPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAccessPolicyTest2() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
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
  public void createAccessPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAccessPolicyTest3() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
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
  public void createAccessPolicyExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAccessPolicyTest4() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofOrganizationLocationAccessPolicyName(
                        "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
    String accessPolicyId = "accessPolicyId97623921";

    AccessPolicy actualResponse =
        client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
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
  public void createAccessPolicyExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
      String accessPolicyId = "accessPolicyId97623921";
      client.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccessPolicyName name =
        AccessPolicyName.ofProjectLocationAccessPolicyName(
            "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");

    AccessPolicy actualResponse = client.getAccessPolicy(name);
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
  public void getAccessPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofProjectLocationAccessPolicyName(
              "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
      client.getAccessPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessPolicyTest2() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5052/locations/location-5052/accessPolicies/accessPolicie-5052";

    AccessPolicy actualResponse = client.getAccessPolicy(name);
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
  public void getAccessPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5052/locations/location-5052/accessPolicies/accessPolicie-5052";
      client.getAccessPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccessPolicyTest() throws Exception {
    AccessPolicy expectedResponse =
        AccessPolicy.newBuilder()
            .setName(
                AccessPolicyName.ofProjectLocationAccessPolicyName(
                        "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                    .toString())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDetails(AccessPolicyDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateAccessPolicyRequest request =
        UpdateAccessPolicyRequest.newBuilder()
            .setAccessPolicy(
                AccessPolicy.newBuilder()
                    .setName(
                        AccessPolicyName.ofProjectLocationAccessPolicyName(
                                "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                            .toString())
                    .setUid("uid115792")
                    .setEtag("etag3123477")
                    .setDisplayName("displayName1714148973")
                    .putAllAnnotations(new HashMap<String, String>())
                    .setCreateTime(Timestamp.newBuilder().build())
                    .setUpdateTime(Timestamp.newBuilder().build())
                    .setDetails(AccessPolicyDetails.newBuilder().build())
                    .build())
            .setValidateOnly(true)
            .build();

    AccessPolicy actualResponse = client.updateAccessPolicyAsync(request).get();
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
  public void updateAccessPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateAccessPolicyRequest request =
          UpdateAccessPolicyRequest.newBuilder()
              .setAccessPolicy(
                  AccessPolicy.newBuilder()
                      .setName(
                          AccessPolicyName.ofProjectLocationAccessPolicyName(
                                  "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
                              .toString())
                      .setUid("uid115792")
                      .setEtag("etag3123477")
                      .setDisplayName("displayName1714148973")
                      .putAllAnnotations(new HashMap<String, String>())
                      .setCreateTime(Timestamp.newBuilder().build())
                      .setUpdateTime(Timestamp.newBuilder().build())
                      .setDetails(AccessPolicyDetails.newBuilder().build())
                      .build())
              .setValidateOnly(true)
              .build();
      client.updateAccessPolicyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAccessPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AccessPolicyName name =
        AccessPolicyName.ofProjectLocationAccessPolicyName(
            "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");

    client.deleteAccessPolicyAsync(name).get();

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
  public void deleteAccessPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofProjectLocationAccessPolicyName(
              "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
      client.deleteAccessPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAccessPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAccessPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-5052/locations/location-5052/accessPolicies/accessPolicie-5052";

    client.deleteAccessPolicyAsync(name).get();

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
  public void deleteAccessPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5052/locations/location-5052/accessPolicies/accessPolicie-5052";
      client.deleteAccessPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listAccessPoliciesTest() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

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
  public void listAccessPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest2() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

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
  public void listAccessPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest3() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

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
  public void listAccessPoliciesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessPoliciesTest4() throws Exception {
    AccessPolicy responsesElement = AccessPolicy.newBuilder().build();
    ListAccessPoliciesResponse expectedResponse =
        ListAccessPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAccessPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAccessPoliciesPagedResponse pagedListResponse = client.listAccessPolicies(parent);

    List<AccessPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAccessPoliciesList().get(0), resources.get(0));

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
  public void listAccessPoliciesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAccessPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAccessPolicyBindingsTest() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchAccessPolicyBindingsResponse expectedResponse =
        SearchAccessPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccessPolicyName name =
        AccessPolicyName.ofOrganizationLocationAccessPolicyName(
            "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]");

    SearchAccessPolicyBindingsPagedResponse pagedListResponse =
        client.searchAccessPolicyBindings(name);

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
  public void searchAccessPolicyBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessPolicyName name =
          AccessPolicyName.ofOrganizationLocationAccessPolicyName(
              "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]");
      client.searchAccessPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAccessPolicyBindingsTest2() throws Exception {
    PolicyBinding responsesElement = PolicyBinding.newBuilder().build();
    SearchAccessPolicyBindingsResponse expectedResponse =
        SearchAccessPolicyBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-9476/locations/location-9476/accessPolicies/accessPolicie-9476";

    SearchAccessPolicyBindingsPagedResponse pagedListResponse =
        client.searchAccessPolicyBindings(name);

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
  public void searchAccessPolicyBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-9476/locations/location-9476/accessPolicies/accessPolicie-9476";
      client.searchAccessPolicyBindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
