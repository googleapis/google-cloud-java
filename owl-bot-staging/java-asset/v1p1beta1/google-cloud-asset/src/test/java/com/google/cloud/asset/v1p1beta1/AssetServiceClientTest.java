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

package com.google.cloud.asset.v1p1beta1;

import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AssetServiceClientTest {
  private static MockAssetService mockAssetService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AssetServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAssetService = new MockAssetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAssetService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    AssetServiceSettings settings =
        AssetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchAllResourcesTest() throws Exception {
    StandardResourceMetadata responsesElement = StandardResourceMetadata.newBuilder().build();
    SearchAllResourcesResponse expectedResponse =
        SearchAllResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockAssetService.addResponse(expectedResponse);

    String scope = "scope109264468";
    String query = "query107944136";
    List<String> assetTypes = new ArrayList<>();

    SearchAllResourcesPagedResponse pagedListResponse =
        client.searchAllResources(scope, query, assetTypes);

    List<StandardResourceMetadata> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAllResourcesRequest actualRequest = ((SearchAllResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertEquals(assetTypes, actualRequest.getAssetTypesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAllResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String scope = "scope109264468";
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
    mockAssetService.addResponse(expectedResponse);

    String scope = "scope109264468";
    String query = "query107944136";

    SearchAllIamPoliciesPagedResponse pagedListResponse = client.searchAllIamPolicies(scope, query);

    List<IamPolicySearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAllIamPoliciesRequest actualRequest =
        ((SearchAllIamPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAllIamPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssetService.addException(exception);

    try {
      String scope = "scope109264468";
      String query = "query107944136";
      client.searchAllIamPolicies(scope, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
