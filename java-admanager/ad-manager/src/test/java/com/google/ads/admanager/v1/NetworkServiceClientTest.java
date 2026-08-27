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

import static com.google.ads.admanager.v1.NetworkServiceClient.ListNetworksPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonNetworkServiceStub;
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
public class NetworkServiceClientTest {
  private static MockHttpService mockService;
  private static NetworkServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonNetworkServiceStub.getMethodDescriptors(),
            NetworkServiceSettings.getDefaultEndpoint());
    NetworkServiceSettings settings =
        NetworkServiceSettings.newBuilder()
            .setTransportChannelProvider(
                NetworkServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NetworkServiceClient.create(settings);
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
  public void getNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[NETWORK_CODE]").toString())
            .setDisplayName("displayName1714148973")
            .setNetworkCode("networkCode-1941129925")
            .setPropertyCode("propertyCode-865006238")
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .addAllSecondaryCurrencyCodes(new ArrayList<String>())
            .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setTestNetwork(true)
            .setNetworkId(-478232372)
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName name = NetworkName.of("[NETWORK_CODE]");

    Network actualResponse = client.getNetwork(name);
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
  public void getNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName name = NetworkName.of("[NETWORK_CODE]");
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkTest2() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[NETWORK_CODE]").toString())
            .setDisplayName("displayName1714148973")
            .setNetworkCode("networkCode-1941129925")
            .setPropertyCode("propertyCode-865006238")
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .addAllSecondaryCurrencyCodes(new ArrayList<String>())
            .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setTestNetwork(true)
            .setNetworkId(-478232372)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4139";

    Network actualResponse = client.getNetwork(name);
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
  public void getNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4139";
      client.getNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworksTest() throws Exception {
    Network responsesElement = Network.newBuilder().build();
    ListNetworksResponse expectedResponse =
        ListNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListNetworksRequest request =
        ListNetworksRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setSkip(3532159)
            .build();

    ListNetworksPagedResponse pagedListResponse = client.listNetworks(request);

    List<Network> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworksList().get(0), resources.get(0));

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
  public void listNetworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListNetworksRequest request =
          ListNetworksRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setSkip(3532159)
              .build();
      client.listNetworks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[NETWORK_CODE]").toString())
            .setDisplayName("displayName1714148973")
            .setNetworkCode("networkCode-1941129925")
            .setPropertyCode("propertyCode-865006238")
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .addAllSecondaryCurrencyCodes(new ArrayList<String>())
            .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setTestNetwork(true)
            .setNetworkId(-478232372)
            .build();
    mockService.addResponse(expectedResponse);

    Network network =
        Network.newBuilder()
            .setName(NetworkName.of("[NETWORK_CODE]").toString())
            .setDisplayName("displayName1714148973")
            .setNetworkCode("networkCode-1941129925")
            .setPropertyCode("propertyCode-865006238")
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .addAllSecondaryCurrencyCodes(new ArrayList<String>())
            .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setTestNetwork(true)
            .setNetworkId(-478232372)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Network actualResponse = client.updateNetwork(network, updateMask);
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
  public void updateNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Network network =
          Network.newBuilder()
              .setName(NetworkName.of("[NETWORK_CODE]").toString())
              .setDisplayName("displayName1714148973")
              .setNetworkCode("networkCode-1941129925")
              .setPropertyCode("propertyCode-865006238")
              .setTimeZone("timeZone-2077180903")
              .setCurrencyCode("currencyCode1004773790")
              .addAllSecondaryCurrencyCodes(new ArrayList<String>())
              .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
              .setTestNetwork(true)
              .setNetworkId(-478232372)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetwork(network, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionTestNetworkTest() throws Exception {
    Network expectedResponse =
        Network.newBuilder()
            .setName(NetworkName.of("[NETWORK_CODE]").toString())
            .setDisplayName("displayName1714148973")
            .setNetworkCode("networkCode-1941129925")
            .setPropertyCode("propertyCode-865006238")
            .setTimeZone("timeZone-2077180903")
            .setCurrencyCode("currencyCode1004773790")
            .addAllSecondaryCurrencyCodes(new ArrayList<String>())
            .setEffectiveRootAdUnit(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
            .setTestNetwork(true)
            .setNetworkId(-478232372)
            .build();
    mockService.addResponse(expectedResponse);

    ProvisionTestNetworkRequest request = ProvisionTestNetworkRequest.newBuilder().build();

    Network actualResponse = client.provisionTestNetwork(request);
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
  public void provisionTestNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProvisionTestNetworkRequest request = ProvisionTestNetworkRequest.newBuilder().build();
      client.provisionTestNetwork(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefaultThirdPartyDataDeclarationTest() throws Exception {
    DefaultThirdPartyDataDeclaration expectedResponse =
        DefaultThirdPartyDataDeclaration.newBuilder()
            .setName(DefaultThirdPartyDataDeclarationName.of("[NETWORK_CODE]").toString())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DefaultThirdPartyDataDeclarationName name =
        DefaultThirdPartyDataDeclarationName.of("[NETWORK_CODE]");

    DefaultThirdPartyDataDeclaration actualResponse =
        client.getDefaultThirdPartyDataDeclaration(name);
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
  public void getDefaultThirdPartyDataDeclarationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DefaultThirdPartyDataDeclarationName name =
          DefaultThirdPartyDataDeclarationName.of("[NETWORK_CODE]");
      client.getDefaultThirdPartyDataDeclaration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefaultThirdPartyDataDeclarationTest2() throws Exception {
    DefaultThirdPartyDataDeclaration expectedResponse =
        DefaultThirdPartyDataDeclaration.newBuilder()
            .setName(DefaultThirdPartyDataDeclarationName.of("[NETWORK_CODE]").toString())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-2476/defaultThirdPartyDataDeclaration";

    DefaultThirdPartyDataDeclaration actualResponse =
        client.getDefaultThirdPartyDataDeclaration(name);
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
  public void getDefaultThirdPartyDataDeclarationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-2476/defaultThirdPartyDataDeclaration";
      client.getDefaultThirdPartyDataDeclaration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
