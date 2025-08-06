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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.LfpProvidersServiceClient.FindLfpProvidersPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class LfpProvidersServiceClientTest {
  private static MockLfpProvidersService mockLfpProvidersService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LfpProvidersServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLfpProvidersService = new MockLfpProvidersService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLfpProvidersService));
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
    LfpProvidersServiceSettings settings =
        LfpProvidersServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpProvidersServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void findLfpProvidersTest() throws Exception {
    LfpProvider responsesElement = LfpProvider.newBuilder().build();
    FindLfpProvidersResponse expectedResponse =
        FindLfpProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpProviders(Arrays.asList(responsesElement))
            .build();
    mockLfpProvidersService.addResponse(expectedResponse);

    OmnichannelSettingName parent = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    FindLfpProvidersPagedResponse pagedListResponse = client.findLfpProviders(parent);

    List<LfpProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLfpProvidersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindLfpProvidersRequest actualRequest = ((FindLfpProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findLfpProvidersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpProvidersService.addException(exception);

    try {
      OmnichannelSettingName parent =
          OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.findLfpProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findLfpProvidersTest2() throws Exception {
    LfpProvider responsesElement = LfpProvider.newBuilder().build();
    FindLfpProvidersResponse expectedResponse =
        FindLfpProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpProviders(Arrays.asList(responsesElement))
            .build();
    mockLfpProvidersService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    FindLfpProvidersPagedResponse pagedListResponse = client.findLfpProviders(parent);

    List<LfpProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpProvidersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLfpProvidersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindLfpProvidersRequest actualRequest = ((FindLfpProvidersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findLfpProvidersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpProvidersService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.findLfpProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkLfpProviderTest() throws Exception {
    LinkLfpProviderResponse expectedResponse =
        LinkLfpProviderResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockLfpProvidersService.addResponse(expectedResponse);

    LfpProviderName name =
        LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");

    LinkLfpProviderResponse actualResponse = client.linkLfpProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpProvidersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkLfpProviderRequest actualRequest = ((LinkLfpProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkLfpProviderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpProvidersService.addException(exception);

    try {
      LfpProviderName name =
          LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");
      client.linkLfpProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkLfpProviderTest2() throws Exception {
    LinkLfpProviderResponse expectedResponse =
        LinkLfpProviderResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockLfpProvidersService.addResponse(expectedResponse);

    String name = "name3373707";

    LinkLfpProviderResponse actualResponse = client.linkLfpProvider(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpProvidersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LinkLfpProviderRequest actualRequest = ((LinkLfpProviderRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void linkLfpProviderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpProvidersService.addException(exception);

    try {
      String name = "name3373707";
      client.linkLfpProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
