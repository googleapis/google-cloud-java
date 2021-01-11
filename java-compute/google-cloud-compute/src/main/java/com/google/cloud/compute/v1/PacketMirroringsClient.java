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
import com.google.cloud.compute.v1.stub.PacketMirroringsStub;
import com.google.cloud.compute.v1.stub.PacketMirroringsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The PacketMirrorings API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String packetMirroring = "";
 *   Operation response = packetMirroringsClient.delete(project, region, packetMirroring);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the packetMirroringsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of PacketMirroringsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * PacketMirroringsSettings packetMirroringsSettings =
 *     PacketMirroringsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PacketMirroringsClient packetMirroringsClient =
 *     PacketMirroringsClient.create(packetMirroringsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PacketMirroringsSettings packetMirroringsSettings =
 *     PacketMirroringsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PacketMirroringsClient packetMirroringsClient =
 *     PacketMirroringsClient.create(packetMirroringsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PacketMirroringsClient implements BackgroundResource {
  private final PacketMirroringsSettings settings;
  private final PacketMirroringsStub stub;

  /** Constructs an instance of PacketMirroringsClient with default settings. */
  public static final PacketMirroringsClient create() throws IOException {
    return create(PacketMirroringsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PacketMirroringsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PacketMirroringsClient create(PacketMirroringsSettings settings)
      throws IOException {
    return new PacketMirroringsClient(settings);
  }

  /**
   * Constructs an instance of PacketMirroringsClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use PacketMirroringsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PacketMirroringsClient create(PacketMirroringsStub stub) {
    return new PacketMirroringsClient(stub);
  }

  /**
   * Constructs an instance of PacketMirroringsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PacketMirroringsClient(PacketMirroringsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PacketMirroringsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PacketMirroringsClient(PacketMirroringsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PacketMirroringsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PacketMirroringsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, PacketMirroringsScopedList&gt; element : packetMirroringsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListPacketMirroringsRequest request =
        AggregatedListPacketMirroringsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   AggregatedListPacketMirroringsRequest request = AggregatedListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, PacketMirroringsScopedList&gt; element : packetMirroringsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListPacketMirroringsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   AggregatedListPacketMirroringsRequest request = AggregatedListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = packetMirroringsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, PacketMirroringsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListPacketMirroringsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   AggregatedListPacketMirroringsRequest request = AggregatedListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     PacketMirroringAggregatedList response = packetMirroringsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, PacketMirroringsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListPacketMirroringsRequest, PacketMirroringAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String packetMirroring = "";
   *   Operation response = packetMirroringsClient.delete(project, region, packetMirroring);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param packetMirroring Name of the PacketMirroring resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String packetMirroring) {
    DeletePacketMirroringRequest request =
        DeletePacketMirroringRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setPacketMirroring(packetMirroring)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   String project = "";
   *   String region = "";
   *   DeletePacketMirroringRequest request = DeletePacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = packetMirroringsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeletePacketMirroringRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   String project = "";
   *   String region = "";
   *   DeletePacketMirroringRequest request = DeletePacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePacketMirroringRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String packetMirroring = "";
   *   PacketMirroring response = packetMirroringsClient.get(project, region, packetMirroring);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param packetMirroring Name of the PacketMirroring resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PacketMirroring get(String project, String region, String packetMirroring) {
    GetPacketMirroringRequest request =
        GetPacketMirroringRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setPacketMirroring(packetMirroring)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   String project = "";
   *   String region = "";
   *   GetPacketMirroringRequest request = GetPacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   PacketMirroring response = packetMirroringsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PacketMirroring get(GetPacketMirroringRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   String project = "";
   *   String region = "";
   *   GetPacketMirroringRequest request = GetPacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;PacketMirroring&gt; future = packetMirroringsClient.getCallable().futureCall(request);
   *   // Do something
   *   PacketMirroring response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPacketMirroringRequest, PacketMirroring> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   Operation response = packetMirroringsClient.insert(project, region, packetMirroringResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param packetMirroringResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, PacketMirroring packetMirroringResource) {
    InsertPacketMirroringRequest request =
        InsertPacketMirroringRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setPacketMirroringResource(packetMirroringResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertPacketMirroringRequest request = InsertPacketMirroringRequest.newBuilder()
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = packetMirroringsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertPacketMirroringRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertPacketMirroringRequest request = InsertPacketMirroringRequest.newBuilder()
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertPacketMirroringRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (PacketMirroring element : packetMirroringsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListPacketMirroringsRequest request =
        ListPacketMirroringsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListPacketMirroringsRequest request = ListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (PacketMirroring element : packetMirroringsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListPacketMirroringsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListPacketMirroringsRequest request = ListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = packetMirroringsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (PacketMirroring element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPacketMirroringsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListPacketMirroringsRequest request = ListPacketMirroringsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     PacketMirroringList response = packetMirroringsClient.listCallable().call(request);
   *     for (PacketMirroring element : response.getItemsList()) {
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
  public final UnaryCallable<ListPacketMirroringsRequest, PacketMirroringList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String packetMirroring = "";
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   Operation response = packetMirroringsClient.patch(project, region, packetMirroring, packetMirroringResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param packetMirroring Name of the PacketMirroring resource to patch.
   * @param packetMirroringResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project,
      String region,
      String packetMirroring,
      PacketMirroring packetMirroringResource) {
    PatchPacketMirroringRequest request =
        PatchPacketMirroringRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setPacketMirroring(packetMirroring)
            .setPacketMirroringResource(packetMirroringResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchPacketMirroringRequest request = PatchPacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = packetMirroringsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchPacketMirroringRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String packetMirroring = "";
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchPacketMirroringRequest request = PatchPacketMirroringRequest.newBuilder()
   *     .setPacketMirroring(packetMirroring)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchPacketMirroringRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = packetMirroringsClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsPacketMirroringRequest request =
        TestIamPermissionsPacketMirroringRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsPacketMirroringRequest request = TestIamPermissionsPacketMirroringRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = packetMirroringsClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsPacketMirroringRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringsClient packetMirroringsClient = PacketMirroringsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsPacketMirroringRequest request = TestIamPermissionsPacketMirroringRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = packetMirroringsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsPacketMirroringRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
          AggregatedListPacketMirroringsRequest,
          PacketMirroringAggregatedList,
          Entry<String, PacketMirroringsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListPacketMirroringsRequest,
                PacketMirroringAggregatedList,
                Entry<String, PacketMirroringsScopedList>>
            context,
        ApiFuture<PacketMirroringAggregatedList> futureResponse) {
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
          AggregatedListPacketMirroringsRequest,
          PacketMirroringAggregatedList,
          Entry<String, PacketMirroringsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListPacketMirroringsRequest,
                PacketMirroringAggregatedList,
                Entry<String, PacketMirroringsScopedList>>
            context,
        PacketMirroringAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListPacketMirroringsRequest,
                PacketMirroringAggregatedList,
                Entry<String, PacketMirroringsScopedList>>
            context,
        PacketMirroringAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListPacketMirroringsRequest,
                PacketMirroringAggregatedList,
                Entry<String, PacketMirroringsScopedList>>
            context,
        ApiFuture<PacketMirroringAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListPacketMirroringsRequest,
          PacketMirroringAggregatedList,
          Entry<String, PacketMirroringsScopedList>,
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
          ListPacketMirroringsRequest,
          PacketMirroringList,
          PacketMirroring,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListPacketMirroringsRequest, PacketMirroringList, PacketMirroring> context,
        ApiFuture<PacketMirroringList> futureResponse) {
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
          ListPacketMirroringsRequest, PacketMirroringList, PacketMirroring, ListPage> {

    private ListPage(
        PageContext<ListPacketMirroringsRequest, PacketMirroringList, PacketMirroring> context,
        PacketMirroringList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListPacketMirroringsRequest, PacketMirroringList, PacketMirroring> context,
        PacketMirroringList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListPacketMirroringsRequest, PacketMirroringList, PacketMirroring> context,
        ApiFuture<PacketMirroringList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPacketMirroringsRequest,
          PacketMirroringList,
          PacketMirroring,
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
