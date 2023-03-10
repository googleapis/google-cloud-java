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
import com.google.cloud.resourcemanager.v3.stub.TagValuesStub;
import com.google.cloud.resourcemanager.v3.stub.TagValuesStubSettings;
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
 * Service Description: Allow users to create and manage tag values.
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
 * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
 *   TagValueName name = TagValueName.of("[TAG_VALUE]");
 *   TagValue response = tagValuesClient.getTagValue(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TagValuesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of TagValuesSettings to create().
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
 * TagValuesSettings tagValuesSettings =
 *     TagValuesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TagValuesClient tagValuesClient = TagValuesClient.create(tagValuesSettings);
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
 * TagValuesSettings tagValuesSettings =
 *     TagValuesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TagValuesClient tagValuesClient = TagValuesClient.create(tagValuesSettings);
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
 * TagValuesSettings tagValuesSettings = TagValuesSettings.newHttpJsonBuilder().build();
 * TagValuesClient tagValuesClient = TagValuesClient.create(tagValuesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TagValuesClient implements BackgroundResource {
  private final TagValuesSettings settings;
  private final TagValuesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TagValuesClient with default settings. */
  public static final TagValuesClient create() throws IOException {
    return create(TagValuesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TagValuesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TagValuesClient create(TagValuesSettings settings) throws IOException {
    return new TagValuesClient(settings);
  }

  /**
   * Constructs an instance of TagValuesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TagValuesSettings).
   */
  public static final TagValuesClient create(TagValuesStub stub) {
    return new TagValuesClient(stub);
  }

  /**
   * Constructs an instance of TagValuesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TagValuesClient(TagValuesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TagValuesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TagValuesClient(TagValuesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TagValuesSettings getSettings() {
    return settings;
  }

  public TagValuesStub getStub() {
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
   * Lists all TagValues for a specific TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   for (TagValue element : tagValuesClient.listTagValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name for TagKey, parent of the TagValues to be listed, in the
   *     format `tagKeys/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagValuesPagedResponse listTagValues(ResourceName parent) {
    ListTagValuesRequest request =
        ListTagValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTagValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagValues for a specific TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   for (TagValue element : tagValuesClient.listTagValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name for TagKey, parent of the TagValues to be listed, in the
   *     format `tagKeys/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagValuesPagedResponse listTagValues(String parent) {
    ListTagValuesRequest request = ListTagValuesRequest.newBuilder().setParent(parent).build();
    return listTagValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagValues for a specific TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ListTagValuesRequest request =
   *       ListTagValuesRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TagValue element : tagValuesClient.listTagValues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagValuesPagedResponse listTagValues(ListTagValuesRequest request) {
    return listTagValuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagValues for a specific TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ListTagValuesRequest request =
   *       ListTagValuesRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TagValue> future = tagValuesClient.listTagValuesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TagValue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable() {
    return stub.listTagValuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all TagValues for a specific TagKey.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ListTagValuesRequest request =
   *       ListTagValuesRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagValuesResponse response = tagValuesClient.listTagValuesCallable().call(request);
   *     for (TagValue element : response.getTagValuesList()) {
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
  public final UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable() {
    return stub.listTagValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves TagValue. If the TagValue or namespaced name does not exist, or if the user does not
   * have permission to view it, this method will return `PERMISSION_DENIED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TagValueName name = TagValueName.of("[TAG_VALUE]");
   *   TagValue response = tagValuesClient.getTagValue(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for TagValue to be fetched in the format `tagValues/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagValue getTagValue(TagValueName name) {
    GetTagValueRequest request =
        GetTagValueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTagValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves TagValue. If the TagValue or namespaced name does not exist, or if the user does not
   * have permission to view it, this method will return `PERMISSION_DENIED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String name = TagValueName.of("[TAG_VALUE]").toString();
   *   TagValue response = tagValuesClient.getTagValue(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for TagValue to be fetched in the format `tagValues/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagValue getTagValue(String name) {
    GetTagValueRequest request = GetTagValueRequest.newBuilder().setName(name).build();
    return getTagValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves TagValue. If the TagValue or namespaced name does not exist, or if the user does not
   * have permission to view it, this method will return `PERMISSION_DENIED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   GetTagValueRequest request =
   *       GetTagValueRequest.newBuilder()
   *           .setName(TagValueName.of("[TAG_VALUE]").toString())
   *           .build();
   *   TagValue response = tagValuesClient.getTagValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagValue getTagValue(GetTagValueRequest request) {
    return getTagValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves TagValue. If the TagValue or namespaced name does not exist, or if the user does not
   * have permission to view it, this method will return `PERMISSION_DENIED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   GetTagValueRequest request =
   *       GetTagValueRequest.newBuilder()
   *           .setName(TagValueName.of("[TAG_VALUE]").toString())
   *           .build();
   *   ApiFuture<TagValue> future = tagValuesClient.getTagValueCallable().futureCall(request);
   *   // Do something.
   *   TagValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable() {
    return stub.getTagValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagValue as a child of the specified TagKey. If a another request with the same
   * parameters is sent while the original request is in process the second request will receive an
   * error. A maximum of 300 TagValues can exist under a TagKey at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TagValue tagValue = TagValue.newBuilder().build();
   *   TagValue response = tagValuesClient.createTagValueAsync(tagValue).get();
   * }
   * }</pre>
   *
   * @param tagValue Required. The TagValue to be created. Only fields `short_name`, `description`,
   *     and `parent` are considered during the creation request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, CreateTagValueMetadata> createTagValueAsync(
      TagValue tagValue) {
    CreateTagValueRequest request =
        CreateTagValueRequest.newBuilder().setTagValue(tagValue).build();
    return createTagValueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagValue as a child of the specified TagKey. If a another request with the same
   * parameters is sent while the original request is in process the second request will receive an
   * error. A maximum of 300 TagValues can exist under a TagKey at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   CreateTagValueRequest request =
   *       CreateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagValue response = tagValuesClient.createTagValueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, CreateTagValueMetadata> createTagValueAsync(
      CreateTagValueRequest request) {
    return createTagValueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagValue as a child of the specified TagKey. If a another request with the same
   * parameters is sent while the original request is in process the second request will receive an
   * error. A maximum of 300 TagValues can exist under a TagKey at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   CreateTagValueRequest request =
   *       CreateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagValue, CreateTagValueMetadata> future =
   *       tagValuesClient.createTagValueOperationCallable().futureCall(request);
   *   // Do something.
   *   TagValue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable() {
    return stub.createTagValueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TagValue as a child of the specified TagKey. If a another request with the same
   * parameters is sent while the original request is in process the second request will receive an
   * error. A maximum of 300 TagValues can exist under a TagKey at any given time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   CreateTagValueRequest request =
   *       CreateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagValuesClient.createTagValueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable() {
    return stub.createTagValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagValue resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TagValue tagValue = TagValue.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagValue response = tagValuesClient.updateTagValueAsync(tagValue, updateMask).get();
   * }
   * }</pre>
   *
   * @param tagValue Required. The new definition of the TagValue. Only fields `description` and
   *     `etag` fields can be updated by this request. If the `etag` field is nonempty, it must
   *     match the `etag` field of the existing ControlGroup. Otherwise, `FAILED_PRECONDITION` will
   *     be returned.
   * @param updateMask Optional. Fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, UpdateTagValueMetadata> updateTagValueAsync(
      TagValue tagValue, FieldMask updateMask) {
    UpdateTagValueRequest request =
        UpdateTagValueRequest.newBuilder().setTagValue(tagValue).setUpdateMask(updateMask).build();
    return updateTagValueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagValue resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   UpdateTagValueRequest request =
   *       UpdateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   TagValue response = tagValuesClient.updateTagValueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, UpdateTagValueMetadata> updateTagValueAsync(
      UpdateTagValueRequest request) {
    return updateTagValueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagValue resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   UpdateTagValueRequest request =
   *       UpdateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<TagValue, UpdateTagValueMetadata> future =
   *       tagValuesClient.updateTagValueOperationCallable().futureCall(request);
   *   // Do something.
   *   TagValue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable() {
    return stub.updateTagValueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the attributes of the TagValue resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   UpdateTagValueRequest request =
   *       UpdateTagValueRequest.newBuilder()
   *           .setTagValue(TagValue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = tagValuesClient.updateTagValueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable() {
    return stub.updateTagValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TagValueName name = TagValueName.of("[TAG_VALUE]");
   *   TagValue response = tagValuesClient.deleteTagValueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name for TagValue to be deleted in the format tagValues/456.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, DeleteTagValueMetadata> deleteTagValueAsync(
      TagValueName name) {
    DeleteTagValueRequest request =
        DeleteTagValueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTagValueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String name = TagValueName.of("[TAG_VALUE]").toString();
   *   TagValue response = tagValuesClient.deleteTagValueAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name for TagValue to be deleted in the format tagValues/456.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, DeleteTagValueMetadata> deleteTagValueAsync(String name) {
    DeleteTagValueRequest request = DeleteTagValueRequest.newBuilder().setName(name).build();
    return deleteTagValueAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   DeleteTagValueRequest request =
   *       DeleteTagValueRequest.newBuilder()
   *           .setName(TagValueName.of("[TAG_VALUE]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   TagValue response = tagValuesClient.deleteTagValueAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TagValue, DeleteTagValueMetadata> deleteTagValueAsync(
      DeleteTagValueRequest request) {
    return deleteTagValueOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   DeleteTagValueRequest request =
   *       DeleteTagValueRequest.newBuilder()
   *           .setName(TagValueName.of("[TAG_VALUE]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<TagValue, DeleteTagValueMetadata> future =
   *       tagValuesClient.deleteTagValueOperationCallable().futureCall(request);
   *   // Do something.
   *   TagValue response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable() {
    return stub.deleteTagValueOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   DeleteTagValueRequest request =
   *       DeleteTagValueRequest.newBuilder()
   *           .setName(TagValueName.of("[TAG_VALUE]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = tagValuesClient.deleteTagValueCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable() {
    return stub.deleteTagValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a TagValue. The returned policy may be empty if no such
   * policy or resource exists. The `resource` field should be the TagValue's resource name. For
   * example: `tagValues/1234`. The caller must have the
   * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified
   * TagValue to get the access control policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ResourceName resource = TagValueName.of("[TAG_VALUE]");
   *   Policy response = tagValuesClient.getIamPolicy(resource);
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
   * Gets the access control policy for a TagValue. The returned policy may be empty if no such
   * policy or resource exists. The `resource` field should be the TagValue's resource name. For
   * example: `tagValues/1234`. The caller must have the
   * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified
   * TagValue to get the access control policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = tagValuesClient.getIamPolicy(resource);
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
   * Gets the access control policy for a TagValue. The returned policy may be empty if no such
   * policy or resource exists. The `resource` field should be the TagValue's resource name. For
   * example: `tagValues/1234`. The caller must have the
   * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified
   * TagValue to get the access control policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = tagValuesClient.getIamPolicy(request);
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
   * Gets the access control policy for a TagValue. The returned policy may be empty if no such
   * policy or resource exists. The `resource` field should be the TagValue's resource name. For
   * example: `tagValues/1234`. The caller must have the
   * `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified
   * TagValue to get the access control policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = tagValuesClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the access control policy on a TagValue, replacing any existing policy. The `resource`
   * field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must
   * have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ResourceName resource = TagValueName.of("[TAG_VALUE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = tagValuesClient.setIamPolicy(resource, policy);
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
   * Sets the access control policy on a TagValue, replacing any existing policy. The `resource`
   * field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must
   * have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = tagValuesClient.setIamPolicy(resource, policy);
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
   * Sets the access control policy on a TagValue, replacing any existing policy. The `resource`
   * field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must
   * have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = tagValuesClient.setIamPolicy(request);
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
   * Sets the access control policy on a TagValue, replacing any existing policy. The `resource`
   * field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must
   * have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = tagValuesClient.setIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the specified TagValue. The `resource` field should be
   * the TagValue's resource name. For example: `tagValues/1234`.
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
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   ResourceName resource = TagValueName.of("[TAG_VALUE]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       tagValuesClient.testIamPermissions(resource, permissions);
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
   * Returns permissions that a caller has on the specified TagValue. The `resource` field should be
   * the TagValue's resource name. For example: `tagValues/1234`.
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
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       tagValuesClient.testIamPermissions(resource, permissions);
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
   * Returns permissions that a caller has on the specified TagValue. The `resource` field should be
   * the TagValue's resource name. For example: `tagValues/1234`.
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
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = tagValuesClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the specified TagValue. The `resource` field should be
   * the TagValue's resource name. For example: `tagValues/1234`.
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
   * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TagValueName.of("[TAG_VALUE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       tagValuesClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListTagValuesPagedResponse
      extends AbstractPagedListResponse<
          ListTagValuesRequest,
          ListTagValuesResponse,
          TagValue,
          ListTagValuesPage,
          ListTagValuesFixedSizeCollection> {

    public static ApiFuture<ListTagValuesPagedResponse> createAsync(
        PageContext<ListTagValuesRequest, ListTagValuesResponse, TagValue> context,
        ApiFuture<ListTagValuesResponse> futureResponse) {
      ApiFuture<ListTagValuesPage> futurePage =
          ListTagValuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTagValuesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTagValuesPagedResponse(ListTagValuesPage page) {
      super(page, ListTagValuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagValuesPage
      extends AbstractPage<
          ListTagValuesRequest, ListTagValuesResponse, TagValue, ListTagValuesPage> {

    private ListTagValuesPage(
        PageContext<ListTagValuesRequest, ListTagValuesResponse, TagValue> context,
        ListTagValuesResponse response) {
      super(context, response);
    }

    private static ListTagValuesPage createEmptyPage() {
      return new ListTagValuesPage(null, null);
    }

    @Override
    protected ListTagValuesPage createPage(
        PageContext<ListTagValuesRequest, ListTagValuesResponse, TagValue> context,
        ListTagValuesResponse response) {
      return new ListTagValuesPage(context, response);
    }

    @Override
    public ApiFuture<ListTagValuesPage> createPageAsync(
        PageContext<ListTagValuesRequest, ListTagValuesResponse, TagValue> context,
        ApiFuture<ListTagValuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagValuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagValuesRequest,
          ListTagValuesResponse,
          TagValue,
          ListTagValuesPage,
          ListTagValuesFixedSizeCollection> {

    private ListTagValuesFixedSizeCollection(List<ListTagValuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagValuesFixedSizeCollection createEmptyCollection() {
      return new ListTagValuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagValuesFixedSizeCollection createCollection(
        List<ListTagValuesPage> pages, int collectionSize) {
      return new ListTagValuesFixedSizeCollection(pages, collectionSize);
    }
  }
}
