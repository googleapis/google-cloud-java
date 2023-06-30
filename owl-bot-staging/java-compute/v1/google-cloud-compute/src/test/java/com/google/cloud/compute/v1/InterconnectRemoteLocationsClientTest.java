/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.InterconnectRemoteLocationsClient.ListPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.stub.HttpJsonInterconnectRemoteLocationsStub;
import com.google.common.collect.Lists;
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
public class InterconnectRemoteLocationsClientTest {
  private static MockHttpService mockService;
  private static InterconnectRemoteLocationsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonInterconnectRemoteLocationsStub.getMethodDescriptors(),
            InterconnectRemoteLocationsSettings.getDefaultEndpoint());
    InterconnectRemoteLocationsSettings settings =
        InterconnectRemoteLocationsSettings.newBuilder()
            .setTransportChannelProvider(
                InterconnectRemoteLocationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InterconnectRemoteLocationsClient.create(settings);
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
  public void getTest() throws Exception {
    InterconnectRemoteLocation expectedResponse =
        InterconnectRemoteLocation.newBuilder()
            .setAddress("address-1147692044")
            .setAttachmentConfigurationConstraints(
                InterconnectAttachmentConfigurationConstraints.newBuilder().build())
            .setCity("city3053931")
            .setConstraints(InterconnectRemoteLocationConstraints.newBuilder().build())
            .setContinent("continent-403427916")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setFacilityProvider("facilityProvider-132020812")
            .setFacilityProviderFacilityId("facilityProviderFacilityId459025394")
            .setId(3355)
            .setKind("kind3292052")
            .setLacp("lacp3313826")
            .setMaxLagSize100Gbps(-828522571)
            .setMaxLagSize10Gbps(294007573)
            .setName("name3373707")
            .setPeeringdbFacilityId("peeringdbFacilityId1154838908")
            .addAllPermittedConnections(
                new ArrayList<InterconnectRemoteLocationPermittedConnections>())
            .setRemoteService("remoteService-1795380337")
            .setSelfLink("selfLink1191800166")
            .setStatus("status-892481550")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String interconnectRemoteLocation = "interconnectRemoteLocation-4719";

    InterconnectRemoteLocation actualResponse = client.get(project, interconnectRemoteLocation);
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
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String interconnectRemoteLocation = "interconnectRemoteLocation-4719";
      client.get(project, interconnectRemoteLocation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    InterconnectRemoteLocation responsesElement = InterconnectRemoteLocation.newBuilder().build();
    InterconnectRemoteLocationList expectedResponse =
        InterconnectRemoteLocationList.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";

    ListPagedResponse pagedListResponse = client.list(project);

    List<InterconnectRemoteLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      client.list(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
