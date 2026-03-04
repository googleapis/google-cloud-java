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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.stub.PartnerLinkServiceStub;
import com.google.ads.datamanager.v1.stub.PartnerLinkServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing partner links.
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
 * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   PartnerLink partnerLink = PartnerLink.newBuilder().build();
 *   PartnerLink response = partnerLinkServiceClient.createPartnerLink(parent, partnerLink);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PartnerLinkServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePartnerLink</td>
 *      <td><p> Creates a partner link for the given account.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPartnerLink(CreatePartnerLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPartnerLink(AccountName parent, PartnerLink partnerLink)
 *           <li><p> createPartnerLink(String parent, PartnerLink partnerLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPartnerLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePartnerLink</td>
 *      <td><p> Deletes a partner link for the given account.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePartnerLink(DeletePartnerLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePartnerLink(PartnerLinkName name)
 *           <li><p> deletePartnerLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePartnerLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchPartnerLinks</td>
 *      <td><p> Searches for all partner links to and from a given account.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchPartnerLinks(SearchPartnerLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchPartnerLinks(AccountName parent)
 *           <li><p> searchPartnerLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchPartnerLinksPagedCallable()
 *           <li><p> searchPartnerLinksCallable()
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
 * <p>This class can be customized by passing in a custom instance of PartnerLinkServiceSettings to
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
 * PartnerLinkServiceSettings partnerLinkServiceSettings =
 *     PartnerLinkServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PartnerLinkServiceClient partnerLinkServiceClient =
 *     PartnerLinkServiceClient.create(partnerLinkServiceSettings);
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
 * PartnerLinkServiceSettings partnerLinkServiceSettings =
 *     PartnerLinkServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PartnerLinkServiceClient partnerLinkServiceClient =
 *     PartnerLinkServiceClient.create(partnerLinkServiceSettings);
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
 * PartnerLinkServiceSettings partnerLinkServiceSettings =
 *     PartnerLinkServiceSettings.newHttpJsonBuilder().build();
 * PartnerLinkServiceClient partnerLinkServiceClient =
 *     PartnerLinkServiceClient.create(partnerLinkServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PartnerLinkServiceClient implements BackgroundResource {
  private final PartnerLinkServiceSettings settings;
  private final PartnerLinkServiceStub stub;

  /** Constructs an instance of PartnerLinkServiceClient with default settings. */
  public static final PartnerLinkServiceClient create() throws IOException {
    return create(PartnerLinkServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PartnerLinkServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PartnerLinkServiceClient create(PartnerLinkServiceSettings settings)
      throws IOException {
    return new PartnerLinkServiceClient(settings);
  }

  /**
   * Constructs an instance of PartnerLinkServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PartnerLinkServiceSettings).
   */
  public static final PartnerLinkServiceClient create(PartnerLinkServiceStub stub) {
    return new PartnerLinkServiceClient(stub);
  }

  /**
   * Constructs an instance of PartnerLinkServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PartnerLinkServiceClient(PartnerLinkServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PartnerLinkServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PartnerLinkServiceClient(PartnerLinkServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PartnerLinkServiceSettings getSettings() {
    return settings;
  }

  public PartnerLinkServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   PartnerLink partnerLink = PartnerLink.newBuilder().build();
   *   PartnerLink response = partnerLinkServiceClient.createPartnerLink(parent, partnerLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of partner links. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @param partnerLink Required. The partner link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerLink createPartnerLink(AccountName parent, PartnerLink partnerLink) {
    CreatePartnerLinkRequest request =
        CreatePartnerLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPartnerLink(partnerLink)
            .build();
    return createPartnerLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   PartnerLink partnerLink = PartnerLink.newBuilder().build();
   *   PartnerLink response = partnerLinkServiceClient.createPartnerLink(parent, partnerLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of partner links. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @param partnerLink Required. The partner link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerLink createPartnerLink(String parent, PartnerLink partnerLink) {
    CreatePartnerLinkRequest request =
        CreatePartnerLinkRequest.newBuilder().setParent(parent).setPartnerLink(partnerLink).build();
    return createPartnerLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   CreatePartnerLinkRequest request =
   *       CreatePartnerLinkRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPartnerLink(PartnerLink.newBuilder().build())
   *           .build();
   *   PartnerLink response = partnerLinkServiceClient.createPartnerLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartnerLink createPartnerLink(CreatePartnerLinkRequest request) {
    return createPartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   CreatePartnerLinkRequest request =
   *       CreatePartnerLinkRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPartnerLink(PartnerLink.newBuilder().build())
   *           .build();
   *   ApiFuture<PartnerLink> future =
   *       partnerLinkServiceClient.createPartnerLinkCallable().futureCall(request);
   *   // Do something.
   *   PartnerLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePartnerLinkRequest, PartnerLink> createPartnerLinkCallable() {
    return stub.createPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   PartnerLinkName name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]");
   *   partnerLinkServiceClient.deletePartnerLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partner link to delete. Format:
   *     accountTypes/{account_type}/accounts/{account}/partnerLinks/{partner_link}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartnerLink(PartnerLinkName name) {
    DeletePartnerLinkRequest request =
        DeletePartnerLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePartnerLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   String name = PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString();
   *   partnerLinkServiceClient.deletePartnerLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the partner link to delete. Format:
   *     accountTypes/{account_type}/accounts/{account}/partnerLinks/{partner_link}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartnerLink(String name) {
    DeletePartnerLinkRequest request = DeletePartnerLinkRequest.newBuilder().setName(name).build();
    deletePartnerLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   DeletePartnerLinkRequest request =
   *       DeletePartnerLinkRequest.newBuilder()
   *           .setName(
   *               PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
   *           .build();
   *   partnerLinkServiceClient.deletePartnerLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePartnerLink(DeletePartnerLinkRequest request) {
    deletePartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a partner link for the given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   DeletePartnerLinkRequest request =
   *       DeletePartnerLinkRequest.newBuilder()
   *           .setName(
   *               PartnerLinkName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[PARTNER_LINK]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       partnerLinkServiceClient.deletePartnerLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePartnerLinkRequest, Empty> deletePartnerLinkCallable() {
    return stub.deletePartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for all partner links to and from a given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   for (PartnerLink element : partnerLinkServiceClient.searchPartnerLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Account to search for partner links. If no `filter` is specified, all
   *     partner links where this account is either the `owning_account` or `partner_account` are
   *     returned.
   *     <p>Format: `accountTypes/{account_type}/accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPartnerLinksPagedResponse searchPartnerLinks(AccountName parent) {
    SearchPartnerLinksRequest request =
        SearchPartnerLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchPartnerLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for all partner links to and from a given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   for (PartnerLink element : partnerLinkServiceClient.searchPartnerLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Account to search for partner links. If no `filter` is specified, all
   *     partner links where this account is either the `owning_account` or `partner_account` are
   *     returned.
   *     <p>Format: `accountTypes/{account_type}/accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPartnerLinksPagedResponse searchPartnerLinks(String parent) {
    SearchPartnerLinksRequest request =
        SearchPartnerLinksRequest.newBuilder().setParent(parent).build();
    return searchPartnerLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for all partner links to and from a given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   SearchPartnerLinksRequest request =
   *       SearchPartnerLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PartnerLink element :
   *       partnerLinkServiceClient.searchPartnerLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPartnerLinksPagedResponse searchPartnerLinks(
      SearchPartnerLinksRequest request) {
    return searchPartnerLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for all partner links to and from a given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   SearchPartnerLinksRequest request =
   *       SearchPartnerLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PartnerLink> future =
   *       partnerLinkServiceClient.searchPartnerLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PartnerLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksPagedResponse>
      searchPartnerLinksPagedCallable() {
    return stub.searchPartnerLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for all partner links to and from a given account.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
   *   SearchPartnerLinksRequest request =
   *       SearchPartnerLinksRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     SearchPartnerLinksResponse response =
   *         partnerLinkServiceClient.searchPartnerLinksCallable().call(request);
   *     for (PartnerLink element : response.getPartnerLinksList()) {
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
  public final UnaryCallable<SearchPartnerLinksRequest, SearchPartnerLinksResponse>
      searchPartnerLinksCallable() {
    return stub.searchPartnerLinksCallable();
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

  public static class SearchPartnerLinksPagedResponse
      extends AbstractPagedListResponse<
          SearchPartnerLinksRequest,
          SearchPartnerLinksResponse,
          PartnerLink,
          SearchPartnerLinksPage,
          SearchPartnerLinksFixedSizeCollection> {

    public static ApiFuture<SearchPartnerLinksPagedResponse> createAsync(
        PageContext<SearchPartnerLinksRequest, SearchPartnerLinksResponse, PartnerLink> context,
        ApiFuture<SearchPartnerLinksResponse> futureResponse) {
      ApiFuture<SearchPartnerLinksPage> futurePage =
          SearchPartnerLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchPartnerLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchPartnerLinksPagedResponse(SearchPartnerLinksPage page) {
      super(page, SearchPartnerLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchPartnerLinksPage
      extends AbstractPage<
          SearchPartnerLinksRequest,
          SearchPartnerLinksResponse,
          PartnerLink,
          SearchPartnerLinksPage> {

    private SearchPartnerLinksPage(
        PageContext<SearchPartnerLinksRequest, SearchPartnerLinksResponse, PartnerLink> context,
        SearchPartnerLinksResponse response) {
      super(context, response);
    }

    private static SearchPartnerLinksPage createEmptyPage() {
      return new SearchPartnerLinksPage(null, null);
    }

    @Override
    protected SearchPartnerLinksPage createPage(
        PageContext<SearchPartnerLinksRequest, SearchPartnerLinksResponse, PartnerLink> context,
        SearchPartnerLinksResponse response) {
      return new SearchPartnerLinksPage(context, response);
    }

    @Override
    public ApiFuture<SearchPartnerLinksPage> createPageAsync(
        PageContext<SearchPartnerLinksRequest, SearchPartnerLinksResponse, PartnerLink> context,
        ApiFuture<SearchPartnerLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchPartnerLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchPartnerLinksRequest,
          SearchPartnerLinksResponse,
          PartnerLink,
          SearchPartnerLinksPage,
          SearchPartnerLinksFixedSizeCollection> {

    private SearchPartnerLinksFixedSizeCollection(
        List<SearchPartnerLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchPartnerLinksFixedSizeCollection createEmptyCollection() {
      return new SearchPartnerLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchPartnerLinksFixedSizeCollection createCollection(
        List<SearchPartnerLinksPage> pages, int collectionSize) {
      return new SearchPartnerLinksFixedSizeCollection(pages, collectionSize);
    }
  }
}
