/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.TargetPoolClient.AggregatedListTargetPoolsPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolClient.ListTargetPoolsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.TargetPoolStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetPoolClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addHealthCheckTargetPool to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetPoolSettings.Builder targetPoolSettingsBuilder =
 *     TargetPoolSettings.newBuilder();
 * targetPoolSettingsBuilder.addHealthCheckTargetPoolSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetPoolSettings targetPoolSettings = targetPoolSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetPoolSettings extends ClientSettings<TargetPoolSettings> {
  /** Returns the object with the settings used for calls to addHealthCheckTargetPool. */
  public UnaryCallSettings<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).addHealthCheckTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to addInstanceTargetPool. */
  public UnaryCallSettings<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).addInstanceTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListTargetPools. */
  public PagedCallSettings<
          AggregatedListTargetPoolsHttpRequest,
          TargetPoolAggregatedList,
          AggregatedListTargetPoolsPagedResponse>
      aggregatedListTargetPoolsSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).aggregatedListTargetPoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetPool. */
  public UnaryCallSettings<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).deleteTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to getTargetPool. */
  public UnaryCallSettings<GetTargetPoolHttpRequest, TargetPool> getTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).getTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to getHealthTargetPool. */
  public UnaryCallSettings<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).getHealthTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to insertTargetPool. */
  public UnaryCallSettings<InsertTargetPoolHttpRequest, Operation> insertTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).insertTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to listTargetPools. */
  public PagedCallSettings<ListTargetPoolsHttpRequest, TargetPoolList, ListTargetPoolsPagedResponse>
      listTargetPoolsSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).listTargetPoolsSettings();
  }

  /** Returns the object with the settings used for calls to removeHealthCheckTargetPool. */
  public UnaryCallSettings<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).removeHealthCheckTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to removeInstanceTargetPool. */
  public UnaryCallSettings<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).removeInstanceTargetPoolSettings();
  }

  /** Returns the object with the settings used for calls to setBackupTargetPool. */
  public UnaryCallSettings<SetBackupTargetPoolHttpRequest, Operation>
      setBackupTargetPoolSettings() {
    return ((TargetPoolStubSettings) getStubSettings()).setBackupTargetPoolSettings();
  }

  public static final TargetPoolSettings create(TargetPoolStubSettings stub) throws IOException {
    return new TargetPoolSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetPoolStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetPoolStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetPoolStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetPoolStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetPoolStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetPoolStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetPoolStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetPoolStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetPoolSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetPoolSettings. */
  public static class Builder extends ClientSettings.Builder<TargetPoolSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetPoolStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetPoolStubSettings.newBuilder());
    }

    protected Builder(TargetPoolSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetPoolStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetPoolStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetPoolStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to addHealthCheckTargetPool. */
    public UnaryCallSettings.Builder<AddHealthCheckTargetPoolHttpRequest, Operation>
        addHealthCheckTargetPoolSettings() {
      return getStubSettingsBuilder().addHealthCheckTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to addInstanceTargetPool. */
    public UnaryCallSettings.Builder<AddInstanceTargetPoolHttpRequest, Operation>
        addInstanceTargetPoolSettings() {
      return getStubSettingsBuilder().addInstanceTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedListTargetPools. */
    public PagedCallSettings.Builder<
            AggregatedListTargetPoolsHttpRequest,
            TargetPoolAggregatedList,
            AggregatedListTargetPoolsPagedResponse>
        aggregatedListTargetPoolsSettings() {
      return getStubSettingsBuilder().aggregatedListTargetPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetPool. */
    public UnaryCallSettings.Builder<DeleteTargetPoolHttpRequest, Operation>
        deleteTargetPoolSettings() {
      return getStubSettingsBuilder().deleteTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to getTargetPool. */
    public UnaryCallSettings.Builder<GetTargetPoolHttpRequest, TargetPool> getTargetPoolSettings() {
      return getStubSettingsBuilder().getTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to getHealthTargetPool. */
    public UnaryCallSettings.Builder<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
        getHealthTargetPoolSettings() {
      return getStubSettingsBuilder().getHealthTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetPool. */
    public UnaryCallSettings.Builder<InsertTargetPoolHttpRequest, Operation>
        insertTargetPoolSettings() {
      return getStubSettingsBuilder().insertTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to listTargetPools. */
    public PagedCallSettings.Builder<
            ListTargetPoolsHttpRequest, TargetPoolList, ListTargetPoolsPagedResponse>
        listTargetPoolsSettings() {
      return getStubSettingsBuilder().listTargetPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to removeHealthCheckTargetPool. */
    public UnaryCallSettings.Builder<RemoveHealthCheckTargetPoolHttpRequest, Operation>
        removeHealthCheckTargetPoolSettings() {
      return getStubSettingsBuilder().removeHealthCheckTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstanceTargetPool. */
    public UnaryCallSettings.Builder<RemoveInstanceTargetPoolHttpRequest, Operation>
        removeInstanceTargetPoolSettings() {
      return getStubSettingsBuilder().removeInstanceTargetPoolSettings();
    }

    /** Returns the builder for the settings used for calls to setBackupTargetPool. */
    public UnaryCallSettings.Builder<SetBackupTargetPoolHttpRequest, Operation>
        setBackupTargetPoolSettings() {
      return getStubSettingsBuilder().setBackupTargetPoolSettings();
    }

    @Override
    public TargetPoolSettings build() throws IOException {
      return new TargetPoolSettings(this);
    }
  }
}
