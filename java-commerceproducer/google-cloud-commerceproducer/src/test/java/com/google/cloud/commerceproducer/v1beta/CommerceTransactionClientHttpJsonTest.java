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

package com.google.cloud.commerceproducer.v1beta;

import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListLocationsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOfferDocumentsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOffersPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListServicesPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkuGroupsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkusPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListStandardOffersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.commerceproducer.v1beta.stub.HttpJsonCommerceTransactionStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.DateTime;
import java.io.IOException;
import java.util.ArrayList;
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
public class CommerceTransactionClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CommerceTransactionClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCommerceTransactionStub.getMethodDescriptors(),
            CommerceTransactionSettings.getDefaultEndpoint());
    CommerceTransactionSettings settings =
        CommerceTransactionSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CommerceTransactionSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CommerceTransactionClient.create(settings);
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
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

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
  public void listServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest2() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

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
  public void listServicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setTitle("title110371416")
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    Service actualResponse = client.getService(name);
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
  public void getServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setTitle("title110371416")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7842/locations/location-7842/services/service-7842";

    Service actualResponse = client.getService(name);
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
  public void getServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7842/locations/location-7842/services/service-7842";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateOffersTest() throws Exception {
    PrivateOffer responsesElement = PrivateOffer.newBuilder().build();
    ListPrivateOffersResponse expectedResponse =
        ListPrivateOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateOffers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateOffersPagedResponse pagedListResponse = client.listPrivateOffers(parent);

    List<PrivateOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateOffersList().get(0), resources.get(0));

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
  public void listPrivateOffersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateOffers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateOffersTest2() throws Exception {
    PrivateOffer responsesElement = PrivateOffer.newBuilder().build();
    ListPrivateOffersResponse expectedResponse =
        ListPrivateOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateOffers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPrivateOffersPagedResponse pagedListResponse = client.listPrivateOffers(parent);

    List<PrivateOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateOffersList().get(0), resources.get(0));

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
  public void listPrivateOffersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPrivateOffers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateOfferTest() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");

    PrivateOffer actualResponse = client.getPrivateOffer(name);
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
  public void getPrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
      client.getPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateOfferTest2() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";

    PrivateOffer actualResponse = client.getPrivateOffer(name);
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
  public void getPrivateOfferExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";
      client.getPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateOfferTest() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreatePrivateOfferRequest request =
        CreatePrivateOfferRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setPrivateOffer(PrivateOffer.newBuilder().build())
            .build();

    PrivateOffer actualResponse = client.createPrivateOffer(request);
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
  public void createPrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreatePrivateOfferRequest request =
          CreatePrivateOfferRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPrivateOffer(PrivateOffer.newBuilder().build())
              .build();
      client.createPrivateOffer(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrivateOfferTest() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOffer privateOffer =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateOffer actualResponse = client.updatePrivateOffer(privateOffer, updateMask);
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
  public void updatePrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOffer privateOffer =
          PrivateOffer.newBuilder()
              .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
              .setPublishRequirementGoogleReview(
                  PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setPublishTime(Timestamp.newBuilder().build())
              .setAcceptTime(Timestamp.newBuilder().build())
              .setCancelTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setCancellationNote("cancellationNote806581141")
              .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
              .setInternalNote("internalNote-80133041")
              .setTitle("title110371416")
              .setCustomerNote("customerNote900170992")
              .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
              .setCustomer(PrivateOffer.Customer.newBuilder().build())
              .setAcceptDeadlineTime(DateTime.newBuilder().build())
              .setTerm(PrivateOffer.Term.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateOffer(privateOffer, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishPrivateOfferTest() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");

    PrivateOffer actualResponse = client.publishPrivateOffer(name);
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
  public void publishPrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
      client.publishPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishPrivateOfferTest2() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";

    PrivateOffer actualResponse = client.publishPrivateOffer(name);
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
  public void publishPrivateOfferExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";
      client.publishPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPrivateOfferTest() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");

    PrivateOffer actualResponse = client.cancelPrivateOffer(name);
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
  public void cancelPrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
      client.cancelPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelPrivateOfferTest2() throws Exception {
    PrivateOffer expectedResponse =
        PrivateOffer.newBuilder()
            .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPublishRequirementGoogleReview(
                PrivateOffer.PublishRequirementGoogleReview.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublishTime(Timestamp.newBuilder().build())
            .setAcceptTime(Timestamp.newBuilder().build())
            .setCancelTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setCancellationNote("cancellationNote806581141")
            .setResellerContact(PrivateOffer.ResellerContact.newBuilder().build())
            .setInternalNote("internalNote-80133041")
            .setTitle("title110371416")
            .setCustomerNote("customerNote900170992")
            .setPartnerContact(PrivateOffer.PartnerContact.newBuilder().build())
            .setCustomer(PrivateOffer.Customer.newBuilder().build())
            .setAcceptDeadlineTime(DateTime.newBuilder().build())
            .setTerm(PrivateOffer.Term.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";

    PrivateOffer actualResponse = client.cancelPrivateOffer(name);
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
  public void cancelPrivateOfferExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";
      client.cancelPrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateOfferTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");

    client.deletePrivateOffer(name);

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
  public void deletePrivateOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
      client.deletePrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateOfferTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";

    client.deletePrivateOffer(name);

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
  public void deletePrivateOfferExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1888/locations/location-1888/privateOffers/privateOffer-1888";
      client.deletePrivateOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateOfferDocumentsTest() throws Exception {
    PrivateOfferDocument responsesElement = PrivateOfferDocument.newBuilder().build();
    ListPrivateOfferDocumentsResponse expectedResponse =
        ListPrivateOfferDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateOfferDocuments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferName parent = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");

    ListPrivateOfferDocumentsPagedResponse pagedListResponse =
        client.listPrivateOfferDocuments(parent);

    List<PrivateOfferDocument> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateOfferDocumentsList().get(0), resources.get(0));

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
  public void listPrivateOfferDocumentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferName parent = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
      client.listPrivateOfferDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateOfferDocumentsTest2() throws Exception {
    PrivateOfferDocument responsesElement = PrivateOfferDocument.newBuilder().build();
    ListPrivateOfferDocumentsResponse expectedResponse =
        ListPrivateOfferDocumentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateOfferDocuments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4017/locations/location-4017/privateOffers/privateOffer-4017";

    ListPrivateOfferDocumentsPagedResponse pagedListResponse =
        client.listPrivateOfferDocuments(parent);

    List<PrivateOfferDocument> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateOfferDocumentsList().get(0), resources.get(0));

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
  public void listPrivateOfferDocumentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4017/locations/location-4017/privateOffers/privateOffer-4017";
      client.listPrivateOfferDocuments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateOfferDocumentTest() throws Exception {
    PrivateOfferDocument expectedResponse =
        PrivateOfferDocument.newBuilder()
            .setName(
                PrivateOfferDocumentName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferDocumentName name =
        PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");

    PrivateOfferDocument actualResponse = client.getPrivateOfferDocument(name);
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
  public void getPrivateOfferDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferDocumentName name =
          PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");
      client.getPrivateOfferDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateOfferDocumentTest2() throws Exception {
    PrivateOfferDocument expectedResponse =
        PrivateOfferDocument.newBuilder()
            .setName(
                PrivateOfferDocumentName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1580/locations/location-1580/privateOffers/privateOffer-1580/documents/document-1580";

    PrivateOfferDocument actualResponse = client.getPrivateOfferDocument(name);
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
  public void getPrivateOfferDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1580/locations/location-1580/privateOffers/privateOffer-1580/documents/document-1580";
      client.getPrivateOfferDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateOfferDocumentTest() throws Exception {
    PrivateOfferDocument expectedResponse =
        PrivateOfferDocument.newBuilder()
            .setName(
                PrivateOfferDocumentName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .build();
    mockService.addResponse(expectedResponse);

    CreatePrivateOfferDocumentRequest request =
        CreatePrivateOfferDocumentRequest.newBuilder()
            .setParent(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
            .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
            .build();

    PrivateOfferDocument actualResponse = client.createPrivateOfferDocument(request);
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
  public void createPrivateOfferDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreatePrivateOfferDocumentRequest request =
          CreatePrivateOfferDocumentRequest.newBuilder()
              .setParent(
                  PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
              .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
              .build();
      client.createPrivateOfferDocument(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrivateOfferDocumentTest() throws Exception {
    PrivateOfferDocument expectedResponse =
        PrivateOfferDocument.newBuilder()
            .setName(
                PrivateOfferDocumentName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .build();
    mockService.addResponse(expectedResponse);

    PrivateOfferDocument privateOfferDocument =
        PrivateOfferDocument.newBuilder()
            .setName(
                PrivateOfferDocumentName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateOfferDocument actualResponse =
        client.updatePrivateOfferDocument(privateOfferDocument, updateMask);
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
  public void updatePrivateOfferDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferDocument privateOfferDocument =
          PrivateOfferDocument.newBuilder()
              .setName(
                  PrivateOfferDocumentName.of(
                          "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setMimeType("mimeType-1392120434")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateOfferDocument(privateOfferDocument, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateOfferDocumentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PrivateOfferDocumentName name =
        PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");

    client.deletePrivateOfferDocument(name);

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
  public void deletePrivateOfferDocumentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateOfferDocumentName name =
          PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");
      client.deletePrivateOfferDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateOfferDocumentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1580/locations/location-1580/privateOffers/privateOffer-1580/documents/document-1580";

    client.deletePrivateOfferDocument(name);

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
  public void deletePrivateOfferDocumentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1580/locations/location-1580/privateOffers/privateOffer-1580/documents/document-1580";
      client.deletePrivateOfferDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStandardOffersTest() throws Exception {
    StandardOffer responsesElement = StandardOffer.newBuilder().build();
    ListStandardOffersResponse expectedResponse =
        ListStandardOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllStandardOffers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    ListStandardOffersPagedResponse pagedListResponse = client.listStandardOffers(parent);

    List<StandardOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStandardOffersList().get(0), resources.get(0));

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
  public void listStandardOffersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.listStandardOffers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStandardOffersTest2() throws Exception {
    StandardOffer responsesElement = StandardOffer.newBuilder().build();
    ListStandardOffersResponse expectedResponse =
        ListStandardOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllStandardOffers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4913/locations/location-4913/services/service-4913";

    ListStandardOffersPagedResponse pagedListResponse = client.listStandardOffers(parent);

    List<StandardOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStandardOffersList().get(0), resources.get(0));

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
  public void listStandardOffersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4913/locations/location-4913/services/service-4913";
      client.listStandardOffers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStandardOfferTest() throws Exception {
    StandardOffer expectedResponse =
        StandardOffer.newBuilder()
            .setName(
                StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setServiceLevel("serviceLevel342085071")
            .setServiceLevelTitle("serviceLevelTitle1761652169")
            .setPriceModel(StandardOffer.PriceModel.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    StandardOfferName name =
        StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]");

    StandardOffer actualResponse = client.getStandardOffer(name);
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
  public void getStandardOfferExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StandardOfferName name =
          StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]");
      client.getStandardOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStandardOfferTest2() throws Exception {
    StandardOffer expectedResponse =
        StandardOffer.newBuilder()
            .setName(
                StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEffectiveTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setServiceLevel("serviceLevel342085071")
            .setServiceLevelTitle("serviceLevelTitle1761652169")
            .setPriceModel(StandardOffer.PriceModel.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3360/locations/location-3360/services/service-3360/standardOffers/standardOffer-3360";

    StandardOffer actualResponse = client.getStandardOffer(name);
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
  public void getStandardOfferExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3360/locations/location-3360/services/service-3360/standardOffers/standardOffer-3360";
      client.getStandardOffer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuTest() throws Exception {
    Sku expectedResponse =
        Sku.newBuilder()
            .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]").toString())
            .setDescription("description-1724546052")
            .addAllSkuPriceTimeline(new ArrayList<Sku.SkuPrice>())
            .build();
    mockService.addResponse(expectedResponse);

    SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]");

    Sku actualResponse = client.getSku(name);
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
  public void getSkuExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]");
      client.getSku(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuTest2() throws Exception {
    Sku expectedResponse =
        Sku.newBuilder()
            .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]").toString())
            .setDescription("description-1724546052")
            .addAllSkuPriceTimeline(new ArrayList<Sku.SkuPrice>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7086/locations/location-7086/services/service-7086/skus/sku-7086";

    Sku actualResponse = client.getSku(name);
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
  public void getSkuExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7086/locations/location-7086/services/service-7086/skus/sku-7086";
      client.getSku(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

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
  public void listSkusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkusTest2() throws Exception {
    Sku responsesElement = Sku.newBuilder().build();
    ListSkusResponse expectedResponse =
        ListSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkus(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4913/locations/location-4913/services/service-4913";

    ListSkusPagedResponse pagedListResponse = client.listSkus(parent);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

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
  public void listSkusExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4913/locations/location-4913/services/service-4913";
      client.listSkus(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuGroupTest() throws Exception {
    SkuGroup expectedResponse =
        SkuGroup.newBuilder()
            .setName(SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]").toString())
            .addAllSkus(new ArrayList<String>())
            .addAllCloudBillingSkus(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    SkuGroupName name = SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]");

    SkuGroup actualResponse = client.getSkuGroup(name);
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
  public void getSkuGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkuGroupName name = SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]");
      client.getSkuGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkuGroupTest2() throws Exception {
    SkuGroup expectedResponse =
        SkuGroup.newBuilder()
            .setName(SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]").toString())
            .addAllSkus(new ArrayList<String>())
            .addAllCloudBillingSkus(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1063/locations/location-1063/skuGroups/skuGroup-1063";

    SkuGroup actualResponse = client.getSkuGroup(name);
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
  public void getSkuGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1063/locations/location-1063/skuGroups/skuGroup-1063";
      client.getSkuGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkuGroupsTest() throws Exception {
    SkuGroup responsesElement = SkuGroup.newBuilder().build();
    ListSkuGroupsResponse expectedResponse =
        ListSkuGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkuGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSkuGroupsPagedResponse pagedListResponse = client.listSkuGroups(parent);

    List<SkuGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkuGroupsList().get(0), resources.get(0));

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
  public void listSkuGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSkuGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkuGroupsTest2() throws Exception {
    SkuGroup responsesElement = SkuGroup.newBuilder().build();
    ListSkuGroupsResponse expectedResponse =
        ListSkuGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkuGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSkuGroupsPagedResponse pagedListResponse = client.listSkuGroups(parent);

    List<SkuGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkuGroupsList().get(0), resources.get(0));

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
  public void listSkuGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSkuGroups(parent);
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
