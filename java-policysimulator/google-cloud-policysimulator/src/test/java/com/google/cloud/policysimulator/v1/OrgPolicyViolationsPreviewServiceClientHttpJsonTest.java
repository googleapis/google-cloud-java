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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.policysimulator.v1.stub.HttpJsonOrgPolicyViolationsPreviewServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class OrgPolicyViolationsPreviewServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OrgPolicyViolationsPreviewServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOrgPolicyViolationsPreviewServiceStub.getMethodDescriptors(),
            OrgPolicyViolationsPreviewServiceSettings.getDefaultEndpoint());
    OrgPolicyViolationsPreviewServiceSettings settings =
        OrgPolicyViolationsPreviewServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OrgPolicyViolationsPreviewServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrgPolicyViolationsPreviewServiceClient.create(settings);
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
  public void listOrgPolicyViolationsPreviewsTest() throws Exception {
    OrgPolicyViolationsPreview responsesElement = OrgPolicyViolationsPreview.newBuilder().build();
    ListOrgPolicyViolationsPreviewsResponse expectedResponse =
        ListOrgPolicyViolationsPreviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolationsPreviews(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListOrgPolicyViolationsPreviewsPagedResponse pagedListResponse =
        client.listOrgPolicyViolationsPreviews(parent);

    List<OrgPolicyViolationsPreview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOrgPolicyViolationsPreviewsList().get(0), resources.get(0));

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
  public void listOrgPolicyViolationsPreviewsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listOrgPolicyViolationsPreviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrgPolicyViolationsPreviewsTest2() throws Exception {
    OrgPolicyViolationsPreview responsesElement = OrgPolicyViolationsPreview.newBuilder().build();
    ListOrgPolicyViolationsPreviewsResponse expectedResponse =
        ListOrgPolicyViolationsPreviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolationsPreviews(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListOrgPolicyViolationsPreviewsPagedResponse pagedListResponse =
        client.listOrgPolicyViolationsPreviews(parent);

    List<OrgPolicyViolationsPreview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOrgPolicyViolationsPreviewsList().get(0), resources.get(0));

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
  public void listOrgPolicyViolationsPreviewsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listOrgPolicyViolationsPreviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrgPolicyViolationsPreviewTest() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrgPolicyViolationsPreviewName name =
        OrgPolicyViolationsPreviewName.of(
            "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");

    OrgPolicyViolationsPreview actualResponse = client.getOrgPolicyViolationsPreview(name);
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
  public void getOrgPolicyViolationsPreviewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrgPolicyViolationsPreviewName name =
          OrgPolicyViolationsPreviewName.of(
              "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
      client.getOrgPolicyViolationsPreview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrgPolicyViolationsPreviewTest2() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-5013/locations/location-5013/orgPolicyViolationsPreviews/orgPolicyViolationsPreview-5013";

    OrgPolicyViolationsPreview actualResponse = client.getOrgPolicyViolationsPreview(name);
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
  public void getOrgPolicyViolationsPreviewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-5013/locations/location-5013/orgPolicyViolationsPreviews/orgPolicyViolationsPreview-5013";
      client.getOrgPolicyViolationsPreview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOrgPolicyViolationsPreviewTest() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrgPolicyViolationsPreviewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    OrgPolicyViolationsPreview orgPolicyViolationsPreview =
        OrgPolicyViolationsPreview.newBuilder().build();
    String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";

    OrgPolicyViolationsPreview actualResponse =
        client
            .createOrgPolicyViolationsPreviewAsync(
                parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
            .get();
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
  public void createOrgPolicyViolationsPreviewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      OrgPolicyViolationsPreview orgPolicyViolationsPreview =
          OrgPolicyViolationsPreview.newBuilder().build();
      String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
      client
          .createOrgPolicyViolationsPreviewAsync(
              parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createOrgPolicyViolationsPreviewTest2() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrgPolicyViolationsPreviewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    OrgPolicyViolationsPreview orgPolicyViolationsPreview =
        OrgPolicyViolationsPreview.newBuilder().build();
    String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";

    OrgPolicyViolationsPreview actualResponse =
        client
            .createOrgPolicyViolationsPreviewAsync(
                parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
            .get();
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
  public void createOrgPolicyViolationsPreviewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      OrgPolicyViolationsPreview orgPolicyViolationsPreview =
          OrgPolicyViolationsPreview.newBuilder().build();
      String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
      client
          .createOrgPolicyViolationsPreviewAsync(
              parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listOrgPolicyViolationsTest() throws Exception {
    OrgPolicyViolation responsesElement = OrgPolicyViolation.newBuilder().build();
    ListOrgPolicyViolationsResponse expectedResponse =
        ListOrgPolicyViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrgPolicyViolationsPreviewName parent =
        OrgPolicyViolationsPreviewName.of(
            "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");

    ListOrgPolicyViolationsPagedResponse pagedListResponse = client.listOrgPolicyViolations(parent);

    List<OrgPolicyViolation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrgPolicyViolationsList().get(0), resources.get(0));

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
  public void listOrgPolicyViolationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrgPolicyViolationsPreviewName parent =
          OrgPolicyViolationsPreviewName.of(
              "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
      client.listOrgPolicyViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrgPolicyViolationsTest2() throws Exception {
    OrgPolicyViolation responsesElement = OrgPolicyViolation.newBuilder().build();
    ListOrgPolicyViolationsResponse expectedResponse =
        ListOrgPolicyViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "organizations/organization-1866/locations/location-1866/orgPolicyViolationsPreviews/orgPolicyViolationsPreview-1866";

    ListOrgPolicyViolationsPagedResponse pagedListResponse = client.listOrgPolicyViolations(parent);

    List<OrgPolicyViolation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrgPolicyViolationsList().get(0), resources.get(0));

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
  public void listOrgPolicyViolationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "organizations/organization-1866/locations/location-1866/orgPolicyViolationsPreviews/orgPolicyViolationsPreview-1866";
      client.listOrgPolicyViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
