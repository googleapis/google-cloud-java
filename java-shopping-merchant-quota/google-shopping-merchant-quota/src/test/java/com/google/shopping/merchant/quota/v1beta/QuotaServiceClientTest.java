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

package com.google.shopping.merchant.quota.v1beta;

import static com.google.shopping.merchant.quota.v1beta.QuotaServiceClient.ListQuotaGroupsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class QuotaServiceClientTest {
  private static MockQuotaService mockQuotaService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private QuotaServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockQuotaService = new MockQuotaService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockQuotaService));
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
    QuotaServiceSettings settings =
        QuotaServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = QuotaServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listQuotaGroupsTest() throws Exception {
    QuotaGroup responsesElement = QuotaGroup.newBuilder().build();
    ListQuotaGroupsResponse expectedResponse =
        ListQuotaGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaGroups(Arrays.asList(responsesElement))
            .build();
    mockQuotaService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListQuotaGroupsPagedResponse pagedListResponse = client.listQuotaGroups(parent);

    List<QuotaGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockQuotaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaGroupsRequest actualRequest = ((ListQuotaGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listQuotaGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaGroupsTest2() throws Exception {
    QuotaGroup responsesElement = QuotaGroup.newBuilder().build();
    ListQuotaGroupsResponse expectedResponse =
        ListQuotaGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaGroups(Arrays.asList(responsesElement))
            .build();
    mockQuotaService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQuotaGroupsPagedResponse pagedListResponse = client.listQuotaGroups(parent);

    List<QuotaGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockQuotaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQuotaGroupsRequest actualRequest = ((ListQuotaGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQuotaGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockQuotaService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listQuotaGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
