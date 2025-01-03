/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.reviews.v1beta;

import static com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceClient.ListMerchantReviewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.type.CustomAttribute;
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
public class MerchantReviewsServiceClientTest {
  private static MockMerchantReviewsService mockMerchantReviewsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MerchantReviewsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMerchantReviewsService = new MockMerchantReviewsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMerchantReviewsService));
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
    MerchantReviewsServiceSettings settings =
        MerchantReviewsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MerchantReviewsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getMerchantReviewTest() throws Exception {
    MerchantReview expectedResponse =
        MerchantReview.newBuilder()
            .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
            .setMerchantReviewId("merchantReviewId-171413381")
            .setAttributes(MerchantReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setMerchantReviewStatus(MerchantReviewStatus.newBuilder().build())
            .build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");

    MerchantReview actualResponse = client.getMerchantReview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMerchantReviewRequest actualRequest = ((GetMerchantReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMerchantReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
      client.getMerchantReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMerchantReviewTest2() throws Exception {
    MerchantReview expectedResponse =
        MerchantReview.newBuilder()
            .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
            .setMerchantReviewId("merchantReviewId-171413381")
            .setAttributes(MerchantReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setMerchantReviewStatus(MerchantReviewStatus.newBuilder().build())
            .build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    String name = "name3373707";

    MerchantReview actualResponse = client.getMerchantReview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMerchantReviewRequest actualRequest = ((GetMerchantReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMerchantReviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      String name = "name3373707";
      client.getMerchantReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMerchantReviewsTest() throws Exception {
    MerchantReview responsesElement = MerchantReview.newBuilder().build();
    ListMerchantReviewsResponse expectedResponse =
        ListMerchantReviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMerchantReviews(Arrays.asList(responsesElement))
            .build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListMerchantReviewsPagedResponse pagedListResponse = client.listMerchantReviews(parent);

    List<MerchantReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMerchantReviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMerchantReviewsRequest actualRequest = ((ListMerchantReviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMerchantReviewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listMerchantReviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMerchantReviewsTest2() throws Exception {
    MerchantReview responsesElement = MerchantReview.newBuilder().build();
    ListMerchantReviewsResponse expectedResponse =
        ListMerchantReviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMerchantReviews(Arrays.asList(responsesElement))
            .build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMerchantReviewsPagedResponse pagedListResponse = client.listMerchantReviews(parent);

    List<MerchantReview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMerchantReviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMerchantReviewsRequest actualRequest = ((ListMerchantReviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMerchantReviewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMerchantReviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertMerchantReviewTest() throws Exception {
    MerchantReview expectedResponse =
        MerchantReview.newBuilder()
            .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
            .setMerchantReviewId("merchantReviewId-171413381")
            .setAttributes(MerchantReviewAttributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setDataSource("dataSource1272470629")
            .setMerchantReviewStatus(MerchantReviewStatus.newBuilder().build())
            .build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    InsertMerchantReviewRequest request =
        InsertMerchantReviewRequest.newBuilder()
            .setParent("parent-995424086")
            .setMerchantReview(MerchantReview.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    MerchantReview actualResponse = client.insertMerchantReview(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertMerchantReviewRequest actualRequest =
        ((InsertMerchantReviewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getMerchantReview(), actualRequest.getMerchantReview());
    Assert.assertEquals(request.getDataSource(), actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertMerchantReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      InsertMerchantReviewRequest request =
          InsertMerchantReviewRequest.newBuilder()
              .setParent("parent-995424086")
              .setMerchantReview(MerchantReview.newBuilder().build())
              .setDataSource("dataSource1272470629")
              .build();
      client.insertMerchantReview(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMerchantReviewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");

    client.deleteMerchantReview(name);

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMerchantReviewRequest actualRequest =
        ((DeleteMerchantReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMerchantReviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
      client.deleteMerchantReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMerchantReviewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMerchantReviewsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMerchantReview(name);

    List<AbstractMessage> actualRequests = mockMerchantReviewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMerchantReviewRequest actualRequest =
        ((DeleteMerchantReviewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMerchantReviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantReviewsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMerchantReview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
