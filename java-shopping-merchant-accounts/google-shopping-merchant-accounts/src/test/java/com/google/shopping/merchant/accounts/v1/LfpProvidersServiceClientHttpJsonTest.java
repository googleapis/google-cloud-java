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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.LfpProvidersServiceClient.FindLfpProvidersPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonLfpProvidersServiceStub;
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
public class LfpProvidersServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LfpProvidersServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLfpProvidersServiceStub.getMethodDescriptors(),
            LfpProvidersServiceSettings.getDefaultEndpoint());
    LfpProvidersServiceSettings settings =
        LfpProvidersServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LfpProvidersServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpProvidersServiceClient.create(settings);
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
  public void findLfpProvidersTest() throws Exception {
    LfpProvider responsesElement = LfpProvider.newBuilder().build();
    FindLfpProvidersResponse expectedResponse =
        FindLfpProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpProviders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OmnichannelSettingName parent = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    FindLfpProvidersPagedResponse pagedListResponse = client.findLfpProviders(parent);

    List<LfpProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpProvidersList().get(0), resources.get(0));

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
  public void findLfpProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OmnichannelSettingName parent =
          OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.findLfpProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findLfpProvidersTest2() throws Exception {
    LfpProvider responsesElement = LfpProvider.newBuilder().build();
    FindLfpProvidersResponse expectedResponse =
        FindLfpProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpProviders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-2452/omnichannelSettings/omnichannelSetting-2452";

    FindLfpProvidersPagedResponse pagedListResponse = client.findLfpProviders(parent);

    List<LfpProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpProvidersList().get(0), resources.get(0));

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
  public void findLfpProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-2452/omnichannelSettings/omnichannelSetting-2452";
      client.findLfpProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkLfpProviderTest() throws Exception {
    LinkLfpProviderResponse expectedResponse =
        LinkLfpProviderResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    LfpProviderName name =
        LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");

    LinkLfpProviderResponse actualResponse = client.linkLfpProvider(name);
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
  public void linkLfpProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LfpProviderName name =
          LfpProviderName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]", "[LFP_PROVIDER]");
      client.linkLfpProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void linkLfpProviderTest2() throws Exception {
    LinkLfpProviderResponse expectedResponse =
        LinkLfpProviderResponse.newBuilder().setResponse(Empty.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    String name =
        "accounts/account-5263/omnichannelSettings/omnichannelSetting-5263/lfpProviders/lfpProvider-5263";

    LinkLfpProviderResponse actualResponse = client.linkLfpProvider(name);
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
  public void linkLfpProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accounts/account-5263/omnichannelSettings/omnichannelSetting-5263/lfpProviders/lfpProvider-5263";
      client.linkLfpProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
