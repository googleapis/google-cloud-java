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

package com.google.shopping.merchant.issueresolution.v1beta;

import static com.google.shopping.merchant.issueresolution.v1beta.AggregateProductStatusesServiceClient.ListAggregateProductStatusesPagedResponse;

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
public class AggregateProductStatusesServiceClientTest {
  private static MockAggregateProductStatusesService mockAggregateProductStatusesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AggregateProductStatusesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAggregateProductStatusesService = new MockAggregateProductStatusesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAggregateProductStatusesService));
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
    AggregateProductStatusesServiceSettings settings =
        AggregateProductStatusesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AggregateProductStatusesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAggregateProductStatusesTest() throws Exception {
    AggregateProductStatus responsesElement = AggregateProductStatus.newBuilder().build();
    ListAggregateProductStatusesResponse expectedResponse =
        ListAggregateProductStatusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAggregateProductStatuses(Arrays.asList(responsesElement))
            .build();
    mockAggregateProductStatusesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListAggregateProductStatusesPagedResponse pagedListResponse =
        client.listAggregateProductStatuses(parent);

    List<AggregateProductStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAggregateProductStatusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAggregateProductStatusesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAggregateProductStatusesRequest actualRequest =
        ((ListAggregateProductStatusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAggregateProductStatusesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAggregateProductStatusesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listAggregateProductStatuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAggregateProductStatusesTest2() throws Exception {
    AggregateProductStatus responsesElement = AggregateProductStatus.newBuilder().build();
    ListAggregateProductStatusesResponse expectedResponse =
        ListAggregateProductStatusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAggregateProductStatuses(Arrays.asList(responsesElement))
            .build();
    mockAggregateProductStatusesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAggregateProductStatusesPagedResponse pagedListResponse =
        client.listAggregateProductStatuses(parent);

    List<AggregateProductStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAggregateProductStatusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAggregateProductStatusesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAggregateProductStatusesRequest actualRequest =
        ((ListAggregateProductStatusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAggregateProductStatusesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAggregateProductStatusesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAggregateProductStatuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
