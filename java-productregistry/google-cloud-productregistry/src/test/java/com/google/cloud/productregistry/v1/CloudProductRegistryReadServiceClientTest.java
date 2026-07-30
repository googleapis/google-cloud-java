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

package com.google.cloud.productregistry.v1;

import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductVariantsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListProductSuitesPagedResponse;

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
import java.util.ArrayList;
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
public class CloudProductRegistryReadServiceClientTest {
  private static MockCloudProductRegistryReadService mockCloudProductRegistryReadService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudProductRegistryReadServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudProductRegistryReadService = new MockCloudProductRegistryReadService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudProductRegistryReadService));
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
    CloudProductRegistryReadServiceSettings settings =
        CloudProductRegistryReadServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudProductRegistryReadServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProductSuiteTest() throws Exception {
    ProductSuite expectedResponse =
        ProductSuite.newBuilder()
            .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .setTitle("title110371416")
            .addAllLogicalProducts(new ArrayList<String>())
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");

    ProductSuite actualResponse = client.getProductSuite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductSuiteRequest actualRequest = ((GetProductSuiteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductSuiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      ProductSuiteName name = ProductSuiteName.of("[PRODUCT_SUITE]");
      client.getProductSuite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProductSuiteTest2() throws Exception {
    ProductSuite expectedResponse =
        ProductSuite.newBuilder()
            .setName(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .setTitle("title110371416")
            .addAllLogicalProducts(new ArrayList<String>())
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    String name = "name3373707";

    ProductSuite actualResponse = client.getProductSuite(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProductSuiteRequest actualRequest = ((GetProductSuiteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProductSuiteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      String name = "name3373707";
      client.getProductSuite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductSuitesTest() throws Exception {
    ProductSuite responsesElement = ProductSuite.newBuilder().build();
    ListProductSuitesResponse expectedResponse =
        ListProductSuitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProductSuites(Arrays.asList(responsesElement))
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    ListProductSuitesRequest request =
        ListProductSuitesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListProductSuitesPagedResponse pagedListResponse = client.listProductSuites(request);

    List<ProductSuite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductSuitesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductSuitesRequest actualRequest = ((ListProductSuitesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductSuitesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      ListProductSuitesRequest request =
          ListProductSuitesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listProductSuites(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductTest() throws Exception {
    LogicalProduct expectedResponse =
        LogicalProduct.newBuilder()
            .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
            .setTitle("title110371416")
            .setProductSuite(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .addAllVariants(new ArrayList<String>())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    LogicalProductName name = LogicalProductName.of("[LOGICAL_PRODUCT]");

    LogicalProduct actualResponse = client.getLogicalProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalProductRequest actualRequest = ((GetLogicalProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      LogicalProductName name = LogicalProductName.of("[LOGICAL_PRODUCT]");
      client.getLogicalProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductTest2() throws Exception {
    LogicalProduct expectedResponse =
        LogicalProduct.newBuilder()
            .setName(LogicalProductName.of("[LOGICAL_PRODUCT]").toString())
            .setTitle("title110371416")
            .setProductSuite(ProductSuiteName.of("[PRODUCT_SUITE]").toString())
            .addAllVariants(new ArrayList<String>())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    String name = "name3373707";

    LogicalProduct actualResponse = client.getLogicalProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalProductRequest actualRequest = ((GetLogicalProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      String name = "name3373707";
      client.getLogicalProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductsTest() throws Exception {
    LogicalProduct responsesElement = LogicalProduct.newBuilder().build();
    ListLogicalProductsResponse expectedResponse =
        ListLogicalProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProducts(Arrays.asList(responsesElement))
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    ListLogicalProductsRequest request =
        ListLogicalProductsRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLogicalProductsPagedResponse pagedListResponse = client.listLogicalProducts(request);

    List<LogicalProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogicalProductsRequest actualRequest = ((ListLogicalProductsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogicalProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      ListLogicalProductsRequest request =
          ListLogicalProductsRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLogicalProducts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductVariantTest() throws Exception {
    LogicalProductVariant expectedResponse =
        LogicalProductVariant.newBuilder()
            .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
            .setTitle("title110371416")
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    LogicalProductVariantName name = LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]");

    LogicalProductVariant actualResponse = client.getLogicalProductVariant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalProductVariantRequest actualRequest =
        ((GetLogicalProductVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalProductVariantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      LogicalProductVariantName name =
          LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]");
      client.getLogicalProductVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLogicalProductVariantTest2() throws Exception {
    LogicalProductVariant expectedResponse =
        LogicalProductVariant.newBuilder()
            .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
            .setTitle("title110371416")
            .setLifecycleState(LifecycleState.forNumber(0))
            .setReplaced(true)
            .setReplacement("replacement430919186")
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    String name = "name3373707";

    LogicalProductVariant actualResponse = client.getLogicalProductVariant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLogicalProductVariantRequest actualRequest =
        ((GetLogicalProductVariantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLogicalProductVariantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      String name = "name3373707";
      client.getLogicalProductVariant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductVariantsTest() throws Exception {
    LogicalProductVariant responsesElement = LogicalProductVariant.newBuilder().build();
    ListLogicalProductVariantsResponse expectedResponse =
        ListLogicalProductVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProductVariants(Arrays.asList(responsesElement))
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    LogicalProductName parent = LogicalProductName.of("[LOGICAL_PRODUCT]");

    ListLogicalProductVariantsPagedResponse pagedListResponse =
        client.listLogicalProductVariants(parent);

    List<LogicalProductVariant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductVariantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogicalProductVariantsRequest actualRequest =
        ((ListLogicalProductVariantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogicalProductVariantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      LogicalProductName parent = LogicalProductName.of("[LOGICAL_PRODUCT]");
      client.listLogicalProductVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLogicalProductVariantsTest2() throws Exception {
    LogicalProductVariant responsesElement = LogicalProductVariant.newBuilder().build();
    ListLogicalProductVariantsResponse expectedResponse =
        ListLogicalProductVariantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLogicalProductVariants(Arrays.asList(responsesElement))
            .build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLogicalProductVariantsPagedResponse pagedListResponse =
        client.listLogicalProductVariants(parent);

    List<LogicalProductVariant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLogicalProductVariantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLogicalProductVariantsRequest actualRequest =
        ((ListLogicalProductVariantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLogicalProductVariantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLogicalProductVariants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEntityTest() throws Exception {
    LookupEntityResponse expectedResponse = LookupEntityResponse.newBuilder().build();
    mockCloudProductRegistryReadService.addResponse(expectedResponse);

    LookupEntityRequest request =
        LookupEntityRequest.newBuilder().setLookupUri("lookupUri1150318994").build();

    LookupEntityResponse actualResponse = client.lookupEntity(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudProductRegistryReadService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupEntityRequest actualRequest = ((LookupEntityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLookupUri(), actualRequest.getLookupUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupEntityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudProductRegistryReadService.addException(exception);

    try {
      LookupEntityRequest request =
          LookupEntityRequest.newBuilder().setLookupUri("lookupUri1150318994").build();
      client.lookupEntity(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
