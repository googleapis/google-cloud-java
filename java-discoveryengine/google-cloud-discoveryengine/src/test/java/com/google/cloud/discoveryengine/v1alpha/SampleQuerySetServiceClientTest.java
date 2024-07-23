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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

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
public class SampleQuerySetServiceClientTest {
  private static MockLocations mockLocations;
  private static MockSampleQuerySetService mockSampleQuerySetService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SampleQuerySetServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSampleQuerySetService = new MockSampleQuerySetService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSampleQuerySetService, mockLocations));
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
    SampleQuerySetServiceSettings settings =
        SampleQuerySetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SampleQuerySetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getSampleQuerySetTest() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    SampleQuerySetName name =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    SampleQuerySet actualResponse = client.getSampleQuerySet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSampleQuerySetRequest actualRequest = ((GetSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSampleQuerySetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      SampleQuerySetName name =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      client.getSampleQuerySet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSampleQuerySetTest2() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    String name = "name3373707";

    SampleQuerySet actualResponse = client.getSampleQuerySet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSampleQuerySetRequest actualRequest = ((GetSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSampleQuerySetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      String name = "name3373707";
      client.getSampleQuerySet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQuerySetsTest() throws Exception {
    SampleQuerySet responsesElement = SampleQuerySet.newBuilder().build();
    ListSampleQuerySetsResponse expectedResponse =
        ListSampleQuerySetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQuerySets(Arrays.asList(responsesElement))
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSampleQuerySetsPagedResponse pagedListResponse = client.listSampleQuerySets(parent);

    List<SampleQuerySet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQuerySetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSampleQuerySetsRequest actualRequest = ((ListSampleQuerySetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSampleQuerySetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSampleQuerySets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQuerySetsTest2() throws Exception {
    SampleQuerySet responsesElement = SampleQuerySet.newBuilder().build();
    ListSampleQuerySetsResponse expectedResponse =
        ListSampleQuerySetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQuerySets(Arrays.asList(responsesElement))
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSampleQuerySetsPagedResponse pagedListResponse = client.listSampleQuerySets(parent);

    List<SampleQuerySet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQuerySetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSampleQuerySetsRequest actualRequest = ((ListSampleQuerySetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSampleQuerySetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSampleQuerySets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQuerySetTest() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
    String sampleQuerySetId = "sampleQuerySetId1320431231";

    SampleQuerySet actualResponse =
        client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSampleQuerySetRequest actualRequest =
        ((CreateSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sampleQuerySet, actualRequest.getSampleQuerySet());
    Assert.assertEquals(sampleQuerySetId, actualRequest.getSampleQuerySetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSampleQuerySetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
      String sampleQuerySetId = "sampleQuerySetId1320431231";
      client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQuerySetTest2() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
    String sampleQuerySetId = "sampleQuerySetId1320431231";

    SampleQuerySet actualResponse =
        client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSampleQuerySetRequest actualRequest =
        ((CreateSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sampleQuerySet, actualRequest.getSampleQuerySet());
    Assert.assertEquals(sampleQuerySetId, actualRequest.getSampleQuerySetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSampleQuerySetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      String parent = "parent-995424086";
      SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
      String sampleQuerySetId = "sampleQuerySetId1320431231";
      client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSampleQuerySetTest() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SampleQuerySet actualResponse = client.updateSampleQuerySet(sampleQuerySet, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSampleQuerySetRequest actualRequest =
        ((UpdateSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(sampleQuerySet, actualRequest.getSampleQuerySet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSampleQuerySetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSampleQuerySet(sampleQuerySet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQuerySetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    SampleQuerySetName name =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    client.deleteSampleQuerySet(name);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSampleQuerySetRequest actualRequest =
        ((DeleteSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSampleQuerySetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      SampleQuerySetName name =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      client.deleteSampleQuerySet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQuerySetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSampleQuerySetService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSampleQuerySet(name);

    List<AbstractMessage> actualRequests = mockSampleQuerySetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSampleQuerySetRequest actualRequest =
        ((DeleteSampleQuerySetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSampleQuerySetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSampleQuerySetService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSampleQuerySet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
