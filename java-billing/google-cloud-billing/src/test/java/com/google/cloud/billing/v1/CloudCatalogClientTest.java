/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CloudCatalogClientTest {
  private static MockCloudBilling mockCloudBilling;
  private static MockCloudCatalog mockCloudCatalog;
  private static MockServiceHelper serviceHelper;
  private CloudCatalogClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudBilling = new MockCloudBilling();
    mockCloudCatalog = new MockCloudCatalog();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudBilling, mockCloudCatalog));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void listServicesTest() {
    String nextPageToken = "";
    Service servicesElement = Service.newBuilder().build();
    List<Service> services = Arrays.asList(servicesElement);
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllServices(services)
            .build();
    mockCloudCatalog.addResponse(expectedResponse);

    ListServicesPagedResponse pagedListResponse = client.listServices();

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = (ListServicesRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudCatalog.addException(exception);

    try {

      client.listServices();
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSkusTest() {
    String nextPageToken = "";
    Sku skusElement = Sku.newBuilder().build();
    List<Sku> skus = Arrays.asList(skusElement);
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder().setNextPageToken(nextPageToken).addAllSkus(skus).build();
    mockCloudCatalog.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[SERVICE]");

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = (ListSkusRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ServiceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCloudCatalog.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[SERVICE]");

      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
