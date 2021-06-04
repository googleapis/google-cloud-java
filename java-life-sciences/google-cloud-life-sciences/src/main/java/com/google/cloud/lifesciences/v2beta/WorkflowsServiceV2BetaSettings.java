/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.lifesciences.v2beta;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.lifesciences.v2beta.stub.WorkflowsServiceV2BetaStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkflowsServiceV2BetaClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (lifesciences.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of runPipeline to 30 seconds:
 *
 * <pre>{@code
 * WorkflowsServiceV2BetaSettings.Builder workflowsServiceV2BetaSettingsBuilder =
 *     WorkflowsServiceV2BetaSettings.newBuilder();
 * workflowsServiceV2BetaSettingsBuilder
 *     .runPipelineSettings()
 *     .setRetrySettings(
 *         workflowsServiceV2BetaSettingsBuilder
 *             .runPipelineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkflowsServiceV2BetaSettings workflowsServiceV2BetaSettings =
 *     workflowsServiceV2BetaSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkflowsServiceV2BetaSettings extends ClientSettings<WorkflowsServiceV2BetaSettings> {

  /** Returns the object with the settings used for calls to runPipeline. */
  public UnaryCallSettings<RunPipelineRequest, Operation> runPipelineSettings() {
    return ((WorkflowsServiceV2BetaStubSettings) getStubSettings()).runPipelineSettings();
  }

  /** Returns the object with the settings used for calls to runPipeline. */
  public OperationCallSettings<RunPipelineRequest, RunPipelineResponse, Metadata>
      runPipelineOperationSettings() {
    return ((WorkflowsServiceV2BetaStubSettings) getStubSettings()).runPipelineOperationSettings();
  }

  public static final WorkflowsServiceV2BetaSettings create(WorkflowsServiceV2BetaStubSettings stub)
      throws IOException {
    return new WorkflowsServiceV2BetaSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkflowsServiceV2BetaStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkflowsServiceV2BetaStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkflowsServiceV2BetaStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkflowsServiceV2BetaStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkflowsServiceV2BetaStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkflowsServiceV2BetaStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkflowsServiceV2BetaStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WorkflowsServiceV2BetaSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkflowsServiceV2BetaSettings. */
  public static class Builder
      extends ClientSettings.Builder<WorkflowsServiceV2BetaSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkflowsServiceV2BetaStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkflowsServiceV2BetaSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkflowsServiceV2BetaStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkflowsServiceV2BetaStubSettings.newBuilder());
    }

    public WorkflowsServiceV2BetaStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkflowsServiceV2BetaStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to runPipeline. */
    public UnaryCallSettings.Builder<RunPipelineRequest, Operation> runPipelineSettings() {
      return getStubSettingsBuilder().runPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to runPipeline. */
    public OperationCallSettings.Builder<RunPipelineRequest, RunPipelineResponse, Metadata>
        runPipelineOperationSettings() {
      return getStubSettingsBuilder().runPipelineOperationSettings();
    }

    @Override
    public WorkflowsServiceV2BetaSettings build() throws IOException {
      return new WorkflowsServiceV2BetaSettings(this);
    }
  }
}
