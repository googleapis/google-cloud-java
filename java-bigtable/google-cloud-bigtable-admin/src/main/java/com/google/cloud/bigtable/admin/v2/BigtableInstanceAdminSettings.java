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

import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Settings class to configure an instance of {@link BigtableInstanceAdminClient}.
 *
 * <p>It must be configured with a {@link ProjectName} and can be used to change default RPC
 * settings.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * BigtableInstanceAdminSettings.Builder settingsBuilder = BigtableInstanceAdminSettings.newBuilder()
 *  .setProjectName(ProjectName.of("my-project"));
 *
 * settingsBuilder.stubSettings().createInstanceSettings()
 *   .setRetrySettings(
 *     RetrySettings.newBuilder()
 *       .setTotalTimeout(Duration.ofMinutes(15))
 *       .build());
 *
 * BigtableInstanceAdminSettings settings = settingsBuilder.build();
 * }</pre>
 */
public final class BigtableInstanceAdminSettings {
  private final ProjectName projectName;
  private final BigtableInstanceAdminStubSettings stubSettings;

  private BigtableInstanceAdminSettings(Builder builder) throws IOException {
    Preconditions.checkNotNull(builder.projectName, "ProjectName must be set");
    Verify.verifyNotNull(builder.stubSettings, "stubSettings should never be null");

    this.projectName = builder.projectName;
    this.stubSettings = builder.stubSettings.build();
  }

  /** Gets the anme of the project whose instances the client will manager. */
  @Nonnull
  public ProjectName getProjectName() {
    return projectName;
  }

  /** Gets the underlying RPC settings. */
  @Nonnull
  public BigtableInstanceAdminStubSettings getStubSettings() {
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

  /** Builder for BigtableInstanceAdminSettings. */
  public static final class Builder {
    @Nullable private ProjectName projectName;
    private final BigtableInstanceAdminStubSettings.Builder stubSettings;

    private Builder() {
      stubSettings = BigtableInstanceAdminStubSettings.newBuilder();
    }

    private Builder(BigtableInstanceAdminSettings settings) {
      this.projectName = settings.projectName;
      this.stubSettings = settings.stubSettings.toBuilder();
    }

    /** Sets the name of instance whose tables the client will manage. */
    public Builder setProjectName(@Nonnull ProjectName projectName) {
      Preconditions.checkNotNull(projectName);
      this.projectName = projectName;
      return this;
    }

    /** Gets the name of the project whose instances the client will manage. */
    @Nullable
    public ProjectName getProjectName() {
      return projectName;
    }

    /**
     * Returns the builder for the settings used for all RPCs.
     *
     * <p>This is meant for advanced usage. The default RPC settings are set to their recommended
     * values.
     */
    public BigtableInstanceAdminStubSettings.Builder stubSettings() {
      return stubSettings;
    }

    /** Builds an instance of the settings. */
    public BigtableInstanceAdminSettings build() throws IOException {
      return new BigtableInstanceAdminSettings(this);
    }
  }
}
