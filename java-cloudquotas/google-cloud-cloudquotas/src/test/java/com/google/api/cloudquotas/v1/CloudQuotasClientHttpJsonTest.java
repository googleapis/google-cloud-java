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

package com.google.api.cloudquotas.v1;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.stub.HttpJsonCloudQuotasStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CloudQuotasClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CloudQuotasClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCloudQuotasStub.getMethodDescriptors(),
            CloudQuotasSettings.getDefaultEndpoint());
    CloudQuotasSettings settings =
        CloudQuotasSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CloudQuotasSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudQuotasClient.create(settings);
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
  public void listQuotaInfosTest() throws Exception {
    QuotaInfo responsesElement = QuotaInfo.newBuilder().build();
    ListQuotaInfosResponse expectedResponse =
        ListQuotaInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaInfos(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName parent =
        ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]");

    ListQuotaInfosPagedResponse pagedListResponse = client.listQuotaInfos(parent);

    List<QuotaInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaInfosList().get(0), resources.get(0));

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
  public void listQuotaInfosExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName parent =
          ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.listQuotaInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaInfosTest2() throws Exception {
    QuotaInfo responsesElement = QuotaInfo.newBuilder().build();
    ListQuotaInfosResponse expectedResponse =
        ListQuotaInfosResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaInfos(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4913/locations/location-4913/services/service-4913";

    ListQuotaInfosPagedResponse pagedListResponse = client.listQuotaInfos(parent);

    List<QuotaInfo> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaInfosList().get(0), resources.get(0));

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
  public void listQuotaInfosExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4913/locations/location-4913/services/service-4913";
      client.listQuotaInfos(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaInfoTest() throws Exception {
    QuotaInfo expectedResponse =
        QuotaInfo.newBuilder()
            .setName(
                QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
                        "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
                    .toString())
            .setQuotaId("quotaId664373683")
            .setMetric("metric-1077545552")
            .setService("service1984153269")
            .setIsPrecise(true)
            .setRefreshInterval("refreshInterval1919275200")
            .addAllDimensions(new ArrayList<String>())
            .setMetricDisplayName("metricDisplayName974527133")
            .setQuotaDisplayName("quotaDisplayName1494811861")
            .setMetricUnit("metricUnit-610538668")
            .setQuotaIncreaseEligibility(QuotaIncreaseEligibility.newBuilder().build())
            .setIsFixed(true)
            .addAllDimensionsInfos(new ArrayList<DimensionsInfo>())
            .setIsConcurrent(true)
            .setServiceRequestQuotaUri("serviceRequestQuotaUri1402291214")
            .build();
    mockService.addResponse(expectedResponse);

    QuotaInfoName name =
        QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
            "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");

    QuotaInfo actualResponse = client.getQuotaInfo(name);
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
  public void getQuotaInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QuotaInfoName name =
          QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
              "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");
      client.getQuotaInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaInfoTest2() throws Exception {
    QuotaInfo expectedResponse =
        QuotaInfo.newBuilder()
            .setName(
                QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
                        "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
                    .toString())
            .setQuotaId("quotaId664373683")
            .setMetric("metric-1077545552")
            .setService("service1984153269")
            .setIsPrecise(true)
            .setRefreshInterval("refreshInterval1919275200")
            .addAllDimensions(new ArrayList<String>())
            .setMetricDisplayName("metricDisplayName974527133")
            .setQuotaDisplayName("quotaDisplayName1494811861")
            .setMetricUnit("metricUnit-610538668")
            .setQuotaIncreaseEligibility(QuotaIncreaseEligibility.newBuilder().build())
            .setIsFixed(true)
            .addAllDimensionsInfos(new ArrayList<DimensionsInfo>())
            .setIsConcurrent(true)
            .setServiceRequestQuotaUri("serviceRequestQuotaUri1402291214")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4073/locations/location-4073/services/service-4073/quotaInfos/quotaInfo-4073";

    QuotaInfo actualResponse = client.getQuotaInfo(name);
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
  public void getQuotaInfoExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4073/locations/location-4073/services/service-4073/quotaInfos/quotaInfo-4073";
      client.getQuotaInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaPreferencesTest() throws Exception {
    QuotaPreference responsesElement = QuotaPreference.newBuilder().build();
    ListQuotaPreferencesResponse expectedResponse =
        ListQuotaPreferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaPreferences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    ListQuotaPreferencesPagedResponse pagedListResponse = client.listQuotaPreferences(parent);

    List<QuotaPreference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaPreferencesList().get(0), resources.get(0));

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
  public void listQuotaPreferencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.listQuotaPreferences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQuotaPreferencesTest2() throws Exception {
    QuotaPreference responsesElement = QuotaPreference.newBuilder().build();
    ListQuotaPreferencesResponse expectedResponse =
        ListQuotaPreferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllQuotaPreferences(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListQuotaPreferencesPagedResponse pagedListResponse = client.listQuotaPreferences(parent);

    List<QuotaPreference> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQuotaPreferencesList().get(0), resources.get(0));

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
  public void listQuotaPreferencesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listQuotaPreferences(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    QuotaPreferenceName name =
        QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
            "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]");

    QuotaPreference actualResponse = client.getQuotaPreference(name);
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
  public void getQuotaPreferenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QuotaPreferenceName name =
          QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
              "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]");
      client.getQuotaPreference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQuotaPreferenceTest2() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3280/locations/location-3280/quotaPreferences/quotaPreference-3280";

    QuotaPreference actualResponse = client.getQuotaPreference(name);
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
  public void getQuotaPreferenceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3280/locations/location-3280/quotaPreferences/quotaPreference-3280";
      client.getQuotaPreference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();

    QuotaPreference actualResponse = client.createQuotaPreference(parent, quotaPreference);
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
  public void createQuotaPreferenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      client.createQuotaPreference(parent, quotaPreference);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest2() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();

    QuotaPreference actualResponse = client.createQuotaPreference(parent, quotaPreference);
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
  public void createQuotaPreferenceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      client.createQuotaPreference(parent, quotaPreference);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest3() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
    String quotaPreferenceId = "quotaPreferenceId-948332050";

    QuotaPreference actualResponse =
        client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
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
  public void createQuotaPreferenceExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      String quotaPreferenceId = "quotaPreferenceId-948332050";
      client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQuotaPreferenceTest4() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
    String quotaPreferenceId = "quotaPreferenceId-948332050";

    QuotaPreference actualResponse =
        client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
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
  public void createQuotaPreferenceExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
      String quotaPreferenceId = "quotaPreferenceId-948332050";
      client.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQuotaPreferenceTest() throws Exception {
    QuotaPreference expectedResponse =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    mockService.addResponse(expectedResponse);

    QuotaPreference quotaPreference =
        QuotaPreference.newBuilder()
            .setName(
                QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                        "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                    .toString())
            .putAllDimensions(new HashMap<String, String>())
            .setQuotaConfig(QuotaConfig.newBuilder().build())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .setQuotaId("quotaId664373683")
            .setReconciling(true)
            .setJustification("justification1864993522")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QuotaPreference actualResponse = client.updateQuotaPreference(quotaPreference, updateMask);
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
  public void updateQuotaPreferenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QuotaPreference quotaPreference =
          QuotaPreference.newBuilder()
              .setName(
                  QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
                          "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
                      .toString())
              .putAllDimensions(new HashMap<String, String>())
              .setQuotaConfig(QuotaConfig.newBuilder().build())
              .setEtag("etag3123477")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setService("service1984153269")
              .setQuotaId("quotaId664373683")
              .setReconciling(true)
              .setJustification("justification1864993522")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQuotaPreference(quotaPreference, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
