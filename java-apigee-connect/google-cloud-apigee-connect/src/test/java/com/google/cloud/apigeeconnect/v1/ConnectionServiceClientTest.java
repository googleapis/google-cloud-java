/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.apigeeconnect.v1;

import static com.google.cloud.apigeeconnect.v1.ConnectionServiceClient.ListConnectionsPagedResponse;

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
public class ConnectionServiceClientTest {
  private static MockConnectionService mockConnectionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConnectionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConnectionService = new MockConnectionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockConnectionService));
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
    ConnectionServiceSettings settings =
        ConnectionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConnectionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConnectionsTest() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockConnectionService.addResponse(expectedResponse);

    EndpointName parent = EndpointName.of("[PROJECT]", "[ENDPOINT]");

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionsRequest actualRequest = ((ListConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      EndpointName parent = EndpointName.of("[PROJECT]", "[ENDPOINT]");
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionsTest2() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockConnectionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConnectionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionsRequest actualRequest = ((ListConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConnectionService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
