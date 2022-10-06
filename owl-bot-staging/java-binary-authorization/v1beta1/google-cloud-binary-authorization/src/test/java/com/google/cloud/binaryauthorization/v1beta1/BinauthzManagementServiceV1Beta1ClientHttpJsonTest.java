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

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.binaryauthorization.v1beta1.stub.HttpJsonBinauthzManagementServiceV1Beta1Stub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class BinauthzManagementServiceV1Beta1ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BinauthzManagementServiceV1Beta1Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBinauthzManagementServiceV1Beta1Stub.getMethodDescriptors(),
            BinauthzManagementServiceV1Beta1Settings.getDefaultEndpoint());
    BinauthzManagementServiceV1Beta1Settings settings =
        BinauthzManagementServiceV1Beta1Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BinauthzManagementServiceV1Beta1Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BinauthzManagementServiceV1Beta1Client.create(settings);
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
  public void getPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
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

    PolicyName name = PolicyName.ofProjectName("[PROJECT]");

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
      PolicyName name = PolicyName.ofProjectName("[PROJECT]");
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
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

    String name = "projects/project-415/policy";

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
  public void getPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-415/policy";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
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

    Policy policy =
        Policy.newBuilder()
            .setName(PolicyName.ofProjectName("[PROJECT]").toString())
            .setDescription("description-1724546052")
            .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
            .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
            .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
            .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();

    Policy actualResponse = client.updatePolicy(policy);
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
      Policy policy =
          Policy.newBuilder()
              .setName(PolicyName.ofProjectName("[PROJECT]").toString())
              .setDescription("description-1724546052")
              .addAllAdmissionWhitelistPatterns(new ArrayList<AdmissionWhitelistPattern>())
              .putAllClusterAdmissionRules(new HashMap<String, AdmissionRule>())
              .putAllKubernetesNamespaceAdmissionRules(new HashMap<String, AdmissionRule>())
              .putAllKubernetesServiceAccountAdmissionRules(new HashMap<String, AdmissionRule>())
              .putAllIstioServiceIdentityAdmissionRules(new HashMap<String, AdmissionRule>())
              .setDefaultAdmissionRule(AdmissionRule.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      client.updatePolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String attestorId = "attestorId2055733027";
    Attestor attestor = Attestor.newBuilder().build();

    Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
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
  public void createAttestorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String attestorId = "attestorId2055733027";
      Attestor attestor = Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttestorTest2() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    String attestorId = "attestorId2055733027";
    Attestor attestor = Attestor.newBuilder().build();

    Attestor actualResponse = client.createAttestor(parent, attestorId, attestor);
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
  public void createAttestorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      String attestorId = "attestorId2055733027";
      Attestor attestor = Attestor.newBuilder().build();
      client.createAttestor(parent, attestorId, attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    Attestor actualResponse = client.getAttestor(name);
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
  public void getAttestorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
      client.getAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttestorTest2() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2729/attestors/attestor-2729";

    Attestor actualResponse = client.getAttestor(name);
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
  public void getAttestorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2729/attestors/attestor-2729";
      client.getAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAttestorTest() throws Exception {
    Attestor expectedResponse =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Attestor attestor =
        Attestor.newBuilder()
            .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();

    Attestor actualResponse = client.updateAttestor(attestor);
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
  public void updateAttestorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Attestor attestor =
          Attestor.newBuilder()
              .setName(AttestorName.of("[PROJECT]", "[ATTESTOR]").toString())
              .setDescription("description-1724546052")
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      client.updateAttestor(attestor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttestorsTest() throws Exception {
    Attestor responsesElement = Attestor.newBuilder().build();
    ListAttestorsResponse expectedResponse =
        ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

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
  public void listAttestorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listAttestors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttestorsTest2() throws Exception {
    Attestor responsesElement = Attestor.newBuilder().build();
    ListAttestorsResponse expectedResponse =
        ListAttestorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttestors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListAttestorsPagedResponse pagedListResponse = client.listAttestors(parent);

    List<Attestor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttestorsList().get(0), resources.get(0));

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
  public void listAttestorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listAttestors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttestorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");

    client.deleteAttestor(name);

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
  public void deleteAttestorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttestorName name = AttestorName.of("[PROJECT]", "[ATTESTOR]");
      client.deleteAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttestorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2729/attestors/attestor-2729";

    client.deleteAttestor(name);

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
  public void deleteAttestorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2729/attestors/attestor-2729";
      client.deleteAttestor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
