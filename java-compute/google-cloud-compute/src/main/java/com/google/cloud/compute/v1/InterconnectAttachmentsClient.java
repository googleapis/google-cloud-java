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
import com.google.cloud.compute.v1.stub.InterconnectAttachmentsStub;
import com.google.cloud.compute.v1.stub.InterconnectAttachmentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The InterconnectAttachments API.
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
 * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String interconnectAttachment = "interconnectAttachment1869250641";
 *   InterconnectAttachment response =
 *       interconnectAttachmentsClient.get(project, region, interconnectAttachment);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InterconnectAttachmentsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * InterconnectAttachmentsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterconnectAttachmentsSettings interconnectAttachmentsSettings =
 *     InterconnectAttachmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create(interconnectAttachmentsSettings);
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
 * InterconnectAttachmentsSettings interconnectAttachmentsSettings =
 *     InterconnectAttachmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create(interconnectAttachmentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InterconnectAttachmentsClient implements BackgroundResource {
  private final InterconnectAttachmentsSettings settings;
  private final InterconnectAttachmentsStub stub;

  /** Constructs an instance of InterconnectAttachmentsClient with default settings. */
  public static final InterconnectAttachmentsClient create() throws IOException {
    return create(InterconnectAttachmentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectAttachmentsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterconnectAttachmentsClient create(InterconnectAttachmentsSettings settings)
      throws IOException {
    return new InterconnectAttachmentsClient(settings);
  }

  /**
   * Constructs an instance of InterconnectAttachmentsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InterconnectAttachmentsSettings).
   */
  public static final InterconnectAttachmentsClient create(InterconnectAttachmentsStub stub) {
    return new InterconnectAttachmentsClient(stub);
  }

  /**
   * Constructs an instance of InterconnectAttachmentsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InterconnectAttachmentsClient(InterconnectAttachmentsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectAttachmentsStubSettings) settings.getStubSettings()).createStub();
  }

  protected InterconnectAttachmentsClient(InterconnectAttachmentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectAttachmentsSettings getSettings() {
    return settings;
  }

  public InterconnectAttachmentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, InterconnectAttachmentsScopedList> element :
   *       interconnectAttachmentsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInterconnectAttachmentsRequest request =
        AggregatedListInterconnectAttachmentsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   AggregatedListInterconnectAttachmentsRequest request =
   *       AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, InterconnectAttachmentsScopedList> element :
   *       interconnectAttachmentsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListInterconnectAttachmentsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   AggregatedListInterconnectAttachmentsRequest request =
   *       AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, InterconnectAttachmentsScopedList>> future =
   *       interconnectAttachmentsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, InterconnectAttachmentsScopedList> element :
   *       future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListInterconnectAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   AggregatedListInterconnectAttachmentsRequest request =
   *       AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InterconnectAttachmentAggregatedList response =
   *         interconnectAttachmentsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, InterconnectAttachmentsScopedList> element :
   *         response.getItemsList()) {
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
  public final UnaryCallable<
          AggregatedListInterconnectAttachmentsRequest, InterconnectAttachmentAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String interconnectAttachment = "interconnectAttachment1869250641";
   *   Operation response =
   *       interconnectAttachmentsClient.deleteAsync(project, region, interconnectAttachment).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param interconnectAttachment Name of the interconnect attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String interconnectAttachment) {
    DeleteInterconnectAttachmentRequest request =
        DeleteInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachment(interconnectAttachment)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = interconnectAttachmentsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteInterconnectAttachmentRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       interconnectAttachmentsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInterconnectAttachmentRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interconnectAttachmentsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterconnectAttachmentRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String interconnectAttachment = "interconnectAttachment1869250641";
   *   InterconnectAttachment response =
   *       interconnectAttachmentsClient.get(project, region, interconnectAttachment);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param interconnectAttachment Name of the interconnect attachment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment get(
      String project, String region, String interconnectAttachment) {
    GetInterconnectAttachmentRequest request =
        GetInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachment(interconnectAttachment)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   GetInterconnectAttachmentRequest request =
   *       GetInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   InterconnectAttachment response = interconnectAttachmentsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment get(GetInterconnectAttachmentRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   GetInterconnectAttachmentRequest request =
   *       GetInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<InterconnectAttachment> future =
   *       interconnectAttachmentsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InterconnectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   InterconnectAttachment interconnectAttachmentResource =
   *       InterconnectAttachment.newBuilder().build();
   *   Operation response =
   *       interconnectAttachmentsClient
   *           .insertAsync(project, region, interconnectAttachmentResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param interconnectAttachmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, InterconnectAttachment interconnectAttachmentResource) {
    InsertInterconnectAttachmentRequest request =
        InsertInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   InsertInterconnectAttachmentRequest request =
   *       InsertInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = interconnectAttachmentsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertInterconnectAttachmentRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   InsertInterconnectAttachmentRequest request =
   *       InsertInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       interconnectAttachmentsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertInterconnectAttachmentRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   InsertInterconnectAttachmentRequest request =
   *       InsertInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       interconnectAttachmentsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertInterconnectAttachmentRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (InterconnectAttachment element :
   *       interconnectAttachmentsClient.list(project, region).iterateAll()) {
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
    ListInterconnectAttachmentsRequest request =
        ListInterconnectAttachmentsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InterconnectAttachment element :
   *       interconnectAttachmentsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInterconnectAttachmentsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InterconnectAttachment> future =
   *       interconnectAttachmentsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterconnectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInterconnectAttachmentsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InterconnectAttachmentList response =
   *         interconnectAttachmentsClient.listCallable().call(request);
   *     for (InterconnectAttachment element : response.getItemsList()) {
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
  public final UnaryCallable<ListInterconnectAttachmentsRequest, InterconnectAttachmentList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String interconnectAttachment = "interconnectAttachment1869250641";
   *   InterconnectAttachment interconnectAttachmentResource =
   *       InterconnectAttachment.newBuilder().build();
   *   Operation response =
   *       interconnectAttachmentsClient
   *           .patchAsync(project, region, interconnectAttachment, interconnectAttachmentResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param interconnectAttachment Name of the interconnect attachment to patch.
   * @param interconnectAttachmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String region,
      String interconnectAttachment,
      InterconnectAttachment interconnectAttachmentResource) {
    PatchInterconnectAttachmentRequest request =
        PatchInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachment(interconnectAttachment)
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   PatchInterconnectAttachmentRequest request =
   *       PatchInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = interconnectAttachmentsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchInterconnectAttachmentRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   PatchInterconnectAttachmentRequest request =
   *       PatchInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       interconnectAttachmentsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchInterconnectAttachmentRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   PatchInterconnectAttachmentRequest request =
   *       PatchInterconnectAttachmentRequest.newBuilder()
   *           .setInterconnectAttachment("interconnectAttachment1869250641")
   *           .setInterconnectAttachmentResource(InterconnectAttachment.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interconnectAttachmentsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchInterconnectAttachmentRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an InterconnectAttachment. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource =
   *       RegionSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       interconnectAttachmentsClient
   *           .setLabelsAsync(project, region, resource, regionSetLabelsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      String project,
      String region,
      String resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {
    SetLabelsInterconnectAttachmentRequest request =
        SetLabelsInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an InterconnectAttachment. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   SetLabelsInterconnectAttachmentRequest request =
   *       SetLabelsInterconnectAttachmentRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = interconnectAttachmentsClient.setLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      SetLabelsInterconnectAttachmentRequest request) {
    return setLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an InterconnectAttachment. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   SetLabelsInterconnectAttachmentRequest request =
   *       SetLabelsInterconnectAttachmentRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       interconnectAttachmentsClient.setLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetLabelsInterconnectAttachmentRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return stub.setLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on an InterconnectAttachment. To learn more about labels, read the Labeling
   * Resources documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient =
   *     InterconnectAttachmentsClient.create()) {
   *   SetLabelsInterconnectAttachmentRequest request =
   *       SetLabelsInterconnectAttachmentRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetLabelsRequestResource(RegionSetLabelsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interconnectAttachmentsClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsInterconnectAttachmentRequest, Operation>
      setLabelsCallable() {
    return stub.setLabelsCallable();
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
          AggregatedListInterconnectAttachmentsRequest,
          InterconnectAttachmentAggregatedList,
          Map.Entry<String, InterconnectAttachmentsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Map.Entry<String, InterconnectAttachmentsScopedList>>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
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
          AggregatedListInterconnectAttachmentsRequest,
          InterconnectAttachmentAggregatedList,
          Map.Entry<String, InterconnectAttachmentsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Map.Entry<String, InterconnectAttachmentsScopedList>>
            context,
        InterconnectAttachmentAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Map.Entry<String, InterconnectAttachmentsScopedList>>
            context,
        InterconnectAttachmentAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Map.Entry<String, InterconnectAttachmentsScopedList>>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInterconnectAttachmentsRequest,
          InterconnectAttachmentAggregatedList,
          Map.Entry<String, InterconnectAttachmentsScopedList>,
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
          ListInterconnectAttachmentsRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListInterconnectAttachmentsRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        ApiFuture<InterconnectAttachmentList> futureResponse) {
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
      extends AbstractPage<
          ListInterconnectAttachmentsRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
          ListPage> {

    private ListPage(
        PageContext<
                ListInterconnectAttachmentsRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        InterconnectAttachmentList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListInterconnectAttachmentsRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        InterconnectAttachmentList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListInterconnectAttachmentsRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        ApiFuture<InterconnectAttachmentList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectAttachmentsRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
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
