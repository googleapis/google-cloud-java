/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.logging;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.cloud.logging.spi.v2.GrpcLoggingRpc;
import com.google.cloud.logging.spi.v2.LoggingRpc;
import com.google.cloud.logging.v2.LoggingSettings;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Set;

public class LoggingOptions extends ServiceOptions<Logging, LoggingOptions> {

  private static final String API_SHORT_NAME = "Logging";
  private static final String LOGGING_SCOPE = "https://www.googleapis.com/auth/logging.admin";
  private static final ImmutableSet<String> SCOPES = ImmutableSet.of(LOGGING_SCOPE);
  private static final String DEFAULT_HOST = LoggingSettings.getDefaultEndpoint();
  private static final long serialVersionUID = 5753499510627426717L;

  private Boolean autoPopulateMetadataOnWrite = null;
  private BatchingSettings batchingSettings = null;

  public static class DefaultLoggingFactory implements LoggingFactory {
    private static final LoggingFactory INSTANCE = new DefaultLoggingFactory();

    @Override
    public Logging create(LoggingOptions options) {
      return new LoggingImpl(options);
    }
  }

  /** Returns a default {@code LoggingOptions} instance. */
  public static LoggingOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static class DefaultLoggingRpcFactory implements LoggingRpcFactory {
    private static final LoggingRpcFactory INSTANCE = new DefaultLoggingRpcFactory();

    @Override
    public ServiceRpc create(LoggingOptions options) {
      try {
        return new GrpcLoggingRpc(options);
      } catch (IOException e) {
        throw new LoggingException(e, true);
      }
    }
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  public static class Builder extends ServiceOptions.Builder<Logging, LoggingOptions, Builder> {

    private Boolean autoPopulateMetadataOnWrite = true;
    private BatchingSettings batchingSettings = null;

    private Builder() {}

    private Builder(LoggingOptions options) {
      super(options);
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof GrpcTransportOptions)) {
        throw new IllegalArgumentException(
            "Only grpc transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @CanIgnoreReturnValue
    public Builder setAutoPopulateMetadata(boolean autoPopulateMetadataOnWrite) {
      this.autoPopulateMetadataOnWrite = autoPopulateMetadataOnWrite;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setBatchingSettings(BatchingSettings batchingSettings) {
      this.batchingSettings = batchingSettings;
      return this;
    }

    @Override
    public LoggingOptions build() {
      return new LoggingOptions(this);
    }
  }

  @InternalApi("This class should only be extended within google-cloud-java")
  protected LoggingOptions(Builder builder) {
    super(LoggingFactory.class, LoggingRpcFactory.class, builder, new LoggingDefaults());
    this.autoPopulateMetadataOnWrite = builder.autoPopulateMetadataOnWrite;
    this.batchingSettings =
        builder.batchingSettings == null ? null : builder.batchingSettings.toBuilder().build();
  }

  @SuppressWarnings("serial")
  private static class LoggingDefaults implements ServiceDefaults<Logging, LoggingOptions> {

    @Override
    public LoggingFactory getDefaultServiceFactory() {
      return DefaultLoggingFactory.INSTANCE;
    }

    @Override
    public LoggingRpcFactory getDefaultRpcFactory() {
      return DefaultLoggingRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultGrpcTransportOptions();
    }
  }

  public static GrpcTransportOptions getDefaultGrpcTransportOptions() {
    return GrpcTransportOptions.newBuilder().build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected LoggingRpc getLoggingRpcV2() {
    return (LoggingRpc) getRpc();
  }

  public Boolean getAutoPopulateMetadata() {
    return this.autoPopulateMetadataOnWrite;
  }

  public BatchingSettings getBatchingSettings() {
    return this.batchingSettings;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoggingOptions && baseEquals((LoggingOptions) obj);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
