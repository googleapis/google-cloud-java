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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.YieldPartnerServiceClient.ListYieldPartnersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonYieldPartnerServiceStub;
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
import java.io.IOException;
import java.util.ArrayList;
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
public class YieldPartnerServiceClientTest {
  private static MockHttpService mockService;
  private static YieldPartnerServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonYieldPartnerServiceStub.getMethodDescriptors(),
            YieldPartnerServiceSettings.getDefaultEndpoint());
    YieldPartnerServiceSettings settings =
        YieldPartnerServiceSettings.newBuilder()
            .setTransportChannelProvider(
                YieldPartnerServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = YieldPartnerServiceClient.create(settings);
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
  public void getYieldPartnerTest() throws Exception {
    YieldPartner expectedResponse =
        YieldPartner.newBuilder()
            .setName(YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllSettings(new ArrayList<YieldPartnerSettings>())
            .build();
    mockService.addResponse(expectedResponse);

    YieldPartnerName name = YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]");

    YieldPartner actualResponse = client.getYieldPartner(name);
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
  public void getYieldPartnerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      YieldPartnerName name = YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]");
      client.getYieldPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getYieldPartnerTest2() throws Exception {
    YieldPartner expectedResponse =
        YieldPartner.newBuilder()
            .setName(YieldPartnerName.of("[NETWORK_CODE]", "[YIELD_PARTNER]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .addAllSettings(new ArrayList<YieldPartnerSettings>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4081/yieldPartners/yieldPartner-4081";

    YieldPartner actualResponse = client.getYieldPartner(name);
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
  public void getYieldPartnerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4081/yieldPartners/yieldPartner-4081";
      client.getYieldPartner(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listYieldPartnersTest() throws Exception {
    YieldPartner responsesElement = YieldPartner.newBuilder().build();
    ListYieldPartnersResponse expectedResponse =
        ListYieldPartnersResponse.newBuilder()
            .setNextPageToken("")
            .addAllYieldPartners(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListYieldPartnersPagedResponse pagedListResponse = client.listYieldPartners(parent);

    List<YieldPartner> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getYieldPartnersList().get(0), resources.get(0));

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
  public void listYieldPartnersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listYieldPartners(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listYieldPartnersTest2() throws Exception {
    YieldPartner responsesElement = YieldPartner.newBuilder().build();
    ListYieldPartnersResponse expectedResponse =
        ListYieldPartnersResponse.newBuilder()
            .setNextPageToken("")
            .addAllYieldPartners(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListYieldPartnersPagedResponse pagedListResponse = client.listYieldPartners(parent);

    List<YieldPartner> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getYieldPartnersList().get(0), resources.get(0));

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
  public void listYieldPartnersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listYieldPartners(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
