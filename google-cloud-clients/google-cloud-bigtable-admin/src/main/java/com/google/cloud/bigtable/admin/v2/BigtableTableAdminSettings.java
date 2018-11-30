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
package com.google.cloud.bigtable.admin.v2;

import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Settings class to configure an instance of {@link BigtableTableAdminClient}.
 *
 * <p>It must be configured with an {@link InstanceName} and can be used to change default RPC
 * settings.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * BigtableTableAdminSettings.Builder tableAdminSettingsBuilder = BigtableTableAdminSettings.newBuilder()
 *   .setInstanceName(InstanceName.of("my-project", "my-instance");
 *
 * tableAdminSettingsBuilder.stubSettings().createTableSettings()
 *   .setRetrySettings(
 *     RetrySettings.newBuilder()
 *       .setTotalTimeout(Duration.ofMinutes(15))
 *       .build());
 *
 * BigtableTableAdminSettings tableAdminSettings = tableAdminSettingsBuilder.build();
 * }</pre>
 */
public final class BigtableTableAdminSettings {
  private final InstanceName instanceName;
  private final BigtableTableAdminStubSettings stubSettings;

  private BigtableTableAdminSettings(Builder builder) throws IOException {
    this.instanceName =
        Preconditions.checkNotNull(builder.instanceName, "InstanceName must be set");
    this.stubSettings =
        Verify.verifyNotNull(builder.stubSettings, "stubSettings should never be null").build();
  }

  /** Gets the name of instance whose tables the client will manage. */
  @Nonnull
  public InstanceName getInstanceName() {
    return instanceName;
  }

  /** Gets the underlying RPC settings. */
  public BigtableTableAdminStubSettings getStubSettings() {
    return stubSettings;
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for BigtableTableAdminSettings. */
  public static final class Builder {
    @Nullable private InstanceName instanceName;
    private final BigtableTableAdminStubSettings.Builder stubSettings;

    private Builder() {
      stubSettings = BigtableTableAdminStubSettings.newBuilder();
    }

    private Builder(BigtableTableAdminSettings settings) {
      this.instanceName = settings.instanceName;
      this.stubSettings = settings.stubSettings.toBuilder();
    }

    /** Sets the name of instance whose tables the client will manage. */
    public Builder setInstanceName(@Nonnull InstanceName instanceName) {
      Preconditions.checkNotNull(instanceName);
      this.instanceName = instanceName;
      return this;
    }

    /** Gets the name of instance whose tables the client will manage. */
    @Nullable
    public InstanceName getInstanceName() {
      return instanceName;
    }

    /**
     * Returns the builder for the settings used for all RPCs.
     *
     * <p>This is meant for advanced usage. The default RPC settings are set to their recommended
     * values.
     */
    public BigtableTableAdminStubSettings.Builder stubSettings() {
      return stubSettings;
    }

    /** Builds an instance of the settings. */
    public BigtableTableAdminSettings build() throws IOException {
      return new BigtableTableAdminSettings(this);
    }
  }
}
