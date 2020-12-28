/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dataproc.v1beta2;

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
import com.google.cloud.dataproc.v1beta2.stub.AutoscalingPolicyServiceStub;
import com.google.cloud.dataproc.v1beta2.stub.AutoscalingPolicyServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The API interface for managing autoscaling policies in the Cloud Dataproc
 * API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the AutoscalingPolicyServiceClient object to clean up
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
 * AutoscalingPolicyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     AutoscalingPolicyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     AutoscalingPolicyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class AutoscalingPolicyServiceClient implements BackgroundResource {
  private final AutoscalingPolicyServiceSettings settings;
  private final AutoscalingPolicyServiceStub stub;

  /** Constructs an instance of AutoscalingPolicyServiceClient with default settings. */
  public static final AutoscalingPolicyServiceClient create() throws IOException {
    return create(AutoscalingPolicyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AutoscalingPolicyServiceClient create(
      AutoscalingPolicyServiceSettings settings) throws IOException {
    return new AutoscalingPolicyServiceClient(settings);
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(AutoscalingPolicyServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AutoscalingPolicyServiceClient create(AutoscalingPolicyServiceStub stub) {
    return new AutoscalingPolicyServiceClient(stub);
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AutoscalingPolicyServiceClient(AutoscalingPolicyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AutoscalingPolicyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AutoscalingPolicyServiceClient(AutoscalingPolicyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutoscalingPolicyServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AutoscalingPolicyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(
      LocationName parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(
      RegionName parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name has the
   *           following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(String parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder().setParent(parent).setPolicy(policy).build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(CreateAutoscalingPolicyRequest request) {
    return createAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable() {
    return stub.createAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * @param policy Required. The updated autoscaling policy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy updateAutoscalingPolicy(AutoscalingPolicy policy) {
    UpdateAutoscalingPolicyRequest request =
        UpdateAutoscalingPolicyRequest.newBuilder().setPolicy(policy).build();
    return updateAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy updateAutoscalingPolicy(UpdateAutoscalingPolicyRequest request) {
    return updateAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable() {
    return stub.updateAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(AutoscalingPolicyName name) {
    GetAutoscalingPolicyRequest request =
        GetAutoscalingPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(String name) {
    GetAutoscalingPolicyRequest request =
        GetAutoscalingPolicyRequest.newBuilder().setName(name).build();
    return getAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(GetAutoscalingPolicyRequest request) {
    return getAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable() {
    return stub.getAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(LocationName parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(RegionName parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(String parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder().setParent(parent).build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(
      ListAutoscalingPoliciesRequest request) {
    return listAutoscalingPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable() {
    return stub.listAutoscalingPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable() {
    return stub.listAutoscalingPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(AutoscalingPolicyName name) {
    DeleteAutoscalingPolicyRequest request =
        DeleteAutoscalingPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(String name) {
    DeleteAutoscalingPolicyRequest request =
        DeleteAutoscalingPolicyRequest.newBuilder().setName(name).build();
    deleteAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(DeleteAutoscalingPolicyRequest request) {
    deleteAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyCallable() {
    return stub.deleteAutoscalingPolicyCallable();
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

  public static class ListAutoscalingPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage,
          ListAutoscalingPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAutoscalingPoliciesPagedResponse> createAsync(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ApiFuture<ListAutoscalingPoliciesResponse> futureResponse) {
      ApiFuture<ListAutoscalingPoliciesPage> futurePage =
          ListAutoscalingPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAutoscalingPoliciesPage, ListAutoscalingPoliciesPagedResponse>() {
            @Override
            public ListAutoscalingPoliciesPagedResponse apply(ListAutoscalingPoliciesPage input) {
              return new ListAutoscalingPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAutoscalingPoliciesPagedResponse(ListAutoscalingPoliciesPage page) {
      super(page, ListAutoscalingPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutoscalingPoliciesPage
      extends AbstractPage<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage> {

    private ListAutoscalingPoliciesPage(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ListAutoscalingPoliciesResponse response) {
      super(context, response);
    }

    private static ListAutoscalingPoliciesPage createEmptyPage() {
      return new ListAutoscalingPoliciesPage(null, null);
    }

    @Override
    protected ListAutoscalingPoliciesPage createPage(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ListAutoscalingPoliciesResponse response) {
      return new ListAutoscalingPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAutoscalingPoliciesPage> createPageAsync(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ApiFuture<ListAutoscalingPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutoscalingPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage,
          ListAutoscalingPoliciesFixedSizeCollection> {

    private ListAutoscalingPoliciesFixedSizeCollection(
        List<ListAutoscalingPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutoscalingPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAutoscalingPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutoscalingPoliciesFixedSizeCollection createCollection(
        List<ListAutoscalingPoliciesPage> pages, int collectionSize) {
      return new ListAutoscalingPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
