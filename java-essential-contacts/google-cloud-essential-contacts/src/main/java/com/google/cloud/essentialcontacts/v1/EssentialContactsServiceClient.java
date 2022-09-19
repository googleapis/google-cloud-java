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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.essentialcontacts.v1.stub.EssentialContactsServiceStub;
import com.google.cloud.essentialcontacts.v1.stub.EssentialContactsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages contacts for important Google Cloud notifications.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EssentialContactsServiceClient essentialContactsServiceClient =
 *     EssentialContactsServiceClient.create()) {
 *   FolderName parent = FolderName.of("[FOLDER]");
 *   Contact contact = Contact.newBuilder().build();
 *   Contact response = essentialContactsServiceClient.createContact(parent, contact);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EssentialContactsServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * EssentialContactsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EssentialContactsServiceSettings essentialContactsServiceSettings =
 *     EssentialContactsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EssentialContactsServiceClient essentialContactsServiceClient =
 *     EssentialContactsServiceClient.create(essentialContactsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EssentialContactsServiceSettings essentialContactsServiceSettings =
 *     EssentialContactsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EssentialContactsServiceClient essentialContactsServiceClient =
 *     EssentialContactsServiceClient.create(essentialContactsServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EssentialContactsServiceSettings essentialContactsServiceSettings =
 *     EssentialContactsServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             EssentialContactsServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * EssentialContactsServiceClient essentialContactsServiceClient =
 *     EssentialContactsServiceClient.create(essentialContactsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EssentialContactsServiceClient implements BackgroundResource {
  private final EssentialContactsServiceSettings settings;
  private final EssentialContactsServiceStub stub;

  /** Constructs an instance of EssentialContactsServiceClient with default settings. */
  public static final EssentialContactsServiceClient create() throws IOException {
    return create(EssentialContactsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EssentialContactsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final EssentialContactsServiceClient create(
      EssentialContactsServiceSettings settings) throws IOException {
    return new EssentialContactsServiceClient(settings);
  }

  /**
   * Constructs an instance of EssentialContactsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(EssentialContactsServiceSettings).
   */
  public static final EssentialContactsServiceClient create(EssentialContactsServiceStub stub) {
    return new EssentialContactsServiceClient(stub);
  }

  /**
   * Constructs an instance of EssentialContactsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected EssentialContactsServiceClient(EssentialContactsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((EssentialContactsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected EssentialContactsServiceClient(EssentialContactsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EssentialContactsServiceSettings getSettings() {
    return settings;
  }

  public EssentialContactsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = essentialContactsServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The resource to save this contact for. Format:
   *     organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
   * @param contact Required. The contact to create. Must specify an email address and language tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(FolderName parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContact(contact)
            .build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = essentialContactsServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The resource to save this contact for. Format:
   *     organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
   * @param contact Required. The contact to create. Must specify an email address and language tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(OrganizationName parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContact(contact)
            .build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = essentialContactsServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The resource to save this contact for. Format:
   *     organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
   * @param contact Required. The contact to create. Must specify an email address and language tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(ProjectName parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContact(contact)
            .build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = essentialContactsServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The resource to save this contact for. Format:
   *     organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
   * @param contact Required. The contact to create. Must specify an email address and language tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(String parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder().setParent(parent).setContact(contact).build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   CreateContactRequest request =
   *       CreateContactRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setContact(Contact.newBuilder().build())
   *           .build();
   *   Contact response = essentialContactsServiceClient.createContact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(CreateContactRequest request) {
    return createContactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new contact for a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   CreateContactRequest request =
   *       CreateContactRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setContact(Contact.newBuilder().build())
   *           .build();
   *   ApiFuture<Contact> future =
   *       essentialContactsServiceClient.createContactCallable().futureCall(request);
   *   // Do something.
   *   Contact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateContactRequest, Contact> createContactCallable() {
    return stub.createContactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a contact. Note: A contact's email address cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   Contact contact = Contact.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Contact response = essentialContactsServiceClient.updateContact(contact, updateMask);
   * }
   * }</pre>
   *
   * @param contact Required. The contact resource to replace the existing saved contact. Note: the
   *     email address of the contact cannot be modified.
   * @param updateMask Optional. The update mask applied to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact updateContact(Contact contact, FieldMask updateMask) {
    UpdateContactRequest request =
        UpdateContactRequest.newBuilder().setContact(contact).setUpdateMask(updateMask).build();
    return updateContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a contact. Note: A contact's email address cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   UpdateContactRequest request =
   *       UpdateContactRequest.newBuilder()
   *           .setContact(Contact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Contact response = essentialContactsServiceClient.updateContact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact updateContact(UpdateContactRequest request) {
    return updateContactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a contact. Note: A contact's email address cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   UpdateContactRequest request =
   *       UpdateContactRequest.newBuilder()
   *           .setContact(Contact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Contact> future =
   *       essentialContactsServiceClient.updateContactCallable().futureCall(request);
   *   // Do something.
   *   Contact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateContactRequest, Contact> updateContactCallable() {
    return stub.updateContactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (Contact element : essentialContactsServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format: organizations/{organization_id},
   *     folders/{folder_id} or projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(FolderName parent) {
    ListContactsRequest request =
        ListContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (Contact element : essentialContactsServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format: organizations/{organization_id},
   *     folders/{folder_id} or projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(OrganizationName parent) {
    ListContactsRequest request =
        ListContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Contact element : essentialContactsServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format: organizations/{organization_id},
   *     folders/{folder_id} or projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(ProjectName parent) {
    ListContactsRequest request =
        ListContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Contact element : essentialContactsServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format: organizations/{organization_id},
   *     folders/{folder_id} or projects/{project_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(String parent) {
    ListContactsRequest request = ListContactsRequest.newBuilder().setParent(parent).build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Contact element : essentialContactsServiceClient.listContacts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(ListContactsRequest request) {
    return listContactsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Contact> future =
   *       essentialContactsServiceClient.listContactsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Contact element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContactsRequest, ListContactsPagedResponse>
      listContactsPagedCallable() {
    return stub.listContactsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the contacts that have been set on a resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListContactsResponse response =
   *         essentialContactsServiceClient.listContactsCallable().call(request);
   *     for (Contact element : response.getContactsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable() {
    return stub.listContactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");
   *   Contact response = essentialContactsServiceClient.getContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the contact to retrieve. Format:
   *     organizations/{organization_id}/contacts/{contact_id},
   *     folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact getContact(ContactName name) {
    GetContactRequest request =
        GetContactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   String name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString();
   *   Contact response = essentialContactsServiceClient.getContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the contact to retrieve. Format:
   *     organizations/{organization_id}/contacts/{contact_id},
   *     folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact getContact(String name) {
    GetContactRequest request = GetContactRequest.newBuilder().setName(name).build();
    return getContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   GetContactRequest request =
   *       GetContactRequest.newBuilder()
   *           .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
   *           .build();
   *   Contact response = essentialContactsServiceClient.getContact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact getContact(GetContactRequest request) {
    return getContactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   GetContactRequest request =
   *       GetContactRequest.newBuilder()
   *           .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
   *           .build();
   *   ApiFuture<Contact> future =
   *       essentialContactsServiceClient.getContactCallable().futureCall(request);
   *   // Do something.
   *   Contact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContactRequest, Contact> getContactCallable() {
    return stub.getContactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ContactName name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]");
   *   essentialContactsServiceClient.deleteContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the contact to delete. Format:
   *     organizations/{organization_id}/contacts/{contact_id},
   *     folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContact(ContactName name) {
    DeleteContactRequest request =
        DeleteContactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   String name = ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString();
   *   essentialContactsServiceClient.deleteContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the contact to delete. Format:
   *     organizations/{organization_id}/contacts/{contact_id},
   *     folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContact(String name) {
    DeleteContactRequest request = DeleteContactRequest.newBuilder().setName(name).build();
    deleteContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   DeleteContactRequest request =
   *       DeleteContactRequest.newBuilder()
   *           .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
   *           .build();
   *   essentialContactsServiceClient.deleteContact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContact(DeleteContactRequest request) {
    deleteContactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a contact.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   DeleteContactRequest request =
   *       DeleteContactRequest.newBuilder()
   *           .setName(ContactName.ofProjectContactName("[PROJECT]", "[CONTACT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       essentialContactsServiceClient.deleteContactCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteContactRequest, Empty> deleteContactCallable() {
    return stub.deleteContactCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all contacts for the resource that are subscribed to the specified notification
   * categories, including contacts inherited from any parent resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ComputeContactsRequest request =
   *       ComputeContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllNotificationCategories(new ArrayList<NotificationCategory>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Contact element : essentialContactsServiceClient.computeContacts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeContactsPagedResponse computeContacts(ComputeContactsRequest request) {
    return computeContactsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all contacts for the resource that are subscribed to the specified notification
   * categories, including contacts inherited from any parent resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ComputeContactsRequest request =
   *       ComputeContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllNotificationCategories(new ArrayList<NotificationCategory>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Contact> future =
   *       essentialContactsServiceClient.computeContactsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Contact element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeContactsRequest, ComputeContactsPagedResponse>
      computeContactsPagedCallable() {
    return stub.computeContactsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all contacts for the resource that are subscribed to the specified notification
   * categories, including contacts inherited from any parent resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   ComputeContactsRequest request =
   *       ComputeContactsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllNotificationCategories(new ArrayList<NotificationCategory>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ComputeContactsResponse response =
   *         essentialContactsServiceClient.computeContactsCallable().call(request);
   *     for (Contact element : response.getContactsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeContactsRequest, ComputeContactsResponse>
      computeContactsCallable() {
    return stub.computeContactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows a contact admin to send a test message to contact to verify that it has been configured
   * correctly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   SendTestMessageRequest request =
   *       SendTestMessageRequest.newBuilder()
   *           .addAllContacts(new ArrayList<String>())
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setNotificationCategory(NotificationCategory.forNumber(0))
   *           .build();
   *   essentialContactsServiceClient.sendTestMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void sendTestMessage(SendTestMessageRequest request) {
    sendTestMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allows a contact admin to send a test message to contact to verify that it has been configured
   * correctly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EssentialContactsServiceClient essentialContactsServiceClient =
   *     EssentialContactsServiceClient.create()) {
   *   SendTestMessageRequest request =
   *       SendTestMessageRequest.newBuilder()
   *           .addAllContacts(new ArrayList<String>())
   *           .setResource(ProjectName.of("[PROJECT]").toString())
   *           .setNotificationCategory(NotificationCategory.forNumber(0))
   *           .build();
   *   ApiFuture<Empty> future =
   *       essentialContactsServiceClient.sendTestMessageCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SendTestMessageRequest, Empty> sendTestMessageCallable() {
    return stub.sendTestMessageCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListContactsPagedResponse
      extends AbstractPagedListResponse<
          ListContactsRequest,
          ListContactsResponse,
          Contact,
          ListContactsPage,
          ListContactsFixedSizeCollection> {

    public static ApiFuture<ListContactsPagedResponse> createAsync(
        PageContext<ListContactsRequest, ListContactsResponse, Contact> context,
        ApiFuture<ListContactsResponse> futureResponse) {
      ApiFuture<ListContactsPage> futurePage =
          ListContactsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContactsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContactsPagedResponse(ListContactsPage page) {
      super(page, ListContactsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContactsPage
      extends AbstractPage<ListContactsRequest, ListContactsResponse, Contact, ListContactsPage> {

    private ListContactsPage(
        PageContext<ListContactsRequest, ListContactsResponse, Contact> context,
        ListContactsResponse response) {
      super(context, response);
    }

    private static ListContactsPage createEmptyPage() {
      return new ListContactsPage(null, null);
    }

    @Override
    protected ListContactsPage createPage(
        PageContext<ListContactsRequest, ListContactsResponse, Contact> context,
        ListContactsResponse response) {
      return new ListContactsPage(context, response);
    }

    @Override
    public ApiFuture<ListContactsPage> createPageAsync(
        PageContext<ListContactsRequest, ListContactsResponse, Contact> context,
        ApiFuture<ListContactsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContactsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContactsRequest,
          ListContactsResponse,
          Contact,
          ListContactsPage,
          ListContactsFixedSizeCollection> {

    private ListContactsFixedSizeCollection(List<ListContactsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContactsFixedSizeCollection createEmptyCollection() {
      return new ListContactsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContactsFixedSizeCollection createCollection(
        List<ListContactsPage> pages, int collectionSize) {
      return new ListContactsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ComputeContactsPagedResponse
      extends AbstractPagedListResponse<
          ComputeContactsRequest,
          ComputeContactsResponse,
          Contact,
          ComputeContactsPage,
          ComputeContactsFixedSizeCollection> {

    public static ApiFuture<ComputeContactsPagedResponse> createAsync(
        PageContext<ComputeContactsRequest, ComputeContactsResponse, Contact> context,
        ApiFuture<ComputeContactsResponse> futureResponse) {
      ApiFuture<ComputeContactsPage> futurePage =
          ComputeContactsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ComputeContactsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ComputeContactsPagedResponse(ComputeContactsPage page) {
      super(page, ComputeContactsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ComputeContactsPage
      extends AbstractPage<
          ComputeContactsRequest, ComputeContactsResponse, Contact, ComputeContactsPage> {

    private ComputeContactsPage(
        PageContext<ComputeContactsRequest, ComputeContactsResponse, Contact> context,
        ComputeContactsResponse response) {
      super(context, response);
    }

    private static ComputeContactsPage createEmptyPage() {
      return new ComputeContactsPage(null, null);
    }

    @Override
    protected ComputeContactsPage createPage(
        PageContext<ComputeContactsRequest, ComputeContactsResponse, Contact> context,
        ComputeContactsResponse response) {
      return new ComputeContactsPage(context, response);
    }

    @Override
    public ApiFuture<ComputeContactsPage> createPageAsync(
        PageContext<ComputeContactsRequest, ComputeContactsResponse, Contact> context,
        ApiFuture<ComputeContactsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ComputeContactsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ComputeContactsRequest,
          ComputeContactsResponse,
          Contact,
          ComputeContactsPage,
          ComputeContactsFixedSizeCollection> {

    private ComputeContactsFixedSizeCollection(
        List<ComputeContactsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ComputeContactsFixedSizeCollection createEmptyCollection() {
      return new ComputeContactsFixedSizeCollection(null, 0);
    }

    @Override
    protected ComputeContactsFixedSizeCollection createCollection(
        List<ComputeContactsPage> pages, int collectionSize) {
      return new ComputeContactsFixedSizeCollection(pages, collectionSize);
    }
  }
}
