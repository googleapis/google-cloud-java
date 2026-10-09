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

import static com.google.ads.admanager.v1.BreakTemplateServiceClient.ListBreakTemplatesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonBreakTemplateServiceStub;
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
public class BreakTemplateServiceClientTest {
  private static MockHttpService mockService;
  private static BreakTemplateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBreakTemplateServiceStub.getMethodDescriptors(),
            BreakTemplateServiceSettings.getDefaultEndpoint());
    BreakTemplateServiceSettings settings =
        BreakTemplateServiceSettings.newBuilder()
            .setTransportChannelProvider(
                BreakTemplateServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BreakTemplateServiceClient.create(settings);
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
  public void getBreakTemplateTest() throws Exception {
    BreakTemplate expectedResponse =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    mockService.addResponse(expectedResponse);

    BreakTemplateName name = BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]");

    BreakTemplate actualResponse = client.getBreakTemplate(name);
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
  public void getBreakTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BreakTemplateName name = BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]");
      client.getBreakTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBreakTemplateTest2() throws Exception {
    BreakTemplate expectedResponse =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-201/breakTemplates/breakTemplate-201";

    BreakTemplate actualResponse = client.getBreakTemplate(name);
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
  public void getBreakTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-201/breakTemplates/breakTemplate-201";
      client.getBreakTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBreakTemplatesTest() throws Exception {
    BreakTemplate responsesElement = BreakTemplate.newBuilder().build();
    ListBreakTemplatesResponse expectedResponse =
        ListBreakTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBreakTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListBreakTemplatesPagedResponse pagedListResponse = client.listBreakTemplates(parent);

    List<BreakTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBreakTemplatesList().get(0), resources.get(0));

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
  public void listBreakTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listBreakTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBreakTemplatesTest2() throws Exception {
    BreakTemplate responsesElement = BreakTemplate.newBuilder().build();
    ListBreakTemplatesResponse expectedResponse =
        ListBreakTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBreakTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListBreakTemplatesPagedResponse pagedListResponse = client.listBreakTemplates(parent);

    List<BreakTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBreakTemplatesList().get(0), resources.get(0));

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
  public void listBreakTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listBreakTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBreakTemplateTest() throws Exception {
    BreakTemplate expectedResponse =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();

    BreakTemplate actualResponse = client.createBreakTemplate(parent, breakTemplate);
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
  public void createBreakTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();
      client.createBreakTemplate(parent, breakTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBreakTemplateTest2() throws Exception {
    BreakTemplate expectedResponse =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();

    BreakTemplate actualResponse = client.createBreakTemplate(parent, breakTemplate);
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
  public void createBreakTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();
      client.createBreakTemplate(parent, breakTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateBreakTemplatesTest() throws Exception {
    BatchCreateBreakTemplatesResponse expectedResponse =
        BatchCreateBreakTemplatesResponse.newBuilder()
            .addAllBreakTemplates(new ArrayList<BreakTemplate>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateBreakTemplateRequest> requests = new ArrayList<>();

    BatchCreateBreakTemplatesResponse actualResponse =
        client.batchCreateBreakTemplates(parent, requests);
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
  public void batchCreateBreakTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateBreakTemplateRequest> requests = new ArrayList<>();
      client.batchCreateBreakTemplates(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateBreakTemplatesTest2() throws Exception {
    BatchCreateBreakTemplatesResponse expectedResponse =
        BatchCreateBreakTemplatesResponse.newBuilder()
            .addAllBreakTemplates(new ArrayList<BreakTemplate>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateBreakTemplateRequest> requests = new ArrayList<>();

    BatchCreateBreakTemplatesResponse actualResponse =
        client.batchCreateBreakTemplates(parent, requests);
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
  public void batchCreateBreakTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateBreakTemplateRequest> requests = new ArrayList<>();
      client.batchCreateBreakTemplates(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBreakTemplateTest() throws Exception {
    BreakTemplate expectedResponse =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    mockService.addResponse(expectedResponse);

    BreakTemplate breakTemplate =
        BreakTemplate.newBuilder()
            .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
            .setCustomTemplate(true)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BreakTemplate actualResponse = client.updateBreakTemplate(breakTemplate, updateMask);
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
  public void updateBreakTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BreakTemplate breakTemplate =
          BreakTemplate.newBuilder()
              .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
              .setCustomTemplate(true)
              .setAdTagName("adTagName-926580830")
              .setDisplayName("displayName1714148973")
              .addAllBreakTemplateMembers(new ArrayList<BreakTemplateMember>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBreakTemplate(breakTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateBreakTemplatesTest() throws Exception {
    BatchUpdateBreakTemplatesResponse expectedResponse =
        BatchUpdateBreakTemplatesResponse.newBuilder()
            .addAllBreakTemplates(new ArrayList<BreakTemplate>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateBreakTemplateRequest> requests = new ArrayList<>();

    BatchUpdateBreakTemplatesResponse actualResponse =
        client.batchUpdateBreakTemplates(parent, requests);
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
  public void batchUpdateBreakTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateBreakTemplateRequest> requests = new ArrayList<>();
      client.batchUpdateBreakTemplates(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateBreakTemplatesTest2() throws Exception {
    BatchUpdateBreakTemplatesResponse expectedResponse =
        BatchUpdateBreakTemplatesResponse.newBuilder()
            .addAllBreakTemplates(new ArrayList<BreakTemplate>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateBreakTemplateRequest> requests = new ArrayList<>();

    BatchUpdateBreakTemplatesResponse actualResponse =
        client.batchUpdateBreakTemplates(parent, requests);
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
  public void batchUpdateBreakTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateBreakTemplateRequest> requests = new ArrayList<>();
      client.batchUpdateBreakTemplates(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
