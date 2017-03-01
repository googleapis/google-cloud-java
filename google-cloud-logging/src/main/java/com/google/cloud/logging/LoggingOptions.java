/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.cloud.GrpcServiceOptions;
import com.google.cloud.logging.spi.DefaultLoggingRpc;
import com.google.cloud.logging.spi.LoggingRpc;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.cloud.logging.spi.v2.LoggingServiceV2Settings;
import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class LoggingOptions extends GrpcServiceOptions<Logging, LoggingRpc, LoggingOptions> {

  private static final long serialVersionUID = -5117984564582881668L;
  private static final String LOGGING_SCOPE = "https://www.googleapis.com/auth/logging.admin";
  private static final Set<String> SCOPES = ImmutableSet.of(LOGGING_SCOPE);
  private static final String DEFAULT_HOST = LoggingServiceV2Settings.getDefaultServiceAddress()
      + ':' + LoggingServiceV2Settings.getDefaultServicePort();

  public static class DefaultLoggingFactory implements LoggingFactory {
    private static final LoggingFactory INSTANCE = new DefaultLoggingFactory();

    @Override
    public Logging create(LoggingOptions options) {
      return new LoggingImpl(options);
    }
  }

  /**
   * Returns a default {@code LoggingOptions} instance.
   */
  @Deprecated
  public static LoggingOptions defaultInstance() {
    return getDefaultInstance();
  }

  /**
   * Returns a default {@code LoggingOptions} instance.
   */
  public static LoggingOptions getDefaultInstance() {
    return newBuilder().build();
  }

  public static class DefaultLoggingRpcFactory implements LoggingRpcFactory {
    private static final LoggingRpcFactory INSTANCE = new DefaultLoggingRpcFactory();

    @Override
    public LoggingRpc create(LoggingOptions options) {
      try {
        return new DefaultLoggingRpc(options);
      } catch (IOException e) {
        throw new LoggingException(e, true);
      }
    }
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  public static class Builder extends
      GrpcServiceOptions.Builder<Logging, LoggingRpc, LoggingOptions, Builder> {

    private Builder() {}

    private Builder(LoggingOptions options) {
      super(options);
    }

    @Override
    public LoggingOptions build() {
      return new LoggingOptions(this);
    }
  }

  protected LoggingOptions(Builder builder) {
    super(LoggingFactory.class, LoggingRpcFactory.class, builder);
  }

  @Override
  protected ExecutorFactory<ScheduledExecutorService> getExecutorFactory() {
    return super.getExecutorFactory();
  }

  @Override
  protected LoggingFactory getDefaultServiceFactory() {
    return DefaultLoggingFactory.INSTANCE;
  }

  @Override
  protected LoggingRpcFactory getDefaultRpcFactory() {
    return DefaultLoggingRpcFactory.INSTANCE;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
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

  @Deprecated
  public static Builder builder() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
