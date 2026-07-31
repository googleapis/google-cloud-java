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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RolloutsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RolloutsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RolloutsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RolloutsSettings.Builder rolloutsSettingsBuilder = RolloutsSettings.newBuilder();
 * rolloutsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         rolloutsSettingsBuilder
 *             .getSettings()
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
 * RolloutsSettings rolloutsSettings = rolloutsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for advance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RolloutsSettings.Builder rolloutsSettingsBuilder = RolloutsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * rolloutsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class RolloutsSettings extends ClientSettings<RolloutsSettings> {

  /** Returns the object with the settings used for calls to advance. */
  public UnaryCallSettings<AdvanceRolloutRequest, Operation> advanceSettings() {
    return ((RolloutsStubSettings) getStubSettings()).advanceSettings();
  }

  /** Returns the object with the settings used for calls to advance. */
  public OperationCallSettings<AdvanceRolloutRequest, Operation, Operation>
      advanceOperationSettings() {
    return ((RolloutsStubSettings) getStubSettings()).advanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancel. */
  public UnaryCallSettings<CancelRolloutRequest, Operation> cancelSettings() {
    return ((RolloutsStubSettings) getStubSettings()).cancelSettings();
  }

  /** Returns the object with the settings used for calls to cancel. */
  public OperationCallSettings<CancelRolloutRequest, Operation, Operation>
      cancelOperationSettings() {
    return ((RolloutsStubSettings) getStubSettings()).cancelOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRolloutRequest, Operation> deleteSettings() {
    return ((RolloutsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRolloutRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RolloutsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getSettings() {
    return ((RolloutsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRolloutsRequest, RolloutsListResponse, ListPagedResponse>
      listSettings() {
    return ((RolloutsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to pause. */
  public UnaryCallSettings<PauseRolloutRequest, Operation> pauseSettings() {
    return ((RolloutsStubSettings) getStubSettings()).pauseSettings();
  }

  /** Returns the object with the settings used for calls to pause. */
  public OperationCallSettings<PauseRolloutRequest, Operation, Operation> pauseOperationSettings() {
    return ((RolloutsStubSettings) getStubSettings()).pauseOperationSettings();
  }

  /** Returns the object with the settings used for calls to resume. */
  public UnaryCallSettings<ResumeRolloutRequest, Operation> resumeSettings() {
    return ((RolloutsStubSettings) getStubSettings()).resumeSettings();
  }

  /** Returns the object with the settings used for calls to resume. */
  public OperationCallSettings<ResumeRolloutRequest, Operation, Operation>
      resumeOperationSettings() {
    return ((RolloutsStubSettings) getStubSettings()).resumeOperationSettings();
  }

  public static final RolloutsSettings create(RolloutsStubSettings stub) throws IOException {
    return new RolloutsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RolloutsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RolloutsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RolloutsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RolloutsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RolloutsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RolloutsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RolloutsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RolloutsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RolloutsSettings. */
  public static class Builder extends ClientSettings.Builder<RolloutsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(RolloutsStubSettings.newBuilder(clientContext));
    }

    protected Builder(RolloutsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RolloutsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RolloutsStubSettings.newBuilder());
    }

    public RolloutsStubSettings.Builder getStubSettingsBuilder() {
      return ((RolloutsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to advance. */
    public UnaryCallSettings.Builder<AdvanceRolloutRequest, Operation> advanceSettings() {
      return getStubSettingsBuilder().advanceSettings();
    }

    /** Returns the builder for the settings used for calls to advance. */
    public OperationCallSettings.Builder<AdvanceRolloutRequest, Operation, Operation>
        advanceOperationSettings() {
      return getStubSettingsBuilder().advanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public UnaryCallSettings.Builder<CancelRolloutRequest, Operation> cancelSettings() {
      return getStubSettingsBuilder().cancelSettings();
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public OperationCallSettings.Builder<CancelRolloutRequest, Operation, Operation>
        cancelOperationSettings() {
      return getStubSettingsBuilder().cancelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRolloutRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRolloutRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRolloutsRequest, RolloutsListResponse, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to pause. */
    public UnaryCallSettings.Builder<PauseRolloutRequest, Operation> pauseSettings() {
      return getStubSettingsBuilder().pauseSettings();
    }

    /** Returns the builder for the settings used for calls to pause. */
    public OperationCallSettings.Builder<PauseRolloutRequest, Operation, Operation>
        pauseOperationSettings() {
      return getStubSettingsBuilder().pauseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resume. */
    public UnaryCallSettings.Builder<ResumeRolloutRequest, Operation> resumeSettings() {
      return getStubSettingsBuilder().resumeSettings();
    }

    /** Returns the builder for the settings used for calls to resume. */
    public OperationCallSettings.Builder<ResumeRolloutRequest, Operation, Operation>
        resumeOperationSettings() {
      return getStubSettingsBuilder().resumeOperationSettings();
    }

    @Override
    public RolloutsSettings build() throws IOException {
      return new RolloutsSettings(this);
    }
  }
}
