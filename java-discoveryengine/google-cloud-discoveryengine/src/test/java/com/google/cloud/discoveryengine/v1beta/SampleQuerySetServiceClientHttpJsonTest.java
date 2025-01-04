/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonSampleQuerySetServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SampleQuerySetServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SampleQuerySetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSampleQuerySetServiceStub.getMethodDescriptors(),
            SampleQuerySetServiceSettings.getDefaultEndpoint());
    SampleQuerySetServiceSettings settings =
        SampleQuerySetServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SampleQuerySetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SampleQuerySetServiceClient.create(settings);
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
  public void getSampleQuerySetTest() throws Exception {
    SampleQuerySet expectedResponse =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    SampleQuerySetName name =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    SampleQuerySet actualResponse = client.getSampleQuerySet(name);
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
  public void getSampleQuerySetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9093/locations/location-9093/sampleQuerySets/sampleQuerySet-9093";

    SampleQuerySet actualResponse = client.getSampleQuerySet(name);
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
  public void getSampleQuerySetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9093/locations/location-9093/sampleQuerySets/sampleQuerySet-9093";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSampleQuerySetsPagedResponse pagedListResponse = client.listSampleQuerySets(parent);

    List<SampleQuerySet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQuerySetsList().get(0), resources.get(0));

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
  public void listSampleQuerySetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSampleQuerySetsPagedResponse pagedListResponse = client.listSampleQuerySets(parent);

    List<SampleQuerySet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQuerySetsList().get(0), resources.get(0));

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
  public void listSampleQuerySetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
    String sampleQuerySetId = "sampleQuerySetId1320431231";

    SampleQuerySet actualResponse =
        client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
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
  public void createSampleQuerySetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
    String sampleQuerySetId = "sampleQuerySetId1320431231";

    SampleQuerySet actualResponse =
        client.createSampleQuerySet(parent, sampleQuerySet, sampleQuerySetId);
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
  public void createSampleQuerySetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    SampleQuerySet sampleQuerySet =
        SampleQuerySet.newBuilder()
            .setName(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SampleQuerySet actualResponse = client.updateSampleQuerySet(sampleQuerySet, updateMask);
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
  public void updateSampleQuerySetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQuerySet sampleQuerySet =
          SampleQuerySet.newBuilder()
              .setName(
                  SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .build();
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
    mockService.addResponse(expectedResponse);

    SampleQuerySetName name =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    client.deleteSampleQuerySet(name);

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
  public void deleteSampleQuerySetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9093/locations/location-9093/sampleQuerySets/sampleQuerySet-9093";

    client.deleteSampleQuerySet(name);

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
  public void deleteSampleQuerySetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9093/locations/location-9093/sampleQuerySets/sampleQuerySet-9093";
      client.deleteSampleQuerySet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
