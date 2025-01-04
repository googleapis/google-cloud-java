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

package com.google.ads.marketingplatform.admin.v1alpha;

import com.google.ads.marketingplatform.admin.v1alpha.stub.MarketingplatformAdminServiceStub;
import com.google.ads.marketingplatform.admin.v1alpha.stub.MarketingplatformAdminServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
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
 * Service Description: Service Interface for the Google Marketing Platform Admin API.
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
 * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create()) {
 *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
 *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MarketingplatformAdminServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrganization</td>
 *      <td><p> Lookup for a single organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrganization(GetOrganizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrganization(OrganizationName name)
 *           <li><p> getOrganization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrganizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyticsAccountLinks</td>
 *      <td><p> Lists the Google Analytics accounts link to the specified Google Marketing Platform organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinks(ListAnalyticsAccountLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinks(OrganizationName parent)
 *           <li><p> listAnalyticsAccountLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalyticsAccountLinksPagedCallable()
 *           <li><p> listAnalyticsAccountLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnalyticsAccountLink</td>
 *      <td><p> Creates the link between the Analytics account and the Google Marketing Platform organization.
 * <p>  User needs to be an org user, and admin on the Analytics account to create the link. If the account is already linked to an organization, user needs to unlink the account from the current organization, then try link again.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLink(CreateAnalyticsAccountLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLink(OrganizationName parent, AnalyticsAccountLink analyticsAccountLink)
 *           <li><p> createAnalyticsAccountLink(String parent, AnalyticsAccountLink analyticsAccountLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnalyticsAccountLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnalyticsAccountLink</td>
 *      <td><p> Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google Marketing Platform organization.
 * <p>  User needs to be an org user, and admin on the Analytics account in order to delete the link.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLink(DeleteAnalyticsAccountLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLink(AnalyticsAccountLinkName name)
 *           <li><p> deleteAnalyticsAccountLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnalyticsAccountLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetPropertyServiceLevel</td>
 *      <td><p> Updates the service level for an Analytics property.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevel(SetPropertyServiceLevelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevel(String analyticsAccountLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setPropertyServiceLevelCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * MarketingplatformAdminServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
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
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
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
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
 *     MarketingplatformAdminServiceSettings.newHttpJsonBuilder().build();
 * MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
 *     MarketingplatformAdminServiceClient.create(marketingplatformAdminServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MarketingplatformAdminServiceClient implements BackgroundResource {
  private final MarketingplatformAdminServiceSettings settings;
  private final MarketingplatformAdminServiceStub stub;

  /** Constructs an instance of MarketingplatformAdminServiceClient with default settings. */
  public static final MarketingplatformAdminServiceClient create() throws IOException {
    return create(MarketingplatformAdminServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final MarketingplatformAdminServiceClient create(
      MarketingplatformAdminServiceSettings settings) throws IOException {
    return new MarketingplatformAdminServiceClient(settings);
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(MarketingplatformAdminServiceSettings).
   */
  public static final MarketingplatformAdminServiceClient create(
      MarketingplatformAdminServiceStub stub) {
    return new MarketingplatformAdminServiceClient(stub);
  }

  /**
   * Constructs an instance of MarketingplatformAdminServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MarketingplatformAdminServiceClient(MarketingplatformAdminServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((MarketingplatformAdminServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MarketingplatformAdminServiceClient(MarketingplatformAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MarketingplatformAdminServiceSettings getSettings() {
    return settings;
  }

  public MarketingplatformAdminServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Organization to retrieve. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(OrganizationName name) {
    GetOrganizationRequest request =
        GetOrganizationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name = OrganizationName.of("[ORGANIZATION]").toString();
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Organization to retrieve. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(String name) {
    GetOrganizationRequest request = GetOrganizationRequest.newBuilder().setName(name).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   Organization response = marketingplatformAdminServiceClient.getOrganization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(GetOrganizationRequest request) {
    return getOrganizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lookup for a single organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   ApiFuture<Organization> future =
   *       marketingplatformAdminServiceClient.getOrganizationCallable().futureCall(request);
   *   // Do something.
   *   Organization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return stub.getOrganizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Analytics
   *     account links. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(
      OrganizationName parent) {
    ListAnalyticsAccountLinksRequest request =
        ListAnalyticsAccountLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyticsAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent organization, which owns this collection of Analytics
   *     account links. Format: organizations/{org_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(String parent) {
    ListAnalyticsAccountLinksRequest request =
        ListAnalyticsAccountLinksRequest.newBuilder().setParent(parent).build();
    return listAnalyticsAccountLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AnalyticsAccountLink element :
   *       marketingplatformAdminServiceClient.listAnalyticsAccountLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyticsAccountLinksPagedResponse listAnalyticsAccountLinks(
      ListAnalyticsAccountLinksRequest request) {
    return listAnalyticsAccountLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AnalyticsAccountLink> future =
   *       marketingplatformAdminServiceClient
   *           .listAnalyticsAccountLinksPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AnalyticsAccountLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    return stub.listAnalyticsAccountLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Google Analytics accounts link to the specified Google Marketing Platform
   * organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   ListAnalyticsAccountLinksRequest request =
   *       ListAnalyticsAccountLinksRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAnalyticsAccountLinksResponse response =
   *         marketingplatformAdminServiceClient.listAnalyticsAccountLinksCallable().call(request);
   *     for (AnalyticsAccountLink element : response.getAnalyticsAccountLinksList()) {
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
  public final UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    return stub.listAnalyticsAccountLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(
   *           parent, analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Analytics account link will be created.
   *     Format: organizations/{org_id}
   * @param analyticsAccountLink Required. The Analytics account link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      OrganizationName parent, AnalyticsAccountLink analyticsAccountLink) {
    CreateAnalyticsAccountLinkRequest request =
        CreateAnalyticsAccountLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return createAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   AnalyticsAccountLink analyticsAccountLink = AnalyticsAccountLink.newBuilder().build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(
   *           parent, analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Analytics account link will be created.
   *     Format: organizations/{org_id}
   * @param analyticsAccountLink Required. The Analytics account link to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      String parent, AnalyticsAccountLink analyticsAccountLink) {
    CreateAnalyticsAccountLinkRequest request =
        CreateAnalyticsAccountLinkRequest.newBuilder()
            .setParent(parent)
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return createAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAnalyticsAccountLinkRequest request =
   *       CreateAnalyticsAccountLinkRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAnalyticsAccountLink(AnalyticsAccountLink.newBuilder().build())
   *           .build();
   *   AnalyticsAccountLink response =
   *       marketingplatformAdminServiceClient.createAnalyticsAccountLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyticsAccountLink createAnalyticsAccountLink(
      CreateAnalyticsAccountLinkRequest request) {
    return createAnalyticsAccountLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the link between the Analytics account and the Google Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account to create the link. If the
   * account is already linked to an organization, user needs to unlink the account from the current
   * organization, then try link again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   CreateAnalyticsAccountLinkRequest request =
   *       CreateAnalyticsAccountLinkRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setAnalyticsAccountLink(AnalyticsAccountLink.newBuilder().build())
   *           .build();
   *   ApiFuture<AnalyticsAccountLink> future =
   *       marketingplatformAdminServiceClient
   *           .createAnalyticsAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AnalyticsAccountLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    return stub.createAnalyticsAccountLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   AnalyticsAccountLinkName name =
   *       AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]");
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Analytics account link to delete. Format:
   *     organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(AnalyticsAccountLinkName name) {
    DeleteAnalyticsAccountLinkRequest request =
        DeleteAnalyticsAccountLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String name =
   *       AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]").toString();
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Analytics account link to delete. Format:
   *     organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(String name) {
    DeleteAnalyticsAccountLinkRequest request =
        DeleteAnalyticsAccountLinkRequest.newBuilder().setName(name).build();
    deleteAnalyticsAccountLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteAnalyticsAccountLinkRequest request =
   *       DeleteAnalyticsAccountLinkRequest.newBuilder()
   *           .setName(
   *               AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   marketingplatformAdminServiceClient.deleteAnalyticsAccountLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalyticsAccountLink(DeleteAnalyticsAccountLinkRequest request) {
    deleteAnalyticsAccountLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google
   * Marketing Platform organization.
   *
   * <p>User needs to be an org user, and admin on the Analytics account in order to delete the
   * link.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   DeleteAnalyticsAccountLinkRequest request =
   *       DeleteAnalyticsAccountLinkRequest.newBuilder()
   *           .setName(
   *               AnalyticsAccountLinkName.of("[ORGANIZATION]", "[ANALYTICS_ACCOUNT_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       marketingplatformAdminServiceClient
   *           .deleteAnalyticsAccountLinkCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    return stub.deleteAnalyticsAccountLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   String analyticsAccountLink = "analyticsAccountLink-397570975";
   *   SetPropertyServiceLevelResponse response =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevel(analyticsAccountLink);
   * }
   * }</pre>
   *
   * @param analyticsAccountLink Required. The parent AnalyticsAccountLink scope where this property
   *     is in. Format: organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetPropertyServiceLevelResponse setPropertyServiceLevel(
      String analyticsAccountLink) {
    SetPropertyServiceLevelRequest request =
        SetPropertyServiceLevelRequest.newBuilder()
            .setAnalyticsAccountLink(analyticsAccountLink)
            .build();
    return setPropertyServiceLevel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   SetPropertyServiceLevelRequest request =
   *       SetPropertyServiceLevelRequest.newBuilder()
   *           .setAnalyticsAccountLink("analyticsAccountLink-397570975")
   *           .setAnalyticsProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setServiceLevel(AnalyticsServiceLevel.forNumber(0))
   *           .build();
   *   SetPropertyServiceLevelResponse response =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetPropertyServiceLevelResponse setPropertyServiceLevel(
      SetPropertyServiceLevelRequest request) {
    return setPropertyServiceLevelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the service level for an Analytics property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MarketingplatformAdminServiceClient marketingplatformAdminServiceClient =
   *     MarketingplatformAdminServiceClient.create()) {
   *   SetPropertyServiceLevelRequest request =
   *       SetPropertyServiceLevelRequest.newBuilder()
   *           .setAnalyticsAccountLink("analyticsAccountLink-397570975")
   *           .setAnalyticsProperty(PropertyName.of("[PROPERTY]").toString())
   *           .setServiceLevel(AnalyticsServiceLevel.forNumber(0))
   *           .build();
   *   ApiFuture<SetPropertyServiceLevelResponse> future =
   *       marketingplatformAdminServiceClient.setPropertyServiceLevelCallable().futureCall(request);
   *   // Do something.
   *   SetPropertyServiceLevelResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    return stub.setPropertyServiceLevelCallable();
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

  public static class ListAnalyticsAccountLinksPagedResponse
      extends AbstractPagedListResponse<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage,
          ListAnalyticsAccountLinksFixedSizeCollection> {

    public static ApiFuture<ListAnalyticsAccountLinksPagedResponse> createAsync(
        PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ApiFuture<ListAnalyticsAccountLinksResponse> futureResponse) {
      ApiFuture<ListAnalyticsAccountLinksPage> futurePage =
          ListAnalyticsAccountLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalyticsAccountLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalyticsAccountLinksPagedResponse(ListAnalyticsAccountLinksPage page) {
      super(page, ListAnalyticsAccountLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalyticsAccountLinksPage
      extends AbstractPage<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage> {

    private ListAnalyticsAccountLinksPage(
        PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ListAnalyticsAccountLinksResponse response) {
      super(context, response);
    }

    private static ListAnalyticsAccountLinksPage createEmptyPage() {
      return new ListAnalyticsAccountLinksPage(null, null);
    }

    @Override
    protected ListAnalyticsAccountLinksPage createPage(
        PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ListAnalyticsAccountLinksResponse response) {
      return new ListAnalyticsAccountLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalyticsAccountLinksPage> createPageAsync(
        PageContext<
                ListAnalyticsAccountLinksRequest,
                ListAnalyticsAccountLinksResponse,
                AnalyticsAccountLink>
            context,
        ApiFuture<ListAnalyticsAccountLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalyticsAccountLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          AnalyticsAccountLink,
          ListAnalyticsAccountLinksPage,
          ListAnalyticsAccountLinksFixedSizeCollection> {

    private ListAnalyticsAccountLinksFixedSizeCollection(
        List<ListAnalyticsAccountLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalyticsAccountLinksFixedSizeCollection createEmptyCollection() {
      return new ListAnalyticsAccountLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalyticsAccountLinksFixedSizeCollection createCollection(
        List<ListAnalyticsAccountLinksPage> pages, int collectionSize) {
      return new ListAnalyticsAccountLinksFixedSizeCollection(pages, collectionSize);
    }
  }
}
