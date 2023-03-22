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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SecurityPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.stub.SecurityPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityPoliciesClient}.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityPoliciesSettings.Builder securityPoliciesSettingsBuilder =
 *     SecurityPoliciesSettings.newBuilder();
 * securityPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         securityPoliciesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityPoliciesSettings securityPoliciesSettings = securityPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityPoliciesSettings extends ClientSettings<SecurityPoliciesSettings> {

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleSecurityPolicyRequest, Operation> addRuleSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleSecurityPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListSecurityPoliciesRequest,
          SecurityPoliciesAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteSecurityPolicyRequest, Operation> deleteSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteSecurityPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetSecurityPolicyRequest, SecurityPolicy> getSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertSecurityPolicyRequest, Operation> insertSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertSecurityPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listPreconfiguredExpressionSets. */
  public UnaryCallSettings<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings())
        .listPreconfiguredExpressionSetsSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchSecurityPolicyRequest, Operation> patchSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchSecurityPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleSecurityPolicyRequest, Operation> patchRuleSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleSecurityPolicyRequest, Operation> removeRuleSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).removeRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsSecurityPolicyRequest, Operation> setLabelsSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsSecurityPolicyRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return ((SecurityPoliciesStubSettings) getStubSettings()).setLabelsOperationSettings();
  }

  public static final SecurityPoliciesSettings create(SecurityPoliciesStubSettings stub)
      throws IOException {
    return new SecurityPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecurityPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecurityPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecurityPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecurityPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecurityPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecurityPoliciesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecurityPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecurityPoliciesSettings. */
  public static class Builder extends ClientSettings.Builder<SecurityPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecurityPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecurityPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecurityPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecurityPoliciesStubSettings.newBuilder());
    }

    public SecurityPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((SecurityPoliciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleSecurityPolicyRequest, Operation> addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleSecurityPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListSecurityPoliciesRequest,
            SecurityPoliciesAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteSecurityPolicyRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteSecurityPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetSecurityPolicyRequest, SecurityPolicy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertSecurityPolicyRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertSecurityPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listPreconfiguredExpressionSets. */
    public UnaryCallSettings.Builder<
            ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsSettings() {
      return getStubSettingsBuilder().listPreconfiguredExpressionSetsSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchSecurityPolicyRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchSecurityPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleSecurityPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<PatchRuleSecurityPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleSecurityPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<RemoveRuleSecurityPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsSecurityPolicyRequest, Operation>
        setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public OperationCallSettings.Builder<SetLabelsSecurityPolicyRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return getStubSettingsBuilder().setLabelsOperationSettings();
    }

    @Override
    public SecurityPoliciesSettings build() throws IOException {
      return new SecurityPoliciesSettings(this);
    }
  }
}
