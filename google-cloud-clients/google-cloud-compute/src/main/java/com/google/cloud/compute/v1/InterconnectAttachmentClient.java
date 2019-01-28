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
import com.google.cloud.compute.v1.stub.InterconnectAttachmentStub;
import com.google.cloud.compute.v1.stub.InterconnectAttachmentStubSettings;
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
 * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
 *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
 *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(interconnectAttachment);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the interconnectAttachmentClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of InterconnectAttachmentSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InterconnectAttachmentSettings interconnectAttachmentSettings =
 *     InterconnectAttachmentSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectAttachmentClient interconnectAttachmentClient =
 *     InterconnectAttachmentClient.create(interconnectAttachmentSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InterconnectAttachmentSettings interconnectAttachmentSettings =
 *     InterconnectAttachmentSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectAttachmentClient interconnectAttachmentClient =
 *     InterconnectAttachmentClient.create(interconnectAttachmentSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectAttachmentClient implements BackgroundResource {
  private final InterconnectAttachmentSettings settings;
  private final InterconnectAttachmentStub stub;

  /** Constructs an instance of InterconnectAttachmentClient with default settings. */
  public static final InterconnectAttachmentClient create() throws IOException {
    return create(InterconnectAttachmentSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectAttachmentClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterconnectAttachmentClient create(InterconnectAttachmentSettings settings)
      throws IOException {
    return new InterconnectAttachmentClient(settings);
  }

  /**
   * Constructs an instance of InterconnectAttachmentClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use InterconnectAttachmentSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InterconnectAttachmentClient create(InterconnectAttachmentStub stub) {
    return new InterconnectAttachmentClient(stub);
  }

  /**
   * Constructs an instance of InterconnectAttachmentClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InterconnectAttachmentClient(InterconnectAttachmentSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectAttachmentStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InterconnectAttachmentClient(InterconnectAttachmentStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectAttachmentSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectAttachmentStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InterconnectAttachmentsScopedList element : interconnectAttachmentClient.aggregatedListInterconnectAttachments(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInterconnectAttachmentsPagedResponse
      aggregatedListInterconnectAttachments(ProjectName project) {
    AggregatedListInterconnectAttachmentsHttpRequest request =
        AggregatedListInterconnectAttachmentsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InterconnectAttachmentsScopedList element : interconnectAttachmentClient.aggregatedListInterconnectAttachments(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInterconnectAttachmentsPagedResponse
      aggregatedListInterconnectAttachments(String project) {
    AggregatedListInterconnectAttachmentsHttpRequest request =
        AggregatedListInterconnectAttachmentsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInterconnectAttachmentsHttpRequest request = AggregatedListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (InterconnectAttachmentsScopedList element : interconnectAttachmentClient.aggregatedListInterconnectAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInterconnectAttachmentsPagedResponse
      aggregatedListInterconnectAttachments(
          AggregatedListInterconnectAttachmentsHttpRequest request) {
    return aggregatedListInterconnectAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInterconnectAttachmentsHttpRequest request = AggregatedListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListInterconnectAttachmentsPagedResponse&gt; future = interconnectAttachmentClient.aggregatedListInterconnectAttachmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InterconnectAttachmentsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInterconnectAttachmentsHttpRequest,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsPagedCallable() {
    return stub.aggregatedListInterconnectAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of interconnect attachments.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInterconnectAttachmentsHttpRequest request = AggregatedListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InterconnectAttachmentAggregatedList response = interconnectAttachmentClient.aggregatedListInterconnectAttachmentsCallable().call(request);
   *     for (InterconnectAttachmentsScopedList element : response.getItemsMap()) {
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
          AggregatedListInterconnectAttachmentsHttpRequest, InterconnectAttachmentAggregatedList>
      aggregatedListInterconnectAttachmentsCallable() {
    return stub.aggregatedListInterconnectAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(interconnectAttachment);
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnectAttachment(
      ProjectRegionInterconnectAttachmentName interconnectAttachment) {

    DeleteInterconnectAttachmentHttpRequest request =
        DeleteInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(
                interconnectAttachment == null ? null : interconnectAttachment.toString())
            .build();
    return deleteInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(interconnectAttachment.toString());
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnectAttachment(String interconnectAttachment) {

    DeleteInterconnectAttachmentHttpRequest request =
        DeleteInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(interconnectAttachment)
            .build();
    return deleteInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   DeleteInterconnectAttachmentHttpRequest request = DeleteInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .build();
   *   Operation response = interconnectAttachmentClient.deleteInterconnectAttachment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInterconnectAttachment(
      DeleteInterconnectAttachmentHttpRequest request) {
    return deleteInterconnectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   DeleteInterconnectAttachmentHttpRequest request = DeleteInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentClient.deleteInterconnectAttachmentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    return stub.deleteInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment response = interconnectAttachmentClient.getInterconnectAttachment(interconnectAttachment);
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectAttachment getInterconnectAttachment(
      ProjectRegionInterconnectAttachmentName interconnectAttachment) {

    GetInterconnectAttachmentHttpRequest request =
        GetInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(
                interconnectAttachment == null ? null : interconnectAttachment.toString())
            .build();
    return getInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment response = interconnectAttachmentClient.getInterconnectAttachment(interconnectAttachment.toString());
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectAttachment getInterconnectAttachment(String interconnectAttachment) {

    GetInterconnectAttachmentHttpRequest request =
        GetInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(interconnectAttachment)
            .build();
    return getInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   GetInterconnectAttachmentHttpRequest request = GetInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .build();
   *   InterconnectAttachment response = interconnectAttachmentClient.getInterconnectAttachment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InterconnectAttachment getInterconnectAttachment(
      GetInterconnectAttachmentHttpRequest request) {
    return getInterconnectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect attachment.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   GetInterconnectAttachmentHttpRequest request = GetInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .build();
   *   ApiFuture&lt;InterconnectAttachment&gt; future = interconnectAttachmentClient.getInterconnectAttachmentCallable().futureCall(request);
   *   // Do something
   *   InterconnectAttachment response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    return stub.getInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   Operation response = interconnectAttachmentClient.insertInterconnectAttachment(region, interconnectAttachmentResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param interconnectAttachmentResource Represents an InterconnectAttachment (VLAN attachment)
   *     resource. For more information, see Creating VLAN Attachments. (== resource_for
   *     beta.interconnectAttachments ==) (== resource_for v1.interconnectAttachments ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnectAttachment(
      ProjectRegionName region, InterconnectAttachment interconnectAttachmentResource) {

    InsertInterconnectAttachmentHttpRequest request =
        InsertInterconnectAttachmentHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .build();
    return insertInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   Operation response = interconnectAttachmentClient.insertInterconnectAttachment(region.toString(), interconnectAttachmentResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param interconnectAttachmentResource Represents an InterconnectAttachment (VLAN attachment)
   *     resource. For more information, see Creating VLAN Attachments. (== resource_for
   *     beta.interconnectAttachments ==) (== resource_for v1.interconnectAttachments ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnectAttachment(
      String region, InterconnectAttachment interconnectAttachmentResource) {

    InsertInterconnectAttachmentHttpRequest request =
        InsertInterconnectAttachmentHttpRequest.newBuilder()
            .setRegion(region)
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .build();
    return insertInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   InsertInterconnectAttachmentHttpRequest request = InsertInterconnectAttachmentHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .build();
   *   Operation response = interconnectAttachmentClient.insertInterconnectAttachment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInterconnectAttachment(
      InsertInterconnectAttachmentHttpRequest request) {
    return insertInterconnectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an InterconnectAttachment in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   InsertInterconnectAttachmentHttpRequest request = InsertInterconnectAttachmentHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentClient.insertInterconnectAttachmentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentCallable() {
    return stub.insertInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InterconnectAttachment element : interconnectAttachmentClient.listInterconnectAttachments(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(
      ProjectRegionName region) {
    ListInterconnectAttachmentsHttpRequest request =
        ListInterconnectAttachmentsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InterconnectAttachment element : interconnectAttachmentClient.listInterconnectAttachments(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(String region) {
    ListInterconnectAttachmentsHttpRequest request =
        ListInterconnectAttachmentsHttpRequest.newBuilder().setRegion(region).build();
    return listInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListInterconnectAttachmentsHttpRequest request = ListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (InterconnectAttachment element : interconnectAttachmentClient.listInterconnectAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(
      ListInterconnectAttachmentsHttpRequest request) {
    return listInterconnectAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListInterconnectAttachmentsHttpRequest request = ListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListInterconnectAttachmentsPagedResponse&gt; future = interconnectAttachmentClient.listInterconnectAttachmentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InterconnectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInterconnectAttachmentsHttpRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    return stub.listInterconnectAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect attachments contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListInterconnectAttachmentsHttpRequest request = ListInterconnectAttachmentsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     InterconnectAttachmentList response = interconnectAttachmentClient.listInterconnectAttachmentsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
      listInterconnectAttachmentsCallable() {
    return stub.listInterconnectAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = interconnectAttachmentClient.patchInterconnectAttachment(interconnectAttachment, interconnectAttachmentResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to patch.
   * @param interconnectAttachmentResource Represents an InterconnectAttachment (VLAN attachment)
   *     resource. For more information, see Creating VLAN Attachments. (== resource_for
   *     beta.interconnectAttachments ==) (== resource_for v1.interconnectAttachments ==)
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnectAttachment(
      ProjectRegionInterconnectAttachmentName interconnectAttachment,
      InterconnectAttachment interconnectAttachmentResource,
      List<String> fieldMask) {

    PatchInterconnectAttachmentHttpRequest request =
        PatchInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(
                interconnectAttachment == null ? null : interconnectAttachment.toString())
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = interconnectAttachmentClient.patchInterconnectAttachment(interconnectAttachment.toString(), interconnectAttachmentResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param interconnectAttachment Name of the interconnect attachment to patch.
   * @param interconnectAttachmentResource Represents an InterconnectAttachment (VLAN attachment)
   *     resource. For more information, see Creating VLAN Attachments. (== resource_for
   *     beta.interconnectAttachments ==) (== resource_for v1.interconnectAttachments ==)
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnectAttachment(
      String interconnectAttachment,
      InterconnectAttachment interconnectAttachmentResource,
      List<String> fieldMask) {

    PatchInterconnectAttachmentHttpRequest request =
        PatchInterconnectAttachmentHttpRequest.newBuilder()
            .setInterconnectAttachment(interconnectAttachment)
            .setInterconnectAttachmentResource(interconnectAttachmentResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInterconnectAttachmentHttpRequest request = PatchInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = interconnectAttachmentClient.patchInterconnectAttachment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInterconnectAttachment(
      PatchInterconnectAttachmentHttpRequest request) {
    return patchInterconnectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect attachment with the data included in the request. This
   * method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectAttachmentClient interconnectAttachmentClient = InterconnectAttachmentClient.create()) {
   *   ProjectRegionInterconnectAttachmentName interconnectAttachment = ProjectRegionInterconnectAttachmentName.of("[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment interconnectAttachmentResource = InterconnectAttachment.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInterconnectAttachmentHttpRequest request = PatchInterconnectAttachmentHttpRequest.newBuilder()
   *     .setInterconnectAttachment(interconnectAttachment.toString())
   *     .setInterconnectAttachmentResource(interconnectAttachmentResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectAttachmentClient.patchInterconnectAttachmentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchInterconnectAttachmentHttpRequest, Operation>
      patchInterconnectAttachmentCallable() {
    return stub.patchInterconnectAttachmentCallable();
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

  public static class AggregatedListInterconnectAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          InterconnectAttachmentsScopedList,
          AggregatedListInterconnectAttachmentsPage,
          AggregatedListInterconnectAttachmentsFixedSizeCollection> {

    public static ApiFuture<AggregatedListInterconnectAttachmentsPagedResponse> createAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentAggregatedList,
                InterconnectAttachmentsScopedList>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
      ApiFuture<AggregatedListInterconnectAttachmentsPage> futurePage =
          AggregatedListInterconnectAttachmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListInterconnectAttachmentsPage,
              AggregatedListInterconnectAttachmentsPagedResponse>() {
            @Override
            public AggregatedListInterconnectAttachmentsPagedResponse apply(
                AggregatedListInterconnectAttachmentsPage input) {
              return new AggregatedListInterconnectAttachmentsPagedResponse(input);
            }
          });
    }

    private AggregatedListInterconnectAttachmentsPagedResponse(
        AggregatedListInterconnectAttachmentsPage page) {
      super(page, AggregatedListInterconnectAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListInterconnectAttachmentsPage
      extends AbstractPage<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          InterconnectAttachmentsScopedList,
          AggregatedListInterconnectAttachmentsPage> {

    private AggregatedListInterconnectAttachmentsPage(
        PageContext<
                AggregatedListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentAggregatedList,
                InterconnectAttachmentsScopedList>
            context,
        InterconnectAttachmentAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListInterconnectAttachmentsPage createEmptyPage() {
      return new AggregatedListInterconnectAttachmentsPage(null, null);
    }

    @Override
    protected AggregatedListInterconnectAttachmentsPage createPage(
        PageContext<
                AggregatedListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentAggregatedList,
                InterconnectAttachmentsScopedList>
            context,
        InterconnectAttachmentAggregatedList response) {
      return new AggregatedListInterconnectAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListInterconnectAttachmentsPage> createPageAsync(
        PageContext<
                AggregatedListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentAggregatedList,
                InterconnectAttachmentsScopedList>
            context,
        ApiFuture<InterconnectAttachmentAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListInterconnectAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentAggregatedList,
          InterconnectAttachmentsScopedList,
          AggregatedListInterconnectAttachmentsPage,
          AggregatedListInterconnectAttachmentsFixedSizeCollection> {

    private AggregatedListInterconnectAttachmentsFixedSizeCollection(
        List<AggregatedListInterconnectAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListInterconnectAttachmentsFixedSizeCollection
        createEmptyCollection() {
      return new AggregatedListInterconnectAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListInterconnectAttachmentsFixedSizeCollection createCollection(
        List<AggregatedListInterconnectAttachmentsPage> pages, int collectionSize) {
      return new AggregatedListInterconnectAttachmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterconnectAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage,
          ListInterconnectAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListInterconnectAttachmentsPagedResponse> createAsync(
        PageContext<
                ListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        ApiFuture<InterconnectAttachmentList> futureResponse) {
      ApiFuture<ListInterconnectAttachmentsPage> futurePage =
          ListInterconnectAttachmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListInterconnectAttachmentsPage, ListInterconnectAttachmentsPagedResponse>() {
            @Override
            public ListInterconnectAttachmentsPagedResponse apply(
                ListInterconnectAttachmentsPage input) {
              return new ListInterconnectAttachmentsPagedResponse(input);
            }
          });
    }

    private ListInterconnectAttachmentsPagedResponse(ListInterconnectAttachmentsPage page) {
      super(page, ListInterconnectAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterconnectAttachmentsPage
      extends AbstractPage<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage> {

    private ListInterconnectAttachmentsPage(
        PageContext<
                ListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        InterconnectAttachmentList response) {
      super(context, response);
    }

    private static ListInterconnectAttachmentsPage createEmptyPage() {
      return new ListInterconnectAttachmentsPage(null, null);
    }

    @Override
    protected ListInterconnectAttachmentsPage createPage(
        PageContext<
                ListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        InterconnectAttachmentList response) {
      return new ListInterconnectAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterconnectAttachmentsPage> createPageAsync(
        PageContext<
                ListInterconnectAttachmentsHttpRequest,
                InterconnectAttachmentList,
                InterconnectAttachment>
            context,
        ApiFuture<InterconnectAttachmentList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterconnectAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectAttachmentsHttpRequest,
          InterconnectAttachmentList,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage,
          ListInterconnectAttachmentsFixedSizeCollection> {

    private ListInterconnectAttachmentsFixedSizeCollection(
        List<ListInterconnectAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterconnectAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListInterconnectAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterconnectAttachmentsFixedSizeCollection createCollection(
        List<ListInterconnectAttachmentsPage> pages, int collectionSize) {
      return new ListInterconnectAttachmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
