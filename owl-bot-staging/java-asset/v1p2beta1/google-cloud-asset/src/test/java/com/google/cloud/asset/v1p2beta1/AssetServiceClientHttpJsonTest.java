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

package com.google.cloud.asset.v1p2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.asset.v1p2beta1.stub.HttpJsonAssetServiceStub;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AssetServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AssetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAssetServiceStub.getMethodDescriptors(),
            AssetServiceSettings.getDefaultEndpoint());
    AssetServiceSettings settings =
        AssetServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AssetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssetServiceClient.create(settings);
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
  public void createFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";

    Feed actualResponse = client.createFeed(parent);
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
  public void createFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      client.createFeed(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");

    Feed actualResponse = client.getFeed(name);
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
  public void getFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
      client.getFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedTest2() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "name-2459/name-2459/feeds/feed-2459";

    Feed actualResponse = client.getFeed(name);
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
  public void getFeedExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-2459/name-2459/feeds/feed-2459";
      client.getFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedsTest() throws Exception {
    ListFeedsResponse expectedResponse =
        ListFeedsResponse.newBuilder().addAllFeeds(new ArrayList<Feed>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";

    ListFeedsResponse actualResponse = client.listFeeds(parent);
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
  public void listFeedsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      client.listFeeds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Feed feed =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .build();

    Feed actualResponse = client.updateFeed(feed);
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
  public void updateFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Feed feed =
          Feed.newBuilder()
              .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
              .addAllAssetNames(new ArrayList<String>())
              .addAllAssetTypes(new ArrayList<String>())
              .setContentType(ContentType.forNumber(0))
              .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
              .build();
      client.updateFeed(feed);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");

    client.deleteFeed(name);

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
  public void deleteFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
      client.deleteFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "name-2459/name-2459/feeds/feed-2459";

    client.deleteFeed(name);

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
  public void deleteFeedExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-2459/name-2459/feeds/feed-2459";
      client.deleteFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
