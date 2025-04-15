/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.parametermanager.v1;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

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
import com.google.cloud.parametermanager.v1.stub.HttpJsonParameterManagerStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.ResourcePolicyMember;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class ParameterManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ParameterManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonParameterManagerStub.getMethodDescriptors(),
            ParameterManagerSettings.getDefaultEndpoint());
    ParameterManagerSettings settings =
        ParameterManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ParameterManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ParameterManagerClient.create(settings);
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
  public void listParametersTest() throws Exception {
    Parameter responsesElement = Parameter.newBuilder().build();
    ListParametersResponse expectedResponse =
        ListParametersResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListParametersPagedResponse pagedListResponse = client.listParameters(parent);

    List<Parameter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParametersList().get(0), resources.get(0));

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
  public void listParametersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listParameters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParametersTest2() throws Exception {
    Parameter responsesElement = Parameter.newBuilder().build();
    ListParametersResponse expectedResponse =
        ListParametersResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListParametersPagedResponse pagedListResponse = client.listParameters(parent);

    List<Parameter> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParametersList().get(0), resources.get(0));

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
  public void listParametersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listParameters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    Parameter actualResponse = client.getParameter(name);
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
  public void getParameterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.getParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterTest2() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6934/locations/location-6934/parameters/parameter-6934";

    Parameter actualResponse = client.getParameter(name);
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
  public void getParameterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6934/locations/location-6934/parameters/parameter-6934";
      client.getParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Parameter parameter = Parameter.newBuilder().build();
    String parameterId = "parameterId1335916196";

    Parameter actualResponse = client.createParameter(parent, parameter, parameterId);
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
  public void createParameterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Parameter parameter = Parameter.newBuilder().build();
      String parameterId = "parameterId1335916196";
      client.createParameter(parent, parameter, parameterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterTest2() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Parameter parameter = Parameter.newBuilder().build();
    String parameterId = "parameterId1335916196";

    Parameter actualResponse = client.createParameter(parent, parameter, parameterId);
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
  public void createParameterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Parameter parameter = Parameter.newBuilder().build();
      String parameterId = "parameterId1335916196";
      client.createParameter(parent, parameter, parameterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateParameterTest() throws Exception {
    Parameter expectedResponse =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    Parameter parameter =
        Parameter.newBuilder()
            .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFormat(ParameterFormat.forNumber(0))
            .setPolicyMember(ResourcePolicyMember.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Parameter actualResponse = client.updateParameter(parameter, updateMask);
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
  public void updateParameterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Parameter parameter =
          Parameter.newBuilder()
              .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setFormat(ParameterFormat.forNumber(0))
              .setPolicyMember(ResourcePolicyMember.newBuilder().build())
              .setKmsKey("kmsKey-1127483058")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateParameter(parameter, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    client.deleteParameter(name);

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
  public void deleteParameterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.deleteParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6934/locations/location-6934/parameters/parameter-6934";

    client.deleteParameter(name);

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
  public void deleteParameterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6934/locations/location-6934/parameters/parameter-6934";
      client.deleteParameter(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParameterVersionsTest() throws Exception {
    ParameterVersion responsesElement = ParameterVersion.newBuilder().build();
    ListParameterVersionsResponse expectedResponse =
        ListParameterVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameterVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");

    ListParameterVersionsPagedResponse pagedListResponse = client.listParameterVersions(parent);

    List<ParameterVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParameterVersionsList().get(0), resources.get(0));

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
  public void listParameterVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      client.listParameterVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParameterVersionsTest2() throws Exception {
    ParameterVersion responsesElement = ParameterVersion.newBuilder().build();
    ListParameterVersionsResponse expectedResponse =
        ListParameterVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParameterVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5035/locations/location-5035/parameters/parameter-5035";

    ListParameterVersionsPagedResponse pagedListResponse = client.listParameterVersions(parent);

    List<ParameterVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParameterVersionsList().get(0), resources.get(0));

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
  public void listParameterVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5035/locations/location-5035/parameters/parameter-5035";
      client.listParameterVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockService.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    ParameterVersion actualResponse = client.getParameterVersion(name);
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
  public void getParameterVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.getParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParameterVersionTest2() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";

    ParameterVersion actualResponse = client.getParameterVersion(name);
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
  public void getParameterVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";
      client.getParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderParameterVersionTest() throws Exception {
    RenderParameterVersionResponse expectedResponse =
        RenderParameterVersionResponse.newBuilder()
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    RenderParameterVersionResponse actualResponse = client.renderParameterVersion(name);
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
  public void renderParameterVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.renderParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderParameterVersionTest2() throws Exception {
    RenderParameterVersionResponse expectedResponse =
        RenderParameterVersionResponse.newBuilder()
            .setParameterVersion(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setRenderedPayload(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";

    RenderParameterVersionResponse actualResponse = client.renderParameterVersion(name);
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
  public void renderParameterVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";
      client.renderParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockService.addResponse(expectedResponse);

    ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
    ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
    String parameterVersionId = "parameterVersionId2070530666";

    ParameterVersion actualResponse =
        client.createParameterVersion(parent, parameterVersion, parameterVersionId);
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
  public void createParameterVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
      ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
      String parameterVersionId = "parameterVersionId2070530666";
      client.createParameterVersion(parent, parameterVersion, parameterVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParameterVersionTest2() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5035/locations/location-5035/parameters/parameter-5035";
    ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
    String parameterVersionId = "parameterVersionId2070530666";

    ParameterVersion actualResponse =
        client.createParameterVersion(parent, parameterVersion, parameterVersionId);
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
  public void createParameterVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5035/locations/location-5035/parameters/parameter-5035";
      ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
      String parameterVersionId = "parameterVersionId2070530666";
      client.createParameterVersion(parent, parameterVersion, parameterVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateParameterVersionTest() throws Exception {
    ParameterVersion expectedResponse =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    mockService.addResponse(expectedResponse);

    ParameterVersion parameterVersion =
        ParameterVersion.newBuilder()
            .setName(
                ParameterVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisabled(true)
            .setPayload(ParameterVersionPayload.newBuilder().build())
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ParameterVersion actualResponse = client.updateParameterVersion(parameterVersion, updateMask);
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
  public void updateParameterVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterVersion parameterVersion =
          ParameterVersion.newBuilder()
              .setName(
                  ParameterVersionName.of(
                          "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDisabled(true)
              .setPayload(ParameterVersionPayload.newBuilder().build())
              .setKmsKeyVersion("kmsKeyVersion2084784042")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateParameterVersion(parameterVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ParameterVersionName name =
        ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");

    client.deleteParameterVersion(name);

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
  public void deleteParameterVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParameterVersionName name =
          ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
      client.deleteParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteParameterVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";

    client.deleteParameterVersion(name);

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
  public void deleteParameterVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3451/locations/location-3451/parameters/parameter-3451/versions/version-3451";
      client.deleteParameterVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
}
