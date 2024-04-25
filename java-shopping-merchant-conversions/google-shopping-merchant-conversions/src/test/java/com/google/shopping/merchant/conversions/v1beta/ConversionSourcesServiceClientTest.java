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

package com.google.shopping.merchant.conversions.v1beta;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class ConversionSourcesServiceClientTest {
  private static MockConversionSourcesService mockConversionSourcesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConversionSourcesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConversionSourcesService = new MockConversionSourcesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConversionSourcesService));
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
    ConversionSourcesServiceSettings settings =
        ConversionSourcesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversionSourcesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    ConversionSource conversionSource = ConversionSource.newBuilder().build();

    ConversionSource actualResponse = client.createConversionSource(parent, conversionSource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionSourceRequest actualRequest =
        ((CreateConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversionSource, actualRequest.getConversionSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      client.createConversionSource(parent, conversionSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversionSourceTest2() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ConversionSource conversionSource = ConversionSource.newBuilder().build();

    ConversionSource actualResponse = client.createConversionSource(parent, conversionSource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversionSourceRequest actualRequest =
        ((CreateConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversionSource, actualRequest.getConversionSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversionSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      String parent = "parent-995424086";
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      client.createConversionSource(parent, conversionSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    ConversionSource conversionSource = ConversionSource.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversionSource actualResponse = client.updateConversionSource(conversionSource, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConversionSourceRequest actualRequest =
        ((UpdateConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(conversionSource, actualRequest.getConversionSource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConversionSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversionSource(conversionSource, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConversionSourcesService.addResponse(expectedResponse);

    ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");

    client.deleteConversionSource(name);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionSourceRequest actualRequest =
        ((DeleteConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
      client.deleteConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConversionSourcesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversionSource(name);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversionSourceRequest actualRequest =
        ((DeleteConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversionSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    UndeleteConversionSourceRequest request =
        UndeleteConversionSourceRequest.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .build();

    ConversionSource actualResponse = client.undeleteConversionSource(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteConversionSourceRequest actualRequest =
        ((UndeleteConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteConversionSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      UndeleteConversionSourceRequest request =
          UndeleteConversionSourceRequest.newBuilder()
              .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
              .build();
      client.undeleteConversionSource(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");

    ConversionSource actualResponse = client.getConversionSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionSourceRequest actualRequest = ((GetConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
      client.getConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionSourceTest2() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    String name = "name3373707";

    ConversionSource actualResponse = client.getConversionSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversionSourceRequest actualRequest = ((GetConversionSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversionSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      String name = "name3373707";
      client.getConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionSourcesTest() throws Exception {
    ConversionSource responsesElement = ConversionSource.newBuilder().build();
    ListConversionSourcesResponse expectedResponse =
        ListConversionSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionSources(Arrays.asList(responsesElement))
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListConversionSourcesPagedResponse pagedListResponse = client.listConversionSources(parent);

    List<ConversionSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionSourcesRequest actualRequest =
        ((ListConversionSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listConversionSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionSourcesTest2() throws Exception {
    ConversionSource responsesElement = ConversionSource.newBuilder().build();
    ListConversionSourcesResponse expectedResponse =
        ListConversionSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionSources(Arrays.asList(responsesElement))
            .build();
    mockConversionSourcesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversionSourcesPagedResponse pagedListResponse = client.listConversionSources(parent);

    List<ConversionSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversionSourcesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversionSourcesRequest actualRequest =
        ((ListConversionSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversionSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversionSourcesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversionSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
