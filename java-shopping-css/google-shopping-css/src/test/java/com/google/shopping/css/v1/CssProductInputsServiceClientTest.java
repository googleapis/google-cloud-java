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

package com.google.shopping.css.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
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
public class CssProductInputsServiceClientTest {
  private static MockCssProductInputsService mockCssProductInputsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CssProductInputsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCssProductInputsService = new MockCssProductInputsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCssProductInputsService));
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
    CssProductInputsServiceSettings settings =
        CssProductInputsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CssProductInputsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void insertCssProductInputTest() throws Exception {
    CssProductInput expectedResponse =
        CssProductInput.newBuilder()
            .setName(CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]").toString())
            .setFinalName("finalName355075361")
            .setRawProvidedId("rawProvidedId-637295450")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setFreshnessTime(Timestamp.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .build();
    mockCssProductInputsService.addResponse(expectedResponse);

    InsertCssProductInputRequest request =
        InsertCssProductInputRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setCssProductInput(CssProductInput.newBuilder().build())
            .setFeedId(-976011428)
            .build();

    CssProductInput actualResponse = client.insertCssProductInput(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCssProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertCssProductInputRequest actualRequest =
        ((InsertCssProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCssProductInput(), actualRequest.getCssProductInput());
    Assert.assertEquals(request.getFeedId(), actualRequest.getFeedId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertCssProductInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductInputsService.addException(exception);

    try {
      InsertCssProductInputRequest request =
          InsertCssProductInputRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setCssProductInput(CssProductInput.newBuilder().build())
              .setFeedId(-976011428)
              .build();
      client.insertCssProductInput(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCssProductInputTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCssProductInputsService.addResponse(expectedResponse);

    CssProductInputName name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]");

    client.deleteCssProductInput(name);

    List<AbstractMessage> actualRequests = mockCssProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCssProductInputRequest actualRequest =
        ((DeleteCssProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCssProductInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductInputsService.addException(exception);

    try {
      CssProductInputName name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]");
      client.deleteCssProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCssProductInputTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCssProductInputsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCssProductInput(name);

    List<AbstractMessage> actualRequests = mockCssProductInputsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCssProductInputRequest actualRequest =
        ((DeleteCssProductInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCssProductInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCssProductInputsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCssProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
