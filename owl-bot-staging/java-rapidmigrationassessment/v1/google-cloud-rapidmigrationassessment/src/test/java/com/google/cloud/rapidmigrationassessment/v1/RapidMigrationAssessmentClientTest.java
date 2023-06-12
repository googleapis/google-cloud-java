/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.rapidmigrationassessment.v1;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class RapidMigrationAssessmentClientTest {
  private static MockLocations mockLocations;
  private static MockRapidMigrationAssessment mockRapidMigrationAssessment;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RapidMigrationAssessmentClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRapidMigrationAssessment = new MockRapidMigrationAssessment();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRapidMigrationAssessment, mockLocations));
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
    RapidMigrationAssessmentSettings settings =
        RapidMigrationAssessmentSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RapidMigrationAssessmentClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Collector collector = Collector.newBuilder().build();
    String collectorId = "collectorId1854072456";

    Collector actualResponse = client.createCollectorAsync(parent, collector, collectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCollectorRequest actualRequest = ((CreateCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(collector, actualRequest.getCollector());
    Assert.assertEquals(collectorId, actualRequest.getCollectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Collector collector = Collector.newBuilder().build();
      String collectorId = "collectorId1854072456";
      client.createCollectorAsync(parent, collector, collectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String parent = "parent-995424086";
    Collector collector = Collector.newBuilder().build();
    String collectorId = "collectorId1854072456";

    Collector actualResponse = client.createCollectorAsync(parent, collector, collectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCollectorRequest actualRequest = ((CreateCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(collector, actualRequest.getCollector());
    Assert.assertEquals(collectorId, actualRequest.getCollectorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String parent = "parent-995424086";
      Collector collector = Collector.newBuilder().build();
      String collectorId = "collectorId1854072456";
      client.createCollectorAsync(parent, collector, collectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAnnotationTest() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnnotationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Annotation annotation = Annotation.newBuilder().build();

    Annotation actualResponse = client.createAnnotationAsync(parent, annotation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationRequest actualRequest = ((CreateAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Annotation annotation = Annotation.newBuilder().build();
      client.createAnnotationAsync(parent, annotation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAnnotationTest2() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnnotationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String parent = "parent-995424086";
    Annotation annotation = Annotation.newBuilder().build();

    Annotation actualResponse = client.createAnnotationAsync(parent, annotation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationRequest actualRequest = ((CreateAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String parent = "parent-995424086";
      Annotation annotation = Annotation.newBuilder().build();
      client.createAnnotationAsync(parent, annotation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAnnotationTest() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    AnnotationName name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]");

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationRequest actualRequest = ((GetAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      AnnotationName name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]");
      client.getAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotationTest2() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    String name = "name3373707";

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationRequest actualRequest = ((GetAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.getAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCollectorsTest() throws Exception {
    Collector responsesElement = Collector.newBuilder().build();
    ListCollectorsResponse expectedResponse =
        ListCollectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollectors(Arrays.asList(responsesElement))
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCollectorsPagedResponse pagedListResponse = client.listCollectors(parent);

    List<Collector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectorsRequest actualRequest = ((ListCollectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCollectorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCollectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCollectorsTest2() throws Exception {
    Collector responsesElement = Collector.newBuilder().build();
    ListCollectorsResponse expectedResponse =
        ListCollectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollectors(Arrays.asList(responsesElement))
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCollectorsPagedResponse pagedListResponse = client.listCollectors(parent);

    List<Collector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectorsRequest actualRequest = ((ListCollectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCollectorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCollectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.getCollector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCollectorRequest actualRequest = ((GetCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.getCollector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    mockRapidMigrationAssessment.addResponse(expectedResponse);

    String name = "name3373707";

    Collector actualResponse = client.getCollector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCollectorRequest actualRequest = ((GetCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.getCollector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    Collector collector = Collector.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Collector actualResponse = client.updateCollectorAsync(collector, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCollectorRequest actualRequest = ((UpdateCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(collector, actualRequest.getCollector());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      Collector collector = Collector.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCollectorAsync(collector, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.deleteCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCollectorRequest actualRequest = ((DeleteCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.deleteCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String name = "name3373707";

    Collector actualResponse = client.deleteCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCollectorRequest actualRequest = ((DeleteCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resumeCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.resumeCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeCollectorRequest actualRequest = ((ResumeCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.resumeCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void resumeCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resumeCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String name = "name3373707";

    Collector actualResponse = client.resumeCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResumeCollectorRequest actualRequest = ((ResumeCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resumeCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.resumeCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void registerCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.registerCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterCollectorRequest actualRequest = ((RegisterCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.registerCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void registerCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String name = "name3373707";

    Collector actualResponse = client.registerCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterCollectorRequest actualRequest = ((RegisterCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.registerCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void pauseCollectorTest() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("pauseCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.pauseCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseCollectorRequest actualRequest = ((PauseCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseCollectorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.pauseCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void pauseCollectorTest2() throws Exception {
    Collector expectedResponse =
        Collector.newBuilder()
            .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setBucket("bucket-1378203158")
            .setExpectedAssetCount(290454521)
            .setClientVersion("clientVersion771880589")
            .setGuestOsScan(GuestOsScan.newBuilder().build())
            .setVsphereScan(VSphereScan.newBuilder().build())
            .setCollectionDays(1060007256)
            .setEulaUri("eulaUri-1399082745")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("pauseCollectorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRapidMigrationAssessment.addResponse(resultOperation);

    String name = "name3373707";

    Collector actualResponse = client.pauseCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRapidMigrationAssessment.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PauseCollectorRequest actualRequest = ((PauseCollectorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pauseCollectorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRapidMigrationAssessment.addException(exception);

    try {
      String name = "name3373707";
      client.pauseCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
