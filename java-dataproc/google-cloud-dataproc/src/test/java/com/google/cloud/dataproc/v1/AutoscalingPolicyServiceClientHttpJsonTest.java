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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonAutoscalingPolicyServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
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
public class AutoscalingPolicyServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AutoscalingPolicyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAutoscalingPolicyServiceStub.getMethodDescriptors(),
            AutoscalingPolicyServiceSettings.getDefaultEndpoint());
    AutoscalingPolicyServiceSettings settings =
        AutoscalingPolicyServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AutoscalingPolicyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutoscalingPolicyServiceClient.create(settings);
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
  public void createAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
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
  public void createAutoscalingPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutoscalingPolicyTest2() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
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
  public void createAutoscalingPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutoscalingPolicyTest3() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
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
  public void createAutoscalingPolicyExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    AutoscalingPolicy policy =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();

    AutoscalingPolicy actualResponse = client.updateAutoscalingPolicy(policy);
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
  public void updateAutoscalingPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutoscalingPolicy policy =
          AutoscalingPolicy.newBuilder()
              .setId("id3355")
              .setName(
                  AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                          "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
              .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      client.updateAutoscalingPolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");

    AutoscalingPolicy actualResponse = client.getAutoscalingPolicy(name);
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
  public void getAutoscalingPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
      client.getAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutoscalingPolicyTest2() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4686/locations/location-4686/autoscalingPolicies/autoscalingPolicie-4686";

    AutoscalingPolicy actualResponse = client.getAutoscalingPolicy(name);
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
  public void getAutoscalingPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4686/locations/location-4686/autoscalingPolicies/autoscalingPolicie-4686";
      client.getAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void listAutoscalingPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest2() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void listAutoscalingPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest3() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

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
  public void listAutoscalingPoliciesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAutoscalingPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");

    client.deleteAutoscalingPolicy(name);

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
  public void deleteAutoscalingPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
      client.deleteAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAutoscalingPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4686/locations/location-4686/autoscalingPolicies/autoscalingPolicie-4686";

    client.deleteAutoscalingPolicy(name);

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
  public void deleteAutoscalingPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4686/locations/location-4686/autoscalingPolicies/autoscalingPolicie-4686";
      client.deleteAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
