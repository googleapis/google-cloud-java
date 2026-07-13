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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonFindingsRefinementServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class FindingsRefinementServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FindingsRefinementServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFindingsRefinementServiceStub.getMethodDescriptors(),
            FindingsRefinementServiceSettings.getDefaultEndpoint());
    FindingsRefinementServiceSettings settings =
        FindingsRefinementServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FindingsRefinementServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FindingsRefinementServiceClient.create(settings);
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
  public void getFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockService.addResponse(expectedResponse);

    FindingsRefinementName name =
        FindingsRefinementName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    FindingsRefinement actualResponse = client.getFindingsRefinement(name);
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
  public void getFindingsRefinementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingsRefinementName name =
          FindingsRefinementName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.getFindingsRefinement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementTest2() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7346/locations/location-7346/instances/instance-7346/findingsRefinements/findingsRefinement-7346";

    FindingsRefinement actualResponse = client.getFindingsRefinement(name);
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
  public void getFindingsRefinementExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7346/locations/location-7346/instances/instance-7346/findingsRefinements/findingsRefinement-7346";
      client.getFindingsRefinement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsRefinementsTest() throws Exception {
    FindingsRefinement responsesElement = FindingsRefinement.newBuilder().build();
    ListFindingsRefinementsResponse expectedResponse =
        ListFindingsRefinementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingsRefinements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFindingsRefinementsPagedResponse pagedListResponse = client.listFindingsRefinements(parent);

    List<FindingsRefinement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsRefinementsList().get(0), resources.get(0));

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
  public void listFindingsRefinementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFindingsRefinements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsRefinementsTest2() throws Exception {
    FindingsRefinement responsesElement = FindingsRefinement.newBuilder().build();
    ListFindingsRefinementsResponse expectedResponse =
        ListFindingsRefinementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingsRefinements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListFindingsRefinementsPagedResponse pagedListResponse = client.listFindingsRefinements(parent);

    List<FindingsRefinement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsRefinementsList().get(0), resources.get(0));

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
  public void listFindingsRefinementsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listFindingsRefinements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();

    FindingsRefinement actualResponse = client.createFindingsRefinement(parent, findingsRefinement);
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
  public void createFindingsRefinementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
      client.createFindingsRefinement(parent, findingsRefinement);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingsRefinementTest2() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();

    FindingsRefinement actualResponse = client.createFindingsRefinement(parent, findingsRefinement);
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
  public void createFindingsRefinementExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
      client.createFindingsRefinement(parent, findingsRefinement);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingsRefinementTest() throws Exception {
    FindingsRefinement expectedResponse =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    mockService.addResponse(expectedResponse);

    FindingsRefinement findingsRefinement =
        FindingsRefinement.newBuilder()
            .setName(
                FindingsRefinementName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setType(FindingsRefinementType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuery("query107944136")
            .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FindingsRefinement actualResponse =
        client.updateFindingsRefinement(findingsRefinement, updateMask);
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
  public void updateFindingsRefinementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingsRefinement findingsRefinement =
          FindingsRefinement.newBuilder()
              .setName(
                  FindingsRefinementName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setType(FindingsRefinementType.forNumber(0))
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setQuery("query107944136")
              .addAllOutcomeFilters(new ArrayList<OutcomeFilter>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFindingsRefinement(findingsRefinement, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementDeploymentTest() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FindingsRefinementDeploymentName name =
        FindingsRefinementDeploymentName.of(
            "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    FindingsRefinementDeployment actualResponse = client.getFindingsRefinementDeployment(name);
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
  public void getFindingsRefinementDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingsRefinementDeploymentName name =
          FindingsRefinementDeploymentName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.getFindingsRefinementDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingsRefinementDeploymentTest2() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2806/locations/location-2806/instances/instance-2806/findingsRefinements/findingsRefinement-2806/deployment";

    FindingsRefinementDeployment actualResponse = client.getFindingsRefinementDeployment(name);
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
  public void getFindingsRefinementDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2806/locations/location-2806/instances/instance-2806/findingsRefinements/findingsRefinement-2806/deployment";
      client.getFindingsRefinementDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingsRefinementDeploymentTest() throws Exception {
    FindingsRefinementDeployment expectedResponse =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FindingsRefinementDeployment findingsRefinementDeployment =
        FindingsRefinementDeployment.newBuilder()
            .setName(
                FindingsRefinementDeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                    .toString())
            .setEnabled(true)
            .setArchived(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FindingsRefinementDeployment actualResponse =
        client.updateFindingsRefinementDeployment(findingsRefinementDeployment, updateMask);
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
  public void updateFindingsRefinementDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingsRefinementDeployment findingsRefinementDeployment =
          FindingsRefinementDeployment.newBuilder()
              .setName(
                  FindingsRefinementDeploymentName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
                      .toString())
              .setEnabled(true)
              .setArchived(true)
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFindingsRefinementDeployment(findingsRefinementDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFindingsRefinementDeploymentsTest() throws Exception {
    FindingsRefinementDeployment responsesElement =
        FindingsRefinementDeployment.newBuilder().build();
    ListAllFindingsRefinementDeploymentsResponse expectedResponse =
        ListAllFindingsRefinementDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAllFindingsRefinementDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListAllFindingsRefinementDeploymentsPagedResponse pagedListResponse =
        client.listAllFindingsRefinementDeployments(instance);

    List<FindingsRefinementDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAllFindingsRefinementDeploymentsList().get(0), resources.get(0));

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
  public void listAllFindingsRefinementDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listAllFindingsRefinementDeployments(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFindingsRefinementDeploymentsTest2() throws Exception {
    FindingsRefinementDeployment responsesElement =
        FindingsRefinementDeployment.newBuilder().build();
    ListAllFindingsRefinementDeploymentsResponse expectedResponse =
        ListAllFindingsRefinementDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAllFindingsRefinementDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";

    ListAllFindingsRefinementDeploymentsPagedResponse pagedListResponse =
        client.listAllFindingsRefinementDeployments(instance);

    List<FindingsRefinementDeployment> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAllFindingsRefinementDeploymentsList().get(0), resources.get(0));

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
  public void listAllFindingsRefinementDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
      client.listAllFindingsRefinementDeployments(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeFindingsRefinementActivityTest() throws Exception {
    ComputeFindingsRefinementActivityResponse expectedResponse =
        ComputeFindingsRefinementActivityResponse.newBuilder()
            .setActivity(FindingsRefinementActivity.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FindingsRefinementName name =
        FindingsRefinementName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");

    ComputeFindingsRefinementActivityResponse actualResponse =
        client.computeFindingsRefinementActivity(name);
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
  public void computeFindingsRefinementActivityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingsRefinementName name =
          FindingsRefinementName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
      client.computeFindingsRefinementActivity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeFindingsRefinementActivityTest2() throws Exception {
    ComputeFindingsRefinementActivityResponse expectedResponse =
        ComputeFindingsRefinementActivityResponse.newBuilder()
            .setActivity(FindingsRefinementActivity.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7346/locations/location-7346/instances/instance-7346/findingsRefinements/findingsRefinement-7346";

    ComputeFindingsRefinementActivityResponse actualResponse =
        client.computeFindingsRefinementActivity(name);
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
  public void computeFindingsRefinementActivityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7346/locations/location-7346/instances/instance-7346/findingsRefinements/findingsRefinement-7346";
      client.computeFindingsRefinementActivity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeAllFindingsRefinementActivitiesTest() throws Exception {
    ComputeAllFindingsRefinementActivitiesResponse expectedResponse =
        ComputeAllFindingsRefinementActivitiesResponse.newBuilder()
            .addAllActivities(new ArrayList<FindingsRefinementActivity>())
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ComputeAllFindingsRefinementActivitiesResponse actualResponse =
        client.computeAllFindingsRefinementActivities(instance);
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
  public void computeAllFindingsRefinementActivitiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.computeAllFindingsRefinementActivities(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeAllFindingsRefinementActivitiesTest2() throws Exception {
    ComputeAllFindingsRefinementActivitiesResponse expectedResponse =
        ComputeAllFindingsRefinementActivitiesResponse.newBuilder()
            .addAllActivities(new ArrayList<FindingsRefinementActivity>())
            .build();
    mockService.addResponse(expectedResponse);

    String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";

    ComputeAllFindingsRefinementActivitiesResponse actualResponse =
        client.computeAllFindingsRefinementActivities(instance);
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
  public void computeAllFindingsRefinementActivitiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String instance = "projects/project-2526/locations/location-2526/instances/instance-2526";
      client.computeAllFindingsRefinementActivities(instance);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
