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

import static com.google.cloud.compute.v1.InterconnectLocationClient.ListInterconnectLocationsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectLocationStub.getInterconnectLocationMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectLocationStub.listInterconnectLocationsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.InterconnectLocationStubSettings;
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
public class InterconnectLocationClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              getInterconnectLocationMethodDescriptor, listInterconnectLocationsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, InterconnectLocationStubSettings.getDefaultEndpoint());

  private static InterconnectLocationClient client;
  private static InterconnectLocationSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        InterconnectLocationSettings.newBuilder()
            .setTransportChannelProvider(
                InterconnectLocationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InterconnectLocationClient.create(clientSettings);
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
  public void getInterconnectLocationTest() {
    String continent = "continent-403427916";
    ProjectGlobalAddressName address = ProjectGlobalAddressName.of("[PROJECT]", "[ADDRESS]");
    String city = "city3053931";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String peeringdbFacilityId = "peeringdbFacilityId-303818";
    String availabilityZone = "availabilityZone-378410992";
    String facilityProviderFacilityId = "facilityProviderFacilityId-1523343611";
    String selfLink = "selfLink-1691268851";
    String facilityProvider = "facilityProvider2143916045";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    String id = "id3355";
    InterconnectLocation expectedResponse =
        InterconnectLocation.newBuilder()
            .setContinent(continent)
            .setAddress(address.toString())
            .setCity(city)
            .setKind(kind)
            .setDescription(description)
            .setPeeringdbFacilityId(peeringdbFacilityId)
            .setAvailabilityZone(availabilityZone)
            .setFacilityProviderFacilityId(facilityProviderFacilityId)
            .setSelfLink(selfLink)
            .setFacilityProvider(facilityProvider)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setId(id)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalInterconnectLocationName interconnectLocation =
        ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");

    InterconnectLocation actualResponse = client.getInterconnectLocation(interconnectLocation);
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
  public void getInterconnectLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalInterconnectLocationName interconnectLocation =
          ProjectGlobalInterconnectLocationName.of("[PROJECT]", "[INTERCONNECT_LOCATION]");

      client.getInterconnectLocation(interconnectLocation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInterconnectLocationsTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    InterconnectLocation itemsElement = InterconnectLocation.newBuilder().build();
    List<InterconnectLocation> items = Arrays.asList(itemsElement);
    InterconnectLocationList expectedResponse =
        InterconnectLocationList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListInterconnectLocationsPagedResponse pagedListResponse =
        client.listInterconnectLocations(project);

    List<InterconnectLocation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listInterconnectLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listInterconnectLocations(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
