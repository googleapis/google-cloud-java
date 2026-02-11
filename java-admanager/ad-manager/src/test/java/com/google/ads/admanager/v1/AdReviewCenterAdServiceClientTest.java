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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.AdReviewCenterAdServiceClient.SearchAdReviewCenterAdsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonAdReviewCenterAdServiceStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
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
public class AdReviewCenterAdServiceClientTest {
  private static MockHttpService mockService;
  private static AdReviewCenterAdServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAdReviewCenterAdServiceStub.getMethodDescriptors(),
            AdReviewCenterAdServiceSettings.getDefaultEndpoint());
    AdReviewCenterAdServiceSettings settings =
        AdReviewCenterAdServiceSettings.newBuilder()
            .setTransportChannelProvider(
                AdReviewCenterAdServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdReviewCenterAdServiceClient.create(settings);
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
  public void searchAdReviewCenterAdsTest() throws Exception {
    AdReviewCenterAd responsesElement = AdReviewCenterAd.newBuilder().build();
    SearchAdReviewCenterAdsResponse expectedResponse =
        SearchAdReviewCenterAdsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdReviewCenterAds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");

    SearchAdReviewCenterAdsPagedResponse pagedListResponse = client.searchAdReviewCenterAds(parent);

    List<AdReviewCenterAd> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdReviewCenterAdsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchAdReviewCenterAdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
      client.searchAdReviewCenterAds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAdReviewCenterAdsTest2() throws Exception {
    AdReviewCenterAd responsesElement = AdReviewCenterAd.newBuilder().build();
    SearchAdReviewCenterAdsResponse expectedResponse =
        SearchAdReviewCenterAdsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAdReviewCenterAds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-8813/webProperties/webPropertie-8813";

    SearchAdReviewCenterAdsPagedResponse pagedListResponse = client.searchAdReviewCenterAds(parent);

    List<AdReviewCenterAd> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAdReviewCenterAdsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchAdReviewCenterAdsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-8813/webProperties/webPropertie-8813";
      client.searchAdReviewCenterAds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchAllowAdReviewCenterAdsTest() throws Exception {
    BatchAllowAdReviewCenterAdsResponse expectedResponse =
        BatchAllowAdReviewCenterAdsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchAllowAdReviewCenterAdsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");

    BatchAllowAdReviewCenterAdsResponse actualResponse =
        client.batchAllowAdReviewCenterAdsAsync(parent).get();
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
  public void batchAllowAdReviewCenterAdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
      client.batchAllowAdReviewCenterAdsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchAllowAdReviewCenterAdsTest2() throws Exception {
    BatchAllowAdReviewCenterAdsResponse expectedResponse =
        BatchAllowAdReviewCenterAdsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchAllowAdReviewCenterAdsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "networks/network-8813/webProperties/webPropertie-8813";

    BatchAllowAdReviewCenterAdsResponse actualResponse =
        client.batchAllowAdReviewCenterAdsAsync(parent).get();
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
  public void batchAllowAdReviewCenterAdsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-8813/webProperties/webPropertie-8813";
      client.batchAllowAdReviewCenterAdsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchBlockAdReviewCenterAdsTest() throws Exception {
    BatchBlockAdReviewCenterAdsResponse expectedResponse =
        BatchBlockAdReviewCenterAdsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchBlockAdReviewCenterAdsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");

    BatchBlockAdReviewCenterAdsResponse actualResponse =
        client.batchBlockAdReviewCenterAdsAsync(parent).get();
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
  public void batchBlockAdReviewCenterAdsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
      client.batchBlockAdReviewCenterAdsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchBlockAdReviewCenterAdsTest2() throws Exception {
    BatchBlockAdReviewCenterAdsResponse expectedResponse =
        BatchBlockAdReviewCenterAdsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchBlockAdReviewCenterAdsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "networks/network-8813/webProperties/webPropertie-8813";

    BatchBlockAdReviewCenterAdsResponse actualResponse =
        client.batchBlockAdReviewCenterAdsAsync(parent).get();
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
  public void batchBlockAdReviewCenterAdsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-8813/webProperties/webPropertie-8813";
      client.batchBlockAdReviewCenterAdsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
