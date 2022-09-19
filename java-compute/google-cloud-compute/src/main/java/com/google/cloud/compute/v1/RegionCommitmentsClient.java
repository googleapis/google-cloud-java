/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionCommitmentsStub;
import com.google.cloud.compute.v1.stub.RegionCommitmentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionCommitments API.
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
 * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String commitment = "commitment1019005717";
 *   Commitment response = regionCommitmentsClient.get(project, region, commitment);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionCommitmentsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionCommitmentsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionCommitmentsSettings regionCommitmentsSettings =
 *     RegionCommitmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionCommitmentsClient regionCommitmentsClient =
 *     RegionCommitmentsClient.create(regionCommitmentsSettings);
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
 * RegionCommitmentsSettings regionCommitmentsSettings =
 *     RegionCommitmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionCommitmentsClient regionCommitmentsClient =
 *     RegionCommitmentsClient.create(regionCommitmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionCommitmentsClient implements BackgroundResource {
  private final RegionCommitmentsSettings settings;
  private final RegionCommitmentsStub stub;

  /** Constructs an instance of RegionCommitmentsClient with default settings. */
  public static final RegionCommitmentsClient create() throws IOException {
    return create(RegionCommitmentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionCommitmentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionCommitmentsClient create(RegionCommitmentsSettings settings)
      throws IOException {
    return new RegionCommitmentsClient(settings);
  }

  /**
   * Constructs an instance of RegionCommitmentsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(RegionCommitmentsSettings).
   */
  public static final RegionCommitmentsClient create(RegionCommitmentsStub stub) {
    return new RegionCommitmentsClient(stub);
  }

  /**
   * Constructs an instance of RegionCommitmentsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionCommitmentsClient(RegionCommitmentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionCommitmentsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionCommitmentsClient(RegionCommitmentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionCommitmentsSettings getSettings() {
    return settings;
  }

  public RegionCommitmentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of commitments by region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, CommitmentsScopedList> element :
   *       regionCommitmentsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListRegionCommitmentsRequest request =
        AggregatedListRegionCommitmentsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of commitments by region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   AggregatedListRegionCommitmentsRequest request =
   *       AggregatedListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, CommitmentsScopedList> element :
   *       regionCommitmentsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListRegionCommitmentsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of commitments by region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   AggregatedListRegionCommitmentsRequest request =
   *       AggregatedListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, CommitmentsScopedList>> future =
   *       regionCommitmentsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, CommitmentsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListRegionCommitmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of commitments by region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   AggregatedListRegionCommitmentsRequest request =
   *       AggregatedListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     CommitmentAggregatedList response =
   *         regionCommitmentsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, CommitmentsScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String commitment = "commitment1019005717";
   *   Commitment response = regionCommitmentsClient.get(project, region, commitment);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param commitment Name of the commitment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Commitment get(String project, String region, String commitment) {
    GetRegionCommitmentRequest request =
        GetRegionCommitmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCommitment(commitment)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   GetRegionCommitmentRequest request =
   *       GetRegionCommitmentRequest.newBuilder()
   *           .setCommitment("commitment1019005717")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   Commitment response = regionCommitmentsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Commitment get(GetRegionCommitmentRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified commitment resource. Gets a list of available commitments by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   GetRegionCommitmentRequest request =
   *       GetRegionCommitmentRequest.newBuilder()
   *           .setCommitment("commitment1019005717")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<Commitment> future = regionCommitmentsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Commitment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionCommitmentRequest, Commitment> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   Operation response =
   *       regionCommitmentsClient.insertAsync(project, region, commitmentResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param commitmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, Commitment commitmentResource) {
    InsertRegionCommitmentRequest request =
        InsertRegionCommitmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCommitmentResource(commitmentResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   InsertRegionCommitmentRequest request =
   *       InsertRegionCommitmentRequest.newBuilder()
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionCommitmentsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionCommitmentRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   InsertRegionCommitmentRequest request =
   *       InsertRegionCommitmentRequest.newBuilder()
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionCommitmentsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionCommitmentRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a commitment in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   InsertRegionCommitmentRequest request =
   *       InsertRegionCommitmentRequest.newBuilder()
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionCommitmentsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionCommitmentRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (Commitment element : regionCommitmentsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionCommitmentsRequest request =
        ListRegionCommitmentsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   ListRegionCommitmentsRequest request =
   *       ListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Commitment element : regionCommitmentsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionCommitmentsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   ListRegionCommitmentsRequest request =
   *       ListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Commitment> future =
   *       regionCommitmentsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Commitment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionCommitmentsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of commitments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   ListRegionCommitmentsRequest request =
   *       ListRegionCommitmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     CommitmentList response = regionCommitmentsClient.listCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListRegionCommitmentsRequest, CommitmentList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified commitment with the data included in the request. Update is performed
   * only on selected fields included as part of update-mask. Only the following fields can be
   * modified: auto_renew.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String commitment = "commitment1019005717";
   *   Commitment commitmentResource = Commitment.newBuilder().build();
   *   Operation response =
   *       regionCommitmentsClient
   *           .updateAsync(project, region, commitment, commitmentResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param commitment Name of the commitment for which auto renew is being updated.
   * @param commitmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String region, String commitment, Commitment commitmentResource) {
    UpdateRegionCommitmentRequest request =
        UpdateRegionCommitmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCommitment(commitment)
            .setCommitmentResource(commitmentResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified commitment with the data included in the request. Update is performed
   * only on selected fields included as part of update-mask. Only the following fields can be
   * modified: auto_renew.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   UpdateRegionCommitmentRequest request =
   *       UpdateRegionCommitmentRequest.newBuilder()
   *           .setCommitment("commitment1019005717")
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   Operation response = regionCommitmentsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateRegionCommitmentRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified commitment with the data included in the request. Update is performed
   * only on selected fields included as part of update-mask. Only the following fields can be
   * modified: auto_renew.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   UpdateRegionCommitmentRequest request =
   *       UpdateRegionCommitmentRequest.newBuilder()
   *           .setCommitment("commitment1019005717")
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionCommitmentsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegionCommitmentRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified commitment with the data included in the request. Update is performed
   * only on selected fields included as part of update-mask. Only the following fields can be
   * modified: auto_renew.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionCommitmentsClient regionCommitmentsClient = RegionCommitmentsClient.create()) {
   *   UpdateRegionCommitmentRequest request =
   *       UpdateRegionCommitmentRequest.newBuilder()
   *           .setCommitment("commitment1019005717")
   *           .setCommitmentResource(Commitment.newBuilder().build())
   *           .setPaths("paths106438894")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   ApiFuture<Operation> future = regionCommitmentsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegionCommitmentRequest, Operation> updateCallable() {
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
          AggregatedListRegionCommitmentsRequest,
          CommitmentAggregatedList,
          Map.Entry<String, CommitmentsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListRegionCommitmentsRequest,
                CommitmentAggregatedList,
                Map.Entry<String, CommitmentsScopedList>>
            context,
        ApiFuture<CommitmentAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListRegionCommitmentsRequest,
          CommitmentAggregatedList,
          Map.Entry<String, CommitmentsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListRegionCommitmentsRequest,
                CommitmentAggregatedList,
                Map.Entry<String, CommitmentsScopedList>>
            context,
        CommitmentAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListRegionCommitmentsRequest,
                CommitmentAggregatedList,
                Map.Entry<String, CommitmentsScopedList>>
            context,
        CommitmentAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListRegionCommitmentsRequest,
                CommitmentAggregatedList,
                Map.Entry<String, CommitmentsScopedList>>
            context,
        ApiFuture<CommitmentAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListRegionCommitmentsRequest,
          CommitmentAggregatedList,
          Map.Entry<String, CommitmentsScopedList>,
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
          ListRegionCommitmentsRequest,
          CommitmentList,
          Commitment,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionCommitmentsRequest, CommitmentList, Commitment> context,
        ApiFuture<CommitmentList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListRegionCommitmentsRequest, CommitmentList, Commitment, ListPage> {

    private ListPage(
        PageContext<ListRegionCommitmentsRequest, CommitmentList, Commitment> context,
        CommitmentList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionCommitmentsRequest, CommitmentList, Commitment> context,
        CommitmentList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionCommitmentsRequest, CommitmentList, Commitment> context,
        ApiFuture<CommitmentList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionCommitmentsRequest,
          CommitmentList,
          Commitment,
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
