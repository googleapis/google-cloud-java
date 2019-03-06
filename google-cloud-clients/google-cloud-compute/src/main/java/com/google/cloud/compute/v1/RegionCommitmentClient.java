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
import com.google.cloud.compute.v1.stub.RegionCommitmentStub;
import com.google.cloud.compute.v1.stub.RegionCommitmentStubSettings;
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
 * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
 *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
 *   Commitment response = regionCommitmentClient.getRegionCommitment(commitment);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionCommitmentClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionCommitmentSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionCommitmentSettings regionCommitmentSettings =
 *     RegionCommitmentSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionCommitmentClient regionCommitmentClient =
 *     RegionCommitmentClient.create(regionCommitmentSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionCommitmentSettings regionCommitmentSettings =
 *     RegionCommitmentSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionCommitmentClient regionCommitmentClient =
 *     RegionCommitmentClient.create(regionCommitmentSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionCommitmentClient implements BackgroundResource {
  private final RegionCommitmentSettings settings;
  private final RegionCommitmentStub stub;

  /** Constructs an instance of RegionCommitmentClient with default settings. */
  public static final RegionCommitmentClient create() throws IOException {
    return create(RegionCommitmentSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionCommitmentClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionCommitmentClient create(RegionCommitmentSettings settings)
      throws IOException {
    return new RegionCommitmentClient(settings);
  }

  /**
   * Constructs an instance of RegionCommitmentClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use RegionCommitmentSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionCommitmentClient create(RegionCommitmentStub stub) {
    return new RegionCommitmentClient(stub);
  }

  /**
   * Constructs an instance of RegionCommitmentClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionCommitmentClient(RegionCommitmentSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionCommitmentStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionCommitmentClient(RegionCommitmentStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionCommitmentSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionCommitmentStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of commitments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (CommitmentsScopedList element : regionCommitmentClient.aggregatedListRegionCommitments(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListRegionCommitmentsPagedResponse aggregatedListRegionCommitments(
      ProjectName project) {
    AggregatedListRegionCommitmentsHttpRequest request =
        AggregatedListRegionCommitmentsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListRegionCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of commitments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (CommitmentsScopedList element : regionCommitmentClient.aggregatedListRegionCommitments(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListRegionCommitmentsPagedResponse aggregatedListRegionCommitments(
      String project) {
    AggregatedListRegionCommitmentsHttpRequest request =
        AggregatedListRegionCommitmentsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListRegionCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of commitments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListRegionCommitmentsHttpRequest request = AggregatedListRegionCommitmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (CommitmentsScopedList element : regionCommitmentClient.aggregatedListRegionCommitments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListRegionCommitmentsPagedResponse aggregatedListRegionCommitments(
      AggregatedListRegionCommitmentsHttpRequest request) {
    return aggregatedListRegionCommitmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of commitments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListRegionCommitmentsHttpRequest request = AggregatedListRegionCommitmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListRegionCommitmentsPagedResponse&gt; future = regionCommitmentClient.aggregatedListRegionCommitmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (CommitmentsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListRegionCommitmentsHttpRequest, AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsPagedCallable() {
    return stub.aggregatedListRegionCommitmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of commitments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListRegionCommitmentsHttpRequest request = AggregatedListRegionCommitmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     CommitmentAggregatedList response = regionCommitmentClient.aggregatedListRegionCommitmentsCallable().call(request);
   *     for (CommitmentsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
      aggregatedListRegionCommitmentsCallable() {
    return stub.aggregatedListRegionCommitmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
   *   Commitment response = regionCommitmentClient.getRegionCommitment(commitment);
   * }
   * </code></pre>
   *
   * @param commitment Name of the commitment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Commitment getRegionCommitment(ProjectRegionCommitmentName commitment) {

    GetRegionCommitmentHttpRequest request =
        GetRegionCommitmentHttpRequest.newBuilder()
            .setCommitment(commitment == null ? null : commitment.toString())
            .build();
    return getRegionCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
   *   Commitment response = regionCommitmentClient.getRegionCommitment(commitment.toString());
   * }
   * </code></pre>
   *
   * @param commitment Name of the commitment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Commitment getRegionCommitment(String commitment) {

    GetRegionCommitmentHttpRequest request =
        GetRegionCommitmentHttpRequest.newBuilder().setCommitment(commitment).build();
    return getRegionCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
   *   GetRegionCommitmentHttpRequest request = GetRegionCommitmentHttpRequest.newBuilder()
   *     .setCommitment(commitment.toString())
   *     .build();
   *   Commitment response = regionCommitmentClient.getRegionCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Commitment getRegionCommitment(GetRegionCommitmentHttpRequest request) {
    return getRegionCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionCommitmentName commitment = ProjectRegionCommitmentName.of("[PROJECT]", "[REGION]", "[COMMITMENT]");
   *   GetRegionCommitmentHttpRequest request = GetRegionCommitmentHttpRequest.newBuilder()
   *     .setCommitment(commitment.toString())
   *     .build();
   *   ApiFuture&lt;Commitment&gt; future = regionCommitmentClient.getRegionCommitmentCallable().futureCall(request);
   *   // Do something
   *   Commitment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionCommitmentHttpRequest, Commitment>
      getRegionCommitmentCallable() {
    return stub.getRegionCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   Operation response = regionCommitmentClient.insertRegionCommitment(region, commitmentResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param commitmentResource Represents a Commitment resource. Creating a Commitment resource
   *     means that you are purchasing a committed use contract with an explicit start and end time.
   *     You can create commitments based on vCPUs and memory usage and receive discounted rates.
   *     For full details, read Signing Up for Committed Use Discounts.
   *     <p>Committed use discounts are subject to Google Cloud Platform's Service Specific Terms.
   *     By purchasing a committed use discount, you agree to these terms. Committed use discounts
   *     will not renew, so you must purchase a new commitment to continue receiving discounts. (==
   *     resource_for beta.commitments ==) (== resource_for v1.commitments ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionCommitment(
      ProjectRegionName region, Commitment commitmentResource) {

    InsertRegionCommitmentHttpRequest request =
        InsertRegionCommitmentHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setCommitmentResource(commitmentResource)
            .build();
    return insertRegionCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   Operation response = regionCommitmentClient.insertRegionCommitment(region.toString(), commitmentResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param commitmentResource Represents a Commitment resource. Creating a Commitment resource
   *     means that you are purchasing a committed use contract with an explicit start and end time.
   *     You can create commitments based on vCPUs and memory usage and receive discounted rates.
   *     For full details, read Signing Up for Committed Use Discounts.
   *     <p>Committed use discounts are subject to Google Cloud Platform's Service Specific Terms.
   *     By purchasing a committed use discount, you agree to these terms. Committed use discounts
   *     will not renew, so you must purchase a new commitment to continue receiving discounts. (==
   *     resource_for beta.commitments ==) (== resource_for v1.commitments ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionCommitment(String region, Commitment commitmentResource) {

    InsertRegionCommitmentHttpRequest request =
        InsertRegionCommitmentHttpRequest.newBuilder()
            .setRegion(region)
            .setCommitmentResource(commitmentResource)
            .build();
    return insertRegionCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   InsertRegionCommitmentHttpRequest request = InsertRegionCommitmentHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setCommitmentResource(commitmentResource)
   *     .build();
   *   Operation response = regionCommitmentClient.insertRegionCommitment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionCommitment(InsertRegionCommitmentHttpRequest request) {
    return insertRegionCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   InsertRegionCommitmentHttpRequest request = InsertRegionCommitmentHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setCommitmentResource(commitmentResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionCommitmentClient.insertRegionCommitmentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentCallable() {
    return stub.insertRegionCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Commitment element : regionCommitmentClient.listRegionCommitments(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionCommitmentsPagedResponse listRegionCommitments(ProjectRegionName region) {
    ListRegionCommitmentsHttpRequest request =
        ListRegionCommitmentsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Commitment element : regionCommitmentClient.listRegionCommitments(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionCommitmentsPagedResponse listRegionCommitments(String region) {
    ListRegionCommitmentsHttpRequest request =
        ListRegionCommitmentsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionCommitmentsHttpRequest request = ListRegionCommitmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (Commitment element : regionCommitmentClient.listRegionCommitments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionCommitmentsPagedResponse listRegionCommitments(
      ListRegionCommitmentsHttpRequest request) {
    return listRegionCommitmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionCommitmentsHttpRequest request = ListRegionCommitmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionCommitmentsPagedResponse&gt; future = regionCommitmentClient.listRegionCommitmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Commitment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionCommitmentsHttpRequest, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsPagedCallable() {
    return stub.listRegionCommitmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionCommitmentClient regionCommitmentClient = RegionCommitmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionCommitmentsHttpRequest request = ListRegionCommitmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     CommitmentList response = regionCommitmentClient.listRegionCommitmentsCallable().call(request);
   *     for (Commitment element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionCommitmentsHttpRequest, CommitmentList>
      listRegionCommitmentsCallable() {
    return stub.listRegionCommitmentsCallable();
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

  public static class AggregatedListRegionCommitmentsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          CommitmentsScopedList,
          AggregatedListRegionCommitmentsPage,
          AggregatedListRegionCommitmentsFixedSizeCollection> {

    public static ApiFuture<AggregatedListRegionCommitmentsPagedResponse> createAsync(
        PageContext<
                AggregatedListRegionCommitmentsHttpRequest,
                CommitmentAggregatedList,
                CommitmentsScopedList>
            context,
        ApiFuture<CommitmentAggregatedList> futureResponse) {
      ApiFuture<AggregatedListRegionCommitmentsPage> futurePage =
          AggregatedListRegionCommitmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListRegionCommitmentsPage, AggregatedListRegionCommitmentsPagedResponse>() {
            @Override
            public AggregatedListRegionCommitmentsPagedResponse apply(
                AggregatedListRegionCommitmentsPage input) {
              return new AggregatedListRegionCommitmentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListRegionCommitmentsPagedResponse(AggregatedListRegionCommitmentsPage page) {
      super(page, AggregatedListRegionCommitmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListRegionCommitmentsPage
      extends AbstractPage<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          CommitmentsScopedList,
          AggregatedListRegionCommitmentsPage> {

    private AggregatedListRegionCommitmentsPage(
        PageContext<
                AggregatedListRegionCommitmentsHttpRequest,
                CommitmentAggregatedList,
                CommitmentsScopedList>
            context,
        CommitmentAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListRegionCommitmentsPage createEmptyPage() {
      return new AggregatedListRegionCommitmentsPage(null, null);
    }

    @Override
    protected AggregatedListRegionCommitmentsPage createPage(
        PageContext<
                AggregatedListRegionCommitmentsHttpRequest,
                CommitmentAggregatedList,
                CommitmentsScopedList>
            context,
        CommitmentAggregatedList response) {
      return new AggregatedListRegionCommitmentsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListRegionCommitmentsPage> createPageAsync(
        PageContext<
                AggregatedListRegionCommitmentsHttpRequest,
                CommitmentAggregatedList,
                CommitmentsScopedList>
            context,
        ApiFuture<CommitmentAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListRegionCommitmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRegionCommitmentsHttpRequest,
          CommitmentAggregatedList,
          CommitmentsScopedList,
          AggregatedListRegionCommitmentsPage,
          AggregatedListRegionCommitmentsFixedSizeCollection> {

    private AggregatedListRegionCommitmentsFixedSizeCollection(
        List<AggregatedListRegionCommitmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListRegionCommitmentsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListRegionCommitmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListRegionCommitmentsFixedSizeCollection createCollection(
        List<AggregatedListRegionCommitmentsPage> pages, int collectionSize) {
      return new AggregatedListRegionCommitmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRegionCommitmentsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionCommitmentsHttpRequest,
          CommitmentList,
          Commitment,
          ListRegionCommitmentsPage,
          ListRegionCommitmentsFixedSizeCollection> {

    public static ApiFuture<ListRegionCommitmentsPagedResponse> createAsync(
        PageContext<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment> context,
        ApiFuture<CommitmentList> futureResponse) {
      ApiFuture<ListRegionCommitmentsPage> futurePage =
          ListRegionCommitmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionCommitmentsPage, ListRegionCommitmentsPagedResponse>() {
            @Override
            public ListRegionCommitmentsPagedResponse apply(ListRegionCommitmentsPage input) {
              return new ListRegionCommitmentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionCommitmentsPagedResponse(ListRegionCommitmentsPage page) {
      super(page, ListRegionCommitmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionCommitmentsPage
      extends AbstractPage<
          ListRegionCommitmentsHttpRequest, CommitmentList, Commitment, ListRegionCommitmentsPage> {

    private ListRegionCommitmentsPage(
        PageContext<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment> context,
        CommitmentList response) {
      super(context, response);
    }

    private static ListRegionCommitmentsPage createEmptyPage() {
      return new ListRegionCommitmentsPage(null, null);
    }

    @Override
    protected ListRegionCommitmentsPage createPage(
        PageContext<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment> context,
        CommitmentList response) {
      return new ListRegionCommitmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionCommitmentsPage> createPageAsync(
        PageContext<ListRegionCommitmentsHttpRequest, CommitmentList, Commitment> context,
        ApiFuture<CommitmentList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionCommitmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionCommitmentsHttpRequest,
          CommitmentList,
          Commitment,
          ListRegionCommitmentsPage,
          ListRegionCommitmentsFixedSizeCollection> {

    private ListRegionCommitmentsFixedSizeCollection(
        List<ListRegionCommitmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionCommitmentsFixedSizeCollection createEmptyCollection() {
      return new ListRegionCommitmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionCommitmentsFixedSizeCollection createCollection(
        List<ListRegionCommitmentsPage> pages, int collectionSize) {
      return new ListRegionCommitmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
