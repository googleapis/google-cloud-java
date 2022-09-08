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

package com.google.cloud.asset.v1;

import static com.google.cloud.asset.v1.AssetServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.asset.v1.stub.HttpJsonAssetServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Expr;
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
  public void exportAssetsTest() throws Exception {
    ExportAssetsResponse expectedResponse =
        ExportAssetsResponse.newBuilder()
            .setReadTime(Timestamp.newBuilder().build())
            .setOutputConfig(OutputConfig.newBuilder().build())
            .setOutputResult(OutputResult.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAssetsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportAssetsRequest request =
        ExportAssetsRequest.newBuilder()
            .setParent(FolderName.of("[FOLDER]").toString())
            .setReadTime(Timestamp.newBuilder().build())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setOutputConfig(OutputConfig.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
            .build();

    ExportAssetsResponse actualResponse = client.exportAssetsAsync(request).get();
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
  public void exportAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportAssetsRequest request =
          ExportAssetsRequest.newBuilder()
              .setParent(FolderName.of("[FOLDER]").toString())
              .setReadTime(Timestamp.newBuilder().build())
              .addAllAssetTypes(new ArrayList<String>())
              .setContentType(ContentType.forNumber(0))
              .setOutputConfig(OutputConfig.newBuilder().build())
              .addAllRelationshipTypes(new ArrayList<String>())
              .build();
      client.exportAssetsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listAssetsTest() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName parent = FolderName.of("[FOLDER]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName parent = FolderName.of("[FOLDER]");
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetsTest2() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetAssetsHistoryTest() throws Exception {
    BatchGetAssetsHistoryResponse expectedResponse =
        BatchGetAssetsHistoryResponse.newBuilder()
            .addAllAssets(new ArrayList<TemporalAsset>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchGetAssetsHistoryRequest request =
        BatchGetAssetsHistoryRequest.newBuilder()
            .setParent(FolderName.of("[FOLDER]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setReadTimeWindow(TimeWindow.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
            .build();

    BatchGetAssetsHistoryResponse actualResponse = client.batchGetAssetsHistory(request);
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
  public void batchGetAssetsHistoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchGetAssetsHistoryRequest request =
          BatchGetAssetsHistoryRequest.newBuilder()
              .setParent(FolderName.of("[FOLDER]").toString())
              .addAllAssetNames(new ArrayList<String>())
              .setContentType(ContentType.forNumber(0))
              .setReadTimeWindow(TimeWindow.newBuilder().build())
              .addAllRelationshipTypes(new ArrayList<String>())
              .build();
      client.batchGetAssetsHistory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
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
            .setCondition(Expr.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
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
            .setCondition(Expr.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
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
            .setCondition(Expr.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
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
            .setCondition(Expr.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    Feed feed =
        Feed.newBuilder()
            .setName(FeedName.ofProjectFeedName("[PROJECT]", "[FEED]").toString())
            .addAllAssetNames(new ArrayList<String>())
            .addAllAssetTypes(new ArrayList<String>())
            .setContentType(ContentType.forNumber(0))
            .setFeedOutputConfig(FeedOutputConfig.newBuilder().build())
            .setCondition(Expr.newBuilder().build())
            .addAllRelationshipTypes(new ArrayList<String>())
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
              .setCondition(Expr.newBuilder().build())
              .addAllRelationshipTypes(new ArrayList<String>())
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

  @Test
  public void searchAllResourcesTest() throws Exception {
    ResourceSearchResult responsesElement = ResourceSearchResult.newBuilder().build();
    SearchAllResourcesResponse expectedResponse =
        SearchAllResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "scope-2319/scope-2319";
    String query = "query107944136";
    List<String> assetTypes = new ArrayList<>();

    SearchAllResourcesPagedResponse pagedListResponse =
        client.searchAllResources(scope, query, assetTypes);

    List<ResourceSearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

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
  public void searchAllResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "scope-2319/scope-2319";
      String query = "query107944136";
      List<String> assetTypes = new ArrayList<>();
      client.searchAllResources(scope, query, assetTypes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAllIamPoliciesTest() throws Exception {
    IamPolicySearchResult responsesElement = IamPolicySearchResult.newBuilder().build();
    SearchAllIamPoliciesResponse expectedResponse =
        SearchAllIamPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "scope-2319/scope-2319";
    String query = "query107944136";

    SearchAllIamPoliciesPagedResponse pagedListResponse = client.searchAllIamPolicies(scope, query);

    List<IamPolicySearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

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
  public void searchAllIamPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "scope-2319/scope-2319";
      String query = "query107944136";
      client.searchAllIamPolicies(scope, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeIamPolicyTest() throws Exception {
    AnalyzeIamPolicyResponse expectedResponse =
        AnalyzeIamPolicyResponse.newBuilder()
            .setMainAnalysis(AnalyzeIamPolicyResponse.IamPolicyAnalysis.newBuilder().build())
            .addAllServiceAccountImpersonationAnalysis(
                new ArrayList<AnalyzeIamPolicyResponse.IamPolicyAnalysis>())
            .setFullyExplored(true)
            .build();
    mockService.addResponse(expectedResponse);

    AnalyzeIamPolicyRequest request =
        AnalyzeIamPolicyRequest.newBuilder()
            .setAnalysisQuery(
                IamPolicyAnalysisQuery.newBuilder()
                    .setScope("scope-2319/scope-2319")
                    .setResourceSelector(
                        IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                    .setIdentitySelector(
                        IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                    .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                    .setOptions(IamPolicyAnalysisQuery.Options.newBuilder().build())
                    .setConditionContext(
                        IamPolicyAnalysisQuery.ConditionContext.newBuilder().build())
                    .build())
            .setSavedAnalysisQuery("savedAnalysisQuery376058885")
            .setExecutionTimeout(Duration.newBuilder().build())
            .build();

    AnalyzeIamPolicyResponse actualResponse = client.analyzeIamPolicy(request);
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
  public void analyzeIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeIamPolicyRequest request =
          AnalyzeIamPolicyRequest.newBuilder()
              .setAnalysisQuery(
                  IamPolicyAnalysisQuery.newBuilder()
                      .setScope("scope-2319/scope-2319")
                      .setResourceSelector(
                          IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                      .setIdentitySelector(
                          IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                      .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                      .setOptions(IamPolicyAnalysisQuery.Options.newBuilder().build())
                      .setConditionContext(
                          IamPolicyAnalysisQuery.ConditionContext.newBuilder().build())
                      .build())
              .setSavedAnalysisQuery("savedAnalysisQuery376058885")
              .setExecutionTimeout(Duration.newBuilder().build())
              .build();
      client.analyzeIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeIamPolicyLongrunningTest() throws Exception {
    AnalyzeIamPolicyLongrunningResponse expectedResponse =
        AnalyzeIamPolicyLongrunningResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("analyzeIamPolicyLongrunningTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AnalyzeIamPolicyLongrunningRequest request =
        AnalyzeIamPolicyLongrunningRequest.newBuilder()
            .setAnalysisQuery(
                IamPolicyAnalysisQuery.newBuilder()
                    .setScope("scope-2319/scope-2319")
                    .setResourceSelector(
                        IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                    .setIdentitySelector(
                        IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                    .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                    .setOptions(IamPolicyAnalysisQuery.Options.newBuilder().build())
                    .setConditionContext(
                        IamPolicyAnalysisQuery.ConditionContext.newBuilder().build())
                    .build())
            .setSavedAnalysisQuery("savedAnalysisQuery376058885")
            .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
            .build();

    AnalyzeIamPolicyLongrunningResponse actualResponse =
        client.analyzeIamPolicyLongrunningAsync(request).get();
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
  public void analyzeIamPolicyLongrunningExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeIamPolicyLongrunningRequest request =
          AnalyzeIamPolicyLongrunningRequest.newBuilder()
              .setAnalysisQuery(
                  IamPolicyAnalysisQuery.newBuilder()
                      .setScope("scope-2319/scope-2319")
                      .setResourceSelector(
                          IamPolicyAnalysisQuery.ResourceSelector.newBuilder().build())
                      .setIdentitySelector(
                          IamPolicyAnalysisQuery.IdentitySelector.newBuilder().build())
                      .setAccessSelector(IamPolicyAnalysisQuery.AccessSelector.newBuilder().build())
                      .setOptions(IamPolicyAnalysisQuery.Options.newBuilder().build())
                      .setConditionContext(
                          IamPolicyAnalysisQuery.ConditionContext.newBuilder().build())
                      .build())
              .setSavedAnalysisQuery("savedAnalysisQuery376058885")
              .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
              .build();
      client.analyzeIamPolicyLongrunningAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void analyzeMoveTest() throws Exception {
    AnalyzeMoveResponse expectedResponse =
        AnalyzeMoveResponse.newBuilder().addAllMoveAnalysis(new ArrayList<MoveAnalysis>()).build();
    mockService.addResponse(expectedResponse);

    AnalyzeMoveRequest request =
        AnalyzeMoveRequest.newBuilder()
            .setResource("resource-4407/resource-4407")
            .setDestinationParent("destinationParent-1733659048")
            .build();

    AnalyzeMoveResponse actualResponse = client.analyzeMove(request);
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
  public void analyzeMoveExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeMoveRequest request =
          AnalyzeMoveRequest.newBuilder()
              .setResource("resource-4407/resource-4407")
              .setDestinationParent("destinationParent-1733659048")
              .build();
      client.analyzeMove(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryAssetsTest() throws Exception {
    QueryAssetsResponse expectedResponse =
        QueryAssetsResponse.newBuilder()
            .setJobReference("jobReference-2094880754")
            .setDone(true)
            .build();
    mockService.addResponse(expectedResponse);

    QueryAssetsRequest request =
        QueryAssetsRequest.newBuilder()
            .setParent(FolderName.of("[FOLDER]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setTimeout(Duration.newBuilder().build())
            .setOutputConfig(QueryAssetsOutputConfig.newBuilder().build())
            .build();

    QueryAssetsResponse actualResponse = client.queryAssets(request);
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
  public void queryAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QueryAssetsRequest request =
          QueryAssetsRequest.newBuilder()
              .setParent(FolderName.of("[FOLDER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setTimeout(Duration.newBuilder().build())
              .setOutputConfig(QueryAssetsOutputConfig.newBuilder().build())
              .build();
      client.queryAssets(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSavedQueryTest() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    SavedQuery savedQuery = SavedQuery.newBuilder().build();
    String savedQueryId = "savedQueryId378086268";

    SavedQuery actualResponse = client.createSavedQuery(parent, savedQuery, savedQueryId);
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
  public void createSavedQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      SavedQuery savedQuery = SavedQuery.newBuilder().build();
      String savedQueryId = "savedQueryId378086268";
      client.createSavedQuery(parent, savedQuery, savedQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSavedQueryTest2() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    SavedQuery savedQuery = SavedQuery.newBuilder().build();
    String savedQueryId = "savedQueryId378086268";

    SavedQuery actualResponse = client.createSavedQuery(parent, savedQuery, savedQueryId);
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
  public void createSavedQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      SavedQuery savedQuery = SavedQuery.newBuilder().build();
      String savedQueryId = "savedQueryId378086268";
      client.createSavedQuery(parent, savedQuery, savedQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSavedQueryTest3() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    SavedQuery savedQuery = SavedQuery.newBuilder().build();
    String savedQueryId = "savedQueryId378086268";

    SavedQuery actualResponse = client.createSavedQuery(parent, savedQuery, savedQueryId);
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
  public void createSavedQueryExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      SavedQuery savedQuery = SavedQuery.newBuilder().build();
      String savedQueryId = "savedQueryId378086268";
      client.createSavedQuery(parent, savedQuery, savedQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSavedQueryTest4() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";
    SavedQuery savedQuery = SavedQuery.newBuilder().build();
    String savedQueryId = "savedQueryId378086268";

    SavedQuery actualResponse = client.createSavedQuery(parent, savedQuery, savedQueryId);
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
  public void createSavedQueryExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      SavedQuery savedQuery = SavedQuery.newBuilder().build();
      String savedQueryId = "savedQueryId378086268";
      client.createSavedQuery(parent, savedQuery, savedQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSavedQueryTest() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SavedQueryName name = SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]");

    SavedQuery actualResponse = client.getSavedQuery(name);
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
  public void getSavedQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SavedQueryName name = SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]");
      client.getSavedQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSavedQueryTest2() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "name-3263/name-3263/savedQueries/savedQuerie-3263";

    SavedQuery actualResponse = client.getSavedQuery(name);
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
  public void getSavedQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-3263/name-3263/savedQueries/savedQuerie-3263";
      client.getSavedQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSavedQueriesTest() throws Exception {
    SavedQuery responsesElement = SavedQuery.newBuilder().build();
    ListSavedQueriesResponse expectedResponse =
        ListSavedQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSavedQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListSavedQueriesPagedResponse pagedListResponse = client.listSavedQueries(parent);

    List<SavedQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSavedQueriesList().get(0), resources.get(0));

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
  public void listSavedQueriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listSavedQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSavedQueriesTest2() throws Exception {
    SavedQuery responsesElement = SavedQuery.newBuilder().build();
    ListSavedQueriesResponse expectedResponse =
        ListSavedQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSavedQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSavedQueriesPagedResponse pagedListResponse = client.listSavedQueries(parent);

    List<SavedQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSavedQueriesList().get(0), resources.get(0));

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
  public void listSavedQueriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSavedQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSavedQueriesTest3() throws Exception {
    SavedQuery responsesElement = SavedQuery.newBuilder().build();
    ListSavedQueriesResponse expectedResponse =
        ListSavedQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSavedQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSavedQueriesPagedResponse pagedListResponse = client.listSavedQueries(parent);

    List<SavedQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSavedQueriesList().get(0), resources.get(0));

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
  public void listSavedQueriesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSavedQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSavedQueriesTest4() throws Exception {
    SavedQuery responsesElement = SavedQuery.newBuilder().build();
    ListSavedQueriesResponse expectedResponse =
        ListSavedQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSavedQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";

    ListSavedQueriesPagedResponse pagedListResponse = client.listSavedQueries(parent);

    List<SavedQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSavedQueriesList().get(0), resources.get(0));

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
  public void listSavedQueriesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      client.listSavedQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSavedQueryTest() throws Exception {
    SavedQuery expectedResponse =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SavedQuery savedQuery =
        SavedQuery.newBuilder()
            .setName(
                SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setLastUpdater("lastUpdater1649733971")
            .putAllLabels(new HashMap<String, String>())
            .setContent(SavedQuery.QueryContent.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SavedQuery actualResponse = client.updateSavedQuery(savedQuery, updateMask);
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
  public void updateSavedQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SavedQuery savedQuery =
          SavedQuery.newBuilder()
              .setName(
                  SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]").toString())
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setCreator("creator1028554796")
              .setLastUpdateTime(Timestamp.newBuilder().build())
              .setLastUpdater("lastUpdater1649733971")
              .putAllLabels(new HashMap<String, String>())
              .setContent(SavedQuery.QueryContent.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSavedQuery(savedQuery, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSavedQueryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SavedQueryName name = SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]");

    client.deleteSavedQuery(name);

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
  public void deleteSavedQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SavedQueryName name = SavedQueryName.ofProjectSavedQueryName("[PROJECT]", "[SAVED_QUERY]");
      client.deleteSavedQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSavedQueryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "name-3263/name-3263/savedQueries/savedQuerie-3263";

    client.deleteSavedQuery(name);

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
  public void deleteSavedQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-3263/name-3263/savedQueries/savedQuerie-3263";
      client.deleteSavedQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetEffectiveIamPoliciesTest() throws Exception {
    BatchGetEffectiveIamPoliciesResponse expectedResponse =
        BatchGetEffectiveIamPoliciesResponse.newBuilder()
            .addAllPolicyResults(
                new ArrayList<BatchGetEffectiveIamPoliciesResponse.EffectiveIamPolicy>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchGetEffectiveIamPoliciesRequest request =
        BatchGetEffectiveIamPoliciesRequest.newBuilder()
            .setScope(FolderName.of("[FOLDER]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetEffectiveIamPoliciesResponse actualResponse =
        client.batchGetEffectiveIamPolicies(request);
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
  public void batchGetEffectiveIamPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchGetEffectiveIamPoliciesRequest request =
          BatchGetEffectiveIamPoliciesRequest.newBuilder()
              .setScope(FolderName.of("[FOLDER]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetEffectiveIamPolicies(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
