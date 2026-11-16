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

import com.google.ads.admanager.v1.stub.LineItemCreativeAssociationServiceStub;
import com.google.ads.admanager.v1.stub.LineItemCreativeAssociationServiceStubSettings;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `LineItemCreativeAssociation` objects.
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
 * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
 *     LineItemCreativeAssociationServiceClient.create()) {
 *   LineItemCreativeAssociationName name =
 *       LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]");
 *   LineItemCreativeAssociation response =
 *       lineItemCreativeAssociationServiceClient.getLineItemCreativeAssociation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LineItemCreativeAssociationServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetLineItemCreativeAssociation</td>
 *      <td><p> Retrieves a `LineItemCreativeAssociation` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLineItemCreativeAssociation(GetLineItemCreativeAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLineItemCreativeAssociation(LineItemCreativeAssociationName name)
 *           <li><p> getLineItemCreativeAssociation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLineItemCreativeAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLineItemCreativeAssociations</td>
 *      <td><p> Lists `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLineItemCreativeAssociations(ListLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLineItemCreativeAssociations(LineItemName parent)
 *           <li><p> listLineItemCreativeAssociations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLineItemCreativeAssociationsPagedCallable()
 *           <li><p> listLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLineItemCreativeAssociation</td>
 *      <td><p> Creates a `LineItemCreativeAssociation` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLineItemCreativeAssociation(CreateLineItemCreativeAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLineItemCreativeAssociation(LineItemName parent, LineItemCreativeAssociation lineItemCreativeAssociation)
 *           <li><p> createLineItemCreativeAssociation(String parent, LineItemCreativeAssociation lineItemCreativeAssociation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLineItemCreativeAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateLineItemCreativeAssociations</td>
 *      <td><p> Creates `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateLineItemCreativeAssociations(LineItemName parent, List&lt;CreateLineItemCreativeAssociationRequest&gt; requests)
 *           <li><p> batchCreateLineItemCreativeAssociations(String parent, List&lt;CreateLineItemCreativeAssociationRequest&gt; requests)
 *           <li><p> batchCreateLineItemCreativeAssociations(BatchCreateLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLineItemCreativeAssociation</td>
 *      <td><p> Updates a `LineItemCreativeAssociation` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLineItemCreativeAssociation(UpdateLineItemCreativeAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLineItemCreativeAssociation(LineItemCreativeAssociation lineItemCreativeAssociation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLineItemCreativeAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateLineItemCreativeAssociations</td>
 *      <td><p> Batch updates `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateLineItemCreativeAssociations(LineItemName parent, List&lt;UpdateLineItemCreativeAssociationRequest&gt; requests)
 *           <li><p> batchUpdateLineItemCreativeAssociations(String parent, List&lt;UpdateLineItemCreativeAssociationRequest&gt; requests)
 *           <li><p> batchUpdateLineItemCreativeAssociations(BatchUpdateLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateLineItemCreativeAssociations</td>
 *      <td><p> Activate a list of `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateLineItemCreativeAssociations(BatchActivateLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateLineItemCreativeAssociations(LineItemName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateLineItemCreativeAssociations(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateLineItemCreativeAssociations</td>
 *      <td><p> Deactivates a list of `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateLineItemCreativeAssociations(BatchDeactivateLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateLineItemCreativeAssociations(LineItemName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateLineItemCreativeAssociations(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteLineItemCreativeAssociations</td>
 *      <td><p> Deletes a list of `LineItemCreativeAssociation` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItemCreativeAssociations(BatchDeleteLineItemCreativeAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItemCreativeAssociations(LineItemName parent, List&lt;String&gt; names)
 *           <li><p> batchDeleteLineItemCreativeAssociations(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItemCreativeAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PreviewLineItemCreativeAssociation</td>
 *      <td><p> Fetch previews for the [LineItemCreativeAssociation][google.ads.admanager.v1.LineItemCreativeAssociation].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> previewLineItemCreativeAssociation(PreviewLineItemCreativeAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> previewLineItemCreativeAssociation(LineItemCreativeAssociationName name, String siteUrl)
 *           <li><p> previewLineItemCreativeAssociation(String name, String siteUrl)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> previewLineItemCreativeAssociationCallable()
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
 * LineItemCreativeAssociationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemCreativeAssociationServiceSettings lineItemCreativeAssociationServiceSettings =
 *     LineItemCreativeAssociationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
 *     LineItemCreativeAssociationServiceClient.create(lineItemCreativeAssociationServiceSettings);
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
 * LineItemCreativeAssociationServiceSettings lineItemCreativeAssociationServiceSettings =
 *     LineItemCreativeAssociationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
 *     LineItemCreativeAssociationServiceClient.create(lineItemCreativeAssociationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LineItemCreativeAssociationServiceClient implements BackgroundResource {
  private final @Nullable LineItemCreativeAssociationServiceSettings settings;
  private final LineItemCreativeAssociationServiceStub stub;

  /** Constructs an instance of LineItemCreativeAssociationServiceClient with default settings. */
  public static final LineItemCreativeAssociationServiceClient create() throws IOException {
    return create(LineItemCreativeAssociationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LineItemCreativeAssociationServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final LineItemCreativeAssociationServiceClient create(
      LineItemCreativeAssociationServiceSettings settings) throws IOException {
    return new LineItemCreativeAssociationServiceClient(settings);
  }

  /**
   * Constructs an instance of LineItemCreativeAssociationServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(LineItemCreativeAssociationServiceSettings).
   */
  public static final LineItemCreativeAssociationServiceClient create(
      LineItemCreativeAssociationServiceStub stub) {
    return new LineItemCreativeAssociationServiceClient(stub);
  }

  /**
   * Constructs an instance of LineItemCreativeAssociationServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected LineItemCreativeAssociationServiceClient(
      LineItemCreativeAssociationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((LineItemCreativeAssociationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LineItemCreativeAssociationServiceClient(LineItemCreativeAssociationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable LineItemCreativeAssociationServiceSettings getSettings() {
    return settings;
  }

  public LineItemCreativeAssociationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemCreativeAssociationName name =
   *       LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]");
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.getLineItemCreativeAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItemCreativeAssociation. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation getLineItemCreativeAssociation(
      @Nullable LineItemCreativeAssociationName name) {
    GetLineItemCreativeAssociationRequest request =
        GetLineItemCreativeAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String name =
   *       LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *           .toString();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.getLineItemCreativeAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItemCreativeAssociation. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation getLineItemCreativeAssociation(String name) {
    GetLineItemCreativeAssociationRequest request =
        GetLineItemCreativeAssociationRequest.newBuilder().setName(name).build();
    return getLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   GetLineItemCreativeAssociationRequest request =
   *       GetLineItemCreativeAssociationRequest.newBuilder()
   *           .setName(
   *               LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *                   .toString())
   *           .build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.getLineItemCreativeAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation getLineItemCreativeAssociation(
      GetLineItemCreativeAssociationRequest request) {
    return getLineItemCreativeAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   GetLineItemCreativeAssociationRequest request =
   *       GetLineItemCreativeAssociationRequest.newBuilder()
   *           .setName(
   *               LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LineItemCreativeAssociation> future =
   *       lineItemCreativeAssociationServiceClient
   *           .getLineItemCreativeAssociationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   LineItemCreativeAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationCallable() {
    return stub.getLineItemCreativeAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   for (LineItemCreativeAssociation element :
   *       lineItemCreativeAssociationServiceClient
   *           .listLineItemCreativeAssociations(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItemCreativeAssociations.
   *     This request supports using the "-" character as a wildcard for resources that span across
   *     multiple LineItem parents. Format: `networks/{network_code}/lineItems/{line_item_id}`
   *     Format: `networks/{network_code}/lineItems/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemCreativeAssociationsPagedResponse listLineItemCreativeAssociations(
      @Nullable LineItemName parent) {
    ListLineItemCreativeAssociationsRequest request =
        ListLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   for (LineItemCreativeAssociation element :
   *       lineItemCreativeAssociationServiceClient
   *           .listLineItemCreativeAssociations(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItemCreativeAssociations.
   *     This request supports using the "-" character as a wildcard for resources that span across
   *     multiple LineItem parents. Format: `networks/{network_code}/lineItems/{line_item_id}`
   *     Format: `networks/{network_code}/lineItems/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemCreativeAssociationsPagedResponse listLineItemCreativeAssociations(
      String parent) {
    ListLineItemCreativeAssociationsRequest request =
        ListLineItemCreativeAssociationsRequest.newBuilder().setParent(parent).build();
    return listLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   ListLineItemCreativeAssociationsRequest request =
   *       ListLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LineItemCreativeAssociation element :
   *       lineItemCreativeAssociationServiceClient
   *           .listLineItemCreativeAssociations(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemCreativeAssociationsPagedResponse listLineItemCreativeAssociations(
      ListLineItemCreativeAssociationsRequest request) {
    return listLineItemCreativeAssociationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   ListLineItemCreativeAssociationsRequest request =
   *       ListLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LineItemCreativeAssociation> future =
   *       lineItemCreativeAssociationServiceClient
   *           .listLineItemCreativeAssociationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (LineItemCreativeAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsPagedCallable() {
    return stub.listLineItemCreativeAssociationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   ListLineItemCreativeAssociationsRequest request =
   *       ListLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLineItemCreativeAssociationsResponse response =
   *         lineItemCreativeAssociationServiceClient
   *             .listLineItemCreativeAssociationsCallable()
   *             .call(request);
   *     for (LineItemCreativeAssociation element : response.getLineItemCreativeAssociationsList()) {
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
  public final UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
      listLineItemCreativeAssociationsCallable() {
    return stub.listLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   LineItemCreativeAssociation lineItemCreativeAssociation =
   *       LineItemCreativeAssociation.newBuilder().build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.createLineItemCreativeAssociation(
   *           parent, lineItemCreativeAssociation);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LineItemCreativeAssociation` will be
   *     created. Format: `networks/{network_code}/lineItems/{line_item_id}`
   * @param lineItemCreativeAssociation Required. The `LineItemCreativeAssociation` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation createLineItemCreativeAssociation(
      @Nullable LineItemName parent, LineItemCreativeAssociation lineItemCreativeAssociation) {
    CreateLineItemCreativeAssociationRequest request =
        CreateLineItemCreativeAssociationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLineItemCreativeAssociation(lineItemCreativeAssociation)
            .build();
    return createLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   LineItemCreativeAssociation lineItemCreativeAssociation =
   *       LineItemCreativeAssociation.newBuilder().build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.createLineItemCreativeAssociation(
   *           parent, lineItemCreativeAssociation);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LineItemCreativeAssociation` will be
   *     created. Format: `networks/{network_code}/lineItems/{line_item_id}`
   * @param lineItemCreativeAssociation Required. The `LineItemCreativeAssociation` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation createLineItemCreativeAssociation(
      String parent, LineItemCreativeAssociation lineItemCreativeAssociation) {
    CreateLineItemCreativeAssociationRequest request =
        CreateLineItemCreativeAssociationRequest.newBuilder()
            .setParent(parent)
            .setLineItemCreativeAssociation(lineItemCreativeAssociation)
            .build();
    return createLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   CreateLineItemCreativeAssociationRequest request =
   *       CreateLineItemCreativeAssociationRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .setLineItemCreativeAssociation(LineItemCreativeAssociation.newBuilder().build())
   *           .build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.createLineItemCreativeAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation createLineItemCreativeAssociation(
      CreateLineItemCreativeAssociationRequest request) {
    return createLineItemCreativeAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   CreateLineItemCreativeAssociationRequest request =
   *       CreateLineItemCreativeAssociationRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .setLineItemCreativeAssociation(LineItemCreativeAssociation.newBuilder().build())
   *           .build();
   *   ApiFuture<LineItemCreativeAssociation> future =
   *       lineItemCreativeAssociationServiceClient
   *           .createLineItemCreativeAssociationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   LineItemCreativeAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationCallable() {
    return stub.createLineItemCreativeAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   List<CreateLineItemCreativeAssociationRequest> requests = new ArrayList<>();
   *   BatchCreateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchCreateLineItemCreativeAssociations(
   *           parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     created. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param requests Required. The `LineItemCreativeAssociation` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemCreativeAssociationsResponse
      batchCreateLineItemCreativeAssociations(
          @Nullable LineItemName parent, List<CreateLineItemCreativeAssociationRequest> requests) {
    BatchCreateLineItemCreativeAssociationsRequest request =
        BatchCreateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   List<CreateLineItemCreativeAssociationRequest> requests = new ArrayList<>();
   *   BatchCreateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchCreateLineItemCreativeAssociations(
   *           parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     created. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param requests Required. The `LineItemCreativeAssociation` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemCreativeAssociationsResponse
      batchCreateLineItemCreativeAssociations(
          String parent, List<CreateLineItemCreativeAssociationRequest> requests) {
    BatchCreateLineItemCreativeAssociationsRequest request =
        BatchCreateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchCreateLineItemCreativeAssociationsRequest request =
   *       BatchCreateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllRequests(new ArrayList<CreateLineItemCreativeAssociationRequest>())
   *           .build();
   *   BatchCreateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchCreateLineItemCreativeAssociations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemCreativeAssociationsResponse
      batchCreateLineItemCreativeAssociations(
          BatchCreateLineItemCreativeAssociationsRequest request) {
    return batchCreateLineItemCreativeAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchCreateLineItemCreativeAssociationsRequest request =
   *       BatchCreateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllRequests(new ArrayList<CreateLineItemCreativeAssociationRequest>())
   *           .build();
   *   ApiFuture<BatchCreateLineItemCreativeAssociationsResponse> future =
   *       lineItemCreativeAssociationServiceClient
   *           .batchCreateLineItemCreativeAssociationsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateLineItemCreativeAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsCallable() {
    return stub.batchCreateLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemCreativeAssociation lineItemCreativeAssociation =
   *       LineItemCreativeAssociation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.updateLineItemCreativeAssociation(
   *           lineItemCreativeAssociation, updateMask);
   * }
   * }</pre>
   *
   * @param lineItemCreativeAssociation Required. The `LineItemCreativeAssociation` to update.
   *     Format: `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation updateLineItemCreativeAssociation(
      LineItemCreativeAssociation lineItemCreativeAssociation, FieldMask updateMask) {
    UpdateLineItemCreativeAssociationRequest request =
        UpdateLineItemCreativeAssociationRequest.newBuilder()
            .setLineItemCreativeAssociation(lineItemCreativeAssociation)
            .setUpdateMask(updateMask)
            .build();
    return updateLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   UpdateLineItemCreativeAssociationRequest request =
   *       UpdateLineItemCreativeAssociationRequest.newBuilder()
   *           .setLineItemCreativeAssociation(LineItemCreativeAssociation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LineItemCreativeAssociation response =
   *       lineItemCreativeAssociationServiceClient.updateLineItemCreativeAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemCreativeAssociation updateLineItemCreativeAssociation(
      UpdateLineItemCreativeAssociationRequest request) {
    return updateLineItemCreativeAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItemCreativeAssociation` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   UpdateLineItemCreativeAssociationRequest request =
   *       UpdateLineItemCreativeAssociationRequest.newBuilder()
   *           .setLineItemCreativeAssociation(LineItemCreativeAssociation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LineItemCreativeAssociation> future =
   *       lineItemCreativeAssociationServiceClient
   *           .updateLineItemCreativeAssociationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   LineItemCreativeAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationCallable() {
    return stub.updateLineItemCreativeAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   List<UpdateLineItemCreativeAssociationRequest> requests = new ArrayList<>();
   *   BatchUpdateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchUpdateLineItemCreativeAssociations(
   *           parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     updated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param requests Required. The `LineItemCreativeAssociation` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemCreativeAssociationsResponse
      batchUpdateLineItemCreativeAssociations(
          @Nullable LineItemName parent, List<UpdateLineItemCreativeAssociationRequest> requests) {
    BatchUpdateLineItemCreativeAssociationsRequest request =
        BatchUpdateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   List<UpdateLineItemCreativeAssociationRequest> requests = new ArrayList<>();
   *   BatchUpdateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchUpdateLineItemCreativeAssociations(
   *           parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     updated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param requests Required. The `LineItemCreativeAssociation` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemCreativeAssociationsResponse
      batchUpdateLineItemCreativeAssociations(
          String parent, List<UpdateLineItemCreativeAssociationRequest> requests) {
    BatchUpdateLineItemCreativeAssociationsRequest request =
        BatchUpdateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchUpdateLineItemCreativeAssociationsRequest request =
   *       BatchUpdateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllRequests(new ArrayList<UpdateLineItemCreativeAssociationRequest>())
   *           .build();
   *   BatchUpdateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchUpdateLineItemCreativeAssociations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemCreativeAssociationsResponse
      batchUpdateLineItemCreativeAssociations(
          BatchUpdateLineItemCreativeAssociationsRequest request) {
    return batchUpdateLineItemCreativeAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchUpdateLineItemCreativeAssociationsRequest request =
   *       BatchUpdateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllRequests(new ArrayList<UpdateLineItemCreativeAssociationRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateLineItemCreativeAssociationsResponse> future =
   *       lineItemCreativeAssociationServiceClient
   *           .batchUpdateLineItemCreativeAssociationsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateLineItemCreativeAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsCallable() {
    return stub.batchUpdateLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchActivateLineItemCreativeAssociations(
   *           parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     activated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to activate. A
   *     maximum of 1000 objects can be activated in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemCreativeAssociationsResponse
      batchActivateLineItemCreativeAssociations(@Nullable LineItemName parent, List<String> names) {
    BatchActivateLineItemCreativeAssociationsRequest request =
        BatchActivateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchActivateLineItemCreativeAssociations(
   *           parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     activated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to activate. A
   *     maximum of 1000 objects can be activated in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemCreativeAssociationsResponse
      batchActivateLineItemCreativeAssociations(String parent, List<String> names) {
    BatchActivateLineItemCreativeAssociationsRequest request =
        BatchActivateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchActivateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchActivateLineItemCreativeAssociationsRequest request =
   *       BatchActivateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchActivateLineItemCreativeAssociations(
   *           request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemCreativeAssociationsResponse
      batchActivateLineItemCreativeAssociations(
          BatchActivateLineItemCreativeAssociationsRequest request) {
    return batchActivateLineItemCreativeAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchActivateLineItemCreativeAssociationsRequest request =
   *       BatchActivateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateLineItemCreativeAssociationsResponse> future =
   *       lineItemCreativeAssociationServiceClient
   *           .batchActivateLineItemCreativeAssociationsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateLineItemCreativeAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsCallable() {
    return stub.batchActivateLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchDeactivateLineItemCreativeAssociations(
   *           parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     deactivated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to deactivate. A
   *     maximum of 1000 objects can be deactivated in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLineItemCreativeAssociationsResponse
      batchDeactivateLineItemCreativeAssociations(
          @Nullable LineItemName parent, List<String> names) {
    BatchDeactivateLineItemCreativeAssociationsRequest request =
        BatchDeactivateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchDeactivateLineItemCreativeAssociations(
   *           parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     deactivated. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to deactivate. A
   *     maximum of 1000 objects can be deactivated in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLineItemCreativeAssociationsResponse
      batchDeactivateLineItemCreativeAssociations(String parent, List<String> names) {
    BatchDeactivateLineItemCreativeAssociationsRequest request =
        BatchDeactivateLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchDeactivateLineItemCreativeAssociationsRequest request =
   *       BatchDeactivateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateLineItemCreativeAssociationsResponse response =
   *       lineItemCreativeAssociationServiceClient.batchDeactivateLineItemCreativeAssociations(
   *           request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLineItemCreativeAssociationsResponse
      batchDeactivateLineItemCreativeAssociations(
          BatchDeactivateLineItemCreativeAssociationsRequest request) {
    return batchDeactivateLineItemCreativeAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchDeactivateLineItemCreativeAssociationsRequest request =
   *       BatchDeactivateLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateLineItemCreativeAssociationsResponse> future =
   *       lineItemCreativeAssociationServiceClient
   *           .batchDeactivateLineItemCreativeAssociationsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateLineItemCreativeAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsCallable() {
    return stub.batchDeactivateLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemName parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   List<String> names = new ArrayList<>();
   *   lineItemCreativeAssociationServiceClient.batchDeleteLineItemCreativeAssociations(
   *       parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     deleted. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to delete. A
   *     maximum of 1000 objects can be deleted in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItemCreativeAssociations(
      @Nullable LineItemName parent, List<String> names) {
    BatchDeleteLineItemCreativeAssociationsRequest request =
        BatchDeleteLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    batchDeleteLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String parent = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   List<String> names = new ArrayList<>();
   *   lineItemCreativeAssociationServiceClient.batchDeleteLineItemCreativeAssociations(
   *       parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItemCreativeAssociations` will be
   *     deleted. This request supports using the "-" character as a wildcard for resources that
   *     span across multiple LineItem parents. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}` Format:
   *     `networks/{network_code}/lineItems/-`
   * @param names Required. The names of the `LineItemCreativeAssociation` objects to delete. A
   *     maximum of 1000 objects can be deleted in a batch. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItemCreativeAssociations(String parent, List<String> names) {
    BatchDeleteLineItemCreativeAssociationsRequest request =
        BatchDeleteLineItemCreativeAssociationsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    batchDeleteLineItemCreativeAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchDeleteLineItemCreativeAssociationsRequest request =
   *       BatchDeleteLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   lineItemCreativeAssociationServiceClient.batchDeleteLineItemCreativeAssociations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItemCreativeAssociations(
      BatchDeleteLineItemCreativeAssociationsRequest request) {
    batchDeleteLineItemCreativeAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a list of `LineItemCreativeAssociation` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   BatchDeleteLineItemCreativeAssociationsRequest request =
   *       BatchDeleteLineItemCreativeAssociationsRequest.newBuilder()
   *           .setParent(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       lineItemCreativeAssociationServiceClient
   *           .batchDeleteLineItemCreativeAssociationsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsCallable() {
    return stub.batchDeleteLineItemCreativeAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch previews for the
   * [LineItemCreativeAssociation][google.ads.admanager.v1.LineItemCreativeAssociation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   LineItemCreativeAssociationName name =
   *       LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]");
   *   String siteUrl = "siteUrl2099991720";
   *   PreviewLineItemCreativeAssociationResponse response =
   *       lineItemCreativeAssociationServiceClient.previewLineItemCreativeAssociation(
   *           name, siteUrl);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LineItemCreativeAssociation` object to preview. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @param siteUrl Required. The URL of the site that the creative should be previewed in
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewLineItemCreativeAssociationResponse previewLineItemCreativeAssociation(
      @Nullable LineItemCreativeAssociationName name, String siteUrl) {
    PreviewLineItemCreativeAssociationRequest request =
        PreviewLineItemCreativeAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSiteUrl(siteUrl)
            .build();
    return previewLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch previews for the
   * [LineItemCreativeAssociation][google.ads.admanager.v1.LineItemCreativeAssociation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   String name =
   *       LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *           .toString();
   *   String siteUrl = "siteUrl2099991720";
   *   PreviewLineItemCreativeAssociationResponse response =
   *       lineItemCreativeAssociationServiceClient.previewLineItemCreativeAssociation(
   *           name, siteUrl);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `LineItemCreativeAssociation` object to preview. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}/creatives/{creative_id}`
   * @param siteUrl Required. The URL of the site that the creative should be previewed in
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewLineItemCreativeAssociationResponse previewLineItemCreativeAssociation(
      String name, String siteUrl) {
    PreviewLineItemCreativeAssociationRequest request =
        PreviewLineItemCreativeAssociationRequest.newBuilder()
            .setName(name)
            .setSiteUrl(siteUrl)
            .build();
    return previewLineItemCreativeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch previews for the
   * [LineItemCreativeAssociation][google.ads.admanager.v1.LineItemCreativeAssociation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   PreviewLineItemCreativeAssociationRequest request =
   *       PreviewLineItemCreativeAssociationRequest.newBuilder()
   *           .setName(
   *               LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *                   .toString())
   *           .setSiteUrl("siteUrl2099991720")
   *           .build();
   *   PreviewLineItemCreativeAssociationResponse response =
   *       lineItemCreativeAssociationServiceClient.previewLineItemCreativeAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewLineItemCreativeAssociationResponse previewLineItemCreativeAssociation(
      PreviewLineItemCreativeAssociationRequest request) {
    return previewLineItemCreativeAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch previews for the
   * [LineItemCreativeAssociation][google.ads.admanager.v1.LineItemCreativeAssociation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemCreativeAssociationServiceClient lineItemCreativeAssociationServiceClient =
   *     LineItemCreativeAssociationServiceClient.create()) {
   *   PreviewLineItemCreativeAssociationRequest request =
   *       PreviewLineItemCreativeAssociationRequest.newBuilder()
   *           .setName(
   *               LineItemCreativeAssociationName.of("[NETWORK_CODE]", "[LINE_ITEM]", "[CREATIVE]")
   *                   .toString())
   *           .setSiteUrl("siteUrl2099991720")
   *           .build();
   *   ApiFuture<PreviewLineItemCreativeAssociationResponse> future =
   *       lineItemCreativeAssociationServiceClient
   *           .previewLineItemCreativeAssociationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PreviewLineItemCreativeAssociationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationCallable() {
    return stub.previewLineItemCreativeAssociationCallable();
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

  public static class ListLineItemCreativeAssociationsPagedResponse
      extends AbstractPagedListResponse<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          LineItemCreativeAssociation,
          ListLineItemCreativeAssociationsPage,
          ListLineItemCreativeAssociationsFixedSizeCollection> {

    public static ApiFuture<ListLineItemCreativeAssociationsPagedResponse> createAsync(
        PageContext<
                ListLineItemCreativeAssociationsRequest,
                ListLineItemCreativeAssociationsResponse,
                LineItemCreativeAssociation>
            context,
        ApiFuture<ListLineItemCreativeAssociationsResponse> futureResponse) {
      ApiFuture<ListLineItemCreativeAssociationsPage> futurePage =
          ListLineItemCreativeAssociationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLineItemCreativeAssociationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLineItemCreativeAssociationsPagedResponse(
        ListLineItemCreativeAssociationsPage page) {
      super(page, ListLineItemCreativeAssociationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLineItemCreativeAssociationsPage
      extends AbstractPage<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          LineItemCreativeAssociation,
          ListLineItemCreativeAssociationsPage> {

    private ListLineItemCreativeAssociationsPage(
        @Nullable
            PageContext<
                ListLineItemCreativeAssociationsRequest,
                ListLineItemCreativeAssociationsResponse,
                LineItemCreativeAssociation>
            context,
        @Nullable ListLineItemCreativeAssociationsResponse response) {
      super(context, response);
    }

    private static ListLineItemCreativeAssociationsPage createEmptyPage() {
      return new ListLineItemCreativeAssociationsPage(null, null);
    }

    @Override
    protected ListLineItemCreativeAssociationsPage createPage(
        @Nullable
            PageContext<
                ListLineItemCreativeAssociationsRequest,
                ListLineItemCreativeAssociationsResponse,
                LineItemCreativeAssociation>
            context,
        @Nullable ListLineItemCreativeAssociationsResponse response) {
      return new ListLineItemCreativeAssociationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLineItemCreativeAssociationsPage> createPageAsync(
        @Nullable
            PageContext<
                ListLineItemCreativeAssociationsRequest,
                ListLineItemCreativeAssociationsResponse,
                LineItemCreativeAssociation>
            context,
        ApiFuture<ListLineItemCreativeAssociationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLineItemCreativeAssociationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLineItemCreativeAssociationsRequest,
          ListLineItemCreativeAssociationsResponse,
          LineItemCreativeAssociation,
          ListLineItemCreativeAssociationsPage,
          ListLineItemCreativeAssociationsFixedSizeCollection> {

    private ListLineItemCreativeAssociationsFixedSizeCollection(
        @Nullable List<ListLineItemCreativeAssociationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLineItemCreativeAssociationsFixedSizeCollection createEmptyCollection() {
      return new ListLineItemCreativeAssociationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLineItemCreativeAssociationsFixedSizeCollection createCollection(
        @Nullable List<ListLineItemCreativeAssociationsPage> pages, int collectionSize) {
      return new ListLineItemCreativeAssociationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
