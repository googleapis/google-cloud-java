/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.networkservices.v1;

import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewaysPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGrpcRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListHttpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListLocationsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceBindingsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTcpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTlsRoutesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.stub.HttpJsonNetworkServicesStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class NetworkServicesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static NetworkServicesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonNetworkServicesStub.getMethodDescriptors(),
            NetworkServicesSettings.getDefaultEndpoint());
    NetworkServicesSettings settings =
        NetworkServicesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                NetworkServicesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NetworkServicesClient.create(settings);
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
  public void listEndpointPoliciesTest() throws Exception {
    EndpointPolicy responsesElement = EndpointPolicy.newBuilder().build();
    ListEndpointPoliciesResponse expectedResponse =
        ListEndpointPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpointPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointPoliciesPagedResponse pagedListResponse = client.listEndpointPolicies(parent);

    List<EndpointPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointPoliciesList().get(0), resources.get(0));

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
  public void listEndpointPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEndpointPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointPoliciesTest2() throws Exception {
    EndpointPolicy responsesElement = EndpointPolicy.newBuilder().build();
    ListEndpointPoliciesResponse expectedResponse =
        ListEndpointPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpointPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEndpointPoliciesPagedResponse pagedListResponse = client.listEndpointPolicies(parent);

    List<EndpointPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointPoliciesList().get(0), resources.get(0));

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
  public void listEndpointPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEndpointPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    mockService.addResponse(expectedResponse);

    EndpointPolicyName name = EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");

    EndpointPolicy actualResponse = client.getEndpointPolicy(name);
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
  public void getEndpointPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointPolicyName name =
          EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
      client.getEndpointPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointPolicyTest2() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3701/locations/location-3701/endpointPolicies/endpointPolicie-3701";

    EndpointPolicy actualResponse = client.getEndpointPolicy(name);
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
  public void getEndpointPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3701/locations/location-3701/endpointPolicies/endpointPolicie-3701";
      client.getEndpointPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
    String endpointPolicyId = "endpointPolicyId-509458782";

    EndpointPolicy actualResponse =
        client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
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
  public void createEndpointPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
      String endpointPolicyId = "endpointPolicyId-509458782";
      client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEndpointPolicyTest2() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
    String endpointPolicyId = "endpointPolicyId-509458782";

    EndpointPolicy actualResponse =
        client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
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
  public void createEndpointPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
      String endpointPolicyId = "endpointPolicyId-509458782";
      client.createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEndpointPolicyTest() throws Exception {
    EndpointPolicy expectedResponse =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EndpointPolicy endpointPolicy =
        EndpointPolicy.newBuilder()
            .setName(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAuthorizationPolicy("authorizationPolicy1042707211")
            .setEndpointMatcher(EndpointMatcher.newBuilder().build())
            .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
            .setDescription("description-1724546052")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .setClientTlsPolicy("clientTlsPolicy1568516738")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EndpointPolicy actualResponse =
        client.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
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
  public void updateEndpointPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointPolicy endpointPolicy =
          EndpointPolicy.newBuilder()
              .setName(
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setAuthorizationPolicy("authorizationPolicy1042707211")
              .setEndpointMatcher(EndpointMatcher.newBuilder().build())
              .setTrafficPortSelector(TrafficPortSelector.newBuilder().build())
              .setDescription("description-1724546052")
              .setServerTlsPolicy("serverTlsPolicy-1897015798")
              .setClientTlsPolicy("clientTlsPolicy1568516738")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEndpointPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EndpointPolicyName name = EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");

    client.deleteEndpointPolicyAsync(name).get();

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
  public void deleteEndpointPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointPolicyName name =
          EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
      client.deleteEndpointPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEndpointPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3701/locations/location-3701/endpointPolicies/endpointPolicie-3701";

    client.deleteEndpointPolicyAsync(name).get();

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
  public void deleteEndpointPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3701/locations/location-3701/endpointPolicies/endpointPolicie-3701";
      client.deleteEndpointPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listGatewaysTest() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

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
  public void listGatewaysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGatewaysTest2() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

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
  public void listGatewaysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    mockService.addResponse(expectedResponse);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    Gateway actualResponse = client.getGateway(name);
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
  public void getGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";

    Gateway actualResponse = client.getGateway(name);
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
  public void getGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
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
  public void createGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
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
  public void createGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Gateway gateway =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllPorts(new ArrayList<Integer>())
            .setScope("scope109264468")
            .setServerTlsPolicy("serverTlsPolicy-1897015798")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Gateway actualResponse = client.updateGatewayAsync(gateway, updateMask).get();
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
  public void updateGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Gateway gateway =
          Gateway.newBuilder()
              .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
              .setSelfLink("selfLink1191800166")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDescription("description-1724546052")
              .addAllPorts(new ArrayList<Integer>())
              .setScope("scope109264468")
              .setServerTlsPolicy("serverTlsPolicy-1897015798")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGatewayAsync(gateway, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGatewayTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    client.deleteGatewayAsync(name).get();

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
  public void deleteGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGatewayTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";

    client.deleteGatewayAsync(name).get();

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
  public void deleteGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listGrpcRoutesTest() throws Exception {
    GrpcRoute responsesElement = GrpcRoute.newBuilder().build();
    ListGrpcRoutesResponse expectedResponse =
        ListGrpcRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrpcRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGrpcRoutesPagedResponse pagedListResponse = client.listGrpcRoutes(parent);

    List<GrpcRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrpcRoutesList().get(0), resources.get(0));

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
  public void listGrpcRoutesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGrpcRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGrpcRoutesTest2() throws Exception {
    GrpcRoute responsesElement = GrpcRoute.newBuilder().build();
    ListGrpcRoutesResponse expectedResponse =
        ListGrpcRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrpcRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGrpcRoutesPagedResponse pagedListResponse = client.listGrpcRoutes(parent);

    List<GrpcRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrpcRoutesList().get(0), resources.get(0));

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
  public void listGrpcRoutesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGrpcRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    mockService.addResponse(expectedResponse);

    GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");

    GrpcRoute actualResponse = client.getGrpcRoute(name);
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
  public void getGrpcRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
      client.getGrpcRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrpcRouteTest2() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9944/locations/location-9944/grpcRoutes/grpcRoute-9944";

    GrpcRoute actualResponse = client.getGrpcRoute(name);
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
  public void getGrpcRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9944/locations/location-9944/grpcRoutes/grpcRoute-9944";
      client.getGrpcRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
    String grpcRouteId = "grpcRouteId1888295750";

    GrpcRoute actualResponse = client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
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
  public void createGrpcRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      String grpcRouteId = "grpcRouteId1888295750";
      client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGrpcRouteTest2() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
    String grpcRouteId = "grpcRouteId1888295750";

    GrpcRoute actualResponse = client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
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
  public void createGrpcRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      String grpcRouteId = "grpcRouteId1888295750";
      client.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateGrpcRouteTest() throws Exception {
    GrpcRoute expectedResponse =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GrpcRoute grpcRoute =
        GrpcRoute.newBuilder()
            .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GrpcRoute actualResponse = client.updateGrpcRouteAsync(grpcRoute, updateMask).get();
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
  public void updateGrpcRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GrpcRoute grpcRoute =
          GrpcRoute.newBuilder()
              .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
              .setSelfLink("selfLink1191800166")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDescription("description-1724546052")
              .addAllHostnames(new ArrayList<String>())
              .addAllMeshes(new ArrayList<String>())
              .addAllGateways(new ArrayList<String>())
              .addAllRules(new ArrayList<GrpcRoute.RouteRule>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGrpcRouteAsync(grpcRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGrpcRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");

    client.deleteGrpcRouteAsync(name).get();

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
  public void deleteGrpcRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
      client.deleteGrpcRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGrpcRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGrpcRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9944/locations/location-9944/grpcRoutes/grpcRoute-9944";

    client.deleteGrpcRouteAsync(name).get();

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
  public void deleteGrpcRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9944/locations/location-9944/grpcRoutes/grpcRoute-9944";
      client.deleteGrpcRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listHttpRoutesTest() throws Exception {
    HttpRoute responsesElement = HttpRoute.newBuilder().build();
    ListHttpRoutesResponse expectedResponse =
        ListHttpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllHttpRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListHttpRoutesPagedResponse pagedListResponse = client.listHttpRoutes(parent);

    List<HttpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHttpRoutesList().get(0), resources.get(0));

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
  public void listHttpRoutesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listHttpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHttpRoutesTest2() throws Exception {
    HttpRoute responsesElement = HttpRoute.newBuilder().build();
    ListHttpRoutesResponse expectedResponse =
        ListHttpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllHttpRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListHttpRoutesPagedResponse pagedListResponse = client.listHttpRoutes(parent);

    List<HttpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHttpRoutesList().get(0), resources.get(0));

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
  public void listHttpRoutesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listHttpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    mockService.addResponse(expectedResponse);

    HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");

    HttpRoute actualResponse = client.getHttpRoute(name);
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
  public void getHttpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
      client.getHttpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHttpRouteTest2() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9090/locations/location-9090/httpRoutes/httpRoute-9090";

    HttpRoute actualResponse = client.getHttpRoute(name);
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
  public void getHttpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9090/locations/location-9090/httpRoutes/httpRoute-9090";
      client.getHttpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    HttpRoute httpRoute = HttpRoute.newBuilder().build();
    String httpRouteId = "httpRouteId-2054835300";

    HttpRoute actualResponse = client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
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
  public void createHttpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      HttpRoute httpRoute = HttpRoute.newBuilder().build();
      String httpRouteId = "httpRouteId-2054835300";
      client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createHttpRouteTest2() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    HttpRoute httpRoute = HttpRoute.newBuilder().build();
    String httpRouteId = "httpRouteId-2054835300";

    HttpRoute actualResponse = client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
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
  public void createHttpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      HttpRoute httpRoute = HttpRoute.newBuilder().build();
      String httpRouteId = "httpRouteId-2054835300";
      client.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateHttpRouteTest() throws Exception {
    HttpRoute expectedResponse =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    HttpRoute httpRoute =
        HttpRoute.newBuilder()
            .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllHostnames(new ArrayList<String>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .addAllRules(new ArrayList<HttpRoute.RouteRule>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    HttpRoute actualResponse = client.updateHttpRouteAsync(httpRoute, updateMask).get();
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
  public void updateHttpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HttpRoute httpRoute =
          HttpRoute.newBuilder()
              .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
              .setSelfLink("selfLink1191800166")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllHostnames(new ArrayList<String>())
              .addAllMeshes(new ArrayList<String>())
              .addAllGateways(new ArrayList<String>())
              .putAllLabels(new HashMap<String, String>())
              .addAllRules(new ArrayList<HttpRoute.RouteRule>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHttpRouteAsync(httpRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteHttpRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");

    client.deleteHttpRouteAsync(name).get();

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
  public void deleteHttpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
      client.deleteHttpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteHttpRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteHttpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9090/locations/location-9090/httpRoutes/httpRoute-9090";

    client.deleteHttpRouteAsync(name).get();

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
  public void deleteHttpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9090/locations/location-9090/httpRoutes/httpRoute-9090";
      client.deleteHttpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTcpRoutesTest() throws Exception {
    TcpRoute responsesElement = TcpRoute.newBuilder().build();
    ListTcpRoutesResponse expectedResponse =
        ListTcpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTcpRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTcpRoutesPagedResponse pagedListResponse = client.listTcpRoutes(parent);

    List<TcpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTcpRoutesList().get(0), resources.get(0));

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
  public void listTcpRoutesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTcpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTcpRoutesTest2() throws Exception {
    TcpRoute responsesElement = TcpRoute.newBuilder().build();
    ListTcpRoutesResponse expectedResponse =
        ListTcpRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTcpRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTcpRoutesPagedResponse pagedListResponse = client.listTcpRoutes(parent);

    List<TcpRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTcpRoutesList().get(0), resources.get(0));

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
  public void listTcpRoutesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listTcpRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");

    TcpRoute actualResponse = client.getTcpRoute(name);
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
  public void getTcpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
      client.getTcpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTcpRouteTest2() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2609/locations/location-2609/tcpRoutes/tcpRoute-2609";

    TcpRoute actualResponse = client.getTcpRoute(name);
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
  public void getTcpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2609/locations/location-2609/tcpRoutes/tcpRoute-2609";
      client.getTcpRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TcpRoute tcpRoute = TcpRoute.newBuilder().build();
    String tcpRouteId = "tcpRouteId806467107";

    TcpRoute actualResponse = client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
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
  public void createTcpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TcpRoute tcpRoute = TcpRoute.newBuilder().build();
      String tcpRouteId = "tcpRouteId806467107";
      client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTcpRouteTest2() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    TcpRoute tcpRoute = TcpRoute.newBuilder().build();
    String tcpRouteId = "tcpRouteId806467107";

    TcpRoute actualResponse = client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
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
  public void createTcpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      TcpRoute tcpRoute = TcpRoute.newBuilder().build();
      String tcpRouteId = "tcpRouteId806467107";
      client.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTcpRouteTest() throws Exception {
    TcpRoute expectedResponse =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TcpRoute tcpRoute =
        TcpRoute.newBuilder()
            .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TcpRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TcpRoute actualResponse = client.updateTcpRouteAsync(tcpRoute, updateMask).get();
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
  public void updateTcpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TcpRoute tcpRoute =
          TcpRoute.newBuilder()
              .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
              .setSelfLink("selfLink1191800166")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .addAllRules(new ArrayList<TcpRoute.RouteRule>())
              .addAllMeshes(new ArrayList<String>())
              .addAllGateways(new ArrayList<String>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTcpRouteAsync(tcpRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTcpRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");

    client.deleteTcpRouteAsync(name).get();

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
  public void deleteTcpRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
      client.deleteTcpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTcpRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTcpRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2609/locations/location-2609/tcpRoutes/tcpRoute-2609";

    client.deleteTcpRouteAsync(name).get();

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
  public void deleteTcpRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2609/locations/location-2609/tcpRoutes/tcpRoute-2609";
      client.deleteTcpRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTlsRoutesTest() throws Exception {
    TlsRoute responsesElement = TlsRoute.newBuilder().build();
    ListTlsRoutesResponse expectedResponse =
        ListTlsRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTlsRoutesPagedResponse pagedListResponse = client.listTlsRoutes(parent);

    List<TlsRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsRoutesList().get(0), resources.get(0));

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
  public void listTlsRoutesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTlsRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTlsRoutesTest2() throws Exception {
    TlsRoute responsesElement = TlsRoute.newBuilder().build();
    ListTlsRoutesResponse expectedResponse =
        ListTlsRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTlsRoutes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTlsRoutesPagedResponse pagedListResponse = client.listTlsRoutes(parent);

    List<TlsRoute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTlsRoutesList().get(0), resources.get(0));

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
  public void listTlsRoutesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listTlsRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");

    TlsRoute actualResponse = client.getTlsRoute(name);
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
  public void getTlsRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
      client.getTlsRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTlsRouteTest2() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5029/locations/location-5029/tlsRoutes/tlsRoute-5029";

    TlsRoute actualResponse = client.getTlsRoute(name);
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
  public void getTlsRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5029/locations/location-5029/tlsRoutes/tlsRoute-5029";
      client.getTlsRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TlsRoute tlsRoute = TlsRoute.newBuilder().build();
    String tlsRouteId = "tlsRouteId-1642257463";

    TlsRoute actualResponse = client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
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
  public void createTlsRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TlsRoute tlsRoute = TlsRoute.newBuilder().build();
      String tlsRouteId = "tlsRouteId-1642257463";
      client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTlsRouteTest2() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    TlsRoute tlsRoute = TlsRoute.newBuilder().build();
    String tlsRouteId = "tlsRouteId-1642257463";

    TlsRoute actualResponse = client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
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
  public void createTlsRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      TlsRoute tlsRoute = TlsRoute.newBuilder().build();
      String tlsRouteId = "tlsRouteId-1642257463";
      client.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTlsRouteTest() throws Exception {
    TlsRoute expectedResponse =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TlsRoute tlsRoute =
        TlsRoute.newBuilder()
            .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllRules(new ArrayList<TlsRoute.RouteRule>())
            .addAllMeshes(new ArrayList<String>())
            .addAllGateways(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TlsRoute actualResponse = client.updateTlsRouteAsync(tlsRoute, updateMask).get();
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
  public void updateTlsRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TlsRoute tlsRoute =
          TlsRoute.newBuilder()
              .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
              .setSelfLink("selfLink1191800166")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .addAllRules(new ArrayList<TlsRoute.RouteRule>())
              .addAllMeshes(new ArrayList<String>())
              .addAllGateways(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTlsRouteAsync(tlsRoute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTlsRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");

    client.deleteTlsRouteAsync(name).get();

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
  public void deleteTlsRouteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
      client.deleteTlsRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTlsRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTlsRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-5029/locations/location-5029/tlsRoutes/tlsRoute-5029";

    client.deleteTlsRouteAsync(name).get();

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
  public void deleteTlsRouteExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5029/locations/location-5029/tlsRoutes/tlsRoute-5029";
      client.deleteTlsRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listServiceBindingsTest() throws Exception {
    ServiceBinding responsesElement = ServiceBinding.newBuilder().build();
    ListServiceBindingsResponse expectedResponse =
        ListServiceBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceBindingsPagedResponse pagedListResponse = client.listServiceBindings(parent);

    List<ServiceBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceBindingsList().get(0), resources.get(0));

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
  public void listServiceBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceBindingsTest2() throws Exception {
    ServiceBinding responsesElement = ServiceBinding.newBuilder().build();
    ListServiceBindingsResponse expectedResponse =
        ListServiceBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceBindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListServiceBindingsPagedResponse pagedListResponse = client.listServiceBindings(parent);

    List<ServiceBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceBindingsList().get(0), resources.get(0));

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
  public void listServiceBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listServiceBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceBindingTest() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ServiceBindingName name = ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");

    ServiceBinding actualResponse = client.getServiceBinding(name);
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
  public void getServiceBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceBindingName name =
          ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
      client.getServiceBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceBindingTest2() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8921/locations/location-8921/serviceBindings/serviceBinding-8921";

    ServiceBinding actualResponse = client.getServiceBinding(name);
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
  public void getServiceBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8921/locations/location-8921/serviceBindings/serviceBinding-8921";
      client.getServiceBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceBindingTest() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
    String serviceBindingId = "serviceBindingId-1424670901";

    ServiceBinding actualResponse =
        client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
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
  public void createServiceBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
      String serviceBindingId = "serviceBindingId-1424670901";
      client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createServiceBindingTest2() throws Exception {
    ServiceBinding expectedResponse =
        ServiceBinding.newBuilder()
            .setName(
                ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setService("service1984153269")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
    String serviceBindingId = "serviceBindingId-1424670901";

    ServiceBinding actualResponse =
        client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
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
  public void createServiceBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
      String serviceBindingId = "serviceBindingId-1424670901";
      client.createServiceBindingAsync(parent, serviceBinding, serviceBindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteServiceBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ServiceBindingName name = ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");

    client.deleteServiceBindingAsync(name).get();

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
  public void deleteServiceBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceBindingName name =
          ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
      client.deleteServiceBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteServiceBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8921/locations/location-8921/serviceBindings/serviceBinding-8921";

    client.deleteServiceBindingAsync(name).get();

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
  public void deleteServiceBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8921/locations/location-8921/serviceBindings/serviceBinding-8921";
      client.deleteServiceBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listMeshesTest() throws Exception {
    Mesh responsesElement = Mesh.newBuilder().build();
    ListMeshesResponse expectedResponse =
        ListMeshesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeshes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMeshesPagedResponse pagedListResponse = client.listMeshes(parent);

    List<Mesh> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMeshesList().get(0), resources.get(0));

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
  public void listMeshesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMeshes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMeshesTest2() throws Exception {
    Mesh responsesElement = Mesh.newBuilder().build();
    ListMeshesResponse expectedResponse =
        ListMeshesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMeshes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListMeshesPagedResponse pagedListResponse = client.listMeshes(parent);

    List<Mesh> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMeshesList().get(0), resources.get(0));

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
  public void listMeshesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listMeshes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    mockService.addResponse(expectedResponse);

    MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");

    Mesh actualResponse = client.getMesh(name);
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
  public void getMeshExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
      client.getMesh(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMeshTest2() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4667/locations/location-4667/meshes/meshe-4667";

    Mesh actualResponse = client.getMesh(name);
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
  public void getMeshExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4667/locations/location-4667/meshes/meshe-4667";
      client.getMesh(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Mesh mesh = Mesh.newBuilder().build();
    String meshId = "meshId-1077585944";

    Mesh actualResponse = client.createMeshAsync(parent, mesh, meshId).get();
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
  public void createMeshExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Mesh mesh = Mesh.newBuilder().build();
      String meshId = "meshId-1077585944";
      client.createMeshAsync(parent, mesh, meshId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMeshTest2() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Mesh mesh = Mesh.newBuilder().build();
    String meshId = "meshId-1077585944";

    Mesh actualResponse = client.createMeshAsync(parent, mesh, meshId).get();
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
  public void createMeshExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Mesh mesh = Mesh.newBuilder().build();
      String meshId = "meshId-1077585944";
      client.createMeshAsync(parent, mesh, meshId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateMeshTest() throws Exception {
    Mesh expectedResponse =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Mesh mesh =
        Mesh.newBuilder()
            .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
            .setSelfLink("selfLink1191800166")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setInterceptionPort(537115930)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Mesh actualResponse = client.updateMeshAsync(mesh, updateMask).get();
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
  public void updateMeshExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Mesh mesh =
          Mesh.newBuilder()
              .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
              .setSelfLink("selfLink1191800166")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDescription("description-1724546052")
              .setInterceptionPort(537115930)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMeshAsync(mesh, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMeshTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");

    client.deleteMeshAsync(name).get();

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
  public void deleteMeshExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
      client.deleteMeshAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMeshTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMeshTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4667/locations/location-4667/meshes/meshe-4667";

    client.deleteMeshAsync(name).get();

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
  public void deleteMeshExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4667/locations/location-4667/meshes/meshe-4667";
      client.deleteMeshAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
