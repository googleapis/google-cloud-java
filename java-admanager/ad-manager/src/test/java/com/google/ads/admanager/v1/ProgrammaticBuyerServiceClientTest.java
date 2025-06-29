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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ProgrammaticBuyerServiceClient.ListProgrammaticBuyersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonProgrammaticBuyerServiceStub;
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
public class ProgrammaticBuyerServiceClientTest {
  private static MockHttpService mockService;
  private static ProgrammaticBuyerServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProgrammaticBuyerServiceStub.getMethodDescriptors(),
            ProgrammaticBuyerServiceSettings.getDefaultEndpoint());
    ProgrammaticBuyerServiceSettings settings =
        ProgrammaticBuyerServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ProgrammaticBuyerServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProgrammaticBuyerServiceClient.create(settings);
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
  public void getProgrammaticBuyerTest() throws Exception {
    ProgrammaticBuyer expectedResponse =
        ProgrammaticBuyer.newBuilder()
            .setName(ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]").toString())
            .setBuyerAccountId(-994282887)
            .setDisplayName("displayName1714148973")
            .setParentAccountId(-325829854)
            .setPartnerClientId("partnerClientId865546030")
            .setAgency(true)
            .setPreferredDealsEnabled(true)
            .setProgrammaticGuaranteedEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    ProgrammaticBuyerName name = ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]");

    ProgrammaticBuyer actualResponse = client.getProgrammaticBuyer(name);
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
  public void getProgrammaticBuyerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProgrammaticBuyerName name =
          ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]");
      client.getProgrammaticBuyer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProgrammaticBuyerTest2() throws Exception {
    ProgrammaticBuyer expectedResponse =
        ProgrammaticBuyer.newBuilder()
            .setName(ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]").toString())
            .setBuyerAccountId(-994282887)
            .setDisplayName("displayName1714148973")
            .setParentAccountId(-325829854)
            .setPartnerClientId("partnerClientId865546030")
            .setAgency(true)
            .setPreferredDealsEnabled(true)
            .setProgrammaticGuaranteedEnabled(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-3525/programmaticBuyers/programmaticBuyer-3525";

    ProgrammaticBuyer actualResponse = client.getProgrammaticBuyer(name);
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
  public void getProgrammaticBuyerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-3525/programmaticBuyers/programmaticBuyer-3525";
      client.getProgrammaticBuyer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgrammaticBuyersTest() throws Exception {
    ProgrammaticBuyer responsesElement = ProgrammaticBuyer.newBuilder().build();
    ListProgrammaticBuyersResponse expectedResponse =
        ListProgrammaticBuyersResponse.newBuilder()
            .setNextPageToken("")
            .addAllProgrammaticBuyers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListProgrammaticBuyersPagedResponse pagedListResponse = client.listProgrammaticBuyers(parent);

    List<ProgrammaticBuyer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgrammaticBuyersList().get(0), resources.get(0));

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
  public void listProgrammaticBuyersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listProgrammaticBuyers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgrammaticBuyersTest2() throws Exception {
    ProgrammaticBuyer responsesElement = ProgrammaticBuyer.newBuilder().build();
    ListProgrammaticBuyersResponse expectedResponse =
        ListProgrammaticBuyersResponse.newBuilder()
            .setNextPageToken("")
            .addAllProgrammaticBuyers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListProgrammaticBuyersPagedResponse pagedListResponse = client.listProgrammaticBuyers(parent);

    List<ProgrammaticBuyer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgrammaticBuyersList().get(0), resources.get(0));

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
  public void listProgrammaticBuyersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listProgrammaticBuyers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
