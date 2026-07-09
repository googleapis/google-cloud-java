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

import com.google.ads.admanager.v1.stub.LabelServiceStub;
import com.google.ads.admanager.v1.stub.LabelServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `Label` objects.
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
 * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
 *   LabelName name = LabelName.of("[NETWORK_CODE]", "[LABEL]");
 *   Label response = labelServiceClient.getLabel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LabelServiceClient object to clean up resources such
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
 *      <td><p> GetLabel</td>
 *      <td><p> API to retrieve a `Label` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLabel(GetLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLabel(LabelName name)
 *           <li><p> getLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLabels</td>
 *      <td><p> API to retrieve a list of `Label` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLabels(ListLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLabels(NetworkName parent)
 *           <li><p> listLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLabelsPagedCallable()
 *           <li><p> listLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLabel</td>
 *      <td><p> API to create a `Label` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLabel(CreateLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLabel(NetworkName parent, Label label)
 *           <li><p> createLabel(String parent, Label label)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateLabels</td>
 *      <td><p> API to batch create `Label` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateLabels(NetworkName parent, List&lt;CreateLabelRequest&gt; requests)
 *           <li><p> batchCreateLabels(String parent, List&lt;CreateLabelRequest&gt; requests)
 *           <li><p> batchCreateLabels(BatchCreateLabelsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLabel</td>
 *      <td><p> API to update a `Label` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLabel(UpdateLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLabel(Label label, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateLabels</td>
 *      <td><p> API to batch update `Label` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateLabels(NetworkName parent, List&lt;UpdateLabelRequest&gt; requests)
 *           <li><p> batchUpdateLabels(String parent, List&lt;UpdateLabelRequest&gt; requests)
 *           <li><p> batchUpdateLabels(BatchUpdateLabelsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateLabels</td>
 *      <td><p> API to activate `Label` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateLabels(BatchActivateLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateLabels(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateLabels(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateLabels</td>
 *      <td><p> API to deactivate `Label` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateLabels(BatchDeactivateLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateLabels(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateLabels(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateLabelsCallable()
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
 * <p>This class can be customized by passing in a custom instance of LabelServiceSettings to
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
 * LabelServiceSettings labelServiceSettings =
 *     LabelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LabelServiceClient labelServiceClient = LabelServiceClient.create(labelServiceSettings);
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
 * LabelServiceSettings labelServiceSettings =
 *     LabelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LabelServiceClient labelServiceClient = LabelServiceClient.create(labelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LabelServiceClient implements BackgroundResource {
  private final LabelServiceSettings settings;
  private final LabelServiceStub stub;

  /** Constructs an instance of LabelServiceClient with default settings. */
  public static final LabelServiceClient create() throws IOException {
    return create(LabelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LabelServiceClient create(LabelServiceSettings settings) throws IOException {
    return new LabelServiceClient(settings);
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LabelServiceSettings).
   */
  public static final LabelServiceClient create(LabelServiceStub stub) {
    return new LabelServiceClient(stub);
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LabelServiceClient(LabelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LabelServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LabelServiceClient(LabelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LabelServiceSettings getSettings() {
    return settings;
  }

  public LabelServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   LabelName name = LabelName.of("[NETWORK_CODE]", "[LABEL]");
   *   Label response = labelServiceClient.getLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(LabelName name) {
    GetLabelRequest request =
        GetLabelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String name = LabelName.of("[NETWORK_CODE]", "[LABEL]").toString();
   *   Label response = labelServiceClient.getLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(String name) {
    GetLabelRequest request = GetLabelRequest.newBuilder().setName(name).build();
    return getLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   GetLabelRequest request =
   *       GetLabelRequest.newBuilder()
   *           .setName(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
   *           .build();
   *   Label response = labelServiceClient.getLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(GetLabelRequest request) {
    return getLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   GetLabelRequest request =
   *       GetLabelRequest.newBuilder()
   *           .setName(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.getLabelCallable().futureCall(request);
   *   // Do something.
   *   Label response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLabelRequest, Label> getLabelCallable() {
    return stub.getLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Label element : labelServiceClient.listLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Labels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(NetworkName parent) {
    ListLabelsRequest request =
        ListLabelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Label element : labelServiceClient.listLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Labels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(String parent) {
    ListLabelsRequest request = ListLabelsRequest.newBuilder().setParent(parent).build();
    return listLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Label element : labelServiceClient.listLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(ListLabelsRequest request) {
    return listLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.listLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Label element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable() {
    return stub.listLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLabelsResponse response = labelServiceClient.listLabelsCallable().call(request);
   *     for (Label element : response.getLabelsList()) {
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
  public final UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable() {
    return stub.listLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Label label = Label.newBuilder().build();
   *   Label response = labelServiceClient.createLabel(parent, label);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Label` will be created. Format:
   *     `networks/{network_code}`
   * @param label Required. The `Label` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label createLabel(NetworkName parent, Label label) {
    CreateLabelRequest request =
        CreateLabelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLabel(label)
            .build();
    return createLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Label label = Label.newBuilder().build();
   *   Label response = labelServiceClient.createLabel(parent, label);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Label` will be created. Format:
   *     `networks/{network_code}`
   * @param label Required. The `Label` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label createLabel(String parent, Label label) {
    CreateLabelRequest request =
        CreateLabelRequest.newBuilder().setParent(parent).setLabel(label).build();
    return createLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   CreateLabelRequest request =
   *       CreateLabelRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLabel(Label.newBuilder().build())
   *           .build();
   *   Label response = labelServiceClient.createLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label createLabel(CreateLabelRequest request) {
    return createLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   CreateLabelRequest request =
   *       CreateLabelRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLabel(Label.newBuilder().build())
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.createLabelCallable().futureCall(request);
   *   // Do something.
   *   Label response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLabelRequest, Label> createLabelCallable() {
    return stub.createLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateLabelRequest> requests = new ArrayList<>();
   *   BatchCreateLabelsResponse response = labelServiceClient.batchCreateLabels(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Labels` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLabelRequest must match this field.
   * @param requests Required. The `Label` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLabelsResponse batchCreateLabels(
      NetworkName parent, List<CreateLabelRequest> requests) {
    BatchCreateLabelsRequest request =
        BatchCreateLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateLabelRequest> requests = new ArrayList<>();
   *   BatchCreateLabelsResponse response = labelServiceClient.batchCreateLabels(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Labels` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLabelRequest must match this field.
   * @param requests Required. The `Label` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLabelsResponse batchCreateLabels(
      String parent, List<CreateLabelRequest> requests) {
    BatchCreateLabelsRequest request =
        BatchCreateLabelsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchCreateLabelsRequest request =
   *       BatchCreateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLabelRequest>())
   *           .build();
   *   BatchCreateLabelsResponse response = labelServiceClient.batchCreateLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLabelsResponse batchCreateLabels(BatchCreateLabelsRequest request) {
    return batchCreateLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchCreateLabelsRequest request =
   *       BatchCreateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLabelRequest>())
   *           .build();
   *   ApiFuture<BatchCreateLabelsResponse> future =
   *       labelServiceClient.batchCreateLabelsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
      batchCreateLabelsCallable() {
    return stub.batchCreateLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   Label label = Label.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Label response = labelServiceClient.updateLabel(label, updateMask);
   * }
   * }</pre>
   *
   * @param label Required. The `Label` to update.
   *     <p>The `Label`'s `name` is used to identify the `Label` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label updateLabel(Label label, FieldMask updateMask) {
    UpdateLabelRequest request =
        UpdateLabelRequest.newBuilder().setLabel(label).setUpdateMask(updateMask).build();
    return updateLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   UpdateLabelRequest request =
   *       UpdateLabelRequest.newBuilder()
   *           .setLabel(Label.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Label response = labelServiceClient.updateLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label updateLabel(UpdateLabelRequest request) {
    return updateLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Label` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   UpdateLabelRequest request =
   *       UpdateLabelRequest.newBuilder()
   *           .setLabel(Label.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.updateLabelCallable().futureCall(request);
   *   // Do something.
   *   Label response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLabelRequest, Label> updateLabelCallable() {
    return stub.updateLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateLabelRequest> requests = new ArrayList<>();
   *   BatchUpdateLabelsResponse response = labelServiceClient.batchUpdateLabels(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Labels` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateLabelRequest must match this field.
   * @param requests Required. The `Label` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLabelsResponse batchUpdateLabels(
      NetworkName parent, List<UpdateLabelRequest> requests) {
    BatchUpdateLabelsRequest request =
        BatchUpdateLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateLabelRequest> requests = new ArrayList<>();
   *   BatchUpdateLabelsResponse response = labelServiceClient.batchUpdateLabels(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Labels` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateLabelRequest must match this field.
   * @param requests Required. The `Label` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLabelsResponse batchUpdateLabels(
      String parent, List<UpdateLabelRequest> requests) {
    BatchUpdateLabelsRequest request =
        BatchUpdateLabelsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchUpdateLabelsRequest request =
   *       BatchUpdateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLabelRequest>())
   *           .build();
   *   BatchUpdateLabelsResponse response = labelServiceClient.batchUpdateLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLabelsResponse batchUpdateLabels(BatchUpdateLabelsRequest request) {
    return batchUpdateLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchUpdateLabelsRequest request =
   *       BatchUpdateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLabelRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateLabelsResponse> future =
   *       labelServiceClient.batchUpdateLabelsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
      batchUpdateLabelsCallable() {
    return stub.batchUpdateLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to activate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLabelsResponse response = labelServiceClient.batchActivateLabels(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLabelsResponse batchActivateLabels(
      NetworkName parent, List<String> names) {
    BatchActivateLabelsRequest request =
        BatchActivateLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to activate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLabelsResponse response = labelServiceClient.batchActivateLabels(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLabelsResponse batchActivateLabels(String parent, List<String> names) {
    BatchActivateLabelsRequest request =
        BatchActivateLabelsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to activate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchActivateLabelsRequest request =
   *       BatchActivateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateLabelsResponse response = labelServiceClient.batchActivateLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLabelsResponse batchActivateLabels(BatchActivateLabelsRequest request) {
    return batchActivateLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to activate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchActivateLabelsRequest request =
   *       BatchActivateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateLabelsResponse> future =
   *       labelServiceClient.batchActivateLabelsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
      batchActivateLabelsCallable() {
    return stub.batchActivateLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to deactivate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateLabelsResponse response =
   *       labelServiceClient.batchDeactivateLabels(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLabelsResponse batchDeactivateLabels(
      NetworkName parent, List<String> names) {
    BatchDeactivateLabelsRequest request =
        BatchDeactivateLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to deactivate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateLabelsResponse response =
   *       labelServiceClient.batchDeactivateLabels(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLabelsResponse batchDeactivateLabels(
      String parent, List<String> names) {
    BatchDeactivateLabelsRequest request =
        BatchDeactivateLabelsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivateLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to deactivate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchDeactivateLabelsRequest request =
   *       BatchDeactivateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateLabelsResponse response = labelServiceClient.batchDeactivateLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateLabelsResponse batchDeactivateLabels(
      BatchDeactivateLabelsRequest request) {
    return batchDeactivateLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to deactivate `Label` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   BatchDeactivateLabelsRequest request =
   *       BatchDeactivateLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateLabelsResponse> future =
   *       labelServiceClient.batchDeactivateLabelsCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateLabelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
      batchDeactivateLabelsCallable() {
    return stub.batchDeactivateLabelsCallable();
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

  public static class ListLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListLabelsRequest,
          ListLabelsResponse,
          Label,
          ListLabelsPage,
          ListLabelsFixedSizeCollection> {

    public static ApiFuture<ListLabelsPagedResponse> createAsync(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ApiFuture<ListLabelsResponse> futureResponse) {
      ApiFuture<ListLabelsPage> futurePage =
          ListLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLabelsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLabelsPagedResponse(ListLabelsPage page) {
      super(page, ListLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLabelsPage
      extends AbstractPage<ListLabelsRequest, ListLabelsResponse, Label, ListLabelsPage> {

    private ListLabelsPage(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ListLabelsResponse response) {
      super(context, response);
    }

    private static ListLabelsPage createEmptyPage() {
      return new ListLabelsPage(null, null);
    }

    @Override
    protected ListLabelsPage createPage(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ListLabelsResponse response) {
      return new ListLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListLabelsPage> createPageAsync(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ApiFuture<ListLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLabelsRequest,
          ListLabelsResponse,
          Label,
          ListLabelsPage,
          ListLabelsFixedSizeCollection> {

    private ListLabelsFixedSizeCollection(List<ListLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLabelsFixedSizeCollection createEmptyCollection() {
      return new ListLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLabelsFixedSizeCollection createCollection(
        List<ListLabelsPage> pages, int collectionSize) {
      return new ListLabelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
