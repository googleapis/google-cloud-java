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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.stub.HttpJsonTargetPoolsStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TargetPoolsClientTest {
  private static MockHttpService mockService;
  private static TargetPoolsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTargetPoolsStub.getMethodDescriptors(),
            TargetPoolsSettings.getDefaultEndpoint());
    TargetPoolsSettings settings =
        TargetPoolsSettings.newBuilder()
            .setTransportChannelProvider(
                TargetPoolsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TargetPoolsClient.create(settings);
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
  public void addHealthCheckTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource =
        TargetPoolsAddHealthCheckRequest.newBuilder().build();

    Operation actualResponse =
        client
            .addHealthCheckAsync(
                project, region, targetPool, targetPoolsAddHealthCheckRequestResource)
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
  public void addHealthCheckExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource =
          TargetPoolsAddHealthCheckRequest.newBuilder().build();
      client
          .addHealthCheckAsync(
              project, region, targetPool, targetPoolsAddHealthCheckRequestResource)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addInstanceTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource =
        TargetPoolsAddInstanceRequest.newBuilder().build();

    Operation actualResponse =
        client
            .addInstanceAsync(project, region, targetPool, targetPoolsAddInstanceRequestResource)
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
  public void addInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource =
          TargetPoolsAddInstanceRequest.newBuilder().build();
      client
          .addInstanceAsync(project, region, targetPool, targetPoolsAddInstanceRequestResource)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void aggregatedListTest() throws Exception {
    TargetPoolsScopedList responsesElement = TargetPoolsScopedList.newBuilder().build();
    TargetPoolAggregatedList expectedResponse =
        TargetPoolAggregatedList.newBuilder()
            .setNextPageToken("")
            .putAllItems(Collections.singletonMap("items", responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";

    AggregatedListPagedResponse pagedListResponse = client.aggregatedList(project);

    List<Map.Entry<String, TargetPoolsScopedList>> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getItemsMap().entrySet().iterator().next(), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void aggregatedListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      client.aggregatedList(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";

    Operation actualResponse = client.deleteAsync(project, region, targetPool).get();
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
  public void deleteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      client.deleteAsync(project, region, targetPool).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getTest() throws Exception {
    TargetPool expectedResponse =
        TargetPool.newBuilder()
            .setBackupPool("backupPool-934162178")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setFailoverRatio(-861074818)
            .addAllHealthChecks(new ArrayList<String>())
            .setId(3355)
            .addAllInstances(new ArrayList<String>())
            .setKind("kind3292052")
            .setName("name3373707")
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setSessionAffinity("sessionAffinity-289859106")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";

    TargetPool actualResponse = client.get(project, region, targetPool);
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
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      client.get(project, region, targetPool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHealthTest() throws Exception {
    TargetPoolInstanceHealth expectedResponse =
        TargetPoolInstanceHealth.newBuilder()
            .addAllHealthStatus(new ArrayList<HealthStatus>())
            .setKind("kind3292052")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();

    TargetPoolInstanceHealth actualResponse =
        client.getHealth(project, region, targetPool, instanceReferenceResource);
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
  public void getHealthExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
      client.getHealth(project, region, targetPool, instanceReferenceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    TargetPool targetPoolResource = TargetPool.newBuilder().build();

    Operation actualResponse = client.insertAsync(project, region, targetPoolResource).get();
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
  public void insertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      TargetPool targetPoolResource = TargetPool.newBuilder().build();
      client.insertAsync(project, region, targetPoolResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTest() throws Exception {
    TargetPool responsesElement = TargetPool.newBuilder().build();
    TargetPoolList expectedResponse =
        TargetPoolList.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";

    ListPagedResponse pagedListResponse = client.list(project, region);

    List<TargetPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      client.list(project, region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeHealthCheckTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource =
        TargetPoolsRemoveHealthCheckRequest.newBuilder().build();

    Operation actualResponse =
        client
            .removeHealthCheckAsync(
                project, region, targetPool, targetPoolsRemoveHealthCheckRequestResource)
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
  public void removeHealthCheckExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource =
          TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
      client
          .removeHealthCheckAsync(
              project, region, targetPool, targetPoolsRemoveHealthCheckRequestResource)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeInstanceTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource =
        TargetPoolsRemoveInstanceRequest.newBuilder().build();

    Operation actualResponse =
        client
            .removeInstanceAsync(
                project, region, targetPool, targetPoolsRemoveInstanceRequestResource)
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
  public void removeInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource =
          TargetPoolsRemoveInstanceRequest.newBuilder().build();
      client
          .removeInstanceAsync(
              project, region, targetPool, targetPoolsRemoveInstanceRequestResource)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void setBackupTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String targetPool = "targetPool-115";
    TargetReference targetReferenceResource = TargetReference.newBuilder().build();

    Operation actualResponse =
        client.setBackupAsync(project, region, targetPool, targetReferenceResource).get();
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
  public void setBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String targetPool = "targetPool-115";
      TargetReference targetReferenceResource = TargetReference.newBuilder().build();
      client.setBackupAsync(project, region, targetPool, targetReferenceResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
