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

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonFeedsServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
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
public class FeedsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FeedsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFeedsServiceStub.getMethodDescriptors(),
            FeedsServiceSettings.getDefaultEndpoint());
    FeedsServiceSettings settings =
        FeedsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FeedsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FeedsServiceClient.create(settings);
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
  public void fetchServiceAccountForCustomerTest() throws Exception {
    FeedServiceAccount expectedResponse =
        FeedServiceAccount.newBuilder()
            .setName(
                FeedServiceAccountName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SERVICE_ACCOUNT]")
                    .toString())
            .setSubjectId("subjectId258589543")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    FeedServiceAccount actualResponse = client.fetchServiceAccountForCustomer(parent);
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
  public void fetchServiceAccountForCustomerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.fetchServiceAccountForCustomer(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchServiceAccountForCustomerTest2() throws Exception {
    FeedServiceAccount expectedResponse =
        FeedServiceAccount.newBuilder()
            .setName(
                FeedServiceAccountName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SERVICE_ACCOUNT]")
                    .toString())
            .setSubjectId("subjectId258589543")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    FeedServiceAccount actualResponse = client.fetchServiceAccountForCustomer(parent);
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
  public void fetchServiceAccountForCustomerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.fetchServiceAccountForCustomer(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Feed feed = Feed.newBuilder().build();

    Feed actualResponse = client.createFeed(parent, feed);
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
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Feed feed = Feed.newBuilder().build();
      client.createFeed(parent, feed);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFeedTest2() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    Feed feed = Feed.newBuilder().build();

    Feed actualResponse = client.createFeed(parent, feed);
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
  public void createFeedExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      Feed feed = Feed.newBuilder().build();
      client.createFeed(parent, feed);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

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
      FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
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
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";

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
      String name =
          "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";
      client.getFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

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
      FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
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

    String name =
        "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";

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
      String name =
          "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";
      client.deleteFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

    Feed actualResponse = client.enableFeed(name);
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
  public void enableFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
      client.enableFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableFeedTest2() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";

    Feed actualResponse = client.enableFeed(name);
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
  public void enableFeedExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";
      client.enableFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

    Feed actualResponse = client.disableFeed(name);
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
  public void disableFeedExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
      client.disableFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableFeedTest2() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";

    Feed actualResponse = client.disableFeed(name);
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
  public void disableFeedExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";
      client.disableFeed(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedsTest() throws Exception {
    Feed responsesElement = Feed.newBuilder().build();
    ListFeedsResponse expectedResponse =
        ListFeedsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeeds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFeedsPagedResponse pagedListResponse = client.listFeeds(parent);

    List<Feed> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedsList().get(0), resources.get(0));

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
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFeeds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedsTest2() throws Exception {
    Feed responsesElement = Feed.newBuilder().build();
    ListFeedsResponse expectedResponse =
        ListFeedsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeeds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListFeedsPagedResponse pagedListResponse = client.listFeeds(parent);

    List<Feed> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedsList().get(0), resources.get(0));

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
  public void listFeedsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listFeeds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedPacksTest() throws Exception {
    FeedPack responsesElement = FeedPack.newBuilder().build();
    ListFeedPacksResponse expectedResponse =
        ListFeedPacksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedPacks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFeedPacksPagedResponse pagedListResponse = client.listFeedPacks(parent);

    List<FeedPack> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedPacksList().get(0), resources.get(0));

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
  public void listFeedPacksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFeedPacks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedPacksTest2() throws Exception {
    FeedPack responsesElement = FeedPack.newBuilder().build();
    ListFeedPacksResponse expectedResponse =
        ListFeedPacksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedPacks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListFeedPacksPagedResponse pagedListResponse = client.listFeedPacks(parent);

    List<FeedPack> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedPacksList().get(0), resources.get(0));

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
  public void listFeedPacksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listFeedPacks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedPackTest() throws Exception {
    FeedPack expectedResponse =
        FeedPack.newBuilder()
            .setName(
                FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllCategories(new ArrayList<String>())
            .addAllPackLogTypes(new ArrayList<PackLogType>())
            .setHidden(true)
            .setPackDocumentation("packDocumentation2019598625")
            .build();
    mockService.addResponse(expectedResponse);

    FeedPackName name = FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]");

    FeedPack actualResponse = client.getFeedPack(name);
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
  public void getFeedPackExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedPackName name = FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]");
      client.getFeedPack(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedPackTest2() throws Exception {
    FeedPack expectedResponse =
        FeedPack.newBuilder()
            .setName(
                FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllCategories(new ArrayList<String>())
            .addAllPackLogTypes(new ArrayList<PackLogType>())
            .setHidden(true)
            .setPackDocumentation("packDocumentation2019598625")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-52/locations/location-52/instances/instance-52/feedPacks/feedPack-52";

    FeedPack actualResponse = client.getFeedPack(name);
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
  public void getFeedPackExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-52/locations/location-52/instances/instance-52/feedPacks/feedPack-52";
      client.getFeedPack(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeedTest() throws Exception {
    Feed expectedResponse =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    mockService.addResponse(expectedResponse);

    Feed feed =
        Feed.newBuilder()
            .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDetails(FeedDetails.newBuilder().build())
            .setFailureMsg("failureMsg1036654999")
            .setReadOnly(true)
            .setLastFeedInitiationTime(Timestamp.newBuilder().build())
            .setFailureDetails(FeedFailureDetails.newBuilder().build())
            .setReferenceId("referenceId-16211514")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Feed actualResponse = client.updateFeed(feed, updateMask);
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
              .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
              .setUid("uid115792")
              .setDisplayName("displayName1714148973")
              .setDetails(FeedDetails.newBuilder().build())
              .setFailureMsg("failureMsg1036654999")
              .setReadOnly(true)
              .setLastFeedInitiationTime(Timestamp.newBuilder().build())
              .setFailureDetails(FeedFailureDetails.newBuilder().build())
              .setReferenceId("referenceId-16211514")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeed(feed, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedSourceTypeSchemasTest() throws Exception {
    FeedSourceTypeSchema responsesElement = FeedSourceTypeSchema.newBuilder().build();
    ListFeedSourceTypeSchemasResponse expectedResponse =
        ListFeedSourceTypeSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedSourceTypeSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListFeedSourceTypeSchemasPagedResponse pagedListResponse =
        client.listFeedSourceTypeSchemas(parent);

    List<FeedSourceTypeSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedSourceTypeSchemasList().get(0), resources.get(0));

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
  public void listFeedSourceTypeSchemasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listFeedSourceTypeSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedSourceTypeSchemasTest2() throws Exception {
    FeedSourceTypeSchema responsesElement = FeedSourceTypeSchema.newBuilder().build();
    ListFeedSourceTypeSchemasResponse expectedResponse =
        ListFeedSourceTypeSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedSourceTypeSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListFeedSourceTypeSchemasPagedResponse pagedListResponse =
        client.listFeedSourceTypeSchemas(parent);

    List<FeedSourceTypeSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedSourceTypeSchemasList().get(0), resources.get(0));

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
  public void listFeedSourceTypeSchemasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listFeedSourceTypeSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogTypeSchemasTest() throws Exception {
    LogTypeSchema responsesElement = LogTypeSchema.newBuilder().build();
    ListLogTypeSchemasResponse expectedResponse =
        ListLogTypeSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogTypeSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FeedSourceTypeSchemaName parent =
        FeedSourceTypeSchemaName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]");

    ListLogTypeSchemasPagedResponse pagedListResponse = client.listLogTypeSchemas(parent);

    List<LogTypeSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogTypeSchemasList().get(0), resources.get(0));

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
  public void listLogTypeSchemasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedSourceTypeSchemaName parent =
          FeedSourceTypeSchemaName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]");
      client.listLogTypeSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogTypeSchemasTest2() throws Exception {
    LogTypeSchema responsesElement = LogTypeSchema.newBuilder().build();
    ListLogTypeSchemasResponse expectedResponse =
        ListLogTypeSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogTypeSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4130/locations/location-4130/instances/instance-4130/feedSourceTypeSchemas/feedSourceTypeSchema-4130";

    ListLogTypeSchemasPagedResponse pagedListResponse = client.listLogTypeSchemas(parent);

    List<LogTypeSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogTypeSchemasList().get(0), resources.get(0));

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
  public void listLogTypeSchemasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4130/locations/location-4130/instances/instance-4130/feedSourceTypeSchemas/feedSourceTypeSchema-4130";
      client.listLogTypeSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importPushLogsTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    FeedName parent = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

    HttpBody actualResponse = client.importPushLogs(parent);
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
  public void importPushLogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName parent = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
      client.importPushLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importPushLogsTest2() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-8708/locations/location-8708/instances/instance-8708/feeds/feed-8708";

    HttpBody actualResponse = client.importPushLogs(parent);
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
  public void importPushLogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8708/locations/location-8708/instances/instance-8708/feeds/feed-8708";
      client.importPushLogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateSecretTest() throws Exception {
    GenerateSecretResponse expectedResponse =
        GenerateSecretResponse.newBuilder().setSecret("secret-906277200").build();
    mockService.addResponse(expectedResponse);

    FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");

    GenerateSecretResponse actualResponse = client.generateSecret(name);
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
  public void generateSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
      client.generateSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateSecretTest2() throws Exception {
    GenerateSecretResponse expectedResponse =
        GenerateSecretResponse.newBuilder().setSecret("secret-906277200").build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";

    GenerateSecretResponse actualResponse = client.generateSecret(name);
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
  public void generateSecretExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5653/locations/location-5653/instances/instance-5653/feeds/feed-5653";
      client.generateSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
