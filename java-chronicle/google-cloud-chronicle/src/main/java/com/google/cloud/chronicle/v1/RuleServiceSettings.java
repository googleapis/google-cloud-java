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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

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
import com.google.cloud.chronicle.v1.stub.RuleServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RuleServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createRule:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleServiceSettings.Builder ruleServiceSettingsBuilder = RuleServiceSettings.newBuilder();
 * ruleServiceSettingsBuilder
 *     .createRuleSettings()
 *     .setRetrySettings(
 *         ruleServiceSettingsBuilder
 *             .createRuleSettings()
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
 * RuleServiceSettings ruleServiceSettings = ruleServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createRetrohunt:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleServiceSettings.Builder ruleServiceSettingsBuilder = RuleServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * ruleServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RuleServiceSettings extends ClientSettings<RuleServiceSettings> {

  /** Returns the object with the settings used for calls to createRule. */
  public UnaryCallSettings<CreateRuleRequest, Rule> createRuleSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).createRuleSettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleRequest, Rule> getRuleSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to listRules. */
  public PagedCallSettings<ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
      listRulesSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).listRulesSettings();
  }

  /** Returns the object with the settings used for calls to updateRule. */
  public UnaryCallSettings<UpdateRuleRequest, Rule> updateRuleSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).updateRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteRule. */
  public UnaryCallSettings<DeleteRuleRequest, Empty> deleteRuleSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).deleteRuleSettings();
  }

  /** Returns the object with the settings used for calls to listRuleRevisions. */
  public PagedCallSettings<
          ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
      listRuleRevisionsSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).listRuleRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to createRetrohunt. */
  public UnaryCallSettings<CreateRetrohuntRequest, Operation> createRetrohuntSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).createRetrohuntSettings();
  }

  /** Returns the object with the settings used for calls to createRetrohunt. */
  public OperationCallSettings<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).createRetrohuntOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRetrohunt. */
  public UnaryCallSettings<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).getRetrohuntSettings();
  }

  /** Returns the object with the settings used for calls to listRetrohunts. */
  public PagedCallSettings<
          ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
      listRetrohuntsSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).listRetrohuntsSettings();
  }

  /** Returns the object with the settings used for calls to getRuleDeployment. */
  public UnaryCallSettings<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).getRuleDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listRuleDeployments. */
  public PagedCallSettings<
          ListRuleDeploymentsRequest, ListRuleDeploymentsResponse, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).listRuleDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to updateRuleDeployment. */
  public UnaryCallSettings<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentSettings() {
    return ((RuleServiceStubSettings) getStubSettings()).updateRuleDeploymentSettings();
  }

  public static final RuleServiceSettings create(RuleServiceStubSettings stub) throws IOException {
    return new RuleServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RuleServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RuleServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RuleServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RuleServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RuleServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RuleServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RuleServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RuleServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RuleServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RuleServiceSettings. */
  public static class Builder extends ClientSettings.Builder<RuleServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RuleServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(RuleServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RuleServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RuleServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(RuleServiceStubSettings.newHttpJsonBuilder());
    }

    public RuleServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RuleServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRule. */
    public UnaryCallSettings.Builder<CreateRuleRequest, Rule> createRuleSettings() {
      return getStubSettingsBuilder().createRuleSettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleRequest, Rule> getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listRules. */
    public PagedCallSettings.Builder<ListRulesRequest, ListRulesResponse, ListRulesPagedResponse>
        listRulesSettings() {
      return getStubSettingsBuilder().listRulesSettings();
    }

    /** Returns the builder for the settings used for calls to updateRule. */
    public UnaryCallSettings.Builder<UpdateRuleRequest, Rule> updateRuleSettings() {
      return getStubSettingsBuilder().updateRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRule. */
    public UnaryCallSettings.Builder<DeleteRuleRequest, Empty> deleteRuleSettings() {
      return getStubSettingsBuilder().deleteRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listRuleRevisions. */
    public PagedCallSettings.Builder<
            ListRuleRevisionsRequest, ListRuleRevisionsResponse, ListRuleRevisionsPagedResponse>
        listRuleRevisionsSettings() {
      return getStubSettingsBuilder().listRuleRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to createRetrohunt. */
    public UnaryCallSettings.Builder<CreateRetrohuntRequest, Operation> createRetrohuntSettings() {
      return getStubSettingsBuilder().createRetrohuntSettings();
    }

    /** Returns the builder for the settings used for calls to createRetrohunt. */
    public OperationCallSettings.Builder<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
        createRetrohuntOperationSettings() {
      return getStubSettingsBuilder().createRetrohuntOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRetrohunt. */
    public UnaryCallSettings.Builder<GetRetrohuntRequest, Retrohunt> getRetrohuntSettings() {
      return getStubSettingsBuilder().getRetrohuntSettings();
    }

    /** Returns the builder for the settings used for calls to listRetrohunts. */
    public PagedCallSettings.Builder<
            ListRetrohuntsRequest, ListRetrohuntsResponse, ListRetrohuntsPagedResponse>
        listRetrohuntsSettings() {
      return getStubSettingsBuilder().listRetrohuntsSettings();
    }

    /** Returns the builder for the settings used for calls to getRuleDeployment. */
    public UnaryCallSettings.Builder<GetRuleDeploymentRequest, RuleDeployment>
        getRuleDeploymentSettings() {
      return getStubSettingsBuilder().getRuleDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listRuleDeployments. */
    public PagedCallSettings.Builder<
            ListRuleDeploymentsRequest,
            ListRuleDeploymentsResponse,
            ListRuleDeploymentsPagedResponse>
        listRuleDeploymentsSettings() {
      return getStubSettingsBuilder().listRuleDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateRuleDeployment. */
    public UnaryCallSettings.Builder<UpdateRuleDeploymentRequest, RuleDeployment>
        updateRuleDeploymentSettings() {
      return getStubSettingsBuilder().updateRuleDeploymentSettings();
    }

    @Override
    public RuleServiceSettings build() throws IOException {
      return new RuleServiceSettings(this);
    }
  }
}
