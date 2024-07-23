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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonSampleQueryServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class SampleQueryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SampleQueryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSampleQueryServiceStub.getMethodDescriptors(),
            SampleQueryServiceSettings.getDefaultEndpoint());
    SampleQueryServiceSettings settings =
        SampleQueryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SampleQueryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SampleQueryServiceClient.create(settings);
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
  public void getSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SampleQueryName name =
        SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");

    SampleQuery actualResponse = client.getSampleQuery(name);
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
  public void getSampleQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQueryName name =
          SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
      client.getSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSampleQueryTest2() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5395/locations/location-5395/sampleQuerySets/sampleQuerySet-5395/sampleQueries/sampleQuerie-5395";

    SampleQuery actualResponse = client.getSampleQuery(name);
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
  public void getSampleQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5395/locations/location-5395/sampleQuerySets/sampleQuerySet-5395/sampleQueries/sampleQuerie-5395";
      client.getSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQueriesTest() throws Exception {
    SampleQuery responsesElement = SampleQuery.newBuilder().build();
    ListSampleQueriesResponse expectedResponse =
        ListSampleQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SampleQuerySetName parent =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");

    ListSampleQueriesPagedResponse pagedListResponse = client.listSampleQueries(parent);

    List<SampleQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQueriesList().get(0), resources.get(0));

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
  public void listSampleQueriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQuerySetName parent =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      client.listSampleQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSampleQueriesTest2() throws Exception {
    SampleQuery responsesElement = SampleQuery.newBuilder().build();
    ListSampleQueriesResponse expectedResponse =
        ListSampleQueriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSampleQueries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6140/locations/location-6140/sampleQuerySets/sampleQuerySet-6140";

    ListSampleQueriesPagedResponse pagedListResponse = client.listSampleQueries(parent);

    List<SampleQuery> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSampleQueriesList().get(0), resources.get(0));

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
  public void listSampleQueriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6140/locations/location-6140/sampleQuerySets/sampleQuerySet-6140";
      client.listSampleQueries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SampleQuerySetName parent =
        SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
    SampleQuery sampleQuery = SampleQuery.newBuilder().build();
    String sampleQueryId = "sampleQueryId1739022073";

    SampleQuery actualResponse = client.createSampleQuery(parent, sampleQuery, sampleQueryId);
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
  public void createSampleQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQuerySetName parent =
          SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
      SampleQuery sampleQuery = SampleQuery.newBuilder().build();
      String sampleQueryId = "sampleQueryId1739022073";
      client.createSampleQuery(parent, sampleQuery, sampleQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSampleQueryTest2() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6140/locations/location-6140/sampleQuerySets/sampleQuerySet-6140";
    SampleQuery sampleQuery = SampleQuery.newBuilder().build();
    String sampleQueryId = "sampleQueryId1739022073";

    SampleQuery actualResponse = client.createSampleQuery(parent, sampleQuery, sampleQueryId);
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
  public void createSampleQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6140/locations/location-6140/sampleQuerySets/sampleQuerySet-6140";
      SampleQuery sampleQuery = SampleQuery.newBuilder().build();
      String sampleQueryId = "sampleQueryId1739022073";
      client.createSampleQuery(parent, sampleQuery, sampleQueryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSampleQueryTest() throws Exception {
    SampleQuery expectedResponse =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SampleQuery sampleQuery =
        SampleQuery.newBuilder()
            .setName(
                SampleQueryName.of(
                        "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SampleQuery actualResponse = client.updateSampleQuery(sampleQuery, updateMask);
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
  public void updateSampleQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQuery sampleQuery =
          SampleQuery.newBuilder()
              .setName(
                  SampleQueryName.of(
                          "[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSampleQuery(sampleQuery, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQueryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SampleQueryName name =
        SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");

    client.deleteSampleQuery(name);

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
  public void deleteSampleQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SampleQueryName name =
          SampleQueryName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]", "[SAMPLE_QUERY]");
      client.deleteSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSampleQueryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5395/locations/location-5395/sampleQuerySets/sampleQuerySet-5395/sampleQueries/sampleQuerie-5395";

    client.deleteSampleQuery(name);

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
  public void deleteSampleQueryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5395/locations/location-5395/sampleQuerySets/sampleQuerySet-5395/sampleQueries/sampleQuerie-5395";
      client.deleteSampleQuery(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSampleQueriesTest() throws Exception {
    ImportSampleQueriesResponse expectedResponse =
        ImportSampleQueriesResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importSampleQueriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportSampleQueriesRequest request =
        ImportSampleQueriesRequest.newBuilder()
            .setParent(
                SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();

    ImportSampleQueriesResponse actualResponse = client.importSampleQueriesAsync(request).get();
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
  public void importSampleQueriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportSampleQueriesRequest request =
          ImportSampleQueriesRequest.newBuilder()
              .setParent(
                  SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.importSampleQueriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
