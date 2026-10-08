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

import static com.google.ads.admanager.v1.LineItemCreativeAssociationServiceClient.ListLineItemCreativeAssociationsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonLineItemCreativeAssociationServiceStub;
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
import com.google.protobuf.Timestamp;
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
public class LineItemCreativeAssociationServiceClientTest {
  private static MockHttpService mockService;
  private static LineItemCreativeAssociationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLineItemCreativeAssociationServiceStub.getMethodDescriptors(),
            LineItemCreativeAssociationServiceSettings.getDefaultEndpoint());
    LineItemCreativeAssociationServiceSettings settings =
        LineItemCreativeAssociationServiceSettings.newBuilder()
            .setTransportChannelProvider(
                LineItemCreativeAssociationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineItemCreativeAssociationServiceClient.create(settings);
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
  public void getLineItemCreativeAssociationTest() throws Exception {
    LineItemCreativeAssociation expectedResponse =
        LineItemCreativeAssociation.newBuilder()
            .setName(
                LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
                    .toString())
            .setLineItem(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setCreative(CreativeName.of("[NETWORK_CODE]", "[CREATIVE]").toString())
            .setCreativeSet(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllSizes(new ArrayList<Size>())
            .setDestinationUrl("destinationUrl912975489")
            .setManualCreativeRotationWeight(1236976674)
            .setSequentialCreativeRotationIndex(-365271007)
            .setTargetingDisplayName("targetingDisplayName-1736481540")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStats(LineItemCreativeAssociationStats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LineItemCreativeAssociationName name =
        LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]");

    LineItemCreativeAssociation actualResponse = client.getLineItemCreativeAssociation(name);
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
  public void getLineItemCreativeAssociationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItemCreativeAssociationName name =
          LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]");
      client.getLineItemCreativeAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineItemCreativeAssociationTest2() throws Exception {
    LineItemCreativeAssociation expectedResponse =
        LineItemCreativeAssociation.newBuilder()
            .setName(
                LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
                    .toString())
            .setLineItem(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setCreative(CreativeName.of("[NETWORK_CODE]", "[CREATIVE]").toString())
            .setCreativeSet(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllSizes(new ArrayList<Size>())
            .setDestinationUrl("destinationUrl912975489")
            .setManualCreativeRotationWeight(1236976674)
            .setSequentialCreativeRotationIndex(-365271007)
            .setTargetingDisplayName("targetingDisplayName-1736481540")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStats(LineItemCreativeAssociationStats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-3731/lineItems/lineItem-3731/creatives/creative-3731";

    LineItemCreativeAssociation actualResponse = client.getLineItemCreativeAssociation(name);
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
  public void getLineItemCreativeAssociationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-3731/lineItems/lineItem-3731/creatives/creative-3731";
      client.getLineItemCreativeAssociation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemCreativeAssociationsTest() throws Exception {
    LineItemCreativeAssociation responsesElement = LineItemCreativeAssociation.newBuilder().build();
    ListLineItemCreativeAssociationsResponse expectedResponse =
        ListLineItemCreativeAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItemCreativeAssociations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");

    ListLineItemCreativeAssociationsPagedResponse pagedListResponse =
        client.listLineItemCreativeAssociations(parent);

    List<LineItemCreativeAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getLineItemCreativeAssociationsList().get(0), resources.get(0));

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
  public void listLineItemCreativeAssociationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
      client.listLineItemCreativeAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemCreativeAssociationsTest2() throws Exception {
    LineItemCreativeAssociation responsesElement = LineItemCreativeAssociation.newBuilder().build();
    ListLineItemCreativeAssociationsResponse expectedResponse =
        ListLineItemCreativeAssociationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItemCreativeAssociations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5774/lineItems/lineItem-5774";

    ListLineItemCreativeAssociationsPagedResponse pagedListResponse =
        client.listLineItemCreativeAssociations(parent);

    List<LineItemCreativeAssociation> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getLineItemCreativeAssociationsList().get(0), resources.get(0));

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
  public void listLineItemCreativeAssociationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5774/lineItems/lineItem-5774";
      client.listLineItemCreativeAssociations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
