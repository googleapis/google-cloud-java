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

package com.google.ads.marketingplatform.admin.v1alpha;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;

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
public class MarketingplatformAdminServiceClientTest {
  private static MockMarketingplatformAdminService mockMarketingplatformAdminService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MarketingplatformAdminServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMarketingplatformAdminService = new MockMarketingplatformAdminService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMarketingplatformAdminService));
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
    MarketingplatformAdminServiceSettings settings =
        MarketingplatformAdminServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MarketingplatformAdminServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOrganizationTest() throws Exception {
    Organization expectedResponse =
        Organization.newBuilder()
            .setName(OrganizationName.of("[ORGANIZATION]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    Organization actualResponse = client.getOrganization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationRequest actualRequest = ((GetOrganizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.getOrganization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationTest2() throws Exception {
    Organization expectedResponse =
        Organization.newBuilder()
            .setName(OrganizationName.of("[ORGANIZATION]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    Organization actualResponse = client.getOrganization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationRequest actualRequest = ((GetOrganizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.getOrganization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyticsAccountLinksTest() throws Exception {
    AnalyticsAccountLink responsesElement = AnalyticsAccountLink.newBuilder().build();
    ListAnalyticsAccountLinksResponse expectedResponse =
        ListAnalyticsAccountLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyticsAccountLinks(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyticsAccountLinksRequest actualRequest =
        ((ListAnalyticsAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyticsAccountLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listAnalyticsAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalyticsAccountLinksTest2() throws Exception {
    AnalyticsAccountLink responsesElement = AnalyticsAccountLink.newBuilder().build();
    ListAnalyticsAccountLinksResponse expectedResponse =
        ListAnalyticsAccountLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyticsAccountLinks(Arrays.asList(responsesElement))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalyticsAccountLinksPagedResponse pagedListResponse =
        client.listAnalyticsAccountLinks(parent);

    List<AnalyticsAccountLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalyticsAccountLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalyticsAccountLinksRequest actualRequest =
        ((ListAnalyticsAccountLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalyticsAccountLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAnalyticsAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalyticsAccountLinkTest() throws Exception {
    AnalyticsAccountLink expectedResponse =
        AnalyticsAccountLink.newBuilder()
            .setName(
                AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
                    .toString())
            .setAnalyticsAccount("analyticsAccount-1287740473")
            .setDisplayName("displayName1714148973")
            .setLinkVerificationState(LinkVerificationState.forNumber(0))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalyticsAccountLinkRequest actualRequest =
        ((CreateAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalyticsAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
      client.createAnalyticsAccountLink(parent, analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalyticsAccountLinkTest2() throws Exception {
    AnalyticsAccountLink expectedResponse =
        AnalyticsAccountLink.newBuilder()
            .setName(
                AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
                    .toString())
            .setAnalyticsAccount("analyticsAccount-1287740473")
            .setDisplayName("displayName1714148973")
            .setLinkVerificationState(LinkVerificationState.forNumber(0))
            .build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();

    AnalyticsAccountLink actualResponse =
        client.createAnalyticsAccountLink(parent, analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalyticsAccountLinkRequest actualRequest =
        ((CreateAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalyticsAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String parent = "parent-995424086";
      AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
      client.createAnalyticsAccountLink(parent, analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalyticsAccountLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    AnalyticsAccountLinkName name =
        AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");

    client.deleteAnalyticsAccountLink(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalyticsAccountLinkRequest actualRequest =
        ((DeleteAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalyticsAccountLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      AnalyticsAccountLinkName name =
          AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");
      client.deleteAnalyticsAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalyticsAccountLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnalyticsAccountLink(name);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalyticsAccountLinkRequest actualRequest =
        ((DeleteAnalyticsAccountLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalyticsAccountLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAnalyticsAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setPropertyServiceLevelTest() throws Exception {
    SetPropertyServiceLevelResponse expectedResponse =
        SetPropertyServiceLevelResponse.newBuilder().build();
    mockMarketingplatformAdminService.addResponse(expectedResponse);

    String analyticsAccountLink = "analyticsAccountLink-397570975";

    SetPropertyServiceLevelResponse actualResponse =
        client.setPropertyServiceLevel(analyticsAccountLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMarketingplatformAdminService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetPropertyServiceLevelRequest actualRequest =
        ((SetPropertyServiceLevelRequest) actualRequests.get(0));

    Assert.assertEquals(analyticsAccountLink, actualRequest.getAnalyticsAccountLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setPropertyServiceLevelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMarketingplatformAdminService.addException(exception);

    try {
      String analyticsAccountLink = "analyticsAccountLink-397570975";
      client.setPropertyServiceLevel(analyticsAccountLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
