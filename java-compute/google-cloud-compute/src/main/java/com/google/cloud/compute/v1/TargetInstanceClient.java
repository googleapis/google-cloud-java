/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.TargetInstanceStub;
import com.google.cloud.compute.v1.stub.TargetInstanceStubSettings;
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
 * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
 *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
 *   Operation response = targetInstanceClient.deleteTargetInstance(targetInstance);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetInstanceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TargetInstanceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetInstanceSettings targetInstanceSettings =
 *     TargetInstanceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetInstanceClient targetInstanceClient =
 *     TargetInstanceClient.create(targetInstanceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetInstanceSettings targetInstanceSettings =
 *     TargetInstanceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetInstanceClient targetInstanceClient =
 *     TargetInstanceClient.create(targetInstanceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetInstanceClient implements BackgroundResource {
  private final TargetInstanceSettings settings;
  private final TargetInstanceStub stub;

  /** Constructs an instance of TargetInstanceClient with default settings. */
  public static final TargetInstanceClient create() throws IOException {
    return create(TargetInstanceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetInstanceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetInstanceClient create(TargetInstanceSettings settings)
      throws IOException {
    return new TargetInstanceClient(settings);
  }

  /**
   * Constructs an instance of TargetInstanceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use TargetInstanceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetInstanceClient create(TargetInstanceStub stub) {
    return new TargetInstanceClient(stub);
  }

  /**
   * Constructs an instance of TargetInstanceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetInstanceClient(TargetInstanceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetInstanceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetInstanceClient(TargetInstanceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetInstanceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetInstanceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetInstancesScopedList element : targetInstanceClient.aggregatedListTargetInstances(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetInstancesPagedResponse aggregatedListTargetInstances(
      ProjectName project) {
    AggregatedListTargetInstancesHttpRequest request =
        AggregatedListTargetInstancesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListTargetInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetInstancesScopedList element : targetInstanceClient.aggregatedListTargetInstances(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetInstancesPagedResponse aggregatedListTargetInstances(
      String project) {
    AggregatedListTargetInstancesHttpRequest request =
        AggregatedListTargetInstancesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListTargetInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetInstancesHttpRequest request = AggregatedListTargetInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (TargetInstancesScopedList element : targetInstanceClient.aggregatedListTargetInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetInstancesPagedResponse aggregatedListTargetInstances(
      AggregatedListTargetInstancesHttpRequest request) {
    return aggregatedListTargetInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetInstancesHttpRequest request = AggregatedListTargetInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListTargetInstancesPagedResponse&gt; future = targetInstanceClient.aggregatedListTargetInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetInstancesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListTargetInstancesHttpRequest, AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesPagedCallable() {
    return stub.aggregatedListTargetInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListTargetInstancesHttpRequest request = AggregatedListTargetInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     TargetInstanceAggregatedList response = targetInstanceClient.aggregatedListTargetInstancesCallable().call(request);
   *     for (TargetInstancesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
      aggregatedListTargetInstancesCallable() {
    return stub.aggregatedListTargetInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   Operation response = targetInstanceClient.deleteTargetInstance(targetInstance);
   * }
   * </code></pre>
   *
   * @param targetInstance Name of the TargetInstance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetInstance(ProjectZoneTargetInstanceName targetInstance) {

    DeleteTargetInstanceHttpRequest request =
        DeleteTargetInstanceHttpRequest.newBuilder()
            .setTargetInstance(targetInstance == null ? null : targetInstance.toString())
            .build();
    return deleteTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   Operation response = targetInstanceClient.deleteTargetInstance(targetInstance.toString());
   * }
   * </code></pre>
   *
   * @param targetInstance Name of the TargetInstance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetInstance(String targetInstance) {

    DeleteTargetInstanceHttpRequest request =
        DeleteTargetInstanceHttpRequest.newBuilder().setTargetInstance(targetInstance).build();
    return deleteTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   DeleteTargetInstanceHttpRequest request = DeleteTargetInstanceHttpRequest.newBuilder()
   *     .setTargetInstance(targetInstance.toString())
   *     .build();
   *   Operation response = targetInstanceClient.deleteTargetInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetInstance(DeleteTargetInstanceHttpRequest request) {
    return deleteTargetInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetInstance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   DeleteTargetInstanceHttpRequest request = DeleteTargetInstanceHttpRequest.newBuilder()
   *     .setTargetInstance(targetInstance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetInstanceClient.deleteTargetInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteTargetInstanceHttpRequest, Operation>
      deleteTargetInstanceCallable() {
    return stub.deleteTargetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   TargetInstance response = targetInstanceClient.getTargetInstance(targetInstance);
   * }
   * </code></pre>
   *
   * @param targetInstance Name of the TargetInstance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetInstance getTargetInstance(ProjectZoneTargetInstanceName targetInstance) {

    GetTargetInstanceHttpRequest request =
        GetTargetInstanceHttpRequest.newBuilder()
            .setTargetInstance(targetInstance == null ? null : targetInstance.toString())
            .build();
    return getTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   TargetInstance response = targetInstanceClient.getTargetInstance(targetInstance.toString());
   * }
   * </code></pre>
   *
   * @param targetInstance Name of the TargetInstance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetInstance getTargetInstance(String targetInstance) {

    GetTargetInstanceHttpRequest request =
        GetTargetInstanceHttpRequest.newBuilder().setTargetInstance(targetInstance).build();
    return getTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   GetTargetInstanceHttpRequest request = GetTargetInstanceHttpRequest.newBuilder()
   *     .setTargetInstance(targetInstance.toString())
   *     .build();
   *   TargetInstance response = targetInstanceClient.getTargetInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetInstance getTargetInstance(GetTargetInstanceHttpRequest request) {
    return getTargetInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetInstance resource. Gets a list of available target instances by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneTargetInstanceName targetInstance = ProjectZoneTargetInstanceName.of("[PROJECT]", "[ZONE]", "[TARGET_INSTANCE]");
   *   GetTargetInstanceHttpRequest request = GetTargetInstanceHttpRequest.newBuilder()
   *     .setTargetInstance(targetInstance.toString())
   *     .build();
   *   ApiFuture&lt;TargetInstance&gt; future = targetInstanceClient.getTargetInstanceCallable().futureCall(request);
   *   // Do something
   *   TargetInstance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetTargetInstanceHttpRequest, TargetInstance>
      getTargetInstanceCallable() {
    return stub.getTargetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   Operation response = targetInstanceClient.insertTargetInstance(zone, targetInstanceResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone scoping this request.
   * @param targetInstanceResource A TargetInstance resource. This resource defines an endpoint
   *     instance that terminates traffic of certain protocols. (== resource_for
   *     beta.targetInstances ==) (== resource_for v1.targetInstances ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetInstance(
      ProjectZoneName zone, TargetInstance targetInstanceResource) {

    InsertTargetInstanceHttpRequest request =
        InsertTargetInstanceHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setTargetInstanceResource(targetInstanceResource)
            .build();
    return insertTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   Operation response = targetInstanceClient.insertTargetInstance(zone.toString(), targetInstanceResource);
   * }
   * </code></pre>
   *
   * @param zone Name of the zone scoping this request.
   * @param targetInstanceResource A TargetInstance resource. This resource defines an endpoint
   *     instance that terminates traffic of certain protocols. (== resource_for
   *     beta.targetInstances ==) (== resource_for v1.targetInstances ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetInstance(String zone, TargetInstance targetInstanceResource) {

    InsertTargetInstanceHttpRequest request =
        InsertTargetInstanceHttpRequest.newBuilder()
            .setZone(zone)
            .setTargetInstanceResource(targetInstanceResource)
            .build();
    return insertTargetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   InsertTargetInstanceHttpRequest request = InsertTargetInstanceHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setTargetInstanceResource(targetInstanceResource)
   *     .build();
   *   Operation response = targetInstanceClient.insertTargetInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetInstance(InsertTargetInstanceHttpRequest request) {
    return insertTargetInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetInstance resource in the specified project and zone using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   TargetInstance targetInstanceResource = TargetInstance.newBuilder().build();
   *   InsertTargetInstanceHttpRequest request = InsertTargetInstanceHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setTargetInstanceResource(targetInstanceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetInstanceClient.insertTargetInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertTargetInstanceHttpRequest, Operation>
      insertTargetInstanceCallable() {
    return stub.insertTargetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (TargetInstance element : targetInstanceClient.listTargetInstances(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetInstancesPagedResponse listTargetInstances(ProjectZoneName zone) {
    ListTargetInstancesHttpRequest request =
        ListTargetInstancesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listTargetInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (TargetInstance element : targetInstanceClient.listTargetInstances(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone Name of the zone scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetInstancesPagedResponse listTargetInstances(String zone) {
    ListTargetInstancesHttpRequest request =
        ListTargetInstancesHttpRequest.newBuilder().setZone(zone).build();
    return listTargetInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListTargetInstancesHttpRequest request = ListTargetInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (TargetInstance element : targetInstanceClient.listTargetInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetInstancesPagedResponse listTargetInstances(
      ListTargetInstancesHttpRequest request) {
    return listTargetInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListTargetInstancesHttpRequest request = ListTargetInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListTargetInstancesPagedResponse&gt; future = targetInstanceClient.listTargetInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListTargetInstancesHttpRequest, ListTargetInstancesPagedResponse>
      listTargetInstancesPagedCallable() {
    return stub.listTargetInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of TargetInstance resources available to the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetInstanceClient targetInstanceClient = TargetInstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListTargetInstancesHttpRequest request = ListTargetInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     TargetInstanceList response = targetInstanceClient.listTargetInstancesCallable().call(request);
   *     for (TargetInstance element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetInstancesHttpRequest, TargetInstanceList>
      listTargetInstancesCallable() {
    return stub.listTargetInstancesCallable();
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

  public static class AggregatedListTargetInstancesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
          TargetInstancesScopedList, AggregatedListTargetInstancesPage,
          AggregatedListTargetInstancesFixedSizeCollection> {

    public static ApiFuture<AggregatedListTargetInstancesPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
                TargetInstancesScopedList>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
      ApiFuture<AggregatedListTargetInstancesPage> futurePage =
          AggregatedListTargetInstancesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListTargetInstancesPage, AggregatedListTargetInstancesPagedResponse>() {
            @Override
            public AggregatedListTargetInstancesPagedResponse apply(
                AggregatedListTargetInstancesPage input) {
              return new AggregatedListTargetInstancesPagedResponse(input);
            }
          });
    }

    private AggregatedListTargetInstancesPagedResponse(AggregatedListTargetInstancesPage page) {
      super(page, AggregatedListTargetInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListTargetInstancesPage
      extends AbstractPage<
          AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
          TargetInstancesScopedList, AggregatedListTargetInstancesPage> {

    private AggregatedListTargetInstancesPage(
        PageContext<
                AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
                TargetInstancesScopedList>
            context,
        TargetInstanceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListTargetInstancesPage createEmptyPage() {
      return new AggregatedListTargetInstancesPage(null, null);
    }

    @Override
    protected AggregatedListTargetInstancesPage createPage(
        PageContext<
                AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
                TargetInstancesScopedList>
            context,
        TargetInstanceAggregatedList response) {
      return new AggregatedListTargetInstancesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListTargetInstancesPage> createPageAsync(
        PageContext<
                AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
                TargetInstancesScopedList>
            context,
        ApiFuture<TargetInstanceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListTargetInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList,
          TargetInstancesScopedList, AggregatedListTargetInstancesPage,
          AggregatedListTargetInstancesFixedSizeCollection> {

    private AggregatedListTargetInstancesFixedSizeCollection(
        List<AggregatedListTargetInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListTargetInstancesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListTargetInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListTargetInstancesFixedSizeCollection createCollection(
        List<AggregatedListTargetInstancesPage> pages, int collectionSize) {
      return new AggregatedListTargetInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance,
          ListTargetInstancesPage, ListTargetInstancesFixedSizeCollection> {

    public static ApiFuture<ListTargetInstancesPagedResponse> createAsync(
        PageContext<ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
      ApiFuture<ListTargetInstancesPage> futurePage =
          ListTargetInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTargetInstancesPage, ListTargetInstancesPagedResponse>() {
            @Override
            public ListTargetInstancesPagedResponse apply(ListTargetInstancesPage input) {
              return new ListTargetInstancesPagedResponse(input);
            }
          });
    }

    private ListTargetInstancesPagedResponse(ListTargetInstancesPage page) {
      super(page, ListTargetInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetInstancesPage
      extends AbstractPage<
          ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance,
          ListTargetInstancesPage> {

    private ListTargetInstancesPage(
        PageContext<ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      super(context, response);
    }

    private static ListTargetInstancesPage createEmptyPage() {
      return new ListTargetInstancesPage(null, null);
    }

    @Override
    protected ListTargetInstancesPage createPage(
        PageContext<ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance> context,
        TargetInstanceList response) {
      return new ListTargetInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetInstancesPage> createPageAsync(
        PageContext<ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance> context,
        ApiFuture<TargetInstanceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetInstancesHttpRequest, TargetInstanceList, TargetInstance,
          ListTargetInstancesPage, ListTargetInstancesFixedSizeCollection> {

    private ListTargetInstancesFixedSizeCollection(
        List<ListTargetInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetInstancesFixedSizeCollection createEmptyCollection() {
      return new ListTargetInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetInstancesFixedSizeCollection createCollection(
        List<ListTargetInstancesPage> pages, int collectionSize) {
      return new ListTargetInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
