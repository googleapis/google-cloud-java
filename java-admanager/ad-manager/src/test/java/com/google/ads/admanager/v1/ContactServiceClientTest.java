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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ContactServiceClient.ListContactsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonContactServiceStub;
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
public class ContactServiceClientTest {
  private static MockHttpService mockService;
  private static ContactServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonContactServiceStub.getMethodDescriptors(),
            ContactServiceSettings.getDefaultEndpoint());
    ContactServiceSettings settings =
        ContactServiceSettings.newBuilder()
            .setTransportChannelProvider(
                ContactServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContactServiceClient.create(settings);
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
  public void getContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    mockService.addResponse(expectedResponse);

    ContactName name = ContactName.of("[NETWORK_CODE]", "[CONTACT]");

    Contact actualResponse = client.getContact(name);
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
  public void getContactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ContactName name = ContactName.of("[NETWORK_CODE]", "[CONTACT]");
      client.getContact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContactTest2() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-6322/contacts/contact-6322";

    Contact actualResponse = client.getContact(name);
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
  public void getContactExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6322/contacts/contact-6322";
      client.getContact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContactsTest() throws Exception {
    Contact responsesElement = Contact.newBuilder().build();
    ListContactsResponse expectedResponse =
        ListContactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

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
  public void listContactsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listContacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContactsTest2() throws Exception {
    Contact responsesElement = Contact.newBuilder().build();
    ListContactsResponse expectedResponse =
        ListContactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

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
  public void listContactsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listContacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
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
  public void createContactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      Contact contact = Contact.newBuilder().build();
      client.createContact(parent, contact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContactTest2() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
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
  public void createContactExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      Contact contact = Contact.newBuilder().build();
      client.createContact(parent, contact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateContactsTest() throws Exception {
    BatchCreateContactsResponse expectedResponse =
        BatchCreateContactsResponse.newBuilder().addAllContacts(new ArrayList<Contact>()).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateContactRequest> requests = new ArrayList<>();

    BatchCreateContactsResponse actualResponse = client.batchCreateContacts(parent, requests);
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
  public void batchCreateContactsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateContactRequest> requests = new ArrayList<>();
      client.batchCreateContacts(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateContactsTest2() throws Exception {
    BatchCreateContactsResponse expectedResponse =
        BatchCreateContactsResponse.newBuilder().addAllContacts(new ArrayList<Contact>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateContactRequest> requests = new ArrayList<>();

    BatchCreateContactsResponse actualResponse = client.batchCreateContacts(parent, requests);
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
  public void batchCreateContactsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateContactRequest> requests = new ArrayList<>();
      client.batchCreateContacts(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    mockService.addResponse(expectedResponse);

    Contact contact =
        Contact.newBuilder()
            .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
            .setDisplayName("displayName1714148973")
            .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
            .setAddress("address-1147692044")
            .setCellPhone("cellPhone1616007468")
            .setComment("comment950398559")
            .setEmail("email96619420")
            .setFax("fax101149")
            .setTitle("title110371416")
            .setWorkPhone("workPhone1076316381")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Contact actualResponse = client.updateContact(contact, updateMask);
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
  public void updateContactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Contact contact =
          Contact.newBuilder()
              .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
              .setDisplayName("displayName1714148973")
              .setCompany(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
              .setAddress("address-1147692044")
              .setCellPhone("cellPhone1616007468")
              .setComment("comment950398559")
              .setEmail("email96619420")
              .setFax("fax101149")
              .setTitle("title110371416")
              .setWorkPhone("workPhone1076316381")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateContact(contact, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateContactsTest() throws Exception {
    BatchUpdateContactsResponse expectedResponse =
        BatchUpdateContactsResponse.newBuilder().addAllContacts(new ArrayList<Contact>()).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateContactRequest> requests = new ArrayList<>();

    BatchUpdateContactsResponse actualResponse = client.batchUpdateContacts(parent, requests);
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
  public void batchUpdateContactsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateContactRequest> requests = new ArrayList<>();
      client.batchUpdateContacts(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateContactsTest2() throws Exception {
    BatchUpdateContactsResponse expectedResponse =
        BatchUpdateContactsResponse.newBuilder().addAllContacts(new ArrayList<Contact>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateContactRequest> requests = new ArrayList<>();

    BatchUpdateContactsResponse actualResponse = client.batchUpdateContacts(parent, requests);
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
  public void batchUpdateContactsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateContactRequest> requests = new ArrayList<>();
      client.batchUpdateContacts(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
