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

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Settings class to configure an instance of {@link BigtableInstanceAdminClient}.
 *
 * <p>It must be configured with a project ID and can be used to change default RPC settings.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * BigtableInstanceAdminSettings.Builder settingsBuilder = BigtableInstanceAdminSettings.newBuilder()
 *  .setProjectId("my-project");
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
  private final String projectId;
  private final BigtableInstanceAdminStubSettings stubSettings;

  private BigtableInstanceAdminSettings(Builder builder) throws IOException {
    Preconditions.checkNotNull(builder.projectId, "Project ID must be set");
    Verify.verifyNotNull(builder.stubSettings, "stubSettings should never be null");

    this.projectId = builder.projectId;
    this.stubSettings = builder.stubSettings.build();
  }

  /** Gets the ID of the project whose instances the client will manage. */
  @Nonnull
  public String getProjectId() {
    return projectId;
  }

  /** Gets the credentials provider to use for getting the credentials to make calls with. */
  public CredentialsProvider getCredentialsProvider() {
    return stubSettings.getCredentialsProvider();
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
    @Nullable private String projectId;
    private final BigtableInstanceAdminStubSettings.Builder stubSettings;

    private Builder() {
      stubSettings = BigtableInstanceAdminStubSettings.newBuilder();
    }

    private Builder(BigtableInstanceAdminSettings settings) {
      this.projectId = settings.projectId;
      this.stubSettings = settings.stubSettings.toBuilder();
    }

    /** Sets the ID of the project whose instances the client will manage. */
    public Builder setProjectId(@Nonnull String projectId) {
      Preconditions.checkNotNull(projectId);
      this.projectId = projectId;
      return this;
    }

    /** Gets the ID of the project whose instances the client will manage. */
    @Nullable
    public String getProjectId() {
      return projectId;
    }

    /** Sets the CredentialsProvider to use for getting the credentials to make calls with. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      stubSettings.setCredentialsProvider(credentialsProvider);

      return this;
    }

    /** Gets the CredentialsProvider to use for getting the credentials to make calls with. */
    public CredentialsProvider getCredentialsProvider() {
      return stubSettings.getCredentialsProvider();
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
