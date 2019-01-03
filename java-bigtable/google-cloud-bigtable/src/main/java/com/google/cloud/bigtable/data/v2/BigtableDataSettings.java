/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2;

import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Settings class to configure an instance of {@link BigtableDataClient}.
 *
 * <p>Sane defaults are provided for most settings:
 *
 * <ul>
 *   <li>The default service address (bigtable.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The only required setting is the instance name.
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <pre>{@code
 * BigtableDataSettings.Builder settingsBuilder = BigtableDataSettings.newBuilder()
 *   .setProjectId("my-project")
 *   .setInstanceId("my-instance-id")
 *   .setAppProfileId("default");
 *
 * settingsBuilder.readRowsSettings().setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE);
 *
 * BigtableDataSettings settings = builder.build();
 * }</pre>
 */
public class BigtableDataSettings extends ClientSettings<BigtableDataSettings> {
  private BigtableDataSettings(Builder builder) throws IOException {
    super(builder);
  }

  /** Create a new builder. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns the target instance.
   *
   * @deprecated Please use {@link #getProjectId()} and {@link #getInstanceId()}.
   */
  @Deprecated()
  public com.google.cloud.bigtable.data.v2.models.InstanceName getInstanceName() {
    return getTypedStubSettings().getInstanceName();
  }

  /** Returns the target project id. */
  public String getProjectId() {
    return getTypedStubSettings().getProjectId();
  }

  /** Returns the target instance id. */
  public String getInstanceId() {
    return getTypedStubSettings().getInstanceId();
  }

  /** Returns the configured AppProfile id to use. */
  public String getAppProfileId() {
    return getTypedStubSettings().getAppProfileId();
  }

  /** Returns the object with the settings used for calls to ReadRows. */
  public ServerStreamingCallSettings<Query, Row> readRowsSettings() {
    return getTypedStubSettings().readRowsSettings();
  }

  /** Returns the object with the settings used for calls to sampleRowKeys. */
  public UnaryCallSettings<String, List<KeyOffset>> sampleRowKeysSettings() {
    return getTypedStubSettings().sampleRowKeysSettings();
  }

  /** Returns the object with the settings used for calls to MutateRow. */
  public UnaryCallSettings<RowMutation, Void> mutateRowSettings() {
    return getTypedStubSettings().mutateRowSettings();
  }

  /** Returns the object with the settings used for BulkMutations. */
  public BatchingCallSettings<RowMutation, Void> bulkMutationsSettings() {
    // NOTE: the user facing BigtableDataClient only exposes this api as newBulkMutationBatcher,
    // so the outer name should match that, while the stub should stick to rpc names.
    return getTypedStubSettings().bulkMutateRowsSettings();
  }

