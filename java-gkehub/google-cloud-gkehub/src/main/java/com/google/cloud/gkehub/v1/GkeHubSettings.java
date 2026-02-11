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

package com.google.cloud.gkehub.v1;

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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gkehub.v1.stub.GkeHubStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GkeHubClient}.
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
 * GkeHubSettings.Builder gkeHubSettingsBuilder = GkeHubSettings.newBuilder();
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
 * GkeHubSettings gkeHubSettings = gkeHubSettingsBuilder.build();
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
 * GkeHubSettings.Builder gkeHubSettingsBuilder = GkeHubSettings.newBuilder();
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
public class GkeHubSettings extends ClientSettings<GkeHubSettings> {

  /** Returns the object with the settings used for calls to listMemberships. */
  public PagedCallSettings<
          ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
      listMembershipsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listMembershipsSettings();
  }

  /** Returns the object with the settings used for calls to listBoundMemberships. */
  public PagedCallSettings<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          ListBoundMembershipsPagedResponse>
      listBoundMembershipsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listBoundMembershipsSettings();
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listFeaturesSettings();
  }

  /** Returns the object with the settings used for calls to getMembership. */
  public UnaryCallSettings<GetMembershipRequest, Membership> getMembershipSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getMembershipSettings();
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getFeatureSettings();
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public UnaryCallSettings<CreateMembershipRequest, Operation> createMembershipSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createMembershipSettings();
  }

  /** Returns the object with the settings used for calls to createMembership. */
  public OperationCallSettings<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createFeatureSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public UnaryCallSettings<DeleteMembershipRequest, Operation> deleteMembershipSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteMembershipSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembership. */
  public OperationCallSettings<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteFeatureSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public UnaryCallSettings<UpdateMembershipRequest, Operation> updateMembershipSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateMembershipSettings();
  }

  /** Returns the object with the settings used for calls to updateMembership. */
  public OperationCallSettings<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateMembershipOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateFeatureSettings();
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public OperationCallSettings<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateConnectManifest. */
  public UnaryCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestSettings() {
    return ((GkeHubStubSettings) getStubSettings()).generateConnectManifestSettings();
  }

  /** Returns the object with the settings used for calls to createFleet. */
  public UnaryCallSettings<CreateFleetRequest, Operation> createFleetSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createFleetSettings();
  }

  /** Returns the object with the settings used for calls to createFleet. */
  public OperationCallSettings<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createFleetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFleet. */
  public UnaryCallSettings<GetFleetRequest, Fleet> getFleetSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getFleetSettings();
  }

  /** Returns the object with the settings used for calls to updateFleet. */
  public UnaryCallSettings<UpdateFleetRequest, Operation> updateFleetSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateFleetSettings();
  }

  /** Returns the object with the settings used for calls to updateFleet. */
  public OperationCallSettings<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateFleetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFleet. */
  public UnaryCallSettings<DeleteFleetRequest, Operation> deleteFleetSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteFleetSettings();
  }

  /** Returns the object with the settings used for calls to deleteFleet. */
  public OperationCallSettings<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteFleetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listFleets. */
  public PagedCallSettings<ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
      listFleetsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listFleetsSettings();
  }

  /** Returns the object with the settings used for calls to getScopeNamespace. */
  public UnaryCallSettings<GetScopeNamespaceRequest, Namespace> getScopeNamespaceSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getScopeNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to createScopeNamespace. */
  public UnaryCallSettings<CreateScopeNamespaceRequest, Operation> createScopeNamespaceSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to createScopeNamespace. */
  public OperationCallSettings<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeNamespaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateScopeNamespace. */
  public UnaryCallSettings<UpdateScopeNamespaceRequest, Operation> updateScopeNamespaceSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to updateScopeNamespace. */
  public OperationCallSettings<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeNamespaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteScopeNamespace. */
  public UnaryCallSettings<DeleteScopeNamespaceRequest, Operation> deleteScopeNamespaceSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteScopeNamespace. */
  public OperationCallSettings<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeNamespaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listScopeNamespaces. */
  public PagedCallSettings<
          ListScopeNamespacesRequest, ListScopeNamespacesResponse, ListScopeNamespacesPagedResponse>
      listScopeNamespacesSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listScopeNamespacesSettings();
  }

  /** Returns the object with the settings used for calls to getScopeRBACRoleBinding. */
  public UnaryCallSettings<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getScopeRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to createScopeRBACRoleBinding. */
  public UnaryCallSettings<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to createScopeRBACRoleBinding. */
  public OperationCallSettings<
          CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateScopeRBACRoleBinding. */
  public UnaryCallSettings<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateScopeRBACRoleBinding. */
  public OperationCallSettings<
          UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteScopeRBACRoleBinding. */
  public UnaryCallSettings<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteScopeRBACRoleBinding. */
  public OperationCallSettings<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listScopeRBACRoleBindings. */
  public PagedCallSettings<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listScopeRBACRoleBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getScope. */
  public UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getScopeSettings();
  }

  /** Returns the object with the settings used for calls to createScope. */
  public UnaryCallSettings<CreateScopeRequest, Operation> createScopeSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeSettings();
  }

  /** Returns the object with the settings used for calls to createScope. */
  public OperationCallSettings<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public UnaryCallSettings<UpdateScopeRequest, Operation> updateScopeSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeSettings();
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public OperationCallSettings<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteScope. */
  public UnaryCallSettings<DeleteScopeRequest, Operation> deleteScopeSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeSettings();
  }

  /** Returns the object with the settings used for calls to deleteScope. */
  public OperationCallSettings<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listScopes. */
  public PagedCallSettings<ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
      listScopesSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listScopesSettings();
  }

  /** Returns the object with the settings used for calls to listPermittedScopes. */
  public PagedCallSettings<
          ListPermittedScopesRequest, ListPermittedScopesResponse, ListPermittedScopesPagedResponse>
      listPermittedScopesSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listPermittedScopesSettings();
  }

  /** Returns the object with the settings used for calls to getMembershipBinding. */
  public UnaryCallSettings<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getMembershipBindingSettings();
  }

  /** Returns the object with the settings used for calls to createMembershipBinding. */
  public UnaryCallSettings<CreateMembershipBindingRequest, Operation>
      createMembershipBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createMembershipBindingSettings();
  }

  /** Returns the object with the settings used for calls to createMembershipBinding. */
  public OperationCallSettings<CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createMembershipBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMembershipBinding. */
  public UnaryCallSettings<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateMembershipBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateMembershipBinding. */
  public OperationCallSettings<UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateMembershipBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembershipBinding. */
  public UnaryCallSettings<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteMembershipBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembershipBinding. */
  public OperationCallSettings<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteMembershipBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMembershipBindings. */
  public PagedCallSettings<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          ListMembershipBindingsPagedResponse>
      listMembershipBindingsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listMembershipBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getMembershipRBACRoleBinding. */
  public UnaryCallSettings<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).getMembershipRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to createMembershipRBACRoleBinding. */
  public UnaryCallSettings<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).createMembershipRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to createMembershipRBACRoleBinding. */
  public OperationCallSettings<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings())
        .createMembershipRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMembershipRBACRoleBinding. */
  public UnaryCallSettings<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).updateMembershipRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateMembershipRBACRoleBinding. */
  public OperationCallSettings<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings())
        .updateMembershipRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembershipRBACRoleBinding. */
  public UnaryCallSettings<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingSettings() {
    return ((GkeHubStubSettings) getStubSettings()).deleteMembershipRBACRoleBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteMembershipRBACRoleBinding. */
  public OperationCallSettings<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationSettings() {
    return ((GkeHubStubSettings) getStubSettings())
        .deleteMembershipRBACRoleBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMembershipRBACRoleBindings. */
  public PagedCallSettings<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsSettings() {
    return ((GkeHubStubSettings) getStubSettings()).listMembershipRBACRoleBindingsSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateMembershipRBACRoleBindingYAML.
   */
  public UnaryCallSettings<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLSettings() {
    return ((GkeHubStubSettings) getStubSettings()).generateMembershipRBACRoleBindingYAMLSettings();
  }

  public static final GkeHubSettings create(GkeHubStubSettings stub) throws IOException {
    return new GkeHubSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GkeHubStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GkeHubStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GkeHubStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GkeHubStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GkeHubStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GkeHubStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GkeHubStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeHubStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GkeHubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GkeHubSettings. */
  public static class Builder extends ClientSettings.Builder<GkeHubSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GkeHubStubSettings.newBuilder(clientContext));
    }

    protected Builder(GkeHubSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GkeHubStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GkeHubStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GkeHubStubSettings.newHttpJsonBuilder());
    }

    public GkeHubStubSettings.Builder getStubSettingsBuilder() {
      return ((GkeHubStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listMemberships. */
    public PagedCallSettings.Builder<
            ListMembershipsRequest, ListMembershipsResponse, ListMembershipsPagedResponse>
        listMembershipsSettings() {
      return getStubSettingsBuilder().listMembershipsSettings();
    }

    /** Returns the builder for the settings used for calls to listBoundMemberships. */
    public PagedCallSettings.Builder<
            ListBoundMembershipsRequest,
            ListBoundMembershipsResponse,
            ListBoundMembershipsPagedResponse>
        listBoundMembershipsSettings() {
      return getStubSettingsBuilder().listBoundMembershipsSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return getStubSettingsBuilder().listFeaturesSettings();
    }

    /** Returns the builder for the settings used for calls to getMembership. */
    public UnaryCallSettings.Builder<GetMembershipRequest, Membership> getMembershipSettings() {
      return getStubSettingsBuilder().getMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getStubSettingsBuilder().getFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public UnaryCallSettings.Builder<CreateMembershipRequest, Operation>
        createMembershipSettings() {
      return getStubSettingsBuilder().createMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to createMembership. */
    public OperationCallSettings.Builder<CreateMembershipRequest, Membership, OperationMetadata>
        createMembershipOperationSettings() {
      return getStubSettingsBuilder().createMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return getStubSettingsBuilder().createFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public OperationCallSettings.Builder<CreateFeatureRequest, Feature, OperationMetadata>
        createFeatureOperationSettings() {
      return getStubSettingsBuilder().createFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public UnaryCallSettings.Builder<DeleteMembershipRequest, Operation>
        deleteMembershipSettings() {
      return getStubSettingsBuilder().deleteMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembership. */
    public OperationCallSettings.Builder<DeleteMembershipRequest, Empty, OperationMetadata>
        deleteMembershipOperationSettings() {
      return getStubSettingsBuilder().deleteMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return getStubSettingsBuilder().deleteFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, OperationMetadata>
        deleteFeatureOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public UnaryCallSettings.Builder<UpdateMembershipRequest, Operation>
        updateMembershipSettings() {
      return getStubSettingsBuilder().updateMembershipSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembership. */
    public OperationCallSettings.Builder<UpdateMembershipRequest, Membership, OperationMetadata>
        updateMembershipOperationSettings() {
      return getStubSettingsBuilder().updateMembershipOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings() {
      return getStubSettingsBuilder().updateFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public OperationCallSettings.Builder<UpdateFeatureRequest, Feature, OperationMetadata>
        updateFeatureOperationSettings() {
      return getStubSettingsBuilder().updateFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateConnectManifest. */
    public UnaryCallSettings.Builder<
            GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestSettings() {
      return getStubSettingsBuilder().generateConnectManifestSettings();
    }

    /** Returns the builder for the settings used for calls to createFleet. */
    public UnaryCallSettings.Builder<CreateFleetRequest, Operation> createFleetSettings() {
      return getStubSettingsBuilder().createFleetSettings();
    }

    /** Returns the builder for the settings used for calls to createFleet. */
    public OperationCallSettings.Builder<CreateFleetRequest, Fleet, OperationMetadata>
        createFleetOperationSettings() {
      return getStubSettingsBuilder().createFleetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFleet. */
    public UnaryCallSettings.Builder<GetFleetRequest, Fleet> getFleetSettings() {
      return getStubSettingsBuilder().getFleetSettings();
    }

    /** Returns the builder for the settings used for calls to updateFleet. */
    public UnaryCallSettings.Builder<UpdateFleetRequest, Operation> updateFleetSettings() {
      return getStubSettingsBuilder().updateFleetSettings();
    }

    /** Returns the builder for the settings used for calls to updateFleet. */
    public OperationCallSettings.Builder<UpdateFleetRequest, Fleet, OperationMetadata>
        updateFleetOperationSettings() {
      return getStubSettingsBuilder().updateFleetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFleet. */
    public UnaryCallSettings.Builder<DeleteFleetRequest, Operation> deleteFleetSettings() {
      return getStubSettingsBuilder().deleteFleetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFleet. */
    public OperationCallSettings.Builder<DeleteFleetRequest, Empty, OperationMetadata>
        deleteFleetOperationSettings() {
      return getStubSettingsBuilder().deleteFleetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listFleets. */
    public PagedCallSettings.Builder<ListFleetsRequest, ListFleetsResponse, ListFleetsPagedResponse>
        listFleetsSettings() {
      return getStubSettingsBuilder().listFleetsSettings();
    }

    /** Returns the builder for the settings used for calls to getScopeNamespace. */
    public UnaryCallSettings.Builder<GetScopeNamespaceRequest, Namespace>
        getScopeNamespaceSettings() {
      return getStubSettingsBuilder().getScopeNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to createScopeNamespace. */
    public UnaryCallSettings.Builder<CreateScopeNamespaceRequest, Operation>
        createScopeNamespaceSettings() {
      return getStubSettingsBuilder().createScopeNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to createScopeNamespace. */
    public OperationCallSettings.Builder<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
        createScopeNamespaceOperationSettings() {
      return getStubSettingsBuilder().createScopeNamespaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateScopeNamespace. */
    public UnaryCallSettings.Builder<UpdateScopeNamespaceRequest, Operation>
        updateScopeNamespaceSettings() {
      return getStubSettingsBuilder().updateScopeNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateScopeNamespace. */
    public OperationCallSettings.Builder<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
        updateScopeNamespaceOperationSettings() {
      return getStubSettingsBuilder().updateScopeNamespaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScopeNamespace. */
    public UnaryCallSettings.Builder<DeleteScopeNamespaceRequest, Operation>
        deleteScopeNamespaceSettings() {
      return getStubSettingsBuilder().deleteScopeNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScopeNamespace. */
    public OperationCallSettings.Builder<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
        deleteScopeNamespaceOperationSettings() {
      return getStubSettingsBuilder().deleteScopeNamespaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listScopeNamespaces. */
    public PagedCallSettings.Builder<
            ListScopeNamespacesRequest,
            ListScopeNamespacesResponse,
            ListScopeNamespacesPagedResponse>
        listScopeNamespacesSettings() {
      return getStubSettingsBuilder().listScopeNamespacesSettings();
    }

    /** Returns the builder for the settings used for calls to getScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
        getScopeRBACRoleBindingSettings() {
      return getStubSettingsBuilder().getScopeRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<CreateScopeRBACRoleBindingRequest, Operation>
        createScopeRBACRoleBindingSettings() {
      return getStubSettingsBuilder().createScopeRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createScopeRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().createScopeRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<UpdateScopeRBACRoleBindingRequest, Operation>
        updateScopeRBACRoleBindingSettings() {
      return getStubSettingsBuilder().updateScopeRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateScopeRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().updateScopeRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScopeRBACRoleBinding. */
    public UnaryCallSettings.Builder<DeleteScopeRBACRoleBindingRequest, Operation>
        deleteScopeRBACRoleBindingSettings() {
      return getStubSettingsBuilder().deleteScopeRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScopeRBACRoleBinding. */
    public OperationCallSettings.Builder<
            DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteScopeRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().deleteScopeRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listScopeRBACRoleBindings. */
    public PagedCallSettings.Builder<
            ListScopeRBACRoleBindingsRequest,
            ListScopeRBACRoleBindingsResponse,
            ListScopeRBACRoleBindingsPagedResponse>
        listScopeRBACRoleBindingsSettings() {
      return getStubSettingsBuilder().listScopeRBACRoleBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getScope. */
    public UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings() {
      return getStubSettingsBuilder().getScopeSettings();
    }

    /** Returns the builder for the settings used for calls to createScope. */
    public UnaryCallSettings.Builder<CreateScopeRequest, Operation> createScopeSettings() {
      return getStubSettingsBuilder().createScopeSettings();
    }

    /** Returns the builder for the settings used for calls to createScope. */
    public OperationCallSettings.Builder<CreateScopeRequest, Scope, OperationMetadata>
        createScopeOperationSettings() {
      return getStubSettingsBuilder().createScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public UnaryCallSettings.Builder<UpdateScopeRequest, Operation> updateScopeSettings() {
      return getStubSettingsBuilder().updateScopeSettings();
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public OperationCallSettings.Builder<UpdateScopeRequest, Scope, OperationMetadata>
        updateScopeOperationSettings() {
      return getStubSettingsBuilder().updateScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScope. */
    public UnaryCallSettings.Builder<DeleteScopeRequest, Operation> deleteScopeSettings() {
      return getStubSettingsBuilder().deleteScopeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScope. */
    public OperationCallSettings.Builder<DeleteScopeRequest, Empty, OperationMetadata>
        deleteScopeOperationSettings() {
      return getStubSettingsBuilder().deleteScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listScopes. */
    public PagedCallSettings.Builder<ListScopesRequest, ListScopesResponse, ListScopesPagedResponse>
        listScopesSettings() {
      return getStubSettingsBuilder().listScopesSettings();
    }

    /** Returns the builder for the settings used for calls to listPermittedScopes. */
    public PagedCallSettings.Builder<
            ListPermittedScopesRequest,
            ListPermittedScopesResponse,
            ListPermittedScopesPagedResponse>
        listPermittedScopesSettings() {
      return getStubSettingsBuilder().listPermittedScopesSettings();
    }

    /** Returns the builder for the settings used for calls to getMembershipBinding. */
    public UnaryCallSettings.Builder<GetMembershipBindingRequest, MembershipBinding>
        getMembershipBindingSettings() {
      return getStubSettingsBuilder().getMembershipBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createMembershipBinding. */
    public UnaryCallSettings.Builder<CreateMembershipBindingRequest, Operation>
        createMembershipBindingSettings() {
      return getStubSettingsBuilder().createMembershipBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createMembershipBinding. */
    public OperationCallSettings.Builder<
            CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        createMembershipBindingOperationSettings() {
      return getStubSettingsBuilder().createMembershipBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembershipBinding. */
    public UnaryCallSettings.Builder<UpdateMembershipBindingRequest, Operation>
        updateMembershipBindingSettings() {
      return getStubSettingsBuilder().updateMembershipBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembershipBinding. */
    public OperationCallSettings.Builder<
            UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
        updateMembershipBindingOperationSettings() {
      return getStubSettingsBuilder().updateMembershipBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembershipBinding. */
    public UnaryCallSettings.Builder<DeleteMembershipBindingRequest, Operation>
        deleteMembershipBindingSettings() {
      return getStubSettingsBuilder().deleteMembershipBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembershipBinding. */
    public OperationCallSettings.Builder<DeleteMembershipBindingRequest, Empty, OperationMetadata>
        deleteMembershipBindingOperationSettings() {
      return getStubSettingsBuilder().deleteMembershipBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMembershipBindings. */
    public PagedCallSettings.Builder<
            ListMembershipBindingsRequest,
            ListMembershipBindingsResponse,
            ListMembershipBindingsPagedResponse>
        listMembershipBindingsSettings() {
      return getStubSettingsBuilder().listMembershipBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
        getMembershipRBACRoleBindingSettings() {
      return getStubSettingsBuilder().getMembershipRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<CreateMembershipRBACRoleBindingRequest, Operation>
        createMembershipRBACRoleBindingSettings() {
      return getStubSettingsBuilder().createMembershipRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        createMembershipRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().createMembershipRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<UpdateMembershipRBACRoleBindingRequest, Operation>
        updateMembershipRBACRoleBindingSettings() {
      return getStubSettingsBuilder().updateMembershipRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
        updateMembershipRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().updateMembershipRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembershipRBACRoleBinding. */
    public UnaryCallSettings.Builder<DeleteMembershipRBACRoleBindingRequest, Operation>
        deleteMembershipRBACRoleBindingSettings() {
      return getStubSettingsBuilder().deleteMembershipRBACRoleBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMembershipRBACRoleBinding. */
    public OperationCallSettings.Builder<
            DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
        deleteMembershipRBACRoleBindingOperationSettings() {
      return getStubSettingsBuilder().deleteMembershipRBACRoleBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMembershipRBACRoleBindings. */
    public PagedCallSettings.Builder<
            ListMembershipRBACRoleBindingsRequest,
            ListMembershipRBACRoleBindingsResponse,
            ListMembershipRBACRoleBindingsPagedResponse>
        listMembershipRBACRoleBindingsSettings() {
      return getStubSettingsBuilder().listMembershipRBACRoleBindingsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateMembershipRBACRoleBindingYAML.
     */
    public UnaryCallSettings.Builder<
            GenerateMembershipRBACRoleBindingYAMLRequest,
            GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAMLSettings() {
      return getStubSettingsBuilder().generateMembershipRBACRoleBindingYAMLSettings();
    }

    @Override
    public GkeHubSettings build() throws IOException {
      return new GkeHubSettings(this);
    }
  }
}
