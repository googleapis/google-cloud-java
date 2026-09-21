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

import com.google.ads.admanager.v1.stub.BreakTemplateServiceStub;
import com.google.ads.admanager.v1.stub.BreakTemplateServiceStubSettings;
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
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `BreakTemplate` objects.
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
 * try (BreakTemplateServiceClient breakTemplateServiceClient =
 *     BreakTemplateServiceClient.create()) {
 *   BreakTemplateName name = BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]");
 *   BreakTemplate response = breakTemplateServiceClient.getBreakTemplate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BreakTemplateServiceClient object to clean up
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
 *      <td><p> GetBreakTemplate</td>
 *      <td><p> Retrieves a `BreakTemplate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBreakTemplate(GetBreakTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBreakTemplate(BreakTemplateName name)
 *           <li><p> getBreakTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBreakTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBreakTemplates</td>
 *      <td><p> Lists `BreakTemplate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBreakTemplates(ListBreakTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBreakTemplates(NetworkName parent)
 *           <li><p> listBreakTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBreakTemplatesPagedCallable()
 *           <li><p> listBreakTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBreakTemplate</td>
 *      <td><p> Creates a `BreakTemplate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBreakTemplate(CreateBreakTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBreakTemplate(NetworkName parent, BreakTemplate breakTemplate)
 *           <li><p> createBreakTemplate(String parent, BreakTemplate breakTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBreakTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateBreakTemplates</td>
 *      <td><p> Batch creates `BreakTemplate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateBreakTemplates(NetworkName parent, List&lt;CreateBreakTemplateRequest&gt; requests)
 *           <li><p> batchCreateBreakTemplates(String parent, List&lt;CreateBreakTemplateRequest&gt; requests)
 *           <li><p> batchCreateBreakTemplates(BatchCreateBreakTemplatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateBreakTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBreakTemplate</td>
 *      <td><p> Updates a `BreakTemplate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBreakTemplate(UpdateBreakTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBreakTemplate(BreakTemplate breakTemplate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBreakTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateBreakTemplates</td>
 *      <td><p> Batch updates `BreakTemplate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateBreakTemplates(NetworkName parent, List&lt;UpdateBreakTemplateRequest&gt; requests)
 *           <li><p> batchUpdateBreakTemplates(String parent, List&lt;UpdateBreakTemplateRequest&gt; requests)
 *           <li><p> batchUpdateBreakTemplates(BatchUpdateBreakTemplatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateBreakTemplatesCallable()
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
 * <p>This class can be customized by passing in a custom instance of BreakTemplateServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BreakTemplateServiceSettings breakTemplateServiceSettings =
 *     BreakTemplateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BreakTemplateServiceClient breakTemplateServiceClient =
 *     BreakTemplateServiceClient.create(breakTemplateServiceSettings);
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
 * BreakTemplateServiceSettings breakTemplateServiceSettings =
 *     BreakTemplateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BreakTemplateServiceClient breakTemplateServiceClient =
 *     BreakTemplateServiceClient.create(breakTemplateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class BreakTemplateServiceClient implements BackgroundResource {
  private final @Nullable BreakTemplateServiceSettings settings;
  private final BreakTemplateServiceStub stub;

  /** Constructs an instance of BreakTemplateServiceClient with default settings. */
  public static final BreakTemplateServiceClient create() throws IOException {
    return create(BreakTemplateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BreakTemplateServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BreakTemplateServiceClient create(BreakTemplateServiceSettings settings)
      throws IOException {
    return new BreakTemplateServiceClient(settings);
  }

  /**
   * Constructs an instance of BreakTemplateServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BreakTemplateServiceSettings).
   */
  public static final BreakTemplateServiceClient create(BreakTemplateServiceStub stub) {
    return new BreakTemplateServiceClient(stub);
  }

  /**
   * Constructs an instance of BreakTemplateServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BreakTemplateServiceClient(BreakTemplateServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BreakTemplateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BreakTemplateServiceClient(BreakTemplateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable BreakTemplateServiceSettings getSettings() {
    return settings;
  }

  public BreakTemplateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BreakTemplateName name = BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]");
   *   BreakTemplate response = breakTemplateServiceClient.getBreakTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BreakTemplate`. Format:
   *     `networks/{network_code}/breakTemplates/{break_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate getBreakTemplate(@Nullable BreakTemplateName name) {
    GetBreakTemplateRequest request =
        GetBreakTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBreakTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   String name = BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString();
   *   BreakTemplate response = breakTemplateServiceClient.getBreakTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BreakTemplate`. Format:
   *     `networks/{network_code}/breakTemplates/{break_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate getBreakTemplate(String name) {
    GetBreakTemplateRequest request = GetBreakTemplateRequest.newBuilder().setName(name).build();
    return getBreakTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   GetBreakTemplateRequest request =
   *       GetBreakTemplateRequest.newBuilder()
   *           .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
   *           .build();
   *   BreakTemplate response = breakTemplateServiceClient.getBreakTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate getBreakTemplate(GetBreakTemplateRequest request) {
    return getBreakTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   GetBreakTemplateRequest request =
   *       GetBreakTemplateRequest.newBuilder()
   *           .setName(BreakTemplateName.of("[NETWORK_CODE]", "[BREAK_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<BreakTemplate> future =
   *       breakTemplateServiceClient.getBreakTemplateCallable().futureCall(request);
   *   // Do something.
   *   BreakTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateCallable() {
    return stub.getBreakTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (BreakTemplate element :
   *       breakTemplateServiceClient.listBreakTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `BreakTemplates`. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBreakTemplatesPagedResponse listBreakTemplates(@Nullable NetworkName parent) {
    ListBreakTemplatesRequest request =
        ListBreakTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (BreakTemplate element :
   *       breakTemplateServiceClient.listBreakTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of `BreakTemplates`. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBreakTemplatesPagedResponse listBreakTemplates(String parent) {
    ListBreakTemplatesRequest request =
        ListBreakTemplatesRequest.newBuilder().setParent(parent).build();
    return listBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   ListBreakTemplatesRequest request =
   *       ListBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (BreakTemplate element :
   *       breakTemplateServiceClient.listBreakTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBreakTemplatesPagedResponse listBreakTemplates(
      ListBreakTemplatesRequest request) {
    return listBreakTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   ListBreakTemplatesRequest request =
   *       ListBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<BreakTemplate> future =
   *       breakTemplateServiceClient.listBreakTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BreakTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesPagedResponse>
      listBreakTemplatesPagedCallable() {
    return stub.listBreakTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   ListBreakTemplatesRequest request =
   *       ListBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListBreakTemplatesResponse response =
   *         breakTemplateServiceClient.listBreakTemplatesCallable().call(request);
   *     for (BreakTemplate element : response.getBreakTemplatesList()) {
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
  public final UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
      listBreakTemplatesCallable() {
    return stub.listBreakTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();
   *   BreakTemplate response =
   *       breakTemplateServiceClient.createBreakTemplate(parent, breakTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `BreakTemplate` will be created. Format:
   *     `networks/{network_code}`
   * @param breakTemplate Required. The `BreakTemplate` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate createBreakTemplate(
      @Nullable NetworkName parent, BreakTemplate breakTemplate) {
    CreateBreakTemplateRequest request =
        CreateBreakTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBreakTemplate(breakTemplate)
            .build();
    return createBreakTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();
   *   BreakTemplate response =
   *       breakTemplateServiceClient.createBreakTemplate(parent, breakTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `BreakTemplate` will be created. Format:
   *     `networks/{network_code}`
   * @param breakTemplate Required. The `BreakTemplate` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate createBreakTemplate(String parent, BreakTemplate breakTemplate) {
    CreateBreakTemplateRequest request =
        CreateBreakTemplateRequest.newBuilder()
            .setParent(parent)
            .setBreakTemplate(breakTemplate)
            .build();
    return createBreakTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   CreateBreakTemplateRequest request =
   *       CreateBreakTemplateRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setBreakTemplate(BreakTemplate.newBuilder().build())
   *           .build();
   *   BreakTemplate response = breakTemplateServiceClient.createBreakTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate createBreakTemplate(CreateBreakTemplateRequest request) {
    return createBreakTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   CreateBreakTemplateRequest request =
   *       CreateBreakTemplateRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setBreakTemplate(BreakTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<BreakTemplate> future =
   *       breakTemplateServiceClient.createBreakTemplateCallable().futureCall(request);
   *   // Do something.
   *   BreakTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBreakTemplateRequest, BreakTemplate>
      createBreakTemplateCallable() {
    return stub.createBreakTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateBreakTemplateRequest> requests = new ArrayList<>();
   *   BatchCreateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchCreateBreakTemplates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `BreakTemplates` will be created. Format:
   *     `networks/{network_code}` The parent field in the `CreateBreakTemplateRequest` must match
   *     this field.
   * @param requests Required. The `BreakTemplate` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateBreakTemplatesResponse batchCreateBreakTemplates(
      @Nullable NetworkName parent, List<CreateBreakTemplateRequest> requests) {
    BatchCreateBreakTemplatesRequest request =
        BatchCreateBreakTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateBreakTemplateRequest> requests = new ArrayList<>();
   *   BatchCreateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchCreateBreakTemplates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `BreakTemplates` will be created. Format:
   *     `networks/{network_code}` The parent field in the `CreateBreakTemplateRequest` must match
   *     this field.
   * @param requests Required. The `BreakTemplate` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateBreakTemplatesResponse batchCreateBreakTemplates(
      String parent, List<CreateBreakTemplateRequest> requests) {
    BatchCreateBreakTemplatesRequest request =
        BatchCreateBreakTemplatesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BatchCreateBreakTemplatesRequest request =
   *       BatchCreateBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateBreakTemplateRequest>())
   *           .build();
   *   BatchCreateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchCreateBreakTemplates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateBreakTemplatesResponse batchCreateBreakTemplates(
      BatchCreateBreakTemplatesRequest request) {
    return batchCreateBreakTemplatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BatchCreateBreakTemplatesRequest request =
   *       BatchCreateBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateBreakTemplateRequest>())
   *           .build();
   *   ApiFuture<BatchCreateBreakTemplatesResponse> future =
   *       breakTemplateServiceClient.batchCreateBreakTemplatesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateBreakTemplatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesCallable() {
    return stub.batchCreateBreakTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BreakTemplate breakTemplate = BreakTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BreakTemplate response =
   *       breakTemplateServiceClient.updateBreakTemplate(breakTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param breakTemplate Required. The `BreakTemplate` to update.
   *     <p>The `BreakTemplate`'s `name` is used to identify the `BreakTemplate` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate updateBreakTemplate(
      BreakTemplate breakTemplate, FieldMask updateMask) {
    UpdateBreakTemplateRequest request =
        UpdateBreakTemplateRequest.newBuilder()
            .setBreakTemplate(breakTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateBreakTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   UpdateBreakTemplateRequest request =
   *       UpdateBreakTemplateRequest.newBuilder()
   *           .setBreakTemplate(BreakTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BreakTemplate response = breakTemplateServiceClient.updateBreakTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BreakTemplate updateBreakTemplate(UpdateBreakTemplateRequest request) {
    return updateBreakTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `BreakTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   UpdateBreakTemplateRequest request =
   *       UpdateBreakTemplateRequest.newBuilder()
   *           .setBreakTemplate(BreakTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BreakTemplate> future =
   *       breakTemplateServiceClient.updateBreakTemplateCallable().futureCall(request);
   *   // Do something.
   *   BreakTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBreakTemplateRequest, BreakTemplate>
      updateBreakTemplateCallable() {
    return stub.updateBreakTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateBreakTemplateRequest> requests = new ArrayList<>();
   *   BatchUpdateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchUpdateBreakTemplates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `BreakTemplates` will be updated. Format:
   *     `networks/{network_code}` The parent field in the `UpdateBreakTemplateRequest` must match
   *     this field.
   * @param requests Required. The `BreakTemplate` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateBreakTemplatesResponse batchUpdateBreakTemplates(
      @Nullable NetworkName parent, List<UpdateBreakTemplateRequest> requests) {
    BatchUpdateBreakTemplatesRequest request =
        BatchUpdateBreakTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateBreakTemplateRequest> requests = new ArrayList<>();
   *   BatchUpdateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchUpdateBreakTemplates(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `BreakTemplates` will be updated. Format:
   *     `networks/{network_code}` The parent field in the `UpdateBreakTemplateRequest` must match
   *     this field.
   * @param requests Required. The `BreakTemplate` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateBreakTemplatesResponse batchUpdateBreakTemplates(
      String parent, List<UpdateBreakTemplateRequest> requests) {
    BatchUpdateBreakTemplatesRequest request =
        BatchUpdateBreakTemplatesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateBreakTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BatchUpdateBreakTemplatesRequest request =
   *       BatchUpdateBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateBreakTemplateRequest>())
   *           .build();
   *   BatchUpdateBreakTemplatesResponse response =
   *       breakTemplateServiceClient.batchUpdateBreakTemplates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateBreakTemplatesResponse batchUpdateBreakTemplates(
      BatchUpdateBreakTemplatesRequest request) {
    return batchUpdateBreakTemplatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `BreakTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BreakTemplateServiceClient breakTemplateServiceClient =
   *     BreakTemplateServiceClient.create()) {
   *   BatchUpdateBreakTemplatesRequest request =
   *       BatchUpdateBreakTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateBreakTemplateRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateBreakTemplatesResponse> future =
   *       breakTemplateServiceClient.batchUpdateBreakTemplatesCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateBreakTemplatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesCallable() {
    return stub.batchUpdateBreakTemplatesCallable();
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

  public static class ListBreakTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListBreakTemplatesRequest,
          ListBreakTemplatesResponse,
          BreakTemplate,
          ListBreakTemplatesPage,
          ListBreakTemplatesFixedSizeCollection> {

    public static ApiFuture<ListBreakTemplatesPagedResponse> createAsync(
        PageContext<ListBreakTemplatesRequest, ListBreakTemplatesResponse, BreakTemplate> context,
        ApiFuture<ListBreakTemplatesResponse> futureResponse) {
      ApiFuture<ListBreakTemplatesPage> futurePage =
          ListBreakTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBreakTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBreakTemplatesPagedResponse(ListBreakTemplatesPage page) {
      super(page, ListBreakTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBreakTemplatesPage
      extends AbstractPage<
          ListBreakTemplatesRequest,
          ListBreakTemplatesResponse,
          BreakTemplate,
          ListBreakTemplatesPage> {

    private ListBreakTemplatesPage(
        @Nullable PageContext<ListBreakTemplatesRequest, ListBreakTemplatesResponse, BreakTemplate>
            context,
        @Nullable ListBreakTemplatesResponse response) {
      super(context, response);
    }

    private static ListBreakTemplatesPage createEmptyPage() {
      return new ListBreakTemplatesPage(null, null);
    }

    @Override
    protected ListBreakTemplatesPage createPage(
        @Nullable PageContext<ListBreakTemplatesRequest, ListBreakTemplatesResponse, BreakTemplate>
            context,
        @Nullable ListBreakTemplatesResponse response) {
      return new ListBreakTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListBreakTemplatesPage> createPageAsync(
        @Nullable PageContext<ListBreakTemplatesRequest, ListBreakTemplatesResponse, BreakTemplate>
            context,
        ApiFuture<ListBreakTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBreakTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBreakTemplatesRequest,
          ListBreakTemplatesResponse,
          BreakTemplate,
          ListBreakTemplatesPage,
          ListBreakTemplatesFixedSizeCollection> {

    private ListBreakTemplatesFixedSizeCollection(
        @Nullable List<ListBreakTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBreakTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListBreakTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBreakTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListBreakTemplatesPage> pages, int collectionSize) {
      return new ListBreakTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
