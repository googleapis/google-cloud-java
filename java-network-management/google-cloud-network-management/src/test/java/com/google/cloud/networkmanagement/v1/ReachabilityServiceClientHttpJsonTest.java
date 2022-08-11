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

package com.google.cloud.networkmanagement.v1;

import static com.google.cloud.networkmanagement.v1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.networkmanagement.v1.stub.HttpJsonReachabilityServiceStub;
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
public class ReachabilityServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ReachabilityServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonReachabilityServiceStub.getMethodDescriptors(),
            ReachabilityServiceSettings.getDefaultEndpoint());
    ReachabilityServiceSettings settings =
        ReachabilityServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ReachabilityServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReachabilityServiceClient.create(settings);
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
  public void listConnectivityTestsTest() throws Exception {
    ConnectivityTest responsesElement = ConnectivityTest.newBuilder().build();
    ListConnectivityTestsResponse expectedResponse =
        ListConnectivityTestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6156/locations/global";

    ListConnectivityTestsPagedResponse pagedListResponse = client.listConnectivityTests(parent);

    List<ConnectivityTest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void listConnectivityTestsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6156/locations/global";
      client.listConnectivityTests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569";

    ConnectivityTest actualResponse = client.getConnectivityTest(name);
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
  public void getConnectivityTestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569";
      client.getConnectivityTest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6156/locations/global";
    String testId = "testId-877170355";
    ConnectivityTest resource = ConnectivityTest.newBuilder().build();

    ConnectivityTest actualResponse =
        client.createConnectivityTestAsync(parent, testId, resource).get();
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
  public void createConnectivityTestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6156/locations/global";
      String testId = "testId-877170355";
      ConnectivityTest resource = ConnectivityTest.newBuilder().build();
      client.createConnectivityTestAsync(parent, testId, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FieldMask updateMask = FieldMask.newBuilder().build();
    ConnectivityTest resource =
        ConnectivityTest.newBuilder()
            .setName(
                "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();

    ConnectivityTest actualResponse =
        client.updateConnectivityTestAsync(updateMask, resource).get();
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
  public void updateConnectivityTestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      ConnectivityTest resource =
          ConnectivityTest.newBuilder()
              .setName(
                  "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569")
              .setDescription("description-1724546052")
              .setSource(Endpoint.newBuilder().build())
              .setDestination(Endpoint.newBuilder().build())
              .setProtocol("protocol-989163880")
              .addAllRelatedProjects(new ArrayList<String>())
              .setDisplayName("displayName1714148973")
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
              .build();
      client.updateConnectivityTestAsync(updateMask, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void rerunConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rerunConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RerunConnectivityTestRequest request =
        RerunConnectivityTestRequest.newBuilder()
            .setName(
                "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569")
            .build();

    ConnectivityTest actualResponse = client.rerunConnectivityTestAsync(request).get();
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
  public void rerunConnectivityTestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RerunConnectivityTestRequest request =
          RerunConnectivityTestRequest.newBuilder()
              .setName(
                  "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569")
              .build();
      client.rerunConnectivityTestAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteConnectivityTestTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569";

    client.deleteConnectivityTestAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectivityTestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4569/locations/global/connectivityTests/connectivityTest-4569";
      client.deleteConnectivityTestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
