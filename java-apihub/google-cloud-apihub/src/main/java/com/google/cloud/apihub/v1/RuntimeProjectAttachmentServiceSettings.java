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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListRuntimeProjectAttachmentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apihub.v1.stub.RuntimeProjectAttachmentServiceStubSettings;
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
 * Settings class to configure an instance of {@link RuntimeProjectAttachmentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createRuntimeProjectAttachment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuntimeProjectAttachmentServiceSettings.Builder runtimeProjectAttachmentServiceSettingsBuilder =
 *     RuntimeProjectAttachmentServiceSettings.newBuilder();
 * runtimeProjectAttachmentServiceSettingsBuilder
 *     .createRuntimeProjectAttachmentSettings()
 *     .setRetrySettings(
 *         runtimeProjectAttachmentServiceSettingsBuilder
 *             .createRuntimeProjectAttachmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RuntimeProjectAttachmentServiceSettings runtimeProjectAttachmentServiceSettings =
 *     runtimeProjectAttachmentServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RuntimeProjectAttachmentServiceSettings
    extends ClientSettings<RuntimeProjectAttachmentServiceSettings> {

  /** Returns the object with the settings used for calls to createRuntimeProjectAttachment. */
  public UnaryCallSettings<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .createRuntimeProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to getRuntimeProjectAttachment. */
  public UnaryCallSettings<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .getRuntimeProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listRuntimeProjectAttachments. */
  public PagedCallSettings<
          ListRuntimeProjectAttachmentsRequest,
          ListRuntimeProjectAttachmentsResponse,
          ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .listRuntimeProjectAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to deleteRuntimeProjectAttachment. */
  public UnaryCallSettings<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .deleteRuntimeProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to lookupRuntimeProjectAttachment. */
  public UnaryCallSettings<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .lookupRuntimeProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings())
        .listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((RuntimeProjectAttachmentServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final RuntimeProjectAttachmentServiceSettings create(
      RuntimeProjectAttachmentServiceStubSettings stub) throws IOException {
    return new RuntimeProjectAttachmentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RuntimeProjectAttachmentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RuntimeProjectAttachmentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RuntimeProjectAttachmentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RuntimeProjectAttachmentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RuntimeProjectAttachmentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RuntimeProjectAttachmentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RuntimeProjectAttachmentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RuntimeProjectAttachmentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RuntimeProjectAttachmentServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<RuntimeProjectAttachmentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RuntimeProjectAttachmentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(RuntimeProjectAttachmentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RuntimeProjectAttachmentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RuntimeProjectAttachmentServiceStubSettings.newBuilder());
    }

    public RuntimeProjectAttachmentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RuntimeProjectAttachmentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<
            CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        createRuntimeProjectAttachmentSettings() {
      return getStubSettingsBuilder().createRuntimeProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to getRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        getRuntimeProjectAttachmentSettings() {
      return getStubSettingsBuilder().getRuntimeProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to listRuntimeProjectAttachments. */
    public PagedCallSettings.Builder<
            ListRuntimeProjectAttachmentsRequest,
            ListRuntimeProjectAttachmentsResponse,
            ListRuntimeProjectAttachmentsPagedResponse>
        listRuntimeProjectAttachmentsSettings() {
      return getStubSettingsBuilder().listRuntimeProjectAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<DeleteRuntimeProjectAttachmentRequest, Empty>
        deleteRuntimeProjectAttachmentSettings() {
      return getStubSettingsBuilder().deleteRuntimeProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to lookupRuntimeProjectAttachment. */
    public UnaryCallSettings.Builder<
            LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachmentSettings() {
      return getStubSettingsBuilder().lookupRuntimeProjectAttachmentSettings();
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
    public RuntimeProjectAttachmentServiceSettings build() throws IOException {
      return new RuntimeProjectAttachmentServiceSettings(this);
    }
  }
}
