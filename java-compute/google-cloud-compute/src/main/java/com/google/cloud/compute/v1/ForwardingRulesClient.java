/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ForwardingRulesStub;
import com.google.cloud.compute.v1.stub.ForwardingRulesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The ForwardingRules API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String forwardingRule = "";
 *   Operation response = forwardingRulesClient.delete(project, region, forwardingRule);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the forwardingRulesClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ForwardingRulesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ForwardingRulesSettings forwardingRulesSettings =
 *     ForwardingRulesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ForwardingRulesClient forwardingRulesClient =
 *     ForwardingRulesClient.create(forwardingRulesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ForwardingRulesSettings forwardingRulesSettings =
 *     ForwardingRulesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ForwardingRulesClient forwardingRulesClient =
 *     ForwardingRulesClient.create(forwardingRulesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ForwardingRulesClient implements BackgroundResource {
  private final ForwardingRulesSettings settings;
  private final ForwardingRulesStub stub;

  /** Constructs an instance of ForwardingRulesClient with default settings. */
  public static final ForwardingRulesClient create() throws IOException {
    return create(ForwardingRulesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ForwardingRulesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ForwardingRulesClient create(ForwardingRulesSettings settings)
      throws IOException {
    return new ForwardingRulesClient(settings);
  }

  /**
   * Constructs an instance of ForwardingRulesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ForwardingRulesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ForwardingRulesClient create(ForwardingRulesStub stub) {
    return new ForwardingRulesClient(stub);
  }

  /**
   * Constructs an instance of ForwardingRulesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ForwardingRulesClient(ForwardingRulesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ForwardingRulesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ForwardingRulesClient(ForwardingRulesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ForwardingRulesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ForwardingRulesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, ForwardingRulesScopedList&gt; element : forwardingRulesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListForwardingRulesRequest request =
        AggregatedListForwardingRulesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   AggregatedListForwardingRulesRequest request = AggregatedListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, ForwardingRulesScopedList&gt; element : forwardingRulesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListForwardingRulesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   AggregatedListForwardingRulesRequest request = AggregatedListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = forwardingRulesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, ForwardingRulesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListForwardingRulesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of forwarding rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   AggregatedListForwardingRulesRequest request = AggregatedListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     ForwardingRuleAggregatedList response = forwardingRulesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, ForwardingRulesScopedList&gt; element : response.getItemsMap()) {
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
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListForwardingRulesRequest, ForwardingRuleAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String forwardingRule = "";
   *   Operation response = forwardingRulesClient.delete(project, region, forwardingRule);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param forwardingRule Name of the ForwardingRule resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String forwardingRule) {
    DeleteForwardingRuleRequest request =
        DeleteForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setForwardingRule(forwardingRule)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   DeleteForwardingRuleRequest request = DeleteForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = forwardingRulesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteForwardingRuleRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   DeleteForwardingRuleRequest request = DeleteForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRulesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteForwardingRuleRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String forwardingRule = "";
   *   ForwardingRule response = forwardingRulesClient.get(project, region, forwardingRule);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param forwardingRule Name of the ForwardingRule resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForwardingRule get(String project, String region, String forwardingRule) {
    GetForwardingRuleRequest request =
        GetForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setForwardingRule(forwardingRule)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   GetForwardingRuleRequest request = GetForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ForwardingRule response = forwardingRulesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ForwardingRule get(GetForwardingRuleRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified ForwardingRule resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   GetForwardingRuleRequest request = GetForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ForwardingRule&gt; future = forwardingRulesClient.getCallable().futureCall(request);
   *   // Do something
   *   ForwardingRule response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetForwardingRuleRequest, ForwardingRule> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = forwardingRulesClient.insert(project, region, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, ForwardingRule forwardingRuleResource) {
    InsertForwardingRuleRequest request =
        InsertForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertForwardingRuleRequest request = InsertForwardingRuleRequest.newBuilder()
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = forwardingRulesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertForwardingRuleRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a ForwardingRule resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertForwardingRuleRequest request = InsertForwardingRuleRequest.newBuilder()
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRulesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertForwardingRuleRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (ForwardingRule element : forwardingRulesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListForwardingRulesRequest request =
        ListForwardingRulesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListForwardingRulesRequest request = ListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (ForwardingRule element : forwardingRulesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListForwardingRulesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListForwardingRulesRequest request = ListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = forwardingRulesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (ForwardingRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListForwardingRulesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of ForwardingRule resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListForwardingRulesRequest request = ListForwardingRulesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     ForwardingRuleList response = forwardingRulesClient.listCallable().call(request);
   *     for (ForwardingRule element : response.getItemsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListForwardingRulesRequest, ForwardingRuleList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   Operation response = forwardingRulesClient.patch(project, region, forwardingRule, forwardingRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param forwardingRule Name of the ForwardingRule resource to patch.
   * @param forwardingRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String region, String forwardingRule, ForwardingRule forwardingRuleResource) {
    PatchForwardingRuleRequest request =
        PatchForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setForwardingRule(forwardingRule)
            .setForwardingRuleResource(forwardingRuleResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchForwardingRuleRequest request = PatchForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = forwardingRulesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchForwardingRuleRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified forwarding rule with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently,
   * you can only patch the network_tier field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   ForwardingRule forwardingRuleResource = ForwardingRule.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchForwardingRuleRequest request = PatchForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setForwardingRuleResource(forwardingRuleResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRulesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchForwardingRuleRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String forwardingRule = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = forwardingRulesClient.setTarget(project, region, forwardingRule, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param forwardingRule Name of the ForwardingRule resource in which target is to be set.
   * @param targetReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTarget(
      String project,
      String region,
      String forwardingRule,
      TargetReference targetReferenceResource) {
    SetTargetForwardingRuleRequest request =
        SetTargetForwardingRuleRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setForwardingRule(forwardingRule)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setTarget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetForwardingRuleRequest request = SetTargetForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = forwardingRulesClient.setTarget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTarget(SetTargetForwardingRuleRequest request) {
    return setTargetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes target URL for forwarding rule. The new target should be of the same type as the old
   * target.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ForwardingRulesClient forwardingRulesClient = ForwardingRulesClient.create()) {
   *   String forwardingRule = "";
   *   String project = "";
   *   String region = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetTargetForwardingRuleRequest request = SetTargetForwardingRuleRequest.newBuilder()
   *     .setForwardingRule(forwardingRule)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = forwardingRulesClient.setTargetCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetTargetForwardingRuleRequest, Operation> setTargetCallable() {
    return stub.setTargetCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListForwardingRulesRequest,
          ForwardingRuleAggregatedList,
          Entry<String, ForwardingRulesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListForwardingRulesRequest,
                ForwardingRuleAggregatedList,
                Entry<String, ForwardingRulesScopedList>>
            context,
        ApiFuture<ForwardingRuleAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListForwardingRulesRequest,
          ForwardingRuleAggregatedList,
          Entry<String, ForwardingRulesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListForwardingRulesRequest,
                ForwardingRuleAggregatedList,
                Entry<String, ForwardingRulesScopedList>>
            context,
        ForwardingRuleAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListForwardingRulesRequest,
                ForwardingRuleAggregatedList,
                Entry<String, ForwardingRulesScopedList>>
            context,
        ForwardingRuleAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListForwardingRulesRequest,
                ForwardingRuleAggregatedList,
                Entry<String, ForwardingRulesScopedList>>
            context,
        ApiFuture<ForwardingRuleAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListForwardingRulesRequest,
          ForwardingRuleAggregatedList,
          Entry<String, ForwardingRulesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListForwardingRulesRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListForwardingRulesRequest, ForwardingRuleList, ForwardingRule, ListPage> {

    private ListPage(
        PageContext<ListForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ForwardingRuleList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListForwardingRulesRequest, ForwardingRuleList, ForwardingRule> context,
        ApiFuture<ForwardingRuleList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListForwardingRulesRequest,
          ForwardingRuleList,
          ForwardingRule,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
