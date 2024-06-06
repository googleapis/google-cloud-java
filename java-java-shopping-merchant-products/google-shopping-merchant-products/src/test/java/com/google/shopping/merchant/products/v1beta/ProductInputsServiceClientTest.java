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

package com.google.shopping.merchant.products.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
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
public class ProductInputsServiceClientTest {
  private static MockProductInputsService mockProductInputsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProductInputsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProductInputsService = new MockProductInputsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProductInputsService));
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
    ProductInputsServiceSettings settings =
        ProductInputsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProductInputsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void insertProductInputTest() throws Exception {
    ProductInput expectedResponse =
        ProductInput.newBuilder()
            .setName(ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]").toString())
            .setProduct("product-309474065")
            .setOfferId("offerId-1548813161")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setVersionNumber(135927952)
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .build();
    mockProductInputsService.addResponse(expectedResponse);

    InsertProductInputRequest request =
        InsertProductInputRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setProductInput(ProductInput.newBuilder().build())
            .setDataSource("dataSource1272470629")
            .build();

    ProductInput actualResponse = client.insertProductInput(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertProductInputRequest actualRequest = ((InsertProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getProductInput(), actualRequest.getProductInput());
    Assert.assertEquals(request.getDataSource(), actualRequest.getDataSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertProductInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductInputsService.addException(exception);

    try {
      InsertProductInputRequest request =
          InsertProductInputRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setProductInput(ProductInput.newBuilder().build())
              .setDataSource("dataSource1272470629")
              .build();
      client.insertProductInput(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductInputTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductInputsService.addResponse(expectedResponse);

    ProductInputName name = ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]");

    client.deleteProductInput(name);

    List<AbstractMessage> actualRequests = mockProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductInputRequest actualRequest = ((DeleteProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductInputsService.addException(exception);

    try {
      ProductInputName name = ProductInputName.of("[ACCOUNT]", "[PRODUCTINPUT]");
      client.deleteProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProductInputTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProductInputsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProductInput(name);

    List<AbstractMessage> actualRequests = mockProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProductInputRequest actualRequest = ((DeleteProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProductInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProductInputsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
