/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.ForwardingRuleClient.AggregatedListForwardingRulesPagedResponse;
import static com.google.cloud.compute.v1.ForwardingRuleClient.ListForwardingRulesPagedResponse;

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
import com.google.cloud.compute.v1.stub.ForwardingRuleStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ForwardingRuleClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteForwardingRule to 30 seconds:
 *
 * <pre>
 * <code>
 * ForwardingRuleSettings.Builder forwardingRuleSettingsBuilder =
 *     ForwardingRuleSettings.newBuilder();
 * forwardingRuleSettingsBuilder.deleteForwardingRuleSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ForwardingRuleSettings forwardingRuleSettings = forwardingRuleSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ForwardingRuleSettings extends ClientSettings<ForwardingRuleSettings> {
  /** Returns the object with the settings used for calls to aggregatedListForwardingRules. */
  public PagedCallSettings<
          AggregatedListForwardingRulesHttpRequest,
          ForwardingRuleAggregatedList,
          AggregatedListForwardingRulesPagedResponse>
      aggregatedListForwardingRulesSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).aggregatedListForwardingRulesSettings();
  }

  /** Returns the object with the settings used for calls to deleteForwardingRule. */
  public UnaryCallSettings<DeleteForwardingRuleHttpRequest, Operation>
      deleteForwardingRuleSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).deleteForwardingRuleSettings();
  }

  /** Returns the object with the settings used for calls to getForwardingRule. */
  public UnaryCallSettings<GetForwardingRuleHttpRequest, ForwardingRule>
      getForwardingRuleSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).getForwardingRuleSettings();
  }

  /** Returns the object with the settings used for calls to insertForwardingRule. */
  public UnaryCallSettings<InsertForwardingRuleHttpRequest, Operation>
      insertForwardingRuleSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).insertForwardingRuleSettings();
  }

  /** Returns the object with the settings used for calls to listForwardingRules. */
  public PagedCallSettings<
          ListForwardingRulesHttpRequest, ForwardingRuleList, ListForwardingRulesPagedResponse>
      listForwardingRulesSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).listForwardingRulesSettings();
  }

  /** Returns the object with the settings used for calls to setTargetForwardingRule. */
  public UnaryCallSettings<SetTargetForwardingRuleHttpRequest, Operation>
      setTargetForwardingRuleSettings() {
    return ((ForwardingRuleStubSettings) getStubSettings()).setTargetForwardingRuleSettings();
  }

  public static final ForwardingRuleSettings create(ForwardingRuleStubSettings stub)
      throws IOException {
    return new ForwardingRuleSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ForwardingRuleStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ForwardingRuleStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ForwardingRuleStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ForwardingRuleStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ForwardingRuleStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ForwardingRuleStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ForwardingRuleStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ForwardingRuleStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ForwardingRuleSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ForwardingRuleSettings. */
  public static class Builder extends ClientSettings.Builder<ForwardingRuleSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ForwardingRuleStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ForwardingRuleStubSettings.newBuilder());
    }

    protected Builder(ForwardingRuleSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ForwardingRuleStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ForwardingRuleStubSettings.Builder getStubSettingsBuilder() {
      return ((ForwardingRuleStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListForwardingRules. */
    public PagedCallSettings.Builder<
            AggregatedListForwardingRulesHttpRequest,
            ForwardingRuleAggregatedList,
            AggregatedListForwardingRulesPagedResponse>
        aggregatedListForwardingRulesSettings() {
      return getStubSettingsBuilder().aggregatedListForwardingRulesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteForwardingRule. */
    public UnaryCallSettings.Builder<DeleteForwardingRuleHttpRequest, Operation>
        deleteForwardingRuleSettings() {
      return getStubSettingsBuilder().deleteForwardingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to getForwardingRule. */
    public UnaryCallSettings.Builder<GetForwardingRuleHttpRequest, ForwardingRule>
        getForwardingRuleSettings() {
      return getStubSettingsBuilder().getForwardingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insertForwardingRule. */
    public UnaryCallSettings.Builder<InsertForwardingRuleHttpRequest, Operation>
        insertForwardingRuleSettings() {
      return getStubSettingsBuilder().insertForwardingRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listForwardingRules. */
    public PagedCallSettings.Builder<
            ListForwardingRulesHttpRequest, ForwardingRuleList, ListForwardingRulesPagedResponse>
        listForwardingRulesSettings() {
      return getStubSettingsBuilder().listForwardingRulesSettings();
    }

    /** Returns the builder for the settings used for calls to setTargetForwardingRule. */
    public UnaryCallSettings.Builder<SetTargetForwardingRuleHttpRequest, Operation>
        setTargetForwardingRuleSettings() {
      return getStubSettingsBuilder().setTargetForwardingRuleSettings();
    }

    @Override
    public ForwardingRuleSettings build() throws IOException {
      return new ForwardingRuleSettings(this);
    }
  }
}
