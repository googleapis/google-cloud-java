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

package com.google.cloud.binaryauthorization.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.binaryauthorization.v1beta1.stub.HttpJsonSystemPolicyV1Beta1Stub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SystemPolicyV1Beta1ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SystemPolicyV1Beta1Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSystemPolicyV1Beta1Stub.getMethodDescriptors(),
            SystemPolicyV1Beta1Settings.getDefaultEndpoint());
    SystemPolicyV1Beta1Settings settings =
        SystemPolicyV1Beta1Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SystemPolicyV1Beta1Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SystemPolicyV1Beta1Client.create(settings);
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
  public void getSystemPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofLocationName("[LOCATION]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PolicyName name = PolicyName.ofLocationName("[LOCATION]");

    Policy actualResponse = client.getSystemPolicy(name);
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
  public void getSystemPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyName name = PolicyName.ofLocationName("[LOCATION]");
      client.getSystemPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSystemPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofLocationName("[LOCATION]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "locations/location-9731/policy";

    Policy actualResponse = client.getSystemPolicy(name);
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
  public void getSystemPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "locations/location-9731/policy";
      client.getSystemPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
