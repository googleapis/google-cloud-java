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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.FlowsClient.ListFlowsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3beta1.stub.FlowsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FlowsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createFlow to 30 seconds:
 *
 * <pre>{@code
 * FlowsSettings.Builder flowsSettingsBuilder = FlowsSettings.newBuilder();
 * flowsSettingsBuilder
 *     .createFlowSettings()
 *     .setRetrySettings(
 *         flowsSettingsBuilder
 *             .createFlowSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FlowsSettings flowsSettings = flowsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FlowsSettings extends ClientSettings<FlowsSettings> {

  /** Returns the object with the settings used for calls to createFlow. */
  public UnaryCallSettings<CreateFlowRequest, Flow> createFlowSettings() {
    return ((FlowsStubSettings) getStubSettings()).createFlowSettings();
  }

  /** Returns the object with the settings used for calls to deleteFlow. */
  public UnaryCallSettings<DeleteFlowRequest, Empty> deleteFlowSettings() {
    return ((FlowsStubSettings) getStubSettings()).deleteFlowSettings();
  }

  /** Returns the object with the settings used for calls to listFlows. */
  public PagedCallSettings<ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
      listFlowsSettings() {
    return ((FlowsStubSettings) getStubSettings()).listFlowsSettings();
  }

  /** Returns the object with the settings used for calls to getFlow. */
  public UnaryCallSettings<GetFlowRequest, Flow> getFlowSettings() {
    return ((FlowsStubSettings) getStubSettings()).getFlowSettings();
  }

  /** Returns the object with the settings used for calls to updateFlow. */
  public UnaryCallSettings<UpdateFlowRequest, Flow> updateFlowSettings() {
    return ((FlowsStubSettings) getStubSettings()).updateFlowSettings();
  }

  /** Returns the object with the settings used for calls to trainFlow. */
  public UnaryCallSettings<TrainFlowRequest, Operation> trainFlowSettings() {
    return ((FlowsStubSettings) getStubSettings()).trainFlowSettings();
  }

  /** Returns the object with the settings used for calls to trainFlow. */
  public OperationCallSettings<TrainFlowRequest, Empty, Struct> trainFlowOperationSettings() {
    return ((FlowsStubSettings) getStubSettings()).trainFlowOperationSettings();
  }

  public static final FlowsSettings create(FlowsStubSettings stub) throws IOException {
    return new FlowsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FlowsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FlowsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FlowsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FlowsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FlowsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FlowsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FlowsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FlowsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FlowsSettings. */
  public static class Builder extends ClientSettings.Builder<FlowsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FlowsStubSettings.newBuilder(clientContext));
    }

    protected Builder(FlowsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FlowsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FlowsStubSettings.newBuilder());
    }

    public FlowsStubSettings.Builder getStubSettingsBuilder() {
      return ((FlowsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFlow. */
    public UnaryCallSettings.Builder<CreateFlowRequest, Flow> createFlowSettings() {
      return getStubSettingsBuilder().createFlowSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFlow. */
    public UnaryCallSettings.Builder<DeleteFlowRequest, Empty> deleteFlowSettings() {
      return getStubSettingsBuilder().deleteFlowSettings();
    }

    /** Returns the builder for the settings used for calls to listFlows. */
    public PagedCallSettings.Builder<ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
        listFlowsSettings() {
      return getStubSettingsBuilder().listFlowsSettings();
    }

    /** Returns the builder for the settings used for calls to getFlow. */
    public UnaryCallSettings.Builder<GetFlowRequest, Flow> getFlowSettings() {
      return getStubSettingsBuilder().getFlowSettings();
    }

    /** Returns the builder for the settings used for calls to updateFlow. */
    public UnaryCallSettings.Builder<UpdateFlowRequest, Flow> updateFlowSettings() {
      return getStubSettingsBuilder().updateFlowSettings();
    }

    /** Returns the builder for the settings used for calls to trainFlow. */
    public UnaryCallSettings.Builder<TrainFlowRequest, Operation> trainFlowSettings() {
      return getStubSettingsBuilder().trainFlowSettings();
    }

    /** Returns the builder for the settings used for calls to trainFlow. */
    public OperationCallSettings.Builder<TrainFlowRequest, Empty, Struct>
        trainFlowOperationSettings() {
      return getStubSettingsBuilder().trainFlowOperationSettings();
    }

    @Override
    public FlowsSettings build() throws IOException {
      return new FlowsSettings(this);
    }
  }
}
