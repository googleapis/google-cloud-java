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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListToolsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3beta1.stub.ToolsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ToolsClient}.
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
 * <p>For example, to set the total timeout of createTool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ToolsSettings.Builder toolsSettingsBuilder = ToolsSettings.newBuilder();
 * toolsSettingsBuilder
 *     .createToolSettings()
 *     .setRetrySettings(
 *         toolsSettingsBuilder
 *             .createToolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ToolsSettings toolsSettings = toolsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ToolsSettings extends ClientSettings<ToolsSettings> {

  /** Returns the object with the settings used for calls to createTool. */
  public UnaryCallSettings<CreateToolRequest, Tool> createToolSettings() {
    return ((ToolsStubSettings) getStubSettings()).createToolSettings();
  }

  /** Returns the object with the settings used for calls to listTools. */
  public PagedCallSettings<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
      listToolsSettings() {
    return ((ToolsStubSettings) getStubSettings()).listToolsSettings();
  }

  /** Returns the object with the settings used for calls to exportTools. */
  public UnaryCallSettings<ExportToolsRequest, Operation> exportToolsSettings() {
    return ((ToolsStubSettings) getStubSettings()).exportToolsSettings();
  }

  /** Returns the object with the settings used for calls to exportTools. */
  public OperationCallSettings<ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
      exportToolsOperationSettings() {
    return ((ToolsStubSettings) getStubSettings()).exportToolsOperationSettings();
  }

  /** Returns the object with the settings used for calls to getTool. */
  public UnaryCallSettings<GetToolRequest, Tool> getToolSettings() {
    return ((ToolsStubSettings) getStubSettings()).getToolSettings();
  }

  /** Returns the object with the settings used for calls to updateTool. */
  public UnaryCallSettings<UpdateToolRequest, Tool> updateToolSettings() {
    return ((ToolsStubSettings) getStubSettings()).updateToolSettings();
  }

  /** Returns the object with the settings used for calls to deleteTool. */
  public UnaryCallSettings<DeleteToolRequest, Empty> deleteToolSettings() {
    return ((ToolsStubSettings) getStubSettings()).deleteToolSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ToolsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ToolsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ToolsSettings create(ToolsStubSettings stub) throws IOException {
    return new ToolsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ToolsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ToolsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ToolsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ToolsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ToolsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ToolsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ToolsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ToolsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected ToolsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ToolsSettings. */
  public static class Builder extends ClientSettings.Builder<ToolsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ToolsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ToolsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ToolsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ToolsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ToolsStubSettings.newHttpJsonBuilder());
    }

    public ToolsStubSettings.Builder getStubSettingsBuilder() {
      return ((ToolsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createTool. */
    public UnaryCallSettings.Builder<CreateToolRequest, Tool> createToolSettings() {
      return getStubSettingsBuilder().createToolSettings();
    }

    /** Returns the builder for the settings used for calls to listTools. */
    public PagedCallSettings.Builder<ListToolsRequest, ListToolsResponse, ListToolsPagedResponse>
        listToolsSettings() {
      return getStubSettingsBuilder().listToolsSettings();
    }

    /** Returns the builder for the settings used for calls to exportTools. */
    public UnaryCallSettings.Builder<ExportToolsRequest, Operation> exportToolsSettings() {
      return getStubSettingsBuilder().exportToolsSettings();
    }

    /** Returns the builder for the settings used for calls to exportTools. */
    public OperationCallSettings.Builder<
            ExportToolsRequest, ExportToolsResponse, ExportToolsMetadata>
        exportToolsOperationSettings() {
      return getStubSettingsBuilder().exportToolsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getTool. */
    public UnaryCallSettings.Builder<GetToolRequest, Tool> getToolSettings() {
      return getStubSettingsBuilder().getToolSettings();
    }

    /** Returns the builder for the settings used for calls to updateTool. */
    public UnaryCallSettings.Builder<UpdateToolRequest, Tool> updateToolSettings() {
      return getStubSettingsBuilder().updateToolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTool. */
    public UnaryCallSettings.Builder<DeleteToolRequest, Empty> deleteToolSettings() {
      return getStubSettingsBuilder().deleteToolSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public ToolsSettings build() throws IOException {
      return new ToolsSettings(this);
    }
  }
}
