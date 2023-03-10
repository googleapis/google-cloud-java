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

package com.google.appengine.v1;

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class DomainMappingsClientTest {
  private static MockDomainMappings mockDomainMappings;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DomainMappingsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDomainMappings = new MockDomainMappings();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDomainMappings));
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
    DomainMappingsSettings settings =
        DomainMappingsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DomainMappingsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDomainMappingsTest() throws Exception {
    DomainMapping responsesElement = DomainMapping.newBuilder().build();
    ListDomainMappingsResponse expectedResponse =
        ListDomainMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDomainMappings(Arrays.asList(responsesElement))
            .build();
    mockDomainMappings.addResponse(expectedResponse);

    ListDomainMappingsRequest request =
        ListDomainMappingsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListDomainMappingsPagedResponse pagedListResponse = client.listDomainMappings(request);

    List<DomainMapping> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDomainMappingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDomainMappings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDomainMappingsRequest actualRequest = ((ListDomainMappingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDomainMappingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomainMappings.addException(exception);

    try {
      ListDomainMappingsRequest request =
          ListDomainMappingsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listDomainMappings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    mockDomainMappings.addResponse(expectedResponse);

    GetDomainMappingRequest request =
        GetDomainMappingRequest.newBuilder().setName("name3373707").build();

    DomainMapping actualResponse = client.getDomainMapping(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomainMappings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDomainMappingRequest actualRequest = ((GetDomainMappingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDomainMappingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomainMappings.addException(exception);

    try {
      GetDomainMappingRequest request =
          GetDomainMappingRequest.newBuilder().setName("name3373707").build();
      client.getDomainMapping(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomainMappings.addResponse(resultOperation);

    CreateDomainMappingRequest request =
        CreateDomainMappingRequest.newBuilder()
            .setParent("parent-995424086")
            .setDomainMapping(DomainMapping.newBuilder().build())
            .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
            .build();

    DomainMapping actualResponse = client.createDomainMappingAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomainMappings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDomainMappingRequest actualRequest = ((CreateDomainMappingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDomainMapping(), actualRequest.getDomainMapping());
    Assert.assertEquals(request.getOverrideStrategy(), actualRequest.getOverrideStrategy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDomainMappingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomainMappings.addException(exception);

    try {
      CreateDomainMappingRequest request =
          CreateDomainMappingRequest.newBuilder()
              .setParent("parent-995424086")
              .setDomainMapping(DomainMapping.newBuilder().build())
              .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
              .build();
      client.createDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomainMappings.addResponse(resultOperation);

    UpdateDomainMappingRequest request =
        UpdateDomainMappingRequest.newBuilder()
            .setName("name3373707")
            .setDomainMapping(DomainMapping.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    DomainMapping actualResponse = client.updateDomainMappingAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomainMappings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDomainMappingRequest actualRequest = ((UpdateDomainMappingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getDomainMapping(), actualRequest.getDomainMapping());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDomainMappingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomainMappings.addException(exception);

    try {
      UpdateDomainMappingRequest request =
          UpdateDomainMappingRequest.newBuilder()
              .setName("name3373707")
              .setDomainMapping(DomainMapping.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDomainMappingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomainMappings.addResponse(resultOperation);

    DeleteDomainMappingRequest request =
        DeleteDomainMappingRequest.newBuilder().setName("name3373707").build();

    client.deleteDomainMappingAsync(request).get();

    List<AbstractMessage> actualRequests = mockDomainMappings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDomainMappingRequest actualRequest = ((DeleteDomainMappingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDomainMappingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomainMappings.addException(exception);

    try {
      DeleteDomainMappingRequest request =
          DeleteDomainMappingRequest.newBuilder().setName("name3373707").build();
      client.deleteDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
