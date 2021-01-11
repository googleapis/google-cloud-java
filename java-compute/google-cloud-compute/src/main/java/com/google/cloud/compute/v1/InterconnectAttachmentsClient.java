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
import com.google.cloud.compute.v1.stub.InterconnectAttachmentsStub;
import com.google.cloud.compute.v1.stub.InterconnectAttachmentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The InterconnectAttachments API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String interconnectAttachment = "";
 *   Operation response = interconnectAttachmentsClient.delete(project, region, interconnectAttachment);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the interconnectAttachmentsClient object to clean up
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
 * <pre>
 * <code>
 * InterconnectAttachmentsSettings interconnectAttachmentsSettings =
 *     InterconnectAttachmentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create(interconnectAttachmentsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InterconnectAttachmentsSettings interconnectAttachmentsSettings =
 *     InterconnectAttachmentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectAttachmentsClient interconnectAttachmentsClient =
 *     InterconnectAttachmentsClient.create(interconnectAttachmentsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * This is for advanced usage - prefer to use InterconnectAttachmentsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InterconnectAttachmentsClient(InterconnectAttachmentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectAttachmentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectAttachmentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, InterconnectAttachmentsScopedList&gt; element : interconnectAttachmentsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInterconnectAttachmentsRequest request =
        AggregatedListInterconnectAttachmentsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   AggregatedListInterconnectAttachmentsRequest request = AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, InterconnectAttachmentsScopedList&gt; element : interconnectAttachmentsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListInterconnectAttachmentsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   AggregatedListInterconnectAttachmentsRequest request = AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = interconnectAttachmentsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, InterconnectAttachmentsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          AggregatedListInterconnectAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   AggregatedListInterconnectAttachmentsRequest request = AggregatedListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     InterconnectAttachmentAggregatedList response = interconnectAttachmentsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, InterconnectAttachmentsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<
          AggregatedListInterconnectAttachmentsRequest, InterconnectAttachmentAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String interconnectAttachment = "";
   *   Operation response = interconnectAttachmentsClient.delete(project, region, interconnectAttachment);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param interconnectAttachment Name of the interconnect attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String interconnectAttachment) {
    DeleteInterconnectAttachmentRequest request =
        DeleteInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachment(interconnectAttachment)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   String project = "";
   *   String region = "";
   *   DeleteInterconnectAttachmentRequest request = DeleteInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = interconnectAttachmentsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInterconnectAttachmentRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   String project = "";
   *   String region = "";
   *   DeleteInterconnectAttachmentRequest request = DeleteInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInterconnectAttachmentRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String interconnectAttachment = "";
   *   InterconnectAttachment response = interconnectAttachmentsClient.get(project, region, interconnectAttachment);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   String project = "";
   *   String region = "";
   *   GetInterconnectAttachmentRequest request = GetInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   InterconnectAttachment response = interconnectAttachmentsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment get(GetInterconnectAttachmentRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   String project = "";
   *   String region = "";
   *   GetInterconnectAttachmentRequest request = GetInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;InterconnectAttachment&gt; future = interconnectAttachmentsClient.getCallable().futureCall(request);
   *   // Do something
   *   InterconnectAttachment response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   Operation response = interconnectAttachmentsClient.insert(project, region, interconnectAttachmentResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param interconnectAttachmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, InterconnectAttachment interconnectAttachmentResource) {
    InsertInterconnectAttachmentRequest request =
        InsertInterconnectAttachmentRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertInterconnectAttachmentRequest request = InsertInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = interconnectAttachmentsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInterconnectAttachmentRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertInterconnectAttachmentRequest request = InsertInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertInterconnectAttachmentRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (InterconnectAttachment element : interconnectAttachmentsClient.list(project, region).iterateAll()) {
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
    ListInterconnectAttachmentsRequest request =
        ListInterconnectAttachmentsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListInterconnectAttachmentsRequest request = ListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (InterconnectAttachment element : interconnectAttachmentsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInterconnectAttachmentsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListInterconnectAttachmentsRequest request = ListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = interconnectAttachmentsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (InterconnectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInterconnectAttachmentsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListInterconnectAttachmentsRequest request = ListInterconnectAttachmentsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     InterconnectAttachmentList response = interconnectAttachmentsClient.listCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListInterconnectAttachmentsRequest, InterconnectAttachmentList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String interconnectAttachment = "";
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   Operation response = interconnectAttachmentsClient.patch(project, region, interconnectAttachment, interconnectAttachmentResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param interconnectAttachment Name of the interconnect attachment to patch.
   * @param interconnectAttachmentResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
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
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchInterconnectAttachmentRequest request = PatchInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = interconnectAttachmentsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchInterconnectAttachmentRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentsClient interconnectAttachmentsClient = InterconnectAttachmentsClient.create()) {
   *   String interconnectAttachment = "";
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchInterconnectAttachmentRequest request = PatchInterconnectAttachmentRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment)
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchInterconnectAttachmentRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
          Entry<String, InterconnectAttachmentsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Entry<String, InterconnectAttachmentsScopedList>>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
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
          AggregatedListInterconnectAttachmentsRequest,
          InterconnectAttachmentAggregatedList,
          Entry<String, InterconnectAttachmentsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Entry<String, InterconnectAttachmentsScopedList>>
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
                Entry<String, InterconnectAttachmentsScopedList>>
            context,
        InterconnectAttachmentAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsRequest,
                InterconnectAttachmentAggregatedList,
                Entry<String, InterconnectAttachmentsScopedList>>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInterconnectAttachmentsRequest,
          InterconnectAttachmentAggregatedList,
          Entry<String, InterconnectAttachmentsScopedList>,
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
