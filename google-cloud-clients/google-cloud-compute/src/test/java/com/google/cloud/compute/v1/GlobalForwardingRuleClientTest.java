/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.GlobalForwardingRuleClient.ListGlobalForwardingRulesPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalForwardingRuleStub.deleteGlobalForwardingRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalForwardingRuleStub.getGlobalForwardingRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalForwardingRuleStub.insertGlobalForwardingRuleMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalForwardingRuleStub.listGlobalForwardingRulesMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalForwardingRuleStub.setTargetGlobalForwardingRuleMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.GlobalForwardingRuleStubSettings;
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
public class GlobalForwardingRuleClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              deleteGlobalForwardingRuleMethodDescriptor,
              getGlobalForwardingRuleMethodDescriptor,
              insertGlobalForwardingRuleMethodDescriptor,
              listGlobalForwardingRulesMethodDescriptor,
              setTargetGlobalForwardingRuleMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, GlobalForwardingRuleStubSettings.getDefaultEndpoint());

  private static GlobalForwardingRuleClient client;
  private static GlobalForwardingRuleSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        GlobalForwardingRuleSettings.newBuilder()
            .setTransportChannelProvider(
                GlobalForwardingRuleSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GlobalForwardingRuleClient.create(clientSettings);
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
  public void deleteGlobalForwardingRuleTest() {
    String httpErrorMessage = "httpErrorMessage1276263769";
    String targetId = "targetId-815576439";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String insertTime = "insertTime-103148397";
    Integer httpErrorStatusCode = 1386087020;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String targetLink = "targetLink-2084812312";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    Integer progress = 1001078227;
    String operationType = "operationType-1432962286";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    String id = "id3355";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String clientOperationId = "clientOperationId-239630617";
    String user = "user3599307";
    String status = "status-892481550";
    Operation expectedResponse =
        Operation.newBuilder()
            .setHttpErrorMessage(httpErrorMessage)
            .setTargetId(targetId)
            .setKind(kind)
            .setDescription(description)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setInsertTime(insertTime)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setZone(zone.toString())
            .setTargetLink(targetLink)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setProgress(progress)
            .setOperationType(operationType)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setId(id)
            .setRegion(region.toString())
            .setClientOperationId(clientOperationId)
            .setUser(user)
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalForwardingRuleName forwardingRule =
        ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");

    Operation actualResponse = client.deleteGlobalForwardingRule(forwardingRule);
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
  public void deleteGlobalForwardingRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalForwardingRuleName forwardingRule =
          ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");

      client.deleteGlobalForwardingRule(forwardingRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGlobalForwardingRuleTest() {
    String portRange = "portRange217518079";
    String networkTier = "networkTier-19473069";
    String kind = "kind3292052";
    String iPProtocol = "iPProtocol323774237";
    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
    String description = "description-1724546052";
    String loadBalancingScheme = "loadBalancingScheme1974502980";
    ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
    String selfLink = "selfLink-1691268851";
    String target = "target-880905839";
    String ipVersion = "ipVersion-1315653184";
    ProjectRegionSubnetworkName subnetwork =
        ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    String id = "id3355";
    String iPAddress = "iPAddress-551149873";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    ForwardingRule expectedResponse =
        ForwardingRule.newBuilder()
            .setPortRange(portRange)
            .setNetworkTier(networkTier)
            .setKind(kind)
            .setIPProtocol(iPProtocol)
            .setBackendService(backendService.toString())
            .setDescription(description)
            .setLoadBalancingScheme(loadBalancingScheme)
            .setNetwork(network.toString())
            .setSelfLink(selfLink)
            .setTarget(target)
            .setIpVersion(ipVersion)
            .setSubnetwork(subnetwork.toString())
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setId(id)
            .setIPAddress(iPAddress)
            .setRegion(region.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalForwardingRuleName forwardingRule =
        ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");

    ForwardingRule actualResponse = client.getGlobalForwardingRule(forwardingRule);
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
  public void getGlobalForwardingRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalForwardingRuleName forwardingRule =
          ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");

      client.getGlobalForwardingRule(forwardingRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertGlobalForwardingRuleTest() {
    String httpErrorMessage = "httpErrorMessage1276263769";
    String targetId = "targetId-815576439";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String insertTime = "insertTime-103148397";
    Integer httpErrorStatusCode = 1386087020;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String targetLink = "targetLink-2084812312";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    Integer progress = 1001078227;
    String operationType = "operationType-1432962286";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    String id = "id3355";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String clientOperationId = "clientOperationId-239630617";
    String user = "user3599307";
    String status = "status-892481550";
    Operation expectedResponse =
        Operation.newBuilder()
            .setHttpErrorMessage(httpErrorMessage)
            .setTargetId(targetId)
            .setKind(kind)
            .setDescription(description)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setInsertTime(insertTime)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setZone(zone.toString())
            .setTargetLink(targetLink)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setProgress(progress)
            .setOperationType(operationType)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setId(id)
            .setRegion(region.toString())
            .setClientOperationId(clientOperationId)
            .setUser(user)
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");
    ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();

    Operation actualResponse = client.insertGlobalForwardingRule(project, forwardingRuleResource);
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
  public void insertGlobalForwardingRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();

      client.insertGlobalForwardingRule(project, forwardingRuleResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGlobalForwardingRulesTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    ForwardingRule itemsElement = ForwardingRule.newBuilder().build();
    List<ForwardingRule> items = Arrays.asList(itemsElement);
    ForwardingRuleList expectedResponse =
        ForwardingRuleList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListGlobalForwardingRulesPagedResponse pagedListResponse =
        client.listGlobalForwardingRules(project);

    List<ForwardingRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listGlobalForwardingRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listGlobalForwardingRules(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setTargetGlobalForwardingRuleTest() {
    String httpErrorMessage = "httpErrorMessage1276263769";
    String targetId = "targetId-815576439";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String insertTime = "insertTime-103148397";
    Integer httpErrorStatusCode = 1386087020;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String targetLink = "targetLink-2084812312";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    Integer progress = 1001078227;
    String operationType = "operationType-1432962286";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    String id = "id3355";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String clientOperationId = "clientOperationId-239630617";
    String user = "user3599307";
    String status = "status-892481550";
    Operation expectedResponse =
        Operation.newBuilder()
            .setHttpErrorMessage(httpErrorMessage)
            .setTargetId(targetId)
            .setKind(kind)
            .setDescription(description)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setInsertTime(insertTime)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setZone(zone.toString())
            .setTargetLink(targetLink)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setProgress(progress)
            .setOperationType(operationType)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setId(id)
            .setRegion(region.toString())
            .setClientOperationId(clientOperationId)
            .setUser(user)
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalForwardingRuleName forwardingRule =
        ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
    TargetReference targetReferenceResource = TargetReference.newBuilder().build();

    Operation actualResponse =
        client.setTargetGlobalForwardingRule(forwardingRule, targetReferenceResource);
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
  public void setTargetGlobalForwardingRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalForwardingRuleName forwardingRule =
          ProjectGlobalForwardingRuleName.of("[PROJECT]", "[FORWARDING_RULE]");
      TargetReference targetReferenceResource = TargetReference.newBuilder().build();

      client.setTargetGlobalForwardingRule(forwardingRule, targetReferenceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
