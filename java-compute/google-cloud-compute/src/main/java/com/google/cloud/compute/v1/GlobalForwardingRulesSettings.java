/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.GlobalForwardingRulesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.GlobalForwardingRulesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link GlobalForwardingRulesClient}.
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
 * <p>For example, to set the total timeout of delete to 30 seconds:
 *
 * <pre>
 * <code>
 * GlobalForwardingRulesSettings.Builder globalForwardingRulesSettingsBuilder =
 *     GlobalForwardingRulesSettings.newBuilder();
 * globalForwardingRulesSettingsBuilder
 *     .deleteSettings()
 *     .setRetrySettings(
 *         globalForwardingRulesSettingsBuilder.deleteSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GlobalForwardingRulesSettings globalForwardingRulesSettings = globalForwardingRulesSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalForwardingRulesSettings extends ClientSettings<GlobalForwardingRulesSettings> {
  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteGlobalForwardingRuleRequest, Operation> deleteSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetGlobalForwardingRuleRequest, ForwardingRule> getSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertGlobalForwardingRuleRequest, Operation> insertSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
      listSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchGlobalForwardingRuleRequest, Operation> patchSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setTarget. */
  public UnaryCallSettings<SetTargetGlobalForwardingRuleRequest, Operation> setTargetSettings() {
    return ((GlobalForwardingRulesStubSettings) getStubSettings()).setTargetSettings();
  }

  public static final GlobalForwardingRulesSettings create(GlobalForwardingRulesStubSettings stub)
      throws IOException {
    return new GlobalForwardingRulesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GlobalForwardingRulesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GlobalForwardingRulesStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return GlobalForwardingRulesStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GlobalForwardingRulesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GlobalForwardingRulesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GlobalForwardingRulesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GlobalForwardingRulesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GlobalForwardingRulesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GlobalForwardingRulesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GlobalForwardingRulesSettings. */
  public static class Builder
      extends ClientSettings.Builder<GlobalForwardingRulesSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(GlobalForwardingRulesStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(GlobalForwardingRulesStubSettings.newBuilder());
    }

    protected Builder(GlobalForwardingRulesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GlobalForwardingRulesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public GlobalForwardingRulesStubSettings.Builder getStubSettingsBuilder() {
      return ((GlobalForwardingRulesStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteGlobalForwardingRuleRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetGlobalForwardingRuleRequest, ForwardingRule> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertGlobalForwardingRuleRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListGlobalForwardingRulesRequest, ForwardingRuleList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchGlobalForwardingRuleRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsGlobalForwardingRuleRequest, Operation>
        setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setTarget. */
    public UnaryCallSettings.Builder<SetTargetGlobalForwardingRuleRequest, Operation>
        setTargetSettings() {
      return getStubSettingsBuilder().setTargetSettings();
    }

    @Override
    public GlobalForwardingRulesSettings build() throws IOException {
      return new GlobalForwardingRulesSettings(this);
    }
  }
}
