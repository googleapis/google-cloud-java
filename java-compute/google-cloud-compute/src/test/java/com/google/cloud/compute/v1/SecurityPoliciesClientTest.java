/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.addRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.deleteMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.getMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.getRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.insertMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.listMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.listPreconfiguredExpressionSetsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.patchMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.patchRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSecurityPoliciesStub.removeRuleMethodDescriptor;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.stub.SecurityPoliciesStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SecurityPoliciesClientTest {
  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              addRuleMethodDescriptor,
              deleteMethodDescriptor,
              getMethodDescriptor,
              getRuleMethodDescriptor,
              insertMethodDescriptor,
              listMethodDescriptor,
              listPreconfiguredExpressionSetsMethodDescriptor,
              patchMethodDescriptor,
              patchRuleMethodDescriptor,
              removeRuleMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, SecurityPoliciesStubSettings.getDefaultEndpoint());

  private static SecurityPoliciesClient client;
  private static SecurityPoliciesSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        SecurityPoliciesSettings.newBuilder()
            .setTransportChannelProvider(
                SecurityPoliciesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityPoliciesClient.create(clientSettings);
  }

  @After
  public void cleanUp() {
    mockService.reset();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void addRuleTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";
    SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();

    Operation actualResponse = client.addRule(project, securityPolicy, securityPolicyRuleResource);
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
  @SuppressWarnings("all")
  public void addRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";
      SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();

      client.addRule(project, securityPolicy, securityPolicyRuleResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";

    Operation actualResponse = client.delete(project, securityPolicy);
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
  @SuppressWarnings("all")
  public void deleteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";

      client.delete(project, securityPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTest() {
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String fingerprint = "fingerprint-1375934236";
    String id = "id3355";
    String kind = "kind3292052";
    String name = "name3373707";
    String selfLink = "selfLink-1691268851";
    SecurityPolicy expectedResponse =
        SecurityPolicy.newBuilder()
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setFingerprint(fingerprint)
            .setId(id)
            .setKind(kind)
            .setName(name)
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";

    SecurityPolicy actualResponse = client.get(project, securityPolicy);
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
  @SuppressWarnings("all")
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";

      client.get(project, securityPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getRuleTest() {
    String action = "action-1422950858";
    String description = "description-1724546052";
    String kind = "kind3292052";
    boolean preview = true;
    int priority = 1165461084;
    SecurityPolicyRule expectedResponse =
        SecurityPolicyRule.newBuilder()
            .setAction(action)
            .setDescription(description)
            .setKind(kind)
            .setPreview(preview)
            .setPriority(priority)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";

    SecurityPolicyRule actualResponse = client.getRule(project, securityPolicy);
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
  @SuppressWarnings("all")
  public void getRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";

      client.getRule(project, securityPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();

    Operation actualResponse = client.insert(project, securityPolicyResource);
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
  @SuppressWarnings("all")
  public void insertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();

      client.insert(project, securityPolicyResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    SecurityPolicy itemsElement = SecurityPolicy.newBuilder().build();
    List<SecurityPolicy> items = Arrays.asList(itemsElement);
    SecurityPolicyList expectedResponse =
        SecurityPolicyList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";

    ListPagedResponse pagedListResponse = client.list(project);

    List<SecurityPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

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
  @SuppressWarnings("all")
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";

      client.list(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPreconfiguredExpressionSetsTest() {
    SecurityPoliciesListPreconfiguredExpressionSetsResponse expectedResponse =
        SecurityPoliciesListPreconfiguredExpressionSetsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";

    SecurityPoliciesListPreconfiguredExpressionSetsResponse actualResponse =
        client.listPreconfiguredExpressionSets(project);
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
  @SuppressWarnings("all")
  public void listPreconfiguredExpressionSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";

      client.listPreconfiguredExpressionSets(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void patchTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";
    SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();

    Operation actualResponse = client.patch(project, securityPolicy, securityPolicyResource);
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
  @SuppressWarnings("all")
  public void patchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";
      SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();

      client.patch(project, securityPolicy, securityPolicyResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void patchRuleTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";
    SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();

    Operation actualResponse =
        client.patchRule(project, securityPolicy, securityPolicyRuleResource);
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
  @SuppressWarnings("all")
  public void patchRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";
      SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();

      client.patchRule(project, securityPolicy, securityPolicyRuleResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void removeRuleTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone = "zone3744684";
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String securityPolicy = "securityPolicy1781695249";

    Operation actualResponse = client.removeRule(project, securityPolicy);
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
  @SuppressWarnings("all")
  public void removeRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String securityPolicy = "securityPolicy1781695249";

      client.removeRule(project, securityPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
