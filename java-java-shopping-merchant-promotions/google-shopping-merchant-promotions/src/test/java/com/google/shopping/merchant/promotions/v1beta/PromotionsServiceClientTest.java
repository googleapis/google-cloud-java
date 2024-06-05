/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.promotions.v1beta;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class PromotionsServiceClientTest {
  private static MockPromotionsService mockPromotionsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PromotionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPromotionsService = new MockPromotionsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPromotionsService));
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
    PromotionsServiceSettings settings =
        PromotionsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PromotionsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void insertPromotionTest() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockPromotionsService.addResponse(expectedResponse);

    InsertPromotionRequest request =
        InsertPromotionRequest.newBuilder()
            .setParent("parent-995424086")
            .setPromotion(Promotion.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    Promotion actualResponse = client.insertPromotion(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPromotionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertPromotionRequest actualRequest = ((InsertPromotionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPromotion(), actualRequest.getPromotion());
    Assert.assertEquals(request.getDataSource(), actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertPromotionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPromotionsService.addException(exception);

    try {
      InsertPromotionRequest request =
          InsertPromotionRequest.newBuilder()
              .setParent("parent-995424086")
              .setPromotion(Promotion.newBuilder().build())
              .setDataSource("dataSource1272470629")
              .build();
      client.insertPromotion(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPromotionTest() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockPromotionsService.addResponse(expectedResponse);

    PromotionName name = PromotionName.of("[ACCOUNT]", "[PROMOTION]");

    Promotion actualResponse = client.getPromotion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPromotionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPromotionRequest actualRequest = ((GetPromotionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPromotionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPromotionsService.addException(exception);

    try {
      PromotionName name = PromotionName.of("[ACCOUNT]", "[PROMOTION]");
      client.getPromotion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPromotionTest2() throws Exception {
    Promotion expectedResponse =
        Promotion.newBuilder()
            .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
            .setPromotionId("promotionId756050206")
            .setContentLanguage("contentLanguage810066673")
            .setTargetCountry("targetCountry-1033189179")
            .addAllRedemptionChannel(new ArrayList<RedemptionChannel>())
            .setDataSource("dataSource1272470629")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setPromotionStatus(PromotionStatus.newBuilder().build())
            .setVersionNumber(135927952)
            .build();
    mockPromotionsService.addResponse(expectedResponse);

    String name = "name3373707";

    Promotion actualResponse = client.getPromotion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPromotionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPromotionRequest actualRequest = ((GetPromotionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPromotionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPromotionsService.addException(exception);

    try {
      String name = "name3373707";
      client.getPromotion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPromotionsTest() throws Exception {
    Promotion responsesElement = Promotion.newBuilder().build();
    ListPromotionsResponse expectedResponse =
        ListPromotionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPromotions(Arrays.asList(responsesElement))
            .build();
    mockPromotionsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPromotionsPagedResponse pagedListResponse = client.listPromotions(parent);

    List<Promotion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPromotionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPromotionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPromotionsRequest actualRequest = ((ListPromotionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPromotionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPromotionsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPromotions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
