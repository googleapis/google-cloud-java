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
import com.google.cloud.resourcemanager.v3.stub.TagKeysStub;
import com.google.cloud.resourcemanager.v3.stub.TagKeysStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Allow users to create and manage tag keys.
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
 * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
 *   TagKeyName name = TagKeyName.of("[TAG_KEY]");
 *   TagKey response = tagKeysClient.getTagKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TagKeysClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of TagKeysSettings to create().
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
 * TagKeysSettings tagKeysSettings =
 *     TagKeysSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TagKeysClient tagKeysClient = TagKeysClient.create(tagKeysSettings);
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
 * TagKeysSettings tagKeysSettings = TagKeysSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TagKeysClient tagKeysClient = TagKeysClient.create(tagKeysSettings);
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
 * TagKeysSettings tagKeysSettings =
 *     TagKeysSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             TagKeysSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * TagKeysClient tagKeysClient = TagKeysClient.create(tagKeysSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TagKeysClient implements BackgroundResource {
  private final TagKeysSettings settings;
  private final TagKeysStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TagKeysClient with default settings. */
  public static final TagKeysClient create() throws IOException {
    return create(TagKeysSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TagKeysClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TagKeysClient create(TagKeysSettings settings) throws IOException {
    return new TagKeysClient(settings);
  }

  /**
   * Constructs an instance of TagKeysClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TagKeysSettings).
   */
  public static final TagKeysClient create(TagKeysStub stub) {
    return new TagKeysClient(stub);
  }

  /**
   * Constructs an instance of TagKeysClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TagKeysClient(TagKeysSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TagKeysStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TagKeysClient(TagKeysStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TagKeysSettings getSettings() {
    return settings;
  }

  public TagKeysStub getStub() {
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
   * Lists all TagKeys for a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   for (TagKey element : tagKeysClient.listTagKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the new TagKey's parent. Must be of the form
   *     `folders/{folder_id}` or `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagKeysPagedResponse listTagKeys(ResourceName parent) {
    ListTagKeysRequest request =
        ListTagKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTagKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagKeys for a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   for (TagKey element : tagKeysClient.listTagKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the new TagKey's parent. Must be of the form
   *     `folders/{folder_id}` or `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagKeysPagedResponse listTagKeys(String parent) {
    ListTagKeysRequest request = ListTagKeysRequest.newBuilder().setParent(parent).build();
    return listTagKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagKeys for a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ListTagKeysRequest request =
   *       ListTagKeysRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TagKey element : tagKeysClient.listTagKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagKeysPagedResponse listTagKeys(ListTagKeysRequest request) {
    return listTagKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagKeys for a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ListTagKeysRequest request =
   *       ListTagKeysRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TagKey> future = tagKeysClient.listTagKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TagKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse>
      listTagKeysPagedCallable() {
    return stub.listTagKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagKeys for a parent resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ListTagKeysRequest request =
   *       ListTagKeysRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagKeysResponse response = tagKeysClient.listTagKeysCallable().call(request);
   *     for (TagKey element : response.getTagKeysList()) {
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
  public final UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable() {
    return stub.listTagKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or
   * the user does not have permission to view it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TagKeyName name = TagKeyName.of("[TAG_KEY]");
   *   TagKey response = tagKeysClient.getTagKey(name);
   * }
   * }</pre>
   *
   * @param name Required. A resource name in the format `tagKeys/{id}`, such as `tagKeys/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagKey getTagKey(TagKeyName name) {
    GetTagKeyRequest request =
        GetTagKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTagKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or
   * the user does not have permission to view it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String name = TagKeyName.of("[TAG_KEY]").toString();
   *   TagKey response = tagKeysClient.getTagKey(name);
   * }
   * }</pre>
   *
   * @param name Required. A resource name in the format `tagKeys/{id}`, such as `tagKeys/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagKey getTagKey(String name) {
    GetTagKeyRequest request = GetTagKeyRequest.newBuilder().setName(name).build();
    return getTagKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or
   * the user does not have permission to view it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   GetTagKeyRequest request =
   *       GetTagKeyRequest.newBuilder().setName(TagKeyName.of("[TAG_KEY]").toString()).build();
   *   TagKey response = tagKeysClient.getTagKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagKey getTagKey(GetTagKeyRequest request) {
    return getTagKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or
   * the user does not have permission to view it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   GetTagKeyRequest request =
   *       GetTagKeyRequest.newBuilder().setName(TagKeyName.of("[TAG_KEY]").toString()).build();
   *   ApiFuture<TagKey> future = tagKeysClient.getTagKeyCallable().futureCall(request);
   *   // Do something.
   *   TagKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable() {
    return stub.getTagKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TagKey. If another request with the same parameters is sent while the original
   * request is in process, the second request will receive an error. A maximum of 300 TagKeys can
   * exist under a parent at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TagKey tagKey = TagKey.newBuilder().build();
   *   TagKey response = tagKeysClient.createTagKeyAsync(tagKey).get();
   * }
   * }</pre>
   *
   * @param tagKey Required. The TagKey to be created. Only fields `short_name`, `description`, and
   *     `parent` are considered during the creation request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, CreateTagKeyMetadata> createTagKeyAsync(TagKey tagKey) {
    CreateTagKeyRequest request = CreateTagKeyRequest.newBuilder().setTagKey(tagKey).build();
    return createTagKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TagKey. If another request with the same parameters is sent while the original
   * request is in process, the second request will receive an error. A maximum of 300 TagKeys can
   * exist under a parent at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   CreateTagKeyRequest request =
   *       CreateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagKey response = tagKeysClient.createTagKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, CreateTagKeyMetadata> createTagKeyAsync(
      CreateTagKeyRequest request) {
    return createTagKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TagKey. If another request with the same parameters is sent while the original
   * request is in process, the second request will receive an error. A maximum of 300 TagKeys can
   * exist under a parent at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   CreateTagKeyRequest request =
   *       CreateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagKey, CreateTagKeyMetadata> future =
   *       tagKeysClient.createTagKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   TagKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable() {
    return stub.createTagKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TagKey. If another request with the same parameters is sent while the original
   * request is in process, the second request will receive an error. A maximum of 300 TagKeys can
   * exist under a parent at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   CreateTagKeyRequest request =
   *       CreateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagKeysClient.createTagKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable() {
    return stub.createTagKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagKey resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TagKey tagKey = TagKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagKey response = tagKeysClient.updateTagKeyAsync(tagKey, updateMask).get();
   * }
   * }</pre>
   *
   * @param tagKey Required. The new definition of the TagKey. Only the `description` and `etag`
   *     fields can be updated by this request. If the `etag` field is not empty, it must match the
   *     `etag` field of the existing tag key. Otherwise, `FAILED_PRECONDITION` will be returned.
   * @param updateMask Fields to be updated. The mask may only contain `description` or `etag`. If
   *     omitted entirely, both `description` and `etag` are assumed to be significant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, UpdateTagKeyMetadata> updateTagKeyAsync(
      TagKey tagKey, FieldMask updateMask) {
    UpdateTagKeyRequest request =
        UpdateTagKeyRequest.newBuilder().setTagKey(tagKey).setUpdateMask(updateMask).build();
    return updateTagKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagKey resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   UpdateTagKeyRequest request =
   *       UpdateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagKey response = tagKeysClient.updateTagKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, UpdateTagKeyMetadata> updateTagKeyAsync(
      UpdateTagKeyRequest request) {
    return updateTagKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagKey resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   UpdateTagKeyRequest request =
   *       UpdateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagKey, UpdateTagKeyMetadata> future =
   *       tagKeysClient.updateTagKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   TagKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable() {
    return stub.updateTagKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagKey resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   UpdateTagKeyRequest request =
   *       UpdateTagKeyRequest.newBuilder()
   *           .setTagKey(TagKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagKeysClient.updateTagKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable() {
    return stub.updateTagKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TagKeyName name = TagKeyName.of("[TAG_KEY]");
   *   TagKey response = tagKeysClient.deleteTagKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a TagKey to be deleted in the format `tagKeys/123`.
   *     The TagKey cannot be a parent of any existing TagValues or it will not be deleted
   *     successfully.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, DeleteTagKeyMetadata> deleteTagKeyAsync(TagKeyName name) {
    DeleteTagKeyRequest request =
        DeleteTagKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTagKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String name = TagKeyName.of("[TAG_KEY]").toString();
   *   TagKey response = tagKeysClient.deleteTagKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a TagKey to be deleted in the format `tagKeys/123`.
   *     The TagKey cannot be a parent of any existing TagValues or it will not be deleted
   *     successfully.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, DeleteTagKeyMetadata> deleteTagKeyAsync(String name) {
    DeleteTagKeyRequest request = DeleteTagKeyRequest.newBuilder().setName(name).build();
    return deleteTagKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   DeleteTagKeyRequest request =
   *       DeleteTagKeyRequest.newBuilder()
   *           .setName(TagKeyName.of("[TAG_KEY]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   TagKey response = tagKeysClient.deleteTagKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagKey, DeleteTagKeyMetadata> deleteTagKeyAsync(
      DeleteTagKeyRequest request) {
    return deleteTagKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   DeleteTagKeyRequest request =
   *       DeleteTagKeyRequest.newBuilder()
   *           .setName(TagKeyName.of("[TAG_KEY]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<TagKey, DeleteTagKeyMetadata> future =
   *       tagKeysClient.deleteTagKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   TagKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable() {
    return stub.deleteTagKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   DeleteTagKeyRequest request =
   *       DeleteTagKeyRequest.newBuilder()
   *           .setName(TagKeyName.of("[TAG_KEY]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = tagKeysClient.deleteTagKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable() {
    return stub.deleteTagKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a TagKey. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the TagKey's resource name. For example,
   * "tagKeys/1234". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy`
   * permission on the specified TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ResourceName resource = TagKeyName.of("[TAG_KEY]");
   *   Policy response = tagKeysClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a TagKey. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the TagKey's resource name. For example,
   * "tagKeys/1234". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy`
   * permission on the specified TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = tagKeysClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a TagKey. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the TagKey's resource name. For example,
   * "tagKeys/1234". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy`
   * permission on the specified TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = tagKeysClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a TagKey. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the TagKey's resource name. For example,
   * "tagKeys/1234". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy`
   * permission on the specified TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = tagKeysClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field
   * should be the TagKey's resource name. For example, "tagKeys/1234". The caller must have
   * `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ResourceName resource = TagKeyName.of("[TAG_KEY]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = tagKeysClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field
   * should be the TagKey's resource name. For example, "tagKeys/1234". The caller must have
   * `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = tagKeysClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field
   * should be the TagKey's resource name. For example, "tagKeys/1234". The caller must have
   * `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = tagKeysClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field
   * should be the TagKey's resource name. For example, "tagKeys/1234". The caller must have
   * `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = tagKeysClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified TagKey. The `resource` field should be
   * the TagKey's resource name. For example, "tagKeys/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   ResourceName resource = TagKeyName.of("[TAG_KEY]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = tagKeysClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified TagKey. The `resource` field should be
   * the TagKey's resource name. For example, "tagKeys/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = tagKeysClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified TagKey. The `resource` field should be
   * the TagKey's resource name. For example, "tagKeys/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = tagKeysClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified TagKey. The `resource` field should be
   * the TagKey's resource name. For example, "tagKeys/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TagKeyName.of("[TAG_KEY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       tagKeysClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

  public static class ListTagKeysPagedResponse
      extends AbstractPagedListResponse<
          ListTagKeysRequest,
          ListTagKeysResponse,
          TagKey,
          ListTagKeysPage,
          ListTagKeysFixedSizeCollection> {

    public static ApiFuture<ListTagKeysPagedResponse> createAsync(
        PageContext<ListTagKeysRequest, ListTagKeysResponse, TagKey> context,
        ApiFuture<ListTagKeysResponse> futureResponse) {
      ApiFuture<ListTagKeysPage> futurePage =
          ListTagKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTagKeysPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTagKeysPagedResponse(ListTagKeysPage page) {
      super(page, ListTagKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagKeysPage
      extends AbstractPage<ListTagKeysRequest, ListTagKeysResponse, TagKey, ListTagKeysPage> {

    private ListTagKeysPage(
        PageContext<ListTagKeysRequest, ListTagKeysResponse, TagKey> context,
        ListTagKeysResponse response) {
      super(context, response);
    }

    private static ListTagKeysPage createEmptyPage() {
      return new ListTagKeysPage(null, null);
    }

    @Override
    protected ListTagKeysPage createPage(
        PageContext<ListTagKeysRequest, ListTagKeysResponse, TagKey> context,
        ListTagKeysResponse response) {
      return new ListTagKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListTagKeysPage> createPageAsync(
        PageContext<ListTagKeysRequest, ListTagKeysResponse, TagKey> context,
        ApiFuture<ListTagKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagKeysRequest,
          ListTagKeysResponse,
          TagKey,
          ListTagKeysPage,
          ListTagKeysFixedSizeCollection> {

    private ListTagKeysFixedSizeCollection(List<ListTagKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagKeysFixedSizeCollection createEmptyCollection() {
      return new ListTagKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagKeysFixedSizeCollection createCollection(
        List<ListTagKeysPage> pages, int collectionSize) {
      return new ListTagKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
