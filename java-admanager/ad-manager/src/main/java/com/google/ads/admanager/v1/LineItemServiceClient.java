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

import com.google.ads.admanager.v1.stub.LineItemServiceStub;
import com.google.ads.admanager.v1.stub.LineItemServiceStubSettings;
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
 * Service Description: Provides methods for handling `LineItem` objects.
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
 * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
 *   LineItemName name = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
 *   LineItem response = lineItemServiceClient.getLineItem(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LineItemServiceClient object to clean up resources
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
 *      <td><p> GetLineItem</td>
 *      <td><p> Retrieves a `LineItem` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLineItem(GetLineItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLineItem(LineItemName name)
 *           <li><p> getLineItem(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLineItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLineItems</td>
 *      <td><p> Lists `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLineItems(ListLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLineItems(NetworkName parent)
 *           <li><p> listLineItems(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLineItemsPagedCallable()
 *           <li><p> listLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLineItem</td>
 *      <td><p> Creates a `LineItem` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLineItem(CreateLineItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLineItem(NetworkName parent, LineItem lineItem)
 *           <li><p> createLineItem(String parent, LineItem lineItem)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLineItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateLineItems</td>
 *      <td><p> Creates `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateLineItems(NetworkName parent, List&lt;CreateLineItemRequest&gt; requests)
 *           <li><p> batchCreateLineItems(String parent, List&lt;CreateLineItemRequest&gt; requests)
 *           <li><p> batchCreateLineItems(BatchCreateLineItemsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLineItem</td>
 *      <td><p> Updates a `LineItem` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLineItem(UpdateLineItemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLineItem(LineItem lineItem, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLineItemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateLineItems</td>
 *      <td><p> Batch updates `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateLineItems(NetworkName parent, List&lt;UpdateLineItemRequest&gt; requests)
 *           <li><p> batchUpdateLineItems(String parent, List&lt;UpdateLineItemRequest&gt; requests)
 *           <li><p> batchUpdateLineItems(BatchUpdateLineItemsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateLineItems</td>
 *      <td><p> Batch activates `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateLineItems(BatchActivateLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPauseLineItems</td>
 *      <td><p> Batch pauses `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPauseLineItems(BatchPauseLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPauseLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchPauseLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPauseLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchResumeLineItems</td>
 *      <td><p> Batch resumes `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchResumeLineItems(BatchResumeLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchResumeLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchResumeLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchResumeLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchResumeAndOverbookLineItems</td>
 *      <td><p> Batch resumes and overbooks `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookLineItems(BatchResumeAndOverbookLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchResumeAndOverbookLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchResumeAndOverbookLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteLineItems</td>
 *      <td><p> Batch deletes `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItems(BatchDeleteLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeleteLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchReserveLineItems</td>
 *      <td><p> Batch reserves `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchReserveLineItems(BatchReserveLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchReserveLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchReserveLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchReserveLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchReserveAndOverbookLineItems</td>
 *      <td><p> Batch reserves and overbooks `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchReserveAndOverbookLineItems(BatchReserveAndOverbookLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchReserveAndOverbookLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchReserveAndOverbookLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchReserveAndOverbookLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchReleaseLineItems</td>
 *      <td><p> Batch releases `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchReleaseLineItems(BatchReleaseLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchReleaseLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchReleaseLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchReleaseLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveLineItems</td>
 *      <td><p> Batch archives `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveLineItems(BatchArchiveLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveLineItemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUnarchiveLineItems</td>
 *      <td><p> Batch unarchives `LineItem` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUnarchiveLineItems(BatchUnarchiveLineItemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchUnarchiveLineItems(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchUnarchiveLineItems(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUnarchiveLineItemsCallable()
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
 * <p>This class can be customized by passing in a custom instance of LineItemServiceSettings to
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
 * LineItemServiceSettings lineItemServiceSettings =
 *     LineItemServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LineItemServiceClient lineItemServiceClient =
 *     LineItemServiceClient.create(lineItemServiceSettings);
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
 * LineItemServiceSettings lineItemServiceSettings =
 *     LineItemServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LineItemServiceClient lineItemServiceClient =
 *     LineItemServiceClient.create(lineItemServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LineItemServiceClient implements BackgroundResource {
  private final @Nullable LineItemServiceSettings settings;
  private final LineItemServiceStub stub;

  /** Constructs an instance of LineItemServiceClient with default settings. */
  public static final LineItemServiceClient create() throws IOException {
    return create(LineItemServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LineItemServiceClient create(LineItemServiceSettings settings)
      throws IOException {
    return new LineItemServiceClient(settings);
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LineItemServiceSettings).
   */
  public static final LineItemServiceClient create(LineItemServiceStub stub) {
    return new LineItemServiceClient(stub);
  }

  /**
   * Constructs an instance of LineItemServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LineItemServiceClient(LineItemServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LineItemServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LineItemServiceClient(LineItemServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable LineItemServiceSettings getSettings() {
    return settings;
  }

  public LineItemServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   LineItemName name = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
   *   LineItem response = lineItemServiceClient.getLineItem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItem. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(@Nullable LineItemName name) {
    GetLineItemRequest request =
        GetLineItemRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String name = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString();
   *   LineItem response = lineItemServiceClient.getLineItem(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItem. Format:
   *     `networks/{network_code}/lineItems/{line_item_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(String name) {
    GetLineItemRequest request = GetLineItemRequest.newBuilder().setName(name).build();
    return getLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   GetLineItemRequest request =
   *       GetLineItemRequest.newBuilder()
   *           .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .build();
   *   LineItem response = lineItemServiceClient.getLineItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem getLineItem(GetLineItemRequest request) {
    return getLineItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   GetLineItemRequest request =
   *       GetLineItemRequest.newBuilder()
   *           .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
   *           .build();
   *   ApiFuture<LineItem> future = lineItemServiceClient.getLineItemCallable().futureCall(request);
   *   // Do something.
   *   LineItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable() {
    return stub.getLineItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (LineItem element : lineItemServiceClient.listLineItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItems. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(@Nullable NetworkName parent) {
    ListLineItemsRequest request =
        ListLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (LineItem element : lineItemServiceClient.listLineItems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItems. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(String parent) {
    ListLineItemsRequest request = ListLineItemsRequest.newBuilder().setParent(parent).build();
    return listLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LineItem element : lineItemServiceClient.listLineItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemsPagedResponse listLineItems(ListLineItemsRequest request) {
    return listLineItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LineItem> future =
   *       lineItemServiceClient.listLineItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LineItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable() {
    return stub.listLineItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   ListLineItemsRequest request =
   *       ListLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLineItemsResponse response =
   *         lineItemServiceClient.listLineItemsCallable().call(request);
   *     for (LineItem element : response.getLineItemsList()) {
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
  public final UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable() {
    return stub.listLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   LineItem lineItem = LineItem.newBuilder().build();
   *   LineItem response = lineItemServiceClient.createLineItem(parent, lineItem);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LineItem` will be created. Format:
   *     `networks/{network_code}`
   * @param lineItem Required. The `LineItem` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem createLineItem(@Nullable NetworkName parent, LineItem lineItem) {
    CreateLineItemRequest request =
        CreateLineItemRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLineItem(lineItem)
            .build();
    return createLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   LineItem lineItem = LineItem.newBuilder().build();
   *   LineItem response = lineItemServiceClient.createLineItem(parent, lineItem);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LineItem` will be created. Format:
   *     `networks/{network_code}`
   * @param lineItem Required. The `LineItem` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem createLineItem(String parent, LineItem lineItem) {
    CreateLineItemRequest request =
        CreateLineItemRequest.newBuilder().setParent(parent).setLineItem(lineItem).build();
    return createLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   CreateLineItemRequest request =
   *       CreateLineItemRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLineItem(LineItem.newBuilder().build())
   *           .build();
   *   LineItem response = lineItemServiceClient.createLineItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem createLineItem(CreateLineItemRequest request) {
    return createLineItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   CreateLineItemRequest request =
   *       CreateLineItemRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLineItem(LineItem.newBuilder().build())
   *           .build();
   *   ApiFuture<LineItem> future =
   *       lineItemServiceClient.createLineItemCallable().futureCall(request);
   *   // Do something.
   *   LineItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLineItemRequest, LineItem> createLineItemCallable() {
    return stub.createLineItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateLineItemRequest> requests = new ArrayList<>();
   *   BatchCreateLineItemsResponse response =
   *       lineItemServiceClient.batchCreateLineItems(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLineItemRequest must match this
   *     field.
   * @param requests Required. The `LineItem` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemsResponse batchCreateLineItems(
      @Nullable NetworkName parent, List<CreateLineItemRequest> requests) {
    BatchCreateLineItemsRequest request =
        BatchCreateLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateLineItemRequest> requests = new ArrayList<>();
   *   BatchCreateLineItemsResponse response =
   *       lineItemServiceClient.batchCreateLineItems(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLineItemRequest must match this
   *     field.
   * @param requests Required. The `LineItem` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemsResponse batchCreateLineItems(
      String parent, List<CreateLineItemRequest> requests) {
    BatchCreateLineItemsRequest request =
        BatchCreateLineItemsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchCreateLineItemsRequest request =
   *       BatchCreateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLineItemRequest>())
   *           .build();
   *   BatchCreateLineItemsResponse response = lineItemServiceClient.batchCreateLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLineItemsResponse batchCreateLineItems(
      BatchCreateLineItemsRequest request) {
    return batchCreateLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchCreateLineItemsRequest request =
   *       BatchCreateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLineItemRequest>())
   *           .build();
   *   ApiFuture<BatchCreateLineItemsResponse> future =
   *       lineItemServiceClient.batchCreateLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsCallable() {
    return stub.batchCreateLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   LineItem lineItem = LineItem.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LineItem response = lineItemServiceClient.updateLineItem(lineItem, updateMask);
   * }
   * }</pre>
   *
   * @param lineItem Required. The `LineItem` to update.
   *     <p>The `LineItem`'s `name` is used to identify the `LineItem` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem updateLineItem(LineItem lineItem, FieldMask updateMask) {
    UpdateLineItemRequest request =
        UpdateLineItemRequest.newBuilder().setLineItem(lineItem).setUpdateMask(updateMask).build();
    return updateLineItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   UpdateLineItemRequest request =
   *       UpdateLineItemRequest.newBuilder()
   *           .setLineItem(LineItem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LineItem response = lineItemServiceClient.updateLineItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItem updateLineItem(UpdateLineItemRequest request) {
    return updateLineItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LineItem` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   UpdateLineItemRequest request =
   *       UpdateLineItemRequest.newBuilder()
   *           .setLineItem(LineItem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LineItem> future =
   *       lineItemServiceClient.updateLineItemCallable().futureCall(request);
   *   // Do something.
   *   LineItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLineItemRequest, LineItem> updateLineItemCallable() {
    return stub.updateLineItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateLineItemRequest> requests = new ArrayList<>();
   *   BatchUpdateLineItemsResponse response =
   *       lineItemServiceClient.batchUpdateLineItems(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}` The parent segment of the `line_item.name` in each
   *     `UpdateLineItemRequest` must match this field.
   * @param requests Required. The `LineItem` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemsResponse batchUpdateLineItems(
      @Nullable NetworkName parent, List<UpdateLineItemRequest> requests) {
    BatchUpdateLineItemsRequest request =
        BatchUpdateLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateLineItemRequest> requests = new ArrayList<>();
   *   BatchUpdateLineItemsResponse response =
   *       lineItemServiceClient.batchUpdateLineItems(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}` The parent segment of the `line_item.name` in each
   *     `UpdateLineItemRequest` must match this field.
   * @param requests Required. The `LineItem` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemsResponse batchUpdateLineItems(
      String parent, List<UpdateLineItemRequest> requests) {
    BatchUpdateLineItemsRequest request =
        BatchUpdateLineItemsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchUpdateLineItemsRequest request =
   *       BatchUpdateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLineItemRequest>())
   *           .build();
   *   BatchUpdateLineItemsResponse response = lineItemServiceClient.batchUpdateLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLineItemsResponse batchUpdateLineItems(
      BatchUpdateLineItemsRequest request) {
    return batchUpdateLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchUpdateLineItemsRequest request =
   *       BatchUpdateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLineItemRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateLineItemsResponse> future =
   *       lineItemServiceClient.batchUpdateLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsCallable() {
    return stub.batchUpdateLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLineItemsResponse response =
   *       lineItemServiceClient.batchActivateLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to activate. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemsResponse batchActivateLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateLineItemsRequest request =
        BatchActivateLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLineItemsResponse response =
   *       lineItemServiceClient.batchActivateLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to activate. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemsResponse batchActivateLineItems(
      String parent, List<String> names) {
    BatchActivateLineItemsRequest request =
        BatchActivateLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchActivateLineItemsRequest request =
   *       BatchActivateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateLineItemsResponse response =
   *       lineItemServiceClient.batchActivateLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLineItemsResponse batchActivateLineItems(
      BatchActivateLineItemsRequest request) {
    return batchActivateLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchActivateLineItemsRequest request =
   *       BatchActivateLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateLineItemsResponse> future =
   *       lineItemServiceClient.batchActivateLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsCallable() {
    return stub.batchActivateLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchPauseLineItemsResponse response =
   *       lineItemServiceClient.batchPauseLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to pause. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLineItemsResponse batchPauseLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchPauseLineItemsRequest request =
        BatchPauseLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchPauseLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchPauseLineItemsResponse response =
   *       lineItemServiceClient.batchPauseLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to pause. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLineItemsResponse batchPauseLineItems(String parent, List<String> names) {
    BatchPauseLineItemsRequest request =
        BatchPauseLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchPauseLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchPauseLineItemsRequest request =
   *       BatchPauseLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchPauseLineItemsResponse response = lineItemServiceClient.batchPauseLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLineItemsResponse batchPauseLineItems(BatchPauseLineItemsRequest request) {
    return batchPauseLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchPauseLineItemsRequest request =
   *       BatchPauseLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchPauseLineItemsResponse> future =
   *       lineItemServiceClient.batchPauseLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchPauseLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsCallable() {
    return stub.batchPauseLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchResumeLineItemsResponse response =
   *       lineItemServiceClient.batchResumeLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to resume. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeLineItemsResponse batchResumeLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchResumeLineItemsRequest request =
        BatchResumeLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchResumeLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchResumeLineItemsResponse response =
   *       lineItemServiceClient.batchResumeLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to resume. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeLineItemsResponse batchResumeLineItems(
      String parent, List<String> names) {
    BatchResumeLineItemsRequest request =
        BatchResumeLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchResumeLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchResumeLineItemsRequest request =
   *       BatchResumeLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchResumeLineItemsResponse response = lineItemServiceClient.batchResumeLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeLineItemsResponse batchResumeLineItems(
      BatchResumeLineItemsRequest request) {
    return batchResumeLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchResumeLineItemsRequest request =
   *       BatchResumeLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchResumeLineItemsResponse> future =
   *       lineItemServiceClient.batchResumeLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchResumeLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsCallable() {
    return stub.batchResumeLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchResumeAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchResumeAndOverbookLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to resume and overbook. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookLineItemsResponse batchResumeAndOverbookLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchResumeAndOverbookLineItemsRequest request =
        BatchResumeAndOverbookLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchResumeAndOverbookLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchResumeAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchResumeAndOverbookLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to resume and overbook. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookLineItemsResponse batchResumeAndOverbookLineItems(
      String parent, List<String> names) {
    BatchResumeAndOverbookLineItemsRequest request =
        BatchResumeAndOverbookLineItemsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchResumeAndOverbookLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchResumeAndOverbookLineItemsRequest request =
   *       BatchResumeAndOverbookLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchResumeAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchResumeAndOverbookLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeAndOverbookLineItemsResponse batchResumeAndOverbookLineItems(
      BatchResumeAndOverbookLineItemsRequest request) {
    return batchResumeAndOverbookLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch resumes and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchResumeAndOverbookLineItemsRequest request =
   *       BatchResumeAndOverbookLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchResumeAndOverbookLineItemsResponse> future =
   *       lineItemServiceClient.batchResumeAndOverbookLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchResumeAndOverbookLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsCallable() {
    return stub.batchResumeAndOverbookLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   lineItemServiceClient.batchDeleteLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to delete. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItems(@Nullable NetworkName parent, List<String> names) {
    BatchDeleteLineItemsRequest request =
        BatchDeleteLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    batchDeleteLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   lineItemServiceClient.batchDeleteLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to delete. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItems(String parent, List<String> names) {
    BatchDeleteLineItemsRequest request =
        BatchDeleteLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    batchDeleteLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchDeleteLineItemsRequest request =
   *       BatchDeleteLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   lineItemServiceClient.batchDeleteLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeleteLineItems(BatchDeleteLineItemsRequest request) {
    batchDeleteLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchDeleteLineItemsRequest request =
   *       BatchDeleteLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       lineItemServiceClient.batchDeleteLineItemsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsCallable() {
    return stub.batchDeleteLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchReserveLineItemsResponse response =
   *       lineItemServiceClient.batchReserveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to reserve. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveLineItemsResponse batchReserveLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchReserveLineItemsRequest request =
        BatchReserveLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchReserveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchReserveLineItemsResponse response =
   *       lineItemServiceClient.batchReserveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to reserve. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveLineItemsResponse batchReserveLineItems(
      String parent, List<String> names) {
    BatchReserveLineItemsRequest request =
        BatchReserveLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchReserveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReserveLineItemsRequest request =
   *       BatchReserveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchReserveLineItemsResponse response = lineItemServiceClient.batchReserveLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveLineItemsResponse batchReserveLineItems(
      BatchReserveLineItemsRequest request) {
    return batchReserveLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReserveLineItemsRequest request =
   *       BatchReserveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchReserveLineItemsResponse> future =
   *       lineItemServiceClient.batchReserveLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchReserveLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsCallable() {
    return stub.batchReserveLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchReserveAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchReserveAndOverbookLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to reserve and overbook. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveAndOverbookLineItemsResponse batchReserveAndOverbookLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchReserveAndOverbookLineItemsRequest request =
        BatchReserveAndOverbookLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchReserveAndOverbookLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchReserveAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchReserveAndOverbookLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to reserve and overbook. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveAndOverbookLineItemsResponse batchReserveAndOverbookLineItems(
      String parent, List<String> names) {
    BatchReserveAndOverbookLineItemsRequest request =
        BatchReserveAndOverbookLineItemsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchReserveAndOverbookLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReserveAndOverbookLineItemsRequest request =
   *       BatchReserveAndOverbookLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchReserveAndOverbookLineItemsResponse response =
   *       lineItemServiceClient.batchReserveAndOverbookLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveAndOverbookLineItemsResponse batchReserveAndOverbookLineItems(
      BatchReserveAndOverbookLineItemsRequest request) {
    return batchReserveAndOverbookLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch reserves and overbooks `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReserveAndOverbookLineItemsRequest request =
   *       BatchReserveAndOverbookLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchReserveAndOverbookLineItemsResponse> future =
   *       lineItemServiceClient.batchReserveAndOverbookLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchReserveAndOverbookLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsCallable() {
    return stub.batchReserveAndOverbookLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch releases `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchReleaseLineItemsResponse response =
   *       lineItemServiceClient.batchReleaseLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to release. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReleaseLineItemsResponse batchReleaseLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchReleaseLineItemsRequest request =
        BatchReleaseLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchReleaseLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch releases `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchReleaseLineItemsResponse response =
   *       lineItemServiceClient.batchReleaseLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to release. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReleaseLineItemsResponse batchReleaseLineItems(
      String parent, List<String> names) {
    BatchReleaseLineItemsRequest request =
        BatchReleaseLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchReleaseLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch releases `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReleaseLineItemsRequest request =
   *       BatchReleaseLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchReleaseLineItemsResponse response = lineItemServiceClient.batchReleaseLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReleaseLineItemsResponse batchReleaseLineItems(
      BatchReleaseLineItemsRequest request) {
    return batchReleaseLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch releases `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchReleaseLineItemsRequest request =
   *       BatchReleaseLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchReleaseLineItemsResponse> future =
   *       lineItemServiceClient.batchReleaseLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchReleaseLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsCallable() {
    return stub.batchReleaseLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveLineItemsResponse response =
   *       lineItemServiceClient.batchArchiveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to archive. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLineItemsResponse batchArchiveLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveLineItemsRequest request =
        BatchArchiveLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveLineItemsResponse response =
   *       lineItemServiceClient.batchArchiveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be updated. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to archive. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLineItemsResponse batchArchiveLineItems(
      String parent, List<String> names) {
    BatchArchiveLineItemsRequest request =
        BatchArchiveLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchArchiveLineItemsRequest request =
   *       BatchArchiveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveLineItemsResponse response = lineItemServiceClient.batchArchiveLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLineItemsResponse batchArchiveLineItems(
      BatchArchiveLineItemsRequest request) {
    return batchArchiveLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchArchiveLineItemsRequest request =
   *       BatchArchiveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveLineItemsResponse> future =
   *       lineItemServiceClient.batchArchiveLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsCallable() {
    return stub.batchArchiveLineItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveLineItemsResponse response =
   *       lineItemServiceClient.batchUnarchiveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be unarchived. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to extract. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveLineItemsResponse batchUnarchiveLineItems(
      @Nullable NetworkName parent, List<String> names) {
    BatchUnarchiveLineItemsRequest request =
        BatchUnarchiveLineItemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchUnarchiveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveLineItemsResponse response =
   *       lineItemServiceClient.batchUnarchiveLineItems(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LineItems` will be unarchived. Format:
   *     `networks/{network_code}`
   * @param names Required. The names of the `LineItem` objects to extract. Format:
   *     `networks/{network_code}/lineItems/{line_item}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveLineItemsResponse batchUnarchiveLineItems(
      String parent, List<String> names) {
    BatchUnarchiveLineItemsRequest request =
        BatchUnarchiveLineItemsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchUnarchiveLineItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchUnarchiveLineItemsRequest request =
   *       BatchUnarchiveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchUnarchiveLineItemsResponse response =
   *       lineItemServiceClient.batchUnarchiveLineItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveLineItemsResponse batchUnarchiveLineItems(
      BatchUnarchiveLineItemsRequest request) {
    return batchUnarchiveLineItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch unarchives `LineItem` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
   *   BatchUnarchiveLineItemsRequest request =
   *       BatchUnarchiveLineItemsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchUnarchiveLineItemsResponse> future =
   *       lineItemServiceClient.batchUnarchiveLineItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchUnarchiveLineItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsCallable() {
    return stub.batchUnarchiveLineItemsCallable();
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

  public static class ListLineItemsPagedResponse
      extends AbstractPagedListResponse<
          ListLineItemsRequest,
          ListLineItemsResponse,
          LineItem,
          ListLineItemsPage,
          ListLineItemsFixedSizeCollection> {

    public static ApiFuture<ListLineItemsPagedResponse> createAsync(
        PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ApiFuture<ListLineItemsResponse> futureResponse) {
      ApiFuture<ListLineItemsPage> futurePage =
          ListLineItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLineItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLineItemsPagedResponse(ListLineItemsPage page) {
      super(page, ListLineItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLineItemsPage
      extends AbstractPage<
          ListLineItemsRequest, ListLineItemsResponse, LineItem, ListLineItemsPage> {

    private ListLineItemsPage(
        @Nullable PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        @Nullable ListLineItemsResponse response) {
      super(context, response);
    }

    private static ListLineItemsPage createEmptyPage() {
      return new ListLineItemsPage(null, null);
    }

    @Override
    protected ListLineItemsPage createPage(
        @Nullable PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        @Nullable ListLineItemsResponse response) {
      return new ListLineItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListLineItemsPage> createPageAsync(
        @Nullable PageContext<ListLineItemsRequest, ListLineItemsResponse, LineItem> context,
        ApiFuture<ListLineItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLineItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLineItemsRequest,
          ListLineItemsResponse,
          LineItem,
          ListLineItemsPage,
          ListLineItemsFixedSizeCollection> {

    private ListLineItemsFixedSizeCollection(
        @Nullable List<ListLineItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLineItemsFixedSizeCollection createEmptyCollection() {
      return new ListLineItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLineItemsFixedSizeCollection createCollection(
        @Nullable List<ListLineItemsPage> pages, int collectionSize) {
      return new ListLineItemsFixedSizeCollection(pages, collectionSize);
    }
  }
}
