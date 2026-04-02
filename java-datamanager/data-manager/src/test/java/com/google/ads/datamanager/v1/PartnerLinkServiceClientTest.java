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

package com.google.ads.datamanager.v1;

import static com.google.ads.datamanager.v1.PartnerLinkServiceClient.SearchPartnerLinksPagedResponse;

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
public class PartnerLinkServiceClientTest {
  private static MockPartnerLinkService mockPartnerLinkService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PartnerLinkServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPartnerLinkService = new MockPartnerLinkService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPartnerLinkService));
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
    PartnerLinkServiceSettings settings =
        PartnerLinkServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PartnerLinkServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPartnerLinkTest() throws Exception {
    PartnerLink expectedResponse =
        PartnerLink.newBuilder()
            .setName(PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
            .setPartnerLinkId("partnerLinkId171029917")
            .setOwningAccount(ProductAccount.newBuilder().build())
            .setPartnerAccount(ProductAccount.newBuilder().build())
            .build();
    mockPartnerLinkService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
    PartnerLink partnerLink = PartnerLink.newBuilder().build();

    PartnerLink actualResponse = client.createPartnerLink(parent, partnerLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePartnerLinkRequest actualRequest = ((CreatePartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(partnerLink, actualRequest.getPartnerLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPartnerLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      PartnerLink partnerLink = PartnerLink.newBuilder().build();
      client.createPartnerLink(parent, partnerLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPartnerLinkTest2() throws Exception {
    PartnerLink expectedResponse =
        PartnerLink.newBuilder()
            .setName(PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
            .setPartnerLinkId("partnerLinkId171029917")
            .setOwningAccount(ProductAccount.newBuilder().build())
            .setPartnerAccount(ProductAccount.newBuilder().build())
            .build();
    mockPartnerLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PartnerLink partnerLink = PartnerLink.newBuilder().build();

    PartnerLink actualResponse = client.createPartnerLink(parent, partnerLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePartnerLinkRequest actualRequest = ((CreatePartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(partnerLink, actualRequest.getPartnerLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPartnerLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      PartnerLink partnerLink = PartnerLink.newBuilder().build();
      client.createPartnerLink(parent, partnerLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartnerLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPartnerLinkService.addResponse(expectedResponse);

    PartnerLinkName name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]");

    client.deletePartnerLink(name);

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePartnerLinkRequest actualRequest = ((DeletePartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePartnerLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      PartnerLinkName name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]");
      client.deletePartnerLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePartnerLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPartnerLinkService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePartnerLink(name);

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePartnerLinkRequest actualRequest = ((DeletePartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePartnerLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePartnerLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPartnerLinksTest() throws Exception {
    PartnerLink responsesElement = PartnerLink.newBuilder().build();
    SearchPartnerLinksResponse expectedResponse =
        SearchPartnerLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartnerLinks(Arrays.asList(responsesElement))
            .build();
    mockPartnerLinkService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");

    SearchPartnerLinksPagedResponse pagedListResponse = client.searchPartnerLinks(parent);

    List<PartnerLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnerLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPartnerLinksRequest actualRequest = ((SearchPartnerLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPartnerLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
      client.searchPartnerLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchPartnerLinksTest2() throws Exception {
    PartnerLink responsesElement = PartnerLink.newBuilder().build();
    SearchPartnerLinksResponse expectedResponse =
        SearchPartnerLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPartnerLinks(Arrays.asList(responsesElement))
            .build();
    mockPartnerLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchPartnerLinksPagedResponse pagedListResponse = client.searchPartnerLinks(parent);

    List<PartnerLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPartnerLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPartnerLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchPartnerLinksRequest actualRequest = ((SearchPartnerLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchPartnerLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPartnerLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchPartnerLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
