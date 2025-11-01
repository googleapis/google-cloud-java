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

import com.google.ads.admanager.v1.stub.ContactServiceStub;
import com.google.ads.admanager.v1.stub.ContactServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `Contact` objects.
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
 * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
 *   ContactName name = ContactName.of("[NETWORK_CODE]", "[CONTACT]");
 *   Contact response = contactServiceClient.getContact(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContactServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetContact</td>
 *      <td><p> API to retrieve a `Contact` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getContact(GetContactRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getContact(ContactName name)
 *           <li><p> getContact(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getContactCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListContacts</td>
 *      <td><p> API to retrieve a list of `Contact` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listContacts(ListContactsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listContacts(NetworkName parent)
 *           <li><p> listContacts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listContactsPagedCallable()
 *           <li><p> listContactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateContact</td>
 *      <td><p> API to create a `Contact` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createContact(CreateContactRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createContact(NetworkName parent, Contact contact)
 *           <li><p> createContact(String parent, Contact contact)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createContactCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateContacts</td>
 *      <td><p> API to batch create `Contact` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateContacts(NetworkName parent, List&lt;CreateContactRequest&gt; requests)
 *           <li><p> batchCreateContacts(String parent, List&lt;CreateContactRequest&gt; requests)
 *           <li><p> batchCreateContacts(BatchCreateContactsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateContactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateContact</td>
 *      <td><p> API to update a `Contact` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateContact(UpdateContactRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateContact(Contact contact, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateContactCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateContacts</td>
 *      <td><p> API to batch update `Contact` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateContacts(NetworkName parent, List&lt;UpdateContactRequest&gt; requests)
 *           <li><p> batchUpdateContacts(String parent, List&lt;UpdateContactRequest&gt; requests)
 *           <li><p> batchUpdateContacts(BatchUpdateContactsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateContactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ContactServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContactServiceSettings contactServiceSettings =
 *     ContactServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContactServiceClient contactServiceClient = ContactServiceClient.create(contactServiceSettings);
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
 * ContactServiceSettings contactServiceSettings =
 *     ContactServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContactServiceClient contactServiceClient = ContactServiceClient.create(contactServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContactServiceClient implements BackgroundResource {
  private final ContactServiceSettings settings;
  private final ContactServiceStub stub;

  /** Constructs an instance of ContactServiceClient with default settings. */
  public static final ContactServiceClient create() throws IOException {
    return create(ContactServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContactServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContactServiceClient create(ContactServiceSettings settings)
      throws IOException {
    return new ContactServiceClient(settings);
  }

  /**
   * Constructs an instance of ContactServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ContactServiceSettings).
   */
  public static final ContactServiceClient create(ContactServiceStub stub) {
    return new ContactServiceClient(stub);
  }

  /**
   * Constructs an instance of ContactServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ContactServiceClient(ContactServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContactServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContactServiceClient(ContactServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContactServiceSettings getSettings() {
    return settings;
  }

  public ContactServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   ContactName name = ContactName.of("[NETWORK_CODE]", "[CONTACT]");
   *   Contact response = contactServiceClient.getContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Contact. Format:
   *     `networks/{network_code}/contacts/{contact_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact getContact(ContactName name) {
    GetContactRequest request =
        GetContactRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   String name = ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString();
   *   Contact response = contactServiceClient.getContact(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Contact. Format:
   *     `networks/{network_code}/contacts/{contact_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact getContact(String name) {
    GetContactRequest request = GetContactRequest.newBuilder().setName(name).build();
    return getContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   GetContactRequest request =
   *       GetContactRequest.newBuilder()
   *           .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
   *           .build();
   *   Contact response = contactServiceClient.getContact(request);
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
   * API to retrieve a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   GetContactRequest request =
   *       GetContactRequest.newBuilder()
   *           .setName(ContactName.of("[NETWORK_CODE]", "[CONTACT]").toString())
   *           .build();
   *   ApiFuture<Contact> future = contactServiceClient.getContactCallable().futureCall(request);
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
   * API to retrieve a list of `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Contact element : contactServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Contacts. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(NetworkName parent) {
    ListContactsRequest request =
        ListContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Contact element : contactServiceClient.listContacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Contacts. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContactsPagedResponse listContacts(String parent) {
    ListContactsRequest request = ListContactsRequest.newBuilder().setParent(parent).build();
    return listContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Contact element : contactServiceClient.listContacts(request).iterateAll()) {
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
   * API to retrieve a list of `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Contact> future =
   *       contactServiceClient.listContactsPagedCallable().futureCall(request);
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
   * API to retrieve a list of `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   ListContactsRequest request =
   *       ListContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListContactsResponse response = contactServiceClient.listContactsCallable().call(request);
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
   * API to create a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = contactServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Contact` will be created. Format:
   *     `networks/{network_code}`
   * @param contact Required. The `Contact` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(NetworkName parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContact(contact)
            .build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Contact contact = Contact.newBuilder().build();
   *   Contact response = contactServiceClient.createContact(parent, contact);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Contact` will be created. Format:
   *     `networks/{network_code}`
   * @param contact Required. The `Contact` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact createContact(String parent, Contact contact) {
    CreateContactRequest request =
        CreateContactRequest.newBuilder().setParent(parent).setContact(contact).build();
    return createContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   CreateContactRequest request =
   *       CreateContactRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setContact(Contact.newBuilder().build())
   *           .build();
   *   Contact response = contactServiceClient.createContact(request);
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
   * API to create a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   CreateContactRequest request =
   *       CreateContactRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setContact(Contact.newBuilder().build())
   *           .build();
   *   ApiFuture<Contact> future = contactServiceClient.createContactCallable().futureCall(request);
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
   * API to batch create `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateContactRequest> requests = new ArrayList<>();
   *   BatchCreateContactsResponse response =
   *       contactServiceClient.batchCreateContacts(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Contacts` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateContactRequest must match this
   *     field.
   * @param requests Required. The `Contact` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateContactsResponse batchCreateContacts(
      NetworkName parent, List<CreateContactRequest> requests) {
    BatchCreateContactsRequest request =
        BatchCreateContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateContactRequest> requests = new ArrayList<>();
   *   BatchCreateContactsResponse response =
   *       contactServiceClient.batchCreateContacts(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Contacts` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateContactRequest must match this
   *     field.
   * @param requests Required. The `Contact` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateContactsResponse batchCreateContacts(
      String parent, List<CreateContactRequest> requests) {
    BatchCreateContactsRequest request =
        BatchCreateContactsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   BatchCreateContactsRequest request =
   *       BatchCreateContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateContactRequest>())
   *           .build();
   *   BatchCreateContactsResponse response = contactServiceClient.batchCreateContacts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateContactsResponse batchCreateContacts(BatchCreateContactsRequest request) {
    return batchCreateContactsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   BatchCreateContactsRequest request =
   *       BatchCreateContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateContactRequest>())
   *           .build();
   *   ApiFuture<BatchCreateContactsResponse> future =
   *       contactServiceClient.batchCreateContactsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateContactsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateContactsRequest, BatchCreateContactsResponse>
      batchCreateContactsCallable() {
    return stub.batchCreateContactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   Contact contact = Contact.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Contact response = contactServiceClient.updateContact(contact, updateMask);
   * }
   * }</pre>
   *
   * @param contact Required. The `Contact` to update.
   *     <p>The `Contact`'s `name` is used to identify the `Contact` to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contact updateContact(Contact contact, FieldMask updateMask) {
    UpdateContactRequest request =
        UpdateContactRequest.newBuilder().setContact(contact).setUpdateMask(updateMask).build();
    return updateContact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   UpdateContactRequest request =
   *       UpdateContactRequest.newBuilder()
   *           .setContact(Contact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Contact response = contactServiceClient.updateContact(request);
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
   * API to update a `Contact` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   UpdateContactRequest request =
   *       UpdateContactRequest.newBuilder()
   *           .setContact(Contact.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Contact> future = contactServiceClient.updateContactCallable().futureCall(request);
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
   * API to batch update `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateContactRequest> requests = new ArrayList<>();
   *   BatchUpdateContactsResponse response =
   *       contactServiceClient.batchUpdateContacts(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Contacts` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateContactRequest must match this
   *     field.
   * @param requests Required. The `Contact` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateContactsResponse batchUpdateContacts(
      NetworkName parent, List<UpdateContactRequest> requests) {
    BatchUpdateContactsRequest request =
        BatchUpdateContactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateContactRequest> requests = new ArrayList<>();
   *   BatchUpdateContactsResponse response =
   *       contactServiceClient.batchUpdateContacts(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Contacts` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateContactRequest must match this
   *     field.
   * @param requests Required. The `Contact` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateContactsResponse batchUpdateContacts(
      String parent, List<UpdateContactRequest> requests) {
    BatchUpdateContactsRequest request =
        BatchUpdateContactsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateContacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   BatchUpdateContactsRequest request =
   *       BatchUpdateContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateContactRequest>())
   *           .build();
   *   BatchUpdateContactsResponse response = contactServiceClient.batchUpdateContacts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateContactsResponse batchUpdateContacts(BatchUpdateContactsRequest request) {
    return batchUpdateContactsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Contact` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
   *   BatchUpdateContactsRequest request =
   *       BatchUpdateContactsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateContactRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateContactsResponse> future =
   *       contactServiceClient.batchUpdateContactsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateContactsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateContactsRequest, BatchUpdateContactsResponse>
      batchUpdateContactsCallable() {
    return stub.batchUpdateContactsCallable();
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
}
