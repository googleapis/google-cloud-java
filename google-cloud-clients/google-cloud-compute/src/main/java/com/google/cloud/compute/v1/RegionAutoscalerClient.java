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
import com.google.cloud.compute.v1.stub.RegionAutoscalerStub;
import com.google.cloud.compute.v1.stub.RegionAutoscalerStubSettings;
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
 * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
 *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
 *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(autoscaler);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionAutoscalerClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionAutoscalerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionAutoscalerSettings regionAutoscalerSettings =
 *     RegionAutoscalerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionAutoscalerClient regionAutoscalerClient =
 *     RegionAutoscalerClient.create(regionAutoscalerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionAutoscalerSettings regionAutoscalerSettings =
 *     RegionAutoscalerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionAutoscalerClient regionAutoscalerClient =
 *     RegionAutoscalerClient.create(regionAutoscalerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionAutoscalerClient implements BackgroundResource {
  private final RegionAutoscalerSettings settings;
  private final RegionAutoscalerStub stub;

  /** Constructs an instance of RegionAutoscalerClient with default settings. */
  public static final RegionAutoscalerClient create() throws IOException {
    return create(RegionAutoscalerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionAutoscalerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionAutoscalerClient create(RegionAutoscalerSettings settings)
      throws IOException {
    return new RegionAutoscalerClient(settings);
  }

  /**
   * Constructs an instance of RegionAutoscalerClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use RegionAutoscalerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionAutoscalerClient create(RegionAutoscalerStub stub) {
    return new RegionAutoscalerClient(stub);
  }

  /**
   * Constructs an instance of RegionAutoscalerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionAutoscalerClient(RegionAutoscalerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionAutoscalerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionAutoscalerClient(RegionAutoscalerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionAutoscalerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionAutoscalerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(autoscaler);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionAutoscaler(ProjectRegionAutoscalerName autoscaler) {

    DeleteRegionAutoscalerHttpRequest request =
        DeleteRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler == null ? null : autoscaler.toString())
            .build();
    return deleteRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(autoscaler.toString());
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionAutoscaler(String autoscaler) {

    DeleteRegionAutoscalerHttpRequest request =
        DeleteRegionAutoscalerHttpRequest.newBuilder().setAutoscaler(autoscaler).build();
    return deleteRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   DeleteRegionAutoscalerHttpRequest request = DeleteRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler.toString())
   *     .build();
   *   Operation response = regionAutoscalerClient.deleteRegionAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionAutoscaler(DeleteRegionAutoscalerHttpRequest request) {
    return deleteRegionAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   DeleteRegionAutoscalerHttpRequest request = DeleteRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalerClient.deleteRegionAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerCallable() {
    return stub.deleteRegionAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   Autoscaler response = regionAutoscalerClient.getRegionAutoscaler(autoscaler);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getRegionAutoscaler(ProjectRegionAutoscalerName autoscaler) {

    GetRegionAutoscalerHttpRequest request =
        GetRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler == null ? null : autoscaler.toString())
            .build();
    return getRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   Autoscaler response = regionAutoscalerClient.getRegionAutoscaler(autoscaler.toString());
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getRegionAutoscaler(String autoscaler) {

    GetRegionAutoscalerHttpRequest request =
        GetRegionAutoscalerHttpRequest.newBuilder().setAutoscaler(autoscaler).build();
    return getRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   GetRegionAutoscalerHttpRequest request = GetRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler.toString())
   *     .build();
   *   Autoscaler response = regionAutoscalerClient.getRegionAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Autoscaler getRegionAutoscaler(GetRegionAutoscalerHttpRequest request) {
    return getRegionAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified autoscaler.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionAutoscalerName autoscaler = ProjectRegionAutoscalerName.of("[PROJECT]", "[REGION]", "[AUTOSCALER]");
   *   GetRegionAutoscalerHttpRequest request = GetRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler.toString())
   *     .build();
   *   ApiFuture&lt;Autoscaler&gt; future = regionAutoscalerClient.getRegionAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Autoscaler response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerCallable() {
    return stub.getRegionAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = regionAutoscalerClient.insertRegionAutoscaler(region, autoscalerResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionAutoscaler(
      ProjectRegionName region, Autoscaler autoscalerResource) {

    InsertRegionAutoscalerHttpRequest request =
        InsertRegionAutoscalerHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insertRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   Operation response = regionAutoscalerClient.insertRegionAutoscaler(region.toString(), autoscalerResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param autoscalerResource Represents an Autoscaler resource. Autoscalers allow you to
   *     automatically scale virtual machine instances in managed instance groups according to an
   *     autoscaling policy that you define. For more information, read Autoscaling Groups of
   *     Instances. (== resource_for beta.autoscalers ==) (== resource_for v1.autoscalers ==) (==
   *     resource_for beta.regionAutoscalers ==) (== resource_for v1.regionAutoscalers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionAutoscaler(String region, Autoscaler autoscalerResource) {

    InsertRegionAutoscalerHttpRequest request =
        InsertRegionAutoscalerHttpRequest.newBuilder()
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .build();
    return insertRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   InsertRegionAutoscalerHttpRequest request = InsertRegionAutoscalerHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .build();
   *   Operation response = regionAutoscalerClient.insertRegionAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionAutoscaler(InsertRegionAutoscalerHttpRequest request) {
    return insertRegionAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   InsertRegionAutoscalerHttpRequest request = InsertRegionAutoscalerHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalerClient.insertRegionAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerCallable() {
    return stub.insertRegionAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Autoscaler element : regionAutoscalerClient.listRegionAutoscalers(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionAutoscalersPagedResponse listRegionAutoscalers(ProjectRegionName region) {
    ListRegionAutoscalersHttpRequest request =
        ListRegionAutoscalersHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Autoscaler element : regionAutoscalerClient.listRegionAutoscalers(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionAutoscalersPagedResponse listRegionAutoscalers(String region) {
    ListRegionAutoscalersHttpRequest request =
        ListRegionAutoscalersHttpRequest.newBuilder().setRegion(region).build();
    return listRegionAutoscalers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionAutoscalersHttpRequest request = ListRegionAutoscalersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (Autoscaler element : regionAutoscalerClient.listRegionAutoscalers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionAutoscalersPagedResponse listRegionAutoscalers(
      ListRegionAutoscalersHttpRequest request) {
    return listRegionAutoscalersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionAutoscalersHttpRequest request = ListRegionAutoscalersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionAutoscalersPagedResponse&gt; future = regionAutoscalerClient.listRegionAutoscalersPagedCallable().futureCall(request);
   *   // Do something
   *   for (Autoscaler element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionAutoscalersHttpRequest, ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersPagedCallable() {
    return stub.listRegionAutoscalersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of autoscalers contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionAutoscalersHttpRequest request = ListRegionAutoscalersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     RegionAutoscalerList response = regionAutoscalerClient.listRegionAutoscalersCallable().call(request);
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
  public final UnaryCallable<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
      listRegionAutoscalersCallable() {
    return stub.listRegionAutoscalersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionAutoscalerClient.patchRegionAutoscaler(autoscaler, region, autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to patch.
   * @param region Name of the region scoping this request.
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
  public final Operation patchRegionAutoscaler(
      String autoscaler,
      ProjectRegionName region,
      Autoscaler autoscalerResource,
      List<String> fieldMask) {

    PatchRegionAutoscalerHttpRequest request =
        PatchRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setRegion(region == null ? null : region.toString())
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionAutoscalerClient.patchRegionAutoscaler(autoscaler, region.toString(), autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to patch.
   * @param region Name of the region scoping this request.
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
  public final Operation patchRegionAutoscaler(
      String autoscaler, String region, Autoscaler autoscalerResource, List<String> fieldMask) {

    PatchRegionAutoscalerHttpRequest request =
        PatchRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionAutoscalerHttpRequest request = PatchRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionAutoscalerClient.patchRegionAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionAutoscaler(PatchRegionAutoscalerHttpRequest request) {
    return patchRegionAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionAutoscalerHttpRequest request = PatchRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalerClient.patchRegionAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerCallable() {
    return stub.patchRegionAutoscalerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionAutoscalerClient.updateRegionAutoscaler(autoscaler, region, autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to update.
   * @param region Name of the region scoping this request.
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
  public final Operation updateRegionAutoscaler(
      String autoscaler,
      ProjectRegionName region,
      Autoscaler autoscalerResource,
      List<String> fieldMask) {

    UpdateRegionAutoscalerHttpRequest request =
        UpdateRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setRegion(region == null ? null : region.toString())
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionAutoscalerClient.updateRegionAutoscaler(autoscaler, region.toString(), autoscalerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param autoscaler Name of the autoscaler to update.
   * @param region Name of the region scoping this request.
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
  public final Operation updateRegionAutoscaler(
      String autoscaler, String region, Autoscaler autoscalerResource, List<String> fieldMask) {

    UpdateRegionAutoscalerHttpRequest request =
        UpdateRegionAutoscalerHttpRequest.newBuilder()
            .setAutoscaler(autoscaler)
            .setRegion(region)
            .setAutoscalerResource(autoscalerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionAutoscaler(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionAutoscalerHttpRequest request = UpdateRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionAutoscalerClient.updateRegionAutoscaler(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionAutoscaler(UpdateRegionAutoscalerHttpRequest request) {
    return updateRegionAutoscalerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an autoscaler in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionAutoscalerClient regionAutoscalerClient = RegionAutoscalerClient.create()) {
   *   String autoscaler = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Autoscaler autoscalerResource = Autoscaler.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionAutoscalerHttpRequest request = UpdateRegionAutoscalerHttpRequest.newBuilder()
   *     .setAutoscaler(autoscaler)
   *     .setRegion(region.toString())
   *     .setAutoscalerResource(autoscalerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionAutoscalerClient.updateRegionAutoscalerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerCallable() {
    return stub.updateRegionAutoscalerCallable();
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

  public static class ListRegionAutoscalersPagedResponse
      extends AbstractPagedListResponse<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          Autoscaler,
          ListRegionAutoscalersPage,
          ListRegionAutoscalersFixedSizeCollection> {

    public static ApiFuture<ListRegionAutoscalersPagedResponse> createAsync(
        PageContext<ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler> context,
        ApiFuture<RegionAutoscalerList> futureResponse) {
      ApiFuture<ListRegionAutoscalersPage> futurePage =
          ListRegionAutoscalersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionAutoscalersPage, ListRegionAutoscalersPagedResponse>() {
            @Override
            public ListRegionAutoscalersPagedResponse apply(ListRegionAutoscalersPage input) {
              return new ListRegionAutoscalersPagedResponse(input);
            }
          });
    }

    private ListRegionAutoscalersPagedResponse(ListRegionAutoscalersPage page) {
      super(page, ListRegionAutoscalersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionAutoscalersPage
      extends AbstractPage<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          Autoscaler,
          ListRegionAutoscalersPage> {

    private ListRegionAutoscalersPage(
        PageContext<ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler> context,
        RegionAutoscalerList response) {
      super(context, response);
    }

    private static ListRegionAutoscalersPage createEmptyPage() {
      return new ListRegionAutoscalersPage(null, null);
    }

    @Override
    protected ListRegionAutoscalersPage createPage(
        PageContext<ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler> context,
        RegionAutoscalerList response) {
      return new ListRegionAutoscalersPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionAutoscalersPage> createPageAsync(
        PageContext<ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler> context,
        ApiFuture<RegionAutoscalerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionAutoscalersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          Autoscaler,
          ListRegionAutoscalersPage,
          ListRegionAutoscalersFixedSizeCollection> {

    private ListRegionAutoscalersFixedSizeCollection(
        List<ListRegionAutoscalersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionAutoscalersFixedSizeCollection createEmptyCollection() {
      return new ListRegionAutoscalersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionAutoscalersFixedSizeCollection createCollection(
        List<ListRegionAutoscalersPage> pages, int collectionSize) {
      return new ListRegionAutoscalersFixedSizeCollection(pages, collectionSize);
    }
  }
}
