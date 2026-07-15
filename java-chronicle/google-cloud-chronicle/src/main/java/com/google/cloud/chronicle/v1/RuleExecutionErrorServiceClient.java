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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.RuleExecutionErrorServiceStub;
import com.google.cloud.chronicle.v1.stub.RuleExecutionErrorServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: RuleExecutionErrorService contains endpoints related to rule execution
 * errors.
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
 * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
 *     RuleExecutionErrorServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   for (RuleExecutionError element :
 *       ruleExecutionErrorServiceClient.listRuleExecutionErrors(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RuleExecutionErrorServiceClient object to clean up
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
 *      <td><p> ListRuleExecutionErrors</td>
 *      <td><p> Lists rule execution errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRuleExecutionErrors(ListRuleExecutionErrorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRuleExecutionErrors(InstanceName parent)
 *           <li><p> listRuleExecutionErrors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRuleExecutionErrorsPagedCallable()
 *           <li><p> listRuleExecutionErrorsCallable()
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
 * RuleExecutionErrorServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleExecutionErrorServiceSettings ruleExecutionErrorServiceSettings =
 *     RuleExecutionErrorServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
 *     RuleExecutionErrorServiceClient.create(ruleExecutionErrorServiceSettings);
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
 * RuleExecutionErrorServiceSettings ruleExecutionErrorServiceSettings =
 *     RuleExecutionErrorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
 *     RuleExecutionErrorServiceClient.create(ruleExecutionErrorServiceSettings);
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
 * RuleExecutionErrorServiceSettings ruleExecutionErrorServiceSettings =
 *     RuleExecutionErrorServiceSettings.newHttpJsonBuilder().build();
 * RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
 *     RuleExecutionErrorServiceClient.create(ruleExecutionErrorServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class RuleExecutionErrorServiceClient implements BackgroundResource {
  private final @Nullable RuleExecutionErrorServiceSettings settings;
  private final RuleExecutionErrorServiceStub stub;

  /** Constructs an instance of RuleExecutionErrorServiceClient with default settings. */
  public static final RuleExecutionErrorServiceClient create() throws IOException {
    return create(RuleExecutionErrorServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RuleExecutionErrorServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RuleExecutionErrorServiceClient create(
      RuleExecutionErrorServiceSettings settings) throws IOException {
    return new RuleExecutionErrorServiceClient(settings);
  }

  /**
   * Constructs an instance of RuleExecutionErrorServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RuleExecutionErrorServiceSettings).
   */
  public static final RuleExecutionErrorServiceClient create(RuleExecutionErrorServiceStub stub) {
    return new RuleExecutionErrorServiceClient(stub);
  }

  /**
   * Constructs an instance of RuleExecutionErrorServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RuleExecutionErrorServiceClient(RuleExecutionErrorServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RuleExecutionErrorServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RuleExecutionErrorServiceClient(RuleExecutionErrorServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable RuleExecutionErrorServiceSettings getSettings() {
    return settings;
  }

  public RuleExecutionErrorServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rule execution errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
   *     RuleExecutionErrorServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (RuleExecutionError element :
   *       ruleExecutionErrorServiceClient.listRuleExecutionErrors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list rule execution errors from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleExecutionErrorsPagedResponse listRuleExecutionErrors(
      @Nullable InstanceName parent) {
    ListRuleExecutionErrorsRequest request =
        ListRuleExecutionErrorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRuleExecutionErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rule execution errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
   *     RuleExecutionErrorServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (RuleExecutionError element :
   *       ruleExecutionErrorServiceClient.listRuleExecutionErrors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list rule execution errors from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleExecutionErrorsPagedResponse listRuleExecutionErrors(String parent) {
    ListRuleExecutionErrorsRequest request =
        ListRuleExecutionErrorsRequest.newBuilder().setParent(parent).build();
    return listRuleExecutionErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rule execution errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
   *     RuleExecutionErrorServiceClient.create()) {
   *   ListRuleExecutionErrorsRequest request =
   *       ListRuleExecutionErrorsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (RuleExecutionError element :
   *       ruleExecutionErrorServiceClient.listRuleExecutionErrors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRuleExecutionErrorsPagedResponse listRuleExecutionErrors(
      ListRuleExecutionErrorsRequest request) {
    return listRuleExecutionErrorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rule execution errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
   *     RuleExecutionErrorServiceClient.create()) {
   *   ListRuleExecutionErrorsRequest request =
   *       ListRuleExecutionErrorsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<RuleExecutionError> future =
   *       ruleExecutionErrorServiceClient
   *           .listRuleExecutionErrorsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (RuleExecutionError element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsPagedResponse>
      listRuleExecutionErrorsPagedCallable() {
    return stub.listRuleExecutionErrorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rule execution errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RuleExecutionErrorServiceClient ruleExecutionErrorServiceClient =
   *     RuleExecutionErrorServiceClient.create()) {
   *   ListRuleExecutionErrorsRequest request =
   *       ListRuleExecutionErrorsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRuleExecutionErrorsResponse response =
   *         ruleExecutionErrorServiceClient.listRuleExecutionErrorsCallable().call(request);
   *     for (RuleExecutionError element : response.getRuleExecutionErrorsList()) {
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
  public final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsCallable() {
    return stub.listRuleExecutionErrorsCallable();
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

  public static class ListRuleExecutionErrorsPagedResponse
      extends AbstractPagedListResponse<
          ListRuleExecutionErrorsRequest,
          ListRuleExecutionErrorsResponse,
          RuleExecutionError,
          ListRuleExecutionErrorsPage,
          ListRuleExecutionErrorsFixedSizeCollection> {

    public static ApiFuture<ListRuleExecutionErrorsPagedResponse> createAsync(
        PageContext<
                ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse, RuleExecutionError>
            context,
        ApiFuture<ListRuleExecutionErrorsResponse> futureResponse) {
      ApiFuture<ListRuleExecutionErrorsPage> futurePage =
          ListRuleExecutionErrorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRuleExecutionErrorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRuleExecutionErrorsPagedResponse(ListRuleExecutionErrorsPage page) {
      super(page, ListRuleExecutionErrorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRuleExecutionErrorsPage
      extends AbstractPage<
          ListRuleExecutionErrorsRequest,
          ListRuleExecutionErrorsResponse,
          RuleExecutionError,
          ListRuleExecutionErrorsPage> {

    private ListRuleExecutionErrorsPage(
        @Nullable
            PageContext<
                ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse, RuleExecutionError>
            context,
        @Nullable ListRuleExecutionErrorsResponse response) {
      super(context, response);
    }

    private static ListRuleExecutionErrorsPage createEmptyPage() {
      return new ListRuleExecutionErrorsPage(null, null);
    }

    @Override
    protected ListRuleExecutionErrorsPage createPage(
        @Nullable
            PageContext<
                ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse, RuleExecutionError>
            context,
        @Nullable ListRuleExecutionErrorsResponse response) {
      return new ListRuleExecutionErrorsPage(context, response);
    }

    @Override
    public ApiFuture<ListRuleExecutionErrorsPage> createPageAsync(
        @Nullable
            PageContext<
                ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse, RuleExecutionError>
            context,
        ApiFuture<ListRuleExecutionErrorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRuleExecutionErrorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRuleExecutionErrorsRequest,
          ListRuleExecutionErrorsResponse,
          RuleExecutionError,
          ListRuleExecutionErrorsPage,
          ListRuleExecutionErrorsFixedSizeCollection> {

    private ListRuleExecutionErrorsFixedSizeCollection(
        @Nullable List<ListRuleExecutionErrorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRuleExecutionErrorsFixedSizeCollection createEmptyCollection() {
      return new ListRuleExecutionErrorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRuleExecutionErrorsFixedSizeCollection createCollection(
        @Nullable List<ListRuleExecutionErrorsPage> pages, int collectionSize) {
      return new ListRuleExecutionErrorsFixedSizeCollection(pages, collectionSize);
    }
  }
}
