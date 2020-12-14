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

package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;
import static com.google.cloud.talent.v4beta1.ProfileServiceClient.SearchProfilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.talent.v4beta1.stub.ProfileServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProfileServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (jobs.googleapis.com) and default port (443) are used.
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
 * ProfileServiceSettings.Builder profileServiceSettingsBuilder =
 *     ProfileServiceSettings.newBuilder();
 * profileServiceSettingsBuilder
 *     .createProfileSettings()
 *     .setRetrySettings(
 *         profileServiceSettingsBuilder
 *             .createProfileSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProfileServiceSettings profileServiceSettings = profileServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProfileServiceSettings extends ClientSettings<ProfileServiceSettings> {

  /** Returns the object with the settings used for calls to listProfiles. */
  public PagedCallSettings<ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
      listProfilesSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).listProfilesSettings();
  }

  /** Returns the object with the settings used for calls to createProfile. */
  public UnaryCallSettings<CreateProfileRequest, Profile> createProfileSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).createProfileSettings();
  }

  /** Returns the object with the settings used for calls to getProfile. */
  public UnaryCallSettings<GetProfileRequest, Profile> getProfileSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).getProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateProfile. */
  public UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).updateProfileSettings();
  }

  /** Returns the object with the settings used for calls to deleteProfile. */
  public UnaryCallSettings<DeleteProfileRequest, Empty> deleteProfileSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).deleteProfileSettings();
  }

  /** Returns the object with the settings used for calls to searchProfiles. */
  public PagedCallSettings<
          SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
      searchProfilesSettings() {
    return ((ProfileServiceStubSettings) getStubSettings()).searchProfilesSettings();
  }

  public static final ProfileServiceSettings create(ProfileServiceStubSettings stub)
      throws IOException {
    return new ProfileServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProfileServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProfileServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProfileServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProfileServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProfileServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProfileServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProfileServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProfileServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProfileServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ProfileServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProfileServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProfileServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProfileServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProfileServiceStubSettings.newBuilder());
    }

    public ProfileServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProfileServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listProfiles. */
    public PagedCallSettings.Builder<
            ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
        listProfilesSettings() {
      return getStubSettingsBuilder().listProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to createProfile. */
    public UnaryCallSettings.Builder<CreateProfileRequest, Profile> createProfileSettings() {
      return getStubSettingsBuilder().createProfileSettings();
    }

    /** Returns the builder for the settings used for calls to getProfile. */
    public UnaryCallSettings.Builder<GetProfileRequest, Profile> getProfileSettings() {
      return getStubSettingsBuilder().getProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateProfile. */
    public UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings() {
      return getStubSettingsBuilder().updateProfileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProfile. */
    public UnaryCallSettings.Builder<DeleteProfileRequest, Empty> deleteProfileSettings() {
      return getStubSettingsBuilder().deleteProfileSettings();
    }

    /** Returns the builder for the settings used for calls to searchProfiles. */
    public PagedCallSettings.Builder<
            SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
        searchProfilesSettings() {
      return getStubSettingsBuilder().searchProfilesSettings();
    }

    @Override
    public ProfileServiceSettings build() throws IOException {
      return new ProfileServiceSettings(this);
    }
  }
}
