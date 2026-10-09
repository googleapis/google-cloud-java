/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.testing;

import com.google.api.core.InternalApi;
import com.google.cloud.TransportOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.List;
import javax.annotation.Nullable;
import org.jspecify.annotations.NullMarked;

/** Options for configuring a {@link RemoteDatastoreHelper}. */
@InternalApi
@NullMarked
public class RemoteDatastoreOptions {

  private final String databaseId;
  private final TransportOptions transportOptions;
  private final @Nullable OpenTelemetrySdk openTelemetrySdk;
  private final @Nullable List<String> instanceTags;

  private RemoteDatastoreOptions(Builder builder) {
    this.databaseId = builder.databaseId;
    this.transportOptions = builder.transportOptions;
    this.openTelemetrySdk = builder.openTelemetrySdk;
    this.instanceTags =
        builder.instanceTags != null ? ImmutableList.copyOf(builder.instanceTags) : null;
  }

  public String getDatabaseId() {
    return databaseId;
  }

  public TransportOptions getTransportOptions() {
    return transportOptions;
  }

  public @Nullable OpenTelemetrySdk getOpenTelemetrySdk() {
    return openTelemetrySdk;
  }

  public @Nullable List<String> getInstanceTags() {
    return instanceTags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RemoteDatastoreOptions)) return false;
    RemoteDatastoreOptions that = (RemoteDatastoreOptions) o;
    return Objects.equal(databaseId, that.databaseId)
        && Objects.equal(transportOptions, that.transportOptions)
        && Objects.equal(openTelemetrySdk, that.openTelemetrySdk)
        && Objects.equal(instanceTags, that.instanceTags);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(databaseId, transportOptions, openTelemetrySdk, instanceTags);
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static RemoteDatastoreOptions getDefaultInstance() {
    return newBuilder().build();
  }

  /** Builder for {@link RemoteDatastoreOptions}. */
  public static class Builder {
    private String databaseId = "";
    private TransportOptions transportOptions = DatastoreOptions.getDefaultHttpTransportOptions();
    private @Nullable OpenTelemetrySdk openTelemetrySdk;
    private @Nullable List<String> instanceTags;

    private Builder() {}

    private Builder(RemoteDatastoreOptions options) {
      this.databaseId = options.databaseId;
      this.transportOptions = options.transportOptions;
      this.openTelemetrySdk = options.openTelemetrySdk;
      this.instanceTags = options.instanceTags;
    }

    public Builder setDatabaseId(String databaseId) {
      Preconditions.checkNotNull(databaseId, "databaseId cannot be null");
      this.databaseId = databaseId;
      return this;
    }

    public Builder setTransportOptions(TransportOptions transportOptions) {
      Preconditions.checkNotNull(transportOptions, "transportOptions cannot be null");
      this.transportOptions = transportOptions;
      return this;
    }

    public Builder setOpenTelemetrySdk(@Nullable OpenTelemetrySdk openTelemetrySdk) {
      this.openTelemetrySdk = openTelemetrySdk;
      return this;
    }

    public Builder setInstanceTags(@Nullable List<String> instanceTags) {
      this.instanceTags = instanceTags;
      return this;
    }

    public RemoteDatastoreOptions build() {
      return new RemoteDatastoreOptions(this);
    }
  }
}
