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

package com.google.cloud.rapidmigrationassessment.v1;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.stub.HttpJsonRapidMigrationAssessmentStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RapidMigrationAssessmentClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RapidMigrationAssessmentClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRapidMigrationAssessmentStub.getMethodDescriptors(),
            RapidMigrationAssessmentSettings.getDefaultEndpoint());
    RapidMigrationAssessmentSettings settings =
        RapidMigrationAssessmentSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RapidMigrationAssessmentSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RapidMigrationAssessmentClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Collector collector = Collector.newBuilder().build();
    String collectorId = "collectorId1854072456";

    Collector actualResponse = client.createCollectorAsync(parent, collector, collectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Collector collector = Collector.newBuilder().build();
      String collectorId = "collectorId1854072456";
      client.createCollectorAsync(parent, collector, collectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Collector collector = Collector.newBuilder().build();
    String collectorId = "collectorId1854072456";

    Collector actualResponse = client.createCollectorAsync(parent, collector, collectorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Collector collector = Collector.newBuilder().build();
      String collectorId = "collectorId1854072456";
      client.createCollectorAsync(parent, collector, collectorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Annotation annotation = Annotation.newBuilder().build();

    Annotation actualResponse = client.createAnnotationAsync(parent, annotation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Annotation annotation = Annotation.newBuilder().build();
      client.createAnnotationAsync(parent, annotation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Annotation annotation = Annotation.newBuilder().build();

    Annotation actualResponse = client.createAnnotationAsync(parent, annotation).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createAnnotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Annotation annotation = Annotation.newBuilder().build();
      client.createAnnotationAsync(parent, annotation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AnnotationName name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]");

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1098/locations/location-1098/annotations/annotation-1098";

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAnnotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1098/locations/location-1098/annotations/annotation-1098";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCollectorsPagedResponse pagedListResponse = client.listCollectors(parent);

    List<Collector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectorsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCollectorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCollectorsPagedResponse pagedListResponse = client.listCollectors(parent);

    List<Collector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectorsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCollectorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.getCollector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";

    Collector actualResponse = client.getCollector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";
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
    mockService.addResponse(resultOperation);

    Collector collector =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Collector actualResponse = client.updateCollectorAsync(collector, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Collector collector =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCollectorAsync(collector, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.deleteCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.deleteCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";

    Collector actualResponse = client.deleteCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";
      client.deleteCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.resumeCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void resumeCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.resumeCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";

    Collector actualResponse = client.resumeCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void resumeCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";
      client.resumeCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.registerCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void registerCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.registerCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";

    Collector actualResponse = client.registerCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void registerCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";
      client.registerCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");

    Collector actualResponse = client.pauseCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pauseCollectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
      client.pauseCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";

    Collector actualResponse = client.pauseCollectorAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pauseCollectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2058/locations/location-2058/collectors/collector-2058";
      client.pauseCollectorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
