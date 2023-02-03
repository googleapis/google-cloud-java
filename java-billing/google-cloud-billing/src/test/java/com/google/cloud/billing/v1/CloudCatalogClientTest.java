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

package com.google.cloud.billing.v1;

import static com.google.cloud.billing.v1.CloudCatalogClient.ListServicesPagedResponse;
import static com.google.cloud.billing.v1.CloudCatalogClient.ListSkusPagedResponse;

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
public class CloudCatalogClientTest {
  private static MockCloudCatalog mockCloudCatalog;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudCatalogClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudCatalog = new MockCloudCatalog();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudCatalog));
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
    CloudCatalogSettings settings =
        CloudCatalogSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudCatalogClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockCloudCatalog.addResponse(expectedResponse);

    ListServicesPagedResponse pagedListResponse = client.listServices();

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudCatalog.addException(exception);

    try {
      ListServicesRequest request =
          ListServicesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listServices(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockCloudCatalog.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[SERVICE]");

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = ((ListSkusRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudCatalog.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[SERVICE]");
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest2() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockCloudCatalog.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = ((ListSkusRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSkusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudCatalog.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
