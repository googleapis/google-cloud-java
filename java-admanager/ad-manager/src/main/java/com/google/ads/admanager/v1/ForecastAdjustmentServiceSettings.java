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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ForecastAdjustmentServiceClient.ListForecastAdjustmentsPagedResponse;

import com.google.ads.admanager.v1.stub.ForecastAdjustmentServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ForecastAdjustmentServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getForecastAdjustment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ForecastAdjustmentServiceSettings.Builder forecastAdjustmentServiceSettingsBuilder =
 *     ForecastAdjustmentServiceSettings.newBuilder();
 * forecastAdjustmentServiceSettingsBuilder
 *     .getForecastAdjustmentSettings()
 *     .setRetrySettings(
 *         forecastAdjustmentServiceSettingsBuilder
 *             .getForecastAdjustmentSettings()
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
 * ForecastAdjustmentServiceSettings forecastAdjustmentServiceSettings =
 *     forecastAdjustmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ForecastAdjustmentServiceSettings
    extends ClientSettings<ForecastAdjustmentServiceSettings> {

  /** Returns the object with the settings used for calls to getForecastAdjustment. */
  public UnaryCallSettings<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .getForecastAdjustmentSettings();
  }

  /** Returns the object with the settings used for calls to listForecastAdjustments. */
  public PagedCallSettings<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .listForecastAdjustmentsSettings();
  }

  /** Returns the object with the settings used for calls to createForecastAdjustment. */
  public UnaryCallSettings<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .createForecastAdjustmentSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateForecastAdjustments. */
  public UnaryCallSettings<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .batchCreateForecastAdjustmentsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateForecastAdjustments. */
  public UnaryCallSettings<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .batchActivateForecastAdjustmentsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivateForecastAdjustments. */
  public UnaryCallSettings<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .batchDeactivateForecastAdjustmentsSettings();
  }

  /** Returns the object with the settings used for calls to updateForecastAdjustment. */
  public UnaryCallSettings<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .updateForecastAdjustmentSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateForecastAdjustments. */
  public UnaryCallSettings<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .batchUpdateForecastAdjustmentsSettings();
  }

  /** Returns the object with the settings used for calls to calculateDailyAdOpportunityCounts. */
  public UnaryCallSettings<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsSettings() {
    return ((ForecastAdjustmentServiceStubSettings) getStubSettings())
        .calculateDailyAdOpportunityCountsSettings();
  }

  public static final ForecastAdjustmentServiceSettings create(
      ForecastAdjustmentServiceStubSettings stub) throws IOException {
    return new ForecastAdjustmentServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ForecastAdjustmentServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ForecastAdjustmentServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ForecastAdjustmentServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ForecastAdjustmentServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ForecastAdjustmentServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ForecastAdjustmentServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ForecastAdjustmentServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ForecastAdjustmentServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ForecastAdjustmentServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ForecastAdjustmentServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ForecastAdjustmentServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ForecastAdjustmentServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ForecastAdjustmentServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ForecastAdjustmentServiceStubSettings.newBuilder());
    }

    public ForecastAdjustmentServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ForecastAdjustmentServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getForecastAdjustment. */
    public UnaryCallSettings.Builder<GetForecastAdjustmentRequest, ForecastAdjustment>
        getForecastAdjustmentSettings() {
      return getStubSettingsBuilder().getForecastAdjustmentSettings();
    }

    /** Returns the builder for the settings used for calls to listForecastAdjustments. */
    public PagedCallSettings.Builder<
            ListForecastAdjustmentsRequest,
            ListForecastAdjustmentsResponse,
            ListForecastAdjustmentsPagedResponse>
        listForecastAdjustmentsSettings() {
      return getStubSettingsBuilder().listForecastAdjustmentsSettings();
    }

    /** Returns the builder for the settings used for calls to createForecastAdjustment. */
    public UnaryCallSettings.Builder<CreateForecastAdjustmentRequest, ForecastAdjustment>
        createForecastAdjustmentSettings() {
      return getStubSettingsBuilder().createForecastAdjustmentSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
        batchCreateForecastAdjustmentsSettings() {
      return getStubSettingsBuilder().batchCreateForecastAdjustmentsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
        batchActivateForecastAdjustmentsSettings() {
      return getStubSettingsBuilder().batchActivateForecastAdjustmentsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchDeactivateForecastAdjustments.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
        batchDeactivateForecastAdjustmentsSettings() {
      return getStubSettingsBuilder().batchDeactivateForecastAdjustmentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateForecastAdjustment. */
    public UnaryCallSettings.Builder<UpdateForecastAdjustmentRequest, ForecastAdjustment>
        updateForecastAdjustmentSettings() {
      return getStubSettingsBuilder().updateForecastAdjustmentSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
        batchUpdateForecastAdjustmentsSettings() {
      return getStubSettingsBuilder().batchUpdateForecastAdjustmentsSettings();
    }

    /** Returns the builder for the settings used for calls to calculateDailyAdOpportunityCounts. */
    public UnaryCallSettings.Builder<
            CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
        calculateDailyAdOpportunityCountsSettings() {
      return getStubSettingsBuilder().calculateDailyAdOpportunityCountsSettings();
    }

    @Override
    public ForecastAdjustmentServiceSettings build() throws IOException {
      return new ForecastAdjustmentServiceSettings(this);
    }
  }
}
