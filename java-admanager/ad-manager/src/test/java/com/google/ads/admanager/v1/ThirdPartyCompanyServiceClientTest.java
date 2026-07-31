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

import static com.google.ads.admanager.v1.ThirdPartyCompanyServiceClient.ListThirdPartyCompaniesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonThirdPartyCompanyServiceStub;
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
public class ThirdPartyCompanyServiceClientTest {
  private static MockHttpService mockService;
  private static ThirdPartyCompanyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonThirdPartyCompanyServiceStub.getMethodDescriptors(),
            ThirdPartyCompanyServiceSettings.getDefaultEndpoint());
    ThirdPartyCompanyServiceSettings settings =
        ThirdPartyCompanyServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ThirdPartyCompanyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ThirdPartyCompanyServiceClient.create(settings);
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
  public void getThirdPartyCompanyTest() throws Exception {
    ThirdPartyCompany expectedResponse =
        ThirdPartyCompany.newBuilder()
            .setName(ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    ThirdPartyCompanyName name =
        ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]");

    ThirdPartyCompany actualResponse = client.getThirdPartyCompany(name);
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
  public void getThirdPartyCompanyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ThirdPartyCompanyName name =
          ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]");
      client.getThirdPartyCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getThirdPartyCompanyTest2() throws Exception {
    ThirdPartyCompany expectedResponse =
        ThirdPartyCompany.newBuilder()
            .setName(ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]").toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4451/thirdPartyCompanies/thirdPartyCompanie-4451";

    ThirdPartyCompany actualResponse = client.getThirdPartyCompany(name);
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
  public void getThirdPartyCompanyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4451/thirdPartyCompanies/thirdPartyCompanie-4451";
      client.getThirdPartyCompany(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listThirdPartyCompaniesTest() throws Exception {
    ThirdPartyCompany responsesElement = ThirdPartyCompany.newBuilder().build();
    ListThirdPartyCompaniesResponse expectedResponse =
        ListThirdPartyCompaniesResponse.newBuilder()
            .setNextPageToken("")
            .addAllThirdPartyCompanies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListThirdPartyCompaniesPagedResponse pagedListResponse = client.listThirdPartyCompanies(parent);

    List<ThirdPartyCompany> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getThirdPartyCompaniesList().get(0), resources.get(0));

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
  public void listThirdPartyCompaniesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listThirdPartyCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listThirdPartyCompaniesTest2() throws Exception {
    ThirdPartyCompany responsesElement = ThirdPartyCompany.newBuilder().build();
    ListThirdPartyCompaniesResponse expectedResponse =
        ListThirdPartyCompaniesResponse.newBuilder()
            .setNextPageToken("")
            .addAllThirdPartyCompanies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListThirdPartyCompaniesPagedResponse pagedListResponse = client.listThirdPartyCompanies(parent);

    List<ThirdPartyCompany> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getThirdPartyCompaniesList().get(0), resources.get(0));

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
  public void listThirdPartyCompaniesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listThirdPartyCompanies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
