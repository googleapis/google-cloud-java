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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.TargetPoolsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TargetPoolsClient}.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TargetPoolsSettings.Builder targetPoolsSettingsBuilder = TargetPoolsSettings.newBuilder();
 * targetPoolsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetPoolsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetPoolsSettings targetPoolsSettings = targetPoolsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetPoolsSettings extends ClientSettings<TargetPoolsSettings> {

  /** Returns the object with the settings used for calls to addHealthCheck. */
  public UnaryCallSettings<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).addHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to addHealthCheck. */
  public OperationCallSettings<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).addHealthCheckOperationSettings();
  }

  /** Returns the object with the settings used for calls to addInstance. */
  public UnaryCallSettings<AddInstanceTargetPoolRequest, Operation> addInstanceSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).addInstanceSettings();
  }

  /** Returns the object with the settings used for calls to addInstance. */
  public OperationCallSettings<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).addInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetPoolRequest, Operation> deleteSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetPoolRequest, TargetPool> getSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getHealth. */
  public UnaryCallSettings<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).getHealthSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetPoolRequest, Operation> insertSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetPoolRequest, Operation, Operation>
      insertOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
      listSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to removeHealthCheck. */
  public UnaryCallSettings<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).removeHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to removeHealthCheck. */
  public OperationCallSettings<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).removeHealthCheckOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeInstance. */
  public UnaryCallSettings<RemoveInstanceTargetPoolRequest, Operation> removeInstanceSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).removeInstanceSettings();
  }

  /** Returns the object with the settings used for calls to removeInstance. */
  public OperationCallSettings<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).removeInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to setBackup. */
  public UnaryCallSettings<SetBackupTargetPoolRequest, Operation> setBackupSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).setBackupSettings();
  }

  /** Returns the object with the settings used for calls to setBackup. */
  public OperationCallSettings<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationSettings() {
    return ((TargetPoolsStubSettings) getStubSettings()).setBackupOperationSettings();
  }

  public static final TargetPoolsSettings create(TargetPoolsStubSettings stub) throws IOException {
    return new TargetPoolsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetPoolsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetPoolsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetPoolsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetPoolsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetPoolsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetPoolsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetPoolsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetPoolsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetPoolsSettings. */
  public static class Builder extends ClientSettings.Builder<TargetPoolsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TargetPoolsStubSettings.newBuilder(clientContext));
    }

    protected Builder(TargetPoolsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetPoolsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TargetPoolsStubSettings.newBuilder());
    }

    public TargetPoolsStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetPoolsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addHealthCheck. */
    public UnaryCallSettings.Builder<AddHealthCheckTargetPoolRequest, Operation>
        addHealthCheckSettings() {
      return getStubSettingsBuilder().addHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to addHealthCheck. */
    public OperationCallSettings.Builder<AddHealthCheckTargetPoolRequest, Operation, Operation>
        addHealthCheckOperationSettings() {
      return getStubSettingsBuilder().addHealthCheckOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addInstance. */
    public UnaryCallSettings.Builder<AddInstanceTargetPoolRequest, Operation>
        addInstanceSettings() {
      return getStubSettingsBuilder().addInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to addInstance. */
    public OperationCallSettings.Builder<AddInstanceTargetPoolRequest, Operation, Operation>
        addInstanceOperationSettings() {
      return getStubSettingsBuilder().addInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListTargetPoolsRequest, TargetPoolAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetPoolRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteTargetPoolRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetPoolRequest, TargetPool> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getHealth. */
    public UnaryCallSettings.Builder<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
        getHealthSettings() {
      return getStubSettingsBuilder().getHealthSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetPoolRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertTargetPoolRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListTargetPoolsRequest, TargetPoolList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to removeHealthCheck. */
    public UnaryCallSettings.Builder<RemoveHealthCheckTargetPoolRequest, Operation>
        removeHealthCheckSettings() {
      return getStubSettingsBuilder().removeHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to removeHealthCheck. */
    public OperationCallSettings.Builder<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
        removeHealthCheckOperationSettings() {
      return getStubSettingsBuilder().removeHealthCheckOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstance. */
    public UnaryCallSettings.Builder<RemoveInstanceTargetPoolRequest, Operation>
        removeInstanceSettings() {
      return getStubSettingsBuilder().removeInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstance. */
    public OperationCallSettings.Builder<RemoveInstanceTargetPoolRequest, Operation, Operation>
        removeInstanceOperationSettings() {
      return getStubSettingsBuilder().removeInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setBackup. */
    public UnaryCallSettings.Builder<SetBackupTargetPoolRequest, Operation> setBackupSettings() {
      return getStubSettingsBuilder().setBackupSettings();
    }

    /** Returns the builder for the settings used for calls to setBackup. */
    public OperationCallSettings.Builder<SetBackupTargetPoolRequest, Operation, Operation>
        setBackupOperationSettings() {
      return getStubSettingsBuilder().setBackupOperationSettings();
    }

    @Override
    public TargetPoolsSettings build() throws IOException {
      return new TargetPoolsSettings(this);
    }
  }
}
