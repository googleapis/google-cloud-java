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

import static com.google.ads.admanager.v1.CreativeTemplateServiceClient.ListCreativeTemplatesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCreativeTemplateServiceStub;
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
public class CreativeTemplateServiceClientTest {
  private static MockHttpService mockService;
  private static CreativeTemplateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCreativeTemplateServiceStub.getMethodDescriptors(),
            CreativeTemplateServiceSettings.getDefaultEndpoint());
    CreativeTemplateServiceSettings settings =
        CreativeTemplateServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CreativeTemplateServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CreativeTemplateServiceClient.create(settings);
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
  public void getCreativeTemplateTest() throws Exception {
    CreativeTemplate expectedResponse =
        CreativeTemplate.newBuilder()
            .setName(CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSnippet("snippet-2061635299")
            .setInterstitial(true)
            .setNativeEligible(true)
            .setNativeVideoEligible(true)
            .setSafeFrameCompatible(true)
            .addAllVariables(new ArrayList<CreativeTemplateVariable>())
            .build();
    mockService.addResponse(expectedResponse);

    CreativeTemplateName name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]");

    CreativeTemplate actualResponse = client.getCreativeTemplate(name);
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
  public void getCreativeTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreativeTemplateName name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]");
      client.getCreativeTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCreativeTemplateTest2() throws Exception {
    CreativeTemplate expectedResponse =
        CreativeTemplate.newBuilder()
            .setName(CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSnippet("snippet-2061635299")
            .setInterstitial(true)
            .setNativeEligible(true)
            .setNativeVideoEligible(true)
            .setSafeFrameCompatible(true)
            .addAllVariables(new ArrayList<CreativeTemplateVariable>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-9871/creativeTemplates/creativeTemplate-9871";

    CreativeTemplate actualResponse = client.getCreativeTemplate(name);
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
  public void getCreativeTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-9871/creativeTemplates/creativeTemplate-9871";
      client.getCreativeTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeTemplatesTest() throws Exception {
    CreativeTemplate responsesElement = CreativeTemplate.newBuilder().build();
    ListCreativeTemplatesResponse expectedResponse =
        ListCreativeTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCreativeTemplatesPagedResponse pagedListResponse = client.listCreativeTemplates(parent);

    List<CreativeTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeTemplatesList().get(0), resources.get(0));

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
  public void listCreativeTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCreativeTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeTemplatesTest2() throws Exception {
    CreativeTemplate responsesElement = CreativeTemplate.newBuilder().build();
    ListCreativeTemplatesResponse expectedResponse =
        ListCreativeTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCreativeTemplatesPagedResponse pagedListResponse = client.listCreativeTemplates(parent);

    List<CreativeTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeTemplatesList().get(0), resources.get(0));

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
  public void listCreativeTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCreativeTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
