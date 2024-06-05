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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.GenAiCacheServiceClient.ListCachedContentsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.GenAiCacheServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.GenAiCacheServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GenAiCacheServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCachedContent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GenAiCacheServiceSettings.Builder genAiCacheServiceSettingsBuilder =
 *     GenAiCacheServiceSettings.newBuilder();
 * genAiCacheServiceSettingsBuilder
 *     .createCachedContentSettings()
 *     .setRetrySettings(
 *         genAiCacheServiceSettingsBuilder
 *             .createCachedContentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GenAiCacheServiceSettings genAiCacheServiceSettings = genAiCacheServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GenAiCacheServiceSettings extends ClientSettings<GenAiCacheServiceSettings> {

  /** Returns the object with the settings used for calls to createCachedContent. */
  public UnaryCallSettings<CreateCachedContentRequest, CachedContent>
      createCachedContentSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).createCachedContentSettings();
  }

  /** Returns the object with the settings used for calls to getCachedContent. */
  public UnaryCallSettings<GetCachedContentRequest, CachedContent> getCachedContentSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).getCachedContentSettings();
  }

  /** Returns the object with the settings used for calls to updateCachedContent. */
  public UnaryCallSettings<UpdateCachedContentRequest, CachedContent>
      updateCachedContentSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).updateCachedContentSettings();
  }

  /** Returns the object with the settings used for calls to deleteCachedContent. */
  public UnaryCallSettings<DeleteCachedContentRequest, Empty> deleteCachedContentSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).deleteCachedContentSettings();
  }

  /** Returns the object with the settings used for calls to listCachedContents. */
  public PagedCallSettings<
          ListCachedContentsRequest, ListCachedContentsResponse, ListCachedContentsPagedResponse>
      listCachedContentsSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).listCachedContentsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((GenAiCacheServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final GenAiCacheServiceSettings create(GenAiCacheServiceStubSettings stub)
      throws IOException {
    return new GenAiCacheServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GenAiCacheServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GenAiCacheServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GenAiCacheServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GenAiCacheServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GenAiCacheServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GenAiCacheServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GenAiCacheServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GenAiCacheServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GenAiCacheServiceSettings. */
  public static class Builder extends ClientSettings.Builder<GenAiCacheServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GenAiCacheServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GenAiCacheServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GenAiCacheServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GenAiCacheServiceStubSettings.newBuilder());
    }

    public GenAiCacheServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GenAiCacheServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCachedContent. */
    public UnaryCallSettings.Builder<CreateCachedContentRequest, CachedContent>
        createCachedContentSettings() {
      return getStubSettingsBuilder().createCachedContentSettings();
    }

    /** Returns the builder for the settings used for calls to getCachedContent. */
    public UnaryCallSettings.Builder<GetCachedContentRequest, CachedContent>
        getCachedContentSettings() {
      return getStubSettingsBuilder().getCachedContentSettings();
    }

    /** Returns the builder for the settings used for calls to updateCachedContent. */
    public UnaryCallSettings.Builder<UpdateCachedContentRequest, CachedContent>
        updateCachedContentSettings() {
      return getStubSettingsBuilder().updateCachedContentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCachedContent. */
    public UnaryCallSettings.Builder<DeleteCachedContentRequest, Empty>
        deleteCachedContentSettings() {
      return getStubSettingsBuilder().deleteCachedContentSettings();
    }

    /** Returns the builder for the settings used for calls to listCachedContents. */
    public PagedCallSettings.Builder<
            ListCachedContentsRequest, ListCachedContentsResponse, ListCachedContentsPagedResponse>
        listCachedContentsSettings() {
      return getStubSettingsBuilder().listCachedContentsSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public GenAiCacheServiceSettings build() throws IOException {
      return new GenAiCacheServiceSettings(this);
    }
  }
}
