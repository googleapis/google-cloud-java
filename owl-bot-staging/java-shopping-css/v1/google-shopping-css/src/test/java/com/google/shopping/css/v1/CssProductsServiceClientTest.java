/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.css.v1;

import static com.google.shopping.css.v1.CssProductsServiceClient.ListCssProductsPagedResponse;

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
public class CssProductsServiceClientTest {
  private static MockCssProductsService mockCssProductsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CssProductsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCssProductsService = new MockCssProductsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCssProductsService));
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
    CssProductsServiceSettings settings =
        CssProductsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CssProductsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getCssProductTest() throws Exception {
    CssProduct expectedResponse =
        CssProduct.newBuilder()
            .setName(CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]").toString())
            .setRawProvidedId("rawProvidedId-637295450")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setCssProductStatus(CssProductStatus.newBuilder().build())
            .build();
    mockCssProductsService.addResponse(expectedResponse);

    CssProductName name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]");

    CssProduct actualResponse = client.getCssProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCssProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCssProductRequest actualRequest = ((GetCssProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCssProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductsService.addException(exception);

    try {
      CssProductName name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]");
      client.getCssProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCssProductTest2() throws Exception {
    CssProduct expectedResponse =
        CssProduct.newBuilder()
            .setName(CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]").toString())
            .setRawProvidedId("rawProvidedId-637295450")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .setCssProductStatus(CssProductStatus.newBuilder().build())
            .build();
    mockCssProductsService.addResponse(expectedResponse);

    String name = "name3373707";

    CssProduct actualResponse = client.getCssProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCssProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCssProductRequest actualRequest = ((GetCssProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCssProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductsService.addException(exception);

    try {
      String name = "name3373707";
      client.getCssProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCssProductsTest() throws Exception {
    CssProduct responsesElement = CssProduct.newBuilder().build();
    ListCssProductsResponse expectedResponse =
        ListCssProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCssProducts(Arrays.asList(responsesElement))
            .build();
    mockCssProductsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListCssProductsPagedResponse pagedListResponse = client.listCssProducts(parent);

    List<CssProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCssProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCssProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCssProductsRequest actualRequest = ((ListCssProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCssProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listCssProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCssProductsTest2() throws Exception {
    CssProduct responsesElement = CssProduct.newBuilder().build();
    ListCssProductsResponse expectedResponse =
        ListCssProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCssProducts(Arrays.asList(responsesElement))
            .build();
    mockCssProductsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCssProductsPagedResponse pagedListResponse = client.listCssProducts(parent);

    List<CssProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCssProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCssProductsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCssProductsRequest actualRequest = ((ListCssProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCssProductsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCssProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
