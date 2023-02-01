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

package com.google.iam.v2;

import static com.google.iam.v2.PoliciesClient.ListPoliciesPagedResponse;

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
import com.google.iam.v2.stub.HttpJsonPoliciesStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class PoliciesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PoliciesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPoliciesStub.getMethodDescriptors(), PoliciesSettings.getDefaultEndpoint());
    PoliciesSettings settings =
        PoliciesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PoliciesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PoliciesClient.create(settings);
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
  public void listPoliciesTest() throws Exception {
    Policy responsesElement = Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "policies/policie-1456/policie-1456";

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<Policy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

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
  public void listPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "policies/policie-1456/policie-1456";
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "policies/policie-3260/policie-3260/policie-3260";

    Policy actualResponse = client.getPolicy(name);
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
  public void getPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "policies/policie-3260/policie-3260/policie-3260";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "policies/policie-1456/policie-1456";
    Policy policy = Policy.newBuilder().build();
    String policyId = "policyId546908653";

    Policy actualResponse = client.createPolicyAsync(parent, policy, policyId).get();
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
  public void createPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "policies/policie-1456/policie-1456";
      Policy policy = Policy.newBuilder().build();
      String policyId = "policyId546908653";
      client.createPolicyAsync(parent, policy, policyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdatePolicyRequest request =
        UpdatePolicyRequest.newBuilder()
            .setPolicy(
                Policy.newBuilder()
                    .setName("policies/policie-3260/policie-3260/policie-3260")
                    .setUid("uid115792")
                    .setKind("kind3292052")
                    .setDisplayName("displayName1714148973")
                    .putAllAnnotations(new HashMap<String, String>())
                    .setEtag("etag3123477")
                    .setCreateTime(Timestamp.newBuilder().build())
                    .setUpdateTime(Timestamp.newBuilder().build())
                    .setDeleteTime(Timestamp.newBuilder().build())
                    .addAllRules(new ArrayList<PolicyRule>())
                    .setManagingAuthority("managingAuthority867537025")
                    .build())
            .build();

    Policy actualResponse = client.updatePolicyAsync(request).get();
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
  public void updatePolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdatePolicyRequest request =
          UpdatePolicyRequest.newBuilder()
              .setPolicy(
                  Policy.newBuilder()
                      .setName("policies/policie-3260/policie-3260/policie-3260")
                      .setUid("uid115792")
                      .setKind("kind3292052")
                      .setDisplayName("displayName1714148973")
                      .putAllAnnotations(new HashMap<String, String>())
                      .setEtag("etag3123477")
                      .setCreateTime(Timestamp.newBuilder().build())
                      .setUpdateTime(Timestamp.newBuilder().build())
                      .setDeleteTime(Timestamp.newBuilder().build())
                      .addAllRules(new ArrayList<PolicyRule>())
                      .setManagingAuthority("managingAuthority867537025")
                      .build())
              .build();
      client.updatePolicyAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName("name3373707")
            .setUid("uid115792")
            .setKind("kind3292052")
            .setDisplayName("displayName1714148973")
            .putAllAnnotations(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .addAllRules(new ArrayList<PolicyRule>())
            .setManagingAuthority("managingAuthority867537025")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "policies/policie-3260/policie-3260/policie-3260";

    Policy actualResponse = client.deletePolicyAsync(name).get();
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
  public void deletePolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "policies/policie-3260/policie-3260/policie-3260";
      client.deletePolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
