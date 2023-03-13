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

package com.google.devtools.cloudprofiler.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.devtools.cloudprofiler.v2.stub.ProfilerServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProfilerServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudprofiler.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createProfile to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProfilerServiceSettings.Builder profilerServiceSettingsBuilder =
 *     ProfilerServiceSettings.newBuilder();
 * profilerServiceSettingsBuilder
 *     .createProfileSettings()
 *     .setRetrySettings(
 *         profilerServiceSettingsBuilder
 *             .createProfileSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProfilerServiceSettings profilerServiceSettings = profilerServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProfilerServiceSettings extends ClientSettings<ProfilerServiceSettings> {

  /** Returns the object with the settings used for calls to createProfile. */
  public UnaryCallSettings<CreateProfileRequest, Profile> createProfileSettings() {
    return ((ProfilerServiceStubSettings) getStubSettings()).createProfileSettings();
  }

  /** Returns the object with the settings used for calls to createOfflineProfile. */
  public UnaryCallSettings<CreateOfflineProfileRequest, Profile> createOfflineProfileSettings() {
    return ((ProfilerServiceStubSettings) getStubSettings()).createOfflineProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateProfile. */
  public UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings() {
    return ((ProfilerServiceStubSettings) getStubSettings()).updateProfileSettings();
  }

  public static final ProfilerServiceSettings create(ProfilerServiceStubSettings stub)
      throws IOException {
    return new ProfilerServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProfilerServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProfilerServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProfilerServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProfilerServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProfilerServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProfilerServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProfilerServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProfilerServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProfilerServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProfilerServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ProfilerServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProfilerServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProfilerServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProfilerServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProfilerServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ProfilerServiceStubSettings.newHttpJsonBuilder());
    }

    public ProfilerServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProfilerServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createProfile. */
    public UnaryCallSettings.Builder<CreateProfileRequest, Profile> createProfileSettings() {
      return getStubSettingsBuilder().createProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createOfflineProfile. */
    public UnaryCallSettings.Builder<CreateOfflineProfileRequest, Profile>
        createOfflineProfileSettings() {
      return getStubSettingsBuilder().createOfflineProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateProfile. */
    public UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings() {
      return getStubSettingsBuilder().updateProfileSettings();
    }

    @Override
    public ProfilerServiceSettings build() throws IOException {
      return new ProfilerServiceSettings(this);
    }
  }
}
