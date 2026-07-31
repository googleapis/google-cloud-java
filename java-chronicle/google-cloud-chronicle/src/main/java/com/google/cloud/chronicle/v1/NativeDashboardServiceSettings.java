/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

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
import com.google.cloud.chronicle.v1.stub.NativeDashboardServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NativeDashboardServiceClient}.
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
 * of createNativeDashboard:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NativeDashboardServiceSettings.Builder nativeDashboardServiceSettingsBuilder =
 *     NativeDashboardServiceSettings.newBuilder();
 * nativeDashboardServiceSettingsBuilder
 *     .createNativeDashboardSettings()
 *     .setRetrySettings(
 *         nativeDashboardServiceSettingsBuilder
 *             .createNativeDashboardSettings()
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
 * NativeDashboardServiceSettings nativeDashboardServiceSettings =
 *     nativeDashboardServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class NativeDashboardServiceSettings extends ClientSettings<NativeDashboardServiceSettings> {

  /** Returns the object with the settings used for calls to createNativeDashboard. */
  public UnaryCallSettings<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).createNativeDashboardSettings();
  }

  /** Returns the object with the settings used for calls to getNativeDashboard. */
  public UnaryCallSettings<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).getNativeDashboardSettings();
  }

  /** Returns the object with the settings used for calls to listNativeDashboards. */
  public PagedCallSettings<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          ListNativeDashboardsPagedResponse>
      listNativeDashboardsSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).listNativeDashboardsSettings();
  }

  /** Returns the object with the settings used for calls to updateNativeDashboard. */
  public UnaryCallSettings<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).updateNativeDashboardSettings();
  }

  /** Returns the object with the settings used for calls to duplicateNativeDashboard. */
  public UnaryCallSettings<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings())
        .duplicateNativeDashboardSettings();
  }

  /** Returns the object with the settings used for calls to deleteNativeDashboard. */
  public UnaryCallSettings<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).deleteNativeDashboardSettings();
  }

  /** Returns the object with the settings used for calls to addChart. */
  public UnaryCallSettings<AddChartRequest, AddChartResponse> addChartSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).addChartSettings();
  }

  /** Returns the object with the settings used for calls to removeChart. */
  public UnaryCallSettings<RemoveChartRequest, NativeDashboard> removeChartSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).removeChartSettings();
  }

  /** Returns the object with the settings used for calls to editChart. */
  public UnaryCallSettings<EditChartRequest, EditChartResponse> editChartSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).editChartSettings();
  }

  /** Returns the object with the settings used for calls to duplicateChart. */
  public UnaryCallSettings<DuplicateChartRequest, DuplicateChartResponse> duplicateChartSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings()).duplicateChartSettings();
  }

  /** Returns the object with the settings used for calls to exportNativeDashboards. */
  public UnaryCallSettings<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings())
        .exportNativeDashboardsSettings();
  }

  /** Returns the object with the settings used for calls to importNativeDashboards. */
  public UnaryCallSettings<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsSettings() {
    return ((NativeDashboardServiceStubSettings) getStubSettings())
        .importNativeDashboardsSettings();
  }

  public static final NativeDashboardServiceSettings create(NativeDashboardServiceStubSettings stub)
      throws IOException {
    return new NativeDashboardServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NativeDashboardServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NativeDashboardServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NativeDashboardServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NativeDashboardServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NativeDashboardServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NativeDashboardServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<NativeDashboardServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(NativeDashboardServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(NativeDashboardServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NativeDashboardServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NativeDashboardServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(NativeDashboardServiceStubSettings.newHttpJsonBuilder());
    }

    public NativeDashboardServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NativeDashboardServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createNativeDashboard. */
    public UnaryCallSettings.Builder<CreateNativeDashboardRequest, NativeDashboard>
        createNativeDashboardSettings() {
      return getStubSettingsBuilder().createNativeDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to getNativeDashboard. */
    public UnaryCallSettings.Builder<GetNativeDashboardRequest, NativeDashboard>
        getNativeDashboardSettings() {
      return getStubSettingsBuilder().getNativeDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to listNativeDashboards. */
    public PagedCallSettings.Builder<
            ListNativeDashboardsRequest,
            ListNativeDashboardsResponse,
            ListNativeDashboardsPagedResponse>
        listNativeDashboardsSettings() {
      return getStubSettingsBuilder().listNativeDashboardsSettings();
    }

    /** Returns the builder for the settings used for calls to updateNativeDashboard. */
    public UnaryCallSettings.Builder<UpdateNativeDashboardRequest, NativeDashboard>
        updateNativeDashboardSettings() {
      return getStubSettingsBuilder().updateNativeDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to duplicateNativeDashboard. */
    public UnaryCallSettings.Builder<DuplicateNativeDashboardRequest, NativeDashboard>
        duplicateNativeDashboardSettings() {
      return getStubSettingsBuilder().duplicateNativeDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNativeDashboard. */
    public UnaryCallSettings.Builder<DeleteNativeDashboardRequest, Empty>
        deleteNativeDashboardSettings() {
      return getStubSettingsBuilder().deleteNativeDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to addChart. */
    public UnaryCallSettings.Builder<AddChartRequest, AddChartResponse> addChartSettings() {
      return getStubSettingsBuilder().addChartSettings();
    }

    /** Returns the builder for the settings used for calls to removeChart. */
    public UnaryCallSettings.Builder<RemoveChartRequest, NativeDashboard> removeChartSettings() {
      return getStubSettingsBuilder().removeChartSettings();
    }

    /** Returns the builder for the settings used for calls to editChart. */
    public UnaryCallSettings.Builder<EditChartRequest, EditChartResponse> editChartSettings() {
      return getStubSettingsBuilder().editChartSettings();
    }

    /** Returns the builder for the settings used for calls to duplicateChart. */
    public UnaryCallSettings.Builder<DuplicateChartRequest, DuplicateChartResponse>
        duplicateChartSettings() {
      return getStubSettingsBuilder().duplicateChartSettings();
    }

    /** Returns the builder for the settings used for calls to exportNativeDashboards. */
    public UnaryCallSettings.Builder<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
        exportNativeDashboardsSettings() {
      return getStubSettingsBuilder().exportNativeDashboardsSettings();
    }

    /** Returns the builder for the settings used for calls to importNativeDashboards. */
    public UnaryCallSettings.Builder<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
        importNativeDashboardsSettings() {
      return getStubSettingsBuilder().importNativeDashboardsSettings();
    }

    @Override
    public NativeDashboardServiceSettings build() throws IOException {
      return new NativeDashboardServiceSettings(this);
    }
  }
}
