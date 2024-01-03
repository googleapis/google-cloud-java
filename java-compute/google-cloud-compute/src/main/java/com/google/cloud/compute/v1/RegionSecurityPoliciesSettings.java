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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionSecurityPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionSecurityPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionSecurityPoliciesClient}.
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
 * RegionSecurityPoliciesSettings.Builder regionSecurityPoliciesSettingsBuilder =
 *     RegionSecurityPoliciesSettings.newBuilder();
 * regionSecurityPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionSecurityPoliciesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionSecurityPoliciesSettings regionSecurityPoliciesSettings =
 *     regionSecurityPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionSecurityPoliciesSettings extends ClientSettings<RegionSecurityPoliciesSettings> {

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleRegionSecurityPolicyRequest, Operation> addRuleSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionSecurityPolicyRequest, Operation> deleteSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionSecurityPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionSecurityPolicyRequest, SecurityPolicy> getSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
      getRuleSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionSecurityPolicyRequest, Operation> insertSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionSecurityPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
      listSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionSecurityPolicyRequest, Operation> patchSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation> patchRuleSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation> removeRuleSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((RegionSecurityPoliciesStubSettings) getStubSettings()).removeRuleOperationSettings();
  }

  public static final RegionSecurityPoliciesSettings create(RegionSecurityPoliciesStubSettings stub)
      throws IOException {
    return new RegionSecurityPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionSecurityPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionSecurityPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionSecurityPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionSecurityPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionSecurityPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionSecurityPoliciesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionSecurityPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionSecurityPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionSecurityPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionSecurityPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionSecurityPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionSecurityPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionSecurityPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionSecurityPoliciesStubSettings.newBuilder());
    }

    public RegionSecurityPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionSecurityPoliciesStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<AddRuleRegionSecurityPolicyRequest, Operation>
        addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionSecurityPolicyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionSecurityPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionSecurityPolicyRequest, SecurityPolicy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionSecurityPolicyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionSecurityPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionSecurityPoliciesRequest, SecurityPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionSecurityPolicyRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionSecurityPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleRegionSecurityPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleRegionSecurityPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    @Override
    public RegionSecurityPoliciesSettings build() throws IOException {
      return new RegionSecurityPoliciesSettings(this);
    }
  }
}
