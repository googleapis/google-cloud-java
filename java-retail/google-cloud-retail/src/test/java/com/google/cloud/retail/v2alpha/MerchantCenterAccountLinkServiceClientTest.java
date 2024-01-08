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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MerchantCenterAccountLinkServiceClientTest {
  private static MockMerchantCenterAccountLinkService mockMerchantCenterAccountLinkService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MerchantCenterAccountLinkServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMerchantCenterAccountLinkService = new MockMerchantCenterAccountLinkService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMerchantCenterAccountLinkService));
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
    MerchantCenterAccountLinkServiceSettings settings =
        MerchantCenterAccountLinkServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MerchantCenterAccountLinkServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMerchantCenterAccountLinksTest() throws Exception {
    ListMerchantCenterAccountLinksResponse expectedResponse =
        ListMerchantCenterAccountLinksResponse.newBuilder()
            .addAllMerchantCenterAccountLinks(new ArrayList<MerchantCenterAccountLink>())
            .build();
    mockMerchantCenterAccountLinkService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListMerchantCenterAccountLinksResponse actualResponse =
        client.listMerchantCenterAccountLinks(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMerchantCenterAccountLinksRequest actualRequest =
        ((ListMerchantCenterAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMerchantCenterAccountLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listMerchantCenterAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMerchantCenterAccountLinksTest2() throws Exception {
    ListMerchantCenterAccountLinksResponse expectedResponse =
        ListMerchantCenterAccountLinksResponse.newBuilder()
            .addAllMerchantCenterAccountLinks(new ArrayList<MerchantCenterAccountLink>())
            .build();
    mockMerchantCenterAccountLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMerchantCenterAccountLinksResponse actualResponse =
        client.listMerchantCenterAccountLinks(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMerchantCenterAccountLinksRequest actualRequest =
        ((ListMerchantCenterAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMerchantCenterAccountLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMerchantCenterAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMerchantCenterAccountLinkTest() throws Exception {
    MerchantCenterAccountLink expectedResponse =
        MerchantCenterAccountLink.newBuilder()
            .setName(
                MerchantCenterAccountLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
                    .toString())
            .setId("id3355")
            .setMerchantCenterAccountId(-1368465440)
            .setBranchId("branchId-25407907")
            .setFeedLabel("feedLabel-1661895690")
            .setLanguageCode("languageCode-2092349083")
            .addAllFeedFilters(new ArrayList<MerchantCenterAccountLink.MerchantCenterFeedFilter>())
            .setProjectId("projectId-894832108")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMerchantCenterAccountLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMerchantCenterAccountLinkService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    MerchantCenterAccountLink merchantCenterAccountLink =
        MerchantCenterAccountLink.newBuilder().build();

    MerchantCenterAccountLink actualResponse =
        client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMerchantCenterAccountLinkRequest actualRequest =
        ((CreateMerchantCenterAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(merchantCenterAccountLink, actualRequest.getMerchantCenterAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMerchantCenterAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      MerchantCenterAccountLink merchantCenterAccountLink =
          MerchantCenterAccountLink.newBuilder().build();
      client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMerchantCenterAccountLinkTest2() throws Exception {
    MerchantCenterAccountLink expectedResponse =
        MerchantCenterAccountLink.newBuilder()
            .setName(
                MerchantCenterAccountLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
                    .toString())
            .setId("id3355")
            .setMerchantCenterAccountId(-1368465440)
            .setBranchId("branchId-25407907")
            .setFeedLabel("feedLabel-1661895690")
            .setLanguageCode("languageCode-2092349083")
            .addAllFeedFilters(new ArrayList<MerchantCenterAccountLink.MerchantCenterFeedFilter>())
            .setProjectId("projectId-894832108")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMerchantCenterAccountLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMerchantCenterAccountLinkService.addResponse(resultOperation);

    String parent = "parent-995424086";
    MerchantCenterAccountLink merchantCenterAccountLink =
        MerchantCenterAccountLink.newBuilder().build();

    MerchantCenterAccountLink actualResponse =
        client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMerchantCenterAccountLinkRequest actualRequest =
        ((CreateMerchantCenterAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(merchantCenterAccountLink, actualRequest.getMerchantCenterAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMerchantCenterAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      MerchantCenterAccountLink merchantCenterAccountLink =
          MerchantCenterAccountLink.newBuilder().build();
      client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMerchantCenterAccountLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMerchantCenterAccountLinkService.addResponse(expectedResponse);

    MerchantCenterAccountLinkName name =
        MerchantCenterAccountLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]");

    client.deleteMerchantCenterAccountLink(name);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMerchantCenterAccountLinkRequest actualRequest =
        ((DeleteMerchantCenterAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMerchantCenterAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      MerchantCenterAccountLinkName name =
          MerchantCenterAccountLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]");
      client.deleteMerchantCenterAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMerchantCenterAccountLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMerchantCenterAccountLinkService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMerchantCenterAccountLink(name);

    List<AbstractMessage> actualRequests = mockMerchantCenterAccountLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMerchantCenterAccountLinkRequest actualRequest =
        ((DeleteMerchantCenterAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMerchantCenterAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMerchantCenterAccountLinkService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMerchantCenterAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
