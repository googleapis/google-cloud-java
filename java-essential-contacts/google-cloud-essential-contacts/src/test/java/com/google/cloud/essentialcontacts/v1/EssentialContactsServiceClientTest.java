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

package com.google.cloud.essentialcontacts.v1;

import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ComputeContactsPagedResponse;
import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ListContactsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EssentialContactsServiceClientTest {
  private static MockEssentialContactsService mockEssentialContactsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EssentialContactsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEssentialContactsService = new MockEssentialContactsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEssentialContactsService));
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
    EssentialContactsServiceSettings settings =
        EssentialContactsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EssentialContactsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContactRequest actualRequest = ((CreateContactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(contact, actualRequest.getContact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
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
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContactRequest actualRequest = ((CreateContactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(contact, actualRequest.getContact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Contact contact = Contact.newBuilder().build();
      client.createContact(parent, contact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContactTest3() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContactRequest actualRequest = ((CreateContactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(contact, actualRequest.getContact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContactExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Contact contact = Contact.newBuilder().build();
      client.createContact(parent, contact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContactTest4() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Contact contact = Contact.newBuilder().build();

    Contact actualResponse = client.createContact(parent, contact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContactRequest actualRequest = ((CreateContactRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(contact, actualRequest.getContact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContactExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Contact contact = Contact.newBuilder().build();
      client.createContact(parent, contact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    Contact contact = Contact.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Contact actualResponse = client.updateContact(contact, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContactRequest actualRequest = ((UpdateContactRequest) actualRequests.get(0));

    Assert.assertEquals(contact, actualRequest.getContact());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateContactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      Contact contact = Contact.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateContact(contact, updateMask);
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
    mockEssentialContactsService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContactsRequest actualRequest = ((ListContactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
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
    mockEssentialContactsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContactsRequest actualRequest = ((ListContactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listContacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContactsTest3() throws Exception {
    Contact responsesElement = Contact.newBuilder().build();
    ListContactsResponse expectedResponse =
        ListContactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContacts(Arrays.asList(responsesElement))
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContactsRequest actualRequest = ((ListContactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContactsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listContacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContactsTest4() throws Exception {
    Contact responsesElement = Contact.newBuilder().build();
    ListContactsResponse expectedResponse =
        ListContactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContacts(Arrays.asList(responsesElement))
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListContactsPagedResponse pagedListResponse = client.listContacts(parent);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContactsRequest actualRequest = ((ListContactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContactsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listContacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContactTest() throws Exception {
    Contact expectedResponse =
        Contact.newBuilder()
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");

    Contact actualResponse = client.getContact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContactRequest actualRequest = ((GetContactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");
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
            .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
            .setEmail("email96619420")
            .addAllNotificationCategorySubscriptions(new ArrayList<NotificationCategory>())
            .setLanguageTag("languageTag-1175857886")
            .setValidationState(ValidationState.forNumber(0))
            .setValidateTime(Timestamp.newBuilder().build())
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    String name = "name3373707";

    Contact actualResponse = client.getContact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContactRequest actualRequest = ((GetContactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      String name = "name3373707";
      client.getContact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContactTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEssentialContactsService.addResponse(expectedResponse);

    ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");

    client.deleteContact(name);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContactRequest actualRequest = ((DeleteContactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");
      client.deleteContact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContactTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEssentialContactsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteContact(name);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContactRequest actualRequest = ((DeleteContactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteContact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void computeContactsTest() throws Exception {
    Contact responsesElement = Contact.newBuilder().build();
    ComputeContactsResponse expectedResponse =
        ComputeContactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllContacts(Arrays.asList(responsesElement))
            .build();
    mockEssentialContactsService.addResponse(expectedResponse);

    ComputeContactsRequest request =
        ComputeContactsRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .addAllNotificationCategories(new ArrayList<NotificationCategory>())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ComputeContactsPagedResponse pagedListResponse = client.computeContacts(request);

    List<Contact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ComputeContactsRequest actualRequest = ((ComputeContactsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(
        request.getNotificationCategoriesList(), actualRequest.getNotificationCategoriesList());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void computeContactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      ComputeContactsRequest request =
          ComputeContactsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .addAllNotificationCategories(new ArrayList<NotificationCategory>())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.computeContacts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendTestMessageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEssentialContactsService.addResponse(expectedResponse);

    SendTestMessageRequest request =
        SendTestMessageRequest.newBuilder()
            .addAllContacts(new ArrayList<String>())
            .setResource(ProjectName.of("[PROJECT]").toString())
            .setNotificationCategory(NotificationCategory.forNumber(0))
            .build();

    client.sendTestMessage(request);

    List<AbstractMessage> actualRequests = mockEssentialContactsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendTestMessageRequest actualRequest = ((SendTestMessageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContactsList(), actualRequest.getContactsList());
    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getNotificationCategory(), actualRequest.getNotificationCategory());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendTestMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEssentialContactsService.addException(exception);

    try {
      SendTestMessageRequest request =
          SendTestMessageRequest.newBuilder()
              .addAllContacts(new ArrayList<String>())
              .setResource(ProjectName.of("[PROJECT]").toString())
              .setNotificationCategory(NotificationCategory.forNumber(0))
              .build();
      client.sendTestMessage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
