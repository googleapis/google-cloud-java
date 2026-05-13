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

package com.google.cloud.grpc;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.grpc.proto.ApiConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class GcpManagedChannelBuilder extends ForwardingChannelBuilder<GcpManagedChannelBuilder> {

  private static final Logger logger = Logger.getLogger(GcpManagedChannelBuilder.class.getName());

  private final ManagedChannelBuilder<?> delegate;
  private int poolSize = 0;
  private GcpManagedChannelOptions options;

  @VisibleForTesting ApiConfig apiConfig;

  private GcpManagedChannelBuilder(ManagedChannelBuilder<?> delegate) {
    this.delegate = delegate;
    this.options = new GcpManagedChannelOptions();
  }

  private ApiConfig parseConfigFromJsonFile(File file) {
    JsonFormat.Parser parser = JsonFormat.parser();
    ApiConfig.Builder apiConfig = ApiConfig.newBuilder();
    try {
      Reader reader = Files.newBufferedReader(file.toPath(), UTF_8);
      parser.merge(reader, apiConfig);
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return null;
    }
    return apiConfig.build();
  }

  public static GcpManagedChannelBuilder forDelegateBuilder(ManagedChannelBuilder<?> delegate) {
    return new GcpManagedChannelBuilder(delegate);
  }

  /**
   * Sets the maximum channel pool size. This will override the pool size configuration in
   * ApiConfig. Deprecated. Use maxSize in GcpManagedChannelOptions.GcpChannelPoolOptions.
   */
  @Deprecated
  public GcpManagedChannelBuilder setPoolSize(int poolSize) {
    this.poolSize = poolSize;
    return this;
  }

  public GcpManagedChannelBuilder withApiConfig(ApiConfig apiConfig) {
    this.apiConfig = apiConfig;
    return this;
  }

  public GcpManagedChannelBuilder withApiConfigJsonFile(File file) {
    this.apiConfig = parseConfigFromJsonFile(file);
    return this;
  }

  public GcpManagedChannelBuilder withApiConfigJsonString(String jsonString) {
    JsonFormat.Parser parser = JsonFormat.parser();
    ApiConfig.Builder apiConfig = ApiConfig.newBuilder();
    try {
      parser.merge(jsonString, apiConfig);
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return null;
    }
    this.apiConfig = apiConfig.build();
    return this;
  }

  public GcpManagedChannelBuilder withOptions(@Nullable GcpManagedChannelOptions options) {
    if (options != null) {
      this.options = options;
    }
    return this;
  }

  /** Returns the delegated {@code ManagedChannelBuilder}. */
  @Override
  protected ManagedChannelBuilder<?> delegate() {
    return delegate;
  }

  /**
   * Returns the {@link ManagedChannel} built by the delegate by default. Overriding method can
   * return different value.
   */
  @Override
  public ManagedChannel build() {
    return new GcpManagedChannel(delegate, apiConfig, poolSize, options);
  }
}
