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

import static com.google.cloud.compute.v1.RegionUrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.HttpJsonRegionUrlMapsStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class RegionUrlMapsClientTest {
  private static MockHttpService mockService;
  private static RegionUrlMapsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRegionUrlMapsStub.getMethodDescriptors(),
            RegionUrlMapsSettings.getDefaultEndpoint());
    RegionUrlMapsSettings settings =
        RegionUrlMapsSettings.newBuilder()
            .setTransportChannelProvider(
                RegionUrlMapsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionUrlMapsClient.create(settings);
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
    String urlMap = "urlMap-7603";

    Operation actualResponse = client.deleteAsync(project, region, urlMap).get();
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
      String urlMap = "urlMap-7603";
      client.deleteAsync(project, region, urlMap).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getTest() throws Exception {
    UrlMap expectedResponse =
        UrlMap.newBuilder()
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDefaultRouteAction(HttpRouteAction.newBuilder().build())
            .setDefaultService("defaultService-306696908")
            .setDefaultUrlRedirect(HttpRedirectAction.newBuilder().build())
            .setDescription("description-1724546052")
            .setFingerprint("fingerprint-1375934236")
            .setHeaderAction(HttpHeaderAction.newBuilder().build())
            .addAllHostRules(new ArrayList<HostRule>())
            .setId(3355)
            .setKind("kind3292052")
            .setName("name3373707")
            .addAllPathMatchers(new ArrayList<PathMatcher>())
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .addAllTests(new ArrayList<UrlMapTest>())
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String urlMap = "urlMap-7603";

    UrlMap actualResponse = client.get(project, region, urlMap);
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
      String urlMap = "urlMap-7603";
      client.get(project, region, urlMap);
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
    UrlMap urlMapResource = UrlMap.newBuilder().build();

    Operation actualResponse = client.insertAsync(project, region, urlMapResource).get();
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
      UrlMap urlMapResource = UrlMap.newBuilder().build();
      client.insertAsync(project, region, urlMapResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTest() throws Exception {
    UrlMap responsesElement = UrlMap.newBuilder().build();
    UrlMapList expectedResponse =
        UrlMapList.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";

    ListPagedResponse pagedListResponse = client.list(project, region);

    List<UrlMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void patchTest() throws Exception {
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
    String urlMap = "urlMap-7603";
    UrlMap urlMapResource = UrlMap.newBuilder().build();

    Operation actualResponse = client.patchAsync(project, region, urlMap, urlMapResource).get();
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
  public void patchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String urlMap = "urlMap-7603";
      UrlMap urlMapResource = UrlMap.newBuilder().build();
      client.patchAsync(project, region, urlMap, urlMapResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTest() throws Exception {
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
    String urlMap = "urlMap-7603";
    UrlMap urlMapResource = UrlMap.newBuilder().build();

    Operation actualResponse = client.updateAsync(project, region, urlMap, urlMapResource).get();
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
  public void updateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String urlMap = "urlMap-7603";
      UrlMap urlMapResource = UrlMap.newBuilder().build();
      client.updateAsync(project, region, urlMap, urlMapResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void validateTest() throws Exception {
    UrlMapsValidateResponse expectedResponse =
        UrlMapsValidateResponse.newBuilder()
            .setResult(UrlMapValidationResult.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String region = "region-9622";
    String urlMap = "urlMap-7603";
    RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource =
        RegionUrlMapsValidateRequest.newBuilder().build();

    UrlMapsValidateResponse actualResponse =
        client.validate(project, region, urlMap, regionUrlMapsValidateRequestResource);
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
  public void validateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String region = "region-9622";
      String urlMap = "urlMap-7603";
      RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource =
          RegionUrlMapsValidateRequest.newBuilder().build();
      client.validate(project, region, urlMap, regionUrlMapsValidateRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
