/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.gkehub.v1.stub;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListBoundMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListFleetsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListPermittedScopesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeNamespacesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopeRBACRoleBindingsPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListScopesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.CreateFeatureRequest;
import com.google.cloud.gkehub.v1.CreateFleetRequest;
import com.google.cloud.gkehub.v1.CreateMembershipBindingRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.CreateScopeRequest;
import com.google.cloud.gkehub.v1.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1.DeleteFleetRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.DeleteScopeRequest;
import com.google.cloud.gkehub.v1.Feature;
import com.google.cloud.gkehub.v1.Fleet;
import com.google.cloud.gkehub.v1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest;
import com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse;
import com.google.cloud.gkehub.v1.GetFeatureRequest;
import com.google.cloud.gkehub.v1.GetFleetRequest;
import com.google.cloud.gkehub.v1.GetMembershipBindingRequest;
import com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.GetMembershipRequest;
import com.google.cloud.gkehub.v1.GetScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.GetScopeRequest;
import com.google.cloud.gkehub.v1.ListBoundMembershipsRequest;
import com.google.cloud.gkehub.v1.ListBoundMembershipsResponse;
import com.google.cloud.gkehub.v1.ListFeaturesRequest;
import com.google.cloud.gkehub.v1.ListFeaturesResponse;
import com.google.cloud.gkehub.v1.ListFleetsRequest;
import com.google.cloud.gkehub.v1.ListFleetsResponse;
import com.google.cloud.gkehub.v1.ListMembershipBindingsRequest;
import com.google.cloud.gkehub.v1.ListMembershipBindingsResponse;
import com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest;
import com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse;
import com.google.cloud.gkehub.v1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1.ListPermittedScopesRequest;
import com.google.cloud.gkehub.v1.ListPermittedScopesResponse;
import com.google.cloud.gkehub.v1.ListScopeNamespacesRequest;
import com.google.cloud.gkehub.v1.ListScopeNamespacesResponse;
import com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest;
import com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse;
import com.google.cloud.gkehub.v1.ListScopesRequest;
import com.google.cloud.gkehub.v1.ListScopesResponse;
import com.google.cloud.gkehub.v1.Membership;
import com.google.cloud.gkehub.v1.MembershipBinding;
import com.google.cloud.gkehub.v1.Namespace;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.RBACRoleBinding;
import com.google.cloud.gkehub.v1.Scope;
import com.google.cloud.gkehub.v1.UpdateFeatureRequest;
import com.google.cloud.gkehub.v1.UpdateFleetRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRequest;
import com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest;
import com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest;
import com.google.cloud.gkehub.v1.UpdateScopeRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GkeHubStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkehub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMembership:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubStubSettings.Builder gkeHubSettingsBuilder = GkeHubStubSettings.newBuilder();
 * gkeHubSettingsBuilder
 *     .getMembershipSettings()
 *     .setRetrySettings(
 *         gkeHubSettingsBuilder
 *             .getMembershipSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * GkeHubStubSettings gkeHubSettings = gkeHubSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMembership:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubStubSettings.Builder gkeHubSettingsBuilder = GkeHubStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * gkeHubSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GkeHubStubSettings extends StubSettings<GkeHubStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings;
  private final PagedCallSettings<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          ListBoundMembershipsPagedResponse>
      listBoundMembershipsSettings;
  private final PagedCallSettings<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings;
  private final UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings;
  private final UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings;
  private final UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings;
  private final OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings;
  private final UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings;
  private final OperationCallSettings<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationSettings;
  private final UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings;
  private final OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings;
  private final UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings;
  private final OperationCallSettings<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationSettings;
  private final UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings;
  private final OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings;
  private final UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings;
  private final OperationCallSettings<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationSettings;
  private final UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings;
  private final UnaryCallSettings<CreateFleetRequest, Operation> createFleetSettings;
  private final OperationCallSettings<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationSettings;
  private final UnaryCallSettings<GetFleetRequest, Fleet> getFleetSettings;
  private final UnaryCallSettings<UpdateFleetRequest, Operation> updateFleetSettings;
  private final OperationCallSettings<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationSettings;
  private final UnaryCallSettings<DeleteFleetRequest, Operation> deleteFleetSettings;
  private final OperationCallSettings<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationSettings;
  private final PagedCallSettings<ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
      listFleetsSettings;
  private final UnaryCallSettings<GetScopeNamespaceRequest, Namespace> getScopeNamespaceSettings;
  private final UnaryCallSettings<CreateScopeNamespaceRequest, Operation>
      createScopeNamespaceSettings;
  private final OperationCallSettings<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationSettings;
  private final UnaryCallSettings<UpdateScopeNamespaceRequest, Operation>
      updateScopeNamespaceSettings;
  private final OperationCallSettings<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationSettings;
  private final UnaryCallSettings<DeleteScopeNamespaceRequest, Operation>
      deleteScopeNamespaceSettings;
  private final OperationCallSettings<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationSettings;
  private final PagedCallSettings<
          ListScopeNamespacesRequest, ListScopeNamespacesResponse, ListScopeNamespacesPagedResponse>
      listScopeNamespacesSettings;
  private final UnaryCallSettings<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingSettings;
  private final UnaryCallSettings<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingSettings;
  private final OperationCallSettings<
          CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationSettings;
  private final UnaryCallSettings<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingSettings;
  private final OperationCallSettings<
          UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationSettings;
  private final UnaryCallSettings<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingSettings;
  private final OperationCallSettings<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationSettings;
  private final PagedCallSettings<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsSettings;
  private final UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings;
  private final UnaryCallSettings<CreateScopeRequest, Operation> createScopeSettings;
  private final OperationCallSettings<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationSettings;
  private final UnaryCallSettings<UpdateScopeRequest, Operation> updateScopeSettings;
  private final OperationCallSettings<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationSettings;
  private final UnaryCallSettings<DeleteScopeRequest, Operation> deleteScopeSettings;
  private final OperationCallSettings<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationSettings;
  private final PagedCallSettings<ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
      listScopesSettings;
  private final PagedCallSettings<
          ListPermittedScopesRequest, ListPermittedScopesResponse, ListPermittedScopesPagedResponse>
      listPermittedScopesSettings;
  private final UnaryCallSettings<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingSettings;
  private final UnaryCallSettings<CreateMembershipBindingRequest, Operation>
      createMembershipBindingSettings;
  private final OperationCallSettings<
          CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationSettings;
  private final UnaryCallSettings<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingSettings;
  private final OperationCallSettings<
          UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationSettings;
  private final UnaryCallSettings<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingSettings;
  private final OperationCallSettings<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationSettings;
  private final PagedCallSettings<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          ListMembershipBindingsPagedResponse>
      listMembershipBindingsSettings;
  private final UnaryCallSettings<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingSettings;
  private final UnaryCallSettings<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingSettings;
  private final OperationCallSettings<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationSettings;
  private final UnaryCallSettings<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingSettings;
  private final OperationCallSettings<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationSettings;
  private final UnaryCallSettings<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingSettings;
  private final OperationCallSettings<
          DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationSettings;
  private final PagedCallSettings<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsSettings;
  private final UnaryCallSettings<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLSettings;

  private static final PagedListDescriptor<
          ListMembershipsRequest, ListMembershipsResponse, Membership>
      LIST_MEMBERSHIPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMembershipsRequest, ListMembershipsResponse, Membership>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipsRequest injectToken(
                ListMembershipsRequest payload, String token) {
              return ListMembershipsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembershipsRequest injectPageSize(
                ListMembershipsRequest payload, int pageSize) {
              return ListMembershipsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMembershipsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Membership> extractResources(ListMembershipsResponse payload) {
              return payload.getResourcesList();
            }
          };

  private static final PagedListDescriptor<
          ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership>
      LIST_BOUND_MEMBERSHIPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBoundMembershipsRequest injectToken(
                ListBoundMembershipsRequest payload, String token) {
              return ListBoundMembershipsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBoundMembershipsRequest injectPageSize(
                ListBoundMembershipsRequest payload, int pageSize) {
              return ListBoundMembershipsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBoundMembershipsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBoundMembershipsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Membership> extractResources(ListBoundMembershipsResponse payload) {
              return payload.getMembershipsList();
            }
          };

  private static final PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>
      LIST_FEATURES_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturesRequest injectToken(ListFeaturesRequest payload, String token) {
              return ListFeaturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeaturesRequest injectPageSize(ListFeaturesRequest payload, int pageSize) {
              return ListFeaturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeaturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feature> extractResources(ListFeaturesResponse payload) {
              return payload.getResourcesList();
            }
          };

  private static final PagedListDescriptor<ListFleetsRequest, ListFleetsResponse, Fleet>
      LIST_FLEETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFleetsRequest, ListFleetsResponse, Fleet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFleetsRequest injectToken(ListFleetsRequest payload, String token) {
              return ListFleetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFleetsRequest injectPageSize(ListFleetsRequest payload, int pageSize) {
              return ListFleetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFleetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFleetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Fleet> extractResources(ListFleetsResponse payload) {
              return payload.getFleetsList();
            }
          };

  private static final PagedListDescriptor<
          ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace>
      LIST_SCOPE_NAMESPACES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScopeNamespacesRequest injectToken(
                ListScopeNamespacesRequest payload, String token) {
              return ListScopeNamespacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScopeNamespacesRequest injectPageSize(
                ListScopeNamespacesRequest payload, int pageSize) {
              return ListScopeNamespacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScopeNamespacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScopeNamespacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Namespace> extractResources(ListScopeNamespacesResponse payload) {
              return payload.getScopeNamespacesList();
            }
          };

  private static final PagedListDescriptor<
          ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse, RBACRoleBinding>
      LIST_SCOPE_R_B_A_C_ROLE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListScopeRBACRoleBindingsRequest,
              ListScopeRBACRoleBindingsResponse,
              RBACRoleBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScopeRBACRoleBindingsRequest injectToken(
                ListScopeRBACRoleBindingsRequest payload, String token) {
              return ListScopeRBACRoleBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListScopeRBACRoleBindingsRequest injectPageSize(
                ListScopeRBACRoleBindingsRequest payload, int pageSize) {
              return ListScopeRBACRoleBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListScopeRBACRoleBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScopeRBACRoleBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RBACRoleBinding> extractResources(
                ListScopeRBACRoleBindingsResponse payload) {
              return payload.getRbacrolebindingsList();
            }
          };

  private static final PagedListDescriptor<ListScopesRequest, ListScopesResponse, Scope>
      LIST_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListScopesRequest, ListScopesResponse, Scope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScopesRequest injectToken(ListScopesRequest payload, String token) {
              return ListScopesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListScopesRequest injectPageSize(ListScopesRequest payload, int pageSize) {
              return ListScopesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Scope> extractResources(ListScopesResponse payload) {
              return payload.getScopesList();
            }
          };

  private static final PagedListDescriptor<
          ListPermittedScopesRequest, ListPermittedScopesResponse, Scope>
      LIST_PERMITTED_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPermittedScopesRequest, ListPermittedScopesResponse, Scope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPermittedScopesRequest injectToken(
                ListPermittedScopesRequest payload, String token) {
              return ListPermittedScopesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPermittedScopesRequest injectPageSize(
                ListPermittedScopesRequest payload, int pageSize) {
              return ListPermittedScopesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPermittedScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPermittedScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Scope> extractResources(ListPermittedScopesResponse payload) {
              return payload.getScopesList();
            }
          };

  private static final PagedListDescriptor<
          ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>
      LIST_MEMBERSHIP_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipBindingsRequest injectToken(
                ListMembershipBindingsRequest payload, String token) {
              return ListMembershipBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMembershipBindingsRequest injectPageSize(
                ListMembershipBindingsRequest payload, int pageSize) {
              return ListMembershipBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMembershipBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MembershipBinding> extractResources(
                ListMembershipBindingsResponse payload) {
              return payload.getMembershipBindingsList();
            }
          };

  private static final PagedListDescriptor<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          RBACRoleBinding>
      LIST_MEMBERSHIP_R_B_A_C_ROLE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMembershipRBACRoleBindingsRequest,
              ListMembershipRBACRoleBindingsResponse,
              RBACRoleBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMembershipRBACRoleBindingsRequest injectToken(
                ListMembershipRBACRoleBindingsRequest payload, String token) {
              return ListMembershipRBACRoleBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMembershipRBACRoleBindingsRequest injectPageSize(
                ListMembershipRBACRoleBindingsRequest payload, int pageSize) {
              return ListMembershipRBACRoleBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMembershipRBACRoleBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMembershipRBACRoleBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RBACRoleBinding> extractResources(
                ListMembershipRBACRoleBindingsResponse payload) {
              return payload.getRbacrolebindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      LIST_MEMBERSHIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> callable,
                ListMembershipsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipsResponse> futureResponse) {
              PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> pageContext =
                  PageContext.create(callable, LIST_MEMBERSHIPS_PAGE_STR_DESC, request, context);
              return ListMembershipsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          ListBoundMembershipsPagedResponse>
      LIST_BOUND_MEMBERSHIPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBoundMembershipsRequest,
              ListBoundMembershipsResponse,
              ListBoundMembershipsPagedResponse>() {
            @Override
            public ApiFuture<ListBoundMembershipsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsResponse> callable,
                ListBoundMembershipsRequest request,
                ApiCallContext context,
                ApiFuture<ListBoundMembershipsResponse> futureResponse) {
              PageContext<ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BOUND_MEMBERSHIPS_PAGE_STR_DESC, request, context);
              return ListBoundMembershipsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      LIST_FEATURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> callable,
                ListFeaturesRequest request,
                ApiCallContext context,
                ApiFuture<ListFeaturesResponse> futureResponse) {
              PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> pageContext =
                  PageContext.create(callable, LIST_FEATURES_PAGE_STR_DESC, request, context);
              return ListFeaturesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
      LIST_FLEETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>() {
            @Override
            public ApiFuture<ListFleetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFleetsRequest, ListFleetsResponse> callable,
                ListFleetsRequest request,
                ApiCallContext context,
                ApiFuture<ListFleetsResponse> futureResponse) {
              PageContext<ListFleetsRequest, ListFleetsResponse, Fleet> pageContext =
                  PageContext.create(callable, LIST_FLEETS_PAGE_STR_DESC, request, context);
              return ListFleetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScopeNamespacesRequest, ListScopeNamespacesResponse, ListScopeNamespacesPagedResponse>
      LIST_SCOPE_NAMESPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScopeNamespacesRequest,
              ListScopeNamespacesResponse,
              ListScopeNamespacesPagedResponse>() {
            @Override
            public ApiFuture<ListScopeNamespacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesResponse> callable,
                ListScopeNamespacesRequest request,
                ApiCallContext context,
                ApiFuture<ListScopeNamespacesResponse> futureResponse) {
              PageContext<ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SCOPE_NAMESPACES_PAGE_STR_DESC, request, context);
              return ListScopeNamespacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          ListScopeRBACRoleBindingsPagedResponse>
      LIST_SCOPE_R_B_A_C_ROLE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScopeRBACRoleBindingsRequest,
              ListScopeRBACRoleBindingsResponse,
              ListScopeRBACRoleBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListScopeRBACRoleBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
                    callable,
                ListScopeRBACRoleBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListScopeRBACRoleBindingsResponse> futureResponse) {
              PageContext<
                      ListScopeRBACRoleBindingsRequest,
                      ListScopeRBACRoleBindingsResponse,
                      RBACRoleBinding>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SCOPE_R_B_A_C_ROLE_BINDINGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListScopeRBACRoleBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
      LIST_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>() {
            @Override
            public ApiFuture<ListScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListScopesRequest, ListScopesResponse> callable,
                ListScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListScopesResponse> futureResponse) {
              PageContext<ListScopesRequest, ListScopesResponse, Scope> pageContext =
                  PageContext.create(callable, LIST_SCOPES_PAGE_STR_DESC, request, context);
              return ListScopesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPermittedScopesRequest, ListPermittedScopesResponse, ListPermittedScopesPagedResponse>
      LIST_PERMITTED_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPermittedScopesRequest,
              ListPermittedScopesResponse,
              ListPermittedScopesPagedResponse>() {
            @Override
            public ApiFuture<ListPermittedScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesResponse> callable,
                ListPermittedScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListPermittedScopesResponse> futureResponse) {
              PageContext<ListPermittedScopesRequest, ListPermittedScopesResponse, Scope>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PERMITTED_SCOPES_PAGE_STR_DESC, request, context);
              return ListPermittedScopesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          ListMembershipBindingsPagedResponse>
      LIST_MEMBERSHIP_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipBindingsRequest,
              ListMembershipBindingsResponse,
              ListMembershipBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
                    callable,
                ListMembershipBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipBindingsResponse> futureResponse) {
              PageContext<
                      ListMembershipBindingsRequest,
                      ListMembershipBindingsResponse,
                      MembershipBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MEMBERSHIP_BINDINGS_PAGE_STR_DESC, request, context);
              return ListMembershipBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          ListMembershipRBACRoleBindingsPagedResponse>
      LIST_MEMBERSHIP_R_B_A_C_ROLE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMembershipRBACRoleBindingsRequest,
              ListMembershipRBACRoleBindingsResponse,
              ListMembershipRBACRoleBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListMembershipRBACRoleBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMembershipRBACRoleBindingsRequest,
                        ListMembershipRBACRoleBindingsResponse>
                    callable,
                ListMembershipRBACRoleBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListMembershipRBACRoleBindingsResponse> futureResponse) {
              PageContext<
                      ListMembershipRBACRoleBindingsRequest,
                      ListMembershipRBACRoleBindingsResponse,
                      RBACRoleBinding>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MEMBERSHIP_R_B_A_C_ROLE_BINDINGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMembershipRBACRoleBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return listMembershipsSettings;
  }

  /** Returns the object with the settings used for calls to listBoundMemberships. */
  public PagedCallSettings<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          ListBoundMembershipsPagedResponse>
      listBoundMembershipsSettings() {
    return listBoundMembershipsSettings;
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return listFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return getMembershipSettings;
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return getFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings() {
    return createMembershipSettings;
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings() {
    return createMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return createFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationSettings() {
    return createFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings() {
    return deleteMembershipSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings() {
    return deleteMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return deleteFeatureSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationSettings() {
    return deleteFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings() {
    return updateMembershipSettings;
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings() {
    return updateMembershipOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings() {
    return updateFeatureSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public OperationCallSettings<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationSettings() {
    return updateFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateConnectManifest. */
  public UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings() {
    return generateConnectManifestSettings;
  }

  /** Returns the object with the settings used for calls to createFleet. */
  public UnaryCallSettings<CreateFleetRequest, Operation> createFleetSettings() {
    return createFleetSettings;
  }

  /** Returns the object with the settings used for calls to createFleet. */
  public OperationCallSettings<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationSettings() {
    return createFleetOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFleet. */
  public UnaryCallSettings<GetFleetRequest, Fleet> getFleetSettings() {
    return getFleetSettings;
  }

  /** Returns the object with the settings used for calls to updateFleet. */
  public UnaryCallSettings<UpdateFleetRequest, Operation> updateFleetSettings() {
    return updateFleetSettings;
  }

  /** Returns the object with the settings used for calls to updateFleet. */
  public OperationCallSettings<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationSettings() {
    return updateFleetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFleet. */
  public UnaryCallSettings<DeleteFleetRequest, Operation> deleteFleetSettings() {
    return deleteFleetSettings;
  }

  /** Returns the object with the settings used for calls to deleteFleet. */
  public OperationCallSettings<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationSettings() {
    return deleteFleetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFleets. */
  public PagedCallSettings<ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
      listFleetsSettings() {
    return listFleetsSettings;
  }

  /** Returns the object with the settings used for calls to getScopeNamespace. */
  public UnaryCallSettings<GetScopeNamespaceRequest, Namespace> getScopeNamespaceSettings() {
    return getScopeNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to createScopeNamespace. */
  public UnaryCallSettings<CreateScopeNamespaceRequest, Operation> createScopeNamespaceSettings() {
    return createScopeNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to createScopeNamespace. */
  public OperationCallSettings<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationSettings() {
    return createScopeNamespaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateScopeNamespace. */
  public UnaryCallSettings<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceSettings() {
    return updateScopeNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to updateScopeNamespace. */
  public OperationCallSettings<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationSettings() {
    return updateScopeNamespaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteScopeNamespace. */
  public UnaryCallSettings<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceSettings() {
    return deleteScopeNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteScopeNamespace. */
  public OperationCallSettings<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationSettings() {
    return deleteScopeNamespaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listScopeNamespaces. */
  public PagedCallSettings<
          ListScopeNamespacesRequest, ListScopeNamespacesResponse, ListScopeNamespacesPagedResponse>
      listScopeNamespacesSettings() {
    return listScopeNamespacesSettings;
  }

  /** Returns the object with the settings used for calls to getScopeRBACRoleBinding. */
  public UnaryCallSettings<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingSettings() {
    return getScopeRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to createScopeRBACRoleBinding. */
  public UnaryCallSettings<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingSettings() {
    return createScopeRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to createScopeRBACRoleBinding. */
  public OperationCallSettings<
          CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationSettings() {
    return createScopeRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateScopeRBACRoleBinding. */
  public UnaryCallSettings<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingSettings() {
    return updateScopeRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateScopeRBACRoleBinding. */
  public OperationCallSettings<
          UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationSettings() {
    return updateScopeRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteScopeRBACRoleBinding. */
  public UnaryCallSettings<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingSettings() {
    return deleteScopeRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteScopeRBACRoleBinding. */
  public OperationCallSettings<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationSettings() {
    return deleteScopeRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listScopeRBACRoleBindings. */
  public PagedCallSettings<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsSettings() {
    return listScopeRBACRoleBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getScope. */
  public UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings() {
    return getScopeSettings;
  }

  /** Returns the object with the settings used for calls to createScope. */
  public UnaryCallSettings<CreateScopeRequest, Operation> createScopeSettings() {
    return createScopeSettings;
  }

  /** Returns the object with the settings used for calls to createScope. */
  public OperationCallSettings<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationSettings() {
    return createScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public UnaryCallSettings<UpdateScopeRequest, Operation> updateScopeSettings() {
    return updateScopeSettings;
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public OperationCallSettings<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationSettings() {
    return updateScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteScope. */
  public UnaryCallSettings<DeleteScopeRequest, Operation> deleteScopeSettings() {
    return deleteScopeSettings;
  }

  /** Returns the object with the settings used for calls to deleteScope. */
  public OperationCallSettings<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationSettings() {
    return deleteScopeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listScopes. */
  public PagedCallSettings<ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
      listScopesSettings() {
    return listScopesSettings;
  }

  /** Returns the object with the settings used for calls to listPermittedScopes. */
  public PagedCallSettings<
          ListPermittedScopesRequest, ListPermittedScopesResponse, ListPermittedScopesPagedResponse>
      listPermittedScopesSettings() {
    return listPermittedScopesSettings;
  }

  /** Returns the object with the settings used for calls to getMembershipBinding. */
  public UnaryCallSettings<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingSettings() {
    return getMembershipBindingSettings;
  }

  /** Returns the object with the settings used for calls to createMembershipBinding. */
  public UnaryCallSettings<CreateMembershipBindingRequest, Operation>
      createMembershipBindingSettings() {
    return createMembershipBindingSettings;
  }

  /** Returns the object with the settings used for calls to createMembershipBinding. */
  public OperationCallSettings<CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationSettings() {
    return createMembershipBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMembershipBinding. */
  public UnaryCallSettings<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingSettings() {
    return updateMembershipBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateMembershipBinding. */
  public OperationCallSettings<UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationSettings() {
    return updateMembershipBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembershipBinding. */
  public UnaryCallSettings<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingSettings() {
    return deleteMembershipBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembershipBinding. */
  public OperationCallSettings<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationSettings() {
    return deleteMembershipBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMembershipBindings. */
  public PagedCallSettings<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          ListMembershipBindingsPagedResponse>
      listMembershipBindingsSettings() {
    return listMembershipBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getMembershipRBACRoleBinding. */
  public UnaryCallSettings<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingSettings() {
    return getMembershipRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to createMembershipRBACRoleBinding. */
  public UnaryCallSettings<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingSettings() {
    return createMembershipRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to createMembershipRBACRoleBinding. */
  public OperationCallSettings<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationSettings() {
    return createMembershipRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMembershipRBACRoleBinding. */
  public UnaryCallSettings<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingSettings() {
    return updateMembershipRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateMembershipRBACRoleBinding. */
  public OperationCallSettings<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationSettings() {
    return updateMembershipRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembershipRBACRoleBinding. */
  public UnaryCallSettings<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingSettings() {
    return deleteMembershipRBACRoleBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteMembershipRBACRoleBinding. */
  public OperationCallSettings<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationSettings() {
    return deleteMembershipRBACRoleBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMembershipRBACRoleBindings. */
  public PagedCallSettings<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsSettings() {
    return listMembershipRBACRoleBindingsSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateMembershipRBACRoleBindingYAML.
   */
  public UnaryCallSettings<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLSettings() {
    return generateMembershipRBACRoleBindingYAMLSettings;
  }

  public GkeHubStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGkeHubStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGkeHubStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "gkehub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "gkehub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "gkehub.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(GkeHubStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected GkeHubStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listMembershipsSettings = settingsBuilder.listMembershipsSettings().build();
    listBoundMembershipsSettings = settingsBuilder.listBoundMembershipsSettings().build();
    listFeaturesSettings = settingsBuilder.listFeaturesSettings().build();
    getMembershipSettings = settingsBuilder.getMembershipSettings().build();
    getFeatureSettings = settingsBuilder.getFeatureSettings().build();
    createMembershipSettings = settingsBuilder.createMembershipSettings().build();
    createMembershipOperationSettings = settingsBuilder.createMembershipOperationSettings().build();
    createFeatureSettings = settingsBuilder.createFeatureSettings().build();
    createFeatureOperationSettings = settingsBuilder.createFeatureOperationSettings().build();
    deleteMembershipSettings = settingsBuilder.deleteMembershipSettings().build();
    deleteMembershipOperationSettings = settingsBuilder.deleteMembershipOperationSettings().build();
    deleteFeatureSettings = settingsBuilder.deleteFeatureSettings().build();
    deleteFeatureOperationSettings = settingsBuilder.deleteFeatureOperationSettings().build();
    updateMembershipSettings = settingsBuilder.updateMembershipSettings().build();
    updateMembershipOperationSettings = settingsBuilder.updateMembershipOperationSettings().build();
    updateFeatureSettings = settingsBuilder.updateFeatureSettings().build();
    updateFeatureOperationSettings = settingsBuilder.updateFeatureOperationSettings().build();
    generateConnectManifestSettings = settingsBuilder.generateConnectManifestSettings().build();
    createFleetSettings = settingsBuilder.createFleetSettings().build();
    createFleetOperationSettings = settingsBuilder.createFleetOperationSettings().build();
    getFleetSettings = settingsBuilder.getFleetSettings().build();
    updateFleetSettings = settingsBuilder.updateFleetSettings().build();
    updateFleetOperationSettings = settingsBuilder.updateFleetOperationSettings().build();
    deleteFleetSettings = settingsBuilder.deleteFleetSettings().build();
    deleteFleetOperationSettings = settingsBuilder.deleteFleetOperationSettings().build();
    listFleetsSettings = settingsBuilder.listFleetsSettings().build();
    getScopeNamespaceSettings = settingsBuilder.getScopeNamespaceSettings().build();
    createScopeNamespaceSettings = settingsBuilder.createScopeNamespaceSettings().build();
    createScopeNamespaceOperationSettings =
        settingsBuilder.createScopeNamespaceOperationSettings().build();
    updateScopeNamespaceSettings = settingsBuilder.updateScopeNamespaceSettings().build();
    updateScopeNamespaceOperationSettings =
        settingsBuilder.updateScopeNamespaceOperationSettings().build();
    deleteScopeNamespaceSettings = settingsBuilder.deleteScopeNamespaceSettings().build();
    deleteScopeNamespaceOperationSettings =
        settingsBuilder.deleteScopeNamespaceOperationSettings().build();
    listScopeNamespacesSettings = settingsBuilder.listScopeNamespacesSettings().build();
    getScopeRBACRoleBindingSettings = settingsBuilder.getScopeRBACRoleBindingSettings().build();
    createScopeRBACRoleBindingSettings =
        settingsBuilder.createScopeRBACRoleBindingSettings().build();
    createScopeRBACRoleBindingOperationSettings =
        settingsBuilder.createScopeRBACRoleBindingOperationSettings().build();
    updateScopeRBACRoleBindingSettings =
        settingsBuilder.updateScopeRBACRoleBindingSettings().build();
    updateScopeRBACRoleBindingOperationSettings =
        settingsBuilder.updateScopeRBACRoleBindingOperationSettings().build();
    deleteScopeRBACRoleBindingSettings =
        settingsBuilder.deleteScopeRBACRoleBindingSettings().build();
    deleteScopeRBACRoleBindingOperationSettings =
        settingsBuilder.deleteScopeRBACRoleBindingOperationSettings().build();
    listScopeRBACRoleBindingsSettings = settingsBuilder.listScopeRBACRoleBindingsSettings().build();
    getScopeSettings = settingsBuilder.getScopeSettings().build();
    createScopeSettings = settingsBuilder.createScopeSettings().build();
    createScopeOperationSettings = settingsBuilder.createScopeOperationSettings().build();
    updateScopeSettings = settingsBuilder.updateScopeSettings().build();
    updateScopeOperationSettings = settingsBuilder.updateScopeOperationSettings().build();
    deleteScopeSettings = settingsBuilder.deleteScopeSettings().build();
    deleteScopeOperationSettings = settingsBuilder.deleteScopeOperationSettings().build();
    listScopesSettings = settingsBuilder.listScopesSettings().build();
    listPermittedScopesSettings = settingsBuilder.listPermittedScopesSettings().build();
    getMembershipBindingSettings = settingsBuilder.getMembershipBindingSettings().build();
    createMembershipBindingSettings = settingsBuilder.createMembershipBindingSettings().build();
    createMembershipBindingOperationSettings =
        settingsBuilder.createMembershipBindingOperationSettings().build();
    updateMembershipBindingSettings = settingsBuilder.updateMembershipBindingSettings().build();
    updateMembershipBindingOperationSettings =
        settingsBuilder.updateMembershipBindingOperationSettings().build();
    deleteMembershipBindingSettings = settingsBuilder.deleteMembershipBindingSettings().build();
    deleteMembershipBindingOperationSettings =
        settingsBuilder.deleteMembershipBindingOperationSettings().build();
    listMembershipBindingsSettings = settingsBuilder.listMembershipBindingsSettings().build();
    getMembershipRBACRoleBindingSettings =
        settingsBuilder.getMembershipRBACRoleBindingSettings().build();
    createMembershipRBACRoleBindingSettings =
        settingsBuilder.createMembershipRBACRoleBindingSettings().build();
    createMembershipRBACRoleBindingOperationSettings =
        settingsBuilder.createMembershipRBACRoleBindingOperationSettings().build();
    updateMembershipRBACRoleBindingSettings =
        settingsBuilder.updateMembershipRBACRoleBindingSettings().build();
    updateMembershipRBACRoleBindingOperationSettings =
        settingsBuilder.updateMembershipRBACRoleBindingOperationSettings().build();
    deleteMembershipRBACRoleBindingSettings =
        settingsBuilder.deleteMembershipRBACRoleBindingSettings().build();
    deleteMembershipRBACRoleBindingOperationSettings =
        settingsBuilder.deleteMembershipRBACRoleBindingOperationSettings().build();
    listMembershipRBACRoleBindingsSettings =
        settingsBuilder.listMembershipRBACRoleBindingsSettings().build();
    generateMembershipRBACRoleBindingYAMLSettings =
        settingsBuilder.generateMembershipRBACRoleBindingYAMLSettings().build();
  }

  /** Builder for GkeHubStubSettings. */
  public static class Builder extends StubSettings.Builder<GkeHubStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings;
    private final PagedCallSettings.Builder<
            ListBoundMembershipsRequest,
            ListBoundMembershipsResponse,
            ListBoundMembershipsPagedResponse>
        listBoundMembershipsSettings;
    private final PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings;
    private final UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings;
    private final UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings;
    private final UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings;
    private final OperationCallSettings.Builder<
            CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings;
    private final OperationCallSettings.Builder<CreateFeatureRequest, Feature, OperationMetadata>
        createFeatureOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings;
    private final OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings;
    private final OperationCallSettings.Builder<DeleteFeatureRequest, Empty, OperationMetadata>
        deleteFeatureOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings;
    private final OperationCallSettings.Builder<
            UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings;
    private final OperationCallSettings.Builder<UpdateFeatureRequest, Feature, OperationMetadata>
        updateFeatureOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings;
    private final UnaryCallSettings.Builder<CreateFleetRequest, Operation> createFleetSettings;
    private final OperationCallSettings.Builder<CreateFleetRequest, Fleet, OperationMetadata>
        createFleetOperationSettings;
    private final UnaryCallSettings.Builder<GetFleetRequest, Fleet> getFleetSettings;
    private final UnaryCallSettings.Builder<UpdateFleetRequest, Operation> updateFleetSettings;
    private final OperationCallSettings.Builder<UpdateFleetRequest, Fleet, OperationMetadata>
        updateFleetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFleetRequest, Operation> deleteFleetSettings;
    private final OperationCallSettings.Builder<DeleteFleetRequest, Empty, OperationMetadata>
        deleteFleetOperationSettings;
    private final PagedCallSettings.Builder<
            ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
        listFleetsSettings;
    private final UnaryCallSettings.Builder<GetScopeNamespaceRequest, Namespace>
        getScopeNamespaceSettings;
    private final UnaryCallSettings.Builder<CreateScopeNamespaceRequest, Operation>
        createScopeNamespaceSettings;
    private final OperationCallSettings.Builder<
            CreateScopeNamespaceRequest, Namespace, OperationMetadata>
        createScopeNamespaceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateScopeNamespaceRequest, Operation>
        updateScopeNamespaceSettings;
    private final OperationCallSettings.Builder<
            UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
        updateScopeNamespaceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteScopeNamespaceRequest, Operation>
        deleteScopeNamespaceSettings;
    private final OperationCallSettings.Builder<
            DeleteScopeNamespaceRequest, Empty, OperationMetadata>
        deleteScopeNamespaceOperationSettings;
    private final PagedCallSettings.Builder<
            ListScopeNamespacesRequest,
            ListScopeNamespacesResponse,
            ListScopeNamespacesPagedResponse>
        listScopeNamespacesSettings;
    private final UnaryCallSettings.Builder<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
        getScopeRBACRoleBindingSettings;
    private final UnaryCallSettings.Builder<CreateScopeRBACRoleBindingRequest, Operation>
        createScopeRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createScopeRBACRoleBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateScopeRBACRoleBindingRequest, Operation>
        updateScopeRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateScopeRBACRoleBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteScopeRBACRoleBindingRequest, Operation>
        deleteScopeRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteScopeRBACRoleBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListScopeRBACRoleBindingsRequest,
            ListScopeRBACRoleBindingsResponse,
            ListScopeRBACRoleBindingsPagedResponse>
        listScopeRBACRoleBindingsSettings;
    private final UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings;
    private final UnaryCallSettings.Builder<CreateScopeRequest, Operation> createScopeSettings;
    private final OperationCallSettings.Builder<CreateScopeRequest, Scope, OperationMetadata>
        createScopeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateScopeRequest, Operation> updateScopeSettings;
    private final OperationCallSettings.Builder<UpdateScopeRequest, Scope, OperationMetadata>
        updateScopeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteScopeRequest, Operation> deleteScopeSettings;
    private final OperationCallSettings.Builder<DeleteScopeRequest, Empty, OperationMetadata>
        deleteScopeOperationSettings;
    private final PagedCallSettings.Builder<
            ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
        listScopesSettings;
    private final PagedCallSettings.Builder<
            ListPermittedScopesRequest,
            ListPermittedScopesResponse,
            ListPermittedScopesPagedResponse>
        listPermittedScopesSettings;
    private final UnaryCallSettings.Builder<GetMembershipBindingRequest, MembershipBinding>
        getMembershipBindingSettings;
    private final UnaryCallSettings.Builder<CreateMembershipBindingRequest, Operation>
        createMembershipBindingSettings;
    private final OperationCallSettings.Builder<
            CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        createMembershipBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipBindingRequest, Operation>
        updateMembershipBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        updateMembershipBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipBindingRequest, Operation>
        deleteMembershipBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteMembershipBindingRequest, Empty, OperationMetadata>
        deleteMembershipBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListMembershipBindingsRequest,
            ListMembershipBindingsResponse,
            ListMembershipBindingsPagedResponse>
        listMembershipBindingsSettings;
    private final UnaryCallSettings.Builder<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
        getMembershipRBACRoleBindingSettings;
    private final UnaryCallSettings.Builder<CreateMembershipRBACRoleBindingRequest, Operation>
        createMembershipRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createMembershipRBACRoleBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMembershipRBACRoleBindingRequest, Operation>
        updateMembershipRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateMembershipRBACRoleBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMembershipRBACRoleBindingRequest, Operation>
        deleteMembershipRBACRoleBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteMembershipRBACRoleBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListMembershipRBACRoleBindingsRequest,
            ListMembershipRBACRoleBindingsResponse,
            ListMembershipRBACRoleBindingsPagedResponse>
        listMembershipRBACRoleBindingsSettings;
    private final UnaryCallSettings.Builder<
            GenerateMembershipRBACRoleBindingYAMLRequest,
            GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAMLSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listMembershipsSettings = PagedCallSettings.newBuilder(LIST_MEMBERSHIPS_PAGE_STR_FACT);
      listBoundMembershipsSettings =
          PagedCallSettings.newBuilder(LIST_BOUND_MEMBERSHIPS_PAGE_STR_FACT);
      listFeaturesSettings = PagedCallSettings.newBuilder(LIST_FEATURES_PAGE_STR_FACT);
      getMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipOperationSettings = OperationCallSettings.newBuilder();
      createFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureOperationSettings = OperationCallSettings.newBuilder();
      deleteMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureOperationSettings = OperationCallSettings.newBuilder();
      updateMembershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipOperationSettings = OperationCallSettings.newBuilder();
      updateFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureOperationSettings = OperationCallSettings.newBuilder();
      generateConnectManifestSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFleetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFleetOperationSettings = OperationCallSettings.newBuilder();
      getFleetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFleetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFleetOperationSettings = OperationCallSettings.newBuilder();
      deleteFleetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFleetOperationSettings = OperationCallSettings.newBuilder();
      listFleetsSettings = PagedCallSettings.newBuilder(LIST_FLEETS_PAGE_STR_FACT);
      getScopeNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeNamespaceOperationSettings = OperationCallSettings.newBuilder();
      updateScopeNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateScopeNamespaceOperationSettings = OperationCallSettings.newBuilder();
      deleteScopeNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScopeNamespaceOperationSettings = OperationCallSettings.newBuilder();
      listScopeNamespacesSettings =
          PagedCallSettings.newBuilder(LIST_SCOPE_NAMESPACES_PAGE_STR_FACT);
      getScopeRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      updateScopeRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateScopeRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteScopeRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScopeRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      listScopeRBACRoleBindingsSettings =
          PagedCallSettings.newBuilder(LIST_SCOPE_R_B_A_C_ROLE_BINDINGS_PAGE_STR_FACT);
      getScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScopeOperationSettings = OperationCallSettings.newBuilder();
      updateScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateScopeOperationSettings = OperationCallSettings.newBuilder();
      deleteScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScopeOperationSettings = OperationCallSettings.newBuilder();
      listScopesSettings = PagedCallSettings.newBuilder(LIST_SCOPES_PAGE_STR_FACT);
      listPermittedScopesSettings =
          PagedCallSettings.newBuilder(LIST_PERMITTED_SCOPES_PAGE_STR_FACT);
      getMembershipBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipBindingOperationSettings = OperationCallSettings.newBuilder();
      updateMembershipBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteMembershipBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipBindingOperationSettings = OperationCallSettings.newBuilder();
      listMembershipBindingsSettings =
          PagedCallSettings.newBuilder(LIST_MEMBERSHIP_BINDINGS_PAGE_STR_FACT);
      getMembershipRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembershipRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      updateMembershipRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMembershipRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteMembershipRBACRoleBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMembershipRBACRoleBindingOperationSettings = OperationCallSettings.newBuilder();
      listMembershipRBACRoleBindingsSettings =
          PagedCallSettings.newBuilder(LIST_MEMBERSHIP_R_B_A_C_ROLE_BINDINGS_PAGE_STR_FACT);
      generateMembershipRBACRoleBindingYAMLSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              listBoundMembershipsSettings,
              listFeaturesSettings,
              getMembershipSettings,
              getFeatureSettings,
              createMembershipSettings,
              createFeatureSettings,
              deleteMembershipSettings,
              deleteFeatureSettings,
              updateMembershipSettings,
              updateFeatureSettings,
              generateConnectManifestSettings,
              createFleetSettings,
              getFleetSettings,
              updateFleetSettings,
              deleteFleetSettings,
              listFleetsSettings,
              getScopeNamespaceSettings,
              createScopeNamespaceSettings,
              updateScopeNamespaceSettings,
              deleteScopeNamespaceSettings,
              listScopeNamespacesSettings,
              getScopeRBACRoleBindingSettings,
              createScopeRBACRoleBindingSettings,
              updateScopeRBACRoleBindingSettings,
              deleteScopeRBACRoleBindingSettings,
              listScopeRBACRoleBindingsSettings,
              getScopeSettings,
              createScopeSettings,
              updateScopeSettings,
              deleteScopeSettings,
              listScopesSettings,
              listPermittedScopesSettings,
              getMembershipBindingSettings,
              createMembershipBindingSettings,
              updateMembershipBindingSettings,
              deleteMembershipBindingSettings,
              listMembershipBindingsSettings,
              getMembershipRBACRoleBindingSettings,
              createMembershipRBACRoleBindingSettings,
              updateMembershipRBACRoleBindingSettings,
              deleteMembershipRBACRoleBindingSettings,
              listMembershipRBACRoleBindingsSettings,
              generateMembershipRBACRoleBindingYAMLSettings);
      initDefaults(this);
    }

    protected Builder(GkeHubStubSettings settings) {
      super(settings);

      listMembershipsSettings = settings.listMembershipsSettings.toBuilder();
      listBoundMembershipsSettings = settings.listBoundMembershipsSettings.toBuilder();
      listFeaturesSettings = settings.listFeaturesSettings.toBuilder();
      getMembershipSettings = settings.getMembershipSettings.toBuilder();
      getFeatureSettings = settings.getFeatureSettings.toBuilder();
      createMembershipSettings = settings.createMembershipSettings.toBuilder();
      createMembershipOperationSettings = settings.createMembershipOperationSettings.toBuilder();
      createFeatureSettings = settings.createFeatureSettings.toBuilder();
      createFeatureOperationSettings = settings.createFeatureOperationSettings.toBuilder();
      deleteMembershipSettings = settings.deleteMembershipSettings.toBuilder();
      deleteMembershipOperationSettings = settings.deleteMembershipOperationSettings.toBuilder();
      deleteFeatureSettings = settings.deleteFeatureSettings.toBuilder();
      deleteFeatureOperationSettings = settings.deleteFeatureOperationSettings.toBuilder();
      updateMembershipSettings = settings.updateMembershipSettings.toBuilder();
      updateMembershipOperationSettings = settings.updateMembershipOperationSettings.toBuilder();
      updateFeatureSettings = settings.updateFeatureSettings.toBuilder();
      updateFeatureOperationSettings = settings.updateFeatureOperationSettings.toBuilder();
      generateConnectManifestSettings = settings.generateConnectManifestSettings.toBuilder();
      createFleetSettings = settings.createFleetSettings.toBuilder();
      createFleetOperationSettings = settings.createFleetOperationSettings.toBuilder();
      getFleetSettings = settings.getFleetSettings.toBuilder();
      updateFleetSettings = settings.updateFleetSettings.toBuilder();
      updateFleetOperationSettings = settings.updateFleetOperationSettings.toBuilder();
      deleteFleetSettings = settings.deleteFleetSettings.toBuilder();
      deleteFleetOperationSettings = settings.deleteFleetOperationSettings.toBuilder();
      listFleetsSettings = settings.listFleetsSettings.toBuilder();
      getScopeNamespaceSettings = settings.getScopeNamespaceSettings.toBuilder();
      createScopeNamespaceSettings = settings.createScopeNamespaceSettings.toBuilder();
      createScopeNamespaceOperationSettings =
          settings.createScopeNamespaceOperationSettings.toBuilder();
      updateScopeNamespaceSettings = settings.updateScopeNamespaceSettings.toBuilder();
      updateScopeNamespaceOperationSettings =
          settings.updateScopeNamespaceOperationSettings.toBuilder();
      deleteScopeNamespaceSettings = settings.deleteScopeNamespaceSettings.toBuilder();
      deleteScopeNamespaceOperationSettings =
          settings.deleteScopeNamespaceOperationSettings.toBuilder();
      listScopeNamespacesSettings = settings.listScopeNamespacesSettings.toBuilder();
      getScopeRBACRoleBindingSettings = settings.getScopeRBACRoleBindingSettings.toBuilder();
      createScopeRBACRoleBindingSettings = settings.createScopeRBACRoleBindingSettings.toBuilder();
      createScopeRBACRoleBindingOperationSettings =
          settings.createScopeRBACRoleBindingOperationSettings.toBuilder();
      updateScopeRBACRoleBindingSettings = settings.updateScopeRBACRoleBindingSettings.toBuilder();
      updateScopeRBACRoleBindingOperationSettings =
          settings.updateScopeRBACRoleBindingOperationSettings.toBuilder();
      deleteScopeRBACRoleBindingSettings = settings.deleteScopeRBACRoleBindingSettings.toBuilder();
      deleteScopeRBACRoleBindingOperationSettings =
          settings.deleteScopeRBACRoleBindingOperationSettings.toBuilder();
      listScopeRBACRoleBindingsSettings = settings.listScopeRBACRoleBindingsSettings.toBuilder();
      getScopeSettings = settings.getScopeSettings.toBuilder();
      createScopeSettings = settings.createScopeSettings.toBuilder();
      createScopeOperationSettings = settings.createScopeOperationSettings.toBuilder();
      updateScopeSettings = settings.updateScopeSettings.toBuilder();
      updateScopeOperationSettings = settings.updateScopeOperationSettings.toBuilder();
      deleteScopeSettings = settings.deleteScopeSettings.toBuilder();
      deleteScopeOperationSettings = settings.deleteScopeOperationSettings.toBuilder();
      listScopesSettings = settings.listScopesSettings.toBuilder();
      listPermittedScopesSettings = settings.listPermittedScopesSettings.toBuilder();
      getMembershipBindingSettings = settings.getMembershipBindingSettings.toBuilder();
      createMembershipBindingSettings = settings.createMembershipBindingSettings.toBuilder();
      createMembershipBindingOperationSettings =
          settings.createMembershipBindingOperationSettings.toBuilder();
      updateMembershipBindingSettings = settings.updateMembershipBindingSettings.toBuilder();
      updateMembershipBindingOperationSettings =
          settings.updateMembershipBindingOperationSettings.toBuilder();
      deleteMembershipBindingSettings = settings.deleteMembershipBindingSettings.toBuilder();
      deleteMembershipBindingOperationSettings =
          settings.deleteMembershipBindingOperationSettings.toBuilder();
      listMembershipBindingsSettings = settings.listMembershipBindingsSettings.toBuilder();
      getMembershipRBACRoleBindingSettings =
          settings.getMembershipRBACRoleBindingSettings.toBuilder();
      createMembershipRBACRoleBindingSettings =
          settings.createMembershipRBACRoleBindingSettings.toBuilder();
      createMembershipRBACRoleBindingOperationSettings =
          settings.createMembershipRBACRoleBindingOperationSettings.toBuilder();
      updateMembershipRBACRoleBindingSettings =
          settings.updateMembershipRBACRoleBindingSettings.toBuilder();
      updateMembershipRBACRoleBindingOperationSettings =
          settings.updateMembershipRBACRoleBindingOperationSettings.toBuilder();
      deleteMembershipRBACRoleBindingSettings =
          settings.deleteMembershipRBACRoleBindingSettings.toBuilder();
      deleteMembershipRBACRoleBindingOperationSettings =
          settings.deleteMembershipRBACRoleBindingOperationSettings.toBuilder();
      listMembershipRBACRoleBindingsSettings =
          settings.listMembershipRBACRoleBindingsSettings.toBuilder();
      generateMembershipRBACRoleBindingYAMLSettings =
          settings.generateMembershipRBACRoleBindingYAMLSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listMembershipsSettings,
              listBoundMembershipsSettings,
              listFeaturesSettings,
              getMembershipSettings,
              getFeatureSettings,
              createMembershipSettings,
              createFeatureSettings,
              deleteMembershipSettings,
              deleteFeatureSettings,
              updateMembershipSettings,
              updateFeatureSettings,
              generateConnectManifestSettings,
              createFleetSettings,
              getFleetSettings,
              updateFleetSettings,
              deleteFleetSettings,
              listFleetsSettings,
              getScopeNamespaceSettings,
              createScopeNamespaceSettings,
              updateScopeNamespaceSettings,
              deleteScopeNamespaceSettings,
              listScopeNamespacesSettings,
              getScopeRBACRoleBindingSettings,
              createScopeRBACRoleBindingSettings,
              updateScopeRBACRoleBindingSettings,
              deleteScopeRBACRoleBindingSettings,
              listScopeRBACRoleBindingsSettings,
              getScopeSettings,
              createScopeSettings,
              updateScopeSettings,
              deleteScopeSettings,
              listScopesSettings,
              listPermittedScopesSettings,
              getMembershipBindingSettings,
              createMembershipBindingSettings,
              updateMembershipBindingSettings,
              deleteMembershipBindingSettings,
              listMembershipBindingsSettings,
              getMembershipRBACRoleBindingSettings,
              createMembershipRBACRoleBindingSettings,
              updateMembershipRBACRoleBindingSettings,
              deleteMembershipRBACRoleBindingSettings,
              listMembershipRBACRoleBindingsSettings,
              generateMembershipRBACRoleBindingYAMLSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listMembershipsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBoundMembershipsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateConnectManifestSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFleetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFleetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFleetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFleetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFleetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getScopeNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createScopeNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateScopeNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteScopeNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listScopeNamespacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getScopeRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createScopeRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateScopeRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteScopeRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listScopeRBACRoleBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPermittedScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMembershipBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMembershipRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMembershipRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMembershipRBACRoleBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMembershipRBACRoleBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateMembershipRBACRoleBindingYAMLSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMembershipOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMembershipRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Membership.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createFleetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateFleetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Fleet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateFleetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateFleetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Fleet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteFleetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteFleetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createScopeNamespaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateScopeNamespaceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Namespace.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateScopeNamespaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateScopeNamespaceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Namespace.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteScopeNamespaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteScopeNamespaceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createScopeRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateScopeRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RBACRoleBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateScopeRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateScopeRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RBACRoleBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteScopeRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteScopeRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Scope.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Scope.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteScopeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteScopeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMembershipBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembershipBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MembershipBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMembershipBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMembershipBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MembershipBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMembershipBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMembershipBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMembershipRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembershipRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RBACRoleBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMembershipRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMembershipRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RBACRoleBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMembershipRBACRoleBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMembershipRBACRoleBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return listMembershipsSettings;
    }

    /** Returns the builder for the settings used for calls to listBoundMemberships. */
    public PagedCallSettings.Builder<
            ListBoundMembershipsRequest,
            ListBoundMembershipsResponse,
            ListBoundMembershipsPagedResponse>
        listBoundMembershipsSettings() {
      return listBoundMembershipsSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return listFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings() {
      return createMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public OperationCallSettings.Builder<CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings() {
      return createMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return createFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public OperationCallSettings.Builder<CreateFeatureRequest, Feature, OperationMetadata>
        createFeatureOperationSettings() {
      return createFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings() {
      return deleteMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings() {
      return deleteMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return deleteFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, OperationMetadata>
        deleteFeatureOperationSettings() {
      return deleteFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings() {
      return updateMembershipSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public OperationCallSettings.Builder<UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings() {
      return updateMembershipOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings() {
      return updateFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public OperationCallSettings.Builder<UpdateFeatureRequest, Feature, OperationMetadata>
        updateFeatureOperationSettings() {
      return updateFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateConnectManifest. */
    public UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings() {
      return generateConnectManifestSettings;
    }

    /** Returns the builder for the settings used for calls to createFleet. */
    public UnaryCallSettings.Builder<CreateFleetRequest, Operation> createFleetSettings() {
      return createFleetSettings;
    }

    /** Returns the builder for the settings used for calls to createFleet. */
    public OperationCallSettings.Builder<CreateFleetRequest, Fleet, OperationMetadata>
        createFleetOperationSettings() {
      return createFleetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFleet. */
    public UnaryCallSettings.Builder<GetFleetRequest, Fleet> getFleetSettings() {
      return getFleetSettings;
    }

    /** Returns the builder for the settings used for calls to updateFleet. */
    public UnaryCallSettings.Builder<UpdateFleetRequest, Operation> updateFleetSettings() {
      return updateFleetSettings;
    }

    /** Returns the builder for the settings used for calls to updateFleet. */
    public OperationCallSettings.Builder<UpdateFleetRequest, Fleet, OperationMetadata>
        updateFleetOperationSettings() {
      return updateFleetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFleet. */
    public UnaryCallSettings.Builder<DeleteFleetRequest, Operation> deleteFleetSettings() {
      return deleteFleetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFleet. */
    public OperationCallSettings.Builder<DeleteFleetRequest, Empty, OperationMetadata>
        deleteFleetOperationSettings() {
      return deleteFleetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFleets. */
    public PagedCallSettings.Builder<ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
        listFleetsSettings() {
      return listFleetsSettings;
    }

    /** Returns the builder for the settings used for calls to getScopeNamespace. */
    public UnaryCallSettings.Builder<GetScopeNamespaceRequest, Namespace>
        getScopeNamespaceSettings() {
      return getScopeNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to createScopeNamespace. */
    public UnaryCallSettings.Builder<CreateScopeNamespaceRequest, Operation>
        createScopeNamespaceSettings() {
      return createScopeNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to createScopeNamespace. */
    public OperationCallSettings.Builder<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
        createScopeNamespaceOperationSettings() {
      return createScopeNamespaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateScopeNamespace. */
    public UnaryCallSettings.Builder<UpdateScopeNamespaceRequest, Operation>
        updateScopeNamespaceSettings() {
      return updateScopeNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateScopeNamespace. */
    public OperationCallSettings.Builder<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
        updateScopeNamespaceOperationSettings() {
      return updateScopeNamespaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScopeNamespace. */
    public UnaryCallSettings.Builder<DeleteScopeNamespaceRequest, Operation>
        deleteScopeNamespaceSettings() {
      return deleteScopeNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScopeNamespace. */
    public OperationCallSettings.Builder<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
        deleteScopeNamespaceOperationSettings() {
      return deleteScopeNamespaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listScopeNamespaces. */
    public PagedCallSettings.Builder<
            ListScopeNamespacesRequest,
            ListScopeNamespacesResponse,
            ListScopeNamespacesPagedResponse>
        listScopeNamespacesSettings() {
      return listScopeNamespacesSettings;
    }

    /** Returns the builder for the settings used for calls to getScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
        getScopeRBACRoleBindingSettings() {
      return getScopeRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<CreateScopeRBACRoleBindingRequest, Operation>
        createScopeRBACRoleBindingSettings() {
      return createScopeRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createScopeRBACRoleBindingOperationSettings() {
      return createScopeRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<UpdateScopeRBACRoleBindingRequest, Operation>
        updateScopeRBACRoleBindingSettings() {
      return updateScopeRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateScopeRBACRoleBindingOperationSettings() {
      return updateScopeRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<DeleteScopeRBACRoleBindingRequest, Operation>
        deleteScopeRBACRoleBindingSettings() {
      return deleteScopeRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteScopeRBACRoleBindingOperationSettings() {
      return deleteScopeRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listScopeRBACRoleBindings. */
    public PagedCallSettings.Builder<
            ListScopeRBACRoleBindingsRequest,
            ListScopeRBACRoleBindingsResponse,
            ListScopeRBACRoleBindingsPagedResponse>
        listScopeRBACRoleBindingsSettings() {
      return listScopeRBACRoleBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getScope. */
    public UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings() {
      return getScopeSettings;
    }

    /** Returns the builder for the settings used for calls to createScope. */
    public UnaryCallSettings.Builder<CreateScopeRequest, Operation> createScopeSettings() {
      return createScopeSettings;
    }

    /** Returns the builder for the settings used for calls to createScope. */
    public OperationCallSettings.Builder<CreateScopeRequest, Scope, OperationMetadata>
        createScopeOperationSettings() {
      return createScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public UnaryCallSettings.Builder<UpdateScopeRequest, Operation> updateScopeSettings() {
      return updateScopeSettings;
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public OperationCallSettings.Builder<UpdateScopeRequest, Scope, OperationMetadata>
        updateScopeOperationSettings() {
      return updateScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScope. */
    public UnaryCallSettings.Builder<DeleteScopeRequest, Operation> deleteScopeSettings() {
      return deleteScopeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScope. */
    public OperationCallSettings.Builder<DeleteScopeRequest, Empty, OperationMetadata>
        deleteScopeOperationSettings() {
      return deleteScopeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listScopes. */
    public PagedCallSettings.Builder<ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
        listScopesSettings() {
      return listScopesSettings;
    }

    /** Returns the builder for the settings used for calls to listPermittedScopes. */
    public PagedCallSettings.Builder<
            ListPermittedScopesRequest,
            ListPermittedScopesResponse,
            ListPermittedScopesPagedResponse>
        listPermittedScopesSettings() {
      return listPermittedScopesSettings;
    }

    /** Returns the builder for the settings used for calls to getMembershipBinding. */
    public UnaryCallSettings.Builder<GetMembershipBindingRequest, MembershipBinding>
        getMembershipBindingSettings() {
      return getMembershipBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createMembershipBinding. */
    public UnaryCallSettings.Builder<CreateMembershipBindingRequest, Operation>
        createMembershipBindingSettings() {
      return createMembershipBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createMembershipBinding. */
    public OperationCallSettings.Builder<
            CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        createMembershipBindingOperationSettings() {
      return createMembershipBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembershipBinding. */
    public UnaryCallSettings.Builder<UpdateMembershipBindingRequest, Operation>
        updateMembershipBindingSettings() {
      return updateMembershipBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembershipBinding. */
    public OperationCallSettings.Builder<
            UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        updateMembershipBindingOperationSettings() {
      return updateMembershipBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembershipBinding. */
    public UnaryCallSettings.Builder<DeleteMembershipBindingRequest, Operation>
        deleteMembershipBindingSettings() {
      return deleteMembershipBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembershipBinding. */
    public OperationCallSettings.Builder<DeleteMembershipBindingRequest, Empty, OperationMetadata>
        deleteMembershipBindingOperationSettings() {
      return deleteMembershipBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMembershipBindings. */
    public PagedCallSettings.Builder<
            ListMembershipBindingsRequest,
            ListMembershipBindingsResponse,
            ListMembershipBindingsPagedResponse>
        listMembershipBindingsSettings() {
      return listMembershipBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
        getMembershipRBACRoleBindingSettings() {
      return getMembershipRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<CreateMembershipRBACRoleBindingRequest, Operation>
        createMembershipRBACRoleBindingSettings() {
      return createMembershipRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createMembershipRBACRoleBindingOperationSettings() {
      return createMembershipRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<UpdateMembershipRBACRoleBindingRequest, Operation>
        updateMembershipRBACRoleBindingSettings() {
      return updateMembershipRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateMembershipRBACRoleBindingOperationSettings() {
      return updateMembershipRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<DeleteMembershipRBACRoleBindingRequest, Operation>
        deleteMembershipRBACRoleBindingSettings() {
      return deleteMembershipRBACRoleBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteMembershipRBACRoleBindingOperationSettings() {
      return deleteMembershipRBACRoleBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMembershipRBACRoleBindings. */
    public PagedCallSettings.Builder<
            ListMembershipRBACRoleBindingsRequest,
            ListMembershipRBACRoleBindingsResponse,
            ListMembershipRBACRoleBindingsPagedResponse>
        listMembershipRBACRoleBindingsSettings() {
      return listMembershipRBACRoleBindingsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateMembershipRBACRoleBindingYAML.
     */
    public UnaryCallSettings.Builder<
            GenerateMembershipRBACRoleBindingYAMLRequest,
            GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAMLSettings() {
      return generateMembershipRBACRoleBindingYAMLSettings;
    }

    @Override
    public GkeHubStubSettings build() throws IOException {
      return new GkeHubStubSettings(this);
    }
  }
}
