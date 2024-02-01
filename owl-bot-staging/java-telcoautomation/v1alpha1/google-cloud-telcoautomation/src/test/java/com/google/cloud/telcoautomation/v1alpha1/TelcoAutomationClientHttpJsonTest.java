/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.telcoautomation.v1alpha1;

import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListEdgeSlmsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListHydratedDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListLocationsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListOrchestrationClustersPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListPublicBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchDeploymentRevisionsPagedResponse;

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
import com.google.cloud.telcoautomation.v1alpha1.stub.HttpJsonTelcoAutomationStub;
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
public class TelcoAutomationClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TelcoAutomationClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTelcoAutomationStub.getMethodDescriptors(),
            TelcoAutomationSettings.getDefaultEndpoint());
    TelcoAutomationSettings settings =
        TelcoAutomationSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TelcoAutomationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TelcoAutomationClient.create(settings);
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
  public void listOrchestrationClustersTest() throws Exception {
    OrchestrationCluster responsesElement = OrchestrationCluster.newBuilder().build();
    ListOrchestrationClustersResponse expectedResponse =
        ListOrchestrationClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrchestrationClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOrchestrationClustersPagedResponse pagedListResponse =
        client.listOrchestrationClusters(parent);

    List<OrchestrationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrchestrationClustersList().get(0), resources.get(0));

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
  public void listOrchestrationClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listOrchestrationClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrchestrationClustersTest2() throws Exception {
    OrchestrationCluster responsesElement = OrchestrationCluster.newBuilder().build();
    ListOrchestrationClustersResponse expectedResponse =
        ListOrchestrationClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrchestrationClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListOrchestrationClustersPagedResponse pagedListResponse =
        client.listOrchestrationClusters(parent);

    List<OrchestrationCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrchestrationClustersList().get(0), resources.get(0));

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
  public void listOrchestrationClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listOrchestrationClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrchestrationClusterTest() throws Exception {
    OrchestrationCluster expectedResponse =
        OrchestrationCluster.newBuilder()
            .setName(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setManagementConfig(ManagementConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName name =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");

    OrchestrationCluster actualResponse = client.getOrchestrationCluster(name);
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
  public void getOrchestrationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName name =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      client.getOrchestrationCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrchestrationClusterTest2() throws Exception {
    OrchestrationCluster expectedResponse =
        OrchestrationCluster.newBuilder()
            .setName(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setManagementConfig(ManagementConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-768/locations/location-768/orchestrationClusters/orchestrationCluster-768";

    OrchestrationCluster actualResponse = client.getOrchestrationCluster(name);
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
  public void getOrchestrationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-768/locations/location-768/orchestrationClusters/orchestrationCluster-768";
      client.getOrchestrationCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOrchestrationClusterTest() throws Exception {
    OrchestrationCluster expectedResponse =
        OrchestrationCluster.newBuilder()
            .setName(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setManagementConfig(ManagementConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrchestrationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
    String orchestrationClusterId = "orchestrationClusterId75469684";

    OrchestrationCluster actualResponse =
        client
            .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
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
  public void createOrchestrationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
      String orchestrationClusterId = "orchestrationClusterId75469684";
      client
          .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createOrchestrationClusterTest2() throws Exception {
    OrchestrationCluster expectedResponse =
        OrchestrationCluster.newBuilder()
            .setName(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setManagementConfig(ManagementConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrchestrationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
    String orchestrationClusterId = "orchestrationClusterId75469684";

    OrchestrationCluster actualResponse =
        client
            .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
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
  public void createOrchestrationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      OrchestrationCluster orchestrationCluster = OrchestrationCluster.newBuilder().build();
      String orchestrationClusterId = "orchestrationClusterId75469684";
      client
          .createOrchestrationClusterAsync(parent, orchestrationCluster, orchestrationClusterId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteOrchestrationClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOrchestrationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrchestrationClusterName name =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");

    client.deleteOrchestrationClusterAsync(name).get();

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
  public void deleteOrchestrationClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName name =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      client.deleteOrchestrationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteOrchestrationClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOrchestrationClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-768/locations/location-768/orchestrationClusters/orchestrationCluster-768";

    client.deleteOrchestrationClusterAsync(name).get();

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
  public void deleteOrchestrationClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-768/locations/location-768/orchestrationClusters/orchestrationCluster-768";
      client.deleteOrchestrationClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEdgeSlmsTest() throws Exception {
    EdgeSlm responsesElement = EdgeSlm.newBuilder().build();
    ListEdgeSlmsResponse expectedResponse =
        ListEdgeSlmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEdgeSlms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEdgeSlmsPagedResponse pagedListResponse = client.listEdgeSlms(parent);

    List<EdgeSlm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEdgeSlmsList().get(0), resources.get(0));

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
  public void listEdgeSlmsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEdgeSlms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEdgeSlmsTest2() throws Exception {
    EdgeSlm responsesElement = EdgeSlm.newBuilder().build();
    ListEdgeSlmsResponse expectedResponse =
        ListEdgeSlmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEdgeSlms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEdgeSlmsPagedResponse pagedListResponse = client.listEdgeSlms(parent);

    List<EdgeSlm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEdgeSlmsList().get(0), resources.get(0));

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
  public void listEdgeSlmsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEdgeSlms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEdgeSlmTest() throws Exception {
    EdgeSlm expectedResponse =
        EdgeSlm.newBuilder()
            .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
            .setOrchestrationCluster(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    mockService.addResponse(expectedResponse);

    EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");

    EdgeSlm actualResponse = client.getEdgeSlm(name);
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
  public void getEdgeSlmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");
      client.getEdgeSlm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEdgeSlmTest2() throws Exception {
    EdgeSlm expectedResponse =
        EdgeSlm.newBuilder()
            .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
            .setOrchestrationCluster(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-804/locations/location-804/edgeSlms/edgeSlm-804";

    EdgeSlm actualResponse = client.getEdgeSlm(name);
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
  public void getEdgeSlmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-804/locations/location-804/edgeSlms/edgeSlm-804";
      client.getEdgeSlm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEdgeSlmTest() throws Exception {
    EdgeSlm expectedResponse =
        EdgeSlm.newBuilder()
            .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
            .setOrchestrationCluster(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEdgeSlmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
    String edgeSlmId = "edgeSlmId213186994";

    EdgeSlm actualResponse = client.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
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
  public void createEdgeSlmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
      String edgeSlmId = "edgeSlmId213186994";
      client.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEdgeSlmTest2() throws Exception {
    EdgeSlm expectedResponse =
        EdgeSlm.newBuilder()
            .setName(EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]").toString())
            .setOrchestrationCluster(
                OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTnaVersion("tnaVersion992913841")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEdgeSlmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
    String edgeSlmId = "edgeSlmId213186994";

    EdgeSlm actualResponse = client.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
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
  public void createEdgeSlmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      EdgeSlm edgeSlm = EdgeSlm.newBuilder().build();
      String edgeSlmId = "edgeSlmId213186994";
      client.createEdgeSlmAsync(parent, edgeSlm, edgeSlmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEdgeSlmTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEdgeSlmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");

    client.deleteEdgeSlmAsync(name).get();

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
  public void deleteEdgeSlmExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EdgeSlmName name = EdgeSlmName.of("[PROJECT]", "[LOCATION]", "[EDGE_SLM]");
      client.deleteEdgeSlmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEdgeSlmTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEdgeSlmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-804/locations/location-804/edgeSlms/edgeSlm-804";

    client.deleteEdgeSlmAsync(name).get();

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
  public void deleteEdgeSlmExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-804/locations/location-804/edgeSlms/edgeSlm-804";
      client.deleteEdgeSlmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
    Blueprint blueprint = Blueprint.newBuilder().build();
    String blueprintId = "blueprintId-1159505138";

    Blueprint actualResponse = client.createBlueprint(parent, blueprint, blueprintId);
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
  public void createBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      Blueprint blueprint = Blueprint.newBuilder().build();
      String blueprintId = "blueprintId-1159505138";
      client.createBlueprint(parent, blueprint, blueprintId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlueprintTest2() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
    Blueprint blueprint = Blueprint.newBuilder().build();
    String blueprintId = "blueprintId-1159505138";

    Blueprint actualResponse = client.createBlueprint(parent, blueprint, blueprintId);
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
  public void createBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      Blueprint blueprint = Blueprint.newBuilder().build();
      String blueprintId = "blueprintId-1159505138";
      client.createBlueprint(parent, blueprint, blueprintId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    Blueprint blueprint =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Blueprint actualResponse = client.updateBlueprint(blueprint, updateMask);
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
  public void updateBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Blueprint blueprint =
          Blueprint.newBuilder()
              .setName(
                  BlueprintName.of(
                          "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                      .toString())
              .setRevisionId("revisionId-1507445162")
              .setSourceBlueprint("sourceBlueprint-1648799560")
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setRepository("repository1950800714")
              .addAllFiles(new ArrayList<File>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setSourceProvider("sourceProvider1943963436")
              .setDeploymentLevel(DeploymentLevel.forNumber(0))
              .setRollbackSupport(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBlueprint(blueprint, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    Blueprint actualResponse = client.getBlueprint(name);
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
  public void getBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.getBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlueprintTest2() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    Blueprint actualResponse = client.getBlueprint(name);
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
  public void getBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.getBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBlueprintTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    client.deleteBlueprint(name);

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
  public void deleteBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.deleteBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBlueprintTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    client.deleteBlueprint(name);

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
  public void deleteBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.deleteBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlueprintsTest() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    ListBlueprintsResponse expectedResponse =
        ListBlueprintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");

    ListBlueprintsPagedResponse pagedListResponse = client.listBlueprints(parent);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void listBlueprintsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      client.listBlueprints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlueprintsTest2() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    ListBlueprintsResponse expectedResponse =
        ListBlueprintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";

    ListBlueprintsPagedResponse pagedListResponse = client.listBlueprints(parent);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void listBlueprintsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      client.listBlueprints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    Blueprint actualResponse = client.approveBlueprint(name);
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
  public void approveBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.approveBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveBlueprintTest2() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    Blueprint actualResponse = client.approveBlueprint(name);
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
  public void approveBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.approveBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    Blueprint actualResponse = client.proposeBlueprint(name);
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
  public void proposeBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.proposeBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void proposeBlueprintTest2() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    Blueprint actualResponse = client.proposeBlueprint(name);
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
  public void proposeBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.proposeBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectBlueprintTest() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    Blueprint actualResponse = client.rejectBlueprint(name);
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
  public void rejectBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.rejectBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rejectBlueprintTest2() throws Exception {
    Blueprint expectedResponse =
        Blueprint.newBuilder()
            .setName(
                BlueprintName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprint("sourceBlueprint-1648799560")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    Blueprint actualResponse = client.rejectBlueprint(name);
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
  public void rejectBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.rejectBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlueprintRevisionsTest() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    ListBlueprintRevisionsResponse expectedResponse =
        ListBlueprintRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    ListBlueprintRevisionsPagedResponse pagedListResponse = client.listBlueprintRevisions(name);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void listBlueprintRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.listBlueprintRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlueprintRevisionsTest2() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    ListBlueprintRevisionsResponse expectedResponse =
        ListBlueprintRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    ListBlueprintRevisionsPagedResponse pagedListResponse = client.listBlueprintRevisions(name);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void listBlueprintRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.listBlueprintRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchBlueprintRevisionsTest() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    SearchBlueprintRevisionsResponse expectedResponse =
        SearchBlueprintRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
    String query = "query107944136";

    SearchBlueprintRevisionsPagedResponse pagedListResponse =
        client.searchBlueprintRevisions(parent, query);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void searchBlueprintRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      String query = "query107944136";
      client.searchBlueprintRevisions(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchBlueprintRevisionsTest2() throws Exception {
    Blueprint responsesElement = Blueprint.newBuilder().build();
    SearchBlueprintRevisionsResponse expectedResponse =
        SearchBlueprintRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
    String query = "query107944136";

    SearchBlueprintRevisionsPagedResponse pagedListResponse =
        client.searchBlueprintRevisions(parent, query);

    List<Blueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlueprintsList().get(0), resources.get(0));

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
  public void searchBlueprintRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      String query = "query107944136";
      client.searchBlueprintRevisions(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchDeploymentRevisionsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    SearchDeploymentRevisionsResponse expectedResponse =
        SearchDeploymentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
    String query = "query107944136";

    SearchDeploymentRevisionsPagedResponse pagedListResponse =
        client.searchDeploymentRevisions(parent, query);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void searchDeploymentRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      String query = "query107944136";
      client.searchDeploymentRevisions(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchDeploymentRevisionsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    SearchDeploymentRevisionsResponse expectedResponse =
        SearchDeploymentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
    String query = "query107944136";

    SearchDeploymentRevisionsPagedResponse pagedListResponse =
        client.searchDeploymentRevisions(parent, query);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void searchDeploymentRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      String query = "query107944136";
      client.searchDeploymentRevisions(parent, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void discardBlueprintChangesTest() throws Exception {
    DiscardBlueprintChangesResponse expectedResponse =
        DiscardBlueprintChangesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BlueprintName name =
        BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");

    DiscardBlueprintChangesResponse actualResponse = client.discardBlueprintChanges(name);
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
  public void discardBlueprintChangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BlueprintName name =
          BlueprintName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[BLUEPRINT]");
      client.discardBlueprintChanges(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void discardBlueprintChangesTest2() throws Exception {
    DiscardBlueprintChangesResponse expectedResponse =
        DiscardBlueprintChangesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";

    DiscardBlueprintChangesResponse actualResponse = client.discardBlueprintChanges(name);
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
  public void discardBlueprintChangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9926/locations/location-9926/orchestrationClusters/orchestrationCluster-9926/blueprints/blueprint-9926";
      client.discardBlueprintChanges(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPublicBlueprintsTest() throws Exception {
    PublicBlueprint responsesElement = PublicBlueprint.newBuilder().build();
    ListPublicBlueprintsResponse expectedResponse =
        ListPublicBlueprintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPublicBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPublicBlueprintsPagedResponse pagedListResponse = client.listPublicBlueprints(parent);

    List<PublicBlueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPublicBlueprintsList().get(0), resources.get(0));

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
  public void listPublicBlueprintsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPublicBlueprints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPublicBlueprintsTest2() throws Exception {
    PublicBlueprint responsesElement = PublicBlueprint.newBuilder().build();
    ListPublicBlueprintsResponse expectedResponse =
        ListPublicBlueprintsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPublicBlueprints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPublicBlueprintsPagedResponse pagedListResponse = client.listPublicBlueprints(parent);

    List<PublicBlueprint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPublicBlueprintsList().get(0), resources.get(0));

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
  public void listPublicBlueprintsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPublicBlueprints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublicBlueprintTest() throws Exception {
    PublicBlueprint expectedResponse =
        PublicBlueprint.newBuilder()
            .setName(
                PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setSourceProvider("sourceProvider1943963436")
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    PublicBlueprintName name =
        PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]");

    PublicBlueprint actualResponse = client.getPublicBlueprint(name);
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
  public void getPublicBlueprintExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PublicBlueprintName name =
          PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]");
      client.getPublicBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublicBlueprintTest2() throws Exception {
    PublicBlueprint expectedResponse =
        PublicBlueprint.newBuilder()
            .setName(
                PublicBlueprintName.of("[PROJECT]", "[LOCATION]", "[PUBLIC_LUEPRINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setSourceProvider("sourceProvider1943963436")
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8265/locations/location-8265/publicBlueprints/publicBlueprint-8265";

    PublicBlueprint actualResponse = client.getPublicBlueprint(name);
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
  public void getPublicBlueprintExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8265/locations/location-8265/publicBlueprints/publicBlueprint-8265";
      client.getPublicBlueprint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
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
  public void createDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
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
  public void createDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    Deployment deployment =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeployment(deployment, updateMask);
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
  public void updateDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Deployment deployment =
          Deployment.newBuilder()
              .setName(
                  DeploymentName.of(
                          "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                      .toString())
              .setRevisionId("revisionId-1507445162")
              .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setRepository("repository1950800714")
              .addAllFiles(new ArrayList<File>())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setSourceProvider("sourceProvider1943963436")
              .setWorkloadCluster("workloadCluster925665923")
              .setDeploymentLevel(DeploymentLevel.forNumber(0))
              .setRollbackSupport(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeployment(deployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    client.removeDeployment(name);

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
  public void removeDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.removeDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    client.removeDeployment(name);

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
  public void removeDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.removeDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrchestrationClusterName parent =
        OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrchestrationClusterName parent =
          OrchestrationClusterName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]");
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1793/locations/location-1793/orchestrationClusters/orchestrationCluster-1793";
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentRevisionsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentRevisionsResponse expectedResponse =
        ListDeploymentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    ListDeploymentRevisionsPagedResponse pagedListResponse = client.listDeploymentRevisions(name);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.listDeploymentRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentRevisionsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentRevisionsResponse expectedResponse =
        ListDeploymentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    ListDeploymentRevisionsPagedResponse pagedListResponse = client.listDeploymentRevisions(name);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.listDeploymentRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void discardDeploymentChangesTest() throws Exception {
    DiscardDeploymentChangesResponse expectedResponse =
        DiscardDeploymentChangesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    DiscardDeploymentChangesResponse actualResponse = client.discardDeploymentChanges(name);
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
  public void discardDeploymentChangesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.discardDeploymentChanges(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void discardDeploymentChangesTest2() throws Exception {
    DiscardDeploymentChangesResponse expectedResponse =
        DiscardDeploymentChangesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    DiscardDeploymentChangesResponse actualResponse = client.discardDeploymentChanges(name);
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
  public void discardDeploymentChangesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.discardDeploymentChanges(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void applyDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    Deployment actualResponse = client.applyDeployment(name);
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
  public void applyDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.applyDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void applyDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    Deployment actualResponse = client.applyDeployment(name);
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
  public void applyDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.applyDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeDeploymentStatusTest() throws Exception {
    ComputeDeploymentStatusResponse expectedResponse =
        ComputeDeploymentStatusResponse.newBuilder()
            .setName("name3373707")
            .setAggregatedStatus(Status.forNumber(0))
            .addAllResourceStatuses(new ArrayList<ResourceStatus>())
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    ComputeDeploymentStatusResponse actualResponse = client.computeDeploymentStatus(name);
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
  public void computeDeploymentStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.computeDeploymentStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeDeploymentStatusTest2() throws Exception {
    ComputeDeploymentStatusResponse expectedResponse =
        ComputeDeploymentStatusResponse.newBuilder()
            .setName("name3373707")
            .setAggregatedStatus(Status.forNumber(0))
            .addAllResourceStatuses(new ArrayList<ResourceStatus>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";

    ComputeDeploymentStatusResponse actualResponse = client.computeDeploymentStatus(name);
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
  public void computeDeploymentStatusExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      client.computeDeploymentStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName name =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
    String revisionId = "revisionId-1507445162";

    Deployment actualResponse = client.rollbackDeployment(name, revisionId);
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
  public void rollbackDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName name =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      String revisionId = "revisionId-1507445162";
      client.rollbackDeployment(name, revisionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of(
                        "[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .setSourceBlueprintRevision("sourceBlueprintRevision-1125632845")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setRepository("repository1950800714")
            .addAllFiles(new ArrayList<File>())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourceProvider("sourceProvider1943963436")
            .setWorkloadCluster("workloadCluster925665923")
            .setDeploymentLevel(DeploymentLevel.forNumber(0))
            .setRollbackSupport(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
    String revisionId = "revisionId-1507445162";

    Deployment actualResponse = client.rollbackDeployment(name, revisionId);
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
  public void rollbackDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3706/locations/location-3706/orchestrationClusters/orchestrationCluster-3706/deployments/deployment-3706";
      String revisionId = "revisionId-1507445162";
      client.rollbackDeployment(name, revisionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHydratedDeploymentTest() throws Exception {
    HydratedDeployment expectedResponse =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    mockService.addResponse(expectedResponse);

    HydratedDeploymentName name =
        HydratedDeploymentName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[ORCHESTRATION_CLUSTER]",
            "[DEPLOYMENT]",
            "[HYDRATED_DEPLOYMENT]");

    HydratedDeployment actualResponse = client.getHydratedDeployment(name);
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
  public void getHydratedDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HydratedDeploymentName name =
          HydratedDeploymentName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[ORCHESTRATION_CLUSTER]",
              "[DEPLOYMENT]",
              "[HYDRATED_DEPLOYMENT]");
      client.getHydratedDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHydratedDeploymentTest2() throws Exception {
    HydratedDeployment expectedResponse =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8051/locations/location-8051/orchestrationClusters/orchestrationCluster-8051/deployments/deployment-8051/hydratedDeployments/hydratedDeployment-8051";

    HydratedDeployment actualResponse = client.getHydratedDeployment(name);
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
  public void getHydratedDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8051/locations/location-8051/orchestrationClusters/orchestrationCluster-8051/deployments/deployment-8051/hydratedDeployments/hydratedDeployment-8051";
      client.getHydratedDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHydratedDeploymentsTest() throws Exception {
    HydratedDeployment responsesElement = HydratedDeployment.newBuilder().build();
    ListHydratedDeploymentsResponse expectedResponse =
        ListHydratedDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHydratedDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DeploymentName parent =
        DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");

    ListHydratedDeploymentsPagedResponse pagedListResponse = client.listHydratedDeployments(parent);

    List<HydratedDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHydratedDeploymentsList().get(0), resources.get(0));

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
  public void listHydratedDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeploymentName parent =
          DeploymentName.of("[PROJECT]", "[LOCATION]", "[ORCHESTRATION_CLUSTER]", "[DEPLOYMENT]");
      client.listHydratedDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHydratedDeploymentsTest2() throws Exception {
    HydratedDeployment responsesElement = HydratedDeployment.newBuilder().build();
    ListHydratedDeploymentsResponse expectedResponse =
        ListHydratedDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllHydratedDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-8809/locations/location-8809/orchestrationClusters/orchestrationCluster-8809/deployments/deployment-8809";

    ListHydratedDeploymentsPagedResponse pagedListResponse = client.listHydratedDeployments(parent);

    List<HydratedDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHydratedDeploymentsList().get(0), resources.get(0));

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
  public void listHydratedDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8809/locations/location-8809/orchestrationClusters/orchestrationCluster-8809/deployments/deployment-8809";
      client.listHydratedDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHydratedDeploymentTest() throws Exception {
    HydratedDeployment expectedResponse =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    mockService.addResponse(expectedResponse);

    HydratedDeployment hydratedDeployment =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HydratedDeployment actualResponse =
        client.updateHydratedDeployment(hydratedDeployment, updateMask);
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
  public void updateHydratedDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HydratedDeployment hydratedDeployment =
          HydratedDeployment.newBuilder()
              .setName(
                  HydratedDeploymentName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[ORCHESTRATION_CLUSTER]",
                          "[DEPLOYMENT]",
                          "[HYDRATED_DEPLOYMENT]")
                      .toString())
              .addAllFiles(new ArrayList<File>())
              .setWorkloadCluster("workloadCluster925665923")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHydratedDeployment(hydratedDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void applyHydratedDeploymentTest() throws Exception {
    HydratedDeployment expectedResponse =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    mockService.addResponse(expectedResponse);

    HydratedDeploymentName name =
        HydratedDeploymentName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[ORCHESTRATION_CLUSTER]",
            "[DEPLOYMENT]",
            "[HYDRATED_DEPLOYMENT]");

    HydratedDeployment actualResponse = client.applyHydratedDeployment(name);
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
  public void applyHydratedDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HydratedDeploymentName name =
          HydratedDeploymentName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[ORCHESTRATION_CLUSTER]",
              "[DEPLOYMENT]",
              "[HYDRATED_DEPLOYMENT]");
      client.applyHydratedDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void applyHydratedDeploymentTest2() throws Exception {
    HydratedDeployment expectedResponse =
        HydratedDeployment.newBuilder()
            .setName(
                HydratedDeploymentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[ORCHESTRATION_CLUSTER]",
                        "[DEPLOYMENT]",
                        "[HYDRATED_DEPLOYMENT]")
                    .toString())
            .addAllFiles(new ArrayList<File>())
            .setWorkloadCluster("workloadCluster925665923")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8051/locations/location-8051/orchestrationClusters/orchestrationCluster-8051/deployments/deployment-8051/hydratedDeployments/hydratedDeployment-8051";

    HydratedDeployment actualResponse = client.applyHydratedDeployment(name);
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
  public void applyHydratedDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8051/locations/location-8051/orchestrationClusters/orchestrationCluster-8051/deployments/deployment-8051/hydratedDeployments/hydratedDeployment-8051";
      client.applyHydratedDeployment(name);
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
}
