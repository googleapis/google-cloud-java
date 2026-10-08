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

import static com.google.ads.admanager.v1.LineItemTemplateServiceClient.ListLineItemTemplatesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonLineItemTemplateServiceStub;
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
public class LineItemTemplateServiceClientTest {
  private static MockHttpService mockService;
  private static LineItemTemplateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLineItemTemplateServiceStub.getMethodDescriptors(),
            LineItemTemplateServiceSettings.getDefaultEndpoint());
    LineItemTemplateServiceSettings settings =
        LineItemTemplateServiceSettings.newBuilder()
            .setTransportChannelProvider(
                LineItemTemplateServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineItemTemplateServiceClient.create(settings);
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
  public void getLineItemTemplateTest() throws Exception {
    LineItemTemplate expectedResponse =
        LineItemTemplate.newBuilder()
            .setName(LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultTemplate(true)
            .setSameAdvertiserExceptionEnabled(true)
            .setLineItemDisplayName("lineItemDisplayName758909638")
            .setNotes("notes105008833")
            .build();
    mockService.addResponse(expectedResponse);

    LineItemTemplateName name = LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]");

    LineItemTemplate actualResponse = client.getLineItemTemplate(name);
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
  public void getLineItemTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItemTemplateName name = LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]");
      client.getLineItemTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineItemTemplateTest2() throws Exception {
    LineItemTemplate expectedResponse =
        LineItemTemplate.newBuilder()
            .setName(LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultTemplate(true)
            .setSameAdvertiserExceptionEnabled(true)
            .setLineItemDisplayName("lineItemDisplayName758909638")
            .setNotes("notes105008833")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-89/lineItemTemplates/lineItemTemplate-89";

    LineItemTemplate actualResponse = client.getLineItemTemplate(name);
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
  public void getLineItemTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-89/lineItemTemplates/lineItemTemplate-89";
      client.getLineItemTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemTemplatesTest() throws Exception {
    LineItemTemplate responsesElement = LineItemTemplate.newBuilder().build();
    ListLineItemTemplatesResponse expectedResponse =
        ListLineItemTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItemTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListLineItemTemplatesPagedResponse pagedListResponse = client.listLineItemTemplates(parent);

    List<LineItemTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemTemplatesList().get(0), resources.get(0));

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
  public void listLineItemTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listLineItemTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemTemplatesTest2() throws Exception {
    LineItemTemplate responsesElement = LineItemTemplate.newBuilder().build();
    ListLineItemTemplatesResponse expectedResponse =
        ListLineItemTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItemTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListLineItemTemplatesPagedResponse pagedListResponse = client.listLineItemTemplates(parent);

    List<LineItemTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemTemplatesList().get(0), resources.get(0));

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
  public void listLineItemTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listLineItemTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
