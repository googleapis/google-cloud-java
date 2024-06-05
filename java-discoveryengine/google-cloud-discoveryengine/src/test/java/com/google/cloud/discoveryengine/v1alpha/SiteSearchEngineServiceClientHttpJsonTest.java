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

import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonSiteSearchEngineServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
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
public class SiteSearchEngineServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SiteSearchEngineServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSiteSearchEngineServiceStub.getMethodDescriptors(),
            SiteSearchEngineServiceSettings.getDefaultEndpoint());
    SiteSearchEngineServiceSettings settings =
        SiteSearchEngineServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SiteSearchEngineServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SiteSearchEngineServiceClient.create(settings);
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
  public void getSiteSearchEngineTest() throws Exception {
    SiteSearchEngine expectedResponse =
        SiteSearchEngine.newBuilder()
            .setName(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    SiteSearchEngineName name =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    SiteSearchEngine actualResponse = client.getSiteSearchEngine(name);
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
  public void getSiteSearchEngineExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SiteSearchEngineName name =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.getSiteSearchEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSiteSearchEngineTest2() throws Exception {
    SiteSearchEngine expectedResponse =
        SiteSearchEngine.newBuilder()
            .setName(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3012/locations/location-3012/dataStores/dataStore-3012/siteSearchEngine";

    SiteSearchEngine actualResponse = client.getSiteSearchEngine(name);
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
  public void getSiteSearchEngineExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3012/locations/location-3012/dataStores/dataStore-3012/siteSearchEngine";
      client.getSiteSearchEngine(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SiteSearchEngineName parent =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    TargetSite targetSite = TargetSite.newBuilder().build();

    TargetSite actualResponse = client.createTargetSiteAsync(parent, targetSite).get();
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
  public void createTargetSiteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SiteSearchEngineName parent =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      TargetSite targetSite = TargetSite.newBuilder().build();
      client.createTargetSiteAsync(parent, targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTargetSiteTest2() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-6467/locations/location-6467/dataStores/dataStore-6467/siteSearchEngine";
    TargetSite targetSite = TargetSite.newBuilder().build();

    TargetSite actualResponse = client.createTargetSiteAsync(parent, targetSite).get();
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
  public void createTargetSiteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6467/locations/location-6467/dataStores/dataStore-6467/siteSearchEngine";
      TargetSite targetSite = TargetSite.newBuilder().build();
      client.createTargetSiteAsync(parent, targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchCreateTargetSitesTest() throws Exception {
    BatchCreateTargetSitesResponse expectedResponse =
        BatchCreateTargetSitesResponse.newBuilder()
            .addAllTargetSites(new ArrayList<TargetSite>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchCreateTargetSitesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BatchCreateTargetSitesRequest request =
        BatchCreateTargetSitesRequest.newBuilder()
            .setParent(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
            .build();

    BatchCreateTargetSitesResponse actualResponse =
        client.batchCreateTargetSitesAsync(request).get();
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
  public void batchCreateTargetSitesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchCreateTargetSitesRequest request =
          BatchCreateTargetSitesRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllRequests(new ArrayList<CreateTargetSiteRequest>())
              .build();
      client.batchCreateTargetSitesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TargetSiteName name =
        TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");

    TargetSite actualResponse = client.getTargetSite(name);
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
  public void getTargetSiteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetSiteName name =
          TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
      client.getTargetSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetSiteTest2() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4107/locations/location-4107/dataStores/dataStore-4107/siteSearchEngine/targetSites/targetSite-4107";

    TargetSite actualResponse = client.getTargetSite(name);
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
  public void getTargetSiteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4107/locations/location-4107/dataStores/dataStore-4107/siteSearchEngine/targetSites/targetSite-4107";
      client.getTargetSite(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTargetSiteTest() throws Exception {
    TargetSite expectedResponse =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TargetSite targetSite =
        TargetSite.newBuilder()
            .setName(
                TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                    .toString())
            .setProvidedUriPattern("providedUriPattern414527175")
            .setExactMatch(true)
            .setGeneratedUriPattern("generatedUriPattern-981984397")
            .setRootDomainUri("rootDomainUri1797820230")
            .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFailureReason(TargetSite.FailureReason.newBuilder().build())
            .build();

    TargetSite actualResponse = client.updateTargetSiteAsync(targetSite).get();
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
  public void updateTargetSiteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetSite targetSite =
          TargetSite.newBuilder()
              .setName(
                  TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]")
                      .toString())
              .setProvidedUriPattern("providedUriPattern414527175")
              .setExactMatch(true)
              .setGeneratedUriPattern("generatedUriPattern-981984397")
              .setRootDomainUri("rootDomainUri1797820230")
              .setSiteVerificationInfo(SiteVerificationInfo.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setFailureReason(TargetSite.FailureReason.newBuilder().build())
              .build();
      client.updateTargetSiteAsync(targetSite).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetSiteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TargetSiteName name =
        TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");

    client.deleteTargetSiteAsync(name).get();

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
  public void deleteTargetSiteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetSiteName name =
          TargetSiteName.ofProjectLocationDataStoreTargetSiteName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[TARGET_SITE]");
      client.deleteTargetSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTargetSiteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTargetSiteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4107/locations/location-4107/dataStores/dataStore-4107/siteSearchEngine/targetSites/targetSite-4107";

    client.deleteTargetSiteAsync(name).get();

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
  public void deleteTargetSiteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4107/locations/location-4107/dataStores/dataStore-4107/siteSearchEngine/targetSites/targetSite-4107";
      client.deleteTargetSiteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTargetSitesTest() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    ListTargetSitesResponse expectedResponse =
        ListTargetSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SiteSearchEngineName parent =
        SiteSearchEngineName.ofProjectLocationDataStoreName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListTargetSitesPagedResponse pagedListResponse = client.listTargetSites(parent);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

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
  public void listTargetSitesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SiteSearchEngineName parent =
          SiteSearchEngineName.ofProjectLocationDataStoreName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listTargetSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetSitesTest2() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    ListTargetSitesResponse expectedResponse =
        ListTargetSitesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6467/locations/location-6467/dataStores/dataStore-6467/siteSearchEngine";

    ListTargetSitesPagedResponse pagedListResponse = client.listTargetSites(parent);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

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
  public void listTargetSitesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6467/locations/location-6467/dataStores/dataStore-6467/siteSearchEngine";
      client.listTargetSites(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableAdvancedSiteSearchTest() throws Exception {
    EnableAdvancedSiteSearchResponse expectedResponse =
        EnableAdvancedSiteSearchResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableAdvancedSiteSearchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EnableAdvancedSiteSearchRequest request =
        EnableAdvancedSiteSearchRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();

    EnableAdvancedSiteSearchResponse actualResponse =
        client.enableAdvancedSiteSearchAsync(request).get();
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
  public void enableAdvancedSiteSearchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnableAdvancedSiteSearchRequest request =
          EnableAdvancedSiteSearchRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.enableAdvancedSiteSearchAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableAdvancedSiteSearchTest() throws Exception {
    DisableAdvancedSiteSearchResponse expectedResponse =
        DisableAdvancedSiteSearchResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableAdvancedSiteSearchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DisableAdvancedSiteSearchRequest request =
        DisableAdvancedSiteSearchRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .build();

    DisableAdvancedSiteSearchResponse actualResponse =
        client.disableAdvancedSiteSearchAsync(request).get();
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
  public void disableAdvancedSiteSearchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisableAdvancedSiteSearchRequest request =
          DisableAdvancedSiteSearchRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.disableAdvancedSiteSearchAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void recrawlUrisTest() throws Exception {
    RecrawlUrisResponse expectedResponse =
        RecrawlUrisResponse.newBuilder()
            .addAllFailureSamples(new ArrayList<RecrawlUrisResponse.FailureInfo>())
            .addAllFailedUris(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("recrawlUrisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RecrawlUrisRequest request =
        RecrawlUrisRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .addAllUris(new ArrayList<String>())
            .build();

    RecrawlUrisResponse actualResponse = client.recrawlUrisAsync(request).get();
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
  public void recrawlUrisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecrawlUrisRequest request =
          RecrawlUrisRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllUris(new ArrayList<String>())
              .build();
      client.recrawlUrisAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchVerifyTargetSitesTest() throws Exception {
    BatchVerifyTargetSitesResponse expectedResponse =
        BatchVerifyTargetSitesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchVerifyTargetSitesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    BatchVerifyTargetSitesRequest request =
        BatchVerifyTargetSitesRequest.newBuilder()
            .setParent(
                SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .build();

    BatchVerifyTargetSitesResponse actualResponse =
        client.batchVerifyTargetSitesAsync(request).get();
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
  public void batchVerifyTargetSitesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchVerifyTargetSitesRequest request =
          BatchVerifyTargetSitesRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.batchVerifyTargetSitesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchDomainVerificationStatusTest() throws Exception {
    TargetSite responsesElement = TargetSite.newBuilder().build();
    FetchDomainVerificationStatusResponse expectedResponse =
        FetchDomainVerificationStatusResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetSites(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FetchDomainVerificationStatusRequest request =
        FetchDomainVerificationStatusRequest.newBuilder()
            .setSiteSearchEngine(
                SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    FetchDomainVerificationStatusPagedResponse pagedListResponse =
        client.fetchDomainVerificationStatus(request);

    List<TargetSite> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetSitesList().get(0), resources.get(0));

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
  public void fetchDomainVerificationStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FetchDomainVerificationStatusRequest request =
          FetchDomainVerificationStatusRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.fetchDomainVerificationStatus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
