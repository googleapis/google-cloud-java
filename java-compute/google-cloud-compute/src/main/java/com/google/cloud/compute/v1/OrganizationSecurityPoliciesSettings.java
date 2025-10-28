/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.OrganizationSecurityPoliciesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.OrganizationSecurityPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrganizationSecurityPoliciesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityPoliciesSettings.Builder organizationSecurityPoliciesSettingsBuilder =
 *     OrganizationSecurityPoliciesSettings.newBuilder();
 * organizationSecurityPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         organizationSecurityPoliciesSettingsBuilder
 *             .getSettings()
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
 * OrganizationSecurityPoliciesSettings organizationSecurityPoliciesSettings =
 *     organizationSecurityPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for addAssociation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityPoliciesSettings.Builder organizationSecurityPoliciesSettingsBuilder =
 *     OrganizationSecurityPoliciesSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * organizationSecurityPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrganizationSecurityPoliciesSettings
    extends ClientSettings<OrganizationSecurityPoliciesSettings> {

  /** Returns the object with the settings used for calls to addAssociation. */
  public UnaryCallSettings<AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).addAssociationSettings();
  }

  /** Returns the object with the settings used for calls to addAssociation. */
  public OperationCallSettings<
          AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      addAssociationOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .addAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleOrganizationSecurityPolicyRequest, Operation> addRuleSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to copyRules. */
  public UnaryCallSettings<CopyRulesOrganizationSecurityPolicyRequest, Operation>
      copyRulesSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).copyRulesSettings();
  }

  /** Returns the object with the settings used for calls to copyRules. */
  public OperationCallSettings<CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
      copyRulesOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .copyRulesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteOrganizationSecurityPolicyRequest, Operation> deleteSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetOrganizationSecurityPolicyRequest, SecurityPolicy> getSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getAssociation. */
  public UnaryCallSettings<
          GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).getAssociationSettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertOrganizationSecurityPolicyRequest, Operation> insertSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertOrganizationSecurityPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listAssociations. */
  public UnaryCallSettings<
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .listAssociationsSettings();
  }

  /** Returns the object with the settings used for calls to listPreconfiguredExpressionSets. */
  public UnaryCallSettings<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .listPreconfiguredExpressionSetsSettings();
  }

  /** Returns the object with the settings used for calls to move. */
  public UnaryCallSettings<MoveOrganizationSecurityPolicyRequest, Operation> moveSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).moveSettings();
  }

  /** Returns the object with the settings used for calls to move. */
  public OperationCallSettings<MoveOrganizationSecurityPolicyRequest, Operation, Operation>
      moveOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).moveOperationSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchOrganizationSecurityPolicyRequest, Operation> patchSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchOrganizationSecurityPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleOrganizationSecurityPolicyRequest, Operation>
      patchRuleSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public UnaryCallSettings<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .removeAssociationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public OperationCallSettings<
          RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .removeAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
      removeRuleSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((OrganizationSecurityPoliciesStubSettings) getStubSettings())
        .removeRuleOperationSettings();
  }

  public static final OrganizationSecurityPoliciesSettings create(
      OrganizationSecurityPoliciesStubSettings stub) throws IOException {
    return new OrganizationSecurityPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrganizationSecurityPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrganizationSecurityPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrganizationSecurityPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrganizationSecurityPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OrganizationSecurityPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrganizationSecurityPoliciesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrganizationSecurityPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected OrganizationSecurityPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrganizationSecurityPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<OrganizationSecurityPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OrganizationSecurityPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrganizationSecurityPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrganizationSecurityPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrganizationSecurityPoliciesStubSettings.newBuilder());
    }

    public OrganizationSecurityPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((OrganizationSecurityPoliciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addAssociation. */
    public UnaryCallSettings.Builder<AddAssociationOrganizationSecurityPolicyRequest, Operation>
        addAssociationSettings() {
      return getStubSettingsBuilder().addAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to addAssociation. */
    public OperationCallSettings.Builder<
            AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
        addAssociationOperationSettings() {
      return getStubSettingsBuilder().addAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleOrganizationSecurityPolicyRequest, Operation>
        addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<
            AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to copyRules. */
    public UnaryCallSettings.Builder<CopyRulesOrganizationSecurityPolicyRequest, Operation>
        copyRulesSettings() {
      return getStubSettingsBuilder().copyRulesSettings();
    }

    /** Returns the builder for the settings used for calls to copyRules. */
    public OperationCallSettings.Builder<
            CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
        copyRulesOperationSettings() {
      return getStubSettingsBuilder().copyRulesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteOrganizationSecurityPolicyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetOrganizationSecurityPolicyRequest, SecurityPolicy>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getAssociation. */
    public UnaryCallSettings.Builder<
            GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
        getAssociationSettings() {
      return getStubSettingsBuilder().getAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertOrganizationSecurityPolicyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertOrganizationSecurityPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listAssociations. */
    public UnaryCallSettings.Builder<
            ListAssociationsOrganizationSecurityPolicyRequest,
            OrganizationSecurityPoliciesListAssociationsResponse>
        listAssociationsSettings() {
      return getStubSettingsBuilder().listAssociationsSettings();
    }

    /** Returns the builder for the settings used for calls to listPreconfiguredExpressionSets. */
    public UnaryCallSettings.Builder<
            ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsSettings() {
      return getStubSettingsBuilder().listPreconfiguredExpressionSetsSettings();
    }

    /** Returns the builder for the settings used for calls to move. */
    public UnaryCallSettings.Builder<MoveOrganizationSecurityPolicyRequest, Operation>
        moveSettings() {
      return getStubSettingsBuilder().moveSettings();
    }

    /** Returns the builder for the settings used for calls to move. */
    public OperationCallSettings.Builder<
            MoveOrganizationSecurityPolicyRequest, Operation, Operation>
        moveOperationSettings() {
      return getStubSettingsBuilder().moveOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchOrganizationSecurityPolicyRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<
            PatchOrganizationSecurityPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleOrganizationSecurityPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<
            PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public UnaryCallSettings.Builder<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
        removeAssociationSettings() {
      return getStubSettingsBuilder().removeAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public OperationCallSettings.Builder<
            RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings() {
      return getStubSettingsBuilder().removeAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    @Override
    public OrganizationSecurityPoliciesSettings build() throws IOException {
      return new OrganizationSecurityPoliciesSettings(this);
    }
  }
}
