/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.securityposture.v1;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.stub.HttpJsonSecurityPostureStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
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
public class SecurityPostureClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SecurityPostureClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSecurityPostureStub.getMethodDescriptors(),
            SecurityPostureSettings.getDefaultEndpoint());
    SecurityPostureSettings settings =
        SecurityPostureSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SecurityPostureSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityPostureClient.create(settings);
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
  public void listPosturesTest() throws Exception {
    Posture responsesElement = Posture.newBuilder().build();
    ListPosturesResponse expectedResponse =
        ListPosturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostures(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPosturesPagedResponse pagedListResponse = client.listPostures(parent);

    List<Posture> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPosturesList().get(0), resources.get(0));

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
  public void listPosturesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPostures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPosturesTest2() throws Exception {
    Posture responsesElement = Posture.newBuilder().build();
    ListPosturesResponse expectedResponse =
        ListPosturesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostures(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListPosturesPagedResponse pagedListResponse = client.listPostures(parent);

    List<Posture> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPosturesList().get(0), resources.get(0));

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
  public void listPosturesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listPostures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPostureRevisionsTest() throws Exception {
    Posture responsesElement = Posture.newBuilder().build();
    ListPostureRevisionsResponse expectedResponse =
        ListPostureRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListPostureRevisionsRequest request =
        ListPostureRevisionsRequest.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListPostureRevisionsPagedResponse pagedListResponse = client.listPostureRevisions(request);

    List<Posture> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRevisionsList().get(0), resources.get(0));

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
  public void listPostureRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListPostureRevisionsRequest request =
          ListPostureRevisionsRequest.newBuilder()
              .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listPostureRevisions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureTest() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    mockService.addResponse(expectedResponse);

    PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");

    Posture actualResponse = client.getPosture(name);
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
  public void getPostureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");
      client.getPosture(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureTest2() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-7771/locations/location-7771/postures/posture-7771";

    Posture actualResponse = client.getPosture(name);
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
  public void getPostureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-7771/locations/location-7771/postures/posture-7771";
      client.getPosture(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPostureTest() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
    Posture posture = Posture.newBuilder().build();
    String postureId = "postureId2023219203";

    Posture actualResponse = client.createPostureAsync(parent, posture, postureId).get();
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
  public void createPostureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      Posture posture = Posture.newBuilder().build();
      String postureId = "postureId2023219203";
      client.createPostureAsync(parent, posture, postureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPostureTest2() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    Posture posture = Posture.newBuilder().build();
    String postureId = "postureId2023219203";

    Posture actualResponse = client.createPostureAsync(parent, posture, postureId).get();
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
  public void createPostureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      Posture posture = Posture.newBuilder().build();
      String postureId = "postureId2023219203";
      client.createPostureAsync(parent, posture, postureId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePostureTest() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Posture posture =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Posture actualResponse = client.updatePostureAsync(posture, updateMask).get();
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
  public void updatePostureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Posture posture =
          Posture.newBuilder()
              .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
              .setRevisionId("revisionId-1507445162")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .addAllPolicySets(new ArrayList<PolicySet>())
              .setEtag("etag3123477")
              .putAllAnnotations(new HashMap<String, String>())
              .setReconciling(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePostureAsync(posture, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePostureTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");

    client.deletePostureAsync(name).get();

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
  public void deletePostureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");
      client.deletePostureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePostureTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "organizations/organization-7771/locations/location-7771/postures/posture-7771";

    client.deletePostureAsync(name).get();

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
  public void deletePostureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-7771/locations/location-7771/postures/posture-7771";
      client.deletePostureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void extractPostureTest() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("extractPostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
    String postureId = "postureId2023219203";
    String workload = "workload35560311";

    Posture actualResponse = client.extractPostureAsync(parent, postureId, workload).get();
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
  public void extractPostureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      String postureId = "postureId2023219203";
      String workload = "workload35560311";
      client.extractPostureAsync(parent, postureId, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void extractPostureTest2() throws Exception {
    Posture expectedResponse =
        Posture.newBuilder()
            .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("extractPostureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    String postureId = "postureId2023219203";
    String workload = "workload35560311";

    Posture actualResponse = client.extractPostureAsync(parent, postureId, workload).get();
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
  public void extractPostureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      String postureId = "postureId2023219203";
      String workload = "workload35560311";
      client.extractPostureAsync(parent, postureId, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listPostureDeploymentsTest() throws Exception {
    PostureDeployment responsesElement = PostureDeployment.newBuilder().build();
    ListPostureDeploymentsResponse expectedResponse =
        ListPostureDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostureDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPostureDeploymentsPagedResponse pagedListResponse = client.listPostureDeployments(parent);

    List<PostureDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPostureDeploymentsList().get(0), resources.get(0));

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
  public void listPostureDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPostureDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPostureDeploymentsTest2() throws Exception {
    PostureDeployment responsesElement = PostureDeployment.newBuilder().build();
    ListPostureDeploymentsResponse expectedResponse =
        ListPostureDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostureDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListPostureDeploymentsPagedResponse pagedListResponse = client.listPostureDeployments(parent);

    List<PostureDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPostureDeploymentsList().get(0), resources.get(0));

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
  public void listPostureDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listPostureDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureDeploymentTest() throws Exception {
    PostureDeployment expectedResponse =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    mockService.addResponse(expectedResponse);

    PostureDeploymentName name =
        PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");

    PostureDeployment actualResponse = client.getPostureDeployment(name);
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
  public void getPostureDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureDeploymentName name =
          PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");
      client.getPostureDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureDeploymentTest2() throws Exception {
    PostureDeployment expectedResponse =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-1322/locations/location-1322/postureDeployments/postureDeployment-1322";

    PostureDeployment actualResponse = client.getPostureDeployment(name);
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
  public void getPostureDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-1322/locations/location-1322/postureDeployments/postureDeployment-1322";
      client.getPostureDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPostureDeploymentTest() throws Exception {
    PostureDeployment expectedResponse =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPostureDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
    PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
    String postureDeploymentId = "postureDeploymentId1771206568";

    PostureDeployment actualResponse =
        client.createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId).get();
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
  public void createPostureDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
      String postureDeploymentId = "postureDeploymentId1771206568";
      client.createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPostureDeploymentTest2() throws Exception {
    PostureDeployment expectedResponse =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPostureDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
    String postureDeploymentId = "postureDeploymentId1771206568";

    PostureDeployment actualResponse =
        client.createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId).get();
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
  public void createPostureDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
      String postureDeploymentId = "postureDeploymentId1771206568";
      client.createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePostureDeploymentTest() throws Exception {
    PostureDeployment expectedResponse =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePostureDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PostureDeployment postureDeployment =
        PostureDeployment.newBuilder()
            .setName(
                PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                    .toString())
            .setTargetResource("targetResource-1933150017")
            .setPostureId("postureId2023219203")
            .setPostureRevisionId("postureRevisionId416325950")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setDesiredPostureId("desiredPostureId1660628617")
            .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
            .setFailureMessage("failureMessage-1704954083")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PostureDeployment actualResponse =
        client.updatePostureDeploymentAsync(postureDeployment, updateMask).get();
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
  public void updatePostureDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureDeployment postureDeployment =
          PostureDeployment.newBuilder()
              .setName(
                  PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
                      .toString())
              .setTargetResource("targetResource-1933150017")
              .setPostureId("postureId2023219203")
              .setPostureRevisionId("postureRevisionId416325950")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setEtag("etag3123477")
              .putAllAnnotations(new HashMap<String, String>())
              .setReconciling(true)
              .setDesiredPostureId("desiredPostureId1660628617")
              .setDesiredPostureRevisionId("desiredPostureRevisionId1708657092")
              .setFailureMessage("failureMessage-1704954083")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePostureDeploymentAsync(postureDeployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePostureDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePostureDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PostureDeploymentName name =
        PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");

    client.deletePostureDeploymentAsync(name).get();

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
  public void deletePostureDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureDeploymentName name =
          PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");
      client.deletePostureDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePostureDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePostureDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "organizations/organization-1322/locations/location-1322/postureDeployments/postureDeployment-1322";

    client.deletePostureDeploymentAsync(name).get();

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
  public void deletePostureDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-1322/locations/location-1322/postureDeployments/postureDeployment-1322";
      client.deletePostureDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listPostureTemplatesTest() throws Exception {
    PostureTemplate responsesElement = PostureTemplate.newBuilder().build();
    ListPostureTemplatesResponse expectedResponse =
        ListPostureTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostureTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");

    ListPostureTemplatesPagedResponse pagedListResponse = client.listPostureTemplates(parent);

    List<PostureTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPostureTemplatesList().get(0), resources.get(0));

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
  public void listPostureTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listPostureTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPostureTemplatesTest2() throws Exception {
    PostureTemplate responsesElement = PostureTemplate.newBuilder().build();
    ListPostureTemplatesResponse expectedResponse =
        ListPostureTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPostureTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListPostureTemplatesPagedResponse pagedListResponse = client.listPostureTemplates(parent);

    List<PostureTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPostureTemplatesList().get(0), resources.get(0));

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
  public void listPostureTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listPostureTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureTemplateTest() throws Exception {
    PostureTemplate expectedResponse =
        PostureTemplate.newBuilder()
            .setName(
                PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .build();
    mockService.addResponse(expectedResponse);

    PostureTemplateName name =
        PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]");

    PostureTemplate actualResponse = client.getPostureTemplate(name);
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
  public void getPostureTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PostureTemplateName name =
          PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]");
      client.getPostureTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPostureTemplateTest2() throws Exception {
    PostureTemplate expectedResponse =
        PostureTemplate.newBuilder()
            .setName(
                PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setDescription("description-1724546052")
            .addAllPolicySets(new ArrayList<PolicySet>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-3681/locations/location-3681/postureTemplates/postureTemplate-3681";

    PostureTemplate actualResponse = client.getPostureTemplate(name);
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
  public void getPostureTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-3681/locations/location-3681/postureTemplates/postureTemplate-3681";
      client.getPostureTemplate(name);
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
            .setName("organizations/organization-1936")
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
              .setName("organizations/organization-1936")
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
            .setName("organizations/organization-7066/locations/location-7066")
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
              .setName("organizations/organization-7066/locations/location-7066")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
