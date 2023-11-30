/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.resourcemanager.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.stub.TagHoldsStub;
import com.google.cloud.resourcemanager.v3.stub.TagHoldsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Allow users to create and manage TagHolds for TagValues. TagHolds represent
 * the use of a Tag Value that is not captured by TagBindings but should still block TagValue
 * deletion (such as a reference in a policy condition). This service provides isolated failure
 * domains by cloud location so that TagHolds can be managed in the same location as their usage.
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
 * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
 *   TagValueName parent = TagValueName.of("[TAG_VALUE]");
 *   TagHold tagHold = TagHold.newBuilder().build();
 *   TagHold response = tagHoldsClient.createTagHoldAsync(parent, tagHold).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TagHoldsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>CreateTagHold</td>
 *      <td><p>Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same
 *  resource and origin exists under the same TagValue.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createTagHoldAsync(CreateTagHoldRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createTagHoldAsync(TagValueName parent, TagHold tagHold)
 *           <li>createTagHoldAsync(String parent, TagHold tagHold)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createTagHoldOperationCallable()
 *           <li>createTagHoldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteTagHold</td>
 *      <td><p>Deletes a TagHold.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteTagHoldAsync(DeleteTagHoldRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteTagHoldAsync(TagHoldName name)
 *           <li>deleteTagHoldAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteTagHoldOperationCallable()
 *           <li>deleteTagHoldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListTagHolds</td>
 *      <td><p>Lists TagHolds under a TagValue.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listTagHolds(ListTagHoldsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listTagHolds(TagValueName parent)
 *           <li>listTagHolds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listTagHoldsPagedCallable()
 *           <li>listTagHoldsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TagHoldsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagHoldsSettings tagHoldsSettings =
 *     TagHoldsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TagHoldsClient tagHoldsClient = TagHoldsClient.create(tagHoldsSettings);
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
 * TagHoldsSettings tagHoldsSettings =
 *     TagHoldsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TagHoldsClient tagHoldsClient = TagHoldsClient.create(tagHoldsSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagHoldsSettings tagHoldsSettings = TagHoldsSettings.newHttpJsonBuilder().build();
 * TagHoldsClient tagHoldsClient = TagHoldsClient.create(tagHoldsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TagHoldsClient implements BackgroundResource {
  private final TagHoldsSettings settings;
  private final TagHoldsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TagHoldsClient with default settings. */
  public static final TagHoldsClient create() throws IOException {
    return create(TagHoldsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TagHoldsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TagHoldsClient create(TagHoldsSettings settings) throws IOException {
    return new TagHoldsClient(settings);
  }

  /**
   * Constructs an instance of TagHoldsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TagHoldsSettings).
   */
  public static final TagHoldsClient create(TagHoldsStub stub) {
    return new TagHoldsClient(stub);
  }

  /**
   * Constructs an instance of TagHoldsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TagHoldsClient(TagHoldsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TagHoldsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TagHoldsClient(TagHoldsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TagHoldsSettings getSettings() {
    return settings;
  }

  public TagHoldsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists
   * under the same TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   TagValueName parent = TagValueName.of("[TAG_VALUE]");
   *   TagHold tagHold = TagHold.newBuilder().build();
   *   TagHold response = tagHoldsClient.createTagHoldAsync(parent, tagHold).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TagHold's parent TagValue. Must be of the
   *     form: `tagValues/{tag-value-id}`.
   * @param tagHold Required. The TagHold to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagHold, CreateTagHoldMetadata> createTagHoldAsync(
      TagValueName parent, TagHold tagHold) {
    CreateTagHoldRequest request =
        CreateTagHoldRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTagHold(tagHold)
            .build();
    return createTagHoldAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists
   * under the same TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   String parent = TagValueName.of("[TAG_VALUE]").toString();
   *   TagHold tagHold = TagHold.newBuilder().build();
   *   TagHold response = tagHoldsClient.createTagHoldAsync(parent, tagHold).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the TagHold's parent TagValue. Must be of the
   *     form: `tagValues/{tag-value-id}`.
   * @param tagHold Required. The TagHold to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagHold, CreateTagHoldMetadata> createTagHoldAsync(
      String parent, TagHold tagHold) {
    CreateTagHoldRequest request =
        CreateTagHoldRequest.newBuilder().setParent(parent).setTagHold(tagHold).build();
    return createTagHoldAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists
   * under the same TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   CreateTagHoldRequest request =
   *       CreateTagHoldRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setTagHold(TagHold.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagHold response = tagHoldsClient.createTagHoldAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagHold, CreateTagHoldMetadata> createTagHoldAsync(
      CreateTagHoldRequest request) {
    return createTagHoldOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists
   * under the same TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   CreateTagHoldRequest request =
   *       CreateTagHoldRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setTagHold(TagHold.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagHold, CreateTagHoldMetadata> future =
   *       tagHoldsClient.createTagHoldOperationCallable().futureCall(request);
   *   // Do something.
   *   TagHold response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationCallable() {
    return stub.createTagHoldOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists
   * under the same TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   CreateTagHoldRequest request =
   *       CreateTagHoldRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setTagHold(TagHold.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagHoldsClient.createTagHoldCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagHoldRequest, Operation> createTagHoldCallable() {
    return stub.createTagHoldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagHold.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   TagHoldName name = TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]");
   *   tagHoldsClient.deleteTagHoldAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TagHold to delete. Must be of the form:
   *     `tagValues/{tag-value-id}/tagHolds/{tag-hold-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagHoldMetadata> deleteTagHoldAsync(TagHoldName name) {
    DeleteTagHoldRequest request =
        DeleteTagHoldRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTagHoldAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagHold.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   String name = TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString();
   *   tagHoldsClient.deleteTagHoldAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TagHold to delete. Must be of the form:
   *     `tagValues/{tag-value-id}/tagHolds/{tag-hold-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagHoldMetadata> deleteTagHoldAsync(String name) {
    DeleteTagHoldRequest request = DeleteTagHoldRequest.newBuilder().setName(name).build();
    return deleteTagHoldAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagHold.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   DeleteTagHoldRequest request =
   *       DeleteTagHoldRequest.newBuilder()
   *           .setName(TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   tagHoldsClient.deleteTagHoldAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagHoldMetadata> deleteTagHoldAsync(
      DeleteTagHoldRequest request) {
    return deleteTagHoldOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagHold.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   DeleteTagHoldRequest request =
   *       DeleteTagHoldRequest.newBuilder()
   *           .setName(TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, DeleteTagHoldMetadata> future =
   *       tagHoldsClient.deleteTagHoldOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationCallable() {
    return stub.deleteTagHoldOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagHold.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   DeleteTagHoldRequest request =
   *       DeleteTagHoldRequest.newBuilder()
   *           .setName(TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagHoldsClient.deleteTagHoldCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagHoldRequest, Operation> deleteTagHoldCallable() {
    return stub.deleteTagHoldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TagHolds under a TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   TagValueName parent = TagValueName.of("[TAG_VALUE]");
   *   for (TagHold element : tagHoldsClient.listTagHolds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent TagValue. Must be of the form:
   *     `tagValues/{tag-value-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagHoldsPagedResponse listTagHolds(TagValueName parent) {
    ListTagHoldsRequest request =
        ListTagHoldsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTagHolds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TagHolds under a TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   String parent = TagValueName.of("[TAG_VALUE]").toString();
   *   for (TagHold element : tagHoldsClient.listTagHolds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent TagValue. Must be of the form:
   *     `tagValues/{tag-value-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagHoldsPagedResponse listTagHolds(String parent) {
    ListTagHoldsRequest request = ListTagHoldsRequest.newBuilder().setParent(parent).build();
    return listTagHolds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TagHolds under a TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   ListTagHoldsRequest request =
   *       ListTagHoldsRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (TagHold element : tagHoldsClient.listTagHolds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagHoldsPagedResponse listTagHolds(ListTagHoldsRequest request) {
    return listTagHoldsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TagHolds under a TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   ListTagHoldsRequest request =
   *       ListTagHoldsRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<TagHold> future = tagHoldsClient.listTagHoldsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TagHold element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagHoldsRequest, ListTagHoldsPagedResponse>
      listTagHoldsPagedCallable() {
    return stub.listTagHoldsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TagHolds under a TagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
   *   ListTagHoldsRequest request =
   *       ListTagHoldsRequest.newBuilder()
   *           .setParent(TagValueName.of("[TAG_VALUE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListTagHoldsResponse response = tagHoldsClient.listTagHoldsCallable().call(request);
   *     for (TagHold element : response.getTagHoldsList()) {
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
  public final UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsCallable() {
    return stub.listTagHoldsCallable();
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

  public static class ListTagHoldsPagedResponse
      extends AbstractPagedListResponse<
          ListTagHoldsRequest,
          ListTagHoldsResponse,
          TagHold,
          ListTagHoldsPage,
          ListTagHoldsFixedSizeCollection> {

    public static ApiFuture<ListTagHoldsPagedResponse> createAsync(
        PageContext<ListTagHoldsRequest, ListTagHoldsResponse, TagHold> context,
        ApiFuture<ListTagHoldsResponse> futureResponse) {
      ApiFuture<ListTagHoldsPage> futurePage =
          ListTagHoldsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTagHoldsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTagHoldsPagedResponse(ListTagHoldsPage page) {
      super(page, ListTagHoldsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagHoldsPage
      extends AbstractPage<ListTagHoldsRequest, ListTagHoldsResponse, TagHold, ListTagHoldsPage> {

    private ListTagHoldsPage(
        PageContext<ListTagHoldsRequest, ListTagHoldsResponse, TagHold> context,
        ListTagHoldsResponse response) {
      super(context, response);
    }

    private static ListTagHoldsPage createEmptyPage() {
      return new ListTagHoldsPage(null, null);
    }

    @Override
    protected ListTagHoldsPage createPage(
        PageContext<ListTagHoldsRequest, ListTagHoldsResponse, TagHold> context,
        ListTagHoldsResponse response) {
      return new ListTagHoldsPage(context, response);
    }

    @Override
    public ApiFuture<ListTagHoldsPage> createPageAsync(
        PageContext<ListTagHoldsRequest, ListTagHoldsResponse, TagHold> context,
        ApiFuture<ListTagHoldsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagHoldsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagHoldsRequest,
          ListTagHoldsResponse,
          TagHold,
          ListTagHoldsPage,
          ListTagHoldsFixedSizeCollection> {

    private ListTagHoldsFixedSizeCollection(List<ListTagHoldsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagHoldsFixedSizeCollection createEmptyCollection() {
      return new ListTagHoldsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagHoldsFixedSizeCollection createCollection(
        List<ListTagHoldsPage> pages, int collectionSize) {
      return new ListTagHoldsFixedSizeCollection(pages, collectionSize);
    }
  }
}
