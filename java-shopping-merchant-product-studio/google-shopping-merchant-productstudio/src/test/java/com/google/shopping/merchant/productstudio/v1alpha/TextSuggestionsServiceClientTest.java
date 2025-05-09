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

package com.google.shopping.merchant.productstudio.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class TextSuggestionsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTextSuggestionsService mockTextSuggestionsService;
  private LocalChannelProvider channelProvider;
  private TextSuggestionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTextSuggestionsService = new MockTextSuggestionsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTextSuggestionsService));
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
    TextSuggestionsServiceSettings settings =
        TextSuggestionsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TextSuggestionsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateProductTextSuggestionsTest() throws Exception {
    GenerateProductTextSuggestionsResponse expectedResponse =
        GenerateProductTextSuggestionsResponse.newBuilder()
            .setTitle(ProductTextGenerationSuggestion.newBuilder().build())
            .setDescription(ProductTextGenerationSuggestion.newBuilder().build())
            .putAllAttributes(new HashMap<String, String>())
            .setMetadata(ProductTextGenerationMetadata.newBuilder().build())
            .build();
    mockTextSuggestionsService.addResponse(expectedResponse);

    String name = "name3373707";

    GenerateProductTextSuggestionsResponse actualResponse =
        client.generateProductTextSuggestions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTextSuggestionsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateProductTextSuggestionsRequest actualRequest =
        ((GenerateProductTextSuggestionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateProductTextSuggestionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTextSuggestionsService.addException(exception);

    try {
      String name = "name3373707";
      client.generateProductTextSuggestions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
