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

import static com.google.cloud.compute.v1.NodeTypeClient.AggregatedListNodeTypesPagedResponse;
import static com.google.cloud.compute.v1.NodeTypeClient.ListNodeTypesPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonNodeTypeStub.aggregatedListNodeTypesMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNodeTypeStub.getNodeTypeMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNodeTypeStub.listNodeTypesMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.NodeTypeStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class NodeTypeClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListNodeTypesMethodDescriptor,
              getNodeTypeMethodDescriptor,
              listNodeTypesMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, NodeTypeStubSettings.getDefaultEndpoint());

  private static NodeTypeClient client;
  private static NodeTypeSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        NodeTypeSettings.newBuilder()
            .setTransportChannelProvider(
                NodeTypeSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NodeTypeClient.create(clientSettings);
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
  public void aggregatedListNodeTypesTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    NodeTypesScopedList itemsItem = NodeTypesScopedList.newBuilder().build();
    Map<String, NodeTypesScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    NodeTypeAggregatedList expectedResponse =
        NodeTypeAggregatedList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListNodeTypesPagedResponse pagedListResponse =
        client.aggregatedListNodeTypes(project);

    List<NodeTypesScopedList> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getItemsMap().values().iterator().next(), resources.get(0));

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
  public void aggregatedListNodeTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListNodeTypes(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNodeTypeTest() {
    Integer memoryMb = 1726613907;
    Integer guestCpus = 1754126894;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String kind = "kind3292052";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    String description = "description-1724546052";
    String cpuPlatform = "cpuPlatform947156266";
    String id = "id3355";
    Integer localSsdGb = 1281375158;
    String selfLink = "selfLink-1691268851";
    NodeType expectedResponse =
        NodeType.newBuilder()
            .setMemoryMb(memoryMb)
            .setGuestCpus(guestCpus)
            .setZone(zone.toString())
            .setKind(kind)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setDescription(description)
            .setCpuPlatform(cpuPlatform)
            .setId(id)
            .setLocalSsdGb(localSsdGb)
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNodeTypeName nodeType =
        ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");

    NodeType actualResponse = client.getNodeType(nodeType);
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
  public void getNodeTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNodeTypeName nodeType =
          ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");

      client.getNodeType(nodeType);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNodeTypesTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    NodeType itemsElement = NodeType.newBuilder().build();
    List<NodeType> items = Arrays.asList(itemsElement);
    NodeTypeList expectedResponse =
        NodeTypeList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

    ListNodeTypesPagedResponse pagedListResponse = client.listNodeTypes(zone);

    List<NodeType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listNodeTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

      client.listNodeTypes(zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
