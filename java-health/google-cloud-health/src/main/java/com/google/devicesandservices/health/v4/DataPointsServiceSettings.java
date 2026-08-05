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

package com.google.devicesandservices.health.v4;

import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.RollUpDataPointsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.devicesandservices.health.v4.stub.DataPointsServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataPointsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (health.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataPoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataPointsServiceSettings.Builder dataPointsServiceSettingsBuilder =
 *     DataPointsServiceSettings.newBuilder();
 * dataPointsServiceSettingsBuilder
 *     .getDataPointSettings()
 *     .setRetrySettings(
 *         dataPointsServiceSettingsBuilder
 *             .getDataPointSettings()
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
 * DataPointsServiceSettings dataPointsServiceSettings = dataPointsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataPoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataPointsServiceSettings.Builder dataPointsServiceSettingsBuilder =
 *     DataPointsServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataPointsServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DataPointsServiceSettings extends ClientSettings<DataPointsServiceSettings> {

  /** Returns the object with the settings used for calls to getDataPoint. */
  public UnaryCallSettings<GetDataPointRequest, DataPoint> getDataPointSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).getDataPointSettings();
  }

  /** Returns the object with the settings used for calls to listDataPoints. */
  public PagedCallSettings<
          ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
      listDataPointsSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).listDataPointsSettings();
  }

  /** Returns the object with the settings used for calls to createDataPoint. */
  public UnaryCallSettings<CreateDataPointRequest, Operation> createDataPointSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).createDataPointSettings();
  }

  /** Returns the object with the settings used for calls to createDataPoint. */
  public OperationCallSettings<CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).createDataPointOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDataPoint. */
  public UnaryCallSettings<UpdateDataPointRequest, Operation> updateDataPointSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).updateDataPointSettings();
  }

  /** Returns the object with the settings used for calls to updateDataPoint. */
  public OperationCallSettings<UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).updateDataPointOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteDataPoints. */
  public UnaryCallSettings<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).batchDeleteDataPointsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteDataPoints. */
  public OperationCallSettings<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings())
        .batchDeleteDataPointsOperationSettings();
  }

  /** Returns the object with the settings used for calls to reconcileDataPoints. */
  public PagedCallSettings<
          ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconcileDataPointsPagedResponse>
      reconcileDataPointsSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).reconcileDataPointsSettings();
  }

  /** Returns the object with the settings used for calls to rollUpDataPoints. */
  public PagedCallSettings<
          RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
      rollUpDataPointsSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).rollUpDataPointsSettings();
  }

  /** Returns the object with the settings used for calls to dailyRollUpDataPoints. */
  public UnaryCallSettings<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).dailyRollUpDataPointsSettings();
  }

  /** Returns the object with the settings used for calls to exportExerciseTcx. */
  public UnaryCallSettings<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxSettings() {
    return ((DataPointsServiceStubSettings) getStubSettings()).exportExerciseTcxSettings();
  }

  public static final DataPointsServiceSettings create(DataPointsServiceStubSettings stub)
      throws IOException {
    return new DataPointsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataPointsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataPointsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataPointsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataPointsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataPointsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataPointsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataPointsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataPointsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataPointsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataPointsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataPointsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(DataPointsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataPointsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataPointsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataPointsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataPointsServiceStubSettings.newHttpJsonBuilder());
    }

    public DataPointsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataPointsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getDataPoint. */
    public UnaryCallSettings.Builder<GetDataPointRequest, DataPoint> getDataPointSettings() {
      return getStubSettingsBuilder().getDataPointSettings();
    }

    /** Returns the builder for the settings used for calls to listDataPoints. */
    public PagedCallSettings.Builder<
            ListDataPointsRequest, ListDataPointsResponse, ListDataPointsPagedResponse>
        listDataPointsSettings() {
      return getStubSettingsBuilder().listDataPointsSettings();
    }

    /** Returns the builder for the settings used for calls to createDataPoint. */
    public UnaryCallSettings.Builder<CreateDataPointRequest, Operation> createDataPointSettings() {
      return getStubSettingsBuilder().createDataPointSettings();
    }

    /** Returns the builder for the settings used for calls to createDataPoint. */
    public OperationCallSettings.Builder<
            CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
        createDataPointOperationSettings() {
      return getStubSettingsBuilder().createDataPointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataPoint. */
    public UnaryCallSettings.Builder<UpdateDataPointRequest, Operation> updateDataPointSettings() {
      return getStubSettingsBuilder().updateDataPointSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataPoint. */
    public OperationCallSettings.Builder<
            UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
        updateDataPointOperationSettings() {
      return getStubSettingsBuilder().updateDataPointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataPoints. */
    public UnaryCallSettings.Builder<BatchDeleteDataPointsRequest, Operation>
        batchDeleteDataPointsSettings() {
      return getStubSettingsBuilder().batchDeleteDataPointsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataPoints. */
    public OperationCallSettings.Builder<
            BatchDeleteDataPointsRequest,
            BatchDeleteDataPointsResponse,
            BatchDeleteDataPointsOperationMetadata>
        batchDeleteDataPointsOperationSettings() {
      return getStubSettingsBuilder().batchDeleteDataPointsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reconcileDataPoints. */
    public PagedCallSettings.Builder<
            ReconcileDataPointsRequest,
            ReconcileDataPointsResponse,
            ReconcileDataPointsPagedResponse>
        reconcileDataPointsSettings() {
      return getStubSettingsBuilder().reconcileDataPointsSettings();
    }

    /** Returns the builder for the settings used for calls to rollUpDataPoints. */
    public PagedCallSettings.Builder<
            RollUpDataPointsRequest, RollUpDataPointsResponse, RollUpDataPointsPagedResponse>
        rollUpDataPointsSettings() {
      return getStubSettingsBuilder().rollUpDataPointsSettings();
    }

    /** Returns the builder for the settings used for calls to dailyRollUpDataPoints. */
    public UnaryCallSettings.Builder<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
        dailyRollUpDataPointsSettings() {
      return getStubSettingsBuilder().dailyRollUpDataPointsSettings();
    }

    /** Returns the builder for the settings used for calls to exportExerciseTcx. */
    public UnaryCallSettings.Builder<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
        exportExerciseTcxSettings() {
      return getStubSettingsBuilder().exportExerciseTcxSettings();
    }

    @Override
    public DataPointsServiceSettings build() throws IOException {
      return new DataPointsServiceSettings(this);
    }
  }
}
