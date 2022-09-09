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

package com.google.cloud.debugger.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.debugger.v2.stub.Controller2StubSettings;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link Controller2Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouddebugger.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of registerDebuggee to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * Controller2Settings.Builder controller2SettingsBuilder = Controller2Settings.newBuilder();
 * controller2SettingsBuilder
 *     .registerDebuggeeSettings()
 *     .setRetrySettings(
 *         controller2SettingsBuilder.registerDebuggeeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * Controller2Settings controller2Settings = controller2SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class Controller2Settings extends ClientSettings<Controller2Settings> {

  /** Returns the object with the settings used for calls to registerDebuggee. */
  public UnaryCallSettings<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeSettings() {
    return ((Controller2StubSettings) getStubSettings()).registerDebuggeeSettings();
  }

  /** Returns the object with the settings used for calls to listActiveBreakpoints. */
  public UnaryCallSettings<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsSettings() {
    return ((Controller2StubSettings) getStubSettings()).listActiveBreakpointsSettings();
  }

  /** Returns the object with the settings used for calls to updateActiveBreakpoint. */
  public UnaryCallSettings<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointSettings() {
    return ((Controller2StubSettings) getStubSettings()).updateActiveBreakpointSettings();
  }

  public static final Controller2Settings create(Controller2StubSettings stub) throws IOException {
    return new Controller2Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return Controller2StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return Controller2StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return Controller2StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return Controller2StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return Controller2StubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return Controller2StubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return Controller2StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return Controller2StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected Controller2Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for Controller2Settings. */
  public static class Builder extends ClientSettings.Builder<Controller2Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(Controller2StubSettings.newBuilder(clientContext));
    }

    protected Builder(Controller2Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(Controller2StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(Controller2StubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(Controller2StubSettings.newHttpJsonBuilder());
    }

    public Controller2StubSettings.Builder getStubSettingsBuilder() {
      return ((Controller2StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to registerDebuggee. */
    public UnaryCallSettings.Builder<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
        registerDebuggeeSettings() {
      return getStubSettingsBuilder().registerDebuggeeSettings();
    }

    /** Returns the builder for the settings used for calls to listActiveBreakpoints. */
    public UnaryCallSettings.Builder<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
        listActiveBreakpointsSettings() {
      return getStubSettingsBuilder().listActiveBreakpointsSettings();
    }

    /** Returns the builder for the settings used for calls to updateActiveBreakpoint. */
    public UnaryCallSettings.Builder<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
        updateActiveBreakpointSettings() {
      return getStubSettingsBuilder().updateActiveBreakpointSettings();
    }

    @Override
    public Controller2Settings build() throws IOException {
      return new Controller2Settings(this);
    }
  }
}
