/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.AutoscalerStub;
import com.google.cloud.compute.v1.stub.AutoscalerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
 *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
 *   Operation response = autoscalerClient.deleteAutoscaler(autoscaler);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the autoscalerClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of AutoscalerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AutoscalerSettings autoscalerSettings =
 *     AutoscalerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutoscalerClient autoscalerClient =
 *     AutoscalerClient.create(autoscalerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AutoscalerSettings autoscalerSettings =
 *     AutoscalerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutoscalerClient autoscalerClient =
 *     AutoscalerClient.create(autoscalerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AutoscalerClient implements BackgroundResource {
  private final AutoscalerSettings settings;
  private final AutoscalerStub stub;

  /** Constructs an instance of AutoscalerClient with default settings. */
  public static final AutoscalerClient create() throws IOException {
    return create(AutoscalerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutoscalerClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AutoscalerClient create(AutoscalerSettings settings) throws IOException {
    return new AutoscalerClient(settings);
  }

  /**
   * Constructs an instance of AutoscalerClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use AutoscalerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AutoscalerClient create(AutoscalerStub stub) {
    return new AutoscalerClient(stub);
  }

  /**
   * Constructs an instance of AutoscalerClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AutoscalerClient(AutoscalerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AutoscalerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AutoscalerClient(AutoscalerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutoscalerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AutoscalerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (AutoscalersScopedList element : autoscalerClient.aggregatedListAutoscalers(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAutoscalersPagedResponse aggregatedListAutoscalers(
      ProjectName project) {
    AggregatedListAutoscalersHttpRequest request =
        AggregatedListAutoscalersHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (AutoscalersScopedList element : autoscalerClient.aggregatedListAutoscalers(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAutoscalersPagedResponse aggregatedListAutoscalers(String project) {
    AggregatedListAutoscalersHttpRequest request =
        AggregatedListAutoscalersHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListAutoscalersHttpRequest request = AggregatedListAutoscalersHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (AutoscalersScopedList element : autoscalerClient.aggregatedListAutoscalers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListAutoscalersPagedResponse aggregatedListAutoscalers(
      AggregatedListAutoscalersHttpRequest request) {
    return aggregatedListAutoscalersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListAutoscalersHttpRequest request = AggregatedListAutoscalersHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListAutoscalersPagedResponse&gt; future = autoscalerClient.aggregatedListAutoscalersPagedCallable().futureCall(request);
   *   // Do something
   *   for (AutoscalersScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListAutoscalersHttpRequest, AggregatedListAutoscalersPagedResponse>
      aggregatedListAutoscalersPagedCallable() {
    return stub.aggregatedListAutoscalersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of autoscalers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListAutoscalersHttpRequest request = AggregatedListAutoscalersHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     AutoscalerAggregatedList response = autoscalerClient.aggregatedListAutoscalersCallable().call(request);
   *     for (AutoscalersScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>
      aggregatedListAutoscalersCallable() {
    return stub.aggregatedListAutoscalersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   Operation response = autoscalerClient.deleteAutoscaler(autoscaler);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAutoscaler(ProjectZoneAutoscalerName autoscaler) {

    DeleteAutoscalerHttpRequest request =
        DeleteAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler == null ? null : autoscaler.toString())
            .build();
    return deleteAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   Operation response = autoscalerClient.deleteAutoscaler(autoscaler.toString());
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAutoscaler(String autoscaler) {

    DeleteAutoscalerHttpRequest request =
        DeleteAutoscalerHttpRequest.newBuilder().setAutoscaler(autoscaler).build();
    return deleteAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedAutoscaler = ProjectZoneAutoscalerName.format("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   DeleteAutoscalerHttpRequest request = DeleteAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(formattedAutoscaler)
   *     .build();
   *   Operation response = autoscalerClient.deleteAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAutoscaler(DeleteAutoscalerHttpRequest request) {
    return deleteAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedAutoscaler = ProjectZoneAutoscalerName.format("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   DeleteAutoscalerHttpRequest request = DeleteAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(formattedAutoscaler)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalerClient.deleteAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteAutoscalerHttpRequest, Operation> deleteAutoscalerCallable() {
    return stub.deleteAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   Autoscaler response = autoscalerClient.getAutoscaler(autoscaler);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getAutoscaler(ProjectZoneAutoscalerName autoscaler) {

    GetAutoscalerHttpRequest request =
        GetAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler == null ? null : autoscaler.toString())
            .build();
    return getAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneAutoscalerName autoscaler = ProjectZoneAutoscalerName.of("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   Autoscaler response = autoscalerClient.getAutoscaler(autoscaler.toString());
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getAutoscaler(String autoscaler) {

    GetAutoscalerHttpRequest request =
        GetAutoscalerHttpRequest.newBuilder().setAutoscaler(autoscaler).build();
    return getAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedAutoscaler = ProjectZoneAutoscalerName.format("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   GetAutoscalerHttpRequest request = GetAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(formattedAutoscaler)
   *     .build();
   *   Autoscaler response = autoscalerClient.getAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getAutoscaler(GetAutoscalerHttpRequest request) {
    return getAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler resource. Gets a list of available autoscalers by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedAutoscaler = ProjectZoneAutoscalerName.format("[PROJECT]", "[ZONE]", "[AUTOSCALER]");
   *   GetAutoscalerHttpRequest request = GetAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(formattedAutoscaler)
   *     .build();
   *   ApiFuture&lt;Autoscaler&gt; future = autoscalerClient.getAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Autoscaler response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerCallable() {
    return stub.getAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = autoscalerClient.insertAutoscaler(zone, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertAutoscaler(ProjectZoneName zone, Autoscaler autoscalerResource) {

    InsertAutoscalerHttpRequest request =
        InsertAutoscalerHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insertAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = autoscalerClient.insertAutoscaler(zone.toString(), autoscalerResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertAutoscaler(String zone, Autoscaler autoscalerResource) {

    InsertAutoscalerHttpRequest request =
        InsertAutoscalerHttpRequest.newBuilder()
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insertAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   InsertAutoscalerHttpRequest request = InsertAutoscalerHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .build();
   *   Operation response = autoscalerClient.insertAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertAutoscaler(InsertAutoscalerHttpRequest request) {
    return insertAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   InsertAutoscalerHttpRequest request = InsertAutoscalerHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalerClient.insertAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertAutoscalerHttpRequest, Operation> insertAutoscalerCallable() {
    return stub.insertAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Autoscaler element : autoscalerClient.listAutoscalers(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAutoscalersPagedResponse listAutoscalers(ProjectZoneName zone) {
    ListAutoscalersHttpRequest request =
        ListAutoscalersHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Autoscaler element : autoscalerClient.listAutoscalers(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAutoscalersPagedResponse listAutoscalers(String zone) {
    ListAutoscalersHttpRequest request =
        ListAutoscalersHttpRequest.newBuilder().setZone(zone).build();
    return listAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListAutoscalersHttpRequest request = ListAutoscalersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (Autoscaler element : autoscalerClient.listAutoscalers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListAutoscalersPagedResponse listAutoscalers(ListAutoscalersHttpRequest request) {
    return listAutoscalersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListAutoscalersHttpRequest request = ListAutoscalersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListAutoscalersPagedResponse&gt; future = autoscalerClient.listAutoscalersPagedCallable().futureCall(request);
   *   // Do something
   *   for (Autoscaler element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListAutoscalersHttpRequest, ListAutoscalersPagedResponse>
      listAutoscalersPagedCallable() {
    return stub.listAutoscalersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListAutoscalersHttpRequest request = ListAutoscalersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     AutoscalerList response = autoscalerClient.listAutoscalersCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListAutoscalersHttpRequest, AutoscalerList> listAutoscalersCallable() {
    return stub.listAutoscalersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = autoscalerClient.patchAutoscaler(autoscaler, zone, autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to patch.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchAutoscaler(
      String autoscaler,
      ProjectZoneName zone,
      Autoscaler autoscalerResource,
      List<String> fieldMask) {

    PatchAutoscalerHttpRequest request =
        PatchAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setZone(zone == null ? null : zone.toString())
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = autoscalerClient.patchAutoscaler(autoscaler, zone.toString(), autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to patch.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchAutoscaler(
      String autoscaler, String zone, Autoscaler autoscalerResource, List<String> fieldMask) {

    PatchAutoscalerHttpRequest request =
        PatchAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchAutoscalerHttpRequest request = PatchAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = autoscalerClient.patchAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchAutoscaler(PatchAutoscalerHttpRequest request) {
    return patchAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchAutoscalerHttpRequest request = PatchAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalerClient.patchAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchAutoscalerHttpRequest, Operation> patchAutoscalerCallable() {
    return stub.patchAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = autoscalerClient.updateAutoscaler(autoscaler, zone, autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to update.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAutoscaler(
      String autoscaler,
      ProjectZoneName zone,
      Autoscaler autoscalerResource,
      List<String> fieldMask) {

    UpdateAutoscalerHttpRequest request =
        UpdateAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setZone(zone == null ? null : zone.toString())
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = autoscalerClient.updateAutoscaler(autoscaler, zone.toString(), autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to update.
   * @param zone Name of the zone for this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAutoscaler(
      String autoscaler, String zone, Autoscaler autoscalerResource, List<String> fieldMask) {

    UpdateAutoscalerHttpRequest request =
        UpdateAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setZone(zone)
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateAutoscalerHttpRequest request = UpdateAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = autoscalerClient.updateAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAutoscaler(UpdateAutoscalerHttpRequest request) {
    return updateAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AutoscalerClient autoscalerClient = AutoscalerClient.create()) {
   *   String autoscaler = "";
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateAutoscalerHttpRequest request = UpdateAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setZone(formattedZone)
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = autoscalerClient.updateAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateAutoscalerHttpRequest, Operation> updateAutoscalerCallable() {
    return stub.updateAutoscalerCallable();
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

  public static class AggregatedListAutoscalersPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListAutoscalersHttpRequest,
          AutoscalerAggregatedList,
          AutoscalersScopedList,
          AggregatedListAutoscalersPage,
          AggregatedListAutoscalersFixedSizeCollection> {

    public static ApiFuture<AggregatedListAutoscalersPagedResponse> createAsync(
        PageContext<
                AggregatedListAutoscalersHttpRequest,
                AutoscalerAggregatedList,
                AutoscalersScopedList>
            context,
        ApiFuture<AutoscalerAggregatedList> futureResponse) {
      ApiFuture<AggregatedListAutoscalersPage> futurePage =
          AggregatedListAutoscalersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListAutoscalersPage, AggregatedListAutoscalersPagedResponse>() {
            @Override
            public AggregatedListAutoscalersPagedResponse apply(
                AggregatedListAutoscalersPage input) {
              return new AggregatedListAutoscalersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListAutoscalersPagedResponse(AggregatedListAutoscalersPage page) {
      super(page, AggregatedListAutoscalersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListAutoscalersPage
      extends AbstractPage<
          AggregatedListAutoscalersHttpRequest,
          AutoscalerAggregatedList,
          AutoscalersScopedList,
          AggregatedListAutoscalersPage> {

    private AggregatedListAutoscalersPage(
        PageContext<
                AggregatedListAutoscalersHttpRequest,
                AutoscalerAggregatedList,
                AutoscalersScopedList>
            context,
        AutoscalerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListAutoscalersPage createEmptyPage() {
      return new AggregatedListAutoscalersPage(null, null);
    }

    @Override
    protected AggregatedListAutoscalersPage createPage(
        PageContext<
                AggregatedListAutoscalersHttpRequest,
                AutoscalerAggregatedList,
                AutoscalersScopedList>
            context,
        AutoscalerAggregatedList response) {
      return new AggregatedListAutoscalersPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListAutoscalersPage> createPageAsync(
        PageContext<
                AggregatedListAutoscalersHttpRequest,
                AutoscalerAggregatedList,
                AutoscalersScopedList>
            context,
        ApiFuture<AutoscalerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListAutoscalersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListAutoscalersHttpRequest,
          AutoscalerAggregatedList,
          AutoscalersScopedList,
          AggregatedListAutoscalersPage,
          AggregatedListAutoscalersFixedSizeCollection> {

    private AggregatedListAutoscalersFixedSizeCollection(
        List<AggregatedListAutoscalersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListAutoscalersFixedSizeCollection createEmptyCollection() {
      return new AggregatedListAutoscalersFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListAutoscalersFixedSizeCollection createCollection(
        List<AggregatedListAutoscalersPage> pages, int collectionSize) {
      return new AggregatedListAutoscalersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutoscalersPagedResponse
      extends AbstractPagedListResponse<
          ListAutoscalersHttpRequest,
          AutoscalerList,
          Autoscaler,
          ListAutoscalersPage,
          ListAutoscalersFixedSizeCollection> {

    public static ApiFuture<ListAutoscalersPagedResponse> createAsync(
        PageContext<ListAutoscalersHttpRequest, AutoscalerList, Autoscaler> context,
        ApiFuture<AutoscalerList> futureResponse) {
      ApiFuture<ListAutoscalersPage> futurePage =
          ListAutoscalersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAutoscalersPage, ListAutoscalersPagedResponse>() {
            @Override
            public ListAutoscalersPagedResponse apply(ListAutoscalersPage input) {
              return new ListAutoscalersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAutoscalersPagedResponse(ListAutoscalersPage page) {
      super(page, ListAutoscalersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutoscalersPage
      extends AbstractPage<
          ListAutoscalersHttpRequest, AutoscalerList, Autoscaler, ListAutoscalersPage> {

    private ListAutoscalersPage(
        PageContext<ListAutoscalersHttpRequest, AutoscalerList, Autoscaler> context,
        AutoscalerList response) {
      super(context, response);
    }

    private static ListAutoscalersPage createEmptyPage() {
      return new ListAutoscalersPage(null, null);
    }

    @Override
    protected ListAutoscalersPage createPage(
        PageContext<ListAutoscalersHttpRequest, AutoscalerList, Autoscaler> context,
        AutoscalerList response) {
      return new ListAutoscalersPage(context, response);
    }

    @Override
    public ApiFuture<ListAutoscalersPage> createPageAsync(
        PageContext<ListAutoscalersHttpRequest, AutoscalerList, Autoscaler> context,
        ApiFuture<AutoscalerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutoscalersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutoscalersHttpRequest,
          AutoscalerList,
          Autoscaler,
          ListAutoscalersPage,
          ListAutoscalersFixedSizeCollection> {

    private ListAutoscalersFixedSizeCollection(
        List<ListAutoscalersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutoscalersFixedSizeCollection createEmptyCollection() {
      return new ListAutoscalersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutoscalersFixedSizeCollection createCollection(
        List<ListAutoscalersPage> pages, int collectionSize) {
      return new ListAutoscalersFixedSizeCollection(pages, collectionSize);
    }
  }
}
