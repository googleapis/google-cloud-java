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

import static com.google.ads.admanager.v1.ViewabilityProviderServiceClient.ListViewabilityProvidersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonViewabilityProviderServiceStub;
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
import com.google.protobuf.FieldMask;
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
public class ViewabilityProviderServiceClientTest {
  private static MockHttpService mockService;
  private static ViewabilityProviderServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonViewabilityProviderServiceStub.getMethodDescriptors(),
            ViewabilityProviderServiceSettings.getDefaultEndpoint());
    ViewabilityProviderServiceSettings settings =
        ViewabilityProviderServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ViewabilityProviderServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ViewabilityProviderServiceClient.create(settings);
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
  public void getViewabilityProviderTest() throws Exception {
    ViewabilityProvider expectedResponse =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ViewabilityProviderName name =
        ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]");

    ViewabilityProvider actualResponse = client.getViewabilityProvider(name);
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
  public void getViewabilityProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ViewabilityProviderName name =
          ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]");
      client.getViewabilityProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewabilityProviderTest2() throws Exception {
    ViewabilityProvider expectedResponse =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-8380/viewabilityProviders/viewabilityProvider-8380";

    ViewabilityProvider actualResponse = client.getViewabilityProvider(name);
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
  public void getViewabilityProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-8380/viewabilityProviders/viewabilityProvider-8380";
      client.getViewabilityProvider(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewabilityProvidersTest() throws Exception {
    ViewabilityProvider responsesElement = ViewabilityProvider.newBuilder().build();
    ListViewabilityProvidersResponse expectedResponse =
        ListViewabilityProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllViewabilityProviders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListViewabilityProvidersPagedResponse pagedListResponse =
        client.listViewabilityProviders(parent);

    List<ViewabilityProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewabilityProvidersList().get(0), resources.get(0));

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
  public void listViewabilityProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listViewabilityProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewabilityProvidersTest2() throws Exception {
    ViewabilityProvider responsesElement = ViewabilityProvider.newBuilder().build();
    ListViewabilityProvidersResponse expectedResponse =
        ListViewabilityProvidersResponse.newBuilder()
            .setNextPageToken("")
            .addAllViewabilityProviders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListViewabilityProvidersPagedResponse pagedListResponse =
        client.listViewabilityProviders(parent);

    List<ViewabilityProvider> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewabilityProvidersList().get(0), resources.get(0));

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
  public void listViewabilityProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listViewabilityProviders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createViewabilityProviderTest() throws Exception {
    ViewabilityProvider expectedResponse =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();

    ViewabilityProvider actualResponse =
        client.createViewabilityProvider(parent, viewabilityProvider);
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
  public void createViewabilityProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();
      client.createViewabilityProvider(parent, viewabilityProvider);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createViewabilityProviderTest2() throws Exception {
    ViewabilityProvider expectedResponse =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();

    ViewabilityProvider actualResponse =
        client.createViewabilityProvider(parent, viewabilityProvider);
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
  public void createViewabilityProviderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      ViewabilityProvider viewabilityProvider = ViewabilityProvider.newBuilder().build();
      client.createViewabilityProvider(parent, viewabilityProvider);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateViewabilityProvidersTest() throws Exception {
    BatchCreateViewabilityProvidersResponse expectedResponse =
        BatchCreateViewabilityProvidersResponse.newBuilder()
            .addAllViewabilityProviders(new ArrayList<ViewabilityProvider>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateViewabilityProviderRequest> requests = new ArrayList<>();

    BatchCreateViewabilityProvidersResponse actualResponse =
        client.batchCreateViewabilityProviders(parent, requests);
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
  public void batchCreateViewabilityProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateViewabilityProviderRequest> requests = new ArrayList<>();
      client.batchCreateViewabilityProviders(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateViewabilityProvidersTest2() throws Exception {
    BatchCreateViewabilityProvidersResponse expectedResponse =
        BatchCreateViewabilityProvidersResponse.newBuilder()
            .addAllViewabilityProviders(new ArrayList<ViewabilityProvider>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateViewabilityProviderRequest> requests = new ArrayList<>();

    BatchCreateViewabilityProvidersResponse actualResponse =
        client.batchCreateViewabilityProviders(parent, requests);
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
  public void batchCreateViewabilityProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateViewabilityProviderRequest> requests = new ArrayList<>();
      client.batchCreateViewabilityProviders(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateViewabilityProviderTest() throws Exception {
    ViewabilityProvider expectedResponse =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ViewabilityProvider viewabilityProvider =
        ViewabilityProvider.newBuilder()
            .setName(
                ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
            .setDisplayName("displayName1714148973")
            .setVendorKey("vendorKey-1085989897")
            .setVerificationScriptUrl("verificationScriptUrl-1396589367")
            .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
            .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
            .setAddress("address-1147692044")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setPhone("phone106642798")
            .setExternalId("externalId-1699764666")
            .setComment("comment950398559")
            .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .addAllAppliedTeams(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ViewabilityProvider actualResponse =
        client.updateViewabilityProvider(viewabilityProvider, updateMask);
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
  public void updateViewabilityProviderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ViewabilityProvider viewabilityProvider =
          ViewabilityProvider.newBuilder()
              .setName(
                  ViewabilityProviderName.of("[NETWORK_CODE]", "[VIEWABILITY_PROVIDER]").toString())
              .setDisplayName("displayName1714148973")
              .setVendorKey("vendorKey-1085989897")
              .setVerificationScriptUrl("verificationScriptUrl-1396589367")
              .setVerificationScriptUrlParameters("verificationScriptUrlParameters-595545197")
              .setRejectionTrackerUrl("rejectionTrackerUrl-2131018752")
              .setAddress("address-1147692044")
              .setEmail("email96619420")
              .setFax("fax101149")
              .setPhone("phone106642798")
              .setExternalId("externalId-1699764666")
              .setComment("comment950398559")
              .setPrimaryContact(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
              .addAllAppliedTeams(new ArrayList<String>())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateViewabilityProvider(viewabilityProvider, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateViewabilityProvidersTest() throws Exception {
    BatchUpdateViewabilityProvidersResponse expectedResponse =
        BatchUpdateViewabilityProvidersResponse.newBuilder()
            .addAllViewabilityProviders(new ArrayList<ViewabilityProvider>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();

    BatchUpdateViewabilityProvidersResponse actualResponse =
        client.batchUpdateViewabilityProviders(parent, requests);
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
  public void batchUpdateViewabilityProvidersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();
      client.batchUpdateViewabilityProviders(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateViewabilityProvidersTest2() throws Exception {
    BatchUpdateViewabilityProvidersResponse expectedResponse =
        BatchUpdateViewabilityProvidersResponse.newBuilder()
            .addAllViewabilityProviders(new ArrayList<ViewabilityProvider>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();

    BatchUpdateViewabilityProvidersResponse actualResponse =
        client.batchUpdateViewabilityProviders(parent, requests);
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
  public void batchUpdateViewabilityProvidersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateViewabilityProviderRequest> requests = new ArrayList<>();
      client.batchUpdateViewabilityProviders(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