  /** Returns the object with the settings used for calls to checkAndMutateRow. */
  public UnaryCallSettings<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
    return getTypedStubSettings().checkAndMutateRowSettings();
  }

  /** Returns the object with the settings used for calls to ReadModifyWriteRow. */
  public UnaryCallSettings<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
    return getTypedStubSettings().readModifyWriteRowSettings();
  }

  @SuppressWarnings("unchecked")
  EnhancedBigtableStubSettings getTypedStubSettings() {
    return (EnhancedBigtableStubSettings) getStubSettings();
  }

  /** Returns a builder containing all the values of this settings class. */
  @SuppressWarnings("unchecked")
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Builder for BigtableDataSettings. */
  public static class Builder extends ClientSettings.Builder<BigtableDataSettings, Builder> {
    /**
     * Initializes a new Builder with sane defaults for all settings.
     *
     * <p>Most defaults are extracted from BaseBigtableDataSettings, however some of the more
     * complex defaults are configured explicitly here. Once the overlayed defaults are configured,
     * the base settings are augmented to work with overlayed functionality (like disabling retries
     * in the underlying GAPIC client for batching).
     */
    private Builder() {
      super(EnhancedBigtableStubSettings.newBuilder());
    }

    private Builder(BigtableDataSettings settings) {
      super(settings);
    }

    // <editor-fold desc="Public API">
    /**
     * Sets the target instance. This setting is required. All RPCs will be made in the context of
     * this setting.
     *
     * @deprecated Please use {@link #setProjectId(String)} and {@link #setInstanceId(String)}.
     */
    @Deprecated
    public Builder setInstanceName(
        @Nonnull com.google.cloud.bigtable.data.v2.models.InstanceName instanceName) {
      getTypedStubSettings().setInstanceName(instanceName);
      return this;
    }

    /**
     * Gets the {@link com.google.cloud.bigtable.data.v2.models.InstanceName} that was previously
     * set on this Builder.
     *
     * @deprecated Please use {@link #getProjectId()} and {@link #getInstanceId()}.
     */
    @Deprecated
    public com.google.cloud.bigtable.data.v2.models.InstanceName getInstanceName() {
      return getTypedStubSettings().getInstanceName();
    }

    /**
     * Sets the target project. This setting is required. All RPCs will be made in the context of
     * this setting.
     */
    public Builder setProjectId(@Nonnull String projectId) {
      getTypedStubSettings().setProjectId(projectId);
      return this;
    }

    /** Gets the project id that was previously set on this Builder. */
    public String getProjectId() {
      return getTypedStubSettings().getProjectId();
    }

    /**
     * Sets the target instance. This setting is required. All RPCs will be made in the context of
     * this setting.
     */
    public Builder setInstanceId(@Nonnull String instanceId) {
      getTypedStubSettings().setInstanceId(instanceId);
      return this;
    }

    /** Gets the instance id that was previously set on this Builder. */
    public String getInstanceId() {
      return getTypedStubSettings().getInstanceId();
    }

    /**
     * Sets the AppProfile to use. An application profile (sometimes also shortened to "app
     * profile") is a group of configuration parameters for an individual use case. A client will
     * identify itself with an application profile ID at connection time, and the requests will be
     * handled according to that application profile.
     */
    public Builder setAppProfileId(@Nonnull String appProfileId) {
      getTypedStubSettings().setAppProfileId(appProfileId);
      return this;
    }

    /** Gets the app profile id that was previously set on this Builder. */
    public String getAppProfileId() {
      return getTypedStubSettings().getAppProfileId();
    }

    /** Returns the builder for the settings used for calls to readRows. */
    public ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings() {
      return getTypedStubSettings().readRowsSettings();
    }

    /** Returns the builder for the settings used for calls to SampleRowKeysSettings. */
    public UnaryCallSettings.Builder<String, List<KeyOffset>> sampleRowKeysSettings() {
      return getTypedStubSettings().sampleRowKeysSettings();
    }

    /** Returns the builder for the settings used for calls to MutateRow. */
    public UnaryCallSettings.Builder<RowMutation, Void> mutateRowSettings() {
      return getTypedStubSettings().mutateRowSettings();
    }

    /** Returns the builder for the settings used for BulkMutations. */
    public BatchingCallSettings.Builder<RowMutation, Void> bulkMutationsSettings() {
      // NOTE: the user facing BigtableDataClient only exposes this api as newBulkMutationBatcher,
      // so the outer name should match that, while the stub should stick to rpc names.
      return getTypedStubSettings().bulkMutateRowsSettings();
    }

    /** Returns the object with the settings used for calls to checkAndMutateRow. */
    public UnaryCallSettings.Builder<ConditionalRowMutation, Boolean> checkAndMutateRowSettings() {
      return getTypedStubSettings().checkAndMutateRowSettings();
    }

    /** Returns the builder with the settings used for calls to ReadModifyWriteRow. */
    public UnaryCallSettings.Builder<ReadModifyWriteRow, Row> readModifyWriteRowSettings() {
      return getTypedStubSettings().readModifyWriteRowSettings();
    }

    @SuppressWarnings("unchecked")
    private EnhancedBigtableStubSettings.Builder getTypedStubSettings() {
      return (EnhancedBigtableStubSettings.Builder) getStubSettings();
    }

    public BigtableDataSettings build() throws IOException {
      return new BigtableDataSettings(this);
    }
    // </editor-fold>
  }
}
