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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcemanager.v3.stub.TagBindingsStub;
import com.google.cloud.resourcemanager.v3.stub.TagBindingsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Allow users to create and manage TagBindings between TagValues and different
 * cloud resources throughout the GCP resource hierarchy.
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
 * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
 *   ResourceName parent = FolderName.of("[FOLDER]");
 *   for (TagBinding element : tagBindingsClient.listTagBindings(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TagBindingsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of TagBindingsSettings to
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
 * TagBindingsSettings tagBindingsSettings =
 *     TagBindingsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TagBindingsClient tagBindingsClient = TagBindingsClient.create(tagBindingsSettings);
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
 * TagBindingsSettings tagBindingsSettings =
 *     TagBindingsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TagBindingsClient tagBindingsClient = TagBindingsClient.create(tagBindingsSettings);
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
 * TagBindingsSettings tagBindingsSettings = TagBindingsSettings.newHttpJsonBuilder().build();
 * TagBindingsClient tagBindingsClient = TagBindingsClient.create(tagBindingsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TagBindingsClient implements BackgroundResource {
  private final TagBindingsSettings settings;
  private final TagBindingsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TagBindingsClient with default settings. */
  public static final TagBindingsClient create() throws IOException {
    return create(TagBindingsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TagBindingsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TagBindingsClient create(TagBindingsSettings settings) throws IOException {
    return new TagBindingsClient(settings);
  }

  /**
   * Constructs an instance of TagBindingsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TagBindingsSettings).
   */
  public static final TagBindingsClient create(TagBindingsStub stub) {
    return new TagBindingsClient(stub);
  }

  /**
   * Constructs an instance of TagBindingsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TagBindingsClient(TagBindingsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TagBindingsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TagBindingsClient(TagBindingsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TagBindingsSettings getSettings() {
    return settings;
  }

  public TagBindingsStub getStub() {
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
   * Lists the TagBindings for the given cloud resource, as specified with `parent`.
   *
   * <p>NOTE: The `parent` field is expected to be a full resource name:
   * https://cloud.google.com/apis/design/resource_names#full_resource_name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   for (TagBinding element : tagBindingsClient.listTagBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of a resource for which you want to list
   *     existing TagBindings. E.g. "//cloudresourcemanager.googleapis.com/projects/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagBindingsPagedResponse listTagBindings(ResourceName parent) {
    ListTagBindingsRequest request =
        ListTagBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTagBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TagBindings for the given cloud resource, as specified with `parent`.
   *
   * <p>NOTE: The `parent` field is expected to be a full resource name:
   * https://cloud.google.com/apis/design/resource_names#full_resource_name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   for (TagBinding element : tagBindingsClient.listTagBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The full resource name of a resource for which you want to list
   *     existing TagBindings. E.g. "//cloudresourcemanager.googleapis.com/projects/123"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagBindingsPagedResponse listTagBindings(String parent) {
    ListTagBindingsRequest request = ListTagBindingsRequest.newBuilder().setParent(parent).build();
    return listTagBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TagBindings for the given cloud resource, as specified with `parent`.
   *
   * <p>NOTE: The `parent` field is expected to be a full resource name:
   * https://cloud.google.com/apis/design/resource_names#full_resource_name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   ListTagBindingsRequest request =
   *       ListTagBindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TagBinding element : tagBindingsClient.listTagBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagBindingsPagedResponse listTagBindings(ListTagBindingsRequest request) {
    return listTagBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TagBindings for the given cloud resource, as specified with `parent`.
   *
   * <p>NOTE: The `parent` field is expected to be a full resource name:
   * https://cloud.google.com/apis/design/resource_names#full_resource_name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   ListTagBindingsRequest request =
   *       ListTagBindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TagBinding> future =
   *       tagBindingsClient.listTagBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TagBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable() {
    return stub.listTagBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the TagBindings for the given cloud resource, as specified with `parent`.
   *
   * <p>NOTE: The `parent` field is expected to be a full resource name:
   * https://cloud.google.com/apis/design/resource_names#full_resource_name
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   ListTagBindingsRequest request =
   *       ListTagBindingsRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagBindingsResponse response =
   *         tagBindingsClient.listTagBindingsCallable().call(request);
   *     for (TagBinding element : response.getTagBindingsList()) {
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
  public final UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse>
      listTagBindingsCallable() {
    return stub.listTagBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagBinding between a TagValue and a cloud resource (currently project, folder, or
   * organization).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   TagBinding tagBinding = TagBinding.newBuilder().build();
   *   TagBinding response = tagBindingsClient.createTagBindingAsync(tagBinding).get();
   * }
   * }</pre>
   *
   * @param tagBinding Required. The TagBinding to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagBinding, CreateTagBindingMetadata> createTagBindingAsync(
      TagBinding tagBinding) {
    CreateTagBindingRequest request =
        CreateTagBindingRequest.newBuilder().setTagBinding(tagBinding).build();
    return createTagBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagBinding between a TagValue and a cloud resource (currently project, folder, or
   * organization).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   CreateTagBindingRequest request =
   *       CreateTagBindingRequest.newBuilder()
   *           .setTagBinding(TagBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagBinding response = tagBindingsClient.createTagBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagBinding, CreateTagBindingMetadata> createTagBindingAsync(
      CreateTagBindingRequest request) {
    return createTagBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagBinding between a TagValue and a cloud resource (currently project, folder, or
   * organization).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   CreateTagBindingRequest request =
   *       CreateTagBindingRequest.newBuilder()
   *           .setTagBinding(TagBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagBinding, CreateTagBindingMetadata> future =
   *       tagBindingsClient.createTagBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   TagBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable() {
    return stub.createTagBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagBinding between a TagValue and a cloud resource (currently project, folder, or
   * organization).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   CreateTagBindingRequest request =
   *       CreateTagBindingRequest.newBuilder()
   *           .setTagBinding(TagBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       tagBindingsClient.createTagBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable() {
    return stub.createTagBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   TagBindingName name = TagBindingName.of("[TAG_BINDING]");
   *   tagBindingsClient.deleteTagBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TagBinding. This is a String of the form:
   *     `tagBindings/{id}` (e.g.
   *     `tagBindings/%2F%2Fcloudresourcemanager.googleapis.com%2Fprojects%2F123/tagValues/456`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagBindingMetadata> deleteTagBindingAsync(
      TagBindingName name) {
    DeleteTagBindingRequest request =
        DeleteTagBindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTagBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   String name = TagBindingName.of("[TAG_BINDING]").toString();
   *   tagBindingsClient.deleteTagBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TagBinding. This is a String of the form:
   *     `tagBindings/{id}` (e.g.
   *     `tagBindings/%2F%2Fcloudresourcemanager.googleapis.com%2Fprojects%2F123/tagValues/456`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagBindingMetadata> deleteTagBindingAsync(String name) {
    DeleteTagBindingRequest request = DeleteTagBindingRequest.newBuilder().setName(name).build();
    return deleteTagBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   DeleteTagBindingRequest request =
   *       DeleteTagBindingRequest.newBuilder()
   *           .setName(TagBindingName.of("[TAG_BINDING]").toString())
   *           .build();
   *   tagBindingsClient.deleteTagBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteTagBindingMetadata> deleteTagBindingAsync(
      DeleteTagBindingRequest request) {
    return deleteTagBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   DeleteTagBindingRequest request =
   *       DeleteTagBindingRequest.newBuilder()
   *           .setName(TagBindingName.of("[TAG_BINDING]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteTagBindingMetadata> future =
   *       tagBindingsClient.deleteTagBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable() {
    return stub.deleteTagBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
   *   DeleteTagBindingRequest request =
   *       DeleteTagBindingRequest.newBuilder()
   *           .setName(TagBindingName.of("[TAG_BINDING]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       tagBindingsClient.deleteTagBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable() {
    return stub.deleteTagBindingCallable();
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

  public static class ListTagBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListTagBindingsRequest,
          ListTagBindingsResponse,
          TagBinding,
          ListTagBindingsPage,
          ListTagBindingsFixedSizeCollection> {

    public static ApiFuture<ListTagBindingsPagedResponse> createAsync(
        PageContext<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding> context,
        ApiFuture<ListTagBindingsResponse> futureResponse) {
      ApiFuture<ListTagBindingsPage> futurePage =
          ListTagBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTagBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTagBindingsPagedResponse(ListTagBindingsPage page) {
      super(page, ListTagBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagBindingsPage
      extends AbstractPage<
          ListTagBindingsRequest, ListTagBindingsResponse, TagBinding, ListTagBindingsPage> {

    private ListTagBindingsPage(
        PageContext<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding> context,
        ListTagBindingsResponse response) {
      super(context, response);
    }

    private static ListTagBindingsPage createEmptyPage() {
      return new ListTagBindingsPage(null, null);
    }

    @Override
    protected ListTagBindingsPage createPage(
        PageContext<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding> context,
        ListTagBindingsResponse response) {
      return new ListTagBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListTagBindingsPage> createPageAsync(
        PageContext<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding> context,
        ApiFuture<ListTagBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagBindingsRequest,
          ListTagBindingsResponse,
          TagBinding,
          ListTagBindingsPage,
          ListTagBindingsFixedSizeCollection> {

    private ListTagBindingsFixedSizeCollection(
        List<ListTagBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagBindingsFixedSizeCollection createEmptyCollection() {
      return new ListTagBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagBindingsFixedSizeCollection createCollection(
        List<ListTagBindingsPage> pages, int collectionSize) {
      return new ListTagBindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
