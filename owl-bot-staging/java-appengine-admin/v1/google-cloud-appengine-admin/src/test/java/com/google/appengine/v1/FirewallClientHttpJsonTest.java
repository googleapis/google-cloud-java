/*
 * Copyright 2022 Google LLC
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

package com.google.appengine.v1;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.appengine.v1.stub.HttpJsonFirewallStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
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
public class FirewallClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FirewallClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFirewallStub.getMethodDescriptors(), FirewallSettings.getDefaultEndpoint());
    FirewallSettings settings =
        FirewallSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FirewallSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirewallClient.create(settings);
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
  public void listIngressRulesTest() throws Exception {
    FirewallRule responsesElement = FirewallRule.newBuilder().build();
    ListIngressRulesResponse expectedResponse =
        ListIngressRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIngressRules(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListIngressRulesRequest request =
        ListIngressRulesRequest.newBuilder()
            .setParent("apps/app-3559")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setMatchingAddress("matchingAddress861962551")
            .build();

    ListIngressRulesPagedResponse pagedListResponse = client.listIngressRules(request);

    List<FirewallRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIngressRulesList().get(0), resources.get(0));

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
  public void listIngressRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListIngressRulesRequest request =
          ListIngressRulesRequest.newBuilder()
              .setParent("apps/app-3559")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMatchingAddress("matchingAddress861962551")
              .build();
      client.listIngressRules(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateIngressRulesTest() throws Exception {
    BatchUpdateIngressRulesResponse expectedResponse =
        BatchUpdateIngressRulesResponse.newBuilder()
            .addAllIngressRules(new ArrayList<FirewallRule>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchUpdateIngressRulesRequest request =
        BatchUpdateIngressRulesRequest.newBuilder()
            .setName("apps/app-4902/firewall/ingressRules")
            .addAllIngressRules(new ArrayList<FirewallRule>())
            .build();

    BatchUpdateIngressRulesResponse actualResponse = client.batchUpdateIngressRules(request);
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
  public void batchUpdateIngressRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchUpdateIngressRulesRequest request =
          BatchUpdateIngressRulesRequest.newBuilder()
              .setName("apps/app-4902/firewall/ingressRules")
              .addAllIngressRules(new ArrayList<FirewallRule>())
              .build();
      client.batchUpdateIngressRules(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    CreateIngressRuleRequest request =
        CreateIngressRuleRequest.newBuilder()
            .setParent("apps/app-3559")
            .setRule(FirewallRule.newBuilder().build())
            .build();

    FirewallRule actualResponse = client.createIngressRule(request);
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
  public void createIngressRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateIngressRuleRequest request =
          CreateIngressRuleRequest.newBuilder()
              .setParent("apps/app-3559")
              .setRule(FirewallRule.newBuilder().build())
              .build();
      client.createIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    GetIngressRuleRequest request =
        GetIngressRuleRequest.newBuilder()
            .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
            .build();

    FirewallRule actualResponse = client.getIngressRule(request);
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
  public void getIngressRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIngressRuleRequest request =
          GetIngressRuleRequest.newBuilder()
              .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
              .build();
      client.getIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    UpdateIngressRuleRequest request =
        UpdateIngressRuleRequest.newBuilder()
            .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
            .setRule(FirewallRule.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    FirewallRule actualResponse = client.updateIngressRule(request);
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
  public void updateIngressRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateIngressRuleRequest request =
          UpdateIngressRuleRequest.newBuilder()
              .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
              .setRule(FirewallRule.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIngressRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteIngressRuleRequest request =
        DeleteIngressRuleRequest.newBuilder()
            .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
            .build();

    client.deleteIngressRule(request);

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
  public void deleteIngressRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteIngressRuleRequest request =
          DeleteIngressRuleRequest.newBuilder()
              .setName("apps/app-389/firewall/ingressRules/ingressRule-389")
              .build();
      client.deleteIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
