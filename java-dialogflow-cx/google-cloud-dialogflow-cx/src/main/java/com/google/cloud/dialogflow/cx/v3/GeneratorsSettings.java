/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.GeneratorsClient.ListGeneratorsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.GeneratorsClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3.stub.GeneratorsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GeneratorsClient}.
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
 * <p>For example, to set the total timeout of getGenerator to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GeneratorsSettings.Builder generatorsSettingsBuilder = GeneratorsSettings.newBuilder();
 * generatorsSettingsBuilder
 *     .getGeneratorSettings()
 *     .setRetrySettings(
 *         generatorsSettingsBuilder
 *             .getGeneratorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GeneratorsSettings generatorsSettings = generatorsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GeneratorsSettings extends ClientSettings<GeneratorsSettings> {

  /** Returns the object with the settings used for calls to listGenerators. */
  public PagedCallSettings<
          ListGeneratorsRequest, ListGeneratorsResponse, ListGeneratorsPagedResponse>
      listGeneratorsSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).listGeneratorsSettings();
  }

  /** Returns the object with the settings used for calls to getGenerator. */
  public UnaryCallSettings<GetGeneratorRequest, Generator> getGeneratorSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).getGeneratorSettings();
  }

  /** Returns the object with the settings used for calls to createGenerator. */
  public UnaryCallSettings<CreateGeneratorRequest, Generator> createGeneratorSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).createGeneratorSettings();
  }

  /** Returns the object with the settings used for calls to updateGenerator. */
  public UnaryCallSettings<UpdateGeneratorRequest, Generator> updateGeneratorSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).updateGeneratorSettings();
  }

  /** Returns the object with the settings used for calls to deleteGenerator. */
  public UnaryCallSettings<DeleteGeneratorRequest, Empty> deleteGeneratorSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).deleteGeneratorSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GeneratorsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final GeneratorsSettings create(GeneratorsStubSettings stub) throws IOException {
    return new GeneratorsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GeneratorsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GeneratorsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GeneratorsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GeneratorsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GeneratorsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GeneratorsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GeneratorsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GeneratorsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GeneratorsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GeneratorsSettings. */
  public static class Builder extends ClientSettings.Builder<GeneratorsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GeneratorsStubSettings.newBuilder(clientContext));
    }

    protected Builder(GeneratorsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GeneratorsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GeneratorsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GeneratorsStubSettings.newHttpJsonBuilder());
    }

    public GeneratorsStubSettings.Builder getStubSettingsBuilder() {
      return ((GeneratorsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listGenerators. */
    public PagedCallSettings.Builder<
            ListGeneratorsRequest, ListGeneratorsResponse, ListGeneratorsPagedResponse>
        listGeneratorsSettings() {
      return getStubSettingsBuilder().listGeneratorsSettings();
    }

    /** Returns the builder for the settings used for calls to getGenerator. */
    public UnaryCallSettings.Builder<GetGeneratorRequest, Generator> getGeneratorSettings() {
      return getStubSettingsBuilder().getGeneratorSettings();
    }

    /** Returns the builder for the settings used for calls to createGenerator. */
    public UnaryCallSettings.Builder<CreateGeneratorRequest, Generator> createGeneratorSettings() {
      return getStubSettingsBuilder().createGeneratorSettings();
    }

    /** Returns the builder for the settings used for calls to updateGenerator. */
    public UnaryCallSettings.Builder<UpdateGeneratorRequest, Generator> updateGeneratorSettings() {
      return getStubSettingsBuilder().updateGeneratorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGenerator. */
    public UnaryCallSettings.Builder<DeleteGeneratorRequest, Empty> deleteGeneratorSettings() {
      return getStubSettingsBuilder().deleteGeneratorSettings();
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
    public GeneratorsSettings build() throws IOException {
      return new GeneratorsSettings(this);
    }
  }
}
