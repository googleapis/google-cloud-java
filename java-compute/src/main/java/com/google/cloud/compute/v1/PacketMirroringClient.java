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
import com.google.cloud.compute.v1.stub.PacketMirroringStub;
import com.google.cloud.compute.v1.stub.PacketMirroringStubSettings;
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
 * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
 *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
 *   Operation response = packetMirroringClient.deletePacketMirroring(packetMirroring);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the packetMirroringClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of PacketMirroringSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * PacketMirroringSettings packetMirroringSettings =
 *     PacketMirroringSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PacketMirroringClient packetMirroringClient =
 *     PacketMirroringClient.create(packetMirroringSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PacketMirroringSettings packetMirroringSettings =
 *     PacketMirroringSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PacketMirroringClient packetMirroringClient =
 *     PacketMirroringClient.create(packetMirroringSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PacketMirroringClient implements BackgroundResource {
  private final PacketMirroringSettings settings;
  private final PacketMirroringStub stub;

  /** Constructs an instance of PacketMirroringClient with default settings. */
  public static final PacketMirroringClient create() throws IOException {
    return create(PacketMirroringSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PacketMirroringClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PacketMirroringClient create(PacketMirroringSettings settings)
      throws IOException {
    return new PacketMirroringClient(settings);
  }

  /**
   * Constructs an instance of PacketMirroringClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use PacketMirroringSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PacketMirroringClient create(PacketMirroringStub stub) {
    return new PacketMirroringClient(stub);
  }

  /**
   * Constructs an instance of PacketMirroringClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PacketMirroringClient(PacketMirroringSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PacketMirroringStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PacketMirroringClient(PacketMirroringStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PacketMirroringSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PacketMirroringStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   Boolean includeAllScopes = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (PacketMirroringsScopedList element : packetMirroringClient.aggregatedListPacketMirrorings(includeAllScopes, project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param includeAllScopes Indicates whether every visible scope for each scope type (zone,
   *     region, global) should be included in the response. For new resource types added after this
   *     field, the flag has no effect as new resource types will always include every visible scope
   *     for each scope type in response. For resource types which predate this field, if this flag
   *     is omitted or false, only scopes of the scope types where the resource type is expected to
   *     be found will be included.
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListPacketMirroringsPagedResponse aggregatedListPacketMirrorings(
      Boolean includeAllScopes, ProjectName project) {
    AggregatedListPacketMirroringsHttpRequest request =
        AggregatedListPacketMirroringsHttpRequest.newBuilder()
            .setIncludeAllScopes(includeAllScopes)
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListPacketMirrorings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   Boolean includeAllScopes = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (PacketMirroringsScopedList element : packetMirroringClient.aggregatedListPacketMirrorings(includeAllScopes, project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param includeAllScopes Indicates whether every visible scope for each scope type (zone,
   *     region, global) should be included in the response. For new resource types added after this
   *     field, the flag has no effect as new resource types will always include every visible scope
   *     for each scope type in response. For resource types which predate this field, if this flag
   *     is omitted or false, only scopes of the scope types where the resource type is expected to
   *     be found will be included.
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListPacketMirroringsPagedResponse aggregatedListPacketMirrorings(
      Boolean includeAllScopes, String project) {
    AggregatedListPacketMirroringsHttpRequest request =
        AggregatedListPacketMirroringsHttpRequest.newBuilder()
            .setIncludeAllScopes(includeAllScopes)
            .setProject(project)
            .build();
    return aggregatedListPacketMirrorings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListPacketMirroringsHttpRequest request = AggregatedListPacketMirroringsHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   for (PacketMirroringsScopedList element : packetMirroringClient.aggregatedListPacketMirrorings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListPacketMirroringsPagedResponse aggregatedListPacketMirrorings(
      AggregatedListPacketMirroringsHttpRequest request) {
    return aggregatedListPacketMirroringsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListPacketMirroringsHttpRequest request = AggregatedListPacketMirroringsHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListPacketMirroringsPagedResponse&gt; future = packetMirroringClient.aggregatedListPacketMirroringsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PacketMirroringsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsPagedCallable() {
    return stub.aggregatedListPacketMirroringsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of packetMirrorings.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListPacketMirroringsHttpRequest request = AggregatedListPacketMirroringsHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     PacketMirroringAggregatedList response = packetMirroringClient.aggregatedListPacketMirroringsCallable().call(request);
   *     for (PacketMirroringsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
      aggregatedListPacketMirroringsCallable() {
    return stub.aggregatedListPacketMirroringsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   Operation response = packetMirroringClient.deletePacketMirroring(packetMirroring);
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePacketMirroring(ProjectRegionPacketMirroringName packetMirroring) {
    DeletePacketMirroringHttpRequest request =
        DeletePacketMirroringHttpRequest.newBuilder()
            .setPacketMirroring(packetMirroring == null ? null : packetMirroring.toString())
            .build();
    return deletePacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   Operation response = packetMirroringClient.deletePacketMirroring(packetMirroring.toString());
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePacketMirroring(String packetMirroring) {
    DeletePacketMirroringHttpRequest request =
        DeletePacketMirroringHttpRequest.newBuilder().setPacketMirroring(packetMirroring).build();
    return deletePacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   DeletePacketMirroringHttpRequest request = DeletePacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .build();
   *   Operation response = packetMirroringClient.deletePacketMirroring(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePacketMirroring(DeletePacketMirroringHttpRequest request) {
    return deletePacketMirroringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   DeletePacketMirroringHttpRequest request = DeletePacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringClient.deletePacketMirroringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringCallable() {
    return stub.deletePacketMirroringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring response = packetMirroringClient.getPacketMirroring(packetMirroring);
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final PacketMirroring getPacketMirroring(
      ProjectRegionPacketMirroringName packetMirroring) {
    GetPacketMirroringHttpRequest request =
        GetPacketMirroringHttpRequest.newBuilder()
            .setPacketMirroring(packetMirroring == null ? null : packetMirroring.toString())
            .build();
    return getPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring response = packetMirroringClient.getPacketMirroring(packetMirroring.toString());
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final PacketMirroring getPacketMirroring(String packetMirroring) {
    GetPacketMirroringHttpRequest request =
        GetPacketMirroringHttpRequest.newBuilder().setPacketMirroring(packetMirroring).build();
    return getPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   GetPacketMirroringHttpRequest request = GetPacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .build();
   *   PacketMirroring response = packetMirroringClient.getPacketMirroring(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final PacketMirroring getPacketMirroring(GetPacketMirroringHttpRequest request) {
    return getPacketMirroringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified PacketMirroring resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   GetPacketMirroringHttpRequest request = GetPacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .build();
   *   ApiFuture&lt;PacketMirroring&gt; future = packetMirroringClient.getPacketMirroringCallable().futureCall(request);
   *   // Do something
   *   PacketMirroring response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringCallable() {
    return stub.getPacketMirroringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   Operation response = packetMirroringClient.insertPacketMirroring(region, packetMirroringResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param packetMirroringResource Represents a PacketMirroring resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertPacketMirroring(
      ProjectRegionName region, PacketMirroring packetMirroringResource) {
    InsertPacketMirroringHttpRequest request =
        InsertPacketMirroringHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setPacketMirroringResource(packetMirroringResource)
            .build();
    return insertPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   Operation response = packetMirroringClient.insertPacketMirroring(region.toString(), packetMirroringResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param packetMirroringResource Represents a PacketMirroring resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertPacketMirroring(
      String region, PacketMirroring packetMirroringResource) {
    InsertPacketMirroringHttpRequest request =
        InsertPacketMirroringHttpRequest.newBuilder()
            .setRegion(region)
            .setPacketMirroringResource(packetMirroringResource)
            .build();
    return insertPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   InsertPacketMirroringHttpRequest request = InsertPacketMirroringHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .build();
   *   Operation response = packetMirroringClient.insertPacketMirroring(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertPacketMirroring(InsertPacketMirroringHttpRequest request) {
    return insertPacketMirroringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a PacketMirroring resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   InsertPacketMirroringHttpRequest request = InsertPacketMirroringHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringClient.insertPacketMirroringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringCallable() {
    return stub.insertPacketMirroringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (PacketMirroring element : packetMirroringClient.listPacketMirrorings(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPacketMirroringsPagedResponse listPacketMirrorings(ProjectRegionName region) {
    ListPacketMirroringsHttpRequest request =
        ListPacketMirroringsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listPacketMirrorings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (PacketMirroring element : packetMirroringClient.listPacketMirrorings(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPacketMirroringsPagedResponse listPacketMirrorings(String region) {
    ListPacketMirroringsHttpRequest request =
        ListPacketMirroringsHttpRequest.newBuilder().setRegion(region).build();
    return listPacketMirrorings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListPacketMirroringsHttpRequest request = ListPacketMirroringsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (PacketMirroring element : packetMirroringClient.listPacketMirrorings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPacketMirroringsPagedResponse listPacketMirrorings(
      ListPacketMirroringsHttpRequest request) {
    return listPacketMirroringsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListPacketMirroringsHttpRequest request = ListPacketMirroringsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListPacketMirroringsPagedResponse&gt; future = packetMirroringClient.listPacketMirroringsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PacketMirroring element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListPacketMirroringsHttpRequest, ListPacketMirroringsPagedResponse>
      listPacketMirroringsPagedCallable() {
    return stub.listPacketMirroringsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of PacketMirroring resources available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListPacketMirroringsHttpRequest request = ListPacketMirroringsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     PacketMirroringList response = packetMirroringClient.listPacketMirroringsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListPacketMirroringsHttpRequest, PacketMirroringList>
      listPacketMirroringsCallable() {
    return stub.listPacketMirroringsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = packetMirroringClient.patchPacketMirroring(packetMirroring, packetMirroringResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to patch.
   * @param packetMirroringResource Represents a PacketMirroring resource.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPacketMirroring(
      ProjectRegionPacketMirroringName packetMirroring,
      PacketMirroring packetMirroringResource,
      List<String> fieldMask) {
    PatchPacketMirroringHttpRequest request =
        PatchPacketMirroringHttpRequest.newBuilder()
            .setPacketMirroring(packetMirroring == null ? null : packetMirroring.toString())
            .setPacketMirroringResource(packetMirroringResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringName packetMirroring = ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = packetMirroringClient.patchPacketMirroring(packetMirroring.toString(), packetMirroringResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param packetMirroring Name of the PacketMirroring resource to patch.
   * @param packetMirroringResource Represents a PacketMirroring resource.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPacketMirroring(
      String packetMirroring, PacketMirroring packetMirroringResource, List<String> fieldMask) {
    PatchPacketMirroringHttpRequest request =
        PatchPacketMirroringHttpRequest.newBuilder()
            .setPacketMirroring(packetMirroring)
            .setPacketMirroringResource(packetMirroringResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchPacketMirroringHttpRequest request = PatchPacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = packetMirroringClient.patchPacketMirroring(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPacketMirroring(PatchPacketMirroringHttpRequest request) {
    return patchPacketMirroringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified PacketMirroring resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedPacketMirroring = ProjectRegionPacketMirroringName.format("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
   *   PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchPacketMirroringHttpRequest request = PatchPacketMirroringHttpRequest.newBuilder()
   *     .setPacketMirroring(formattedPacketMirroring)
   *     .setPacketMirroringResource(packetMirroringResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = packetMirroringClient.patchPacketMirroringCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringCallable() {
    return stub.patchPacketMirroringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringResourceName resource = ProjectRegionPacketMirroringResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = packetMirroringClient.testIamPermissionsPacketMirroring(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsPacketMirroring(
      ProjectRegionPacketMirroringResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsPacketMirroringHttpRequest request =
        TestIamPermissionsPacketMirroringHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   ProjectRegionPacketMirroringResourceName resource = ProjectRegionPacketMirroringResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = packetMirroringClient.testIamPermissionsPacketMirroring(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsPacketMirroring(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsPacketMirroringHttpRequest request =
        TestIamPermissionsPacketMirroringHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsPacketMirroring(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedResource = ProjectRegionPacketMirroringResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsPacketMirroringHttpRequest request = TestIamPermissionsPacketMirroringHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = packetMirroringClient.testIamPermissionsPacketMirroring(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsPacketMirroring(
      TestIamPermissionsPacketMirroringHttpRequest request) {
    return testIamPermissionsPacketMirroringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PacketMirroringClient packetMirroringClient = PacketMirroringClient.create()) {
   *   String formattedResource = ProjectRegionPacketMirroringResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsPacketMirroringHttpRequest request = TestIamPermissionsPacketMirroringHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = packetMirroringClient.testIamPermissionsPacketMirroringCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringCallable() {
    return stub.testIamPermissionsPacketMirroringCallable();
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

  public static class AggregatedListPacketMirroringsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          PacketMirroringsScopedList,
          AggregatedListPacketMirroringsPage,
          AggregatedListPacketMirroringsFixedSizeCollection> {

    public static ApiFuture<AggregatedListPacketMirroringsPagedResponse> createAsync(
        PageContext<
                AggregatedListPacketMirroringsHttpRequest,
                PacketMirroringAggregatedList,
                PacketMirroringsScopedList>
            context,
        ApiFuture<PacketMirroringAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPacketMirroringsPage> futurePage =
          AggregatedListPacketMirroringsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListPacketMirroringsPage, AggregatedListPacketMirroringsPagedResponse>() {
            @Override
            public AggregatedListPacketMirroringsPagedResponse apply(
                AggregatedListPacketMirroringsPage input) {
              return new AggregatedListPacketMirroringsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPacketMirroringsPagedResponse(AggregatedListPacketMirroringsPage page) {
      super(page, AggregatedListPacketMirroringsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPacketMirroringsPage
      extends AbstractPage<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          PacketMirroringsScopedList,
          AggregatedListPacketMirroringsPage> {

    private AggregatedListPacketMirroringsPage(
        PageContext<
                AggregatedListPacketMirroringsHttpRequest,
                PacketMirroringAggregatedList,
                PacketMirroringsScopedList>
            context,
        PacketMirroringAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPacketMirroringsPage createEmptyPage() {
      return new AggregatedListPacketMirroringsPage(null, null);
    }

    @Override
    protected AggregatedListPacketMirroringsPage createPage(
        PageContext<
                AggregatedListPacketMirroringsHttpRequest,
                PacketMirroringAggregatedList,
                PacketMirroringsScopedList>
            context,
        PacketMirroringAggregatedList response) {
      return new AggregatedListPacketMirroringsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPacketMirroringsPage> createPageAsync(
        PageContext<
                AggregatedListPacketMirroringsHttpRequest,
                PacketMirroringAggregatedList,
                PacketMirroringsScopedList>
            context,
        ApiFuture<PacketMirroringAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListPacketMirroringsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          PacketMirroringsScopedList,
          AggregatedListPacketMirroringsPage,
          AggregatedListPacketMirroringsFixedSizeCollection> {

    private AggregatedListPacketMirroringsFixedSizeCollection(
        List<AggregatedListPacketMirroringsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListPacketMirroringsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListPacketMirroringsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListPacketMirroringsFixedSizeCollection createCollection(
        List<AggregatedListPacketMirroringsPage> pages, int collectionSize) {
      return new AggregatedListPacketMirroringsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPacketMirroringsPagedResponse
      extends AbstractPagedListResponse<
          ListPacketMirroringsHttpRequest,
          PacketMirroringList,
          PacketMirroring,
          ListPacketMirroringsPage,
          ListPacketMirroringsFixedSizeCollection> {

    public static ApiFuture<ListPacketMirroringsPagedResponse> createAsync(
        PageContext<ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring> context,
        ApiFuture<PacketMirroringList> futureResponse) {
      ApiFuture<ListPacketMirroringsPage> futurePage =
          ListPacketMirroringsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPacketMirroringsPage, ListPacketMirroringsPagedResponse>() {
            @Override
            public ListPacketMirroringsPagedResponse apply(ListPacketMirroringsPage input) {
              return new ListPacketMirroringsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPacketMirroringsPagedResponse(ListPacketMirroringsPage page) {
      super(page, ListPacketMirroringsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPacketMirroringsPage
      extends AbstractPage<
          ListPacketMirroringsHttpRequest,
          PacketMirroringList,
          PacketMirroring,
          ListPacketMirroringsPage> {

    private ListPacketMirroringsPage(
        PageContext<ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring> context,
        PacketMirroringList response) {
      super(context, response);
    }

    private static ListPacketMirroringsPage createEmptyPage() {
      return new ListPacketMirroringsPage(null, null);
    }

    @Override
    protected ListPacketMirroringsPage createPage(
        PageContext<ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring> context,
        PacketMirroringList response) {
      return new ListPacketMirroringsPage(context, response);
    }

    @Override
    public ApiFuture<ListPacketMirroringsPage> createPageAsync(
        PageContext<ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring> context,
        ApiFuture<PacketMirroringList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPacketMirroringsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPacketMirroringsHttpRequest,
          PacketMirroringList,
          PacketMirroring,
          ListPacketMirroringsPage,
          ListPacketMirroringsFixedSizeCollection> {

    private ListPacketMirroringsFixedSizeCollection(
        List<ListPacketMirroringsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPacketMirroringsFixedSizeCollection createEmptyCollection() {
      return new ListPacketMirroringsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPacketMirroringsFixedSizeCollection createCollection(
        List<ListPacketMirroringsPage> pages, int collectionSize) {
      return new ListPacketMirroringsFixedSizeCollection(pages, collectionSize);
    }
  }
}
