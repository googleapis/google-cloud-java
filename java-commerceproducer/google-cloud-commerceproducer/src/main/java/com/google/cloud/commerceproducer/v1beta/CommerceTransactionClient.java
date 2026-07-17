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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerceproducer.v1beta.stub.CommerceTransactionStub;
import com.google.cloud.commerceproducer.v1beta.stub.CommerceTransactionStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: APIs related to managing resources that model commercial transactions.
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
 * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
 *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
 *   Service response = commerceTransactionClient.getService(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CommerceTransactionClient object to clean up resources
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
 *      <td><p> ListServices</td>
 *      <td><p> Lists Services in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServices(ListServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServices(LocationName parent)
 *           <li><p> listServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServicesPagedCallable()
 *           <li><p> listServicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetService</td>
 *      <td><p> Gets details of a single Service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getService(GetServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getService(ServiceName name)
 *           <li><p> getService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateOffers</td>
 *      <td><p> Lists PrivateOffers for the given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateOffers(ListPrivateOffersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateOffers(LocationName parent)
 *           <li><p> listPrivateOffers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateOffersPagedCallable()
 *           <li><p> listPrivateOffersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPrivateOffer</td>
 *      <td><p> Gets details of a single PrivateOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateOffer(GetPrivateOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateOffer(PrivateOfferName name)
 *           <li><p> getPrivateOffer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateOffer</td>
 *      <td><p> Creates a new PrivateOffer in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateOffer(CreatePrivateOfferRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateOffer</td>
 *      <td><p> Updates the target PrivateOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateOffer(UpdatePrivateOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePrivateOffer(PrivateOffer privateOffer, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PublishPrivateOffer</td>
 *      <td><p> Publishes the target PrivateOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> publishPrivateOffer(PublishPrivateOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> publishPrivateOffer(PrivateOfferName name)
 *           <li><p> publishPrivateOffer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> publishPrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelPrivateOffer</td>
 *      <td><p> Cancels the target PrivateOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelPrivateOffer(CancelPrivateOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelPrivateOffer(PrivateOfferName name)
 *           <li><p> cancelPrivateOffer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelPrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePrivateOffer</td>
 *      <td><p> Deletes the target PrivateOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePrivateOffer(DeletePrivateOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePrivateOffer(PrivateOfferName name)
 *           <li><p> deletePrivateOffer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePrivateOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateOfferDocuments</td>
 *      <td><p> Lists PrivateOfferDocuments for the given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateOfferDocuments(ListPrivateOfferDocumentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateOfferDocuments(PrivateOfferName parent)
 *           <li><p> listPrivateOfferDocuments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateOfferDocumentsPagedCallable()
 *           <li><p> listPrivateOfferDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPrivateOfferDocument</td>
 *      <td><p> Gets details of a single PrivateOfferDocument.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateOfferDocument(GetPrivateOfferDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateOfferDocument(PrivateOfferDocumentName name)
 *           <li><p> getPrivateOfferDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateOfferDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateOfferDocument</td>
 *      <td><p> Creates a new PrivateOfferDocument in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateOfferDocument(CreatePrivateOfferDocumentRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateOfferDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateOfferDocument</td>
 *      <td><p> Updates the target PrivateOfferDocument.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateOfferDocument(UpdatePrivateOfferDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePrivateOfferDocument(PrivateOfferDocument privateOfferDocument, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateOfferDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePrivateOfferDocument</td>
 *      <td><p> Deletes the target PrivateOfferDocument.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePrivateOfferDocument(DeletePrivateOfferDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePrivateOfferDocument(PrivateOfferDocumentName name)
 *           <li><p> deletePrivateOfferDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePrivateOfferDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListStandardOffers</td>
 *      <td><p> Lists StandardOffers for the given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listStandardOffers(ListStandardOffersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listStandardOffers(ServiceName parent)
 *           <li><p> listStandardOffers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listStandardOffersPagedCallable()
 *           <li><p> listStandardOffersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStandardOffer</td>
 *      <td><p> Gets details of a single StandardOffer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStandardOffer(GetStandardOfferRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStandardOffer(StandardOfferName name)
 *           <li><p> getStandardOffer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStandardOfferCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSku</td>
 *      <td><p> Gets details of a single Sku.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSku(GetSkuRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSku(SkuName name)
 *           <li><p> getSku(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkuCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSkus</td>
 *      <td><p> Lists Skus for the given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSkus(ListSkusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSkus(ServiceName parent)
 *           <li><p> listSkus(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSkusPagedCallable()
 *           <li><p> listSkusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSkuGroup</td>
 *      <td><p> Gets details of a single SkuGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSkuGroup(GetSkuGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSkuGroup(SkuGroupName name)
 *           <li><p> getSkuGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkuGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSkuGroups</td>
 *      <td><p> Lists SkuGroups for the given parent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSkuGroups(ListSkuGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSkuGroups(LocationName parent)
 *           <li><p> listSkuGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSkuGroupsPagedCallable()
 *           <li><p> listSkuGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of CommerceTransactionSettings to
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
 * CommerceTransactionSettings commerceTransactionSettings =
 *     CommerceTransactionSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CommerceTransactionClient commerceTransactionClient =
 *     CommerceTransactionClient.create(commerceTransactionSettings);
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
 * CommerceTransactionSettings commerceTransactionSettings =
 *     CommerceTransactionSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CommerceTransactionClient commerceTransactionClient =
 *     CommerceTransactionClient.create(commerceTransactionSettings);
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
 * CommerceTransactionSettings commerceTransactionSettings =
 *     CommerceTransactionSettings.newHttpJsonBuilder().build();
 * CommerceTransactionClient commerceTransactionClient =
 *     CommerceTransactionClient.create(commerceTransactionSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class CommerceTransactionClient implements BackgroundResource {
  private final @Nullable CommerceTransactionSettings settings;
  private final CommerceTransactionStub stub;

  /** Constructs an instance of CommerceTransactionClient with default settings. */
  public static final CommerceTransactionClient create() throws IOException {
    return create(CommerceTransactionSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CommerceTransactionClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CommerceTransactionClient create(CommerceTransactionSettings settings)
      throws IOException {
    return new CommerceTransactionClient(settings);
  }

  /**
   * Constructs an instance of CommerceTransactionClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CommerceTransactionSettings).
   */
  public static final CommerceTransactionClient create(CommerceTransactionStub stub) {
    return new CommerceTransactionClient(stub);
  }

  /**
   * Constructs an instance of CommerceTransactionClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CommerceTransactionClient(CommerceTransactionSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CommerceTransactionStubSettings) settings.getStubSettings()).createStub();
  }

  protected CommerceTransactionClient(CommerceTransactionStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CommerceTransactionSettings getSettings() {
    return settings;
  }

  public CommerceTransactionStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Service element : commerceTransactionClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListServicesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(@Nullable LocationName parent) {
    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Service element : commerceTransactionClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListServicesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(String parent) {
    ListServicesRequest request = ListServicesRequest.newBuilder().setParent(parent).build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Service element : commerceTransactionClient.listServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(ListServicesRequest request) {
    return listServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Service> future =
   *       commerceTransactionClient.listServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Service element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable() {
    return stub.listServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response =
   *         commerceTransactionClient.listServicesCallable().call(request);
   *     for (Service element : response.getServicesList()) {
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
  public final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return stub.listServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   Service response = commerceTransactionClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(@Nullable ServiceName name) {
    GetServiceRequest request =
        GetServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   Service response = commerceTransactionClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(String name) {
    GetServiceRequest request = GetServiceRequest.newBuilder().setName(name).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setView(ServiceView.forNumber(0))
   *           .build();
   *   Service response = commerceTransactionClient.getService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(GetServiceRequest request) {
    return getServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setView(ServiceView.forNumber(0))
   *           .build();
   *   ApiFuture<Service> future =
   *       commerceTransactionClient.getServiceCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PrivateOffer element :
   *       commerceTransactionClient.listPrivateOffers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPrivateOffersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOffersPagedResponse listPrivateOffers(@Nullable LocationName parent) {
    ListPrivateOffersRequest request =
        ListPrivateOffersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateOffers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PrivateOffer element :
   *       commerceTransactionClient.listPrivateOffers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPrivateOffersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOffersPagedResponse listPrivateOffers(String parent) {
    ListPrivateOffersRequest request =
        ListPrivateOffersRequest.newBuilder().setParent(parent).build();
    return listPrivateOffers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOffersRequest request =
   *       ListPrivateOffersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PrivateOffer element :
   *       commerceTransactionClient.listPrivateOffers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOffersPagedResponse listPrivateOffers(ListPrivateOffersRequest request) {
    return listPrivateOffersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOffersRequest request =
   *       ListPrivateOffersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.listPrivateOffersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateOffer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersPagedResponse>
      listPrivateOffersPagedCallable() {
    return stub.listPrivateOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOffersRequest request =
   *       ListPrivateOffersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPrivateOffersResponse response =
   *         commerceTransactionClient.listPrivateOffersCallable().call(request);
   *     for (PrivateOffer element : response.getPrivateOffersList()) {
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
  public final UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersCallable() {
    return stub.listPrivateOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
   *   PrivateOffer response = commerceTransactionClient.getPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer getPrivateOffer(@Nullable PrivateOfferName name) {
    GetPrivateOfferRequest request =
        GetPrivateOfferRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString();
   *   PrivateOffer response = commerceTransactionClient.getPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer getPrivateOffer(String name) {
    GetPrivateOfferRequest request = GetPrivateOfferRequest.newBuilder().setName(name).build();
    return getPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetPrivateOfferRequest request =
   *       GetPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setView(PrivateOfferView.forNumber(0))
   *           .build();
   *   PrivateOffer response = commerceTransactionClient.getPrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer getPrivateOffer(GetPrivateOfferRequest request) {
    return getPrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetPrivateOfferRequest request =
   *       GetPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setView(PrivateOfferView.forNumber(0))
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.getPrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   PrivateOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferCallable() {
    return stub.getPrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PrivateOffer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CreatePrivateOfferRequest request =
   *       CreatePrivateOfferRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateOffer(PrivateOffer.newBuilder().build())
   *           .build();
   *   PrivateOffer response = commerceTransactionClient.createPrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer createPrivateOffer(CreatePrivateOfferRequest request) {
    return createPrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PrivateOffer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CreatePrivateOfferRequest request =
   *       CreatePrivateOfferRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateOffer(PrivateOffer.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.createPrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   PrivateOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferCallable() {
    return stub.createPrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOffer privateOffer = PrivateOffer.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateOffer response =
   *       commerceTransactionClient.updatePrivateOffer(privateOffer, updateMask);
   * }
   * }</pre>
   *
   * @param privateOffer Required. The resource being updated
   * @param updateMask Optional. The list of fields to update. The fields specified in the
   *     update_mask are relative to the resource, not the full request. A field will be overwritten
   *     if it is in the mask. The special value "&#42;" means full replacement. If unspecified, all
   *     fields present in the request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer updatePrivateOffer(PrivateOffer privateOffer, FieldMask updateMask) {
    UpdatePrivateOfferRequest request =
        UpdatePrivateOfferRequest.newBuilder()
            .setPrivateOffer(privateOffer)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   UpdatePrivateOfferRequest request =
   *       UpdatePrivateOfferRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPrivateOffer(PrivateOffer.newBuilder().build())
   *           .build();
   *   PrivateOffer response = commerceTransactionClient.updatePrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer updatePrivateOffer(UpdatePrivateOfferRequest request) {
    return updatePrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   UpdatePrivateOfferRequest request =
   *       UpdatePrivateOfferRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPrivateOffer(PrivateOffer.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.updatePrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   PrivateOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferCallable() {
    return stub.updatePrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Publishes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
   *   PrivateOffer response = commerceTransactionClient.publishPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer publishPrivateOffer(@Nullable PrivateOfferName name) {
    PublishPrivateOfferRequest request =
        PublishPrivateOfferRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return publishPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Publishes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString();
   *   PrivateOffer response = commerceTransactionClient.publishPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer publishPrivateOffer(String name) {
    PublishPrivateOfferRequest request =
        PublishPrivateOfferRequest.newBuilder().setName(name).build();
    return publishPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Publishes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PublishPrivateOfferRequest request =
   *       PublishPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   PrivateOffer response = commerceTransactionClient.publishPrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer publishPrivateOffer(PublishPrivateOfferRequest request) {
    return publishPrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Publishes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PublishPrivateOfferRequest request =
   *       PublishPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.publishPrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   PrivateOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PublishPrivateOfferRequest, PrivateOffer>
      publishPrivateOfferCallable() {
    return stub.publishPrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
   *   PrivateOffer response = commerceTransactionClient.cancelPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer cancelPrivateOffer(@Nullable PrivateOfferName name) {
    CancelPrivateOfferRequest request =
        CancelPrivateOfferRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return cancelPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString();
   *   PrivateOffer response = commerceTransactionClient.cancelPrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer cancelPrivateOffer(String name) {
    CancelPrivateOfferRequest request =
        CancelPrivateOfferRequest.newBuilder().setName(name).build();
    return cancelPrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CancelPrivateOfferRequest request =
   *       CancelPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setCancellationNote("cancellationNote806581141")
   *           .build();
   *   PrivateOffer response = commerceTransactionClient.cancelPrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOffer cancelPrivateOffer(CancelPrivateOfferRequest request) {
    return cancelPrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CancelPrivateOfferRequest request =
   *       CancelPrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setCancellationNote("cancellationNote806581141")
   *           .build();
   *   ApiFuture<PrivateOffer> future =
   *       commerceTransactionClient.cancelPrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   PrivateOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferCallable() {
    return stub.cancelPrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferName name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
   *   commerceTransactionClient.deletePrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOffer(@Nullable PrivateOfferName name) {
    DeletePrivateOfferRequest request =
        DeletePrivateOfferRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString();
   *   commerceTransactionClient.deletePrivateOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOffer(String name) {
    DeletePrivateOfferRequest request =
        DeletePrivateOfferRequest.newBuilder().setName(name).build();
    deletePrivateOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   DeletePrivateOfferRequest request =
   *       DeletePrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setForce(true)
   *           .build();
   *   commerceTransactionClient.deletePrivateOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOffer(DeletePrivateOfferRequest request) {
    deletePrivateOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   DeletePrivateOfferRequest request =
   *       DeletePrivateOfferRequest.newBuilder()
   *           .setName(PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       commerceTransactionClient.deletePrivateOfferCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateOfferRequest, Empty> deletePrivateOfferCallable() {
    return stub.deletePrivateOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOfferDocuments for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferName parent = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]");
   *   for (PrivateOfferDocument element :
   *       commerceTransactionClient.listPrivateOfferDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPrivateOfferDocumentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOfferDocumentsPagedResponse listPrivateOfferDocuments(
      @Nullable PrivateOfferName parent) {
    ListPrivateOfferDocumentsRequest request =
        ListPrivateOfferDocumentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateOfferDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOfferDocuments for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString();
   *   for (PrivateOfferDocument element :
   *       commerceTransactionClient.listPrivateOfferDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPrivateOfferDocumentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOfferDocumentsPagedResponse listPrivateOfferDocuments(String parent) {
    ListPrivateOfferDocumentsRequest request =
        ListPrivateOfferDocumentsRequest.newBuilder().setParent(parent).build();
    return listPrivateOfferDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOfferDocuments for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOfferDocumentsRequest request =
   *       ListPrivateOfferDocumentsRequest.newBuilder()
   *           .setParent(
   *               PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PrivateOfferDocument element :
   *       commerceTransactionClient.listPrivateOfferDocuments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateOfferDocumentsPagedResponse listPrivateOfferDocuments(
      ListPrivateOfferDocumentsRequest request) {
    return listPrivateOfferDocumentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOfferDocuments for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOfferDocumentsRequest request =
   *       ListPrivateOfferDocumentsRequest.newBuilder()
   *           .setParent(
   *               PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PrivateOfferDocument> future =
   *       commerceTransactionClient.listPrivateOfferDocumentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateOfferDocument element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsPagedCallable() {
    return stub.listPrivateOfferDocumentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PrivateOfferDocuments for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListPrivateOfferDocumentsRequest request =
   *       ListPrivateOfferDocumentsRequest.newBuilder()
   *           .setParent(
   *               PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPrivateOfferDocumentsResponse response =
   *         commerceTransactionClient.listPrivateOfferDocumentsCallable().call(request);
   *     for (PrivateOfferDocument element : response.getPrivateOfferDocumentsList()) {
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
  public final UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsCallable() {
    return stub.listPrivateOfferDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferDocumentName name =
   *       PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");
   *   PrivateOfferDocument response = commerceTransactionClient.getPrivateOfferDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument getPrivateOfferDocument(
      @Nullable PrivateOfferDocumentName name) {
    GetPrivateOfferDocumentRequest request =
        GetPrivateOfferDocumentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrivateOfferDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name =
   *       PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *           .toString();
   *   PrivateOfferDocument response = commerceTransactionClient.getPrivateOfferDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument getPrivateOfferDocument(String name) {
    GetPrivateOfferDocumentRequest request =
        GetPrivateOfferDocumentRequest.newBuilder().setName(name).build();
    return getPrivateOfferDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetPrivateOfferDocumentRequest request =
   *       GetPrivateOfferDocumentRequest.newBuilder()
   *           .setName(
   *               PrivateOfferDocumentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   PrivateOfferDocument response = commerceTransactionClient.getPrivateOfferDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument getPrivateOfferDocument(
      GetPrivateOfferDocumentRequest request) {
    return getPrivateOfferDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetPrivateOfferDocumentRequest request =
   *       GetPrivateOfferDocumentRequest.newBuilder()
   *           .setName(
   *               PrivateOfferDocumentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PrivateOfferDocument> future =
   *       commerceTransactionClient.getPrivateOfferDocumentCallable().futureCall(request);
   *   // Do something.
   *   PrivateOfferDocument response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentCallable() {
    return stub.getPrivateOfferDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PrivateOfferDocument in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CreatePrivateOfferDocumentRequest request =
   *       CreatePrivateOfferDocumentRequest.newBuilder()
   *           .setParent(
   *               PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
   *           .build();
   *   PrivateOfferDocument response = commerceTransactionClient.createPrivateOfferDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument createPrivateOfferDocument(
      CreatePrivateOfferDocumentRequest request) {
    return createPrivateOfferDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PrivateOfferDocument in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   CreatePrivateOfferDocumentRequest request =
   *       CreatePrivateOfferDocumentRequest.newBuilder()
   *           .setParent(
   *               PrivateOfferName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]").toString())
   *           .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateOfferDocument> future =
   *       commerceTransactionClient.createPrivateOfferDocumentCallable().futureCall(request);
   *   // Do something.
   *   PrivateOfferDocument response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentCallable() {
    return stub.createPrivateOfferDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferDocument privateOfferDocument = PrivateOfferDocument.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateOfferDocument response =
   *       commerceTransactionClient.updatePrivateOfferDocument(privateOfferDocument, updateMask);
   * }
   * }</pre>
   *
   * @param privateOfferDocument Required. The resource being updated.
   * @param updateMask Optional. The list of fields to update. The fields specified in the
   *     update_mask are relative to the resource, not the full request. A field will be overwritten
   *     if it is in the mask. The special value "&#42;" means full replacement. If unspecified, all
   *     fields present in the request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument updatePrivateOfferDocument(
      PrivateOfferDocument privateOfferDocument, FieldMask updateMask) {
    UpdatePrivateOfferDocumentRequest request =
        UpdatePrivateOfferDocumentRequest.newBuilder()
            .setPrivateOfferDocument(privateOfferDocument)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateOfferDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   UpdatePrivateOfferDocumentRequest request =
   *       UpdatePrivateOfferDocumentRequest.newBuilder()
   *           .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PrivateOfferDocument response = commerceTransactionClient.updatePrivateOfferDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateOfferDocument updatePrivateOfferDocument(
      UpdatePrivateOfferDocumentRequest request) {
    return updatePrivateOfferDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   UpdatePrivateOfferDocumentRequest request =
   *       UpdatePrivateOfferDocumentRequest.newBuilder()
   *           .setPrivateOfferDocument(PrivateOfferDocument.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateOfferDocument> future =
   *       commerceTransactionClient.updatePrivateOfferDocumentCallable().futureCall(request);
   *   // Do something.
   *   PrivateOfferDocument response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentCallable() {
    return stub.updatePrivateOfferDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   PrivateOfferDocumentName name =
   *       PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]");
   *   commerceTransactionClient.deletePrivateOfferDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOfferDocument(@Nullable PrivateOfferDocumentName name) {
    DeletePrivateOfferDocumentRequest request =
        DeletePrivateOfferDocumentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePrivateOfferDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name =
   *       PrivateOfferDocumentName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *           .toString();
   *   commerceTransactionClient.deletePrivateOfferDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOfferDocument(String name) {
    DeletePrivateOfferDocumentRequest request =
        DeletePrivateOfferDocumentRequest.newBuilder().setName(name).build();
    deletePrivateOfferDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   DeletePrivateOfferDocumentRequest request =
   *       DeletePrivateOfferDocumentRequest.newBuilder()
   *           .setName(
   *               PrivateOfferDocumentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   commerceTransactionClient.deletePrivateOfferDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePrivateOfferDocument(DeletePrivateOfferDocumentRequest request) {
    deletePrivateOfferDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the target PrivateOfferDocument.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   DeletePrivateOfferDocumentRequest request =
   *       DeletePrivateOfferDocumentRequest.newBuilder()
   *           .setName(
   *               PrivateOfferDocumentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_OFFER]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       commerceTransactionClient.deletePrivateOfferDocumentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentCallable() {
    return stub.deletePrivateOfferDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StandardOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (StandardOffer element :
   *       commerceTransactionClient.listStandardOffers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListStandardOffersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStandardOffersPagedResponse listStandardOffers(@Nullable ServiceName parent) {
    ListStandardOffersRequest request =
        ListStandardOffersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStandardOffers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StandardOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   for (StandardOffer element :
   *       commerceTransactionClient.listStandardOffers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListStandardOffersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStandardOffersPagedResponse listStandardOffers(String parent) {
    ListStandardOffersRequest request =
        ListStandardOffersRequest.newBuilder().setParent(parent).build();
    return listStandardOffers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StandardOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListStandardOffersRequest request =
   *       ListStandardOffersRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (StandardOffer element :
   *       commerceTransactionClient.listStandardOffers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStandardOffersPagedResponse listStandardOffers(
      ListStandardOffersRequest request) {
    return listStandardOffersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StandardOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListStandardOffersRequest request =
   *       ListStandardOffersRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<StandardOffer> future =
   *       commerceTransactionClient.listStandardOffersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StandardOffer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStandardOffersRequest, ListStandardOffersPagedResponse>
      listStandardOffersPagedCallable() {
    return stub.listStandardOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists StandardOffers for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListStandardOffersRequest request =
   *       ListStandardOffersRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListStandardOffersResponse response =
   *         commerceTransactionClient.listStandardOffersCallable().call(request);
   *     for (StandardOffer element : response.getStandardOffersList()) {
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
  public final UnaryCallable<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersCallable() {
    return stub.listStandardOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single StandardOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   StandardOfferName name =
   *       StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]");
   *   StandardOffer response = commerceTransactionClient.getStandardOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StandardOffer getStandardOffer(@Nullable StandardOfferName name) {
    GetStandardOfferRequest request =
        GetStandardOfferRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStandardOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single StandardOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name =
   *       StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]")
   *           .toString();
   *   StandardOffer response = commerceTransactionClient.getStandardOffer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StandardOffer getStandardOffer(String name) {
    GetStandardOfferRequest request = GetStandardOfferRequest.newBuilder().setName(name).build();
    return getStandardOffer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single StandardOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetStandardOfferRequest request =
   *       GetStandardOfferRequest.newBuilder()
   *           .setName(
   *               StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]")
   *                   .toString())
   *           .setView(StandardOfferView.forNumber(0))
   *           .build();
   *   StandardOffer response = commerceTransactionClient.getStandardOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StandardOffer getStandardOffer(GetStandardOfferRequest request) {
    return getStandardOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single StandardOffer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetStandardOfferRequest request =
   *       GetStandardOfferRequest.newBuilder()
   *           .setName(
   *               StandardOfferName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[STANDARD_OFFER]")
   *                   .toString())
   *           .setView(StandardOfferView.forNumber(0))
   *           .build();
   *   ApiFuture<StandardOffer> future =
   *       commerceTransactionClient.getStandardOfferCallable().futureCall(request);
   *   // Do something.
   *   StandardOffer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStandardOfferRequest, StandardOffer> getStandardOfferCallable() {
    return stub.getStandardOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Sku.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]");
   *   Sku response = commerceTransactionClient.getSku(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(@Nullable SkuName name) {
    GetSkuRequest request =
        GetSkuRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSku(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Sku.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]").toString();
   *   Sku response = commerceTransactionClient.getSku(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(String name) {
    GetSkuRequest request = GetSkuRequest.newBuilder().setName(name).build();
    return getSku(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Sku.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetSkuRequest request =
   *       GetSkuRequest.newBuilder()
   *           .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]").toString())
   *           .build();
   *   Sku response = commerceTransactionClient.getSku(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(GetSkuRequest request) {
    return getSkuCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Sku.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetSkuRequest request =
   *       GetSkuRequest.newBuilder()
   *           .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[SKU]").toString())
   *           .build();
   *   ApiFuture<Sku> future = commerceTransactionClient.getSkuCallable().futureCall(request);
   *   // Do something.
   *   Sku response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    return stub.getSkuCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Skus for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (Sku element : commerceTransactionClient.listSkus(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkusRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(@Nullable ServiceName parent) {
    ListSkusRequest request =
        ListSkusRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSkus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Skus for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   for (Sku element : commerceTransactionClient.listSkus(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkusRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(String parent) {
    ListSkusRequest request = ListSkusRequest.newBuilder().setParent(parent).build();
    return listSkus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Skus for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Sku element : commerceTransactionClient.listSkus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(ListSkusRequest request) {
    return listSkusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Skus for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Sku> future = commerceTransactionClient.listSkusPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Sku element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return stub.listSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Skus for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSkusResponse response = commerceTransactionClient.listSkusCallable().call(request);
   *     for (Sku element : response.getSkusList()) {
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
  public final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return stub.listSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SkuGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   SkuGroupName name = SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]");
   *   SkuGroup response = commerceTransactionClient.getSkuGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkuGroup getSkuGroup(@Nullable SkuGroupName name) {
    GetSkuGroupRequest request =
        GetSkuGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSkuGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SkuGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String name = SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]").toString();
   *   SkuGroup response = commerceTransactionClient.getSkuGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkuGroup getSkuGroup(String name) {
    GetSkuGroupRequest request = GetSkuGroupRequest.newBuilder().setName(name).build();
    return getSkuGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SkuGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetSkuGroupRequest request =
   *       GetSkuGroupRequest.newBuilder()
   *           .setName(SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]").toString())
   *           .build();
   *   SkuGroup response = commerceTransactionClient.getSkuGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkuGroup getSkuGroup(GetSkuGroupRequest request) {
    return getSkuGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single SkuGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetSkuGroupRequest request =
   *       GetSkuGroupRequest.newBuilder()
   *           .setName(SkuGroupName.of("[PROJECT]", "[LOCATION]", "[SKU_GROUP]").toString())
   *           .build();
   *   ApiFuture<SkuGroup> future =
   *       commerceTransactionClient.getSkuGroupCallable().futureCall(request);
   *   // Do something.
   *   SkuGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkuGroupRequest, SkuGroup> getSkuGroupCallable() {
    return stub.getSkuGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SkuGroups for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SkuGroup element : commerceTransactionClient.listSkuGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkuGroupsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkuGroupsPagedResponse listSkuGroups(@Nullable LocationName parent) {
    ListSkuGroupsRequest request =
        ListSkuGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSkuGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SkuGroups for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SkuGroup element : commerceTransactionClient.listSkuGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkuGroupsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkuGroupsPagedResponse listSkuGroups(String parent) {
    ListSkuGroupsRequest request = ListSkuGroupsRequest.newBuilder().setParent(parent).build();
    return listSkuGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SkuGroups for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkuGroupsRequest request =
   *       ListSkuGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SkuGroup element : commerceTransactionClient.listSkuGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkuGroupsPagedResponse listSkuGroups(ListSkuGroupsRequest request) {
    return listSkuGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SkuGroups for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkuGroupsRequest request =
   *       ListSkuGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SkuGroup> future =
   *       commerceTransactionClient.listSkuGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SkuGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsPagedResponse>
      listSkuGroupsPagedCallable() {
    return stub.listSkuGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SkuGroups for the given parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListSkuGroupsRequest request =
   *       ListSkuGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSkuGroupsResponse response =
   *         commerceTransactionClient.listSkuGroupsCallable().call(request);
   *     for (SkuGroup element : response.getSkuGroupsList()) {
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
  public final UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsResponse> listSkuGroupsCallable() {
    return stub.listSkuGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : commerceTransactionClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       commerceTransactionClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         commerceTransactionClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = commerceTransactionClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       commerceTransactionClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListServicesPagedResponse
      extends AbstractPagedListResponse<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    public static ApiFuture<ListServicesPagedResponse> createAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      ApiFuture<ListServicesPage> futurePage =
          ListServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServicesPagedResponse(ListServicesPage page) {
      super(page, ListServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServicesPage
      extends AbstractPage<ListServicesRequest, ListServicesResponse, Service, ListServicesPage> {

    private ListServicesPage(
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        @Nullable ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        @Nullable ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    private ListServicesFixedSizeCollection(
        @Nullable List<ListServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServicesFixedSizeCollection createEmptyCollection() {
      return new ListServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServicesFixedSizeCollection createCollection(
        @Nullable List<ListServicesPage> pages, int collectionSize) {
      return new ListServicesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPrivateOffersPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateOffersRequest,
          ListPrivateOffersResponse,
          PrivateOffer,
          ListPrivateOffersPage,
          ListPrivateOffersFixedSizeCollection> {

    public static ApiFuture<ListPrivateOffersPagedResponse> createAsync(
        PageContext<ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer> context,
        ApiFuture<ListPrivateOffersResponse> futureResponse) {
      ApiFuture<ListPrivateOffersPage> futurePage =
          ListPrivateOffersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateOffersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateOffersPagedResponse(ListPrivateOffersPage page) {
      super(page, ListPrivateOffersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateOffersPage
      extends AbstractPage<
          ListPrivateOffersRequest,
          ListPrivateOffersResponse,
          PrivateOffer,
          ListPrivateOffersPage> {

    private ListPrivateOffersPage(
        @Nullable PageContext<ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>
            context,
        @Nullable ListPrivateOffersResponse response) {
      super(context, response);
    }

    private static ListPrivateOffersPage createEmptyPage() {
      return new ListPrivateOffersPage(null, null);
    }

    @Override
    protected ListPrivateOffersPage createPage(
        @Nullable PageContext<ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>
            context,
        @Nullable ListPrivateOffersResponse response) {
      return new ListPrivateOffersPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateOffersPage> createPageAsync(
        @Nullable PageContext<ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>
            context,
        ApiFuture<ListPrivateOffersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateOffersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateOffersRequest,
          ListPrivateOffersResponse,
          PrivateOffer,
          ListPrivateOffersPage,
          ListPrivateOffersFixedSizeCollection> {

    private ListPrivateOffersFixedSizeCollection(
        @Nullable List<ListPrivateOffersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateOffersFixedSizeCollection createEmptyCollection() {
      return new ListPrivateOffersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateOffersFixedSizeCollection createCollection(
        @Nullable List<ListPrivateOffersPage> pages, int collectionSize) {
      return new ListPrivateOffersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPrivateOfferDocumentsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          PrivateOfferDocument,
          ListPrivateOfferDocumentsPage,
          ListPrivateOfferDocumentsFixedSizeCollection> {

    public static ApiFuture<ListPrivateOfferDocumentsPagedResponse> createAsync(
        PageContext<
                ListPrivateOfferDocumentsRequest,
                ListPrivateOfferDocumentsResponse,
                PrivateOfferDocument>
            context,
        ApiFuture<ListPrivateOfferDocumentsResponse> futureResponse) {
      ApiFuture<ListPrivateOfferDocumentsPage> futurePage =
          ListPrivateOfferDocumentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateOfferDocumentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateOfferDocumentsPagedResponse(ListPrivateOfferDocumentsPage page) {
      super(page, ListPrivateOfferDocumentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateOfferDocumentsPage
      extends AbstractPage<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          PrivateOfferDocument,
          ListPrivateOfferDocumentsPage> {

    private ListPrivateOfferDocumentsPage(
        @Nullable
            PageContext<
                ListPrivateOfferDocumentsRequest,
                ListPrivateOfferDocumentsResponse,
                PrivateOfferDocument>
            context,
        @Nullable ListPrivateOfferDocumentsResponse response) {
      super(context, response);
    }

    private static ListPrivateOfferDocumentsPage createEmptyPage() {
      return new ListPrivateOfferDocumentsPage(null, null);
    }

    @Override
    protected ListPrivateOfferDocumentsPage createPage(
        @Nullable
            PageContext<
                ListPrivateOfferDocumentsRequest,
                ListPrivateOfferDocumentsResponse,
                PrivateOfferDocument>
            context,
        @Nullable ListPrivateOfferDocumentsResponse response) {
      return new ListPrivateOfferDocumentsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateOfferDocumentsPage> createPageAsync(
        @Nullable
            PageContext<
                ListPrivateOfferDocumentsRequest,
                ListPrivateOfferDocumentsResponse,
                PrivateOfferDocument>
            context,
        ApiFuture<ListPrivateOfferDocumentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateOfferDocumentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          PrivateOfferDocument,
          ListPrivateOfferDocumentsPage,
          ListPrivateOfferDocumentsFixedSizeCollection> {

    private ListPrivateOfferDocumentsFixedSizeCollection(
        @Nullable List<ListPrivateOfferDocumentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateOfferDocumentsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateOfferDocumentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateOfferDocumentsFixedSizeCollection createCollection(
        @Nullable List<ListPrivateOfferDocumentsPage> pages, int collectionSize) {
      return new ListPrivateOfferDocumentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListStandardOffersPagedResponse
      extends AbstractPagedListResponse<
          ListStandardOffersRequest,
          ListStandardOffersResponse,
          StandardOffer,
          ListStandardOffersPage,
          ListStandardOffersFixedSizeCollection> {

    public static ApiFuture<ListStandardOffersPagedResponse> createAsync(
        PageContext<ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer> context,
        ApiFuture<ListStandardOffersResponse> futureResponse) {
      ApiFuture<ListStandardOffersPage> futurePage =
          ListStandardOffersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListStandardOffersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListStandardOffersPagedResponse(ListStandardOffersPage page) {
      super(page, ListStandardOffersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStandardOffersPage
      extends AbstractPage<
          ListStandardOffersRequest,
          ListStandardOffersResponse,
          StandardOffer,
          ListStandardOffersPage> {

    private ListStandardOffersPage(
        @Nullable PageContext<ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>
            context,
        @Nullable ListStandardOffersResponse response) {
      super(context, response);
    }

    private static ListStandardOffersPage createEmptyPage() {
      return new ListStandardOffersPage(null, null);
    }

    @Override
    protected ListStandardOffersPage createPage(
        @Nullable PageContext<ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>
            context,
        @Nullable ListStandardOffersResponse response) {
      return new ListStandardOffersPage(context, response);
    }

    @Override
    public ApiFuture<ListStandardOffersPage> createPageAsync(
        @Nullable PageContext<ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>
            context,
        ApiFuture<ListStandardOffersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStandardOffersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStandardOffersRequest,
          ListStandardOffersResponse,
          StandardOffer,
          ListStandardOffersPage,
          ListStandardOffersFixedSizeCollection> {

    private ListStandardOffersFixedSizeCollection(
        @Nullable List<ListStandardOffersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStandardOffersFixedSizeCollection createEmptyCollection() {
      return new ListStandardOffersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStandardOffersFixedSizeCollection createCollection(
        @Nullable List<ListStandardOffersPage> pages, int collectionSize) {
      return new ListStandardOffersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkusPagedResponse
      extends AbstractPagedListResponse<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    public static ApiFuture<ListSkusPagedResponse> createAsync(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      ApiFuture<ListSkusPage> futurePage =
          ListSkusPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSkusPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSkusPagedResponse(ListSkusPage page) {
      super(page, ListSkusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkusPage
      extends AbstractPage<ListSkusRequest, ListSkusResponse, Sku, ListSkusPage> {

    private ListSkusPage(
        @Nullable PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        @Nullable ListSkusResponse response) {
      super(context, response);
    }

    private static ListSkusPage createEmptyPage() {
      return new ListSkusPage(null, null);
    }

    @Override
    protected ListSkusPage createPage(
        @Nullable PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        @Nullable ListSkusResponse response) {
      return new ListSkusPage(context, response);
    }

    @Override
    public ApiFuture<ListSkusPage> createPageAsync(
        @Nullable PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    private ListSkusFixedSizeCollection(@Nullable List<ListSkusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkusFixedSizeCollection createEmptyCollection() {
      return new ListSkusFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkusFixedSizeCollection createCollection(
        @Nullable List<ListSkusPage> pages, int collectionSize) {
      return new ListSkusFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkuGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListSkuGroupsRequest,
          ListSkuGroupsResponse,
          SkuGroup,
          ListSkuGroupsPage,
          ListSkuGroupsFixedSizeCollection> {

    public static ApiFuture<ListSkuGroupsPagedResponse> createAsync(
        PageContext<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup> context,
        ApiFuture<ListSkuGroupsResponse> futureResponse) {
      ApiFuture<ListSkuGroupsPage> futurePage =
          ListSkuGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSkuGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSkuGroupsPagedResponse(ListSkuGroupsPage page) {
      super(page, ListSkuGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkuGroupsPage
      extends AbstractPage<
          ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup, ListSkuGroupsPage> {

    private ListSkuGroupsPage(
        @Nullable PageContext<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup> context,
        @Nullable ListSkuGroupsResponse response) {
      super(context, response);
    }

    private static ListSkuGroupsPage createEmptyPage() {
      return new ListSkuGroupsPage(null, null);
    }

    @Override
    protected ListSkuGroupsPage createPage(
        @Nullable PageContext<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup> context,
        @Nullable ListSkuGroupsResponse response) {
      return new ListSkuGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListSkuGroupsPage> createPageAsync(
        @Nullable PageContext<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup> context,
        ApiFuture<ListSkuGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkuGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkuGroupsRequest,
          ListSkuGroupsResponse,
          SkuGroup,
          ListSkuGroupsPage,
          ListSkuGroupsFixedSizeCollection> {

    private ListSkuGroupsFixedSizeCollection(
        @Nullable List<ListSkuGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkuGroupsFixedSizeCollection createEmptyCollection() {
      return new ListSkuGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkuGroupsFixedSizeCollection createCollection(
        @Nullable List<ListSkuGroupsPage> pages, int collectionSize) {
      return new ListSkuGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
