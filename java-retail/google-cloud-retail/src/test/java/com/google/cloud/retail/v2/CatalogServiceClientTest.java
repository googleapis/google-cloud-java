/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.retail.v2;

import static com.google.cloud.retail.v2.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class CatalogServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockServiceHelper mockServiceHelper;
  private CatalogServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCatalogService));
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
    CatalogServiceSettings settings =
        CatalogServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CatalogServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest2() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setProductLevelConfig(ProductLevelConfig.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    Catalog catalog = Catalog.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Catalog actualResponse = client.updateCatalog(catalog, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCatalogRequest actualRequest = ((UpdateCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      Catalog catalog = Catalog.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalog(catalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
