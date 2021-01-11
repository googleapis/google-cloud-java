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
import com.google.cloud.compute.v1.stub.AutoscalersStub;
import com.google.cloud.compute.v1.stub.AutoscalersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Autoscalers API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String autoscaler = "";
 *   Operation response = autoscalersClient.delete(project, zone, autoscaler);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the autoscalersClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of AutoscalersSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AutoscalersSettings autoscalersSettings =
 *     AutoscalersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutoscalersClient autoscalersClient =
 *     AutoscalersClient.create(autoscalersSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AutoscalersSettings autoscalersSettings =
 *     AutoscalersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutoscalersClient autoscalersClient =
 *     AutoscalersClient.create(autoscalersSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AutoscalersClient implements BackgroundResource {
  private final AutoscalersSettings settings;
  private final AutoscalersStub stub;

  /** Constructs an instance of AutoscalersClient with default settings. */
  public static final AutoscalersClient create() throws IOException {
    return create(AutoscalersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutoscalersClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AutoscalersClient create(AutoscalersSettings settings) throws IOException {
    return new AutoscalersClient(settings);
  }

  /**
   * Constructs an instance of AutoscalersClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use AutoscalersSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AutoscalersClient create(AutoscalersStub stub) {
    return new AutoscalersClient(stub);
  }

  /**
   * Constructs an instance of AutoscalersClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AutoscalersClient(AutoscalersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AutoscalersStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AutoscalersClient(AutoscalersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutoscalersSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AutoscalersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, AutoscalersScopedList&gt; element : autoscalersClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListAutoscalersRequest request =
        AggregatedListAutoscalersRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   AggregatedListAutoscalersRequest request = AggregatedListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, AutoscalersScopedList&gt; element : autoscalersClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListAutoscalersRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   AggregatedListAutoscalersRequest request = AggregatedListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = autoscalersClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, AutoscalersScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListAutoscalersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   AggregatedListAutoscalersRequest request = AggregatedListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     AutoscalerAggregatedList response = autoscalersClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, AutoscalersScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListAutoscalersRequest, AutoscalerAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String autoscaler = "";
   *   Operation response = autoscalersClient.delete(project, zone, autoscaler);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String autoscaler) {
    DeleteAutoscalerRequest request =
        DeleteAutoscalerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAutoscaler(autoscaler)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteAutoscalerRequest request = DeleteAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = autoscalersClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteAutoscalerRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteAutoscalerRequest request = DeleteAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalersClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAutoscalerRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String autoscaler = "";
   *   Autoscaler response = autoscalersClient.get(project, zone, autoscaler);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Autoscaler get(String project, String zone, String autoscaler) {
    GetAutoscalerRequest request =
        GetAutoscalerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAutoscaler(autoscaler)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String zone = "";
   *   GetAutoscalerRequest request = GetAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Autoscaler response = autoscalersClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Autoscaler get(GetAutoscalerRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String autoscaler = "";
   *   String project = "";
   *   String zone = "";
   *   GetAutoscalerRequest request = GetAutoscalerRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Autoscaler&gt; future = autoscalersClient.getCallable().futureCall(request);
   *   // Do something
   *   Autoscaler response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAutoscalerRequest, Autoscaler> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = autoscalersClient.insert(project, zone, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String zone, Autoscaler autoscalerResource) {
    InsertAutoscalerRequest request =
        InsertAutoscalerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertAutoscalerRequest request = InsertAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = autoscalersClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertAutoscalerRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertAutoscalerRequest request = InsertAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalersClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertAutoscalerRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (Autoscaler element : autoscalersClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListAutoscalersRequest request =
        ListAutoscalersRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListAutoscalersRequest request = ListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (Autoscaler element : autoscalersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListAutoscalersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListAutoscalersRequest request = ListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = autoscalersClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Autoscaler element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAutoscalersRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListAutoscalersRequest request = ListAutoscalersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     AutoscalerList response = autoscalersClient.listCallable().call(request);
   *     for (Autoscaler element : response.getItemsList()) {
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
  public final UnaryCallable<ListAutoscalersRequest, AutoscalerList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = autoscalersClient.patch(project, zone, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String zone, Autoscaler autoscalerResource) {
    PatchAutoscalerRequest request =
        PatchAutoscalerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchAutoscalerRequest request = PatchAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = autoscalersClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchAutoscalerRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchAutoscalerRequest request = PatchAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalersClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchAutoscalerRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = autoscalersClient.update(project, zone, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(String project, String zone, Autoscaler autoscalerResource) {
    UpdateAutoscalerRequest request =
        UpdateAutoscalerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   UpdateAutoscalerRequest request = UpdateAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = autoscalersClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateAutoscalerRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalersClient autoscalersClient = AutoscalersClient.create()) {
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   UpdateAutoscalerRequest request = UpdateAutoscalerRequest.newBuilder()
   *     .setAutoscalerResource(autoscalerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalersClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateAutoscalerRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
          AggregatedListAutoscalersRequest,
          AutoscalerAggregatedList,
          Entry<String, AutoscalersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListAutoscalersRequest,
                AutoscalerAggregatedList,
                Entry<String, AutoscalersScopedList>>
            context,
        ApiFuture<AutoscalerAggregatedList> futureResponse) {
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
          AggregatedListAutoscalersRequest,
          AutoscalerAggregatedList,
          Entry<String, AutoscalersScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListAutoscalersRequest,
                AutoscalerAggregatedList,
                Entry<String, AutoscalersScopedList>>
            context,
        AutoscalerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListAutoscalersRequest,
                AutoscalerAggregatedList,
                Entry<String, AutoscalersScopedList>>
            context,
        AutoscalerAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListAutoscalersRequest,
                AutoscalerAggregatedList,
                Entry<String, AutoscalersScopedList>>
            context,
        ApiFuture<AutoscalerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListAutoscalersRequest,
          AutoscalerAggregatedList,
          Entry<String, AutoscalersScopedList>,
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
          ListAutoscalersRequest, AutoscalerList, Autoscaler, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListAutoscalersRequest, AutoscalerList, Autoscaler> context,
        ApiFuture<AutoscalerList> futureResponse) {
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
      extends AbstractPage<ListAutoscalersRequest, AutoscalerList, Autoscaler, ListPage> {

    private ListPage(
        PageContext<ListAutoscalersRequest, AutoscalerList, Autoscaler> context,
        AutoscalerList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListAutoscalersRequest, AutoscalerList, Autoscaler> context,
        AutoscalerList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListAutoscalersRequest, AutoscalerList, Autoscaler> context,
        ApiFuture<AutoscalerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutoscalersRequest, AutoscalerList, Autoscaler, ListPage, ListFixedSizeCollection> {

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
