/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.PacketMirroringClient.AggregatedListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.PacketMirroringClient.ListPacketMirroringsPagedResponse;

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
import com.google.cloud.compute.v1.stub.PacketMirroringStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link PacketMirroringClient}.
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
 * <p>For example, to set the total timeout of deletePacketMirroring to 30 seconds:
 *
 * <pre>
 * <code>
 * PacketMirroringSettings.Builder packetMirroringSettingsBuilder =
 *     PacketMirroringSettings.newBuilder();
 * packetMirroringSettingsBuilder.deletePacketMirroringSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * PacketMirroringSettings packetMirroringSettings = packetMirroringSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PacketMirroringSettings extends ClientSettings<PacketMirroringSettings> {
  /** Returns the object with the settings used for calls to aggregatedListPacketMirrorings. */
  public PagedCallSettings<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsSettings() {
    return ((PacketMirroringStubSettings) getStubSettings())
        .aggregatedListPacketMirroringsSettings();
  }

  /** Returns the object with the settings used for calls to deletePacketMirroring. */
  public UnaryCallSettings<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringSettings() {
    return ((PacketMirroringStubSettings) getStubSettings()).deletePacketMirroringSettings();
  }

  /** Returns the object with the settings used for calls to getPacketMirroring. */
  public UnaryCallSettings<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringSettings() {
    return ((PacketMirroringStubSettings) getStubSettings()).getPacketMirroringSettings();
  }

  /** Returns the object with the settings used for calls to insertPacketMirroring. */
  public UnaryCallSettings<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringSettings() {
    return ((PacketMirroringStubSettings) getStubSettings()).insertPacketMirroringSettings();
  }

  /** Returns the object with the settings used for calls to listPacketMirrorings. */
  public PagedCallSettings<
          ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
      listPacketMirroringsSettings() {
    return ((PacketMirroringStubSettings) getStubSettings()).listPacketMirroringsSettings();
  }

  /** Returns the object with the settings used for calls to patchPacketMirroring. */
  public UnaryCallSettings<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringSettings() {
    return ((PacketMirroringStubSettings) getStubSettings()).patchPacketMirroringSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsPacketMirroring. */
  public UnaryCallSettings<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringSettings() {
    return ((PacketMirroringStubSettings) getStubSettings())
        .testIamPermissionsPacketMirroringSettings();
  }

  public static final PacketMirroringSettings create(PacketMirroringStubSettings stub)
      throws IOException {
    return new PacketMirroringSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PacketMirroringStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PacketMirroringStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return PacketMirroringStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PacketMirroringStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PacketMirroringStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PacketMirroringStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PacketMirroringStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PacketMirroringStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PacketMirroringSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PacketMirroringSettings. */
  public static class Builder extends ClientSettings.Builder<PacketMirroringSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(PacketMirroringStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(PacketMirroringStubSettings.newBuilder());
    }

    protected Builder(PacketMirroringSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PacketMirroringStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public PacketMirroringStubSettings.Builder getStubSettingsBuilder() {
      return ((PacketMirroringStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListPacketMirrorings. */
    public PagedCallSettings.Builder<
            AggregatedListPacketMirroringsHttpRequest,
            PacketMirroringAggregatedList,
            AggregatedListPacketMirroringsPagedResponse>
        aggregatedListPacketMirroringsSettings() {
      return getStubSettingsBuilder().aggregatedListPacketMirroringsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePacketMirroring. */
    public UnaryCallSettings.Builder<DeletePacketMirroringHttpRequest, Operation>
        deletePacketMirroringSettings() {
      return getStubSettingsBuilder().deletePacketMirroringSettings();
    }

    /** Returns the builder for the settings used for calls to getPacketMirroring. */
    public UnaryCallSettings.Builder<GetPacketMirroringHttpRequest, PacketMirroring>
        getPacketMirroringSettings() {
      return getStubSettingsBuilder().getPacketMirroringSettings();
    }

    /** Returns the builder for the settings used for calls to insertPacketMirroring. */
    public UnaryCallSettings.Builder<InsertPacketMirroringHttpRequest, Operation>
        insertPacketMirroringSettings() {
      return getStubSettingsBuilder().insertPacketMirroringSettings();
    }

    /** Returns the builder for the settings used for calls to listPacketMirrorings. */
    public PagedCallSettings.Builder<
            ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
        listPacketMirroringsSettings() {
      return getStubSettingsBuilder().listPacketMirroringsSettings();
    }

    /** Returns the builder for the settings used for calls to patchPacketMirroring. */
    public UnaryCallSettings.Builder<PatchPacketMirroringHttpRequest, Operation>
        patchPacketMirroringSettings() {
      return getStubSettingsBuilder().patchPacketMirroringSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsPacketMirroring. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
        testIamPermissionsPacketMirroringSettings() {
      return getStubSettingsBuilder().testIamPermissionsPacketMirroringSettings();
    }

    @Override
    public PacketMirroringSettings build() throws IOException {
      return new PacketMirroringSettings(this);
    }
  }
}
