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

package com.google.cloud.dataplex.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.dataplex.v1.stub.ContentServiceStub;
import com.google.cloud.dataplex.v1.stub.ContentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ContentService manages Notebook and SQL Scripts for Dataplex.
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
 * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
 *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
 *   Content content = Content.newBuilder().build();
 *   Content response = contentServiceClient.createContent(parent, content);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContentServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ContentServiceSettings to
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
 * ContentServiceSettings contentServiceSettings =
 *     ContentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContentServiceClient contentServiceClient = ContentServiceClient.create(contentServiceSettings);
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
 * ContentServiceSettings contentServiceSettings =
 *     ContentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContentServiceClient contentServiceClient = ContentServiceClient.create(contentServiceSettings);
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
 * ContentServiceSettings contentServiceSettings =
 *     ContentServiceSettings.newHttpJsonBuilder().build();
 * ContentServiceClient contentServiceClient = ContentServiceClient.create(contentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContentServiceClient implements BackgroundResource {
  private final ContentServiceSettings settings;
  private final ContentServiceStub stub;

  /** Constructs an instance of ContentServiceClient with default settings. */
  public static final ContentServiceClient create() throws IOException {
    return create(ContentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContentServiceClient create(ContentServiceSettings settings)
      throws IOException {
    return new ContentServiceClient(settings);
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ContentServiceSettings).
   */
  public static final ContentServiceClient create(ContentServiceStub stub) {
    return new ContentServiceClient(stub);
  }

  /**
   * Constructs an instance of ContentServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ContentServiceClient(ContentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContentServiceClient(ContentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContentServiceSettings getSettings() {
    return settings;
  }

  public ContentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   Content content = Content.newBuilder().build();
   *   Content response = contentServiceClient.createContent(parent, content);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}
   * @param content Required. Content resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content createContent(LakeName parent, Content content) {
    CreateContentRequest request =
        CreateContentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setContent(content)
            .build();
    return createContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   Content content = Content.newBuilder().build();
   *   Content response = contentServiceClient.createContent(parent, content);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}
   * @param content Required. Content resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content createContent(String parent, Content content) {
    CreateContentRequest request =
        CreateContentRequest.newBuilder().setParent(parent).setContent(content).build();
    return createContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   CreateContentRequest request =
   *       CreateContentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setContent(Content.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Content response = contentServiceClient.createContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content createContent(CreateContentRequest request) {
    return createContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   CreateContentRequest request =
   *       CreateContentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setContent(Content.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Content> future = contentServiceClient.createContentCallable().futureCall(request);
   *   // Do something.
   *   Content response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateContentRequest, Content> createContentCallable() {
    return stub.createContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a content. Only supports full resource update.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   Content content = Content.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Content response = contentServiceClient.updateContent(content, updateMask);
   * }
   * }</pre>
   *
   * @param content Required. Update description. Only fields specified in `update_mask` are
   *     updated.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content updateContent(Content content, FieldMask updateMask) {
    UpdateContentRequest request =
        UpdateContentRequest.newBuilder().setContent(content).setUpdateMask(updateMask).build();
    return updateContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a content. Only supports full resource update.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   UpdateContentRequest request =
   *       UpdateContentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setContent(Content.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Content response = contentServiceClient.updateContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content updateContent(UpdateContentRequest request) {
    return updateContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a content. Only supports full resource update.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   UpdateContentRequest request =
   *       UpdateContentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setContent(Content.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Content> future = contentServiceClient.updateContentCallable().futureCall(request);
   *   // Do something.
   *   Content response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateContentRequest, Content> updateContentCallable() {
    return stub.updateContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");
   *   contentServiceClient.deleteContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the content:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContent(ContentName name) {
    DeleteContentRequest request =
        DeleteContentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString();
   *   contentServiceClient.deleteContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the content:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContent(String name) {
    DeleteContentRequest request = DeleteContentRequest.newBuilder().setName(name).build();
    deleteContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   DeleteContentRequest request =
   *       DeleteContentRequest.newBuilder()
   *           .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .build();
   *   contentServiceClient.deleteContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContent(DeleteContentRequest request) {
    deleteContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   DeleteContentRequest request =
   *       DeleteContentRequest.newBuilder()
   *           .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = contentServiceClient.deleteContentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteContentRequest, Empty> deleteContentCallable() {
    return stub.deleteContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a content resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");
   *   Content response = contentServiceClient.getContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the content:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(ContentName name) {
    GetContentRequest request =
        GetContentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a content resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString();
   *   Content response = contentServiceClient.getContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the content:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(String name) {
    GetContentRequest request = GetContentRequest.newBuilder().setName(name).build();
    return getContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a content resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetContentRequest request =
   *       GetContentRequest.newBuilder()
   *           .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .build();
   *   Content response = contentServiceClient.getContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Content getContent(GetContentRequest request) {
    return getContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a content resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetContentRequest request =
   *       GetContentRequest.newBuilder()
   *           .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .build();
   *   ApiFuture<Content> future = contentServiceClient.getContentCallable().futureCall(request);
   *   // Do something.
   *   Content response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContentRequest, Content> getContentCallable() {
    return stub.getContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a contentitem resource. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Caller must have Google IAM `dataplex.content.getIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ResourceName resource = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");
   *   Policy response = contentServiceClient.getIamPolicy(resource);
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
   * Gets the access control policy for a contentitem resource. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Caller must have Google IAM `dataplex.content.getIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String resource =
   *       AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString();
   *   Policy response = contentServiceClient.getIamPolicy(resource);
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
   * Gets the access control policy for a contentitem resource. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Caller must have Google IAM `dataplex.content.getIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = contentServiceClient.getIamPolicy(request);
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
   * Gets the access control policy for a contentitem resource. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Caller must have Google IAM `dataplex.content.getIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = contentServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the access control policy on the specified contentitem resource. Replaces any existing
   * policy.
   *
   * <p>Caller must have Google IAM `dataplex.content.setIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = contentServiceClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified contentitem resource. Replaces any existing
   * policy.
   *
   * <p>Caller must have Google IAM `dataplex.content.setIamPolicy` permission on the resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = contentServiceClient.setIamPolicyCallable().futureCall(request);
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
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (a `NOT_FOUND` error is not returned).
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = contentServiceClient.testIamPermissions(request);
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
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (a `NOT_FOUND` error is not returned).
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       contentServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
   *   for (Content element : contentServiceClient.listContent(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(LakeName parent) {
    ListContentRequest request =
        ListContentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   String parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString();
   *   for (Content element : contentServiceClient.listContent(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent lake:
   *     projects/{project_id}/locations/{location_id}/lakes/{lake_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(String parent) {
    ListContentRequest request = ListContentRequest.newBuilder().setParent(parent).build();
    return listContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Content element : contentServiceClient.listContent(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentPagedResponse listContent(ListContentRequest request) {
    return listContentPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Content> future =
   *       contentServiceClient.listContentPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Content element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContentRequest, ListContentPagedResponse>
      listContentPagedCallable() {
    return stub.listContentPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListContentRequest request =
   *       ListContentRequest.newBuilder()
   *           .setParent(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListContentResponse response = contentServiceClient.listContentCallable().call(request);
   *     for (Content element : response.getContentList()) {
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
  public final UnaryCallable<ListContentRequest, ListContentResponse> listContentCallable() {
    return stub.listContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : contentServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       contentServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = contentServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = contentServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = contentServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListContentPagedResponse
      extends AbstractPagedListResponse<
          ListContentRequest,
          ListContentResponse,
          Content,
          ListContentPage,
          ListContentFixedSizeCollection> {

    public static ApiFuture<ListContentPagedResponse> createAsync(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ApiFuture<ListContentResponse> futureResponse) {
      ApiFuture<ListContentPage> futurePage =
          ListContentPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListContentPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListContentPagedResponse(ListContentPage page) {
      super(page, ListContentFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContentPage
      extends AbstractPage<ListContentRequest, ListContentResponse, Content, ListContentPage> {

    private ListContentPage(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ListContentResponse response) {
      super(context, response);
    }

    private static ListContentPage createEmptyPage() {
      return new ListContentPage(null, null);
    }

    @Override
    protected ListContentPage createPage(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ListContentResponse response) {
      return new ListContentPage(context, response);
    }

    @Override
    public ApiFuture<ListContentPage> createPageAsync(
        PageContext<ListContentRequest, ListContentResponse, Content> context,
        ApiFuture<ListContentResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContentFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContentRequest,
          ListContentResponse,
          Content,
          ListContentPage,
          ListContentFixedSizeCollection> {

    private ListContentFixedSizeCollection(List<ListContentPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContentFixedSizeCollection createEmptyCollection() {
      return new ListContentFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContentFixedSizeCollection createCollection(
        List<ListContentPage> pages, int collectionSize) {
      return new ListContentFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
