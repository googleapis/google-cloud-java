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

package com.google.cloud.channel.v1;

import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerLinksPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListEntitlementsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListProductsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSubscribersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableSkusPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.PostalAddress;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CloudChannelServiceClientTest {
  private static MockCloudChannelService mockCloudChannelService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudChannelServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudChannelService = new MockCloudChannelService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudChannelService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    CloudChannelServiceSettings settings =
        CloudChannelServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudChannelServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCustomersTest() throws Exception {
    Customer responsesElement = Customer.newBuilder().build();
    ListCustomersResponse expectedResponse =
        ListCustomersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomers(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListCustomersRequest request =
        ListCustomersRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListCustomersPagedResponse pagedListResponse = client.listCustomers(request);

    List<Customer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomersRequest actualRequest = ((ListCustomersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListCustomersRequest request =
          ListCustomersRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listCustomers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");

    Customer actualResponse = client.getCustomer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRequest actualRequest = ((GetCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
      client.getCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerTest2() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    Customer actualResponse = client.getCustomer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRequest actualRequest = ((GetCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkCloudIdentityAccountsExistTest() throws Exception {
    CheckCloudIdentityAccountsExistResponse expectedResponse =
        CheckCloudIdentityAccountsExistResponse.newBuilder()
            .addAllCloudIdentityAccounts(new ArrayList<CloudIdentityCustomerAccount>())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CheckCloudIdentityAccountsExistRequest request =
        CheckCloudIdentityAccountsExistRequest.newBuilder()
            .setParent("parent-995424086")
            .setDomain("domain-1326197564")
            .build();

    CheckCloudIdentityAccountsExistResponse actualResponse =
        client.checkCloudIdentityAccountsExist(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckCloudIdentityAccountsExistRequest actualRequest =
        ((CheckCloudIdentityAccountsExistRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDomain(), actualRequest.getDomain());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkCloudIdentityAccountsExistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CheckCloudIdentityAccountsExistRequest request =
          CheckCloudIdentityAccountsExistRequest.newBuilder()
              .setParent("parent-995424086")
              .setDomain("domain-1326197564")
              .build();
      client.checkCloudIdentityAccountsExist(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomerTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CreateCustomerRequest request =
        CreateCustomerRequest.newBuilder()
            .setParent("parent-995424086")
            .setCustomer(Customer.newBuilder().build())
            .build();

    Customer actualResponse = client.createCustomer(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomerRequest actualRequest = ((CreateCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CreateCustomerRequest request =
          CreateCustomerRequest.newBuilder()
              .setParent("parent-995424086")
              .setCustomer(Customer.newBuilder().build())
              .build();
      client.createCustomer(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomerTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    UpdateCustomerRequest request =
        UpdateCustomerRequest.newBuilder()
            .setCustomer(Customer.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Customer actualResponse = client.updateCustomer(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomerRequest actualRequest = ((UpdateCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      UpdateCustomerRequest request =
          UpdateCustomerRequest.newBuilder()
              .setCustomer(Customer.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateCustomer(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");

    client.deleteCustomer(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomerRequest actualRequest = ((DeleteCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
      client.deleteCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomerTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCustomer(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomerRequest actualRequest = ((DeleteCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importCustomerTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ImportCustomerRequest request =
        ImportCustomerRequest.newBuilder()
            .setParent("parent-995424086")
            .setAuthToken("authToken1450587441")
            .setOverwriteIfExists(true)
            .setChannelPartnerId("channelPartnerId-170366400")
            .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .build();

    Customer actualResponse = client.importCustomer(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportCustomerRequest actualRequest = ((ImportCustomerRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDomain(), actualRequest.getDomain());
    Assert.assertEquals(request.getCloudIdentityId(), actualRequest.getCloudIdentityId());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAuthToken(), actualRequest.getAuthToken());
    Assert.assertEquals(request.getOverwriteIfExists(), actualRequest.getOverwriteIfExists());
    Assert.assertEquals(request.getChannelPartnerId(), actualRequest.getChannelPartnerId());
    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importCustomerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ImportCustomerRequest request =
          ImportCustomerRequest.newBuilder()
              .setParent("parent-995424086")
              .setAuthToken("authToken1450587441")
              .setOverwriteIfExists(true)
              .setChannelPartnerId("channelPartnerId-170366400")
              .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .build();
      client.importCustomer(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionCloudIdentityTest() throws Exception {
    Customer expectedResponse =
        Customer.newBuilder()
            .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setOrgDisplayName("orgDisplayName127031529")
            .setOrgPostalAddress(PostalAddress.newBuilder().build())
            .setPrimaryContactInfo(ContactInfo.newBuilder().build())
            .setAlternateEmail("alternateEmail-232564926")
            .setDomain("domain-1326197564")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCloudIdentityId("cloudIdentityId941784718")
            .setLanguageCode("languageCode-2092349083")
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setChannelPartnerId("channelPartnerId-170366400")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("provisionCloudIdentityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    ProvisionCloudIdentityRequest request =
        ProvisionCloudIdentityRequest.newBuilder()
            .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .setUser(AdminUser.newBuilder().build())
            .setValidateOnly(true)
            .build();

    Customer actualResponse = client.provisionCloudIdentityAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvisionCloudIdentityRequest actualRequest =
        ((ProvisionCloudIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertEquals(request.getCloudIdentityInfo(), actualRequest.getCloudIdentityInfo());
    Assert.assertEquals(request.getUser(), actualRequest.getUser());
    Assert.assertEquals(request.getValidateOnly(), actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provisionCloudIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ProvisionCloudIdentityRequest request =
          ProvisionCloudIdentityRequest.newBuilder()
              .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
              .setUser(AdminUser.newBuilder().build())
              .setValidateOnly(true)
              .build();
      client.provisionCloudIdentityAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder()
            .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(request);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListEntitlementsRequest request =
          ListEntitlementsRequest.newBuilder()
              .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listEntitlements(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferableSkusTest() throws Exception {
    TransferableSku responsesElement = TransferableSku.newBuilder().build();
    ListTransferableSkusResponse expectedResponse =
        ListTransferableSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferableSkus(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListTransferableSkusRequest request =
        ListTransferableSkusRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setAuthToken("authToken1450587441")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListTransferableSkusPagedResponse pagedListResponse = client.listTransferableSkus(request);

    List<TransferableSku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferableSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferableSkusRequest actualRequest =
        ((ListTransferableSkusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCloudIdentityId(), actualRequest.getCloudIdentityId());
    Assert.assertEquals(request.getCustomerName(), actualRequest.getCustomerName());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getAuthToken(), actualRequest.getAuthToken());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferableSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListTransferableSkusRequest request =
          ListTransferableSkusRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setAuthToken("authToken1450587441")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listTransferableSkus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTransferableOffersTest() throws Exception {
    TransferableOffer responsesElement = TransferableOffer.newBuilder().build();
    ListTransferableOffersResponse expectedResponse =
        ListTransferableOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllTransferableOffers(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListTransferableOffersRequest request =
        ListTransferableOffersRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setSku("sku113949")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListTransferableOffersPagedResponse pagedListResponse = client.listTransferableOffers(request);

    List<TransferableOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTransferableOffersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTransferableOffersRequest actualRequest =
        ((ListTransferableOffersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCloudIdentityId(), actualRequest.getCloudIdentityId());
    Assert.assertEquals(request.getCustomerName(), actualRequest.getCustomerName());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getSku(), actualRequest.getSku());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTransferableOffersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListTransferableOffersRequest request =
          ListTransferableOffersRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setSku("sku113949")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listTransferableOffers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    GetEntitlementRequest request =
        GetEntitlementRequest.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .build();

    Entitlement actualResponse = client.getEntitlement(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntitlementRequest actualRequest = ((GetEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      GetEntitlementRequest request =
          GetEntitlementRequest.newBuilder()
              .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
              .build();
      client.getEntitlement(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    CreateEntitlementRequest request =
        CreateEntitlementRequest.newBuilder()
            .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setEntitlement(Entitlement.newBuilder().build())
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.createEntitlementAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntitlementRequest actualRequest = ((CreateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEntitlement(), actualRequest.getEntitlement());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CreateEntitlementRequest request =
          CreateEntitlementRequest.newBuilder()
              .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setEntitlement(Entitlement.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      client.createEntitlementAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void changeParametersTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("changeParametersTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    ChangeParametersRequest request =
        ChangeParametersRequest.newBuilder()
            .setName("name3373707")
            .addAllParameters(new ArrayList<Parameter>())
            .setRequestId("requestId693933066")
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .build();

    Entitlement actualResponse = client.changeParametersAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ChangeParametersRequest actualRequest = ((ChangeParametersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getParametersList(), actualRequest.getParametersList());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(request.getPurchaseOrderId(), actualRequest.getPurchaseOrderId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void changeParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChangeParametersRequest request =
          ChangeParametersRequest.newBuilder()
              .setName("name3373707")
              .addAllParameters(new ArrayList<Parameter>())
              .setRequestId("requestId693933066")
              .setPurchaseOrderId("purchaseOrderId2029917384")
              .build();
      client.changeParametersAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void changeRenewalSettingsTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("changeRenewalSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    ChangeRenewalSettingsRequest request =
        ChangeRenewalSettingsRequest.newBuilder()
            .setName("name3373707")
            .setRenewalSettings(RenewalSettings.newBuilder().build())
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.changeRenewalSettingsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ChangeRenewalSettingsRequest actualRequest =
        ((ChangeRenewalSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRenewalSettings(), actualRequest.getRenewalSettings());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void changeRenewalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChangeRenewalSettingsRequest request =
          ChangeRenewalSettingsRequest.newBuilder()
              .setName("name3373707")
              .setRenewalSettings(RenewalSettings.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      client.changeRenewalSettingsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void changeOfferTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("changeOfferTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    ChangeOfferRequest request =
        ChangeOfferRequest.newBuilder()
            .setName("name3373707")
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .addAllParameters(new ArrayList<Parameter>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.changeOfferAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ChangeOfferRequest actualRequest = ((ChangeOfferRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getOffer(), actualRequest.getOffer());
    Assert.assertEquals(request.getParametersList(), actualRequest.getParametersList());
    Assert.assertEquals(request.getPurchaseOrderId(), actualRequest.getPurchaseOrderId());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void changeOfferExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChangeOfferRequest request =
          ChangeOfferRequest.newBuilder()
              .setName("name3373707")
              .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
              .addAllParameters(new ArrayList<Parameter>())
              .setPurchaseOrderId("purchaseOrderId2029917384")
              .setRequestId("requestId693933066")
              .build();
      client.changeOfferAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startPaidServiceTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startPaidServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    StartPaidServiceRequest request =
        StartPaidServiceRequest.newBuilder()
            .setName("name3373707")
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.startPaidServiceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartPaidServiceRequest actualRequest = ((StartPaidServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startPaidServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      StartPaidServiceRequest request =
          StartPaidServiceRequest.newBuilder()
              .setName("name3373707")
              .setRequestId("requestId693933066")
              .build();
      client.startPaidServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void suspendEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("suspendEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    SuspendEntitlementRequest request =
        SuspendEntitlementRequest.newBuilder()
            .setName("name3373707")
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.suspendEntitlementAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuspendEntitlementRequest actualRequest = ((SuspendEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suspendEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      SuspendEntitlementRequest request =
          SuspendEntitlementRequest.newBuilder()
              .setName("name3373707")
              .setRequestId("requestId693933066")
              .build();
      client.suspendEntitlementAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cancelEntitlementTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cancelEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    CancelEntitlementRequest request =
        CancelEntitlementRequest.newBuilder()
            .setName("name3373707")
            .setRequestId("requestId693933066")
            .build();

    client.cancelEntitlementAsync(request).get();

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelEntitlementRequest actualRequest = ((CancelEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CancelEntitlementRequest request =
          CancelEntitlementRequest.newBuilder()
              .setName("name3373707")
              .setRequestId("requestId693933066")
              .build();
      client.cancelEntitlementAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void activateEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setCommitmentSettings(CommitmentSettings.newBuilder().build())
            .setProvisionedService(ProvisionedService.newBuilder().build())
            .addAllSuspensionReasons(new ArrayList<Entitlement.SuspensionReason>())
            .setPurchaseOrderId("purchaseOrderId2029917384")
            .setTrialSettings(TrialSettings.newBuilder().build())
            .setAssociationInfo(AssociationInfo.newBuilder().build())
            .addAllParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("activateEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    ActivateEntitlementRequest request =
        ActivateEntitlementRequest.newBuilder()
            .setName("name3373707")
            .setRequestId("requestId693933066")
            .build();

    Entitlement actualResponse = client.activateEntitlementAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ActivateEntitlementRequest actualRequest = ((ActivateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void activateEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ActivateEntitlementRequest request =
          ActivateEntitlementRequest.newBuilder()
              .setName("name3373707")
              .setRequestId("requestId693933066")
              .build();
      client.activateEntitlementAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void transferEntitlementsTest() throws Exception {
    TransferEntitlementsResponse expectedResponse =
        TransferEntitlementsResponse.newBuilder()
            .addAllEntitlements(new ArrayList<Entitlement>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("transferEntitlementsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    TransferEntitlementsRequest request =
        TransferEntitlementsRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllEntitlements(new ArrayList<Entitlement>())
            .setAuthToken("authToken1450587441")
            .setRequestId("requestId693933066")
            .build();

    TransferEntitlementsResponse actualResponse = client.transferEntitlementsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferEntitlementsRequest actualRequest =
        ((TransferEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEntitlementsList(), actualRequest.getEntitlementsList());
    Assert.assertEquals(request.getAuthToken(), actualRequest.getAuthToken());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void transferEntitlementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      TransferEntitlementsRequest request =
          TransferEntitlementsRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllEntitlements(new ArrayList<Entitlement>())
              .setAuthToken("authToken1450587441")
              .setRequestId("requestId693933066")
              .build();
      client.transferEntitlementsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void transferEntitlementsToGoogleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("transferEntitlementsToGoogleTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudChannelService.addResponse(resultOperation);

    TransferEntitlementsToGoogleRequest request =
        TransferEntitlementsToGoogleRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllEntitlements(new ArrayList<Entitlement>())
            .setRequestId("requestId693933066")
            .build();

    client.transferEntitlementsToGoogleAsync(request).get();

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferEntitlementsToGoogleRequest actualRequest =
        ((TransferEntitlementsToGoogleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEntitlementsList(), actualRequest.getEntitlementsList());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void transferEntitlementsToGoogleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      TransferEntitlementsToGoogleRequest request =
          TransferEntitlementsToGoogleRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllEntitlements(new ArrayList<Entitlement>())
              .setRequestId("requestId693933066")
              .build();
      client.transferEntitlementsToGoogleAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listChannelPartnerLinksTest() throws Exception {
    ChannelPartnerLink responsesElement = ChannelPartnerLink.newBuilder().build();
    ListChannelPartnerLinksResponse expectedResponse =
        ListChannelPartnerLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelPartnerLinks(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListChannelPartnerLinksRequest request =
        ListChannelPartnerLinksRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setView(ChannelPartnerLinkView.forNumber(0))
            .build();

    ListChannelPartnerLinksPagedResponse pagedListResponse =
        client.listChannelPartnerLinks(request);

    List<ChannelPartnerLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChannelPartnerLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelPartnerLinksRequest actualRequest =
        ((ListChannelPartnerLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelPartnerLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListChannelPartnerLinksRequest request =
          ListChannelPartnerLinksRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(ChannelPartnerLinkView.forNumber(0))
              .build();
      client.listChannelPartnerLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelPartnerLinkTest() throws Exception {
    ChannelPartnerLink expectedResponse =
        ChannelPartnerLink.newBuilder()
            .setName(ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
            .setResellerCloudIdentityId("resellerCloudIdentityId478410940")
            .setLinkState(ChannelPartnerLinkState.forNumber(0))
            .setInviteLinkUri("inviteLinkUri-1908670519")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublicId("publicId1293600100")
            .setChannelPartnerCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    GetChannelPartnerLinkRequest request =
        GetChannelPartnerLinkRequest.newBuilder()
            .setName("name3373707")
            .setView(ChannelPartnerLinkView.forNumber(0))
            .build();

    ChannelPartnerLink actualResponse = client.getChannelPartnerLink(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelPartnerLinkRequest actualRequest =
        ((GetChannelPartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelPartnerLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      GetChannelPartnerLinkRequest request =
          GetChannelPartnerLinkRequest.newBuilder()
              .setName("name3373707")
              .setView(ChannelPartnerLinkView.forNumber(0))
              .build();
      client.getChannelPartnerLink(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelPartnerLinkTest() throws Exception {
    ChannelPartnerLink expectedResponse =
        ChannelPartnerLink.newBuilder()
            .setName(ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
            .setResellerCloudIdentityId("resellerCloudIdentityId478410940")
            .setLinkState(ChannelPartnerLinkState.forNumber(0))
            .setInviteLinkUri("inviteLinkUri-1908670519")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublicId("publicId1293600100")
            .setChannelPartnerCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CreateChannelPartnerLinkRequest request =
        CreateChannelPartnerLinkRequest.newBuilder()
            .setParent("parent-995424086")
            .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
            .build();

    ChannelPartnerLink actualResponse = client.createChannelPartnerLink(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelPartnerLinkRequest actualRequest =
        ((CreateChannelPartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getChannelPartnerLink(), actualRequest.getChannelPartnerLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelPartnerLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CreateChannelPartnerLinkRequest request =
          CreateChannelPartnerLinkRequest.newBuilder()
              .setParent("parent-995424086")
              .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
              .build();
      client.createChannelPartnerLink(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateChannelPartnerLinkTest() throws Exception {
    ChannelPartnerLink expectedResponse =
        ChannelPartnerLink.newBuilder()
            .setName(ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
            .setResellerCloudIdentityId("resellerCloudIdentityId478410940")
            .setLinkState(ChannelPartnerLinkState.forNumber(0))
            .setInviteLinkUri("inviteLinkUri-1908670519")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublicId("publicId1293600100")
            .setChannelPartnerCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    UpdateChannelPartnerLinkRequest request =
        UpdateChannelPartnerLinkRequest.newBuilder()
            .setName("name3373707")
            .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    ChannelPartnerLink actualResponse = client.updateChannelPartnerLink(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateChannelPartnerLinkRequest actualRequest =
        ((UpdateChannelPartnerLinkRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getChannelPartnerLink(), actualRequest.getChannelPartnerLink());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateChannelPartnerLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      UpdateChannelPartnerLinkRequest request =
          UpdateChannelPartnerLinkRequest.newBuilder()
              .setName("name3373707")
              .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateChannelPartnerLink(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerRepricingConfigTest() throws Exception {
    CustomerRepricingConfig expectedResponse =
        CustomerRepricingConfig.newBuilder()
            .setName(
                CustomerRepricingConfigName.of(
                        "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerRepricingConfigName name =
        CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");

    CustomerRepricingConfig actualResponse = client.getCustomerRepricingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRepricingConfigRequest actualRequest =
        ((GetCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerRepricingConfigName name =
          CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");
      client.getCustomerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomerRepricingConfigTest2() throws Exception {
    CustomerRepricingConfig expectedResponse =
        CustomerRepricingConfig.newBuilder()
            .setName(
                CustomerRepricingConfigName.of(
                        "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    CustomerRepricingConfig actualResponse = client.getCustomerRepricingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomerRepricingConfigRequest actualRequest =
        ((GetCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomerRepricingConfigsTest() throws Exception {
    CustomerRepricingConfig responsesElement = CustomerRepricingConfig.newBuilder().build();
    ListCustomerRepricingConfigsResponse expectedResponse =
        ListCustomerRepricingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomerRepricingConfigs(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");

    ListCustomerRepricingConfigsPagedResponse pagedListResponse =
        client.listCustomerRepricingConfigs(parent);

    List<CustomerRepricingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCustomerRepricingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomerRepricingConfigsRequest actualRequest =
        ((ListCustomerRepricingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomerRepricingConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
      client.listCustomerRepricingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomerRepricingConfigsTest2() throws Exception {
    CustomerRepricingConfig responsesElement = CustomerRepricingConfig.newBuilder().build();
    ListCustomerRepricingConfigsResponse expectedResponse =
        ListCustomerRepricingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomerRepricingConfigs(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomerRepricingConfigsPagedResponse pagedListResponse =
        client.listCustomerRepricingConfigs(parent);

    List<CustomerRepricingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCustomerRepricingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomerRepricingConfigsRequest actualRequest =
        ((ListCustomerRepricingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomerRepricingConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomerRepricingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomerRepricingConfigTest() throws Exception {
    CustomerRepricingConfig expectedResponse =
        CustomerRepricingConfig.newBuilder()
            .setName(
                CustomerRepricingConfigName.of(
                        "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
    CustomerRepricingConfig customerRepricingConfig = CustomerRepricingConfig.newBuilder().build();

    CustomerRepricingConfig actualResponse =
        client.createCustomerRepricingConfig(parent, customerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomerRepricingConfigRequest actualRequest =
        ((CreateCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customerRepricingConfig, actualRequest.getCustomerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
      CustomerRepricingConfig customerRepricingConfig =
          CustomerRepricingConfig.newBuilder().build();
      client.createCustomerRepricingConfig(parent, customerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomerRepricingConfigTest2() throws Exception {
    CustomerRepricingConfig expectedResponse =
        CustomerRepricingConfig.newBuilder()
            .setName(
                CustomerRepricingConfigName.of(
                        "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomerRepricingConfig customerRepricingConfig = CustomerRepricingConfig.newBuilder().build();

    CustomerRepricingConfig actualResponse =
        client.createCustomerRepricingConfig(parent, customerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomerRepricingConfigRequest actualRequest =
        ((CreateCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customerRepricingConfig, actualRequest.getCustomerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomerRepricingConfig customerRepricingConfig =
          CustomerRepricingConfig.newBuilder().build();
      client.createCustomerRepricingConfig(parent, customerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomerRepricingConfigTest() throws Exception {
    CustomerRepricingConfig expectedResponse =
        CustomerRepricingConfig.newBuilder()
            .setName(
                CustomerRepricingConfigName.of(
                        "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerRepricingConfig customerRepricingConfig = CustomerRepricingConfig.newBuilder().build();

    CustomerRepricingConfig actualResponse =
        client.updateCustomerRepricingConfig(customerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomerRepricingConfigRequest actualRequest =
        ((UpdateCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(customerRepricingConfig, actualRequest.getCustomerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerRepricingConfig customerRepricingConfig =
          CustomerRepricingConfig.newBuilder().build();
      client.updateCustomerRepricingConfig(customerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomerRepricingConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    CustomerRepricingConfigName name =
        CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");

    client.deleteCustomerRepricingConfig(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomerRepricingConfigRequest actualRequest =
        ((DeleteCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      CustomerRepricingConfigName name =
          CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");
      client.deleteCustomerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomerRepricingConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCustomerRepricingConfig(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomerRepricingConfigRequest actualRequest =
        ((DeleteCustomerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelPartnerRepricingConfigTest() throws Exception {
    ChannelPartnerRepricingConfig expectedResponse =
        ChannelPartnerRepricingConfig.newBuilder()
            .setName(
                ChannelPartnerRepricingConfigName.of(
                        "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ChannelPartnerRepricingConfigName name =
        ChannelPartnerRepricingConfigName.of(
            "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");

    ChannelPartnerRepricingConfig actualResponse = client.getChannelPartnerRepricingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelPartnerRepricingConfigRequest actualRequest =
        ((GetChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelPartnerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChannelPartnerRepricingConfigName name =
          ChannelPartnerRepricingConfigName.of(
              "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");
      client.getChannelPartnerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChannelPartnerRepricingConfigTest2() throws Exception {
    ChannelPartnerRepricingConfig expectedResponse =
        ChannelPartnerRepricingConfig.newBuilder()
            .setName(
                ChannelPartnerRepricingConfigName.of(
                        "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    ChannelPartnerRepricingConfig actualResponse = client.getChannelPartnerRepricingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChannelPartnerRepricingConfigRequest actualRequest =
        ((GetChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChannelPartnerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.getChannelPartnerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelPartnerRepricingConfigsTest() throws Exception {
    ChannelPartnerRepricingConfig responsesElement =
        ChannelPartnerRepricingConfig.newBuilder().build();
    ListChannelPartnerRepricingConfigsResponse expectedResponse =
        ListChannelPartnerRepricingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelPartnerRepricingConfigs(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ChannelPartnerLinkName parent =
        ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");

    ListChannelPartnerRepricingConfigsPagedResponse pagedListResponse =
        client.listChannelPartnerRepricingConfigs(parent);

    List<ChannelPartnerRepricingConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getChannelPartnerRepricingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelPartnerRepricingConfigsRequest actualRequest =
        ((ListChannelPartnerRepricingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelPartnerRepricingConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChannelPartnerLinkName parent =
          ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");
      client.listChannelPartnerRepricingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChannelPartnerRepricingConfigsTest2() throws Exception {
    ChannelPartnerRepricingConfig responsesElement =
        ChannelPartnerRepricingConfig.newBuilder().build();
    ListChannelPartnerRepricingConfigsResponse expectedResponse =
        ListChannelPartnerRepricingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChannelPartnerRepricingConfigs(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChannelPartnerRepricingConfigsPagedResponse pagedListResponse =
        client.listChannelPartnerRepricingConfigs(parent);

    List<ChannelPartnerRepricingConfig> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getChannelPartnerRepricingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChannelPartnerRepricingConfigsRequest actualRequest =
        ((ListChannelPartnerRepricingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChannelPartnerRepricingConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChannelPartnerRepricingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelPartnerRepricingConfigTest() throws Exception {
    ChannelPartnerRepricingConfig expectedResponse =
        ChannelPartnerRepricingConfig.newBuilder()
            .setName(
                ChannelPartnerRepricingConfigName.of(
                        "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ChannelPartnerLinkName parent =
        ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");
    ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
        ChannelPartnerRepricingConfig.newBuilder().build();

    ChannelPartnerRepricingConfig actualResponse =
        client.createChannelPartnerRepricingConfig(parent, channelPartnerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelPartnerRepricingConfigRequest actualRequest =
        ((CreateChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        channelPartnerRepricingConfig, actualRequest.getChannelPartnerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelPartnerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChannelPartnerLinkName parent =
          ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");
      ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
          ChannelPartnerRepricingConfig.newBuilder().build();
      client.createChannelPartnerRepricingConfig(parent, channelPartnerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createChannelPartnerRepricingConfigTest2() throws Exception {
    ChannelPartnerRepricingConfig expectedResponse =
        ChannelPartnerRepricingConfig.newBuilder()
            .setName(
                ChannelPartnerRepricingConfigName.of(
                        "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
        ChannelPartnerRepricingConfig.newBuilder().build();

    ChannelPartnerRepricingConfig actualResponse =
        client.createChannelPartnerRepricingConfig(parent, channelPartnerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateChannelPartnerRepricingConfigRequest actualRequest =
        ((CreateChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        channelPartnerRepricingConfig, actualRequest.getChannelPartnerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createChannelPartnerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String parent = "parent-995424086";
      ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
          ChannelPartnerRepricingConfig.newBuilder().build();
      client.createChannelPartnerRepricingConfig(parent, channelPartnerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateChannelPartnerRepricingConfigTest() throws Exception {
    ChannelPartnerRepricingConfig expectedResponse =
        ChannelPartnerRepricingConfig.newBuilder()
            .setName(
                ChannelPartnerRepricingConfigName.of(
                        "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                    .toString())
            .setRepricingConfig(RepricingConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
        ChannelPartnerRepricingConfig.newBuilder().build();

    ChannelPartnerRepricingConfig actualResponse =
        client.updateChannelPartnerRepricingConfig(channelPartnerRepricingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateChannelPartnerRepricingConfigRequest actualRequest =
        ((UpdateChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        channelPartnerRepricingConfig, actualRequest.getChannelPartnerRepricingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateChannelPartnerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
          ChannelPartnerRepricingConfig.newBuilder().build();
      client.updateChannelPartnerRepricingConfig(channelPartnerRepricingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteChannelPartnerRepricingConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    ChannelPartnerRepricingConfigName name =
        ChannelPartnerRepricingConfigName.of(
            "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");

    client.deleteChannelPartnerRepricingConfig(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelPartnerRepricingConfigRequest actualRequest =
        ((DeleteChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelPartnerRepricingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ChannelPartnerRepricingConfigName name =
          ChannelPartnerRepricingConfigName.of(
              "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");
      client.deleteChannelPartnerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteChannelPartnerRepricingConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCloudChannelService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteChannelPartnerRepricingConfig(name);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteChannelPartnerRepricingConfigRequest actualRequest =
        ((DeleteChannelPartnerRepricingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteChannelPartnerRepricingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteChannelPartnerRepricingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupOfferTest() throws Exception {
    Offer expectedResponse =
        Offer.newBuilder()
            .setName(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
            .setMarketingInfo(MarketingInfo.newBuilder().build())
            .setSku(Sku.newBuilder().build())
            .setPlan(Plan.newBuilder().build())
            .setConstraints(Constraints.newBuilder().build())
            .addAllPriceByResources(new ArrayList<PriceByResource>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllParameterDefinitions(new ArrayList<ParameterDefinition>())
            .setDealCode("dealCode509806713")
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    LookupOfferRequest request =
        LookupOfferRequest.newBuilder()
            .setEntitlement(
                EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
            .build();

    Offer actualResponse = client.lookupOffer(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupOfferRequest actualRequest = ((LookupOfferRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEntitlement(), actualRequest.getEntitlement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupOfferExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      LookupOfferRequest request =
          LookupOfferRequest.newBuilder()
              .setEntitlement(
                  EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
              .build();
      client.lookupOffer(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProductsTest() throws Exception {
    Product responsesElement = Product.newBuilder().build();
    ListProductsResponse expectedResponse =
        ListProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProducts(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListProductsRequest request =
        ListProductsRequest.newBuilder()
            .setAccount("account-1177318867")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListProductsPagedResponse pagedListResponse = client.listProducts(request);

    List<Product> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProductsRequest actualRequest = ((ListProductsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListProductsRequest request =
          ListProductsRequest.newBuilder()
              .setAccount("account-1177318867")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listProducts(request);
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
    mockCloudChannelService.addResponse(expectedResponse);

    ListSkusRequest request =
        ListSkusRequest.newBuilder()
            .setParent(ProductName.of("[PRODUCT]").toString())
            .setAccount("account-1177318867")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListSkusPagedResponse pagedListResponse = client.listSkus(request);

    List<Sku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSkusRequest actualRequest = ((ListSkusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListSkusRequest request =
          ListSkusRequest.newBuilder()
              .setParent(ProductName.of("[PRODUCT]").toString())
              .setAccount("account-1177318867")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listSkus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOffersTest() throws Exception {
    Offer responsesElement = Offer.newBuilder().build();
    ListOffersResponse expectedResponse =
        ListOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllOffers(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListOffersRequest request =
        ListOffersRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListOffersPagedResponse pagedListResponse = client.listOffers(request);

    List<Offer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOffersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOffersRequest actualRequest = ((ListOffersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOffersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListOffersRequest request =
          ListOffersRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listOffers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPurchasableSkusTest() throws Exception {
    PurchasableSku responsesElement = PurchasableSku.newBuilder().build();
    ListPurchasableSkusResponse expectedResponse =
        ListPurchasableSkusResponse.newBuilder()
            .setNextPageToken("")
            .addAllPurchasableSkus(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListPurchasableSkusRequest request =
        ListPurchasableSkusRequest.newBuilder()
            .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListPurchasableSkusPagedResponse pagedListResponse = client.listPurchasableSkus(request);

    List<PurchasableSku> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPurchasableSkusList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPurchasableSkusRequest actualRequest = ((ListPurchasableSkusRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getCreateEntitlementPurchase(), actualRequest.getCreateEntitlementPurchase());
    Assert.assertEquals(request.getChangeOfferPurchase(), actualRequest.getChangeOfferPurchase());
    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPurchasableSkusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListPurchasableSkusRequest request =
          ListPurchasableSkusRequest.newBuilder()
              .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listPurchasableSkus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPurchasableOffersTest() throws Exception {
    PurchasableOffer responsesElement = PurchasableOffer.newBuilder().build();
    ListPurchasableOffersResponse expectedResponse =
        ListPurchasableOffersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPurchasableOffers(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListPurchasableOffersRequest request =
        ListPurchasableOffersRequest.newBuilder()
            .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setLanguageCode("languageCode-2092349083")
            .build();

    ListPurchasableOffersPagedResponse pagedListResponse = client.listPurchasableOffers(request);

    List<PurchasableOffer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPurchasableOffersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPurchasableOffersRequest actualRequest =
        ((ListPurchasableOffersRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getCreateEntitlementPurchase(), actualRequest.getCreateEntitlementPurchase());
    Assert.assertEquals(request.getChangeOfferPurchase(), actualRequest.getChangeOfferPurchase());
    Assert.assertEquals(request.getCustomer(), actualRequest.getCustomer());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPurchasableOffersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListPurchasableOffersRequest request =
          ListPurchasableOffersRequest.newBuilder()
              .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.listPurchasableOffers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void registerSubscriberTest() throws Exception {
    RegisterSubscriberResponse expectedResponse =
        RegisterSubscriberResponse.newBuilder().setTopic("topic110546223").build();
    mockCloudChannelService.addResponse(expectedResponse);

    RegisterSubscriberRequest request =
        RegisterSubscriberRequest.newBuilder()
            .setAccount("account-1177318867")
            .setServiceAccount("serviceAccount1079137720")
            .build();

    RegisterSubscriberResponse actualResponse = client.registerSubscriber(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterSubscriberRequest actualRequest = ((RegisterSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getServiceAccount(), actualRequest.getServiceAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerSubscriberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      RegisterSubscriberRequest request =
          RegisterSubscriberRequest.newBuilder()
              .setAccount("account-1177318867")
              .setServiceAccount("serviceAccount1079137720")
              .build();
      client.registerSubscriber(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unregisterSubscriberTest() throws Exception {
    UnregisterSubscriberResponse expectedResponse =
        UnregisterSubscriberResponse.newBuilder().setTopic("topic110546223").build();
    mockCloudChannelService.addResponse(expectedResponse);

    UnregisterSubscriberRequest request =
        UnregisterSubscriberRequest.newBuilder()
            .setAccount("account-1177318867")
            .setServiceAccount("serviceAccount1079137720")
            .build();

    UnregisterSubscriberResponse actualResponse = client.unregisterSubscriber(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnregisterSubscriberRequest actualRequest =
        ((UnregisterSubscriberRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getServiceAccount(), actualRequest.getServiceAccount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unregisterSubscriberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      UnregisterSubscriberRequest request =
          UnregisterSubscriberRequest.newBuilder()
              .setAccount("account-1177318867")
              .setServiceAccount("serviceAccount1079137720")
              .build();
      client.unregisterSubscriber(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscribersTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListSubscribersResponse expectedResponse =
        ListSubscribersResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceAccounts(Arrays.asList(responsesElement))
            .build();
    mockCloudChannelService.addResponse(expectedResponse);

    ListSubscribersRequest request =
        ListSubscribersRequest.newBuilder()
            .setAccount("account-1177318867")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListSubscribersPagedResponse pagedListResponse = client.listSubscribers(request);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceAccountsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudChannelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSubscribersRequest actualRequest = ((ListSubscribersRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAccount(), actualRequest.getAccount());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSubscribersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudChannelService.addException(exception);

    try {
      ListSubscribersRequest request =
          ListSubscribersRequest.newBuilder()
              .setAccount("account-1177318867")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listSubscribers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
