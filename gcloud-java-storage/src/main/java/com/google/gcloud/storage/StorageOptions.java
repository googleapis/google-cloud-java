/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.DefaultStorageRpc;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpcFactory;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class StorageOptions extends ServiceOptions<StorageRpc, StorageOptions> {

  private static final long serialVersionUID = -7804860602287801084L;
  private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
  private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
  private static final String DEFAULT_PATH_DELIMITER = "/";

  private final String pathDelimiter;
  private final TimeSource timeSource;
  private transient StorageRpc storageRpc;

  /**
   * A class providing access to the current time in milliseconds.
   *
   * Implementations should implement {@code Serializable} wherever possible and must document
   * whether or not they do support serialization.
   */
  public static abstract class TimeSource {

    private static TimeSource DEFAULT_TIME_SOURCE = new DefaultTimeSource();

    /**
     * Returns current time in milliseconds according to this time source.
     */
    public abstract long millis();

    /**
     * Returns the default time source.
     */
    public static TimeSource defaultTimeSource() {
      return DEFAULT_TIME_SOURCE;
    }

    private static class DefaultTimeSource extends TimeSource implements Serializable {

      private static final long serialVersionUID = -5077300394286703864L;

      @Override
      public long millis() {
        return System.currentTimeMillis();
      }
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<StorageRpc, StorageOptions, Builder> {

    private String pathDelimiter;
    private TimeSource timeSource;

    private Builder() {}

    private Builder(StorageOptions options) {
      super(options);
    }

    /**
     * Sets the path delimiter for the storage service.
     * @param pathDelimiter the path delimiter to set
     * @return the builder.
     */
    public Builder pathDelimiter(String pathDelimiter) {
      this.pathDelimiter = pathDelimiter;
      return this;
    }

    /**
     * Sets the time source for the storage service. The time source is used by `signUrl` to compute
     * URL's expiry time. If no time source is set by default `System.getTimeMillis()` is used.
     * @param source the time source to set
     * @return the builder.
     */
    public Builder timeSource(TimeSource source) {
      this.timeSource = source;
      return this;
    }

    @Override
    public StorageOptions build() {
      return new StorageOptions(this);
    }
  }

  private StorageOptions(Builder builder) {
    super(builder);
    pathDelimiter = MoreObjects.firstNonNull(builder.pathDelimiter, DEFAULT_PATH_DELIMITER);
    timeSource = MoreObjects.firstNonNull(builder.timeSource, TimeSource.defaultTimeSource());
    // todo: consider providing read-timeout
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  StorageRpc storageRpc() {
    if (storageRpc != null) {
      return storageRpc;
    }
    if (serviceRpcFactory() != null) {
      storageRpc = serviceRpcFactory().create(this);
    } else {
      storageRpc = createRpc(this, StorageRpcFactory.class);
      if (storageRpc == null) {
        storageRpc = new DefaultStorageRpc(this);
      }
    }
    return storageRpc;
  }

  /**
   * Returns the storage service's path delimiter.
   */
  public String pathDelimiter() {
    return pathDelimiter;
  }

  /**
   * Returns the storage service's time source. Default time source uses `System.getTimeMillis()` to
   * get current time. 
   */
  public TimeSource timeSource() {
    return timeSource;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return baseHashCode() ^ Objects.hash(pathDelimiter);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof StorageOptions)) {
      return false;
    }
    StorageOptions other = (StorageOptions) obj;
    return baseEquals(other) && Objects.equals(pathDelimiter, other.pathDelimiter);
  }

  public static StorageOptions defaultInstance() {
    return builder().build();
  }

  public static Builder builder() {
    return new Builder();
  }
}
